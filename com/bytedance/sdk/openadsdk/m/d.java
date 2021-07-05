package com.bytedance.sdk.openadsdk.m;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.searchbox.live.interfaces.DI;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Context f31372a;

    /* renamed from: b  reason: collision with root package name */
    public WeakReference<f> f31373b;

    /* renamed from: c  reason: collision with root package name */
    public Map<String, a> f31374c;

    /* renamed from: d  reason: collision with root package name */
    public SensorEventListener f31375d;

    /* renamed from: e  reason: collision with root package name */
    public SensorEventListener f31376e;

    /* loaded from: classes6.dex */
    public interface a {
        JSONObject a(JSONObject jSONObject) throws Throwable;
    }

    public d(f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {fVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f31374c = new HashMap();
        this.f31375d = new SensorEventListener(this) { // from class: com.bytedance.sdk.openadsdk.m.d.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ d f31377a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.f31377a = this;
            }

            @Override // android.hardware.SensorEventListener
            public void onAccuracyChanged(Sensor sensor, int i4) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLI(1048576, this, sensor, i4) == null) {
                }
            }

            @Override // android.hardware.SensorEventListener
            public void onSensorChanged(SensorEvent sensorEvent) {
                f d2;
                Interceptable interceptable2 = $ic;
                if ((interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, sensorEvent) == null) && sensorEvent.sensor.getType() == 1 && (d2 = this.f31377a.d()) != null) {
                    float[] fArr = sensorEvent.values;
                    float f2 = fArr[0];
                    float f3 = fArr[1];
                    float f4 = fArr[2];
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("x", f2);
                        jSONObject.put("y", f3);
                        jSONObject.put("z", f4);
                        d2.a("accelerometer_callback", jSONObject);
                    } catch (Throwable unused) {
                    }
                }
            }
        };
        this.f31376e = new SensorEventListener(this) { // from class: com.bytedance.sdk.openadsdk.m.d.11
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ d f31379a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.f31379a = this;
            }

            @Override // android.hardware.SensorEventListener
            public void onAccuracyChanged(Sensor sensor, int i4) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLI(1048576, this, sensor, i4) == null) {
                }
            }

            @Override // android.hardware.SensorEventListener
            public void onSensorChanged(SensorEvent sensorEvent) {
                f d2;
                Interceptable interceptable2 = $ic;
                if ((interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, sensorEvent) == null) && sensorEvent.sensor.getType() == 4 && (d2 = this.f31379a.d()) != null) {
                    float degrees = (float) Math.toDegrees(sensorEvent.values[0]);
                    float degrees2 = (float) Math.toDegrees(sensorEvent.values[1]);
                    float degrees3 = (float) Math.toDegrees(sensorEvent.values[2]);
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("x", degrees);
                        jSONObject.put("y", degrees2);
                        jSONObject.put("z", degrees3);
                        d2.a("gyro_callback", jSONObject);
                    } catch (Throwable unused) {
                    }
                }
            }
        };
        this.f31372a = fVar.a();
        this.f31373b = new WeakReference<>(fVar);
        c();
    }

    private void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65540, this) == null) {
            this.f31374c.put("adInfo", new a(this) { // from class: com.bytedance.sdk.openadsdk.m.d.12
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ d f31380a;

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
                    this.f31380a = this;
                }

                @Override // com.bytedance.sdk.openadsdk.m.d.a
                public JSONObject a(JSONObject jSONObject) {
                    InterceptResult invokeL;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, jSONObject)) == null) {
                        f d2 = this.f31380a.d();
                        if (d2 != null) {
                            return d2.n();
                        }
                        return null;
                    }
                    return (JSONObject) invokeL.objValue;
                }
            });
            this.f31374c.put(DI.APP_INFO_NAME, new a(this) { // from class: com.bytedance.sdk.openadsdk.m.d.13
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ d f31381a;

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
                    this.f31381a = this;
                }

                @Override // com.bytedance.sdk.openadsdk.m.d.a
                public JSONObject a(JSONObject jSONObject) throws Throwable {
                    InterceptResult invokeL;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, jSONObject)) == null) {
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("appName", "playable_sdk");
                        jSONObject2.put("playableSdkEdition", "1.0.0.0");
                        JSONArray jSONArray = new JSONArray();
                        for (String str : this.f31381a.a()) {
                            jSONArray.put(str);
                        }
                        jSONObject2.put("supportList", jSONArray);
                        f d2 = this.f31381a.d();
                        if (d2 != null) {
                            jSONObject2.put("deviceId", d2.g());
                            jSONObject2.put("netType", d2.k());
                            jSONObject2.put("innerAppName", d2.d());
                            jSONObject2.put("appName", d2.e());
                            jSONObject2.put("appVersion", d2.f());
                            Map<String, String> b2 = d2.b();
                            for (String str2 : b2.keySet()) {
                                jSONObject2.put(str2, b2.get(str2));
                            }
                        }
                        return jSONObject2;
                    }
                    return (JSONObject) invokeL.objValue;
                }
            });
            this.f31374c.put("playableSDKInfo", new a(this) { // from class: com.bytedance.sdk.openadsdk.m.d.14
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ d f31382a;

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
                    this.f31382a = this;
                }

                @Override // com.bytedance.sdk.openadsdk.m.d.a
                public JSONObject a(JSONObject jSONObject) throws Throwable {
                    InterceptResult invokeL;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, jSONObject)) == null) {
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("appName", "playable_sdk");
                        jSONObject2.put("playableSdkEdition", "1.0.0.0");
                        return jSONObject2;
                    }
                    return (JSONObject) invokeL.objValue;
                }
            });
            this.f31374c.put("subscribe_app_ad", new a(this) { // from class: com.bytedance.sdk.openadsdk.m.d.15
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ d f31383a;

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
                    this.f31383a = this;
                }

                @Override // com.bytedance.sdk.openadsdk.m.d.a
                public JSONObject a(JSONObject jSONObject) {
                    InterceptResult invokeL;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, jSONObject)) == null) {
                        com.bytedance.sdk.openadsdk.m.a e2 = this.f31383a.e();
                        if (e2 == null) {
                            return null;
                        }
                        e2.a(jSONObject);
                        return null;
                    }
                    return (JSONObject) invokeL.objValue;
                }
            });
            this.f31374c.put("download_app_ad", new a(this) { // from class: com.bytedance.sdk.openadsdk.m.d.16
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ d f31384a;

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
                    this.f31384a = this;
                }

                @Override // com.bytedance.sdk.openadsdk.m.d.a
                public JSONObject a(JSONObject jSONObject) {
                    InterceptResult invokeL;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, jSONObject)) == null) {
                        com.bytedance.sdk.openadsdk.m.a e2 = this.f31384a.e();
                        if (e2 == null) {
                            return null;
                        }
                        e2.b(jSONObject);
                        return null;
                    }
                    return (JSONObject) invokeL.objValue;
                }
            });
            this.f31374c.put("isViewable", new a(this) { // from class: com.bytedance.sdk.openadsdk.m.d.17
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ d f31385a;

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
                    this.f31385a = this;
                }

                @Override // com.bytedance.sdk.openadsdk.m.d.a
                public JSONObject a(JSONObject jSONObject) throws Throwable {
                    InterceptResult invokeL;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, jSONObject)) == null) {
                        f d2 = this.f31385a.d();
                        if (d2 == null) {
                            return new JSONObject();
                        }
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("viewStatus", d2.i());
                        return jSONObject2;
                    }
                    return (JSONObject) invokeL.objValue;
                }
            });
            this.f31374c.put("getVolume", new a(this) { // from class: com.bytedance.sdk.openadsdk.m.d.18
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ d f31386a;

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
                    this.f31386a = this;
                }

                @Override // com.bytedance.sdk.openadsdk.m.d.a
                public JSONObject a(JSONObject jSONObject) throws Throwable {
                    InterceptResult invokeL;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, jSONObject)) == null) {
                        f d2 = this.f31386a.d();
                        if (d2 == null) {
                            return new JSONObject();
                        }
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("endcard_mute", d2.h());
                        return jSONObject2;
                    }
                    return (JSONObject) invokeL.objValue;
                }
            });
            this.f31374c.put("getScreenSize", new a(this) { // from class: com.bytedance.sdk.openadsdk.m.d.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ d f31387a;

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
                    this.f31387a = this;
                }

                @Override // com.bytedance.sdk.openadsdk.m.d.a
                public JSONObject a(JSONObject jSONObject) throws Throwable {
                    InterceptResult invokeL;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, jSONObject)) == null) {
                        f d2 = this.f31387a.d();
                        if (d2 == null) {
                            return new JSONObject();
                        }
                        return d2.m();
                    }
                    return (JSONObject) invokeL.objValue;
                }
            });
            this.f31374c.put("start_accelerometer_observer", new a(this) { // from class: com.bytedance.sdk.openadsdk.m.d.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ d f31388a;

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
                    this.f31388a = this;
                }

                @Override // com.bytedance.sdk.openadsdk.m.d.a
                public JSONObject a(JSONObject jSONObject) throws Throwable {
                    InterceptResult invokeL;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, jSONObject)) == null) {
                        JSONObject jSONObject2 = new JSONObject();
                        int i2 = 2;
                        if (jSONObject != null) {
                            try {
                                i2 = jSONObject.optInt("interval_android", 2);
                            } catch (Throwable th) {
                                e.a("PlayableJsBridge", "invoke start_accelerometer_observer error", th);
                                jSONObject2.put("code", -2);
                                jSONObject2.put("codeMsg", th.toString());
                                return jSONObject2;
                            }
                        }
                        h.a(this.f31388a.f31372a, this.f31388a.f31375d, i2);
                        jSONObject2.put("code", 0);
                        return jSONObject2;
                    }
                    return (JSONObject) invokeL.objValue;
                }
            });
            this.f31374c.put("close_accelerometer_observer", new a(this) { // from class: com.bytedance.sdk.openadsdk.m.d.4
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ d f31389a;

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
                    this.f31389a = this;
                }

                @Override // com.bytedance.sdk.openadsdk.m.d.a
                public JSONObject a(JSONObject jSONObject) throws Throwable {
                    InterceptResult invokeL;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, jSONObject)) == null) {
                        JSONObject jSONObject2 = new JSONObject();
                        try {
                            h.a(this.f31389a.f31372a, this.f31389a.f31375d);
                            jSONObject2.put("code", 0);
                            return jSONObject2;
                        } catch (Throwable th) {
                            e.a("PlayableJsBridge", "invoke close_accelerometer_observer error", th);
                            jSONObject2.put("code", -2);
                            jSONObject2.put("codeMsg", th.toString());
                            return jSONObject2;
                        }
                    }
                    return (JSONObject) invokeL.objValue;
                }
            });
            this.f31374c.put("start_gyro_observer", new a(this) { // from class: com.bytedance.sdk.openadsdk.m.d.5
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ d f31390a;

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
                    this.f31390a = this;
                }

                @Override // com.bytedance.sdk.openadsdk.m.d.a
                public JSONObject a(JSONObject jSONObject) throws Throwable {
                    InterceptResult invokeL;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, jSONObject)) == null) {
                        JSONObject jSONObject2 = new JSONObject();
                        int i2 = 2;
                        if (jSONObject != null) {
                            try {
                                i2 = jSONObject.optInt("interval_android", 2);
                            } catch (Throwable th) {
                                e.a("PlayableJsBridge", "invoke start_gyro_observer error", th);
                                jSONObject2.put("code", -2);
                                jSONObject2.put("codeMsg", th.toString());
                                return jSONObject2;
                            }
                        }
                        h.b(this.f31390a.f31372a, this.f31390a.f31376e, i2);
                        jSONObject2.put("code", 0);
                        return jSONObject2;
                    }
                    return (JSONObject) invokeL.objValue;
                }
            });
            this.f31374c.put("close_gyro_observer", new a(this) { // from class: com.bytedance.sdk.openadsdk.m.d.6
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ d f31391a;

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
                    this.f31391a = this;
                }

                @Override // com.bytedance.sdk.openadsdk.m.d.a
                public JSONObject a(JSONObject jSONObject) throws Throwable {
                    InterceptResult invokeL;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, jSONObject)) == null) {
                        JSONObject jSONObject2 = new JSONObject();
                        try {
                            h.a(this.f31391a.f31372a, this.f31391a.f31376e);
                            jSONObject2.put("code", 0);
                            return jSONObject2;
                        } catch (Throwable th) {
                            e.a("PlayableJsBridge", "invoke close_gyro_observer error", th);
                            jSONObject2.put("code", -2);
                            jSONObject2.put("codeMsg", th.toString());
                            return jSONObject2;
                        }
                    }
                    return (JSONObject) invokeL.objValue;
                }
            });
            this.f31374c.put("device_shake", new a(this) { // from class: com.bytedance.sdk.openadsdk.m.d.7
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ d f31392a;

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
                    this.f31392a = this;
                }

                @Override // com.bytedance.sdk.openadsdk.m.d.a
                public JSONObject a(JSONObject jSONObject) throws Throwable {
                    InterceptResult invokeL;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, jSONObject)) == null) {
                        JSONObject jSONObject2 = new JSONObject();
                        try {
                            h.a(this.f31392a.f31372a);
                            jSONObject2.put("code", 0);
                            return jSONObject2;
                        } catch (Throwable th) {
                            e.a("PlayableJsBridge", "invoke device_shake error", th);
                            jSONObject2.put("code", -2);
                            jSONObject2.put("codeMsg", th.toString());
                            return jSONObject2;
                        }
                    }
                    return (JSONObject) invokeL.objValue;
                }
            });
            this.f31374c.put("playable_style", new a(this) { // from class: com.bytedance.sdk.openadsdk.m.d.8
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ d f31393a;

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
                    this.f31393a = this;
                }

                @Override // com.bytedance.sdk.openadsdk.m.d.a
                public JSONObject a(JSONObject jSONObject) throws Throwable {
                    InterceptResult invokeL;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, jSONObject)) == null) {
                        f d2 = this.f31393a.d();
                        if (d2 != null) {
                            return d2.c();
                        }
                        return null;
                    }
                    return (JSONObject) invokeL.objValue;
                }
            });
            this.f31374c.put("sendReward", new a(this) { // from class: com.bytedance.sdk.openadsdk.m.d.9
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ d f31394a;

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
                    this.f31394a = this;
                }

                @Override // com.bytedance.sdk.openadsdk.m.d.a
                public JSONObject a(JSONObject jSONObject) throws Throwable {
                    InterceptResult invokeL;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, jSONObject)) == null) {
                        f d2 = this.f31394a.d();
                        if (d2 != null) {
                            d2.o();
                            return null;
                        }
                        return null;
                    }
                    return (JSONObject) invokeL.objValue;
                }
            });
            this.f31374c.put("webview_time_track", new a(this) { // from class: com.bytedance.sdk.openadsdk.m.d.10
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ d f31378a;

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
                    this.f31378a = this;
                }

                @Override // com.bytedance.sdk.openadsdk.m.d.a
                public JSONObject a(JSONObject jSONObject) throws Throwable {
                    InterceptResult invokeL;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, jSONObject)) == null) {
                        com.bytedance.sdk.openadsdk.m.a e2 = this.f31378a.e();
                        if (e2 != null) {
                            e2.c(jSONObject);
                            return null;
                        }
                        return null;
                    }
                    return (JSONObject) invokeL.objValue;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public f d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, this)) == null) {
            WeakReference<f> weakReference = this.f31373b;
            if (weakReference == null) {
                return null;
            }
            return weakReference.get();
        }
        return (f) invokeV.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.bytedance.sdk.openadsdk.m.a e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, this)) == null) {
            f d2 = d();
            if (d2 == null) {
                return null;
            }
            return d2.l();
        }
        return (com.bytedance.sdk.openadsdk.m.a) invokeV.objValue;
    }

    public Set<String> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f31374c.keySet() : (Set) invokeV.objValue;
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            h.a(this.f31372a, this.f31375d);
            h.a(this.f31372a, this.f31376e);
        }
    }

    public JSONObject a(String str, JSONObject jSONObject) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, jSONObject)) == null) {
            try {
                a aVar = this.f31374c.get(str);
                if (aVar == null) {
                    return null;
                }
                return aVar.a(jSONObject);
            } catch (Throwable th) {
                e.a("PlayableJsBridge", "invoke error", th);
                return null;
            }
        }
        return (JSONObject) invokeLL.objValue;
    }
}
