package com.kwad.sdk.lib.a.a;

import com.kwad.sdk.lib.a.a.b;
import com.kwad.sdk.mvp.Presenter;
/* loaded from: classes3.dex */
public class a<MODEL, CallerContext extends b<?, MODEL>> extends Presenter {
    protected CallerContext b;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        this.b = (CallerContext) n();
    }
}
