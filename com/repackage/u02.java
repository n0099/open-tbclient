package com.repackage;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;
import com.repackage.t02;
/* loaded from: classes7.dex */
public interface u02<T extends t02> {
    void a(@NonNull Handler handler);

    void b(T t);

    Looper getLooper();
}
