package com.xiaomi.push;

import com.xiaomi.push.iz;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
/* loaded from: classes10.dex */
public class jj extends iz {
    public static int b = 10000;
    public static int c = 10000;
    public static int d = 10000;
    public static int e = 10485760;
    public static int f = 104857600;

    /* loaded from: classes10.dex */
    public static class a extends iz.a {
        public a() {
            super(false, true);
        }

        public a(boolean z, boolean z2, int i) {
            super(z, z2, i);
        }

        @Override // com.xiaomi.push.iz.a, com.xiaomi.push.jf
        public jd a(jn jnVar) {
            jj jjVar = new jj(jnVar, ((iz.a) this).f810a, this.b);
            int i = ((iz.a) this).a;
            if (i != 0) {
                jjVar.b(i);
            }
            return jjVar;
        }
    }

    public jj(jn jnVar, boolean z, boolean z2) {
        super(jnVar, z, z2);
    }

    @Override // com.xiaomi.push.iz, com.xiaomi.push.jd
    /* renamed from: a */
    public jb mo700a() {
        byte a2 = a();
        int mo697a = mo697a();
        if (mo697a <= c) {
            return new jb(a2, mo697a);
        }
        throw new je(3, "Thrift list size " + mo697a + " out of range!");
    }

    @Override // com.xiaomi.push.iz, com.xiaomi.push.jd
    /* renamed from: a */
    public jc mo701a() {
        byte a2 = a();
        byte a3 = a();
        int mo697a = mo697a();
        if (mo697a <= b) {
            return new jc(a2, a3, mo697a);
        }
        throw new je(3, "Thrift map size " + mo697a + " out of range!");
    }

    @Override // com.xiaomi.push.iz, com.xiaomi.push.jd
    /* renamed from: a */
    public jh mo702a() {
        byte a2 = a();
        int mo697a = mo697a();
        if (mo697a <= d) {
            return new jh(a2, mo697a);
        }
        throw new je(3, "Thrift set size " + mo697a + " out of range!");
    }

    @Override // com.xiaomi.push.iz, com.xiaomi.push.jd
    /* renamed from: a */
    public String mo704a() {
        int mo697a = mo697a();
        if (mo697a > e) {
            throw new je(3, "Thrift string size " + mo697a + " out of range!");
        } else if (((jd) this).a.b() >= mo697a) {
            try {
                String str = new String(((jd) this).a.mo722a(), ((jd) this).a.a(), mo697a, "UTF-8");
                ((jd) this).a.a(mo697a);
                return str;
            } catch (UnsupportedEncodingException unused) {
                throw new ix("JVM DOES NOT SUPPORT UTF-8");
            }
        } else {
            return a(mo697a);
        }
    }

    @Override // com.xiaomi.push.iz, com.xiaomi.push.jd
    /* renamed from: a */
    public ByteBuffer mo705a() {
        int mo697a = mo697a();
        if (mo697a > f) {
            throw new je(3, "Thrift binary size " + mo697a + " out of range!");
        }
        c(mo697a);
        if (((jd) this).a.b() >= mo697a) {
            ByteBuffer wrap = ByteBuffer.wrap(((jd) this).a.mo722a(), ((jd) this).a.a(), mo697a);
            ((jd) this).a.a(mo697a);
            return wrap;
        }
        byte[] bArr = new byte[mo697a];
        ((jd) this).a.b(bArr, 0, mo697a);
        return ByteBuffer.wrap(bArr);
    }
}
