package com.kwad.sdk.reward.widget.tailframe;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.tieba.R;
import com.kwad.sdk.core.download.a.a;
import com.kwad.sdk.core.download.a.b;
import com.kwad.sdk.core.download.a.c;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.page.widget.TextProgressBar;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.reward.widget.tailframe.appbar.TailFrameBarAppLandscape;
import com.kwad.sdk.reward.widget.tailframe.h5bar.TailFrameBarH5Landscape;
import com.kwad.sdk.widget.KsLogoView;
import com.kwad.sdk.widget.d;
import com.kwad.sdk.widget.f;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class TailFrameLandscapeVertical extends LinearLayout implements d {
    public ImageView a;
    public ImageView b;
    public ImageView c;
    public TailFrameBarAppLandscape d;
    public TailFrameBarH5Landscape e;
    public a f;
    public AdTemplate g;
    public AdInfo h;
    public JSONObject i;
    public b j;
    public TextProgressBar k;
    public KsLogoView l;
    public com.kwad.sdk.reward.a m;
    public View n;

    public TailFrameLandscapeVertical(Context context) {
        this(context, null);
    }

    public TailFrameLandscapeVertical(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TailFrameLandscapeVertical(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        b();
    }

    private void a(View view2, final boolean z) {
        if (com.kwad.sdk.core.response.a.d.v(this.g)) {
            this.m.a(getContext(), z ? 1 : 153, 1);
        } else {
            com.kwad.sdk.core.download.a.a.a(new a.C0304a(view2.getContext()).a(this.g).a(this.j).a(view2 == this.k).a(view2 == this.k ? 1 : 2).a(new a.b() { // from class: com.kwad.sdk.reward.widget.tailframe.TailFrameLandscapeVertical.2
                @Override // com.kwad.sdk.core.download.a.a.b
                public void a() {
                    if (TailFrameLandscapeVertical.this.f != null) {
                        TailFrameLandscapeVertical.this.f.a(z);
                    }
                }
            }));
        }
    }

    private void b() {
        LinearLayout.inflate(getContext(), R.layout.obfuscated_res_0x7f0d0464, this);
        this.a = (ImageView) findViewById(R.id.obfuscated_res_0x7f09113f);
        this.b = (ImageView) findViewById(R.id.obfuscated_res_0x7f091140);
        this.c = (ImageView) findViewById(R.id.obfuscated_res_0x7f091141);
        this.l = (KsLogoView) findViewById(R.id.obfuscated_res_0x7f09113b);
        this.n = findViewById(R.id.obfuscated_res_0x7f09113c);
    }

    private void c() {
        KSImageLoader.loadImage(this.a, com.kwad.sdk.core.response.a.a.h(this.h), this.g);
        KSImageLoader.loadImage(this.b, com.kwad.sdk.core.response.a.a.h(this.h), this.g);
        KSImageLoader.loadImage(this.c, com.kwad.sdk.core.response.a.a.h(this.h), this.g);
    }

    private void d() {
        if (!com.kwad.sdk.core.response.a.a.B(this.h) && !com.kwad.sdk.core.response.a.d.v(this.g)) {
            TailFrameBarH5Landscape tailFrameBarH5Landscape = (TailFrameBarH5Landscape) findViewById(R.id.obfuscated_res_0x7f09112a);
            this.e = tailFrameBarH5Landscape;
            tailFrameBarH5Landscape.setModel(this.g);
            this.e.setVisibility(0);
            return;
        }
        TailFrameBarAppLandscape tailFrameBarAppLandscape = (TailFrameBarAppLandscape) findViewById(R.id.obfuscated_res_0x7f091114);
        this.d = tailFrameBarAppLandscape;
        tailFrameBarAppLandscape.setModel(this.g);
        this.d.setVisibility(0);
        this.k = this.d.getTextProgressBar();
        if (!com.kwad.sdk.core.response.a.d.v(this.g)) {
            e();
        }
        new f(this.k, this);
    }

    private void e() {
        this.j = new b(this.g, this.i, new c() { // from class: com.kwad.sdk.reward.widget.tailframe.TailFrameLandscapeVertical.1
            @Override // com.kwad.sdk.core.download.a.c
            public void a(int i) {
                TailFrameLandscapeVertical.this.d.a(TailFrameLandscapeVertical.this.h);
                TailFrameLandscapeVertical.this.k.a(com.kwad.sdk.core.response.a.a.a(i), i);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onDownloadFailed() {
                TailFrameLandscapeVertical.this.d.a(TailFrameLandscapeVertical.this.h);
                TailFrameLandscapeVertical.this.k.a(com.kwad.sdk.core.response.a.a.A(TailFrameLandscapeVertical.this.h), 0);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onDownloadFinished() {
                TailFrameLandscapeVertical.this.d.a(TailFrameLandscapeVertical.this.h);
                TailFrameLandscapeVertical.this.k.a(com.kwad.sdk.core.response.a.a.a(TailFrameLandscapeVertical.this.g), 0);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onIdle() {
                TailFrameLandscapeVertical.this.d.a(TailFrameLandscapeVertical.this.h);
                TailFrameLandscapeVertical.this.k.a(com.kwad.sdk.core.response.a.a.A(TailFrameLandscapeVertical.this.h), 0);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onInstalled() {
                TailFrameLandscapeVertical.this.d.a(TailFrameLandscapeVertical.this.h);
                TailFrameLandscapeVertical.this.k.a(com.kwad.sdk.core.response.a.a.m(TailFrameLandscapeVertical.this.h), 0);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onProgressUpdate(int i) {
                TailFrameLandscapeVertical.this.d.a(TailFrameLandscapeVertical.this.h);
                TailFrameLandscapeVertical.this.k.a(com.kwad.sdk.core.response.a.a.a(i), i);
            }
        });
    }

    private void f() {
        setOnClickListener(null);
        this.j = null;
    }

    public void a() {
        TailFrameBarAppLandscape tailFrameBarAppLandscape = this.d;
        if (tailFrameBarAppLandscape != null) {
            tailFrameBarAppLandscape.b();
            this.d.setVisibility(8);
        }
        TailFrameBarH5Landscape tailFrameBarH5Landscape = this.e;
        if (tailFrameBarH5Landscape != null) {
            tailFrameBarH5Landscape.a();
            this.e.setVisibility(8);
        }
        f();
    }

    public void a(@NonNull AdTemplate adTemplate, JSONObject jSONObject, a aVar) {
        this.g = adTemplate;
        this.h = com.kwad.sdk.core.response.a.d.j(adTemplate);
        this.i = jSONObject;
        this.f = aVar;
        this.l.a(this.g);
        c();
        d();
        setClickable(true);
        new f(this, this);
    }

    @Override // com.kwad.sdk.widget.d
    public void a_(View view2) {
        a(view2, true);
    }

    @Override // com.kwad.sdk.widget.d
    public void b(View view2) {
        if (com.kwad.sdk.core.response.a.c.g(this.g)) {
            a(view2, false);
        }
    }

    public void setCallerContext(com.kwad.sdk.reward.a aVar) {
        this.m = aVar;
    }
}
