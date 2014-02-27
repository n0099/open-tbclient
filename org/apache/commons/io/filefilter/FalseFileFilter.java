package org.apache.commons.io.filefilter;

import java.io.File;
import java.io.Serializable;
/* loaded from: classes.dex */
public class FalseFileFilter implements Serializable, IOFileFilter {
    public static final IOFileFilter FALSE;
    public static final IOFileFilter INSTANCE;

    static {
        FalseFileFilter falseFileFilter = new FalseFileFilter();
        FALSE = falseFileFilter;
        INSTANCE = falseFileFilter;
    }

    protected FalseFileFilter() {
    }

    @Override // org.apache.commons.io.filefilter.IOFileFilter, java.io.FileFilter
    public boolean accept(File file) {
        return false;
    }

    @Override // org.apache.commons.io.filefilter.IOFileFilter, java.io.FilenameFilter
    public boolean accept(File file, String str) {
        return false;
    }
}
