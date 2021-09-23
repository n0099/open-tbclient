package com.bytedance.sdk.openadsdk.e;

import android.app.Activity;
import android.content.Context;
import android.os.Looper;
import android.text.TextUtils;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.down.retry.HttpRetryStrategyDataParse;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.sapi2.SapiOptions;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.tbadk.browser.newshare.ThreadAchievementShareDialogView;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.JProtect;
import com.bytedance.sdk.openadsdk.FilterWord;
import com.bytedance.sdk.openadsdk.core.r;
import com.bytedance.sdk.openadsdk.q.s;
import com.coremedia.iso.boxes.FreeSpaceBox;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static long a(long j2, com.bytedance.sdk.openadsdk.core.e.m mVar, String str) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65536, null, new Object[]{Long.valueOf(j2), mVar, str})) == null) {
            if (j2 > 0) {
                a((System.currentTimeMillis() - j2) + "", mVar, str);
                return 0L;
            }
            return j2;
        }
        return invokeCommon.longValue;
    }

    public static long a(long j2, boolean z, com.bytedance.sdk.openadsdk.core.e.m mVar, String str) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{Long.valueOf(j2), Boolean.valueOf(z), mVar, str})) == null) {
            if (z) {
                return System.currentTimeMillis();
            }
            a((System.currentTimeMillis() - j2) + "", mVar, str);
            return 0L;
        }
        return invokeCommon.longValue;
    }

    public static void a(long j2, String str, String str2) {
        com.bytedance.sdk.openadsdk.core.e.m mVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65538, null, new Object[]{Long.valueOf(j2), str, str2}) == null) {
            try {
                mVar = com.bytedance.sdk.openadsdk.core.b.a(new JSONObject(str2));
            } catch (Throwable unused) {
                mVar = null;
            }
            if (mVar == null) {
                return;
            }
            a(com.bytedance.sdk.openadsdk.core.o.a(), mVar, str, "open_appback", Long.valueOf(j2));
            com.bytedance.sdk.openadsdk.q.e.a(0L);
            com.bytedance.sdk.openadsdk.q.e.c("");
        }
    }

    public static void a(Context context, long j2, com.bytedance.sdk.openadsdk.core.e.m mVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65539, null, new Object[]{context, Long.valueOf(j2), mVar}) == null) || context == null || mVar == null) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("skip_duration", j2);
            jSONObject.put("ad_extra_data", jSONObject2.toString());
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        c(context, mVar, "splash_ad", FreeSpaceBox.TYPE, jSONObject);
    }

    public static void a(Context context, com.bytedance.sdk.openadsdk.core.e.m mVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, context, mVar) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.putOpt("render_type", "h5");
                jSONObject2.putOpt("render_type_2", 0);
                jSONObject.putOpt("ad_extra_data", jSONObject2);
            } catch (Exception unused) {
            }
            d(context, mVar, "landingpage", "open_url_h5", jSONObject);
        }
    }

    public static void a(Context context, com.bytedance.sdk.openadsdk.core.e.m mVar, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(AdIconUtil.AD_TEXT_ID, null, context, mVar, str) == null) {
            c(context, mVar, str, "click_close");
        }
    }

    public static void a(Context context, com.bytedance.sdk.openadsdk.core.e.m mVar, String str, long j2) {
        String str2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(AdIconUtil.BAIDU_LOGO_ID, null, new Object[]{context, mVar, str, Long.valueOf(j2)}) == null) && context != null && com.bytedance.sdk.openadsdk.core.o.h().v()) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("duration", System.currentTimeMillis() - j2);
            } catch (Throwable th) {
                th.printStackTrace();
            }
            char c2 = 65535;
            switch (str.hashCode()) {
                case -1695837674:
                    if (str.equals("banner_ad")) {
                        c2 = 0;
                        break;
                    }
                    break;
                case -1364000502:
                    if (str.equals("rewarded_video")) {
                        c2 = 4;
                        break;
                    }
                    break;
                case -891990144:
                    if (str.equals("stream")) {
                        c2 = 3;
                        break;
                    }
                    break;
                case -764631662:
                    if (str.equals("fullscreen_interstitial_ad")) {
                        c2 = 5;
                        break;
                    }
                    break;
                case -712491894:
                    if (str.equals("embeded_ad")) {
                        c2 = 2;
                        break;
                    }
                    break;
                case 1844104722:
                    if (str.equals(ThreadAchievementShareDialogView.THREAD_INTERACTION_VIEW_TYPE)) {
                        c2 = 1;
                        break;
                    }
                    break;
                case 1912999166:
                    if (str.equals("draw_ad")) {
                        c2 = 6;
                        break;
                    }
                    break;
            }
            switch (c2) {
                case 0:
                    str2 = "banner_ad_loadtime";
                    break;
                case 1:
                    str2 = "interaction_loadtime";
                    break;
                case 2:
                    str2 = "embeded_ad_loadtime";
                    break;
                case 3:
                    str2 = "stream_loadtime";
                    break;
                case 4:
                    str2 = "rewarded_video_loadtime";
                    break;
                case 5:
                    str2 = "fullscreen_interstitial_ad_loadtime";
                    break;
                case 6:
                    str2 = "draw_ad_loadtime";
                    break;
                default:
                    str2 = "";
                    break;
            }
            c(context, mVar, str, str2, jSONObject);
        }
    }

    public static void a(Context context, com.bytedance.sdk.openadsdk.core.e.m mVar, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65543, null, context, mVar, str, str2) == null) {
            c(context, mVar, str, str2);
        }
    }

    public static void a(Context context, com.bytedance.sdk.openadsdk.core.e.m mVar, String str, String str2, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65544, null, new Object[]{context, mVar, str, str2, Integer.valueOf(i2), Integer.valueOf(i3)}) == null) || mVar == null || context == null) {
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("color_percent", Integer.valueOf(i2));
        String j2 = mVar.V() != null ? mVar.V().j() : null;
        if (TextUtils.isEmpty(j2)) {
            j2 = com.bytedance.sdk.openadsdk.core.e.o.e(mVar);
        }
        hashMap.put("playable_url", j2);
        hashMap.put("memory_total", Integer.valueOf(com.bytedance.sdk.openadsdk.q.q.m()));
        hashMap.put("memory_use", Integer.valueOf(com.bytedance.sdk.openadsdk.q.q.o() - com.bytedance.sdk.openadsdk.q.q.n()));
        hashMap.put(HttpRetryStrategyDataParse.DOWNFLOW_TETRY_REQUEST_ID, com.bytedance.sdk.openadsdk.q.q.h(mVar.ao()));
        hashMap.put("timestamp", Long.valueOf(System.currentTimeMillis()));
        hashMap.put("color_percent_type", Integer.valueOf(i3));
        j(context, mVar, str, str2, hashMap);
    }

    public static void a(Context context, com.bytedance.sdk.openadsdk.core.e.m mVar, String str, String str2, long j2, int i2, Map<String, Object> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65545, null, new Object[]{context, mVar, str, str2, Long.valueOf(j2), Integer.valueOf(i2), map}) == null) {
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject.put("duration", j2);
                jSONObject.put(SapiOptions.KEY_CACHE_PERCENT, i2);
                if (map != null) {
                    for (Map.Entry<String, Object> entry : map.entrySet()) {
                        jSONObject2.put(entry.getKey(), entry.getValue());
                    }
                }
                jSONObject.put("ad_extra_data", jSONObject2.toString());
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            c(context, mVar, str, str2, jSONObject);
        }
    }

    public static void a(Context context, com.bytedance.sdk.openadsdk.core.e.m mVar, String str, String str2, long j2, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65546, null, new Object[]{context, mVar, str, str2, Long.valueOf(j2), jSONObject}) == null) || context == null || mVar == null || jSONObject == null) {
            return;
        }
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("duration", j2);
            jSONObject2.put("ad_extra_data", jSONObject.toString());
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        c(context, mVar, str, str2, jSONObject2);
    }

    public static void a(Context context, com.bytedance.sdk.openadsdk.core.e.m mVar, String str, String str2, Long l) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(65547, null, context, mVar, str, str2, l) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("duration", l);
            } catch (Exception unused) {
            }
            c(context, mVar, str, str2, jSONObject);
        }
    }

    public static void a(Context context, com.bytedance.sdk.openadsdk.core.e.m mVar, String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLLL(65548, null, context, mVar, str, str2, str3) == null) || context == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3) || mVar == null) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("scheme", str3);
            jSONObject.put("ad_extra_data", jSONObject2.toString());
        } catch (Exception unused) {
        }
        c(context, mVar, str, str2, jSONObject);
    }

    public static void a(Context context, com.bytedance.sdk.openadsdk.core.e.m mVar, String str, String str2, Map<String, Object> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(65549, null, context, mVar, str, str2, map) == null) {
            JSONObject jSONObject = new JSONObject();
            if (map == null || map.size() <= 0) {
                c(context, mVar, str, str2);
                return;
            }
            try {
                JSONObject jSONObject2 = new JSONObject();
                for (Map.Entry<String, Object> entry : map.entrySet()) {
                    jSONObject2.put(entry.getKey(), entry.getValue());
                }
                jSONObject.put("ad_extra_data", jSONObject2.toString());
            } catch (Exception unused) {
            }
            c(context, mVar, str, str2, jSONObject);
        }
    }

    public static void a(Context context, com.bytedance.sdk.openadsdk.core.e.m mVar, String str, String str2, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(65550, null, context, mVar, str, str2, jSONObject) == null) {
            if (jSONObject == null) {
                c(context, mVar, str, str2);
                return;
            }
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("ad_extra_data", jSONObject.toString());
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            c(context, mVar, str, str2, jSONObject2);
        }
    }

    @Keep
    @JProtect
    public static void a(Context context, com.bytedance.sdk.openadsdk.core.e.m mVar, String str, Map<String, Object> map) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLL(65551, null, context, mVar, str, map) == null) || a(str, mVar)) {
            return;
        }
        r.b();
        float floatValue = Double.valueOf((System.currentTimeMillis() / 1000) - com.bytedance.sdk.openadsdk.q.q.g(mVar.ao())).floatValue();
        if (Looper.getMainLooper() == Looper.myLooper()) {
            com.bytedance.sdk.component.d.e.b(new com.bytedance.sdk.component.d.g("onShow", context, mVar, str, map, floatValue) { // from class: com.bytedance.sdk.openadsdk.e.d.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ Context f68064a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ com.bytedance.sdk.openadsdk.core.e.m f68065b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ String f68066c;

                /* renamed from: d  reason: collision with root package name */
                public final /* synthetic */ Map f68067d;

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ float f68068e;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(r7);
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {r7, context, mVar, str, map, Float.valueOf(floatValue)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            super((String) newInitContext.callArgs[0]);
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f68064a = context;
                    this.f68065b = mVar;
                    this.f68066c = str;
                    this.f68067d = map;
                    this.f68068e = floatValue;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        d.b(this.f68064a, this.f68065b, this.f68066c, this.f68067d, this.f68068e);
                    }
                }
            });
        } else {
            b(context, mVar, str, map, floatValue);
        }
    }

    public static void a(Context context, String str, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65553, null, new Object[]{context, str, Long.valueOf(j2)}) == null) {
            com.bytedance.sdk.openadsdk.core.c.c.a(context, str, j2);
        }
    }

    @Keep
    @JProtect
    public static void a(Context context, String str, com.bytedance.sdk.openadsdk.core.e.m mVar, com.bytedance.sdk.openadsdk.core.e.f fVar, String str2, boolean z, Map<String, Object> map) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65554, null, new Object[]{context, str, mVar, fVar, str2, Boolean.valueOf(z), map}) == null) || a(str2, mVar)) {
            return;
        }
        float floatValue = Double.valueOf((System.currentTimeMillis() / 1000) - com.bytedance.sdk.openadsdk.q.q.g(mVar.ao())).floatValue();
        if (Looper.getMainLooper() == Looper.myLooper()) {
            com.bytedance.sdk.component.d.e.b(new com.bytedance.sdk.component.d.g("onClick", context, str, mVar, fVar, str2, z, map, floatValue) { // from class: com.bytedance.sdk.openadsdk.e.d.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ Context f68072a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ String f68073b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ com.bytedance.sdk.openadsdk.core.e.m f68074c;

                /* renamed from: d  reason: collision with root package name */
                public final /* synthetic */ com.bytedance.sdk.openadsdk.core.e.f f68075d;

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ String f68076e;

                /* renamed from: f  reason: collision with root package name */
                public final /* synthetic */ boolean f68077f;

                /* renamed from: g  reason: collision with root package name */
                public final /* synthetic */ Map f68078g;

                /* renamed from: h  reason: collision with root package name */
                public final /* synthetic */ float f68079h;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(r7);
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {r7, context, str, mVar, fVar, str2, Boolean.valueOf(z), map, Float.valueOf(floatValue)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            super((String) newInitContext.callArgs[0]);
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f68072a = context;
                    this.f68073b = str;
                    this.f68074c = mVar;
                    this.f68075d = fVar;
                    this.f68076e = str2;
                    this.f68077f = z;
                    this.f68078g = map;
                    this.f68079h = floatValue;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        d.b(this.f68072a, this.f68073b, this.f68074c, this.f68075d, this.f68076e, this.f68077f, this.f68078g, this.f68079h);
                    }
                }
            });
        } else {
            b(context, str, mVar, fVar, str2, z, map, floatValue);
        }
    }

    public static void a(Context context, String str, String str2, String str3, String str4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(65556, null, context, str, str2, str3, str4) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt("log_extra", str2);
            } catch (JSONException unused) {
            }
            com.bytedance.sdk.openadsdk.core.o.c().a(com.bytedance.sdk.openadsdk.e.a.a(context, str3, str4, str, jSONObject));
            if (com.bytedance.sdk.component.utils.k.c()) {
                com.bytedance.sdk.component.utils.k.c("AdEvent", "tag: " + str3 + "label: " + str4 + " " + str);
            }
        }
    }

    public static void a(com.bytedance.sdk.openadsdk.core.e.m mVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65557, null, mVar) == null) {
        }
    }

    public static void a(com.bytedance.sdk.openadsdk.core.e.m mVar, Activity activity) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65558, null, mVar, activity) == null) && mVar != null && activity != null) {
            try {
                String a2 = com.bytedance.sdk.openadsdk.q.q.a(mVar);
                if (a2 == null) {
                    return;
                }
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("page_name", activity.getClass().getName());
                s.a(jSONObject);
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("ad_extra_data", jSONObject);
                c(com.bytedance.sdk.openadsdk.core.o.a(), mVar, a2, "page_on_create", jSONObject2);
            } catch (Throwable unused) {
            }
        }
    }

    public static void a(com.bytedance.sdk.openadsdk.core.e.m mVar, String str, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65559, null, new Object[]{mVar, str, Long.valueOf(j2)}) == null) {
            if (Looper.getMainLooper() == Looper.myLooper()) {
                com.bytedance.sdk.component.d.e.b(new com.bytedance.sdk.component.d.g("onDownloadCreativeDuration", mVar, str, j2) { // from class: com.bytedance.sdk.openadsdk.e.d.2
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ com.bytedance.sdk.openadsdk.core.e.m f68069a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ String f68070b;

                    /* renamed from: c  reason: collision with root package name */
                    public final /* synthetic */ long f68071c;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(r7);
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {r7, mVar, str, Long.valueOf(j2)};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                super((String) newInitContext.callArgs[0]);
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f68069a = mVar;
                        this.f68070b = str;
                        this.f68071c = j2;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            d.c(this.f68069a, this.f68070b, this.f68071c);
                        }
                    }
                });
            } else {
                c(mVar, str, j2);
            }
        }
    }

    public static void a(com.bytedance.sdk.openadsdk.core.e.m mVar, JSONObject jSONObject, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65560, null, mVar, jSONObject, str) == null) || mVar == null || jSONObject == null || TextUtils.isEmpty(str) || !str.equals("embeded_ad")) {
            return;
        }
        int i2 = 1;
        try {
            jSONObject.put("video_middle_page", (mVar.aD() != 1 || mVar.Q() == null) ? 0 : 0);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static void a(@NonNull com.bytedance.sdk.openadsdk.dislike.c.b bVar, FilterWord filterWord) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65561, null, bVar, filterWord) == null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(filterWord);
            com.bytedance.sdk.openadsdk.core.o.f().a(bVar, arrayList);
            if (com.bytedance.sdk.component.utils.k.c()) {
                com.bytedance.sdk.component.utils.k.c("AdEvent", "tt_dislike_icon " + bVar.d());
            }
        }
    }

    public static void a(String str, com.bytedance.sdk.openadsdk.core.e.m mVar, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65562, null, str, mVar, str2) == null) || mVar == null) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("duration", str);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        c(com.bytedance.sdk.openadsdk.core.o.a(), mVar, str2, "ad_show_time", jSONObject);
    }

    public static void a(String str, String str2, String str3, long j2, long j3, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65563, null, new Object[]{str, str2, str3, Long.valueOf(j2), Long.valueOf(j3), jSONObject}) == null) {
            float floatValue = Double.valueOf((System.currentTimeMillis() / 1000) - com.bytedance.sdk.openadsdk.q.q.g(jSONObject.optString("log_extra"))).floatValue();
            if (Looper.getMainLooper() == Looper.myLooper()) {
                com.bytedance.sdk.component.d.e.b(new com.bytedance.sdk.component.d.g("sendJsAdEvent", str, str2, str3, j2, j3, jSONObject, floatValue) { // from class: com.bytedance.sdk.openadsdk.e.d.4
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ String f68080a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ String f68081b;

                    /* renamed from: c  reason: collision with root package name */
                    public final /* synthetic */ String f68082c;

                    /* renamed from: d  reason: collision with root package name */
                    public final /* synthetic */ long f68083d;

                    /* renamed from: e  reason: collision with root package name */
                    public final /* synthetic */ long f68084e;

                    /* renamed from: f  reason: collision with root package name */
                    public final /* synthetic */ JSONObject f68085f;

                    /* renamed from: g  reason: collision with root package name */
                    public final /* synthetic */ float f68086g;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(r8);
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r3;
                            Object[] objArr = {r8, str, str2, str3, Long.valueOf(j2), Long.valueOf(j3), jSONObject, Float.valueOf(floatValue)};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                super((String) newInitContext.callArgs[0]);
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f68080a = str;
                        this.f68081b = str2;
                        this.f68082c = str3;
                        this.f68083d = j2;
                        this.f68084e = j3;
                        this.f68085f = jSONObject;
                        this.f68086g = floatValue;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            d.b(this.f68080a, this.f68081b, this.f68082c, this.f68083d, this.f68084e, this.f68085f, this.f68086g);
                        }
                    }
                });
            } else {
                b(str, str2, str3, j2, j3, jSONObject, floatValue);
            }
        }
    }

    public static boolean a(String str, com.bytedance.sdk.openadsdk.core.e.m mVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65565, null, str, mVar)) == null) ? !TextUtils.isEmpty(str) && mVar != null && str.equals("feed_video_middle_page") && mVar.aD() == 1 : invokeLL.booleanValue;
    }

    public static void b(Context context, com.bytedance.sdk.openadsdk.core.e.m mVar, String str, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65566, null, new Object[]{context, mVar, str, Long.valueOf(j2)}) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.putOpt("render_type", "h5");
                jSONObject2.putOpt("render_type_2", 0);
                jSONObject.putOpt("ad_extra_data", jSONObject2);
                jSONObject.put("duration", Math.min(j2, 600000L));
            } catch (Exception unused) {
            }
            d(context, mVar, str, "load", jSONObject);
        }
    }

    public static void b(Context context, com.bytedance.sdk.openadsdk.core.e.m mVar, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65567, null, context, mVar, str, str2) == null) {
            c(context, mVar, str, str2);
        }
    }

    public static void b(Context context, com.bytedance.sdk.openadsdk.core.e.m mVar, String str, String str2, Map<String, Object> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(65568, null, context, mVar, str, str2, map) == null) {
            if (map == null || map.size() <= 0) {
                c(context, mVar, str, str2);
                return;
            }
            JSONObject jSONObject = new JSONObject();
            try {
                JSONObject jSONObject2 = new JSONObject();
                for (Map.Entry<String, Object> entry : map.entrySet()) {
                    jSONObject2.put(entry.getKey(), entry.getValue());
                }
                jSONObject.put("ad_extra_data", jSONObject2.toString());
            } catch (Exception unused) {
            }
            c(context, mVar, str, str2, jSONObject);
        }
    }

    public static void b(Context context, com.bytedance.sdk.openadsdk.core.e.m mVar, String str, String str2, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(65569, null, context, mVar, str, str2, jSONObject) == null) {
            JSONObject jSONObject2 = new JSONObject();
            if (jSONObject != null) {
                try {
                    jSONObject2.put("ad_extra_data", jSONObject.toString());
                } catch (Exception unused) {
                }
            }
            c(context, mVar, str, str2, jSONObject2);
        }
    }

    public static void b(Context context, com.bytedance.sdk.openadsdk.core.e.m mVar, String str, Map<String, Object> map, float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65570, null, new Object[]{context, mVar, str, map, Float.valueOf(f2)}) == null) {
            Context a2 = context == null ? com.bytedance.sdk.openadsdk.core.o.a() : context;
            JSONObject jSONObject = new JSONObject();
            try {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("device", com.bytedance.sdk.openadsdk.core.k.c.e(a2).toString());
                jSONObject2.put("is_cache", mVar.at() ? 1 : 0);
                if (map != null) {
                    for (Map.Entry<String, Object> entry : map.entrySet()) {
                        jSONObject2.put(entry.getKey(), entry.getValue());
                    }
                }
                s.a(jSONObject2);
                jSONObject.put("ad_extra_data", jSONObject2.toString());
                jSONObject.putOpt("log_extra", mVar.ao());
                if (f2 <= 0.0f) {
                    f2 = 0.0f;
                }
                jSONObject.putOpt("show_time", Float.valueOf(f2));
            } catch (JSONException unused) {
            }
            com.bytedance.sdk.openadsdk.core.o.c().a(com.bytedance.sdk.openadsdk.e.a.a(a2, str, "show", mVar.ak(), jSONObject));
            String a3 = com.bytedance.sdk.openadsdk.core.j.a(com.bytedance.sdk.openadsdk.core.o.a());
            if (!TextUtils.isEmpty(a3)) {
                com.bytedance.sdk.openadsdk.core.o.g().a(a3, mVar.af(), true);
            }
            com.bytedance.sdk.openadsdk.m.a.b(context);
        }
    }

    public static void b(Context context, String str, com.bytedance.sdk.openadsdk.core.e.m mVar, com.bytedance.sdk.openadsdk.core.e.f fVar, String str2, boolean z, Map<String, Object> map, float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65571, null, new Object[]{context, str, mVar, fVar, str2, Boolean.valueOf(z), map, Float.valueOf(f2)}) == null) {
            if (context == null) {
                context = com.bytedance.sdk.openadsdk.core.o.a();
            }
            JSONObject jSONObject = new JSONObject();
            if (fVar != null) {
                try {
                    JSONObject a2 = fVar.a();
                    a2.put("device", com.bytedance.sdk.openadsdk.core.k.c.e(context).toString());
                    a2.put("is_valid", z);
                    s.a(a2);
                    if (map != null) {
                        for (Map.Entry<String, Object> entry : map.entrySet()) {
                            a2.put(entry.getKey(), entry.getValue());
                        }
                    }
                    a(mVar, a2, str2);
                    jSONObject.put("ad_extra_data", a2.toString());
                } catch (JSONException unused) {
                }
            }
            jSONObject.putOpt("log_extra", mVar.ao());
            if (f2 <= 0.0f) {
                f2 = 0.0f;
            }
            jSONObject.putOpt("show_time", Float.valueOf(f2));
            com.bytedance.sdk.openadsdk.core.o.c().a(com.bytedance.sdk.openadsdk.e.a.a(context, str2, str, mVar.ak(), jSONObject));
            String a3 = com.bytedance.sdk.openadsdk.core.j.a(com.bytedance.sdk.openadsdk.core.o.a());
            if (!TextUtils.isEmpty(a3) && PrefetchEvent.STATE_CLICK.equals(str)) {
                com.bytedance.sdk.openadsdk.core.o.g().a(a3, mVar.ag(), true);
            }
            if (com.bytedance.sdk.component.utils.k.c()) {
                com.bytedance.sdk.component.utils.k.c("AdEvent", str + " " + mVar.ak());
            }
        }
    }

    public static void b(String str, String str2, String str3, long j2, long j3, JSONObject jSONObject, float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65573, null, new Object[]{str, str2, str3, Long.valueOf(j2), Long.valueOf(j3), jSONObject, Float.valueOf(f2)}) == null) {
            if (jSONObject != null) {
                JSONObject jSONObject2 = new JSONObject();
                try {
                    String optString = jSONObject.optString("ad_extra_data", null);
                    if (optString != null) {
                        jSONObject2 = new JSONObject(optString);
                    }
                    jSONObject2.put("device", com.bytedance.sdk.openadsdk.core.k.c.e(com.bytedance.sdk.openadsdk.core.o.a()).toString());
                    jSONObject.put("ad_extra_data", jSONObject2.toString());
                    jSONObject.put("tag", str2);
                    if (PrefetchEvent.STATE_CLICK.equals(str3)) {
                        if (f2 <= 0.0f) {
                            f2 = 0.0f;
                        }
                        jSONObject.putOpt("show_time", Float.valueOf(f2));
                    }
                } catch (JSONException unused) {
                }
            }
            com.bytedance.sdk.openadsdk.core.o.c().a(com.bytedance.sdk.openadsdk.e.a.a(str, str2, str3, j2, j3, jSONObject));
            if (com.bytedance.sdk.component.utils.k.c()) {
                com.bytedance.sdk.component.utils.k.c("AdEvent", "sendJsAdEvent");
            }
        }
    }

    public static void c(Context context, com.bytedance.sdk.openadsdk.core.e.m mVar, String str, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLL(65574, null, context, mVar, str, str2) == null) || mVar == null) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("log_extra", mVar.ao());
        } catch (JSONException unused) {
        }
        com.bytedance.sdk.openadsdk.core.o.c().a(com.bytedance.sdk.openadsdk.e.a.a(context, str, str2, mVar.ak(), jSONObject));
        if (com.bytedance.sdk.component.utils.k.c()) {
            com.bytedance.sdk.component.utils.k.c("AdEvent", "tag: " + str + "label: " + str2 + " " + mVar.ak());
        }
    }

    public static void c(Context context, com.bytedance.sdk.openadsdk.core.e.m mVar, String str, String str2, Map<String, Object> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(65575, null, context, mVar, str, str2, map) == null) {
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            if (map != null) {
                try {
                    for (Map.Entry<String, Object> entry : map.entrySet()) {
                        jSONObject.put(entry.getKey(), entry.getValue());
                    }
                } catch (Throwable th) {
                    com.bytedance.sdk.component.utils.k.c(th.toString());
                }
            }
            jSONObject2.put("ad_extra_data", jSONObject.toString());
            c(context, mVar, str, str2, jSONObject2);
        }
    }

    public static void c(Context context, com.bytedance.sdk.openadsdk.core.e.m mVar, String str, String str2, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLLL(65576, null, context, mVar, str, str2, jSONObject) == null) || mVar == null) {
            return;
        }
        if (jSONObject != null) {
            try {
                jSONObject.putOpt("log_extra", mVar.ao());
            } catch (JSONException unused) {
            }
        }
        com.bytedance.sdk.openadsdk.core.o.c().a(com.bytedance.sdk.openadsdk.e.a.a(context, str, str2, mVar.ak(), jSONObject));
        if (com.bytedance.sdk.component.utils.k.c()) {
            com.bytedance.sdk.component.utils.k.c("AdEvent", "tag: " + str + "label: " + str2 + " " + mVar.ak());
        }
    }

    public static void c(com.bytedance.sdk.openadsdk.core.e.m mVar, String str, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65577, null, new Object[]{mVar, str, Long.valueOf(j2)}) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("device", com.bytedance.sdk.openadsdk.core.k.c.e(com.bytedance.sdk.openadsdk.core.o.a()).toString());
                jSONObject2.put("download_creative_duration", j2);
                jSONObject.put("ad_extra_data", jSONObject2.toString());
                jSONObject.putOpt("log_extra", mVar.ao());
            } catch (JSONException unused) {
            }
            com.bytedance.sdk.openadsdk.core.o.c().a(com.bytedance.sdk.openadsdk.e.a.a(com.bytedance.sdk.openadsdk.core.o.a(), str, "download_creative_duration", mVar.ak(), jSONObject));
        }
    }

    public static void d(Context context, com.bytedance.sdk.openadsdk.core.e.m mVar, String str, String str2, Map<String, Object> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(65578, null, context, mVar, str, str2, map) == null) {
            e(context, mVar, str, str2, map);
        }
    }

    public static void d(Context context, com.bytedance.sdk.openadsdk.core.e.m mVar, String str, String str2, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(65579, null, context, mVar, str, str2, jSONObject) == null) {
            if (jSONObject == null) {
                jSONObject = new JSONObject();
            }
            c(context, mVar, str, str2, jSONObject);
        }
    }

    public static void e(Context context, com.bytedance.sdk.openadsdk.core.e.m mVar, String str, String str2, Map<String, Object> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(65580, null, context, mVar, str, str2, map) == null) {
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            if (map != null) {
                try {
                    for (Map.Entry<String, Object> entry : map.entrySet()) {
                        jSONObject.put(entry.getKey(), entry.getValue());
                    }
                } catch (Throwable th) {
                    com.bytedance.sdk.component.utils.k.c(th.toString());
                }
            }
            jSONObject2.put("ad_extra_data", jSONObject.toString());
            c(context, mVar, str, str2, jSONObject2);
        }
    }

    public static void f(Context context, com.bytedance.sdk.openadsdk.core.e.m mVar, String str, String str2, Map<String, Object> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(65581, null, context, mVar, str, str2, map) == null) {
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            if (map != null) {
                try {
                    for (Map.Entry<String, Object> entry : map.entrySet()) {
                        jSONObject2.put(entry.getKey(), entry.getValue());
                    }
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
            }
            jSONObject.put("ad_extra_data", jSONObject2.toString());
            c(context, mVar, str, str2, jSONObject);
        }
    }

    public static void g(Context context, com.bytedance.sdk.openadsdk.core.e.m mVar, String str, String str2, Map<String, Object> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(65582, null, context, mVar, str, str2, map) == null) {
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            if (map != null) {
                try {
                    for (Map.Entry<String, Object> entry : map.entrySet()) {
                        jSONObject2.put(entry.getKey(), entry.getValue());
                    }
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
            }
            jSONObject.put("ad_extra_data", jSONObject2.toString());
            c(context, mVar, str, str2, jSONObject);
        }
    }

    public static void h(Context context, com.bytedance.sdk.openadsdk.core.e.m mVar, String str, String str2, Map<String, Object> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(65583, null, context, mVar, str, str2, map) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                JSONObject jSONObject2 = new JSONObject();
                if (map != null) {
                    for (Map.Entry<String, Object> entry : map.entrySet()) {
                        jSONObject2.put(entry.getKey(), entry.getValue());
                    }
                }
                jSONObject.put("ad_extra_data", jSONObject2.toString());
            } catch (Exception unused) {
            }
            c(context, mVar, str, str2, jSONObject);
        }
    }

    public static void i(Context context, com.bytedance.sdk.openadsdk.core.e.m mVar, String str, String str2, Map<String, Object> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(65584, null, context, mVar, str, str2, map) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put(TiebaStatic.Params.REFER, str2);
                if (map != null) {
                    for (Map.Entry<String, Object> entry : map.entrySet()) {
                        jSONObject2.put(entry.getKey(), entry.getValue());
                    }
                }
                jSONObject.put("ad_extra_data", jSONObject2.toString());
            } catch (Throwable unused) {
            }
            c(context, mVar, str, "click_open", jSONObject);
        }
    }

    public static void j(Context context, com.bytedance.sdk.openadsdk.core.e.m mVar, String str, String str2, Map<String, Object> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(65585, null, context, mVar, str, str2, map) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                JSONObject jSONObject2 = new JSONObject();
                if (map != null) {
                    for (Map.Entry<String, Object> entry : map.entrySet()) {
                        jSONObject2.put(entry.getKey(), entry.getValue());
                    }
                }
                jSONObject.put("ad_extra_data", jSONObject2.toString());
            } catch (Exception unused) {
            }
            c(context, mVar, str, str2, jSONObject);
        }
    }

    /* loaded from: classes9.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public static void a(String str, JSONObject jSONObject, com.bytedance.sdk.openadsdk.core.e.m mVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(65537, null, str, jSONObject, mVar) == null) {
                try {
                    String a2 = com.bytedance.sdk.openadsdk.q.q.a(mVar);
                    if (a2 == null) {
                        return;
                    }
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("ad_extra_data", jSONObject.toString());
                    d.c(com.bytedance.sdk.openadsdk.core.o.a(), mVar, a2 + "_landingpage", str, jSONObject2);
                } catch (Throwable unused) {
                }
            }
        }

        public static void a(int i2, int i3, com.bytedance.sdk.openadsdk.core.e.m mVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIIL(65536, null, i2, i3, mVar) == null) {
                try {
                    String a2 = com.bytedance.sdk.openadsdk.q.q.a(mVar);
                    if (a2 == null) {
                        return;
                    }
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("all_times", i3);
                    jSONObject.put("hit_times", i2);
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("ad_extra_data", jSONObject.toString());
                    d.c(com.bytedance.sdk.openadsdk.core.o.a(), mVar, a2 + "_landingpage", "local_res_hit_rate", jSONObject2);
                } catch (Throwable unused) {
                }
            }
        }
    }
}
