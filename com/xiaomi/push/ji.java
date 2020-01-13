package com.xiaomi.push;

import com.xiaomi.push.iy;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
/* loaded from: classes6.dex */
public class ji extends iy {
    private static int b = 10000;
    private static int c = 10000;
    private static int d = 10000;
    private static int e = 10485760;
    private static int f = 104857600;

    /* loaded from: classes6.dex */
    public static class a extends iy.a {
        public a() {
            super(false, true);
        }

        public a(boolean z, boolean z2, int i) {
            super(z, z2, i);
        }

        @Override // com.xiaomi.push.iy.a, com.xiaomi.push.je
        public jc a(jm jmVar) {
            ji jiVar = new ji(jmVar, this.f789a, this.b);
            if (this.a != 0) {
                jiVar.b(this.a);
            }
            return jiVar;
        }
    }

    public ji(jm jmVar, boolean z, boolean z2) {
        super(jmVar, z, z2);
    }

    @Override // com.xiaomi.push.iy, com.xiaomi.push.jc
    public ja a() {
        byte a2 = a();
        int a3 = a();
        if (a3 > c) {
            throw new jd(3, "Thrift list size " + a3 + " out of range!");
        }
        return new ja(a2, a3);
    }

    @Override // com.xiaomi.push.iy, com.xiaomi.push.jc
    public jb a() {
        byte a2 = a();
        byte a3 = a();
        int a4 = a();
        if (a4 > b) {
            throw new jd(3, "Thrift map size " + a4 + " out of range!");
        }
        return new jb(a2, a3, a4);
    }

    @Override // com.xiaomi.push.iy, com.xiaomi.push.jc
    public jg a() {
        byte a2 = a();
        int a3 = a();
        if (a3 > d) {
            throw new jd(3, "Thrift set size " + a3 + " out of range!");
        }
        return new jg(a2, a3);
    }

    @Override // com.xiaomi.push.iy, com.xiaomi.push.jc
    public String a() {
        int a2 = a();
        if (a2 > e) {
            throw new jd(3, "Thrift string size " + a2 + " out of range!");
        }
        if (this.a.b() >= a2) {
            try {
                String str = new String(this.a.m474a(), this.a.a(), a2, "UTF-8");
                this.a.a(a2);
                return str;
            } catch (UnsupportedEncodingException e2) {
                throw new iw("JVM DOES NOT SUPPORT UTF-8");
            }
        }
        return a(a2);
    }

    @Override // com.xiaomi.push.iy, com.xiaomi.push.jc
    public ByteBuffer a() {
        int a2 = a();
        if (a2 > f) {
            throw new jd(3, "Thrift binary size " + a2 + " out of range!");
        }
        c(a2);
        if (this.a.b() >= a2) {
            ByteBuffer wrap = ByteBuffer.wrap(this.a.m474a(), this.a.a(), a2);
            this.a.a(a2);
            return wrap;
        }
        byte[] bArr = new byte[a2];
        this.a.b(bArr, 0, a2);
        return ByteBuffer.wrap(bArr);
    }
}
