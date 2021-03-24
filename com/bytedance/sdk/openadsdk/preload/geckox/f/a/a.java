package com.bytedance.sdk.openadsdk.preload.geckox.f.a;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes6.dex */
public abstract class a {

    /* renamed from: a  reason: collision with root package name */
    public File f30280a;

    public a(File file) {
        this.f30280a = file;
    }

    public abstract InputStream a(File file, String str) throws IOException;

    public final InputStream a(String str) throws IOException {
        return a(this.f30280a, str);
    }

    public abstract boolean b(File file, String str) throws IOException;

    public final boolean b(String str) throws IOException {
        return b(this.f30280a, str);
    }
}
