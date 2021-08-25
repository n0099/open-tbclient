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
    public Context f67809a;

    /* renamed from: b  reason: collision with root package name */
    public WeakReference<f> f67810b;

    /* renamed from: c  reason: collision with root package name */
    public Map<String, a> f67811c;

    /* renamed from: d  reason: collision with root package name */
    public SensorEventListener f67812d;

    /* renamed from: e  reason: collision with root package name */
    public SensorEventListener f67813e;

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
        this.f67811c = new HashMap();
        this.f67812d = new SensorEventListener(this) { // from class: com.bytedance.sdk.openadsdk.l.d.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ d f67814a;

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
                this.f67814a = this;
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
                if ((interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, sensorEvent) == null) && sensorEvent.sensor.getType() == 1 && (d2 = this.f67814a.d()) != null) {
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
        this.f67813e = new SensorEventListener(this) { // from class: com.bytedance.sdk.openadsdk.l.d.12
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ d f67817a;

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
                this.f67817a = this;
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
                if ((interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, sensorEvent) == null) && sensorEvent.sensor.getType() == 4 && (d2 = this.f67817a.d()) != null) {
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
        this.f67809a = fVar.a();
        this.f67810b = new WeakReference<>(fVar);
        c();
    }

    private void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) {
            this.f67811c.put("adInfo", new a(this) { // from class: com.bytedance.sdk.openadsdk.l.d.13
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ d f67818a;

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
                    this.f67818a = this;
                }

                @Override // com.bytedance.sdk.openadsdk.l.d.a
                public JSONObject a(JSONObject jSONObject) {
                    InterceptResult invokeL;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, jSONObject)) == null) {
                        f d2 = this.f67818a.d();
                        if (d2 != null) {
                            return d2.n();
                        }
                        return null;
                    }
                    return (JSONObject) invokeL.objValue;
                }
            });
            this.f67811c.put(DI.APP_INFO_NAME, new a(this) { // from class: com.bytedance.sdk.openadsdk.l.d.14
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ d f67819a;

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
                    this.f67819a = this;
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
                        for (String str : this.f67819a.a()) {
                            jSONArray.put(str);
                        }
                        jSONObject2.put("supportList", jSONArray);
                        f d2 = this.f67819a.d();
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
            this.f67811c.put("playableSDKInfo", new a(this) { // from class: com.bytedance.sdk.openadsdk.l.d.15
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ d f67820a;

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
                    this.f67820a = this;
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
            this.f67811c.put("subscribe_app_ad", new a(this) { // from class: com.bytedance.sdk.openadsdk.l.d.16
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ d f67821a;

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
                    this.f67821a = this;
                }

                @Override // com.bytedance.sdk.openadsdk.l.d.a
                public JSONObject a(JSONObject jSONObject) {
                    InterceptResult invokeL;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, jSONObject)) == null) {
                        com.bytedance.sdk.openadsdk.l.a e2 = this.f67821a.e();
                        if (e2 == null) {
                            return null;
                        }
                        e2.a(jSONObject);
                        return null;
                    }
                    return (JSONObject) invokeL.objValue;
                }
            });
            this.f67811c.put("download_app_ad", new a(this) { // from class: com.bytedance.sdk.openadsdk.l.d.17
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ d f67822a;

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
                    this.f67822a = this;
                }

                @Override // com.bytedance.sdk.openadsdk.l.d.a
                public JSONObject a(JSONObject jSONObject) {
                    InterceptResult invokeL;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, jSONObject)) == null) {
                        com.bytedance.sdk.openadsdk.l.a e2 = this.f67822a.e();
                        if (e2 == null) {
                            return null;
                        }
                        e2.b(jSONObject);
                        return null;
                    }
                    return (JSONObject) invokeL.objValue;
                }
            });
            this.f67811c.put("isViewable", new a(this) { // from class: com.bytedance.sdk.openadsdk.l.d.18
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ d f67823a;

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
                    this.f67823a = this;
                }

                @Override // com.bytedance.sdk.openadsdk.l.d.a
                public JSONObject a(JSONObject jSONObject) throws Throwable {
                    InterceptResult invokeL;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, jSONObject)) == null) {
                        f d2 = this.f67823a.d();
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
            this.f67811c.put("getVolume", new a(this) { // from class: com.bytedance.sdk.openadsdk.l.d.19
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ d f67824a;

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
                    this.f67824a = this;
                }

                @Override // com.bytedance.sdk.openadsdk.l.d.a
                public JSONObject a(JSONObject jSONObject) throws Throwable {
                    InterceptResult invokeL;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, jSONObject)) == null) {
                        f d2 = this.f67824a.d();
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
            this.f67811c.put("getScreenSize", new a(this) { // from class: com.bytedance.sdk.openadsdk.l.d.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ d f67825a;

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
                    this.f67825a = this;
                }

                @Override // com.bytedance.sdk.openadsdk.l.d.a
                public JSONObject a(JSONObject jSONObject) throws Throwable {
                    InterceptResult invokeL;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, jSONObject)) == null) {
                        f d2 = this.f67825a.d();
                        if (d2 == null) {
                            return new JSONObject();
                        }
                        return d2.m();
                    }
                    return (JSONObject) invokeL.objValue;
                }
            });
            this.f67811c.put("start_accelerometer_observer", new a(this) { // from class: com.bytedance.sdk.openadsdk.l.d.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ d f67826a;

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
                    this.f67826a = this;
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
                        h.a(this.f67826a.f67809a, this.f67826a.f67812d, i2);
                        jSONObject2.put("code", 0);
                        return jSONObject2;
                    }
                    return (JSONObject) invokeL.objValue;
                }
            });
            this.f67811c.put("close_accelerometer_observer", new a(this) { // from class: com.bytedance.sdk.openadsdk.l.d.4
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ d f67827a;

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
                    this.f67827a = this;
                }

                @Override // com.bytedance.sdk.openadsdk.l.d.a
                public JSONObject a(JSONObject jSONObject) throws Throwable {
                    InterceptResult invokeL;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, jSONObject)) == null) {
                        JSONObject jSONObject2 = new JSONObject();
                        try {
                            h.a(this.f67827a.f67809a, this.f67827a.f67812d);
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
            this.f67811c.put("start_gyro_observer", new a(this) { // from class: com.bytedance.sdk.openadsdk.l.d.5
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ d f67828a;

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
                    this.f67828a = this;
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
                        h.b(this.f67828a.f67809a, this.f67828a.f67813e, i2);
                        jSONObject2.put("code", 0);
                        return jSONObject2;
                    }
                    return (JSONObject) invokeL.objValue;
                }
            });
            this.f67811c.put("close_gyro_observer", new a(this) { // from class: com.bytedance.sdk.openadsdk.l.d.6
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ d f67829a;

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
                    this.f67829a = this;
                }

                @Override // com.bytedance.sdk.openadsdk.l.d.a
                public JSONObject a(JSONObject jSONObject) throws Throwable {
                    InterceptResult invokeL;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, jSONObject)) == null) {
                        JSONObject jSONObject2 = new JSONObject();
                        try {
                            h.a(this.f67829a.f67809a, this.f67829a.f67813e);
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
            this.f67811c.put("device_shake", new a(this) { // from class: com.bytedance.sdk.openadsdk.l.d.7
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ d f67830a;

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
                    this.f67830a = this;
                }

                @Override // com.bytedance.sdk.openadsdk.l.d.a
                public JSONObject a(JSONObject jSONObject) throws Throwable {
                    InterceptResult invokeL;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, jSONObject)) == null) {
                        JSONObject jSONObject2 = new JSONObject();
                        try {
                            h.a(this.f67830a.f67809a);
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
            this.f67811c.put("playable_style", new a(this) { // from class: com.bytedance.sdk.openadsdk.l.d.8
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ d f67831a;

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
                    this.f67831a = this;
                }

                @Override // com.bytedance.sdk.openadsdk.l.d.a
                public JSONObject a(JSONObject jSONObject) throws Throwable {
                    InterceptResult invokeL;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, jSONObject)) == null) {
                        f d2 = this.f67831a.d();
                        if (d2 != null) {
                            return d2.c();
                        }
                        return null;
                    }
                    return (JSONObject) invokeL.objValue;
                }
            });
            this.f67811c.put("sendReward", new a(this) { // from class: com.bytedance.sdk.openadsdk.l.d.9
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ d f67832a;

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
                    this.f67832a = this;
                }

                @Override // com.bytedance.sdk.openadsdk.l.d.a
                public JSONObject a(JSONObject jSONObject) throws Throwable {
                    InterceptResult invokeL;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, jSONObject)) == null) {
                        f d2 = this.f67832a.d();
                        if (d2 != null) {
                            d2.o();
                            return null;
                        }
                        return null;
                    }
                    return (JSONObject) invokeL.objValue;
                }
            });
            this.f67811c.put("webview_time_track", new a(this) { // from class: com.bytedance.sdk.openadsdk.l.d.10
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ d f67815a;

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
                    this.f67815a = this;
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
            this.f67811c.put("playable_event", new a(this) { // from class: com.bytedance.sdk.openadsdk.l.d.11
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ d f67816a;

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
                    this.f67816a = this;
                }

                @Override // com.bytedance.sdk.openadsdk.l.d.a
                public JSONObject a(JSONObject jSONObject) throws Throwable {
                    InterceptResult invokeL;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, jSONObject)) == null) {
                        f d2 = this.f67816a.d();
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
            WeakReference<f> weakReference = this.f67810b;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f67811c.keySet() : (Set) invokeV.objValue;
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            h.a(this.f67809a, this.f67812d);
            h.a(this.f67809a, this.f67813e);
        }
    }

    public JSONObject a(String str, JSONObject jSONObject) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, jSONObject)) == null) {
            try {
                a aVar = this.f67811c.get(str);
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
