package com.xiaomi.push;

import com.xiaomi.push.ix;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
/* loaded from: classes7.dex */
public class jh extends ix {

    /* renamed from: b  reason: collision with root package name */
    public static int f41660b = 10000;

    /* renamed from: c  reason: collision with root package name */
    public static int f41661c = 10000;

    /* renamed from: d  reason: collision with root package name */
    public static int f41662d = 10000;

    /* renamed from: e  reason: collision with root package name */
    public static int f41663e = 10485760;

    /* renamed from: f  reason: collision with root package name */
    public static int f41664f = 104857600;

    /* loaded from: classes7.dex */
    public static class a extends ix.a {
        public a() {
            super(false, true);
        }

        public a(boolean z, boolean z2, int i2) {
            super(z, z2, i2);
        }

        @Override // com.xiaomi.push.ix.a, com.xiaomi.push.jd
        public jb a(jl jlVar) {
            jh jhVar = new jh(jlVar, ((ix.a) this).f805a, this.f41647b);
            int i2 = ((ix.a) this).f41646a;
            if (i2 != 0) {
                jhVar.b(i2);
            }
            return jhVar;
        }
    }

    public jh(jl jlVar, boolean z, boolean z2) {
        super(jlVar, z, z2);
    }

    @Override // com.xiaomi.push.ix, com.xiaomi.push.jb
    public iz a() {
        byte a2 = a();
        int a3 = a();
        if (a3 <= f41661c) {
            return new iz(a2, a3);
        }
        throw new jc(3, "Thrift list size " + a3 + " out of range!");
    }

    @Override // com.xiaomi.push.ix, com.xiaomi.push.jb
    public ja a() {
        byte a2 = a();
        byte a3 = a();
        int a4 = a();
        if (a4 <= f41660b) {
            return new ja(a2, a3, a4);
        }
        throw new jc(3, "Thrift map size " + a4 + " out of range!");
    }

    @Override // com.xiaomi.push.ix, com.xiaomi.push.jb
    public jf a() {
        byte a2 = a();
        int a3 = a();
        if (a3 <= f41662d) {
            return new jf(a2, a3);
        }
        throw new jc(3, "Thrift set size " + a3 + " out of range!");
    }

    @Override // com.xiaomi.push.ix, com.xiaomi.push.jb
    public String a() {
        int a2 = a();
        if (a2 > f41663e) {
            throw new jc(3, "Thrift string size " + a2 + " out of range!");
        } else if (((jb) this).f41655a.b() >= a2) {
            try {
                String str = new String(((jb) this).f41655a.m517a(), ((jb) this).f41655a.a(), a2, "UTF-8");
                ((jb) this).f41655a.a(a2);
                return str;
            } catch (UnsupportedEncodingException unused) {
                throw new iv("JVM DOES NOT SUPPORT UTF-8");
            }
        } else {
            return a(a2);
        }
    }

    @Override // com.xiaomi.push.ix, com.xiaomi.push.jb
    public ByteBuffer a() {
        int a2 = a();
        if (a2 > f41664f) {
            throw new jc(3, "Thrift binary size " + a2 + " out of range!");
        }
        c(a2);
        if (((jb) this).f41655a.b() >= a2) {
            ByteBuffer wrap = ByteBuffer.wrap(((jb) this).f41655a.m517a(), ((jb) this).f41655a.a(), a2);
            ((jb) this).f41655a.a(a2);
            return wrap;
        }
        byte[] bArr = new byte[a2];
        ((jb) this).f41655a.b(bArr, 0, a2);
        return ByteBuffer.wrap(bArr);
    }
}
