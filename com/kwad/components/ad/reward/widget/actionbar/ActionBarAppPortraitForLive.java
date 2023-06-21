package com.kwad.components.ad.reward.widget.actionbar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.tieba.R;
import com.kwad.components.ad.reward.k;
import com.kwad.components.ad.widget.DownloadProgressView;
import com.kwad.components.core.c.a.a;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.widget.c;
import com.kwad.sdk.widget.f;
/* loaded from: classes9.dex */
public class ActionBarAppPortraitForLive extends LinearLayout implements c {
    public DownloadProgressView dk;
    public AdTemplate mAdTemplate;
    public com.kwad.components.core.c.a.c mApkDownloadHelper;
    public k nM;
    public a wO;

    /* loaded from: classes9.dex */
    public interface a {
        void R(boolean z);
    }

    public ActionBarAppPortraitForLive(Context context) {
        this(context, null);
    }

    public ActionBarAppPortraitForLive(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ActionBarAppPortraitForLive(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        initView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(View view2, final boolean z) {
        com.kwad.components.core.c.a.a.a(new a.C0631a(view2.getContext()).L(this.mAdTemplate).b(this.mApkDownloadHelper).aj(true).l(this.nM.eF.getPlayDuration()).ae(view2 == this.dk ? 1 : 2).a(new a.b() { // from class: com.kwad.components.ad.reward.widget.actionbar.ActionBarAppPortraitForLive.2
            @Override // com.kwad.components.core.c.a.a.b
            public final void onAdClicked() {
                if (ActionBarAppPortraitForLive.this.wO != null) {
                    ActionBarAppPortraitForLive.this.wO.R(z);
                }
            }
        }));
    }

    private void initView() {
        LinearLayout.inflate(getContext(), R.layout.obfuscated_res_0x7f0d04e1, this);
        this.dk = (DownloadProgressView) findViewById(R.id.obfuscated_res_0x7f091332);
    }

    public final void a(@NonNull k kVar, @NonNull AdTemplate adTemplate, @Nullable com.kwad.components.core.c.a.c cVar, a aVar) {
        this.nM = kVar;
        this.mAdTemplate = adTemplate;
        this.wO = aVar;
        this.mApkDownloadHelper = cVar;
        this.dk.F(adTemplate);
        if (this.mApkDownloadHelper != null) {
            cVar.b(this.dk.getAppDownloadListener());
            cVar.d(this.dk.getAppDownloadListener());
        }
        setClickable(true);
        this.dk.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.ad.reward.widget.actionbar.ActionBarAppPortraitForLive.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                ActionBarAppPortraitForLive.this.b(view2, true);
            }
        });
        new f(this, this);
    }

    @Override // com.kwad.sdk.widget.c
    public final void f(View view2) {
        b(view2, true);
    }

    @Override // com.kwad.sdk.widget.c
    public final void g(View view2) {
        if (com.kwad.sdk.core.response.a.c.bF(this.mAdTemplate)) {
            b(view2, false);
        }
    }
}
