package com.alura.pix.controller;

import com.alura.pix.dto.PixDTO;
import com.alura.pix.service.PixService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pix")
public class PixController {

    @Autowired
    private PixService pixService;

    @PostMapping
    public PixDTO salvarPix(@RequestBody PixDTO pixDTO) {



        return pixService.salvarPix(pixDTO);
    }
}
