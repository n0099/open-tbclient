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
/* loaded from: classes5.dex */
public class q {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f31506a;

    /* renamed from: b  reason: collision with root package name */
    public com.bytedance.sdk.openadsdk.core.e.m f31507b;

    /* renamed from: c  reason: collision with root package name */
    public Boolean f31508c;

    /* renamed from: d  reason: collision with root package name */
    public Boolean f31509d;

    /* renamed from: e  reason: collision with root package name */
    public Boolean f31510e;

    /* renamed from: f  reason: collision with root package name */
    public JSONObject f31511f;

    /* renamed from: g  reason: collision with root package name */
    public JSONArray f31512g;

    /* renamed from: h  reason: collision with root package name */
    public JSONArray f31513h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f31514i;

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
        this.f31506a = "embeded_ad";
        Boolean bool = Boolean.FALSE;
        this.f31508c = bool;
        this.f31509d = bool;
        this.f31510e = bool;
        this.f31514i = false;
        this.f31506a = str;
        this.f31507b = mVar;
        this.f31511f = new JSONObject();
        this.f31512g = new JSONArray();
        this.f31513h = new JSONArray();
        a(this.f31511f, "webview_source", Integer.valueOf(i2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65553, this)) == null) ? this.f31510e.booleanValue() || (this.f31509d.booleanValue() && this.f31508c.booleanValue()) : invokeV.booleanValue;
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            com.bytedance.sdk.component.utils.h.a().post(new Runnable(this) { // from class: com.bytedance.sdk.openadsdk.e.q.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ q f31537a;

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
                    this.f31537a = this;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        long currentTimeMillis = System.currentTimeMillis();
                        JSONObject jSONObject = new JSONObject();
                        this.f31537a.a(jSONObject, "ts", Long.valueOf(currentTimeMillis));
                        q qVar = this.f31537a;
                        qVar.a(qVar.f31511f, "native_render_end", jSONObject);
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
                public final /* synthetic */ q f31548a;

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
                    this.f31548a = this;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        long currentTimeMillis = System.currentTimeMillis();
                        JSONObject jSONObject = new JSONObject();
                        this.f31548a.a(jSONObject, "ts", Long.valueOf(currentTimeMillis));
                        q qVar = this.f31548a;
                        qVar.a(qVar.f31511f, "native_render_end", jSONObject);
                        long currentTimeMillis2 = System.currentTimeMillis();
                        JSONObject jSONObject2 = new JSONObject();
                        this.f31548a.a(jSONObject2, "ts", Long.valueOf(currentTimeMillis2));
                        q qVar2 = this.f31548a;
                        qVar2.a(qVar2.f31511f, "render_success", jSONObject2);
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
                public final /* synthetic */ q f31549a;

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
                    this.f31549a = this;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        long currentTimeMillis = System.currentTimeMillis();
                        JSONObject jSONObject = new JSONObject();
                        this.f31549a.a(jSONObject, "ts", Long.valueOf(currentTimeMillis));
                        q qVar = this.f31549a;
                        qVar.a(qVar.f31511f, "webview_load_start", (Object) jSONObject, false);
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
                public final /* synthetic */ q f31550a;

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
                    this.f31550a = this;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        long currentTimeMillis = System.currentTimeMillis();
                        JSONObject jSONObject = new JSONObject();
                        this.f31550a.a(jSONObject, "ts", Long.valueOf(currentTimeMillis));
                        q qVar = this.f31550a;
                        qVar.a(qVar.f31511f, "webview_load_success", jSONObject);
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
                public final /* synthetic */ q f31553a;

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
                    this.f31553a = this;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        long currentTimeMillis = System.currentTimeMillis();
                        JSONObject jSONObject = new JSONObject();
                        this.f31553a.a(jSONObject, "ts", Long.valueOf(currentTimeMillis));
                        q qVar = this.f31553a;
                        qVar.a(qVar.f31511f, "native_endcard_show", jSONObject);
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
                public final /* synthetic */ q f31554a;

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
                    this.f31554a = this;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        long currentTimeMillis = System.currentTimeMillis();
                        JSONObject jSONObject = new JSONObject();
                        this.f31554a.a(jSONObject, "ts", Long.valueOf(currentTimeMillis));
                        q qVar = this.f31554a;
                        qVar.a(qVar.f31511f, "native_endcard_close", jSONObject);
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
                public final /* synthetic */ q f31555a;

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
                    this.f31555a = this;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        long currentTimeMillis = System.currentTimeMillis();
                        JSONObject jSONObject = new JSONObject();
                        this.f31555a.a(jSONObject, "ts", Long.valueOf(currentTimeMillis));
                        this.f31555a.a(jSONObject, "type", "native_enterBackground");
                        q qVar = this.f31555a;
                        qVar.a(qVar.f31512g, jSONObject);
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
                public final /* synthetic */ q f31516a;

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
                    this.f31516a = this;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        long currentTimeMillis = System.currentTimeMillis();
                        JSONObject jSONObject = new JSONObject();
                        this.f31516a.a(jSONObject, "ts", Long.valueOf(currentTimeMillis));
                        this.f31516a.a(jSONObject, "type", "native_enterForeground");
                        q qVar = this.f31516a;
                        qVar.a(qVar.f31512g, jSONObject);
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
                public final /* synthetic */ q f31532a;

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
                    this.f31532a = this;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        long currentTimeMillis = System.currentTimeMillis();
                        JSONObject jSONObject = new JSONObject();
                        this.f31532a.a(jSONObject, "ts", Long.valueOf(currentTimeMillis));
                        q qVar = this.f31532a;
                        qVar.a(qVar.f31511f, "no_native_render", jSONObject);
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
                public final /* synthetic */ q f31533a;

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
                    this.f31533a = this;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        long currentTimeMillis = System.currentTimeMillis();
                        JSONObject jSONObject = new JSONObject();
                        this.f31533a.a(jSONObject, "ts", Long.valueOf(currentTimeMillis));
                        q qVar = this.f31533a;
                        qVar.a(qVar.f31511f, "render_failed", jSONObject);
                    }
                }
            });
        }
    }

    public void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
            this.f31508c = Boolean.TRUE;
        }
    }

    public void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048604, this) == null) {
            com.bytedance.sdk.component.utils.h.a().post(new Runnable(this) { // from class: com.bytedance.sdk.openadsdk.e.q.19
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ q f31536a;

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
                    this.f31536a = this;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if ((interceptable2 == null || interceptable2.invokeV(1048576, this) == null) && this.f31536a.u() && !this.f31536a.f31514i) {
                        if (this.f31536a.f31512g != null && this.f31536a.f31512g.length() != 0) {
                            try {
                                this.f31536a.f31511f.put("native_switchBackgroundAndForeground", this.f31536a.f31512g);
                            } catch (Exception unused) {
                            }
                        }
                        if (this.f31536a.f31513h != null && this.f31536a.f31513h.length() != 0) {
                            try {
                                this.f31536a.f31511f.put("intercept_source", this.f31536a.f31513h);
                            } catch (Exception unused2) {
                            }
                        }
                        HashMap hashMap = new HashMap();
                        hashMap.put("webview_time_track", this.f31536a.f31511f);
                        if (com.bytedance.sdk.openadsdk.core.h.d().x() && this.f31536a.f31511f != null) {
                            com.bytedance.sdk.component.utils.k.b("WebviewTimeTrack", this.f31536a.f31511f.toString());
                        }
                        d.g(com.bytedance.sdk.openadsdk.core.o.a(), this.f31536a.f31507b, this.f31536a.f31506a, "webview_time_track", hashMap);
                        this.f31536a.f31514i = true;
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
                public final /* synthetic */ q f31522a;

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
                    this.f31522a = this;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        long currentTimeMillis = System.currentTimeMillis();
                        JSONObject jSONObject = new JSONObject();
                        this.f31522a.a(jSONObject, "ts", Long.valueOf(currentTimeMillis));
                        q qVar = this.f31522a;
                        qVar.a(qVar.f31511f, "render_success", jSONObject);
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
                public final /* synthetic */ q f31543a;

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
                    this.f31543a = this;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        long currentTimeMillis = System.currentTimeMillis();
                        JSONObject jSONObject = new JSONObject();
                        this.f31543a.a(jSONObject, "ts", Long.valueOf(currentTimeMillis));
                        q qVar = this.f31543a;
                        qVar.a(qVar.f31511f, "native_render_start", jSONObject);
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
                public final /* synthetic */ q f31544a;

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
                    this.f31544a = this;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        long currentTimeMillis = System.currentTimeMillis();
                        JSONObject jSONObject = new JSONObject();
                        this.f31544a.a(jSONObject, "ts", Long.valueOf(currentTimeMillis));
                        q qVar = this.f31544a;
                        qVar.a(qVar.f31511f, "dynamic_render_start", jSONObject);
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
                public final /* synthetic */ q f31545a;

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
                    this.f31545a = this;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        long currentTimeMillis = System.currentTimeMillis();
                        JSONObject jSONObject = new JSONObject();
                        this.f31545a.a(jSONObject, "ts", Long.valueOf(currentTimeMillis));
                        q qVar = this.f31545a;
                        qVar.a(qVar.f31511f, "dynamic_render_success", jSONObject);
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
                public final /* synthetic */ q f31546a;

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
                    this.f31546a = this;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        long currentTimeMillis = System.currentTimeMillis();
                        JSONObject jSONObject = new JSONObject();
                        this.f31546a.a(jSONObject, "ts", Long.valueOf(currentTimeMillis));
                        q qVar = this.f31546a;
                        qVar.a(qVar.f31511f, "dynamic_render_error", jSONObject);
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
                public final /* synthetic */ q f31547a;

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
                    this.f31547a = this;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        long currentTimeMillis = System.currentTimeMillis();
                        JSONObject jSONObject = new JSONObject();
                        this.f31547a.a(jSONObject, "ts", Long.valueOf(currentTimeMillis));
                        q qVar = this.f31547a;
                        qVar.a(qVar.f31511f, "before_webview_request", jSONObject);
                    }
                }
            });
        }
    }

    public void b(String str, long j, long j2, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048585, this, new Object[]{str, Long.valueOf(j), Long.valueOf(j2), Integer.valueOf(i2)}) == null) {
            com.bytedance.sdk.component.utils.h.a().post(new Runnable(this, str, j2, j, i2) { // from class: com.bytedance.sdk.openadsdk.e.q.13
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ String f31523a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ long f31524b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ long f31525c;

                /* renamed from: d  reason: collision with root package name */
                public final /* synthetic */ int f31526d;

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ q f31527e;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, str, Long.valueOf(j2), Long.valueOf(j), Integer.valueOf(i2)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i3 = newInitContext.flag;
                        if ((i3 & 1) != 0) {
                            int i4 = i3 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f31527e = this;
                    this.f31523a = str;
                    this.f31524b = j2;
                    this.f31525c = j;
                    this.f31526d = i2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || TextUtils.isEmpty(this.f31523a) || this.f31524b < this.f31525c) {
                        return;
                    }
                    JSONObject jSONObject = new JSONObject();
                    this.f31527e.a(jSONObject, "start_ts", Long.valueOf(this.f31525c));
                    this.f31527e.a(jSONObject, "end_ts", Long.valueOf(this.f31524b));
                    this.f31527e.a(jSONObject, "intercept_type", Integer.valueOf(this.f31526d));
                    this.f31527e.a(jSONObject, "type", "intercept_js");
                    this.f31527e.a(jSONObject, "url", this.f31523a);
                    this.f31527e.a(jSONObject, "duration", Long.valueOf(this.f31524b - this.f31525c));
                    q qVar = this.f31527e;
                    qVar.a(qVar.f31513h, jSONObject);
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
                public final /* synthetic */ String f31530a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ q f31531b;

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
                    this.f31531b = this;
                    this.f31530a = str;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || TextUtils.isEmpty(this.f31530a)) {
                        return;
                    }
                    long currentTimeMillis = System.currentTimeMillis();
                    JSONObject jSONObject = new JSONObject();
                    this.f31531b.a(jSONObject, "ts", Long.valueOf(currentTimeMillis));
                    this.f31531b.a(jSONObject, "jsb", this.f31530a);
                    q qVar = this.f31531b;
                    qVar.a(qVar.f31511f, "webview_jsb_end", jSONObject);
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
                public final /* synthetic */ JSONObject f31534a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ q f31535b;

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
                    this.f31535b = this;
                    this.f31534a = jSONObject;
                }

                @Override // java.lang.Runnable
                public void run() {
                    JSONObject jSONObject2;
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || this.f31535b.f31511f == null || (jSONObject2 = this.f31534a) == null) {
                        return;
                    }
                    Iterator<String> keys = jSONObject2.keys();
                    while (keys.hasNext()) {
                        String next = keys.next();
                        q qVar = this.f31535b;
                        qVar.a(qVar.f31511f, next, this.f31534a.opt(next));
                    }
                    this.f31535b.f31509d = Boolean.TRUE;
                    this.f31535b.t();
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
                public final /* synthetic */ q f31515a;

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
                    this.f31515a = this;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        long currentTimeMillis = System.currentTimeMillis();
                        JSONObject jSONObject = new JSONObject();
                        this.f31515a.a(jSONObject, "ts", Long.valueOf(currentTimeMillis));
                        this.f31515a.a(jSONObject, "webview_count", Integer.valueOf(com.bytedance.sdk.openadsdk.core.widget.webview.f.a().e()));
                        this.f31515a.a(jSONObject, "available_cache_count", Integer.valueOf(com.bytedance.sdk.openadsdk.core.widget.webview.f.a().d()));
                        q qVar = this.f31515a;
                        qVar.a(qVar.f31511f, "render_start", jSONObject);
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
                public final /* synthetic */ int f31538a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ q f31539b;

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
                    this.f31539b = this;
                    this.f31538a = i2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.f31539b.a(this.f31538a, (String) null);
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
                public final /* synthetic */ int f31540a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ String f31541b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ q f31542c;

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
                    this.f31542c = this;
                    this.f31540a = i2;
                    this.f31541b = str;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        long currentTimeMillis = System.currentTimeMillis();
                        JSONObject jSONObject = new JSONObject();
                        this.f31542c.a(jSONObject, "ts", Long.valueOf(currentTimeMillis));
                        this.f31542c.a(jSONObject, "code", Integer.valueOf(this.f31540a));
                        String str2 = this.f31541b;
                        if (str2 != null) {
                            this.f31542c.a(jSONObject, "msg", str2);
                        }
                        q qVar = this.f31542c;
                        qVar.a(qVar.f31511f, "render_error", jSONObject);
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
                public final /* synthetic */ JSONObject f31551a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ q f31552b;

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
                    this.f31552b = this;
                    this.f31551a = jSONObject;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        JSONObject jSONObject2 = this.f31551a;
                        if (jSONObject2 == null) {
                            jSONObject2 = new JSONObject();
                        }
                        this.f31552b.a(jSONObject2, "ts", Long.valueOf(System.currentTimeMillis()));
                        q qVar = this.f31552b;
                        qVar.a(qVar.f31511f, "webview_load_error", jSONObject2);
                    }
                }
            });
        }
    }

    public void a(String str, long j, long j2, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{str, Long.valueOf(j), Long.valueOf(j2), Integer.valueOf(i2)}) == null) {
            com.bytedance.sdk.component.utils.h.a().post(new Runnable(this, str, j2, j, i2) { // from class: com.bytedance.sdk.openadsdk.e.q.11
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ String f31517a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ long f31518b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ long f31519c;

                /* renamed from: d  reason: collision with root package name */
                public final /* synthetic */ int f31520d;

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ q f31521e;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, str, Long.valueOf(j2), Long.valueOf(j), Integer.valueOf(i2)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i3 = newInitContext.flag;
                        if ((i3 & 1) != 0) {
                            int i4 = i3 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f31521e = this;
                    this.f31517a = str;
                    this.f31518b = j2;
                    this.f31519c = j;
                    this.f31520d = i2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || TextUtils.isEmpty(this.f31517a) || this.f31518b < this.f31519c) {
                        return;
                    }
                    JSONObject jSONObject = new JSONObject();
                    this.f31521e.a(jSONObject, "start_ts", Long.valueOf(this.f31519c));
                    this.f31521e.a(jSONObject, "end_ts", Long.valueOf(this.f31518b));
                    this.f31521e.a(jSONObject, "intercept_type", Integer.valueOf(this.f31520d));
                    this.f31521e.a(jSONObject, "type", "intercept_html");
                    this.f31521e.a(jSONObject, "url", this.f31517a);
                    this.f31521e.a(jSONObject, "duration", Long.valueOf(this.f31518b - this.f31519c));
                    q qVar = this.f31521e;
                    qVar.a(qVar.f31513h, jSONObject);
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
                public final /* synthetic */ String f31528a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ q f31529b;

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
                    this.f31529b = this;
                    this.f31528a = str;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || TextUtils.isEmpty(this.f31528a)) {
                        return;
                    }
                    long currentTimeMillis = System.currentTimeMillis();
                    JSONObject jSONObject = new JSONObject();
                    this.f31529b.a(jSONObject, "ts", Long.valueOf(currentTimeMillis));
                    this.f31529b.a(jSONObject, "jsb", this.f31528a);
                    q qVar = this.f31529b;
                    qVar.a(qVar.f31511f, "webview_jsb_start", jSONObject);
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
        this.f31506a = "embeded_ad";
        Boolean bool = Boolean.FALSE;
        this.f31508c = bool;
        this.f31509d = bool;
        this.f31510e = bool;
        this.f31514i = false;
    }

    public void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            this.f31510e = Boolean.valueOf(z);
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
