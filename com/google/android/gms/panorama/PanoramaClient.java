package com.google.android.gms.panorama;

import android.content.Intent;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesClient;
/* loaded from: classes.dex */
public class PanoramaClient implements GooglePlayServicesClient {

    /* loaded from: classes.dex */
    public interface OnPanoramaInfoLoadedListener {
        void a(ConnectionResult connectionResult, Intent intent);
    }

    /* loaded from: classes.dex */
    public interface a {
        void a(ConnectionResult connectionResult, int i, Intent intent);
    }
}
