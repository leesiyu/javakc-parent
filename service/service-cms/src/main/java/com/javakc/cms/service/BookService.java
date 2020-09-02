package com.javakc.cms.service;

import com.javakc.cms.dao.BookDao;
import com.javakc.cms.entity.Book;
import com.javakc.cms.vo.BookQuery;
import com.javakc.commonutils.jpa.base.service.BaseService;
import com.javakc.commonutils.jpa.dynamic.SimpleSpecification;
import com.javakc.commonutils.jpa.dynamic.SimpleSpecificationBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * @author leesiyu
 * @version 1.0
 * @Copyright © 北京汇才同飞教育科技公司
 */
@Service
public class BookService extends BaseService<BookDao, Book> {


    public List<Book> findAll() {
        return dao.findAll();
    }

    /**
     * 带条件的分页查询 - 书籍管理
     * @param bookQuery 封装的查询条件
     * @param pageNo 当前页
     * @param pageSize 最大页
     * @return 查询到的数据
     */
    public Page<Book> findPageBook(BookQuery bookQuery, int pageNo, int pageSize) {
        // ## 设置查询条件
        SimpleSpecificationBuilder simpleSpecificationBuilder = new SimpleSpecificationBuilder<>();
        if (null != bookQuery) {
            if (!StringUtils.isEmpty(bookQuery.getTitle())) {
                // ## : like
                simpleSpecificationBuilder.and("title", ":", bookQuery.getTitle());
            }
        }
        Specification<Book> specification = simpleSpecificationBuilder.getSpecification();

        // ## 查询
        Page<Book> page = dao.findAll(specification, PageRequest.of(pageNo - 1, pageSize));
        return page;
    }

}
