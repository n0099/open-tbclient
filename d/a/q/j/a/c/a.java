package d.a.q.j.a.c;

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
import d.a.q.g.c.a.e;
import d.a.q.g.c.a.f;
import d.a.q.g.c.a.g;
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
    public static final byte[] f63822g = {77, 73, 78, 71};

    /* renamed from: a  reason: collision with root package name */
    public long f63823a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f63824b;

    /* renamed from: c  reason: collision with root package name */
    public Set<String> f63825c;

    /* renamed from: d  reason: collision with root package name */
    public String f63826d;

    /* renamed from: e  reason: collision with root package name */
    public Context f63827e;

    /* renamed from: f  reason: collision with root package name */
    public int f63828f;

    public static boolean e(String str, Context context, JSONObject jSONObject, Set<String> set) {
        JSONArray jSONArray = jSONObject.getJSONArray("sigs");
        int length = jSONArray.length();
        String[] strArr = new String[length];
        for (int i2 = 0; i2 < length; i2++) {
            strArr[i2] = jSONArray.getString(i2);
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
        for (int i2 = 0; i2 < length; i2++) {
            strArr[i2] = f.c(signatureArr[i2].toByteArray());
        }
        return strArr;
    }

    public final void a(Bundle bundle, d.a.q.g.b.e.a aVar) {
        try {
            if (aVar == null) {
                this.f63828f |= 16;
                return;
            }
            String string = bundle.getString("helios_data");
            if (TextUtils.isEmpty(string)) {
                this.f63828f |= 1;
                return;
            }
            String string2 = bundle.getString("helios_sf");
            if (TextUtils.isEmpty(string2)) {
                this.f63828f |= 2;
                return;
            }
            byte[] decode = Base64.decode(string.getBytes("utf-8"), 1);
            for (int i2 = 0; i2 < decode.length; i2++) {
                decode[i2] = (byte) (decode[i2] ^ f63822g[i2 % f63822g.length]);
            }
            JSONObject jSONObject = new JSONObject(new String(decode));
            if (f(jSONObject)) {
                HashSet hashSet = new HashSet();
                this.f63825c = hashSet;
                if (!e(this.f63826d, this.f63827e, jSONObject, hashSet)) {
                    this.f63828f |= 4;
                } else if (!Arrays.equals(g.a(Base64.decode(string2, 0), aVar), f.b(decode))) {
                    this.f63828f |= 8;
                } else {
                    this.f63823a = jSONObject.getLong("priority");
                    this.f63824b = true;
                }
            }
        } catch (Exception e2) {
            this.f63828f |= 256;
            Log.getStackTraceString(e2);
        }
    }

    public void b(d.a.q.g.b.e.a aVar, boolean z) {
        PackageInfo packageInfo;
        ActivityInfo[] activityInfoArr;
        ActivityInfo activityInfo;
        Bundle bundle;
        PackageManager packageManager = this.f63827e.getPackageManager();
        try {
            packageInfo = packageManager.getPackageInfo(this.f63826d, 2);
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
        this.f63826d = str;
        this.f63827e = context;
    }

    public boolean d() {
        return this.f63824b;
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x003d, code lost:
        if (r10.equals(r9.f63826d) == false) goto L13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0052, code lost:
        if (r0.startsWith(r10) != false) goto L14;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean f(JSONObject jSONObject) {
        int i2;
        e eVar = new e();
        eVar.b(jSONObject.optLong("flags"));
        String optString = jSONObject.optString("package", "");
        long a2 = eVar.a(7L);
        if (!optString.equals("") || a2 == 4) {
            if (a2 != 0) {
                if (a2 == 1) {
                    String str = this.f63826d;
                    if (str != null) {
                    }
                    i2 = this.f63828f | 32;
                    this.f63828f = i2;
                    return false;
                } else if (a2 == 2) {
                    try {
                        if (!Pattern.compile(optString).matcher(this.f63826d).matches()) {
                            this.f63828f |= 32;
                            return false;
                        }
                    } catch (Exception unused) {
                        i2 = this.f63828f | 128;
                    }
                } else if (a2 == 4) {
                    return true;
                }
                return true;
            }
        }
        i2 = this.f63828f | 64;
        this.f63828f = i2;
        return false;
    }

    public long i() {
        return this.f63823a;
    }

    public Set<String> j() {
        return this.f63825c;
    }
}
