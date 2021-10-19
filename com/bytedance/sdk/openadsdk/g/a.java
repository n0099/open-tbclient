package com.bytedance.sdk.openadsdk.g;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.down.request.db.DownloadDataConstants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.component.utils.k;
import com.bytedance.sdk.openadsdk.TTAppDownloadListener;
import com.bytedance.sdk.openadsdk.core.e.m;
import com.bytedance.sdk.openadsdk.downloadnew.core.a;
import com.bytedance.sdk.openadsdk.downloadnew.core.b;
import com.bytedance.sdk.openadsdk.q.q;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class a implements c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final m f68231a;

    /* renamed from: b  reason: collision with root package name */
    public final b f68232b;

    /* renamed from: c  reason: collision with root package name */
    public final Map<String, com.bytedance.sdk.openadsdk.downloadnew.core.b> f68233c;

    public a(b bVar, m mVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bVar, mVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f68233c = new HashMap();
        this.f68232b = bVar;
        this.f68231a = mVar;
    }

    @Override // com.bytedance.sdk.openadsdk.g.c
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            for (com.bytedance.sdk.openadsdk.downloadnew.core.b bVar : this.f68233c.values()) {
                if (bVar != null) {
                    bVar.c();
                }
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.g.c
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            b();
            for (com.bytedance.sdk.openadsdk.downloadnew.core.b bVar : this.f68233c.values()) {
                if (bVar != null) {
                    bVar.d();
                }
            }
            this.f68233c.clear();
        }
    }

    public static a a(b bVar, m mVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, bVar, mVar)) == null) ? new a(bVar, mVar) : (a) invokeLL.objValue;
    }

    @Override // com.bytedance.sdk.openadsdk.g.c
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            for (com.bytedance.sdk.openadsdk.downloadnew.core.b bVar : this.f68233c.values()) {
                if (bVar != null) {
                    bVar.b();
                }
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.g.c
    public void b(JSONObject jSONObject) {
        JSONObject optJSONObject;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, jSONObject) == null) || jSONObject == null || this.f68232b == null || (optJSONObject = jSONObject.optJSONObject("data")) == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.downloadnew.core.b bVar = this.f68233c.get(a(optJSONObject, (String) null).al().b());
        if (bVar != null) {
            bVar.f();
        }
    }

    private m a(JSONObject jSONObject, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, this, jSONObject, str)) == null) {
            if (jSONObject == null) {
                return null;
            }
            m mVar = new m();
            mVar.c(jSONObject);
            if (!TextUtils.isEmpty(str)) {
                mVar.k(str);
            }
            if (this.f68231a == null) {
                return mVar;
            }
            String b2 = mVar.al() != null ? mVar.al().b() : null;
            if (TextUtils.isEmpty(b2)) {
                return this.f68231a;
            }
            return (this.f68231a.al() == null || !b2.equals(this.f68231a.al().b())) ? mVar : this.f68231a;
        }
        return (m) invokeLL.objValue;
    }

    /* renamed from: com.bytedance.sdk.openadsdk.g.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public static class C1925a {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static ConcurrentHashMap<String, JSONObject> f68242a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-492560486, "Lcom/bytedance/sdk/openadsdk/g/a$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-492560486, "Lcom/bytedance/sdk/openadsdk/g/a$a;");
                    return;
                }
            }
            f68242a = new ConcurrentHashMap<>();
        }

        public static synchronized JSONObject a(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
                synchronized (C1925a.class) {
                    if (TextUtils.isEmpty(str)) {
                        return new JSONObject();
                    }
                    if (f68242a == null) {
                        return new JSONObject();
                    }
                    JSONObject jSONObject = f68242a.get(str);
                    return jSONObject == null ? new JSONObject() : jSONObject;
                }
            }
            return (JSONObject) invokeL.objValue;
        }

        public static synchronized void a(String str, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(65538, null, str, i2, i3) == null) {
                synchronized (C1925a.class) {
                    if (TextUtils.isEmpty(str)) {
                        return;
                    }
                    if (f68242a == null) {
                        f68242a = new ConcurrentHashMap<>();
                    }
                    JSONObject jSONObject = f68242a.get(str);
                    if (jSONObject == null) {
                        jSONObject = new JSONObject();
                        f68242a.put(str, jSONObject);
                    }
                    try {
                        jSONObject.put("downloadStatus", i2);
                        jSONObject.put("downloadProcessRate", i3);
                        jSONObject.put("code", 0);
                        jSONObject.put("codeMsg", "get ad_down_load_id success");
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                }
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.g.c
    public void a(Context context, JSONObject jSONObject, String str, int i2, boolean z) {
        JSONObject optJSONObject;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{context, jSONObject, str, Integer.valueOf(i2), Boolean.valueOf(z)}) == null) || context == null || jSONObject == null || (optJSONObject = jSONObject.optJSONObject("data")) == null) {
            return;
        }
        a(context, a(optJSONObject, str), optJSONObject, i2, z);
    }

    private void a(Context context, m mVar, JSONObject jSONObject, int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(AdIconUtil.BAIDU_LOGO_ID, this, new Object[]{context, mVar, jSONObject, Integer.valueOf(i2), Boolean.valueOf(z)}) == null) || context == null || mVar == null || mVar.al() == null || jSONObject == null || this.f68232b == null || this.f68233c.get(mVar.al().b()) != null) {
            return;
        }
        String a2 = q.a(i2);
        if (TextUtils.isEmpty(a2)) {
            return;
        }
        this.f68233c.put(mVar.al().b(), a(context, mVar, jSONObject, a2, z));
    }

    @Override // com.bytedance.sdk.openadsdk.g.c
    public void a(Context context, JSONObject jSONObject, String str) {
        JSONObject optJSONObject;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, jSONObject, str) == null) || context == null || jSONObject == null || (optJSONObject = jSONObject.optJSONObject("data")) == null) {
            return;
        }
        a(context, a(optJSONObject, (String) null), str);
    }

    private void a(Context context, m mVar, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(AdIconUtil.AD_TEXT_ID, this, context, mVar, str) == null) || context == null || mVar == null) {
            return;
        }
        if (mVar.al() == null) {
            com.bytedance.sdk.openadsdk.downloadnew.a.b(context, mVar, str).g();
            return;
        }
        String ak = mVar.ak();
        com.bytedance.sdk.openadsdk.downloadnew.core.b bVar = this.f68233c.get(mVar.al().b());
        if (bVar != null) {
            bVar.g();
            bVar.a(new TTAppDownloadListener(this, ak) { // from class: com.bytedance.sdk.openadsdk.g.a.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ String f68234a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ a f68235b;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, ak};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f68235b = this;
                    this.f68234a = ak;
                }

                @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
                public void onDownloadActive(long j2, long j3, String str2, String str3) {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeCommon(1048576, this, new Object[]{Long.valueOf(j2), Long.valueOf(j3), str2, str3}) == null) || j2 <= 0) {
                        return;
                    }
                    C1925a.a(this.f68234a, 3, (int) ((j3 * 100) / j2));
                }

                @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
                public void onDownloadFailed(long j2, long j3, String str2, String str3) {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Long.valueOf(j2), Long.valueOf(j3), str2, str3}) == null) || j2 <= 0) {
                        return;
                    }
                    C1925a.a(this.f68234a, 4, (int) ((j3 * 100) / j2));
                }

                @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
                public void onDownloadFinished(long j2, String str2, String str3) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Long.valueOf(j2), str2, str3}) == null) {
                        C1925a.a(this.f68234a, 5, 100);
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
                public void onDownloadPaused(long j2, long j3, String str2, String str3) {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeCommon(1048579, this, new Object[]{Long.valueOf(j2), Long.valueOf(j3), str2, str3}) == null) || j2 <= 0) {
                        return;
                    }
                    C1925a.a(this.f68234a, 2, (int) ((j3 * 100) / j2));
                }

                @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
                public void onIdle() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048580, this) == null) {
                        C1925a.a(this.f68234a, 1, 0);
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
                public void onInstalled(String str2, String str3) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLL(1048581, this, str2, str3) == null) {
                        C1925a.a(this.f68234a, 6, 100);
                    }
                }
            });
        }
        if (context instanceof com.bytedance.sdk.openadsdk.core.video.b.b) {
            ((com.bytedance.sdk.openadsdk.core.video.b.b) context).B();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.g.c
    public void a(JSONObject jSONObject) {
        JSONObject optJSONObject;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, jSONObject) == null) || jSONObject == null || (optJSONObject = jSONObject.optJSONObject("data")) == null) {
            return;
        }
        a(a(optJSONObject, (String) null), optJSONObject);
    }

    private void a(m mVar, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65543, this, mVar, jSONObject) == null) || this.f68232b == null || mVar == null || mVar.al() == null) {
            return;
        }
        String b2 = mVar.al().b();
        if (this.f68233c.containsKey(b2)) {
            this.f68233c.remove(b2);
            try {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("message", "success");
                jSONObject2.put("status", "unsubscribed");
                jSONObject2.put("appad", jSONObject);
                this.f68232b.a("app_ad_event", jSONObject2);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
    }

    private com.bytedance.sdk.openadsdk.downloadnew.core.b a(@NonNull Context context, @NonNull m mVar, @NonNull JSONObject jSONObject, @NonNull String str, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, this, new Object[]{context, mVar, jSONObject, str, Boolean.valueOf(z)})) == null) {
            com.bytedance.sdk.openadsdk.downloadnew.core.b b2 = com.bytedance.sdk.openadsdk.downloadnew.a.b(context, mVar, str);
            b2.a(new TTAppDownloadListener(this, jSONObject) { // from class: com.bytedance.sdk.openadsdk.g.a.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ JSONObject f68236a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ a f68237b;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, jSONObject};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f68237b = this;
                    this.f68236a = jSONObject;
                }

                private void a(String... strArr) {
                    Interceptable interceptable2 = $ic;
                    if ((interceptable2 == null || interceptable2.invokeL(65537, this, strArr) == null) && strArr != null && strArr.length % 2 == 0) {
                        try {
                            JSONObject jSONObject2 = new JSONObject();
                            jSONObject2.put("message", "success");
                            jSONObject2.put("appad", this.f68236a);
                            for (int i2 = 0; i2 < strArr.length; i2 += 2) {
                                jSONObject2.put(strArr[i2], strArr[i2 + 1]);
                            }
                            this.f68237b.f68232b.a("app_ad_event", jSONObject2);
                        } catch (JSONException unused) {
                            k.b("JsAppAdDownloadManager", "JSONException");
                        }
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
                public void onDownloadActive(long j2, long j3, String str2, String str3) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeCommon(1048576, this, new Object[]{Long.valueOf(j2), Long.valueOf(j3), str2, str3}) == null) {
                        a("status", "download_active", DownloadDataConstants.Columns.COLUMN_TOTAL_BYTES, String.valueOf(j2), DownloadDataConstants.Columns.COLUMN_CURRENT_BYTES, String.valueOf(j3));
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
                public void onDownloadFailed(long j2, long j3, String str2, String str3) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Long.valueOf(j2), Long.valueOf(j3), str2, str3}) == null) {
                        a("status", "download_failed", DownloadDataConstants.Columns.COLUMN_TOTAL_BYTES, String.valueOf(j2), DownloadDataConstants.Columns.COLUMN_CURRENT_BYTES, String.valueOf(j3));
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
                public void onDownloadFinished(long j2, String str2, String str3) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Long.valueOf(j2), str2, str3}) == null) {
                        a("status", "download_finished", DownloadDataConstants.Columns.COLUMN_TOTAL_BYTES, String.valueOf(j2), DownloadDataConstants.Columns.COLUMN_CURRENT_BYTES, String.valueOf(j2));
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
                public void onDownloadPaused(long j2, long j3, String str2, String str3) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeCommon(1048579, this, new Object[]{Long.valueOf(j2), Long.valueOf(j3), str2, str3}) == null) {
                        a("status", "download_paused", DownloadDataConstants.Columns.COLUMN_TOTAL_BYTES, String.valueOf(j2), DownloadDataConstants.Columns.COLUMN_CURRENT_BYTES, String.valueOf(j3));
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
                public void onIdle() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048580, this) == null) {
                        a("status", "idle");
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
                public void onInstalled(String str2, String str3) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLL(1048581, this, str2, str3) == null) {
                        a("status", "installed");
                    }
                }
            });
            b2.a(new b.a(this, jSONObject) { // from class: com.bytedance.sdk.openadsdk.g.a.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ JSONObject f68238a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ a f68239b;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, jSONObject};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f68239b = this;
                    this.f68238a = jSONObject;
                }
            });
            b2.a(3, new a.InterfaceC1922a(this, z) { // from class: com.bytedance.sdk.openadsdk.g.a.4
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ boolean f68240a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ a f68241b;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, Boolean.valueOf(z)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f68241b = this;
                    this.f68240a = z;
                }

                @Override // com.bytedance.sdk.openadsdk.downloadnew.core.a.InterfaceC1922a
                public boolean a(int i2, m mVar2, String str2, String str3, Object obj) {
                    InterceptResult invokeCommon2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeCommon2 = interceptable2.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), mVar2, str2, str3, obj})) == null) {
                        if (i2 != 3 || mVar2 == null || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3) || this.f68240a) {
                            return true;
                        }
                        char c2 = 65535;
                        switch (str3.hashCode()) {
                            case -1297985154:
                                if (str3.equals("click_continue")) {
                                    c2 = 3;
                                    break;
                                }
                                break;
                            case -777040223:
                                if (str3.equals("click_open")) {
                                    c2 = 4;
                                    break;
                                }
                                break;
                            case 565370917:
                                if (str3.equals("click_start_detail")) {
                                    c2 = 0;
                                    break;
                                }
                                break;
                            case 1682049151:
                                if (str3.equals("click_pause")) {
                                    c2 = 2;
                                    break;
                                }
                                break;
                            case 1685366507:
                                if (str3.equals("click_start")) {
                                    c2 = 1;
                                    break;
                                }
                                break;
                        }
                        return (c2 == 0 || c2 == 1 || c2 == 2 || c2 == 3 || c2 == 4) ? false : true;
                    }
                    return invokeCommon2.booleanValue;
                }
            });
            return b2;
        }
        return (com.bytedance.sdk.openadsdk.downloadnew.core.b) invokeCommon.objValue;
    }
}
