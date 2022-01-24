package com.ss.android.socialbase.appdownloader.f.a;

import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes4.dex */
public class a implements i {

    /* renamed from: b  reason: collision with root package name */
    public d f59822b;

    /* renamed from: d  reason: collision with root package name */
    public f f59824d;

    /* renamed from: e  reason: collision with root package name */
    public int[] f59825e;

    /* renamed from: g  reason: collision with root package name */
    public boolean f59827g;

    /* renamed from: h  reason: collision with root package name */
    public int f59828h;

    /* renamed from: i  reason: collision with root package name */
    public int f59829i;

    /* renamed from: j  reason: collision with root package name */
    public int f59830j;
    public int k;
    public int[] l;
    public int m;
    public int n;
    public int o;

    /* renamed from: c  reason: collision with root package name */
    public boolean f59823c = false;

    /* renamed from: f  reason: collision with root package name */
    public C2202a f59826f = new C2202a();

    public a() {
        g();
    }

    private final void g() {
        this.f59828h = -1;
        this.f59829i = -1;
        this.f59830j = -1;
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
        if (this.f59824d == null) {
            b.a(this.f59822b, 524291);
            this.f59822b.c();
            this.f59824d = f.a(this.f59822b);
            this.f59826f.e();
            this.f59823c = true;
        }
        int i2 = this.f59828h;
        if (i2 != 1) {
            g();
            while (true) {
                if (this.f59827g) {
                    this.f59827g = false;
                    this.f59826f.f();
                }
                int i3 = 3;
                if (i2 == 3 && this.f59826f.d() == 1 && this.f59826f.b() == 0) {
                    this.f59828h = 1;
                    return;
                }
                int b3 = i2 == 0 ? 1048834 : this.f59822b.b();
                if (b3 == 524672) {
                    b2 = this.f59822b.b();
                    if (b2 < 8 || b2 % 4 != 0) {
                        break;
                    }
                    this.f59825e = this.f59822b.b((b2 / 4) - 2);
                } else if (b3 < 1048832 || b3 > 1048836) {
                    break;
                } else if (b3 == 1048834 && i2 == -1) {
                    this.f59828h = 0;
                    return;
                } else {
                    this.f59822b.c();
                    int b4 = this.f59822b.b();
                    this.f59822b.c();
                    if (b3 != 1048832 && b3 != 1048833) {
                        this.f59829i = b4;
                        if (b3 == 1048834) {
                            this.k = this.f59822b.b();
                            this.f59830j = this.f59822b.b();
                            this.f59822b.c();
                            int b5 = this.f59822b.b();
                            this.m = (b5 >>> 16) - 1;
                            int b6 = this.f59822b.b();
                            this.n = b6;
                            this.o = (b6 >>> 16) - 1;
                            this.n = (65535 & b6) - 1;
                            this.l = this.f59822b.b((b5 & 65535) * 5);
                            while (true) {
                                int[] iArr = this.l;
                                if (i3 < iArr.length) {
                                    iArr[i3] = iArr[i3] >>> 24;
                                    i3 += 5;
                                } else {
                                    this.f59826f.e();
                                    this.f59828h = 2;
                                    return;
                                }
                            }
                        } else if (b3 == 1048835) {
                            this.k = this.f59822b.b();
                            this.f59830j = this.f59822b.b();
                            this.f59828h = 3;
                            this.f59827g = true;
                            return;
                        } else if (b3 == 1048836) {
                            this.f59830j = this.f59822b.b();
                            this.f59822b.c();
                            this.f59822b.c();
                            this.f59828h = 4;
                            return;
                        }
                    } else if (b3 == 1048832) {
                        this.f59826f.a(this.f59822b.b(), this.f59822b.b());
                    } else {
                        this.f59822b.c();
                        this.f59822b.c();
                        this.f59826f.c();
                    }
                }
            }
            throw new IOException("Invalid resource ids size (" + b2 + ").");
        }
    }

    public void a(InputStream inputStream) {
        a();
        if (inputStream != null) {
            this.f59822b = new d(inputStream, false);
        }
    }

    public int b() throws h, IOException {
        if (this.f59822b != null) {
            try {
                h();
                return this.f59828h;
            } catch (IOException e2) {
                a();
                throw e2;
            }
        }
        throw new h("Parser is not opened.", this, null);
    }

    @Override // com.ss.android.socialbase.appdownloader.f.a.g
    public int c() {
        return this.f59829i;
    }

    @Override // com.ss.android.socialbase.appdownloader.f.a.g
    public String d() {
        return "XML line #" + c();
    }

    public int e() {
        if (this.f59828h != 2) {
            return -1;
        }
        return this.l.length / 5;
    }

    @Override // com.ss.android.socialbase.appdownloader.f.a.g
    public int f() {
        return -1;
    }

    /* renamed from: com.ss.android.socialbase.appdownloader.f.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static final class C2202a {
        public int[] a = new int[32];

        /* renamed from: b  reason: collision with root package name */
        public int f59831b;

        /* renamed from: c  reason: collision with root package name */
        public int f59832c;

        public final void a() {
            this.f59831b = 0;
            this.f59832c = 0;
        }

        public final int b() {
            int i2 = this.f59831b;
            if (i2 == 0) {
                return 0;
            }
            return this.a[i2 - 1];
        }

        public final boolean c() {
            int i2;
            int[] iArr;
            int i3;
            int i4 = this.f59831b;
            if (i4 == 0 || (i3 = (iArr = this.a)[i4 - 1]) == 0) {
                return false;
            }
            int i5 = i3 - 1;
            int i6 = i2 - 2;
            iArr[i6] = i5;
            iArr[i6 - ((i5 * 2) + 1)] = i5;
            this.f59831b = i4 - 2;
            return true;
        }

        public final int d() {
            return this.f59832c;
        }

        public final void e() {
            a(2);
            int i2 = this.f59831b;
            int[] iArr = this.a;
            iArr[i2] = 0;
            iArr[i2 + 1] = 0;
            this.f59831b = i2 + 2;
            this.f59832c++;
        }

        public final void f() {
            int i2 = this.f59831b;
            if (i2 != 0) {
                int i3 = i2 - 1;
                int i4 = this.a[i3] * 2;
                if ((i3 - 1) - i4 != 0) {
                    this.f59831b = i2 - (i4 + 2);
                    this.f59832c--;
                }
            }
        }

        public final void a(int i2, int i3) {
            if (this.f59832c == 0) {
                e();
            }
            a(2);
            int i4 = this.f59831b;
            int i5 = i4 - 1;
            int[] iArr = this.a;
            int i6 = iArr[i5];
            int i7 = i6 + 1;
            iArr[(i5 - 1) - (i6 * 2)] = i7;
            iArr[i5] = i2;
            iArr[i5 + 1] = i3;
            iArr[i5 + 2] = i7;
            this.f59831b = i4 + 2;
        }

        private void a(int i2) {
            int[] iArr = this.a;
            int length = iArr.length;
            int i3 = this.f59831b;
            int i4 = length - i3;
            if (i4 <= i2) {
                int[] iArr2 = new int[(iArr.length + i4) * 2];
                System.arraycopy(iArr, 0, iArr2, 0, i3);
                this.a = iArr2;
            }
        }
    }

    private final int e(int i2) {
        if (this.f59828h == 2) {
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
            return this.f59824d.a(iArr[e2 + 2]);
        }
        int i3 = iArr[e2 + 4];
        return "";
    }

    public void a() {
        if (this.f59823c) {
            this.f59823c = false;
            this.f59822b.a();
            this.f59822b = null;
            this.f59824d = null;
            this.f59825e = null;
            this.f59826f.a();
            g();
        }
    }

    public int b(int i2) {
        return this.l[e(i2) + 3];
    }

    public String a(int i2) {
        int i3 = this.l[e(i2) + 1];
        return i3 == -1 ? "" : this.f59824d.a(i3);
    }
}
