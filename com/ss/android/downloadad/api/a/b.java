package com.ss.android.downloadad.api.a;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.bridge.BaiduAppJsBridgeHandler;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.ss.android.download.api.download.DownloadController;
import com.ss.android.download.api.download.DownloadEventConfig;
import com.ss.android.download.api.download.DownloadModel;
import com.ss.android.download.api.model.DeepLink;
import com.ss.android.downloadad.api.constant.AdBaseConstants;
import com.ss.android.downloadad.api.download.AdDownloadController;
import com.ss.android.downloadad.api.download.AdDownloadEventConfig;
import com.ss.android.downloadad.api.download.AdDownloadModel;
import com.ss.android.downloadlib.addownload.j;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class b implements a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public long A;
    public long B;
    public long C;
    public int D;
    public int E;
    public String F;
    public boolean G;
    public String H;
    public boolean I;
    public boolean J;
    public boolean K;
    public String L;
    public String M;
    public boolean N;
    public boolean O;
    public int P;
    @AdBaseConstants.FunnelType
    public int Q;
    public long R;
    public long S;
    public boolean T;
    public boolean U;
    public String V;
    public boolean W;
    public boolean X;
    public boolean Y;
    public long Z;

    /* renamed from: a  reason: collision with root package name */
    public boolean f68379a;
    public transient boolean aa;
    public boolean ab;
    public boolean ac;
    public boolean ad;
    public boolean ae;
    public boolean af;

    /* renamed from: b  reason: collision with root package name */
    public boolean f68380b;

    /* renamed from: c  reason: collision with root package name */
    public final AtomicBoolean f68381c;

    /* renamed from: d  reason: collision with root package name */
    public final AtomicBoolean f68382d;

    /* renamed from: e  reason: collision with root package name */
    public long f68383e;

    /* renamed from: f  reason: collision with root package name */
    public long f68384f;

    /* renamed from: g  reason: collision with root package name */
    public String f68385g;

    /* renamed from: h  reason: collision with root package name */
    public int f68386h;

    /* renamed from: i  reason: collision with root package name */
    public String f68387i;
    public String j;
    public String k;
    public String l;
    public int m;
    public int n;
    public int o;
    public int p;
    public String q;
    public String r;
    public String s;
    public boolean t;
    public long u;
    public JSONObject v;
    public int w;
    public boolean x;
    public int y;
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
        this.f68386h = 1;
        this.t = true;
        this.x = false;
        this.y = 0;
        this.z = 0;
        this.G = false;
        this.I = false;
        this.J = true;
        this.K = true;
        this.f68379a = true;
        this.f68380b = true;
        this.f68381c = new AtomicBoolean(false);
        this.f68382d = new AtomicBoolean(false);
        this.Q = 1;
        this.T = true;
        this.Z = -1L;
    }

    public synchronized void A() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            synchronized (this) {
                this.z++;
            }
        }
    }

    public long B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            long j = this.A;
            return j == 0 ? this.u : j;
        }
        return invokeV.longValue;
    }

    public long C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.B : invokeV.longValue;
    }

    public int D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.D : invokeV.intValue;
    }

    public int E() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.E : invokeV.intValue;
    }

    public String F() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.F : (String) invokeV.objValue;
    }

    public int G() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f68386h : invokeV.intValue;
    }

    public long H() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.u : invokeV.longValue;
    }

    public int I() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.p : invokeV.intValue;
    }

    public String J() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.q : (String) invokeV.objValue;
    }

    public int K() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.P : invokeV.intValue;
    }

    public boolean L() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.x : invokeV.booleanValue;
    }

    public long M() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.Z : invokeV.longValue;
    }

    public String N() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.r : (String) invokeV.objValue;
    }

    public int O() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.n : invokeV.intValue;
    }

    public String P() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.V : (String) invokeV.objValue;
    }

    public boolean Q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.X : invokeV.booleanValue;
    }

    public boolean R() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.O : invokeV.booleanValue;
    }

    public boolean S() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.Y : invokeV.booleanValue;
    }

    public long T() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.R : invokeV.longValue;
    }

    public long U() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.S : invokeV.longValue;
    }

    public boolean V() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? this.G : invokeV.booleanValue;
    }

    public String W() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? this.H : (String) invokeV.objValue;
    }

    public boolean X() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? this.I : invokeV.booleanValue;
    }

    public boolean Y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? this.aa : invokeV.booleanValue;
    }

    public boolean Z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? this.ab : invokeV.booleanValue;
    }

    public void a(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048603, this, i2) == null) {
            this.y = i2;
        }
    }

    public boolean aa() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) ? this.ad : invokeV.booleanValue;
    }

    public boolean ab() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) ? this.ac : invokeV.booleanValue;
    }

    public boolean ac() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) ? this.ae : invokeV.booleanValue;
    }

    public boolean ad() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) ? this.af : invokeV.booleanValue;
    }

    public JSONObject ae() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("mId", this.f68383e);
                jSONObject.put("mExtValue", this.f68384f);
                jSONObject.put("mLogExtra", this.f68385g);
                jSONObject.put("mDownloadStatus", this.f68386h);
                jSONObject.put("mPackageName", this.f68387i);
                jSONObject.put("mIsAd", this.t);
                jSONObject.put("mTimeStamp", this.u);
                jSONObject.put("mExtras", this.v);
                jSONObject.put("mVersionCode", this.p);
                jSONObject.put("mVersionName", this.q);
                jSONObject.put("mDownloadId", this.w);
                jSONObject.put("mIsV3Event", this.N);
                jSONObject.put("mScene", this.P);
                jSONObject.put("mEventTag", this.L);
                jSONObject.put("mEventRefer", this.M);
                jSONObject.put("mDownloadUrl", this.j);
                jSONObject.put("mEnableBackDialog", this.x);
                jSONObject.put("hasSendInstallFinish", this.f68381c.get());
                jSONObject.put("hasSendDownloadFailedFinally", this.f68382d.get());
                jSONObject.put("mLastFailedErrCode", this.E);
                jSONObject.put("mLastFailedErrMsg", this.F);
                jSONObject.put("mOpenUrl", this.k);
                jSONObject.put("mLinkMode", this.n);
                jSONObject.put("mDownloadMode", this.o);
                jSONObject.put("mModelType", this.m);
                jSONObject.put("mAppName", this.r);
                jSONObject.put("mAppIcon", this.s);
                jSONObject.put("mDownloadFailedTimes", this.y);
                jSONObject.put("mRecentDownloadResumeTime", this.A == 0 ? this.u : this.A);
                jSONObject.put("mClickPauseTimes", this.z);
                jSONObject.put("mJumpInstallTime", this.B);
                jSONObject.put("mCancelInstallTime", this.C);
                jSONObject.put("mLastFailedResumeCount", this.D);
                jSONObject.put("mIsUpdateDownload", this.G);
                jSONObject.put("mOriginMimeType", this.H);
                jSONObject.put("mIsPatchApplyHandled", this.I);
                jSONObject.put("downloadFinishReason", this.V);
                jSONObject.put("clickDownloadTime", this.R);
                jSONObject.put("clickDownloadSize", this.S);
                jSONObject.put("installAfterCleanSpace", this.O);
                jSONObject.put("funnelType", this.Q);
                jSONObject.put(BaiduAppJsBridgeHandler.INPUT_PARAM_WEB_URL, this.l);
                jSONObject.put("enableShowComplianceDialog", this.T);
                jSONObject.put("isAutoDownloadOnCardShow", this.U);
                int i2 = 1;
                jSONObject.put("enable_new_activity", this.J ? 1 : 0);
                jSONObject.put("enable_pause", this.K ? 1 : 0);
                jSONObject.put("enable_ah", this.f68379a ? 1 : 0);
                if (!this.f68380b) {
                    i2 = 0;
                }
                jSONObject.put("enable_am", i2);
            } catch (Exception e2) {
                j.s().a(e2, "NativeDownloadModel toJson");
            }
            return jSONObject;
        }
        return (JSONObject) invokeV.objValue;
    }

    public AdDownloadModel af() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048613, this)) == null) ? new AdDownloadModel.Builder().setAdId(this.f68383e).setExtraValue(this.f68384f).setLogExtra(this.f68385g).setPackageName(this.f68387i).setExtra(this.v).setIsAd(this.t).setVersionCode(this.p).setVersionName(this.q).setDownloadUrl(this.j).setModelType(this.m).setMimeType(this.H).setAppName(this.r).setAppIcon(this.s).setDeepLink(new DeepLink(this.k, this.l, null)).build() : (AdDownloadModel) invokeV.objValue;
    }

    public AdDownloadEventConfig ag() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048614, this)) == null) ? new AdDownloadEventConfig.Builder().setClickButtonTag(this.L).setRefer(this.M).setIsEnableV3Event(this.N).build() : (AdDownloadEventConfig) invokeV.objValue;
    }

    public AdDownloadController ah() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048615, this)) == null) ? new AdDownloadController.Builder().setIsEnableBackDialog(this.x).setLinkMode(this.n).setDownloadMode(this.o).setEnableShowComplianceDialog(this.T).setEnableAH(this.f68379a).setEnableAM(this.f68380b).build() : (AdDownloadController) invokeV.objValue;
    }

    public void b(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048617, this, i2) == null) {
            this.z = i2;
        }
    }

    public void c(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048622, this, j) == null) {
            this.C = j;
        }
    }

    public void d(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048627, this, i2) == null) {
            this.E = i2;
        }
    }

    public void e(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048633, this, j) == null) {
            this.f68384f = j;
        }
    }

    public void f(long j) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeJ(1048638, this, j) == null) || j <= 0) {
            return;
        }
        this.u = j;
    }

    @Override // com.ss.android.downloadad.api.a.a
    public JSONObject g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048641, this)) == null) ? this.v : (JSONObject) invokeV.objValue;
    }

    public void h(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048647, this, i2) == null) {
            this.P = i2;
        }
    }

    public void i(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048652, this, i2) == null) {
            this.Q = i2;
        }
    }

    @Override // com.ss.android.downloadad.api.a.a
    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048656, this)) == null) ? this.L : (String) invokeV.objValue;
    }

    @Override // com.ss.android.downloadad.api.a.a
    public JSONObject k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048660, this)) == null) {
            return null;
        }
        return (JSONObject) invokeV.objValue;
    }

    public void k(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048662, this, str) == null) {
            this.s = str;
        }
    }

    @Override // com.ss.android.downloadad.api.a.a
    public long l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048664, this)) == null) ? this.f68384f : invokeV.longValue;
    }

    @Override // com.ss.android.downloadad.api.a.a
    public boolean m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048670, this)) == null) ? this.N : invokeV.booleanValue;
    }

    @Override // com.ss.android.downloadad.api.a.a
    public List<String> n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048671, this)) == null) {
            return null;
        }
        return (List) invokeV.objValue;
    }

    public void n(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048672, this, z) == null) {
            this.ae = z;
        }
    }

    @Override // com.ss.android.downloadad.api.a.a
    public Object o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048673, this)) == null) {
            return null;
        }
        return invokeV.objValue;
    }

    public void o(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048674, this, z) == null) {
            this.af = z;
        }
    }

    @Override // com.ss.android.downloadad.api.a.a
    public JSONObject p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048675, this)) == null) {
            return null;
        }
        return (JSONObject) invokeV.objValue;
    }

    public void p(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048676, this, z) == null) {
            this.T = z;
        }
    }

    public void q(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048677, this, z) == null) {
            this.U = z;
        }
    }

    @Override // com.ss.android.downloadad.api.a.a
    public JSONObject r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048679, this)) == null) {
            return null;
        }
        return (JSONObject) invokeV.objValue;
    }

    public void r(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048680, this, z) == null) {
            this.J = z;
        }
    }

    @Override // com.ss.android.downloadad.api.a.a
    public int s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048681, this)) == null) ? this.w : invokeV.intValue;
    }

    @Override // com.ss.android.downloadad.api.a.a
    public int t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048683, this)) == null) {
            return -1;
        }
        return invokeV.intValue;
    }

    public void t(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048684, this, z) == null) {
            this.f68379a = z;
        }
    }

    public void u(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048686, this, z) == null) {
            this.f68380b = z;
        }
    }

    @Override // com.ss.android.downloadad.api.a.a
    public DownloadEventConfig v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048687, this)) == null) ? ag() : (DownloadEventConfig) invokeV.objValue;
    }

    @Override // com.ss.android.downloadad.api.a.a
    public DownloadController w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048688, this)) == null) ? ah() : (DownloadController) invokeV.objValue;
    }

    public int x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048689, this)) == null) ? this.y : invokeV.intValue;
    }

    public synchronized void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048690, this) == null) {
            synchronized (this) {
                this.y++;
            }
        }
    }

    public int z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048691, this)) == null) ? this.z : invokeV.intValue;
    }

    public void a(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048604, this, j) == null) {
            this.A = j;
        }
    }

    public void b(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048618, this, j) == null) {
            this.B = j;
        }
    }

    public void c(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048621, this, i2) == null) {
            this.D = i2;
        }
    }

    public void d(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048628, this, j) == null) {
            this.f68383e = j;
        }
    }

    public void e(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048632, this, i2) == null) {
            this.f68386h = i2;
        }
    }

    public void f(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048637, this, i2) == null) {
            this.p = i2;
        }
    }

    public void g(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048642, this, i2) == null) {
            this.w = i2;
        }
    }

    @Override // com.ss.android.downloadad.api.a.a
    public int h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048646, this)) == null) ? this.Q : invokeV.intValue;
    }

    @Override // com.ss.android.downloadad.api.a.a
    public String i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048651, this)) == null) ? this.M : (String) invokeV.objValue;
    }

    public void j(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048658, this, str) == null) {
            this.r = str;
        }
    }

    public void k(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048661, this, i2) == null) {
            this.o = i2;
        }
    }

    public void l(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048665, this, i2) == null) {
            this.m = i2;
        }
    }

    public void m(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048668, this, str) == null) {
            this.H = str;
        }
    }

    @Override // com.ss.android.downloadad.api.a.a
    public boolean q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048678, this)) == null) ? this.J : invokeV.booleanValue;
    }

    public void s(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048682, this, z) == null) {
            this.K = z;
        }
    }

    @Override // com.ss.android.downloadad.api.a.a
    public DownloadModel u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048685, this)) == null) ? af() : (DownloadModel) invokeV.objValue;
    }

    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048605, this, str) == null) {
            this.F = str;
        }
    }

    @Override // com.ss.android.downloadad.api.a.a
    public long b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048616, this)) == null) ? this.f68383e : invokeV.longValue;
    }

    public void c(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048623, this, str) == null) {
            this.f68385g = str;
        }
    }

    @Override // com.ss.android.downloadad.api.a.a
    public String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048626, this)) == null) ? this.f68385g : (String) invokeV.objValue;
    }

    @Override // com.ss.android.downloadad.api.a.a
    public String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048631, this)) == null) ? this.f68387i : (String) invokeV.objValue;
    }

    public void f(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048639, this, str) == null) {
            this.L = str;
        }
    }

    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048644, this, str) == null) {
            this.M = str;
        }
    }

    public void h(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048649, this, str) == null) {
            this.j = str;
        }
    }

    public void i(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048654, this, str) == null) {
            this.k = str;
        }
    }

    public void j(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048657, this, i2) == null) {
            this.n = i2;
        }
    }

    public void k(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048663, this, z) == null) {
            this.ab = z;
        }
    }

    public void l(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048666, this, str) == null) {
            this.V = str;
        }
    }

    public void m(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048669, this, z) == null) {
            this.ac = z;
        }
    }

    public void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048607, this, z) == null) {
            this.t = z;
        }
    }

    public void b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048619, this, str) == null) {
            this.f68387i = str;
        }
    }

    @Override // com.ss.android.downloadad.api.a.a
    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048625, this)) == null) ? this.t : invokeV.booleanValue;
    }

    public void d(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048629, this, str) == null) {
            this.q = str;
        }
    }

    public void e(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048634, this, str) == null) {
            this.l = str;
        }
    }

    @Override // com.ss.android.downloadad.api.a.a
    public String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048636, this)) == null) ? this.k : (String) invokeV.objValue;
    }

    public void g(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048643, this, j) == null) {
            this.Z = j;
        }
    }

    public void h(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048648, this, j) == null) {
            this.R = j;
        }
    }

    public void i(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048653, this, j) == null) {
            this.S = j;
        }
    }

    public void j(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048659, this, z) == null) {
            this.aa = z;
        }
    }

    public void l(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048667, this, z) == null) {
            this.ad = z;
        }
    }

    public void a(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048606, this, jSONObject) == null) {
            this.v = jSONObject;
        }
    }

    public void b(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048620, this, z) == null) {
            this.N = z;
        }
    }

    public void c(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048624, this, z) == null) {
            this.x = z;
        }
    }

    public void d(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048630, this, z) == null) {
            this.W = z;
        }
    }

    public void e(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048635, this, z) == null) {
            this.X = z;
        }
    }

    public void f(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048640, this, z) == null) {
            this.O = z;
        }
    }

    public void g(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048645, this, z) == null) {
            this.Y = z;
        }
    }

    public void h(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048650, this, z) == null) {
            this.G = z;
        }
    }

    public void i(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048655, this, z) == null) {
            this.I = z;
        }
    }

    public static b b(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, jSONObject)) == null) {
            if (jSONObject == null) {
                return null;
            }
            b bVar = new b();
            try {
                bVar.d(com.ss.android.download.api.c.b.a(jSONObject, "mId"));
                bVar.e(com.ss.android.download.api.c.b.a(jSONObject, "mExtValue"));
                bVar.c(jSONObject.optString("mLogExtra"));
                bVar.e(jSONObject.optInt("mDownloadStatus"));
                bVar.b(jSONObject.optString("mPackageName"));
                boolean z = true;
                bVar.a(jSONObject.optBoolean("mIsAd", true));
                bVar.f(com.ss.android.download.api.c.b.a(jSONObject, "mTimeStamp"));
                bVar.f(jSONObject.optInt("mVersionCode"));
                bVar.d(jSONObject.optString("mVersionName"));
                bVar.g(jSONObject.optInt("mDownloadId"));
                bVar.b(jSONObject.optBoolean("mIsV3Event"));
                bVar.h(jSONObject.optInt("mScene"));
                bVar.f(jSONObject.optString("mEventTag"));
                bVar.g(jSONObject.optString("mEventRefer"));
                bVar.h(jSONObject.optString("mDownloadUrl"));
                bVar.c(jSONObject.optBoolean("mEnableBackDialog"));
                bVar.f68381c.set(jSONObject.optBoolean("hasSendInstallFinish"));
                bVar.f68382d.set(jSONObject.optBoolean("hasSendDownloadFailedFinally"));
                bVar.d(jSONObject.optInt("mLastFailedErrCode"));
                bVar.a(jSONObject.optString("mLastFailedErrMsg"));
                bVar.i(jSONObject.optString("mOpenUrl"));
                bVar.j(jSONObject.optInt("mLinkMode"));
                bVar.k(jSONObject.optInt("mDownloadMode"));
                bVar.l(jSONObject.optInt("mModelType"));
                bVar.j(jSONObject.optString("mAppName"));
                bVar.k(jSONObject.optString("mAppIcon"));
                bVar.a(jSONObject.optInt("mDownloadFailedTimes", 0));
                bVar.a(com.ss.android.download.api.c.b.a(jSONObject, "mRecentDownloadResumeTime"));
                bVar.b(jSONObject.optInt("mClickPauseTimes"));
                bVar.b(com.ss.android.download.api.c.b.a(jSONObject, "mJumpInstallTime"));
                bVar.c(com.ss.android.download.api.c.b.a(jSONObject, "mCancelInstallTime"));
                bVar.c(jSONObject.optInt("mLastFailedResumeCount"));
                bVar.l(jSONObject.optString("downloadFinishReason"));
                bVar.i(jSONObject.optLong("clickDownloadSize"));
                bVar.h(jSONObject.optLong("clickDownloadTime"));
                bVar.h(jSONObject.optBoolean("mIsUpdateDownload"));
                bVar.m(jSONObject.optString("mOriginMimeType"));
                bVar.i(jSONObject.optBoolean("mIsPatchApplyHandled"));
                bVar.f(jSONObject.optBoolean("installAfterCleanSpace"));
                bVar.i(jSONObject.optInt("funnelType", 1));
                bVar.e(jSONObject.optString(BaiduAppJsBridgeHandler.INPUT_PARAM_WEB_URL));
                bVar.p(jSONObject.optBoolean("enableShowComplianceDialog", true));
                bVar.q(jSONObject.optBoolean("isAutoDownloadOnCardShow"));
                bVar.r(jSONObject.optInt("enable_new_activity", 1) == 1);
                bVar.s(jSONObject.optInt("enable_pause", 1) == 1);
                bVar.t(jSONObject.optInt("enable_ah", 1) == 1);
                if (jSONObject.optInt("enable_am", 1) != 1) {
                    z = false;
                }
                bVar.u(z);
                bVar.a(jSONObject.optJSONObject("mExtras"));
            } catch (Exception e2) {
                j.s().a(e2, "NativeDownloadModel fromJson");
            }
            return bVar;
        }
        return (b) invokeL.objValue;
    }

    @Override // com.ss.android.downloadad.api.a.a
    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) ? this.j : (String) invokeV.objValue;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public b(DownloadModel downloadModel, DownloadEventConfig downloadEventConfig, DownloadController downloadController) {
        this(downloadModel, downloadEventConfig, downloadController, 0);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {downloadModel, downloadEventConfig, downloadController};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((DownloadModel) objArr2[0], (DownloadEventConfig) objArr2[1], (DownloadController) objArr2[2], ((Integer) objArr2[3]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public b(DownloadModel downloadModel, DownloadEventConfig downloadEventConfig, DownloadController downloadController, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {downloadModel, downloadEventConfig, downloadController, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.f68386h = 1;
        this.t = true;
        this.x = false;
        this.y = 0;
        this.z = 0;
        this.G = false;
        this.I = false;
        this.J = true;
        this.K = true;
        this.f68379a = true;
        this.f68380b = true;
        this.f68381c = new AtomicBoolean(false);
        this.f68382d = new AtomicBoolean(false);
        this.Q = 1;
        this.T = true;
        this.Z = -1L;
        this.f68383e = downloadModel.getId();
        this.f68384f = downloadModel.getExtraValue();
        this.f68385g = downloadModel.getLogExtra();
        this.f68387i = downloadModel.getPackageName();
        this.v = downloadModel.getExtra();
        this.t = downloadModel.isAd();
        this.p = downloadModel.getVersionCode();
        this.q = downloadModel.getVersionName();
        this.j = downloadModel.getDownloadUrl();
        if (downloadModel.getDeepLink() != null) {
            this.k = downloadModel.getDeepLink().getOpenUrl();
            this.l = downloadModel.getDeepLink().getWebUrl();
        }
        this.m = downloadModel.getModelType();
        this.r = downloadModel.getName();
        this.s = downloadModel.getAppIcon();
        this.H = downloadModel.getMimeType();
        this.L = downloadEventConfig.getClickButtonTag();
        this.M = downloadEventConfig.getRefer();
        this.N = downloadEventConfig.isEnableV3Event();
        this.x = downloadController.isEnableBackDialog();
        this.n = downloadController.getLinkMode();
        this.o = downloadController.getDownloadMode();
        this.T = downloadController.enableShowComplianceDialog();
        this.U = downloadController.isAutoDownloadOnCardShow();
        this.J = downloadController.enableNewActivity();
        this.f68379a = downloadController.enableAH();
        this.f68380b = downloadController.enableAM();
        this.w = i2;
        long currentTimeMillis = System.currentTimeMillis();
        this.u = currentTimeMillis;
        this.A = currentTimeMillis;
        this.I = downloadModel.shouldDownloadWithPatchApply();
    }
}
