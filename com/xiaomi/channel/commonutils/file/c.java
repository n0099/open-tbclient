package com.xiaomi.channel.commonutils.file;

import java.io.File;
import java.io.FileFilter;
/* loaded from: classes3.dex */
final class c implements FileFilter {
    @Override // java.io.FileFilter
    public boolean accept(File file) {
        return file.isDirectory();
    }
}
