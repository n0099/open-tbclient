package com.repackage;

import android.content.Context;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.nadcore.player.strategy.IVideoUpdateStrategy;
/* loaded from: classes7.dex */
public interface wo0 extends so0, uo0 {
    public static final a a = a31.a;

    /* loaded from: classes7.dex */
    public interface a {
        wo0 a(Context context, int i);

        wo0 b(Context context, int i, @Nullable xo0 xo0Var);
    }

    void a(to0 to0Var);

    void attachToContainer(@NonNull ViewGroup viewGroup);

    void c(@NonNull zm0 zm0Var);

    void d(@NonNull IVideoUpdateStrategy iVideoUpdateStrategy);

    void release();
}
