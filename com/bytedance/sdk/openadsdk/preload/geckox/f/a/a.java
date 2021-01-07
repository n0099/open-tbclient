package com.bytedance.sdk.openadsdk.preload.geckox.f.a;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes4.dex */
public abstract class a {

    /* renamed from: a  reason: collision with root package name */
    private File f7780a;

    protected abstract InputStream a(File file, String str) throws IOException;

    protected abstract boolean b(File file, String str) throws IOException;

    public a(File file) {
        this.f7780a = file;
    }

    public final InputStream a(String str) throws IOException {
        return a(this.f7780a, str);
    }

    public final boolean b(String str) throws IOException {
        return b(this.f7780a, str);
    }
}
