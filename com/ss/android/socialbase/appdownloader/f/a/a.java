package com.ss.android.socialbase.appdownloader.f.a;

import androidx.core.internal.view.SupportMenu;
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
    private d qdX;
    private g qdY;
    private boolean c = false;
    private C1230a qdZ = new C1230a();

    public a() {
        g();
    }

    public void a(InputStream inputStream) {
        a();
        if (inputStream != null) {
            this.qdX = new d(inputStream, false);
        }
    }

    public void a() {
        if (this.c) {
            this.c = false;
            this.qdX.a();
            this.qdX = null;
            this.qdY = null;
            this.e = null;
            this.qdZ.a();
            g();
        }
    }

    public int b() throws i, IOException {
        if (this.qdX == null) {
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
        return i2 == -1 ? "" : this.qdY.a(i2);
    }

    public int b(int i) {
        return this.l[e(i) + 3];
    }

    public int c(int i) {
        return this.l[e(i) + 4];
    }

    public String Rl(int i) {
        int e = e(i);
        if (this.l[e + 3] == 3) {
            return this.qdY.a(this.l[e + 2]);
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
        if (this.qdY == null) {
            b.a(this.qdX, 524291);
            this.qdX.c();
            this.qdY = g.a(this.qdX);
            this.qdZ.e();
            this.c = true;
        }
        if (this.h != 1) {
            int i = this.h;
            g();
            while (true) {
                if (this.g) {
                    this.g = false;
                    this.qdZ.f();
                }
                if (i == 3 && this.qdZ.d() == 1 && this.qdZ.b() == 0) {
                    this.h = 1;
                    return;
                }
                int b2 = i == 0 ? 1048834 : this.qdX.b();
                if (b2 == 524672) {
                    int b3 = this.qdX.b();
                    if (b3 < 8 || b3 % 4 != 0) {
                        break;
                    }
                    this.e = this.qdX.b((b3 / 4) - 2);
                } else if (b2 < 1048832 || b2 > 1048836) {
                    break;
                } else if (b2 == 1048834 && i == -1) {
                    this.h = 0;
                    return;
                } else {
                    this.qdX.c();
                    int b4 = this.qdX.b();
                    this.qdX.c();
                    if (b2 == 1048832 || b2 == 1048833) {
                        if (b2 == 1048832) {
                            this.qdZ.a(this.qdX.b(), this.qdX.b());
                        } else {
                            this.qdX.c();
                            this.qdX.c();
                            this.qdZ.c();
                        }
                    } else {
                        this.i = b4;
                        if (b2 == 1048834) {
                            this.k = this.qdX.b();
                            this.j = this.qdX.b();
                            this.qdX.c();
                            int b5 = this.qdX.b();
                            this.m = (b5 >>> 16) - 1;
                            int i2 = b5 & SupportMenu.USER_MASK;
                            this.n = this.qdX.b();
                            this.o = (this.n >>> 16) - 1;
                            this.n = (this.n & SupportMenu.USER_MASK) - 1;
                            this.l = this.qdX.b(i2 * 5);
                            for (int i3 = 3; i3 < this.l.length; i3 += 5) {
                                int[] iArr = this.l;
                                iArr[i3] = iArr[i3] >>> 24;
                            }
                            this.qdZ.e();
                            this.h = 2;
                            return;
                        } else if (b2 == 1048835) {
                            this.k = this.qdX.b();
                            this.j = this.qdX.b();
                            this.h = 3;
                            this.g = true;
                            return;
                        } else if (b2 == 1048836) {
                            this.j = this.qdX.b();
                            this.qdX.c();
                            this.qdX.c();
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
    public static final class C1230a {

        /* renamed from: a  reason: collision with root package name */
        private int[] f13044a = new int[32];

        /* renamed from: b  reason: collision with root package name */
        private int f13045b;
        private int c;

        public final void a() {
            this.f13045b = 0;
            this.c = 0;
        }

        public final int b() {
            if (this.f13045b == 0) {
                return 0;
            }
            return this.f13044a[this.f13045b - 1];
        }

        public final void a(int i, int i2) {
            if (this.c == 0) {
                e();
            }
            a(2);
            int i3 = this.f13045b - 1;
            int i4 = this.f13044a[i3];
            this.f13044a[(i3 - 1) - (i4 * 2)] = i4 + 1;
            this.f13044a[i3] = i;
            this.f13044a[i3 + 1] = i2;
            this.f13044a[i3 + 2] = i4 + 1;
            this.f13045b += 2;
        }

        public final boolean c() {
            int i;
            int i2;
            if (this.f13045b == 0 || (i2 = this.f13044a[this.f13045b - 1]) == 0) {
                return false;
            }
            int i3 = i2 - 1;
            int i4 = i - 2;
            this.f13044a[i4] = i3;
            this.f13044a[i4 - ((i3 * 2) + 1)] = i3;
            this.f13045b -= 2;
            return true;
        }

        public final int d() {
            return this.c;
        }

        public final void e() {
            a(2);
            int i = this.f13045b;
            this.f13044a[i] = 0;
            this.f13044a[i + 1] = 0;
            this.f13045b += 2;
            this.c++;
        }

        public final void f() {
            if (this.f13045b != 0) {
                int i = this.f13045b - 1;
                int i2 = this.f13044a[i];
                if ((i - 1) - (i2 * 2) != 0) {
                    this.f13045b -= (i2 * 2) + 2;
                    this.c--;
                }
            }
        }

        private void a(int i) {
            int length = this.f13044a.length - this.f13045b;
            if (length <= i) {
                int[] iArr = new int[(length + this.f13044a.length) * 2];
                System.arraycopy(this.f13044a, 0, iArr, 0, this.f13045b);
                this.f13044a = iArr;
            }
        }
    }
}
