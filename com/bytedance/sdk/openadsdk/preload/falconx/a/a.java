package com.bytedance.sdk.openadsdk.preload.falconx.a;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.preload.geckox.f.b;
import java.io.File;
import java.io.InputStream;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private b f7731a;

    /* renamed from: b  reason: collision with root package name */
    private AtomicBoolean f7732b = new AtomicBoolean(false);

    public a(Context context, String str, File file) {
        if (context == null) {
            throw new RuntimeException("context == null");
        }
        if (TextUtils.isEmpty(str)) {
            throw new RuntimeException("access key empty");
        }
        if (file == null) {
            throw new RuntimeException("resRootDir == null");
        }
        this.f7731a = new b(context, str, file);
    }

    public InputStream a(String str) throws Exception {
        if (this.f7732b.get()) {
            throw new RuntimeException("released!");
        }
        com.bytedance.sdk.openadsdk.preload.geckox.h.b.a("WebOffline-falcon", "GeckoResLoader ready to load, file:", str);
        return this.f7731a.a(str);
    }

    public boolean b(String str) throws Exception {
        if (this.f7732b.get()) {
            throw new RuntimeException("released!");
        }
        return this.f7731a.b(str);
    }

    public void a() throws Exception {
        if (!this.f7732b.getAndSet(true)) {
            this.f7731a.a();
        }
    }
}
