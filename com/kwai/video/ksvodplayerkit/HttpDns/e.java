package com.kwai.video.ksvodplayerkit.HttpDns;

import android.text.TextUtils;
import java.util.List;
/* loaded from: classes6.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public b f37499a;

    /* loaded from: classes6.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public static final e f37500a = new e();
    }

    public e() {
        this.f37499a = new c();
    }

    public static e a() {
        return a.f37500a;
    }

    public List<f> a(String str) {
        return this.f37499a.b(str);
    }

    public void b(String str) {
        b bVar;
        if (TextUtils.isEmpty(str) || (bVar = this.f37499a) == null) {
            return;
        }
        bVar.a(str);
    }
}
