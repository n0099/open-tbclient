package com.kwad.sdk.core.page.widget;

import android.content.Context;
import android.view.TextureView;
import androidx.annotation.RequiresApi;
@RequiresApi(api = 14)
/* loaded from: classes7.dex */
public class c extends TextureView {
    public c(Context context) {
        super(context);
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        try {
            super.onDetachedFromWindow();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
