package com.google.ar.core;

import android.app.PendingIntent;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import com.google.ar.core.ArCoreApk;
import com.google.ar.core.exceptions.UnavailableDeviceNotCompatibleException;
import com.google.ar.core.exceptions.UnavailableUserDeclinedInstallationException;
/* loaded from: classes11.dex */
class n implements ArCoreApk.a {
    final /* synthetic */ o nCE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ArCoreApk.Availability gx(Context context) {
        ArCoreApk.Availability availability;
        try {
            if (gy(context) != null) {
                availability = ArCoreApk.Availability.SUPPORTED_APK_TOO_OLD;
            } else {
                availability = ArCoreApk.Availability.SUPPORTED_INSTALLED;
            }
            return availability;
        } catch (UnavailableDeviceNotCompatibleException e) {
            return ArCoreApk.Availability.UNSUPPORTED_DEVICE_NOT_CAPABLE;
        } catch (UnavailableUserDeclinedInstallationException e2) {
            return ArCoreApk.Availability.UNKNOWN_ERROR;
        } catch (RuntimeException e3) {
            return ArCoreApk.Availability.UNKNOWN_ERROR;
        }
    }

    static PendingIntent gy(Context context) throws UnavailableDeviceNotCompatibleException, UnavailableUserDeclinedInstallationException {
        try {
            Bundle call = context.getContentResolver().call(UO(""), "getSetupIntent", context.getPackageName(), (Bundle) null);
            if (call == null) {
                return null;
            }
            PendingIntent pendingIntent = (PendingIntent) call.getParcelable("intent");
            if (pendingIntent == null) {
                String string = call.getString("exceptionType", "");
                if (string.isEmpty()) {
                    return null;
                }
                if (string.equals(UnavailableDeviceNotCompatibleException.class.getName())) {
                    throw new UnavailableDeviceNotCompatibleException();
                }
                if (string.equals(UnavailableUserDeclinedInstallationException.class.getName())) {
                    throw new UnavailableUserDeclinedInstallationException();
                }
                Class<? extends U> asSubclass = Class.forName(string).asSubclass(RuntimeException.class);
                String string2 = call.getString("exceptionText", null);
                if (string2 != null) {
                    throw ((RuntimeException) asSubclass.getConstructor(String.class).newInstance(string2));
                }
                throw ((RuntimeException) asSubclass.getConstructor(new Class[0]).newInstance(new Object[0]));
            }
            return pendingIntent;
        } catch (ReflectiveOperationException e) {
            e = e;
            Log.i("ARCore-SetupContentResolver", "Post-install failed", e);
            return null;
        } catch (RuntimeException e2) {
            e = e2;
            Log.i("ARCore-SetupContentResolver", "Post-install failed", e);
            return null;
        }
    }

    public static Uri UO(String str) {
        return new Uri.Builder().scheme("content").authority("com.google.ar.core.services.arcorecontentprovider").path(str).build();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(o oVar) {
        this.nCE = oVar;
    }

    @Override // com.google.ar.core.ArCoreApk.a
    public void a(ArCoreApk.Availability availability) {
        synchronized (this.nCE) {
            o.a(this.nCE, availability);
            o.a(this.nCE, false);
        }
    }
}
