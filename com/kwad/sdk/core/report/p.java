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
import com.kwad.sdk.utils.at;
import com.kwad.sdk.utils.z;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class p extends com.kwad.sdk.core.network.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public int f57677b;

    /* renamed from: c  reason: collision with root package name */
    public AdTemplate f57678c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    public a f57679d;
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    public JSONObject f57680e;

    /* loaded from: classes2.dex */
    public static class a extends com.kwad.sdk.core.response.kwai.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int A;
        public double B;
        public int a;

        /* renamed from: b  reason: collision with root package name */
        public int f57681b;

        /* renamed from: c  reason: collision with root package name */
        public int f57682c;

        /* renamed from: d  reason: collision with root package name */
        public int f57683d;

        /* renamed from: e  reason: collision with root package name */
        public int f57684e;

        /* renamed from: f  reason: collision with root package name */
        public int f57685f;

        /* renamed from: g  reason: collision with root package name */
        public z.a f57686g;

        /* renamed from: h  reason: collision with root package name */
        public String f57687h;

        /* renamed from: i  reason: collision with root package name */
        public int f57688i;

        /* renamed from: j  reason: collision with root package name */
        public int f57689j;

        /* renamed from: k  reason: collision with root package name */
        public int f57690k;
        public String l;
        public String m;
        public int n;
        public int o;
        public String p;
        public String q;
        public int r;
        public int s;
        public long t;
        public int u;
        public int v;
        public int w;
        public long x;
        public int y;
        public int z;

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
                    return;
                }
            }
            this.f57684e = -1;
            this.l = "";
            this.u = 0;
            this.z = -1;
            this.A = -1;
        }
    }

    public p(@NonNull AdTemplate adTemplate, int i2, @Nullable a aVar, @Nullable JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {adTemplate, Integer.valueOf(i2), aVar, jSONObject};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f57678c = adTemplate;
        this.f57677b = i2;
        this.f57679d = aVar;
        this.f57680e = jSONObject;
    }

    private void a(String str, @Nullable a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65537, this, str, aVar) == null) || aVar == null || TextUtils.isEmpty(str)) {
            return;
        }
        int i2 = aVar.f57681b;
        if (i2 != 0) {
            a("itemClickType", i2);
        }
        if (!TextUtils.isEmpty(aVar.f57687h)) {
            b("payload", aVar.f57687h);
        }
        int i3 = aVar.o;
        if (i3 != 0) {
            a("adAggPageSource", i3);
        }
        int i4 = aVar.z;
        if (i4 >= 0) {
            a("adOrder", i4);
        }
        int i5 = aVar.A;
        if (i5 >= 0) {
            a("adInterstitialSource", i5);
        }
        double d2 = aVar.B;
        if (d2 > 0.0d) {
            a("splashShakeAcceleration", d2);
        }
    }

    private void a(String str, AdTemplate adTemplate, @Nullable a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65538, this, str, adTemplate, aVar) == null) || aVar == null || TextUtils.isEmpty(str)) {
            return;
        }
        int i2 = aVar.z;
        if (i2 >= 0) {
            a("adOrder", i2);
        }
        int i3 = aVar.A;
        if (i3 >= 0) {
            a("adInterstitialSource", i3);
        }
    }

    private void a(@Nullable JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, this, jSONObject) == null) {
            if (jSONObject == null) {
                jSONObject = new JSONObject();
            }
            try {
                jSONObject.put("clientTimestamp", System.currentTimeMillis());
            } catch (JSONException e2) {
                com.kwad.sdk.core.d.a.a(e2);
            }
            b("extData", jSONObject.toString());
        }
    }

    private void b(String str, @Nullable a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, this, str, aVar) == null) || aVar == null || TextUtils.isEmpty(str)) {
            return;
        }
        int i2 = aVar.f57682c;
        if (i2 != 0) {
            a("itemCloseType", i2);
        }
        int i3 = aVar.a;
        if (i3 > 0) {
            a("photoPlaySecond", i3);
        }
        int i4 = aVar.f57683d;
        if (i4 != 0) {
            a("elementType", i4);
        }
        if (!TextUtils.isEmpty(aVar.f57687h)) {
            b("payload", aVar.f57687h);
        }
        int i5 = aVar.f57688i;
        if (i5 > 0) {
            a("deeplinkType", i5);
        }
        int i6 = aVar.f57689j;
        if (i6 > 0) {
            a("downloadSource", i6);
        }
        int i7 = aVar.f57690k;
        if (i7 > 0) {
            a("isPackageChanged", i7);
        }
        b("installedFrom", aVar.l);
        a("isChangedEndcard", aVar.n);
        int i8 = aVar.o;
        if (i8 != 0) {
            a("adAggPageSource", i8);
        }
        String str2 = aVar.m;
        if (str2 != null) {
            b("downloadFailedReason", str2);
        }
        if (!at.a(aVar.q)) {
            b("installedPackageName", aVar.q);
        }
        if (!at.a(aVar.p)) {
            b("serverPackageName", aVar.p);
        }
        int i9 = aVar.s;
        if (i9 > 0) {
            a("closeButtonClickTime", i9);
        }
        int i10 = aVar.r;
        if (i10 > 0) {
            a("closeButtonImpressionTime", i10);
        }
        int i11 = aVar.u;
        if (i11 >= 0) {
            a("downloadStatus", i11);
        }
        long j2 = aVar.t;
        if (j2 > 0) {
            a("landingPageLoadedDuration", j2);
        }
        int i12 = aVar.f57684e;
        if (i12 > -1) {
            a("impFailReason", i12);
        }
        int i13 = aVar.f57685f;
        if (i13 > 0) {
            a("winEcpm", i13);
        }
        a("downloadCardType", aVar.v);
        a("landingPageType", aVar.w);
        int i14 = aVar.A;
        if (i14 >= 0) {
            a("adInterstitialSource", i14);
        }
    }

    private void b(String str, AdTemplate adTemplate, @Nullable a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65541, this, str, adTemplate, aVar) == null) || TextUtils.isEmpty(str) || adTemplate == null) {
            return;
        }
        int i2 = adTemplate.mInitVoiceStatus;
        if (i2 != 0) {
            a("initVoiceStatus", i2);
        }
        a("ecpmType", this.f57678c.mBidEcpm == 0 ? 2 : 1);
        if (aVar == null) {
            return;
        }
        int i3 = aVar.o;
        if (i3 != 0) {
            a("adAggPageSource", i3);
        }
        if (TextUtils.isEmpty(aVar.f57687h)) {
            return;
        }
        b("payload", aVar.f57687h);
    }

    @Override // com.kwad.sdk.core.network.b, com.kwad.sdk.core.network.g
    public String a() {
        InterceptResult invokeV;
        String replaceFirst;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            AdInfo j2 = com.kwad.sdk.core.response.a.d.j(this.f57678c);
            int i2 = this.f57677b;
            if (i2 == 1) {
                replaceFirst = j2.adBaseInfo.showUrl.replaceFirst("__PR__", String.valueOf((this.f57678c.mBidEcpm == 0 && com.kwad.sdk.core.config.b.ax()) ? com.kwad.sdk.core.response.a.a.F(com.kwad.sdk.core.response.a.d.j(this.f57678c)) : this.f57678c.mBidEcpm)).replaceFirst("__TYPE__", String.valueOf(this.f57678c.mVideoPlayerStatus.mVideoPlayerType)).replaceFirst("__BEHAVIOR__", String.valueOf(this.f57678c.mVideoPlayerStatus.mVideoPlayerBehavior));
                a(replaceFirst, this.f57678c, this.f57679d);
            } else {
                AdInfo.AdBaseInfo adBaseInfo = j2.adBaseInfo;
                if (i2 != 2) {
                    replaceFirst = adBaseInfo.convUrl.replaceFirst("__ACTION__", String.valueOf(i2)).replaceFirst("__PR__", String.valueOf(this.f57678c.mBidEcpm)).replaceFirst("__TYPE__", String.valueOf(this.f57678c.mVideoPlayerStatus.mVideoPlayerType)).replaceFirst("__BEHAVIOR__", String.valueOf(this.f57678c.mVideoPlayerStatus.mVideoPlayerBehavior));
                    b(replaceFirst, this.f57679d);
                    a(this.f57680e);
                    return replaceFirst;
                }
                String str = adBaseInfo.clickUrl;
                a aVar = this.f57679d;
                if (aVar != null) {
                    str = z.b(str, aVar.f57686g);
                }
                replaceFirst = z.b(str).replaceFirst("__PR__", String.valueOf(this.f57678c.mBidEcpm)).replaceFirst("__TYPE__", String.valueOf(this.f57678c.mVideoPlayerStatus.mVideoPlayerType)).replaceFirst("__BEHAVIOR__", String.valueOf(this.f57678c.mVideoPlayerStatus.mVideoPlayerBehavior));
                a(replaceFirst, this.f57679d);
            }
            b(replaceFirst, this.f57678c, this.f57679d);
            a(this.f57680e);
            return replaceFirst;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.kwad.sdk.core.network.b, com.kwad.sdk.core.network.g
    public JSONObject e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.a : (JSONObject) invokeV.objValue;
    }

    @Override // com.kwad.sdk.core.network.b
    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
        }
    }

    @Override // com.kwad.sdk.core.network.b
    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
        }
    }

    public AdTemplate i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f57678c : (AdTemplate) invokeV.objValue;
    }

    public List<String> j() {
        InterceptResult invokeV;
        z.a aVar;
        AdInfo.AdTrackInfo adTrackInfo;
        a aVar2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            ArrayList arrayList = new ArrayList();
            AdInfo j2 = com.kwad.sdk.core.response.a.d.j(this.f57678c);
            if (!j2.adTrackInfoList.isEmpty()) {
                Iterator<AdInfo.AdTrackInfo> it = j2.adTrackInfoList.iterator();
                while (true) {
                    aVar = null;
                    if (!it.hasNext()) {
                        adTrackInfo = null;
                        break;
                    }
                    adTrackInfo = it.next();
                    if (adTrackInfo.type == this.f57677b && adTrackInfo.urls != null) {
                        break;
                    }
                }
                if (adTrackInfo != null) {
                    if (adTrackInfo.type == 2 && (aVar2 = this.f57679d) != null) {
                        aVar = aVar2.f57686g;
                    }
                    for (String str : adTrackInfo.urls) {
                        arrayList.add(z.a(str, aVar));
                    }
                }
            }
            return arrayList;
        }
        return (List) invokeV.objValue;
    }
}
