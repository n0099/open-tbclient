package org.chromium.base;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ResolveInfo;
import android.os.BadParcelableException;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.TransactionTooLargeException;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.core.app.BundleCompat;
import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class IntentUtils {
    public static final String ANDROID_APP_REFERRER_SCHEME = "android-app";
    @VisibleForTesting
    public static final String EPHEMERAL_INSTALLER_CLASS = "com.google.android.gms.instantapps.routing.EphemeralInstallerActivity";
    public static final String TAG = "IntentUtils";

    public static <T extends Parcelable> ArrayList<T> getParcelableArrayListExtra(Intent intent, String str) {
        try {
            return intent.getParcelableArrayListExtra(str);
        } catch (Throwable unused) {
            Log.e("IntentUtils", "getParcelableArrayListExtra failed on intent " + intent, new Object[0]);
            return null;
        }
    }

    public static Intent logInvalidIntent(Intent intent, Exception exc) {
        Log.e("IntentUtils", "Invalid incoming intent.", exc);
        return intent.replaceExtras((Bundle) null);
    }

    public static void logTransactionTooLargeOrRethrow(RuntimeException runtimeException, Intent intent) {
        if (runtimeException.getCause() instanceof TransactionTooLargeException) {
            Log.e("IntentUtils", "Could not resolve Activity for intent " + intent.toString(), runtimeException);
            return;
        }
        throw runtimeException;
    }

    public static IBinder safeGetBinder(Bundle bundle, String str) {
        if (bundle == null) {
            return null;
        }
        try {
            return BundleCompat.getBinder(bundle, str);
        } catch (Throwable unused) {
            Log.e("IntentUtils", "getBinder failed on bundle " + bundle, new Object[0]);
            return null;
        }
    }

    public static IBinder safeGetBinderExtra(Intent intent, String str) {
        if (!intent.hasExtra(str)) {
            return null;
        }
        return safeGetBinder(intent.getExtras(), str);
    }

    public static Bundle safeGetBundle(Bundle bundle, String str) {
        try {
            return bundle.getBundle(str);
        } catch (Throwable unused) {
            Log.e("IntentUtils", "getBundle failed on bundle " + bundle, new Object[0]);
            return null;
        }
    }

    public static Bundle safeGetBundleExtra(Intent intent, String str) {
        try {
            return intent.getBundleExtra(str);
        } catch (Throwable unused) {
            Log.e("IntentUtils", "getBundleExtra failed on intent " + intent, new Object[0]);
            return null;
        }
    }

    public static byte[] safeGetByteArrayExtra(Intent intent, String str) {
        try {
            return intent.getByteArrayExtra(str);
        } catch (Throwable unused) {
            Log.e("IntentUtils", "getByteArrayExtra failed on intent " + intent, new Object[0]);
            return null;
        }
    }

    public static float[] safeGetFloatArray(Bundle bundle, String str) {
        try {
            return bundle.getFloatArray(str);
        } catch (Throwable unused) {
            Log.e("IntentUtils", "getFloatArray failed on bundle " + bundle, new Object[0]);
            return null;
        }
    }

    public static int[] safeGetIntArray(Bundle bundle, String str) {
        try {
            return bundle.getIntArray(str);
        } catch (Throwable unused) {
            Log.e("IntentUtils", "getIntArray failed on bundle " + bundle, new Object[0]);
            return null;
        }
    }

    public static int[] safeGetIntArrayExtra(Intent intent, String str) {
        try {
            return intent.getIntArrayExtra(str);
        } catch (Throwable unused) {
            Log.e("IntentUtils", "getIntArrayExtra failed on intent " + intent, new Object[0]);
            return null;
        }
    }

    public static <T extends Parcelable> T safeGetParcelable(Bundle bundle, String str) {
        try {
            return (T) bundle.getParcelable(str);
        } catch (Throwable unused) {
            Log.e("IntentUtils", "getParcelable failed on bundle " + bundle, new Object[0]);
            return null;
        }
    }

    public static Parcelable[] safeGetParcelableArrayExtra(Intent intent, String str) {
        try {
            return intent.getParcelableArrayExtra(str);
        } catch (Throwable unused) {
            Log.e("IntentUtils", "getParcelableArrayExtra failed on intent " + intent, new Object[0]);
            return null;
        }
    }

    public static <T extends Parcelable> ArrayList<T> safeGetParcelableArrayList(Bundle bundle, String str) {
        try {
            return bundle.getParcelableArrayList(str);
        } catch (Throwable unused) {
            Log.e("IntentUtils", "getParcelableArrayList failed on bundle " + bundle, new Object[0]);
            return null;
        }
    }

    public static <T extends Parcelable> T safeGetParcelableExtra(Intent intent, String str) {
        try {
            return (T) intent.getParcelableExtra(str);
        } catch (Throwable unused) {
            Log.e("IntentUtils", "getParcelableExtra failed on intent " + intent, new Object[0]);
            return null;
        }
    }

    public static String safeGetString(Bundle bundle, String str) {
        try {
            return bundle.getString(str);
        } catch (Throwable unused) {
            Log.e("IntentUtils", "getString failed on bundle " + bundle, new Object[0]);
            return null;
        }
    }

    public static ArrayList<String> safeGetStringArrayListExtra(Intent intent, String str) {
        try {
            return intent.getStringArrayListExtra(str);
        } catch (Throwable unused) {
            Log.e("IntentUtils", "getStringArrayListExtra failed on intent " + intent, new Object[0]);
            return null;
        }
    }

    public static String safeGetStringExtra(Intent intent, String str) {
        try {
            return intent.getStringExtra(str);
        } catch (Throwable unused) {
            Log.e("IntentUtils", "getStringExtra failed on intent " + intent, new Object[0]);
            return null;
        }
    }

    public static boolean safeHasExtra(Intent intent, String str) {
        try {
            return intent.hasExtra(str);
        } catch (Throwable unused) {
            Log.e("IntentUtils", "hasExtra failed on intent " + intent, new Object[0]);
            return false;
        }
    }

    public static void safeRemoveExtra(Intent intent, String str) {
        try {
            intent.removeExtra(str);
        } catch (Throwable unused) {
            Log.e("IntentUtils", "removeExtra failed on intent " + intent, new Object[0]);
        }
    }

    public static boolean safeStartActivity(Context context, Intent intent) {
        return safeStartActivity(context, intent, null);
    }

    public static int getParceledIntentSize(Intent intent) {
        Parcel obtain = Parcel.obtain();
        intent.writeToParcel(obtain, 0);
        return obtain.dataSize();
    }

    public static boolean isInstantAppResolveInfo(ResolveInfo resolveInfo) {
        if (resolveInfo == null) {
            return false;
        }
        if (Build.VERSION.SDK_INT >= 26) {
            return resolveInfo.isInstantAppAvailable;
        }
        ActivityInfo activityInfo = resolveInfo.activityInfo;
        if (activityInfo == null) {
            return false;
        }
        return EPHEMERAL_INSTALLER_CLASS.equals(activityInfo.name);
    }

    public static boolean isIntentForNewTaskOrNewDocument(Intent intent) {
        if ((intent.getFlags() & 268959744) != 0) {
            return true;
        }
        return false;
    }

    public static Intent sanitizeIntent(Intent intent) {
        if (intent == null) {
            return null;
        }
        try {
            intent.getBooleanExtra("TriggerUnparcel", false);
            return intent;
        } catch (BadParcelableException e) {
            return logInvalidIntent(intent, e);
        } catch (RuntimeException e2) {
            if (e2.getCause() instanceof ClassNotFoundException) {
                return logInvalidIntent(intent, e2);
            }
            throw e2;
        }
    }

    public static boolean safeGetBoolean(Bundle bundle, String str, boolean z) {
        try {
            return bundle.getBoolean(str, z);
        } catch (Throwable unused) {
            Log.e("IntentUtils", "getBoolean failed on bundle " + bundle, new Object[0]);
            return z;
        }
    }

    public static boolean safeGetBooleanExtra(Intent intent, String str, boolean z) {
        try {
            return intent.getBooleanExtra(str, z);
        } catch (Throwable unused) {
            Log.e("IntentUtils", "getBooleanExtra failed on intent " + intent, new Object[0]);
            return z;
        }
    }

    public static int safeGetInt(Bundle bundle, String str, int i) {
        try {
            return bundle.getInt(str, i);
        } catch (Throwable unused) {
            Log.e("IntentUtils", "getInt failed on bundle " + bundle, new Object[0]);
            return i;
        }
    }

    public static int safeGetIntExtra(Intent intent, String str, int i) {
        try {
            return intent.getIntExtra(str, i);
        } catch (Throwable unused) {
            Log.e("IntentUtils", "getIntExtra failed on intent " + intent, new Object[0]);
            return i;
        }
    }

    public static long safeGetLongExtra(Intent intent, String str, long j) {
        try {
            return intent.getLongExtra(str, j);
        } catch (Throwable unused) {
            Log.e("IntentUtils", "getLongExtra failed on intent " + intent, new Object[0]);
            return j;
        }
    }

    public static void safePutBinderExtra(Intent intent, String str, IBinder iBinder) {
        if (intent == null) {
            return;
        }
        Bundle bundle = new Bundle();
        try {
            BundleCompat.putBinder(bundle, str, iBinder);
        } catch (Throwable unused) {
            Log.e("IntentUtils", "putBinder failed on bundle " + bundle, new Object[0]);
        }
        intent.putExtras(bundle);
    }

    public static boolean safeStartActivity(Context context, Intent intent, @Nullable Bundle bundle) {
        try {
            context.startActivity(intent, bundle);
            return true;
        } catch (ActivityNotFoundException unused) {
            return false;
        }
    }

    public static <T extends Serializable> T safeGetSerializableExtra(Intent intent, String str) {
        try {
            return (T) intent.getSerializableExtra(str);
        } catch (ClassCastException e) {
            Log.e("IntentUtils", "Invalide class for Serializable: " + str, e);
            return null;
        } catch (Throwable unused) {
            Log.e("IntentUtils", "getSerializableExtra failed on intent " + intent, new Object[0]);
            return null;
        }
    }
}
