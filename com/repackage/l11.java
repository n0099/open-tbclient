package com.repackage;

import android.app.Activity;
import android.content.Intent;
import androidx.annotation.NonNull;
/* loaded from: classes6.dex */
public interface l11 {
    void doFinish();

    @NonNull
    Activity getActivity();

    @NonNull
    Intent getIntent();

    boolean handleSetContentView();
}
