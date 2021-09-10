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
/* loaded from: classes10.dex */
public class n extends com.kwad.sdk.core.network.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public int f72211b;

    /* renamed from: c  reason: collision with root package name */
    public AdTemplate f72212c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    public a f72213d;
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    public JSONObject f72214e;

    /* loaded from: classes10.dex */
    public static class a extends com.kwad.sdk.core.response.a.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public int f72215a;

        /* renamed from: b  reason: collision with root package name */
        public int f72216b;

        /* renamed from: c  reason: collision with root package name */
        public int f72217c;

        /* renamed from: d  reason: collision with root package name */
        public int f72218d;

        /* renamed from: e  reason: collision with root package name */
        public v.a f72219e;

        /* renamed from: f  reason: collision with root package name */
        public String f72220f;

        /* renamed from: g  reason: collision with root package name */
        public int f72221g;

        /* renamed from: h  reason: collision with root package name */
        public int f72222h;

        /* renamed from: i  reason: collision with root package name */
        public int f72223i;

        /* renamed from: j  reason: collision with root package name */
        public String f72224j;
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
            this.f72224j = "";
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
        this.f72212c = adTemplate;
        this.f72211b = i2;
        this.f72213d = aVar;
        this.f72214e = jSONObject;
    }

    private void a(String str, @Nullable a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65537, this, str, aVar) == null) || aVar == null || TextUtils.isEmpty(str)) {
            return;
        }
        int i2 = aVar.f72216b;
        if (i2 != 0) {
            a("itemClickType", i2);
        }
        if (!TextUtils.isEmpty(aVar.f72220f)) {
            b("payload", aVar.f72220f);
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
        if (TextUtils.isEmpty(aVar.f72220f)) {
            return;
        }
        b("payload", aVar.f72220f);
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
        int i2 = aVar.f72217c;
        if (i2 != 0) {
            a("itemCloseType", i2);
        }
        int i3 = aVar.f72215a;
        if (i3 > 0) {
            a("photoPlaySecond", i3);
        }
        int i4 = aVar.f72218d;
        if (i4 != 0) {
            a("elementType", i4);
        }
        if (!TextUtils.isEmpty(aVar.f72220f)) {
            b("payload", aVar.f72220f);
        }
        int i5 = aVar.f72221g;
        if (i5 > 0) {
            a("deeplinkType", i5);
        }
        int i6 = aVar.f72222h;
        if (i6 > 0) {
            a("downloadSource", i6);
        }
        int i7 = aVar.f72223i;
        if (i7 > 0) {
            a("isPackageChanged", i7);
        }
        b("installedFrom", aVar.f72224j);
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
        long j2 = aVar.r;
        if (j2 > 0) {
            a("landingPageLoadedDuration", j2);
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
            AdInfo i2 = com.kwad.sdk.core.response.b.c.i(this.f72212c);
            int i3 = this.f72211b;
            if (i3 == 1) {
                replaceFirst = i2.adBaseInfo.showUrl.replaceFirst("__PR__", String.valueOf(this.f72212c.mBidEcpm)).replaceFirst("__TYPE__", String.valueOf(this.f72212c.mVideoPlayerStatus.mVideoPlayerType)).replaceFirst("__BEHAVIOR__", String.valueOf(this.f72212c.mVideoPlayerStatus.mVideoPlayerBehavior));
            } else {
                AdInfo.AdBaseInfo adBaseInfo = i2.adBaseInfo;
                if (i3 != 2) {
                    replaceFirst = adBaseInfo.convUrl.replaceFirst("__ACTION__", String.valueOf(i3)).replaceFirst("__PR__", String.valueOf(this.f72212c.mBidEcpm)).replaceFirst("__TYPE__", String.valueOf(this.f72212c.mVideoPlayerStatus.mVideoPlayerType)).replaceFirst("__BEHAVIOR__", String.valueOf(this.f72212c.mVideoPlayerStatus.mVideoPlayerBehavior));
                    b(replaceFirst, this.f72213d);
                    a(this.f72214e);
                    return replaceFirst;
                }
                String str = adBaseInfo.clickUrl;
                a aVar = this.f72213d;
                if (aVar != null) {
                    str = v.b(str, aVar.f72219e);
                }
                replaceFirst = str.replaceFirst("__PR__", String.valueOf(this.f72212c.mBidEcpm)).replaceFirst("__TYPE__", String.valueOf(this.f72212c.mVideoPlayerStatus.mVideoPlayerType)).replaceFirst("__BEHAVIOR__", String.valueOf(this.f72212c.mVideoPlayerStatus.mVideoPlayerBehavior));
                a(replaceFirst, this.f72213d);
            }
            a(replaceFirst, this.f72212c, this.f72213d);
            a(this.f72214e);
            return replaceFirst;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.kwad.sdk.core.network.b, com.kwad.sdk.core.network.g
    public JSONObject e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f71966a : (JSONObject) invokeV.objValue;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f72212c : (AdTemplate) invokeV.objValue;
    }

    public List<String> i() {
        InterceptResult invokeV;
        v.a aVar;
        AdInfo.AdTrackInfo adTrackInfo;
        a aVar2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            ArrayList arrayList = new ArrayList();
            AdInfo i2 = com.kwad.sdk.core.response.b.c.i(this.f72212c);
            if (!i2.adTrackInfoList.isEmpty()) {
                Iterator<AdInfo.AdTrackInfo> it = i2.adTrackInfoList.iterator();
                while (true) {
                    aVar = null;
                    if (!it.hasNext()) {
                        adTrackInfo = null;
                        break;
                    }
                    adTrackInfo = it.next();
                    if (adTrackInfo.type == this.f72211b && adTrackInfo.urls != null) {
                        break;
                    }
                }
                if (adTrackInfo != null) {
                    if (adTrackInfo.type == 2 && (aVar2 = this.f72213d) != null) {
                        aVar = aVar2.f72219e;
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
