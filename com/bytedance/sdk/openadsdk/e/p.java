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
public class p {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f31263a;

    /* renamed from: b  reason: collision with root package name */
    public com.bytedance.sdk.openadsdk.core.e.m f31264b;

    /* renamed from: c  reason: collision with root package name */
    public Boolean f31265c;

    /* renamed from: d  reason: collision with root package name */
    public Boolean f31266d;

    /* renamed from: e  reason: collision with root package name */
    public Boolean f31267e;

    /* renamed from: f  reason: collision with root package name */
    public JSONObject f31268f;

    /* renamed from: g  reason: collision with root package name */
    public JSONArray f31269g;

    /* renamed from: h  reason: collision with root package name */
    public JSONArray f31270h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f31271i;
    public final Object j;

    public p(int i2, String str, com.bytedance.sdk.openadsdk.core.e.m mVar) {
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
        this.f31263a = "embeded_ad";
        Boolean bool = Boolean.FALSE;
        this.f31265c = bool;
        this.f31266d = bool;
        this.f31267e = bool;
        this.f31271i = false;
        this.j = new Object();
        this.f31263a = str;
        this.f31264b = mVar;
        this.f31268f = new JSONObject();
        this.f31269g = new JSONArray();
        this.f31270h = new JSONArray();
        a(this.f31268f, "webview_source", Integer.valueOf(i2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65554, this)) == null) ? this.f31267e.booleanValue() || (this.f31266d.booleanValue() && this.f31265c.booleanValue()) : invokeV.booleanValue;
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            com.bytedance.sdk.component.e.e.b(new com.bytedance.sdk.component.e.g(this, "onWebviewLoadStart") { // from class: com.bytedance.sdk.openadsdk.e.p.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ p f31304a;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(r8);
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, r8};
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
                    this.f31304a = this;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        synchronized (this.f31304a.j) {
                            long currentTimeMillis = System.currentTimeMillis();
                            JSONObject jSONObject = new JSONObject();
                            this.f31304a.a(jSONObject, "ts", Long.valueOf(currentTimeMillis));
                            this.f31304a.a(this.f31304a.f31268f, "webview_load_start", (Object) jSONObject, false);
                        }
                    }
                }
            });
        }
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            com.bytedance.sdk.component.e.e.b(new com.bytedance.sdk.component.e.g(this, "onWebviewLoadSuc") { // from class: com.bytedance.sdk.openadsdk.e.p.4
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ p f31305a;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(r8);
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, r8};
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
                    this.f31305a = this;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        synchronized (this.f31305a.j) {
                            long currentTimeMillis = System.currentTimeMillis();
                            JSONObject jSONObject = new JSONObject();
                            this.f31305a.a(jSONObject, "ts", Long.valueOf(currentTimeMillis));
                            this.f31305a.a(this.f31305a.f31268f, "webview_load_success", jSONObject);
                        }
                    }
                }
            });
        }
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            a((JSONObject) null);
        }
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            com.bytedance.sdk.component.e.e.b(new com.bytedance.sdk.component.e.g(this, "onNativeEndCardShow") { // from class: com.bytedance.sdk.openadsdk.e.p.6
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ p f31308a;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(r8);
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, r8};
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
                    this.f31308a = this;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        synchronized (this.f31308a.j) {
                            long currentTimeMillis = System.currentTimeMillis();
                            JSONObject jSONObject = new JSONObject();
                            this.f31308a.a(jSONObject, "ts", Long.valueOf(currentTimeMillis));
                            this.f31308a.a(this.f31308a.f31268f, "native_endcard_show", jSONObject);
                        }
                    }
                }
            });
        }
    }

    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            com.bytedance.sdk.component.e.e.b(new com.bytedance.sdk.component.e.g(this, "onNativeEndCardClose") { // from class: com.bytedance.sdk.openadsdk.e.p.7
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ p f31309a;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(r8);
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, r8};
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
                    this.f31309a = this;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        synchronized (this.f31309a.j) {
                            long currentTimeMillis = System.currentTimeMillis();
                            JSONObject jSONObject = new JSONObject();
                            this.f31309a.a(jSONObject, "ts", Long.valueOf(currentTimeMillis));
                            this.f31309a.a(this.f31309a.f31268f, "native_endcard_close", jSONObject);
                        }
                    }
                }
            });
        }
    }

    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            com.bytedance.sdk.component.e.e.b(new com.bytedance.sdk.component.e.g(this, "onNativeEnterBackground") { // from class: com.bytedance.sdk.openadsdk.e.p.8
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ p f31310a;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(r8);
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, r8};
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
                    this.f31310a = this;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        synchronized (this.f31310a.j) {
                            long currentTimeMillis = System.currentTimeMillis();
                            JSONObject jSONObject = new JSONObject();
                            this.f31310a.a(jSONObject, "ts", Long.valueOf(currentTimeMillis));
                            this.f31310a.a(jSONObject, "type", "native_enterBackground");
                            this.f31310a.a(this.f31310a.f31269g, jSONObject);
                        }
                    }
                }
            });
        }
    }

    public void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            com.bytedance.sdk.component.e.e.b(new com.bytedance.sdk.component.e.g(this, "onNativeEnterForeground") { // from class: com.bytedance.sdk.openadsdk.e.p.9
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ p f31311a;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(r8);
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, r8};
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
                    this.f31311a = this;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        synchronized (this.f31311a.j) {
                            long currentTimeMillis = System.currentTimeMillis();
                            JSONObject jSONObject = new JSONObject();
                            this.f31311a.a(jSONObject, "ts", Long.valueOf(currentTimeMillis));
                            this.f31311a.a(jSONObject, "type", "native_enterForeground");
                            this.f31311a.a(this.f31311a.f31269g, jSONObject);
                        }
                    }
                }
            });
        }
    }

    public void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            com.bytedance.sdk.component.e.e.b(new com.bytedance.sdk.component.e.g(this, "onNoNativeRender") { // from class: com.bytedance.sdk.openadsdk.e.p.15
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ p f31288a;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(r8);
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, r8};
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
                    this.f31288a = this;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        synchronized (this.f31288a.j) {
                            long currentTimeMillis = System.currentTimeMillis();
                            JSONObject jSONObject = new JSONObject();
                            this.f31288a.a(jSONObject, "ts", Long.valueOf(currentTimeMillis));
                            this.f31288a.a(this.f31288a.f31268f, "no_native_render", jSONObject);
                        }
                    }
                }
            });
        }
    }

    public void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            com.bytedance.sdk.component.e.e.b(new com.bytedance.sdk.component.e.g(this, "onRenderFailed") { // from class: com.bytedance.sdk.openadsdk.e.p.16
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ p f31289a;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(r8);
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, r8};
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
                    this.f31289a = this;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        synchronized (this.f31289a.j) {
                            long currentTimeMillis = System.currentTimeMillis();
                            JSONObject jSONObject = new JSONObject();
                            this.f31289a.a(jSONObject, "ts", Long.valueOf(currentTimeMillis));
                            this.f31289a.a(this.f31289a.f31268f, "render_failed", jSONObject);
                        }
                    }
                }
            });
        }
    }

    public void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            this.f31265c = Boolean.TRUE;
        }
    }

    public void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
            com.bytedance.sdk.component.e.e.a(new com.bytedance.sdk.component.e.g(this, "trySendTrackInfo") { // from class: com.bytedance.sdk.openadsdk.e.p.18
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ p f31292a;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(r8);
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, r8};
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
                    this.f31292a = this;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        synchronized (this.f31292a.j) {
                            if (this.f31292a.t()) {
                                if (this.f31292a.f31271i) {
                                    return;
                                }
                                if (this.f31292a.f31269g != null && this.f31292a.f31269g.length() != 0) {
                                    try {
                                        this.f31292a.f31268f.put("native_switchBackgroundAndForeground", this.f31292a.f31269g);
                                    } catch (Exception unused) {
                                    }
                                }
                                if (this.f31292a.f31270h != null && this.f31292a.f31270h.length() != 0) {
                                    try {
                                        this.f31292a.f31268f.put("intercept_source", this.f31292a.f31270h);
                                    } catch (Exception unused2) {
                                    }
                                }
                                HashMap hashMap = new HashMap();
                                hashMap.put("webview_time_track", this.f31292a.f31268f);
                                if (com.bytedance.sdk.openadsdk.core.h.d().x() && this.f31292a.f31268f != null) {
                                    com.bytedance.sdk.component.utils.j.b("WebviewTimeTrack", this.f31292a.f31268f.toString());
                                }
                                d.h(com.bytedance.sdk.openadsdk.core.o.a(), this.f31292a.f31264b, this.f31292a.f31263a, "webview_time_track", hashMap);
                                this.f31292a.f31271i = true;
                            }
                        }
                    }
                }
            });
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            com.bytedance.sdk.component.e.e.b(new com.bytedance.sdk.component.e.g(this, "onRenderSuc") { // from class: com.bytedance.sdk.openadsdk.e.p.12
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ p f31283a;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(r8);
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, r8};
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
                    this.f31283a = this;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        synchronized (this.f31283a.j) {
                            long currentTimeMillis = System.currentTimeMillis();
                            JSONObject jSONObject = new JSONObject();
                            this.f31283a.a(jSONObject, "ts", Long.valueOf(currentTimeMillis));
                            this.f31283a.a(this.f31283a.f31268f, "render_success", jSONObject);
                        }
                    }
                }
            });
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            com.bytedance.sdk.component.e.e.b(new com.bytedance.sdk.component.e.g(this, "onNativeRenderStart") { // from class: com.bytedance.sdk.openadsdk.e.p.21
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ p f31299a;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(r8);
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, r8};
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
                    this.f31299a = this;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        synchronized (this.f31299a.j) {
                            long currentTimeMillis = System.currentTimeMillis();
                            JSONObject jSONObject = new JSONObject();
                            this.f31299a.a(jSONObject, "ts", Long.valueOf(currentTimeMillis));
                            this.f31299a.a(this.f31299a.f31268f, "native_render_start", jSONObject);
                        }
                    }
                }
            });
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            com.bytedance.sdk.component.e.e.b(new com.bytedance.sdk.component.e.g(this, "onDynamicRenderStart") { // from class: com.bytedance.sdk.openadsdk.e.p.22
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ p f31300a;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(r8);
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, r8};
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
                    this.f31300a = this;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        synchronized (this.f31300a.j) {
                            long currentTimeMillis = System.currentTimeMillis();
                            JSONObject jSONObject = new JSONObject();
                            this.f31300a.a(jSONObject, "ts", Long.valueOf(currentTimeMillis));
                            this.f31300a.a(this.f31300a.f31268f, "dynamic_render_start", jSONObject);
                        }
                    }
                }
            });
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            com.bytedance.sdk.component.e.e.b(new com.bytedance.sdk.component.e.g(this, "onDynamicRenderSuc") { // from class: com.bytedance.sdk.openadsdk.e.p.23
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ p f31301a;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(r8);
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, r8};
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
                    this.f31301a = this;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        synchronized (this.f31301a.j) {
                            long currentTimeMillis = System.currentTimeMillis();
                            JSONObject jSONObject = new JSONObject();
                            this.f31301a.a(jSONObject, "ts", Long.valueOf(currentTimeMillis));
                            this.f31301a.a(this.f31301a.f31268f, "dynamic_render_success", jSONObject);
                        }
                    }
                }
            });
        }
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            com.bytedance.sdk.component.e.e.b(new com.bytedance.sdk.component.e.g(this, "onDynamicRenderError") { // from class: com.bytedance.sdk.openadsdk.e.p.24
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ p f31302a;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(r8);
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, r8};
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
                    this.f31302a = this;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        synchronized (this.f31302a.j) {
                            long currentTimeMillis = System.currentTimeMillis();
                            JSONObject jSONObject = new JSONObject();
                            this.f31302a.a(jSONObject, "ts", Long.valueOf(currentTimeMillis));
                            this.f31302a.a(this.f31302a.f31268f, "dynamic_render_error", jSONObject);
                        }
                    }
                }
            });
        }
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            com.bytedance.sdk.component.e.e.b(new com.bytedance.sdk.component.e.g(this, "onBeforeWebViewRequest") { // from class: com.bytedance.sdk.openadsdk.e.p.25
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ p f31303a;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(r8);
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, r8};
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
                    this.f31303a = this;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        synchronized (this.f31303a.j) {
                            long currentTimeMillis = System.currentTimeMillis();
                            JSONObject jSONObject = new JSONObject();
                            this.f31303a.a(jSONObject, "ts", Long.valueOf(currentTimeMillis));
                            this.f31303a.a(this.f31303a.f31268f, "before_webview_request", jSONObject);
                        }
                    }
                }
            });
        }
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            com.bytedance.sdk.component.e.e.b(new com.bytedance.sdk.component.e.g(this, "onNativeRenderEnd") { // from class: com.bytedance.sdk.openadsdk.e.p.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ p f31295a;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(r8);
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, r8};
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
                    this.f31295a = this;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        synchronized (this.f31295a.j) {
                            long currentTimeMillis = System.currentTimeMillis();
                            JSONObject jSONObject = new JSONObject();
                            this.f31295a.a(jSONObject, "ts", Long.valueOf(currentTimeMillis));
                            this.f31295a.a(this.f31295a.f31268f, "native_render_end", jSONObject);
                        }
                    }
                }
            });
        }
    }

    public void b(String str, long j, long j2, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048585, this, new Object[]{str, Long.valueOf(j), Long.valueOf(j2), Integer.valueOf(i2)}) == null) {
            com.bytedance.sdk.component.e.e.b(new com.bytedance.sdk.component.e.g(this, "onInterceptJs", str, j2, j, i2) { // from class: com.bytedance.sdk.openadsdk.e.p.11
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ String f31278a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ long f31279b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ long f31280c;

                /* renamed from: d  reason: collision with root package name */
                public final /* synthetic */ int f31281d;

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ p f31282e;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(r8);
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, r8, str, Long.valueOf(j2), Long.valueOf(j), Integer.valueOf(i2)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i3 = newInitContext.flag;
                        if ((i3 & 1) != 0) {
                            int i4 = i3 & 2;
                            super((String) newInitContext.callArgs[0]);
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f31282e = this;
                    this.f31278a = str;
                    this.f31279b = j2;
                    this.f31280c = j;
                    this.f31281d = i2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        synchronized (this.f31282e.j) {
                            if (!TextUtils.isEmpty(this.f31278a) && this.f31279b >= this.f31280c) {
                                JSONObject jSONObject = new JSONObject();
                                this.f31282e.a(jSONObject, "start_ts", Long.valueOf(this.f31280c));
                                this.f31282e.a(jSONObject, "end_ts", Long.valueOf(this.f31279b));
                                this.f31282e.a(jSONObject, "intercept_type", Integer.valueOf(this.f31281d));
                                this.f31282e.a(jSONObject, "type", "intercept_js");
                                this.f31282e.a(jSONObject, "url", this.f31278a);
                                this.f31282e.a(jSONObject, "duration", Long.valueOf(this.f31279b - this.f31280c));
                                this.f31282e.a(this.f31282e.f31270h, jSONObject);
                            }
                        }
                    }
                }
            });
        }
    }

    public void b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) {
            com.bytedance.sdk.component.e.e.b(new com.bytedance.sdk.component.e.g(this, "onWebviewJsbEnd", str) { // from class: com.bytedance.sdk.openadsdk.e.p.14
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ String f31286a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ p f31287b;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(r8);
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, r8, str};
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
                    this.f31287b = this;
                    this.f31286a = str;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        synchronized (this.f31287b.j) {
                            if (TextUtils.isEmpty(this.f31286a)) {
                                return;
                            }
                            long currentTimeMillis = System.currentTimeMillis();
                            JSONObject jSONObject = new JSONObject();
                            this.f31287b.a(jSONObject, "ts", Long.valueOf(currentTimeMillis));
                            this.f31287b.a(jSONObject, "jsb", this.f31286a);
                            this.f31287b.a(this.f31287b.f31268f, "webview_jsb_end", jSONObject);
                        }
                    }
                }
            });
        }
    }

    public void b(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, jSONObject) == null) {
            com.bytedance.sdk.component.e.e.b(new com.bytedance.sdk.component.e.g(this, "addExtraH5JsonObject", jSONObject) { // from class: com.bytedance.sdk.openadsdk.e.p.17
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ JSONObject f31290a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ p f31291b;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(r8);
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, r8, jSONObject};
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
                    this.f31291b = this;
                    this.f31290a = jSONObject;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        synchronized (this.f31291b.j) {
                            if (this.f31291b.f31268f != null && this.f31290a != null) {
                                Iterator<String> keys = this.f31290a.keys();
                                while (keys.hasNext()) {
                                    String next = keys.next();
                                    this.f31291b.a(this.f31291b.f31268f, next, this.f31290a.opt(next));
                                }
                                this.f31291b.f31266d = Boolean.TRUE;
                                this.f31291b.s();
                            }
                        }
                    }
                }
            });
        }
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            com.bytedance.sdk.component.e.e.b(new com.bytedance.sdk.component.e.g(this, "onRenderStart") { // from class: com.bytedance.sdk.openadsdk.e.p.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ p f31272a;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(r8);
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, r8};
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
                    this.f31272a = this;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        synchronized (this.f31272a.j) {
                            long currentTimeMillis = System.currentTimeMillis();
                            JSONObject jSONObject = new JSONObject();
                            this.f31272a.a(jSONObject, "ts", Long.valueOf(currentTimeMillis));
                            this.f31272a.a(jSONObject, "webview_count", Integer.valueOf(com.bytedance.sdk.openadsdk.core.widget.webview.d.a().f()));
                            this.f31272a.a(jSONObject, "available_cache_count", Integer.valueOf(com.bytedance.sdk.openadsdk.core.widget.webview.d.a().e()));
                            this.f31272a.a(this.f31272a.f31268f, "render_start", jSONObject);
                        }
                    }
                }
            });
        }
    }

    public void a(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
            com.bytedance.sdk.component.e.e.b(new com.bytedance.sdk.component.e.g(this, "onRenderError", i2) { // from class: com.bytedance.sdk.openadsdk.e.p.19
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ int f31293a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ p f31294b;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(r8);
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, r8, Integer.valueOf(i2)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i3 = newInitContext.flag;
                        if ((i3 & 1) != 0) {
                            int i4 = i3 & 2;
                            super((String) newInitContext.callArgs[0]);
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f31294b = this;
                    this.f31293a = i2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        synchronized (this.f31294b.j) {
                            this.f31294b.a(this.f31293a, (String) null);
                        }
                    }
                }
            });
        }
    }

    public void a(int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(Constants.METHOD_SEND_USER_MSG, this, i2, str) == null) {
            com.bytedance.sdk.component.e.e.b(new com.bytedance.sdk.component.e.g(this, "onRenderError", i2, str) { // from class: com.bytedance.sdk.openadsdk.e.p.20
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ int f31296a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ String f31297b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ p f31298c;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(r8);
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, r8, Integer.valueOf(i2), str};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i3 = newInitContext.flag;
                        if ((i3 & 1) != 0) {
                            int i4 = i3 & 2;
                            super((String) newInitContext.callArgs[0]);
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f31298c = this;
                    this.f31296a = i2;
                    this.f31297b = str;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        synchronized (this.f31298c.j) {
                            long currentTimeMillis = System.currentTimeMillis();
                            JSONObject jSONObject = new JSONObject();
                            this.f31298c.a(jSONObject, "ts", Long.valueOf(currentTimeMillis));
                            this.f31298c.a(jSONObject, "code", Integer.valueOf(this.f31296a));
                            if (this.f31297b != null) {
                                this.f31298c.a(jSONObject, "msg", this.f31297b);
                            }
                            this.f31298c.a(this.f31298c.f31268f, "render_error", jSONObject);
                        }
                    }
                }
            });
        }
    }

    public void a(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, jSONObject) == null) {
            com.bytedance.sdk.component.e.e.b(new com.bytedance.sdk.component.e.g(this, "onWebviewLoadError", jSONObject) { // from class: com.bytedance.sdk.openadsdk.e.p.5
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ JSONObject f31306a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ p f31307b;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(r8);
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, r8, jSONObject};
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
                    this.f31307b = this;
                    this.f31306a = jSONObject;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        synchronized (this.f31307b.j) {
                            JSONObject jSONObject2 = this.f31306a;
                            if (jSONObject2 == null) {
                                jSONObject2 = new JSONObject();
                            }
                            this.f31307b.a(jSONObject2, "ts", Long.valueOf(System.currentTimeMillis()));
                            this.f31307b.a(this.f31307b.f31268f, "webview_load_error", jSONObject2);
                        }
                    }
                }
            });
        }
    }

    public void a(String str, long j, long j2, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{str, Long.valueOf(j), Long.valueOf(j2), Integer.valueOf(i2)}) == null) {
            com.bytedance.sdk.component.e.e.b(new com.bytedance.sdk.component.e.g(this, "onInterceptHtml", str, j2, j, i2) { // from class: com.bytedance.sdk.openadsdk.e.p.10
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ String f31273a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ long f31274b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ long f31275c;

                /* renamed from: d  reason: collision with root package name */
                public final /* synthetic */ int f31276d;

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ p f31277e;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(r8);
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, r8, str, Long.valueOf(j2), Long.valueOf(j), Integer.valueOf(i2)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i3 = newInitContext.flag;
                        if ((i3 & 1) != 0) {
                            int i4 = i3 & 2;
                            super((String) newInitContext.callArgs[0]);
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f31277e = this;
                    this.f31273a = str;
                    this.f31274b = j2;
                    this.f31275c = j;
                    this.f31276d = i2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        synchronized (this.f31277e.j) {
                            if (!TextUtils.isEmpty(this.f31273a) && this.f31274b >= this.f31275c) {
                                JSONObject jSONObject = new JSONObject();
                                this.f31277e.a(jSONObject, "start_ts", Long.valueOf(this.f31275c));
                                this.f31277e.a(jSONObject, "end_ts", Long.valueOf(this.f31274b));
                                this.f31277e.a(jSONObject, "intercept_type", Integer.valueOf(this.f31276d));
                                this.f31277e.a(jSONObject, "type", "intercept_html");
                                this.f31277e.a(jSONObject, "url", this.f31273a);
                                this.f31277e.a(jSONObject, "duration", Long.valueOf(this.f31274b - this.f31275c));
                                this.f31277e.a(this.f31277e.f31270h, jSONObject);
                            }
                        }
                    }
                }
            });
        }
    }

    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            com.bytedance.sdk.component.e.e.b(new com.bytedance.sdk.component.e.g(this, "onWebviewJsbStart", str) { // from class: com.bytedance.sdk.openadsdk.e.p.13
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ String f31284a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ p f31285b;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(r8);
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, r8, str};
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
                    this.f31285b = this;
                    this.f31284a = str;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        synchronized (this.f31285b.j) {
                            if (TextUtils.isEmpty(this.f31284a)) {
                                return;
                            }
                            long currentTimeMillis = System.currentTimeMillis();
                            JSONObject jSONObject = new JSONObject();
                            this.f31285b.a(jSONObject, "ts", Long.valueOf(currentTimeMillis));
                            this.f31285b.a(jSONObject, "jsb", this.f31284a);
                            this.f31285b.a(this.f31285b.f31268f, "webview_jsb_start", jSONObject);
                        }
                    }
                }
            });
        }
    }

    public void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            this.f31267e = Boolean.valueOf(z);
        }
    }

    public p() {
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
        this.f31263a = "embeded_ad";
        Boolean bool = Boolean.FALSE;
        this.f31265c = bool;
        this.f31266d = bool;
        this.f31267e = bool;
        this.f31271i = false;
        this.j = new Object();
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
