package com.repackage;

import android.content.Context;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.nadcore.player.strategy.IVideoUpdateStrategy;
/* loaded from: classes7.dex */
public interface so0 extends oo0, qo0 {
    public static final a a = w21.a;

    /* loaded from: classes7.dex */
    public interface a {
        so0 a(Context context, int i);

        so0 b(Context context, int i, @Nullable to0 to0Var);
    }

    void a(po0 po0Var);

    void attachToContainer(@NonNull ViewGroup viewGroup);

    void c(@NonNull vm0 vm0Var);

    void d(@NonNull IVideoUpdateStrategy iVideoUpdateStrategy);

    void release();
}
