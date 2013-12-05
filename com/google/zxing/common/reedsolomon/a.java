package com.google.zxing.common.reedsolomon;

import com.baidu.cyberplayer.sdk.BVideoView;
import com.tencent.mm.sdk.platformtools.LVBuffer;
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static final a f2868a = new a(4201, LVBuffer.LENGTH_ALLOC_PER_NEW, 1);
    public static final a b = new a(1033, 1024, 1);
    public static final a c = new a(67, 64, 1);
    public static final a d = new a(19, 16, 1);
    public static final a e = new a(285, 256, 0);
    public static final a f = new a(BVideoView.MEDIA_ERROR_NO_INPUTFILE, 256, 1);
    public static final a g = f;
    public static final a h = c;
    private int[] i;
    private int[] j;
    private b k;
    private b l;
    private final int m;
    private final int n;
    private final int o;
    private boolean p = false;

    public a(int i, int i2, int i3) {
        this.n = i;
        this.m = i2;
        this.o = i3;
        if (i2 <= 0) {
            e();
        }
    }

    private void e() {
        this.i = new int[this.m];
        this.j = new int[this.m];
        int i = 1;
        for (int i2 = 0; i2 < this.m; i2++) {
            this.i[i2] = i;
            i <<= 1;
            if (i >= this.m) {
                i = (i ^ this.n) & (this.m - 1);
            }
        }
        for (int i3 = 0; i3 < this.m - 1; i3++) {
            this.j[this.i[i3]] = i3;
        }
        this.k = new b(this, new int[1]);
        this.l = new b(this, new int[]{1});
        this.p = true;
    }

    private void f() {
        if (!this.p) {
            e();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b a() {
        f();
        return this.k;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b b() {
        f();
        return this.l;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b a(int i, int i2) {
        f();
        if (i < 0) {
            throw new IllegalArgumentException();
        }
        if (i2 == 0) {
            return this.k;
        }
        int[] iArr = new int[i + 1];
        iArr[0] = i2;
        return new b(this, iArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int b(int i, int i2) {
        return i ^ i2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int a(int i) {
        f();
        return this.i[i];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int b(int i) {
        f();
        if (i == 0) {
            throw new IllegalArgumentException();
        }
        return this.j[i];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int c(int i) {
        f();
        if (i == 0) {
            throw new ArithmeticException();
        }
        return this.i[(this.m - this.j[i]) - 1];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int c(int i, int i2) {
        f();
        if (i == 0 || i2 == 0) {
            return 0;
        }
        return this.i[(this.j[i] + this.j[i2]) % (this.m - 1)];
    }

    public int c() {
        return this.m;
    }

    public int d() {
        return this.o;
    }

    public String toString() {
        return "GF(0x" + Integer.toHexString(this.n) + ',' + this.m + ')';
    }
}
