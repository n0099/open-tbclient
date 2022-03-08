package com.kwad.sdk.widget;

import android.app.Dialog;
import android.content.Context;
import androidx.annotation.NonNull;
import com.kwad.sdk.api.loader.Wrapper;
/* loaded from: classes8.dex */
public class a extends Dialog {
    public a(@NonNull Context context) {
        super(Wrapper.wrapContextIfNeed(context));
        requestWindowFeature(1);
    }
}
