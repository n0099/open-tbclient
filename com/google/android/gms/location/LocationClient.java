package com.google.android.gms.location;

import android.app.PendingIntent;
import com.google.android.gms.common.GooglePlayServicesClient;
/* loaded from: classes.dex */
public class LocationClient implements GooglePlayServicesClient {

    /* loaded from: classes.dex */
    public interface OnAddGeofencesResultListener {
        void a(int i, String[] strArr);
    }

    /* loaded from: classes.dex */
    public interface OnRemoveGeofencesResultListener {
        void a(int i, PendingIntent pendingIntent);

        void a(int i, String[] strArr);
    }
}
