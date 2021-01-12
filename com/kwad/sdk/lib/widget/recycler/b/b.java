package com.kwad.sdk.lib.widget.recycler.b;

import com.kwad.sdk.lib.widget.recycler.b.a;
import com.kwad.sdk.lib.widget.recycler.b.a.C1137a;
import com.kwad.sdk.mvp.Presenter;
/* loaded from: classes4.dex */
public abstract class b<MODEL, CallerContext extends a.C1137a<MODEL>> extends Presenter {

    /* renamed from: a  reason: collision with root package name */
    protected CallerContext f10452a;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        this.f10452a = (CallerContext) n();
    }
}
