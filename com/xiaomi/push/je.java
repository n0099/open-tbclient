package com.xiaomi.push;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
/* loaded from: classes6.dex */
public class je extends ji {

    /* renamed from: a  reason: collision with root package name */
    private static final jn f14169a = new jn();

    /* renamed from: a  reason: collision with other field name */
    protected int f850a;

    /* renamed from: a  reason: collision with other field name */
    protected boolean f851a;

    /* renamed from: a  reason: collision with other field name */
    private byte[] f852a;

    /* renamed from: b  reason: collision with root package name */
    protected boolean f14170b;

    /* renamed from: b  reason: collision with other field name */
    private byte[] f853b;
    protected boolean c;

    /* renamed from: c  reason: collision with other field name */
    private byte[] f854c;
    private byte[] d;
    private byte[] e;
    private byte[] f;
    private byte[] g;
    private byte[] h;

    /* loaded from: classes6.dex */
    public static class a implements jk {

        /* renamed from: a  reason: collision with root package name */
        protected int f14171a;

        /* renamed from: a  reason: collision with other field name */
        protected boolean f855a;

        /* renamed from: b  reason: collision with root package name */
        protected boolean f14172b;

        public a() {
            this(false, true);
        }

        public a(boolean z, boolean z2) {
            this(z, z2, 0);
        }

        public a(boolean z, boolean z2, int i) {
            this.f855a = false;
            this.f14172b = true;
            this.f855a = z;
            this.f14172b = z2;
            this.f14171a = i;
        }

        @Override // com.xiaomi.push.jk
        public ji a(js jsVar) {
            je jeVar = new je(jsVar, this.f855a, this.f14172b);
            if (this.f14171a != 0) {
                jeVar.b(this.f14171a);
            }
            return jeVar;
        }
    }

    public je(js jsVar, boolean z, boolean z2) {
        super(jsVar);
        this.f851a = false;
        this.f14170b = true;
        this.c = false;
        this.f852a = new byte[1];
        this.f853b = new byte[2];
        this.f854c = new byte[4];
        this.d = new byte[8];
        this.e = new byte[1];
        this.f = new byte[2];
        this.g = new byte[4];
        this.h = new byte[8];
        this.f851a = z;
        this.f14170b = z2;
    }

    private int a(byte[] bArr, int i, int i2) {
        c(i2);
        return this.f14177a.b(bArr, i, i2);
    }

    @Override // com.xiaomi.push.ji
    public byte a() {
        if (this.f14177a.b() < 1) {
            a(this.e, 0, 1);
            return this.e[0];
        }
        byte b2 = this.f14177a.m521a()[this.f14177a.a()];
        this.f14177a.a(1);
        return b2;
    }

    @Override // com.xiaomi.push.ji
    public double a() {
        return Double.longBitsToDouble(a());
    }

    @Override // com.xiaomi.push.ji
    public int a() {
        int i = 0;
        byte[] bArr = this.g;
        if (this.f14177a.b() >= 4) {
            bArr = this.f14177a.m521a();
            i = this.f14177a.a();
            this.f14177a.a(4);
        } else {
            a(this.g, 0, 4);
        }
        return (bArr[i + 3] & 255) | ((bArr[i] & 255) << 24) | ((bArr[i + 1] & 255) << 16) | ((bArr[i + 2] & 255) << 8);
    }

    @Override // com.xiaomi.push.ji
    public long a() {
        int i = 0;
        byte[] bArr = this.h;
        if (this.f14177a.b() >= 8) {
            bArr = this.f14177a.m521a();
            i = this.f14177a.a();
            this.f14177a.a(8);
        } else {
            a(this.h, 0, 8);
        }
        return (bArr[i + 7] & 255) | ((bArr[i] & 255) << 56) | ((bArr[i + 1] & 255) << 48) | ((bArr[i + 2] & 255) << 40) | ((bArr[i + 3] & 255) << 32) | ((bArr[i + 4] & 255) << 24) | ((bArr[i + 5] & 255) << 16) | ((bArr[i + 6] & 255) << 8);
    }

    @Override // com.xiaomi.push.ji
    public jf a() {
        byte a2 = a();
        return new jf("", a2, a2 == 0 ? (short) 0 : a());
    }

    @Override // com.xiaomi.push.ji
    public jg a() {
        return new jg(a(), a());
    }

    @Override // com.xiaomi.push.ji
    public jh a() {
        return new jh(a(), a(), a());
    }

    @Override // com.xiaomi.push.ji
    public jm a() {
        return new jm(a(), a());
    }

    @Override // com.xiaomi.push.ji
    public jn a() {
        return f14169a;
    }

    @Override // com.xiaomi.push.ji
    public String a() {
        int a2 = a();
        if (this.f14177a.b() >= a2) {
            try {
                String str = new String(this.f14177a.m521a(), this.f14177a.a(), a2, "UTF-8");
                this.f14177a.a(a2);
                return str;
            } catch (UnsupportedEncodingException e) {
                throw new jc("JVM DOES NOT SUPPORT UTF-8");
            }
        }
        return a(a2);
    }

    @Override // com.xiaomi.push.ji
    public String a(int i) {
        try {
            c(i);
            byte[] bArr = new byte[i];
            this.f14177a.b(bArr, 0, i);
            return new String(bArr, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new jc("JVM DOES NOT SUPPORT UTF-8");
        }
    }

    @Override // com.xiaomi.push.ji
    public ByteBuffer a() {
        int a2 = a();
        c(a2);
        if (this.f14177a.b() >= a2) {
            ByteBuffer wrap = ByteBuffer.wrap(this.f14177a.m521a(), this.f14177a.a(), a2);
            this.f14177a.a(a2);
            return wrap;
        }
        byte[] bArr = new byte[a2];
        this.f14177a.b(bArr, 0, a2);
        return ByteBuffer.wrap(bArr);
    }

    @Override // com.xiaomi.push.ji
    public short a() {
        int i = 0;
        byte[] bArr = this.f;
        if (this.f14177a.b() >= 2) {
            bArr = this.f14177a.m521a();
            i = this.f14177a.a();
            this.f14177a.a(2);
        } else {
            a(this.f, 0, 2);
        }
        return (short) ((bArr[i + 1] & 255) | ((bArr[i] & 255) << 8));
    }

    @Override // com.xiaomi.push.ji
    public void a() {
    }

    @Override // com.xiaomi.push.ji
    public void a(byte b2) {
        this.f852a[0] = b2;
        this.f14177a.m520a(this.f852a, 0, 1);
    }

    @Override // com.xiaomi.push.ji
    public void a(int i) {
        this.f854c[0] = (byte) ((i >> 24) & 255);
        this.f854c[1] = (byte) ((i >> 16) & 255);
        this.f854c[2] = (byte) ((i >> 8) & 255);
        this.f854c[3] = (byte) (i & 255);
        this.f14177a.m520a(this.f854c, 0, 4);
    }

    @Override // com.xiaomi.push.ji
    public void a(long j) {
        this.d[0] = (byte) ((j >> 56) & 255);
        this.d[1] = (byte) ((j >> 48) & 255);
        this.d[2] = (byte) ((j >> 40) & 255);
        this.d[3] = (byte) ((j >> 32) & 255);
        this.d[4] = (byte) ((j >> 24) & 255);
        this.d[5] = (byte) ((j >> 16) & 255);
        this.d[6] = (byte) ((j >> 8) & 255);
        this.d[7] = (byte) (255 & j);
        this.f14177a.m520a(this.d, 0, 8);
    }

    @Override // com.xiaomi.push.ji
    public void a(jf jfVar) {
        a(jfVar.f14173a);
        a(jfVar.f857a);
    }

    @Override // com.xiaomi.push.ji
    public void a(jg jgVar) {
        a(jgVar.f14174a);
        a(jgVar.f858a);
    }

    @Override // com.xiaomi.push.ji
    public void a(jh jhVar) {
        a(jhVar.f14175a);
        a(jhVar.f14176b);
        a(jhVar.f859a);
    }

    @Override // com.xiaomi.push.ji
    public void a(jn jnVar) {
    }

    @Override // com.xiaomi.push.ji
    public void a(String str) {
        try {
            byte[] bytes = str.getBytes("UTF-8");
            a(bytes.length);
            this.f14177a.m520a(bytes, 0, bytes.length);
        } catch (UnsupportedEncodingException e) {
            throw new jc("JVM DOES NOT SUPPORT UTF-8");
        }
    }

    @Override // com.xiaomi.push.ji
    public void a(ByteBuffer byteBuffer) {
        int limit = (byteBuffer.limit() - byteBuffer.position()) - byteBuffer.arrayOffset();
        a(limit);
        this.f14177a.m520a(byteBuffer.array(), byteBuffer.position() + byteBuffer.arrayOffset(), limit);
    }

    @Override // com.xiaomi.push.ji
    public void a(short s) {
        this.f853b[0] = (byte) ((s >> 8) & 255);
        this.f853b[1] = (byte) (s & 255);
        this.f14177a.m520a(this.f853b, 0, 2);
    }

    @Override // com.xiaomi.push.ji
    public void a(boolean z) {
        a(z ? (byte) 1 : (byte) 0);
    }

    @Override // com.xiaomi.push.ji
    public boolean a() {
        return a() == 1;
    }

    @Override // com.xiaomi.push.ji
    public void b() {
    }

    public void b(int i) {
        this.f850a = i;
        this.c = true;
    }

    @Override // com.xiaomi.push.ji
    public void c() {
        a((byte) 0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c(int i) {
        if (i < 0) {
            throw new jc("Negative length: " + i);
        }
        if (this.c) {
            this.f850a -= i;
            if (this.f850a < 0) {
                throw new jc("Message length exceeded: " + i);
            }
        }
    }

    @Override // com.xiaomi.push.ji
    public void d() {
    }

    @Override // com.xiaomi.push.ji
    public void e() {
    }

    @Override // com.xiaomi.push.ji
    public void f() {
    }

    @Override // com.xiaomi.push.ji
    public void g() {
    }

    @Override // com.xiaomi.push.ji
    public void h() {
    }

    @Override // com.xiaomi.push.ji
    public void i() {
    }

    @Override // com.xiaomi.push.ji
    public void j() {
    }
}
