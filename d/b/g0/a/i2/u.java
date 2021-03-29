package d.b.g0.a.i2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
/* loaded from: classes3.dex */
public class u {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f44788a = d.b.g0.a.k.f45051a;

    public static boolean a(Activity activity) {
        if (activity == null || !b(activity.getIntent())) {
            return false;
        }
        try {
            e.i(activity);
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
            } catch (Exception unused) {
                return true;
            }
        }
        return false;
    }

    public static boolean c(Bundle bundle, String str, boolean z) {
        try {
            return bundle.getBoolean(str);
        } catch (Throwable unused) {
            if (f44788a) {
                Log.e("IntentUtils", "getBoolean failed on bundle " + bundle);
            }
            return z;
        }
    }

    public static Bundle d(Bundle bundle, String str) {
        try {
            return bundle.getBundle(str);
        } catch (Throwable unused) {
            if (f44788a) {
                Log.e("IntentUtils", "getBundle failed on bundle " + bundle);
                return null;
            }
            return null;
        }
    }

    public static Bundle e(Intent intent, String str) {
        try {
            return intent.getBundleExtra(str);
        } catch (Throwable unused) {
            if (f44788a) {
                Log.e("IntentUtils", "getBundleExtra failed on intent " + intent);
                return null;
            }
            return null;
        }
    }

    public static int f(Bundle bundle, String str, int i) {
        try {
            return bundle.getInt(str);
        } catch (Throwable unused) {
            if (f44788a) {
                Log.e("IntentUtils", "getInt failed on bundle " + bundle);
            }
            return i;
        }
    }

    public static String g(Bundle bundle, String str) {
        try {
            return bundle.getString(str);
        } catch (Throwable unused) {
            if (f44788a) {
                Log.e("IntentUtils", "getString failed on bundle " + bundle);
                return null;
            }
            return null;
        }
    }

    public static String h(Intent intent, String str) {
        try {
            return intent.getStringExtra(str);
        } catch (Throwable unused) {
            if (f44788a) {
                Log.e("IntentUtils", "getStringExtra failed on intent " + intent);
                return null;
            }
            return null;
        }
    }

    public static String i(Bundle bundle, String str) {
        try {
            return bundle.getString(str);
        } catch (Throwable unused) {
            if (f44788a) {
                Log.e("IntentUtils", "getStringExtra failed on bundle " + bundle);
                return null;
            }
            return null;
        }
    }
}
