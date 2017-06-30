package com.xiaomi.channel.commonutils.file;

import java.io.File;
import java.io.FileFilter;
/* loaded from: classes2.dex */
final class b implements FileFilter {
    @Override // java.io.FileFilter
    public boolean accept(File file) {
        return file.isDirectory();
    }
}
