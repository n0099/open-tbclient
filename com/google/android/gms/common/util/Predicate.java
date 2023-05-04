package com.google.android.gms.common.util;

import androidx.annotation.NonNull;
import com.google.android.gms.common.annotation.KeepForSdk;
@KeepForSdk
/* loaded from: classes8.dex */
public interface Predicate<T> {
    @KeepForSdk
    boolean apply(@NonNull T t);
}
