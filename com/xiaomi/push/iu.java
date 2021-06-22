package com.xiaomi.push;

import com.xiaomi.push.ix;
/* loaded from: classes7.dex */
public class iu {

    /* renamed from: a  reason: collision with root package name */
    public final jb f41739a;

    /* renamed from: a  reason: collision with other field name */
    public final jk f797a;

    public iu() {
        this(new ix.a());
    }

    public iu(jd jdVar) {
        jk jkVar = new jk();
        this.f797a = jkVar;
        this.f41739a = jdVar.a(jkVar);
    }

    public void a(iq iqVar, byte[] bArr) {
        try {
            this.f797a.a(bArr);
            iqVar.a(this.f41739a);
        } finally {
            this.f41739a.k();
        }
    }
}
