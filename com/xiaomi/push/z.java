package com.xiaomi.push;

import java.io.File;
import java.io.FileFilter;
/* loaded from: classes9.dex */
public final class z implements FileFilter {
    @Override // java.io.FileFilter
    public boolean accept(File file) {
        return file.isDirectory();
    }
}
