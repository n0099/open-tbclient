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
import com.kwad.sdk.utils.an;
import com.kwad.sdk.utils.v;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class n extends com.kwad.sdk.core.network.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public int f65020b;

    /* renamed from: c  reason: collision with root package name */
    public AdTemplate f65021c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    public a f65022d;
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    public JSONObject f65023e;

    /* loaded from: classes2.dex */
    public static class a extends com.kwad.sdk.core.response.a.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public int f65024a;

        /* renamed from: b  reason: collision with root package name */
        public int f65025b;

        /* renamed from: c  reason: collision with root package name */
        public int f65026c;

        /* renamed from: d  reason: collision with root package name */
        public int f65027d;

        /* renamed from: e  reason: collision with root package name */
        public v.a f65028e;

        /* renamed from: f  reason: collision with root package name */
        public String f65029f;

        /* renamed from: g  reason: collision with root package name */
        public int f65030g;

        /* renamed from: h  reason: collision with root package name */
        public int f65031h;

        /* renamed from: i  reason: collision with root package name */
        public int f65032i;
        public String j;
        public String k;
        public int l;
        public int m;
        public String n;
        public String o;
        public int p;
        public int q;
        public long r;
        public int s;
        public int t;
        public int u;

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
            this.j = "";
            this.s = 0;
        }
    }

    public n(@NonNull AdTemplate adTemplate, int i2, @Nullable a aVar, @Nullable JSONObject jSONObject) {
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
        this.f65021c = adTemplate;
        this.f65020b = i2;
        this.f65022d = aVar;
        this.f65023e = jSONObject;
    }

    private void a(String str, @Nullable a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65537, this, str, aVar) == null) || aVar == null || TextUtils.isEmpty(str)) {
            return;
        }
        int i2 = aVar.f65025b;
        if (i2 != 0) {
            a("itemClickType", i2);
        }
        if (!TextUtils.isEmpty(aVar.f65029f)) {
            b("payload", aVar.f65029f);
        }
        int i3 = aVar.m;
        if (i3 != 0) {
            a("adAggPageSource", i3);
        }
    }

    private void a(String str, AdTemplate adTemplate, @Nullable a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65538, this, str, adTemplate, aVar) == null) || TextUtils.isEmpty(str) || adTemplate == null) {
            return;
        }
        int i2 = adTemplate.mInitVoiceStatus;
        if (i2 != 0) {
            a("initVoiceStatus", i2);
        }
        if (aVar == null) {
            return;
        }
        int i3 = aVar.m;
        if (i3 != 0) {
            a("adAggPageSource", i3);
        }
        if (TextUtils.isEmpty(aVar.f65029f)) {
            return;
        }
        b("payload", aVar.f65029f);
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
        int i2 = aVar.f65026c;
        if (i2 != 0) {
            a("itemCloseType", i2);
        }
        int i3 = aVar.f65024a;
        if (i3 > 0) {
            a("photoPlaySecond", i3);
        }
        int i4 = aVar.f65027d;
        if (i4 != 0) {
            a("elementType", i4);
        }
        if (!TextUtils.isEmpty(aVar.f65029f)) {
            b("payload", aVar.f65029f);
        }
        int i5 = aVar.f65030g;
        if (i5 > 0) {
            a("deeplinkType", i5);
        }
        int i6 = aVar.f65031h;
        if (i6 > 0) {
            a("downloadSource", i6);
        }
        int i7 = aVar.f65032i;
        if (i7 > 0) {
            a("isPackageChanged", i7);
        }
        b("installedFrom", aVar.j);
        a("isChangedEndcard", aVar.l);
        int i8 = aVar.m;
        if (i8 != 0) {
            a("adAggPageSource", i8);
        }
        String str2 = aVar.k;
        if (str2 != null) {
            b("downloadFailedReason", str2);
        }
        if (!an.a(aVar.o)) {
            b("installedPackageName", aVar.o);
        }
        if (!an.a(aVar.n)) {
            b("serverPackageName", aVar.n);
        }
        int i9 = aVar.q;
        if (i9 > 0) {
            a("closeButtonClickTime", i9);
        }
        int i10 = aVar.p;
        if (i10 > 0) {
            a("closeButtonImpressionTime", i10);
        }
        int i11 = aVar.s;
        if (i11 >= 0) {
            a("downloadStatus", i11);
        }
        long j = aVar.r;
        if (j > 0) {
            a("landingPageLoadedDuration", j);
        }
        a("downloadCardType", aVar.t);
        a("landingPageType", aVar.u);
    }

    @Override // com.kwad.sdk.core.network.b, com.kwad.sdk.core.network.g
    public String a() {
        InterceptResult invokeV;
        String replaceFirst;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            AdInfo i2 = com.kwad.sdk.core.response.b.c.i(this.f65021c);
            int i3 = this.f65020b;
            if (i3 == 1) {
                replaceFirst = i2.adBaseInfo.showUrl.replaceFirst("__PR__", String.valueOf(this.f65021c.mBidEcpm)).replaceFirst("__TYPE__", String.valueOf(this.f65021c.mVideoPlayerStatus.mVideoPlayerType)).replaceFirst("__BEHAVIOR__", String.valueOf(this.f65021c.mVideoPlayerStatus.mVideoPlayerBehavior));
            } else {
                AdInfo.AdBaseInfo adBaseInfo = i2.adBaseInfo;
                if (i3 != 2) {
                    replaceFirst = adBaseInfo.convUrl.replaceFirst("__ACTION__", String.valueOf(i3)).replaceFirst("__PR__", String.valueOf(this.f65021c.mBidEcpm)).replaceFirst("__TYPE__", String.valueOf(this.f65021c.mVideoPlayerStatus.mVideoPlayerType)).replaceFirst("__BEHAVIOR__", String.valueOf(this.f65021c.mVideoPlayerStatus.mVideoPlayerBehavior));
                    b(replaceFirst, this.f65022d);
                    a(this.f65023e);
                    return replaceFirst;
                }
                String str = adBaseInfo.clickUrl;
                a aVar = this.f65022d;
                if (aVar != null) {
                    str = v.b(str, aVar.f65028e);
                }
                replaceFirst = str.replaceFirst("__PR__", String.valueOf(this.f65021c.mBidEcpm)).replaceFirst("__TYPE__", String.valueOf(this.f65021c.mVideoPlayerStatus.mVideoPlayerType)).replaceFirst("__BEHAVIOR__", String.valueOf(this.f65021c.mVideoPlayerStatus.mVideoPlayerBehavior));
                a(replaceFirst, this.f65022d);
            }
            a(replaceFirst, this.f65021c, this.f65022d);
            a(this.f65023e);
            return replaceFirst;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.kwad.sdk.core.network.b, com.kwad.sdk.core.network.g
    public JSONObject e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f64781a : (JSONObject) invokeV.objValue;
    }

    @Override // com.kwad.sdk.core.network.b
    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
        }
    }

    @Override // com.kwad.sdk.core.network.b
    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
        }
    }

    public AdTemplate h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f65021c : (AdTemplate) invokeV.objValue;
    }

    public List<String> i() {
        InterceptResult invokeV;
        v.a aVar;
        AdInfo.AdTrackInfo adTrackInfo;
        a aVar2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            ArrayList arrayList = new ArrayList();
            AdInfo i2 = com.kwad.sdk.core.response.b.c.i(this.f65021c);
            if (!i2.adTrackInfoList.isEmpty()) {
                Iterator<AdInfo.AdTrackInfo> it = i2.adTrackInfoList.iterator();
                while (true) {
                    aVar = null;
                    if (!it.hasNext()) {
                        adTrackInfo = null;
                        break;
                    }
                    adTrackInfo = it.next();
                    if (adTrackInfo.type == this.f65020b && adTrackInfo.urls != null) {
                        break;
                    }
                }
                if (adTrackInfo != null) {
                    if (adTrackInfo.type == 2 && (aVar2 = this.f65022d) != null) {
                        aVar = aVar2.f65028e;
                    }
                    for (String str : adTrackInfo.urls) {
                        arrayList.add(v.a(str, aVar));
                    }
                }
            }
            return arrayList;
        }
        return (List) invokeV.objValue;
    }
}
