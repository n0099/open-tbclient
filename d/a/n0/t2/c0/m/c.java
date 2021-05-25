package d.a.n0.t2.c0.m;

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
    public g f60991a;

    /* renamed from: b  reason: collision with root package name */
    public b f60992b;

    /* renamed from: c  reason: collision with root package name */
    public long f60993c = 0;

    public c(g gVar) {
        this.f60991a = gVar;
    }

    public void a() {
        b bVar = this.f60992b;
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
    public boolean b(String str, j jVar, int i2, int i3, int i4, int i5, boolean z, boolean z2) {
        e eVar;
        int i6;
        int i7;
        e eVar2;
        a b2;
        a b3;
        int i8;
        int b4 = i4 <= 0 ? d.a.c.c.j.b.d().b().b() : i4;
        int a2 = i2 <= 0 ? d.a.c.c.j.b.d().a() : i2;
        int b5 = i5 <= 0 ? d.a.c.c.j.b.d().c().b() : i5;
        this.f60992b = new b(this.f60991a);
        int i9 = 0;
        while (i9 < a2) {
            e eVar3 = new e();
            int i10 = i9 + 1;
            try {
                i8 = b4;
                i6 = b4;
                i7 = i9;
            } catch (FileNotFoundException e2) {
                e = e2;
                eVar2 = eVar3;
                i6 = b4;
                i7 = i9;
            } catch (Exception e3) {
                e = e3;
                eVar = eVar3;
                i6 = b4;
                i7 = i9;
            } catch (Throwable th) {
                th = th;
                eVar = eVar3;
            }
            try {
                boolean c2 = this.f60992b.c(str, jVar, i8, b5, z, eVar3, z2);
                d.a.c.e.e.a.c().g(this.f60991a.a().e(), this.f60991a.a().d("Host"), TextUtils.isEmpty(eVar3.f61007f), eVar3.f61010i != null);
                this.f60991a.d(eVar3);
                a b6 = a.b();
                if (b6 != null) {
                    b6.c(this.f60991a);
                }
                return c2;
            } catch (FileNotFoundException e4) {
                e = e4;
                eVar2 = eVar3;
                this.f60991a.b().f61019b = -100;
                eVar2.f61007f = String.valueOf(this.f60991a.b().f61019b) + "|retryCount:" + i7 + FieldBuilder.SE + e.getClass() + FieldBuilder.SE + e.getMessage();
                this.f60991a.d(eVar2);
                d.a.c.e.e.a.c().g(this.f60991a.a().e(), this.f60991a.a().d("Host"), TextUtils.isEmpty(eVar2.f61007f), eVar2.f61010i != null);
                this.f60991a.d(eVar2);
                b3 = a.b();
                if (b3 == null) {
                    b4 = i6;
                    i9 = i10;
                }
                b3.c(this.f60991a);
                b4 = i6;
                i9 = i10;
            } catch (Exception e5) {
                e = e5;
                eVar = eVar3;
                try {
                    this.f60991a.b().f61019b = -10;
                    eVar.f61007f = String.valueOf(this.f60991a.b().f61019b) + "|retryCount:" + i7 + FieldBuilder.SE + e.getClass() + FieldBuilder.SE + e.getMessage();
                    this.f60991a.d(eVar);
                    d.a.c.e.e.a.c().g(this.f60991a.a().e(), this.f60991a.a().d("Host"), TextUtils.isEmpty(eVar.f61007f), eVar.f61010i != null);
                    this.f60991a.d(eVar);
                    b3 = a.b();
                    if (b3 == null) {
                        b4 = i6;
                        i9 = i10;
                    }
                    b3.c(this.f60991a);
                    b4 = i6;
                    i9 = i10;
                } catch (Throwable th2) {
                    th = th2;
                    d.a.c.e.e.a.c().g(this.f60991a.a().e(), this.f60991a.a().d("Host"), TextUtils.isEmpty(eVar.f61007f), eVar.f61010i == null);
                    this.f60991a.d(eVar);
                    b2 = a.b();
                    if (b2 != null) {
                        b2.c(this.f60991a);
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                eVar = eVar3;
                d.a.c.e.e.a.c().g(this.f60991a.a().e(), this.f60991a.a().d("Host"), TextUtils.isEmpty(eVar.f61007f), eVar.f61010i == null);
                this.f60991a.d(eVar);
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
        r0.c(r16.f60991a);
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
    public void c(int i2, int i3, int i4) {
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
        int b5 = i3 <= 0 ? d.a.c.c.j.b.d().b().b() : i3;
        int a2 = i2 <= 0 ? d.a.c.c.j.b.d().a() : i2;
        int b6 = i4 <= 0 ? d.a.c.c.j.b.d().c().b() : i4;
        System.currentTimeMillis();
        boolean z = true;
        int i5 = 0;
        for (boolean z2 = true; !this.f60991a.b().f61018a && z == z2 && i5 < a2; z2 = true) {
            e eVar = new e();
            this.f60991a.d(eVar);
            try {
                try {
                    try {
                        b bVar8 = new b(this.f60991a);
                        this.f60992b = bVar8;
                        bVar8.g(b5, b6, eVar);
                    } catch (SocketException e2) {
                        eVar.f61007f = String.valueOf(this.f60991a.b().f61019b) + "|retryCount:" + i5 + FieldBuilder.SE + e2.getClass() + FieldBuilder.SE + e2.getMessage();
                        this.f60991a.b().f61020c = -12;
                        if (this.f60993c <= 0 && (bVar4 = this.f60992b) != null) {
                            this.f60993c = bVar4.f();
                        }
                        System.currentTimeMillis();
                        d.a.c.e.e.a.c().g(this.f60991a.a().e(), this.f60991a.a().d("Host"), TextUtils.isEmpty(eVar.f61007f), eVar.f61010i != null);
                        this.f60991a.e(eVar);
                        b4 = a.b();
                    } catch (SocketTimeoutException e3) {
                        eVar.f61007f = String.valueOf(this.f60991a.b().f61019b) + "|retryCount:" + i5 + FieldBuilder.SE + e3.getClass() + FieldBuilder.SE + e3.getMessage();
                        this.f60991a.b().f61020c = -13;
                        if (this.f60993c <= 0 && (bVar3 = this.f60992b) != null) {
                            this.f60993c = bVar3.f();
                        }
                        System.currentTimeMillis();
                        d.a.c.e.e.a.c().g(this.f60991a.a().e(), this.f60991a.a().d("Host"), TextUtils.isEmpty(eVar.f61007f), eVar.f61010i != null);
                        this.f60991a.e(eVar);
                        b4 = a.b();
                    }
                } catch (IllegalStateException e4) {
                    this.f60991a.b().f61020c = -19;
                    eVar.f61007f = "errorCode:" + String.valueOf(-19) + FieldBuilder.SE + e4.getClass() + FieldBuilder.SE + e4.getMessage() + "|getcontent_illegal_error";
                    if (this.f60993c <= 0 && (bVar2 = this.f60992b) != null) {
                        this.f60993c = bVar2.f();
                    }
                    System.currentTimeMillis();
                    d.a.c.e.e.a.c().g(this.f60991a.a().e(), this.f60991a.a().d("Host"), TextUtils.isEmpty(eVar.f61007f), eVar.f61010i != null);
                    this.f60991a.e(eVar);
                    b3 = a.b();
                    if (b3 == null) {
                    }
                } catch (Exception e5) {
                    eVar.f61007f = String.valueOf(this.f60991a.b().f61019b) + "|retryCount:" + i5 + FieldBuilder.SE + e5.getClass() + FieldBuilder.SE + e5.getMessage();
                    this.f60991a.b().f61020c = -10;
                    BdLog.e(e5.getMessage());
                    if (this.f60993c <= 0 && (bVar = this.f60992b) != null) {
                        this.f60993c = bVar.f();
                    }
                    System.currentTimeMillis();
                    d.a.c.e.e.a.c().g(this.f60991a.a().e(), this.f60991a.a().d("Host"), TextUtils.isEmpty(eVar.f61007f), eVar.f61010i != null);
                    this.f60991a.e(eVar);
                    b2 = a.b();
                    if (b2 == null) {
                        return;
                    }
                }
                if (this.f60991a.b().f61019b != 200) {
                    eVar.f61007f = String.valueOf(this.f60991a.b().f61019b) + "|retryCount:" + i5;
                    z = e(this.f60991a.b().f61019b);
                    if (this.f60993c <= 0 && (bVar7 = this.f60992b) != null) {
                        this.f60993c = bVar7.f();
                    }
                    System.currentTimeMillis();
                    d.a.c.e.e.a.c().g(this.f60991a.a().e(), this.f60991a.a().d("Host"), TextUtils.isEmpty(eVar.f61007f), eVar.f61010i != null);
                    this.f60991a.e(eVar);
                    b3 = a.b();
                    if (b3 == null) {
                        i5++;
                    }
                    b3.c(this.f60991a);
                    i5++;
                } else {
                    this.f60991a.e(eVar);
                    if (this.f60993c <= 0 && (bVar6 = this.f60992b) != null) {
                        this.f60993c = bVar6.f();
                    }
                    System.currentTimeMillis();
                    d.a.c.e.e.a.c().g(this.f60991a.a().e(), this.f60991a.a().d("Host"), TextUtils.isEmpty(eVar.f61007f), eVar.f61010i != null);
                    this.f60991a.e(eVar);
                    b2 = a.b();
                    if (b2 == null) {
                        return;
                    }
                    b2.c(this.f60991a);
                    return;
                }
            } catch (Throwable th) {
                if (this.f60993c <= 0 && (bVar5 = this.f60992b) != null) {
                    this.f60993c = bVar5.f();
                }
                System.currentTimeMillis();
                d.a.c.e.e.a.c().g(this.f60991a.a().e(), this.f60991a.a().d("Host"), TextUtils.isEmpty(eVar.f61007f), eVar.f61010i != null);
                this.f60991a.e(eVar);
                a b7 = a.b();
                if (b7 != null) {
                    b7.c(this.f60991a);
                }
                throw th;
            }
        }
    }

    public boolean d() {
        g gVar = this.f60991a;
        if (gVar == null) {
            return false;
        }
        return gVar.b().f61018a;
    }

    public final boolean e(int i2) {
        if (i2 == 202 || i2 == 201 || i2 == 205 || i2 == 304 || i2 == 305 || i2 == 408) {
            return true;
        }
        return (i2 == 502 || i2 == 503 || i2 == 504 || i2 == 404) ? false : true;
    }

    public void f(int i2, int i3, int i4) {
        if (this.f60991a.a().f()) {
            h(i2, i3, i4);
        } else {
            g(i2, i3, i4);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:82:0x0288, code lost:
        if (r3 == null) goto L61;
     */
    /* JADX WARN: Code restructure failed: missing block: B:96:0x02fe, code lost:
        if (r3 == null) goto L61;
     */
    /* JADX WARN: Code restructure failed: missing block: B:97:0x0300, code lost:
        r3.c(r11.f60991a);
     */
    /* JADX WARN: Code restructure failed: missing block: B:98:0x0305, code lost:
        r3 = true;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void g(int i2, int i3, int i4) {
        a b2;
        b bVar;
        b bVar2;
        b bVar3;
        b bVar4;
        b bVar5;
        if (i3 <= 0) {
            i3 = d.a.c.c.j.b.d().b().b();
        }
        if (i2 <= 0) {
            i2 = d.a.c.c.j.b.d().a();
        }
        if (i4 <= 0) {
            i4 = d.a.c.c.j.b.d().c().b();
        }
        System.currentTimeMillis();
        boolean z = true;
        int i5 = 0;
        while (!this.f60991a.b().f61018a && z && i5 < i2) {
            e eVar = new e();
            int i6 = i5 + 1;
            try {
                try {
                    try {
                        b bVar6 = new b(this.f60991a);
                        this.f60992b = bVar6;
                        bVar6.o(i3, i4, eVar);
                    } catch (SocketTimeoutException e2) {
                        this.f60991a.b().f61020c = -13;
                        eVar.f61007f = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                        BdLog.e(e2.getMessage());
                        this.f60991a.d(eVar);
                        if (this.f60993c <= 0 && (bVar3 = this.f60992b) != null) {
                            this.f60993c = bVar3.f();
                        }
                        System.currentTimeMillis();
                        d.a.c.e.e.a.c().g(this.f60991a.a().e(), this.f60991a.a().d("Host"), TextUtils.isEmpty(eVar.f61007f), eVar.f61010i != null);
                        this.f60991a.d(eVar);
                        b2 = a.b();
                    }
                } catch (UnsupportedOperationException unused) {
                    this.f60991a.b().f61020c = -14;
                    eVar.f61007f = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                    this.f60991a.d(eVar);
                    if (this.f60993c <= 0 && (bVar2 = this.f60992b) != null) {
                        this.f60993c = bVar2.f();
                    }
                    System.currentTimeMillis();
                    d.a.c.e.e.a.c().g(this.f60991a.a().e(), this.f60991a.a().d("Host"), TextUtils.isEmpty(eVar.f61007f), eVar.f61010i != null);
                    this.f60991a.d(eVar);
                    a b3 = a.b();
                    if (b3 != null) {
                        b3.c(this.f60991a);
                    }
                    z = false;
                } catch (SocketException e3) {
                    this.f60991a.b().f61020c = -12;
                    eVar.f61007f = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                    BdLog.e(e3.getMessage());
                    this.f60991a.d(eVar);
                    if (this.f60993c <= 0 && (bVar = this.f60992b) != null) {
                        this.f60993c = bVar.f();
                    }
                    System.currentTimeMillis();
                    d.a.c.e.e.a.c().g(this.f60991a.a().e(), this.f60991a.a().d("Host"), TextUtils.isEmpty(eVar.f61007f), eVar.f61010i != null);
                    this.f60991a.d(eVar);
                    b2 = a.b();
                }
                if (this.f60991a.b().f61019b != 200) {
                    eVar.f61007f = String.valueOf(this.f60991a.b().f61019b) + "|retryCount:" + i5;
                    boolean e4 = e(this.f60991a.b().f61019b);
                    this.f60991a.d(eVar);
                    if (this.f60993c <= 0 && (bVar5 = this.f60992b) != null) {
                        this.f60993c = bVar5.f();
                    }
                    System.currentTimeMillis();
                    d.a.c.e.e.a.c().g(this.f60991a.a().e(), this.f60991a.a().d("Host"), TextUtils.isEmpty(eVar.f61007f), eVar.f61010i != null);
                    this.f60991a.d(eVar);
                    a b4 = a.b();
                    if (b4 != null) {
                        b4.c(this.f60991a);
                    }
                    z = e4;
                    i5 = i6;
                } else {
                    if (this.f60993c <= 0 && (bVar4 = this.f60992b) != null) {
                        this.f60993c = bVar4.f();
                    }
                    System.currentTimeMillis();
                    d.a.c.e.e.a.c().g(this.f60991a.a().e(), this.f60991a.a().d("Host"), TextUtils.isEmpty(eVar.f61007f), eVar.f61010i != null);
                    this.f60991a.d(eVar);
                    a b5 = a.b();
                    if (b5 != null) {
                        b5.c(this.f60991a);
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
        r3.c(r11.f60991a);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void h(int i2, int i3, int i4) {
        a b2;
        b bVar;
        b bVar2;
        b bVar3;
        b bVar4;
        b bVar5;
        b bVar6;
        b bVar7;
        b bVar8;
        if (i3 <= 0) {
            i3 = d.a.c.c.j.b.d().b().b();
        }
        if (i2 <= 0) {
            i2 = d.a.c.c.j.b.d().a();
        }
        if (i4 <= 0) {
            i4 = d.a.c.c.j.b.d().c().b();
        }
        System.currentTimeMillis();
        boolean z = true;
        int i5 = 0;
        while (!this.f60991a.b().f61018a && z && i5 < i2) {
            e eVar = new e();
            int i6 = i5 + 1;
            try {
                try {
                    try {
                        b bVar9 = new b(this.f60991a);
                        this.f60992b = bVar9;
                        bVar9.n(i3, i4, eVar);
                    } catch (SocketException e2) {
                        this.f60991a.b().f61020c = -12;
                        eVar.f61007f = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                        BdLog.e(e2.getMessage());
                        this.f60991a.d(eVar);
                        if (this.f60993c <= 0 && (bVar4 = this.f60992b) != null) {
                            this.f60993c = bVar4.f();
                        }
                        System.currentTimeMillis();
                        d.a.c.e.e.a.c().g(this.f60991a.a().e(), this.f60991a.a().d("Host"), TextUtils.isEmpty(eVar.f61007f), eVar.f61010i != null);
                        this.f60991a.d(eVar);
                        b2 = a.b();
                        if (b2 != null) {
                            b bVar10 = this.f60992b;
                            if (bVar10 != null) {
                            }
                        }
                        z = true;
                        i5 = i6;
                    }
                } catch (UnsupportedOperationException unused) {
                    this.f60991a.b().f61020c = -14;
                    eVar.f61007f = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                    this.f60991a.d(eVar);
                    if (this.f60993c <= 0 && (bVar3 = this.f60992b) != null) {
                        this.f60993c = bVar3.f();
                    }
                    System.currentTimeMillis();
                    d.a.c.e.e.a.c().g(this.f60991a.a().e(), this.f60991a.a().d("Host"), TextUtils.isEmpty(eVar.f61007f), eVar.f61010i != null);
                    this.f60991a.d(eVar);
                    a b3 = a.b();
                    if (b3 != null && (bVar2 = this.f60992b) != null && bVar2.m()) {
                        b3.c(this.f60991a);
                    }
                    z = false;
                } catch (SocketTimeoutException e3) {
                    this.f60991a.b().f61020c = -13;
                    eVar.f61007f = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                    BdLog.e(e3.getMessage());
                    this.f60991a.d(eVar);
                    if (this.f60993c <= 0 && (bVar = this.f60992b) != null) {
                        this.f60993c = bVar.f();
                    }
                    System.currentTimeMillis();
                    d.a.c.e.e.a.c().g(this.f60991a.a().e(), this.f60991a.a().d("Host"), TextUtils.isEmpty(eVar.f61007f), eVar.f61010i != null);
                    this.f60991a.d(eVar);
                    b2 = a.b();
                    if (b2 != null) {
                        b bVar11 = this.f60992b;
                        if (bVar11 != null) {
                        }
                    }
                    z = true;
                    i5 = i6;
                }
                if (this.f60991a.b().f61019b != 200) {
                    eVar.f61007f = String.valueOf(this.f60991a.b().f61019b) + "|retryCount:" + i5;
                    boolean e4 = e(this.f60991a.b().f61019b);
                    this.f60991a.d(eVar);
                    if (this.f60993c <= 0 && (bVar8 = this.f60992b) != null) {
                        this.f60993c = bVar8.f();
                    }
                    System.currentTimeMillis();
                    d.a.c.e.e.a.c().g(this.f60991a.a().e(), this.f60991a.a().d("Host"), TextUtils.isEmpty(eVar.f61007f), eVar.f61010i != null);
                    this.f60991a.d(eVar);
                    a b4 = a.b();
                    if (b4 != null && (bVar7 = this.f60992b) != null && bVar7.m()) {
                        b4.c(this.f60991a);
                    }
                    z = e4;
                    i5 = i6;
                } else {
                    if (this.f60993c <= 0 && (bVar6 = this.f60992b) != null) {
                        this.f60993c = bVar6.f();
                    }
                    System.currentTimeMillis();
                    d.a.c.e.e.a.c().g(this.f60991a.a().e(), this.f60991a.a().d("Host"), TextUtils.isEmpty(eVar.f61007f), eVar.f61010i != null);
                    this.f60991a.d(eVar);
                    a b5 = a.b();
                    if (b5 == null || (bVar5 = this.f60992b) == null || !bVar5.m()) {
                        return;
                    }
                    b5.c(this.f60991a);
                    return;
                }
            }
        }
    }

    public void i() {
        g gVar = this.f60991a;
        if (gVar == null) {
            return;
        }
        gVar.b().f61018a = true;
    }
}
