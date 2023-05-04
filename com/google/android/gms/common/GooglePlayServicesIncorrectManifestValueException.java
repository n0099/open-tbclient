package com.google.android.gms.common;

import android.support.v4.media.session.MediaSessionCompat;
import com.google.android.gms.common.annotation.KeepName;
@KeepName
/* loaded from: classes8.dex */
public final class GooglePlayServicesIncorrectManifestValueException extends GooglePlayServicesManifestException {
    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public GooglePlayServicesIncorrectManifestValueException(int i) {
        super(i, r1.toString());
        int i2 = GoogleApiAvailabilityLight.GOOGLE_PLAY_SERVICES_VERSION_CODE;
        StringBuilder sb = new StringBuilder((int) MediaSessionCompat.MAX_BITMAP_SIZE_IN_DP);
        sb.append("The meta-data tag in your app's AndroidManifest.xml does not have the right value.  Expected ");
        sb.append(i2);
        sb.append(" but found ");
        sb.append(i);
        sb.append(".  You must have the following declaration within the <application> element:     <meta-data android:name=\"com.google.android.gms.version\" android:value=\"@integer/google_play_services_version\" />");
    }
}
