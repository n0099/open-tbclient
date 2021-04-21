package com.xiaomi.push.service;
/* loaded from: classes7.dex */
public class be {

    /* renamed from: a  reason: collision with root package name */
    public static int f41377a = 8;

    /* renamed from: d  reason: collision with root package name */
    public int f41380d = -666;

    /* renamed from: a  reason: collision with other field name */
    public byte[] f922a = new byte[256];

    /* renamed from: c  reason: collision with root package name */
    public int f41379c = 0;

    /* renamed from: b  reason: collision with root package name */
    public int f41378b = 0;

    public static int a(byte b2) {
        return b2 >= 0 ? b2 : b2 + 256;
    }

    private void a() {
        this.f41379c = 0;
        this.f41378b = 0;
    }

    private void a(int i, byte[] bArr, boolean z) {
        int length = bArr.length;
        for (int i2 = 0; i2 < 256; i2++) {
            this.f922a[i2] = (byte) i2;
        }
        this.f41379c = 0;
        this.f41378b = 0;
        while (true) {
            int i3 = this.f41378b;
            if (i3 >= i) {
                break;
            }
            int a2 = ((this.f41379c + a(this.f922a[i3])) + a(bArr[this.f41378b % length])) % 256;
            this.f41379c = a2;
            a(this.f922a, this.f41378b, a2);
            this.f41378b++;
        }
        if (i != 256) {
            this.f41380d = ((this.f41379c + a(this.f922a[i])) + a(bArr[i % length])) % 256;
        }
        if (z) {
            StringBuilder sb = new StringBuilder();
            sb.append("S_");
            int i4 = i - 1;
            sb.append(i4);
            sb.append(":");
            for (int i5 = 0; i5 <= i; i5++) {
                sb.append(" ");
                sb.append(a(this.f922a[i5]));
            }
            sb.append("   j_");
            sb.append(i4);
            sb.append("=");
            sb.append(this.f41379c);
            sb.append("   j_");
            sb.append(i);
            sb.append("=");
            sb.append(this.f41380d);
            sb.append("   S_");
            sb.append(i4);
            sb.append("[j_");
            sb.append(i4);
            sb.append("]=");
            sb.append(a(this.f922a[this.f41379c]));
            sb.append("   S_");
            sb.append(i4);
            sb.append("[j_");
            sb.append(i);
            sb.append("]=");
            sb.append(a(this.f922a[this.f41380d]));
            if (this.f922a[1] != 0) {
                sb.append("   S[1]!=0");
            }
            com.xiaomi.channel.commonutils.logger.b.m55a(sb.toString());
        }
    }

    private void a(byte[] bArr) {
        a(256, bArr, false);
    }

    public static void a(byte[] bArr, int i, int i2) {
        byte b2 = bArr[i];
        bArr[i] = bArr[i2];
        bArr[i2] = b2;
    }

    public static byte[] a(String str, String str2) {
        byte[] m165a = com.xiaomi.push.bj.m165a(str);
        byte[] bytes = str2.getBytes();
        byte[] bArr = new byte[m165a.length + 1 + bytes.length];
        for (int i = 0; i < m165a.length; i++) {
            bArr[i] = m165a[i];
        }
        bArr[m165a.length] = 95;
        for (int i2 = 0; i2 < bytes.length; i2++) {
            bArr[m165a.length + 1 + i2] = bytes[i2];
        }
        return bArr;
    }

    public static byte[] a(byte[] bArr, String str) {
        return a(bArr, com.xiaomi.push.bj.m165a(str));
    }

    public static byte[] a(byte[] bArr, byte[] bArr2) {
        byte[] bArr3 = new byte[bArr2.length];
        be beVar = new be();
        beVar.a(bArr);
        beVar.a();
        for (int i = 0; i < bArr2.length; i++) {
            bArr3[i] = (byte) (bArr2[i] ^ beVar.m595a());
        }
        return bArr3;
    }

    public static byte[] a(byte[] bArr, byte[] bArr2, boolean z, int i, int i2) {
        byte[] bArr3;
        int i3;
        if (i < 0 || i > bArr2.length || i + i2 > bArr2.length) {
            throw new IllegalArgumentException("start = " + i + " len = " + i2);
        }
        if (z) {
            bArr3 = bArr2;
            i3 = i;
        } else {
            bArr3 = new byte[i2];
            i3 = 0;
        }
        be beVar = new be();
        beVar.a(bArr);
        beVar.a();
        for (int i4 = 0; i4 < i2; i4++) {
            bArr3[i3 + i4] = (byte) (bArr2[i + i4] ^ beVar.m595a());
        }
        return bArr3;
    }

    /* renamed from: a  reason: collision with other method in class */
    public byte m595a() {
        int i = (this.f41378b + 1) % 256;
        this.f41378b = i;
        int a2 = (this.f41379c + a(this.f922a[i])) % 256;
        this.f41379c = a2;
        a(this.f922a, this.f41378b, a2);
        byte[] bArr = this.f922a;
        return bArr[(a(bArr[this.f41378b]) + a(this.f922a[this.f41379c])) % 256];
    }
}
