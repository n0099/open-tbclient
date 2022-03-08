package dxm.sasdk;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.graphics.Point;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.util.devices.RomUtils;
import com.baidu.tieba.imageProblem.httpNet.CDNIPDirectConnect;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.v8.debug.mirror.ObjectMirror;
import dxm.sasdk.exceptions.InvalidDataException;
import dxm.sasdk.util.SensorsDataUtils;
import f.a.c;
import f.a.d;
import f.a.e;
import f.a.f;
import f.a.g;
import f.a.i;
import f.a.j;
import f.a.k;
import f.a.l;
import f.a.m;
import f.a.n;
import f.a.o;
import f.a.p;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class DxmSdkSensorsDataAPI {
    public static /* synthetic */ Interceptable $ic;
    public static Boolean r;
    public static final Pattern s;
    public static final Map<Context, DxmSdkSensorsDataAPI> t;
    public static final p u;
    public static m v;
    public static final SimpleDateFormat w;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;

    /* renamed from: b  reason: collision with root package name */
    public String f60125b;

    /* renamed from: c  reason: collision with root package name */
    public DebugMode f60126c;

    /* renamed from: d  reason: collision with root package name */
    public int f60127d;

    /* renamed from: e  reason: collision with root package name */
    public int f60128e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f60129f;

    /* renamed from: g  reason: collision with root package name */
    public final Context f60130g;

    /* renamed from: h  reason: collision with root package name */
    public final f.a.a f60131h;

    /* renamed from: i  reason: collision with root package name */
    public final e f60132i;

    /* renamed from: j  reason: collision with root package name */
    public final i f60133j;
    public final j k;
    public final g l;
    public final f m;
    public final Map<String, Object> n;
    public final Map<String, d> o;
    public int p;
    public n q;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes8.dex */
    public static final class DebugMode {
        public static final /* synthetic */ DebugMode[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final DebugMode DEBUG_AND_TRACK;
        public static final DebugMode DEBUG_OFF;
        public static final DebugMode DEBUG_ONLY;
        public transient /* synthetic */ FieldHolder $fh;
        public final boolean debugMode;
        public final boolean debugWriteData;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1486171724, "Ldxm/sasdk/DxmSdkSensorsDataAPI$DebugMode;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1486171724, "Ldxm/sasdk/DxmSdkSensorsDataAPI$DebugMode;");
                    return;
                }
            }
            DEBUG_OFF = new DebugMode("DEBUG_OFF", 0, false, false);
            DEBUG_ONLY = new DebugMode("DEBUG_ONLY", 1, true, false);
            DebugMode debugMode = new DebugMode("DEBUG_AND_TRACK", 2, true, true);
            DEBUG_AND_TRACK = debugMode;
            $VALUES = new DebugMode[]{DEBUG_OFF, DEBUG_ONLY, debugMode};
        }

        public DebugMode(String str, int i2, boolean z, boolean z2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2), Boolean.valueOf(z), Boolean.valueOf(z2)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.debugMode = z;
            this.debugWriteData = z2;
        }

        public static DebugMode valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (DebugMode) Enum.valueOf(DebugMode.class, str) : (DebugMode) invokeL.objValue;
        }

        public static DebugMode[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (DebugMode[]) $VALUES.clone() : (DebugMode[]) invokeV.objValue;
        }

        public boolean isDebugMode() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.debugMode : invokeV.booleanValue;
        }

        public boolean isDebugWriteData() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.debugWriteData : invokeV.booleanValue;
        }
    }

    /* loaded from: classes8.dex */
    public class a implements p.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a(DxmSdkSensorsDataAPI dxmSdkSensorsDataAPI) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dxmSdkSensorsDataAPI};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // f.a.p.b
        public void a(SharedPreferences sharedPreferences) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, sharedPreferences) == null) {
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ EventType f60134e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f60135f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ JSONObject f60136g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ d f60137h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ String f60138i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ DxmSdkSensorsDataAPI f60139j;

        public b(DxmSdkSensorsDataAPI dxmSdkSensorsDataAPI, EventType eventType, String str, JSONObject jSONObject, d dVar, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dxmSdkSensorsDataAPI, eventType, str, jSONObject, dVar, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f60139j = dxmSdkSensorsDataAPI;
            this.f60134e = eventType;
            this.f60135f = str;
            this.f60136g = jSONObject;
            this.f60137h = dVar;
            this.f60138i = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            JSONObject jSONObject;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    if (this.f60134e.isTrack()) {
                        this.f60139j.l(this.f60135f);
                    }
                    this.f60139j.m(this.f60134e, this.f60136g);
                    try {
                        if (this.f60134e.isTrack()) {
                            jSONObject = new JSONObject(this.f60139j.n);
                            synchronized (this.f60139j.k) {
                                SensorsDataUtils.h(this.f60139j.k.b(), jSONObject);
                            }
                            String i2 = SensorsDataUtils.i(this.f60139j.f60130g);
                            jSONObject.put("$wifi", i2.equals(CDNIPDirectConnect.CDNNetworkChangeReceiver.WIFI_STRING));
                            jSONObject.put("$network_type", i2);
                            try {
                                if (DxmSdkSensorsDataAPI.v != null) {
                                    jSONObject.put("$latitude", DxmSdkSensorsDataAPI.v.a());
                                    jSONObject.put("$longitude", DxmSdkSensorsDataAPI.v.b());
                                }
                            } catch (Exception e2) {
                                e2.printStackTrace();
                            }
                            try {
                                String v = this.f60139j.v();
                                if (!TextUtils.isEmpty(v)) {
                                    jSONObject.put("$screen_orientation", v);
                                }
                            } catch (Exception e3) {
                                e3.printStackTrace();
                            }
                        } else if (!this.f60134e.isProfile()) {
                            return;
                        } else {
                            jSONObject = new JSONObject();
                        }
                        String str = null;
                        if (this.f60136g != null) {
                            try {
                                if (this.f60136g.has("$lib_detail")) {
                                    str = this.f60136g.getString("$lib_detail");
                                    this.f60136g.remove("$lib_detail");
                                }
                            } catch (Exception e4) {
                                e4.printStackTrace();
                            }
                            SensorsDataUtils.h(this.f60136g, jSONObject);
                        }
                        if (this.f60137h != null) {
                            try {
                                if (!jSONObject.has("event_duration") || jSONObject.optDouble("event_duration") <= 0.0d) {
                                    Double valueOf = Double.valueOf(this.f60137h.a());
                                    if (valueOf.doubleValue() > 0.0d) {
                                        jSONObject.put("event_duration", valueOf);
                                    }
                                }
                            } catch (Exception e5) {
                                e5.printStackTrace();
                            }
                        }
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("$lib", "Android");
                        jSONObject2.put("$lib_version", "1.10.4");
                        if (this.f60139j.n.containsKey("$app_version")) {
                            jSONObject2.put("$app_version", this.f60139j.n.get("$app_version"));
                        }
                        JSONObject b2 = this.f60139j.k.b();
                        if (b2 != null && b2.has("$app_version")) {
                            jSONObject2.put("$app_version", b2.get("$app_version"));
                        }
                        JSONObject jSONObject3 = new JSONObject();
                        try {
                            jSONObject3.put("_track_id", new Random().nextInt());
                        } catch (Exception unused) {
                        }
                        jSONObject3.put("time", System.currentTimeMillis());
                        jSONObject3.put("type", this.f60134e.getEventType());
                        try {
                            if (jSONObject.has("$project")) {
                                jSONObject3.put("project", jSONObject.optString("$project"));
                                jSONObject.remove("$project");
                            }
                            if (jSONObject.has("$token")) {
                                jSONObject3.put("token", jSONObject.optString("$token"));
                                jSONObject.remove("$token");
                            }
                        } catch (Exception e6) {
                            e6.printStackTrace();
                        }
                        jSONObject3.put(ObjectMirror.PROPERTIES, jSONObject);
                        String u = this.f60139j.u();
                        if (!TextUtils.isEmpty(u)) {
                            jSONObject3.put("distinct_id", u);
                        } else {
                            jSONObject3.put("distinct_id", this.f60139j.q());
                        }
                        jSONObject3.put("lib", jSONObject2);
                        if (this.f60134e == EventType.TRACK) {
                            jSONObject3.put("event", this.f60135f);
                            jSONObject.put("$is_first_day", this.f60139j.A());
                        } else if (this.f60134e == EventType.TRACK_SIGNUP) {
                            jSONObject3.put("event", this.f60135f);
                            jSONObject3.put("original_id", this.f60138i);
                        }
                        jSONObject2.put("$lib_method", "code");
                        if (TextUtils.isEmpty(str)) {
                            StackTraceElement[] stackTrace = new Exception().getStackTrace();
                            if (stackTrace.length > 2) {
                                StackTraceElement stackTraceElement = stackTrace[2];
                                str = String.format("%s##%s##%s##%s", stackTraceElement.getClassName(), stackTraceElement.getMethodName(), stackTraceElement.getFileName(), Integer.valueOf(stackTraceElement.getLineNumber()));
                            }
                        }
                        jSONObject2.put("$lib_detail", str);
                        this.f60139j.f60131h.b(this.f60134e.getEventType(), jSONObject3);
                        k.b("SA.SensorsDataAPI", "track event:\n" + f.a.q.b.b(jSONObject3.toString()));
                    } catch (JSONException unused2) {
                        throw new InvalidDataException("Unexpected property");
                    }
                } catch (Exception e7) {
                    e7.printStackTrace();
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1181097630, "Ldxm/sasdk/DxmSdkSensorsDataAPI;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1181097630, "Ldxm/sasdk/DxmSdkSensorsDataAPI;");
                return;
            }
        }
        r = Boolean.FALSE;
        s = Pattern.compile("^((?!^distinct_id$|^original_id$|^time$|^properties$|^id$|^first_id$|^second_id$|^users$|^events$|^event$|^user_id$|^date$|^datetime$)[a-zA-Z_$][a-zA-Z\\d_$]{0,99})$", 2);
        t = new HashMap();
        u = new p();
        w = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
    }

    public DxmSdkSensorsDataAPI() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.p = 14;
        this.f60130g = null;
        this.f60131h = null;
        this.f60132i = null;
        this.f60133j = null;
        this.k = null;
        this.l = null;
        this.m = null;
        this.n = null;
        this.o = null;
    }

    public static DxmSdkSensorsDataAPI H() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            synchronized (t) {
                if (t.size() > 0) {
                    Iterator<DxmSdkSensorsDataAPI> it = t.values().iterator();
                    if (it.hasNext()) {
                        return it.next();
                    }
                }
                return new c();
            }
        }
        return (DxmSdkSensorsDataAPI) invokeV.objValue;
    }

    public static DxmSdkSensorsDataAPI I(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, context)) == null) {
            if (context == null) {
                return new c();
            }
            synchronized (t) {
                DxmSdkSensorsDataAPI dxmSdkSensorsDataAPI = t.get(context.getApplicationContext());
                return dxmSdkSensorsDataAPI == null ? new c() : dxmSdkSensorsDataAPI;
            }
        }
        return (DxmSdkSensorsDataAPI) invokeL.objValue;
    }

    public static DxmSdkSensorsDataAPI J(Context context, String str, DebugMode debugMode) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65541, null, context, str, debugMode)) == null) {
            if (context == null) {
                return new c();
            }
            synchronized (t) {
                Context applicationContext = context.getApplicationContext();
                DxmSdkSensorsDataAPI dxmSdkSensorsDataAPI = t.get(applicationContext);
                if (dxmSdkSensorsDataAPI == null && f.a.b.a(applicationContext)) {
                    dxmSdkSensorsDataAPI = new DxmSdkSensorsDataAPI(applicationContext, str, debugMode);
                    t.put(applicationContext, dxmSdkSensorsDataAPI);
                }
                return dxmSdkSensorsDataAPI != null ? dxmSdkSensorsDataAPI : new c();
            }
        }
        return (DxmSdkSensorsDataAPI) invokeLLL.objValue;
    }

    public final boolean A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            String b2 = this.m.b();
            if (b2 == null) {
                return true;
            }
            return b2.equals(w.format(Long.valueOf(System.currentTimeMillis())));
        }
        return invokeV.booleanValue;
    }

    public boolean B(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) ? (L(str) & this.p) != 0 : invokeL.booleanValue;
    }

    public void C(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            try {
                k(str);
                synchronized (this.f60133j) {
                    if (!str.equals(this.f60133j.b())) {
                        this.f60133j.a(str);
                        if (!str.equals(q())) {
                            N(EventType.TRACK_SIGNUP, "$SignUp", null, q());
                        }
                    }
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public void D() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            synchronized (this.f60133j) {
                this.f60133j.a(null);
            }
        }
    }

    public void E(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, jSONObject) == null) || jSONObject == null) {
            return;
        }
        try {
            m(EventType.REGISTER_SUPER_PROPERTIES, jSONObject);
            synchronized (this.k) {
                JSONObject b2 = this.k.b();
                SensorsDataUtils.h(jSONObject, b2);
                this.k.a(b2);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            try {
                if (this.q != null) {
                    this.q.enable();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public void G(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            try {
                this.f60125b = str;
                if (!TextUtils.isEmpty(str) && this.f60126c != DebugMode.DEBUG_OFF) {
                    Uri parse = Uri.parse(str);
                    int lastIndexOf = parse.getPath().lastIndexOf(47);
                    if (lastIndexOf != -1) {
                        this.a = parse.buildUpon().path(parse.getPath().substring(0, lastIndexOf) + "/debug").build().toString();
                        return;
                    }
                    return;
                }
                this.a = str;
                n();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public void K() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            try {
                if (this.q != null) {
                    this.q.disable();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public final int L(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str)) == null) {
            if ("NULL".equals(str)) {
                return 255;
            }
            if (CDNIPDirectConnect.CDNNetworkChangeReceiver.WIFI_STRING.equals(str)) {
                return 8;
            }
            if ("2G".equals(str)) {
                return 1;
            }
            if ("3G".equals(str)) {
                return 2;
            }
            return "4G".equals(str) ? 4 : 255;
        }
        return invokeL.intValue;
    }

    public void M(String str, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048585, this, str, jSONObject) == null) {
            try {
                N(EventType.TRACK, str, jSONObject, null);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public final void N(EventType eventType, String str, JSONObject jSONObject, String str2) {
        d dVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048586, this, eventType, str, jSONObject, str2) == null) {
            if (str != null) {
                synchronized (this.o) {
                    dVar = this.o.get(str);
                    this.o.remove(str);
                }
            } else {
                dVar = null;
            }
            o.b().a(new b(this, eventType, str, jSONObject, dVar, str2));
        }
    }

    public void O(String str, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048587, this, str, jSONObject) == null) {
            if (jSONObject != null) {
                String optString = jSONObject.optString("event_key");
                if (!TextUtils.isEmpty(optString)) {
                    double r2 = r(optString);
                    if (r2 > 0.0d) {
                        try {
                            jSONObject.put("event_duration", r2);
                        } catch (JSONException e2) {
                            e2.printStackTrace();
                        }
                    }
                }
            }
            M(str, jSONObject);
        }
    }

    public void P(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, str) == null) {
            try {
                l(str);
                synchronized (this.o) {
                    this.o.put(str, new d(TimeUnit.SECONDS));
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public void i() {
        d value;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            synchronized (this.o) {
                try {
                    for (Map.Entry<String, d> entry : this.o.entrySet()) {
                        if (entry != null && (value = entry.getValue()) != null) {
                            value.e(SystemClock.elapsedRealtime());
                        }
                    }
                } catch (Exception e2) {
                    k.b("SA.SensorsDataAPI", "appBecomeActive error:" + e2.getMessage());
                }
            }
        }
    }

    public void j() {
        d value;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            synchronized (this.o) {
                try {
                    for (Map.Entry<String, d> entry : this.o.entrySet()) {
                        if (entry != null && !"$AppEnd".equals(entry.getKey().toString()) && (value = entry.getValue()) != null) {
                            value.d((value.b() + SystemClock.elapsedRealtime()) - value.c());
                            value.e(SystemClock.elapsedRealtime());
                        }
                    }
                } catch (Exception e2) {
                    k.b("SA.SensorsDataAPI", "appEnterBackground error:" + e2.getMessage());
                }
            }
        }
    }

    public final void k(String str) throws InvalidDataException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, str) == null) {
            if (str != null && str.length() >= 1) {
                if (str.length() > 255) {
                    throw new InvalidDataException("The max length of distinct_id or original_id or login_id is 255.");
                }
                return;
            }
            throw new InvalidDataException("The distinct_id or original_id or login_id is empty.");
        }
    }

    public final void l(String str) throws InvalidDataException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, str) == null) {
            if (str != null && str.length() >= 1) {
                if (s.matcher(str).matches()) {
                    return;
                }
                throw new InvalidDataException("The key '" + str + "' is invalid.");
            }
            throw new InvalidDataException("The key is empty.");
        }
    }

    public final void m(EventType eventType, JSONObject jSONObject) throws InvalidDataException {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048593, this, eventType, jSONObject) == null) || jSONObject == null) {
            return;
        }
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            l(next);
            try {
                Object obj = jSONObject.get(next);
                if (!(obj instanceof String) && !(obj instanceof Number) && !(obj instanceof JSONArray) && !(obj instanceof Boolean) && !(obj instanceof Date)) {
                    throw new InvalidDataException("The property value must be an instance of String/Number/Boolean/JSONArray. [key='" + next + "', value='" + obj.toString() + "']");
                }
                if ("app_crashed_reason".equals(next)) {
                    if ((obj instanceof String) && !next.startsWith("$") && ((String) obj).length() > 16382) {
                        k.a("SA.SensorsDataAPI", "The property value is too long. [key='" + next + "', value='" + obj.toString() + "']");
                    }
                } else if ((obj instanceof String) && !next.startsWith("$") && ((String) obj).length() > 8191) {
                    k.a("SA.SensorsDataAPI", "The property value is too long. [key='" + next + "', value='" + obj.toString() + "']");
                }
            } catch (JSONException unused) {
                throw new InvalidDataException("Unexpected property key. [key='" + next + "']");
            }
        }
    }

    public final void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            this.f60126c = DebugMode.DEBUG_OFF;
            o(false);
            this.a = this.f60125b;
        }
    }

    public void o(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048595, this, z) == null) {
            r = Boolean.valueOf(z);
        }
    }

    public void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            this.f60131h.c();
        }
    }

    public String q() {
        InterceptResult invokeV;
        String b2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            synchronized (this.f60132i) {
                b2 = this.f60132i.b();
            }
            return b2;
        }
        return (String) invokeV.objValue;
    }

    public final double r(String str) {
        InterceptResult invokeL;
        d dVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048598, this, str)) == null) {
            if (str != null) {
                synchronized (this.o) {
                    dVar = this.o.get(str);
                    this.o.remove(str);
                }
            } else {
                dVar = null;
            }
            if (dVar != null) {
                try {
                    Double valueOf = Double.valueOf(dVar.a());
                    if (valueOf.doubleValue() > 0.0d) {
                        return valueOf.doubleValue();
                    }
                    return -1.0d;
                } catch (Exception e2) {
                    e2.printStackTrace();
                    return -1.0d;
                }
            }
            return -1.0d;
        }
        return invokeL.doubleValue;
    }

    public int s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? this.f60128e : invokeV.intValue;
    }

    public int t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? this.f60127d : invokeV.intValue;
    }

    public String u() {
        InterceptResult invokeV;
        String b2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            synchronized (this.f60133j) {
                b2 = this.f60133j.b();
            }
            return b2;
        }
        return (String) invokeV.objValue;
    }

    public String v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
            try {
                if (this.q != null) {
                    return this.q.a();
                }
                return null;
            } catch (Exception e2) {
                e2.printStackTrace();
                return null;
            }
        }
        return (String) invokeV.objValue;
    }

    public String w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) ? this.a : (String) invokeV.objValue;
    }

    public void x(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048604, this, str) == null) {
            try {
                k(str);
                synchronized (this.f60132i) {
                    this.f60132i.a(str);
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public boolean y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) ? this.f60126c.isDebugMode() : invokeV.booleanValue;
    }

    public boolean z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) ? this.f60126c.isDebugWriteData() : invokeV.booleanValue;
    }

    public DxmSdkSensorsDataAPI(Context context, String str, DebugMode debugMode) {
        PackageManager packageManager;
        ApplicationInfo applicationInfo;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str, debugMode};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.p = 14;
        this.f60130g = context;
        this.f60126c = debugMode;
        String packageName = context.getApplicationContext().getPackageName();
        try {
            SensorsDataUtils.b(this.f60130g);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        try {
            k.d(this);
            Bundle bundle = null;
            if (context != null && (packageManager = context.getApplicationContext().getPackageManager()) != null && (applicationInfo = packageManager.getApplicationInfo(packageName, 128)) != null) {
                bundle = applicationInfo.metaData;
            }
            bundle = bundle == null ? new Bundle() : bundle;
            G(str);
            if (debugMode == DebugMode.DEBUG_OFF) {
                r = Boolean.valueOf(bundle.getBoolean("com.sensorsdata.analytics.android.EnableLogging", false));
            } else {
                r = Boolean.valueOf(bundle.getBoolean("com.sensorsdata.analytics.android.EnableLogging", true));
            }
            this.f60127d = bundle.getInt("com.sensorsdata.analytics.android.FlushInterval", 15000);
            this.f60128e = bundle.getInt("com.sensorsdata.analytics.android.FlushBulkSize", 100);
            this.f60129f = bundle.getBoolean("com.sensorsdata.analytics.android.AndroidId", true);
            k.a("SA.SensorsDataAPI", "mEnableAndroidId :" + this.f60129f);
            this.f60131h = f.a.a.d(this.f60130g, "dxm.sasdk.sa");
            Future<SharedPreferences> a2 = u.a(context, "dxm.sasdk.sa", new a(this));
            this.f60132i = new e(a2);
            if (this.f60129f) {
                try {
                    String c2 = SensorsDataUtils.c(this.f60130g);
                    if (SensorsDataUtils.g(c2)) {
                        x(f.a.q.c.b(c2));
                    }
                } catch (Exception e3) {
                    e3.printStackTrace();
                }
            }
            k.a("SA.SensorsDataAPI", "mEnableAndroidId :" + this.f60129f + " ; mDistinctId MD5 = " + this.f60132i.b());
            this.f60133j = new i(a2);
            this.k = new j(a2);
            this.l = new g(a2);
            this.m = new f(a2);
            if (Build.VERSION.SDK_INT >= 14) {
                ((Application) context.getApplicationContext()).registerActivityLifecycleCallbacks(new l(this, this.l, this.m));
            }
            if (debugMode != DebugMode.DEBUG_OFF) {
                String.format(Locale.CHINA, "Initialized the instance of Sensors Analytics SDK with server url '%s', flush interval %d ms, debugMode: %s", this.a, Integer.valueOf(this.f60127d), debugMode);
            }
            HashMap hashMap = new HashMap();
            hashMap.put("$lib", "Android");
            hashMap.put("$lib_version", "1.10.4");
            hashMap.put("$os", "Android");
            String str2 = Build.VERSION.RELEASE;
            hashMap.put("$os_version", str2 == null ? RomUtils.UNKNOWN : str2);
            String str3 = Build.MANUFACTURER;
            hashMap.put("$manufacturer", str3 == null ? RomUtils.UNKNOWN : str3);
            if (TextUtils.isEmpty(Build.MODEL)) {
                hashMap.put("$model", RomUtils.UNKNOWN);
            } else {
                hashMap.put("$model", Build.MODEL.trim());
            }
            try {
                hashMap.put("$app_version", this.f60130g.getPackageManager().getPackageInfo(this.f60130g.getPackageName(), 0).versionName);
            } catch (Exception unused) {
                DebugMode debugMode2 = DebugMode.DEBUG_OFF;
            }
            DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
            hashMap.put("$screen_height", Integer.valueOf(displayMetrics.heightPixels));
            hashMap.put("$screen_width", Integer.valueOf(displayMetrics.widthPixels));
            try {
                WindowManager windowManager = (WindowManager) this.f60130g.getSystemService("window");
                if (Build.VERSION.SDK_INT >= 17) {
                    Point point = new Point();
                    if (windowManager != null) {
                        windowManager.getDefaultDisplay().getRealSize(point);
                        hashMap.put("$screen_height", Integer.valueOf(point.y));
                    }
                }
            } catch (Exception unused2) {
                hashMap.put("$screen_height", Integer.valueOf(displayMetrics.heightPixels));
            }
            if (this.f60129f) {
                String c3 = SensorsDataUtils.c(this.f60130g);
                k.a("SA.SensorsDataAPI", "device_id android id = " + c3);
                if (!TextUtils.isEmpty(c3)) {
                    k.a("SA.SensorsDataAPI", "device_id Md5 android id = " + f.a.q.c.b(c3));
                    hashMap.put("$device_id", f.a.q.c.b(c3));
                }
            }
            this.n = Collections.unmodifiableMap(hashMap);
            this.o = new HashMap();
        } catch (PackageManager.NameNotFoundException e4) {
            throw new RuntimeException("Can't configure SensorsDataAPI with package name " + packageName, e4);
        }
    }
}
