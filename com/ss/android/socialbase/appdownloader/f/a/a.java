package com.ss.android.socialbase.appdownloader.f.a;

import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes8.dex */
public class a implements i {

    /* renamed from: b  reason: collision with root package name */
    public d f58339b;

    /* renamed from: d  reason: collision with root package name */
    public f f58341d;

    /* renamed from: e  reason: collision with root package name */
    public int[] f58342e;

    /* renamed from: g  reason: collision with root package name */
    public boolean f58344g;

    /* renamed from: h  reason: collision with root package name */
    public int f58345h;

    /* renamed from: i  reason: collision with root package name */
    public int f58346i;

    /* renamed from: j  reason: collision with root package name */
    public int f58347j;
    public int k;
    public int[] l;
    public int m;
    public int n;
    public int o;

    /* renamed from: c  reason: collision with root package name */
    public boolean f58340c = false;

    /* renamed from: f  reason: collision with root package name */
    public C2191a f58343f = new C2191a();

    public a() {
        g();
    }

    private final void g() {
        this.f58345h = -1;
        this.f58346i = -1;
        this.f58347j = -1;
        this.k = -1;
        this.l = null;
        this.m = -1;
        this.n = -1;
        this.o = -1;
    }

    /* JADX WARN: Code restructure failed: missing block: B:62:0x018e, code lost:
        throw new java.io.IOException("Invalid chunk type (" + r5 + ").");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void h() throws IOException {
        int b2;
        if (this.f58341d == null) {
            b.a(this.f58339b, 524291);
            this.f58339b.c();
            this.f58341d = f.a(this.f58339b);
            this.f58343f.e();
            this.f58340c = true;
        }
        int i2 = this.f58345h;
        if (i2 != 1) {
            g();
            while (true) {
                if (this.f58344g) {
                    this.f58344g = false;
                    this.f58343f.f();
                }
                int i3 = 3;
                if (i2 == 3 && this.f58343f.d() == 1 && this.f58343f.b() == 0) {
                    this.f58345h = 1;
                    return;
                }
                int b3 = i2 == 0 ? 1048834 : this.f58339b.b();
                if (b3 == 524672) {
                    b2 = this.f58339b.b();
                    if (b2 < 8 || b2 % 4 != 0) {
                        break;
                    }
                    this.f58342e = this.f58339b.b((b2 / 4) - 2);
                } else if (b3 < 1048832 || b3 > 1048836) {
                    break;
                } else if (b3 == 1048834 && i2 == -1) {
                    this.f58345h = 0;
                    return;
                } else {
                    this.f58339b.c();
                    int b4 = this.f58339b.b();
                    this.f58339b.c();
                    if (b3 != 1048832 && b3 != 1048833) {
                        this.f58346i = b4;
                        if (b3 == 1048834) {
                            this.k = this.f58339b.b();
                            this.f58347j = this.f58339b.b();
                            this.f58339b.c();
                            int b5 = this.f58339b.b();
                            this.m = (b5 >>> 16) - 1;
                            int b6 = this.f58339b.b();
                            this.n = b6;
                            this.o = (b6 >>> 16) - 1;
                            this.n = (65535 & b6) - 1;
                            this.l = this.f58339b.b((b5 & 65535) * 5);
                            while (true) {
                                int[] iArr = this.l;
                                if (i3 < iArr.length) {
                                    iArr[i3] = iArr[i3] >>> 24;
                                    i3 += 5;
                                } else {
                                    this.f58343f.e();
                                    this.f58345h = 2;
                                    return;
                                }
                            }
                        } else if (b3 == 1048835) {
                            this.k = this.f58339b.b();
                            this.f58347j = this.f58339b.b();
                            this.f58345h = 3;
                            this.f58344g = true;
                            return;
                        } else if (b3 == 1048836) {
                            this.f58347j = this.f58339b.b();
                            this.f58339b.c();
                            this.f58339b.c();
                            this.f58345h = 4;
                            return;
                        }
                    } else if (b3 == 1048832) {
                        this.f58343f.a(this.f58339b.b(), this.f58339b.b());
                    } else {
                        this.f58339b.c();
                        this.f58339b.c();
                        this.f58343f.c();
                    }
                }
            }
            throw new IOException("Invalid resource ids size (" + b2 + ").");
        }
    }

    public void a(InputStream inputStream) {
        a();
        if (inputStream != null) {
            this.f58339b = new d(inputStream, false);
        }
    }

    public int b() throws h, IOException {
        if (this.f58339b != null) {
            try {
                h();
                return this.f58345h;
            } catch (IOException e2) {
                a();
                throw e2;
            }
        }
        throw new h("Parser is not opened.", this, null);
    }

    @Override // com.ss.android.socialbase.appdownloader.f.a.g
    public int c() {
        return this.f58346i;
    }

    @Override // com.ss.android.socialbase.appdownloader.f.a.g
    public String d() {
        return "XML line #" + c();
    }

    public int e() {
        if (this.f58345h != 2) {
            return -1;
        }
        return this.l.length / 5;
    }

    @Override // com.ss.android.socialbase.appdownloader.f.a.g
    public int f() {
        return -1;
    }

    /* renamed from: com.ss.android.socialbase.appdownloader.f.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static final class C2191a {
        public int[] a = new int[32];

        /* renamed from: b  reason: collision with root package name */
        public int f58348b;

        /* renamed from: c  reason: collision with root package name */
        public int f58349c;

        public final void a() {
            this.f58348b = 0;
            this.f58349c = 0;
        }

        public final int b() {
            int i2 = this.f58348b;
            if (i2 == 0) {
                return 0;
            }
            return this.a[i2 - 1];
        }

        public final boolean c() {
            int i2;
            int[] iArr;
            int i3;
            int i4 = this.f58348b;
            if (i4 == 0 || (i3 = (iArr = this.a)[i4 - 1]) == 0) {
                return false;
            }
            int i5 = i3 - 1;
            int i6 = i2 - 2;
            iArr[i6] = i5;
            iArr[i6 - ((i5 * 2) + 1)] = i5;
            this.f58348b = i4 - 2;
            return true;
        }

        public final int d() {
            return this.f58349c;
        }

        public final void e() {
            a(2);
            int i2 = this.f58348b;
            int[] iArr = this.a;
            iArr[i2] = 0;
            iArr[i2 + 1] = 0;
            this.f58348b = i2 + 2;
            this.f58349c++;
        }

        public final void f() {
            int i2 = this.f58348b;
            if (i2 != 0) {
                int i3 = i2 - 1;
                int i4 = this.a[i3] * 2;
                if ((i3 - 1) - i4 != 0) {
                    this.f58348b = i2 - (i4 + 2);
                    this.f58349c--;
                }
            }
        }

        public final void a(int i2, int i3) {
            if (this.f58349c == 0) {
                e();
            }
            a(2);
            int i4 = this.f58348b;
            int i5 = i4 - 1;
            int[] iArr = this.a;
            int i6 = iArr[i5];
            int i7 = i6 + 1;
            iArr[(i5 - 1) - (i6 * 2)] = i7;
            iArr[i5] = i2;
            iArr[i5 + 1] = i3;
            iArr[i5 + 2] = i7;
            this.f58348b = i4 + 2;
        }

        private void a(int i2) {
            int[] iArr = this.a;
            int length = iArr.length;
            int i3 = this.f58348b;
            int i4 = length - i3;
            if (i4 <= i2) {
                int[] iArr2 = new int[(iArr.length + i4) * 2];
                System.arraycopy(iArr, 0, iArr2, 0, i3);
                this.a = iArr2;
            }
        }
    }

    private final int e(int i2) {
        if (this.f58345h == 2) {
            int i3 = i2 * 5;
            if (i3 < this.l.length) {
                return i3;
            }
            throw new IndexOutOfBoundsException("Invalid attribute index (" + i2 + ").");
        }
        throw new IndexOutOfBoundsException("Current event is not START_TAG.");
    }

    public int c(int i2) {
        return this.l[e(i2) + 4];
    }

    public String d(int i2) {
        int e2 = e(i2);
        int[] iArr = this.l;
        if (iArr[e2 + 3] == 3) {
            return this.f58341d.a(iArr[e2 + 2]);
        }
        int i3 = iArr[e2 + 4];
        return "";
    }

    public void a() {
        if (this.f58340c) {
            this.f58340c = false;
            this.f58339b.a();
            this.f58339b = null;
            this.f58341d = null;
            this.f58342e = null;
            this.f58343f.a();
            g();
        }
    }

    public int b(int i2) {
        return this.l[e(i2) + 3];
    }

    public String a(int i2) {
        int i3 = this.l[e(i2) + 1];
        return i3 == -1 ? "" : this.f58341d.a(i3);
    }
}
