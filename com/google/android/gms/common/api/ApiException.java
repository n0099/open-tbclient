package com.google.android.gms.common.api;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
/* loaded from: classes7.dex */
public class ApiException extends Exception {
    @NonNull
    @Deprecated
    public final Status mStatus;

    @NonNull
    public Status getStatus() {
        return this.mStatus;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public ApiException(@NonNull Status status) {
        super(r3.toString());
        String str;
        int statusCode = status.getStatusCode();
        if (status.getStatusMessage() != null) {
            str = status.getStatusMessage();
        } else {
            str = "";
        }
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 13);
        sb.append(statusCode);
        sb.append(": ");
        sb.append(str);
        this.mStatus = status;
    }

    public int getStatusCode() {
        return this.mStatus.getStatusCode();
    }

    @Nullable
    @Deprecated
    public String getStatusMessage() {
        return this.mStatus.getStatusMessage();
    }
}
