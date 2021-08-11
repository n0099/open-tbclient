package com.bytedance.sdk.openadsdk.l;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import androidx.core.view.InputDeviceCompat;
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
/* loaded from: classes9.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Context f67609a;

    /* renamed from: b  reason: collision with root package name */
    public WeakReference<f> f67610b;

    /* renamed from: c  reason: collision with root package name */
    public Map<String, a> f67611c;

    /* renamed from: d  reason: collision with root package name */
    public SensorEventListener f67612d;

    /* renamed from: e  reason: collision with root package name */
    public SensorEventListener f67613e;

    /* loaded from: classes9.dex */
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
        this.f67611c = new HashMap();
        this.f67612d = new SensorEventListener(this) { // from class: com.bytedance.sdk.openadsdk.l.d.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ d f67614a;

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
                this.f67614a = this;
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
                if ((interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, sensorEvent) == null) && sensorEvent.sensor.getType() == 1 && (d2 = this.f67614a.d()) != null) {
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
        this.f67613e = new SensorEventListener(this) { // from class: com.bytedance.sdk.openadsdk.l.d.12
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ d f67617a;

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
                this.f67617a = this;
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
                if ((interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, sensorEvent) == null) && sensorEvent.sensor.getType() == 4 && (d2 = this.f67617a.d()) != null) {
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
        this.f67609a = fVar.a();
        this.f67610b = new WeakReference<>(fVar);
        c();
    }

    private void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) {
            this.f67611c.put("adInfo", new a(this) { // from class: com.bytedance.sdk.openadsdk.l.d.13
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ d f67618a;

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
                    this.f67618a = this;
                }

                @Override // com.bytedance.sdk.openadsdk.l.d.a
                public JSONObject a(JSONObject jSONObject) {
                    InterceptResult invokeL;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, jSONObject)) == null) {
                        f d2 = this.f67618a.d();
                        if (d2 != null) {
                            return d2.n();
                        }
                        return null;
                    }
                    return (JSONObject) invokeL.objValue;
                }
            });
            this.f67611c.put(DI.APP_INFO_NAME, new a(this) { // from class: com.bytedance.sdk.openadsdk.l.d.14
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ d f67619a;

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
                    this.f67619a = this;
                }

                @Override // com.bytedance.sdk.openadsdk.l.d.a
                public JSONObject a(JSONObject jSONObject) throws Throwable {
                    InterceptResult invokeL;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, jSONObject)) == null) {
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("appName", "playable_sdk");
                        jSONObject2.put("playableSdkEdition", "1.0.0.0");
                        JSONArray jSONArray = new JSONArray();
                        for (String str : this.f67619a.a()) {
                            jSONArray.put(str);
                        }
                        jSONObject2.put("supportList", jSONArray);
                        f d2 = this.f67619a.d();
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
            this.f67611c.put("playableSDKInfo", new a(this) { // from class: com.bytedance.sdk.openadsdk.l.d.15
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ d f67620a;

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
                    this.f67620a = this;
                }

                @Override // com.bytedance.sdk.openadsdk.l.d.a
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
            this.f67611c.put("subscribe_app_ad", new a(this) { // from class: com.bytedance.sdk.openadsdk.l.d.16
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ d f67621a;

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
                    this.f67621a = this;
                }

                @Override // com.bytedance.sdk.openadsdk.l.d.a
                public JSONObject a(JSONObject jSONObject) {
                    InterceptResult invokeL;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, jSONObject)) == null) {
                        com.bytedance.sdk.openadsdk.l.a e2 = this.f67621a.e();
                        if (e2 == null) {
                            return null;
                        }
                        e2.a(jSONObject);
                        return null;
                    }
                    return (JSONObject) invokeL.objValue;
                }
            });
            this.f67611c.put("download_app_ad", new a(this) { // from class: com.bytedance.sdk.openadsdk.l.d.17
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ d f67622a;

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
                    this.f67622a = this;
                }

                @Override // com.bytedance.sdk.openadsdk.l.d.a
                public JSONObject a(JSONObject jSONObject) {
                    InterceptResult invokeL;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, jSONObject)) == null) {
                        com.bytedance.sdk.openadsdk.l.a e2 = this.f67622a.e();
                        if (e2 == null) {
                            return null;
                        }
                        e2.b(jSONObject);
                        return null;
                    }
                    return (JSONObject) invokeL.objValue;
                }
            });
            this.f67611c.put("isViewable", new a(this) { // from class: com.bytedance.sdk.openadsdk.l.d.18
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ d f67623a;

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
                    this.f67623a = this;
                }

                @Override // com.bytedance.sdk.openadsdk.l.d.a
                public JSONObject a(JSONObject jSONObject) throws Throwable {
                    InterceptResult invokeL;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, jSONObject)) == null) {
                        f d2 = this.f67623a.d();
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
            this.f67611c.put("getVolume", new a(this) { // from class: com.bytedance.sdk.openadsdk.l.d.19
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ d f67624a;

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
                    this.f67624a = this;
                }

                @Override // com.bytedance.sdk.openadsdk.l.d.a
                public JSONObject a(JSONObject jSONObject) throws Throwable {
                    InterceptResult invokeL;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, jSONObject)) == null) {
                        f d2 = this.f67624a.d();
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
            this.f67611c.put("getScreenSize", new a(this) { // from class: com.bytedance.sdk.openadsdk.l.d.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ d f67625a;

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
                    this.f67625a = this;
                }

                @Override // com.bytedance.sdk.openadsdk.l.d.a
                public JSONObject a(JSONObject jSONObject) throws Throwable {
                    InterceptResult invokeL;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, jSONObject)) == null) {
                        f d2 = this.f67625a.d();
                        if (d2 == null) {
                            return new JSONObject();
                        }
                        return d2.m();
                    }
                    return (JSONObject) invokeL.objValue;
                }
            });
            this.f67611c.put("start_accelerometer_observer", new a(this) { // from class: com.bytedance.sdk.openadsdk.l.d.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ d f67626a;

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
                    this.f67626a = this;
                }

                @Override // com.bytedance.sdk.openadsdk.l.d.a
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
                        h.a(this.f67626a.f67609a, this.f67626a.f67612d, i2);
                        jSONObject2.put("code", 0);
                        return jSONObject2;
                    }
                    return (JSONObject) invokeL.objValue;
                }
            });
            this.f67611c.put("close_accelerometer_observer", new a(this) { // from class: com.bytedance.sdk.openadsdk.l.d.4
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ d f67627a;

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
                    this.f67627a = this;
                }

                @Override // com.bytedance.sdk.openadsdk.l.d.a
                public JSONObject a(JSONObject jSONObject) throws Throwable {
                    InterceptResult invokeL;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, jSONObject)) == null) {
                        JSONObject jSONObject2 = new JSONObject();
                        try {
                            h.a(this.f67627a.f67609a, this.f67627a.f67612d);
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
            this.f67611c.put("start_gyro_observer", new a(this) { // from class: com.bytedance.sdk.openadsdk.l.d.5
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ d f67628a;

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
                    this.f67628a = this;
                }

                @Override // com.bytedance.sdk.openadsdk.l.d.a
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
                        h.b(this.f67628a.f67609a, this.f67628a.f67613e, i2);
                        jSONObject2.put("code", 0);
                        return jSONObject2;
                    }
                    return (JSONObject) invokeL.objValue;
                }
            });
            this.f67611c.put("close_gyro_observer", new a(this) { // from class: com.bytedance.sdk.openadsdk.l.d.6
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ d f67629a;

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
                    this.f67629a = this;
                }

                @Override // com.bytedance.sdk.openadsdk.l.d.a
                public JSONObject a(JSONObject jSONObject) throws Throwable {
                    InterceptResult invokeL;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, jSONObject)) == null) {
                        JSONObject jSONObject2 = new JSONObject();
                        try {
                            h.a(this.f67629a.f67609a, this.f67629a.f67613e);
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
            this.f67611c.put("device_shake", new a(this) { // from class: com.bytedance.sdk.openadsdk.l.d.7
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ d f67630a;

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
                    this.f67630a = this;
                }

                @Override // com.bytedance.sdk.openadsdk.l.d.a
                public JSONObject a(JSONObject jSONObject) throws Throwable {
                    InterceptResult invokeL;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, jSONObject)) == null) {
                        JSONObject jSONObject2 = new JSONObject();
                        try {
                            h.a(this.f67630a.f67609a);
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
            this.f67611c.put("playable_style", new a(this) { // from class: com.bytedance.sdk.openadsdk.l.d.8
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ d f67631a;

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
                    this.f67631a = this;
                }

                @Override // com.bytedance.sdk.openadsdk.l.d.a
                public JSONObject a(JSONObject jSONObject) throws Throwable {
                    InterceptResult invokeL;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, jSONObject)) == null) {
                        f d2 = this.f67631a.d();
                        if (d2 != null) {
                            return d2.c();
                        }
                        return null;
                    }
                    return (JSONObject) invokeL.objValue;
                }
            });
            this.f67611c.put("sendReward", new a(this) { // from class: com.bytedance.sdk.openadsdk.l.d.9
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ d f67632a;

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
                    this.f67632a = this;
                }

                @Override // com.bytedance.sdk.openadsdk.l.d.a
                public JSONObject a(JSONObject jSONObject) throws Throwable {
                    InterceptResult invokeL;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, jSONObject)) == null) {
                        f d2 = this.f67632a.d();
                        if (d2 != null) {
                            d2.o();
                            return null;
                        }
                        return null;
                    }
                    return (JSONObject) invokeL.objValue;
                }
            });
            this.f67611c.put("webview_time_track", new a(this) { // from class: com.bytedance.sdk.openadsdk.l.d.10
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ d f67615a;

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
                    this.f67615a = this;
                }

                @Override // com.bytedance.sdk.openadsdk.l.d.a
                public JSONObject a(JSONObject jSONObject) throws Throwable {
                    InterceptResult invokeL;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, jSONObject)) == null) {
                        return null;
                    }
                    return (JSONObject) invokeL.objValue;
                }
            });
            this.f67611c.put("playable_event", new a(this) { // from class: com.bytedance.sdk.openadsdk.l.d.11
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ d f67616a;

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
                    this.f67616a = this;
                }

                @Override // com.bytedance.sdk.openadsdk.l.d.a
                public JSONObject a(JSONObject jSONObject) throws Throwable {
                    InterceptResult invokeL;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, jSONObject)) == null) {
                        f d2 = this.f67616a.d();
                        if (d2 == null || jSONObject == null) {
                            return null;
                        }
                        d2.b(jSONObject.optString("event", null), jSONObject.optJSONObject("params"));
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
            WeakReference<f> weakReference = this.f67610b;
            if (weakReference == null) {
                return null;
            }
            return weakReference.get();
        }
        return (f) invokeV.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.bytedance.sdk.openadsdk.l.a e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, this)) == null) {
            f d2 = d();
            if (d2 == null) {
                return null;
            }
            return d2.l();
        }
        return (com.bytedance.sdk.openadsdk.l.a) invokeV.objValue;
    }

    public Set<String> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f67611c.keySet() : (Set) invokeV.objValue;
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            h.a(this.f67609a, this.f67612d);
            h.a(this.f67609a, this.f67613e);
        }
    }

    public JSONObject a(String str, JSONObject jSONObject) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, jSONObject)) == null) {
            try {
                a aVar = this.f67611c.get(str);
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
