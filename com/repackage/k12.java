package com.repackage;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;
import com.repackage.j12;
/* loaded from: classes6.dex */
public interface k12<T extends j12> {
    void a(@NonNull Handler handler);

    void b(T t);

    Looper getLooper();
}
