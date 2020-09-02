package com.javakc.cms.dao;

import com.javakc.cms.entity.Book;
import com.javakc.commonutils.jpa.base.dao.BaseDao;
import lombok.Data;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author leesiyu
 * @version 1.0
 * @Copyright © 北京汇才同飞教育科技公司
 */
public interface BookDao extends BaseDao<Book, String> {



}
