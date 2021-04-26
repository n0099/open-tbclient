package com.kwad.sdk.core.page.a;

import android.content.Context;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.kwad.sdk.api.KsAdVideoPlayConfig;
import com.kwad.sdk.core.page.recycle.e;
import com.kwad.sdk.core.response.b.c;
import com.kwad.sdk.feed.widget.k;
import com.kwad.sdk.mvp.Presenter;
/* loaded from: classes6.dex */
public class a extends Presenter {

    /* renamed from: a  reason: collision with root package name */
    public int f33261a;

    @Override // com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        final e eVar = (e) k();
        KsAdVideoPlayConfig build = new KsAdVideoPlayConfig.Builder().videoSoundEnable(true).build();
        k kVar = (k) i();
        kVar.a(eVar.f33307c);
        kVar.a(build);
        kVar.setVisibility(0);
        kVar.setOnEndBtnClickListener(new View.OnClickListener() { // from class: com.kwad.sdk.core.page.a.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (com.kwad.sdk.core.response.b.a.v(c.g(eVar.f33307c))) {
                    com.kwad.sdk.core.download.b.b bVar = eVar.f33305a;
                    if (bVar != null) {
                        bVar.a((Context) a.this.j(), false);
                        return;
                    }
                    return;
                }
                RecyclerView recyclerView = eVar.f33306b;
                if (recyclerView == null || recyclerView.getAdapter() == null || eVar.f33306b.getAdapter().getItemCount() <= 1) {
                    return;
                }
                eVar.f33306b.scrollToPosition(1);
            }
        });
        kVar.setWindowFullScreenListener(new k.a() { // from class: com.kwad.sdk.core.page.a.a.2
            @Override // com.kwad.sdk.feed.widget.k.a
            public void a() {
                a.this.f33261a = eVar.f33306b.computeVerticalScrollOffset();
            }

            @Override // com.kwad.sdk.feed.widget.k.a
            public void b() {
                eVar.f33306b.scrollToPosition(a.this.f33261a);
            }
        });
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b() {
        super.b();
    }
}
