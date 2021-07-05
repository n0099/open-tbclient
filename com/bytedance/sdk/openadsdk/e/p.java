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
/* loaded from: classes6.dex */
public class p {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f31153a;

    /* renamed from: b  reason: collision with root package name */
    public com.bytedance.sdk.openadsdk.core.e.m f31154b;

    /* renamed from: c  reason: collision with root package name */
    public Boolean f31155c;

    /* renamed from: d  reason: collision with root package name */
    public Boolean f31156d;

    /* renamed from: e  reason: collision with root package name */
    public Boolean f31157e;

    /* renamed from: f  reason: collision with root package name */
    public JSONObject f31158f;

    /* renamed from: g  reason: collision with root package name */
    public JSONArray f31159g;

    /* renamed from: h  reason: collision with root package name */
    public JSONArray f31160h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f31161i;
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
        this.f31153a = "embeded_ad";
        Boolean bool = Boolean.FALSE;
        this.f31155c = bool;
        this.f31156d = bool;
        this.f31157e = bool;
        this.f31161i = false;
        this.j = new Object();
        this.f31153a = str;
        this.f31154b = mVar;
        this.f31158f = new JSONObject();
        this.f31159g = new JSONArray();
        this.f31160h = new JSONArray();
        a(this.f31158f, "webview_source", Integer.valueOf(i2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65554, this)) == null) ? this.f31157e.booleanValue() || (this.f31156d.booleanValue() && this.f31155c.booleanValue()) : invokeV.booleanValue;
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            com.bytedance.sdk.component.e.e.b(new com.bytedance.sdk.component.e.g(this, "onWebviewLoadStart") { // from class: com.bytedance.sdk.openadsdk.e.p.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ p f31194a;

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
                    this.f31194a = this;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        synchronized (this.f31194a.j) {
                            long currentTimeMillis = System.currentTimeMillis();
                            JSONObject jSONObject = new JSONObject();
                            this.f31194a.a(jSONObject, "ts", Long.valueOf(currentTimeMillis));
                            this.f31194a.a(this.f31194a.f31158f, "webview_load_start", (Object) jSONObject, false);
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
                public final /* synthetic */ p f31195a;

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
                    this.f31195a = this;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        synchronized (this.f31195a.j) {
                            long currentTimeMillis = System.currentTimeMillis();
                            JSONObject jSONObject = new JSONObject();
                            this.f31195a.a(jSONObject, "ts", Long.valueOf(currentTimeMillis));
                            this.f31195a.a(this.f31195a.f31158f, "webview_load_success", jSONObject);
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
                public final /* synthetic */ p f31198a;

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
                    this.f31198a = this;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        synchronized (this.f31198a.j) {
                            long currentTimeMillis = System.currentTimeMillis();
                            JSONObject jSONObject = new JSONObject();
                            this.f31198a.a(jSONObject, "ts", Long.valueOf(currentTimeMillis));
                            this.f31198a.a(this.f31198a.f31158f, "native_endcard_show", jSONObject);
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
                public final /* synthetic */ p f31199a;

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
                    this.f31199a = this;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        synchronized (this.f31199a.j) {
                            long currentTimeMillis = System.currentTimeMillis();
                            JSONObject jSONObject = new JSONObject();
                            this.f31199a.a(jSONObject, "ts", Long.valueOf(currentTimeMillis));
                            this.f31199a.a(this.f31199a.f31158f, "native_endcard_close", jSONObject);
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
                public final /* synthetic */ p f31200a;

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
                    this.f31200a = this;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        synchronized (this.f31200a.j) {
                            long currentTimeMillis = System.currentTimeMillis();
                            JSONObject jSONObject = new JSONObject();
                            this.f31200a.a(jSONObject, "ts", Long.valueOf(currentTimeMillis));
                            this.f31200a.a(jSONObject, "type", "native_enterBackground");
                            this.f31200a.a(this.f31200a.f31159g, jSONObject);
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
                public final /* synthetic */ p f31201a;

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
                    this.f31201a = this;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        synchronized (this.f31201a.j) {
                            long currentTimeMillis = System.currentTimeMillis();
                            JSONObject jSONObject = new JSONObject();
                            this.f31201a.a(jSONObject, "ts", Long.valueOf(currentTimeMillis));
                            this.f31201a.a(jSONObject, "type", "native_enterForeground");
                            this.f31201a.a(this.f31201a.f31159g, jSONObject);
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
                public final /* synthetic */ p f31178a;

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
                    this.f31178a = this;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        synchronized (this.f31178a.j) {
                            long currentTimeMillis = System.currentTimeMillis();
                            JSONObject jSONObject = new JSONObject();
                            this.f31178a.a(jSONObject, "ts", Long.valueOf(currentTimeMillis));
                            this.f31178a.a(this.f31178a.f31158f, "no_native_render", jSONObject);
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
                public final /* synthetic */ p f31179a;

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
                    this.f31179a = this;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        synchronized (this.f31179a.j) {
                            long currentTimeMillis = System.currentTimeMillis();
                            JSONObject jSONObject = new JSONObject();
                            this.f31179a.a(jSONObject, "ts", Long.valueOf(currentTimeMillis));
                            this.f31179a.a(this.f31179a.f31158f, "render_failed", jSONObject);
                        }
                    }
                }
            });
        }
    }

    public void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            this.f31155c = Boolean.TRUE;
        }
    }

    public void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
            com.bytedance.sdk.component.e.e.a(new com.bytedance.sdk.component.e.g(this, "trySendTrackInfo") { // from class: com.bytedance.sdk.openadsdk.e.p.18
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ p f31182a;

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
                    this.f31182a = this;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        synchronized (this.f31182a.j) {
                            if (this.f31182a.t()) {
                                if (this.f31182a.f31161i) {
                                    return;
                                }
                                if (this.f31182a.f31159g != null && this.f31182a.f31159g.length() != 0) {
                                    try {
                                        this.f31182a.f31158f.put("native_switchBackgroundAndForeground", this.f31182a.f31159g);
                                    } catch (Exception unused) {
                                    }
                                }
                                if (this.f31182a.f31160h != null && this.f31182a.f31160h.length() != 0) {
                                    try {
                                        this.f31182a.f31158f.put("intercept_source", this.f31182a.f31160h);
                                    } catch (Exception unused2) {
                                    }
                                }
                                HashMap hashMap = new HashMap();
                                hashMap.put("webview_time_track", this.f31182a.f31158f);
                                if (com.bytedance.sdk.openadsdk.core.h.d().x() && this.f31182a.f31158f != null) {
                                    com.bytedance.sdk.component.utils.j.b("WebviewTimeTrack", this.f31182a.f31158f.toString());
                                }
                                d.h(com.bytedance.sdk.openadsdk.core.o.a(), this.f31182a.f31154b, this.f31182a.f31153a, "webview_time_track", hashMap);
                                this.f31182a.f31161i = true;
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
                public final /* synthetic */ p f31173a;

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
                    this.f31173a = this;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        synchronized (this.f31173a.j) {
                            long currentTimeMillis = System.currentTimeMillis();
                            JSONObject jSONObject = new JSONObject();
                            this.f31173a.a(jSONObject, "ts", Long.valueOf(currentTimeMillis));
                            this.f31173a.a(this.f31173a.f31158f, "render_success", jSONObject);
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
                public final /* synthetic */ p f31189a;

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
                    this.f31189a = this;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        synchronized (this.f31189a.j) {
                            long currentTimeMillis = System.currentTimeMillis();
                            JSONObject jSONObject = new JSONObject();
                            this.f31189a.a(jSONObject, "ts", Long.valueOf(currentTimeMillis));
                            this.f31189a.a(this.f31189a.f31158f, "native_render_start", jSONObject);
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
                public final /* synthetic */ p f31190a;

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
                    this.f31190a = this;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        synchronized (this.f31190a.j) {
                            long currentTimeMillis = System.currentTimeMillis();
                            JSONObject jSONObject = new JSONObject();
                            this.f31190a.a(jSONObject, "ts", Long.valueOf(currentTimeMillis));
                            this.f31190a.a(this.f31190a.f31158f, "dynamic_render_start", jSONObject);
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
                public final /* synthetic */ p f31191a;

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
                    this.f31191a = this;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        synchronized (this.f31191a.j) {
                            long currentTimeMillis = System.currentTimeMillis();
                            JSONObject jSONObject = new JSONObject();
                            this.f31191a.a(jSONObject, "ts", Long.valueOf(currentTimeMillis));
                            this.f31191a.a(this.f31191a.f31158f, "dynamic_render_success", jSONObject);
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
                public final /* synthetic */ p f31192a;

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
                    this.f31192a = this;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        synchronized (this.f31192a.j) {
                            long currentTimeMillis = System.currentTimeMillis();
                            JSONObject jSONObject = new JSONObject();
                            this.f31192a.a(jSONObject, "ts", Long.valueOf(currentTimeMillis));
                            this.f31192a.a(this.f31192a.f31158f, "dynamic_render_error", jSONObject);
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
                public final /* synthetic */ p f31193a;

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
                    this.f31193a = this;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        synchronized (this.f31193a.j) {
                            long currentTimeMillis = System.currentTimeMillis();
                            JSONObject jSONObject = new JSONObject();
                            this.f31193a.a(jSONObject, "ts", Long.valueOf(currentTimeMillis));
                            this.f31193a.a(this.f31193a.f31158f, "before_webview_request", jSONObject);
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
                public final /* synthetic */ p f31185a;

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
                    this.f31185a = this;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        synchronized (this.f31185a.j) {
                            long currentTimeMillis = System.currentTimeMillis();
                            JSONObject jSONObject = new JSONObject();
                            this.f31185a.a(jSONObject, "ts", Long.valueOf(currentTimeMillis));
                            this.f31185a.a(this.f31185a.f31158f, "native_render_end", jSONObject);
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
                public final /* synthetic */ String f31168a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ long f31169b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ long f31170c;

                /* renamed from: d  reason: collision with root package name */
                public final /* synthetic */ int f31171d;

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ p f31172e;

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
                    this.f31172e = this;
                    this.f31168a = str;
                    this.f31169b = j2;
                    this.f31170c = j;
                    this.f31171d = i2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        synchronized (this.f31172e.j) {
                            if (!TextUtils.isEmpty(this.f31168a) && this.f31169b >= this.f31170c) {
                                JSONObject jSONObject = new JSONObject();
                                this.f31172e.a(jSONObject, "start_ts", Long.valueOf(this.f31170c));
                                this.f31172e.a(jSONObject, "end_ts", Long.valueOf(this.f31169b));
                                this.f31172e.a(jSONObject, "intercept_type", Integer.valueOf(this.f31171d));
                                this.f31172e.a(jSONObject, "type", "intercept_js");
                                this.f31172e.a(jSONObject, "url", this.f31168a);
                                this.f31172e.a(jSONObject, "duration", Long.valueOf(this.f31169b - this.f31170c));
                                this.f31172e.a(this.f31172e.f31160h, jSONObject);
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
                public final /* synthetic */ String f31176a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ p f31177b;

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
                    this.f31177b = this;
                    this.f31176a = str;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        synchronized (this.f31177b.j) {
                            if (TextUtils.isEmpty(this.f31176a)) {
                                return;
                            }
                            long currentTimeMillis = System.currentTimeMillis();
                            JSONObject jSONObject = new JSONObject();
                            this.f31177b.a(jSONObject, "ts", Long.valueOf(currentTimeMillis));
                            this.f31177b.a(jSONObject, "jsb", this.f31176a);
                            this.f31177b.a(this.f31177b.f31158f, "webview_jsb_end", jSONObject);
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
                public final /* synthetic */ JSONObject f31180a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ p f31181b;

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
                    this.f31181b = this;
                    this.f31180a = jSONObject;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        synchronized (this.f31181b.j) {
                            if (this.f31181b.f31158f != null && this.f31180a != null) {
                                Iterator<String> keys = this.f31180a.keys();
                                while (keys.hasNext()) {
                                    String next = keys.next();
                                    this.f31181b.a(this.f31181b.f31158f, next, this.f31180a.opt(next));
                                }
                                this.f31181b.f31156d = Boolean.TRUE;
                                this.f31181b.s();
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
                public final /* synthetic */ p f31162a;

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
                    this.f31162a = this;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        synchronized (this.f31162a.j) {
                            long currentTimeMillis = System.currentTimeMillis();
                            JSONObject jSONObject = new JSONObject();
                            this.f31162a.a(jSONObject, "ts", Long.valueOf(currentTimeMillis));
                            this.f31162a.a(jSONObject, "webview_count", Integer.valueOf(com.bytedance.sdk.openadsdk.core.widget.webview.d.a().f()));
                            this.f31162a.a(jSONObject, "available_cache_count", Integer.valueOf(com.bytedance.sdk.openadsdk.core.widget.webview.d.a().e()));
                            this.f31162a.a(this.f31162a.f31158f, "render_start", jSONObject);
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
                public final /* synthetic */ int f31183a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ p f31184b;

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
                    this.f31184b = this;
                    this.f31183a = i2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        synchronized (this.f31184b.j) {
                            this.f31184b.a(this.f31183a, (String) null);
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
                public final /* synthetic */ int f31186a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ String f31187b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ p f31188c;

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
                    this.f31188c = this;
                    this.f31186a = i2;
                    this.f31187b = str;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        synchronized (this.f31188c.j) {
                            long currentTimeMillis = System.currentTimeMillis();
                            JSONObject jSONObject = new JSONObject();
                            this.f31188c.a(jSONObject, "ts", Long.valueOf(currentTimeMillis));
                            this.f31188c.a(jSONObject, "code", Integer.valueOf(this.f31186a));
                            if (this.f31187b != null) {
                                this.f31188c.a(jSONObject, "msg", this.f31187b);
                            }
                            this.f31188c.a(this.f31188c.f31158f, "render_error", jSONObject);
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
                public final /* synthetic */ JSONObject f31196a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ p f31197b;

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
                    this.f31197b = this;
                    this.f31196a = jSONObject;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        synchronized (this.f31197b.j) {
                            JSONObject jSONObject2 = this.f31196a;
                            if (jSONObject2 == null) {
                                jSONObject2 = new JSONObject();
                            }
                            this.f31197b.a(jSONObject2, "ts", Long.valueOf(System.currentTimeMillis()));
                            this.f31197b.a(this.f31197b.f31158f, "webview_load_error", jSONObject2);
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
                public final /* synthetic */ String f31163a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ long f31164b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ long f31165c;

                /* renamed from: d  reason: collision with root package name */
                public final /* synthetic */ int f31166d;

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ p f31167e;

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
                    this.f31167e = this;
                    this.f31163a = str;
                    this.f31164b = j2;
                    this.f31165c = j;
                    this.f31166d = i2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        synchronized (this.f31167e.j) {
                            if (!TextUtils.isEmpty(this.f31163a) && this.f31164b >= this.f31165c) {
                                JSONObject jSONObject = new JSONObject();
                                this.f31167e.a(jSONObject, "start_ts", Long.valueOf(this.f31165c));
                                this.f31167e.a(jSONObject, "end_ts", Long.valueOf(this.f31164b));
                                this.f31167e.a(jSONObject, "intercept_type", Integer.valueOf(this.f31166d));
                                this.f31167e.a(jSONObject, "type", "intercept_html");
                                this.f31167e.a(jSONObject, "url", this.f31163a);
                                this.f31167e.a(jSONObject, "duration", Long.valueOf(this.f31164b - this.f31165c));
                                this.f31167e.a(this.f31167e.f31160h, jSONObject);
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
                public final /* synthetic */ String f31174a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ p f31175b;

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
                    this.f31175b = this;
                    this.f31174a = str;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        synchronized (this.f31175b.j) {
                            if (TextUtils.isEmpty(this.f31174a)) {
                                return;
                            }
                            long currentTimeMillis = System.currentTimeMillis();
                            JSONObject jSONObject = new JSONObject();
                            this.f31175b.a(jSONObject, "ts", Long.valueOf(currentTimeMillis));
                            this.f31175b.a(jSONObject, "jsb", this.f31174a);
                            this.f31175b.a(this.f31175b.f31158f, "webview_jsb_start", jSONObject);
                        }
                    }
                }
            });
        }
    }

    public void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            this.f31157e = Boolean.valueOf(z);
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
        this.f31153a = "embeded_ad";
        Boolean bool = Boolean.FALSE;
        this.f31155c = bool;
        this.f31156d = bool;
        this.f31157e = bool;
        this.f31161i = false;
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
