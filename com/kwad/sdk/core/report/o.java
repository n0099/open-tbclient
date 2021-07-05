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
import com.kwad.sdk.utils.ag;
import com.kwad.sdk.utils.s;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class o extends com.kwad.sdk.core.network.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public int f36549b;

    /* renamed from: c  reason: collision with root package name */
    public AdTemplate f36550c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    public a f36551d;
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    public JSONObject f36552e;

    /* loaded from: classes7.dex */
    public static class a extends com.kwad.sdk.core.response.a.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public int f36553a;

        /* renamed from: b  reason: collision with root package name */
        public int f36554b;

        /* renamed from: c  reason: collision with root package name */
        public int f36555c;

        /* renamed from: d  reason: collision with root package name */
        public int f36556d;

        /* renamed from: e  reason: collision with root package name */
        public s.a f36557e;

        /* renamed from: f  reason: collision with root package name */
        public String f36558f;

        /* renamed from: g  reason: collision with root package name */
        public int f36559g;

        /* renamed from: h  reason: collision with root package name */
        public int f36560h;

        /* renamed from: i  reason: collision with root package name */
        public int f36561i;
        public String j;
        public String k;
        public int l;
        public String m;
        public String n;
        public int o;
        public int p;
        public int q;

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
            this.q = 0;
        }
    }

    public o(@NonNull AdTemplate adTemplate, int i2, @Nullable a aVar, @Nullable JSONObject jSONObject) {
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
        this.f36550c = adTemplate;
        this.f36549b = i2;
        this.f36551d = aVar;
        this.f36552e = jSONObject;
    }

    private void a(String str, @Nullable a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65537, this, str, aVar) == null) || aVar == null || TextUtils.isEmpty(str)) {
            return;
        }
        int i2 = aVar.f36554b;
        if (i2 != 0) {
            a("itemClickType", i2);
        }
        if (TextUtils.isEmpty(aVar.f36558f)) {
            return;
        }
        b("payload", aVar.f36558f);
    }

    private void a(String str, AdTemplate adTemplate) {
        int i2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65538, this, str, adTemplate) == null) || TextUtils.isEmpty(str) || adTemplate == null || (i2 = adTemplate.mInitVoiceStatus) == 0) {
            return;
        }
        a("initVoiceStatus", i2);
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
        if (!(interceptable == null || interceptable.invokeLL(65540, this, str, aVar) == null) || aVar == null || TextUtils.isEmpty(str)) {
            return;
        }
        int i2 = aVar.f36555c;
        if (i2 != 0) {
            a("itemCloseType", i2);
        }
        int i3 = aVar.f36553a;
        if (i3 > 0) {
            a("photoPlaySecond", i3);
        }
        int i4 = aVar.f36556d;
        if (i4 != 0) {
            a("elementType", i4);
        }
        if (!TextUtils.isEmpty(aVar.f36558f)) {
            b("payload", aVar.f36558f);
        }
        int i5 = aVar.f36559g;
        if (i5 > 0) {
            a("deeplinkType", i5);
        }
        int i6 = aVar.f36560h;
        if (i6 > 0) {
            a("download_source", i6);
        }
        a("is_package_changed", aVar.f36561i);
        b("installed_from", aVar.j);
        a("isChangedEndcard", aVar.l);
        String str2 = aVar.k;
        if (str2 != null) {
            b("downloadFailedReason", str2);
        }
        if (!ag.a(aVar.n)) {
            b("installedPackageName", aVar.n);
        }
        if (!ag.a(aVar.m)) {
            b("serverPackageName", aVar.m);
        }
        int i7 = aVar.p;
        if (i7 > 0) {
            a("closeButtonClickTime", i7);
        }
        int i8 = aVar.o;
        if (i8 > 0) {
            a("closeButtonImpressionTime", i8);
        }
        int i9 = aVar.q;
        if (i9 >= 0) {
            a("downloadStatus", i9);
        }
    }

    @Override // com.kwad.sdk.core.network.b, com.kwad.sdk.core.network.g
    public String a() {
        InterceptResult invokeV;
        String replaceFirst;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            AdInfo j = com.kwad.sdk.core.response.b.c.j(this.f36550c);
            int i2 = this.f36549b;
            if (i2 == 1) {
                replaceFirst = j.adBaseInfo.showUrl.replaceFirst("__PR__", String.valueOf(this.f36550c.mBidEcpm)).replaceFirst("__TYPE__", String.valueOf(this.f36550c.mVideoPlayerStatus.mVideoPlayerType)).replaceFirst("__BEHAVIOR__", String.valueOf(this.f36550c.mVideoPlayerStatus.mVideoPlayerBehavior));
            } else {
                AdInfo.AdBaseInfo adBaseInfo = j.adBaseInfo;
                if (i2 != 2) {
                    replaceFirst = adBaseInfo.convUrl.replaceFirst("__ACTION__", String.valueOf(i2)).replaceFirst("__PR__", String.valueOf(this.f36550c.mBidEcpm)).replaceFirst("__TYPE__", String.valueOf(this.f36550c.mVideoPlayerStatus.mVideoPlayerType)).replaceFirst("__BEHAVIOR__", String.valueOf(this.f36550c.mVideoPlayerStatus.mVideoPlayerBehavior));
                    b(replaceFirst, this.f36551d);
                    a(this.f36552e);
                    return replaceFirst;
                }
                String str = adBaseInfo.clickUrl;
                a aVar = this.f36551d;
                if (aVar != null) {
                    str = s.b(str, aVar.f36557e);
                }
                replaceFirst = str.replaceFirst("__PR__", String.valueOf(this.f36550c.mBidEcpm)).replaceFirst("__TYPE__", String.valueOf(this.f36550c.mVideoPlayerStatus.mVideoPlayerType)).replaceFirst("__BEHAVIOR__", String.valueOf(this.f36550c.mVideoPlayerStatus.mVideoPlayerBehavior));
                a(replaceFirst, this.f36551d);
            }
            a(replaceFirst, this.f36550c);
            a(this.f36552e);
            return replaceFirst;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.kwad.sdk.core.network.b, com.kwad.sdk.core.network.g
    public JSONObject d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f36353a : (JSONObject) invokeV.objValue;
    }

    @Override // com.kwad.sdk.core.network.b
    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
        }
    }

    @Override // com.kwad.sdk.core.network.b
    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
        }
    }

    public List<String> g() {
        InterceptResult invokeV;
        s.a aVar;
        AdInfo.AdTrackInfo adTrackInfo;
        a aVar2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            ArrayList arrayList = new ArrayList();
            AdInfo j = com.kwad.sdk.core.response.b.c.j(this.f36550c);
            if (!j.adTrackInfoList.isEmpty()) {
                Iterator<AdInfo.AdTrackInfo> it = j.adTrackInfoList.iterator();
                while (true) {
                    aVar = null;
                    if (!it.hasNext()) {
                        adTrackInfo = null;
                        break;
                    }
                    adTrackInfo = it.next();
                    if (adTrackInfo.type == this.f36549b && adTrackInfo.urls != null) {
                        break;
                    }
                }
                if (adTrackInfo != null) {
                    if (adTrackInfo.type == 2 && (aVar2 = this.f36551d) != null) {
                        aVar = aVar2.f36557e;
                    }
                    for (String str : adTrackInfo.urls) {
                        arrayList.add(s.a(str, aVar));
                    }
                }
            }
            return arrayList;
        }
        return (List) invokeV.objValue;
    }
}
