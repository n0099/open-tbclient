package com.repackage;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.tieba.frs.shrinkhead.LogicField;
/* loaded from: classes7.dex */
public interface wl6 {
    @Nullable
    <T> T a(@NonNull LogicField logicField);

    void c(boolean z);

    void d(View.OnClickListener onClickListener);

    void g(int i, @NonNull String str);

    void j(long j, long j2);

    void k(@Nullable String str, @NonNull String str2);

    void l(@NonNull LogicField logicField, int i);

    void onChangeSkinType(int i);
}
