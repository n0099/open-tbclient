package com.kwad.components.core.widget.kwai;

import android.view.View;
import androidx.annotation.NonNull;
/* loaded from: classes9.dex */
public class b extends a {
    public View mRootView;

    public b(@NonNull View view2, int i) {
        super(view2, i);
        this.mRootView = view2;
    }

    @Override // com.kwad.components.core.widget.kwai.a
    public boolean dK() {
        return com.kwad.sdk.b.kwai.a.a(this.mRootView, 70, true);
    }
}
