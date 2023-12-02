package com.kwad.components.core.r.b;

import android.view.View;
import android.widget.FrameLayout;
import com.baidu.tieba.R;
import com.kwad.components.core.proxy.c;
import com.kwad.sdk.components.l;
import com.kwad.sdk.mvp.Presenter;
/* loaded from: classes10.dex */
public final class b extends Presenter {
    public FrameLayout SA;
    public com.kwad.components.core.r.a.b SD;
    public l SG;

    public final boolean onBackPressed() {
        l lVar = this.SG;
        if (lVar != null && lVar.onBackPressed()) {
            return true;
        }
        return false;
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void aj() {
        super.aj();
        this.SD = (com.kwad.components.core.r.a.b) HU();
        this.SA = (FrameLayout) findViewById(R.id.obfuscated_res_0x7f09139b);
        this.SG = this.SD.Su.a(null);
        this.SD.Mm.add(new com.kwad.components.core.l.a.a() { // from class: com.kwad.components.core.r.b.b.1
            @Override // com.kwad.components.core.l.a.a
            public final void c(c cVar) {
            }

            @Override // com.kwad.components.core.l.a.a
            public final void d(c cVar) {
            }

            @Override // com.kwad.components.core.l.a.a
            public final void fN() {
            }

            @Override // com.kwad.components.core.l.a.a
            public final void fO() {
                if (b.this.SD.St != null) {
                    b.this.SD.St.callbackDismiss();
                }
            }
        });
        if (this.SG == null) {
            if (getActivity() != null) {
                getActivity().finish();
                return;
            }
            return;
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        View view2 = this.SG.getView();
        view2.setLayoutParams(layoutParams);
        this.SA.addView(view2);
        this.SG.bindActivity(getActivity());
        this.SG.render();
    }
}
