package com.repackage;

import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
/* loaded from: classes7.dex */
public interface ui0<VIEW extends View> {
    void b(@NonNull ViewGroup viewGroup);

    @NonNull
    VIEW getRealView();

    void update(String str, @NonNull ei0 ei0Var);
}
