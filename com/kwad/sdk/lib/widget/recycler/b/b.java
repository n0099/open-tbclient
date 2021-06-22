package com.kwad.sdk.lib.widget.recycler.b;

import com.kwad.sdk.lib.widget.recycler.b.a;
import com.kwad.sdk.lib.widget.recycler.b.a.C0431a;
import com.kwad.sdk.mvp.Presenter;
/* loaded from: classes7.dex */
public abstract class b<MODEL, CallerContext extends a.C0431a<MODEL>> extends Presenter {

    /* renamed from: a  reason: collision with root package name */
    public CallerContext f36811a;

    @Override // com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        this.f36811a = (CallerContext) n();
    }
}
