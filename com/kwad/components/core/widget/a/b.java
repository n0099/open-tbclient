package com.kwad.components.core.widget.a;

import android.view.View;
import androidx.annotation.NonNull;
import com.kwad.sdk.utils.bq;
/* loaded from: classes10.dex */
public class b extends a {
    public View mRootView;

    public b(@NonNull View view2, int i) {
        super(view2, i);
        this.mRootView = view2;
    }

    @Override // com.kwad.components.core.widget.a.a
    public boolean dW() {
        return bq.a(this.mRootView, 70, true);
    }
}
