package com.repackage;

import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.ConnectException;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import javax.net.ssl.SSLException;
/* loaded from: classes6.dex */
public class lf {
    public static /* synthetic */ Interceptable $ic = null;
    public static boolean e = true;
    public transient /* synthetic */ FieldHolder $fh;
    public of a;
    public kf b;
    public int c;
    public long d;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1964034613, "Lcom/repackage/lf;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1964034613, "Lcom/repackage/lf;");
        }
    }

    public lf(of ofVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {ofVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.c = 0;
        this.d = 0L;
        this.a = ofVar;
    }

    public final void a(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
            try {
                if (this.a == null || i <= 0) {
                    return;
                }
                this.a.b().a("Retry-Count", String.valueOf(i));
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
        }
    }

    public void b() {
        kf kfVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (kfVar = this.b) == null) {
            return;
        }
        kfVar.b();
    }

    /* JADX WARN: Code restructure failed: missing block: B:113:0x0403, code lost:
        if (r0 == null) goto L105;
     */
    /* JADX WARN: Code restructure failed: missing block: B:114:0x0405, code lost:
        r0.b(r22.a);
     */
    /* JADX WARN: Code restructure failed: missing block: B:115:0x040a, code lost:
        r9 = r26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x01fe, code lost:
        if (r0 == null) goto L105;
     */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x0293, code lost:
        if (r0 == null) goto L105;
     */
    /* JADX WARN: Code restructure failed: missing block: B:95:0x0328, code lost:
        if (r0 == null) goto L105;
     */
    /* JADX WARN: Removed duplicated region for block: B:174:0x074c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean c(String str, rf rfVar, int i, int i2, int i3, int i4, boolean z, boolean z2) {
        InterceptResult invokeCommon;
        nf nfVar;
        int i5;
        int i6;
        String str2;
        int i7;
        nf nfVar2;
        nf nfVar3;
        nf nfVar4;
        nf nfVar5;
        String str3;
        nf nfVar6;
        nf nfVar7;
        nf nfVar8;
        nf nfVar9;
        jf a;
        jf a2;
        jf a3;
        nf nfVar10;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{str, rfVar, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) {
            String str4 = "responseCode:";
            int b = i3 <= 0 ? fb.d().b().b() : i3;
            int b2 = i4 <= 0 ? fb.d().c().b() : i4;
            kf kfVar = new kf(this.a);
            this.b = kfVar;
            kfVar.s(e);
            int i8 = 0;
            boolean z3 = false;
            for (int a4 = i <= 0 ? fb.d().a() : i; i8 < a4; a4 = i6) {
                nf nfVar11 = new nf();
                this.a.c().c = -1;
                this.b.r(i8);
                int i9 = i8 + 1;
                try {
                    try {
                        nfVar11.e = i9;
                        try {
                            this.c = i8;
                            a(i8);
                            str2 = str4;
                            i7 = i9;
                            i5 = i8;
                            i6 = a4;
                        } catch (IllegalStateException e2) {
                            e = e2;
                            str2 = str4;
                            i7 = i9;
                            nfVar9 = nfVar11;
                            i5 = i8;
                            i6 = a4;
                        } catch (ConnectException e3) {
                            e = e3;
                            str2 = str4;
                            i7 = i9;
                            nfVar8 = nfVar11;
                            i5 = i8;
                            i6 = a4;
                        } catch (SocketException e4) {
                            e = e4;
                            str2 = str4;
                            i7 = i9;
                            nfVar7 = nfVar11;
                            i5 = i8;
                            i6 = a4;
                        } catch (SocketTimeoutException e5) {
                            e = e5;
                            str2 = str4;
                            i7 = i9;
                            nfVar6 = nfVar11;
                            i5 = i8;
                            i6 = a4;
                        }
                    } catch (IllegalStateException e6) {
                        e = e6;
                        str3 = str4;
                        i7 = i9;
                        nfVar9 = nfVar11;
                        i5 = i8;
                        i6 = a4;
                    } catch (ConnectException e7) {
                        e = e7;
                        str3 = str4;
                        i7 = i9;
                        nfVar8 = nfVar11;
                        i5 = i8;
                        i6 = a4;
                    } catch (SocketException e8) {
                        e = e8;
                        str3 = str4;
                        i7 = i9;
                        nfVar7 = nfVar11;
                        i5 = i8;
                        i6 = a4;
                    } catch (SocketTimeoutException e9) {
                        e = e9;
                        str3 = str4;
                        i7 = i9;
                        nfVar6 = nfVar11;
                        i5 = i8;
                        i6 = a4;
                    }
                } catch (FileNotFoundException e10) {
                    e = e10;
                    str2 = str4;
                    i7 = i9;
                    nfVar5 = nfVar11;
                    i5 = i8;
                    i6 = a4;
                } catch (UnknownHostException e11) {
                    e = e11;
                    str2 = str4;
                    i7 = i9;
                    nfVar4 = nfVar11;
                    i5 = i8;
                    i6 = a4;
                } catch (SSLException e12) {
                    e = e12;
                    str2 = str4;
                    i7 = i9;
                    nfVar3 = nfVar11;
                    i5 = i8;
                    i6 = a4;
                } catch (IOException e13) {
                    e = e13;
                    str2 = str4;
                    i7 = i9;
                    nfVar2 = nfVar11;
                    i5 = i8;
                    i6 = a4;
                } catch (Exception e14) {
                    e = e14;
                    str2 = str4;
                    i7 = i9;
                    nfVar = nfVar11;
                    i5 = i8;
                    i6 = a4;
                } catch (Throwable th) {
                    th = th;
                    nfVar = nfVar11;
                    i5 = i8;
                    i6 = a4;
                }
                try {
                    z3 = this.b.d(str, rfVar, b, b2, z, nfVar11, z2);
                    if (!z3 && this.a.c().a) {
                        this.a.c().c = -14;
                    }
                    if (z3 || i5 != i6 - 1) {
                        nfVar10 = nfVar11;
                    } else {
                        StringBuilder sb = new StringBuilder();
                        nfVar10 = nfVar11;
                        sb.append(nfVar10.h);
                        sb.append("|");
                        sb.append(xf.c());
                        nfVar10.h = sb.toString();
                        nfVar10.h += "|netAvailable:" + mi.A();
                    }
                    this.a.e(nfVar10);
                    jf a5 = jf.a();
                    if (a5 != null) {
                        a5.b(this.a);
                    }
                    return z3;
                } catch (FileNotFoundException e15) {
                    e = e15;
                    nfVar5 = nfVar11;
                    StringBuilder sb2 = new StringBuilder();
                    str3 = str2;
                    sb2.append(str3);
                    sb2.append(String.valueOf(this.a.c().b));
                    sb2.append("|retryCount:");
                    sb2.append(i5);
                    sb2.append("|");
                    sb2.append(e.getClass().getName());
                    sb2.append("|");
                    sb2.append(e.getMessage());
                    nfVar5.h = sb2.toString();
                    this.a.c().c = -100;
                    if (!z3 && i5 == i6 - 1) {
                        nfVar5.h += "|" + xf.c();
                        nfVar5.h += "|netAvailable:" + mi.A();
                    }
                    this.a.e(nfVar5);
                    a3 = jf.a();
                    if (a3 == null) {
                        str4 = str3;
                        i8 = i7;
                    }
                    a3.b(this.a);
                    str4 = str3;
                    i8 = i7;
                } catch (IllegalStateException e16) {
                    e = e16;
                    nfVar9 = nfVar11;
                    str3 = str2;
                    nfVar9.h = str3 + String.valueOf(this.a.c().b) + "|retryCount:" + i5 + "|" + e.getClass().getName() + "|" + e.getMessage() + "|getcontent_illegal_error";
                    this.a.c().c = -19;
                    if (!z3 && i5 == i6 - 1) {
                        nfVar9.h += "|" + xf.c();
                        nfVar9.h += "|netAvailable:" + mi.A();
                    }
                    this.a.e(nfVar9);
                    a3 = jf.a();
                    if (a3 == null) {
                        str4 = str3;
                        i8 = i7;
                    }
                    a3.b(this.a);
                    str4 = str3;
                    i8 = i7;
                } catch (ConnectException e17) {
                    e = e17;
                    nfVar8 = nfVar11;
                    str3 = str2;
                    nfVar8.h = str3 + String.valueOf(this.a.c().b) + "|retryCount:" + i5 + "|" + e.getClass().getName() + "|" + e.getMessage();
                    this.a.c().c = -22;
                    if (!z3 && i5 == i6 - 1) {
                        nfVar8.h += "|" + xf.c();
                        nfVar8.h += "|netAvailable:" + mi.A();
                    }
                    this.a.e(nfVar8);
                    a3 = jf.a();
                    if (a3 == null) {
                        str4 = str3;
                        i8 = i7;
                    }
                    a3.b(this.a);
                    str4 = str3;
                    i8 = i7;
                } catch (SocketException e18) {
                    e = e18;
                    nfVar7 = nfVar11;
                    str3 = str2;
                    nfVar7.h = str3 + String.valueOf(this.a.c().b) + "|retryCount:" + i5 + "|" + e.getClass().getName() + "|" + e.getMessage();
                    this.a.c().c = -12;
                    if (!z3 && i5 == i6 - 1) {
                        nfVar7.h += "|" + xf.c();
                        nfVar7.h += "|netAvailable:" + mi.A();
                    }
                    this.a.e(nfVar7);
                    a3 = jf.a();
                    if (a3 == null) {
                        str4 = str3;
                        i8 = i7;
                    }
                    a3.b(this.a);
                    str4 = str3;
                    i8 = i7;
                } catch (SocketTimeoutException e19) {
                    e = e19;
                    nfVar6 = nfVar11;
                    str3 = str2;
                    nfVar6.h = str3 + String.valueOf(this.a.c().b) + "|retryCount:" + i5 + "|" + e.getClass().getName() + "|" + e.getMessage();
                    this.a.c().c = -13;
                    if (!z3 && i5 == i6 - 1) {
                        nfVar6.h += "|" + xf.c();
                        nfVar6.h += "|netAvailable:" + mi.A();
                    }
                    this.a.e(nfVar6);
                    a3 = jf.a();
                    if (a3 == null) {
                        str4 = str3;
                        i8 = i7;
                    }
                    a3.b(this.a);
                    str4 = str3;
                    i8 = i7;
                } catch (UnknownHostException e20) {
                    e = e20;
                    nfVar4 = nfVar11;
                    nfVar4.h = "errorCode:" + String.valueOf(this.a.c().b) + "|retryCount:" + i5 + "|" + e.getClass().getName() + "|" + e.getMessage();
                    this.a.c().c = -21;
                    if (!z3 && i5 == i6 - 1) {
                        nfVar4.h += "|" + xf.c();
                        nfVar4.h += "|netAvailable:" + mi.A();
                    }
                    this.a.e(nfVar4);
                    a2 = jf.a();
                } catch (SSLException e21) {
                    e = e21;
                    nfVar3 = nfVar11;
                    if (this.a.b().e() && i5 < i6 - 1) {
                        String b3 = xf.b(this.a.b().l());
                        if (!ni.isEmpty(b3)) {
                            this.a.b().t(b3);
                        }
                        BdStatisticsManager.getInstance().eventStat(null, "c13429", "", 1, "obj_type", "1");
                    } else {
                        nfVar3.h = "errorCode:" + String.valueOf(this.a.c().b) + "|retryCount:" + i5 + "|" + e.getClass().getName() + "|" + e.getMessage();
                        this.a.c().c = -20;
                    }
                    if (!z3 && i5 == i6 - 1) {
                        nfVar3.h += "|" + xf.c();
                        nfVar3.h += "|netAvailable:" + mi.A();
                    }
                    this.a.e(nfVar3);
                    a2 = jf.a();
                } catch (IOException e22) {
                    e = e22;
                    nfVar2 = nfVar11;
                    nfVar2.h = "errorCode:" + String.valueOf(this.a.c().b) + "|retryCount:" + i5 + "|" + e.getClass().getName() + "|" + e.getMessage();
                    this.a.c().c = -19;
                    if (!z3 && i5 == i6 - 1) {
                        nfVar2.h += "|" + xf.c();
                        nfVar2.h += "|netAvailable:" + mi.A();
                    }
                    this.a.e(nfVar2);
                    a2 = jf.a();
                } catch (Exception e23) {
                    e = e23;
                    nfVar = nfVar11;
                    try {
                        nfVar.h = "errorCode:" + String.valueOf(this.a.c().b) + "|retryCount:" + i5 + "|" + e.getClass().getName() + "|" + e.getMessage();
                        this.a.c().c = -10;
                        BdLog.e(e.getMessage());
                        if (!z3 && i5 == i6 - 1) {
                            nfVar.h += "|" + xf.c();
                            nfVar.h += "|netAvailable:" + mi.A();
                        }
                        this.a.e(nfVar);
                        a2 = jf.a();
                    } catch (Throwable th2) {
                        th = th2;
                        if (!z3 && i5 == i6 - 1) {
                            nfVar.h += "|" + xf.c();
                            nfVar.h += "|netAvailable:" + mi.A();
                        }
                        this.a.e(nfVar);
                        a = jf.a();
                        if (a != null) {
                            a.b(this.a);
                        }
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    nfVar = nfVar11;
                    if (!z3) {
                        nfVar.h += "|" + xf.c();
                        nfVar.h += "|netAvailable:" + mi.A();
                    }
                    this.a.e(nfVar);
                    a = jf.a();
                    if (a != null) {
                    }
                    throw th;
                }
            }
            return z3;
        }
        return invokeCommon.booleanValue;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IGET, CONST, CMP_L]}, finally: {[IGET, CONST, CMP_L, IGET, INVOKE, IF, INVOKE, ARITH, IPUT, IGET, INVOKE, INVOKE, INVOKE, IPUT, IGET, INVOKE, IF, INVOKE, ARITH, IPUT, IGET, INVOKE, INVOKE, IF, IGET, IGET, INVOKE, IF, INVOKE, ARITH, IPUT, IGET, INVOKE, INVOKE, IF] complete} */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x0259, code lost:
        if (r0 == null) goto L58;
     */
    /* JADX WARN: Code restructure failed: missing block: B:94:0x02be, code lost:
        if (r0 == null) goto L58;
     */
    /* JADX WARN: Code restructure failed: missing block: B:95:0x02c0, code lost:
        r0.b(r17.a);
     */
    /* JADX WARN: Code restructure failed: missing block: B:96:0x02c5, code lost:
        r11 = true;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void d(int i, int i2, int i3) {
        int i4;
        int i5;
        kf kfVar;
        jf a;
        kf kfVar2;
        jf a2;
        kf kfVar3;
        kf kfVar4;
        kf kfVar5;
        kf kfVar6;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIII(1048579, this, i, i2, i3) == null) {
            int b = i2 <= 0 ? fb.d().b().b() : i2;
            int a3 = i <= 0 ? fb.d().a() : i;
            int b2 = i3 <= 0 ? fb.d().c().b() : i3;
            long currentTimeMillis = System.currentTimeMillis();
            int i6 = 0;
            boolean z = true;
            for (int i7 = 1; !this.a.c().a && z == i7 && i6 < a3; i7 = 1) {
                nf nfVar = new nf();
                this.a.e(nfVar);
                try {
                    try {
                        this.c = i6;
                        nfVar.e = i6 + 1;
                        nfVar.v = i7;
                        a(i6);
                        kf kfVar7 = new kf(this.a);
                        this.b = kfVar7;
                        kfVar7.r(i6);
                        this.b.s(e);
                        this.b.k(b, b2, nfVar);
                    } finally {
                        if (this.d <= 0 && (kfVar = this.b) != null) {
                            this.d = kfVar.i();
                        }
                        nfVar.f = System.currentTimeMillis() - currentTimeMillis;
                        this.a.f(nfVar);
                        jf a4 = jf.a();
                        if (a4 != null) {
                            a4.b(this.a);
                        }
                    }
                } catch (SocketException e2) {
                    e = e2;
                    i5 = i6;
                } catch (SocketTimeoutException e3) {
                    e = e3;
                    i5 = i6;
                } catch (IOException e4) {
                    e = e4;
                    i5 = i6;
                } catch (Exception e5) {
                    e = e5;
                    i4 = i6;
                }
                if (this.a.c().b != 200) {
                    nfVar.h = String.valueOf(this.a.c().b) + "|retryCount:" + i6;
                    z = l(this.a.c().b);
                    int i8 = i6;
                    if (this.d <= 0 && (kfVar6 = this.b) != null) {
                        this.d = kfVar6.i();
                    }
                    nfVar.f = System.currentTimeMillis() - currentTimeMillis;
                    this.a.f(nfVar);
                    jf a5 = jf.a();
                    if (a5 != null) {
                        a5.b(this.a);
                    }
                    i5 = i8;
                    i6 = i5 + 1;
                } else {
                    i4 = i6;
                    try {
                        this.a.f(nfVar);
                        if (this.d <= 0 && (kfVar5 = this.b) != null) {
                            this.d = kfVar5.i();
                        }
                        nfVar.f = System.currentTimeMillis() - currentTimeMillis;
                        this.a.f(nfVar);
                        a = jf.a();
                        if (a == null) {
                            return;
                        }
                    } catch (SocketException e6) {
                        e = e6;
                        i5 = i4;
                        nfVar.h = String.valueOf(this.a.c().b) + "|retryCount:" + i5 + "|" + e.getClass() + "|" + e.getMessage();
                        this.a.c().c = -12;
                        if (this.d <= 0 && (kfVar4 = this.b) != null) {
                            this.d = kfVar4.i();
                        }
                        nfVar.f = System.currentTimeMillis() - currentTimeMillis;
                        this.a.f(nfVar);
                        a2 = jf.a();
                    } catch (SocketTimeoutException e7) {
                        e = e7;
                        i5 = i4;
                        nfVar.h = String.valueOf(this.a.c().b) + "|retryCount:" + i5 + "|" + e.getClass() + "|" + e.getMessage();
                        this.a.c().c = -13;
                        if (this.d <= 0 && (kfVar3 = this.b) != null) {
                            this.d = kfVar3.i();
                        }
                        nfVar.f = System.currentTimeMillis() - currentTimeMillis;
                        this.a.f(nfVar);
                        a2 = jf.a();
                    } catch (IOException e8) {
                        e = e8;
                        i5 = i4;
                        this.a.c().c = -19;
                        nfVar.h = "errorCode:" + String.valueOf(-19) + "|" + e.getClass() + "|" + e.getMessage() + "|getcontent_illegal_error";
                        i6 = i5 + 1;
                    } catch (Exception e9) {
                        e = e9;
                        nfVar.h = String.valueOf(this.a.c().b) + "|retryCount:" + i4 + "|" + e.getClass() + "|" + e.getMessage();
                        this.a.c().c = -10;
                        BdLog.e(e.getMessage());
                        if (this.d <= 0 && (kfVar2 = this.b) != null) {
                            this.d = kfVar2.i();
                        }
                        nfVar.f = System.currentTimeMillis() - currentTimeMillis;
                        this.a.f(nfVar);
                        a = jf.a();
                        if (a == null) {
                            return;
                        }
                        a.b(this.a);
                        return;
                    }
                    a.b(this.a);
                    return;
                }
            }
        }
    }

    public long e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            kf kfVar = this.b;
            if (kfVar == null) {
                return -1L;
            }
            return kfVar.e();
        }
        return invokeV.longValue;
    }

    public long f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            kf kfVar = this.b;
            if (kfVar == null) {
                return -1L;
            }
            return kfVar.h();
        }
        return invokeV.longValue;
    }

    public long g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            long j = this.d;
            if (j > 0) {
                return j;
            }
            kf kfVar = this.b;
            if (kfVar == null) {
                return -1L;
            }
            return kfVar.i();
        }
        return invokeV.longValue;
    }

    public long h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            kf kfVar = this.b;
            if (kfVar == null) {
                return -1L;
            }
            return kfVar.l();
        }
        return invokeV.longValue;
    }

    public long i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            kf kfVar = this.b;
            if (kfVar == null) {
                return -1L;
            }
            return kfVar.j();
        }
        return invokeV.longValue;
    }

    public int j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.c : invokeV.intValue;
    }

    public boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            of ofVar = this.a;
            if (ofVar == null) {
                return false;
            }
            return ofVar.c().a;
        }
        return invokeV.booleanValue;
    }

    public final boolean l(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048587, this, i)) == null) {
            if (i == 202 || i == 201 || i == 205 || i == 304 || i == 305 || i == 408) {
                return true;
            }
            return (i == 502 || i == 503 || i == 504 || i == 404) ? false : true;
        }
        return invokeI.booleanValue;
    }

    public void m(int i, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIII(1048588, this, i, i2, i3) == null) {
            if (this.a.b().m()) {
                o(i, i2, i3);
            } else {
                n(i, i2, i3);
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:65:0x020e, code lost:
        if (r4 == null) goto L52;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x026a, code lost:
        if (r4 == null) goto L52;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x026c, code lost:
        r4.b(r12.a);
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x0271, code lost:
        r4 = true;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void n(int i, int i2, int i3) {
        kf kfVar;
        jf a;
        kf kfVar2;
        kf kfVar3;
        kf kfVar4;
        kf kfVar5;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIII(1048589, this, i, i2, i3) == null) {
            if (i2 <= 0) {
                i2 = fb.d().b().b();
            }
            if (i <= 0) {
                i = fb.d().a();
            }
            if (i3 <= 0) {
                i3 = fb.d().c().b();
            }
            long currentTimeMillis = System.currentTimeMillis();
            boolean z = true;
            int i4 = 0;
            while (!this.a.c().a && z && i4 < i) {
                nf nfVar = new nf();
                this.c = i4;
                int i5 = i4 + 1;
                nfVar.e = i5;
                a(i4);
                try {
                    try {
                        try {
                            kf kfVar6 = new kf(this.a);
                            this.b = kfVar6;
                            kfVar6.r(i4);
                            this.b.s(e);
                            this.b.q(i2, i3, nfVar);
                        } catch (SocketTimeoutException e2) {
                            this.a.c().c = -13;
                            this.a.c().g = e2.getMessage();
                            nfVar.h = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.obfuscated_res_0x7f0f0c17);
                            BdLog.e(e2.getMessage());
                            this.a.e(nfVar);
                            if (this.d <= 0 && (kfVar3 = this.b) != null) {
                                this.d = kfVar3.i();
                            }
                            nfVar.f = System.currentTimeMillis() - currentTimeMillis;
                            this.a.e(nfVar);
                            a = jf.a();
                        }
                    } catch (SocketException e3) {
                        this.a.c().c = -12;
                        this.a.c().g = e3.getMessage();
                        nfVar.h = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.obfuscated_res_0x7f0f0c17);
                        BdLog.e(e3.getMessage());
                        this.a.e(nfVar);
                        if (this.d <= 0 && (kfVar2 = this.b) != null) {
                            this.d = kfVar2.i();
                        }
                        nfVar.f = System.currentTimeMillis() - currentTimeMillis;
                        this.a.e(nfVar);
                        a = jf.a();
                    }
                } catch (UnsupportedOperationException e4) {
                    try {
                        this.a.c().c = -14;
                        this.a.c().g = e4.getMessage();
                        nfVar.h = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.obfuscated_res_0x7f0f0c17);
                        this.a.e(nfVar);
                        if (this.d <= 0 && (kfVar = this.b) != null) {
                            this.d = kfVar.i();
                        }
                        nfVar.f = System.currentTimeMillis() - currentTimeMillis;
                        this.a.e(nfVar);
                        jf a2 = jf.a();
                        if (a2 != null) {
                            a2.b(this.a);
                        }
                        z = false;
                    }
                }
                if (this.a.c().b != 200) {
                    nfVar.h = String.valueOf(this.a.c().b) + "|retryCount:" + i4;
                    boolean l = l(this.a.c().b);
                    this.a.e(nfVar);
                    if (this.d <= 0 && (kfVar5 = this.b) != null) {
                        this.d = kfVar5.i();
                    }
                    nfVar.f = System.currentTimeMillis() - currentTimeMillis;
                    this.a.e(nfVar);
                    jf a3 = jf.a();
                    if (a3 != null) {
                        a3.b(this.a);
                    }
                    z = l;
                    i4 = i5;
                } else {
                    if (this.d <= 0 && (kfVar4 = this.b) != null) {
                        this.d = kfVar4.i();
                    }
                    nfVar.f = System.currentTimeMillis() - currentTimeMillis;
                    this.a.e(nfVar);
                    jf a4 = jf.a();
                    if (a4 != null) {
                        a4.b(this.a);
                        return;
                    }
                    return;
                }
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:100:0x02a8, code lost:
        r4.b(r12.a);
     */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x0240, code lost:
        if (r5.o() != false) goto L66;
     */
    /* JADX WARN: Code restructure failed: missing block: B:99:0x02a6, code lost:
        if (r5.o() != false) goto L66;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void o(int i, int i2, int i3) {
        jf a;
        kf kfVar;
        kf kfVar2;
        kf kfVar3;
        kf kfVar4;
        kf kfVar5;
        kf kfVar6;
        kf kfVar7;
        kf kfVar8;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIII(1048590, this, i, i2, i3) == null) {
            if (i2 <= 0) {
                i2 = fb.d().b().b();
            }
            if (i <= 0) {
                i = fb.d().a();
            }
            if (i3 <= 0) {
                i3 = fb.d().c().b();
            }
            long currentTimeMillis = System.currentTimeMillis();
            boolean z = true;
            int i4 = 0;
            while (!this.a.c().a && z && i4 < i) {
                nf nfVar = new nf();
                int i5 = i4 + 1;
                nfVar.e = i5;
                this.c = i4;
                a(i4);
                try {
                    try {
                        try {
                            kf kfVar9 = new kf(this.a);
                            this.b = kfVar9;
                            kfVar9.r(i4);
                            this.b.s(e);
                            this.b.p(i2, i3, nfVar);
                        } catch (SocketTimeoutException e2) {
                            this.a.c().c = -13;
                            this.a.c().g = e2.getMessage();
                            nfVar.h = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.obfuscated_res_0x7f0f0c17);
                            BdLog.e(e2.getMessage());
                            this.a.e(nfVar);
                            if (this.d <= 0 && (kfVar4 = this.b) != null) {
                                this.d = kfVar4.i();
                            }
                            nfVar.f = System.currentTimeMillis() - currentTimeMillis;
                            this.a.e(nfVar);
                            a = jf.a();
                            if (a != null) {
                                kf kfVar10 = this.b;
                                if (kfVar10 != null) {
                                }
                            }
                            z = true;
                            i4 = i5;
                        }
                    } catch (UnsupportedOperationException e3) {
                        try {
                            this.a.c().c = -14;
                            this.a.c().g = e3.getMessage();
                            nfVar.h = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.obfuscated_res_0x7f0f0c17);
                            this.a.e(nfVar);
                            if (this.d <= 0 && (kfVar3 = this.b) != null) {
                                this.d = kfVar3.i();
                            }
                            nfVar.f = System.currentTimeMillis() - currentTimeMillis;
                            this.a.e(nfVar);
                            jf a2 = jf.a();
                            if (a2 != null && (kfVar2 = this.b) != null && kfVar2.o()) {
                                a2.b(this.a);
                            }
                            z = false;
                        }
                    }
                } catch (SocketException e4) {
                    this.a.c().c = -12;
                    this.a.c().g = e4.getMessage();
                    nfVar.h = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.obfuscated_res_0x7f0f0c17);
                    BdLog.e(e4.getMessage());
                    this.a.e(nfVar);
                    if (this.d <= 0 && (kfVar = this.b) != null) {
                        this.d = kfVar.i();
                    }
                    nfVar.f = System.currentTimeMillis() - currentTimeMillis;
                    this.a.e(nfVar);
                    a = jf.a();
                    if (a != null) {
                        kf kfVar11 = this.b;
                        if (kfVar11 != null) {
                        }
                    }
                    z = true;
                    i4 = i5;
                }
                if (this.a.c().b != 200) {
                    nfVar.h = String.valueOf(this.a.c().b) + "|retryCount:" + i4;
                    boolean l = l(this.a.c().b);
                    this.a.e(nfVar);
                    if (this.d <= 0 && (kfVar8 = this.b) != null) {
                        this.d = kfVar8.i();
                    }
                    nfVar.f = System.currentTimeMillis() - currentTimeMillis;
                    this.a.e(nfVar);
                    jf a3 = jf.a();
                    if (a3 != null && (kfVar7 = this.b) != null && kfVar7.o()) {
                        a3.b(this.a);
                    }
                    z = l;
                    i4 = i5;
                } else {
                    if (this.d <= 0 && (kfVar6 = this.b) != null) {
                        this.d = kfVar6.i();
                    }
                    nfVar.f = System.currentTimeMillis() - currentTimeMillis;
                    this.a.e(nfVar);
                    jf a4 = jf.a();
                    if (a4 == null || (kfVar5 = this.b) == null || !kfVar5.o()) {
                        return;
                    }
                    a4.b(this.a);
                    return;
                }
            }
        }
    }

    public void p() {
        of ofVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048591, this) == null) || (ofVar = this.a) == null) {
            return;
        }
        ofVar.c().a = true;
    }
}
