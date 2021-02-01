package com.kwai.video.ksvodplayerkit.HttpDns;

import android.text.TextUtils;
import java.util.List;
/* loaded from: classes3.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    private b f11032a;

    /* loaded from: classes3.dex */
    private static final class a {

        /* renamed from: a  reason: collision with root package name */
        private static final e f11033a = new e();
    }

    private e() {
        this.f11032a = new c();
    }

    public static e a() {
        return a.f11033a;
    }

    public List<f> a(String str) {
        return this.f11032a.b(str);
    }

    public void b(String str) {
        if (TextUtils.isEmpty(str) || this.f11032a == null) {
            return;
        }
        this.f11032a.a(str);
    }
}
