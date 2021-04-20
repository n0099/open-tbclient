package com.xiaomi.push;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
/* loaded from: classes7.dex */
public class ix extends jb {

    /* renamed from: a  reason: collision with root package name */
    public static final jg f41146a = new jg();

    /* renamed from: a  reason: collision with other field name */
    public int f800a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f801a;

    /* renamed from: a  reason: collision with other field name */
    public byte[] f802a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f41147b;

    /* renamed from: b  reason: collision with other field name */
    public byte[] f803b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f41148c;

    /* renamed from: c  reason: collision with other field name */
    public byte[] f804c;

    /* renamed from: d  reason: collision with root package name */
    public byte[] f41149d;

    /* renamed from: e  reason: collision with root package name */
    public byte[] f41150e;

    /* renamed from: f  reason: collision with root package name */
    public byte[] f41151f;

    /* renamed from: g  reason: collision with root package name */
    public byte[] f41152g;

    /* renamed from: h  reason: collision with root package name */
    public byte[] f41153h;

    /* loaded from: classes7.dex */
    public static class a implements jd {

        /* renamed from: a  reason: collision with root package name */
        public int f41154a;

        /* renamed from: a  reason: collision with other field name */
        public boolean f805a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f41155b;

        public a() {
            this(false, true);
        }

        public a(boolean z, boolean z2) {
            this(z, z2, 0);
        }

        public a(boolean z, boolean z2, int i) {
            this.f805a = false;
            this.f41155b = true;
            this.f805a = z;
            this.f41155b = z2;
            this.f41154a = i;
        }

        @Override // com.xiaomi.push.jd
        public jb a(jl jlVar) {
            ix ixVar = new ix(jlVar, this.f805a, this.f41155b);
            int i = this.f41154a;
            if (i != 0) {
                ixVar.b(i);
            }
            return ixVar;
        }
    }

    public ix(jl jlVar, boolean z, boolean z2) {
        super(jlVar);
        this.f801a = false;
        this.f41147b = true;
        this.f41148c = false;
        this.f802a = new byte[1];
        this.f803b = new byte[2];
        this.f804c = new byte[4];
        this.f41149d = new byte[8];
        this.f41150e = new byte[1];
        this.f41151f = new byte[2];
        this.f41152g = new byte[4];
        this.f41153h = new byte[8];
        this.f801a = z;
        this.f41147b = z2;
    }

    private int a(byte[] bArr, int i, int i2) {
        c(i2);
        return ((jb) this).f41163a.b(bArr, i, i2);
    }

    @Override // com.xiaomi.push.jb
    public byte a() {
        if (((jb) this).f41163a.b() < 1) {
            a(this.f41150e, 0, 1);
            return this.f41150e[0];
        }
        byte b2 = ((jb) this).f41163a.m516a()[((jb) this).f41163a.a()];
        ((jb) this).f41163a.a(1);
        return b2;
    }

    @Override // com.xiaomi.push.jb
    public double a() {
        return Double.longBitsToDouble(a());
    }

    @Override // com.xiaomi.push.jb
    public int a() {
        byte[] bArr = this.f41152g;
        int i = 0;
        if (((jb) this).f41163a.b() >= 4) {
            bArr = ((jb) this).f41163a.m516a();
            i = ((jb) this).f41163a.a();
            ((jb) this).f41163a.a(4);
        } else {
            a(this.f41152g, 0, 4);
        }
        return (bArr[i + 3] & 255) | ((bArr[i] & 255) << 24) | ((bArr[i + 1] & 255) << 16) | ((bArr[i + 2] & 255) << 8);
    }

    @Override // com.xiaomi.push.jb
    public long a() {
        byte[] bArr = this.f41153h;
        int i = 0;
        if (((jb) this).f41163a.b() >= 8) {
            bArr = ((jb) this).f41163a.m516a();
            i = ((jb) this).f41163a.a();
            ((jb) this).f41163a.a(8);
        } else {
            a(this.f41153h, 0, 8);
        }
        return (bArr[i + 7] & 255) | ((bArr[i] & 255) << 56) | ((bArr[i + 1] & 255) << 48) | ((bArr[i + 2] & 255) << 40) | ((bArr[i + 3] & 255) << 32) | ((bArr[i + 4] & 255) << 24) | ((bArr[i + 5] & 255) << 16) | ((bArr[i + 6] & 255) << 8);
    }

    @Override // com.xiaomi.push.jb
    public iy a() {
        byte a2 = a();
        return new iy("", a2, a2 == 0 ? (short) 0 : a());
    }

    @Override // com.xiaomi.push.jb
    public iz a() {
        return new iz(a(), a());
    }

    @Override // com.xiaomi.push.jb
    public ja a() {
        return new ja(a(), a(), a());
    }

    @Override // com.xiaomi.push.jb
    public jf a() {
        return new jf(a(), a());
    }

    @Override // com.xiaomi.push.jb
    public jg a() {
        return f41146a;
    }

    @Override // com.xiaomi.push.jb
    public String a() {
        int a2 = a();
        if (((jb) this).f41163a.b() >= a2) {
            try {
                String str = new String(((jb) this).f41163a.m516a(), ((jb) this).f41163a.a(), a2, "UTF-8");
                ((jb) this).f41163a.a(a2);
                return str;
            } catch (UnsupportedEncodingException unused) {
                throw new iv("JVM DOES NOT SUPPORT UTF-8");
            }
        }
        return a(a2);
    }

    @Override // com.xiaomi.push.jb
    public String a(int i) {
        try {
            c(i);
            byte[] bArr = new byte[i];
            ((jb) this).f41163a.b(bArr, 0, i);
            return new String(bArr, "UTF-8");
        } catch (UnsupportedEncodingException unused) {
            throw new iv("JVM DOES NOT SUPPORT UTF-8");
        }
    }

    @Override // com.xiaomi.push.jb
    public ByteBuffer a() {
        int a2 = a();
        c(a2);
        if (((jb) this).f41163a.b() >= a2) {
            ByteBuffer wrap = ByteBuffer.wrap(((jb) this).f41163a.m516a(), ((jb) this).f41163a.a(), a2);
            ((jb) this).f41163a.a(a2);
            return wrap;
        }
        byte[] bArr = new byte[a2];
        ((jb) this).f41163a.b(bArr, 0, a2);
        return ByteBuffer.wrap(bArr);
    }

    @Override // com.xiaomi.push.jb
    public short a() {
        byte[] bArr = this.f41151f;
        int i = 0;
        if (((jb) this).f41163a.b() >= 2) {
            bArr = ((jb) this).f41163a.m516a();
            i = ((jb) this).f41163a.a();
            ((jb) this).f41163a.a(2);
        } else {
            a(this.f41151f, 0, 2);
        }
        return (short) ((bArr[i + 1] & 255) | ((bArr[i] & 255) << 8));
    }

    @Override // com.xiaomi.push.jb
    public void a() {
    }

    @Override // com.xiaomi.push.jb
    public void a(byte b2) {
        byte[] bArr = this.f802a;
        bArr[0] = b2;
        ((jb) this).f41163a.m515a(bArr, 0, 1);
    }

    @Override // com.xiaomi.push.jb
    public void a(int i) {
        byte[] bArr = this.f804c;
        bArr[0] = (byte) ((i >> 24) & 255);
        bArr[1] = (byte) ((i >> 16) & 255);
        bArr[2] = (byte) ((i >> 8) & 255);
        bArr[3] = (byte) (i & 255);
        ((jb) this).f41163a.m515a(bArr, 0, 4);
    }

    @Override // com.xiaomi.push.jb
    public void a(long j) {
        byte[] bArr = this.f41149d;
        bArr[0] = (byte) ((j >> 56) & 255);
        bArr[1] = (byte) ((j >> 48) & 255);
        bArr[2] = (byte) ((j >> 40) & 255);
        bArr[3] = (byte) ((j >> 32) & 255);
        bArr[4] = (byte) ((j >> 24) & 255);
        bArr[5] = (byte) ((j >> 16) & 255);
        bArr[6] = (byte) ((j >> 8) & 255);
        bArr[7] = (byte) (j & 255);
        ((jb) this).f41163a.m515a(bArr, 0, 8);
    }

    @Override // com.xiaomi.push.jb
    public void a(iy iyVar) {
        a(iyVar.f41156a);
        a(iyVar.f807a);
    }

    @Override // com.xiaomi.push.jb
    public void a(iz izVar) {
        a(izVar.f41157a);
        a(izVar.f808a);
    }

    @Override // com.xiaomi.push.jb
    public void a(ja jaVar) {
        a(jaVar.f41161a);
        a(jaVar.f41162b);
        a(jaVar.f811a);
    }

    @Override // com.xiaomi.push.jb
    public void a(jg jgVar) {
    }

    @Override // com.xiaomi.push.jb
    public void a(String str) {
        try {
            byte[] bytes = str.getBytes("UTF-8");
            a(bytes.length);
            ((jb) this).f41163a.m515a(bytes, 0, bytes.length);
        } catch (UnsupportedEncodingException unused) {
            throw new iv("JVM DOES NOT SUPPORT UTF-8");
        }
    }

    @Override // com.xiaomi.push.jb
    public void a(ByteBuffer byteBuffer) {
        int limit = (byteBuffer.limit() - byteBuffer.position()) - byteBuffer.arrayOffset();
        a(limit);
        ((jb) this).f41163a.m515a(byteBuffer.array(), byteBuffer.position() + byteBuffer.arrayOffset(), limit);
    }

    @Override // com.xiaomi.push.jb
    public void a(short s) {
        byte[] bArr = this.f803b;
        bArr[0] = (byte) ((s >> 8) & 255);
        bArr[1] = (byte) (s & 255);
        ((jb) this).f41163a.m515a(bArr, 0, 2);
    }

    @Override // com.xiaomi.push.jb
    public void a(boolean z) {
        a(z ? (byte) 1 : (byte) 0);
    }

    @Override // com.xiaomi.push.jb
    public boolean a() {
        return a() == 1;
    }

    @Override // com.xiaomi.push.jb
    public void b() {
    }

    public void b(int i) {
        this.f800a = i;
        this.f41148c = true;
    }

    @Override // com.xiaomi.push.jb
    public void c() {
        a((byte) 0);
    }

    public void c(int i) {
        if (i < 0) {
            throw new iv("Negative length: " + i);
        } else if (this.f41148c) {
            int i2 = this.f800a - i;
            this.f800a = i2;
            if (i2 >= 0) {
                return;
            }
            throw new iv("Message length exceeded: " + i);
        }
    }

    @Override // com.xiaomi.push.jb
    public void d() {
    }

    @Override // com.xiaomi.push.jb
    public void e() {
    }

    @Override // com.xiaomi.push.jb
    public void f() {
    }

    @Override // com.xiaomi.push.jb
    public void g() {
    }

    @Override // com.xiaomi.push.jb
    public void h() {
    }

    @Override // com.xiaomi.push.jb
    public void i() {
    }

    @Override // com.xiaomi.push.jb
    public void j() {
    }
}
