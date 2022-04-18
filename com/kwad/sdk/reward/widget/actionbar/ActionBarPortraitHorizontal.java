package com.kwad.sdk.reward.widget.actionbar;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.tieba.R;
import com.kwad.sdk.api.KsAppDownloadListener;
import com.kwad.sdk.core.download.a.a;
import com.kwad.sdk.core.download.a.b;
import com.kwad.sdk.core.download.a.c;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.page.widget.TextProgressBar;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.reward.widget.AppScoreView;
import com.kwad.sdk.widget.KsLogoView;
import com.kwad.sdk.widget.d;
import com.kwad.sdk.widget.f;
/* loaded from: classes5.dex */
public class ActionBarPortraitHorizontal extends FrameLayout implements d {
    public ViewGroup a;
    public ViewGroup b;
    public ImageView c;
    public AppScoreView d;
    public TextView e;
    public View f;
    public ViewGroup g;
    public TextView h;
    public TextView i;
    public TextView j;
    public TextProgressBar k;
    public View l;
    public AdTemplate m;
    public AdInfo n;
    public a o;
    public b p;
    public KsAppDownloadListener q;
    public KsLogoView r;

    /* loaded from: classes5.dex */
    public interface a {
        void a(boolean z);
    }

    public ActionBarPortraitHorizontal(@NonNull Context context) {
        super(context);
        a(context);
    }

    public ActionBarPortraitHorizontal(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context);
    }

    public ActionBarPortraitHorizontal(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a(context);
    }

    private void a(Context context) {
        FrameLayout.inflate(context, R.layout.obfuscated_res_0x7f0d0477, this);
        this.a = (ViewGroup) findViewById(R.id.obfuscated_res_0x7f09114e);
        this.b = (ViewGroup) findViewById(R.id.obfuscated_res_0x7f09114f);
        this.c = (ImageView) findViewById(R.id.obfuscated_res_0x7f091030);
        this.d = (AppScoreView) findViewById(R.id.obfuscated_res_0x7f091033);
        this.e = (TextView) findViewById(R.id.obfuscated_res_0x7f09102f);
        this.f = findViewById(R.id.obfuscated_res_0x7f09116d);
        this.g = (ViewGroup) findViewById(R.id.obfuscated_res_0x7f091041);
        this.h = (TextView) findViewById(R.id.obfuscated_res_0x7f091032);
        this.i = (TextView) findViewById(R.id.obfuscated_res_0x7f0910c0);
        this.j = (TextView) findViewById(R.id.obfuscated_res_0x7f09102b);
        TextProgressBar textProgressBar = (TextProgressBar) findViewById(R.id.obfuscated_res_0x7f09102d);
        this.k = textProgressBar;
        textProgressBar.setTextDimen(com.kwad.sdk.a.kwai.a.a(getContext(), 16.0f));
        this.k.setTextColor(-1);
        View findViewById = findViewById(R.id.obfuscated_res_0x7f09102e);
        this.l = findViewById;
        new f(findViewById, this);
        this.r = (KsLogoView) findViewById(R.id.obfuscated_res_0x7f091007);
    }

    private KsAppDownloadListener getAppDownloadListener() {
        if (this.q == null) {
            this.q = new c() { // from class: com.kwad.sdk.reward.widget.actionbar.ActionBarPortraitHorizontal.1
                @Override // com.kwad.sdk.core.download.a.c
                public void a(int i) {
                    ActionBarPortraitHorizontal.this.k.a(com.kwad.sdk.core.response.a.a.b(i), i);
                    ActionBarPortraitHorizontal.this.l.setVisibility(8);
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public void onDownloadFailed() {
                    ActionBarPortraitHorizontal.this.k.a(com.kwad.sdk.core.response.a.a.A(ActionBarPortraitHorizontal.this.n), 0);
                    ActionBarPortraitHorizontal.this.l.setVisibility(0);
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public void onDownloadFinished() {
                    ActionBarPortraitHorizontal.this.k.a(com.kwad.sdk.core.response.a.a.a(ActionBarPortraitHorizontal.this.m), 0);
                    ActionBarPortraitHorizontal.this.l.setVisibility(0);
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public void onIdle() {
                    ActionBarPortraitHorizontal.this.k.a(com.kwad.sdk.core.response.a.a.A(ActionBarPortraitHorizontal.this.n), 0);
                    ActionBarPortraitHorizontal.this.l.setVisibility(0);
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public void onInstalled() {
                    ActionBarPortraitHorizontal.this.k.a(com.kwad.sdk.core.response.a.a.m(ActionBarPortraitHorizontal.this.n), 0);
                    ActionBarPortraitHorizontal.this.l.setVisibility(0);
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public void onProgressUpdate(int i) {
                    ActionBarPortraitHorizontal.this.k.a(com.kwad.sdk.core.response.a.a.a(i), i);
                    ActionBarPortraitHorizontal.this.l.setVisibility(8);
                }
            };
        }
        return this.q;
    }

    public void a(View view2, final boolean z) {
        com.kwad.sdk.core.download.a.a.a(new a.C0296a(view2.getContext()).a(this.m).a(new a.b() { // from class: com.kwad.sdk.reward.widget.actionbar.ActionBarPortraitHorizontal.2
            @Override // com.kwad.sdk.core.download.a.a.b
            public void a() {
                if (ActionBarPortraitHorizontal.this.o != null) {
                    ActionBarPortraitHorizontal.this.o.a(z);
                }
            }
        }).a(this.p).a(view2 == this.k).a(view2 == this.l ? 1 : 2));
    }

    public void a(@NonNull AdTemplate adTemplate, @Nullable b bVar, @NonNull a aVar, int i) {
        this.m = adTemplate;
        this.r.a(adTemplate);
        AdInfo j = com.kwad.sdk.core.response.a.d.j(this.m);
        this.n = j;
        if (com.kwad.sdk.core.response.a.a.B(j)) {
            this.b.setVisibility(8);
            this.a.setVisibility(0);
            new f(this.a, this);
            this.h.setText(com.kwad.sdk.core.response.a.a.t(this.n));
        } else {
            this.b.setVisibility(0);
            this.a.setVisibility(8);
            this.i.setText(this.n.adBaseInfo.productName);
            new f(this.b, this);
        }
        new f(this.k, this);
        this.o = aVar;
        this.p = bVar;
        KSImageLoader.loadAppIcon(this.c, com.kwad.sdk.core.response.a.a.au(this.n), adTemplate, 16);
        float x = com.kwad.sdk.core.response.a.a.x(this.n);
        if (x >= 3.0f) {
            this.d.setScore(x);
            this.d.setVisibility(0);
        } else {
            this.d.setVisibility(8);
        }
        String w = com.kwad.sdk.core.response.a.a.w(this.n);
        if (!TextUtils.isEmpty(w)) {
            this.e.setText(w);
            this.e.setVisibility(0);
        } else {
            this.e.setVisibility(8);
        }
        ViewGroup.LayoutParams layoutParams = this.f.getLayoutParams();
        layoutParams.height = i;
        this.f.setLayoutParams(layoutParams);
        this.j.setText(com.kwad.sdk.core.response.a.a.s(this.n));
        this.k.a(com.kwad.sdk.core.response.a.a.A(this.n), this.k.getMax());
        this.l.setVisibility(8);
        b bVar2 = this.p;
        if (bVar2 != null) {
            bVar2.a(getAppDownloadListener());
        }
        new f(this.g, this);
    }

    @Override // com.kwad.sdk.widget.d
    public void a_(View view2) {
        a(view2, true);
    }

    @Override // com.kwad.sdk.widget.d
    public void b(View view2) {
        if (com.kwad.sdk.core.response.a.c.g(this.m)) {
            a(view2, false);
        }
    }
}
