package com.xiaomi.push;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
/* loaded from: classes10.dex */
public class iz extends jd {
    public static final ji a = new ji();

    /* renamed from: a  reason: collision with other field name */
    public int f806a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f807a;

    /* renamed from: a  reason: collision with other field name */
    public byte[] f808a;
    public boolean b;

    /* renamed from: b  reason: collision with other field name */
    public byte[] f809b;
    public boolean c;

    /* renamed from: c  reason: collision with other field name */
    public byte[] f810c;
    public byte[] d;
    public byte[] e;
    public byte[] f;
    public byte[] g;
    public byte[] h;

    /* loaded from: classes10.dex */
    public static class a implements jf {
        public int a;

        /* renamed from: a  reason: collision with other field name */
        public boolean f811a;
        public boolean b;

        public a() {
            this(false, true);
        }

        public a(boolean z, boolean z2) {
            this(z, z2, 0);
        }

        public a(boolean z, boolean z2, int i) {
            this.f811a = false;
            this.b = true;
            this.f811a = z;
            this.b = z2;
            this.a = i;
        }

        @Override // com.xiaomi.push.jf
        public jd a(jn jnVar) {
            iz izVar = new iz(jnVar, this.f811a, this.b);
            int i = this.a;
            if (i != 0) {
                izVar.b(i);
            }
            return izVar;
        }
    }

    public iz(jn jnVar, boolean z, boolean z2) {
        super(jnVar);
        this.f807a = false;
        this.b = true;
        this.c = false;
        this.f808a = new byte[1];
        this.f809b = new byte[2];
        this.f810c = new byte[4];
        this.d = new byte[8];
        this.e = new byte[1];
        this.f = new byte[2];
        this.g = new byte[4];
        this.h = new byte[8];
        this.f807a = z;
        this.b = z2;
    }

    private int a(byte[] bArr, int i, int i2) {
        c(i2);
        return ((jd) this).a.b(bArr, i, i2);
    }

    @Override // com.xiaomi.push.jd
    public byte a() {
        if (((jd) this).a.b() < 1) {
            a(this.e, 0, 1);
            return this.e[0];
        }
        byte b = ((jd) this).a.mo719a()[((jd) this).a.a()];
        ((jd) this).a.a(1);
        return b;
    }

    @Override // com.xiaomi.push.jd
    /* renamed from: a  reason: collision with other method in class */
    public double mo693a() {
        return Double.longBitsToDouble(mo695a());
    }

    @Override // com.xiaomi.push.jd
    /* renamed from: a  reason: collision with other method in class */
    public int mo694a() {
        byte[] bArr = this.g;
        int i = 0;
        if (((jd) this).a.b() >= 4) {
            bArr = ((jd) this).a.mo719a();
            i = ((jd) this).a.a();
            ((jd) this).a.a(4);
        } else {
            a(this.g, 0, 4);
        }
        return (bArr[i + 3] & 255) | ((bArr[i] & 255) << 24) | ((bArr[i + 1] & 255) << 16) | ((bArr[i + 2] & 255) << 8);
    }

    @Override // com.xiaomi.push.jd
    /* renamed from: a  reason: collision with other method in class */
    public long mo695a() {
        byte[] bArr = this.h;
        int i = 0;
        if (((jd) this).a.b() >= 8) {
            bArr = ((jd) this).a.mo719a();
            i = ((jd) this).a.a();
            ((jd) this).a.a(8);
        } else {
            a(this.h, 0, 8);
        }
        return (bArr[i + 7] & 255) | ((bArr[i] & 255) << 56) | ((bArr[i + 1] & 255) << 48) | ((bArr[i + 2] & 255) << 40) | ((bArr[i + 3] & 255) << 32) | ((bArr[i + 4] & 255) << 24) | ((bArr[i + 5] & 255) << 16) | ((bArr[i + 6] & 255) << 8);
    }

    @Override // com.xiaomi.push.jd
    /* renamed from: a  reason: collision with other method in class */
    public ja mo696a() {
        byte a2 = a();
        return new ja("", a2, a2 == 0 ? (short) 0 : mo703a());
    }

    @Override // com.xiaomi.push.jd
    /* renamed from: a  reason: collision with other method in class */
    public jb mo697a() {
        return new jb(a(), mo694a());
    }

    @Override // com.xiaomi.push.jd
    /* renamed from: a  reason: collision with other method in class */
    public jc mo698a() {
        return new jc(a(), a(), mo694a());
    }

    @Override // com.xiaomi.push.jd
    /* renamed from: a  reason: collision with other method in class */
    public jh mo699a() {
        return new jh(a(), mo694a());
    }

    @Override // com.xiaomi.push.jd
    /* renamed from: a  reason: collision with other method in class */
    public ji mo700a() {
        return a;
    }

    @Override // com.xiaomi.push.jd
    /* renamed from: a  reason: collision with other method in class */
    public String mo701a() {
        int mo694a = mo694a();
        if (((jd) this).a.b() >= mo694a) {
            try {
                String str = new String(((jd) this).a.mo719a(), ((jd) this).a.a(), mo694a, "UTF-8");
                ((jd) this).a.a(mo694a);
                return str;
            } catch (UnsupportedEncodingException unused) {
                throw new ix("JVM DOES NOT SUPPORT UTF-8");
            }
        }
        return a(mo694a);
    }

    /* JADX DEBUG: Possible override for method com.xiaomi.push.jd.a(I)V */
    public String a(int i) {
        try {
            c(i);
            byte[] bArr = new byte[i];
            ((jd) this).a.b(bArr, 0, i);
            return new String(bArr, "UTF-8");
        } catch (UnsupportedEncodingException unused) {
            throw new ix("JVM DOES NOT SUPPORT UTF-8");
        }
    }

    @Override // com.xiaomi.push.jd
    /* renamed from: a  reason: collision with other method in class */
    public ByteBuffer mo702a() {
        int mo694a = mo694a();
        c(mo694a);
        if (((jd) this).a.b() >= mo694a) {
            ByteBuffer wrap = ByteBuffer.wrap(((jd) this).a.mo719a(), ((jd) this).a.a(), mo694a);
            ((jd) this).a.a(mo694a);
            return wrap;
        }
        byte[] bArr = new byte[mo694a];
        ((jd) this).a.b(bArr, 0, mo694a);
        return ByteBuffer.wrap(bArr);
    }

    @Override // com.xiaomi.push.jd
    /* renamed from: a  reason: collision with other method in class */
    public short mo703a() {
        byte[] bArr = this.f;
        int i = 0;
        if (((jd) this).a.b() >= 2) {
            bArr = ((jd) this).a.mo719a();
            i = ((jd) this).a.a();
            ((jd) this).a.a(2);
        } else {
            a(this.f, 0, 2);
        }
        return (short) ((bArr[i + 1] & 255) | ((bArr[i] & 255) << 8));
    }

    @Override // com.xiaomi.push.jd
    /* renamed from: a  reason: collision with other method in class */
    public void mo704a() {
    }

    @Override // com.xiaomi.push.jd
    public void a(byte b) {
        byte[] bArr = this.f808a;
        bArr[0] = b;
        ((jd) this).a.mo718a(bArr, 0, 1);
    }

    @Override // com.xiaomi.push.jd
    /* renamed from: a  reason: collision with other method in class */
    public void mo705a(int i) {
        byte[] bArr = this.f810c;
        bArr[0] = (byte) ((i >> 24) & 255);
        bArr[1] = (byte) ((i >> 16) & 255);
        bArr[2] = (byte) ((i >> 8) & 255);
        bArr[3] = (byte) (i & 255);
        ((jd) this).a.mo718a(bArr, 0, 4);
    }

    @Override // com.xiaomi.push.jd
    public void a(long j) {
        byte[] bArr = this.d;
        bArr[0] = (byte) ((j >> 56) & 255);
        bArr[1] = (byte) ((j >> 48) & 255);
        bArr[2] = (byte) ((j >> 40) & 255);
        bArr[3] = (byte) ((j >> 32) & 255);
        bArr[4] = (byte) ((j >> 24) & 255);
        bArr[5] = (byte) ((j >> 16) & 255);
        bArr[6] = (byte) ((j >> 8) & 255);
        bArr[7] = (byte) (j & 255);
        ((jd) this).a.mo718a(bArr, 0, 8);
    }

    @Override // com.xiaomi.push.jd
    public void a(ja jaVar) {
        a(jaVar.a);
        a(jaVar.f814a);
    }

    @Override // com.xiaomi.push.jd
    public void a(jb jbVar) {
        a(jbVar.a);
        mo705a(jbVar.f815a);
    }

    @Override // com.xiaomi.push.jd
    public void a(jc jcVar) {
        a(jcVar.a);
        a(jcVar.b);
        mo705a(jcVar.f816a);
    }

    @Override // com.xiaomi.push.jd
    public void a(ji jiVar) {
    }

    @Override // com.xiaomi.push.jd
    public void a(String str) {
        try {
            byte[] bytes = str.getBytes("UTF-8");
            mo705a(bytes.length);
            ((jd) this).a.mo718a(bytes, 0, bytes.length);
        } catch (UnsupportedEncodingException unused) {
            throw new ix("JVM DOES NOT SUPPORT UTF-8");
        }
    }

    @Override // com.xiaomi.push.jd
    public void a(ByteBuffer byteBuffer) {
        int limit = (byteBuffer.limit() - byteBuffer.position()) - byteBuffer.arrayOffset();
        mo705a(limit);
        ((jd) this).a.mo718a(byteBuffer.array(), byteBuffer.position() + byteBuffer.arrayOffset(), limit);
    }

    @Override // com.xiaomi.push.jd
    public void a(short s) {
        byte[] bArr = this.f809b;
        bArr[0] = (byte) ((s >> 8) & 255);
        bArr[1] = (byte) (s & 255);
        ((jd) this).a.mo718a(bArr, 0, 2);
    }

    @Override // com.xiaomi.push.jd
    public void a(boolean z) {
        a(z ? (byte) 1 : (byte) 0);
    }

    @Override // com.xiaomi.push.jd
    /* renamed from: a  reason: collision with other method in class */
    public boolean mo706a() {
        return a() == 1;
    }

    @Override // com.xiaomi.push.jd
    public void b() {
    }

    public void b(int i) {
        this.f806a = i;
        this.c = true;
    }

    @Override // com.xiaomi.push.jd
    public void c() {
        a((byte) 0);
    }

    public void c(int i) {
        if (i < 0) {
            throw new ix("Negative length: " + i);
        } else if (this.c) {
            int i2 = this.f806a - i;
            this.f806a = i2;
            if (i2 >= 0) {
                return;
            }
            throw new ix("Message length exceeded: " + i);
        }
    }

    @Override // com.xiaomi.push.jd
    public void d() {
    }

    @Override // com.xiaomi.push.jd
    public void e() {
    }

    @Override // com.xiaomi.push.jd
    public void f() {
    }

    @Override // com.xiaomi.push.jd
    public void g() {
    }

    @Override // com.xiaomi.push.jd
    public void h() {
    }

    @Override // com.xiaomi.push.jd
    public void i() {
    }

    @Override // com.xiaomi.push.jd
    public void j() {
    }
}
