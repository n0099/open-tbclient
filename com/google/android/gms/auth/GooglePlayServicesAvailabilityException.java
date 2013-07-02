package com.google.android.gms.auth;

import android.content.Intent;
/* loaded from: classes.dex */
public class GooglePlayServicesAvailabilityException extends UserRecoverableAuthException {
    private final int A;

    GooglePlayServicesAvailabilityException(int i, String str, Intent intent) {
        super(str, intent);
        this.A = i;
    }

    public int getConnectionStatusCode() {
        return this.A;
    }
}
