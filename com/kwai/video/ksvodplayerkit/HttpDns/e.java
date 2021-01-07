package com.kwai.video.ksvodplayerkit.HttpDns;

import android.text.TextUtils;
import java.util.List;
/* loaded from: classes5.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    private b f11330a;

    /* loaded from: classes5.dex */
    private static final class a {

        /* renamed from: a  reason: collision with root package name */
        private static final e f11331a = new e();
    }

    private e() {
        this.f11330a = new c();
    }

    public static e a() {
        return a.f11331a;
    }

    public List<f> a(String str) {
        return this.f11330a.b(str);
    }

    public void b(String str) {
        if (TextUtils.isEmpty(str) || this.f11330a == null) {
            return;
        }
        this.f11330a.a(str);
    }
}
