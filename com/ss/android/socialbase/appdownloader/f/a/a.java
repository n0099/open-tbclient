package com.ss.android.socialbase.appdownloader.f.a;

import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes6.dex */
class a implements j {
    private int[] e;
    private boolean g;
    private int h;
    private int i;
    private int j;
    private int k;
    private int[] l;
    private int m;
    private int n;
    private int o;
    private d qfm;
    private g qfn;
    private boolean c = false;
    private C1222a qfo = new C1222a();

    public a() {
        g();
    }

    public void a(InputStream inputStream) {
        a();
        if (inputStream != null) {
            this.qfm = new d(inputStream, false);
        }
    }

    public void a() {
        if (this.c) {
            this.c = false;
            this.qfm.a();
            this.qfm = null;
            this.qfn = null;
            this.e = null;
            this.qfo.a();
            g();
        }
    }

    public int b() throws i, IOException {
        if (this.qfm == null) {
            throw new i("Parser is not opened.", this, null);
        }
        try {
            h();
            return this.h;
        } catch (IOException e) {
            a();
            throw e;
        }
    }

    @Override // com.ss.android.socialbase.appdownloader.f.a.h
    public int c() {
        return this.i;
    }

    @Override // com.ss.android.socialbase.appdownloader.f.a.h
    public String d() {
        return "XML line #" + c();
    }

    public int e() {
        if (this.h != 2) {
            return -1;
        }
        return this.l.length / 5;
    }

    public String a(int i) {
        int i2 = this.l[e(i) + 1];
        return i2 == -1 ? "" : this.qfn.a(i2);
    }

    public int b(int i) {
        return this.l[e(i) + 3];
    }

    public int c(int i) {
        return this.l[e(i) + 4];
    }

    public String Rq(int i) {
        int e = e(i);
        if (this.l[e + 3] == 3) {
            return this.qfn.a(this.l[e + 2]);
        }
        int i2 = this.l[e + 4];
        return "";
    }

    @Override // com.ss.android.socialbase.appdownloader.f.a.h
    public int f() {
        return -1;
    }

    private final int e(int i) {
        if (this.h != 2) {
            throw new IndexOutOfBoundsException("Current event is not START_TAG.");
        }
        int i2 = i * 5;
        if (i2 >= this.l.length) {
            throw new IndexOutOfBoundsException("Invalid attribute index (" + i + ").");
        }
        return i2;
    }

    private final void g() {
        this.h = -1;
        this.i = -1;
        this.j = -1;
        this.k = -1;
        this.l = null;
        this.m = -1;
        this.n = -1;
        this.o = -1;
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x009c, code lost:
        throw new java.io.IOException("Invalid resource ids size (" + r1 + ").");
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x00c4, code lost:
        throw new java.io.IOException("Invalid chunk type (" + r1 + ").");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void h() throws IOException {
        if (this.qfn == null) {
            b.a(this.qfm, 524291);
            this.qfm.c();
            this.qfn = g.a(this.qfm);
            this.qfo.e();
            this.c = true;
        }
        if (this.h != 1) {
            int i = this.h;
            g();
            while (true) {
                if (this.g) {
                    this.g = false;
                    this.qfo.f();
                }
                if (i == 3 && this.qfo.d() == 1 && this.qfo.b() == 0) {
                    this.h = 1;
                    return;
                }
                int b = i == 0 ? 1048834 : this.qfm.b();
                if (b == 524672) {
                    int b2 = this.qfm.b();
                    if (b2 < 8 || b2 % 4 != 0) {
                        break;
                    }
                    this.e = this.qfm.b((b2 / 4) - 2);
                } else if (b < 1048832 || b > 1048836) {
                    break;
                } else if (b == 1048834 && i == -1) {
                    this.h = 0;
                    return;
                } else {
                    this.qfm.c();
                    int b3 = this.qfm.b();
                    this.qfm.c();
                    if (b == 1048832 || b == 1048833) {
                        if (b == 1048832) {
                            this.qfo.a(this.qfm.b(), this.qfm.b());
                        } else {
                            this.qfm.c();
                            this.qfm.c();
                            this.qfo.c();
                        }
                    } else {
                        this.i = b3;
                        if (b == 1048834) {
                            this.k = this.qfm.b();
                            this.j = this.qfm.b();
                            this.qfm.c();
                            int b4 = this.qfm.b();
                            this.m = (b4 >>> 16) - 1;
                            this.n = this.qfm.b();
                            this.o = (this.n >>> 16) - 1;
                            this.n = (this.n & 65535) - 1;
                            this.l = this.qfm.b((b4 & 65535) * 5);
                            for (int i2 = 3; i2 < this.l.length; i2 += 5) {
                                int[] iArr = this.l;
                                iArr[i2] = iArr[i2] >>> 24;
                            }
                            this.qfo.e();
                            this.h = 2;
                            return;
                        } else if (b == 1048835) {
                            this.k = this.qfm.b();
                            this.j = this.qfm.b();
                            this.h = 3;
                            this.g = true;
                            return;
                        } else if (b == 1048836) {
                            this.j = this.qfm.b();
                            this.qfm.c();
                            this.qfm.c();
                            this.h = 4;
                            return;
                        }
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.ss.android.socialbase.appdownloader.f.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static final class C1222a {

        /* renamed from: a  reason: collision with root package name */
        private int[] f7763a = new int[32];
        private int b;
        private int c;

        public final void a() {
            this.b = 0;
            this.c = 0;
        }

        public final int b() {
            if (this.b == 0) {
                return 0;
            }
            return this.f7763a[this.b - 1];
        }

        public final void a(int i, int i2) {
            if (this.c == 0) {
                e();
            }
            a(2);
            int i3 = this.b - 1;
            int i4 = this.f7763a[i3];
            this.f7763a[(i3 - 1) - (i4 * 2)] = i4 + 1;
            this.f7763a[i3] = i;
            this.f7763a[i3 + 1] = i2;
            this.f7763a[i3 + 2] = i4 + 1;
            this.b += 2;
        }

        public final boolean c() {
            int i;
            int i2;
            if (this.b == 0 || (i2 = this.f7763a[this.b - 1]) == 0) {
                return false;
            }
            int i3 = i2 - 1;
            int i4 = i - 2;
            this.f7763a[i4] = i3;
            this.f7763a[i4 - ((i3 * 2) + 1)] = i3;
            this.b -= 2;
            return true;
        }

        public final int d() {
            return this.c;
        }

        public final void e() {
            a(2);
            int i = this.b;
            this.f7763a[i] = 0;
            this.f7763a[i + 1] = 0;
            this.b += 2;
            this.c++;
        }

        public final void f() {
            if (this.b != 0) {
                int i = this.b - 1;
                int i2 = this.f7763a[i];
                if ((i - 1) - (i2 * 2) != 0) {
                    this.b -= (i2 * 2) + 2;
                    this.c--;
                }
            }
        }

        private void a(int i) {
            int length = this.f7763a.length - this.b;
            if (length <= i) {
                int[] iArr = new int[(length + this.f7763a.length) * 2];
                System.arraycopy(this.f7763a, 0, iArr, 0, this.b);
                this.f7763a = iArr;
            }
        }
    }
}
