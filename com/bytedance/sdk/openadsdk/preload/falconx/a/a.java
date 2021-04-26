package com.bytedance.sdk.openadsdk.preload.falconx.a;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.preload.geckox.f.b;
import java.io.File;
import java.io.InputStream;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes5.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public b f30783a;

    /* renamed from: b  reason: collision with root package name */
    public AtomicBoolean f30784b = new AtomicBoolean(false);

    public a(Context context, String str, File file) {
        if (context != null) {
            if (TextUtils.isEmpty(str)) {
                throw new RuntimeException("access key empty");
            }
            if (file != null) {
                this.f30783a = new b(context, str, file);
                return;
            }
            throw new RuntimeException("resRootDir == null");
        }
        throw new RuntimeException("context == null");
    }

    public InputStream a(String str) throws Exception {
        if (!this.f30784b.get()) {
            com.bytedance.sdk.openadsdk.preload.geckox.h.b.a("WebOffline-falcon", "GeckoResLoader ready to load, file:", str);
            return this.f30783a.a(str);
        }
        throw new RuntimeException("released!");
    }

    public boolean b(String str) throws Exception {
        if (!this.f30784b.get()) {
            return this.f30783a.b(str);
        }
        throw new RuntimeException("released!");
    }

    public void a() throws Exception {
        if (this.f30784b.getAndSet(true)) {
            return;
        }
        this.f30783a.a();
    }
}
