package dxm.sasdk;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.graphics.Point;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.WindowManager;
import com.baidu.android.util.devices.RomUtils;
import com.baidu.tieba.imageProblem.httpNet.CDNIPDirectConnect;
import dxm.sasdk.exceptions.InvalidDataException;
import dxm.sasdk.util.SensorsDataUtils;
import e.a.c;
import e.a.d;
import e.a.e;
import e.a.f;
import e.a.g;
import e.a.i;
import e.a.j;
import e.a.k;
import e.a.l;
import e.a.m;
import e.a.n;
import e.a.o;
import e.a.p;
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
/* loaded from: classes7.dex */
public class DxmSdkSensorsDataAPI {
    public static m v;

    /* renamed from: a  reason: collision with root package name */
    public String f68176a;

    /* renamed from: b  reason: collision with root package name */
    public String f68177b;

    /* renamed from: c  reason: collision with root package name */
    public DebugMode f68178c;

    /* renamed from: d  reason: collision with root package name */
    public int f68179d;

    /* renamed from: e  reason: collision with root package name */
    public int f68180e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f68181f;

    /* renamed from: g  reason: collision with root package name */
    public final Context f68182g;

    /* renamed from: h  reason: collision with root package name */
    public final e.a.a f68183h;

    /* renamed from: i  reason: collision with root package name */
    public final e f68184i;
    public final i j;
    public final j k;
    public final g l;
    public final f m;
    public final Map<String, Object> n;
    public final Map<String, d> o;
    public int p;
    public n q;
    public static Boolean r = Boolean.FALSE;
    public static final Pattern s = Pattern.compile("^((?!^distinct_id$|^original_id$|^time$|^properties$|^id$|^first_id$|^second_id$|^users$|^events$|^event$|^user_id$|^date$|^datetime$)[a-zA-Z_$][a-zA-Z\\d_$]{0,99})$", 2);
    public static final Map<Context, DxmSdkSensorsDataAPI> t = new HashMap();
    public static final p u = new p();
    public static final SimpleDateFormat w = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());

    /* loaded from: classes7.dex */
    public enum DebugMode {
        DEBUG_OFF(false, false),
        DEBUG_ONLY(true, false),
        DEBUG_AND_TRACK(true, true);
        
        public final boolean debugMode;
        public final boolean debugWriteData;

        DebugMode(boolean z, boolean z2) {
            this.debugMode = z;
            this.debugWriteData = z2;
        }

        public boolean isDebugMode() {
            return this.debugMode;
        }

        public boolean isDebugWriteData() {
            return this.debugWriteData;
        }
    }

    /* loaded from: classes7.dex */
    public class a implements p.b {
        public a(DxmSdkSensorsDataAPI dxmSdkSensorsDataAPI) {
        }

        @Override // e.a.p.b
        public void a(SharedPreferences sharedPreferences) {
        }
    }

    /* loaded from: classes7.dex */
    public class b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ EventType f68185e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f68186f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ JSONObject f68187g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ d f68188h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ String f68189i;

        public b(EventType eventType, String str, JSONObject jSONObject, d dVar, String str2) {
            this.f68185e = eventType;
            this.f68186f = str;
            this.f68187g = jSONObject;
            this.f68188h = dVar;
            this.f68189i = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            JSONObject jSONObject;
            try {
                if (this.f68185e.isTrack()) {
                    DxmSdkSensorsDataAPI.this.l(this.f68186f);
                }
                DxmSdkSensorsDataAPI.this.m(this.f68185e, this.f68187g);
                try {
                    if (this.f68185e.isTrack()) {
                        jSONObject = new JSONObject(DxmSdkSensorsDataAPI.this.n);
                        synchronized (DxmSdkSensorsDataAPI.this.k) {
                            SensorsDataUtils.h(DxmSdkSensorsDataAPI.this.k.b(), jSONObject);
                        }
                        String i2 = SensorsDataUtils.i(DxmSdkSensorsDataAPI.this.f68182g);
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
                            String v = DxmSdkSensorsDataAPI.this.v();
                            if (!TextUtils.isEmpty(v)) {
                                jSONObject.put("$screen_orientation", v);
                            }
                        } catch (Exception e3) {
                            e3.printStackTrace();
                        }
                    } else if (!this.f68185e.isProfile()) {
                        return;
                    } else {
                        jSONObject = new JSONObject();
                    }
                    String str = null;
                    if (this.f68187g != null) {
                        try {
                            if (this.f68187g.has("$lib_detail")) {
                                str = this.f68187g.getString("$lib_detail");
                                this.f68187g.remove("$lib_detail");
                            }
                        } catch (Exception e4) {
                            e4.printStackTrace();
                        }
                        SensorsDataUtils.h(this.f68187g, jSONObject);
                    }
                    if (this.f68188h != null) {
                        try {
                            if (!jSONObject.has("event_duration") || jSONObject.optDouble("event_duration") <= 0.0d) {
                                Double valueOf = Double.valueOf(this.f68188h.a());
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
                    if (DxmSdkSensorsDataAPI.this.n.containsKey("$app_version")) {
                        jSONObject2.put("$app_version", DxmSdkSensorsDataAPI.this.n.get("$app_version"));
                    }
                    JSONObject b2 = DxmSdkSensorsDataAPI.this.k.b();
                    if (b2 != null && b2.has("$app_version")) {
                        jSONObject2.put("$app_version", b2.get("$app_version"));
                    }
                    JSONObject jSONObject3 = new JSONObject();
                    try {
                        jSONObject3.put("_track_id", new Random().nextInt());
                    } catch (Exception unused) {
                    }
                    jSONObject3.put("time", System.currentTimeMillis());
                    jSONObject3.put("type", this.f68185e.getEventType());
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
                    jSONObject3.put("properties", jSONObject);
                    String u = DxmSdkSensorsDataAPI.this.u();
                    if (!TextUtils.isEmpty(u)) {
                        jSONObject3.put("distinct_id", u);
                    } else {
                        jSONObject3.put("distinct_id", DxmSdkSensorsDataAPI.this.q());
                    }
                    jSONObject3.put("lib", jSONObject2);
                    if (this.f68185e == EventType.TRACK) {
                        jSONObject3.put("event", this.f68186f);
                        jSONObject.put("$is_first_day", DxmSdkSensorsDataAPI.this.A());
                    } else if (this.f68185e == EventType.TRACK_SIGNUP) {
                        jSONObject3.put("event", this.f68186f);
                        jSONObject3.put("original_id", this.f68189i);
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
                    DxmSdkSensorsDataAPI.this.f68183h.b(this.f68185e.getEventType(), jSONObject3);
                    k.b("SA.SensorsDataAPI", "track event:\n" + e.a.q.b.b(jSONObject3.toString()));
                } catch (JSONException unused2) {
                    throw new InvalidDataException("Unexpected property");
                }
            } catch (Exception e7) {
                e7.printStackTrace();
            }
        }
    }

    public DxmSdkSensorsDataAPI() {
        this.p = 14;
        this.f68182g = null;
        this.f68183h = null;
        this.f68184i = null;
        this.j = null;
        this.k = null;
        this.l = null;
        this.m = null;
        this.n = null;
        this.o = null;
    }

    public static DxmSdkSensorsDataAPI H() {
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

    public static DxmSdkSensorsDataAPI I(Context context) {
        if (context == null) {
            return new c();
        }
        synchronized (t) {
            DxmSdkSensorsDataAPI dxmSdkSensorsDataAPI = t.get(context.getApplicationContext());
            if (dxmSdkSensorsDataAPI == null) {
                Log.i("SA.SensorsDataAPI", "The static method sharedInstance(context, serverURL, debugMode) should be called before calling sharedInstance()");
                return new c();
            }
            return dxmSdkSensorsDataAPI;
        }
    }

    public static DxmSdkSensorsDataAPI J(Context context, String str, DebugMode debugMode) {
        if (context == null) {
            return new c();
        }
        synchronized (t) {
            Context applicationContext = context.getApplicationContext();
            DxmSdkSensorsDataAPI dxmSdkSensorsDataAPI = t.get(applicationContext);
            if (dxmSdkSensorsDataAPI == null && e.a.b.a(applicationContext)) {
                dxmSdkSensorsDataAPI = new DxmSdkSensorsDataAPI(applicationContext, str, debugMode);
                t.put(applicationContext, dxmSdkSensorsDataAPI);
            }
            if (dxmSdkSensorsDataAPI != null) {
                return dxmSdkSensorsDataAPI;
            }
            return new c();
        }
    }

    public final boolean A() {
        String b2 = this.m.b();
        if (b2 == null) {
            return true;
        }
        return b2.equals(w.format(Long.valueOf(System.currentTimeMillis())));
    }

    public boolean B(String str) {
        return (L(str) & this.p) != 0;
    }

    public void C(String str) {
        try {
            k(str);
            synchronized (this.j) {
                if (!str.equals(this.j.b())) {
                    this.j.a(str);
                    if (!str.equals(q())) {
                        N(EventType.TRACK_SIGNUP, "$SignUp", null, q());
                    }
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void D() {
        synchronized (this.j) {
            this.j.a(null);
        }
    }

    public void E(JSONObject jSONObject) {
        if (jSONObject == null) {
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
        try {
            if (this.q != null) {
                this.q.enable();
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void G(String str) {
        try {
            this.f68177b = str;
            if (!TextUtils.isEmpty(str) && this.f68178c != DebugMode.DEBUG_OFF) {
                Uri parse = Uri.parse(str);
                int lastIndexOf = parse.getPath().lastIndexOf(47);
                if (lastIndexOf != -1) {
                    this.f68176a = parse.buildUpon().path(parse.getPath().substring(0, lastIndexOf) + "/debug").build().toString();
                }
            }
            this.f68176a = str;
            n();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void K() {
        try {
            if (this.q != null) {
                this.q.disable();
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public final int L(String str) {
        if ("NULL".equals(str)) {
            return 255;
        }
        if (CDNIPDirectConnect.CDNNetworkChangeReceiver.WIFI_STRING.equals(str)) {
            return 8;
        }
        if ("2G".equals(str)) {
            return 1;
        }
        if (com.baidu.apollon.statistics.g.f3963b.equals(str)) {
            return 2;
        }
        return "4G".equals(str) ? 4 : 255;
    }

    public void M(String str, JSONObject jSONObject) {
        try {
            N(EventType.TRACK, str, jSONObject, null);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public final void N(EventType eventType, String str, JSONObject jSONObject, String str2) {
        d dVar;
        if (str != null) {
            synchronized (this.o) {
                dVar = this.o.get(str);
                this.o.remove(str);
            }
        } else {
            dVar = null;
        }
        o.b().a(new b(eventType, str, jSONObject, dVar, str2));
    }

    public void O(String str, JSONObject jSONObject) {
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

    public void P(String str) {
        try {
            l(str);
            synchronized (this.o) {
                this.o.put(str, new d(TimeUnit.SECONDS));
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void i() {
        d value;
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

    public void j() {
        d value;
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

    public final void k(String str) throws InvalidDataException {
        if (str != null && str.length() >= 1) {
            if (str.length() > 255) {
                throw new InvalidDataException("The max length of distinct_id or original_id or login_id is 255.");
            }
            return;
        }
        throw new InvalidDataException("The distinct_id or original_id or login_id is empty.");
    }

    public final void l(String str) throws InvalidDataException {
        if (str != null && str.length() >= 1) {
            if (s.matcher(str).matches()) {
                return;
            }
            throw new InvalidDataException("The key '" + str + "' is invalid.");
        }
        throw new InvalidDataException("The key is empty.");
    }

    public final void m(EventType eventType, JSONObject jSONObject) throws InvalidDataException {
        if (jSONObject == null) {
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
        this.f68178c = DebugMode.DEBUG_OFF;
        o(false);
        this.f68176a = this.f68177b;
    }

    public void o(boolean z) {
        r = Boolean.valueOf(z);
    }

    public void p() {
        this.f68183h.c();
    }

    public String q() {
        String b2;
        synchronized (this.f68184i) {
            b2 = this.f68184i.b();
        }
        return b2;
    }

    public final double r(String str) {
        d dVar;
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

    public int s() {
        return this.f68180e;
    }

    public int t() {
        return this.f68179d;
    }

    public String u() {
        String b2;
        synchronized (this.j) {
            b2 = this.j.b();
        }
        return b2;
    }

    public String v() {
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

    public String w() {
        return this.f68176a;
    }

    public void x(String str) {
        try {
            k(str);
            synchronized (this.f68184i) {
                this.f68184i.a(str);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public boolean y() {
        return this.f68178c.isDebugMode();
    }

    public boolean z() {
        return this.f68178c.isDebugWriteData();
    }

    public DxmSdkSensorsDataAPI(Context context, String str, DebugMode debugMode) {
        this.p = 14;
        this.f68182g = context;
        this.f68178c = debugMode;
        String packageName = context.getApplicationContext().getPackageName();
        try {
            SensorsDataUtils.b(this.f68182g);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        try {
            k.d(this);
            Bundle bundle = context.getApplicationContext().getPackageManager().getApplicationInfo(packageName, 128).metaData;
            bundle = bundle == null ? new Bundle() : bundle;
            G(str);
            if (debugMode == DebugMode.DEBUG_OFF) {
                r = Boolean.valueOf(bundle.getBoolean("com.sensorsdata.analytics.android.EnableLogging", false));
            } else {
                r = Boolean.valueOf(bundle.getBoolean("com.sensorsdata.analytics.android.EnableLogging", true));
            }
            this.f68179d = bundle.getInt("com.sensorsdata.analytics.android.FlushInterval", 15000);
            this.f68180e = bundle.getInt("com.sensorsdata.analytics.android.FlushBulkSize", 100);
            this.f68181f = bundle.getBoolean("com.sensorsdata.analytics.android.AndroidId", true);
            k.a("SA.SensorsDataAPI", "mEnableAndroidId :" + this.f68181f);
            this.f68183h = e.a.a.d(this.f68182g, "dxm.sasdk.sa");
            Future<SharedPreferences> a2 = u.a(context, "dxm.sasdk.sa", new a(this));
            this.f68184i = new e(a2);
            if (this.f68181f) {
                try {
                    String c2 = SensorsDataUtils.c(this.f68182g);
                    if (SensorsDataUtils.g(c2)) {
                        x(e.a.q.c.b(c2));
                    }
                } catch (Exception e3) {
                    e3.printStackTrace();
                }
            }
            k.a("SA.SensorsDataAPI", "mEnableAndroidId :" + this.f68181f + " ; mDistinctId MD5 = " + this.f68184i.b());
            this.j = new i(a2);
            this.k = new j(a2);
            this.l = new g(a2);
            this.m = new f(a2);
            if (Build.VERSION.SDK_INT >= 14) {
                ((Application) context.getApplicationContext()).registerActivityLifecycleCallbacks(new l(this, this.l, this.m));
            }
            if (debugMode != DebugMode.DEBUG_OFF) {
                Log.i("SA.SensorsDataAPI", String.format(Locale.CHINA, "Initialized the instance of Sensors Analytics SDK with server url '%s', flush interval %d ms, debugMode: %s", this.f68176a, Integer.valueOf(this.f68179d), debugMode));
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
                hashMap.put("$app_version", this.f68182g.getPackageManager().getPackageInfo(this.f68182g.getPackageName(), 0).versionName);
            } catch (Exception e4) {
                if (debugMode != DebugMode.DEBUG_OFF) {
                    Log.i("SA.SensorsDataAPI", "Exception getting app version name", e4);
                }
            }
            DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
            hashMap.put("$screen_height", Integer.valueOf(displayMetrics.heightPixels));
            hashMap.put("$screen_width", Integer.valueOf(displayMetrics.widthPixels));
            try {
                WindowManager windowManager = (WindowManager) this.f68182g.getSystemService("window");
                if (Build.VERSION.SDK_INT >= 17) {
                    Point point = new Point();
                    if (windowManager != null) {
                        windowManager.getDefaultDisplay().getRealSize(point);
                        hashMap.put("$screen_height", Integer.valueOf(point.y));
                    }
                }
            } catch (Exception unused) {
                hashMap.put("$screen_height", Integer.valueOf(displayMetrics.heightPixels));
            }
            if (this.f68181f) {
                String c3 = SensorsDataUtils.c(this.f68182g);
                k.a("SA.SensorsDataAPI", "device_id android id = " + c3);
                if (!TextUtils.isEmpty(c3)) {
                    k.a("SA.SensorsDataAPI", "device_id Md5 android id = " + e.a.q.c.b(c3));
                    hashMap.put("$device_id", e.a.q.c.b(c3));
                }
            }
            this.n = Collections.unmodifiableMap(hashMap);
            this.o = new HashMap();
        } catch (PackageManager.NameNotFoundException e5) {
            throw new RuntimeException("Can't configure SensorsDataAPI with package name " + packageName, e5);
        }
    }
}
