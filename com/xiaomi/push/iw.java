package com.xiaomi.push;

import com.xiaomi.push.ix;
import java.io.ByteArrayOutputStream;
/* loaded from: classes7.dex */
public class iw {

    /* renamed from: a  reason: collision with root package name */
    public jb f40855a;

    /* renamed from: a  reason: collision with other field name */
    public final ji f798a;

    /* renamed from: a  reason: collision with other field name */
    public final ByteArrayOutputStream f799a;

    public iw() {
        this(new ix.a());
    }

    public iw(jd jdVar) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        this.f799a = byteArrayOutputStream;
        ji jiVar = new ji(byteArrayOutputStream);
        this.f798a = jiVar;
        this.f40855a = jdVar.a(jiVar);
    }

    public byte[] a(iq iqVar) {
        this.f799a.reset();
        iqVar.b(this.f40855a);
        return this.f799a.toByteArray();
    }
}
