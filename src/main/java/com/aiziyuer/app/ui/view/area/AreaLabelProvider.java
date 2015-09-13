package com.aiziyuer.app.ui.view.area;

import com.aiziyuer.app.ui.data.AreaBo;
import org.apache.commons.lang3.StringUtils;
import org.eclipse.jface.viewers.LabelProvider;

/**
 * 区域展示方式提供类
 */
public class AreaLabelProvider extends LabelProvider {

    @Override
    public String getText(Object element) {

        if (!(element instanceof AreaBo))
            return StringUtils.EMPTY;

        AreaBo areaBo = (AreaBo) element;

        return areaBo.getName();
    }
}
