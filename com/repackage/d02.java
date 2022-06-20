package com.repackage;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;
import com.repackage.c02;
/* loaded from: classes5.dex */
public interface d02<T extends c02> {
    void a(@NonNull Handler handler);

    void b(T t);

    Looper getLooper();
}
