package com.javakc.cms.controller;


import com.javakc.cms.entity.Book;
import com.javakc.cms.service.BookService;
import com.javakc.cms.vo.BookQuery;
import com.javakc.commonutils.api.APICODE;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author leesiyu
 * @version 1.0
 * @Copyright © 北京汇才同飞教育科技公司
 */
@Api(tags = "书籍管理")
@RestController
@RequestMapping("/cms/book")
public class BookController {


    @Autowired
    private BookService bookService;

    /**
     * 查询所有数据
     * @return
     */
    @GetMapping
    @ApiOperation(value = "查询所有内容")
    public APICODE findAll() {
        // ## 查询
        List<Book> list = bookService.findAll();
        return APICODE.OK().data("items", list);
    }


    @PostMapping("{pageNo}/{pageSize}")
    @ApiOperation(value = "根据条件进程分页查询")
    public APICODE findPageBook(@RequestBody(required = false) BookQuery bookQuery,
                                @PathVariable(name = "pageNo") int pageNo, @PathVariable(name = "pageSize") int pageSize) {
        // ## 调用service的方法,进行带条件的分页查询
        Page<Book> page = bookService.findPageBook(bookQuery, pageNo, pageSize);
        // ## 获取总数 count()
        long totalElements = page.getTotalElements();
        // ## 当前页查询的集合数据
        List<Book> list = page.getContent();
        return APICODE.OK().data("total", totalElements).data("items", list);
    }

    @PostMapping("saveBook")
    @ApiOperation(value = "添加书籍")
    public APICODE saveBook(@RequestBody Book book) {
        // ## 保存
        Book book1 = bookService.saveOrUpdate(book);
        System.out.println(book1.getId());
        return APICODE.OK();
    }


    @GetMapping("{bookId}")
    @ApiOperation(value = "根据ID进行书籍数据获取")
    public APICODE getByBookId(@PathVariable(name = "bookId") String bookId) {
        Book book = bookService.getById(bookId);
        return APICODE.OK().data("book", book);
    }

    @PutMapping("updateBook")
    @ApiOperation(value = "根据ID进行书籍数据修改")
    public APICODE updateBook(@RequestBody Book book) {
        // ## 修改
        Book book1 = bookService.saveOrUpdate(book);
        return APICODE.OK();
    }

    @DeleteMapping("{bookId}")
    @ApiOperation(value = "根据ID进行数据的删除")
    public APICODE deleteByBoookId(@PathVariable("bookId") String bookId) {
        bookService.removeById(bookId);
        return APICODE.OK();
    }





}
