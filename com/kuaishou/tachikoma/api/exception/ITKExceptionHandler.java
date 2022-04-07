package com.kuaishou.tachikoma.api.exception;

import androidx.annotation.Nullable;
import com.kuaishou.tachikoma.api.model.TKBundle;
/* loaded from: classes5.dex */
public interface ITKExceptionHandler {
    void handleException(Throwable th, @Nullable TKBundle tKBundle);
}
