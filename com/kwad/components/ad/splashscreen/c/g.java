package com.kwad.components.ad.splashscreen.c;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.baidu.tieba.R;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.utils.bn;
/* loaded from: classes10.dex */
public final class g extends e {
    private void kX() {
        bn.postOnUiThread(new Runnable() { // from class: com.kwad.components.ad.splashscreen.c.g.1
            @Override // java.lang.Runnable
            public final void run() {
                if (g.this.getActivity() != null) {
                    try {
                        ViewGroup viewGroup = (ViewGroup) g.this.getActivity().getWindow().getDecorView();
                        if (com.kwad.sdk.d.a.a.C(viewGroup) && com.kwad.sdk.d.a.a.aH(g.this.getActivity()) == viewGroup.getHeight()) {
                            g.this.kY();
                        }
                    } catch (Throwable unused) {
                    }
                }
            }
        });
    }

    @Override // com.kwad.components.ad.splashscreen.c.e, com.kwad.sdk.mvp.Presenter
    public final void aj() {
        super.aj();
        kX();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
    }

    private int x(AdInfo adInfo) {
        int a;
        int statusBarHeight;
        if (com.kwad.components.ad.splashscreen.f.c.z(adInfo)) {
            a = com.kwad.sdk.d.a.a.a(getActivity(), 32.0f);
            statusBarHeight = com.kwad.sdk.d.a.a.getStatusBarHeight(getActivity());
        } else {
            a = com.kwad.sdk.d.a.a.a(getActivity(), 16.0f);
            statusBarHeight = com.kwad.sdk.d.a.a.getStatusBarHeight(getActivity());
        }
        return a + statusBarHeight;
    }

    public static void j(View view2, int i) {
        if (view2.getLayoutParams() instanceof FrameLayout.LayoutParams) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view2.getLayoutParams();
            layoutParams.topMargin = i;
            view2.setLayoutParams(layoutParams);
        } else if (view2.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) view2.getLayoutParams();
            layoutParams2.topMargin = i;
            view2.setLayoutParams(layoutParams2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kY() {
        int i;
        if (getContext() == null) {
            return;
        }
        AdInfo dP = com.kwad.sdk.core.response.b.e.dP(this.Df.mAdTemplate);
        if (com.kwad.components.ad.splashscreen.f.c.z(dP)) {
            i = R.id.obfuscated_res_0x7f091404;
        } else {
            i = R.id.obfuscated_res_0x7f091403;
        }
        j(findViewById(i), x(dP));
        if (com.kwad.components.ad.splashscreen.f.c.z(dP)) {
            j(findViewById(R.id.obfuscated_res_0x7f0914c5), com.kwad.sdk.d.a.a.getStatusBarHeight(getActivity()) + com.kwad.sdk.d.a.a.a(getContext(), 12.0f));
            j(findViewById(R.id.obfuscated_res_0x7f0914d0), com.kwad.sdk.d.a.a.getStatusBarHeight(getActivity()) + com.kwad.sdk.d.a.a.a(getContext(), 32.0f));
            j(findViewById(R.id.obfuscated_res_0x7f0914a9), com.kwad.sdk.d.a.a.getStatusBarHeight(getActivity()));
        }
    }
}
