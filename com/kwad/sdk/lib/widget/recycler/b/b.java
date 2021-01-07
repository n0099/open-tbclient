package com.kwad.sdk.lib.widget.recycler.b;

import com.kwad.sdk.lib.widget.recycler.b.a;
import com.kwad.sdk.lib.widget.recycler.b.a.C1154a;
import com.kwad.sdk.mvp.Presenter;
/* loaded from: classes5.dex */
public abstract class b<MODEL, CallerContext extends a.C1154a<MODEL>> extends Presenter {

    /* renamed from: a  reason: collision with root package name */
    protected CallerContext f10752a;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        this.f10752a = (CallerContext) n();
    }
}
