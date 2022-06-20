package com.repackage;

import android.text.TextUtils;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.tbadk.TbDomainConfig;
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
import java.util.List;
import javax.net.ssl.SSLException;
/* loaded from: classes6.dex */
public class of {
    public static /* synthetic */ Interceptable $ic = null;
    public static boolean e = true;
    public transient /* synthetic */ FieldHolder $fh;
    public rf a;
    public nf b;
    public int c;
    public long d;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1964031730, "Lcom/repackage/of;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1964031730, "Lcom/repackage/of;");
        }
    }

    public of(rf rfVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {rfVar};
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
        this.a = rfVar;
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
        nf nfVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (nfVar = this.b) == null) {
            return;
        }
        nfVar.b();
    }

    public boolean c(String str, vf vfVar, int i, int i2, int i3, int i4, boolean z, boolean z2) {
        InterceptResult invokeCommon;
        qf qfVar;
        int i5;
        int i6;
        String str2;
        int i7;
        qf qfVar2;
        String str3;
        StringBuilder sb;
        StringBuilder sb2;
        qf qfVar3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{str, vfVar, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) {
            String str4 = "responseCode:";
            int b = i3 <= 0 ? ib.d().b().b() : i3;
            int b2 = i4 <= 0 ? ib.d().c().b() : i4;
            nf nfVar = new nf(this.a);
            this.b = nfVar;
            nfVar.r(e);
            int i8 = 0;
            boolean z3 = false;
            for (int a = i <= 0 ? ib.d().a() : i; i8 < a; a = i6) {
                qf qfVar4 = new qf();
                this.a.c().c = -1;
                this.b.q(i8);
                int i9 = i8 + 1;
                try {
                    try {
                        qfVar4.e = i9;
                        try {
                            this.c = i8;
                            a(i8);
                            str2 = str4;
                            i7 = i9;
                            i5 = i8;
                            i6 = a;
                        } catch (IllegalStateException e2) {
                            e = e2;
                            str2 = str4;
                            i7 = i9;
                            qfVar2 = qfVar4;
                            i5 = i8;
                            i6 = a;
                        } catch (ConnectException e3) {
                            e = e3;
                            str2 = str4;
                            i7 = i9;
                            qfVar2 = qfVar4;
                            i5 = i8;
                            i6 = a;
                        } catch (SocketException e4) {
                            e = e4;
                            str2 = str4;
                            i7 = i9;
                            qfVar2 = qfVar4;
                            i5 = i8;
                            i6 = a;
                        } catch (SocketTimeoutException e5) {
                            e = e5;
                            str2 = str4;
                            i7 = i9;
                            qfVar2 = qfVar4;
                            i5 = i8;
                            i6 = a;
                        }
                    } catch (IllegalStateException e6) {
                        e = e6;
                        str3 = str4;
                        i7 = i9;
                        qfVar2 = qfVar4;
                        i5 = i8;
                        i6 = a;
                    } catch (ConnectException e7) {
                        e = e7;
                        str3 = str4;
                        i7 = i9;
                        qfVar2 = qfVar4;
                        i5 = i8;
                        i6 = a;
                    } catch (SocketException e8) {
                        e = e8;
                        str3 = str4;
                        i7 = i9;
                        qfVar2 = qfVar4;
                        i5 = i8;
                        i6 = a;
                    } catch (SocketTimeoutException e9) {
                        e = e9;
                        str3 = str4;
                        i7 = i9;
                        qfVar2 = qfVar4;
                        i5 = i8;
                        i6 = a;
                    }
                } catch (FileNotFoundException e10) {
                    e = e10;
                    str2 = str4;
                    i7 = i9;
                    qfVar2 = qfVar4;
                    i5 = i8;
                    i6 = a;
                } catch (UnknownHostException e11) {
                    e = e11;
                    str2 = str4;
                    i7 = i9;
                    qfVar = qfVar4;
                    i5 = i8;
                    i6 = a;
                } catch (SSLException e12) {
                    e = e12;
                    str2 = str4;
                    i7 = i9;
                    qfVar = qfVar4;
                    i5 = i8;
                    i6 = a;
                } catch (IOException e13) {
                    e = e13;
                    str2 = str4;
                    i7 = i9;
                    qfVar = qfVar4;
                    i5 = i8;
                    i6 = a;
                } catch (Exception e14) {
                    e = e14;
                    str2 = str4;
                    i7 = i9;
                    qfVar = qfVar4;
                    i5 = i8;
                    i6 = a;
                } catch (Throwable th) {
                    th = th;
                    qfVar = qfVar4;
                    i5 = i8;
                    i6 = a;
                }
                try {
                    z3 = this.b.d(str, vfVar, b, b2, z, qfVar4, z2);
                    if (!z3 && this.a.c().a) {
                        this.a.c().c = -14;
                    }
                    if (z3 || i5 != i6 - 1) {
                        qfVar3 = qfVar4;
                    } else {
                        StringBuilder sb3 = new StringBuilder();
                        qfVar3 = qfVar4;
                        sb3.append(qfVar3.h);
                        sb3.append("|netAvailable:");
                        sb3.append(ni.A());
                        qfVar3.h = sb3.toString();
                    }
                    this.a.e(qfVar3);
                    return z3;
                } catch (FileNotFoundException e15) {
                    e = e15;
                    qfVar2 = qfVar4;
                    StringBuilder sb4 = new StringBuilder();
                    str3 = str2;
                    sb4.append(str3);
                    sb4.append(String.valueOf(this.a.c().b));
                    sb4.append("|retryCount:");
                    sb4.append(i5);
                    sb4.append("|");
                    sb4.append(e.getClass().getName());
                    sb4.append("|");
                    sb4.append(e.getMessage());
                    qfVar2.h = sb4.toString();
                    this.a.c().c = -100;
                    if (!z3 && i5 == i6 - 1) {
                        sb2 = new StringBuilder();
                        sb2.append(qfVar2.h);
                        sb2.append("|netAvailable:");
                        sb2.append(ni.A());
                        qfVar2.h = sb2.toString();
                    }
                    this.a.e(qfVar2);
                    str4 = str3;
                    i8 = i7;
                } catch (IllegalStateException e16) {
                    e = e16;
                    qfVar2 = qfVar4;
                    str3 = str2;
                    qfVar2.h = str3 + String.valueOf(this.a.c().b) + "|retryCount:" + i5 + "|" + e.getClass().getName() + "|" + e.getMessage() + "|getcontent_illegal_error";
                    this.a.c().c = -19;
                    if (!z3 && i5 == i6 - 1) {
                        sb2 = new StringBuilder();
                        sb2.append(qfVar2.h);
                        sb2.append("|netAvailable:");
                        sb2.append(ni.A());
                        qfVar2.h = sb2.toString();
                    }
                    this.a.e(qfVar2);
                    str4 = str3;
                    i8 = i7;
                } catch (ConnectException e17) {
                    e = e17;
                    qfVar2 = qfVar4;
                    str3 = str2;
                    qfVar2.h = str3 + String.valueOf(this.a.c().b) + "|retryCount:" + i5 + "|" + e.getClass().getName() + "|" + e.getMessage();
                    this.a.c().c = -22;
                    if (!z3 && i5 == i6 - 1) {
                        sb2 = new StringBuilder();
                        sb2.append(qfVar2.h);
                        sb2.append("|netAvailable:");
                        sb2.append(ni.A());
                        qfVar2.h = sb2.toString();
                    }
                    this.a.e(qfVar2);
                    str4 = str3;
                    i8 = i7;
                } catch (SocketException e18) {
                    e = e18;
                    qfVar2 = qfVar4;
                    str3 = str2;
                    qfVar2.h = str3 + String.valueOf(this.a.c().b) + "|retryCount:" + i5 + "|" + e.getClass().getName() + "|" + e.getMessage();
                    this.a.c().c = -12;
                    if (!z3 && i5 == i6 - 1) {
                        sb2 = new StringBuilder();
                        sb2.append(qfVar2.h);
                        sb2.append("|netAvailable:");
                        sb2.append(ni.A());
                        qfVar2.h = sb2.toString();
                    }
                    this.a.e(qfVar2);
                    str4 = str3;
                    i8 = i7;
                } catch (SocketTimeoutException e19) {
                    e = e19;
                    qfVar2 = qfVar4;
                    str3 = str2;
                    qfVar2.h = str3 + String.valueOf(this.a.c().b) + "|retryCount:" + i5 + "|" + e.getClass().getName() + "|" + e.getMessage();
                    this.a.c().c = -13;
                    if (!z3 && i5 == i6 - 1) {
                        sb2 = new StringBuilder();
                        sb2.append(qfVar2.h);
                        sb2.append("|netAvailable:");
                        sb2.append(ni.A());
                        qfVar2.h = sb2.toString();
                    }
                    this.a.e(qfVar2);
                    str4 = str3;
                    i8 = i7;
                } catch (UnknownHostException e20) {
                    e = e20;
                    qfVar = qfVar4;
                    qfVar.h = "errorCode:" + String.valueOf(this.a.c().b) + "|retryCount:" + i5 + "|" + e.getClass().getName() + "|" + e.getMessage();
                    this.a.c().c = -21;
                    if (!z3 && i5 == i6 - 1) {
                        sb = new StringBuilder();
                        sb.append(qfVar.h);
                        sb.append("|netAvailable:");
                        sb.append(ni.A());
                        qfVar.h = sb.toString();
                    }
                    this.a.e(qfVar);
                    str3 = str2;
                    str4 = str3;
                    i8 = i7;
                } catch (SSLException e21) {
                    e = e21;
                    qfVar = qfVar4;
                    if (this.a.b().e() && i5 < i6 - 1) {
                        BdStatisticsManager.getInstance().eventStat(null, "c13429", "", 1, "obj_type", "1");
                    } else {
                        qfVar.h = "errorCode:" + String.valueOf(this.a.c().b) + "|retryCount:" + i5 + "|" + e.getClass().getName() + "|" + e.getMessage();
                        this.a.c().c = -20;
                    }
                    if (!z3 && i5 == i6 - 1) {
                        sb = new StringBuilder();
                        sb.append(qfVar.h);
                        sb.append("|netAvailable:");
                        sb.append(ni.A());
                        qfVar.h = sb.toString();
                    }
                    this.a.e(qfVar);
                    str3 = str2;
                    str4 = str3;
                    i8 = i7;
                } catch (IOException e22) {
                    e = e22;
                    qfVar = qfVar4;
                    qfVar.h = "errorCode:" + String.valueOf(this.a.c().b) + "|retryCount:" + i5 + "|" + e.getClass().getName() + "|" + e.getMessage();
                    this.a.c().c = -19;
                    if (!z3 && i5 == i6 - 1) {
                        sb = new StringBuilder();
                        sb.append(qfVar.h);
                        sb.append("|netAvailable:");
                        sb.append(ni.A());
                        qfVar.h = sb.toString();
                    }
                    this.a.e(qfVar);
                    str3 = str2;
                    str4 = str3;
                    i8 = i7;
                } catch (Exception e23) {
                    e = e23;
                    qfVar = qfVar4;
                    try {
                        qfVar.h = "errorCode:" + String.valueOf(this.a.c().b) + "|retryCount:" + i5 + "|" + e.getClass().getName() + "|" + e.getMessage();
                        this.a.c().c = -10;
                        BdLog.e(e.getMessage());
                        if (!z3 && i5 == i6 - 1) {
                            sb = new StringBuilder();
                            sb.append(qfVar.h);
                            sb.append("|netAvailable:");
                            sb.append(ni.A());
                            qfVar.h = sb.toString();
                        }
                        this.a.e(qfVar);
                        str3 = str2;
                        str4 = str3;
                        i8 = i7;
                    } catch (Throwable th2) {
                        th = th2;
                        if (!z3 && i5 == i6 - 1) {
                            qfVar.h += "|netAvailable:" + ni.A();
                        }
                        this.a.e(qfVar);
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    qfVar = qfVar4;
                    if (!z3) {
                        qfVar.h += "|netAvailable:" + ni.A();
                    }
                    this.a.e(qfVar);
                    throw th;
                }
            }
            return z3;
        }
        return invokeCommon.booleanValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:110:0x022f, code lost:
        if (r0 != null) goto L91;
     */
    /* JADX WARN: Code restructure failed: missing block: B:111:0x0231, code lost:
        r23.d = r0.i();
     */
    /* JADX WARN: Code restructure failed: missing block: B:148:0x02dd, code lost:
        if (r0 != null) goto L91;
     */
    /* JADX WARN: Code restructure failed: missing block: B:165:0x03a5, code lost:
        if (r0 != null) goto L99;
     */
    /* JADX WARN: Code restructure failed: missing block: B:173:0x03ff, code lost:
        if (r0 != null) goto L99;
     */
    /* JADX WARN: Code restructure failed: missing block: B:174:0x0401, code lost:
        r23.d = r0.i();
     */
    /* JADX WARN: Removed duplicated region for block: B:103:0x0217  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x02db  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x0332  */
    /* JADX WARN: Removed duplicated region for block: B:164:0x03a3  */
    /* JADX WARN: Removed duplicated region for block: B:172:0x03fd  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00aa  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x014e  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0150  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0177  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0179  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x017c  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x017e  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x019e A[Catch: all -> 0x025a, Exception -> 0x0261, IOException -> 0x0267, SocketTimeoutException -> 0x026f, SocketException -> 0x0277, TRY_LEAVE, TryCatch #10 {SocketException -> 0x0277, SocketTimeoutException -> 0x026f, IOException -> 0x0267, Exception -> 0x0261, all -> 0x025a, blocks: (B:80:0x018f, B:82:0x019e), top: B:193:0x018f }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void d(int i, int i2, int i3) {
        int i4;
        int i5;
        int i6;
        qf qfVar;
        yf yfVar;
        yf yfVar2;
        qf qfVar2;
        int i7;
        int i8;
        nf nfVar;
        nf nfVar2;
        nf nfVar3;
        nf nfVar4;
        nf nfVar5;
        String[] split;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIII(1048579, this, i, i2, i3) == null) {
            int b = i2 <= 0 ? ib.d().b().b() : i2;
            int a = i <= 0 ? ib.d().a() : i;
            int b2 = i3 <= 0 ? ib.d().c().b() : i3;
            String m = this.a.b().m();
            int i9 = 1;
            if (!TextUtils.isEmpty(m) && (m.contains(TbDomainConfig.DOMAIN_HTTPS_SERVER_ADDRESS) || m.contains(TbDomainConfig.DOMAIN_HTTPS_TIEBA))) {
                if (!((lf) ServiceManager.getService(lf.a)).isFullHttps()) {
                    List<uf> httpsWhileList = ((lf) ServiceManager.getService(lf.a)).getHttpsWhileList();
                    if (httpsWhileList != null && httpsWhileList.size() > 0) {
                        for (uf ufVar : httpsWhileList) {
                            if (ufVar != null && !TextUtils.isEmpty(ufVar.a) && m.contains(ufVar.a)) {
                                i4 = ufVar.b;
                                break;
                            }
                        }
                    }
                } else {
                    i4 = 1;
                }
                if (i4 > 0) {
                    if (m.contains(TbDomainConfig.DOMAIN_HTTPS_SERVER_ADDRESS)) {
                        String[] split2 = m.split(TbDomainConfig.DOMAIN_HTTPS_SERVER_ADDRESS);
                        if (split2 != null && split2.length == 2) {
                            sf b3 = this.a.b();
                            b3.s(TbDomainConfig.DOMAIN_HTTPS_TIEBAC + split2[1]);
                        }
                    } else if (m.contains(TbDomainConfig.DOMAIN_HTTPS_TIEBA) && (split = m.split(TbDomainConfig.DOMAIN_HTTPS_TIEBA)) != null && split.length == 2) {
                        sf b4 = this.a.b();
                        b4.s("https://tieba.baidu.com/" + split[1]);
                    }
                }
                i5 = (((lf) ServiceManager.getService(lf.a)).isSwitchOn() || TextUtils.isEmpty(this.a.b().i())) ? 0 : i4;
                long currentTimeMillis = System.currentTimeMillis();
                i6 = 0;
                boolean z = true;
                while (!this.a.c().a && z && i6 < a + i5) {
                    qfVar = new qf();
                    this.a.e(qfVar);
                    yfVar = new yf();
                    yfVar.a = m;
                    yfVar.d = i6 >= i5;
                    try {
                        this.c = i6;
                        qfVar.e = i6 + 1;
                        qfVar.v = i9;
                        a(i6);
                        nf nfVar6 = new nf(this.a);
                        this.b = nfVar6;
                        nfVar6.q(i6);
                        this.b.r(e);
                        i7 = i6;
                        i8 = i5;
                        try {
                            this.b.k(i6 >= i5, i6 >= i9, b, b2, qfVar, yfVar);
                        } catch (SocketException e2) {
                            e = e2;
                            yfVar2 = yfVar;
                            qfVar2 = qfVar;
                        } catch (SocketTimeoutException e3) {
                            e = e3;
                            yfVar2 = yfVar;
                            qfVar2 = qfVar;
                        } catch (IOException e4) {
                            e = e4;
                            yfVar2 = yfVar;
                            qfVar2 = qfVar;
                        } catch (Exception e5) {
                            e = e5;
                            yfVar2 = yfVar;
                            qfVar2 = qfVar;
                        } catch (Throwable th) {
                            th = th;
                            yfVar2 = yfVar;
                            qfVar2 = qfVar;
                        }
                    } catch (SocketException e6) {
                        e = e6;
                        yfVar2 = yfVar;
                        qfVar2 = qfVar;
                        i7 = i6;
                        i8 = i5;
                    } catch (SocketTimeoutException e7) {
                        e = e7;
                        yfVar2 = yfVar;
                        qfVar2 = qfVar;
                        i7 = i6;
                        i8 = i5;
                    } catch (IOException e8) {
                        e = e8;
                        yfVar2 = yfVar;
                        qfVar2 = qfVar;
                        i7 = i6;
                        i8 = i5;
                    } catch (Exception e9) {
                        e = e9;
                        yfVar2 = yfVar;
                        qfVar2 = qfVar;
                        i7 = i6;
                    } catch (Throwable th2) {
                        th = th2;
                        yfVar2 = yfVar;
                        qfVar2 = qfVar;
                    }
                    if (this.a.c().b == 200) {
                        qfVar2 = qfVar;
                        try {
                            qfVar2.h = String.valueOf(this.a.c().b) + "|retryCount:" + i7;
                            z = l(this.a.c().b);
                            yfVar2 = yfVar;
                            try {
                                try {
                                    try {
                                        yfVar2.b = this.a.c().b;
                                        yfVar2.c = "faild";
                                        if (this.d <= 0 && (nfVar5 = this.b) != null) {
                                            this.d = nfVar5.i();
                                        }
                                        qfVar2.f = System.currentTimeMillis() - currentTimeMillis;
                                        this.a.f(qfVar2);
                                        yfVar2.a();
                                    } catch (Throwable th3) {
                                        th = th3;
                                        if (this.d <= 0 && (nfVar4 = this.b) != null) {
                                            this.d = nfVar4.i();
                                        }
                                        qfVar2.f = System.currentTimeMillis() - currentTimeMillis;
                                        this.a.f(qfVar2);
                                        yfVar2.a();
                                        throw th;
                                    }
                                } catch (Exception e10) {
                                    e = e10;
                                    qfVar2.h = String.valueOf(this.a.c().b) + "|retryCount:" + i7 + "|" + e.getClass() + "|" + e.getMessage();
                                    this.a.c().c = -10;
                                    BdLog.e(e.getMessage());
                                    yfVar2.b = -10;
                                    yfVar2.c = Log.getStackTraceString(e);
                                    if (this.d <= 0) {
                                        nfVar3 = this.b;
                                    }
                                    qfVar2.f = System.currentTimeMillis() - currentTimeMillis;
                                    this.a.f(qfVar2);
                                    yfVar2.a();
                                    return;
                                }
                            } catch (SocketException e11) {
                                e = e11;
                                qfVar2.h = String.valueOf(this.a.c().b) + "|retryCount:" + i7 + "|" + e.getClass() + "|" + e.getMessage();
                                this.a.c().c = -12;
                                yfVar2.b = -12;
                                yfVar2.c = Log.getStackTraceString(e);
                                if (this.d <= 0) {
                                    nfVar2 = this.b;
                                }
                                qfVar2.f = System.currentTimeMillis() - currentTimeMillis;
                                this.a.f(qfVar2);
                                yfVar2.a();
                                z = true;
                                i6 = i7 + 1;
                                i5 = i8;
                                i9 = 1;
                            } catch (SocketTimeoutException e12) {
                                e = e12;
                                qfVar2.h = String.valueOf(this.a.c().b) + "|retryCount:" + i7 + "|" + e.getClass() + "|" + e.getMessage();
                                this.a.c().c = -13;
                                yfVar2.b = -13;
                                yfVar2.c = Log.getStackTraceString(e);
                                if (this.d <= 0) {
                                    nfVar2 = this.b;
                                }
                                qfVar2.f = System.currentTimeMillis() - currentTimeMillis;
                                this.a.f(qfVar2);
                                yfVar2.a();
                                z = true;
                                i6 = i7 + 1;
                                i5 = i8;
                                i9 = 1;
                            } catch (IOException e13) {
                                e = e13;
                                this.a.c().c = -19;
                                qfVar2.h = "errorCode:" + String.valueOf(-19) + "|" + e.getClass() + "|" + e.getMessage() + "|getcontent_illegal_error";
                                yfVar2.b = -19;
                                yfVar2.c = Log.getStackTraceString(e);
                                if (this.d <= 0 && (nfVar = this.b) != null) {
                                    this.d = nfVar.i();
                                }
                                qfVar2.f = System.currentTimeMillis() - currentTimeMillis;
                                this.a.f(qfVar2);
                                yfVar2.a();
                                i6 = i7 + 1;
                                i5 = i8;
                                i9 = 1;
                            }
                        } catch (SocketException e14) {
                            e = e14;
                            yfVar2 = yfVar;
                            qfVar2.h = String.valueOf(this.a.c().b) + "|retryCount:" + i7 + "|" + e.getClass() + "|" + e.getMessage();
                            this.a.c().c = -12;
                            yfVar2.b = -12;
                            yfVar2.c = Log.getStackTraceString(e);
                            if (this.d <= 0) {
                            }
                            qfVar2.f = System.currentTimeMillis() - currentTimeMillis;
                            this.a.f(qfVar2);
                            yfVar2.a();
                            z = true;
                            i6 = i7 + 1;
                            i5 = i8;
                            i9 = 1;
                        } catch (SocketTimeoutException e15) {
                            e = e15;
                            yfVar2 = yfVar;
                            qfVar2.h = String.valueOf(this.a.c().b) + "|retryCount:" + i7 + "|" + e.getClass() + "|" + e.getMessage();
                            this.a.c().c = -13;
                            yfVar2.b = -13;
                            yfVar2.c = Log.getStackTraceString(e);
                            if (this.d <= 0) {
                            }
                            qfVar2.f = System.currentTimeMillis() - currentTimeMillis;
                            this.a.f(qfVar2);
                            yfVar2.a();
                            z = true;
                            i6 = i7 + 1;
                            i5 = i8;
                            i9 = 1;
                        } catch (IOException e16) {
                            e = e16;
                            yfVar2 = yfVar;
                            this.a.c().c = -19;
                            qfVar2.h = "errorCode:" + String.valueOf(-19) + "|" + e.getClass() + "|" + e.getMessage() + "|getcontent_illegal_error";
                            yfVar2.b = -19;
                            yfVar2.c = Log.getStackTraceString(e);
                            if (this.d <= 0) {
                            }
                            qfVar2.f = System.currentTimeMillis() - currentTimeMillis;
                            this.a.f(qfVar2);
                            yfVar2.a();
                            i6 = i7 + 1;
                            i5 = i8;
                            i9 = 1;
                        } catch (Exception e17) {
                            e = e17;
                            yfVar2 = yfVar;
                            qfVar2.h = String.valueOf(this.a.c().b) + "|retryCount:" + i7 + "|" + e.getClass() + "|" + e.getMessage();
                            this.a.c().c = -10;
                            BdLog.e(e.getMessage());
                            yfVar2.b = -10;
                            yfVar2.c = Log.getStackTraceString(e);
                            if (this.d <= 0) {
                            }
                            qfVar2.f = System.currentTimeMillis() - currentTimeMillis;
                            this.a.f(qfVar2);
                            yfVar2.a();
                            return;
                        } catch (Throwable th4) {
                            th = th4;
                            yfVar2 = yfVar;
                        }
                        i6 = i7 + 1;
                        i5 = i8;
                        i9 = 1;
                    } else {
                        yfVar2 = yfVar;
                        qfVar2 = qfVar;
                        this.a.f(qfVar2);
                        try {
                            yfVar2.b = 0;
                            yfVar2.c = "ok";
                            if (this.d <= 0) {
                                nfVar3 = this.b;
                            }
                            qfVar2.f = System.currentTimeMillis() - currentTimeMillis;
                            this.a.f(qfVar2);
                            yfVar2.a();
                            return;
                        } catch (SocketException e18) {
                            e = e18;
                            qfVar2.h = String.valueOf(this.a.c().b) + "|retryCount:" + i7 + "|" + e.getClass() + "|" + e.getMessage();
                            this.a.c().c = -12;
                            yfVar2.b = -12;
                            yfVar2.c = Log.getStackTraceString(e);
                            if (this.d <= 0) {
                            }
                            qfVar2.f = System.currentTimeMillis() - currentTimeMillis;
                            this.a.f(qfVar2);
                            yfVar2.a();
                            z = true;
                            i6 = i7 + 1;
                            i5 = i8;
                            i9 = 1;
                        } catch (SocketTimeoutException e19) {
                            e = e19;
                            qfVar2.h = String.valueOf(this.a.c().b) + "|retryCount:" + i7 + "|" + e.getClass() + "|" + e.getMessage();
                            this.a.c().c = -13;
                            yfVar2.b = -13;
                            yfVar2.c = Log.getStackTraceString(e);
                            if (this.d <= 0) {
                            }
                            qfVar2.f = System.currentTimeMillis() - currentTimeMillis;
                            this.a.f(qfVar2);
                            yfVar2.a();
                            z = true;
                            i6 = i7 + 1;
                            i5 = i8;
                            i9 = 1;
                        } catch (IOException e20) {
                            e = e20;
                            this.a.c().c = -19;
                            qfVar2.h = "errorCode:" + String.valueOf(-19) + "|" + e.getClass() + "|" + e.getMessage() + "|getcontent_illegal_error";
                            yfVar2.b = -19;
                            yfVar2.c = Log.getStackTraceString(e);
                            if (this.d <= 0) {
                                this.d = nfVar.i();
                            }
                            qfVar2.f = System.currentTimeMillis() - currentTimeMillis;
                            this.a.f(qfVar2);
                            yfVar2.a();
                            i6 = i7 + 1;
                            i5 = i8;
                            i9 = 1;
                        }
                    }
                }
                return;
            }
            i4 = 0;
            if (i4 > 0) {
            }
            if (((lf) ServiceManager.getService(lf.a)).isSwitchOn()) {
            }
            long currentTimeMillis2 = System.currentTimeMillis();
            i6 = 0;
            boolean z2 = true;
            while (!this.a.c().a) {
                qfVar = new qf();
                this.a.e(qfVar);
                yfVar = new yf();
                yfVar.a = m;
                yfVar.d = i6 >= i5;
                this.c = i6;
                qfVar.e = i6 + 1;
                qfVar.v = i9;
                a(i6);
                nf nfVar62 = new nf(this.a);
                this.b = nfVar62;
                nfVar62.q(i6);
                this.b.r(e);
                i7 = i6;
                i8 = i5;
                this.b.k(i6 >= i5, i6 >= i9, b, b2, qfVar, yfVar);
                if (this.a.c().b == 200) {
                }
            }
        }
    }

    public long e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            nf nfVar = this.b;
            if (nfVar == null) {
                return -1L;
            }
            return nfVar.e();
        }
        return invokeV.longValue;
    }

    public long f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            nf nfVar = this.b;
            if (nfVar == null) {
                return -1L;
            }
            return nfVar.h();
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
            nf nfVar = this.b;
            if (nfVar == null) {
                return -1L;
            }
            return nfVar.i();
        }
        return invokeV.longValue;
    }

    public long h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            nf nfVar = this.b;
            if (nfVar == null) {
                return -1L;
            }
            return nfVar.l();
        }
        return invokeV.longValue;
    }

    public long i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            nf nfVar = this.b;
            if (nfVar == null) {
                return -1L;
            }
            return nfVar.j();
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
            rf rfVar = this.a;
            if (rfVar == null) {
                return false;
            }
            return rfVar.c().a;
        }
        return invokeV.booleanValue;
    }

    public final boolean l(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048587, this, i)) == null) ? (i == 502 || i == 503 || i == 504 || i == 404) ? false : true : invokeI.booleanValue;
    }

    public void m(int i, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIII(1048588, this, i, i2, i3) == null) {
            if (this.a.b().n()) {
                o(i, i2, i3);
            } else {
                n(i, i2, i3);
            }
        }
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IGET, CMP_L]}, finally: {[IGET, CMP_L, INVOKE, ARITH, IPUT, IGET, INVOKE, INVOKE, INVOKE, IPUT, INVOKE, ARITH, IPUT, IGET, INVOKE, INVOKE, IF, IGET, INVOKE, ARITH, IPUT, IGET, INVOKE, INVOKE, IF] complete} */
    /* JADX WARN: Code restructure failed: missing block: B:131:0x02c5, code lost:
        if (r0 != null) goto L80;
     */
    /* JADX WARN: Code restructure failed: missing block: B:139:0x0324, code lost:
        if (r0 != null) goto L80;
     */
    /* JADX WARN: Code restructure failed: missing block: B:140:0x0326, code lost:
        r21.d = r0.i();
     */
    /* JADX WARN: Code restructure failed: missing block: B:148:0x03a2, code lost:
        if (r0 != null) goto L89;
     */
    /* JADX WARN: Code restructure failed: missing block: B:156:0x0408, code lost:
        if (r0 != null) goto L89;
     */
    /* JADX WARN: Code restructure failed: missing block: B:157:0x040a, code lost:
        r21.d = r0.i();
     */
    /* JADX WARN: Removed duplicated region for block: B:101:0x0210  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x02c3  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x0322  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x03a0  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x0406  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0145  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0147  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x016f  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0171  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0174  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0176  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0195 A[Catch: all -> 0x0247, UnsupportedOperationException -> 0x024d, SocketTimeoutException -> 0x0254, SocketException -> 0x025b, TRY_LEAVE, TryCatch #6 {UnsupportedOperationException -> 0x024d, SocketException -> 0x025b, SocketTimeoutException -> 0x0254, all -> 0x0247, blocks: (B:80:0x0186, B:82:0x0195), top: B:180:0x0186 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void n(int i, int i2, int i3) {
        int i4;
        int i5;
        int i6;
        qf qfVar;
        yf yfVar;
        int i7;
        int i8;
        yf yfVar2;
        qf qfVar2;
        int i9;
        nf nfVar;
        nf nfVar2;
        nf nfVar3;
        boolean z;
        int i10;
        nf nfVar4;
        String[] split;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIII(1048589, this, i, i2, i3) == null) {
            int b = i2 <= 0 ? ib.d().b().b() : i2;
            int a = i <= 0 ? ib.d().a() : i;
            int b2 = i3 <= 0 ? ib.d().c().b() : i3;
            String m = this.a.b().m();
            int i11 = 1;
            if (!TextUtils.isEmpty(m) && (m.contains(TbDomainConfig.DOMAIN_HTTPS_SERVER_ADDRESS) || m.contains(TbDomainConfig.DOMAIN_HTTPS_TIEBA))) {
                if (!((lf) ServiceManager.getService(lf.a)).isFullHttps()) {
                    List<uf> httpsWhileList = ((lf) ServiceManager.getService(lf.a)).getHttpsWhileList();
                    if (httpsWhileList != null && httpsWhileList.size() > 0) {
                        for (uf ufVar : httpsWhileList) {
                            if (ufVar != null && !TextUtils.isEmpty(ufVar.a) && m.contains(ufVar.a)) {
                                i4 = ufVar.b;
                                break;
                            }
                        }
                    }
                } else {
                    i4 = 1;
                }
                if (i4 > 0) {
                    if (m.contains(TbDomainConfig.DOMAIN_HTTPS_SERVER_ADDRESS)) {
                        String[] split2 = m.split(TbDomainConfig.DOMAIN_HTTPS_SERVER_ADDRESS);
                        if (split2 != null && split2.length == 2) {
                            this.a.b().s(TbDomainConfig.DOMAIN_HTTPS_TIEBAC + split2[1]);
                        }
                    } else if (m.contains(TbDomainConfig.DOMAIN_HTTPS_TIEBA) && (split = m.split(TbDomainConfig.DOMAIN_HTTPS_TIEBA)) != null && split.length == 2) {
                        this.a.b().s("https://tieba.baidu.com/" + split[1]);
                    }
                }
                i5 = (((lf) ServiceManager.getService(lf.a)).isSwitchOn() || TextUtils.isEmpty(this.a.b().i())) ? 0 : i4;
                long currentTimeMillis = System.currentTimeMillis();
                boolean z2 = true;
                i6 = 0;
                while (!this.a.c().a && z2 && i6 < a + i5) {
                    qfVar = new qf();
                    yfVar = new yf();
                    yfVar.a = m;
                    yfVar.d = i6 >= i5;
                    this.c = i6;
                    i7 = i6 + 1;
                    qfVar.e = i7;
                    a(i6);
                    try {
                        nf nfVar5 = new nf(this.a);
                        this.b = nfVar5;
                        nfVar5.q(i6);
                        this.b.r(e);
                        nf nfVar6 = this.b;
                        z = i6 >= i5;
                        boolean z3 = i6 >= i11;
                        i9 = R.string.obfuscated_res_0x7f0f0c37;
                        boolean z4 = z3;
                        i8 = i7;
                        i10 = i6;
                        try {
                            nfVar6.p(z, z4, b, b2, qfVar, yfVar);
                        } catch (UnsupportedOperationException e2) {
                            e = e2;
                            yfVar2 = yfVar;
                            qfVar2 = qfVar;
                        } catch (SocketException e3) {
                            e = e3;
                            yfVar2 = yfVar;
                            qfVar2 = qfVar;
                        } catch (SocketTimeoutException e4) {
                            e = e4;
                            yfVar2 = yfVar;
                            qfVar2 = qfVar;
                        } catch (Throwable th) {
                            th = th;
                            yfVar2 = yfVar;
                            qfVar2 = qfVar;
                        }
                    } catch (UnsupportedOperationException e5) {
                        e = e5;
                        i8 = i7;
                        yfVar2 = yfVar;
                        qfVar2 = qfVar;
                        i9 = R.string.obfuscated_res_0x7f0f0c37;
                    } catch (SocketException e6) {
                        e = e6;
                        i8 = i7;
                        yfVar2 = yfVar;
                        qfVar2 = qfVar;
                        i9 = R.string.obfuscated_res_0x7f0f0c37;
                    } catch (SocketTimeoutException e7) {
                        e = e7;
                        i8 = i7;
                        yfVar2 = yfVar;
                        qfVar2 = qfVar;
                        i9 = R.string.obfuscated_res_0x7f0f0c37;
                    } catch (Throwable th2) {
                        th = th2;
                        i8 = i7;
                        yfVar2 = yfVar;
                        qfVar2 = qfVar;
                        i9 = R.string.obfuscated_res_0x7f0f0c37;
                    }
                    if (this.a.c().b == 200) {
                        qfVar2 = qfVar;
                        try {
                            qfVar2.h = String.valueOf(this.a.c().b) + "|retryCount:" + i10;
                            z2 = l(this.a.c().b);
                            this.a.e(qfVar2);
                            yfVar2 = yfVar;
                        } catch (UnsupportedOperationException e8) {
                            e = e8;
                            yfVar2 = yfVar;
                            this.a.c().c = -14;
                            this.a.c().g = e.getMessage() + Log.getStackTraceString(e);
                            qfVar2.h = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(i9);
                            this.a.e(qfVar2);
                            yfVar2.b = -14;
                            yfVar2.c = Log.getStackTraceString(e);
                            if (this.d <= 0) {
                                nfVar2 = this.b;
                            }
                            qfVar2.f = System.currentTimeMillis() - currentTimeMillis;
                            this.a.e(qfVar2);
                            yfVar2.a();
                            z2 = false;
                            i6 = i8;
                            i11 = 1;
                        } catch (SocketException e9) {
                            e = e9;
                            yfVar2 = yfVar;
                            this.a.c().c = -12;
                            this.a.c().g = e.getMessage() + Log.getStackTraceString(e);
                            qfVar2.h = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(i9);
                            BdLog.e(e.getMessage());
                            this.a.e(qfVar2);
                            yfVar2.b = -12;
                            yfVar2.c = Log.getStackTraceString(e);
                            if (this.d <= 0) {
                                nfVar3 = this.b;
                            }
                            qfVar2.f = System.currentTimeMillis() - currentTimeMillis;
                            this.a.e(qfVar2);
                            yfVar2.a();
                            z2 = true;
                            i6 = i8;
                            i11 = 1;
                        } catch (SocketTimeoutException e10) {
                            e = e10;
                            yfVar2 = yfVar;
                            this.a.c().c = -13;
                            this.a.c().g = e.getMessage() + Log.getStackTraceString(e);
                            qfVar2.h = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(i9);
                            BdLog.e(e.getMessage());
                            this.a.e(qfVar2);
                            yfVar2.b = -13;
                            yfVar2.c = Log.getStackTraceString(e);
                            if (this.d <= 0) {
                                nfVar3 = this.b;
                            }
                            qfVar2.f = System.currentTimeMillis() - currentTimeMillis;
                            this.a.e(qfVar2);
                            yfVar2.a();
                            z2 = true;
                            i6 = i8;
                            i11 = 1;
                        } catch (Throwable th3) {
                            th = th3;
                            yfVar2 = yfVar;
                            try {
                                this.a.c().c = -10;
                                this.a.c().g = th.getMessage() + Log.getStackTraceString(th);
                                qfVar2.h = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(i9);
                                BdLog.e(th.getMessage());
                                this.a.e(qfVar2);
                                yfVar2.b = -10;
                                yfVar2.c = Log.getStackTraceString(th);
                                if (this.d <= 0) {
                                    nfVar2 = this.b;
                                }
                                qfVar2.f = System.currentTimeMillis() - currentTimeMillis;
                                this.a.e(qfVar2);
                                yfVar2.a();
                                z2 = false;
                                i6 = i8;
                                i11 = 1;
                            } finally {
                                if (this.d <= 0 && (nfVar = this.b) != null) {
                                    this.d = nfVar.i();
                                }
                                qfVar2.f = System.currentTimeMillis() - currentTimeMillis;
                                this.a.e(qfVar2);
                                yfVar2.a();
                            }
                        }
                        try {
                            yfVar2.b = this.a.c().b;
                            yfVar2.c = "faild";
                            if (this.d <= 0 && (nfVar4 = this.b) != null) {
                                this.d = nfVar4.i();
                            }
                            qfVar2.f = System.currentTimeMillis() - currentTimeMillis;
                            this.a.e(qfVar2);
                            yfVar2.a();
                        } catch (UnsupportedOperationException e11) {
                            e = e11;
                            this.a.c().c = -14;
                            this.a.c().g = e.getMessage() + Log.getStackTraceString(e);
                            qfVar2.h = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(i9);
                            this.a.e(qfVar2);
                            yfVar2.b = -14;
                            yfVar2.c = Log.getStackTraceString(e);
                            if (this.d <= 0) {
                            }
                            qfVar2.f = System.currentTimeMillis() - currentTimeMillis;
                            this.a.e(qfVar2);
                            yfVar2.a();
                            z2 = false;
                            i6 = i8;
                            i11 = 1;
                        } catch (SocketException e12) {
                            e = e12;
                            this.a.c().c = -12;
                            this.a.c().g = e.getMessage() + Log.getStackTraceString(e);
                            qfVar2.h = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(i9);
                            BdLog.e(e.getMessage());
                            this.a.e(qfVar2);
                            yfVar2.b = -12;
                            yfVar2.c = Log.getStackTraceString(e);
                            if (this.d <= 0) {
                            }
                            qfVar2.f = System.currentTimeMillis() - currentTimeMillis;
                            this.a.e(qfVar2);
                            yfVar2.a();
                            z2 = true;
                            i6 = i8;
                            i11 = 1;
                        } catch (SocketTimeoutException e13) {
                            e = e13;
                            this.a.c().c = -13;
                            this.a.c().g = e.getMessage() + Log.getStackTraceString(e);
                            qfVar2.h = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(i9);
                            BdLog.e(e.getMessage());
                            this.a.e(qfVar2);
                            yfVar2.b = -13;
                            yfVar2.c = Log.getStackTraceString(e);
                            if (this.d <= 0) {
                            }
                            qfVar2.f = System.currentTimeMillis() - currentTimeMillis;
                            this.a.e(qfVar2);
                            yfVar2.a();
                            z2 = true;
                            i6 = i8;
                            i11 = 1;
                        } catch (Throwable th4) {
                            th = th4;
                            this.a.c().c = -10;
                            this.a.c().g = th.getMessage() + Log.getStackTraceString(th);
                            qfVar2.h = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(i9);
                            BdLog.e(th.getMessage());
                            this.a.e(qfVar2);
                            yfVar2.b = -10;
                            yfVar2.c = Log.getStackTraceString(th);
                            if (this.d <= 0) {
                            }
                            qfVar2.f = System.currentTimeMillis() - currentTimeMillis;
                            this.a.e(qfVar2);
                            yfVar2.a();
                            z2 = false;
                            i6 = i8;
                            i11 = 1;
                        }
                        i6 = i8;
                        i11 = 1;
                    } else {
                        yfVar2 = yfVar;
                        qfVar2 = qfVar;
                        yfVar2.b = 0;
                        yfVar2.c = "ok";
                        return;
                    }
                }
                return;
            }
            i4 = 0;
            if (i4 > 0) {
            }
            if (((lf) ServiceManager.getService(lf.a)).isSwitchOn()) {
            }
            long currentTimeMillis2 = System.currentTimeMillis();
            boolean z22 = true;
            i6 = 0;
            while (!this.a.c().a) {
                qfVar = new qf();
                yfVar = new yf();
                yfVar.a = m;
                yfVar.d = i6 >= i5;
                this.c = i6;
                i7 = i6 + 1;
                qfVar.e = i7;
                a(i6);
                nf nfVar52 = new nf(this.a);
                this.b = nfVar52;
                nfVar52.q(i6);
                this.b.r(e);
                nf nfVar62 = this.b;
                if (i6 >= i5) {
                }
                if (i6 >= i11) {
                }
                i9 = R.string.obfuscated_res_0x7f0f0c37;
                boolean z42 = z3;
                i8 = i7;
                i10 = i6;
                nfVar62.p(z, z42, b, b2, qfVar, yfVar);
                if (this.a.c().b == 200) {
                }
            }
        }
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IGET, CMP_L]}, finally: {[IGET, CMP_L, INVOKE, ARITH, IPUT, IGET, INVOKE, INVOKE, INVOKE, IPUT, INVOKE, ARITH, IPUT, IGET, INVOKE, INVOKE, IF, IGET, INVOKE, ARITH, IPUT, IGET, INVOKE, INVOKE, IF] complete} */
    /* JADX WARN: Code restructure failed: missing block: B:131:0x02c5, code lost:
        if (r0 != null) goto L80;
     */
    /* JADX WARN: Code restructure failed: missing block: B:139:0x0324, code lost:
        if (r0 != null) goto L80;
     */
    /* JADX WARN: Code restructure failed: missing block: B:140:0x0326, code lost:
        r21.d = r0.i();
     */
    /* JADX WARN: Code restructure failed: missing block: B:148:0x03a2, code lost:
        if (r0 != null) goto L89;
     */
    /* JADX WARN: Code restructure failed: missing block: B:156:0x0408, code lost:
        if (r0 != null) goto L89;
     */
    /* JADX WARN: Code restructure failed: missing block: B:157:0x040a, code lost:
        r21.d = r0.i();
     */
    /* JADX WARN: Removed duplicated region for block: B:101:0x0210  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x02c3  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x0322  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x03a0  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x0406  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0145  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0147  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x016f  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0171  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0174  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0176  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0195 A[Catch: all -> 0x0247, UnsupportedOperationException -> 0x024d, SocketTimeoutException -> 0x0254, SocketException -> 0x025b, TRY_LEAVE, TryCatch #6 {UnsupportedOperationException -> 0x024d, SocketException -> 0x025b, SocketTimeoutException -> 0x0254, all -> 0x0247, blocks: (B:80:0x0186, B:82:0x0195), top: B:180:0x0186 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void o(int i, int i2, int i3) {
        int i4;
        int i5;
        int i6;
        qf qfVar;
        yf yfVar;
        int i7;
        int i8;
        yf yfVar2;
        qf qfVar2;
        int i9;
        nf nfVar;
        nf nfVar2;
        nf nfVar3;
        boolean z;
        int i10;
        nf nfVar4;
        String[] split;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIII(1048590, this, i, i2, i3) == null) {
            int b = i2 <= 0 ? ib.d().b().b() : i2;
            int a = i <= 0 ? ib.d().a() : i;
            int b2 = i3 <= 0 ? ib.d().c().b() : i3;
            String m = this.a.b().m();
            int i11 = 1;
            if (!TextUtils.isEmpty(m) && (m.contains(TbDomainConfig.DOMAIN_HTTPS_SERVER_ADDRESS) || m.contains(TbDomainConfig.DOMAIN_HTTPS_TIEBA))) {
                if (!((lf) ServiceManager.getService(lf.a)).isFullHttps()) {
                    List<uf> httpsWhileList = ((lf) ServiceManager.getService(lf.a)).getHttpsWhileList();
                    if (httpsWhileList != null && httpsWhileList.size() > 0) {
                        for (uf ufVar : httpsWhileList) {
                            if (ufVar != null && !TextUtils.isEmpty(ufVar.a) && m.contains(ufVar.a)) {
                                i4 = ufVar.b;
                                break;
                            }
                        }
                    }
                } else {
                    i4 = 1;
                }
                if (i4 > 0) {
                    if (m.contains(TbDomainConfig.DOMAIN_HTTPS_SERVER_ADDRESS)) {
                        String[] split2 = m.split(TbDomainConfig.DOMAIN_HTTPS_SERVER_ADDRESS);
                        if (split2 != null && split2.length == 2) {
                            this.a.b().s(TbDomainConfig.DOMAIN_HTTPS_TIEBAC + split2[1]);
                        }
                    } else if (m.contains(TbDomainConfig.DOMAIN_HTTPS_TIEBA) && (split = m.split(TbDomainConfig.DOMAIN_HTTPS_TIEBA)) != null && split.length == 2) {
                        this.a.b().s("https://tieba.baidu.com/" + split[1]);
                    }
                }
                i5 = (((lf) ServiceManager.getService(lf.a)).isSwitchOn() || TextUtils.isEmpty(this.a.b().i())) ? 0 : i4;
                long currentTimeMillis = System.currentTimeMillis();
                boolean z2 = true;
                i6 = 0;
                while (!this.a.c().a && z2 && i6 < a + i5) {
                    qfVar = new qf();
                    yfVar = new yf();
                    yfVar.a = m;
                    yfVar.d = i6 >= i5;
                    i7 = i6 + 1;
                    qfVar.e = i7;
                    this.c = i6;
                    a(i6);
                    try {
                        nf nfVar5 = new nf(this.a);
                        this.b = nfVar5;
                        nfVar5.q(i6);
                        this.b.r(e);
                        nf nfVar6 = this.b;
                        z = i6 >= i5;
                        boolean z3 = i6 >= i11;
                        i9 = R.string.obfuscated_res_0x7f0f0c37;
                        boolean z4 = z3;
                        i8 = i7;
                        i10 = i6;
                        try {
                            nfVar6.o(z, z4, b, b2, qfVar, yfVar);
                        } catch (UnsupportedOperationException e2) {
                            e = e2;
                            yfVar2 = yfVar;
                            qfVar2 = qfVar;
                        } catch (SocketException e3) {
                            e = e3;
                            yfVar2 = yfVar;
                            qfVar2 = qfVar;
                        } catch (SocketTimeoutException e4) {
                            e = e4;
                            yfVar2 = yfVar;
                            qfVar2 = qfVar;
                        } catch (Throwable th) {
                            th = th;
                            yfVar2 = yfVar;
                            qfVar2 = qfVar;
                        }
                    } catch (UnsupportedOperationException e5) {
                        e = e5;
                        i8 = i7;
                        yfVar2 = yfVar;
                        qfVar2 = qfVar;
                        i9 = R.string.obfuscated_res_0x7f0f0c37;
                    } catch (SocketException e6) {
                        e = e6;
                        i8 = i7;
                        yfVar2 = yfVar;
                        qfVar2 = qfVar;
                        i9 = R.string.obfuscated_res_0x7f0f0c37;
                    } catch (SocketTimeoutException e7) {
                        e = e7;
                        i8 = i7;
                        yfVar2 = yfVar;
                        qfVar2 = qfVar;
                        i9 = R.string.obfuscated_res_0x7f0f0c37;
                    } catch (Throwable th2) {
                        th = th2;
                        i8 = i7;
                        yfVar2 = yfVar;
                        qfVar2 = qfVar;
                        i9 = R.string.obfuscated_res_0x7f0f0c37;
                    }
                    if (this.a.c().b == 200) {
                        qfVar2 = qfVar;
                        try {
                            qfVar2.h = String.valueOf(this.a.c().b) + "|retryCount:" + i10;
                            z2 = l(this.a.c().b);
                            this.a.e(qfVar2);
                            yfVar2 = yfVar;
                        } catch (UnsupportedOperationException e8) {
                            e = e8;
                            yfVar2 = yfVar;
                            this.a.c().c = -14;
                            this.a.c().g = e.getMessage() + Log.getStackTraceString(e);
                            qfVar2.h = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(i9);
                            this.a.e(qfVar2);
                            yfVar2.b = -14;
                            yfVar2.c = Log.getStackTraceString(e);
                            if (this.d <= 0) {
                                nfVar2 = this.b;
                            }
                            qfVar2.f = System.currentTimeMillis() - currentTimeMillis;
                            this.a.e(qfVar2);
                            yfVar2.a();
                            z2 = false;
                            i6 = i8;
                            i11 = 1;
                        } catch (SocketException e9) {
                            e = e9;
                            yfVar2 = yfVar;
                            this.a.c().c = -12;
                            this.a.c().g = e.getMessage() + Log.getStackTraceString(e);
                            qfVar2.h = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(i9);
                            BdLog.e(e.getMessage());
                            this.a.e(qfVar2);
                            yfVar2.b = -12;
                            yfVar2.c = Log.getStackTraceString(e);
                            if (this.d <= 0) {
                                nfVar3 = this.b;
                            }
                            qfVar2.f = System.currentTimeMillis() - currentTimeMillis;
                            this.a.e(qfVar2);
                            yfVar2.a();
                            z2 = true;
                            i6 = i8;
                            i11 = 1;
                        } catch (SocketTimeoutException e10) {
                            e = e10;
                            yfVar2 = yfVar;
                            this.a.c().c = -13;
                            this.a.c().g = e.getMessage() + Log.getStackTraceString(e);
                            qfVar2.h = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(i9);
                            BdLog.e(e.getMessage());
                            this.a.e(qfVar2);
                            yfVar2.b = -13;
                            yfVar2.c = Log.getStackTraceString(e);
                            if (this.d <= 0) {
                                nfVar3 = this.b;
                            }
                            qfVar2.f = System.currentTimeMillis() - currentTimeMillis;
                            this.a.e(qfVar2);
                            yfVar2.a();
                            z2 = true;
                            i6 = i8;
                            i11 = 1;
                        } catch (Throwable th3) {
                            th = th3;
                            yfVar2 = yfVar;
                            try {
                                this.a.c().c = -10;
                                this.a.c().g = th.getMessage() + Log.getStackTraceString(th);
                                qfVar2.h = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(i9);
                                BdLog.e(th.getMessage());
                                this.a.e(qfVar2);
                                yfVar2.b = -10;
                                yfVar2.c = Log.getStackTraceString(th);
                                if (this.d <= 0) {
                                    nfVar2 = this.b;
                                }
                                qfVar2.f = System.currentTimeMillis() - currentTimeMillis;
                                this.a.e(qfVar2);
                                yfVar2.a();
                                z2 = false;
                                i6 = i8;
                                i11 = 1;
                            } finally {
                                if (this.d <= 0 && (nfVar = this.b) != null) {
                                    this.d = nfVar.i();
                                }
                                qfVar2.f = System.currentTimeMillis() - currentTimeMillis;
                                this.a.e(qfVar2);
                                yfVar2.a();
                            }
                        }
                        try {
                            yfVar2.b = this.a.c().b;
                            yfVar2.c = "faild";
                            if (this.d <= 0 && (nfVar4 = this.b) != null) {
                                this.d = nfVar4.i();
                            }
                            qfVar2.f = System.currentTimeMillis() - currentTimeMillis;
                            this.a.e(qfVar2);
                            yfVar2.a();
                        } catch (UnsupportedOperationException e11) {
                            e = e11;
                            this.a.c().c = -14;
                            this.a.c().g = e.getMessage() + Log.getStackTraceString(e);
                            qfVar2.h = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(i9);
                            this.a.e(qfVar2);
                            yfVar2.b = -14;
                            yfVar2.c = Log.getStackTraceString(e);
                            if (this.d <= 0) {
                            }
                            qfVar2.f = System.currentTimeMillis() - currentTimeMillis;
                            this.a.e(qfVar2);
                            yfVar2.a();
                            z2 = false;
                            i6 = i8;
                            i11 = 1;
                        } catch (SocketException e12) {
                            e = e12;
                            this.a.c().c = -12;
                            this.a.c().g = e.getMessage() + Log.getStackTraceString(e);
                            qfVar2.h = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(i9);
                            BdLog.e(e.getMessage());
                            this.a.e(qfVar2);
                            yfVar2.b = -12;
                            yfVar2.c = Log.getStackTraceString(e);
                            if (this.d <= 0) {
                            }
                            qfVar2.f = System.currentTimeMillis() - currentTimeMillis;
                            this.a.e(qfVar2);
                            yfVar2.a();
                            z2 = true;
                            i6 = i8;
                            i11 = 1;
                        } catch (SocketTimeoutException e13) {
                            e = e13;
                            this.a.c().c = -13;
                            this.a.c().g = e.getMessage() + Log.getStackTraceString(e);
                            qfVar2.h = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(i9);
                            BdLog.e(e.getMessage());
                            this.a.e(qfVar2);
                            yfVar2.b = -13;
                            yfVar2.c = Log.getStackTraceString(e);
                            if (this.d <= 0) {
                            }
                            qfVar2.f = System.currentTimeMillis() - currentTimeMillis;
                            this.a.e(qfVar2);
                            yfVar2.a();
                            z2 = true;
                            i6 = i8;
                            i11 = 1;
                        } catch (Throwable th4) {
                            th = th4;
                            this.a.c().c = -10;
                            this.a.c().g = th.getMessage() + Log.getStackTraceString(th);
                            qfVar2.h = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(i9);
                            BdLog.e(th.getMessage());
                            this.a.e(qfVar2);
                            yfVar2.b = -10;
                            yfVar2.c = Log.getStackTraceString(th);
                            if (this.d <= 0) {
                            }
                            qfVar2.f = System.currentTimeMillis() - currentTimeMillis;
                            this.a.e(qfVar2);
                            yfVar2.a();
                            z2 = false;
                            i6 = i8;
                            i11 = 1;
                        }
                        i6 = i8;
                        i11 = 1;
                    } else {
                        yfVar2 = yfVar;
                        qfVar2 = qfVar;
                        yfVar2.b = 0;
                        yfVar2.c = "ok";
                        return;
                    }
                }
                return;
            }
            i4 = 0;
            if (i4 > 0) {
            }
            if (((lf) ServiceManager.getService(lf.a)).isSwitchOn()) {
            }
            long currentTimeMillis2 = System.currentTimeMillis();
            boolean z22 = true;
            i6 = 0;
            while (!this.a.c().a) {
                qfVar = new qf();
                yfVar = new yf();
                yfVar.a = m;
                yfVar.d = i6 >= i5;
                i7 = i6 + 1;
                qfVar.e = i7;
                this.c = i6;
                a(i6);
                nf nfVar52 = new nf(this.a);
                this.b = nfVar52;
                nfVar52.q(i6);
                this.b.r(e);
                nf nfVar62 = this.b;
                if (i6 >= i5) {
                }
                if (i6 >= i11) {
                }
                i9 = R.string.obfuscated_res_0x7f0f0c37;
                boolean z42 = z3;
                i8 = i7;
                i10 = i6;
                nfVar62.o(z, z42, b, b2, qfVar, yfVar);
                if (this.a.c().b == 200) {
                }
            }
        }
    }

    public void p() {
        rf rfVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048591, this) == null) || (rfVar = this.a) == null) {
            return;
        }
        rfVar.c().a = true;
    }
}
