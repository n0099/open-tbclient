package d.l.a.b.a.c;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.bridge.BaiduAppJsBridgeHandler;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.l.a.a.a.d.d;
import d.l.a.b.a.a.a;
import d.l.a.b.a.a.b;
import d.l.a.b.a.a.c;
import d.l.a.d.b.l;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class b implements a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int A;
    public String B;
    public boolean C;
    public String D;
    public boolean E;
    public boolean F;
    public boolean G;
    public String H;
    public String I;
    public boolean J;
    public boolean K;
    public boolean L;
    public boolean M;
    public final AtomicBoolean N;
    public final AtomicBoolean O;
    public int P;
    public int Q;
    public long R;
    public long S;
    public boolean T;
    public boolean U;
    public String V;
    public boolean W;
    public boolean X;
    public long Y;
    public transient boolean Z;

    /* renamed from: a  reason: collision with root package name */
    public long f74117a;
    public boolean a0;

    /* renamed from: b  reason: collision with root package name */
    public long f74118b;
    public boolean b0;

    /* renamed from: c  reason: collision with root package name */
    public String f74119c;
    public boolean c0;

    /* renamed from: d  reason: collision with root package name */
    public int f74120d;
    public boolean d0;

    /* renamed from: e  reason: collision with root package name */
    public String f74121e;
    public boolean e0;

    /* renamed from: f  reason: collision with root package name */
    public String f74122f;

    /* renamed from: g  reason: collision with root package name */
    public String f74123g;

    /* renamed from: h  reason: collision with root package name */
    public String f74124h;

    /* renamed from: i  reason: collision with root package name */
    public int f74125i;
    public int j;
    public int k;
    public int l;
    public String m;
    public String n;
    public String o;
    public boolean p;
    public long q;
    public JSONObject r;
    public int s;
    public boolean t;
    public int u;
    public int v;
    public long w;
    public long x;
    public long y;
    public int z;

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
                return;
            }
        }
        this.f74120d = 1;
        this.p = true;
        this.t = false;
        this.u = 0;
        this.v = 0;
        this.C = false;
        this.E = false;
        this.F = true;
        this.G = true;
        this.K = true;
        this.L = true;
        this.N = new AtomicBoolean(false);
        this.O = new AtomicBoolean(false);
        this.Q = 1;
        this.T = true;
        this.Y = -1L;
    }

    public static b k0(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, jSONObject)) == null) {
            if (jSONObject == null) {
                return null;
            }
            b bVar = new b();
            try {
                bVar.u0(d.l.a.a.a.g.b.a(jSONObject, "mId"));
                bVar.y0(d.l.a.a.a.g.b.a(jSONObject, "mExtValue"));
                bVar.r0(jSONObject.optString("mLogExtra"));
                bVar.x0(jSONObject.optInt("mDownloadStatus"));
                bVar.n0(jSONObject.optString("mPackageName"));
                boolean z = true;
                bVar.b0(jSONObject.optBoolean("mIsAd", true));
                bVar.C0(d.l.a.a.a.g.b.a(jSONObject, "mTimeStamp"));
                bVar.B0(jSONObject.optInt("mVersionCode"));
                bVar.v0(jSONObject.optString("mVersionName"));
                bVar.F0(jSONObject.optInt("mDownloadId"));
                bVar.o0(jSONObject.optBoolean("mIsV3Event"));
                bVar.J0(jSONObject.optInt("mScene"));
                bVar.D0(jSONObject.optString("mEventTag"));
                bVar.H0(jSONObject.optString("mEventRefer"));
                bVar.L0(jSONObject.optString("mDownloadUrl"));
                bVar.s0(jSONObject.optBoolean("mEnableBackDialog"));
                bVar.N.set(jSONObject.optBoolean("hasSendInstallFinish"));
                bVar.O.set(jSONObject.optBoolean("hasSendDownloadFailedFinally"));
                bVar.t0(jSONObject.optInt("mLastFailedErrCode"));
                bVar.Z(jSONObject.optString("mLastFailedErrMsg"));
                bVar.P0(jSONObject.optString("mOpenUrl"));
                bVar.R0(jSONObject.optInt("mLinkMode"));
                bVar.U0(jSONObject.optInt("mDownloadMode"));
                bVar.X0(jSONObject.optInt("mModelType"));
                bVar.S0(jSONObject.optString("mAppName"));
                bVar.V0(jSONObject.optString("mAppIcon"));
                bVar.X(jSONObject.optInt("mDownloadFailedTimes", 0));
                bVar.Y(d.l.a.a.a.g.b.a(jSONObject, "mRecentDownloadResumeTime"));
                bVar.l0(jSONObject.optInt("mClickPauseTimes"));
                bVar.m0(d.l.a.a.a.g.b.a(jSONObject, "mJumpInstallTime"));
                bVar.q0(d.l.a.a.a.g.b.a(jSONObject, "mCancelInstallTime"));
                bVar.p0(jSONObject.optInt("mLastFailedResumeCount"));
                bVar.Y0(jSONObject.optString("downloadFinishReason"));
                bVar.O0(jSONObject.optLong("clickDownloadSize"));
                bVar.K0(jSONObject.optLong("clickDownloadTime"));
                bVar.M0(jSONObject.optBoolean("mIsUpdateDownload"));
                bVar.a1(jSONObject.optString("mOriginMimeType"));
                bVar.Q0(jSONObject.optBoolean("mIsPatchApplyHandled"));
                bVar.E0(jSONObject.optBoolean("installAfterCleanSpace"));
                bVar.N0(jSONObject.optInt("funnelType", 1));
                bVar.z0(jSONObject.optString(BaiduAppJsBridgeHandler.INPUT_PARAM_WEB_URL));
                bVar.e1(jSONObject.optBoolean("enableShowComplianceDialog", true));
                bVar.f1(jSONObject.optBoolean("isAutoDownloadOnCardShow"));
                bVar.g1(jSONObject.optInt("enable_new_activity", 1) == 1);
                bVar.h1(jSONObject.optInt("enable_pause", 1) == 1);
                bVar.i1(jSONObject.optInt("enable_ah", 1) == 1);
                if (jSONObject.optInt("enable_am", 1) != 1) {
                    z = false;
                }
                bVar.j1(z);
                bVar.a0(jSONObject.optJSONObject("mExtras"));
            } catch (Exception e2) {
                l.F().a(e2, "NativeDownloadModel fromJson");
            }
            return bVar;
        }
        return (b) invokeL.objValue;
    }

    public int A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.z : invokeV.intValue;
    }

    public void A0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            this.W = z;
        }
    }

    public int B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.A : invokeV.intValue;
    }

    public void B0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            this.l = i2;
        }
    }

    public String C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.B : (String) invokeV.objValue;
    }

    public void C0(long j) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeJ(1048581, this, j) == null) || j <= 0) {
            return;
        }
        this.q = j;
    }

    public int D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f74120d : invokeV.intValue;
    }

    public void D0(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
            this.H = str;
        }
    }

    public long E() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.q : invokeV.longValue;
    }

    public void E0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            this.M = z;
        }
    }

    public int F() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.l : invokeV.intValue;
    }

    public void F0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i2) == null) {
            this.s = i2;
        }
    }

    public String G() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.m : (String) invokeV.objValue;
    }

    public void G0(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048589, this, j) == null) {
            this.Y = j;
        }
    }

    public int H() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.P : invokeV.intValue;
    }

    public void H0(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, str) == null) {
            this.I = str;
        }
    }

    public boolean I() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.t : invokeV.booleanValue;
    }

    public void I0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048593, this, z) == null) {
            this.X = z;
        }
    }

    public long J() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.Y : invokeV.longValue;
    }

    public void J0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048595, this, i2) == null) {
            this.P = i2;
        }
    }

    public String K() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.n : (String) invokeV.objValue;
    }

    public void K0(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048597, this, j) == null) {
            this.R = j;
        }
    }

    public int L() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? this.j : invokeV.intValue;
    }

    public void L0(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, str) == null) {
            this.f74122f = str;
        }
    }

    public String M() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? this.V : (String) invokeV.objValue;
    }

    public void M0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048601, this, z) == null) {
            this.C = z;
        }
    }

    public boolean N() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) ? this.W : invokeV.booleanValue;
    }

    public void N0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048603, this, i2) == null) {
            this.Q = i2;
        }
    }

    public boolean O() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) ? this.M : invokeV.booleanValue;
    }

    public void O0(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048605, this, j) == null) {
            this.S = j;
        }
    }

    public boolean P() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) ? this.X : invokeV.booleanValue;
    }

    public void P0(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048607, this, str) == null) {
            this.f74123g = str;
        }
    }

    public long Q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) ? this.R : invokeV.longValue;
    }

    public void Q0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048609, this, z) == null) {
            this.E = z;
        }
    }

    public long R() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) ? this.S : invokeV.longValue;
    }

    public void R0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048611, this, i2) == null) {
            this.j = i2;
        }
    }

    public boolean S() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) ? this.C : invokeV.booleanValue;
    }

    public void S0(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048613, this, str) == null) {
            this.n = str;
        }
    }

    public String T() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048614, this)) == null) ? this.D : (String) invokeV.objValue;
    }

    public void T0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048615, this, z) == null) {
            this.Z = z;
        }
    }

    public boolean U() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048616, this)) == null) ? this.E : invokeV.booleanValue;
    }

    public void U0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048617, this, i2) == null) {
            this.k = i2;
        }
    }

    public boolean V() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048618, this)) == null) ? this.Z : invokeV.booleanValue;
    }

    public void V0(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048619, this, str) == null) {
            this.o = str;
        }
    }

    public boolean W() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048620, this)) == null) ? this.a0 : invokeV.booleanValue;
    }

    public void W0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048621, this, z) == null) {
            this.a0 = z;
        }
    }

    public void X(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048622, this, i2) == null) {
            this.u = i2;
        }
    }

    public void X0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048623, this, i2) == null) {
            this.f74125i = i2;
        }
    }

    public void Y(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048624, this, j) == null) {
            this.w = j;
        }
    }

    public void Y0(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048625, this, str) == null) {
            this.V = str;
        }
    }

    public void Z(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048626, this, str) == null) {
            this.B = str;
        }
    }

    public void Z0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048627, this, z) == null) {
            this.c0 = z;
        }
    }

    @Override // d.l.a.b.a.c.a
    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048628, this)) == null) ? this.f74122f : (String) invokeV.objValue;
    }

    public void a0(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048629, this, jSONObject) == null) {
            this.r = jSONObject;
        }
    }

    public void a1(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048630, this, str) == null) {
            this.D = str;
        }
    }

    @Override // d.l.a.b.a.c.a
    public long b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048631, this)) == null) ? this.f74117a : invokeV.longValue;
    }

    public void b0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048632, this, z) == null) {
            this.p = z;
        }
    }

    public void b1(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048633, this, z) == null) {
            this.b0 = z;
        }
    }

    @Override // d.l.a.b.a.c.a
    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048634, this)) == null) ? this.p : invokeV.booleanValue;
    }

    public boolean c0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048635, this)) == null) ? this.c0 : invokeV.booleanValue;
    }

    public void c1(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048636, this, z) == null) {
            this.d0 = z;
        }
    }

    @Override // d.l.a.b.a.c.a
    public String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048637, this)) == null) ? this.f74119c : (String) invokeV.objValue;
    }

    public boolean d0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048638, this)) == null) ? this.b0 : invokeV.booleanValue;
    }

    public void d1(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048639, this, z) == null) {
            this.e0 = z;
        }
    }

    @Override // d.l.a.b.a.c.a
    public String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048640, this)) == null) ? this.f74121e : (String) invokeV.objValue;
    }

    public boolean e0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048641, this)) == null) ? this.d0 : invokeV.booleanValue;
    }

    public void e1(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048642, this, z) == null) {
            this.T = z;
        }
    }

    @Override // d.l.a.b.a.c.a
    public String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048643, this)) == null) ? this.f74123g : (String) invokeV.objValue;
    }

    public boolean f0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048644, this)) == null) ? this.e0 : invokeV.booleanValue;
    }

    public void f1(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048645, this, z) == null) {
            this.U = z;
        }
    }

    @Override // d.l.a.b.a.c.a
    public JSONObject g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048646, this)) == null) ? this.r : (JSONObject) invokeV.objValue;
    }

    public JSONObject g0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048647, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("mId", this.f74117a);
                jSONObject.put("mExtValue", this.f74118b);
                jSONObject.put("mLogExtra", this.f74119c);
                jSONObject.put("mDownloadStatus", this.f74120d);
                jSONObject.put("mPackageName", this.f74121e);
                jSONObject.put("mIsAd", this.p);
                jSONObject.put("mTimeStamp", this.q);
                jSONObject.put("mExtras", this.r);
                jSONObject.put("mVersionCode", this.l);
                jSONObject.put("mVersionName", this.m);
                jSONObject.put("mDownloadId", this.s);
                jSONObject.put("mIsV3Event", this.J);
                jSONObject.put("mScene", this.P);
                jSONObject.put("mEventTag", this.H);
                jSONObject.put("mEventRefer", this.I);
                jSONObject.put("mDownloadUrl", this.f74122f);
                jSONObject.put("mEnableBackDialog", this.t);
                jSONObject.put("hasSendInstallFinish", this.N.get());
                jSONObject.put("hasSendDownloadFailedFinally", this.O.get());
                jSONObject.put("mLastFailedErrCode", this.A);
                jSONObject.put("mLastFailedErrMsg", this.B);
                jSONObject.put("mOpenUrl", this.f74123g);
                jSONObject.put("mLinkMode", this.j);
                jSONObject.put("mDownloadMode", this.k);
                jSONObject.put("mModelType", this.f74125i);
                jSONObject.put("mAppName", this.n);
                jSONObject.put("mAppIcon", this.o);
                jSONObject.put("mDownloadFailedTimes", this.u);
                jSONObject.put("mRecentDownloadResumeTime", this.w == 0 ? this.q : this.w);
                jSONObject.put("mClickPauseTimes", this.v);
                jSONObject.put("mJumpInstallTime", this.x);
                jSONObject.put("mCancelInstallTime", this.y);
                jSONObject.put("mLastFailedResumeCount", this.z);
                jSONObject.put("mIsUpdateDownload", this.C);
                jSONObject.put("mOriginMimeType", this.D);
                jSONObject.put("mIsPatchApplyHandled", this.E);
                jSONObject.put("downloadFinishReason", this.V);
                jSONObject.put("clickDownloadTime", this.R);
                jSONObject.put("clickDownloadSize", this.S);
                jSONObject.put("installAfterCleanSpace", this.M);
                jSONObject.put("funnelType", this.Q);
                jSONObject.put(BaiduAppJsBridgeHandler.INPUT_PARAM_WEB_URL, this.f74124h);
                jSONObject.put("enableShowComplianceDialog", this.T);
                jSONObject.put("isAutoDownloadOnCardShow", this.U);
                int i2 = 1;
                jSONObject.put("enable_new_activity", this.F ? 1 : 0);
                jSONObject.put("enable_pause", this.G ? 1 : 0);
                jSONObject.put("enable_ah", this.K ? 1 : 0);
                if (!this.L) {
                    i2 = 0;
                }
                jSONObject.put("enable_am", i2);
            } catch (Exception e2) {
                l.F().a(e2, "NativeDownloadModel toJson");
            }
            return jSONObject;
        }
        return (JSONObject) invokeV.objValue;
    }

    public void g1(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048648, this, z) == null) {
            this.F = z;
        }
    }

    @Override // d.l.a.b.a.c.a
    public int h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048649, this)) == null) ? this.Q : invokeV.intValue;
    }

    public c h0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048650, this)) == null) {
            c.a aVar = new c.a();
            aVar.b(this.f74117a);
            aVar.m(this.f74118b);
            aVar.e(this.f74119c);
            aVar.k(this.f74121e);
            aVar.f(this.r);
            aVar.g(this.p);
            aVar.i(this.l);
            aVar.t(this.m);
            aVar.p(this.f74122f);
            aVar.a(this.f74125i);
            aVar.s(this.D);
            aVar.r(this.n);
            aVar.n(this.o);
            aVar.c(new d.l.a.a.a.f.b(this.f74123g, this.f74124h, null));
            return aVar.h();
        }
        return (c) invokeV.objValue;
    }

    public void h1(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048651, this, z) == null) {
            this.G = z;
        }
    }

    @Override // d.l.a.b.a.c.a
    public String i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048652, this)) == null) ? this.I : (String) invokeV.objValue;
    }

    public d.l.a.b.a.a.b i0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048653, this)) == null) {
            b.a aVar = new b.a();
            aVar.b(this.H);
            aVar.n(this.I);
            aVar.h(this.J);
            return aVar.d();
        }
        return (d.l.a.b.a.a.b) invokeV.objValue;
    }

    public void i1(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048654, this, z) == null) {
            this.K = z;
        }
    }

    @Override // d.l.a.b.a.c.a
    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048655, this)) == null) ? this.H : (String) invokeV.objValue;
    }

    public d.l.a.b.a.a.a j0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048656, this)) == null) {
            a.C2045a c2045a = new a.C2045a();
            c2045a.c(this.t);
            c2045a.a(this.j);
            c2045a.e(this.k);
            c2045a.i(this.T);
            c2045a.j(this.K);
            c2045a.k(this.L);
            return c2045a.d();
        }
        return (d.l.a.b.a.a.a) invokeV.objValue;
    }

    public void j1(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048657, this, z) == null) {
            this.L = z;
        }
    }

    @Override // d.l.a.b.a.c.a
    public JSONObject k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048658, this)) == null) {
            return null;
        }
        return (JSONObject) invokeV.objValue;
    }

    public int k1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048659, this)) == null) ? this.u : invokeV.intValue;
    }

    @Override // d.l.a.b.a.c.a
    public long l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048660, this)) == null) ? this.f74118b : invokeV.longValue;
    }

    public void l0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048661, this, i2) == null) {
            this.v = i2;
        }
    }

    public synchronized void l1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048662, this) == null) {
            synchronized (this) {
                this.u++;
            }
        }
    }

    @Override // d.l.a.b.a.c.a
    public boolean m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048663, this)) == null) ? this.J : invokeV.booleanValue;
    }

    public void m0(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048664, this, j) == null) {
            this.x = j;
        }
    }

    public int m1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048665, this)) == null) ? this.v : invokeV.intValue;
    }

    @Override // d.l.a.b.a.c.a
    public List<String> n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048666, this)) == null) {
            return null;
        }
        return (List) invokeV.objValue;
    }

    public void n0(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048667, this, str) == null) {
            this.f74121e = str;
        }
    }

    @Override // d.l.a.b.a.c.a
    public Object o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048668, this)) == null) {
            return null;
        }
        return invokeV.objValue;
    }

    public void o0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048669, this, z) == null) {
            this.J = z;
        }
    }

    @Override // d.l.a.b.a.c.a
    public JSONObject p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048670, this)) == null) {
            return null;
        }
        return (JSONObject) invokeV.objValue;
    }

    public void p0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048671, this, i2) == null) {
            this.z = i2;
        }
    }

    @Override // d.l.a.b.a.c.a
    public boolean q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048672, this)) == null) ? this.F : invokeV.booleanValue;
    }

    public void q0(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048673, this, j) == null) {
            this.y = j;
        }
    }

    @Override // d.l.a.b.a.c.a
    public JSONObject r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048674, this)) == null) {
            return null;
        }
        return (JSONObject) invokeV.objValue;
    }

    public void r0(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048675, this, str) == null) {
            this.f74119c = str;
        }
    }

    @Override // d.l.a.b.a.c.a
    public int s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048676, this)) == null) ? this.s : invokeV.intValue;
    }

    public void s0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048677, this, z) == null) {
            this.t = z;
        }
    }

    @Override // d.l.a.b.a.c.a
    public int t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048678, this)) == null) {
            return -1;
        }
        return invokeV.intValue;
    }

    public void t0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048679, this, i2) == null) {
            this.A = i2;
        }
    }

    @Override // d.l.a.b.a.c.a
    public d u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048680, this)) == null) ? h0() : (d) invokeV.objValue;
    }

    public void u0(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048681, this, j) == null) {
            this.f74117a = j;
        }
    }

    @Override // d.l.a.b.a.c.a
    public d.l.a.a.a.d.c v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048682, this)) == null) ? i0() : (d.l.a.a.a.d.c) invokeV.objValue;
    }

    public void v0(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048683, this, str) == null) {
            this.m = str;
        }
    }

    @Override // d.l.a.b.a.c.a
    public d.l.a.a.a.d.b w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048684, this)) == null) ? j0() : (d.l.a.a.a.d.b) invokeV.objValue;
    }

    public void w0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048685, this, z) == null) {
        }
    }

    public synchronized void x() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048686, this) == null) {
            synchronized (this) {
                this.v++;
            }
        }
    }

    public void x0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048687, this, i2) == null) {
            this.f74120d = i2;
        }
    }

    public long y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048688, this)) == null) {
            long j = this.w;
            return j == 0 ? this.q : j;
        }
        return invokeV.longValue;
    }

    public void y0(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048689, this, j) == null) {
            this.f74118b = j;
        }
    }

    public long z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048690, this)) == null) ? this.x : invokeV.longValue;
    }

    public void z0(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048691, this, str) == null) {
            this.f74124h = str;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public b(d dVar, d.l.a.a.a.d.c cVar, d.l.a.a.a.d.b bVar) {
        this(dVar, cVar, bVar, 0);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {dVar, cVar, bVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((d) objArr2[0], (d.l.a.a.a.d.c) objArr2[1], (d.l.a.a.a.d.b) objArr2[2], ((Integer) objArr2[3]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public b(d dVar, d.l.a.a.a.d.c cVar, d.l.a.a.a.d.b bVar, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {dVar, cVar, bVar, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.f74120d = 1;
        this.p = true;
        this.t = false;
        this.u = 0;
        this.v = 0;
        this.C = false;
        this.E = false;
        this.F = true;
        this.G = true;
        this.K = true;
        this.L = true;
        this.N = new AtomicBoolean(false);
        this.O = new AtomicBoolean(false);
        this.Q = 1;
        this.T = true;
        this.Y = -1L;
        this.f74117a = dVar.d();
        this.f74118b = dVar.g();
        this.f74119c = dVar.u();
        this.f74121e = dVar.v();
        this.r = dVar.z();
        this.p = dVar.t();
        this.l = dVar.r();
        this.m = dVar.s();
        this.f74122f = dVar.a();
        if (dVar.x() != null) {
            this.f74123g = dVar.x().d();
            this.f74124h = dVar.x().a();
        }
        this.f74125i = dVar.A();
        this.n = dVar.h();
        this.o = dVar.w();
        this.D = dVar.i();
        this.H = cVar.b();
        this.I = cVar.a();
        this.J = cVar.m();
        this.t = bVar.c();
        this.j = bVar.a();
        this.k = bVar.b();
        this.T = bVar.e();
        this.U = bVar.f();
        this.F = bVar.g();
        this.K = bVar.h();
        this.L = bVar.i();
        this.s = i2;
        long currentTimeMillis = System.currentTimeMillis();
        this.q = currentTimeMillis;
        this.w = currentTimeMillis;
        this.E = dVar.E();
    }
}
