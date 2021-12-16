package com.kwad.sdk.core.report;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.model.PageInfo;
import com.kwad.sdk.core.response.model.PreloadData;
import com.kwad.sdk.core.scene.EntryPackage;
import com.kwad.sdk.core.scene.URLPackage;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.live.mode.LiveInfo;
import com.kwad.sdk.utils.t;
import java.io.Serializable;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class ReportAction extends c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public long A;
    public long B;
    public long C;
    public String D;
    public int E;
    public int F;
    public int G;
    public int H;
    public int I;
    public int J;
    public String K;
    public URLPackage L;
    public URLPackage M;
    public long N;
    public int O;
    public String P;
    public int Q;
    public int R;
    public long S;
    public long T;
    public int U;
    public int V;
    public int W;
    public JSONArray X;
    public JSONArray Y;
    public String Z;
    public int aA;
    public int aB;
    public String aC;
    public String aD;
    public int aE;
    public long aF;
    public LiveLogInfo aG;
    public String aH;
    public int aI;
    public int aJ;
    public String aK;
    public String aL;
    public JSONObject aM;
    public JSONArray aN;
    public long aO;
    public int aP;
    public int aQ;
    public int aR;
    public int aS;
    public int aT;
    public long aU;
    public JSONArray aV;
    public boolean aW;
    public String aX;
    public int aY;
    public int aZ;
    public String aa;
    public String ab;
    public String ac;
    public long ad;
    public long ae;
    public int af;
    public int ag;
    public String ah;
    public a ai;
    public int aj;
    public int ak;
    public String al;
    public long am;
    public String an;
    public String ao;
    public long ap;
    public long aq;
    public long ar;
    public int as;
    public int at;
    public int au;
    public int av;
    public int aw;
    public int ax;
    public int ay;
    public JSONArray az;

    /* renamed from: b  reason: collision with root package name */
    public transient SceneImpl f58217b;
    public String bA;
    public int bB;
    public int bC;
    public long bD;
    public int bE;
    public String bF;
    public int bG;
    public double bH;
    public String bI;
    public int bJ;
    public int bK;
    public String bL;
    public String bM;
    public int ba;
    public String bb;
    public long bc;
    public long bd;
    public int be;
    public String bf;
    public long bg;
    public long bh;
    public long bi;
    public long bj;
    public String bk;
    public String bl;
    public long bm;
    public long bn;
    public JSONArray bo;
    public long bp;
    public long bq;
    public long br;
    public JSONArray bs;
    public int bt;
    public String bu;
    public String bv;
    public String bw;
    public String bx;
    public String by;
    public String bz;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    public transient AdTemplate f58218c;

    /* renamed from: d  reason: collision with root package name */
    public long f58219d;

    /* renamed from: e  reason: collision with root package name */
    public String f58220e;

    /* renamed from: f  reason: collision with root package name */
    public long f58221f;

    /* renamed from: g  reason: collision with root package name */
    public int f58222g;

    /* renamed from: h  reason: collision with root package name */
    public long f58223h;

    /* renamed from: i  reason: collision with root package name */
    public long f58224i;

    /* renamed from: j  reason: collision with root package name */
    public long f58225j;

    /* renamed from: k  reason: collision with root package name */
    public JSONObject f58226k;
    public JSONObject l;
    public long m;
    public int n;
    public int o;
    public long p;
    public long q;
    public long r;
    public long s;
    public long t;
    public long u;
    public long v;
    public long w;
    public long x;
    public long y;
    public long z;

    /* loaded from: classes3.dex */
    public static class LiveLogInfo extends com.kwad.sdk.core.response.kwai.a implements Serializable {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = 4898843925487388950L;
        public transient /* synthetic */ FieldHolder $fh;
        public String liveStreamId;

        public LiveLogInfo() {
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
    }

    /* loaded from: classes3.dex */
    public static final class a extends com.kwad.sdk.core.response.kwai.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;

        /* renamed from: b  reason: collision with root package name */
        public int f58227b;

        public a() {
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

        public static a a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
                a aVar = new a();
                aVar.a = b.a;
                aVar.f58227b = b.f58228b;
                return aVar;
            }
            return (a) invokeV.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public static int a;

        /* renamed from: b  reason: collision with root package name */
        public static int f58228b;
        public transient /* synthetic */ FieldHolder $fh;
    }

    public ReportAction(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Long.valueOf(j2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f58222g = -1;
        this.n = 0;
        this.o = 0;
        this.B = -1L;
        this.G = 0;
        this.H = 0;
        this.I = -1;
        this.J = 0;
        this.V = -1;
        this.W = 0;
        this.aq = -1L;
        this.ar = -1L;
        this.av = -1;
        this.aG = new LiveLogInfo();
        this.aS = -1;
        this.aT = -1;
        this.aU = 0L;
        this.aY = 0;
        this.aZ = -1;
        this.ba = 0;
        this.bK = 0;
        this.f58224i = j2;
    }

    public ReportAction(long j2, @NonNull AdTemplate adTemplate) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Long.valueOf(j2), adTemplate};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f58222g = -1;
        this.n = 0;
        this.o = 0;
        this.B = -1L;
        this.G = 0;
        this.H = 0;
        this.I = -1;
        this.J = 0;
        this.V = -1;
        this.W = 0;
        this.aq = -1L;
        this.ar = -1L;
        this.av = -1;
        this.aG = new LiveLogInfo();
        this.aS = -1;
        this.aT = -1;
        this.aU = 0L;
        this.aY = 0;
        this.aZ = -1;
        this.ba = 0;
        this.bK = 0;
        this.f58224i = j2;
        this.f58218c = adTemplate;
    }

    public ReportAction(String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.f58222g = -1;
        this.n = 0;
        this.o = 0;
        this.B = -1L;
        this.G = 0;
        this.H = 0;
        this.I = -1;
        this.J = 0;
        this.V = -1;
        this.W = 0;
        this.aq = -1L;
        this.ar = -1L;
        this.av = -1;
        this.aG = new LiveLogInfo();
        this.aS = -1;
        this.aT = -1;
        this.aU = 0L;
        this.aY = 0;
        this.aZ = -1;
        this.ba = 0;
        this.bK = 0;
        try {
            parseJson(new JSONObject(str));
        } catch (JSONException e2) {
            com.kwad.sdk.core.d.a.a(e2);
        }
    }

    public ReportAction(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {jSONObject};
            interceptable.invokeUnInit(65539, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        this.f58222g = -1;
        this.n = 0;
        this.o = 0;
        this.B = -1L;
        this.G = 0;
        this.H = 0;
        this.I = -1;
        this.J = 0;
        this.V = -1;
        this.W = 0;
        this.aq = -1L;
        this.ar = -1L;
        this.av = -1;
        this.aG = new LiveLogInfo();
        this.aS = -1;
        this.aT = -1;
        this.aU = 0L;
        this.aY = 0;
        this.aZ = -1;
        this.ba = 0;
        this.bK = 0;
        parseJson(jSONObject);
    }

    public static ReportAction a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                return jSONObject.optBoolean("ecIdentityFlag", false) ? new m(jSONObject) : new ReportAction(jSONObject);
            } catch (JSONException e2) {
                com.kwad.sdk.core.d.a.a(e2);
                return new ReportAction("");
            }
        }
        return (ReportAction) invokeL.objValue;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v69, resolved type: boolean */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0190  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x01a2  */
    /* JADX WARN: Removed duplicated region for block: B:74:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void a(@Nullable AdTemplate adTemplate) {
        SceneImpl sceneImpl;
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeL(65541, this, adTemplate) != null) {
            return;
        }
        this.ak = 3;
        com.kwad.sdk.plugin.b bVar = (com.kwad.sdk.plugin.b) com.kwad.sdk.plugin.f.a(com.kwad.sdk.plugin.b.class);
        if (bVar != null) {
            this.aY = bVar.d();
        }
        this.a = UUID.randomUUID().toString();
        this.f58219d = System.currentTimeMillis();
        this.f58220e = n.b();
        try {
            this.f58221f = n.c();
        } catch (Exception e2) {
            com.kwad.sdk.core.d.a.b(e2);
        }
        this.f58223h = n.e();
        SceneImpl sceneImpl2 = this.f58217b;
        if (sceneImpl2 == null) {
            if (adTemplate != null && (sceneImpl2 = adTemplate.mAdScene) != null) {
                this.f58217b = sceneImpl2;
            }
            if (adTemplate != null) {
                this.q = adTemplate.getShowPosition() + 1;
                this.r = adTemplate.getServerPosition() + 1;
                this.f58225j = com.kwad.sdk.core.response.a.d.g(adTemplate);
                String h2 = com.kwad.sdk.core.response.a.d.h(adTemplate);
                if (!TextUtils.isEmpty(h2)) {
                    try {
                        this.f58226k = new JSONObject(h2);
                    } catch (Exception e3) {
                        com.kwad.sdk.core.d.a.b(e3);
                    }
                }
                String i2 = com.kwad.sdk.core.response.a.d.i(adTemplate);
                if (!TextUtils.isEmpty(i2)) {
                    try {
                        this.l = new JSONObject(i2);
                    } catch (Exception e4) {
                        com.kwad.sdk.core.d.a.b(e4);
                    }
                }
                this.m = com.kwad.sdk.core.response.a.d.e(adTemplate);
                this.n = com.kwad.sdk.core.response.a.d.f(adTemplate);
                this.o = adTemplate.realShowType;
                this.p = com.kwad.sdk.core.response.a.d.p(adTemplate);
                int i3 = this.o;
                if (i3 == 1) {
                    this.s = com.kwad.sdk.core.response.a.f.c(adTemplate.photoInfo).longValue();
                    this.N = com.kwad.sdk.core.response.a.f.h(adTemplate.photoInfo);
                    this.ah = com.kwad.sdk.core.response.a.f.g(adTemplate.photoInfo);
                    this.al = com.kwad.sdk.core.response.a.f.k(adTemplate.photoInfo);
                    this.am = com.kwad.sdk.core.response.a.f.j(adTemplate.photoInfo);
                    this.an = com.kwad.sdk.core.response.a.f.l(adTemplate.photoInfo);
                    this.ap = com.kwad.sdk.core.response.a.f.m(adTemplate.photoInfo);
                    this.ao = com.kwad.sdk.core.response.a.f.n(adTemplate.photoInfo);
                    PreloadData preloadData = adTemplate.mPreloadData;
                    this.ay = preloadData != null ? preloadData.isPreload : 0;
                    this.bK = com.kwad.sdk.core.response.a.f.a(adTemplate) ? 1 : 0;
                } else if (i3 == 2) {
                    AdInfo j2 = com.kwad.sdk.core.response.a.d.j(adTemplate);
                    this.aF = j2.adBaseInfo.creativeId;
                    this.s = com.kwad.sdk.core.response.a.a.b(j2) * 1000;
                    this.N = j2.advertiserInfo.userId;
                } else if (i3 == 4) {
                    LiveInfo r = com.kwad.sdk.core.response.a.d.r(adTemplate);
                    this.aG.liveStreamId = com.kwad.sdk.live.mode.a.a(r);
                    this.N = com.kwad.sdk.live.mode.a.b(r);
                    if (com.kwad.sdk.b.f57626d.booleanValue()) {
                        this.bK = 1;
                    }
                } else if (i3 == 5) {
                    this.bJ = com.kwad.sdk.core.response.a.e.c(com.kwad.sdk.core.response.a.d.l(this.f58218c));
                }
                this.aj = adTemplate.mMediaPlayerType;
                this.ax = adTemplate.mIsLeftSlipStatus;
                this.aB = adTemplate.mPhotoResponseType;
                PageInfo pageInfo = adTemplate.mPageInfo;
                if (pageInfo != null) {
                    this.aP = pageInfo.pageType;
                }
                this.F = com.kwad.sdk.core.response.a.d.q(adTemplate);
            }
            this.ai = a.a();
            if (this.f58217b == null && adTemplate != null) {
                this.f58217b = adTemplate.mAdScene;
            }
            sceneImpl = this.f58217b;
            if (sceneImpl != null) {
                this.m = sceneImpl.getPosId();
                this.L = this.f58217b.getUrlPackage();
            }
            if (this.L == null) {
                EntryPackage b2 = com.kwad.sdk.core.scene.a.a().b(this.L.identity);
                this.K = b2.entryPageSource;
                this.ab = b2.entryId;
                this.M = com.kwad.sdk.core.scene.a.a().a(this.L.identity);
                return;
            }
            return;
        }
        this.m = sceneImpl2.getPosId();
        this.L = this.f58217b.getUrlPackage();
        this.f58222g = this.f58217b.getAdStyle();
        if (adTemplate != null) {
        }
        this.ai = a.a();
        if (this.f58217b == null) {
            this.f58217b = adTemplate.mAdScene;
        }
        sceneImpl = this.f58217b;
        if (sceneImpl != null) {
        }
        if (this.L == null) {
        }
    }

    @Override // com.kwad.sdk.core.report.c, com.kwad.sdk.core.response.kwai.a
    public void afterParseJson(@Nullable JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, jSONObject) == null) {
            super.afterParseJson(jSONObject);
            if (jSONObject == null) {
                return;
            }
            this.ak = 3;
            this.f58222g = jSONObject.optInt("adStyle", -1);
            this.as = jSONObject.optInt("adHorizontalFeedType");
            this.at = jSONObject.optInt("videoPlayMode");
            this.au = jSONObject.optInt("autoReplayTimes");
            this.V = jSONObject.optInt("reportType");
            this.I = jSONObject.optInt("playerControlledType", -1);
            this.aJ = jSONObject.optInt("num");
            this.aI = jSONObject.optInt("state");
            this.aq = jSONObject.optLong("relatedFromPhotoId", -1L);
            this.ar = jSONObject.optLong("relatedContentSourceType", -1L);
            this.av = jSONObject.optInt("hotCompType", -1);
            this.aU = jSONObject.optLong("timeSpend");
            this.bq = jSONObject.optLong("loadingDuration");
            this.br = jSONObject.optLong("loadingDurationLimt");
            this.aZ = jSONObject.optInt("playerTypeInfo", -1);
            if (jSONObject.has("actionId")) {
                this.a = jSONObject.optString("actionId");
            }
            this.bK = jSONObject.optInt("adBizType");
        }
    }

    @Override // com.kwad.sdk.core.report.c, com.kwad.sdk.core.response.kwai.a
    public void afterToJson(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONObject) == null) {
            super.afterToJson(jSONObject);
            t.a(jSONObject, "actionId", this.a);
            int i2 = this.f58222g;
            if (i2 > 0) {
                t.a(jSONObject, "adStyle", i2);
            }
            int i3 = this.V;
            if (i3 != -1) {
                t.a(jSONObject, "reportType", i3);
            }
            int i4 = this.I;
            if (i4 != -1) {
                t.a(jSONObject, "playerControlledType", i4);
            }
            int i5 = this.aJ;
            if (i5 > 0) {
                t.a(jSONObject, "num", i5);
            }
            int i6 = this.aI;
            if (i6 != 0) {
                t.a(jSONObject, "state", i6);
            }
            long j2 = this.aq;
            if (j2 != -1) {
                t.a(jSONObject, "relatedFromPhotoId", j2);
            }
            long j3 = this.ar;
            if (j3 != -1) {
                t.a(jSONObject, "relatedContentSourceType", j3);
            }
            int i7 = this.av;
            if (i7 != -1) {
                t.a(jSONObject, "hotCompType", i7);
            }
            long j4 = this.aU;
            if (j4 > 0) {
                t.a(jSONObject, "timeSpend", j4);
            }
            long j5 = this.bq;
            if (j5 > 0) {
                t.a(jSONObject, "loadingDuration", j5);
            }
            long j6 = this.br;
            if (j6 > 0) {
                t.a(jSONObject, "loadingDurationLimt", j6);
            }
            t.a(jSONObject, "adHorizontalFeedType", this.as);
            t.a(jSONObject, "videoPlayMode", this.at);
            t.a(jSONObject, "autoReplayTimes", this.au);
            t.a(jSONObject, "playerTypeInfo", this.aZ);
            int i8 = this.bK;
            if (i8 > 0) {
                t.a(jSONObject, "adBizType", i8);
            }
        }
    }

    public ReportAction b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            a(this.f58218c);
            return this;
        }
        return (ReportAction) invokeV.objValue;
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            com.kwad.sdk.core.h.b a2 = com.kwad.sdk.core.h.b.a();
            this.aR = a2.b() ? 1 : 0;
            this.aS = a2.c();
            this.aT = a2.d();
        }
    }
}
