package com.repackage;

import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
/* loaded from: classes6.dex */
public interface hk0<VIEW extends View> {
    void b(@NonNull ViewGroup viewGroup);

    @NonNull
    VIEW getRealView();

    void update(String str, @NonNull rj0 rj0Var);
}
