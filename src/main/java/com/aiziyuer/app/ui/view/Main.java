package com.aiziyuer.app.ui.view;

import com.aiziyuer.app.ui.view.area.AreaContentProvider;
import org.eclipse.jface.action.CoolBarManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.StatusLineManager;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.window.ApplicationWindow;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;

public class Main extends ApplicationWindow {

    private TreeViewer treeViewer;

    public Main() {
        super(null);
        createActions();
        addCoolBar(SWT.FLAT);
        addMenuBar();
        addStatusLine();
    }

    @Override
    protected Control createContents(Composite parent) {
        Composite container = new Composite(parent, SWT.NONE);
        container.setLayout(new FillLayout(SWT.HORIZONTAL));

        SashForm sashForm = new SashForm(container, SWT.NONE);

        treeViewer = new TreeViewer(sashForm, SWT.BORDER);

        Composite composite = new Composite(sashForm, SWT.NONE);


        sashForm.setWeights(new int[]{1, 2});

        setContentProvider();

        addListener();

        return container;
    }

    private void setContentProvider() {
        treeViewer.setContentProvider(new AreaContentProvider());
    }

    private void addListener() {
        treeViewer.addSelectionChangedListener(new ISelectionChangedListener() {
            @Override
            public void selectionChanged(SelectionChangedEvent event) {

            }
        });
    }

    private void createActions() {
        // Create the actions
    }

    @Override
    protected MenuManager createMenuManager() {
        MenuManager menuManager = new MenuManager("menu");
        return menuManager;
    }

    @Override
    protected CoolBarManager createCoolBarManager(int style) {
        CoolBarManager coolBarManager = new CoolBarManager(style);
        return coolBarManager;
    }

    @Override
    protected StatusLineManager createStatusLineManager() {
        StatusLineManager statusLineManager = new StatusLineManager();
        return statusLineManager;
    }

    @Override
    protected void configureShell(Shell newShell) {
        super.configureShell(newShell);
        newShell.setText("New Application");
    }
}
