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
/* loaded from: classes7.dex */
public class ActionBarAppPortrait extends LinearLayout implements d {
    public ImageView a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f41119b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f41120c;

    /* renamed from: d  reason: collision with root package name */
    public AppScoreView f41121d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f41122e;

    /* renamed from: f  reason: collision with root package name */
    public TextProgressBar f41123f;

    /* renamed from: g  reason: collision with root package name */
    public View f41124g;

    /* renamed from: h  reason: collision with root package name */
    public AdTemplate f41125h;
    public AdInfo i;
    public a j;
    public b k;
    public KsAppDownloadListener l;

    /* loaded from: classes7.dex */
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
        LinearLayout.inflate(getContext(), R.layout.obfuscated_res_0x7f0d0479, this);
        this.a = (ImageView) findViewById(R.id.obfuscated_res_0x7f091036);
        this.f41119b = (TextView) findViewById(R.id.obfuscated_res_0x7f09103a);
        this.f41120c = (TextView) findViewById(R.id.obfuscated_res_0x7f091031);
        this.f41121d = (AppScoreView) findViewById(R.id.obfuscated_res_0x7f091039);
        this.f41122e = (TextView) findViewById(R.id.obfuscated_res_0x7f091035);
        TextProgressBar textProgressBar = (TextProgressBar) findViewById(R.id.obfuscated_res_0x7f091033);
        this.f41123f = textProgressBar;
        textProgressBar.setTextDimen(com.kwad.sdk.a.kwai.a.a(getContext(), 16.0f));
        this.f41123f.setTextColor(-1);
        this.f41124g = findViewById(R.id.obfuscated_res_0x7f09106a);
    }

    private void a(View view, final boolean z) {
        com.kwad.sdk.core.download.a.a.a(new a.C1956a(view.getContext()).a(this.f41125h).a(this.k).a(view == this.f41123f).a(view == this.f41124g ? 1 : 2).a(new a.b() { // from class: com.kwad.sdk.reward.widget.actionbar.ActionBarAppPortrait.2
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
            ((LinearLayout.LayoutParams) this.f41119b.getLayoutParams()).bottomMargin = com.kwad.sdk.a.kwai.a.a(getContext(), 1.0f);
            ((LinearLayout.LayoutParams) this.f41121d.getLayoutParams()).bottomMargin = com.kwad.sdk.a.kwai.a.a(getContext(), 1.0f);
            this.f41122e.setText(w);
            this.f41122e.setVisibility(0);
            this.f41121d.setVisibility(0);
            this.f41121d.setScore(x);
        } else if (z) {
            this.f41122e.setText(w);
            this.f41122e.setVisibility(0);
            this.f41121d.setVisibility(8);
        } else if (!z2) {
            this.f41120c.setText(com.kwad.sdk.core.response.a.a.s(this.i));
            this.f41122e.setVisibility(8);
            this.f41121d.setVisibility(8);
            this.f41120c.setVisibility(0);
            return;
        } else {
            this.f41122e.setVisibility(8);
            this.f41121d.setScore(x);
            this.f41121d.setVisibility(0);
        }
        this.f41120c.setVisibility(8);
    }

    private KsAppDownloadListener getAppDownloadListener() {
        if (this.l == null) {
            this.l = new c() { // from class: com.kwad.sdk.reward.widget.actionbar.ActionBarAppPortrait.1
                @Override // com.kwad.sdk.core.download.a.c
                public void a(int i) {
                    ActionBarAppPortrait.this.f41123f.a(com.kwad.sdk.core.response.a.a.b(i), i);
                    ActionBarAppPortrait.this.f41124g.setVisibility(8);
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public void onDownloadFailed() {
                    ActionBarAppPortrait.this.f41123f.a(com.kwad.sdk.core.response.a.a.A(ActionBarAppPortrait.this.i), 0);
                    ActionBarAppPortrait.this.f41124g.setVisibility(0);
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public void onDownloadFinished() {
                    ActionBarAppPortrait.this.f41123f.a(com.kwad.sdk.core.response.a.a.a(ActionBarAppPortrait.this.f41125h), 0);
                    ActionBarAppPortrait.this.f41124g.setVisibility(0);
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public void onIdle() {
                    ActionBarAppPortrait.this.f41123f.a(com.kwad.sdk.core.response.a.a.A(ActionBarAppPortrait.this.i), 0);
                    ActionBarAppPortrait.this.f41124g.setVisibility(0);
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public void onInstalled() {
                    ActionBarAppPortrait.this.f41123f.a(com.kwad.sdk.core.response.a.a.m(ActionBarAppPortrait.this.i), 0);
                    ActionBarAppPortrait.this.f41124g.setVisibility(0);
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public void onProgressUpdate(int i) {
                    ActionBarAppPortrait.this.f41123f.a(com.kwad.sdk.core.response.a.a.a(i), i);
                    ActionBarAppPortrait.this.f41124g.setVisibility(8);
                }
            };
        }
        return this.l;
    }

    public void a(@NonNull AdTemplate adTemplate, @Nullable b bVar, a aVar) {
        this.f41125h = adTemplate;
        AdInfo j = com.kwad.sdk.core.response.a.d.j(adTemplate);
        this.i = j;
        this.j = aVar;
        this.k = bVar;
        KSImageLoader.loadAppIcon(this.a, com.kwad.sdk.core.response.a.a.au(j), adTemplate, 12);
        this.f41119b.setText(com.kwad.sdk.core.response.a.a.at(this.i));
        b();
        this.f41123f.a(com.kwad.sdk.core.response.a.a.A(this.i), 0);
        b bVar2 = this.k;
        if (bVar2 != null) {
            bVar2.a(getAppDownloadListener());
        }
        setClickable(true);
        new f(this, this);
        new f(this.f41124g, this);
    }

    @Override // com.kwad.sdk.widget.d
    public void a_(View view) {
        a(view, true);
    }

    @Override // com.kwad.sdk.widget.d
    public void b(View view) {
        if (com.kwad.sdk.core.response.a.c.g(this.f41125h)) {
            a(view, false);
        }
    }

    public b getApkDownloadHelper() {
        return this.k;
    }
}
