package com.kwad.sdk.glide.load.a.a;

import java.io.File;
/* loaded from: classes5.dex */
class a {
    public File a(String str) {
        return new File(str);
    }

    public boolean a(File file) {
        return file.exists();
    }

    public long b(File file) {
        return file.length();
    }
}
