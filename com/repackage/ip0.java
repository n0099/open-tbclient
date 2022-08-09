package com.repackage;

import android.content.Context;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.nadcore.player.strategy.IVideoUpdateStrategy;
/* loaded from: classes6.dex */
public interface ip0 extends ep0, gp0 {
    public static final a a = d41.a;

    /* loaded from: classes6.dex */
    public interface a {
        ip0 a(Context context, int i);

        ip0 b(Context context, int i, @Nullable jp0 jp0Var);
    }

    void a(fp0 fp0Var);

    void attachToContainer(@NonNull ViewGroup viewGroup);

    void c(@NonNull jn0 jn0Var);

    void d(@NonNull IVideoUpdateStrategy iVideoUpdateStrategy);

    void release();
}
