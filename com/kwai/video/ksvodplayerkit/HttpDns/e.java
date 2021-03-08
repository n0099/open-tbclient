package com.kwai.video.ksvodplayerkit.HttpDns;

import android.text.TextUtils;
import java.util.List;
/* loaded from: classes3.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    private b f7266a;

    /* loaded from: classes3.dex */
    private static final class a {

        /* renamed from: a  reason: collision with root package name */
        private static final e f7267a = new e();
    }

    private e() {
        this.f7266a = new c();
    }

    public static e a() {
        return a.f7267a;
    }

    public List<f> a(String str) {
        return this.f7266a.b(str);
    }

    public void b(String str) {
        if (TextUtils.isEmpty(str) || this.f7266a == null) {
            return;
        }
        this.f7266a.a(str);
    }
}
