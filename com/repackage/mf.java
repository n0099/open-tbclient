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
public class mf {
    public static /* synthetic */ Interceptable $ic = null;
    public static boolean e = true;
    public transient /* synthetic */ FieldHolder $fh;
    public pf a;
    public lf b;
    public int c;
    public long d;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1964033652, "Lcom/repackage/mf;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1964033652, "Lcom/repackage/mf;");
        }
    }

    public mf(pf pfVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {pfVar};
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
        this.a = pfVar;
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
        lf lfVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (lfVar = this.b) == null) {
            return;
        }
        lfVar.b();
    }

    /* JADX WARN: Code restructure failed: missing block: B:110:0x0364, code lost:
        if (r0 == null) goto L105;
     */
    /* JADX WARN: Code restructure failed: missing block: B:111:0x0366, code lost:
        r0.b(r22.a);
     */
    /* JADX WARN: Code restructure failed: missing block: B:112:0x036b, code lost:
        r9 = r26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x01ca, code lost:
        if (r0 == null) goto L105;
     */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x0245, code lost:
        if (r0 == null) goto L105;
     */
    /* JADX WARN: Code restructure failed: missing block: B:95:0x02c0, code lost:
        if (r0 == null) goto L105;
     */
    /* JADX WARN: Removed duplicated region for block: B:171:0x0611  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean c(String str, tf tfVar, int i, int i2, int i3, int i4, boolean z, boolean z2) {
        InterceptResult invokeCommon;
        of ofVar;
        int i5;
        int i6;
        String str2;
        int i7;
        of ofVar2;
        of ofVar3;
        of ofVar4;
        of ofVar5;
        String str3;
        of ofVar6;
        of ofVar7;
        of ofVar8;
        of ofVar9;
        kf a;
        kf a2;
        kf a3;
        of ofVar10;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{str, tfVar, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) {
            String str4 = "responseCode:";
            int b = i3 <= 0 ? fb.d().b().b() : i3;
            int b2 = i4 <= 0 ? fb.d().c().b() : i4;
            lf lfVar = new lf(this.a);
            this.b = lfVar;
            lfVar.s(e);
            int i8 = 0;
            boolean z3 = false;
            for (int a4 = i <= 0 ? fb.d().a() : i; i8 < a4; a4 = i6) {
                of ofVar11 = new of();
                this.a.c().c = -1;
                this.b.r(i8);
                int i9 = i8 + 1;
                try {
                    try {
                        ofVar11.e = i9;
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
                            ofVar9 = ofVar11;
                            i5 = i8;
                            i6 = a4;
                        } catch (ConnectException e3) {
                            e = e3;
                            str2 = str4;
                            i7 = i9;
                            ofVar8 = ofVar11;
                            i5 = i8;
                            i6 = a4;
                        } catch (SocketException e4) {
                            e = e4;
                            str2 = str4;
                            i7 = i9;
                            ofVar7 = ofVar11;
                            i5 = i8;
                            i6 = a4;
                        } catch (SocketTimeoutException e5) {
                            e = e5;
                            str2 = str4;
                            i7 = i9;
                            ofVar6 = ofVar11;
                            i5 = i8;
                            i6 = a4;
                        }
                    } catch (IllegalStateException e6) {
                        e = e6;
                        str3 = str4;
                        i7 = i9;
                        ofVar9 = ofVar11;
                        i5 = i8;
                        i6 = a4;
                    } catch (ConnectException e7) {
                        e = e7;
                        str3 = str4;
                        i7 = i9;
                        ofVar8 = ofVar11;
                        i5 = i8;
                        i6 = a4;
                    } catch (SocketException e8) {
                        e = e8;
                        str3 = str4;
                        i7 = i9;
                        ofVar7 = ofVar11;
                        i5 = i8;
                        i6 = a4;
                    } catch (SocketTimeoutException e9) {
                        e = e9;
                        str3 = str4;
                        i7 = i9;
                        ofVar6 = ofVar11;
                        i5 = i8;
                        i6 = a4;
                    }
                } catch (FileNotFoundException e10) {
                    e = e10;
                    str2 = str4;
                    i7 = i9;
                    ofVar5 = ofVar11;
                    i5 = i8;
                    i6 = a4;
                } catch (UnknownHostException e11) {
                    e = e11;
                    str2 = str4;
                    i7 = i9;
                    ofVar4 = ofVar11;
                    i5 = i8;
                    i6 = a4;
                } catch (SSLException e12) {
                    e = e12;
                    str2 = str4;
                    i7 = i9;
                    ofVar3 = ofVar11;
                    i5 = i8;
                    i6 = a4;
                } catch (IOException e13) {
                    e = e13;
                    str2 = str4;
                    i7 = i9;
                    ofVar2 = ofVar11;
                    i5 = i8;
                    i6 = a4;
                } catch (Exception e14) {
                    e = e14;
                    str2 = str4;
                    i7 = i9;
                    ofVar = ofVar11;
                    i5 = i8;
                    i6 = a4;
                } catch (Throwable th) {
                    th = th;
                    ofVar = ofVar11;
                    i5 = i8;
                    i6 = a4;
                }
                try {
                    z3 = this.b.d(str, tfVar, b, b2, z, ofVar11, z2);
                    if (!z3 && this.a.c().a) {
                        this.a.c().c = -14;
                    }
                    if (z3 || i5 != i6 - 1) {
                        ofVar10 = ofVar11;
                    } else {
                        StringBuilder sb = new StringBuilder();
                        ofVar10 = ofVar11;
                        sb.append(ofVar10.h);
                        sb.append("|netAvailable:");
                        sb.append(ki.A());
                        ofVar10.h = sb.toString();
                    }
                    this.a.e(ofVar10);
                    kf a5 = kf.a();
                    if (a5 != null) {
                        a5.b(this.a);
                    }
                    return z3;
                } catch (FileNotFoundException e15) {
                    e = e15;
                    ofVar5 = ofVar11;
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
                    ofVar5.h = sb2.toString();
                    this.a.c().c = -100;
                    if (!z3 && i5 == i6 - 1) {
                        ofVar5.h += "|netAvailable:" + ki.A();
                    }
                    this.a.e(ofVar5);
                    a3 = kf.a();
                    if (a3 == null) {
                        str4 = str3;
                        i8 = i7;
                    }
                    a3.b(this.a);
                    str4 = str3;
                    i8 = i7;
                } catch (IllegalStateException e16) {
                    e = e16;
                    ofVar9 = ofVar11;
                    str3 = str2;
                    ofVar9.h = str3 + String.valueOf(this.a.c().b) + "|retryCount:" + i5 + "|" + e.getClass().getName() + "|" + e.getMessage() + "|getcontent_illegal_error";
                    this.a.c().c = -19;
                    if (!z3 && i5 == i6 - 1) {
                        ofVar9.h += "|netAvailable:" + ki.A();
                    }
                    this.a.e(ofVar9);
                    a3 = kf.a();
                    if (a3 == null) {
                        str4 = str3;
                        i8 = i7;
                    }
                    a3.b(this.a);
                    str4 = str3;
                    i8 = i7;
                } catch (ConnectException e17) {
                    e = e17;
                    ofVar8 = ofVar11;
                    str3 = str2;
                    ofVar8.h = str3 + String.valueOf(this.a.c().b) + "|retryCount:" + i5 + "|" + e.getClass().getName() + "|" + e.getMessage();
                    this.a.c().c = -22;
                    if (!z3 && i5 == i6 - 1) {
                        ofVar8.h += "|netAvailable:" + ki.A();
                    }
                    this.a.e(ofVar8);
                    a3 = kf.a();
                    if (a3 == null) {
                        str4 = str3;
                        i8 = i7;
                    }
                    a3.b(this.a);
                    str4 = str3;
                    i8 = i7;
                } catch (SocketException e18) {
                    e = e18;
                    ofVar7 = ofVar11;
                    str3 = str2;
                    ofVar7.h = str3 + String.valueOf(this.a.c().b) + "|retryCount:" + i5 + "|" + e.getClass().getName() + "|" + e.getMessage();
                    this.a.c().c = -12;
                    if (!z3 && i5 == i6 - 1) {
                        ofVar7.h += "|netAvailable:" + ki.A();
                    }
                    this.a.e(ofVar7);
                    a3 = kf.a();
                    if (a3 == null) {
                        str4 = str3;
                        i8 = i7;
                    }
                    a3.b(this.a);
                    str4 = str3;
                    i8 = i7;
                } catch (SocketTimeoutException e19) {
                    e = e19;
                    ofVar6 = ofVar11;
                    str3 = str2;
                    ofVar6.h = str3 + String.valueOf(this.a.c().b) + "|retryCount:" + i5 + "|" + e.getClass().getName() + "|" + e.getMessage();
                    this.a.c().c = -13;
                    if (!z3 && i5 == i6 - 1) {
                        ofVar6.h += "|netAvailable:" + ki.A();
                    }
                    this.a.e(ofVar6);
                    a3 = kf.a();
                    if (a3 == null) {
                        str4 = str3;
                        i8 = i7;
                    }
                    a3.b(this.a);
                    str4 = str3;
                    i8 = i7;
                } catch (UnknownHostException e20) {
                    e = e20;
                    ofVar4 = ofVar11;
                    ofVar4.h = "errorCode:" + String.valueOf(this.a.c().b) + "|retryCount:" + i5 + "|" + e.getClass().getName() + "|" + e.getMessage();
                    this.a.c().c = -21;
                    if (!z3 && i5 == i6 - 1) {
                        ofVar4.h += "|netAvailable:" + ki.A();
                    }
                    this.a.e(ofVar4);
                    a2 = kf.a();
                } catch (SSLException e21) {
                    e = e21;
                    ofVar3 = ofVar11;
                    if (this.a.b().e() && i5 < i6 - 1) {
                        BdStatisticsManager.getInstance().eventStat(null, "c13429", "", 1, "obj_type", "1");
                    } else {
                        ofVar3.h = "errorCode:" + String.valueOf(this.a.c().b) + "|retryCount:" + i5 + "|" + e.getClass().getName() + "|" + e.getMessage();
                        this.a.c().c = -20;
                    }
                    if (!z3 && i5 == i6 - 1) {
                        ofVar3.h += "|netAvailable:" + ki.A();
                    }
                    this.a.e(ofVar3);
                    a2 = kf.a();
                } catch (IOException e22) {
                    e = e22;
                    ofVar2 = ofVar11;
                    ofVar2.h = "errorCode:" + String.valueOf(this.a.c().b) + "|retryCount:" + i5 + "|" + e.getClass().getName() + "|" + e.getMessage();
                    this.a.c().c = -19;
                    if (!z3 && i5 == i6 - 1) {
                        ofVar2.h += "|netAvailable:" + ki.A();
                    }
                    this.a.e(ofVar2);
                    a2 = kf.a();
                } catch (Exception e23) {
                    e = e23;
                    ofVar = ofVar11;
                    try {
                        ofVar.h = "errorCode:" + String.valueOf(this.a.c().b) + "|retryCount:" + i5 + "|" + e.getClass().getName() + "|" + e.getMessage();
                        this.a.c().c = -10;
                        BdLog.e(e.getMessage());
                        if (!z3 && i5 == i6 - 1) {
                            ofVar.h += "|netAvailable:" + ki.A();
                        }
                        this.a.e(ofVar);
                        a2 = kf.a();
                    } catch (Throwable th2) {
                        th = th2;
                        if (!z3 && i5 == i6 - 1) {
                            ofVar.h += "|netAvailable:" + ki.A();
                        }
                        this.a.e(ofVar);
                        a = kf.a();
                        if (a != null) {
                            a.b(this.a);
                        }
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    ofVar = ofVar11;
                    if (!z3) {
                        ofVar.h += "|netAvailable:" + ki.A();
                    }
                    this.a.e(ofVar);
                    a = kf.a();
                    if (a != null) {
                    }
                    throw th;
                }
            }
            return z3;
        }
        return invokeCommon.booleanValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:121:0x0331, code lost:
        if (r0 == null) goto L99;
     */
    /* JADX WARN: Code restructure failed: missing block: B:131:0x0395, code lost:
        if (r0 == null) goto L99;
     */
    /* JADX WARN: Code restructure failed: missing block: B:132:0x0397, code lost:
        r0.b(r17.a);
     */
    /* JADX WARN: Code restructure failed: missing block: B:133:0x039c, code lost:
        r12 = true;
     */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00aa  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0165  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0167  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0177 A[Catch: all -> 0x01fe, Exception -> 0x0201, IOException -> 0x026a, SocketTimeoutException -> 0x02d0, SocketException -> 0x0334, TRY_LEAVE, TryCatch #3 {SocketException -> 0x0334, blocks: (B:66:0x0143, B:70:0x0168, B:72:0x0177, B:82:0x01d0), top: B:148:0x0143, outer: #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:82:0x01d0 A[Catch: all -> 0x01fe, Exception -> 0x0201, IOException -> 0x026a, SocketTimeoutException -> 0x02d0, SocketException -> 0x0334, TRY_ENTER, TRY_LEAVE, TryCatch #3 {SocketException -> 0x0334, blocks: (B:66:0x0143, B:70:0x0168, B:72:0x0177, B:82:0x01d0), top: B:148:0x0143, outer: #2 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void d(int i, int i2, int i3) {
        int i4;
        int i5;
        of ofVar;
        lf lfVar;
        kf a;
        lf lfVar2;
        kf a2;
        lf lfVar3;
        lf lfVar4;
        lf lfVar5;
        lf lfVar6;
        lf lfVar7;
        String[] split;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIII(1048579, this, i, i2, i3) == null) {
            int b = i2 <= 0 ? fb.d().b().b() : i2;
            int a3 = i <= 0 ? fb.d().a() : i;
            int b2 = i3 <= 0 ? fb.d().c().b() : i3;
            String m = this.a.b().m();
            int i6 = 1;
            if (!TextUtils.isEmpty(m) && (m.contains(TbDomainConfig.DOMAIN_HTTPS_SERVER_ADDRESS) || m.contains(TbDomainConfig.DOMAIN_HTTPS_TIEBA))) {
                if (!((Cif) ServiceManager.getService(Cif.a)).isFullHttps()) {
                    List<sf> httpsWhileList = ((Cif) ServiceManager.getService(Cif.a)).getHttpsWhileList();
                    if (httpsWhileList != null && httpsWhileList.size() > 0) {
                        for (sf sfVar : httpsWhileList) {
                            if (sfVar != null && !TextUtils.isEmpty(sfVar.a) && m.contains(sfVar.a)) {
                                i4 = sfVar.b;
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
                            qf b3 = this.a.b();
                            b3.s(TbDomainConfig.DOMAIN_HTTPS_TIEBAC + split2[1]);
                        }
                    } else if (m.contains(TbDomainConfig.DOMAIN_HTTPS_TIEBA) && (split = m.split(TbDomainConfig.DOMAIN_HTTPS_TIEBA)) != null && split.length == 2) {
                        qf b4 = this.a.b();
                        b4.s("https://tieba.baidu.com/" + split[1]);
                    }
                }
                i4 = (((Cif) ServiceManager.getService(Cif.a)).isSwitchOn() || TextUtils.isEmpty(this.a.b().i())) ? 0 : 0;
                long currentTimeMillis = System.currentTimeMillis();
                boolean z = true;
                i5 = 0;
                while (!this.a.c().a && z && i5 < a3 + i4) {
                    ofVar = new of();
                    this.a.e(ofVar);
                    try {
                        try {
                            try {
                                try {
                                    this.c = i5;
                                    ofVar.e = i5 + 1;
                                    ofVar.v = i6;
                                    a(i5);
                                    lf lfVar8 = new lf(this.a);
                                    this.b = lfVar8;
                                    lfVar8.r(i5);
                                    this.b.s(e);
                                    this.b.k(i5 >= i4, b, b2, ofVar);
                                } catch (SocketException e2) {
                                    ofVar.h = String.valueOf(this.a.c().b) + "|retryCount:" + i5 + "|" + e2.getClass() + "|" + e2.getMessage();
                                    this.a.c().c = -12;
                                    if (this.d <= 0 && (lfVar4 = this.b) != null) {
                                        this.d = lfVar4.i();
                                    }
                                    ofVar.f = System.currentTimeMillis() - currentTimeMillis;
                                    this.a.f(ofVar);
                                    a = kf.a();
                                }
                            } catch (Exception e3) {
                                ofVar.h = String.valueOf(this.a.c().b) + "|retryCount:" + i5 + "|" + e3.getClass() + "|" + e3.getMessage();
                                this.a.c().c = -10;
                                BdLog.e(e3.getMessage());
                                if (this.d <= 0 && (lfVar3 = this.b) != null) {
                                    this.d = lfVar3.i();
                                }
                                ofVar.f = System.currentTimeMillis() - currentTimeMillis;
                                this.a.f(ofVar);
                                a2 = kf.a();
                                if (a2 == null) {
                                    return;
                                }
                            }
                        } catch (SocketTimeoutException e4) {
                            ofVar.h = String.valueOf(this.a.c().b) + "|retryCount:" + i5 + "|" + e4.getClass() + "|" + e4.getMessage();
                            this.a.c().c = -13;
                            if (this.d <= 0 && (lfVar2 = this.b) != null) {
                                this.d = lfVar2.i();
                            }
                            ofVar.f = System.currentTimeMillis() - currentTimeMillis;
                            this.a.f(ofVar);
                            a = kf.a();
                        } catch (IOException e5) {
                            this.a.c().c = -19;
                            ofVar.h = "errorCode:" + String.valueOf(-19) + "|" + e5.getClass() + "|" + e5.getMessage() + "|getcontent_illegal_error";
                            if (this.d <= 0 && (lfVar = this.b) != null) {
                                this.d = lfVar.i();
                            }
                            ofVar.f = System.currentTimeMillis() - currentTimeMillis;
                            this.a.f(ofVar);
                            kf a4 = kf.a();
                            if (a4 != null) {
                                a4.b(this.a);
                            }
                        }
                        if (this.a.c().b == 200) {
                            ofVar.h = String.valueOf(this.a.c().b) + "|retryCount:" + i5;
                            boolean l = l(this.a.c().b);
                            if (this.d <= 0 && (lfVar7 = this.b) != null) {
                                this.d = lfVar7.i();
                            }
                            ofVar.f = System.currentTimeMillis() - currentTimeMillis;
                            this.a.f(ofVar);
                            kf a5 = kf.a();
                            if (a5 != null) {
                                a5.b(this.a);
                            }
                            z = l;
                            i5++;
                            i6 = 1;
                        } else {
                            this.a.f(ofVar);
                            if (this.d <= 0 && (lfVar6 = this.b) != null) {
                                this.d = lfVar6.i();
                            }
                            ofVar.f = System.currentTimeMillis() - currentTimeMillis;
                            this.a.f(ofVar);
                            a2 = kf.a();
                            if (a2 == null) {
                                return;
                            }
                            a2.b(this.a);
                            return;
                        }
                    } catch (Throwable th) {
                        if (this.d <= 0 && (lfVar5 = this.b) != null) {
                            this.d = lfVar5.i();
                        }
                        ofVar.f = System.currentTimeMillis() - currentTimeMillis;
                        this.a.f(ofVar);
                        kf a6 = kf.a();
                        if (a6 != null) {
                            a6.b(this.a);
                        }
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
                ofVar = new of();
                this.a.e(ofVar);
                this.c = i5;
                ofVar.e = i5 + 1;
                ofVar.v = i6;
                a(i5);
                lf lfVar82 = new lf(this.a);
                this.b = lfVar82;
                lfVar82.r(i5);
                this.b.s(e);
                this.b.k(i5 >= i4, b, b2, ofVar);
                if (this.a.c().b == 200) {
                }
            }
        }
    }

    public long e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            lf lfVar = this.b;
            if (lfVar == null) {
                return -1L;
            }
            return lfVar.e();
        }
        return invokeV.longValue;
    }

    public long f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            lf lfVar = this.b;
            if (lfVar == null) {
                return -1L;
            }
            return lfVar.h();
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
            lf lfVar = this.b;
            if (lfVar == null) {
                return -1L;
            }
            return lfVar.i();
        }
        return invokeV.longValue;
    }

    public long h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            lf lfVar = this.b;
            if (lfVar == null) {
                return -1L;
            }
            return lfVar.l();
        }
        return invokeV.longValue;
    }

    public long i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            lf lfVar = this.b;
            if (lfVar == null) {
                return -1L;
            }
            return lfVar.j();
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
            pf pfVar = this.a;
            if (pfVar == null) {
                return false;
            }
            return pfVar.c().a;
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

    /* JADX DEBUG: Finally have unexpected throw blocks count: 0, expect 1 */
    /* JADX WARN: Code restructure failed: missing block: B:107:0x02c8, code lost:
        if (r0 == null) goto L87;
     */
    /* JADX WARN: Code restructure failed: missing block: B:108:0x02ca, code lost:
        r0.b(r16.a);
     */
    /* JADX WARN: Code restructure failed: missing block: B:109:0x02cf, code lost:
        r0 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:118:0x033e, code lost:
        if (r0 == null) goto L98;
     */
    /* JADX WARN: Code restructure failed: missing block: B:128:0x03ad, code lost:
        if (r0 == null) goto L98;
     */
    /* JADX WARN: Code restructure failed: missing block: B:129:0x03af, code lost:
        r0.b(r16.a);
     */
    /* JADX WARN: Code restructure failed: missing block: B:130:0x03b4, code lost:
        r0 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:97:0x0260, code lost:
        if (r0 == null) goto L87;
     */
    /* JADX WARN: Removed duplicated region for block: B:153:0x01cb A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x015d  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x015f  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x016f A[Catch: all -> 0x01f4, UnsupportedOperationException -> 0x0263, SocketTimeoutException -> 0x02d2, SocketException -> 0x0341, TRY_LEAVE, TryCatch #5 {UnsupportedOperationException -> 0x0263, SocketTimeoutException -> 0x02d2, blocks: (B:66:0x0146, B:70:0x0160, B:72:0x016f), top: B:148:0x0146, outer: #3 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void n(int i, int i2, int i3) {
        int i4;
        int i5;
        of ofVar;
        kf a;
        lf lfVar;
        kf a2;
        lf lfVar2;
        lf lfVar3;
        lf lfVar4;
        lf lfVar5;
        lf lfVar6;
        lf lfVar7;
        String[] split;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIII(1048589, this, i, i2, i3) == null) {
            int b = i2 <= 0 ? fb.d().b().b() : i2;
            int a3 = i <= 0 ? fb.d().a() : i;
            int b2 = i3 <= 0 ? fb.d().c().b() : i3;
            String m = this.a.b().m();
            if (!TextUtils.isEmpty(m) && (m.contains(TbDomainConfig.DOMAIN_HTTPS_SERVER_ADDRESS) || m.contains(TbDomainConfig.DOMAIN_HTTPS_TIEBA))) {
                if (!((Cif) ServiceManager.getService(Cif.a)).isFullHttps()) {
                    List<sf> httpsWhileList = ((Cif) ServiceManager.getService(Cif.a)).getHttpsWhileList();
                    if (httpsWhileList != null && httpsWhileList.size() > 0) {
                        for (sf sfVar : httpsWhileList) {
                            if (sfVar != null && !TextUtils.isEmpty(sfVar.a) && m.contains(sfVar.a)) {
                                i4 = sfVar.b;
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
                            qf b3 = this.a.b();
                            b3.s(TbDomainConfig.DOMAIN_HTTPS_TIEBAC + split2[1]);
                        }
                    } else if (m.contains(TbDomainConfig.DOMAIN_HTTPS_TIEBA) && (split = m.split(TbDomainConfig.DOMAIN_HTTPS_TIEBA)) != null && split.length == 2) {
                        qf b4 = this.a.b();
                        b4.s("https://tieba.baidu.com/" + split[1]);
                    }
                }
                i4 = (((Cif) ServiceManager.getService(Cif.a)).isSwitchOn() || TextUtils.isEmpty(this.a.b().i())) ? 0 : 0;
                long currentTimeMillis = System.currentTimeMillis();
                boolean z = true;
                i5 = 0;
                while (!this.a.c().a && z && i5 < a3 + i4) {
                    ofVar = new of();
                    this.c = i5;
                    int i6 = i5 + 1;
                    ofVar.e = i6;
                    a(i5);
                    try {
                        try {
                            lf lfVar8 = new lf(this.a);
                            this.b = lfVar8;
                            lfVar8.r(i5);
                            this.b.s(e);
                            this.b.q(i5 >= i4, b, b2, ofVar);
                        } catch (UnsupportedOperationException e2) {
                            this.a.c().c = -14;
                            rf c = this.a.c();
                            c.g = e2.getMessage() + Log.getStackTraceString(e2);
                            ofVar.h = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.obfuscated_res_0x7f0f0c2d);
                            this.a.e(ofVar);
                            if (this.d <= 0 && (lfVar5 = this.b) != null) {
                                this.d = lfVar5.i();
                            }
                            ofVar.f = System.currentTimeMillis() - currentTimeMillis;
                            this.a.e(ofVar);
                            a = kf.a();
                        } catch (SocketTimeoutException e3) {
                            this.a.c().c = -13;
                            rf c2 = this.a.c();
                            c2.g = e3.getMessage() + Log.getStackTraceString(e3);
                            ofVar.h = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.obfuscated_res_0x7f0f0c2d);
                            BdLog.e(e3.getMessage());
                            this.a.e(ofVar);
                            if (this.d <= 0 && (lfVar4 = this.b) != null) {
                                this.d = lfVar4.i();
                            }
                            ofVar.f = System.currentTimeMillis() - currentTimeMillis;
                            this.a.e(ofVar);
                            a2 = kf.a();
                        }
                    } catch (SocketException e4) {
                        this.a.c().c = -12;
                        rf c3 = this.a.c();
                        c3.g = e4.getMessage() + Log.getStackTraceString(e4);
                        ofVar.h = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.obfuscated_res_0x7f0f0c2d);
                        BdLog.e(e4.getMessage());
                        this.a.e(ofVar);
                        if (this.d <= 0 && (lfVar2 = this.b) != null) {
                            this.d = lfVar2.i();
                        }
                        ofVar.f = System.currentTimeMillis() - currentTimeMillis;
                        this.a.e(ofVar);
                        a2 = kf.a();
                    } catch (Throwable th) {
                        try {
                            this.a.c().c = -10;
                            rf c4 = this.a.c();
                            c4.g = th.getMessage() + Log.getStackTraceString(th);
                            ofVar.h = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.obfuscated_res_0x7f0f0c2d);
                            BdLog.e(th.getMessage());
                            this.a.e(ofVar);
                            if (this.d <= 0 && (lfVar = this.b) != null) {
                                this.d = lfVar.i();
                            }
                            ofVar.f = System.currentTimeMillis() - currentTimeMillis;
                            this.a.e(ofVar);
                            a = kf.a();
                        } catch (Throwable th2) {
                            if (this.d <= 0 && (lfVar3 = this.b) != null) {
                                this.d = lfVar3.i();
                            }
                            ofVar.f = System.currentTimeMillis() - currentTimeMillis;
                            this.a.e(ofVar);
                            kf a4 = kf.a();
                            if (a4 != null) {
                                a4.b(this.a);
                            }
                            throw th2;
                        }
                    }
                    if (this.a.c().b == 200) {
                        ofVar.h = String.valueOf(this.a.c().b) + "|retryCount:" + i5;
                        z = l(this.a.c().b);
                        this.a.e(ofVar);
                        if (this.d <= 0 && (lfVar7 = this.b) != null) {
                            this.d = lfVar7.i();
                        }
                        ofVar.f = System.currentTimeMillis() - currentTimeMillis;
                        this.a.e(ofVar);
                        kf a5 = kf.a();
                        if (a5 != null) {
                            a5.b(this.a);
                        }
                        i5 = i6;
                    } else {
                        if (this.d <= 0 && (lfVar6 = this.b) != null) {
                            this.d = lfVar6.i();
                        }
                        ofVar.f = System.currentTimeMillis() - currentTimeMillis;
                        this.a.e(ofVar);
                        kf a6 = kf.a();
                        if (a6 != null) {
                            a6.b(this.a);
                            return;
                        }
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
                ofVar = new of();
                this.c = i5;
                int i62 = i5 + 1;
                ofVar.e = i62;
                a(i5);
                lf lfVar82 = new lf(this.a);
                this.b = lfVar82;
                lfVar82.r(i5);
                this.b.s(e);
                this.b.q(i5 >= i4, b, b2, ofVar);
                if (this.a.c().b == 200) {
                }
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:138:0x0370, code lost:
        if (r8.o() != false) goto L121;
     */
    /* JADX WARN: Code restructure failed: missing block: B:152:0x03ea, code lost:
        if (r8.o() != false) goto L121;
     */
    /* JADX WARN: Code restructure failed: missing block: B:153:0x03ec, code lost:
        r0.b(r16.a);
     */
    /* JADX WARN: Removed duplicated region for block: B:181:0x01d5 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x015d  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x015f  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x016f A[Catch: all -> 0x0208, UnsupportedOperationException -> 0x0281, SocketTimeoutException -> 0x02fa, SocketException -> 0x0374, TRY_LEAVE, TryCatch #1 {UnsupportedOperationException -> 0x0281, blocks: (B:66:0x0146, B:70:0x0160, B:72:0x016f), top: B:174:0x0146, outer: #0 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void o(int i, int i2, int i3) {
        int i4;
        int i5;
        of ofVar;
        kf a;
        lf lfVar;
        lf lfVar2;
        lf lfVar3;
        lf lfVar4;
        lf lfVar5;
        lf lfVar6;
        lf lfVar7;
        lf lfVar8;
        String[] split;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIII(1048590, this, i, i2, i3) == null) {
            int b = i2 <= 0 ? fb.d().b().b() : i2;
            int a2 = i <= 0 ? fb.d().a() : i;
            int b2 = i3 <= 0 ? fb.d().c().b() : i3;
            String m = this.a.b().m();
            if (!TextUtils.isEmpty(m) && (m.contains(TbDomainConfig.DOMAIN_HTTPS_SERVER_ADDRESS) || m.contains(TbDomainConfig.DOMAIN_HTTPS_TIEBA))) {
                if (!((Cif) ServiceManager.getService(Cif.a)).isFullHttps()) {
                    List<sf> httpsWhileList = ((Cif) ServiceManager.getService(Cif.a)).getHttpsWhileList();
                    if (httpsWhileList != null && httpsWhileList.size() > 0) {
                        for (sf sfVar : httpsWhileList) {
                            if (sfVar != null && !TextUtils.isEmpty(sfVar.a) && m.contains(sfVar.a)) {
                                i4 = sfVar.b;
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
                            qf b3 = this.a.b();
                            b3.s(TbDomainConfig.DOMAIN_HTTPS_TIEBAC + split2[1]);
                        }
                    } else if (m.contains(TbDomainConfig.DOMAIN_HTTPS_TIEBA) && (split = m.split(TbDomainConfig.DOMAIN_HTTPS_TIEBA)) != null && split.length == 2) {
                        qf b4 = this.a.b();
                        b4.s("https://tieba.baidu.com/" + split[1]);
                    }
                }
                i4 = (((Cif) ServiceManager.getService(Cif.a)).isSwitchOn() || TextUtils.isEmpty(this.a.b().i())) ? 0 : 0;
                long currentTimeMillis = System.currentTimeMillis();
                boolean z = true;
                i5 = 0;
                while (!this.a.c().a && z && i5 < a2 + i4) {
                    ofVar = new of();
                    int i6 = i5 + 1;
                    ofVar.e = i6;
                    this.c = i5;
                    a(i5);
                    try {
                        try {
                            try {
                                lf lfVar9 = new lf(this.a);
                                this.b = lfVar9;
                                lfVar9.r(i5);
                                this.b.s(e);
                                this.b.p(i5 >= i4, b, b2, ofVar);
                            } catch (UnsupportedOperationException e2) {
                                try {
                                    this.a.c().c = -14;
                                    rf c = this.a.c();
                                    c.g = e2.getMessage() + Log.getStackTraceString(e2);
                                    ofVar.h = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.obfuscated_res_0x7f0f0c2d);
                                    this.a.e(ofVar);
                                    if (this.d <= 0 && (lfVar4 = this.b) != null) {
                                        this.d = lfVar4.i();
                                    }
                                    ofVar.f = System.currentTimeMillis() - currentTimeMillis;
                                    this.a.e(ofVar);
                                    kf a3 = kf.a();
                                    if (a3 != null && (lfVar3 = this.b) != null && lfVar3.o()) {
                                        a3.b(this.a);
                                    }
                                    z = false;
                                }
                            }
                        } catch (SocketTimeoutException e3) {
                            this.a.c().c = -13;
                            rf c2 = this.a.c();
                            c2.g = e3.getMessage() + Log.getStackTraceString(e3);
                            ofVar.h = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.obfuscated_res_0x7f0f0c2d);
                            BdLog.e(e3.getMessage());
                            this.a.e(ofVar);
                            if (this.d <= 0 && (lfVar2 = this.b) != null) {
                                this.d = lfVar2.i();
                            }
                            ofVar.f = System.currentTimeMillis() - currentTimeMillis;
                            this.a.e(ofVar);
                            a = kf.a();
                            if (a != null) {
                                lf lfVar10 = this.b;
                                if (lfVar10 != null) {
                                }
                            }
                            z = true;
                            i5 = i6;
                        }
                    } catch (SocketException e4) {
                        this.a.c().c = -12;
                        rf c3 = this.a.c();
                        c3.g = e4.getMessage() + Log.getStackTraceString(e4);
                        ofVar.h = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.obfuscated_res_0x7f0f0c2d);
                        BdLog.e(e4.getMessage());
                        this.a.e(ofVar);
                        if (this.d <= 0 && (lfVar = this.b) != null) {
                            this.d = lfVar.i();
                        }
                        ofVar.f = System.currentTimeMillis() - currentTimeMillis;
                        this.a.e(ofVar);
                        a = kf.a();
                        if (a != null) {
                            lf lfVar11 = this.b;
                            if (lfVar11 != null) {
                            }
                        }
                        z = true;
                        i5 = i6;
                    }
                    if (this.a.c().b == 200) {
                        ofVar.h = String.valueOf(this.a.c().b) + "|retryCount:" + i5;
                        z = l(this.a.c().b);
                        this.a.e(ofVar);
                        if (this.d <= 0 && (lfVar8 = this.b) != null) {
                            this.d = lfVar8.i();
                        }
                        ofVar.f = System.currentTimeMillis() - currentTimeMillis;
                        this.a.e(ofVar);
                        kf a4 = kf.a();
                        if (a4 != null && (lfVar7 = this.b) != null && lfVar7.o()) {
                            a4.b(this.a);
                        }
                        i5 = i6;
                    } else {
                        if (this.d <= 0 && (lfVar6 = this.b) != null) {
                            this.d = lfVar6.i();
                        }
                        ofVar.f = System.currentTimeMillis() - currentTimeMillis;
                        this.a.e(ofVar);
                        kf a5 = kf.a();
                        if (a5 == null || (lfVar5 = this.b) == null || !lfVar5.o()) {
                            return;
                        }
                        a5.b(this.a);
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
                ofVar = new of();
                int i62 = i5 + 1;
                ofVar.e = i62;
                this.c = i5;
                a(i5);
                lf lfVar92 = new lf(this.a);
                this.b = lfVar92;
                lfVar92.r(i5);
                this.b.s(e);
                this.b.p(i5 >= i4, b, b2, ofVar);
                if (this.a.c().b == 200) {
                }
            }
        }
    }

    public void p() {
        pf pfVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048591, this) == null) || (pfVar = this.a) == null) {
            return;
        }
        pfVar.c().a = true;
    }
}
