package com.repackage;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.shrinkhead.LogicField;
import tbclient.ThemeElement;
/* loaded from: classes7.dex */
public interface wm6 {
    @Nullable
    <T> T a(@NonNull LogicField logicField);

    void b(boolean z);

    void c(float f);

    void d(int i, boolean z);

    void e(@NonNull ThemeElement themeElement);

    @NonNull
    NavigationBar f();

    @Nullable
    cn6 g();

    void h(boolean z);

    int i();

    void j(@NonNull FrsFragment frsFragment, @NonNull View view2, @NonNull View.OnClickListener onClickListener);

    @Nullable
    zm6 k();

    void onChangeSkinType(int i);
}
