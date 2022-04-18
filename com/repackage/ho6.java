package com.repackage;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.shrinkhead.LogicField;
import tbclient.ThemeElement;
/* loaded from: classes6.dex */
public interface ho6 extends po6 {
    @Override // com.repackage.po6
    @Nullable
    <T> T a(@NonNull LogicField logicField);

    void b(boolean z);

    void e(@NonNull ThemeElement themeElement);

    void f(@NonNull FrsFragment frsFragment, @NonNull View view2);

    @NonNull
    mo6 h();

    void i(@Nullable Integer num, @Nullable Integer num2, boolean z);

    View m();

    int n(@NonNull LogicField logicField);
}
