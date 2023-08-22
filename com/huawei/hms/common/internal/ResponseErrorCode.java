package com.huawei.hms.common.internal;

import android.os.Parcelable;
/* loaded from: classes10.dex */
public interface ResponseErrorCode {
    int getErrorCode();

    String getErrorReason();

    Parcelable getParcelable();

    String getResolution();

    int getStatusCode();

    String getTransactionId();

    boolean hasResolution();
}
