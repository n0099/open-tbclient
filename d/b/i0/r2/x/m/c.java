package d.b.i0.r2.x.m;

import android.text.TextUtils;
import com.baidu.adp.R;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.util.FieldBuilder;
import java.io.FileNotFoundException;
import java.net.SocketException;
import java.net.SocketTimeoutException;
/* loaded from: classes5.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public g f59954a;

    /* renamed from: b  reason: collision with root package name */
    public b f59955b;

    /* renamed from: c  reason: collision with root package name */
    public long f59956c = 0;

    public c(g gVar) {
        this.f59954a = gVar;
    }

    public void a() {
        b bVar = this.f59955b;
        if (bVar != null) {
            bVar.a();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:58:0x01de  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x01e0  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x01ef  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean b(String str, j jVar, int i, int i2, int i3, int i4, boolean z, boolean z2) {
        e eVar;
        int i5;
        int i6;
        e eVar2;
        a b2;
        a b3;
        int i7;
        int b4 = i3 <= 0 ? d.b.b.c.j.b.d().b().b() : i3;
        int a2 = i <= 0 ? d.b.b.c.j.b.d().a() : i;
        int b5 = i4 <= 0 ? d.b.b.c.j.b.d().c().b() : i4;
        this.f59955b = new b(this.f59954a);
        int i8 = 0;
        while (i8 < a2) {
            e eVar3 = new e();
            int i9 = i8 + 1;
            try {
                i7 = b4;
                i5 = b4;
                i6 = i8;
            } catch (FileNotFoundException e2) {
                e = e2;
                eVar2 = eVar3;
                i5 = b4;
                i6 = i8;
            } catch (Exception e3) {
                e = e3;
                eVar = eVar3;
                i5 = b4;
                i6 = i8;
            } catch (Throwable th) {
                th = th;
                eVar = eVar3;
            }
            try {
                boolean c2 = this.f59955b.c(str, jVar, i7, b5, z, eVar3, z2);
                d.b.b.e.e.a.c().g(this.f59954a.a().e(), this.f59954a.a().d("Host"), TextUtils.isEmpty(eVar3.f59970f), eVar3.i != null);
                this.f59954a.d(eVar3);
                a b6 = a.b();
                if (b6 != null) {
                    b6.c(this.f59954a);
                }
                return c2;
            } catch (FileNotFoundException e4) {
                e = e4;
                eVar2 = eVar3;
                this.f59954a.b().f59981b = -100;
                eVar2.f59970f = String.valueOf(this.f59954a.b().f59981b) + "|retryCount:" + i6 + FieldBuilder.SE + e.getClass() + FieldBuilder.SE + e.getMessage();
                this.f59954a.d(eVar2);
                d.b.b.e.e.a.c().g(this.f59954a.a().e(), this.f59954a.a().d("Host"), TextUtils.isEmpty(eVar2.f59970f), eVar2.i != null);
                this.f59954a.d(eVar2);
                b3 = a.b();
                if (b3 == null) {
                    b4 = i5;
                    i8 = i9;
                }
                b3.c(this.f59954a);
                b4 = i5;
                i8 = i9;
            } catch (Exception e5) {
                e = e5;
                eVar = eVar3;
                try {
                    this.f59954a.b().f59981b = -10;
                    eVar.f59970f = String.valueOf(this.f59954a.b().f59981b) + "|retryCount:" + i6 + FieldBuilder.SE + e.getClass() + FieldBuilder.SE + e.getMessage();
                    this.f59954a.d(eVar);
                    d.b.b.e.e.a.c().g(this.f59954a.a().e(), this.f59954a.a().d("Host"), TextUtils.isEmpty(eVar.f59970f), eVar.i != null);
                    this.f59954a.d(eVar);
                    b3 = a.b();
                    if (b3 == null) {
                        b4 = i5;
                        i8 = i9;
                    }
                    b3.c(this.f59954a);
                    b4 = i5;
                    i8 = i9;
                } catch (Throwable th2) {
                    th = th2;
                    d.b.b.e.e.a.c().g(this.f59954a.a().e(), this.f59954a.a().d("Host"), TextUtils.isEmpty(eVar.f59970f), eVar.i == null);
                    this.f59954a.d(eVar);
                    b2 = a.b();
                    if (b2 != null) {
                        b2.c(this.f59954a);
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                eVar = eVar3;
                d.b.b.e.e.a.c().g(this.f59954a.a().e(), this.f59954a.a().d("Host"), TextUtils.isEmpty(eVar.f59970f), eVar.i == null);
                this.f59954a.d(eVar);
                b2 = a.b();
                if (b2 != null) {
                }
                throw th;
            }
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:100:0x0358, code lost:
        if (r0 == null) goto L79;
     */
    /* JADX WARN: Code restructure failed: missing block: B:101:0x035a, code lost:
        r0.c(r16.f59954a);
     */
    /* JADX WARN: Code restructure failed: missing block: B:102:0x035f, code lost:
        r10 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:86:0x02d1, code lost:
        if (r0 == null) goto L79;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void c(int i, int i2, int i3) {
        a b2;
        b bVar;
        a b3;
        b bVar2;
        a b4;
        b bVar3;
        b bVar4;
        b bVar5;
        b bVar6;
        b bVar7;
        int b5 = i2 <= 0 ? d.b.b.c.j.b.d().b().b() : i2;
        int a2 = i <= 0 ? d.b.b.c.j.b.d().a() : i;
        int b6 = i3 <= 0 ? d.b.b.c.j.b.d().c().b() : i3;
        System.currentTimeMillis();
        boolean z = true;
        int i4 = 0;
        for (boolean z2 = true; !this.f59954a.b().f59980a && z == z2 && i4 < a2; z2 = true) {
            e eVar = new e();
            this.f59954a.d(eVar);
            try {
                try {
                    try {
                        b bVar8 = new b(this.f59954a);
                        this.f59955b = bVar8;
                        bVar8.g(b5, b6, eVar);
                    } catch (SocketException e2) {
                        eVar.f59970f = String.valueOf(this.f59954a.b().f59981b) + "|retryCount:" + i4 + FieldBuilder.SE + e2.getClass() + FieldBuilder.SE + e2.getMessage();
                        this.f59954a.b().f59982c = -12;
                        if (this.f59956c <= 0 && (bVar4 = this.f59955b) != null) {
                            this.f59956c = bVar4.f();
                        }
                        System.currentTimeMillis();
                        d.b.b.e.e.a.c().g(this.f59954a.a().e(), this.f59954a.a().d("Host"), TextUtils.isEmpty(eVar.f59970f), eVar.i != null);
                        this.f59954a.e(eVar);
                        b4 = a.b();
                    } catch (SocketTimeoutException e3) {
                        eVar.f59970f = String.valueOf(this.f59954a.b().f59981b) + "|retryCount:" + i4 + FieldBuilder.SE + e3.getClass() + FieldBuilder.SE + e3.getMessage();
                        this.f59954a.b().f59982c = -13;
                        if (this.f59956c <= 0 && (bVar3 = this.f59955b) != null) {
                            this.f59956c = bVar3.f();
                        }
                        System.currentTimeMillis();
                        d.b.b.e.e.a.c().g(this.f59954a.a().e(), this.f59954a.a().d("Host"), TextUtils.isEmpty(eVar.f59970f), eVar.i != null);
                        this.f59954a.e(eVar);
                        b4 = a.b();
                    }
                } catch (IllegalStateException e4) {
                    this.f59954a.b().f59982c = -19;
                    eVar.f59970f = "errorCode:" + String.valueOf(-19) + FieldBuilder.SE + e4.getClass() + FieldBuilder.SE + e4.getMessage() + "|getcontent_illegal_error";
                    if (this.f59956c <= 0 && (bVar2 = this.f59955b) != null) {
                        this.f59956c = bVar2.f();
                    }
                    System.currentTimeMillis();
                    d.b.b.e.e.a.c().g(this.f59954a.a().e(), this.f59954a.a().d("Host"), TextUtils.isEmpty(eVar.f59970f), eVar.i != null);
                    this.f59954a.e(eVar);
                    b3 = a.b();
                    if (b3 == null) {
                    }
                } catch (Exception e5) {
                    eVar.f59970f = String.valueOf(this.f59954a.b().f59981b) + "|retryCount:" + i4 + FieldBuilder.SE + e5.getClass() + FieldBuilder.SE + e5.getMessage();
                    this.f59954a.b().f59982c = -10;
                    BdLog.e(e5.getMessage());
                    if (this.f59956c <= 0 && (bVar = this.f59955b) != null) {
                        this.f59956c = bVar.f();
                    }
                    System.currentTimeMillis();
                    d.b.b.e.e.a.c().g(this.f59954a.a().e(), this.f59954a.a().d("Host"), TextUtils.isEmpty(eVar.f59970f), eVar.i != null);
                    this.f59954a.e(eVar);
                    b2 = a.b();
                    if (b2 == null) {
                        return;
                    }
                }
                if (this.f59954a.b().f59981b != 200) {
                    eVar.f59970f = String.valueOf(this.f59954a.b().f59981b) + "|retryCount:" + i4;
                    z = e(this.f59954a.b().f59981b);
                    if (this.f59956c <= 0 && (bVar7 = this.f59955b) != null) {
                        this.f59956c = bVar7.f();
                    }
                    System.currentTimeMillis();
                    d.b.b.e.e.a.c().g(this.f59954a.a().e(), this.f59954a.a().d("Host"), TextUtils.isEmpty(eVar.f59970f), eVar.i != null);
                    this.f59954a.e(eVar);
                    b3 = a.b();
                    if (b3 == null) {
                        i4++;
                    }
                    b3.c(this.f59954a);
                    i4++;
                } else {
                    this.f59954a.e(eVar);
                    if (this.f59956c <= 0 && (bVar6 = this.f59955b) != null) {
                        this.f59956c = bVar6.f();
                    }
                    System.currentTimeMillis();
                    d.b.b.e.e.a.c().g(this.f59954a.a().e(), this.f59954a.a().d("Host"), TextUtils.isEmpty(eVar.f59970f), eVar.i != null);
                    this.f59954a.e(eVar);
                    b2 = a.b();
                    if (b2 == null) {
                        return;
                    }
                    b2.c(this.f59954a);
                    return;
                }
            } catch (Throwable th) {
                if (this.f59956c <= 0 && (bVar5 = this.f59955b) != null) {
                    this.f59956c = bVar5.f();
                }
                System.currentTimeMillis();
                d.b.b.e.e.a.c().g(this.f59954a.a().e(), this.f59954a.a().d("Host"), TextUtils.isEmpty(eVar.f59970f), eVar.i != null);
                this.f59954a.e(eVar);
                a b7 = a.b();
                if (b7 != null) {
                    b7.c(this.f59954a);
                }
                throw th;
            }
        }
    }

    public boolean d() {
        g gVar = this.f59954a;
        if (gVar == null) {
            return false;
        }
        return gVar.b().f59980a;
    }

    public final boolean e(int i) {
        if (i == 202 || i == 201 || i == 205 || i == 304 || i == 305 || i == 408) {
            return true;
        }
        return (i == 502 || i == 503 || i == 504 || i == 404) ? false : true;
    }

    public void f(int i, int i2, int i3) {
        if (this.f59954a.a().f()) {
            h(i, i2, i3);
        } else {
            g(i, i2, i3);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:82:0x0288, code lost:
        if (r3 == null) goto L61;
     */
    /* JADX WARN: Code restructure failed: missing block: B:96:0x02fe, code lost:
        if (r3 == null) goto L61;
     */
    /* JADX WARN: Code restructure failed: missing block: B:97:0x0300, code lost:
        r3.c(r11.f59954a);
     */
    /* JADX WARN: Code restructure failed: missing block: B:98:0x0305, code lost:
        r3 = true;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void g(int i, int i2, int i3) {
        a b2;
        b bVar;
        b bVar2;
        b bVar3;
        b bVar4;
        b bVar5;
        if (i2 <= 0) {
            i2 = d.b.b.c.j.b.d().b().b();
        }
        if (i <= 0) {
            i = d.b.b.c.j.b.d().a();
        }
        if (i3 <= 0) {
            i3 = d.b.b.c.j.b.d().c().b();
        }
        System.currentTimeMillis();
        boolean z = true;
        int i4 = 0;
        while (!this.f59954a.b().f59980a && z && i4 < i) {
            e eVar = new e();
            int i5 = i4 + 1;
            try {
                try {
                    try {
                        b bVar6 = new b(this.f59954a);
                        this.f59955b = bVar6;
                        bVar6.o(i2, i3, eVar);
                    } catch (SocketTimeoutException e2) {
                        this.f59954a.b().f59982c = -13;
                        eVar.f59970f = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                        BdLog.e(e2.getMessage());
                        this.f59954a.d(eVar);
                        if (this.f59956c <= 0 && (bVar3 = this.f59955b) != null) {
                            this.f59956c = bVar3.f();
                        }
                        System.currentTimeMillis();
                        d.b.b.e.e.a.c().g(this.f59954a.a().e(), this.f59954a.a().d("Host"), TextUtils.isEmpty(eVar.f59970f), eVar.i != null);
                        this.f59954a.d(eVar);
                        b2 = a.b();
                    }
                } catch (UnsupportedOperationException unused) {
                    this.f59954a.b().f59982c = -14;
                    eVar.f59970f = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                    this.f59954a.d(eVar);
                    if (this.f59956c <= 0 && (bVar2 = this.f59955b) != null) {
                        this.f59956c = bVar2.f();
                    }
                    System.currentTimeMillis();
                    d.b.b.e.e.a.c().g(this.f59954a.a().e(), this.f59954a.a().d("Host"), TextUtils.isEmpty(eVar.f59970f), eVar.i != null);
                    this.f59954a.d(eVar);
                    a b3 = a.b();
                    if (b3 != null) {
                        b3.c(this.f59954a);
                    }
                    z = false;
                } catch (SocketException e3) {
                    this.f59954a.b().f59982c = -12;
                    eVar.f59970f = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                    BdLog.e(e3.getMessage());
                    this.f59954a.d(eVar);
                    if (this.f59956c <= 0 && (bVar = this.f59955b) != null) {
                        this.f59956c = bVar.f();
                    }
                    System.currentTimeMillis();
                    d.b.b.e.e.a.c().g(this.f59954a.a().e(), this.f59954a.a().d("Host"), TextUtils.isEmpty(eVar.f59970f), eVar.i != null);
                    this.f59954a.d(eVar);
                    b2 = a.b();
                }
                if (this.f59954a.b().f59981b != 200) {
                    eVar.f59970f = String.valueOf(this.f59954a.b().f59981b) + "|retryCount:" + i4;
                    boolean e4 = e(this.f59954a.b().f59981b);
                    this.f59954a.d(eVar);
                    if (this.f59956c <= 0 && (bVar5 = this.f59955b) != null) {
                        this.f59956c = bVar5.f();
                    }
                    System.currentTimeMillis();
                    d.b.b.e.e.a.c().g(this.f59954a.a().e(), this.f59954a.a().d("Host"), TextUtils.isEmpty(eVar.f59970f), eVar.i != null);
                    this.f59954a.d(eVar);
                    a b4 = a.b();
                    if (b4 != null) {
                        b4.c(this.f59954a);
                    }
                    z = e4;
                    i4 = i5;
                } else {
                    if (this.f59956c <= 0 && (bVar4 = this.f59955b) != null) {
                        this.f59956c = bVar4.f();
                    }
                    System.currentTimeMillis();
                    d.b.b.e.e.a.c().g(this.f59954a.a().e(), this.f59954a.a().d("Host"), TextUtils.isEmpty(eVar.f59970f), eVar.i != null);
                    this.f59954a.d(eVar);
                    a b5 = a.b();
                    if (b5 != null) {
                        b5.c(this.f59954a);
                        return;
                    }
                    return;
                }
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:102:0x02bb, code lost:
        if (r4.m() != false) goto L75;
     */
    /* JADX WARN: Code restructure failed: missing block: B:120:0x033c, code lost:
        if (r4.m() != false) goto L75;
     */
    /* JADX WARN: Code restructure failed: missing block: B:121:0x033e, code lost:
        r3.c(r11.f59954a);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void h(int i, int i2, int i3) {
        a b2;
        b bVar;
        b bVar2;
        b bVar3;
        b bVar4;
        b bVar5;
        b bVar6;
        b bVar7;
        b bVar8;
        if (i2 <= 0) {
            i2 = d.b.b.c.j.b.d().b().b();
        }
        if (i <= 0) {
            i = d.b.b.c.j.b.d().a();
        }
        if (i3 <= 0) {
            i3 = d.b.b.c.j.b.d().c().b();
        }
        System.currentTimeMillis();
        boolean z = true;
        int i4 = 0;
        while (!this.f59954a.b().f59980a && z && i4 < i) {
            e eVar = new e();
            int i5 = i4 + 1;
            try {
                try {
                    try {
                        b bVar9 = new b(this.f59954a);
                        this.f59955b = bVar9;
                        bVar9.n(i2, i3, eVar);
                    } catch (SocketException e2) {
                        this.f59954a.b().f59982c = -12;
                        eVar.f59970f = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                        BdLog.e(e2.getMessage());
                        this.f59954a.d(eVar);
                        if (this.f59956c <= 0 && (bVar4 = this.f59955b) != null) {
                            this.f59956c = bVar4.f();
                        }
                        System.currentTimeMillis();
                        d.b.b.e.e.a.c().g(this.f59954a.a().e(), this.f59954a.a().d("Host"), TextUtils.isEmpty(eVar.f59970f), eVar.i != null);
                        this.f59954a.d(eVar);
                        b2 = a.b();
                        if (b2 != null) {
                            b bVar10 = this.f59955b;
                            if (bVar10 != null) {
                            }
                        }
                        z = true;
                        i4 = i5;
                    }
                } catch (UnsupportedOperationException unused) {
                    this.f59954a.b().f59982c = -14;
                    eVar.f59970f = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                    this.f59954a.d(eVar);
                    if (this.f59956c <= 0 && (bVar3 = this.f59955b) != null) {
                        this.f59956c = bVar3.f();
                    }
                    System.currentTimeMillis();
                    d.b.b.e.e.a.c().g(this.f59954a.a().e(), this.f59954a.a().d("Host"), TextUtils.isEmpty(eVar.f59970f), eVar.i != null);
                    this.f59954a.d(eVar);
                    a b3 = a.b();
                    if (b3 != null && (bVar2 = this.f59955b) != null && bVar2.m()) {
                        b3.c(this.f59954a);
                    }
                    z = false;
                } catch (SocketTimeoutException e3) {
                    this.f59954a.b().f59982c = -13;
                    eVar.f59970f = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                    BdLog.e(e3.getMessage());
                    this.f59954a.d(eVar);
                    if (this.f59956c <= 0 && (bVar = this.f59955b) != null) {
                        this.f59956c = bVar.f();
                    }
                    System.currentTimeMillis();
                    d.b.b.e.e.a.c().g(this.f59954a.a().e(), this.f59954a.a().d("Host"), TextUtils.isEmpty(eVar.f59970f), eVar.i != null);
                    this.f59954a.d(eVar);
                    b2 = a.b();
                    if (b2 != null) {
                        b bVar11 = this.f59955b;
                        if (bVar11 != null) {
                        }
                    }
                    z = true;
                    i4 = i5;
                }
                if (this.f59954a.b().f59981b != 200) {
                    eVar.f59970f = String.valueOf(this.f59954a.b().f59981b) + "|retryCount:" + i4;
                    boolean e4 = e(this.f59954a.b().f59981b);
                    this.f59954a.d(eVar);
                    if (this.f59956c <= 0 && (bVar8 = this.f59955b) != null) {
                        this.f59956c = bVar8.f();
                    }
                    System.currentTimeMillis();
                    d.b.b.e.e.a.c().g(this.f59954a.a().e(), this.f59954a.a().d("Host"), TextUtils.isEmpty(eVar.f59970f), eVar.i != null);
                    this.f59954a.d(eVar);
                    a b4 = a.b();
                    if (b4 != null && (bVar7 = this.f59955b) != null && bVar7.m()) {
                        b4.c(this.f59954a);
                    }
                    z = e4;
                    i4 = i5;
                } else {
                    if (this.f59956c <= 0 && (bVar6 = this.f59955b) != null) {
                        this.f59956c = bVar6.f();
                    }
                    System.currentTimeMillis();
                    d.b.b.e.e.a.c().g(this.f59954a.a().e(), this.f59954a.a().d("Host"), TextUtils.isEmpty(eVar.f59970f), eVar.i != null);
                    this.f59954a.d(eVar);
                    a b5 = a.b();
                    if (b5 == null || (bVar5 = this.f59955b) == null || !bVar5.m()) {
                        return;
                    }
                    b5.c(this.f59954a);
                    return;
                }
            }
        }
    }

    public void i() {
        g gVar = this.f59954a;
        if (gVar == null) {
            return;
        }
        gVar.b().f59980a = true;
    }
}
