package com.repackage;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;
import com.repackage.r02;
/* loaded from: classes7.dex */
public interface s02<T extends r02> {
    void a(@NonNull Handler handler);

    void b(T t);

    Looper getLooper();
}
