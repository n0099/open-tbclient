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
    public jb mo692a() {
        byte a2 = a();
        int mo689a = mo689a();
        if (mo689a <= c) {
            return new jb(a2, mo689a);
        }
        throw new je(3, "Thrift list size " + mo689a + " out of range!");
    }

    @Override // com.xiaomi.push.iz, com.xiaomi.push.jd
    /* renamed from: a */
    public jc mo693a() {
        byte a2 = a();
        byte a3 = a();
        int mo689a = mo689a();
        if (mo689a <= b) {
            return new jc(a2, a3, mo689a);
        }
        throw new je(3, "Thrift map size " + mo689a + " out of range!");
    }

    @Override // com.xiaomi.push.iz, com.xiaomi.push.jd
    /* renamed from: a */
    public jh mo694a() {
        byte a2 = a();
        int mo689a = mo689a();
        if (mo689a <= d) {
            return new jh(a2, mo689a);
        }
        throw new je(3, "Thrift set size " + mo689a + " out of range!");
    }

    @Override // com.xiaomi.push.iz, com.xiaomi.push.jd
    /* renamed from: a */
    public String mo696a() {
        int mo689a = mo689a();
        if (mo689a > e) {
            throw new je(3, "Thrift string size " + mo689a + " out of range!");
        } else if (((jd) this).a.b() >= mo689a) {
            try {
                String str = new String(((jd) this).a.mo714a(), ((jd) this).a.a(), mo689a, "UTF-8");
                ((jd) this).a.a(mo689a);
                return str;
            } catch (UnsupportedEncodingException unused) {
                throw new ix("JVM DOES NOT SUPPORT UTF-8");
            }
        } else {
            return a(mo689a);
        }
    }

    @Override // com.xiaomi.push.iz, com.xiaomi.push.jd
    /* renamed from: a */
    public ByteBuffer mo697a() {
        int mo689a = mo689a();
        if (mo689a > f) {
            throw new je(3, "Thrift binary size " + mo689a + " out of range!");
        }
        c(mo689a);
        if (((jd) this).a.b() >= mo689a) {
            ByteBuffer wrap = ByteBuffer.wrap(((jd) this).a.mo714a(), ((jd) this).a.a(), mo689a);
            ((jd) this).a.a(mo689a);
            return wrap;
        }
        byte[] bArr = new byte[mo689a];
        ((jd) this).a.b(bArr, 0, mo689a);
        return ByteBuffer.wrap(bArr);
    }
}
