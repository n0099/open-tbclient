package com.kwai.video.ksvodplayerkit.HttpDns;

import android.text.TextUtils;
import java.util.List;
/* loaded from: classes7.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public b f38077a;

    /* loaded from: classes7.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public static final e f38078a = new e();
    }

    public e() {
        this.f38077a = new c();
    }

    public static e a() {
        return a.f38078a;
    }

    public List<f> a(String str) {
        return this.f38077a.b(str);
    }

    public void b(String str) {
        b bVar;
        if (TextUtils.isEmpty(str) || (bVar = this.f38077a) == null) {
            return;
        }
        bVar.a(str);
    }
}
