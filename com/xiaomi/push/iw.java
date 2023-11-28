package com.xiaomi.push;

import com.xiaomi.push.iz;
/* loaded from: classes10.dex */
public class iw {
    public final jd a;

    /* renamed from: a  reason: collision with other field name */
    public final jm f798a;

    public iw() {
        this(new iz.a());
    }

    public iw(jf jfVar) {
        jm jmVar = new jm();
        this.f798a = jmVar;
        this.a = jfVar.a(jmVar);
    }

    public void a(is isVar, byte[] bArr) {
        try {
            this.f798a.a(bArr);
            isVar.a(this.a);
        } finally {
            this.a.k();
        }
    }
}
