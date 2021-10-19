package com.bytedance.sdk.openadsdk.multipro.c;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.ar.arplay.core.engine.ARPScriptEnvironment;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ugc.editvideo.sticker.StickerDataChangeType;
import com.bytedance.sdk.component.utils.k;
import com.bytedance.sdk.component.utils.n;
import com.bytedance.sdk.openadsdk.core.o;
import com.bytedance.sdk.openadsdk.e.f;
import com.bytedance.sdk.openadsdk.e.g;
import com.bytedance.sdk.openadsdk.e.l;
import com.bytedance.sdk.openadsdk.j.c.c;
import com.bytedance.sdk.openadsdk.multipro.e;
import com.bytedance.sdk.openadsdk.p.g;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class a implements com.bytedance.sdk.openadsdk.multipro.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Context f68466a;

    /* renamed from: com.bytedance.sdk.openadsdk.multipro.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public static class C1928a implements com.bytedance.sdk.openadsdk.j.a.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public JSONObject f68467a;

        public C1928a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            try {
                this.f68467a = new JSONObject(str);
            } catch (Throwable unused) {
            }
        }

        public static C1928a b(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? new C1928a(str) : (C1928a) invokeL.objValue;
        }

        @Override // com.bytedance.sdk.openadsdk.j.a.a
        public JSONObject a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f68467a : (JSONObject) invokeV.objValue;
        }
    }

    /* loaded from: classes9.dex */
    public static class c {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static volatile com.bytedance.sdk.openadsdk.j.c.c f68471a;
        public transient /* synthetic */ FieldHolder $fh;

        public static com.bytedance.sdk.openadsdk.j.c.c a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
                if (f68471a == null) {
                    synchronized (com.bytedance.sdk.openadsdk.j.c.c.class) {
                        if (f68471a == null) {
                            f68471a = new com.bytedance.sdk.openadsdk.j.c.c();
                        }
                    }
                }
                return f68471a;
            }
            return (com.bytedance.sdk.openadsdk.j.c.c) invokeV.objValue;
        }
    }

    /* loaded from: classes9.dex */
    public static class d {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static volatile com.bytedance.sdk.openadsdk.p.a f68472a;
        public transient /* synthetic */ FieldHolder $fh;

        public static com.bytedance.sdk.openadsdk.p.a a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
                if (f68472a == null) {
                    synchronized (com.bytedance.sdk.openadsdk.p.a.class) {
                        if (f68472a == null) {
                            f68472a = new com.bytedance.sdk.openadsdk.p.b(o.a(), new g(o.a()));
                        }
                    }
                }
                return f68472a;
            }
            return (com.bytedance.sdk.openadsdk.p.a) invokeV.objValue;
        }
    }

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

    public static void a(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TRACKBALL, null, z) == null) || o.a() == null) {
            return;
        }
        try {
            ContentResolver e2 = e();
            if (e2 != null) {
                e2.getType(Uri.parse(f() + "logStatusStart" + ("?isRealTime=" + String.valueOf(z))));
            }
        } catch (Throwable unused) {
        }
    }

    public static void b(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, str) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            ContentResolver e2 = e();
            if (e2 != null) {
                e2.getType(Uri.parse(f() + "trackFailed?did=" + String.valueOf(str)));
            }
        } catch (Throwable unused) {
        }
    }

    public static void c() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, null) == null) || o.a() == null) {
            return;
        }
        try {
            ContentResolver e2 = e();
            if (e2 != null) {
                e2.getType(Uri.parse(f() + "adEventStart"));
            }
        } catch (Throwable unused) {
        }
    }

    public static void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65544, null) == null) {
            try {
                ContentResolver e2 = e();
                if (e2 != null) {
                    e2.getType(Uri.parse(f() + "logStatusInit"));
                }
            } catch (Throwable unused) {
            }
        }
    }

    public static ContentResolver e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) {
            try {
                if (o.a() != null) {
                    return o.a().getContentResolver();
                }
                return null;
            } catch (Throwable unused) {
                return null;
            }
        }
        return (ContentResolver) invokeV.objValue;
    }

    public static String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65546, null)) == null) {
            return e.f68478b + "/t_event_ad_event/";
        }
        return (String) invokeV.objValue;
    }

    @Override // com.bytedance.sdk.openadsdk.multipro.a
    public int a(@NonNull Uri uri, @Nullable ContentValues contentValues, @Nullable String str, @Nullable String[] strArr) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, uri, contentValues, str, strArr)) == null) {
            return 0;
        }
        return invokeLLLL.intValue;
    }

    @Override // com.bytedance.sdk.openadsdk.multipro.a
    public int a(@NonNull Uri uri, @Nullable String str, @Nullable String[] strArr) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, uri, str, strArr)) == null) {
            return 0;
        }
        return invokeLLL.intValue;
    }

    @Override // com.bytedance.sdk.openadsdk.multipro.a
    public Cursor a(@NonNull Uri uri, @Nullable String[] strArr, @Nullable String str, @Nullable String[] strArr2, @Nullable String str2) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(Constants.METHOD_SEND_USER_MSG, this, uri, strArr, str, strArr2, str2)) == null) {
            return null;
        }
        return (Cursor) invokeLLLLL.objValue;
    }

    @Override // com.bytedance.sdk.openadsdk.multipro.a
    public Uri a(@NonNull Uri uri, @Nullable ContentValues contentValues) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, uri, contentValues)) == null) {
            return null;
        }
        return (Uri) invokeLL.objValue;
    }

    @Override // com.bytedance.sdk.openadsdk.multipro.a
    @NonNull
    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? "t_event_ad_event" : (String) invokeV.objValue;
    }

    @Override // com.bytedance.sdk.openadsdk.multipro.a
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
        }
    }

    public static void c(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65543, null, str) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            ContentResolver e2 = e();
            if (e2 != null) {
                String a2 = com.bytedance.sdk.openadsdk.multipro.c.a(str);
                e2.getType(Uri.parse(f() + "logStatusUpload?event=" + a2));
            }
        } catch (Throwable unused) {
        }
    }

    public static void a(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65537, null, str) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        k.b("AdEventProviderImpl", "dispatch event");
        try {
            ContentResolver e2 = e();
            if (e2 != null) {
                String a2 = com.bytedance.sdk.openadsdk.multipro.c.a(str);
                e2.getType(Uri.parse(f() + "adEventDispatch?event=" + a2));
            }
        } catch (Throwable th) {
            k.f("AdEventProviderImpl", "dispatch event Throwable:" + th.toString());
        }
    }

    /* loaded from: classes9.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static volatile com.bytedance.sdk.openadsdk.e.b<com.bytedance.sdk.openadsdk.e.a> f68468a;

        /* renamed from: b  reason: collision with root package name */
        public static volatile com.bytedance.sdk.openadsdk.e.b<c.a> f68469b;

        /* renamed from: c  reason: collision with root package name */
        public static volatile com.bytedance.sdk.openadsdk.e.b<c.a> f68470c;
        public transient /* synthetic */ FieldHolder $fh;

        public static com.bytedance.sdk.openadsdk.e.b<com.bytedance.sdk.openadsdk.e.a> a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
                if (f68468a == null) {
                    synchronized (o.class) {
                        if (f68468a == null) {
                            f68468a = new com.bytedance.sdk.openadsdk.e.b<>(new f(o.a()), o.f(), g.b.a(), d());
                        }
                    }
                }
                return f68468a;
            }
            return (com.bytedance.sdk.openadsdk.e.b) invokeV.objValue;
        }

        public static com.bytedance.sdk.openadsdk.e.b<c.a> b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
                if (f68470c == null) {
                    synchronized (o.class) {
                        if (f68470c == null) {
                            f68470c = a("ttad_bk_batch_stats", "AdStatsEventBatchThread", false);
                        }
                    }
                }
                return f68470c;
            }
            return (com.bytedance.sdk.openadsdk.e.b) invokeV.objValue;
        }

        public static com.bytedance.sdk.openadsdk.e.b<c.a> c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
                if (f68469b == null) {
                    synchronized (o.class) {
                        if (f68469b == null) {
                            f68469b = a("ttad_bk_stats", "AdStatsEventThread", true);
                        }
                    }
                }
                return f68469b;
            }
            return (com.bytedance.sdk.openadsdk.e.b) invokeV.objValue;
        }

        public static g.a d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? new g.a() { // from class: com.bytedance.sdk.openadsdk.multipro.c.a.b.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                        }
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.e.g.a
                public boolean a() {
                    InterceptResult invokeV2;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeV2 = interceptable2.invokeV(1048576, this)) == null) ? n.a(o.a()) : invokeV2.booleanValue;
                }
            } : (g.a) invokeV.objValue;
        }

        public static com.bytedance.sdk.openadsdk.e.b<c.a> a(String str, String str2, boolean z) {
            InterceptResult invokeLLZ;
            g.b b2;
            com.bytedance.sdk.openadsdk.e.e lVar;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(65537, null, str, str2, z)) == null) {
                if (z) {
                    lVar = new com.bytedance.sdk.openadsdk.e.n(o.a());
                    b2 = g.b.a();
                } else {
                    b2 = g.b.b();
                    lVar = new l(o.a());
                }
                g.a d2 = d();
                return new com.bytedance.sdk.openadsdk.e.b<>(lVar, null, b2, d2, new com.bytedance.sdk.openadsdk.e.o(str, str2, lVar, null, b2, d2));
            }
            return (com.bytedance.sdk.openadsdk.e.b) invokeLLZ.objValue;
        }
    }

    public static void a(String str, List<String> list, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLZ(65538, null, str, list, z) == null) && !TextUtils.isEmpty(str) && list != null && !list.isEmpty()) {
            try {
                StringBuilder sb = new StringBuilder();
                for (String str2 : list) {
                    sb.append(com.bytedance.sdk.openadsdk.multipro.c.a(str2));
                    sb.append(",");
                }
                String a2 = com.bytedance.sdk.openadsdk.multipro.c.a(sb.toString());
                String str3 = "?did=" + String.valueOf(str) + "&track=" + String.valueOf(a2) + "&replace=" + String.valueOf(z);
                ContentResolver e2 = e();
                if (e2 == null) {
                    return;
                }
                e2.getType(Uri.parse(f() + "trackUrl" + str3));
            } catch (Throwable unused) {
            }
        }
    }

    public static void a(String str, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(65539, null, str, z) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            ContentResolver e2 = e();
            if (e2 != null) {
                e2.getType(Uri.parse(f() + "logStatusDispatch" + ("?event=" + com.bytedance.sdk.openadsdk.multipro.c.a(str) + "&isRealTime=" + String.valueOf(z))));
            }
        } catch (Throwable unused) {
        }
    }

    @Override // com.bytedance.sdk.openadsdk.multipro.a
    public void a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, context) == null) {
            this.f68466a = context;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.multipro.a
    public String a(@NonNull Uri uri) {
        InterceptResult invokeL;
        String queryParameter;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, uri)) == null) {
            String str = uri.getPath().split("/")[2];
            if ("adEventStart".equals(str)) {
                k.b("AdEventProviderImpl", "====ad event function will be start====");
                b.a().a();
            } else if ("logStatusStart".equals(str)) {
                k.b("AdEventProviderImpl", "====log stats function will be start====");
                if (Boolean.valueOf(uri.getQueryParameter("isRealTime")).booleanValue()) {
                    b.c().a();
                } else {
                    b.b().a();
                }
            } else if ("adEventDispatch".equals(str)) {
                k.b("AdEventProviderImpl", "dispatch FUN_AD_EVENT_DISPATCH");
                com.bytedance.sdk.openadsdk.e.a a2 = com.bytedance.sdk.openadsdk.e.a.a(com.bytedance.sdk.openadsdk.multipro.c.b(uri.getQueryParameter("event")));
                if (a2 != null) {
                    b.a().a(a2);
                }
            } else if ("logStatusDispatch".equals(str)) {
                Boolean valueOf = Boolean.valueOf(uri.getQueryParameter("isRealTime"));
                c.a a3 = c.a.a(com.bytedance.sdk.openadsdk.multipro.c.b(uri.getQueryParameter("event")));
                if (a3 == null) {
                    return null;
                }
                if (valueOf.booleanValue()) {
                    b.c().a(a3);
                } else {
                    b.b().a(a3);
                }
            } else if ("trackUrl".equals(str)) {
                try {
                    String queryParameter2 = uri.getQueryParameter("did");
                    boolean booleanValue = Boolean.valueOf(uri.getQueryParameter(StickerDataChangeType.REPLACE)).booleanValue();
                    String[] split = com.bytedance.sdk.openadsdk.multipro.c.b(uri.getQueryParameter(ARPScriptEnvironment.KEY_DATA_PIP_TRACK)).split(",");
                    if (split.length > 0) {
                        ArrayList arrayList = new ArrayList();
                        for (String str2 : split) {
                            String b2 = com.bytedance.sdk.openadsdk.multipro.c.b(str2);
                            if (!TextUtils.isEmpty(b2)) {
                                arrayList.add(b2);
                            }
                        }
                        d.a().a(queryParameter2, arrayList, booleanValue);
                    }
                } catch (Throwable unused) {
                }
            } else if ("trackFailed".equals(str)) {
                d.a().a(uri.getQueryParameter("did"));
                k.b("AdEventProviderImpl", "track failed: " + String.valueOf(queryParameter));
            } else if ("logStatusInit".equals(str)) {
                c.a().a();
            } else if ("logStatusUpload".equals(str)) {
                String b3 = com.bytedance.sdk.openadsdk.multipro.c.b(uri.getQueryParameter("event"));
                if (!TextUtils.isEmpty(b3)) {
                    c.a().a(C1928a.b(b3));
                }
            }
            return null;
        }
        return (String) invokeL.objValue;
    }
}
