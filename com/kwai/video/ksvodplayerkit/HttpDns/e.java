package com.kwai.video.ksvodplayerkit.HttpDns;

import android.text.TextUtils;
import java.util.List;
/* loaded from: classes6.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public b f37209a;

    /* loaded from: classes6.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public static final e f37210a = new e();
    }

    public e() {
        this.f37209a = new c();
    }

    public static e a() {
        return a.f37210a;
    }

    public List<f> a(String str) {
        return this.f37209a.b(str);
    }

    public void b(String str) {
        b bVar;
        if (TextUtils.isEmpty(str) || (bVar = this.f37209a) == null) {
            return;
        }
        bVar.a(str);
    }
}
