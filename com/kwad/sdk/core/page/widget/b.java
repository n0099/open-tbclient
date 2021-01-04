package com.kwad.sdk.core.page.widget;

import android.content.Context;
import android.view.TextureView;
import androidx.annotation.RequiresApi;
@RequiresApi(api = 14)
/* loaded from: classes5.dex */
public class b extends TextureView {
    public b(Context context) {
        super(context);
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        try {
            super.onDetachedFromWindow();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
