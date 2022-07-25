package com.repackage;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;
import com.repackage.s02;
/* loaded from: classes7.dex */
public interface t02<T extends s02> {
    void a(@NonNull Handler handler);

    void b(T t);

    Looper getLooper();
}
