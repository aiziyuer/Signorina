package com.aiziyuer.app.biz.impl;

import com.aiziyuer.app.biz.IAreaBiz;
import com.aiziyuer.app.ui.data.AreaBo;
import org.apache.commons.lang3.math.NumberUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * 区域树实现类
 */
public class AreaBizImpl implements IAreaBiz {

    @Override
    public AreaBo queryAreas() {

        // 写入测试代码
        long[] testDataArray = new long[]{1, 2, 3, 4, 5, 6, 7, 8, 9};

        int multiple = 10000;

        List<AreaBo> areaBos = new ArrayList<AreaBo>();
        for (long testData : testDataArray) {
            AreaBo areaBo = new AreaBo();
            areaBos.add(areaBo);

            areaBo.setId(testData);
            areaBo.setName(String.valueOf(testData));

            List<AreaBo> childAreaBos = new ArrayList<AreaBo>();
            areaBo.setChildes(childAreaBos);
            for (long testChildData : testDataArray) {
                AreaBo areaBo2 = new AreaBo();
                areaBo2.setId(testChildData + testData * multiple);
                areaBo2.setName(String.valueOf(areaBo2.getId()));
                childAreaBos.add(areaBo2);
            }
        }

        AreaBo root = new AreaBo();
        root.setChildes(areaBos);
        root.setId(NumberUtils.LONG_MINUS_ONE);
        root.setName(String.valueOf(NumberUtils.LONG_MINUS_ONE));

        return root;
    }
}
