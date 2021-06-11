package d.a.c.e.j.a;

import android.text.TextUtils;
import com.baidu.adp.R;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.util.BdLog;
import d.a.c.e.p.j;
import d.a.c.e.p.k;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.ConnectException;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import javax.net.ssl.SSLException;
/* loaded from: classes.dex */
public class c {

    /* renamed from: f  reason: collision with root package name */
    public static boolean f42268f = true;

    /* renamed from: a  reason: collision with root package name */
    public e f42269a;

    /* renamed from: b  reason: collision with root package name */
    public b f42270b;

    /* renamed from: c  reason: collision with root package name */
    public int f42271c = 0;

    /* renamed from: d  reason: collision with root package name */
    public long f42272d = 0;

    /* renamed from: e  reason: collision with root package name */
    public boolean f42273e = true;

    public c(e eVar) {
        this.f42269a = eVar;
    }

    public final void a(int i2) {
        try {
            if (this.f42269a == null || i2 <= 0) {
                return;
            }
            this.f42269a.b().a("Retry-Count", String.valueOf(i2));
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
        }
    }

    public void b() {
        b bVar = this.f42270b;
        if (bVar != null) {
            bVar.b();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:112:0x03c5, code lost:
        if (r0 == null) goto L135;
     */
    /* JADX WARN: Code restructure failed: missing block: B:135:0x04c8, code lost:
        if (r0 == null) goto L135;
     */
    /* JADX WARN: Code restructure failed: missing block: B:136:0x04ca, code lost:
        r0.c(r23.f42269a);
     */
    /* JADX WARN: Code restructure failed: missing block: B:137:0x04cf, code lost:
        r10 = r27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x024b, code lost:
        if (r0 == null) goto L135;
     */
    /* JADX WARN: Code restructure failed: missing block: B:97:0x0308, code lost:
        if (r0 == null) goto L135;
     */
    /* JADX WARN: Removed duplicated region for block: B:217:0x08b6  */
    /* JADX WARN: Removed duplicated region for block: B:218:0x08b8  */
    /* JADX WARN: Removed duplicated region for block: B:226:0x0901  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean c(String str, h hVar, int i2, int i3, int i4, int i5, boolean z, boolean z2) {
        d dVar;
        int i6;
        int i7;
        String str2;
        int i8;
        d dVar2;
        d dVar3;
        d dVar4;
        d dVar5;
        String str3;
        d dVar6;
        d dVar7;
        d dVar8;
        d dVar9;
        a b2;
        a b3;
        a b4;
        String str4 = "responseCode:";
        int b5 = i4 <= 0 ? d.a.c.c.j.b.d().b().b() : i4;
        int b6 = i5 <= 0 ? d.a.c.c.j.b.d().c().b() : i5;
        b bVar = new b(this.f42269a);
        this.f42270b = bVar;
        bVar.u(f42268f);
        int i9 = 0;
        boolean z3 = false;
        for (int a2 = i2 <= 0 ? d.a.c.c.j.b.d().a() : i2; i9 < a2; a2 = i7) {
            d dVar10 = new d();
            this.f42269a.c().f42296c = -1;
            this.f42270b.s(i9);
            int i10 = i9 + 1;
            try {
                try {
                    dVar10.f42278e = i10;
                    try {
                        this.f42271c = i9;
                        a(i9);
                        str2 = str4;
                        i8 = i10;
                        i6 = i9;
                        i7 = a2;
                    } catch (IllegalStateException e2) {
                        e = e2;
                        str2 = str4;
                        i8 = i10;
                        dVar9 = dVar10;
                        i6 = i9;
                        i7 = a2;
                    } catch (ConnectException e3) {
                        e = e3;
                        str2 = str4;
                        i8 = i10;
                        dVar8 = dVar10;
                        i6 = i9;
                        i7 = a2;
                    } catch (SocketException e4) {
                        e = e4;
                        str2 = str4;
                        i8 = i10;
                        dVar7 = dVar10;
                        i6 = i9;
                        i7 = a2;
                    } catch (SocketTimeoutException e5) {
                        e = e5;
                        str2 = str4;
                        i8 = i10;
                        dVar6 = dVar10;
                        i6 = i9;
                        i7 = a2;
                    }
                } catch (IllegalStateException e6) {
                    e = e6;
                    str3 = str4;
                    i8 = i10;
                    dVar9 = dVar10;
                    i6 = i9;
                    i7 = a2;
                } catch (ConnectException e7) {
                    e = e7;
                    str3 = str4;
                    i8 = i10;
                    dVar8 = dVar10;
                    i6 = i9;
                    i7 = a2;
                } catch (SocketException e8) {
                    e = e8;
                    str3 = str4;
                    i8 = i10;
                    dVar7 = dVar10;
                    i6 = i9;
                    i7 = a2;
                } catch (SocketTimeoutException e9) {
                    e = e9;
                    str3 = str4;
                    i8 = i10;
                    dVar6 = dVar10;
                    i6 = i9;
                    i7 = a2;
                }
            } catch (FileNotFoundException e10) {
                e = e10;
                str2 = str4;
                i8 = i10;
                dVar5 = dVar10;
                i6 = i9;
                i7 = a2;
            } catch (UnknownHostException e11) {
                e = e11;
                str2 = str4;
                i8 = i10;
                dVar4 = dVar10;
                i6 = i9;
                i7 = a2;
            } catch (SSLException e12) {
                e = e12;
                str2 = str4;
                i8 = i10;
                dVar3 = dVar10;
                i6 = i9;
                i7 = a2;
            } catch (IOException e13) {
                e = e13;
                str2 = str4;
                i8 = i10;
                dVar2 = dVar10;
                i6 = i9;
                i7 = a2;
            } catch (Exception e14) {
                e = e14;
                str2 = str4;
                i8 = i10;
                dVar = dVar10;
                i6 = i9;
                i7 = a2;
            } catch (Throwable th) {
                th = th;
                dVar = dVar10;
                i6 = i9;
                i7 = a2;
            }
            try {
                z3 = this.f42270b.d(str, hVar, b5, b6, z, dVar10, z2);
                if (!z3 && this.f42269a.c().f42294a) {
                    this.f42269a.c().f42296c = -14;
                }
                d.a.c.e.e.a.c().g(this.f42269a.b().i(), this.f42269a.b().g("Host"), TextUtils.isEmpty(dVar10.f42281h), dVar10.l != null);
                if (!z3 && i6 == i7 - 1) {
                    dVar10.f42281h += "|" + d.a.c.e.j.a.j.d.c();
                    dVar10.f42281h += "|netAvailable:" + j.A();
                }
                this.f42269a.e(dVar10);
                a b7 = a.b();
                if (b7 != null) {
                    b7.c(this.f42269a);
                }
                return z3;
            } catch (FileNotFoundException e15) {
                e = e15;
                dVar5 = dVar10;
                StringBuilder sb = new StringBuilder();
                str3 = str2;
                sb.append(str3);
                sb.append(String.valueOf(this.f42269a.c().f42295b));
                sb.append("|retryCount:");
                sb.append(i6);
                sb.append("|");
                sb.append(e.getClass().getName());
                sb.append("|");
                sb.append(e.getMessage());
                dVar5.f42281h = sb.toString();
                this.f42269a.c().f42296c = -100;
                d.a.c.e.e.a.c().g(this.f42269a.b().i(), this.f42269a.b().g("Host"), TextUtils.isEmpty(dVar5.f42281h), dVar5.l != null);
                if (!z3 && i6 == i7 - 1) {
                    dVar5.f42281h += "|" + d.a.c.e.j.a.j.d.c();
                    dVar5.f42281h += "|netAvailable:" + j.A();
                }
                this.f42269a.e(dVar5);
                b4 = a.b();
                if (b4 == null) {
                    str4 = str3;
                    i9 = i8;
                }
                b4.c(this.f42269a);
                str4 = str3;
                i9 = i8;
            } catch (IllegalStateException e16) {
                e = e16;
                dVar9 = dVar10;
                str3 = str2;
                dVar9.f42281h = str3 + String.valueOf(this.f42269a.c().f42295b) + "|retryCount:" + i6 + "|" + e.getClass().getName() + "|" + e.getMessage() + "|getcontent_illegal_error";
                this.f42269a.c().f42296c = -19;
                d.a.c.e.e.a.c().g(this.f42269a.b().i(), this.f42269a.b().g("Host"), TextUtils.isEmpty(dVar9.f42281h), dVar9.l != null);
                if (!z3 && i6 == i7 - 1) {
                    dVar9.f42281h += "|" + d.a.c.e.j.a.j.d.c();
                    dVar9.f42281h += "|netAvailable:" + j.A();
                }
                this.f42269a.e(dVar9);
                b4 = a.b();
                if (b4 == null) {
                    str4 = str3;
                    i9 = i8;
                }
                b4.c(this.f42269a);
                str4 = str3;
                i9 = i8;
            } catch (ConnectException e17) {
                e = e17;
                dVar8 = dVar10;
                str3 = str2;
                dVar8.f42281h = str3 + String.valueOf(this.f42269a.c().f42295b) + "|retryCount:" + i6 + "|" + e.getClass().getName() + "|" + e.getMessage();
                this.f42269a.c().f42296c = -22;
                d.a.c.e.e.a.c().g(this.f42269a.b().i(), this.f42269a.b().g("Host"), TextUtils.isEmpty(dVar8.f42281h), dVar8.l != null);
                if (!z3 && i6 == i7 - 1) {
                    dVar8.f42281h += "|" + d.a.c.e.j.a.j.d.c();
                    dVar8.f42281h += "|netAvailable:" + j.A();
                }
                this.f42269a.e(dVar8);
                b4 = a.b();
                if (b4 == null) {
                    str4 = str3;
                    i9 = i8;
                }
                b4.c(this.f42269a);
                str4 = str3;
                i9 = i8;
            } catch (SocketException e18) {
                e = e18;
                dVar7 = dVar10;
                str3 = str2;
                dVar7.f42281h = str3 + String.valueOf(this.f42269a.c().f42295b) + "|retryCount:" + i6 + "|" + e.getClass().getName() + "|" + e.getMessage();
                this.f42269a.c().f42296c = -12;
                d.a.c.e.e.a.c().g(this.f42269a.b().i(), this.f42269a.b().g("Host"), TextUtils.isEmpty(dVar7.f42281h), dVar7.l != null);
                if (!z3 && i6 == i7 - 1) {
                    dVar7.f42281h += "|" + d.a.c.e.j.a.j.d.c();
                    dVar7.f42281h += "|netAvailable:" + j.A();
                }
                this.f42269a.e(dVar7);
                b4 = a.b();
                if (b4 == null) {
                    str4 = str3;
                    i9 = i8;
                }
                b4.c(this.f42269a);
                str4 = str3;
                i9 = i8;
            } catch (SocketTimeoutException e19) {
                e = e19;
                dVar6 = dVar10;
                str3 = str2;
                dVar6.f42281h = str3 + String.valueOf(this.f42269a.c().f42295b) + "|retryCount:" + i6 + "|" + e.getClass().getName() + "|" + e.getMessage();
                this.f42269a.c().f42296c = -13;
                d.a.c.e.e.a.c().g(this.f42269a.b().i(), this.f42269a.b().g("Host"), TextUtils.isEmpty(dVar6.f42281h), dVar6.l != null);
                if (!z3 && i6 == i7 - 1) {
                    dVar6.f42281h += "|" + d.a.c.e.j.a.j.d.c();
                    dVar6.f42281h += "|netAvailable:" + j.A();
                }
                this.f42269a.e(dVar6);
                b4 = a.b();
                if (b4 == null) {
                    str4 = str3;
                    i9 = i8;
                }
                b4.c(this.f42269a);
                str4 = str3;
                i9 = i8;
            } catch (UnknownHostException e20) {
                e = e20;
                dVar4 = dVar10;
                dVar4.f42281h = "errorCode:" + String.valueOf(this.f42269a.c().f42295b) + "|retryCount:" + i6 + "|" + e.getClass().getName() + "|" + e.getMessage();
                this.f42269a.c().f42296c = -21;
                d.a.c.e.e.a.c().g(this.f42269a.b().i(), this.f42269a.b().g("Host"), TextUtils.isEmpty(dVar4.f42281h), dVar4.l != null);
                if (!z3 && i6 == i7 - 1) {
                    dVar4.f42281h += "|" + d.a.c.e.j.a.j.d.c();
                    dVar4.f42281h += "|netAvailable:" + j.A();
                }
                this.f42269a.e(dVar4);
                b3 = a.b();
            } catch (SSLException e21) {
                e = e21;
                dVar3 = dVar10;
                if (this.f42269a.b().e() && i6 < i7 - 1) {
                    String b8 = d.a.c.e.j.a.j.d.b(this.f42269a.b().i());
                    if (!k.isEmpty(b8)) {
                        this.f42269a.b().s(b8);
                    }
                    BdStatisticsManager.getInstance().eventStat(null, "c13429", "", 1, "obj_type", "1");
                } else {
                    dVar3.f42281h = "errorCode:" + String.valueOf(this.f42269a.c().f42295b) + "|retryCount:" + i6 + "|" + e.getClass().getName() + "|" + e.getMessage();
                    this.f42269a.c().f42296c = -20;
                }
                d.a.c.e.e.a.c().g(this.f42269a.b().i(), this.f42269a.b().g("Host"), TextUtils.isEmpty(dVar3.f42281h), dVar3.l != null);
                if (!z3 && i6 == i7 - 1) {
                    dVar3.f42281h += "|" + d.a.c.e.j.a.j.d.c();
                    dVar3.f42281h += "|netAvailable:" + j.A();
                }
                this.f42269a.e(dVar3);
                b3 = a.b();
            } catch (IOException e22) {
                e = e22;
                dVar2 = dVar10;
                dVar2.f42281h = "errorCode:" + String.valueOf(this.f42269a.c().f42295b) + "|retryCount:" + i6 + "|" + e.getClass().getName() + "|" + e.getMessage();
                this.f42269a.c().f42296c = -19;
                d.a.c.e.e.a.c().g(this.f42269a.b().i(), this.f42269a.b().g("Host"), TextUtils.isEmpty(dVar2.f42281h), dVar2.l != null);
                if (!z3 && i6 == i7 - 1) {
                    dVar2.f42281h += "|" + d.a.c.e.j.a.j.d.c();
                    dVar2.f42281h += "|netAvailable:" + j.A();
                }
                this.f42269a.e(dVar2);
                b3 = a.b();
            } catch (Exception e23) {
                e = e23;
                dVar = dVar10;
                try {
                    dVar.f42281h = "errorCode:" + String.valueOf(this.f42269a.c().f42295b) + "|retryCount:" + i6 + "|" + e.getClass().getName() + "|" + e.getMessage();
                    this.f42269a.c().f42296c = -10;
                    BdLog.e(e.getMessage());
                    d.a.c.e.e.a.c().g(this.f42269a.b().i(), this.f42269a.b().g("Host"), TextUtils.isEmpty(dVar.f42281h), dVar.l != null);
                    if (!z3 && i6 == i7 - 1) {
                        dVar.f42281h += "|" + d.a.c.e.j.a.j.d.c();
                        dVar.f42281h += "|netAvailable:" + j.A();
                    }
                    this.f42269a.e(dVar);
                    b3 = a.b();
                } catch (Throwable th2) {
                    th = th2;
                    d.a.c.e.e.a.c().g(this.f42269a.b().i(), this.f42269a.b().g("Host"), TextUtils.isEmpty(dVar.f42281h), dVar.l == null);
                    if (!z3 && i6 == i7 - 1) {
                        dVar.f42281h += "|" + d.a.c.e.j.a.j.d.c();
                        dVar.f42281h += "|netAvailable:" + j.A();
                    }
                    this.f42269a.e(dVar);
                    b2 = a.b();
                    if (b2 != null) {
                        b2.c(this.f42269a);
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                dVar = dVar10;
                d.a.c.e.e.a.c().g(this.f42269a.b().i(), this.f42269a.b().g("Host"), TextUtils.isEmpty(dVar.f42281h), dVar.l == null);
                if (!z3) {
                    dVar.f42281h += "|" + d.a.c.e.j.a.j.d.c();
                    dVar.f42281h += "|netAvailable:" + j.A();
                }
                this.f42269a.e(dVar);
                b2 = a.b();
                if (b2 != null) {
                }
                throw th;
            }
        }
        return z3;
    }

    public boolean d(String str, h hVar, int i2, int i3, int i4, boolean z) {
        return c(str, hVar, i2, -1, i3, i4, false, z);
    }

    /* JADX WARN: Code restructure failed: missing block: B:105:0x03a2, code lost:
        if (r0 == null) goto L93;
     */
    /* JADX WARN: Code restructure failed: missing block: B:106:0x03a4, code lost:
        r0.c(r19.f42269a);
     */
    /* JADX WARN: Code restructure failed: missing block: B:107:0x03a9, code lost:
        r12 = 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:90:0x0313, code lost:
        if (r0 == null) goto L93;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void e(int i2, int i3, int i4) {
        int i5;
        b bVar;
        a b2;
        b bVar2;
        b bVar3;
        a b3;
        b bVar4;
        b bVar5;
        b bVar6;
        b bVar7;
        int b4 = i3 <= 0 ? d.a.c.c.j.b.d().b().b() : i3;
        int a2 = i2 <= 0 ? d.a.c.c.j.b.d().a() : i2;
        int b5 = i4 <= 0 ? d.a.c.c.j.b.d().c().b() : i4;
        long currentTimeMillis = System.currentTimeMillis();
        int i6 = true;
        int i7 = 0;
        for (int i8 = 1; !this.f42269a.c().f42294a && i6 == i8 && i7 < a2; i8 = 1) {
            d dVar = new d();
            this.f42269a.e(dVar);
            try {
                try {
                    try {
                        try {
                            this.f42271c = i7;
                            dVar.f42278e = i7 + 1;
                            dVar.v = i8;
                            a(i7);
                            b bVar8 = new b(this.f42269a);
                            this.f42270b = bVar8;
                            bVar8.s(i7);
                            this.f42270b.u(f42268f);
                            this.f42270b.k(b4, b5, dVar);
                        } catch (Exception e2) {
                            dVar.f42281h = String.valueOf(this.f42269a.c().f42295b) + "|retryCount:" + i7 + "|" + e2.getClass() + "|" + e2.getMessage();
                            this.f42269a.c().f42296c = -10;
                            BdLog.e(e2.getMessage());
                            if (this.f42272d <= 0 && (bVar4 = this.f42270b) != null) {
                                this.f42272d = bVar4.i();
                            }
                            dVar.f42279f = System.currentTimeMillis() - currentTimeMillis;
                            d.a.c.e.e.a.c().g(this.f42269a.b().i(), this.f42269a.b().g("Host"), TextUtils.isEmpty(dVar.f42281h), dVar.l != null);
                            this.f42269a.f(dVar);
                            b3 = a.b();
                            if (b3 == null) {
                                return;
                            }
                        }
                    } catch (SocketTimeoutException e3) {
                        i5 = b4;
                        dVar.f42281h = String.valueOf(this.f42269a.c().f42295b) + "|retryCount:" + i7 + "|" + e3.getClass() + "|" + e3.getMessage();
                        this.f42269a.c().f42296c = -13;
                        if (this.f42272d <= 0 && (bVar3 = this.f42270b) != null) {
                            this.f42272d = bVar3.i();
                        }
                        dVar.f42279f = System.currentTimeMillis() - currentTimeMillis;
                        d.a.c.e.e.a.c().g(this.f42269a.b().i(), this.f42269a.b().g("Host"), TextUtils.isEmpty(dVar.f42281h), dVar.l != null);
                        this.f42269a.f(dVar);
                        b2 = a.b();
                    }
                } catch (SocketException e4) {
                    i5 = b4;
                    dVar.f42281h = String.valueOf(this.f42269a.c().f42295b) + "|retryCount:" + i7 + "|" + e4.getClass() + "|" + e4.getMessage();
                    this.f42269a.c().f42296c = -12;
                    if (this.f42272d <= 0 && (bVar2 = this.f42270b) != null) {
                        this.f42272d = bVar2.i();
                    }
                    dVar.f42279f = System.currentTimeMillis() - currentTimeMillis;
                    d.a.c.e.e.a.c().g(this.f42269a.b().i(), this.f42269a.b().g("Host"), TextUtils.isEmpty(dVar.f42281h), dVar.l != null);
                    this.f42269a.f(dVar);
                    b2 = a.b();
                } catch (IOException e5) {
                    this.f42269a.c().f42296c = -19;
                    dVar.f42281h = "errorCode:" + String.valueOf(-19) + "|" + e5.getClass() + "|" + e5.getMessage() + "|getcontent_illegal_error";
                    if (this.f42272d <= 0 && (bVar = this.f42270b) != null) {
                        this.f42272d = bVar.i();
                    }
                    dVar.f42279f = System.currentTimeMillis() - currentTimeMillis;
                    i5 = b4;
                    d.a.c.e.e.a.c().g(this.f42269a.b().i(), this.f42269a.b().g("Host"), TextUtils.isEmpty(dVar.f42281h), dVar.l != null);
                    this.f42269a.f(dVar);
                    a b6 = a.b();
                    if (b6 != null) {
                        b6.c(this.f42269a);
                    }
                }
                if (this.f42269a.c().f42295b != 200) {
                    dVar.f42281h = String.valueOf(this.f42269a.c().f42295b) + "|retryCount:" + i7;
                    boolean m = m(this.f42269a.c().f42295b);
                    if (this.f42272d <= 0 && (bVar7 = this.f42270b) != null) {
                        this.f42272d = bVar7.i();
                    }
                    dVar.f42279f = System.currentTimeMillis() - currentTimeMillis;
                    d.a.c.e.e.a.c().g(this.f42269a.b().i(), this.f42269a.b().g("Host"), TextUtils.isEmpty(dVar.f42281h), dVar.l != null);
                    this.f42269a.f(dVar);
                    a b7 = a.b();
                    if (b7 != null) {
                        b7.c(this.f42269a);
                    }
                    i6 = m;
                    i5 = b4;
                    i7++;
                    b4 = i5;
                } else {
                    this.f42269a.f(dVar);
                    if (this.f42272d <= 0 && (bVar6 = this.f42270b) != null) {
                        this.f42272d = bVar6.i();
                    }
                    dVar.f42279f = System.currentTimeMillis() - currentTimeMillis;
                    d.a.c.e.e.a.c().g(this.f42269a.b().i(), this.f42269a.b().g("Host"), TextUtils.isEmpty(dVar.f42281h), dVar.l != null);
                    this.f42269a.f(dVar);
                    b3 = a.b();
                    if (b3 == null) {
                        return;
                    }
                    b3.c(this.f42269a);
                    return;
                }
            } catch (Throwable th) {
                if (this.f42272d <= 0 && (bVar5 = this.f42270b) != null) {
                    this.f42272d = bVar5.i();
                }
                dVar.f42279f = System.currentTimeMillis() - currentTimeMillis;
                d.a.c.e.e.a.c().g(this.f42269a.b().i(), this.f42269a.b().g("Host"), TextUtils.isEmpty(dVar.f42281h), dVar.l != null);
                this.f42269a.f(dVar);
                a b8 = a.b();
                if (b8 != null) {
                    b8.c(this.f42269a);
                }
                throw th;
            }
        }
    }

    public long f() {
        b bVar = this.f42270b;
        if (bVar == null) {
            return -1L;
        }
        return bVar.e();
    }

    public long g() {
        b bVar = this.f42270b;
        if (bVar == null) {
            return -1L;
        }
        return bVar.h();
    }

    public long h() {
        long j = this.f42272d;
        if (j > 0) {
            return j;
        }
        b bVar = this.f42270b;
        if (bVar == null) {
            return -1L;
        }
        return bVar.i();
    }

    public long i() {
        b bVar = this.f42270b;
        if (bVar == null) {
            return -1L;
        }
        return bVar.l();
    }

    public long j() {
        b bVar = this.f42270b;
        if (bVar == null) {
            return -1L;
        }
        return bVar.j();
    }

    public int k() {
        return this.f42271c;
    }

    public boolean l() {
        e eVar = this.f42269a;
        if (eVar == null) {
            return false;
        }
        return eVar.c().f42294a;
    }

    public final boolean m(int i2) {
        if (i2 == 202 || i2 == 201 || i2 == 205 || i2 == 304 || i2 == 305 || i2 == 408) {
            return true;
        }
        return (i2 == 502 || i2 == 503 || i2 == 504 || i2 == 404) ? false : true;
    }

    public void n(int i2, int i3, int i4) {
        if (this.f42269a.b().j()) {
            p(i2, i3, i4);
        } else {
            o(i2, i3, i4);
        }
    }

    /* JADX DEBUG: Finally have unexpected throw blocks count: 0, expect 1 */
    /* JADX WARN: Code restructure failed: missing block: B:100:0x0342, code lost:
        r0.c(r16.f42269a);
     */
    /* JADX WARN: Code restructure failed: missing block: B:101:0x0347, code lost:
        r0 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x01d2, code lost:
        if (r0 == null) goto L62;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x0244, code lost:
        if (r0 == null) goto L62;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x0246, code lost:
        r0.c(r16.f42269a);
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x024b, code lost:
        r0 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x02c5, code lost:
        if (r0 == null) goto L77;
     */
    /* JADX WARN: Code restructure failed: missing block: B:99:0x0340, code lost:
        if (r0 == null) goto L77;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void o(int i2, int i3, int i4) {
        a b2;
        b bVar;
        a b3;
        b bVar2;
        b bVar3;
        b bVar4;
        b bVar5;
        b bVar6;
        b bVar7;
        int b4 = i3 <= 0 ? d.a.c.c.j.b.d().b().b() : i3;
        int a2 = i2 <= 0 ? d.a.c.c.j.b.d().a() : i2;
        int b5 = i4 <= 0 ? d.a.c.c.j.b.d().c().b() : i4;
        long currentTimeMillis = System.currentTimeMillis();
        boolean z = true;
        int i5 = 0;
        for (boolean z2 = true; !this.f42269a.c().f42294a && z == z2 && i5 < a2; z2 = true) {
            d dVar = new d();
            this.f42271c = i5;
            int i6 = i5 + 1;
            dVar.f42278e = i6;
            a(i5);
            try {
                try {
                    b bVar8 = new b(this.f42269a);
                    this.f42270b = bVar8;
                    bVar8.s(i5);
                    this.f42270b.u(f42268f);
                    this.f42270b.t(this.f42273e);
                    this.f42270b.r(b4, b5, dVar);
                } catch (UnsupportedOperationException unused) {
                    this.f42269a.c().f42296c = -14;
                    dVar.f42281h = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                    this.f42269a.e(dVar);
                    if (this.f42272d <= 0 && (bVar5 = this.f42270b) != null) {
                        this.f42272d = bVar5.i();
                    }
                    dVar.f42279f = System.currentTimeMillis() - currentTimeMillis;
                    d.a.c.e.e.a.c().g(this.f42269a.b().i(), this.f42269a.b().g("Host"), TextUtils.isEmpty(dVar.f42281h), dVar.l != null);
                    this.f42269a.e(dVar);
                    b2 = a.b();
                } catch (SocketTimeoutException e2) {
                    this.f42269a.c().f42296c = -13;
                    dVar.f42281h = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                    BdLog.e(e2.getMessage());
                    this.f42269a.e(dVar);
                    if (this.f42272d <= 0 && (bVar4 = this.f42270b) != null) {
                        this.f42272d = bVar4.i();
                    }
                    dVar.f42279f = System.currentTimeMillis() - currentTimeMillis;
                    d.a.c.e.e.a.c().g(this.f42269a.b().i(), this.f42269a.b().g("Host"), TextUtils.isEmpty(dVar.f42281h), dVar.l != null);
                    this.f42269a.e(dVar);
                    b3 = a.b();
                }
            } catch (SocketException e3) {
                this.f42269a.c().f42296c = -12;
                dVar.f42281h = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                BdLog.e(e3.getMessage());
                this.f42269a.e(dVar);
                if (this.f42272d <= 0 && (bVar2 = this.f42270b) != null) {
                    this.f42272d = bVar2.i();
                }
                dVar.f42279f = System.currentTimeMillis() - currentTimeMillis;
                d.a.c.e.e.a.c().g(this.f42269a.b().i(), this.f42269a.b().g("Host"), TextUtils.isEmpty(dVar.f42281h), dVar.l != null);
                this.f42269a.e(dVar);
                b3 = a.b();
            } catch (Throwable th) {
                try {
                    this.f42269a.c().f42296c = -10;
                    dVar.f42281h = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                    BdLog.e(th.getMessage());
                    this.f42269a.e(dVar);
                    if (this.f42272d <= 0 && (bVar = this.f42270b) != null) {
                        this.f42272d = bVar.i();
                    }
                    dVar.f42279f = System.currentTimeMillis() - currentTimeMillis;
                    d.a.c.e.e.a.c().g(this.f42269a.b().i(), this.f42269a.b().g("Host"), TextUtils.isEmpty(dVar.f42281h), dVar.l != null);
                    this.f42269a.e(dVar);
                    b2 = a.b();
                } catch (Throwable th2) {
                    if (this.f42272d <= 0 && (bVar3 = this.f42270b) != null) {
                        this.f42272d = bVar3.i();
                    }
                    dVar.f42279f = System.currentTimeMillis() - currentTimeMillis;
                    d.a.c.e.e.a.c().g(this.f42269a.b().i(), this.f42269a.b().g("Host"), TextUtils.isEmpty(dVar.f42281h), dVar.l != null);
                    this.f42269a.e(dVar);
                    a b6 = a.b();
                    if (b6 != null) {
                        b6.c(this.f42269a);
                    }
                    throw th2;
                }
            }
            if (this.f42269a.c().f42295b != 200) {
                dVar.f42281h = String.valueOf(this.f42269a.c().f42295b) + "|retryCount:" + i5;
                z = m(this.f42269a.c().f42295b);
                this.f42269a.e(dVar);
                if (this.f42272d <= 0 && (bVar7 = this.f42270b) != null) {
                    this.f42272d = bVar7.i();
                }
                dVar.f42279f = System.currentTimeMillis() - currentTimeMillis;
                d.a.c.e.e.a.c().g(this.f42269a.b().i(), this.f42269a.b().g("Host"), TextUtils.isEmpty(dVar.f42281h), dVar.l != null);
                this.f42269a.e(dVar);
                a b7 = a.b();
                if (b7 != null) {
                    b7.c(this.f42269a);
                }
                i5 = i6;
            } else {
                if (this.f42272d <= 0 && (bVar6 = this.f42270b) != null) {
                    this.f42272d = bVar6.i();
                }
                dVar.f42279f = System.currentTimeMillis() - currentTimeMillis;
                d.a.c.e.e.a.c().g(this.f42269a.b().i(), this.f42269a.b().g("Host"), TextUtils.isEmpty(dVar.f42281h), dVar.l != null);
                this.f42269a.e(dVar);
                a b8 = a.b();
                if (b8 != null) {
                    b8.c(this.f42269a);
                    return;
                }
                return;
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:105:0x02f1, code lost:
        if (r8.p() != false) goto L99;
     */
    /* JADX WARN: Code restructure failed: missing block: B:123:0x0376, code lost:
        if (r8.p() != false) goto L99;
     */
    /* JADX WARN: Code restructure failed: missing block: B:124:0x0378, code lost:
        r0.c(r16.f42269a);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void p(int i2, int i3, int i4) {
        a b2;
        b bVar;
        b bVar2;
        b bVar3;
        b bVar4;
        b bVar5;
        b bVar6;
        b bVar7;
        b bVar8;
        int b3 = i3 <= 0 ? d.a.c.c.j.b.d().b().b() : i3;
        int a2 = i2 <= 0 ? d.a.c.c.j.b.d().a() : i2;
        int b4 = i4 <= 0 ? d.a.c.c.j.b.d().c().b() : i4;
        long currentTimeMillis = System.currentTimeMillis();
        boolean z = true;
        int i5 = 0;
        for (boolean z2 = true; !this.f42269a.c().f42294a && z == z2 && i5 < a2; z2 = true) {
            d dVar = new d();
            int i6 = i5 + 1;
            dVar.f42278e = i6;
            this.f42271c = i5;
            a(i5);
            try {
                try {
                    try {
                        b bVar9 = new b(this.f42269a);
                        this.f42270b = bVar9;
                        bVar9.s(i5);
                        this.f42270b.u(f42268f);
                        this.f42270b.q(b3, b4, dVar);
                    } catch (UnsupportedOperationException unused) {
                        this.f42269a.c().f42296c = -14;
                        dVar.f42281h = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                        this.f42269a.e(dVar);
                        if (this.f42272d <= 0 && (bVar4 = this.f42270b) != null) {
                            this.f42272d = bVar4.i();
                        }
                        dVar.f42279f = System.currentTimeMillis() - currentTimeMillis;
                        d.a.c.e.e.a.c().g(this.f42269a.b().i(), this.f42269a.b().g("Host"), TextUtils.isEmpty(dVar.f42281h), dVar.l != null);
                        this.f42269a.e(dVar);
                        a b5 = a.b();
                        if (b5 != null && (bVar3 = this.f42270b) != null && bVar3.p()) {
                            b5.c(this.f42269a);
                        }
                        z = false;
                    }
                } catch (SocketException e2) {
                    this.f42269a.c().f42296c = -12;
                    dVar.f42281h = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                    BdLog.e(e2.getMessage());
                    this.f42269a.e(dVar);
                    if (this.f42272d <= 0 && (bVar2 = this.f42270b) != null) {
                        this.f42272d = bVar2.i();
                    }
                    dVar.f42279f = System.currentTimeMillis() - currentTimeMillis;
                    d.a.c.e.e.a.c().g(this.f42269a.b().i(), this.f42269a.b().g("Host"), TextUtils.isEmpty(dVar.f42281h), dVar.l != null);
                    this.f42269a.e(dVar);
                    b2 = a.b();
                    if (b2 != null) {
                        b bVar10 = this.f42270b;
                        if (bVar10 != null) {
                        }
                    }
                    z = true;
                    i5 = i6;
                } catch (SocketTimeoutException e3) {
                    this.f42269a.c().f42296c = -13;
                    dVar.f42281h = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                    BdLog.e(e3.getMessage());
                    this.f42269a.e(dVar);
                    if (this.f42272d <= 0 && (bVar = this.f42270b) != null) {
                        this.f42272d = bVar.i();
                    }
                    dVar.f42279f = System.currentTimeMillis() - currentTimeMillis;
                    d.a.c.e.e.a.c().g(this.f42269a.b().i(), this.f42269a.b().g("Host"), TextUtils.isEmpty(dVar.f42281h), dVar.l != null);
                    this.f42269a.e(dVar);
                    b2 = a.b();
                    if (b2 != null) {
                        b bVar11 = this.f42270b;
                        if (bVar11 != null) {
                        }
                    }
                    z = true;
                    i5 = i6;
                }
                if (this.f42269a.c().f42295b != 200) {
                    dVar.f42281h = String.valueOf(this.f42269a.c().f42295b) + "|retryCount:" + i5;
                    z = m(this.f42269a.c().f42295b);
                    this.f42269a.e(dVar);
                    if (this.f42272d <= 0 && (bVar8 = this.f42270b) != null) {
                        this.f42272d = bVar8.i();
                    }
                    dVar.f42279f = System.currentTimeMillis() - currentTimeMillis;
                    d.a.c.e.e.a.c().g(this.f42269a.b().i(), this.f42269a.b().g("Host"), TextUtils.isEmpty(dVar.f42281h), dVar.l != null);
                    this.f42269a.e(dVar);
                    a b6 = a.b();
                    if (b6 != null && (bVar7 = this.f42270b) != null && bVar7.p()) {
                        b6.c(this.f42269a);
                    }
                    i5 = i6;
                } else {
                    if (this.f42272d <= 0 && (bVar6 = this.f42270b) != null) {
                        this.f42272d = bVar6.i();
                    }
                    dVar.f42279f = System.currentTimeMillis() - currentTimeMillis;
                    d.a.c.e.e.a.c().g(this.f42269a.b().i(), this.f42269a.b().g("Host"), TextUtils.isEmpty(dVar.f42281h), dVar.l != null);
                    this.f42269a.e(dVar);
                    a b7 = a.b();
                    if (b7 == null || (bVar5 = this.f42270b) == null || !bVar5.p()) {
                        return;
                    }
                    b7.c(this.f42269a);
                    return;
                }
            }
        }
    }

    public void q() {
        e eVar = this.f42269a;
        if (eVar == null) {
            return;
        }
        eVar.c().f42294a = true;
    }
}
