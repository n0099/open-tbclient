package com.repackage;

import androidx.annotation.AnyThread;
import androidx.annotation.NonNull;
import androidx.annotation.UiThread;
/* loaded from: classes6.dex */
public interface ou2 {
    @UiThread
    void a(String str);

    @UiThread
    void b();

    void c(@NonNull Runnable runnable, @NonNull String str);

    @UiThread
    void d(boolean z);

    @AnyThread
    void e(String str);

    String getName();
}
