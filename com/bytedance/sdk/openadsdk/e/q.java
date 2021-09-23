package com.bytedance.sdk.openadsdk.e;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class q {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f68140a;

    /* renamed from: b  reason: collision with root package name */
    public com.bytedance.sdk.openadsdk.core.e.m f68141b;

    /* renamed from: c  reason: collision with root package name */
    public Boolean f68142c;

    /* renamed from: d  reason: collision with root package name */
    public Boolean f68143d;

    /* renamed from: e  reason: collision with root package name */
    public Boolean f68144e;

    /* renamed from: f  reason: collision with root package name */
    public JSONObject f68145f;

    /* renamed from: g  reason: collision with root package name */
    public JSONArray f68146g;

    /* renamed from: h  reason: collision with root package name */
    public JSONArray f68147h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f68148i;

    public q(int i2, String str, com.bytedance.sdk.openadsdk.core.e.m mVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2), str, mVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f68140a = "embeded_ad";
        Boolean bool = Boolean.FALSE;
        this.f68142c = bool;
        this.f68143d = bool;
        this.f68144e = bool;
        this.f68148i = false;
        this.f68140a = str;
        this.f68141b = mVar;
        this.f68145f = new JSONObject();
        this.f68146g = new JSONArray();
        this.f68147h = new JSONArray();
        a(this.f68145f, "webview_source", Integer.valueOf(i2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65553, this)) == null) ? this.f68144e.booleanValue() || (this.f68143d.booleanValue() && this.f68142c.booleanValue()) : invokeV.booleanValue;
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            com.bytedance.sdk.component.utils.h.a().post(new Runnable(this) { // from class: com.bytedance.sdk.openadsdk.e.q.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ q f68171a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f68171a = this;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        long currentTimeMillis = System.currentTimeMillis();
                        JSONObject jSONObject = new JSONObject();
                        this.f68171a.a(jSONObject, "ts", Long.valueOf(currentTimeMillis));
                        q qVar = this.f68171a;
                        qVar.a(qVar.f68145f, "native_render_end", jSONObject);
                    }
                }
            });
        }
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            com.bytedance.sdk.component.utils.h.a().post(new Runnable(this) { // from class: com.bytedance.sdk.openadsdk.e.q.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ q f68182a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f68182a = this;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        long currentTimeMillis = System.currentTimeMillis();
                        JSONObject jSONObject = new JSONObject();
                        this.f68182a.a(jSONObject, "ts", Long.valueOf(currentTimeMillis));
                        q qVar = this.f68182a;
                        qVar.a(qVar.f68145f, "native_render_end", jSONObject);
                        long currentTimeMillis2 = System.currentTimeMillis();
                        JSONObject jSONObject2 = new JSONObject();
                        this.f68182a.a(jSONObject2, "ts", Long.valueOf(currentTimeMillis2));
                        q qVar2 = this.f68182a;
                        qVar2.a(qVar2.f68145f, "render_success", jSONObject2);
                    }
                }
            });
        }
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            com.bytedance.sdk.component.utils.h.a().post(new Runnable(this) { // from class: com.bytedance.sdk.openadsdk.e.q.4
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ q f68183a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f68183a = this;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        long currentTimeMillis = System.currentTimeMillis();
                        JSONObject jSONObject = new JSONObject();
                        this.f68183a.a(jSONObject, "ts", Long.valueOf(currentTimeMillis));
                        q qVar = this.f68183a;
                        qVar.a(qVar.f68145f, "webview_load_start", (Object) jSONObject, false);
                    }
                }
            });
        }
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            com.bytedance.sdk.component.utils.h.a().post(new Runnable(this) { // from class: com.bytedance.sdk.openadsdk.e.q.5
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ q f68184a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f68184a = this;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        long currentTimeMillis = System.currentTimeMillis();
                        JSONObject jSONObject = new JSONObject();
                        this.f68184a.a(jSONObject, "ts", Long.valueOf(currentTimeMillis));
                        q qVar = this.f68184a;
                        qVar.a(qVar.f68145f, "webview_load_success", jSONObject);
                    }
                }
            });
        }
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            a((JSONObject) null);
        }
    }

    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            com.bytedance.sdk.component.utils.h.a().post(new Runnable(this) { // from class: com.bytedance.sdk.openadsdk.e.q.7
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ q f68187a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f68187a = this;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        long currentTimeMillis = System.currentTimeMillis();
                        JSONObject jSONObject = new JSONObject();
                        this.f68187a.a(jSONObject, "ts", Long.valueOf(currentTimeMillis));
                        q qVar = this.f68187a;
                        qVar.a(qVar.f68145f, "native_endcard_show", jSONObject);
                    }
                }
            });
        }
    }

    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            com.bytedance.sdk.component.utils.h.a().post(new Runnable(this) { // from class: com.bytedance.sdk.openadsdk.e.q.8
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ q f68188a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f68188a = this;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        long currentTimeMillis = System.currentTimeMillis();
                        JSONObject jSONObject = new JSONObject();
                        this.f68188a.a(jSONObject, "ts", Long.valueOf(currentTimeMillis));
                        q qVar = this.f68188a;
                        qVar.a(qVar.f68145f, "native_endcard_close", jSONObject);
                    }
                }
            });
        }
    }

    public void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            com.bytedance.sdk.component.utils.h.a().post(new Runnable(this) { // from class: com.bytedance.sdk.openadsdk.e.q.9
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ q f68189a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f68189a = this;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        long currentTimeMillis = System.currentTimeMillis();
                        JSONObject jSONObject = new JSONObject();
                        this.f68189a.a(jSONObject, "ts", Long.valueOf(currentTimeMillis));
                        this.f68189a.a(jSONObject, "type", "native_enterBackground");
                        q qVar = this.f68189a;
                        qVar.a(qVar.f68146g, jSONObject);
                    }
                }
            });
        }
    }

    public void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            com.bytedance.sdk.component.utils.h.a().post(new Runnable(this) { // from class: com.bytedance.sdk.openadsdk.e.q.10
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ q f68150a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f68150a = this;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        long currentTimeMillis = System.currentTimeMillis();
                        JSONObject jSONObject = new JSONObject();
                        this.f68150a.a(jSONObject, "ts", Long.valueOf(currentTimeMillis));
                        this.f68150a.a(jSONObject, "type", "native_enterForeground");
                        q qVar = this.f68150a;
                        qVar.a(qVar.f68146g, jSONObject);
                    }
                }
            });
        }
    }

    public void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            com.bytedance.sdk.component.utils.h.a().post(new Runnable(this) { // from class: com.bytedance.sdk.openadsdk.e.q.16
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ q f68166a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f68166a = this;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        long currentTimeMillis = System.currentTimeMillis();
                        JSONObject jSONObject = new JSONObject();
                        this.f68166a.a(jSONObject, "ts", Long.valueOf(currentTimeMillis));
                        q qVar = this.f68166a;
                        qVar.a(qVar.f68145f, "no_native_render", jSONObject);
                    }
                }
            });
        }
    }

    public void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            com.bytedance.sdk.component.utils.h.a().post(new Runnable(this) { // from class: com.bytedance.sdk.openadsdk.e.q.17
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ q f68167a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f68167a = this;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        long currentTimeMillis = System.currentTimeMillis();
                        JSONObject jSONObject = new JSONObject();
                        this.f68167a.a(jSONObject, "ts", Long.valueOf(currentTimeMillis));
                        q qVar = this.f68167a;
                        qVar.a(qVar.f68145f, "render_failed", jSONObject);
                    }
                }
            });
        }
    }

    public void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
            this.f68142c = Boolean.TRUE;
        }
    }

    public void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048604, this) == null) {
            com.bytedance.sdk.component.utils.h.a().post(new Runnable(this) { // from class: com.bytedance.sdk.openadsdk.e.q.19
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ q f68170a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f68170a = this;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if ((interceptable2 == null || interceptable2.invokeV(1048576, this) == null) && this.f68170a.u() && !this.f68170a.f68148i) {
                        if (this.f68170a.f68146g != null && this.f68170a.f68146g.length() != 0) {
                            try {
                                this.f68170a.f68145f.put("native_switchBackgroundAndForeground", this.f68170a.f68146g);
                            } catch (Exception unused) {
                            }
                        }
                        if (this.f68170a.f68147h != null && this.f68170a.f68147h.length() != 0) {
                            try {
                                this.f68170a.f68145f.put("intercept_source", this.f68170a.f68147h);
                            } catch (Exception unused2) {
                            }
                        }
                        HashMap hashMap = new HashMap();
                        hashMap.put("webview_time_track", this.f68170a.f68145f);
                        if (com.bytedance.sdk.openadsdk.core.h.d().x() && this.f68170a.f68145f != null) {
                            com.bytedance.sdk.component.utils.k.b("WebviewTimeTrack", this.f68170a.f68145f.toString());
                        }
                        d.g(com.bytedance.sdk.openadsdk.core.o.a(), this.f68170a.f68141b, this.f68170a.f68140a, "webview_time_track", hashMap);
                        this.f68170a.f68148i = true;
                    }
                }
            });
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            com.bytedance.sdk.component.utils.h.a().post(new Runnable(this) { // from class: com.bytedance.sdk.openadsdk.e.q.12
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ q f68156a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f68156a = this;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        long currentTimeMillis = System.currentTimeMillis();
                        JSONObject jSONObject = new JSONObject();
                        this.f68156a.a(jSONObject, "ts", Long.valueOf(currentTimeMillis));
                        q qVar = this.f68156a;
                        qVar.a(qVar.f68145f, "render_success", jSONObject);
                    }
                }
            });
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            com.bytedance.sdk.component.utils.h.a().post(new Runnable(this) { // from class: com.bytedance.sdk.openadsdk.e.q.22
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ q f68177a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f68177a = this;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        long currentTimeMillis = System.currentTimeMillis();
                        JSONObject jSONObject = new JSONObject();
                        this.f68177a.a(jSONObject, "ts", Long.valueOf(currentTimeMillis));
                        q qVar = this.f68177a;
                        qVar.a(qVar.f68145f, "native_render_start", jSONObject);
                    }
                }
            });
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            com.bytedance.sdk.component.utils.h.a().post(new Runnable(this) { // from class: com.bytedance.sdk.openadsdk.e.q.23
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ q f68178a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f68178a = this;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        long currentTimeMillis = System.currentTimeMillis();
                        JSONObject jSONObject = new JSONObject();
                        this.f68178a.a(jSONObject, "ts", Long.valueOf(currentTimeMillis));
                        q qVar = this.f68178a;
                        qVar.a(qVar.f68145f, "dynamic_render_start", jSONObject);
                    }
                }
            });
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            com.bytedance.sdk.component.utils.h.a().post(new Runnable(this) { // from class: com.bytedance.sdk.openadsdk.e.q.24
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ q f68179a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f68179a = this;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        long currentTimeMillis = System.currentTimeMillis();
                        JSONObject jSONObject = new JSONObject();
                        this.f68179a.a(jSONObject, "ts", Long.valueOf(currentTimeMillis));
                        q qVar = this.f68179a;
                        qVar.a(qVar.f68145f, "dynamic_render_success", jSONObject);
                    }
                }
            });
        }
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            com.bytedance.sdk.component.utils.h.a().post(new Runnable(this) { // from class: com.bytedance.sdk.openadsdk.e.q.25
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ q f68180a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f68180a = this;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        long currentTimeMillis = System.currentTimeMillis();
                        JSONObject jSONObject = new JSONObject();
                        this.f68180a.a(jSONObject, "ts", Long.valueOf(currentTimeMillis));
                        q qVar = this.f68180a;
                        qVar.a(qVar.f68145f, "dynamic_render_error", jSONObject);
                    }
                }
            });
        }
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            com.bytedance.sdk.component.utils.h.a().post(new Runnable(this) { // from class: com.bytedance.sdk.openadsdk.e.q.26
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ q f68181a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f68181a = this;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        long currentTimeMillis = System.currentTimeMillis();
                        JSONObject jSONObject = new JSONObject();
                        this.f68181a.a(jSONObject, "ts", Long.valueOf(currentTimeMillis));
                        q qVar = this.f68181a;
                        qVar.a(qVar.f68145f, "before_webview_request", jSONObject);
                    }
                }
            });
        }
    }

    public void b(String str, long j2, long j3, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048585, this, new Object[]{str, Long.valueOf(j2), Long.valueOf(j3), Integer.valueOf(i2)}) == null) {
            com.bytedance.sdk.component.utils.h.a().post(new Runnable(this, str, j3, j2, i2) { // from class: com.bytedance.sdk.openadsdk.e.q.13
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ String f68157a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ long f68158b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ long f68159c;

                /* renamed from: d  reason: collision with root package name */
                public final /* synthetic */ int f68160d;

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ q f68161e;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, str, Long.valueOf(j3), Long.valueOf(j2), Integer.valueOf(i2)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i3 = newInitContext.flag;
                        if ((i3 & 1) != 0) {
                            int i4 = i3 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f68161e = this;
                    this.f68157a = str;
                    this.f68158b = j3;
                    this.f68159c = j2;
                    this.f68160d = i2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || TextUtils.isEmpty(this.f68157a) || this.f68158b < this.f68159c) {
                        return;
                    }
                    JSONObject jSONObject = new JSONObject();
                    this.f68161e.a(jSONObject, "start_ts", Long.valueOf(this.f68159c));
                    this.f68161e.a(jSONObject, "end_ts", Long.valueOf(this.f68158b));
                    this.f68161e.a(jSONObject, "intercept_type", Integer.valueOf(this.f68160d));
                    this.f68161e.a(jSONObject, "type", "intercept_js");
                    this.f68161e.a(jSONObject, "url", this.f68157a);
                    this.f68161e.a(jSONObject, "duration", Long.valueOf(this.f68158b - this.f68159c));
                    q qVar = this.f68161e;
                    qVar.a(qVar.f68147h, jSONObject);
                }
            });
        }
    }

    public void b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) {
            com.bytedance.sdk.component.utils.h.a().post(new Runnable(this, str) { // from class: com.bytedance.sdk.openadsdk.e.q.15
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ String f68164a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ q f68165b;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, str};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f68165b = this;
                    this.f68164a = str;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || TextUtils.isEmpty(this.f68164a)) {
                        return;
                    }
                    long currentTimeMillis = System.currentTimeMillis();
                    JSONObject jSONObject = new JSONObject();
                    this.f68165b.a(jSONObject, "ts", Long.valueOf(currentTimeMillis));
                    this.f68165b.a(jSONObject, "jsb", this.f68164a);
                    q qVar = this.f68165b;
                    qVar.a(qVar.f68145f, "webview_jsb_end", jSONObject);
                }
            });
        }
    }

    public void b(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, jSONObject) == null) {
            com.bytedance.sdk.component.utils.h.a().post(new Runnable(this, jSONObject) { // from class: com.bytedance.sdk.openadsdk.e.q.18
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ JSONObject f68168a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ q f68169b;

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
                    this.f68169b = this;
                    this.f68168a = jSONObject;
                }

                @Override // java.lang.Runnable
                public void run() {
                    JSONObject jSONObject2;
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || this.f68169b.f68145f == null || (jSONObject2 = this.f68168a) == null) {
                        return;
                    }
                    Iterator<String> keys = jSONObject2.keys();
                    while (keys.hasNext()) {
                        String next = keys.next();
                        q qVar = this.f68169b;
                        qVar.a(qVar.f68145f, next, this.f68168a.opt(next));
                    }
                    this.f68169b.f68143d = Boolean.TRUE;
                    this.f68169b.t();
                }
            });
        }
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            com.bytedance.sdk.component.utils.h.a().post(new Runnable(this) { // from class: com.bytedance.sdk.openadsdk.e.q.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ q f68149a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f68149a = this;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        long currentTimeMillis = System.currentTimeMillis();
                        JSONObject jSONObject = new JSONObject();
                        this.f68149a.a(jSONObject, "ts", Long.valueOf(currentTimeMillis));
                        this.f68149a.a(jSONObject, "webview_count", Integer.valueOf(com.bytedance.sdk.openadsdk.core.widget.webview.f.a().e()));
                        this.f68149a.a(jSONObject, "available_cache_count", Integer.valueOf(com.bytedance.sdk.openadsdk.core.widget.webview.f.a().d()));
                        q qVar = this.f68149a;
                        qVar.a(qVar.f68145f, "render_start", jSONObject);
                    }
                }
            });
        }
    }

    public void a(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
            com.bytedance.sdk.component.utils.h.a().post(new Runnable(this, i2) { // from class: com.bytedance.sdk.openadsdk.e.q.20
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ int f68172a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ q f68173b;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, Integer.valueOf(i2)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i3 = newInitContext.flag;
                        if ((i3 & 1) != 0) {
                            int i4 = i3 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f68173b = this;
                    this.f68172a = i2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.f68173b.a(this.f68172a, (String) null);
                    }
                }
            });
        }
    }

    public void a(int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(Constants.METHOD_SEND_USER_MSG, this, i2, str) == null) {
            com.bytedance.sdk.component.utils.h.a().post(new Runnable(this, i2, str) { // from class: com.bytedance.sdk.openadsdk.e.q.21
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ int f68174a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ String f68175b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ q f68176c;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, Integer.valueOf(i2), str};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i3 = newInitContext.flag;
                        if ((i3 & 1) != 0) {
                            int i4 = i3 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f68176c = this;
                    this.f68174a = i2;
                    this.f68175b = str;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        long currentTimeMillis = System.currentTimeMillis();
                        JSONObject jSONObject = new JSONObject();
                        this.f68176c.a(jSONObject, "ts", Long.valueOf(currentTimeMillis));
                        this.f68176c.a(jSONObject, "code", Integer.valueOf(this.f68174a));
                        String str2 = this.f68175b;
                        if (str2 != null) {
                            this.f68176c.a(jSONObject, "msg", str2);
                        }
                        q qVar = this.f68176c;
                        qVar.a(qVar.f68145f, "render_error", jSONObject);
                    }
                }
            });
        }
    }

    public void a(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, jSONObject) == null) {
            com.bytedance.sdk.component.utils.h.a().post(new Runnable(this, jSONObject) { // from class: com.bytedance.sdk.openadsdk.e.q.6
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ JSONObject f68185a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ q f68186b;

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
                    this.f68186b = this;
                    this.f68185a = jSONObject;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        JSONObject jSONObject2 = this.f68185a;
                        if (jSONObject2 == null) {
                            jSONObject2 = new JSONObject();
                        }
                        this.f68186b.a(jSONObject2, "ts", Long.valueOf(System.currentTimeMillis()));
                        q qVar = this.f68186b;
                        qVar.a(qVar.f68145f, "webview_load_error", jSONObject2);
                    }
                }
            });
        }
    }

    public void a(String str, long j2, long j3, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{str, Long.valueOf(j2), Long.valueOf(j3), Integer.valueOf(i2)}) == null) {
            com.bytedance.sdk.component.utils.h.a().post(new Runnable(this, str, j3, j2, i2) { // from class: com.bytedance.sdk.openadsdk.e.q.11
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ String f68151a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ long f68152b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ long f68153c;

                /* renamed from: d  reason: collision with root package name */
                public final /* synthetic */ int f68154d;

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ q f68155e;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, str, Long.valueOf(j3), Long.valueOf(j2), Integer.valueOf(i2)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i3 = newInitContext.flag;
                        if ((i3 & 1) != 0) {
                            int i4 = i3 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f68155e = this;
                    this.f68151a = str;
                    this.f68152b = j3;
                    this.f68153c = j2;
                    this.f68154d = i2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || TextUtils.isEmpty(this.f68151a) || this.f68152b < this.f68153c) {
                        return;
                    }
                    JSONObject jSONObject = new JSONObject();
                    this.f68155e.a(jSONObject, "start_ts", Long.valueOf(this.f68153c));
                    this.f68155e.a(jSONObject, "end_ts", Long.valueOf(this.f68152b));
                    this.f68155e.a(jSONObject, "intercept_type", Integer.valueOf(this.f68154d));
                    this.f68155e.a(jSONObject, "type", "intercept_html");
                    this.f68155e.a(jSONObject, "url", this.f68151a);
                    this.f68155e.a(jSONObject, "duration", Long.valueOf(this.f68152b - this.f68153c));
                    q qVar = this.f68155e;
                    qVar.a(qVar.f68147h, jSONObject);
                }
            });
        }
    }

    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            com.bytedance.sdk.component.utils.h.a().post(new Runnable(this, str) { // from class: com.bytedance.sdk.openadsdk.e.q.14
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ String f68162a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ q f68163b;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, str};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f68163b = this;
                    this.f68162a = str;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || TextUtils.isEmpty(this.f68162a)) {
                        return;
                    }
                    long currentTimeMillis = System.currentTimeMillis();
                    JSONObject jSONObject = new JSONObject();
                    this.f68163b.a(jSONObject, "ts", Long.valueOf(currentTimeMillis));
                    this.f68163b.a(jSONObject, "jsb", this.f68162a);
                    q qVar = this.f68163b;
                    qVar.a(qVar.f68145f, "webview_jsb_start", jSONObject);
                }
            });
        }
    }

    public q() {
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
        this.f68140a = "embeded_ad";
        Boolean bool = Boolean.FALSE;
        this.f68142c = bool;
        this.f68143d = bool;
        this.f68144e = bool;
        this.f68148i = false;
    }

    public void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            this.f68144e = Boolean.valueOf(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(JSONObject jSONObject, String str, Object obj, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65545, this, new Object[]{jSONObject, str, obj, Boolean.valueOf(z)}) == null) || jSONObject == null || TextUtils.isEmpty(str)) {
            return;
        }
        if (!z) {
            try {
                if (jSONObject.has(str)) {
                    return;
                }
            } catch (Exception unused) {
                return;
            }
        }
        jSONObject.put(str, obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(JSONObject jSONObject, String str, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65544, this, jSONObject, str, obj) == null) {
            a(jSONObject, str, obj, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(JSONArray jSONArray, Object obj) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65543, this, jSONArray, obj) == null) && jSONArray != null && jSONArray.length() < 10) {
            try {
                jSONArray.put(obj);
            } catch (Exception unused) {
            }
        }
    }
}
