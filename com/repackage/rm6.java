package com.repackage;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.shrinkhead.LogicField;
import tbclient.ThemeElement;
/* loaded from: classes7.dex */
public interface rm6 extends zm6 {
    @Override // com.repackage.zm6
    @Nullable
    <T> T a(@NonNull LogicField logicField);

    void b(boolean z);

    void e(@NonNull ThemeElement themeElement);

    void f(@NonNull FrsFragment frsFragment, @NonNull View view2);

    @NonNull
    wm6 h();

    void i(@Nullable Integer num, @Nullable Integer num2, boolean z);

    View m();

    int n(@NonNull LogicField logicField);
}
