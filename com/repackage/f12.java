package com.repackage;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;
import com.repackage.e12;
/* loaded from: classes6.dex */
public interface f12<T extends e12> {
    void a(@NonNull Handler handler);

    void b(T t);

    Looper getLooper();
}
