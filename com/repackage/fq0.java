package com.repackage;

import android.content.Context;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.nadcore.player.strategy.IVideoUpdateStrategy;
/* loaded from: classes6.dex */
public interface fq0 extends bq0, dq0 {
    public static final a a = y31.a;

    /* loaded from: classes6.dex */
    public interface a {
        fq0 a(Context context, int i);

        fq0 b(Context context, int i, @Nullable gq0 gq0Var);
    }

    void a(cq0 cq0Var);

    void attachToContainer(@NonNull ViewGroup viewGroup);

    void c(@NonNull io0 io0Var);

    void d(@NonNull IVideoUpdateStrategy iVideoUpdateStrategy);

    void release();
}
