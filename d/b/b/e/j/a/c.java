package d.b.b.e.j.a;

import android.text.TextUtils;
import com.baidu.adp.R;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.util.FieldBuilder;
import d.b.b.e.p.j;
import d.b.b.e.p.k;
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
    public static boolean f41771f = true;

    /* renamed from: a  reason: collision with root package name */
    public e f41772a;

    /* renamed from: b  reason: collision with root package name */
    public b f41773b;

    /* renamed from: c  reason: collision with root package name */
    public int f41774c = 0;

    /* renamed from: d  reason: collision with root package name */
    public long f41775d = 0;

    /* renamed from: e  reason: collision with root package name */
    public boolean f41776e = true;

    public c(e eVar) {
        this.f41772a = eVar;
    }

    public final void a(int i) {
        try {
            if (this.f41772a == null || i <= 0) {
                return;
            }
            this.f41772a.b().a("Retry-Count", String.valueOf(i));
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
        }
    }

    public void b() {
        b bVar = this.f41773b;
        if (bVar != null) {
            bVar.b();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:112:0x03c9, code lost:
        if (r0 == null) goto L135;
     */
    /* JADX WARN: Code restructure failed: missing block: B:135:0x04cc, code lost:
        if (r0 == null) goto L135;
     */
    /* JADX WARN: Code restructure failed: missing block: B:136:0x04ce, code lost:
        r0.c(r23.f41772a);
     */
    /* JADX WARN: Code restructure failed: missing block: B:137:0x04d3, code lost:
        r10 = r27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x024f, code lost:
        if (r0 == null) goto L135;
     */
    /* JADX WARN: Code restructure failed: missing block: B:97:0x030c, code lost:
        if (r0 == null) goto L135;
     */
    /* JADX WARN: Removed duplicated region for block: B:217:0x08bb  */
    /* JADX WARN: Removed duplicated region for block: B:218:0x08bd  */
    /* JADX WARN: Removed duplicated region for block: B:226:0x0906  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean c(String str, h hVar, int i, int i2, int i3, int i4, boolean z, boolean z2) {
        d dVar;
        int i5;
        int i6;
        String str2;
        int i7;
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
        int b5 = i3 <= 0 ? d.b.b.c.j.b.d().b().b() : i3;
        int b6 = i4 <= 0 ? d.b.b.c.j.b.d().c().b() : i4;
        b bVar = new b(this.f41772a);
        this.f41773b = bVar;
        bVar.u(f41771f);
        int i8 = 0;
        boolean z3 = false;
        for (int a2 = i <= 0 ? d.b.b.c.j.b.d().a() : i; i8 < a2; a2 = i6) {
            d dVar10 = new d();
            this.f41772a.c().f41798c = -1;
            this.f41773b.s(i8);
            int i9 = i8 + 1;
            try {
                try {
                    dVar10.f41781e = i9;
                    try {
                        this.f41774c = i8;
                        a(i8);
                        str2 = str4;
                        i7 = i9;
                        i5 = i8;
                        i6 = a2;
                    } catch (IllegalStateException e2) {
                        e = e2;
                        str2 = str4;
                        i7 = i9;
                        dVar9 = dVar10;
                        i5 = i8;
                        i6 = a2;
                    } catch (ConnectException e3) {
                        e = e3;
                        str2 = str4;
                        i7 = i9;
                        dVar8 = dVar10;
                        i5 = i8;
                        i6 = a2;
                    } catch (SocketException e4) {
                        e = e4;
                        str2 = str4;
                        i7 = i9;
                        dVar7 = dVar10;
                        i5 = i8;
                        i6 = a2;
                    } catch (SocketTimeoutException e5) {
                        e = e5;
                        str2 = str4;
                        i7 = i9;
                        dVar6 = dVar10;
                        i5 = i8;
                        i6 = a2;
                    }
                } catch (IllegalStateException e6) {
                    e = e6;
                    str3 = str4;
                    i7 = i9;
                    dVar9 = dVar10;
                    i5 = i8;
                    i6 = a2;
                } catch (ConnectException e7) {
                    e = e7;
                    str3 = str4;
                    i7 = i9;
                    dVar8 = dVar10;
                    i5 = i8;
                    i6 = a2;
                } catch (SocketException e8) {
                    e = e8;
                    str3 = str4;
                    i7 = i9;
                    dVar7 = dVar10;
                    i5 = i8;
                    i6 = a2;
                } catch (SocketTimeoutException e9) {
                    e = e9;
                    str3 = str4;
                    i7 = i9;
                    dVar6 = dVar10;
                    i5 = i8;
                    i6 = a2;
                }
            } catch (FileNotFoundException e10) {
                e = e10;
                str2 = str4;
                i7 = i9;
                dVar5 = dVar10;
                i5 = i8;
                i6 = a2;
            } catch (UnknownHostException e11) {
                e = e11;
                str2 = str4;
                i7 = i9;
                dVar4 = dVar10;
                i5 = i8;
                i6 = a2;
            } catch (SSLException e12) {
                e = e12;
                str2 = str4;
                i7 = i9;
                dVar3 = dVar10;
                i5 = i8;
                i6 = a2;
            } catch (IOException e13) {
                e = e13;
                str2 = str4;
                i7 = i9;
                dVar2 = dVar10;
                i5 = i8;
                i6 = a2;
            } catch (Exception e14) {
                e = e14;
                str2 = str4;
                i7 = i9;
                dVar = dVar10;
                i5 = i8;
                i6 = a2;
            } catch (Throwable th) {
                th = th;
                dVar = dVar10;
                i5 = i8;
                i6 = a2;
            }
            try {
                z3 = this.f41773b.d(str, hVar, b5, b6, z, dVar10, z2);
                if (!z3 && this.f41772a.c().f41796a) {
                    this.f41772a.c().f41798c = -14;
                }
                d.b.b.e.e.a.c().g(this.f41772a.b().i(), this.f41772a.b().g("Host"), TextUtils.isEmpty(dVar10.f41784h), dVar10.l != null);
                if (!z3 && i5 == i6 - 1) {
                    dVar10.f41784h += FieldBuilder.SE + d.b.b.e.j.a.j.d.c();
                    dVar10.f41784h += "|netAvailable:" + j.A();
                }
                this.f41772a.e(dVar10);
                a b7 = a.b();
                if (b7 != null) {
                    b7.c(this.f41772a);
                }
                return z3;
            } catch (FileNotFoundException e15) {
                e = e15;
                dVar5 = dVar10;
                StringBuilder sb = new StringBuilder();
                str3 = str2;
                sb.append(str3);
                sb.append(String.valueOf(this.f41772a.c().f41797b));
                sb.append("|retryCount:");
                sb.append(i5);
                sb.append(FieldBuilder.SE);
                sb.append(e.getClass().getName());
                sb.append(FieldBuilder.SE);
                sb.append(e.getMessage());
                dVar5.f41784h = sb.toString();
                this.f41772a.c().f41798c = -100;
                d.b.b.e.e.a.c().g(this.f41772a.b().i(), this.f41772a.b().g("Host"), TextUtils.isEmpty(dVar5.f41784h), dVar5.l != null);
                if (!z3 && i5 == i6 - 1) {
                    dVar5.f41784h += FieldBuilder.SE + d.b.b.e.j.a.j.d.c();
                    dVar5.f41784h += "|netAvailable:" + j.A();
                }
                this.f41772a.e(dVar5);
                b4 = a.b();
                if (b4 == null) {
                    str4 = str3;
                    i8 = i7;
                }
                b4.c(this.f41772a);
                str4 = str3;
                i8 = i7;
            } catch (IllegalStateException e16) {
                e = e16;
                dVar9 = dVar10;
                str3 = str2;
                dVar9.f41784h = str3 + String.valueOf(this.f41772a.c().f41797b) + "|retryCount:" + i5 + FieldBuilder.SE + e.getClass().getName() + FieldBuilder.SE + e.getMessage() + "|getcontent_illegal_error";
                this.f41772a.c().f41798c = -19;
                d.b.b.e.e.a.c().g(this.f41772a.b().i(), this.f41772a.b().g("Host"), TextUtils.isEmpty(dVar9.f41784h), dVar9.l != null);
                if (!z3 && i5 == i6 - 1) {
                    dVar9.f41784h += FieldBuilder.SE + d.b.b.e.j.a.j.d.c();
                    dVar9.f41784h += "|netAvailable:" + j.A();
                }
                this.f41772a.e(dVar9);
                b4 = a.b();
                if (b4 == null) {
                    str4 = str3;
                    i8 = i7;
                }
                b4.c(this.f41772a);
                str4 = str3;
                i8 = i7;
            } catch (ConnectException e17) {
                e = e17;
                dVar8 = dVar10;
                str3 = str2;
                dVar8.f41784h = str3 + String.valueOf(this.f41772a.c().f41797b) + "|retryCount:" + i5 + FieldBuilder.SE + e.getClass().getName() + FieldBuilder.SE + e.getMessage();
                this.f41772a.c().f41798c = -22;
                d.b.b.e.e.a.c().g(this.f41772a.b().i(), this.f41772a.b().g("Host"), TextUtils.isEmpty(dVar8.f41784h), dVar8.l != null);
                if (!z3 && i5 == i6 - 1) {
                    dVar8.f41784h += FieldBuilder.SE + d.b.b.e.j.a.j.d.c();
                    dVar8.f41784h += "|netAvailable:" + j.A();
                }
                this.f41772a.e(dVar8);
                b4 = a.b();
                if (b4 == null) {
                    str4 = str3;
                    i8 = i7;
                }
                b4.c(this.f41772a);
                str4 = str3;
                i8 = i7;
            } catch (SocketException e18) {
                e = e18;
                dVar7 = dVar10;
                str3 = str2;
                dVar7.f41784h = str3 + String.valueOf(this.f41772a.c().f41797b) + "|retryCount:" + i5 + FieldBuilder.SE + e.getClass().getName() + FieldBuilder.SE + e.getMessage();
                this.f41772a.c().f41798c = -12;
                d.b.b.e.e.a.c().g(this.f41772a.b().i(), this.f41772a.b().g("Host"), TextUtils.isEmpty(dVar7.f41784h), dVar7.l != null);
                if (!z3 && i5 == i6 - 1) {
                    dVar7.f41784h += FieldBuilder.SE + d.b.b.e.j.a.j.d.c();
                    dVar7.f41784h += "|netAvailable:" + j.A();
                }
                this.f41772a.e(dVar7);
                b4 = a.b();
                if (b4 == null) {
                    str4 = str3;
                    i8 = i7;
                }
                b4.c(this.f41772a);
                str4 = str3;
                i8 = i7;
            } catch (SocketTimeoutException e19) {
                e = e19;
                dVar6 = dVar10;
                str3 = str2;
                dVar6.f41784h = str3 + String.valueOf(this.f41772a.c().f41797b) + "|retryCount:" + i5 + FieldBuilder.SE + e.getClass().getName() + FieldBuilder.SE + e.getMessage();
                this.f41772a.c().f41798c = -13;
                d.b.b.e.e.a.c().g(this.f41772a.b().i(), this.f41772a.b().g("Host"), TextUtils.isEmpty(dVar6.f41784h), dVar6.l != null);
                if (!z3 && i5 == i6 - 1) {
                    dVar6.f41784h += FieldBuilder.SE + d.b.b.e.j.a.j.d.c();
                    dVar6.f41784h += "|netAvailable:" + j.A();
                }
                this.f41772a.e(dVar6);
                b4 = a.b();
                if (b4 == null) {
                    str4 = str3;
                    i8 = i7;
                }
                b4.c(this.f41772a);
                str4 = str3;
                i8 = i7;
            } catch (UnknownHostException e20) {
                e = e20;
                dVar4 = dVar10;
                dVar4.f41784h = "errorCode:" + String.valueOf(this.f41772a.c().f41797b) + "|retryCount:" + i5 + FieldBuilder.SE + e.getClass().getName() + FieldBuilder.SE + e.getMessage();
                this.f41772a.c().f41798c = -21;
                d.b.b.e.e.a.c().g(this.f41772a.b().i(), this.f41772a.b().g("Host"), TextUtils.isEmpty(dVar4.f41784h), dVar4.l != null);
                if (!z3 && i5 == i6 - 1) {
                    dVar4.f41784h += FieldBuilder.SE + d.b.b.e.j.a.j.d.c();
                    dVar4.f41784h += "|netAvailable:" + j.A();
                }
                this.f41772a.e(dVar4);
                b3 = a.b();
            } catch (SSLException e21) {
                e = e21;
                dVar3 = dVar10;
                if (this.f41772a.b().e() && i5 < i6 - 1) {
                    String b8 = d.b.b.e.j.a.j.d.b(this.f41772a.b().i());
                    if (!k.isEmpty(b8)) {
                        this.f41772a.b().s(b8);
                    }
                    BdStatisticsManager.getInstance().eventStat(null, "c13429", "", 1, "obj_type", "1");
                } else {
                    dVar3.f41784h = "errorCode:" + String.valueOf(this.f41772a.c().f41797b) + "|retryCount:" + i5 + FieldBuilder.SE + e.getClass().getName() + FieldBuilder.SE + e.getMessage();
                    this.f41772a.c().f41798c = -20;
                }
                d.b.b.e.e.a.c().g(this.f41772a.b().i(), this.f41772a.b().g("Host"), TextUtils.isEmpty(dVar3.f41784h), dVar3.l != null);
                if (!z3 && i5 == i6 - 1) {
                    dVar3.f41784h += FieldBuilder.SE + d.b.b.e.j.a.j.d.c();
                    dVar3.f41784h += "|netAvailable:" + j.A();
                }
                this.f41772a.e(dVar3);
                b3 = a.b();
            } catch (IOException e22) {
                e = e22;
                dVar2 = dVar10;
                dVar2.f41784h = "errorCode:" + String.valueOf(this.f41772a.c().f41797b) + "|retryCount:" + i5 + FieldBuilder.SE + e.getClass().getName() + FieldBuilder.SE + e.getMessage();
                this.f41772a.c().f41798c = -19;
                d.b.b.e.e.a.c().g(this.f41772a.b().i(), this.f41772a.b().g("Host"), TextUtils.isEmpty(dVar2.f41784h), dVar2.l != null);
                if (!z3 && i5 == i6 - 1) {
                    dVar2.f41784h += FieldBuilder.SE + d.b.b.e.j.a.j.d.c();
                    dVar2.f41784h += "|netAvailable:" + j.A();
                }
                this.f41772a.e(dVar2);
                b3 = a.b();
            } catch (Exception e23) {
                e = e23;
                dVar = dVar10;
                try {
                    dVar.f41784h = "errorCode:" + String.valueOf(this.f41772a.c().f41797b) + "|retryCount:" + i5 + FieldBuilder.SE + e.getClass().getName() + FieldBuilder.SE + e.getMessage();
                    this.f41772a.c().f41798c = -10;
                    BdLog.e(e.getMessage());
                    d.b.b.e.e.a.c().g(this.f41772a.b().i(), this.f41772a.b().g("Host"), TextUtils.isEmpty(dVar.f41784h), dVar.l != null);
                    if (!z3 && i5 == i6 - 1) {
                        dVar.f41784h += FieldBuilder.SE + d.b.b.e.j.a.j.d.c();
                        dVar.f41784h += "|netAvailable:" + j.A();
                    }
                    this.f41772a.e(dVar);
                    b3 = a.b();
                } catch (Throwable th2) {
                    th = th2;
                    d.b.b.e.e.a.c().g(this.f41772a.b().i(), this.f41772a.b().g("Host"), TextUtils.isEmpty(dVar.f41784h), dVar.l == null);
                    if (!z3 && i5 == i6 - 1) {
                        dVar.f41784h += FieldBuilder.SE + d.b.b.e.j.a.j.d.c();
                        dVar.f41784h += "|netAvailable:" + j.A();
                    }
                    this.f41772a.e(dVar);
                    b2 = a.b();
                    if (b2 != null) {
                        b2.c(this.f41772a);
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                dVar = dVar10;
                d.b.b.e.e.a.c().g(this.f41772a.b().i(), this.f41772a.b().g("Host"), TextUtils.isEmpty(dVar.f41784h), dVar.l == null);
                if (!z3) {
                    dVar.f41784h += FieldBuilder.SE + d.b.b.e.j.a.j.d.c();
                    dVar.f41784h += "|netAvailable:" + j.A();
                }
                this.f41772a.e(dVar);
                b2 = a.b();
                if (b2 != null) {
                }
                throw th;
            }
        }
        return z3;
    }

    /* JADX WARN: Code restructure failed: missing block: B:105:0x03a5, code lost:
        if (r0 == null) goto L93;
     */
    /* JADX WARN: Code restructure failed: missing block: B:106:0x03a7, code lost:
        r0.c(r19.f41772a);
     */
    /* JADX WARN: Code restructure failed: missing block: B:107:0x03ac, code lost:
        r12 = 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:90:0x0316, code lost:
        if (r0 == null) goto L93;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void d(int i, int i2, int i3) {
        int i4;
        b bVar;
        a b2;
        b bVar2;
        b bVar3;
        a b3;
        b bVar4;
        b bVar5;
        b bVar6;
        b bVar7;
        int b4 = i2 <= 0 ? d.b.b.c.j.b.d().b().b() : i2;
        int a2 = i <= 0 ? d.b.b.c.j.b.d().a() : i;
        int b5 = i3 <= 0 ? d.b.b.c.j.b.d().c().b() : i3;
        long currentTimeMillis = System.currentTimeMillis();
        int i5 = true;
        int i6 = 0;
        for (int i7 = 1; !this.f41772a.c().f41796a && i5 == i7 && i6 < a2; i7 = 1) {
            d dVar = new d();
            this.f41772a.e(dVar);
            try {
                try {
                    try {
                        try {
                            this.f41774c = i6;
                            dVar.f41781e = i6 + 1;
                            dVar.v = i7;
                            a(i6);
                            b bVar8 = new b(this.f41772a);
                            this.f41773b = bVar8;
                            bVar8.s(i6);
                            this.f41773b.u(f41771f);
                            this.f41773b.k(b4, b5, dVar);
                        } catch (Exception e2) {
                            dVar.f41784h = String.valueOf(this.f41772a.c().f41797b) + "|retryCount:" + i6 + FieldBuilder.SE + e2.getClass() + FieldBuilder.SE + e2.getMessage();
                            this.f41772a.c().f41798c = -10;
                            BdLog.e(e2.getMessage());
                            if (this.f41775d <= 0 && (bVar4 = this.f41773b) != null) {
                                this.f41775d = bVar4.i();
                            }
                            dVar.f41782f = System.currentTimeMillis() - currentTimeMillis;
                            d.b.b.e.e.a.c().g(this.f41772a.b().i(), this.f41772a.b().g("Host"), TextUtils.isEmpty(dVar.f41784h), dVar.l != null);
                            this.f41772a.f(dVar);
                            b3 = a.b();
                            if (b3 == null) {
                                return;
                            }
                        }
                    } catch (SocketTimeoutException e3) {
                        i4 = b4;
                        dVar.f41784h = String.valueOf(this.f41772a.c().f41797b) + "|retryCount:" + i6 + FieldBuilder.SE + e3.getClass() + FieldBuilder.SE + e3.getMessage();
                        this.f41772a.c().f41798c = -13;
                        if (this.f41775d <= 0 && (bVar3 = this.f41773b) != null) {
                            this.f41775d = bVar3.i();
                        }
                        dVar.f41782f = System.currentTimeMillis() - currentTimeMillis;
                        d.b.b.e.e.a.c().g(this.f41772a.b().i(), this.f41772a.b().g("Host"), TextUtils.isEmpty(dVar.f41784h), dVar.l != null);
                        this.f41772a.f(dVar);
                        b2 = a.b();
                    }
                } catch (SocketException e4) {
                    i4 = b4;
                    dVar.f41784h = String.valueOf(this.f41772a.c().f41797b) + "|retryCount:" + i6 + FieldBuilder.SE + e4.getClass() + FieldBuilder.SE + e4.getMessage();
                    this.f41772a.c().f41798c = -12;
                    if (this.f41775d <= 0 && (bVar2 = this.f41773b) != null) {
                        this.f41775d = bVar2.i();
                    }
                    dVar.f41782f = System.currentTimeMillis() - currentTimeMillis;
                    d.b.b.e.e.a.c().g(this.f41772a.b().i(), this.f41772a.b().g("Host"), TextUtils.isEmpty(dVar.f41784h), dVar.l != null);
                    this.f41772a.f(dVar);
                    b2 = a.b();
                } catch (IOException e5) {
                    this.f41772a.c().f41798c = -19;
                    dVar.f41784h = "errorCode:" + String.valueOf(-19) + FieldBuilder.SE + e5.getClass() + FieldBuilder.SE + e5.getMessage() + "|getcontent_illegal_error";
                    if (this.f41775d <= 0 && (bVar = this.f41773b) != null) {
                        this.f41775d = bVar.i();
                    }
                    dVar.f41782f = System.currentTimeMillis() - currentTimeMillis;
                    i4 = b4;
                    d.b.b.e.e.a.c().g(this.f41772a.b().i(), this.f41772a.b().g("Host"), TextUtils.isEmpty(dVar.f41784h), dVar.l != null);
                    this.f41772a.f(dVar);
                    a b6 = a.b();
                    if (b6 != null) {
                        b6.c(this.f41772a);
                    }
                }
                if (this.f41772a.c().f41797b != 200) {
                    dVar.f41784h = String.valueOf(this.f41772a.c().f41797b) + "|retryCount:" + i6;
                    boolean l = l(this.f41772a.c().f41797b);
                    if (this.f41775d <= 0 && (bVar7 = this.f41773b) != null) {
                        this.f41775d = bVar7.i();
                    }
                    dVar.f41782f = System.currentTimeMillis() - currentTimeMillis;
                    d.b.b.e.e.a.c().g(this.f41772a.b().i(), this.f41772a.b().g("Host"), TextUtils.isEmpty(dVar.f41784h), dVar.l != null);
                    this.f41772a.f(dVar);
                    a b7 = a.b();
                    if (b7 != null) {
                        b7.c(this.f41772a);
                    }
                    i5 = l;
                    i4 = b4;
                    i6++;
                    b4 = i4;
                } else {
                    this.f41772a.f(dVar);
                    if (this.f41775d <= 0 && (bVar6 = this.f41773b) != null) {
                        this.f41775d = bVar6.i();
                    }
                    dVar.f41782f = System.currentTimeMillis() - currentTimeMillis;
                    d.b.b.e.e.a.c().g(this.f41772a.b().i(), this.f41772a.b().g("Host"), TextUtils.isEmpty(dVar.f41784h), dVar.l != null);
                    this.f41772a.f(dVar);
                    b3 = a.b();
                    if (b3 == null) {
                        return;
                    }
                    b3.c(this.f41772a);
                    return;
                }
            } catch (Throwable th) {
                if (this.f41775d <= 0 && (bVar5 = this.f41773b) != null) {
                    this.f41775d = bVar5.i();
                }
                dVar.f41782f = System.currentTimeMillis() - currentTimeMillis;
                d.b.b.e.e.a.c().g(this.f41772a.b().i(), this.f41772a.b().g("Host"), TextUtils.isEmpty(dVar.f41784h), dVar.l != null);
                this.f41772a.f(dVar);
                a b8 = a.b();
                if (b8 != null) {
                    b8.c(this.f41772a);
                }
                throw th;
            }
        }
    }

    public long e() {
        b bVar = this.f41773b;
        if (bVar == null) {
            return -1L;
        }
        return bVar.e();
    }

    public long f() {
        b bVar = this.f41773b;
        if (bVar == null) {
            return -1L;
        }
        return bVar.h();
    }

    public long g() {
        long j = this.f41775d;
        if (j > 0) {
            return j;
        }
        b bVar = this.f41773b;
        if (bVar == null) {
            return -1L;
        }
        return bVar.i();
    }

    public long h() {
        b bVar = this.f41773b;
        if (bVar == null) {
            return -1L;
        }
        return bVar.l();
    }

    public long i() {
        b bVar = this.f41773b;
        if (bVar == null) {
            return -1L;
        }
        return bVar.j();
    }

    public int j() {
        return this.f41774c;
    }

    public boolean k() {
        e eVar = this.f41772a;
        if (eVar == null) {
            return false;
        }
        return eVar.c().f41796a;
    }

    public final boolean l(int i) {
        if (i == 202 || i == 201 || i == 205 || i == 304 || i == 305 || i == 408) {
            return true;
        }
        return (i == 502 || i == 503 || i == 504 || i == 404) ? false : true;
    }

    public void m(int i, int i2, int i3) {
        if (this.f41772a.b().j()) {
            o(i, i2, i3);
        } else {
            n(i, i2, i3);
        }
    }

    /* JADX DEBUG: Finally have unexpected throw blocks count: 0, expect 1 */
    /* JADX WARN: Code restructure failed: missing block: B:100:0x0343, code lost:
        r0.c(r16.f41772a);
     */
    /* JADX WARN: Code restructure failed: missing block: B:101:0x0348, code lost:
        r0 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x01d3, code lost:
        if (r0 == null) goto L62;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x0245, code lost:
        if (r0 == null) goto L62;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x0247, code lost:
        r0.c(r16.f41772a);
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x024c, code lost:
        r0 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x02c6, code lost:
        if (r0 == null) goto L77;
     */
    /* JADX WARN: Code restructure failed: missing block: B:99:0x0341, code lost:
        if (r0 == null) goto L77;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void n(int i, int i2, int i3) {
        a b2;
        b bVar;
        a b3;
        b bVar2;
        b bVar3;
        b bVar4;
        b bVar5;
        b bVar6;
        b bVar7;
        int b4 = i2 <= 0 ? d.b.b.c.j.b.d().b().b() : i2;
        int a2 = i <= 0 ? d.b.b.c.j.b.d().a() : i;
        int b5 = i3 <= 0 ? d.b.b.c.j.b.d().c().b() : i3;
        long currentTimeMillis = System.currentTimeMillis();
        boolean z = true;
        int i4 = 0;
        for (boolean z2 = true; !this.f41772a.c().f41796a && z == z2 && i4 < a2; z2 = true) {
            d dVar = new d();
            this.f41774c = i4;
            int i5 = i4 + 1;
            dVar.f41781e = i5;
            a(i4);
            try {
                try {
                    b bVar8 = new b(this.f41772a);
                    this.f41773b = bVar8;
                    bVar8.s(i4);
                    this.f41773b.u(f41771f);
                    this.f41773b.t(this.f41776e);
                    this.f41773b.r(b4, b5, dVar);
                } catch (UnsupportedOperationException unused) {
                    this.f41772a.c().f41798c = -14;
                    dVar.f41784h = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                    this.f41772a.e(dVar);
                    if (this.f41775d <= 0 && (bVar5 = this.f41773b) != null) {
                        this.f41775d = bVar5.i();
                    }
                    dVar.f41782f = System.currentTimeMillis() - currentTimeMillis;
                    d.b.b.e.e.a.c().g(this.f41772a.b().i(), this.f41772a.b().g("Host"), TextUtils.isEmpty(dVar.f41784h), dVar.l != null);
                    this.f41772a.e(dVar);
                    b2 = a.b();
                } catch (SocketTimeoutException e2) {
                    this.f41772a.c().f41798c = -13;
                    dVar.f41784h = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                    BdLog.e(e2.getMessage());
                    this.f41772a.e(dVar);
                    if (this.f41775d <= 0 && (bVar4 = this.f41773b) != null) {
                        this.f41775d = bVar4.i();
                    }
                    dVar.f41782f = System.currentTimeMillis() - currentTimeMillis;
                    d.b.b.e.e.a.c().g(this.f41772a.b().i(), this.f41772a.b().g("Host"), TextUtils.isEmpty(dVar.f41784h), dVar.l != null);
                    this.f41772a.e(dVar);
                    b3 = a.b();
                }
            } catch (SocketException e3) {
                this.f41772a.c().f41798c = -12;
                dVar.f41784h = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                BdLog.e(e3.getMessage());
                this.f41772a.e(dVar);
                if (this.f41775d <= 0 && (bVar2 = this.f41773b) != null) {
                    this.f41775d = bVar2.i();
                }
                dVar.f41782f = System.currentTimeMillis() - currentTimeMillis;
                d.b.b.e.e.a.c().g(this.f41772a.b().i(), this.f41772a.b().g("Host"), TextUtils.isEmpty(dVar.f41784h), dVar.l != null);
                this.f41772a.e(dVar);
                b3 = a.b();
            } catch (Throwable th) {
                try {
                    this.f41772a.c().f41798c = -10;
                    dVar.f41784h = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                    BdLog.e(th.getMessage());
                    this.f41772a.e(dVar);
                    if (this.f41775d <= 0 && (bVar = this.f41773b) != null) {
                        this.f41775d = bVar.i();
                    }
                    dVar.f41782f = System.currentTimeMillis() - currentTimeMillis;
                    d.b.b.e.e.a.c().g(this.f41772a.b().i(), this.f41772a.b().g("Host"), TextUtils.isEmpty(dVar.f41784h), dVar.l != null);
                    this.f41772a.e(dVar);
                    b2 = a.b();
                } catch (Throwable th2) {
                    if (this.f41775d <= 0 && (bVar3 = this.f41773b) != null) {
                        this.f41775d = bVar3.i();
                    }
                    dVar.f41782f = System.currentTimeMillis() - currentTimeMillis;
                    d.b.b.e.e.a.c().g(this.f41772a.b().i(), this.f41772a.b().g("Host"), TextUtils.isEmpty(dVar.f41784h), dVar.l != null);
                    this.f41772a.e(dVar);
                    a b6 = a.b();
                    if (b6 != null) {
                        b6.c(this.f41772a);
                    }
                    throw th2;
                }
            }
            if (this.f41772a.c().f41797b != 200) {
                dVar.f41784h = String.valueOf(this.f41772a.c().f41797b) + "|retryCount:" + i4;
                z = l(this.f41772a.c().f41797b);
                this.f41772a.e(dVar);
                if (this.f41775d <= 0 && (bVar7 = this.f41773b) != null) {
                    this.f41775d = bVar7.i();
                }
                dVar.f41782f = System.currentTimeMillis() - currentTimeMillis;
                d.b.b.e.e.a.c().g(this.f41772a.b().i(), this.f41772a.b().g("Host"), TextUtils.isEmpty(dVar.f41784h), dVar.l != null);
                this.f41772a.e(dVar);
                a b7 = a.b();
                if (b7 != null) {
                    b7.c(this.f41772a);
                }
                i4 = i5;
            } else {
                if (this.f41775d <= 0 && (bVar6 = this.f41773b) != null) {
                    this.f41775d = bVar6.i();
                }
                dVar.f41782f = System.currentTimeMillis() - currentTimeMillis;
                d.b.b.e.e.a.c().g(this.f41772a.b().i(), this.f41772a.b().g("Host"), TextUtils.isEmpty(dVar.f41784h), dVar.l != null);
                this.f41772a.e(dVar);
                a b8 = a.b();
                if (b8 != null) {
                    b8.c(this.f41772a);
                    return;
                }
                return;
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:105:0x02f2, code lost:
        if (r8.p() != false) goto L99;
     */
    /* JADX WARN: Code restructure failed: missing block: B:123:0x0377, code lost:
        if (r8.p() != false) goto L99;
     */
    /* JADX WARN: Code restructure failed: missing block: B:124:0x0379, code lost:
        r0.c(r16.f41772a);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void o(int i, int i2, int i3) {
        a b2;
        b bVar;
        b bVar2;
        b bVar3;
        b bVar4;
        b bVar5;
        b bVar6;
        b bVar7;
        b bVar8;
        int b3 = i2 <= 0 ? d.b.b.c.j.b.d().b().b() : i2;
        int a2 = i <= 0 ? d.b.b.c.j.b.d().a() : i;
        int b4 = i3 <= 0 ? d.b.b.c.j.b.d().c().b() : i3;
        long currentTimeMillis = System.currentTimeMillis();
        boolean z = true;
        int i4 = 0;
        for (boolean z2 = true; !this.f41772a.c().f41796a && z == z2 && i4 < a2; z2 = true) {
            d dVar = new d();
            int i5 = i4 + 1;
            dVar.f41781e = i5;
            this.f41774c = i4;
            a(i4);
            try {
                try {
                    try {
                        b bVar9 = new b(this.f41772a);
                        this.f41773b = bVar9;
                        bVar9.s(i4);
                        this.f41773b.u(f41771f);
                        this.f41773b.q(b3, b4, dVar);
                    } catch (UnsupportedOperationException unused) {
                        this.f41772a.c().f41798c = -14;
                        dVar.f41784h = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                        this.f41772a.e(dVar);
                        if (this.f41775d <= 0 && (bVar4 = this.f41773b) != null) {
                            this.f41775d = bVar4.i();
                        }
                        dVar.f41782f = System.currentTimeMillis() - currentTimeMillis;
                        d.b.b.e.e.a.c().g(this.f41772a.b().i(), this.f41772a.b().g("Host"), TextUtils.isEmpty(dVar.f41784h), dVar.l != null);
                        this.f41772a.e(dVar);
                        a b5 = a.b();
                        if (b5 != null && (bVar3 = this.f41773b) != null && bVar3.p()) {
                            b5.c(this.f41772a);
                        }
                        z = false;
                    }
                } catch (SocketException e2) {
                    this.f41772a.c().f41798c = -12;
                    dVar.f41784h = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                    BdLog.e(e2.getMessage());
                    this.f41772a.e(dVar);
                    if (this.f41775d <= 0 && (bVar2 = this.f41773b) != null) {
                        this.f41775d = bVar2.i();
                    }
                    dVar.f41782f = System.currentTimeMillis() - currentTimeMillis;
                    d.b.b.e.e.a.c().g(this.f41772a.b().i(), this.f41772a.b().g("Host"), TextUtils.isEmpty(dVar.f41784h), dVar.l != null);
                    this.f41772a.e(dVar);
                    b2 = a.b();
                    if (b2 != null) {
                        b bVar10 = this.f41773b;
                        if (bVar10 != null) {
                        }
                    }
                    z = true;
                    i4 = i5;
                } catch (SocketTimeoutException e3) {
                    this.f41772a.c().f41798c = -13;
                    dVar.f41784h = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                    BdLog.e(e3.getMessage());
                    this.f41772a.e(dVar);
                    if (this.f41775d <= 0 && (bVar = this.f41773b) != null) {
                        this.f41775d = bVar.i();
                    }
                    dVar.f41782f = System.currentTimeMillis() - currentTimeMillis;
                    d.b.b.e.e.a.c().g(this.f41772a.b().i(), this.f41772a.b().g("Host"), TextUtils.isEmpty(dVar.f41784h), dVar.l != null);
                    this.f41772a.e(dVar);
                    b2 = a.b();
                    if (b2 != null) {
                        b bVar11 = this.f41773b;
                        if (bVar11 != null) {
                        }
                    }
                    z = true;
                    i4 = i5;
                }
                if (this.f41772a.c().f41797b != 200) {
                    dVar.f41784h = String.valueOf(this.f41772a.c().f41797b) + "|retryCount:" + i4;
                    z = l(this.f41772a.c().f41797b);
                    this.f41772a.e(dVar);
                    if (this.f41775d <= 0 && (bVar8 = this.f41773b) != null) {
                        this.f41775d = bVar8.i();
                    }
                    dVar.f41782f = System.currentTimeMillis() - currentTimeMillis;
                    d.b.b.e.e.a.c().g(this.f41772a.b().i(), this.f41772a.b().g("Host"), TextUtils.isEmpty(dVar.f41784h), dVar.l != null);
                    this.f41772a.e(dVar);
                    a b6 = a.b();
                    if (b6 != null && (bVar7 = this.f41773b) != null && bVar7.p()) {
                        b6.c(this.f41772a);
                    }
                    i4 = i5;
                } else {
                    if (this.f41775d <= 0 && (bVar6 = this.f41773b) != null) {
                        this.f41775d = bVar6.i();
                    }
                    dVar.f41782f = System.currentTimeMillis() - currentTimeMillis;
                    d.b.b.e.e.a.c().g(this.f41772a.b().i(), this.f41772a.b().g("Host"), TextUtils.isEmpty(dVar.f41784h), dVar.l != null);
                    this.f41772a.e(dVar);
                    a b7 = a.b();
                    if (b7 == null || (bVar5 = this.f41773b) == null || !bVar5.p()) {
                        return;
                    }
                    b7.c(this.f41772a);
                    return;
                }
            }
        }
    }

    public void p() {
        e eVar = this.f41772a;
        if (eVar == null) {
            return;
        }
        eVar.c().f41796a = true;
    }
}
