package com.aiziyuer.app.ui.data;

import lombok.Data;

import java.util.List;

/**
 * 区域信息
 */
@Data
public class AreaBo {

    private long id;

    private String name;

    private List<AreaBo> childes;
}
