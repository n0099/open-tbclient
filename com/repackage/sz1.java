package com.repackage;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;
import com.repackage.rz1;
/* loaded from: classes7.dex */
public interface sz1<T extends rz1> {
    void a(@NonNull Handler handler);

    void b(T t);

    Looper getLooper();
}
