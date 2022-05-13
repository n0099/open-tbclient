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
public class ActionBarLandscapeVertical extends FrameLayout implements d {
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
    public KsLogoView m;
    public AdTemplate n;
    public AdInfo o;
    public a p;
    public b q;
    public KsAppDownloadListener r;

    /* loaded from: classes5.dex */
    public interface a {
        void a(boolean z);
    }

    public ActionBarLandscapeVertical(@NonNull Context context) {
        super(context);
        a(context);
    }

    public ActionBarLandscapeVertical(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context);
    }

    public ActionBarLandscapeVertical(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a(context);
    }

    private void a(Context context) {
        FrameLayout.inflate(context, R.layout.obfuscated_res_0x7f0d046a, this);
        this.a = (ViewGroup) findViewById(R.id.obfuscated_res_0x7f09115d);
        this.b = (ViewGroup) findViewById(R.id.obfuscated_res_0x7f09115f);
        this.c = (ImageView) findViewById(R.id.obfuscated_res_0x7f09103f);
        this.d = (AppScoreView) findViewById(R.id.obfuscated_res_0x7f091042);
        this.e = (TextView) findViewById(R.id.obfuscated_res_0x7f09103e);
        this.f = findViewById(R.id.obfuscated_res_0x7f09117c);
        this.g = (ViewGroup) findViewById(R.id.obfuscated_res_0x7f091050);
        this.h = (TextView) findViewById(R.id.obfuscated_res_0x7f091041);
        this.i = (TextView) findViewById(R.id.obfuscated_res_0x7f0910d2);
        this.j = (TextView) findViewById(R.id.obfuscated_res_0x7f09103a);
        TextProgressBar textProgressBar = (TextProgressBar) findViewById(R.id.obfuscated_res_0x7f09103c);
        this.k = textProgressBar;
        textProgressBar.setTextDimen(com.kwad.sdk.a.kwai.a.a(getContext(), 16.0f));
        this.k.setTextColor(-1);
        View findViewById = findViewById(R.id.obfuscated_res_0x7f09103d);
        this.l = findViewById;
        new f(findViewById, this);
        this.m = (KsLogoView) findViewById(R.id.obfuscated_res_0x7f091016);
    }

    private KsAppDownloadListener getAppDownloadListener() {
        if (this.r == null) {
            this.r = new c() { // from class: com.kwad.sdk.reward.widget.actionbar.ActionBarLandscapeVertical.1
                @Override // com.kwad.sdk.core.download.a.c
                public void a(int i) {
                    ActionBarLandscapeVertical.this.k.a(com.kwad.sdk.core.response.a.a.b(i), i);
                    ActionBarLandscapeVertical.this.l.setVisibility(8);
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public void onDownloadFailed() {
                    ActionBarLandscapeVertical.this.k.a(com.kwad.sdk.core.response.a.a.A(ActionBarLandscapeVertical.this.o), 0);
                    ActionBarLandscapeVertical.this.l.setVisibility(0);
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public void onDownloadFinished() {
                    ActionBarLandscapeVertical.this.k.a(com.kwad.sdk.core.response.a.a.a(ActionBarLandscapeVertical.this.n), 0);
                    ActionBarLandscapeVertical.this.l.setVisibility(0);
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public void onIdle() {
                    ActionBarLandscapeVertical.this.k.a(com.kwad.sdk.core.response.a.a.A(ActionBarLandscapeVertical.this.o), 0);
                    ActionBarLandscapeVertical.this.l.setVisibility(0);
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public void onInstalled() {
                    ActionBarLandscapeVertical.this.k.a(com.kwad.sdk.core.response.a.a.m(ActionBarLandscapeVertical.this.o), 0);
                    ActionBarLandscapeVertical.this.l.setVisibility(0);
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public void onProgressUpdate(int i) {
                    ActionBarLandscapeVertical.this.k.a(com.kwad.sdk.core.response.a.a.a(i), i);
                    ActionBarLandscapeVertical.this.l.setVisibility(8);
                }
            };
        }
        return this.r;
    }

    public void a(View view2, final boolean z) {
        com.kwad.sdk.core.download.a.a.a(new a.C0295a(view2.getContext()).a(this.n).a(this.q).a(view2 == this.k).a(view2 == this.l ? 1 : 2).a(new a.b() { // from class: com.kwad.sdk.reward.widget.actionbar.ActionBarLandscapeVertical.2
            @Override // com.kwad.sdk.core.download.a.a.b
            public void a() {
                if (ActionBarLandscapeVertical.this.p != null) {
                    ActionBarLandscapeVertical.this.p.a(z);
                }
            }
        }));
    }

    public void a(@NonNull AdTemplate adTemplate, @Nullable b bVar, @NonNull a aVar, int i) {
        TextView textView;
        String str;
        this.n = adTemplate;
        this.o = com.kwad.sdk.core.response.a.d.j(adTemplate);
        this.m.a(adTemplate);
        if (com.kwad.sdk.core.response.a.a.B(this.o)) {
            this.i.setVisibility(8);
            this.a.setVisibility(0);
            new f(this.a, this);
            textView = this.h;
            str = com.kwad.sdk.core.response.a.a.t(this.o);
        } else {
            this.i.setVisibility(0);
            this.a.setVisibility(8);
            new f(this.b, this);
            textView = this.i;
            str = this.o.adBaseInfo.productName;
        }
        textView.setText(str);
        this.p = aVar;
        this.q = bVar;
        KSImageLoader.loadAppIcon(this.c, com.kwad.sdk.core.response.a.a.au(this.o), adTemplate, 16);
        float x = com.kwad.sdk.core.response.a.a.x(this.o);
        if (x >= 3.0f) {
            this.d.setScore(x);
            this.d.setVisibility(0);
        } else {
            this.d.setVisibility(8);
        }
        String w = com.kwad.sdk.core.response.a.a.w(this.o);
        if (!TextUtils.isEmpty(w)) {
            this.e.setText(w);
            this.e.setVisibility(0);
        } else {
            this.e.setVisibility(8);
        }
        ViewGroup.LayoutParams layoutParams = this.f.getLayoutParams();
        layoutParams.width = i;
        this.f.setLayoutParams(layoutParams);
        this.j.setText(com.kwad.sdk.core.response.a.a.s(this.o));
        this.k.a(com.kwad.sdk.core.response.a.a.A(this.o), this.k.getMax());
        this.l.setVisibility(8);
        b bVar2 = this.q;
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
        if (com.kwad.sdk.core.response.a.c.g(this.n)) {
            a(view2, false);
        }
    }
}
