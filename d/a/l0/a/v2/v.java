package d.a.l0.a.v2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import com.baidu.android.util.android.IntentUtils;
/* loaded from: classes3.dex */
public class v {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f45492a = d.a.l0.a.k.f43199a;

    public static boolean a(Activity activity) {
        if (activity == null || !b(activity.getIntent())) {
            return false;
        }
        try {
            f.j(activity);
        } catch (Exception unused) {
        }
        return true;
    }

    public static boolean b(Intent intent) {
        if (intent != null) {
            try {
                Bundle extras = intent.getExtras();
                if (extras != null) {
                    extras.isEmpty();
                    return false;
                }
                return false;
            } catch (Throwable unused) {
                return true;
            }
        }
        return false;
    }

    public static boolean c(Bundle bundle, String str, boolean z) {
        try {
            return bundle.getBoolean(str);
        } catch (Throwable unused) {
            if (f45492a) {
                Log.e(IntentUtils.TAG, "getBoolean failed on bundle " + bundle);
            }
            return z;
        }
    }

    public static Bundle d(Bundle bundle, String str) {
        try {
            return bundle.getBundle(str);
        } catch (Throwable unused) {
            if (f45492a) {
                Log.e(IntentUtils.TAG, "getBundle failed on bundle " + bundle);
                return null;
            }
            return null;
        }
    }

    public static Bundle e(Intent intent, String str) {
        try {
            return intent.getBundleExtra(str);
        } catch (Throwable unused) {
            if (f45492a) {
                Log.e(IntentUtils.TAG, "getBundleExtra failed on intent " + intent);
                return null;
            }
            return null;
        }
    }

    public static int f(Bundle bundle, String str, int i2) {
        try {
            return bundle.getInt(str);
        } catch (Throwable unused) {
            if (f45492a) {
                Log.e(IntentUtils.TAG, "getInt failed on bundle " + bundle);
            }
            return i2;
        }
    }

    public static String g(Bundle bundle, String str) {
        try {
            return bundle.getString(str);
        } catch (Throwable unused) {
            if (f45492a) {
                Log.e(IntentUtils.TAG, "getString failed on bundle " + bundle);
                return null;
            }
            return null;
        }
    }

    public static String h(Intent intent, String str) {
        try {
            return intent.getStringExtra(str);
        } catch (Throwable unused) {
            if (f45492a) {
                Log.e(IntentUtils.TAG, "getStringExtra failed on intent " + intent);
                return null;
            }
            return null;
        }
    }

    public static String i(Bundle bundle, String str) {
        try {
            return bundle.getString(str);
        } catch (Throwable unused) {
            if (f45492a) {
                Log.e(IntentUtils.TAG, "getStringExtra failed on bundle " + bundle);
                return null;
            }
            return null;
        }
    }
}
