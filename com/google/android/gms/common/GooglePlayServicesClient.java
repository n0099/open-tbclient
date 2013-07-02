package com.google.android.gms.common;

import android.os.Bundle;
/* loaded from: classes.dex */
public interface GooglePlayServicesClient {

    /* loaded from: classes.dex */
    public interface ConnectionCallbacks {
        void a();

        void a(Bundle bundle);
    }

    /* loaded from: classes.dex */
    public interface OnConnectionFailedListener {
        void a(ConnectionResult connectionResult);
    }
}
