package com.google.android.gms.common;

import android.app.PendingIntent;
import com.google.android.gms.internal.w;
/* loaded from: classes.dex */
public final class ConnectionResult {
    public static final ConnectionResult a = new ConnectionResult(0, null);
    private final PendingIntent b;
    private final int c;

    public ConnectionResult(int i, PendingIntent pendingIntent) {
        this.c = i;
        this.b = pendingIntent;
    }

    private String b() {
        switch (this.c) {
            case 0:
                return "SUCCESS";
            case 1:
                return "SERVICE_MISSING";
            case 2:
                return "SERVICE_VERSION_UPDATE_REQUIRED";
            case 3:
                return "SERVICE_DISABLED";
            case 4:
                return "SIGN_IN_REQUIRED";
            case 5:
                return "INVALID_ACCOUNT";
            case 6:
                return "RESOLUTION_REQUIRED";
            case 7:
                return "NETWORK_ERROR";
            case 8:
                return "INTERNAL_ERROR";
            case 9:
                return "SERVICE_INVALID";
            case 10:
                return "DEVELOPER_ERROR";
            default:
                return "unknown status code " + this.c;
        }
    }

    public boolean a() {
        return this.c == 0;
    }

    public String toString() {
        return w.a(this).a("statusCode", b()).a("resolution", this.b).toString();
    }
}
