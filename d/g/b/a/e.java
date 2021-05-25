package d.g.b.a;

import android.app.PendingIntent;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import com.google.ar.core.ArCoreApk;
import com.google.ar.core.exceptions.UnavailableDeviceNotCompatibleException;
import com.google.ar.core.exceptions.UnavailableUserDeclinedInstallationException;
/* loaded from: classes6.dex */
public class e implements ArCoreApk.a {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ f f66185a;

    public e(f fVar) {
        this.f66185a = fVar;
    }

    public static Uri b(String str) {
        return new Uri.Builder().scheme("content").authority("com.google.ar.core.services.arcorecontentprovider").path(str).build();
    }

    public static ArCoreApk.Availability c(Context context) {
        try {
            if (d(context) != null) {
                return ArCoreApk.Availability.SUPPORTED_APK_TOO_OLD;
            }
            return ArCoreApk.Availability.SUPPORTED_INSTALLED;
        } catch (UnavailableDeviceNotCompatibleException unused) {
            return ArCoreApk.Availability.UNSUPPORTED_DEVICE_NOT_CAPABLE;
        } catch (UnavailableUserDeclinedInstallationException | RuntimeException unused2) {
            return ArCoreApk.Availability.UNKNOWN_ERROR;
        }
    }

    public static PendingIntent d(Context context) {
        try {
            Bundle call = context.getContentResolver().call(b(""), "getSetupIntent", context.getPackageName(), (Bundle) null);
            if (call == null) {
                return null;
            }
            PendingIntent pendingIntent = (PendingIntent) call.getParcelable("intent");
            if (pendingIntent != null) {
                return pendingIntent;
            }
            String string = call.getString("exceptionType", "");
            if (string.isEmpty()) {
                return null;
            }
            if (!string.equals(UnavailableDeviceNotCompatibleException.class.getName())) {
                if (!string.equals(UnavailableUserDeclinedInstallationException.class.getName())) {
                    Class<? extends U> asSubclass = Class.forName(string).asSubclass(RuntimeException.class);
                    String string2 = call.getString("exceptionText", null);
                    if (string2 != null) {
                        throw ((RuntimeException) asSubclass.getConstructor(String.class).newInstance(string2));
                    }
                    throw ((RuntimeException) asSubclass.getConstructor(new Class[0]).newInstance(new Object[0]));
                }
                throw new UnavailableUserDeclinedInstallationException();
            }
            throw new UnavailableDeviceNotCompatibleException();
        } catch (ReflectiveOperationException | RuntimeException e2) {
            Log.i("ARCore-SetupContentResolver", "Post-install failed", e2);
            return null;
        }
    }

    @Override // com.google.ar.core.ArCoreApk.a
    public void a(ArCoreApk.Availability availability) {
        synchronized (this.f66185a) {
            f.c(this.f66185a, availability);
            f.f(this.f66185a, false);
        }
    }
}
