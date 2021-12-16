package com.ss.android.downloadlib.g;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.protobuf.CodedInputStream;
import com.ss.android.download.api.config.q;
import com.ss.android.download.api.constant.BaseConstants;
import com.ss.android.downloadlib.activity.JumpKllkActivity;
import com.ss.android.downloadlib.activity.TTDelegateActivity;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class h {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void b(Context context, com.ss.android.downloadlib.addownload.b.e eVar, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65551, null, context, eVar, str) == null) {
            com.ss.android.downloadlib.d.a().a(new Runnable(str, context, eVar) { // from class: com.ss.android.downloadlib.g.h.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ String a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ Context f62018b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ com.ss.android.downloadlib.addownload.b.e f62019c;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {str, context, eVar};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = str;
                    this.f62018b = context;
                    this.f62019c = eVar;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        JSONObject i2 = com.ss.android.downloadlib.addownload.j.i();
                        String optString = i2.optString("s");
                        JSONObject jSONObject = new JSONObject();
                        String a = com.ss.android.socialbase.appdownloader.f.c.a(i2.optString("x"), optString);
                        JSONObject jSONObject2 = new JSONObject();
                        l.a(jSONObject2, "p", this.a);
                        l.a(jSONObject2, "i", Build.VERSION.INCREMENTAL);
                        l.a(jSONObject2, "m", Build.MODEL);
                        l.a(jSONObject2, "im", com.ss.android.downloadlib.a.a.b.a(this.f62018b));
                        l.a(jSONObject2, "d", com.ss.android.downloadlib.a.a.b.b(this.f62018b));
                        l.a(jSONObject2, "t", "m");
                        byte[] bytes = jSONObject2.toString().getBytes();
                        com.ss.android.downloadlib.addownload.j.d().a(a, com.ss.android.downloadlib.addownload.j.q().a(bytes, bytes.length), "application/octet-stream;tt-data=a", 0, new q(this, jSONObject, i2, optString) { // from class: com.ss.android.downloadlib.g.h.1.1
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;
                            public final /* synthetic */ JSONObject a;

                            /* renamed from: b  reason: collision with root package name */
                            public final /* synthetic */ JSONObject f62020b;

                            /* renamed from: c  reason: collision with root package name */
                            public final /* synthetic */ String f62021c;

                            /* renamed from: d  reason: collision with root package name */
                            public final /* synthetic */ AnonymousClass1 f62022d;

                            {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 != null) {
                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                    newInitContext.initArgs = r2;
                                    Object[] objArr = {this, jSONObject, i2, optString};
                                    interceptable3.invokeUnInit(65536, newInitContext);
                                    int i3 = newInitContext.flag;
                                    if ((i3 & 1) != 0) {
                                        int i4 = i3 & 2;
                                        newInitContext.thisArg = this;
                                        interceptable3.invokeInitBody(65536, newInitContext);
                                        return;
                                    }
                                }
                                this.f62022d = this;
                                this.a = jSONObject;
                                this.f62020b = i2;
                                this.f62021c = optString;
                            }

                            @Override // com.ss.android.download.api.config.q
                            public void a(String str2) {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 == null || interceptable3.invokeL(1048576, this, str2) == null) {
                                    AnonymousClass1 anonymousClass1 = this.f62022d;
                                    h.b(anonymousClass1.f62018b, anonymousClass1.a, str2, anonymousClass1.f62019c, this.a, this.f62020b, this.f62021c);
                                }
                            }

                            @Override // com.ss.android.download.api.config.q
                            public void a(Throwable th) {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 == null || interceptable3.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th) == null) {
                                    Context context2 = this.f62022d.f62018b;
                                    com.ss.android.downloadlib.b.a.a(h.a(context2, Uri.parse(BaseConstants.MARKET_PREFIX + this.f62022d.a)), this.f62022d.f62019c, true);
                                    l.a(this.a, "ttdownloader_message", th != null ? th.getMessage() : StringUtil.NULL_STRING);
                                    h.b(this.f62022d.f62019c, this.a, 4, 1);
                                }
                            }
                        });
                    }
                }
            });
        }
    }

    public static com.ss.android.downloadlib.addownload.b.g c(Context context, com.ss.android.downloadlib.addownload.b.e eVar, String str) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65555, null, context, eVar, str)) == null) {
            Intent intent = new Intent(context, JumpKllkActivity.class);
            intent.addFlags(268435456);
            intent.putExtra("p", str);
            intent.putExtra("id", eVar.a);
            intent.putExtra(BaseConstants.START_ONLY_FOR_ANDROID, true);
            JSONObject jSONObject = new JSONObject();
            try {
                context.startActivity(intent);
                return new com.ss.android.downloadlib.addownload.b.g(7, "am_kllk2");
            } catch (Throwable unused) {
                b(eVar, jSONObject, 1, 3);
                return a(context, Uri.parse(BaseConstants.MARKET_PREFIX + str));
            }
        }
        return (com.ss.android.downloadlib.addownload.b.g) invokeLLL.objValue;
    }

    public static com.ss.android.downloadlib.addownload.b.g d(@NonNull Context context, @NonNull String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65557, null, context, str)) == null) {
            try {
                Uri parse = Uri.parse("https://www.samsungapps.com/appquery/appDetail.as?appId=" + str);
                Intent intent = new Intent();
                intent.setClassName("com.sec.android.app.samsungapps", "com.sec.android.app.samsungapps.Main");
                intent.setData(parse);
                if (!(context instanceof Activity)) {
                    intent.addFlags(268435456);
                }
                intent.putExtra(BaseConstants.START_ONLY_FOR_ANDROID, true);
                context.startActivity(intent);
                return new com.ss.android.downloadlib.addownload.b.g(5);
            } catch (Exception unused) {
                return new com.ss.android.downloadlib.addownload.b.g(6, 14);
            }
        }
        return (com.ss.android.downloadlib.addownload.b.g) invokeLL.objValue;
    }

    public static boolean e(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65560, null, context, str)) == null) {
            if (context == null) {
                context = com.ss.android.downloadlib.addownload.j.getContext();
            }
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            Intent intent = new Intent("android.intent.action.VIEW");
            if (!(context instanceof Activity)) {
                intent.addFlags(268435456);
                if (com.ss.android.socialbase.downloader.g.a.c().a("fix_app_link_flag")) {
                    intent.addFlags(32768);
                }
            }
            intent.setData(Uri.parse(str));
            intent.putExtra(BaseConstants.START_ONLY_FOR_ANDROID, true);
            String i2 = com.ss.android.socialbase.appdownloader.f.d.i();
            if (l.d(com.ss.android.downloadlib.addownload.j.getContext(), i2)) {
                intent.setPackage(i2);
            }
            if (l.a(com.ss.android.downloadlib.addownload.j.getContext(), intent)) {
                try {
                    context.startActivity(intent);
                    return true;
                } catch (Exception unused) {
                    return false;
                }
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public static void b(Context context, String str, String str2, @NonNull com.ss.android.downloadlib.addownload.b.e eVar, @NonNull JSONObject jSONObject, @NonNull JSONObject jSONObject2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65553, null, new Object[]{context, str, str2, eVar, jSONObject, jSONObject2, str3}) == null) {
            l.a(jSONObject, "ttdownloader_type", (Object) 1);
            try {
                String a = a(com.ss.android.socialbase.appdownloader.f.c.a(new JSONObject(str2).optString("a")), jSONObject2, str3);
                l.a(jSONObject, "open_url", a);
                if (e(context, a)) {
                    b(eVar, jSONObject, -1, 1);
                    com.ss.android.downloadlib.b.a.a("am_m1", jSONObject, eVar, true);
                } else {
                    com.ss.android.downloadlib.b.a.a(a(context, Uri.parse(BaseConstants.MARKET_PREFIX + str)), eVar, true);
                    b(eVar, jSONObject, 2, 1);
                }
            } catch (Exception unused) {
                com.ss.android.downloadlib.b.a.a(a(context, Uri.parse(BaseConstants.MARKET_PREFIX + str)), eVar, true);
                b(eVar, jSONObject, 3, 1);
            }
        }
    }

    public static com.ss.android.downloadlib.addownload.b.g a(Context context, Uri uri) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, context, uri)) == null) {
            if (context != null && uri != null && "market".equals(uri.getScheme())) {
                try {
                    Intent intent = new Intent("android.intent.action.VIEW", uri);
                    if (!l.a(context, intent)) {
                        return new com.ss.android.downloadlib.addownload.b.g(6, 13);
                    }
                    String i2 = com.ss.android.socialbase.appdownloader.f.d.i();
                    if (l.d(context, i2) && !com.ss.android.socialbase.appdownloader.f.d.f()) {
                        intent.setPackage(i2);
                    }
                    if (com.ss.android.socialbase.downloader.g.a.c().a("fix_jump_market")) {
                        intent.addFlags(335544320);
                    } else if (!(context instanceof Activity)) {
                        intent.addFlags(268435456);
                    }
                    intent.putExtra(BaseConstants.START_ONLY_FOR_ANDROID, true);
                    context.startActivity(intent);
                    return new com.ss.android.downloadlib.addownload.b.g(5);
                } catch (Exception unused) {
                    return new com.ss.android.downloadlib.addownload.b.g(6, 14);
                }
            }
            return new com.ss.android.downloadlib.addownload.b.g(6, 12);
        }
        return (com.ss.android.downloadlib.addownload.b.g) invokeLL.objValue;
    }

    public static boolean c(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65556, null, context, str)) == null) {
            if (context == null) {
                return false;
            }
            try {
                Uri parse = Uri.parse(str);
                Intent intent = new Intent("android.intent.action.VIEW");
                intent.setData(parse);
                intent.addFlags(268435456);
                intent.putExtra("open_url", str);
                intent.putExtra(BaseConstants.START_ONLY_FOR_ANDROID, true);
                context.startActivity(intent);
                return true;
            } catch (Throwable th) {
                th.printStackTrace();
                return false;
            }
        }
        return invokeLL.booleanValue;
    }

    public static void d(Context context, com.ss.android.downloadlib.addownload.b.e eVar, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65558, null, context, eVar, str) == null) {
            com.ss.android.downloadlib.d.a().a(new Runnable(context, str, eVar) { // from class: com.ss.android.downloadlib.g.h.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ Context a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ String f62023b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ com.ss.android.downloadlib.addownload.b.e f62024c;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {context, str, eVar};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = context;
                    this.f62023b = str;
                    this.f62024c = eVar;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        Context context2 = this.a;
                        com.ss.android.downloadlib.b.a.a(h.a(context2, Uri.parse(BaseConstants.MARKET_PREFIX + this.f62023b)), this.f62024c, true);
                        JSONObject jSONObject = new JSONObject();
                        try {
                            JSONObject i2 = com.ss.android.downloadlib.addownload.j.i();
                            Thread.sleep(i2.optInt("m2_delay_millis", 1000));
                            com.ss.android.downloadlib.a.b.a.a().a(this.a, true);
                            com.ss.android.downloadlib.a.b.b bVar = new com.ss.android.downloadlib.a.b.b();
                            bVar.a = 1;
                            bVar.f61735b = 0;
                            bVar.f61736c = String.format(com.ss.android.socialbase.appdownloader.f.c.a(i2.optString("v"), i2.optString("s")), this.f62023b);
                            com.ss.android.downloadlib.a.b.a.a().a(bVar, (com.ss.android.downloadlib.a.b.d) null);
                            com.ss.android.downloadlib.a.b.a.a().b();
                            h.b(this.f62024c, jSONObject, -1, 2);
                        } catch (Throwable th) {
                            th.printStackTrace();
                            h.b(this.f62024c, jSONObject, 1, 2);
                        }
                    }
                }
            });
        }
    }

    public static void b(Context context, String str, String str2, @NonNull com.ss.android.downloadlib.addownload.b.e eVar, @NonNull JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(65552, null, context, str, str2, eVar, jSONObject) == null) {
            l.a(jSONObject, "ttdownloader_type", (Object) 5);
            try {
                String a = com.ss.android.socialbase.appdownloader.f.c.a(new JSONObject(str2).optString("a"));
                if (!TextUtils.isEmpty(a)) {
                    TTDelegateActivity.a(str, eVar.a, a, jSONObject);
                } else {
                    com.ss.android.downloadlib.b.a.a(a(context, Uri.parse(BaseConstants.MARKET_PREFIX + str)), eVar, true);
                    b(eVar, jSONObject, 5, 5);
                }
            } catch (Exception unused) {
                com.ss.android.downloadlib.b.a.a(a(context, Uri.parse(BaseConstants.MARKET_PREFIX + str)), eVar, true);
                b(eVar, jSONObject, 6, 5);
            }
        }
    }

    public static void e(Context context, com.ss.android.downloadlib.addownload.b.e eVar, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65559, null, context, eVar, str) == null) {
            com.ss.android.downloadlib.d.a().a(new Runnable(str, context, eVar) { // from class: com.ss.android.downloadlib.g.h.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ String a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ Context f62025b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ com.ss.android.downloadlib.addownload.b.e f62026c;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {str, context, eVar};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = str;
                    this.f62025b = context;
                    this.f62026c = eVar;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        JSONObject i2 = com.ss.android.downloadlib.addownload.j.i();
                        String optString = i2.optString("s");
                        JSONObject jSONObject = new JSONObject();
                        String a = com.ss.android.socialbase.appdownloader.f.c.a(i2.optString("x"), optString);
                        JSONObject jSONObject2 = new JSONObject();
                        l.a(jSONObject2, "t", "v");
                        l.a(jSONObject2, "p", this.a);
                        byte[] bytes = jSONObject2.toString().getBytes();
                        com.ss.android.downloadlib.addownload.j.d().a(a, com.ss.android.downloadlib.addownload.j.q().a(bytes, bytes.length), "application/octet-stream;tt-data=a", 0, new q(this, jSONObject) { // from class: com.ss.android.downloadlib.g.h.3.1
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;
                            public final /* synthetic */ JSONObject a;

                            /* renamed from: b  reason: collision with root package name */
                            public final /* synthetic */ AnonymousClass3 f62027b;

                            {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 != null) {
                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                    newInitContext.initArgs = r2;
                                    Object[] objArr = {this, jSONObject};
                                    interceptable3.invokeUnInit(65536, newInitContext);
                                    int i3 = newInitContext.flag;
                                    if ((i3 & 1) != 0) {
                                        int i4 = i3 & 2;
                                        newInitContext.thisArg = this;
                                        interceptable3.invokeInitBody(65536, newInitContext);
                                        return;
                                    }
                                }
                                this.f62027b = this;
                                this.a = jSONObject;
                            }

                            @Override // com.ss.android.download.api.config.q
                            public void a(String str2) {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 == null || interceptable3.invokeL(1048576, this, str2) == null) {
                                    AnonymousClass3 anonymousClass3 = this.f62027b;
                                    h.b(anonymousClass3.f62025b, anonymousClass3.a, str2, anonymousClass3.f62026c, this.a);
                                }
                            }

                            @Override // com.ss.android.download.api.config.q
                            public void a(Throwable th) {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 == null || interceptable3.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th) == null) {
                                    Context context2 = this.f62027b.f62025b;
                                    com.ss.android.downloadlib.b.a.a(h.a(context2, Uri.parse(BaseConstants.MARKET_PREFIX + this.f62027b.a)), this.f62027b.f62026c, true);
                                    l.a(this.a, "ttdownloader_message", th != null ? th.getMessage() : StringUtil.NULL_STRING);
                                    h.b(this.f62027b.f62026c, this.a, 7, 5);
                                }
                            }
                        });
                    }
                }
            });
        }
    }

    public static com.ss.android.downloadlib.addownload.b.g a(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, context, str)) == null) {
            if (context != null && !TextUtils.isEmpty(str)) {
                if (com.ss.android.socialbase.appdownloader.f.d.f() && l.d(context, "com.sec.android.app.samsungapps")) {
                    return d(context, str);
                }
                return a(context, Uri.parse(BaseConstants.MARKET_PREFIX + str));
            }
            return new com.ss.android.downloadlib.addownload.b.g(6, 11);
        }
        return (com.ss.android.downloadlib.addownload.b.g) invokeLL.objValue;
    }

    public static com.ss.android.downloadlib.addownload.b.g a(Context context, com.ss.android.downloadlib.addownload.b.e eVar, String str) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65537, null, context, eVar, str)) == null) {
            if (context != null && !TextUtils.isEmpty(str)) {
                if (com.ss.android.socialbase.appdownloader.f.d.f() && l.d(context, "com.sec.android.app.samsungapps")) {
                    return d(context, str);
                }
                if (eVar.f61804b.isAd() && eVar.f61806d.enableAM()) {
                    JSONArray optJSONArray = com.ss.android.downloadlib.addownload.j.i().optJSONArray("am_plans");
                    if (com.ss.android.socialbase.appdownloader.f.d.b() && com.ss.android.socialbase.appdownloader.f.a.a(optJSONArray, "am_0")) {
                        b(context, eVar, str);
                        return new com.ss.android.downloadlib.addownload.b.g(7, "am_m1");
                    } else if (com.ss.android.socialbase.appdownloader.f.d.d() && com.ss.android.socialbase.appdownloader.f.a.a(optJSONArray, "am_3")) {
                        return c(context, eVar, str);
                    } else {
                        if (com.ss.android.socialbase.appdownloader.f.d.e() && com.ss.android.socialbase.appdownloader.f.a.a(optJSONArray, "am_2")) {
                            d(context, eVar, str);
                            return new com.ss.android.downloadlib.addownload.b.g(7, "am_m2");
                        } else if (com.ss.android.socialbase.appdownloader.f.d.c() && com.ss.android.socialbase.appdownloader.f.a.a(optJSONArray, "am_5")) {
                            e(context, eVar, str);
                            return new com.ss.android.downloadlib.addownload.b.g(7, "am_v1");
                        } else {
                            return a(context, Uri.parse(BaseConstants.MARKET_PREFIX + str));
                        }
                    }
                }
                return a(context, Uri.parse(BaseConstants.MARKET_PREFIX + str));
            }
            return new com.ss.android.downloadlib.addownload.b.g(6, 11);
        }
        return (com.ss.android.downloadlib.addownload.b.g) invokeLLL.objValue;
    }

    public static void b(com.ss.android.downloadlib.addownload.b.e eVar, JSONObject jSONObject, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLII(65554, null, eVar, jSONObject, i2, i3) == null) {
            l.a(jSONObject, "error_code", Integer.valueOf(i2));
            l.a(jSONObject, "ttdownloader_type", Integer.valueOf(i3));
            l.a(jSONObject, com.ss.android.socialbase.appdownloader.f.d.i(), Integer.valueOf(l.b(com.ss.android.downloadlib.addownload.j.getContext(), com.ss.android.socialbase.appdownloader.f.d.i())));
            com.ss.android.downloadlib.d.a.a().b("am_result", jSONObject, eVar);
        }
    }

    public static com.ss.android.downloadlib.addownload.b.g b(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65549, null, context, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return new com.ss.android.downloadlib.addownload.b.g(4, 11);
            }
            if (context == null) {
                context = com.ss.android.downloadlib.addownload.j.getContext();
            }
            Intent f2 = l.f(context, str);
            if (f2 == null) {
                return new com.ss.android.downloadlib.addownload.b.g(4, 22);
            }
            f2.putExtra(BaseConstants.START_ONLY_FOR_ANDROID, true);
            try {
                context.startActivity(f2);
                return new com.ss.android.downloadlib.addownload.b.g(3);
            } catch (Exception unused) {
                return new com.ss.android.downloadlib.addownload.b.g(4, 23);
            }
        }
        return (com.ss.android.downloadlib.addownload.b.g) invokeLL.objValue;
    }

    public static com.ss.android.downloadlib.addownload.b.g b(String str, @NonNull com.ss.android.downloadad.api.a.a aVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65550, null, str, aVar)) == null) {
            if (TextUtils.isEmpty(str)) {
                return new com.ss.android.downloadlib.addownload.b.g(2, 21);
            }
            Context context = com.ss.android.downloadlib.addownload.j.getContext();
            Uri parse = Uri.parse(str);
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setData(parse);
            intent.addFlags(268435456);
            intent.putExtra("open_url", str);
            intent.putExtra(BaseConstants.START_ONLY_FOR_ANDROID, true);
            if (com.ss.android.socialbase.downloader.g.a.c().a("fix_app_link_flag")) {
                intent.addFlags(CodedInputStream.DEFAULT_SIZE_LIMIT);
            }
            if (l.b(context, intent)) {
                if (com.ss.android.downloadlib.addownload.j.i().optInt("open_url_mode") == 0 && com.ss.android.downloadlib.addownload.j.k() != null && com.ss.android.downloadlib.addownload.j.k().a() && Build.VERSION.SDK_INT >= 26 && aVar.q()) {
                    TTDelegateActivity.a(str, aVar);
                } else {
                    try {
                        com.ss.android.downloadlib.addownload.j.getContext().startActivity(intent);
                    } catch (Exception unused) {
                        return new com.ss.android.downloadlib.addownload.b.g(2);
                    }
                }
                return new com.ss.android.downloadlib.addownload.b.g(1);
            }
            return new com.ss.android.downloadlib.addownload.b.g(2, 24);
        }
        return (com.ss.android.downloadlib.addownload.b.g) invokeLL.objValue;
    }

    public static String a(String str, @NonNull JSONObject jSONObject, String str2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65542, null, str, jSONObject, str2)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            String a = com.ss.android.socialbase.appdownloader.f.c.a(jSONObject.optString("g"), str2);
            String a2 = com.ss.android.socialbase.appdownloader.f.c.a(jSONObject.optString("h"), str2);
            return (TextUtils.isEmpty(a) || TextUtils.isEmpty(a2)) ? str : str.replace(a, a2);
        }
        return (String) invokeLLL.objValue;
    }

    public static void a(Context context, String str, long j2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65544, null, new Object[]{context, str, Long.valueOf(j2), Boolean.valueOf(z)}) == null) {
            JSONObject jSONObject = new JSONObject();
            com.ss.android.downloadlib.addownload.b.e e2 = com.ss.android.downloadlib.addownload.b.f.a().e(j2);
            try {
                JSONObject i2 = com.ss.android.downloadlib.addownload.j.i();
                String optString = i2.optString("s");
                String a = com.ss.android.socialbase.appdownloader.f.c.a(i2.optString("aa"), optString);
                String a2 = com.ss.android.socialbase.appdownloader.f.c.a(i2.optString("ac"), optString);
                String a3 = com.ss.android.socialbase.appdownloader.f.c.a(i2.optString("af"), optString);
                boolean a4 = com.ss.android.socialbase.appdownloader.f.a.a(i2, context, a2);
                StringBuilder sb = new StringBuilder(String.format(a, str, a3, a2));
                Intent intent = new Intent("android.intent.action.VIEW");
                String i3 = com.ss.android.socialbase.appdownloader.f.d.i();
                if (l.d(context, i3)) {
                    intent.setPackage(i3);
                }
                if (z) {
                    sb.append(com.ss.android.socialbase.appdownloader.f.c.a(i2.optString("ae"), optString));
                } else {
                    intent.addFlags(335544320);
                }
                l.a(jSONObject, "mf", Boolean.valueOf(a4));
                l.a(jSONObject, "if", Boolean.valueOf(z));
                intent.setData(Uri.parse(sb.toString()));
                intent.putExtra(BaseConstants.START_ONLY_FOR_ANDROID, true);
                context.startActivity(intent);
                com.ss.android.downloadlib.b.a.a("am_kllk2", jSONObject, e2, true);
                if (a4) {
                    b(e2, jSONObject, -1, 3);
                } else {
                    b(e2, jSONObject, 3, 3);
                }
            } catch (Exception unused) {
                Context context2 = com.ss.android.downloadlib.addownload.j.getContext();
                com.ss.android.downloadlib.b.a.a(a(context2, Uri.parse(BaseConstants.MARKET_PREFIX + str)), e2, true);
                b(e2, jSONObject, 2, 3);
            }
        }
    }

    public static boolean a(@NonNull Activity activity, @NonNull String str, @NonNull HashMap<String, String> hashMap) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65548, null, activity, str, hashMap)) == null) {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setData(Uri.parse(BaseConstants.MARKET_PREFIX + str));
            intent.putExtra(BaseConstants.START_ONLY_FOR_ANDROID, true);
            intent.putExtra("param", hashMap);
            String i2 = com.ss.android.socialbase.appdownloader.f.d.i();
            if (l.d(com.ss.android.downloadlib.addownload.j.getContext(), i2)) {
                intent.setPackage(i2);
            }
            if (l.a(com.ss.android.downloadlib.addownload.j.getContext(), intent)) {
                try {
                    activity.startActivity(intent);
                    return true;
                } catch (Exception e2) {
                    com.ss.android.downloadlib.e.c.a().a(e2, "start v1");
                    return false;
                }
            }
            return false;
        }
        return invokeLLL.booleanValue;
    }

    public static void a(@NonNull Activity activity, String str, long j2, String str2, String str3) {
        JSONObject jSONObject;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65543, null, new Object[]{activity, str, Long.valueOf(j2), str2, str3}) == null) {
            try {
                jSONObject = new JSONObject(str3);
            } catch (JSONException unused) {
                jSONObject = new JSONObject();
            }
            com.ss.android.downloadlib.addownload.b.e e2 = com.ss.android.downloadlib.addownload.b.f.a().e(j2);
            try {
                JSONObject i3 = com.ss.android.downloadlib.addownload.j.i();
                boolean a = com.ss.android.socialbase.appdownloader.f.a.a(i3, activity, com.ss.android.socialbase.appdownloader.f.c.a(i3.optString("bg"), i3.optString("s")));
                HashMap<String, String> b2 = l.b(new JSONObject(str2));
                if (a && !b2.isEmpty() && a(activity, str, b2)) {
                    b(e2, jSONObject, -1, 5);
                    com.ss.android.downloadlib.b.a.a("am_v1", jSONObject, e2, true);
                    return;
                }
                if (a) {
                    i2 = b2.isEmpty() ? 1 : 2;
                } else {
                    i2 = 3;
                }
                b(e2, jSONObject, i2, 5);
                com.ss.android.downloadlib.b.a.a(a(activity, Uri.parse(BaseConstants.MARKET_PREFIX + str)), e2, true);
            } catch (Exception unused2) {
                Context context = com.ss.android.downloadlib.addownload.j.getContext();
                com.ss.android.downloadlib.b.a.a(a(context, Uri.parse(BaseConstants.MARKET_PREFIX + str)), e2, true);
                b(e2, jSONObject, 4, 5);
            }
        }
    }

    public static com.ss.android.downloadlib.addownload.b.g a(Context context, String str, com.ss.android.downloadad.api.a.a aVar) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65539, null, context, str, aVar)) == null) {
            Intent f2 = l.f(context, str);
            if (f2 == null) {
                return new com.ss.android.downloadlib.addownload.b.g(4, 22);
            }
            if (Build.VERSION.SDK_INT >= 26 && com.ss.android.downloadlib.addownload.j.i().optInt("open_package_mode") == 1 && com.ss.android.downloadlib.addownload.j.k() != null && com.ss.android.downloadlib.addownload.j.k().a() && aVar.q()) {
                TTDelegateActivity.b(str, aVar);
                return new com.ss.android.downloadlib.addownload.b.g(3);
            }
            f2.putExtra(BaseConstants.START_ONLY_FOR_ANDROID, true);
            try {
                context.startActivity(f2);
                return new com.ss.android.downloadlib.addownload.b.g(3);
            } catch (Exception unused) {
                return new com.ss.android.downloadlib.addownload.b.g(4, 23);
            }
        }
        return (com.ss.android.downloadlib.addownload.b.g) invokeLLL.objValue;
    }

    public static com.ss.android.downloadlib.addownload.b.g a(String str, com.ss.android.downloadad.api.a.a aVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65541, null, str, aVar)) == null) ? a(com.ss.android.downloadlib.addownload.j.getContext(), str, aVar) : (com.ss.android.downloadlib.addownload.b.g) invokeLL.objValue;
    }

    public static com.ss.android.downloadlib.addownload.b.g a(@NonNull com.ss.android.downloadad.api.a.b bVar, String str, String str2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, bVar, str, str2)) == null) {
            com.ss.android.downloadlib.addownload.b.g b2 = b(str, bVar);
            return (com.ss.android.downloadlib.b.f.a(bVar) && b2.getType() == 2) ? a(str2, bVar) : b2;
        }
        return (com.ss.android.downloadlib.addownload.b.g) invokeLLL.objValue;
    }
}
