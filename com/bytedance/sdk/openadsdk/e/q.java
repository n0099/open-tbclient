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
    public String f67649a;

    /* renamed from: b  reason: collision with root package name */
    public com.bytedance.sdk.openadsdk.core.e.m f67650b;

    /* renamed from: c  reason: collision with root package name */
    public Boolean f67651c;

    /* renamed from: d  reason: collision with root package name */
    public Boolean f67652d;

    /* renamed from: e  reason: collision with root package name */
    public Boolean f67653e;

    /* renamed from: f  reason: collision with root package name */
    public JSONObject f67654f;

    /* renamed from: g  reason: collision with root package name */
    public JSONArray f67655g;

    /* renamed from: h  reason: collision with root package name */
    public JSONArray f67656h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f67657i;

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
        this.f67649a = "embeded_ad";
        Boolean bool = Boolean.FALSE;
        this.f67651c = bool;
        this.f67652d = bool;
        this.f67653e = bool;
        this.f67657i = false;
        this.f67649a = str;
        this.f67650b = mVar;
        this.f67654f = new JSONObject();
        this.f67655g = new JSONArray();
        this.f67656h = new JSONArray();
        a(this.f67654f, "webview_source", Integer.valueOf(i2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65553, this)) == null) ? this.f67653e.booleanValue() || (this.f67652d.booleanValue() && this.f67651c.booleanValue()) : invokeV.booleanValue;
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            com.bytedance.sdk.component.utils.h.a().post(new Runnable(this) { // from class: com.bytedance.sdk.openadsdk.e.q.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ q f67680a;

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
                    this.f67680a = this;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        long currentTimeMillis = System.currentTimeMillis();
                        JSONObject jSONObject = new JSONObject();
                        this.f67680a.a(jSONObject, "ts", Long.valueOf(currentTimeMillis));
                        q qVar = this.f67680a;
                        qVar.a(qVar.f67654f, "native_render_end", jSONObject);
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
                public final /* synthetic */ q f67691a;

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
                    this.f67691a = this;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        long currentTimeMillis = System.currentTimeMillis();
                        JSONObject jSONObject = new JSONObject();
                        this.f67691a.a(jSONObject, "ts", Long.valueOf(currentTimeMillis));
                        q qVar = this.f67691a;
                        qVar.a(qVar.f67654f, "native_render_end", jSONObject);
                        long currentTimeMillis2 = System.currentTimeMillis();
                        JSONObject jSONObject2 = new JSONObject();
                        this.f67691a.a(jSONObject2, "ts", Long.valueOf(currentTimeMillis2));
                        q qVar2 = this.f67691a;
                        qVar2.a(qVar2.f67654f, "render_success", jSONObject2);
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
                public final /* synthetic */ q f67692a;

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
                    this.f67692a = this;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        long currentTimeMillis = System.currentTimeMillis();
                        JSONObject jSONObject = new JSONObject();
                        this.f67692a.a(jSONObject, "ts", Long.valueOf(currentTimeMillis));
                        q qVar = this.f67692a;
                        qVar.a(qVar.f67654f, "webview_load_start", (Object) jSONObject, false);
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
                public final /* synthetic */ q f67693a;

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
                    this.f67693a = this;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        long currentTimeMillis = System.currentTimeMillis();
                        JSONObject jSONObject = new JSONObject();
                        this.f67693a.a(jSONObject, "ts", Long.valueOf(currentTimeMillis));
                        q qVar = this.f67693a;
                        qVar.a(qVar.f67654f, "webview_load_success", jSONObject);
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
                public final /* synthetic */ q f67696a;

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
                    this.f67696a = this;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        long currentTimeMillis = System.currentTimeMillis();
                        JSONObject jSONObject = new JSONObject();
                        this.f67696a.a(jSONObject, "ts", Long.valueOf(currentTimeMillis));
                        q qVar = this.f67696a;
                        qVar.a(qVar.f67654f, "native_endcard_show", jSONObject);
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
                public final /* synthetic */ q f67697a;

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
                    this.f67697a = this;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        long currentTimeMillis = System.currentTimeMillis();
                        JSONObject jSONObject = new JSONObject();
                        this.f67697a.a(jSONObject, "ts", Long.valueOf(currentTimeMillis));
                        q qVar = this.f67697a;
                        qVar.a(qVar.f67654f, "native_endcard_close", jSONObject);
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
                public final /* synthetic */ q f67698a;

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
                    this.f67698a = this;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        long currentTimeMillis = System.currentTimeMillis();
                        JSONObject jSONObject = new JSONObject();
                        this.f67698a.a(jSONObject, "ts", Long.valueOf(currentTimeMillis));
                        this.f67698a.a(jSONObject, "type", "native_enterBackground");
                        q qVar = this.f67698a;
                        qVar.a(qVar.f67655g, jSONObject);
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
                public final /* synthetic */ q f67659a;

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
                    this.f67659a = this;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        long currentTimeMillis = System.currentTimeMillis();
                        JSONObject jSONObject = new JSONObject();
                        this.f67659a.a(jSONObject, "ts", Long.valueOf(currentTimeMillis));
                        this.f67659a.a(jSONObject, "type", "native_enterForeground");
                        q qVar = this.f67659a;
                        qVar.a(qVar.f67655g, jSONObject);
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
                public final /* synthetic */ q f67675a;

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
                    this.f67675a = this;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        long currentTimeMillis = System.currentTimeMillis();
                        JSONObject jSONObject = new JSONObject();
                        this.f67675a.a(jSONObject, "ts", Long.valueOf(currentTimeMillis));
                        q qVar = this.f67675a;
                        qVar.a(qVar.f67654f, "no_native_render", jSONObject);
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
                public final /* synthetic */ q f67676a;

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
                    this.f67676a = this;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        long currentTimeMillis = System.currentTimeMillis();
                        JSONObject jSONObject = new JSONObject();
                        this.f67676a.a(jSONObject, "ts", Long.valueOf(currentTimeMillis));
                        q qVar = this.f67676a;
                        qVar.a(qVar.f67654f, "render_failed", jSONObject);
                    }
                }
            });
        }
    }

    public void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
            this.f67651c = Boolean.TRUE;
        }
    }

    public void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048604, this) == null) {
            com.bytedance.sdk.component.utils.h.a().post(new Runnable(this) { // from class: com.bytedance.sdk.openadsdk.e.q.19
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ q f67679a;

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
                    this.f67679a = this;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if ((interceptable2 == null || interceptable2.invokeV(1048576, this) == null) && this.f67679a.u() && !this.f67679a.f67657i) {
                        if (this.f67679a.f67655g != null && this.f67679a.f67655g.length() != 0) {
                            try {
                                this.f67679a.f67654f.put("native_switchBackgroundAndForeground", this.f67679a.f67655g);
                            } catch (Exception unused) {
                            }
                        }
                        if (this.f67679a.f67656h != null && this.f67679a.f67656h.length() != 0) {
                            try {
                                this.f67679a.f67654f.put("intercept_source", this.f67679a.f67656h);
                            } catch (Exception unused2) {
                            }
                        }
                        HashMap hashMap = new HashMap();
                        hashMap.put("webview_time_track", this.f67679a.f67654f);
                        if (com.bytedance.sdk.openadsdk.core.h.d().x() && this.f67679a.f67654f != null) {
                            com.bytedance.sdk.component.utils.k.b("WebviewTimeTrack", this.f67679a.f67654f.toString());
                        }
                        d.g(com.bytedance.sdk.openadsdk.core.o.a(), this.f67679a.f67650b, this.f67679a.f67649a, "webview_time_track", hashMap);
                        this.f67679a.f67657i = true;
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
                public final /* synthetic */ q f67665a;

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
                    this.f67665a = this;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        long currentTimeMillis = System.currentTimeMillis();
                        JSONObject jSONObject = new JSONObject();
                        this.f67665a.a(jSONObject, "ts", Long.valueOf(currentTimeMillis));
                        q qVar = this.f67665a;
                        qVar.a(qVar.f67654f, "render_success", jSONObject);
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
                public final /* synthetic */ q f67686a;

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
                    this.f67686a = this;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        long currentTimeMillis = System.currentTimeMillis();
                        JSONObject jSONObject = new JSONObject();
                        this.f67686a.a(jSONObject, "ts", Long.valueOf(currentTimeMillis));
                        q qVar = this.f67686a;
                        qVar.a(qVar.f67654f, "native_render_start", jSONObject);
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
                public final /* synthetic */ q f67687a;

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
                    this.f67687a = this;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        long currentTimeMillis = System.currentTimeMillis();
                        JSONObject jSONObject = new JSONObject();
                        this.f67687a.a(jSONObject, "ts", Long.valueOf(currentTimeMillis));
                        q qVar = this.f67687a;
                        qVar.a(qVar.f67654f, "dynamic_render_start", jSONObject);
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
                public final /* synthetic */ q f67688a;

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
                    this.f67688a = this;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        long currentTimeMillis = System.currentTimeMillis();
                        JSONObject jSONObject = new JSONObject();
                        this.f67688a.a(jSONObject, "ts", Long.valueOf(currentTimeMillis));
                        q qVar = this.f67688a;
                        qVar.a(qVar.f67654f, "dynamic_render_success", jSONObject);
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
                public final /* synthetic */ q f67689a;

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
                    this.f67689a = this;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        long currentTimeMillis = System.currentTimeMillis();
                        JSONObject jSONObject = new JSONObject();
                        this.f67689a.a(jSONObject, "ts", Long.valueOf(currentTimeMillis));
                        q qVar = this.f67689a;
                        qVar.a(qVar.f67654f, "dynamic_render_error", jSONObject);
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
                public final /* synthetic */ q f67690a;

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
                    this.f67690a = this;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        long currentTimeMillis = System.currentTimeMillis();
                        JSONObject jSONObject = new JSONObject();
                        this.f67690a.a(jSONObject, "ts", Long.valueOf(currentTimeMillis));
                        q qVar = this.f67690a;
                        qVar.a(qVar.f67654f, "before_webview_request", jSONObject);
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
                public final /* synthetic */ String f67666a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ long f67667b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ long f67668c;

                /* renamed from: d  reason: collision with root package name */
                public final /* synthetic */ int f67669d;

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ q f67670e;

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
                    this.f67670e = this;
                    this.f67666a = str;
                    this.f67667b = j3;
                    this.f67668c = j2;
                    this.f67669d = i2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || TextUtils.isEmpty(this.f67666a) || this.f67667b < this.f67668c) {
                        return;
                    }
                    JSONObject jSONObject = new JSONObject();
                    this.f67670e.a(jSONObject, "start_ts", Long.valueOf(this.f67668c));
                    this.f67670e.a(jSONObject, "end_ts", Long.valueOf(this.f67667b));
                    this.f67670e.a(jSONObject, "intercept_type", Integer.valueOf(this.f67669d));
                    this.f67670e.a(jSONObject, "type", "intercept_js");
                    this.f67670e.a(jSONObject, "url", this.f67666a);
                    this.f67670e.a(jSONObject, "duration", Long.valueOf(this.f67667b - this.f67668c));
                    q qVar = this.f67670e;
                    qVar.a(qVar.f67656h, jSONObject);
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
                public final /* synthetic */ String f67673a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ q f67674b;

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
                    this.f67674b = this;
                    this.f67673a = str;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || TextUtils.isEmpty(this.f67673a)) {
                        return;
                    }
                    long currentTimeMillis = System.currentTimeMillis();
                    JSONObject jSONObject = new JSONObject();
                    this.f67674b.a(jSONObject, "ts", Long.valueOf(currentTimeMillis));
                    this.f67674b.a(jSONObject, "jsb", this.f67673a);
                    q qVar = this.f67674b;
                    qVar.a(qVar.f67654f, "webview_jsb_end", jSONObject);
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
                public final /* synthetic */ JSONObject f67677a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ q f67678b;

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
                    this.f67678b = this;
                    this.f67677a = jSONObject;
                }

                @Override // java.lang.Runnable
                public void run() {
                    JSONObject jSONObject2;
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || this.f67678b.f67654f == null || (jSONObject2 = this.f67677a) == null) {
                        return;
                    }
                    Iterator<String> keys = jSONObject2.keys();
                    while (keys.hasNext()) {
                        String next = keys.next();
                        q qVar = this.f67678b;
                        qVar.a(qVar.f67654f, next, this.f67677a.opt(next));
                    }
                    this.f67678b.f67652d = Boolean.TRUE;
                    this.f67678b.t();
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
                public final /* synthetic */ q f67658a;

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
                    this.f67658a = this;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        long currentTimeMillis = System.currentTimeMillis();
                        JSONObject jSONObject = new JSONObject();
                        this.f67658a.a(jSONObject, "ts", Long.valueOf(currentTimeMillis));
                        this.f67658a.a(jSONObject, "webview_count", Integer.valueOf(com.bytedance.sdk.openadsdk.core.widget.webview.f.a().e()));
                        this.f67658a.a(jSONObject, "available_cache_count", Integer.valueOf(com.bytedance.sdk.openadsdk.core.widget.webview.f.a().d()));
                        q qVar = this.f67658a;
                        qVar.a(qVar.f67654f, "render_start", jSONObject);
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
                public final /* synthetic */ int f67681a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ q f67682b;

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
                    this.f67682b = this;
                    this.f67681a = i2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.f67682b.a(this.f67681a, (String) null);
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
                public final /* synthetic */ int f67683a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ String f67684b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ q f67685c;

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
                    this.f67685c = this;
                    this.f67683a = i2;
                    this.f67684b = str;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        long currentTimeMillis = System.currentTimeMillis();
                        JSONObject jSONObject = new JSONObject();
                        this.f67685c.a(jSONObject, "ts", Long.valueOf(currentTimeMillis));
                        this.f67685c.a(jSONObject, "code", Integer.valueOf(this.f67683a));
                        String str2 = this.f67684b;
                        if (str2 != null) {
                            this.f67685c.a(jSONObject, "msg", str2);
                        }
                        q qVar = this.f67685c;
                        qVar.a(qVar.f67654f, "render_error", jSONObject);
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
                public final /* synthetic */ JSONObject f67694a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ q f67695b;

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
                    this.f67695b = this;
                    this.f67694a = jSONObject;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        JSONObject jSONObject2 = this.f67694a;
                        if (jSONObject2 == null) {
                            jSONObject2 = new JSONObject();
                        }
                        this.f67695b.a(jSONObject2, "ts", Long.valueOf(System.currentTimeMillis()));
                        q qVar = this.f67695b;
                        qVar.a(qVar.f67654f, "webview_load_error", jSONObject2);
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
                public final /* synthetic */ String f67660a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ long f67661b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ long f67662c;

                /* renamed from: d  reason: collision with root package name */
                public final /* synthetic */ int f67663d;

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ q f67664e;

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
                    this.f67664e = this;
                    this.f67660a = str;
                    this.f67661b = j3;
                    this.f67662c = j2;
                    this.f67663d = i2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || TextUtils.isEmpty(this.f67660a) || this.f67661b < this.f67662c) {
                        return;
                    }
                    JSONObject jSONObject = new JSONObject();
                    this.f67664e.a(jSONObject, "start_ts", Long.valueOf(this.f67662c));
                    this.f67664e.a(jSONObject, "end_ts", Long.valueOf(this.f67661b));
                    this.f67664e.a(jSONObject, "intercept_type", Integer.valueOf(this.f67663d));
                    this.f67664e.a(jSONObject, "type", "intercept_html");
                    this.f67664e.a(jSONObject, "url", this.f67660a);
                    this.f67664e.a(jSONObject, "duration", Long.valueOf(this.f67661b - this.f67662c));
                    q qVar = this.f67664e;
                    qVar.a(qVar.f67656h, jSONObject);
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
                public final /* synthetic */ String f67671a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ q f67672b;

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
                    this.f67672b = this;
                    this.f67671a = str;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || TextUtils.isEmpty(this.f67671a)) {
                        return;
                    }
                    long currentTimeMillis = System.currentTimeMillis();
                    JSONObject jSONObject = new JSONObject();
                    this.f67672b.a(jSONObject, "ts", Long.valueOf(currentTimeMillis));
                    this.f67672b.a(jSONObject, "jsb", this.f67671a);
                    q qVar = this.f67672b;
                    qVar.a(qVar.f67654f, "webview_jsb_start", jSONObject);
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
        this.f67649a = "embeded_ad";
        Boolean bool = Boolean.FALSE;
        this.f67651c = bool;
        this.f67652d = bool;
        this.f67653e = bool;
        this.f67657i = false;
    }

    public void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            this.f67653e = Boolean.valueOf(z);
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
