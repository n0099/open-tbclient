package com.kwad.sdk.core.report;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
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
import com.kwad.sdk.utils.q;
import java.io.Serializable;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
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
    public String aA;
    public int aB;
    public long aC;
    public LiveLogInfo aD;
    public String aE;
    public int aF;
    public int aG;
    public String aH;
    public String aI;
    public JSONObject aJ;
    public JSONArray aK;
    public long aL;
    public int aM;
    public int aN;
    public int aO;
    public int aP;
    public int aQ;
    public long aR;
    public JSONArray aS;
    public boolean aT;
    public String aU;
    public int aV;
    public int aW;
    public int aX;
    public String aY;
    public long aZ;
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
    public JSONArray aw;
    public int ax;
    public int ay;
    public String az;

    /* renamed from: b  reason: collision with root package name */
    public transient SceneImpl f72467b;
    public long ba;
    public int bb;
    public String bc;
    public long bd;
    public long be;
    public long bf;
    public long bg;
    public String bh;
    public String bi;
    public long bj;
    public long bk;
    public JSONArray bl;
    public long bm;
    public long bn;
    public long bo;
    public JSONArray bp;
    public int bq;
    public String br;
    public String bs;
    public String bt;
    public String bu;
    public String bv;
    public int bw;
    public double bx;
    public String by;
    public int bz;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    public transient AdTemplate f72468c;

    /* renamed from: d  reason: collision with root package name */
    public long f72469d;

    /* renamed from: e  reason: collision with root package name */
    public String f72470e;

    /* renamed from: f  reason: collision with root package name */
    public long f72471f;

    /* renamed from: g  reason: collision with root package name */
    public int f72472g;

    /* renamed from: h  reason: collision with root package name */
    public long f72473h;

    /* renamed from: i  reason: collision with root package name */
    public long f72474i;

    /* renamed from: j  reason: collision with root package name */
    public long f72475j;
    public JSONObject k;
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

    /* loaded from: classes10.dex */
    public static class LiveLogInfo extends com.kwad.sdk.core.response.a.a implements Serializable {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = 4898843925487388950L;
        public transient /* synthetic */ FieldHolder $fh;
        public String expTag;
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

    /* loaded from: classes10.dex */
    public static final class a extends com.kwad.sdk.core.response.a.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public int f72476a;

        /* renamed from: b  reason: collision with root package name */
        public int f72477b;

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
                aVar.f72476a = b.f72478a;
                aVar.f72477b = b.f72479b;
                return aVar;
            }
            return (a) invokeV.objValue;
        }
    }

    /* loaded from: classes10.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static int f72478a;

        /* renamed from: b  reason: collision with root package name */
        public static int f72479b;
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
        this.f72472g = -1;
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
        this.as = -1;
        this.aD = new LiveLogInfo();
        this.aP = -1;
        this.aQ = -1;
        this.aR = 0L;
        this.aV = 0;
        this.aW = -1;
        this.aX = 0;
        this.f72474i = j2;
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
        this.f72472g = -1;
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
        this.as = -1;
        this.aD = new LiveLogInfo();
        this.aP = -1;
        this.aQ = -1;
        this.aR = 0L;
        this.aV = 0;
        this.aW = -1;
        this.aX = 0;
        this.f72474i = j2;
        this.f72468c = adTemplate;
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
        this.f72472g = -1;
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
        this.as = -1;
        this.aD = new LiveLogInfo();
        this.aP = -1;
        this.aQ = -1;
        this.aR = 0L;
        this.aV = 0;
        this.aW = -1;
        this.aX = 0;
        try {
            parseJson(new JSONObject(str));
        } catch (JSONException e2) {
            com.kwad.sdk.core.d.a.a(e2);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v69, resolved type: boolean */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x018c  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x019e  */
    /* JADX WARN: Removed duplicated region for block: B:73:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void a(@Nullable AdTemplate adTemplate) {
        SceneImpl sceneImpl;
        long b2;
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeL(65539, this, adTemplate) != null) {
            return;
        }
        this.ak = 3;
        com.kwad.sdk.plugin.b bVar = (com.kwad.sdk.plugin.b) com.kwad.sdk.plugin.f.a(com.kwad.sdk.plugin.b.class);
        if (bVar != null) {
            this.aV = bVar.e();
        }
        this.f72515a = UUID.randomUUID().toString();
        this.f72469d = System.currentTimeMillis();
        this.f72470e = l.b();
        try {
            this.f72471f = l.c();
        } catch (Exception e2) {
            com.kwad.sdk.core.d.a.b(e2);
        }
        this.f72473h = l.e();
        SceneImpl sceneImpl2 = this.f72467b;
        if (sceneImpl2 == null) {
            if (adTemplate != null && (sceneImpl2 = adTemplate.mAdScene) != null) {
                this.f72467b = sceneImpl2;
            }
            if (adTemplate != null) {
                this.q = adTemplate.getShowPosition() + 1;
                this.r = adTemplate.getServerPosition() + 1;
                this.f72475j = com.kwad.sdk.core.response.b.c.f(adTemplate);
                String g2 = com.kwad.sdk.core.response.b.c.g(adTemplate);
                if (!TextUtils.isEmpty(g2)) {
                    try {
                        this.k = new JSONObject(g2);
                    } catch (Exception e3) {
                        com.kwad.sdk.core.d.a.b(e3);
                    }
                }
                String h2 = com.kwad.sdk.core.response.b.c.h(adTemplate);
                if (!TextUtils.isEmpty(h2)) {
                    try {
                        this.l = new JSONObject(h2);
                    } catch (Exception e4) {
                        com.kwad.sdk.core.d.a.b(e4);
                    }
                }
                this.m = com.kwad.sdk.core.response.b.c.d(adTemplate);
                this.n = com.kwad.sdk.core.response.b.c.e(adTemplate);
                int i2 = adTemplate.realShowType;
                this.o = i2;
                if (i2 == 1) {
                    this.p = com.kwad.sdk.core.response.b.e.d(adTemplate.photoInfo);
                    this.s = com.kwad.sdk.core.response.b.e.c(adTemplate.photoInfo).longValue();
                    this.N = com.kwad.sdk.core.response.b.e.g(adTemplate.photoInfo);
                    this.ah = com.kwad.sdk.core.response.b.e.f(adTemplate.photoInfo);
                    this.al = com.kwad.sdk.core.response.b.e.j(adTemplate.photoInfo);
                    this.am = com.kwad.sdk.core.response.b.e.i(adTemplate.photoInfo);
                    this.an = com.kwad.sdk.core.response.b.e.k(adTemplate.photoInfo);
                    this.ap = com.kwad.sdk.core.response.b.e.l(adTemplate.photoInfo);
                    this.ao = com.kwad.sdk.core.response.b.e.m(adTemplate.photoInfo);
                    PreloadData preloadData = adTemplate.mPreloadData;
                    this.av = preloadData != null ? preloadData.isPreload : 0;
                } else {
                    if (i2 == 2) {
                        AdInfo i3 = com.kwad.sdk.core.response.b.c.i(adTemplate);
                        this.p = com.kwad.sdk.core.response.b.a.i(i3);
                        this.aC = i3.adBaseInfo.creativeId;
                        this.s = com.kwad.sdk.core.response.b.a.b(i3) * 1000;
                        b2 = i3.advertiserInfo.userId;
                    } else if (i2 == 4) {
                        LiveInfo q = com.kwad.sdk.core.response.b.c.q(adTemplate);
                        this.aD.liveStreamId = com.kwad.sdk.live.mode.a.a(q);
                        this.aD.expTag = com.kwad.sdk.live.mode.a.c(q);
                        b2 = com.kwad.sdk.live.mode.a.b(q);
                    } else if (i2 == 5) {
                        this.bz = com.kwad.sdk.core.response.b.d.c(com.kwad.sdk.core.response.b.c.k(this.f72468c));
                    }
                    this.N = b2;
                }
                this.aj = adTemplate.mMediaPlayerType;
                this.au = adTemplate.mIsLeftSlipStatus;
                this.ay = adTemplate.mPhotoResponseType;
                PageInfo pageInfo = adTemplate.mPageInfo;
                if (pageInfo != null) {
                    this.aM = pageInfo.pageType;
                }
                this.F = com.kwad.sdk.core.response.b.c.p(adTemplate);
            }
            this.ai = a.a();
            if (this.f72467b == null && adTemplate != null) {
                this.f72467b = adTemplate.mAdScene;
            }
            sceneImpl = this.f72467b;
            if (sceneImpl != null) {
                this.m = sceneImpl.getPosId();
                this.L = this.f72467b.getUrlPackage();
            }
            if (this.L == null) {
                EntryPackage b3 = com.kwad.sdk.core.scene.a.a().b(this.L.identity);
                this.K = b3.entryPageSource;
                this.ab = b3.entryId;
                this.M = com.kwad.sdk.core.scene.a.a().a(this.L.identity);
                return;
            }
            return;
        }
        this.m = sceneImpl2.getPosId();
        this.L = this.f72467b.getUrlPackage();
        this.f72472g = this.f72467b.getAdStyle();
        if (adTemplate != null) {
        }
        this.ai = a.a();
        if (this.f72467b == null) {
            this.f72467b = adTemplate.mAdScene;
        }
        sceneImpl = this.f72467b;
        if (sceneImpl != null) {
        }
        if (this.L == null) {
        }
    }

    @Override // com.kwad.sdk.core.report.c, com.kwad.sdk.core.response.a.a
    public void afterParseJson(@Nullable JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, jSONObject) == null) {
            super.afterParseJson(jSONObject);
            if (jSONObject == null) {
                return;
            }
            this.ak = 3;
            this.f72472g = jSONObject.optInt("adStyle", -1);
            this.V = jSONObject.optInt("reportType");
            this.I = jSONObject.optInt("playerControlledType", -1);
            this.aG = jSONObject.optInt("num");
            this.aF = jSONObject.optInt("state");
            this.aq = jSONObject.optLong("relatedFromPhotoId", -1L);
            this.ar = jSONObject.optLong("relatedContentSourceType", -1L);
            this.as = jSONObject.optInt("hotCompType", -1);
            this.aR = jSONObject.optLong("timeSpend");
            this.bn = jSONObject.optLong("loadingDuration");
            this.bo = jSONObject.optLong("loadingDurationLimt");
            this.aW = jSONObject.optInt("playerTypeInfo", -1);
            if (jSONObject.has("actionId")) {
                this.f72515a = jSONObject.optString("actionId");
            }
        }
    }

    @Override // com.kwad.sdk.core.report.c, com.kwad.sdk.core.response.a.a
    public void afterToJson(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONObject) == null) {
            super.afterToJson(jSONObject);
            q.a(jSONObject, "actionId", this.f72515a);
            int i2 = this.f72472g;
            if (i2 > 0) {
                q.a(jSONObject, "adStyle", i2);
            }
            int i3 = this.V;
            if (i3 != -1) {
                q.a(jSONObject, "reportType", i3);
            }
            int i4 = this.I;
            if (i4 != -1) {
                q.a(jSONObject, "playerControlledType", i4);
            }
            int i5 = this.aG;
            if (i5 > 0) {
                q.a(jSONObject, "num", i5);
            }
            int i6 = this.aF;
            if (i6 != 0) {
                q.a(jSONObject, "state", i6);
            }
            long j2 = this.aq;
            if (j2 != -1) {
                q.a(jSONObject, "relatedFromPhotoId", j2);
            }
            long j3 = this.ar;
            if (j3 != -1) {
                q.a(jSONObject, "relatedContentSourceType", j3);
            }
            int i7 = this.as;
            if (i7 != -1) {
                q.a(jSONObject, "hotCompType", i7);
            }
            long j4 = this.aR;
            if (j4 > 0) {
                q.a(jSONObject, "timeSpend", j4);
            }
            long j5 = this.bn;
            if (j5 > 0) {
                q.a(jSONObject, "loadingDuration", j5);
            }
            long j6 = this.bo;
            if (j6 > 0) {
                q.a(jSONObject, "loadingDurationLimt", j6);
            }
            q.a(jSONObject, "playerTypeInfo", this.aW);
        }
    }

    public ReportAction b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            a(this.f72468c);
            return this;
        }
        return (ReportAction) invokeV.objValue;
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            com.kwad.sdk.core.h.b a2 = com.kwad.sdk.core.h.b.a();
            this.aO = a2.b() ? 1 : 0;
            this.aP = a2.c();
            this.aQ = a2.d();
        }
    }
}
