package com.kwai.video.ksvodplayerkit.HttpDns;

import android.text.TextUtils;
import java.util.List;
/* loaded from: classes4.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    private b f11030a;

    /* loaded from: classes4.dex */
    private static final class a {

        /* renamed from: a  reason: collision with root package name */
        private static final e f11031a = new e();
    }

    private e() {
        this.f11030a = new c();
    }

    public static e a() {
        return a.f11031a;
    }

    public List<f> a(String str) {
        return this.f11030a.b(str);
    }

    public void b(String str) {
        if (TextUtils.isEmpty(str) || this.f11030a == null) {
            return;
        }
        this.f11030a.a(str);
    }
}
