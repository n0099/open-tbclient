package com.facebook.a;

import com.facebook.common.internal.g;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes2.dex */
public class b implements a {
    private final File mFile;

    private b(File file) {
        this.mFile = (File) g.checkNotNull(file);
    }

    public File getFile() {
        return this.mFile;
    }

    @Override // com.facebook.a.a
    public InputStream openStream() throws IOException {
        return new FileInputStream(this.mFile);
    }

    @Override // com.facebook.a.a
    public long size() {
        return this.mFile.length();
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof b)) {
            return false;
        }
        return this.mFile.equals(((b) obj).mFile);
    }

    public int hashCode() {
        return this.mFile.hashCode();
    }

    public static b aa(File file) {
        if (file != null) {
            return new b(file);
        }
        return null;
    }
}
