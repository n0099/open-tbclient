package d.b.q.j.a.c;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import d.b.q.g.c.a.e;
import d.b.q.g.c.a.f;
import d.b.q.g.c.a.g;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a {

    /* renamed from: g  reason: collision with root package name */
    public static final byte[] f64542g = {77, 73, 78, 71};

    /* renamed from: a  reason: collision with root package name */
    public long f64543a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f64544b;

    /* renamed from: c  reason: collision with root package name */
    public Set<String> f64545c;

    /* renamed from: d  reason: collision with root package name */
    public String f64546d;

    /* renamed from: e  reason: collision with root package name */
    public Context f64547e;

    /* renamed from: f  reason: collision with root package name */
    public int f64548f;

    public static boolean e(String str, Context context, JSONObject jSONObject, Set<String> set) {
        JSONArray jSONArray = jSONObject.getJSONArray("sigs");
        int length = jSONArray.length();
        String[] strArr = new String[length];
        for (int i = 0; i < length; i++) {
            strArr[i] = jSONArray.getString(i);
        }
        String[] h2 = h(context.getPackageManager().getPackageInfo(str, 64).signatures);
        if (h2 != null && h2.length > 0) {
            Collections.addAll(set, h2);
        }
        return g(strArr, h2);
    }

    public static boolean g(String[] strArr, String[] strArr2) {
        if (strArr == null || strArr2 == null || strArr.length != strArr2.length) {
            return false;
        }
        HashSet hashSet = new HashSet();
        for (String str : strArr) {
            hashSet.add(str);
        }
        HashSet hashSet2 = new HashSet();
        for (String str2 : strArr2) {
            hashSet2.add(str2);
        }
        return hashSet.equals(hashSet2);
    }

    public static String[] h(Signature[] signatureArr) {
        int length = signatureArr.length;
        String[] strArr = new String[length];
        for (int i = 0; i < length; i++) {
            strArr[i] = f.c(signatureArr[i].toByteArray());
        }
        return strArr;
    }

    public final void a(Bundle bundle, d.b.q.g.b.e.a aVar) {
        try {
            if (aVar == null) {
                this.f64548f |= 16;
                return;
            }
            String string = bundle.getString("helios_data");
            if (TextUtils.isEmpty(string)) {
                this.f64548f |= 1;
                return;
            }
            String string2 = bundle.getString("helios_sf");
            if (TextUtils.isEmpty(string2)) {
                this.f64548f |= 2;
                return;
            }
            byte[] decode = Base64.decode(string.getBytes("utf-8"), 1);
            for (int i = 0; i < decode.length; i++) {
                decode[i] = (byte) (decode[i] ^ f64542g[i % f64542g.length]);
            }
            JSONObject jSONObject = new JSONObject(new String(decode));
            if (f(jSONObject)) {
                HashSet hashSet = new HashSet();
                this.f64545c = hashSet;
                if (!e(this.f64546d, this.f64547e, jSONObject, hashSet)) {
                    this.f64548f |= 4;
                } else if (!Arrays.equals(g.a(Base64.decode(string2, 0), aVar), f.b(decode))) {
                    this.f64548f |= 8;
                } else {
                    this.f64543a = jSONObject.getLong("priority");
                    this.f64544b = true;
                }
            }
        } catch (Exception e2) {
            this.f64548f |= 256;
            Log.getStackTraceString(e2);
        }
    }

    public void b(d.b.q.g.b.e.a aVar, boolean z) {
        PackageInfo packageInfo;
        ActivityInfo[] activityInfoArr;
        ActivityInfo activityInfo;
        Bundle bundle;
        PackageManager packageManager = this.f64547e.getPackageManager();
        try {
            packageInfo = packageManager.getPackageInfo(this.f64546d, 2);
        } catch (PackageManager.NameNotFoundException unused) {
            packageInfo = null;
        }
        if (packageInfo == null || (activityInfoArr = packageInfo.receivers) == null || activityInfoArr.length <= 0) {
            return;
        }
        for (ActivityInfo activityInfo2 : activityInfoArr) {
            if ("com.baidu.helios.DummyProvider".equals(activityInfo2.name)) {
                try {
                    activityInfo = packageManager.getReceiverInfo(new ComponentName(activityInfo2.packageName, activityInfo2.name), 128);
                } catch (PackageManager.NameNotFoundException unused2) {
                    activityInfo = null;
                }
                if (activityInfo != null && (bundle = activityInfo.metaData) != null && bundle.containsKey("helios") && z) {
                    a(bundle, aVar);
                }
            }
        }
    }

    public void c(String str, Context context) {
        this.f64546d = str;
        this.f64547e = context;
    }

    public boolean d() {
        return this.f64544b;
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x003d, code lost:
        if (r10.equals(r9.f64546d) == false) goto L13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0052, code lost:
        if (r0.startsWith(r10) != false) goto L14;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean f(JSONObject jSONObject) {
        int i;
        e eVar = new e();
        eVar.b(jSONObject.optLong("flags"));
        String optString = jSONObject.optString("package", "");
        long a2 = eVar.a(7L);
        if (!optString.equals("") || a2 == 4) {
            if (a2 != 0) {
                if (a2 == 1) {
                    String str = this.f64546d;
                    if (str != null) {
                    }
                    i = this.f64548f | 32;
                    this.f64548f = i;
                    return false;
                } else if (a2 == 2) {
                    try {
                        if (!Pattern.compile(optString).matcher(this.f64546d).matches()) {
                            this.f64548f |= 32;
                            return false;
                        }
                    } catch (Exception unused) {
                        i = this.f64548f | 128;
                    }
                } else if (a2 == 4) {
                    return true;
                }
                return true;
            }
        }
        i = this.f64548f | 64;
        this.f64548f = i;
        return false;
    }

    public long i() {
        return this.f64543a;
    }

    public Set<String> j() {
        return this.f64545c;
    }
}
