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
/* loaded from: classes7.dex */
public class ActionBarPortraitHorizontal extends FrameLayout implements d {
    public ViewGroup a;

    /* renamed from: b  reason: collision with root package name */
    public ViewGroup f41141b;

    /* renamed from: c  reason: collision with root package name */
    public ImageView f41142c;

    /* renamed from: d  reason: collision with root package name */
    public AppScoreView f41143d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f41144e;

    /* renamed from: f  reason: collision with root package name */
    public View f41145f;

    /* renamed from: g  reason: collision with root package name */
    public ViewGroup f41146g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f41147h;
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

    /* loaded from: classes7.dex */
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
        FrameLayout.inflate(context, R.layout.obfuscated_res_0x7f0d047c, this);
        this.a = (ViewGroup) findViewById(R.id.obfuscated_res_0x7f091154);
        this.f41141b = (ViewGroup) findViewById(R.id.obfuscated_res_0x7f091155);
        this.f41142c = (ImageView) findViewById(R.id.obfuscated_res_0x7f091036);
        this.f41143d = (AppScoreView) findViewById(R.id.obfuscated_res_0x7f091039);
        this.f41144e = (TextView) findViewById(R.id.obfuscated_res_0x7f091035);
        this.f41145f = findViewById(R.id.obfuscated_res_0x7f091173);
        this.f41146g = (ViewGroup) findViewById(R.id.obfuscated_res_0x7f091047);
        this.f41147h = (TextView) findViewById(R.id.obfuscated_res_0x7f091038);
        this.i = (TextView) findViewById(R.id.obfuscated_res_0x7f0910c6);
        this.j = (TextView) findViewById(R.id.obfuscated_res_0x7f091031);
        TextProgressBar textProgressBar = (TextProgressBar) findViewById(R.id.obfuscated_res_0x7f091033);
        this.k = textProgressBar;
        textProgressBar.setTextDimen(com.kwad.sdk.a.kwai.a.a(getContext(), 16.0f));
        this.k.setTextColor(-1);
        View findViewById = findViewById(R.id.obfuscated_res_0x7f091034);
        this.l = findViewById;
        new f(findViewById, this);
        this.r = (KsLogoView) findViewById(R.id.obfuscated_res_0x7f09100d);
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

    public void a(View view, final boolean z) {
        com.kwad.sdk.core.download.a.a.a(new a.C1956a(view.getContext()).a(this.m).a(new a.b() { // from class: com.kwad.sdk.reward.widget.actionbar.ActionBarPortraitHorizontal.2
            @Override // com.kwad.sdk.core.download.a.a.b
            public void a() {
                if (ActionBarPortraitHorizontal.this.o != null) {
                    ActionBarPortraitHorizontal.this.o.a(z);
                }
            }
        }).a(this.p).a(view == this.k).a(view == this.l ? 1 : 2));
    }

    public void a(@NonNull AdTemplate adTemplate, @Nullable b bVar, @NonNull a aVar, int i) {
        this.m = adTemplate;
        this.r.a(adTemplate);
        AdInfo j = com.kwad.sdk.core.response.a.d.j(this.m);
        this.n = j;
        if (com.kwad.sdk.core.response.a.a.B(j)) {
            this.f41141b.setVisibility(8);
            this.a.setVisibility(0);
            new f(this.a, this);
            this.f41147h.setText(com.kwad.sdk.core.response.a.a.t(this.n));
        } else {
            this.f41141b.setVisibility(0);
            this.a.setVisibility(8);
            this.i.setText(this.n.adBaseInfo.productName);
            new f(this.f41141b, this);
        }
        new f(this.k, this);
        this.o = aVar;
        this.p = bVar;
        KSImageLoader.loadAppIcon(this.f41142c, com.kwad.sdk.core.response.a.a.au(this.n), adTemplate, 16);
        float x = com.kwad.sdk.core.response.a.a.x(this.n);
        if (x >= 3.0f) {
            this.f41143d.setScore(x);
            this.f41143d.setVisibility(0);
        } else {
            this.f41143d.setVisibility(8);
        }
        String w = com.kwad.sdk.core.response.a.a.w(this.n);
        if (!TextUtils.isEmpty(w)) {
            this.f41144e.setText(w);
            this.f41144e.setVisibility(0);
        } else {
            this.f41144e.setVisibility(8);
        }
        ViewGroup.LayoutParams layoutParams = this.f41145f.getLayoutParams();
        layoutParams.height = i;
        this.f41145f.setLayoutParams(layoutParams);
        this.j.setText(com.kwad.sdk.core.response.a.a.s(this.n));
        this.k.a(com.kwad.sdk.core.response.a.a.A(this.n), this.k.getMax());
        this.l.setVisibility(8);
        b bVar2 = this.p;
        if (bVar2 != null) {
            bVar2.a(getAppDownloadListener());
        }
        new f(this.f41146g, this);
    }

    @Override // com.kwad.sdk.widget.d
    public void a_(View view) {
        a(view, true);
    }

    @Override // com.kwad.sdk.widget.d
    public void b(View view) {
        if (com.kwad.sdk.core.response.a.c.g(this.m)) {
            a(view, false);
        }
    }
}
