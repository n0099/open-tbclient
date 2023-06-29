package com.kwad.sdk.api.core.fragment;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
/* loaded from: classes10.dex */
public interface IDialogFragmentLifecycle extends IFragmentLifecycle {
    void onCancel(DialogInterface dialogInterface);

    Dialog onCreateDialog(Bundle bundle);

    void onDismiss(DialogInterface dialogInterface);
}
