package com.aiziyuer.app.ui.view.area;

import com.aiziyuer.app.ui.data.AreaBo;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;
import org.springframework.util.CollectionUtils;

/**
 * 区域树信息
 */
public class AreaContentProvider implements ITreeContentProvider {

    @Override
    public Object[] getElements(Object inputElement) {

        if (!(inputElement instanceof AreaBo))
            return new Object[0];

        AreaBo areaBo = (AreaBo) inputElement;
        return areaBo.getChildes().toArray();
    }

    @Override
    public Object[] getChildren(Object parentElement) {

        if (!(parentElement instanceof AreaBo))
            return new Object[0];

        AreaBo areaBo = (AreaBo) parentElement;
        return areaBo.getChildes().toArray();
    }

    @Override
    public Object getParent(Object element) {
        return null;
    }

    @Override
    public boolean hasChildren(Object element) {

        if (!(element instanceof AreaBo))
            return false;

        AreaBo areaBo = (AreaBo) element;
        return !CollectionUtils.isEmpty(areaBo.getChildes());
    }

    @Override
    public void dispose() {

    }

    @Override
    public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {

    }
}
