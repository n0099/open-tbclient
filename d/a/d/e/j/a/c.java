package d.a.d.e.j.a;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.R;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.d.e.p.j;
import d.a.d.e.p.k;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.ConnectException;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import javax.net.ssl.SSLException;
/* loaded from: classes7.dex */
public class c {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: f  reason: collision with root package name */
    public static boolean f41700f = true;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public e f41701a;

    /* renamed from: b  reason: collision with root package name */
    public b f41702b;

    /* renamed from: c  reason: collision with root package name */
    public int f41703c;

    /* renamed from: d  reason: collision with root package name */
    public long f41704d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f41705e;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(19003109, "Ld/a/d/e/j/a/c;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(19003109, "Ld/a/d/e/j/a/c;");
        }
    }

    public c(e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {eVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f41703c = 0;
        this.f41704d = 0L;
        this.f41705e = true;
        this.f41701a = eVar;
    }

    public final void a(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
            try {
                if (this.f41701a == null || i2 <= 0) {
                    return;
                }
                this.f41701a.b().a("Retry-Count", String.valueOf(i2));
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
        }
    }

    public void b() {
        b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (bVar = this.f41702b) == null) {
            return;
        }
        bVar.b();
    }

    /* JADX WARN: Code restructure failed: missing block: B:114:0x03c9, code lost:
        if (r0 == null) goto L137;
     */
    /* JADX WARN: Code restructure failed: missing block: B:137:0x04cc, code lost:
        if (r0 == null) goto L137;
     */
    /* JADX WARN: Code restructure failed: missing block: B:138:0x04ce, code lost:
        r0.c(r23.f41701a);
     */
    /* JADX WARN: Code restructure failed: missing block: B:139:0x04d3, code lost:
        r10 = r27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x024f, code lost:
        if (r0 == null) goto L137;
     */
    /* JADX WARN: Code restructure failed: missing block: B:99:0x030c, code lost:
        if (r0 == null) goto L137;
     */
    /* JADX WARN: Removed duplicated region for block: B:219:0x08ba  */
    /* JADX WARN: Removed duplicated region for block: B:220:0x08bc  */
    /* JADX WARN: Removed duplicated region for block: B:228:0x0905  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean c(String str, h hVar, int i2, int i3, int i4, int i5, boolean z, boolean z2) {
        InterceptResult invokeCommon;
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
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{str, hVar, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) {
            String str4 = "responseCode:";
            int b5 = i4 <= 0 ? d.a.d.c.j.b.d().b().b() : i4;
            int b6 = i5 <= 0 ? d.a.d.c.j.b.d().c().b() : i5;
            b bVar = new b(this.f41701a);
            this.f41702b = bVar;
            bVar.u(f41700f);
            int i9 = 0;
            boolean z3 = false;
            for (int a2 = i2 <= 0 ? d.a.d.c.j.b.d().a() : i2; i9 < a2; a2 = i7) {
                d dVar10 = new d();
                this.f41701a.c().f41728c = -1;
                this.f41702b.s(i9);
                int i10 = i9 + 1;
                try {
                    try {
                        dVar10.f41710e = i10;
                        try {
                            this.f41703c = i9;
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
                    z3 = this.f41702b.d(str, hVar, b5, b6, z, dVar10, z2);
                    if (!z3 && this.f41701a.c().f41726a) {
                        this.f41701a.c().f41728c = -14;
                    }
                    d.a.d.e.e.a.c().g(this.f41701a.b().i(), this.f41701a.b().g("Host"), TextUtils.isEmpty(dVar10.f41713h), dVar10.l != null);
                    if (!z3 && i6 == i7 - 1) {
                        dVar10.f41713h += "|" + d.a.d.e.j.a.j.d.c();
                        dVar10.f41713h += "|netAvailable:" + j.A();
                    }
                    this.f41701a.e(dVar10);
                    a b7 = a.b();
                    if (b7 != null) {
                        b7.c(this.f41701a);
                    }
                    return z3;
                } catch (FileNotFoundException e15) {
                    e = e15;
                    dVar5 = dVar10;
                    StringBuilder sb = new StringBuilder();
                    str3 = str2;
                    sb.append(str3);
                    sb.append(String.valueOf(this.f41701a.c().f41727b));
                    sb.append("|retryCount:");
                    sb.append(i6);
                    sb.append("|");
                    sb.append(e.getClass().getName());
                    sb.append("|");
                    sb.append(e.getMessage());
                    dVar5.f41713h = sb.toString();
                    this.f41701a.c().f41728c = -100;
                    d.a.d.e.e.a.c().g(this.f41701a.b().i(), this.f41701a.b().g("Host"), TextUtils.isEmpty(dVar5.f41713h), dVar5.l != null);
                    if (!z3 && i6 == i7 - 1) {
                        dVar5.f41713h += "|" + d.a.d.e.j.a.j.d.c();
                        dVar5.f41713h += "|netAvailable:" + j.A();
                    }
                    this.f41701a.e(dVar5);
                    b4 = a.b();
                    if (b4 == null) {
                        str4 = str3;
                        i9 = i8;
                    }
                    b4.c(this.f41701a);
                    str4 = str3;
                    i9 = i8;
                } catch (IllegalStateException e16) {
                    e = e16;
                    dVar9 = dVar10;
                    str3 = str2;
                    dVar9.f41713h = str3 + String.valueOf(this.f41701a.c().f41727b) + "|retryCount:" + i6 + "|" + e.getClass().getName() + "|" + e.getMessage() + "|getcontent_illegal_error";
                    this.f41701a.c().f41728c = -19;
                    d.a.d.e.e.a.c().g(this.f41701a.b().i(), this.f41701a.b().g("Host"), TextUtils.isEmpty(dVar9.f41713h), dVar9.l != null);
                    if (!z3 && i6 == i7 - 1) {
                        dVar9.f41713h += "|" + d.a.d.e.j.a.j.d.c();
                        dVar9.f41713h += "|netAvailable:" + j.A();
                    }
                    this.f41701a.e(dVar9);
                    b4 = a.b();
                    if (b4 == null) {
                        str4 = str3;
                        i9 = i8;
                    }
                    b4.c(this.f41701a);
                    str4 = str3;
                    i9 = i8;
                } catch (ConnectException e17) {
                    e = e17;
                    dVar8 = dVar10;
                    str3 = str2;
                    dVar8.f41713h = str3 + String.valueOf(this.f41701a.c().f41727b) + "|retryCount:" + i6 + "|" + e.getClass().getName() + "|" + e.getMessage();
                    this.f41701a.c().f41728c = -22;
                    d.a.d.e.e.a.c().g(this.f41701a.b().i(), this.f41701a.b().g("Host"), TextUtils.isEmpty(dVar8.f41713h), dVar8.l != null);
                    if (!z3 && i6 == i7 - 1) {
                        dVar8.f41713h += "|" + d.a.d.e.j.a.j.d.c();
                        dVar8.f41713h += "|netAvailable:" + j.A();
                    }
                    this.f41701a.e(dVar8);
                    b4 = a.b();
                    if (b4 == null) {
                        str4 = str3;
                        i9 = i8;
                    }
                    b4.c(this.f41701a);
                    str4 = str3;
                    i9 = i8;
                } catch (SocketException e18) {
                    e = e18;
                    dVar7 = dVar10;
                    str3 = str2;
                    dVar7.f41713h = str3 + String.valueOf(this.f41701a.c().f41727b) + "|retryCount:" + i6 + "|" + e.getClass().getName() + "|" + e.getMessage();
                    this.f41701a.c().f41728c = -12;
                    d.a.d.e.e.a.c().g(this.f41701a.b().i(), this.f41701a.b().g("Host"), TextUtils.isEmpty(dVar7.f41713h), dVar7.l != null);
                    if (!z3 && i6 == i7 - 1) {
                        dVar7.f41713h += "|" + d.a.d.e.j.a.j.d.c();
                        dVar7.f41713h += "|netAvailable:" + j.A();
                    }
                    this.f41701a.e(dVar7);
                    b4 = a.b();
                    if (b4 == null) {
                        str4 = str3;
                        i9 = i8;
                    }
                    b4.c(this.f41701a);
                    str4 = str3;
                    i9 = i8;
                } catch (SocketTimeoutException e19) {
                    e = e19;
                    dVar6 = dVar10;
                    str3 = str2;
                    dVar6.f41713h = str3 + String.valueOf(this.f41701a.c().f41727b) + "|retryCount:" + i6 + "|" + e.getClass().getName() + "|" + e.getMessage();
                    this.f41701a.c().f41728c = -13;
                    d.a.d.e.e.a.c().g(this.f41701a.b().i(), this.f41701a.b().g("Host"), TextUtils.isEmpty(dVar6.f41713h), dVar6.l != null);
                    if (!z3 && i6 == i7 - 1) {
                        dVar6.f41713h += "|" + d.a.d.e.j.a.j.d.c();
                        dVar6.f41713h += "|netAvailable:" + j.A();
                    }
                    this.f41701a.e(dVar6);
                    b4 = a.b();
                    if (b4 == null) {
                        str4 = str3;
                        i9 = i8;
                    }
                    b4.c(this.f41701a);
                    str4 = str3;
                    i9 = i8;
                } catch (UnknownHostException e20) {
                    e = e20;
                    dVar4 = dVar10;
                    dVar4.f41713h = "errorCode:" + String.valueOf(this.f41701a.c().f41727b) + "|retryCount:" + i6 + "|" + e.getClass().getName() + "|" + e.getMessage();
                    this.f41701a.c().f41728c = -21;
                    d.a.d.e.e.a.c().g(this.f41701a.b().i(), this.f41701a.b().g("Host"), TextUtils.isEmpty(dVar4.f41713h), dVar4.l != null);
                    if (!z3 && i6 == i7 - 1) {
                        dVar4.f41713h += "|" + d.a.d.e.j.a.j.d.c();
                        dVar4.f41713h += "|netAvailable:" + j.A();
                    }
                    this.f41701a.e(dVar4);
                    b3 = a.b();
                } catch (SSLException e21) {
                    e = e21;
                    dVar3 = dVar10;
                    if (this.f41701a.b().e() && i6 < i7 - 1) {
                        String b8 = d.a.d.e.j.a.j.d.b(this.f41701a.b().i());
                        if (!k.isEmpty(b8)) {
                            this.f41701a.b().s(b8);
                        }
                        BdStatisticsManager.getInstance().eventStat(null, "c13429", "", 1, "obj_type", "1");
                    } else {
                        dVar3.f41713h = "errorCode:" + String.valueOf(this.f41701a.c().f41727b) + "|retryCount:" + i6 + "|" + e.getClass().getName() + "|" + e.getMessage();
                        this.f41701a.c().f41728c = -20;
                    }
                    d.a.d.e.e.a.c().g(this.f41701a.b().i(), this.f41701a.b().g("Host"), TextUtils.isEmpty(dVar3.f41713h), dVar3.l != null);
                    if (!z3 && i6 == i7 - 1) {
                        dVar3.f41713h += "|" + d.a.d.e.j.a.j.d.c();
                        dVar3.f41713h += "|netAvailable:" + j.A();
                    }
                    this.f41701a.e(dVar3);
                    b3 = a.b();
                } catch (IOException e22) {
                    e = e22;
                    dVar2 = dVar10;
                    dVar2.f41713h = "errorCode:" + String.valueOf(this.f41701a.c().f41727b) + "|retryCount:" + i6 + "|" + e.getClass().getName() + "|" + e.getMessage();
                    this.f41701a.c().f41728c = -19;
                    d.a.d.e.e.a.c().g(this.f41701a.b().i(), this.f41701a.b().g("Host"), TextUtils.isEmpty(dVar2.f41713h), dVar2.l != null);
                    if (!z3 && i6 == i7 - 1) {
                        dVar2.f41713h += "|" + d.a.d.e.j.a.j.d.c();
                        dVar2.f41713h += "|netAvailable:" + j.A();
                    }
                    this.f41701a.e(dVar2);
                    b3 = a.b();
                } catch (Exception e23) {
                    e = e23;
                    dVar = dVar10;
                    try {
                        dVar.f41713h = "errorCode:" + String.valueOf(this.f41701a.c().f41727b) + "|retryCount:" + i6 + "|" + e.getClass().getName() + "|" + e.getMessage();
                        this.f41701a.c().f41728c = -10;
                        BdLog.e(e.getMessage());
                        d.a.d.e.e.a.c().g(this.f41701a.b().i(), this.f41701a.b().g("Host"), TextUtils.isEmpty(dVar.f41713h), dVar.l != null);
                        if (!z3 && i6 == i7 - 1) {
                            dVar.f41713h += "|" + d.a.d.e.j.a.j.d.c();
                            dVar.f41713h += "|netAvailable:" + j.A();
                        }
                        this.f41701a.e(dVar);
                        b3 = a.b();
                    } catch (Throwable th2) {
                        th = th2;
                        d.a.d.e.e.a.c().g(this.f41701a.b().i(), this.f41701a.b().g("Host"), TextUtils.isEmpty(dVar.f41713h), dVar.l == null);
                        if (!z3 && i6 == i7 - 1) {
                            dVar.f41713h += "|" + d.a.d.e.j.a.j.d.c();
                            dVar.f41713h += "|netAvailable:" + j.A();
                        }
                        this.f41701a.e(dVar);
                        b2 = a.b();
                        if (b2 != null) {
                            b2.c(this.f41701a);
                        }
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    dVar = dVar10;
                    d.a.d.e.e.a.c().g(this.f41701a.b().i(), this.f41701a.b().g("Host"), TextUtils.isEmpty(dVar.f41713h), dVar.l == null);
                    if (!z3) {
                        dVar.f41713h += "|" + d.a.d.e.j.a.j.d.c();
                        dVar.f41713h += "|netAvailable:" + j.A();
                    }
                    this.f41701a.e(dVar);
                    b2 = a.b();
                    if (b2 != null) {
                    }
                    throw th;
                }
            }
            return z3;
        }
        return invokeCommon.booleanValue;
    }

    public boolean d(String str, h hVar, int i2, int i3, int i4, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{str, hVar, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Boolean.valueOf(z)})) == null) ? c(str, hVar, i2, -1, i3, i4, false, z) : invokeCommon.booleanValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:107:0x03a6, code lost:
        if (r0 == null) goto L82;
     */
    /* JADX WARN: Code restructure failed: missing block: B:108:0x03a8, code lost:
        r0.c(r19.f41701a);
     */
    /* JADX WARN: Code restructure failed: missing block: B:109:0x03ad, code lost:
        r12 = 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:92:0x0317, code lost:
        if (r0 == null) goto L82;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void e(int i2, int i3, int i4) {
        a b2;
        b bVar;
        int i5;
        b bVar2;
        a b3;
        b bVar3;
        b bVar4;
        b bVar5;
        b bVar6;
        b bVar7;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIII(1048580, this, i2, i3, i4) == null) {
            int b4 = i3 <= 0 ? d.a.d.c.j.b.d().b().b() : i3;
            int a2 = i2 <= 0 ? d.a.d.c.j.b.d().a() : i2;
            int b5 = i4 <= 0 ? d.a.d.c.j.b.d().c().b() : i4;
            long currentTimeMillis = System.currentTimeMillis();
            int i6 = true;
            int i7 = 0;
            for (int i8 = 1; !this.f41701a.c().f41726a && i6 == i8 && i7 < a2; i8 = 1) {
                d dVar = new d();
                this.f41701a.e(dVar);
                try {
                    try {
                        try {
                            this.f41703c = i7;
                            dVar.f41710e = i7 + 1;
                            dVar.v = i8;
                            a(i7);
                            b bVar8 = new b(this.f41701a);
                            this.f41702b = bVar8;
                            bVar8.s(i7);
                            this.f41702b.u(f41700f);
                            this.f41702b.k(b4, b5, dVar);
                        } catch (SocketException e2) {
                            i5 = b4;
                            dVar.f41713h = String.valueOf(this.f41701a.c().f41727b) + "|retryCount:" + i7 + "|" + e2.getClass() + "|" + e2.getMessage();
                            this.f41701a.c().f41728c = -12;
                            if (this.f41704d <= 0 && (bVar4 = this.f41702b) != null) {
                                this.f41704d = bVar4.i();
                            }
                            dVar.f41711f = System.currentTimeMillis() - currentTimeMillis;
                            d.a.d.e.e.a.c().g(this.f41701a.b().i(), this.f41701a.b().g("Host"), TextUtils.isEmpty(dVar.f41713h), dVar.l != null);
                            this.f41701a.f(dVar);
                            b3 = a.b();
                        } catch (SocketTimeoutException e3) {
                            i5 = b4;
                            dVar.f41713h = String.valueOf(this.f41701a.c().f41727b) + "|retryCount:" + i7 + "|" + e3.getClass() + "|" + e3.getMessage();
                            this.f41701a.c().f41728c = -13;
                            if (this.f41704d <= 0 && (bVar3 = this.f41702b) != null) {
                                this.f41704d = bVar3.i();
                            }
                            dVar.f41711f = System.currentTimeMillis() - currentTimeMillis;
                            d.a.d.e.e.a.c().g(this.f41701a.b().i(), this.f41701a.b().g("Host"), TextUtils.isEmpty(dVar.f41713h), dVar.l != null);
                            this.f41701a.f(dVar);
                            b3 = a.b();
                        }
                    } catch (IOException e4) {
                        this.f41701a.c().f41728c = -19;
                        dVar.f41713h = "errorCode:" + String.valueOf(-19) + "|" + e4.getClass() + "|" + e4.getMessage() + "|getcontent_illegal_error";
                        if (this.f41704d <= 0 && (bVar2 = this.f41702b) != null) {
                            this.f41704d = bVar2.i();
                        }
                        dVar.f41711f = System.currentTimeMillis() - currentTimeMillis;
                        i5 = b4;
                        d.a.d.e.e.a.c().g(this.f41701a.b().i(), this.f41701a.b().g("Host"), TextUtils.isEmpty(dVar.f41713h), dVar.l != null);
                        this.f41701a.f(dVar);
                        a b6 = a.b();
                        if (b6 != null) {
                            b6.c(this.f41701a);
                        }
                    } catch (Exception e5) {
                        dVar.f41713h = String.valueOf(this.f41701a.c().f41727b) + "|retryCount:" + i7 + "|" + e5.getClass() + "|" + e5.getMessage();
                        this.f41701a.c().f41728c = -10;
                        BdLog.e(e5.getMessage());
                        if (this.f41704d <= 0 && (bVar = this.f41702b) != null) {
                            this.f41704d = bVar.i();
                        }
                        dVar.f41711f = System.currentTimeMillis() - currentTimeMillis;
                        d.a.d.e.e.a.c().g(this.f41701a.b().i(), this.f41701a.b().g("Host"), TextUtils.isEmpty(dVar.f41713h), dVar.l != null);
                        this.f41701a.f(dVar);
                        b2 = a.b();
                        if (b2 == null) {
                            return;
                        }
                    }
                    if (this.f41701a.c().f41727b != 200) {
                        dVar.f41713h = String.valueOf(this.f41701a.c().f41727b) + "|retryCount:" + i7;
                        boolean m = m(this.f41701a.c().f41727b);
                        if (this.f41704d <= 0 && (bVar7 = this.f41702b) != null) {
                            this.f41704d = bVar7.i();
                        }
                        dVar.f41711f = System.currentTimeMillis() - currentTimeMillis;
                        d.a.d.e.e.a.c().g(this.f41701a.b().i(), this.f41701a.b().g("Host"), TextUtils.isEmpty(dVar.f41713h), dVar.l != null);
                        this.f41701a.f(dVar);
                        a b7 = a.b();
                        if (b7 != null) {
                            b7.c(this.f41701a);
                        }
                        i6 = m;
                        i5 = b4;
                        i7++;
                        b4 = i5;
                    } else {
                        this.f41701a.f(dVar);
                        if (this.f41704d <= 0 && (bVar6 = this.f41702b) != null) {
                            this.f41704d = bVar6.i();
                        }
                        dVar.f41711f = System.currentTimeMillis() - currentTimeMillis;
                        d.a.d.e.e.a.c().g(this.f41701a.b().i(), this.f41701a.b().g("Host"), TextUtils.isEmpty(dVar.f41713h), dVar.l != null);
                        this.f41701a.f(dVar);
                        b2 = a.b();
                        if (b2 == null) {
                            return;
                        }
                        b2.c(this.f41701a);
                        return;
                    }
                } catch (Throwable th) {
                    if (this.f41704d <= 0 && (bVar5 = this.f41702b) != null) {
                        this.f41704d = bVar5.i();
                    }
                    dVar.f41711f = System.currentTimeMillis() - currentTimeMillis;
                    d.a.d.e.e.a.c().g(this.f41701a.b().i(), this.f41701a.b().g("Host"), TextUtils.isEmpty(dVar.f41713h), dVar.l != null);
                    this.f41701a.f(dVar);
                    a b8 = a.b();
                    if (b8 != null) {
                        b8.c(this.f41701a);
                    }
                    throw th;
                }
            }
        }
    }

    public long f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            b bVar = this.f41702b;
            if (bVar == null) {
                return -1L;
            }
            return bVar.e();
        }
        return invokeV.longValue;
    }

    public long g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            b bVar = this.f41702b;
            if (bVar == null) {
                return -1L;
            }
            return bVar.h();
        }
        return invokeV.longValue;
    }

    public long h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            long j = this.f41704d;
            if (j > 0) {
                return j;
            }
            b bVar = this.f41702b;
            if (bVar == null) {
                return -1L;
            }
            return bVar.i();
        }
        return invokeV.longValue;
    }

    public long i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            b bVar = this.f41702b;
            if (bVar == null) {
                return -1L;
            }
            return bVar.l();
        }
        return invokeV.longValue;
    }

    public long j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            b bVar = this.f41702b;
            if (bVar == null) {
                return -1L;
            }
            return bVar.j();
        }
        return invokeV.longValue;
    }

    public int k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f41703c : invokeV.intValue;
    }

    public boolean l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            e eVar = this.f41701a;
            if (eVar == null) {
                return false;
            }
            return eVar.c().f41726a;
        }
        return invokeV.booleanValue;
    }

    public final boolean m(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048588, this, i2)) == null) {
            if (i2 == 202 || i2 == 201 || i2 == 205 || i2 == 304 || i2 == 305 || i2 == 408) {
                return true;
            }
            return (i2 == 502 || i2 == 503 || i2 == 504 || i2 == 404) ? false : true;
        }
        return invokeI.booleanValue;
    }

    public void n(int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIII(1048589, this, i2, i3, i4) == null) {
            if (this.f41701a.b().j()) {
                p(i2, i3, i4);
            } else {
                o(i2, i3, i4);
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:101:0x0344, code lost:
        if (r0 == null) goto L64;
     */
    /* JADX WARN: Code restructure failed: missing block: B:102:0x0346, code lost:
        r0.c(r16.f41701a);
     */
    /* JADX WARN: Code restructure failed: missing block: B:103:0x034b, code lost:
        r0 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:87:0x02c9, code lost:
        if (r0 == null) goto L64;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void o(int i2, int i3, int i4) {
        b bVar;
        a b2;
        b bVar2;
        b bVar3;
        b bVar4;
        b bVar5;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIII(1048590, this, i2, i3, i4) == null) {
            int b3 = i3 <= 0 ? d.a.d.c.j.b.d().b().b() : i3;
            int a2 = i2 <= 0 ? d.a.d.c.j.b.d().a() : i2;
            int b4 = i4 <= 0 ? d.a.d.c.j.b.d().c().b() : i4;
            long currentTimeMillis = System.currentTimeMillis();
            boolean z = true;
            int i5 = 0;
            for (boolean z2 = true; !this.f41701a.c().f41726a && z == z2 && i5 < a2; z2 = true) {
                d dVar = new d();
                this.f41703c = i5;
                int i6 = i5 + 1;
                dVar.f41710e = i6;
                a(i5);
                try {
                    try {
                        try {
                            try {
                                b bVar6 = new b(this.f41701a);
                                this.f41702b = bVar6;
                                bVar6.s(i5);
                                this.f41702b.u(f41700f);
                                this.f41702b.t(this.f41705e);
                                this.f41702b.r(b3, b4, dVar);
                            } catch (SocketTimeoutException e2) {
                                this.f41701a.c().f41728c = -13;
                                dVar.f41713h = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                                BdLog.e(e2.getMessage());
                                this.f41701a.e(dVar);
                                if (this.f41704d <= 0 && (bVar3 = this.f41702b) != null) {
                                    this.f41704d = bVar3.i();
                                }
                                dVar.f41711f = System.currentTimeMillis() - currentTimeMillis;
                                d.a.d.e.e.a.c().g(this.f41701a.b().i(), this.f41701a.b().g("Host"), TextUtils.isEmpty(dVar.f41713h), dVar.l != null);
                                this.f41701a.e(dVar);
                                b2 = a.b();
                            }
                        } catch (SocketException e3) {
                            this.f41701a.c().f41728c = -12;
                            dVar.f41713h = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                            BdLog.e(e3.getMessage());
                            this.f41701a.e(dVar);
                            if (this.f41704d <= 0 && (bVar2 = this.f41702b) != null) {
                                this.f41704d = bVar2.i();
                            }
                            dVar.f41711f = System.currentTimeMillis() - currentTimeMillis;
                            d.a.d.e.e.a.c().g(this.f41701a.b().i(), this.f41701a.b().g("Host"), TextUtils.isEmpty(dVar.f41713h), dVar.l != null);
                            this.f41701a.e(dVar);
                            b2 = a.b();
                        }
                    } catch (UnsupportedOperationException unused) {
                        this.f41701a.c().f41728c = -14;
                        dVar.f41713h = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                        this.f41701a.e(dVar);
                        if (this.f41704d <= 0 && (bVar = this.f41702b) != null) {
                            this.f41704d = bVar.i();
                        }
                        dVar.f41711f = System.currentTimeMillis() - currentTimeMillis;
                        d.a.d.e.e.a.c().g(this.f41701a.b().i(), this.f41701a.b().g("Host"), TextUtils.isEmpty(dVar.f41713h), dVar.l != null);
                        this.f41701a.e(dVar);
                        a b5 = a.b();
                        if (b5 != null) {
                            b5.c(this.f41701a);
                        }
                        z = false;
                    }
                    if (this.f41701a.c().f41727b != 200) {
                        dVar.f41713h = String.valueOf(this.f41701a.c().f41727b) + "|retryCount:" + i5;
                        z = m(this.f41701a.c().f41727b);
                        this.f41701a.e(dVar);
                        if (this.f41704d <= 0 && (bVar5 = this.f41702b) != null) {
                            this.f41704d = bVar5.i();
                        }
                        dVar.f41711f = System.currentTimeMillis() - currentTimeMillis;
                        d.a.d.e.e.a.c().g(this.f41701a.b().i(), this.f41701a.b().g("Host"), TextUtils.isEmpty(dVar.f41713h), dVar.l != null);
                        this.f41701a.e(dVar);
                        a b6 = a.b();
                        if (b6 != null) {
                            b6.c(this.f41701a);
                        }
                        i5 = i6;
                    } else {
                        if (this.f41704d <= 0 && (bVar4 = this.f41702b) != null) {
                            this.f41704d = bVar4.i();
                        }
                        dVar.f41711f = System.currentTimeMillis() - currentTimeMillis;
                        d.a.d.e.e.a.c().g(this.f41701a.b().i(), this.f41701a.b().g("Host"), TextUtils.isEmpty(dVar.f41713h), dVar.l != null);
                        this.f41701a.e(dVar);
                        a b7 = a.b();
                        if (b7 != null) {
                            b7.c(this.f41701a);
                            return;
                        }
                        return;
                    }
                }
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:107:0x02f5, code lost:
        if (r8.p() != false) goto L80;
     */
    /* JADX WARN: Code restructure failed: missing block: B:125:0x037a, code lost:
        if (r8.p() != false) goto L80;
     */
    /* JADX WARN: Code restructure failed: missing block: B:126:0x037c, code lost:
        r0.c(r16.f41701a);
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
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIII(1048591, this, i2, i3, i4) == null) {
            int b3 = i3 <= 0 ? d.a.d.c.j.b.d().b().b() : i3;
            int a2 = i2 <= 0 ? d.a.d.c.j.b.d().a() : i2;
            int b4 = i4 <= 0 ? d.a.d.c.j.b.d().c().b() : i4;
            long currentTimeMillis = System.currentTimeMillis();
            boolean z = true;
            int i5 = 0;
            for (boolean z2 = true; !this.f41701a.c().f41726a && z == z2 && i5 < a2; z2 = true) {
                d dVar = new d();
                int i6 = i5 + 1;
                dVar.f41710e = i6;
                this.f41703c = i5;
                a(i5);
                try {
                    try {
                        try {
                            b bVar9 = new b(this.f41701a);
                            this.f41702b = bVar9;
                            bVar9.s(i5);
                            this.f41702b.u(f41700f);
                            this.f41702b.q(b3, b4, dVar);
                        } catch (SocketTimeoutException e2) {
                            this.f41701a.c().f41728c = -13;
                            dVar.f41713h = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                            BdLog.e(e2.getMessage());
                            this.f41701a.e(dVar);
                            if (this.f41704d <= 0 && (bVar4 = this.f41702b) != null) {
                                this.f41704d = bVar4.i();
                            }
                            dVar.f41711f = System.currentTimeMillis() - currentTimeMillis;
                            d.a.d.e.e.a.c().g(this.f41701a.b().i(), this.f41701a.b().g("Host"), TextUtils.isEmpty(dVar.f41713h), dVar.l != null);
                            this.f41701a.e(dVar);
                            b2 = a.b();
                            if (b2 != null) {
                                b bVar10 = this.f41702b;
                                if (bVar10 != null) {
                                }
                            }
                            z = true;
                            i5 = i6;
                        }
                    } catch (UnsupportedOperationException unused) {
                        this.f41701a.c().f41728c = -14;
                        dVar.f41713h = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                        this.f41701a.e(dVar);
                        if (this.f41704d <= 0 && (bVar3 = this.f41702b) != null) {
                            this.f41704d = bVar3.i();
                        }
                        dVar.f41711f = System.currentTimeMillis() - currentTimeMillis;
                        d.a.d.e.e.a.c().g(this.f41701a.b().i(), this.f41701a.b().g("Host"), TextUtils.isEmpty(dVar.f41713h), dVar.l != null);
                        this.f41701a.e(dVar);
                        a b5 = a.b();
                        if (b5 != null && (bVar2 = this.f41702b) != null && bVar2.p()) {
                            b5.c(this.f41701a);
                        }
                        z = false;
                    } catch (SocketException e3) {
                        this.f41701a.c().f41728c = -12;
                        dVar.f41713h = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                        BdLog.e(e3.getMessage());
                        this.f41701a.e(dVar);
                        if (this.f41704d <= 0 && (bVar = this.f41702b) != null) {
                            this.f41704d = bVar.i();
                        }
                        dVar.f41711f = System.currentTimeMillis() - currentTimeMillis;
                        d.a.d.e.e.a.c().g(this.f41701a.b().i(), this.f41701a.b().g("Host"), TextUtils.isEmpty(dVar.f41713h), dVar.l != null);
                        this.f41701a.e(dVar);
                        b2 = a.b();
                        if (b2 != null) {
                            b bVar11 = this.f41702b;
                            if (bVar11 != null) {
                            }
                        }
                        z = true;
                        i5 = i6;
                    }
                    if (this.f41701a.c().f41727b != 200) {
                        dVar.f41713h = String.valueOf(this.f41701a.c().f41727b) + "|retryCount:" + i5;
                        z = m(this.f41701a.c().f41727b);
                        this.f41701a.e(dVar);
                        if (this.f41704d <= 0 && (bVar8 = this.f41702b) != null) {
                            this.f41704d = bVar8.i();
                        }
                        dVar.f41711f = System.currentTimeMillis() - currentTimeMillis;
                        d.a.d.e.e.a.c().g(this.f41701a.b().i(), this.f41701a.b().g("Host"), TextUtils.isEmpty(dVar.f41713h), dVar.l != null);
                        this.f41701a.e(dVar);
                        a b6 = a.b();
                        if (b6 != null && (bVar7 = this.f41702b) != null && bVar7.p()) {
                            b6.c(this.f41701a);
                        }
                        i5 = i6;
                    } else {
                        if (this.f41704d <= 0 && (bVar6 = this.f41702b) != null) {
                            this.f41704d = bVar6.i();
                        }
                        dVar.f41711f = System.currentTimeMillis() - currentTimeMillis;
                        d.a.d.e.e.a.c().g(this.f41701a.b().i(), this.f41701a.b().g("Host"), TextUtils.isEmpty(dVar.f41713h), dVar.l != null);
                        this.f41701a.e(dVar);
                        a b7 = a.b();
                        if (b7 == null || (bVar5 = this.f41702b) == null || !bVar5.p()) {
                            return;
                        }
                        b7.c(this.f41701a);
                        return;
                    }
                }
            }
        }
    }

    public void q() {
        e eVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048592, this) == null) || (eVar = this.f41701a) == null) {
            return;
        }
        eVar.c().f41726a = true;
    }
}
