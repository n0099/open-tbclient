package com.kwad.sdk.reward.widget.actionbar;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
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
import com.kwad.sdk.widget.d;
import com.kwad.sdk.widget.f;
/* loaded from: classes5.dex */
public class ActionBarAppPortrait extends LinearLayout implements d {
    public ImageView a;
    public TextView b;
    public TextView c;
    public AppScoreView d;
    public TextView e;
    public TextProgressBar f;
    public View g;
    public AdTemplate h;
    public AdInfo i;
    public a j;
    public b k;
    public KsAppDownloadListener l;

    /* loaded from: classes5.dex */
    public interface a {
        void a(boolean z);
    }

    public ActionBarAppPortrait(Context context) {
        this(context, null);
    }

    public ActionBarAppPortrait(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ActionBarAppPortrait(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a();
    }

    private void a() {
        LinearLayout.inflate(getContext(), R.layout.obfuscated_res_0x7f0d0474, this);
        this.a = (ImageView) findViewById(R.id.obfuscated_res_0x7f09102f);
        this.b = (TextView) findViewById(R.id.obfuscated_res_0x7f091033);
        this.c = (TextView) findViewById(R.id.obfuscated_res_0x7f09102a);
        this.d = (AppScoreView) findViewById(R.id.obfuscated_res_0x7f091032);
        this.e = (TextView) findViewById(R.id.obfuscated_res_0x7f09102e);
        TextProgressBar textProgressBar = (TextProgressBar) findViewById(R.id.obfuscated_res_0x7f09102c);
        this.f = textProgressBar;
        textProgressBar.setTextDimen(com.kwad.sdk.a.kwai.a.a(getContext(), 16.0f));
        this.f.setTextColor(-1);
        this.g = findViewById(R.id.obfuscated_res_0x7f091063);
    }

    private void a(View view2, final boolean z) {
        com.kwad.sdk.core.download.a.a.a(new a.C0296a(view2.getContext()).a(this.h).a(this.k).a(view2 == this.f).a(view2 == this.g ? 1 : 2).a(new a.b() { // from class: com.kwad.sdk.reward.widget.actionbar.ActionBarAppPortrait.2
            @Override // com.kwad.sdk.core.download.a.a.b
            public void a() {
                if (ActionBarAppPortrait.this.j != null) {
                    ActionBarAppPortrait.this.j.a(z);
                }
            }
        }));
    }

    private void b() {
        String w = com.kwad.sdk.core.response.a.a.w(this.i);
        boolean z = !TextUtils.isEmpty(w);
        float x = com.kwad.sdk.core.response.a.a.x(this.i);
        boolean z2 = x >= 3.0f;
        if (z && z2) {
            ((LinearLayout.LayoutParams) this.b.getLayoutParams()).bottomMargin = com.kwad.sdk.a.kwai.a.a(getContext(), 1.0f);
            ((LinearLayout.LayoutParams) this.d.getLayoutParams()).bottomMargin = com.kwad.sdk.a.kwai.a.a(getContext(), 1.0f);
            this.e.setText(w);
            this.e.setVisibility(0);
            this.d.setVisibility(0);
            this.d.setScore(x);
        } else if (z) {
            this.e.setText(w);
            this.e.setVisibility(0);
            this.d.setVisibility(8);
        } else if (!z2) {
            this.c.setText(com.kwad.sdk.core.response.a.a.s(this.i));
            this.e.setVisibility(8);
            this.d.setVisibility(8);
            this.c.setVisibility(0);
            return;
        } else {
            this.e.setVisibility(8);
            this.d.setScore(x);
            this.d.setVisibility(0);
        }
        this.c.setVisibility(8);
    }

    private KsAppDownloadListener getAppDownloadListener() {
        if (this.l == null) {
            this.l = new c() { // from class: com.kwad.sdk.reward.widget.actionbar.ActionBarAppPortrait.1
                @Override // com.kwad.sdk.core.download.a.c
                public void a(int i) {
                    ActionBarAppPortrait.this.f.a(com.kwad.sdk.core.response.a.a.b(i), i);
                    ActionBarAppPortrait.this.g.setVisibility(8);
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public void onDownloadFailed() {
                    ActionBarAppPortrait.this.f.a(com.kwad.sdk.core.response.a.a.A(ActionBarAppPortrait.this.i), 0);
                    ActionBarAppPortrait.this.g.setVisibility(0);
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public void onDownloadFinished() {
                    ActionBarAppPortrait.this.f.a(com.kwad.sdk.core.response.a.a.a(ActionBarAppPortrait.this.h), 0);
                    ActionBarAppPortrait.this.g.setVisibility(0);
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public void onIdle() {
                    ActionBarAppPortrait.this.f.a(com.kwad.sdk.core.response.a.a.A(ActionBarAppPortrait.this.i), 0);
                    ActionBarAppPortrait.this.g.setVisibility(0);
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public void onInstalled() {
                    ActionBarAppPortrait.this.f.a(com.kwad.sdk.core.response.a.a.m(ActionBarAppPortrait.this.i), 0);
                    ActionBarAppPortrait.this.g.setVisibility(0);
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public void onProgressUpdate(int i) {
                    ActionBarAppPortrait.this.f.a(com.kwad.sdk.core.response.a.a.a(i), i);
                    ActionBarAppPortrait.this.g.setVisibility(8);
                }
            };
        }
        return this.l;
    }

    public void a(@NonNull AdTemplate adTemplate, @Nullable b bVar, a aVar) {
        this.h = adTemplate;
        AdInfo j = com.kwad.sdk.core.response.a.d.j(adTemplate);
        this.i = j;
        this.j = aVar;
        this.k = bVar;
        KSImageLoader.loadAppIcon(this.a, com.kwad.sdk.core.response.a.a.au(j), adTemplate, 12);
        this.b.setText(com.kwad.sdk.core.response.a.a.at(this.i));
        b();
        this.f.a(com.kwad.sdk.core.response.a.a.A(this.i), 0);
        b bVar2 = this.k;
        if (bVar2 != null) {
            bVar2.a(getAppDownloadListener());
        }
        setClickable(true);
        new f(this, this);
        new f(this.g, this);
    }

    @Override // com.kwad.sdk.widget.d
    public void a_(View view2) {
        a(view2, true);
    }

    @Override // com.kwad.sdk.widget.d
    public void b(View view2) {
        if (com.kwad.sdk.core.response.a.c.g(this.h)) {
            a(view2, false);
        }
    }

    public b getApkDownloadHelper() {
        return this.k;
    }
}
