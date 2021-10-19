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
    public int f72565b;

    /* renamed from: c  reason: collision with root package name */
    public AdTemplate f72566c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    public a f72567d;
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    public JSONObject f72568e;

    /* loaded from: classes10.dex */
    public static class a extends com.kwad.sdk.core.response.a.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public int f72569a;

        /* renamed from: b  reason: collision with root package name */
        public int f72570b;

        /* renamed from: c  reason: collision with root package name */
        public int f72571c;

        /* renamed from: d  reason: collision with root package name */
        public int f72572d;

        /* renamed from: e  reason: collision with root package name */
        public v.a f72573e;

        /* renamed from: f  reason: collision with root package name */
        public String f72574f;

        /* renamed from: g  reason: collision with root package name */
        public int f72575g;

        /* renamed from: h  reason: collision with root package name */
        public int f72576h;

        /* renamed from: i  reason: collision with root package name */
        public int f72577i;

        /* renamed from: j  reason: collision with root package name */
        public String f72578j;
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
            this.f72578j = "";
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
        this.f72566c = adTemplate;
        this.f72565b = i2;
        this.f72567d = aVar;
        this.f72568e = jSONObject;
    }

    private void a(String str, @Nullable a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65537, this, str, aVar) == null) || aVar == null || TextUtils.isEmpty(str)) {
            return;
        }
        int i2 = aVar.f72570b;
        if (i2 != 0) {
            a("itemClickType", i2);
        }
        if (!TextUtils.isEmpty(aVar.f72574f)) {
            b("payload", aVar.f72574f);
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
        if (TextUtils.isEmpty(aVar.f72574f)) {
            return;
        }
        b("payload", aVar.f72574f);
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
        int i2 = aVar.f72571c;
        if (i2 != 0) {
            a("itemCloseType", i2);
        }
        int i3 = aVar.f72569a;
        if (i3 > 0) {
            a("photoPlaySecond", i3);
        }
        int i4 = aVar.f72572d;
        if (i4 != 0) {
            a("elementType", i4);
        }
        if (!TextUtils.isEmpty(aVar.f72574f)) {
            b("payload", aVar.f72574f);
        }
        int i5 = aVar.f72575g;
        if (i5 > 0) {
            a("deeplinkType", i5);
        }
        int i6 = aVar.f72576h;
        if (i6 > 0) {
            a("downloadSource", i6);
        }
        int i7 = aVar.f72577i;
        if (i7 > 0) {
            a("isPackageChanged", i7);
        }
        b("installedFrom", aVar.f72578j);
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
            AdInfo i2 = com.kwad.sdk.core.response.b.c.i(this.f72566c);
            int i3 = this.f72565b;
            if (i3 == 1) {
                replaceFirst = i2.adBaseInfo.showUrl.replaceFirst("__PR__", String.valueOf(this.f72566c.mBidEcpm)).replaceFirst("__TYPE__", String.valueOf(this.f72566c.mVideoPlayerStatus.mVideoPlayerType)).replaceFirst("__BEHAVIOR__", String.valueOf(this.f72566c.mVideoPlayerStatus.mVideoPlayerBehavior));
            } else {
                AdInfo.AdBaseInfo adBaseInfo = i2.adBaseInfo;
                if (i3 != 2) {
                    replaceFirst = adBaseInfo.convUrl.replaceFirst("__ACTION__", String.valueOf(i3)).replaceFirst("__PR__", String.valueOf(this.f72566c.mBidEcpm)).replaceFirst("__TYPE__", String.valueOf(this.f72566c.mVideoPlayerStatus.mVideoPlayerType)).replaceFirst("__BEHAVIOR__", String.valueOf(this.f72566c.mVideoPlayerStatus.mVideoPlayerBehavior));
                    b(replaceFirst, this.f72567d);
                    a(this.f72568e);
                    return replaceFirst;
                }
                String str = adBaseInfo.clickUrl;
                a aVar = this.f72567d;
                if (aVar != null) {
                    str = v.b(str, aVar.f72573e);
                }
                replaceFirst = str.replaceFirst("__PR__", String.valueOf(this.f72566c.mBidEcpm)).replaceFirst("__TYPE__", String.valueOf(this.f72566c.mVideoPlayerStatus.mVideoPlayerType)).replaceFirst("__BEHAVIOR__", String.valueOf(this.f72566c.mVideoPlayerStatus.mVideoPlayerBehavior));
                a(replaceFirst, this.f72567d);
            }
            a(replaceFirst, this.f72566c, this.f72567d);
            a(this.f72568e);
            return replaceFirst;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.kwad.sdk.core.network.b, com.kwad.sdk.core.network.g
    public JSONObject e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f72320a : (JSONObject) invokeV.objValue;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f72566c : (AdTemplate) invokeV.objValue;
    }

    public List<String> i() {
        InterceptResult invokeV;
        v.a aVar;
        AdInfo.AdTrackInfo adTrackInfo;
        a aVar2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            ArrayList arrayList = new ArrayList();
            AdInfo i2 = com.kwad.sdk.core.response.b.c.i(this.f72566c);
            if (!i2.adTrackInfoList.isEmpty()) {
                Iterator<AdInfo.AdTrackInfo> it = i2.adTrackInfoList.iterator();
                while (true) {
                    aVar = null;
                    if (!it.hasNext()) {
                        adTrackInfo = null;
                        break;
                    }
                    adTrackInfo = it.next();
                    if (adTrackInfo.type == this.f72565b && adTrackInfo.urls != null) {
                        break;
                    }
                }
                if (adTrackInfo != null) {
                    if (adTrackInfo.type == 2 && (aVar2 = this.f72567d) != null) {
                        aVar = aVar2.f72573e;
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
