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

    public boolean c(String str, sf sfVar, int i, int i2, int i3, int i4, boolean z, boolean z2) {
        InterceptResult invokeCommon;
        nf nfVar;
        int i5;
        int i6;
        String str2;
        int i7;
        nf nfVar2;
        String str3;
        StringBuilder sb;
        StringBuilder sb2;
        nf nfVar3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{str, sfVar, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) {
            String str4 = "responseCode:";
            int b = i3 <= 0 ? fb.d().b().b() : i3;
            int b2 = i4 <= 0 ? fb.d().c().b() : i4;
            kf kfVar = new kf(this.a);
            this.b = kfVar;
            kfVar.r(e);
            int i8 = 0;
            boolean z3 = false;
            for (int a = i <= 0 ? fb.d().a() : i; i8 < a; a = i6) {
                nf nfVar4 = new nf();
                this.a.c().c = -1;
                this.b.q(i8);
                int i9 = i8 + 1;
                try {
                    try {
                        nfVar4.e = i9;
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
                            nfVar2 = nfVar4;
                            i5 = i8;
                            i6 = a;
                        } catch (ConnectException e3) {
                            e = e3;
                            str2 = str4;
                            i7 = i9;
                            nfVar2 = nfVar4;
                            i5 = i8;
                            i6 = a;
                        } catch (SocketException e4) {
                            e = e4;
                            str2 = str4;
                            i7 = i9;
                            nfVar2 = nfVar4;
                            i5 = i8;
                            i6 = a;
                        } catch (SocketTimeoutException e5) {
                            e = e5;
                            str2 = str4;
                            i7 = i9;
                            nfVar2 = nfVar4;
                            i5 = i8;
                            i6 = a;
                        }
                    } catch (IllegalStateException e6) {
                        e = e6;
                        str3 = str4;
                        i7 = i9;
                        nfVar2 = nfVar4;
                        i5 = i8;
                        i6 = a;
                    } catch (ConnectException e7) {
                        e = e7;
                        str3 = str4;
                        i7 = i9;
                        nfVar2 = nfVar4;
                        i5 = i8;
                        i6 = a;
                    } catch (SocketException e8) {
                        e = e8;
                        str3 = str4;
                        i7 = i9;
                        nfVar2 = nfVar4;
                        i5 = i8;
                        i6 = a;
                    } catch (SocketTimeoutException e9) {
                        e = e9;
                        str3 = str4;
                        i7 = i9;
                        nfVar2 = nfVar4;
                        i5 = i8;
                        i6 = a;
                    }
                } catch (FileNotFoundException e10) {
                    e = e10;
                    str2 = str4;
                    i7 = i9;
                    nfVar2 = nfVar4;
                    i5 = i8;
                    i6 = a;
                } catch (UnknownHostException e11) {
                    e = e11;
                    str2 = str4;
                    i7 = i9;
                    nfVar = nfVar4;
                    i5 = i8;
                    i6 = a;
                } catch (SSLException e12) {
                    e = e12;
                    str2 = str4;
                    i7 = i9;
                    nfVar = nfVar4;
                    i5 = i8;
                    i6 = a;
                } catch (IOException e13) {
                    e = e13;
                    str2 = str4;
                    i7 = i9;
                    nfVar = nfVar4;
                    i5 = i8;
                    i6 = a;
                } catch (Exception e14) {
                    e = e14;
                    str2 = str4;
                    i7 = i9;
                    nfVar = nfVar4;
                    i5 = i8;
                    i6 = a;
                } catch (Throwable th) {
                    th = th;
                    nfVar = nfVar4;
                    i5 = i8;
                    i6 = a;
                }
                try {
                    z3 = this.b.d(str, sfVar, b, b2, z, nfVar4, z2);
                    if (!z3 && this.a.c().a) {
                        this.a.c().c = -14;
                    }
                    if (z3 || i5 != i6 - 1) {
                        nfVar3 = nfVar4;
                    } else {
                        StringBuilder sb3 = new StringBuilder();
                        nfVar3 = nfVar4;
                        sb3.append(nfVar3.h);
                        sb3.append("|netAvailable:");
                        sb3.append(ji.A());
                        nfVar3.h = sb3.toString();
                    }
                    this.a.e(nfVar3);
                    return z3;
                } catch (FileNotFoundException e15) {
                    e = e15;
                    nfVar2 = nfVar4;
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
                    nfVar2.h = sb4.toString();
                    this.a.c().c = -100;
                    if (!z3 && i5 == i6 - 1) {
                        sb2 = new StringBuilder();
                        sb2.append(nfVar2.h);
                        sb2.append("|netAvailable:");
                        sb2.append(ji.A());
                        nfVar2.h = sb2.toString();
                    }
                    this.a.e(nfVar2);
                    str4 = str3;
                    i8 = i7;
                } catch (IllegalStateException e16) {
                    e = e16;
                    nfVar2 = nfVar4;
                    str3 = str2;
                    nfVar2.h = str3 + String.valueOf(this.a.c().b) + "|retryCount:" + i5 + "|" + e.getClass().getName() + "|" + e.getMessage() + "|getcontent_illegal_error";
                    this.a.c().c = -19;
                    if (!z3 && i5 == i6 - 1) {
                        sb2 = new StringBuilder();
                        sb2.append(nfVar2.h);
                        sb2.append("|netAvailable:");
                        sb2.append(ji.A());
                        nfVar2.h = sb2.toString();
                    }
                    this.a.e(nfVar2);
                    str4 = str3;
                    i8 = i7;
                } catch (ConnectException e17) {
                    e = e17;
                    nfVar2 = nfVar4;
                    str3 = str2;
                    nfVar2.h = str3 + String.valueOf(this.a.c().b) + "|retryCount:" + i5 + "|" + e.getClass().getName() + "|" + e.getMessage();
                    this.a.c().c = -22;
                    if (!z3 && i5 == i6 - 1) {
                        sb2 = new StringBuilder();
                        sb2.append(nfVar2.h);
                        sb2.append("|netAvailable:");
                        sb2.append(ji.A());
                        nfVar2.h = sb2.toString();
                    }
                    this.a.e(nfVar2);
                    str4 = str3;
                    i8 = i7;
                } catch (SocketException e18) {
                    e = e18;
                    nfVar2 = nfVar4;
                    str3 = str2;
                    nfVar2.h = str3 + String.valueOf(this.a.c().b) + "|retryCount:" + i5 + "|" + e.getClass().getName() + "|" + e.getMessage();
                    this.a.c().c = -12;
                    if (!z3 && i5 == i6 - 1) {
                        sb2 = new StringBuilder();
                        sb2.append(nfVar2.h);
                        sb2.append("|netAvailable:");
                        sb2.append(ji.A());
                        nfVar2.h = sb2.toString();
                    }
                    this.a.e(nfVar2);
                    str4 = str3;
                    i8 = i7;
                } catch (SocketTimeoutException e19) {
                    e = e19;
                    nfVar2 = nfVar4;
                    str3 = str2;
                    nfVar2.h = str3 + String.valueOf(this.a.c().b) + "|retryCount:" + i5 + "|" + e.getClass().getName() + "|" + e.getMessage();
                    this.a.c().c = -13;
                    if (!z3 && i5 == i6 - 1) {
                        sb2 = new StringBuilder();
                        sb2.append(nfVar2.h);
                        sb2.append("|netAvailable:");
                        sb2.append(ji.A());
                        nfVar2.h = sb2.toString();
                    }
                    this.a.e(nfVar2);
                    str4 = str3;
                    i8 = i7;
                } catch (UnknownHostException e20) {
                    e = e20;
                    nfVar = nfVar4;
                    nfVar.h = "errorCode:" + String.valueOf(this.a.c().b) + "|retryCount:" + i5 + "|" + e.getClass().getName() + "|" + e.getMessage();
                    this.a.c().c = -21;
                    if (!z3 && i5 == i6 - 1) {
                        sb = new StringBuilder();
                        sb.append(nfVar.h);
                        sb.append("|netAvailable:");
                        sb.append(ji.A());
                        nfVar.h = sb.toString();
                    }
                    this.a.e(nfVar);
                    str3 = str2;
                    str4 = str3;
                    i8 = i7;
                } catch (SSLException e21) {
                    e = e21;
                    nfVar = nfVar4;
                    if (this.a.b().e() && i5 < i6 - 1) {
                        BdStatisticsManager.getInstance().eventStat(null, "c13429", "", 1, "obj_type", "1");
                    } else {
                        nfVar.h = "errorCode:" + String.valueOf(this.a.c().b) + "|retryCount:" + i5 + "|" + e.getClass().getName() + "|" + e.getMessage();
                        this.a.c().c = -20;
                    }
                    if (!z3 && i5 == i6 - 1) {
                        sb = new StringBuilder();
                        sb.append(nfVar.h);
                        sb.append("|netAvailable:");
                        sb.append(ji.A());
                        nfVar.h = sb.toString();
                    }
                    this.a.e(nfVar);
                    str3 = str2;
                    str4 = str3;
                    i8 = i7;
                } catch (IOException e22) {
                    e = e22;
                    nfVar = nfVar4;
                    nfVar.h = "errorCode:" + String.valueOf(this.a.c().b) + "|retryCount:" + i5 + "|" + e.getClass().getName() + "|" + e.getMessage();
                    this.a.c().c = -19;
                    if (!z3 && i5 == i6 - 1) {
                        sb = new StringBuilder();
                        sb.append(nfVar.h);
                        sb.append("|netAvailable:");
                        sb.append(ji.A());
                        nfVar.h = sb.toString();
                    }
                    this.a.e(nfVar);
                    str3 = str2;
                    str4 = str3;
                    i8 = i7;
                } catch (Exception e23) {
                    e = e23;
                    nfVar = nfVar4;
                    try {
                        nfVar.h = "errorCode:" + String.valueOf(this.a.c().b) + "|retryCount:" + i5 + "|" + e.getClass().getName() + "|" + e.getMessage();
                        this.a.c().c = -10;
                        BdLog.e(e.getMessage());
                        if (!z3 && i5 == i6 - 1) {
                            sb = new StringBuilder();
                            sb.append(nfVar.h);
                            sb.append("|netAvailable:");
                            sb.append(ji.A());
                            nfVar.h = sb.toString();
                        }
                        this.a.e(nfVar);
                        str3 = str2;
                        str4 = str3;
                        i8 = i7;
                    } catch (Throwable th2) {
                        th = th2;
                        if (!z3 && i5 == i6 - 1) {
                            nfVar.h += "|netAvailable:" + ji.A();
                        }
                        this.a.e(nfVar);
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    nfVar = nfVar4;
                    if (!z3) {
                        nfVar.h += "|netAvailable:" + ji.A();
                    }
                    this.a.e(nfVar);
                    throw th;
                }
            }
            return z3;
        }
        return invokeCommon.booleanValue;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IGET, CONST, CMP_L]}, finally: {[IGET, CONST, CMP_L, INVOKE, ARITH, IPUT, IGET, INVOKE, INVOKE, IPUT, INVOKE, ARITH, IPUT, IGET, INVOKE, IF, IGET, INVOKE, ARITH, IPUT, IGET, INVOKE, IF] complete} */
    /* JADX WARN: Code restructure failed: missing block: B:108:0x02e0, code lost:
        if (r0 != null) goto L87;
     */
    /* JADX WARN: Code restructure failed: missing block: B:115:0x032c, code lost:
        if (r0 != null) goto L87;
     */
    /* JADX WARN: Code restructure failed: missing block: B:116:0x032e, code lost:
        r17.d = r0.i();
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x01d2, code lost:
        if (r0 != null) goto L67;
     */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x01d4, code lost:
        r17.d = r0.i();
     */
    /* JADX WARN: Code restructure failed: missing block: B:93:0x0239, code lost:
        if (r0 != null) goto L67;
     */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00aa  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0165  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0167  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0177 A[Catch: all -> 0x01e8, Exception -> 0x01eb, IOException -> 0x023c, SocketTimeoutException -> 0x0297, SocketException -> 0x02e3, TRY_LEAVE, TryCatch #3 {SocketException -> 0x02e3, blocks: (B:66:0x0143, B:70:0x0168, B:72:0x0177, B:79:0x01c5), top: B:130:0x0143, outer: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:79:0x01c5 A[Catch: all -> 0x01e8, Exception -> 0x01eb, IOException -> 0x023c, SocketTimeoutException -> 0x0297, SocketException -> 0x02e3, TRY_ENTER, TRY_LEAVE, TryCatch #3 {SocketException -> 0x02e3, blocks: (B:66:0x0143, B:70:0x0168, B:72:0x0177, B:79:0x01c5), top: B:130:0x0143, outer: #1 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void d(int i, int i2, int i3) {
        int i4;
        int i5;
        nf nfVar;
        kf kfVar;
        kf kfVar2;
        kf kfVar3;
        kf kfVar4;
        kf kfVar5;
        String[] split;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIII(1048579, this, i, i2, i3) == null) {
            int b = i2 <= 0 ? fb.d().b().b() : i2;
            int a = i <= 0 ? fb.d().a() : i;
            int b2 = i3 <= 0 ? fb.d().c().b() : i3;
            String m = this.a.b().m();
            int i6 = 1;
            if (!TextUtils.isEmpty(m) && (m.contains(TbDomainConfig.DOMAIN_HTTPS_SERVER_ADDRESS) || m.contains(TbDomainConfig.DOMAIN_HTTPS_TIEBA))) {
                if (!((Cif) ServiceManager.getService(Cif.a)).isFullHttps()) {
                    List<rf> httpsWhileList = ((Cif) ServiceManager.getService(Cif.a)).getHttpsWhileList();
                    if (httpsWhileList != null && httpsWhileList.size() > 0) {
                        for (rf rfVar : httpsWhileList) {
                            if (rfVar != null && !TextUtils.isEmpty(rfVar.a) && m.contains(rfVar.a)) {
                                i4 = rfVar.b;
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
                            pf b3 = this.a.b();
                            b3.s(TbDomainConfig.DOMAIN_HTTPS_TIEBAC + split2[1]);
                        }
                    } else if (m.contains(TbDomainConfig.DOMAIN_HTTPS_TIEBA) && (split = m.split(TbDomainConfig.DOMAIN_HTTPS_TIEBA)) != null && split.length == 2) {
                        pf b4 = this.a.b();
                        b4.s("https://tieba.baidu.com/" + split[1]);
                    }
                }
                i4 = (((Cif) ServiceManager.getService(Cif.a)).isSwitchOn() || TextUtils.isEmpty(this.a.b().i())) ? 0 : 0;
                long currentTimeMillis = System.currentTimeMillis();
                boolean z = true;
                i5 = 0;
                while (!this.a.c().a && z && i5 < a + i4) {
                    nfVar = new nf();
                    this.a.e(nfVar);
                    try {
                        try {
                            try {
                                try {
                                    this.c = i5;
                                    nfVar.e = i5 + 1;
                                    nfVar.v = i6;
                                    a(i5);
                                    kf kfVar6 = new kf(this.a);
                                    this.b = kfVar6;
                                    kfVar6.q(i5);
                                    this.b.r(e);
                                    this.b.k(i5 >= i4, b, b2, nfVar);
                                } catch (SocketException e2) {
                                    nfVar.h = String.valueOf(this.a.c().b) + "|retryCount:" + i5 + "|" + e2.getClass() + "|" + e2.getMessage();
                                    this.a.c().c = -12;
                                    if (this.d <= 0) {
                                        kfVar2 = this.b;
                                    }
                                    nfVar.f = System.currentTimeMillis() - currentTimeMillis;
                                    this.a.f(nfVar);
                                    z = true;
                                    i5++;
                                    i6 = 1;
                                }
                            } catch (IOException e3) {
                                this.a.c().c = -19;
                                nfVar.h = "errorCode:" + String.valueOf(-19) + "|" + e3.getClass() + "|" + e3.getMessage() + "|getcontent_illegal_error";
                                if (this.d <= 0 && (kfVar3 = this.b) != null) {
                                    this.d = kfVar3.i();
                                }
                                nfVar.f = System.currentTimeMillis() - currentTimeMillis;
                                this.a.f(nfVar);
                            }
                        } catch (SocketTimeoutException e4) {
                            nfVar.h = String.valueOf(this.a.c().b) + "|retryCount:" + i5 + "|" + e4.getClass() + "|" + e4.getMessage();
                            this.a.c().c = -13;
                            if (this.d <= 0) {
                                kfVar2 = this.b;
                            }
                            nfVar.f = System.currentTimeMillis() - currentTimeMillis;
                            this.a.f(nfVar);
                            z = true;
                            i5++;
                            i6 = 1;
                        } catch (Exception e5) {
                            nfVar.h = String.valueOf(this.a.c().b) + "|retryCount:" + i5 + "|" + e5.getClass() + "|" + e5.getMessage();
                            this.a.c().c = -10;
                            BdLog.e(e5.getMessage());
                            if (this.d <= 0) {
                                kfVar = this.b;
                            }
                        }
                        if (this.a.c().b == 200) {
                            nfVar.h = String.valueOf(this.a.c().b) + "|retryCount:" + i5;
                            boolean l = l(this.a.c().b);
                            if (this.d <= 0 && (kfVar5 = this.b) != null) {
                                this.d = kfVar5.i();
                            }
                            nfVar.f = System.currentTimeMillis() - currentTimeMillis;
                            this.a.f(nfVar);
                            z = l;
                            i5++;
                            i6 = 1;
                        } else {
                            this.a.f(nfVar);
                            if (this.d <= 0) {
                                kfVar = this.b;
                            }
                            nfVar.f = System.currentTimeMillis() - currentTimeMillis;
                            this.a.f(nfVar);
                            return;
                        }
                    } catch (Throwable th) {
                        if (this.d <= 0 && (kfVar4 = this.b) != null) {
                            this.d = kfVar4.i();
                        }
                        nfVar.f = System.currentTimeMillis() - currentTimeMillis;
                        this.a.f(nfVar);
                        throw th;
                    }
                }
                return;
            }
            i4 = 0;
            if (i4 > 0) {
            }
            if (((Cif) ServiceManager.getService(Cif.a)).isSwitchOn()) {
            }
            long currentTimeMillis2 = System.currentTimeMillis();
            boolean z2 = true;
            i5 = 0;
            while (!this.a.c().a) {
                nfVar = new nf();
                this.a.e(nfVar);
                this.c = i5;
                nfVar.e = i5 + 1;
                nfVar.v = i6;
                a(i5);
                kf kfVar62 = new kf(this.a);
                this.b = kfVar62;
                kfVar62.q(i5);
                this.b.r(e);
                this.b.k(i5 >= i4, b, b2, nfVar);
                if (this.a.c().b == 200) {
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

    /* JADX WARN: Code restructure failed: missing block: B:105:0x02ed, code lost:
        if (r0 != null) goto L77;
     */
    /* JADX WARN: Code restructure failed: missing block: B:112:0x0344, code lost:
        if (r0 != null) goto L77;
     */
    /* JADX WARN: Code restructure failed: missing block: B:113:0x0346, code lost:
        r16.d = r0.i();
     */
    /* JADX WARN: Removed duplicated region for block: B:134:0x01c0 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x015d  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x015f  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x016f A[Catch: all -> 0x01de, UnsupportedOperationException -> 0x0235, SocketTimeoutException -> 0x0299, SocketException -> 0x02f0, TRY_LEAVE, TryCatch #4 {SocketTimeoutException -> 0x0299, blocks: (B:66:0x0146, B:70:0x0160, B:72:0x016f), top: B:128:0x0146, outer: #2 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void n(int i, int i2, int i3) {
        int i4;
        int i5;
        nf nfVar;
        kf kfVar;
        kf kfVar2;
        kf kfVar3;
        kf kfVar4;
        String[] split;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIII(1048589, this, i, i2, i3) == null) {
            int b = i2 <= 0 ? fb.d().b().b() : i2;
            int a = i <= 0 ? fb.d().a() : i;
            int b2 = i3 <= 0 ? fb.d().c().b() : i3;
            String m = this.a.b().m();
            if (!TextUtils.isEmpty(m) && (m.contains(TbDomainConfig.DOMAIN_HTTPS_SERVER_ADDRESS) || m.contains(TbDomainConfig.DOMAIN_HTTPS_TIEBA))) {
                if (!((Cif) ServiceManager.getService(Cif.a)).isFullHttps()) {
                    List<rf> httpsWhileList = ((Cif) ServiceManager.getService(Cif.a)).getHttpsWhileList();
                    if (httpsWhileList != null && httpsWhileList.size() > 0) {
                        for (rf rfVar : httpsWhileList) {
                            if (rfVar != null && !TextUtils.isEmpty(rfVar.a) && m.contains(rfVar.a)) {
                                i4 = rfVar.b;
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
                            pf b3 = this.a.b();
                            b3.s(TbDomainConfig.DOMAIN_HTTPS_TIEBAC + split2[1]);
                        }
                    } else if (m.contains(TbDomainConfig.DOMAIN_HTTPS_TIEBA) && (split = m.split(TbDomainConfig.DOMAIN_HTTPS_TIEBA)) != null && split.length == 2) {
                        pf b4 = this.a.b();
                        b4.s("https://tieba.baidu.com/" + split[1]);
                    }
                }
                i4 = (((Cif) ServiceManager.getService(Cif.a)).isSwitchOn() || TextUtils.isEmpty(this.a.b().i())) ? 0 : 0;
                long currentTimeMillis = System.currentTimeMillis();
                boolean z = true;
                i5 = 0;
                while (!this.a.c().a && z && i5 < a + i4) {
                    nfVar = new nf();
                    this.c = i5;
                    int i6 = i5 + 1;
                    nfVar.e = i6;
                    a(i5);
                    try {
                        try {
                            kf kfVar5 = new kf(this.a);
                            this.b = kfVar5;
                            kfVar5.q(i5);
                            this.b.r(e);
                            this.b.p(i5 >= i4, b, b2, nfVar);
                        } catch (SocketTimeoutException e2) {
                            this.a.c().c = -13;
                            qf c = this.a.c();
                            c.g = e2.getMessage() + Log.getStackTraceString(e2);
                            nfVar.h = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.obfuscated_res_0x7f0f0c33);
                            BdLog.e(e2.getMessage());
                            this.a.e(nfVar);
                            if (this.d <= 0) {
                                kfVar = this.b;
                            }
                            nfVar.f = System.currentTimeMillis() - currentTimeMillis;
                            this.a.e(nfVar);
                            z = true;
                            i5 = i6;
                        }
                    } catch (UnsupportedOperationException e3) {
                        try {
                            this.a.c().c = -14;
                            qf c2 = this.a.c();
                            c2.g = e3.getMessage() + Log.getStackTraceString(e3);
                            nfVar.h = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.obfuscated_res_0x7f0f0c33);
                            this.a.e(nfVar);
                            if (this.d <= 0 && (kfVar2 = this.b) != null) {
                                this.d = kfVar2.i();
                            }
                            nfVar.f = System.currentTimeMillis() - currentTimeMillis;
                            this.a.e(nfVar);
                            z = false;
                        }
                    } catch (SocketException e4) {
                        this.a.c().c = -12;
                        qf c3 = this.a.c();
                        c3.g = e4.getMessage() + Log.getStackTraceString(e4);
                        nfVar.h = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.obfuscated_res_0x7f0f0c33);
                        BdLog.e(e4.getMessage());
                        this.a.e(nfVar);
                        if (this.d <= 0) {
                            kfVar = this.b;
                        }
                        nfVar.f = System.currentTimeMillis() - currentTimeMillis;
                        this.a.e(nfVar);
                        z = true;
                        i5 = i6;
                    }
                    if (this.a.c().b == 200) {
                        nfVar.h = String.valueOf(this.a.c().b) + "|retryCount:" + i5;
                        z = l(this.a.c().b);
                        this.a.e(nfVar);
                        if (this.d <= 0 && (kfVar4 = this.b) != null) {
                            this.d = kfVar4.i();
                        }
                        nfVar.f = System.currentTimeMillis() - currentTimeMillis;
                        this.a.e(nfVar);
                        i5 = i6;
                    } else {
                        if (this.d <= 0 && (kfVar3 = this.b) != null) {
                            this.d = kfVar3.i();
                        }
                        nfVar.f = System.currentTimeMillis() - currentTimeMillis;
                        this.a.e(nfVar);
                        return;
                    }
                }
                return;
            }
            i4 = 0;
            if (i4 > 0) {
            }
            if (((Cif) ServiceManager.getService(Cif.a)).isSwitchOn()) {
            }
            long currentTimeMillis2 = System.currentTimeMillis();
            boolean z2 = true;
            i5 = 0;
            while (!this.a.c().a) {
                nfVar = new nf();
                this.c = i5;
                int i62 = i5 + 1;
                nfVar.e = i62;
                a(i5);
                kf kfVar52 = new kf(this.a);
                this.b = kfVar52;
                kfVar52.q(i5);
                this.b.r(e);
                this.b.p(i5 >= i4, b, b2, nfVar);
                if (this.a.c().b == 200) {
                }
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:105:0x02ed, code lost:
        if (r0 != null) goto L77;
     */
    /* JADX WARN: Code restructure failed: missing block: B:112:0x0344, code lost:
        if (r0 != null) goto L77;
     */
    /* JADX WARN: Code restructure failed: missing block: B:113:0x0346, code lost:
        r16.d = r0.i();
     */
    /* JADX WARN: Removed duplicated region for block: B:134:0x01c0 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x015d  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x015f  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x016f A[Catch: all -> 0x01de, UnsupportedOperationException -> 0x0235, SocketTimeoutException -> 0x0299, SocketException -> 0x02f0, TRY_LEAVE, TryCatch #4 {SocketTimeoutException -> 0x0299, blocks: (B:66:0x0146, B:70:0x0160, B:72:0x016f), top: B:128:0x0146, outer: #2 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void o(int i, int i2, int i3) {
        int i4;
        int i5;
        nf nfVar;
        kf kfVar;
        kf kfVar2;
        kf kfVar3;
        kf kfVar4;
        String[] split;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIII(1048590, this, i, i2, i3) == null) {
            int b = i2 <= 0 ? fb.d().b().b() : i2;
            int a = i <= 0 ? fb.d().a() : i;
            int b2 = i3 <= 0 ? fb.d().c().b() : i3;
            String m = this.a.b().m();
            if (!TextUtils.isEmpty(m) && (m.contains(TbDomainConfig.DOMAIN_HTTPS_SERVER_ADDRESS) || m.contains(TbDomainConfig.DOMAIN_HTTPS_TIEBA))) {
                if (!((Cif) ServiceManager.getService(Cif.a)).isFullHttps()) {
                    List<rf> httpsWhileList = ((Cif) ServiceManager.getService(Cif.a)).getHttpsWhileList();
                    if (httpsWhileList != null && httpsWhileList.size() > 0) {
                        for (rf rfVar : httpsWhileList) {
                            if (rfVar != null && !TextUtils.isEmpty(rfVar.a) && m.contains(rfVar.a)) {
                                i4 = rfVar.b;
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
                            pf b3 = this.a.b();
                            b3.s(TbDomainConfig.DOMAIN_HTTPS_TIEBAC + split2[1]);
                        }
                    } else if (m.contains(TbDomainConfig.DOMAIN_HTTPS_TIEBA) && (split = m.split(TbDomainConfig.DOMAIN_HTTPS_TIEBA)) != null && split.length == 2) {
                        pf b4 = this.a.b();
                        b4.s("https://tieba.baidu.com/" + split[1]);
                    }
                }
                i4 = (((Cif) ServiceManager.getService(Cif.a)).isSwitchOn() || TextUtils.isEmpty(this.a.b().i())) ? 0 : 0;
                long currentTimeMillis = System.currentTimeMillis();
                boolean z = true;
                i5 = 0;
                while (!this.a.c().a && z && i5 < a + i4) {
                    nfVar = new nf();
                    int i6 = i5 + 1;
                    nfVar.e = i6;
                    this.c = i5;
                    a(i5);
                    try {
                        try {
                            kf kfVar5 = new kf(this.a);
                            this.b = kfVar5;
                            kfVar5.q(i5);
                            this.b.r(e);
                            this.b.o(i5 >= i4, b, b2, nfVar);
                        } catch (SocketTimeoutException e2) {
                            this.a.c().c = -13;
                            qf c = this.a.c();
                            c.g = e2.getMessage() + Log.getStackTraceString(e2);
                            nfVar.h = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.obfuscated_res_0x7f0f0c33);
                            BdLog.e(e2.getMessage());
                            this.a.e(nfVar);
                            if (this.d <= 0) {
                                kfVar = this.b;
                            }
                            nfVar.f = System.currentTimeMillis() - currentTimeMillis;
                            this.a.e(nfVar);
                            z = true;
                            i5 = i6;
                        }
                    } catch (UnsupportedOperationException e3) {
                        try {
                            this.a.c().c = -14;
                            qf c2 = this.a.c();
                            c2.g = e3.getMessage() + Log.getStackTraceString(e3);
                            nfVar.h = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.obfuscated_res_0x7f0f0c33);
                            this.a.e(nfVar);
                            if (this.d <= 0 && (kfVar2 = this.b) != null) {
                                this.d = kfVar2.i();
                            }
                            nfVar.f = System.currentTimeMillis() - currentTimeMillis;
                            this.a.e(nfVar);
                            z = false;
                        }
                    } catch (SocketException e4) {
                        this.a.c().c = -12;
                        qf c3 = this.a.c();
                        c3.g = e4.getMessage() + Log.getStackTraceString(e4);
                        nfVar.h = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.obfuscated_res_0x7f0f0c33);
                        BdLog.e(e4.getMessage());
                        this.a.e(nfVar);
                        if (this.d <= 0) {
                            kfVar = this.b;
                        }
                        nfVar.f = System.currentTimeMillis() - currentTimeMillis;
                        this.a.e(nfVar);
                        z = true;
                        i5 = i6;
                    }
                    if (this.a.c().b == 200) {
                        nfVar.h = String.valueOf(this.a.c().b) + "|retryCount:" + i5;
                        z = l(this.a.c().b);
                        this.a.e(nfVar);
                        if (this.d <= 0 && (kfVar4 = this.b) != null) {
                            this.d = kfVar4.i();
                        }
                        nfVar.f = System.currentTimeMillis() - currentTimeMillis;
                        this.a.e(nfVar);
                        i5 = i6;
                    } else {
                        if (this.d <= 0 && (kfVar3 = this.b) != null) {
                            this.d = kfVar3.i();
                        }
                        nfVar.f = System.currentTimeMillis() - currentTimeMillis;
                        this.a.e(nfVar);
                        return;
                    }
                }
                return;
            }
            i4 = 0;
            if (i4 > 0) {
            }
            if (((Cif) ServiceManager.getService(Cif.a)).isSwitchOn()) {
            }
            long currentTimeMillis2 = System.currentTimeMillis();
            boolean z2 = true;
            i5 = 0;
            while (!this.a.c().a) {
                nfVar = new nf();
                int i62 = i5 + 1;
                nfVar.e = i62;
                this.c = i5;
                a(i5);
                kf kfVar52 = new kf(this.a);
                this.b = kfVar52;
                kfVar52.q(i5);
                this.b.r(e);
                this.b.o(i5 >= i4, b, b2, nfVar);
                if (this.a.c().b == 200) {
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
