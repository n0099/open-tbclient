package com.repackage;

import android.app.Activity;
import android.content.Intent;
import androidx.annotation.NonNull;
/* loaded from: classes7.dex */
public interface y21 {
    void doFinish();

    @NonNull
    Activity getActivity();

    @NonNull
    Intent getIntent();

    boolean handleSetContentView();
}
