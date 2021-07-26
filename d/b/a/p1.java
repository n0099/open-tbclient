package d.b.a;

import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.tblauncher.MainTabActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.embedapplog.AppLog;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.UUID;
/* loaded from: classes8.dex */
public class p1 {
    public static /* synthetic */ Interceptable $ic;
    public static long n;
    public static b o;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final y1 f69285a;

    /* renamed from: b  reason: collision with root package name */
    public final z1 f69286b;

    /* renamed from: c  reason: collision with root package name */
    public w f69287c;

    /* renamed from: d  reason: collision with root package name */
    public w f69288d;

    /* renamed from: e  reason: collision with root package name */
    public String f69289e;

    /* renamed from: f  reason: collision with root package name */
    public long f69290f;

    /* renamed from: g  reason: collision with root package name */
    public int f69291g;

    /* renamed from: h  reason: collision with root package name */
    public long f69292h;

    /* renamed from: i  reason: collision with root package name */
    public volatile boolean f69293i;
    public long j;
    public int k;
    public String l;
    public u m;

    /* loaded from: classes8.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes8.dex */
    public static class b extends y {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public /* synthetic */ b(a aVar) {
            this();
        }
    }

    public p1(z1 z1Var, y1 y1Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {z1Var, y1Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f69292h = -1L;
        this.f69286b = z1Var;
        this.f69285a = y1Var;
    }

    public static long a(y1 y1Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, y1Var)) == null) {
            long j = n + 1;
            n = j;
            if (j % 1000 == 0) {
                y1Var.r(j + 1000);
            }
            return n;
        }
        return invokeL.longValue;
    }

    public static boolean e(p pVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, pVar)) == null) {
            if (pVar instanceof w) {
                return ((w) pVar).p();
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static b j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            if (o == null) {
                o = new b(null);
            }
            o.f69277e = System.currentTimeMillis();
            return o;
        }
        return (b) invokeV.objValue;
    }

    public synchronized Bundle b(long j, long j2) {
        InterceptResult invokeCommon;
        Bundle bundle;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Long.valueOf(j), Long.valueOf(j2)})) == null) {
            synchronized (this) {
                bundle = null;
                if (this.f69285a.G() && i() && j - this.f69290f > j2) {
                    bundle = new Bundle();
                    bundle.putInt("session_no", this.k);
                    int i2 = this.f69291g + 1;
                    this.f69291g = i2;
                    bundle.putInt("send_times", i2);
                    bundle.putLong("current_duration", (j - this.f69290f) / 1000);
                    bundle.putString("session_start_time", p.c(this.f69292h));
                    this.f69290f = j;
                }
            }
            return bundle;
        }
        return (Bundle) invokeCommon.objValue;
    }

    public synchronized u c() {
        InterceptResult invokeV;
        u uVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            synchronized (this) {
                uVar = this.m;
            }
            return uVar;
        }
        return (u) invokeV.objValue;
    }

    public final synchronized void d(p pVar, ArrayList<p> arrayList, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(Constants.METHOD_SEND_USER_MSG, this, pVar, arrayList, z) == null) {
            synchronized (this) {
                long j = pVar instanceof b ? -1L : pVar.f69277e;
                this.f69289e = UUID.randomUUID().toString();
                n = this.f69285a.b();
                this.f69292h = j;
                this.f69293i = z;
                this.j = 0L;
                if (h0.f69234b) {
                    h0.a("startSession, " + this.f69289e + ", hadUi:" + z + " data:" + pVar, null);
                }
                if (z) {
                    Calendar calendar = Calendar.getInstance();
                    String str = "" + calendar.get(1) + calendar.get(2) + calendar.get(5);
                    if (TextUtils.isEmpty(this.l)) {
                        this.l = this.f69285a.x();
                        this.k = this.f69285a.A();
                    }
                    if (!str.equals(this.l)) {
                        this.l = str;
                        this.k = 1;
                    } else {
                        this.k++;
                    }
                    this.f69285a.t(str, this.k);
                    this.f69291g = 0;
                }
                if (j != -1) {
                    u uVar = new u();
                    uVar.f69279g = this.f69289e;
                    uVar.f69278f = a(this.f69285a);
                    uVar.f69277e = this.f69292h;
                    uVar.n = this.f69286b.p();
                    uVar.m = this.f69286b.n();
                    if (this.f69285a.W()) {
                        uVar.f69281i = AppLog.getAbConfigVersion();
                        uVar.j = AppLog.getAbSDKVersion();
                    }
                    arrayList.add(uVar);
                    this.m = uVar;
                    if (h0.f69234b) {
                        h0.a("gen launch, " + uVar.f69279g + ", hadUi:" + z, null);
                    }
                }
            }
        }
    }

    public boolean f(p pVar, ArrayList<p> arrayList) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, pVar, arrayList)) == null) {
            boolean z = pVar instanceof w;
            boolean e2 = e(pVar);
            boolean z2 = true;
            if (this.f69292h == -1) {
                d(pVar, arrayList, e(pVar));
            } else if (!this.f69293i && e2) {
                d(pVar, arrayList, true);
            } else {
                long j = this.j;
                if (j != 0 && pVar.f69277e > j + this.f69285a.Y()) {
                    d(pVar, arrayList, e2);
                } else if (this.f69292h > pVar.f69277e + MainTabActivity.SERVICE_BETWEEN_TIME) {
                    d(pVar, arrayList, e2);
                } else {
                    z2 = false;
                }
            }
            if (z) {
                w wVar = (w) pVar;
                if (wVar.p()) {
                    this.f69290f = pVar.f69277e;
                    this.j = 0L;
                    arrayList.add(pVar);
                    if (TextUtils.isEmpty(wVar.n)) {
                        w wVar2 = this.f69288d;
                        if (wVar2 != null && (wVar.f69277e - wVar2.f69277e) - wVar2.m < 500) {
                            wVar.n = wVar2.o;
                        } else {
                            w wVar3 = this.f69287c;
                            if (wVar3 != null && (wVar.f69277e - wVar3.f69277e) - wVar3.m < 500) {
                                wVar.n = wVar3.o;
                            }
                        }
                    }
                } else {
                    Bundle b2 = b(pVar.f69277e, 0L);
                    if (b2 != null) {
                        AppLog.onEventV3("play_session", b2);
                    }
                    this.f69290f = 0L;
                    this.j = wVar.f69277e;
                    arrayList.add(pVar);
                    if (wVar.q()) {
                        this.f69287c = wVar;
                    } else {
                        this.f69288d = wVar;
                        this.f69287c = null;
                    }
                }
            } else if (!(pVar instanceof b)) {
                arrayList.add(pVar);
            }
            g(pVar);
            return z2;
        }
        return invokeLL.booleanValue;
    }

    public void g(p pVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, pVar) == null) || pVar == null) {
            return;
        }
        pVar.f69280h = this.f69286b.t();
        pVar.f69279g = this.f69289e;
        pVar.f69278f = a(this.f69285a);
        if (this.f69285a.W()) {
            pVar.f69281i = AppLog.getAbConfigVersion();
            pVar.j = AppLog.getAbSDKVersion();
        }
    }

    public boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f69293i : invokeV.booleanValue;
    }

    public boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? h() && this.j == 0 : invokeV.booleanValue;
    }
}
