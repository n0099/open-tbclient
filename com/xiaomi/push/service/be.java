package com.xiaomi.push.service;
/* loaded from: classes7.dex */
public class be {

    /* renamed from: a  reason: collision with root package name */
    public static int f38097a = 8;

    /* renamed from: d  reason: collision with root package name */
    public int f38100d = -666;

    /* renamed from: a  reason: collision with other field name */
    public byte[] f922a = new byte[256];

    /* renamed from: c  reason: collision with root package name */
    public int f38099c = 0;

    /* renamed from: b  reason: collision with root package name */
    public int f38098b = 0;

    public static int a(byte b2) {
        return b2 >= 0 ? b2 : b2 + 256;
    }

    private void a() {
        this.f38099c = 0;
        this.f38098b = 0;
    }

    private void a(int i2, byte[] bArr, boolean z) {
        int length = bArr.length;
        for (int i3 = 0; i3 < 256; i3++) {
            this.f922a[i3] = (byte) i3;
        }
        this.f38099c = 0;
        this.f38098b = 0;
        while (true) {
            int i4 = this.f38098b;
            if (i4 >= i2) {
                break;
            }
            int a2 = ((this.f38099c + a(this.f922a[i4])) + a(bArr[this.f38098b % length])) % 256;
            this.f38099c = a2;
            a(this.f922a, this.f38098b, a2);
            this.f38098b++;
        }
        if (i2 != 256) {
            this.f38100d = ((this.f38099c + a(this.f922a[i2])) + a(bArr[i2 % length])) % 256;
        }
        if (z) {
            StringBuilder sb = new StringBuilder();
            sb.append("S_");
            int i5 = i2 - 1;
            sb.append(i5);
            sb.append(":");
            for (int i6 = 0; i6 <= i2; i6++) {
                sb.append(" ");
                sb.append(a(this.f922a[i6]));
            }
            sb.append("   j_");
            sb.append(i5);
            sb.append("=");
            sb.append(this.f38099c);
            sb.append("   j_");
            sb.append(i2);
            sb.append("=");
            sb.append(this.f38100d);
            sb.append("   S_");
            sb.append(i5);
            sb.append("[j_");
            sb.append(i5);
            sb.append("]=");
            sb.append(a(this.f922a[this.f38099c]));
            sb.append("   S_");
            sb.append(i5);
            sb.append("[j_");
            sb.append(i2);
            sb.append("]=");
            sb.append(a(this.f922a[this.f38100d]));
            if (this.f922a[1] != 0) {
                sb.append("   S[1]!=0");
            }
            com.xiaomi.channel.commonutils.logger.b.m57a(sb.toString());
        }
    }

    private void a(byte[] bArr) {
        a(256, bArr, false);
    }

    public static void a(byte[] bArr, int i2, int i3) {
        byte b2 = bArr[i2];
        bArr[i2] = bArr[i3];
        bArr[i3] = b2;
    }

    public static byte[] a(String str, String str2) {
        byte[] m167a = com.xiaomi.push.bj.m167a(str);
        byte[] bytes = str2.getBytes();
        byte[] bArr = new byte[m167a.length + 1 + bytes.length];
        for (int i2 = 0; i2 < m167a.length; i2++) {
            bArr[i2] = m167a[i2];
        }
        bArr[m167a.length] = 95;
        for (int i3 = 0; i3 < bytes.length; i3++) {
            bArr[m167a.length + 1 + i3] = bytes[i3];
        }
        return bArr;
    }

    public static byte[] a(byte[] bArr, String str) {
        return a(bArr, com.xiaomi.push.bj.m167a(str));
    }

    public static byte[] a(byte[] bArr, byte[] bArr2) {
        byte[] bArr3 = new byte[bArr2.length];
        be beVar = new be();
        beVar.a(bArr);
        beVar.a();
        for (int i2 = 0; i2 < bArr2.length; i2++) {
            bArr3[i2] = (byte) (bArr2[i2] ^ beVar.m597a());
        }
        return bArr3;
    }

    public static byte[] a(byte[] bArr, byte[] bArr2, boolean z, int i2, int i3) {
        byte[] bArr3;
        int i4;
        if (i2 < 0 || i2 > bArr2.length || i2 + i3 > bArr2.length) {
            throw new IllegalArgumentException("start = " + i2 + " len = " + i3);
        }
        if (z) {
            bArr3 = bArr2;
            i4 = i2;
        } else {
            bArr3 = new byte[i3];
            i4 = 0;
        }
        be beVar = new be();
        beVar.a(bArr);
        beVar.a();
        for (int i5 = 0; i5 < i3; i5++) {
            bArr3[i4 + i5] = (byte) (bArr2[i2 + i5] ^ beVar.m597a());
        }
        return bArr3;
    }

    /* renamed from: a  reason: collision with other method in class */
    public byte m597a() {
        int i2 = (this.f38098b + 1) % 256;
        this.f38098b = i2;
        int a2 = (this.f38099c + a(this.f922a[i2])) % 256;
        this.f38099c = a2;
        a(this.f922a, this.f38098b, a2);
        byte[] bArr = this.f922a;
        return bArr[(a(bArr[this.f38098b]) + a(this.f922a[this.f38099c])) % 256];
    }
}
