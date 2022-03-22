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
/* loaded from: classes7.dex */
public class TailFrameLandscapeVertical extends LinearLayout implements d {
    public ImageView a;

    /* renamed from: b  reason: collision with root package name */
    public ImageView f41159b;

    /* renamed from: c  reason: collision with root package name */
    public ImageView f41160c;

    /* renamed from: d  reason: collision with root package name */
    public TailFrameBarAppLandscape f41161d;

    /* renamed from: e  reason: collision with root package name */
    public TailFrameBarH5Landscape f41162e;

    /* renamed from: f  reason: collision with root package name */
    public a f41163f;

    /* renamed from: g  reason: collision with root package name */
    public AdTemplate f41164g;

    /* renamed from: h  reason: collision with root package name */
    public AdInfo f41165h;
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

    private void a(View view, final boolean z) {
        if (com.kwad.sdk.core.response.a.d.v(this.f41164g)) {
            this.m.a(getContext(), z ? 1 : 153, 1);
        } else {
            com.kwad.sdk.core.download.a.a.a(new a.C1956a(view.getContext()).a(this.f41164g).a(this.j).a(view == this.k).a(view == this.k ? 1 : 2).a(new a.b() { // from class: com.kwad.sdk.reward.widget.tailframe.TailFrameLandscapeVertical.2
                @Override // com.kwad.sdk.core.download.a.a.b
                public void a() {
                    if (TailFrameLandscapeVertical.this.f41163f != null) {
                        TailFrameLandscapeVertical.this.f41163f.a(z);
                    }
                }
            }));
        }
    }

    private void b() {
        LinearLayout.inflate(getContext(), R.layout.obfuscated_res_0x7f0d0485, this);
        this.a = (ImageView) findViewById(R.id.obfuscated_res_0x7f091184);
        this.f41159b = (ImageView) findViewById(R.id.obfuscated_res_0x7f091185);
        this.f41160c = (ImageView) findViewById(R.id.obfuscated_res_0x7f091186);
        this.l = (KsLogoView) findViewById(R.id.obfuscated_res_0x7f091180);
        this.n = findViewById(R.id.obfuscated_res_0x7f091181);
    }

    private void c() {
        KSImageLoader.loadImage(this.a, com.kwad.sdk.core.response.a.a.h(this.f41165h), this.f41164g);
        KSImageLoader.loadImage(this.f41159b, com.kwad.sdk.core.response.a.a.h(this.f41165h), this.f41164g);
        KSImageLoader.loadImage(this.f41160c, com.kwad.sdk.core.response.a.a.h(this.f41165h), this.f41164g);
    }

    private void d() {
        if (!com.kwad.sdk.core.response.a.a.B(this.f41165h) && !com.kwad.sdk.core.response.a.d.v(this.f41164g)) {
            TailFrameBarH5Landscape tailFrameBarH5Landscape = (TailFrameBarH5Landscape) findViewById(R.id.obfuscated_res_0x7f09116f);
            this.f41162e = tailFrameBarH5Landscape;
            tailFrameBarH5Landscape.setModel(this.f41164g);
            this.f41162e.setVisibility(0);
            return;
        }
        TailFrameBarAppLandscape tailFrameBarAppLandscape = (TailFrameBarAppLandscape) findViewById(R.id.obfuscated_res_0x7f091159);
        this.f41161d = tailFrameBarAppLandscape;
        tailFrameBarAppLandscape.setModel(this.f41164g);
        this.f41161d.setVisibility(0);
        this.k = this.f41161d.getTextProgressBar();
        if (!com.kwad.sdk.core.response.a.d.v(this.f41164g)) {
            e();
        }
        new f(this.k, this);
    }

    private void e() {
        this.j = new b(this.f41164g, this.i, new c() { // from class: com.kwad.sdk.reward.widget.tailframe.TailFrameLandscapeVertical.1
            @Override // com.kwad.sdk.core.download.a.c
            public void a(int i) {
                TailFrameLandscapeVertical.this.f41161d.a(TailFrameLandscapeVertical.this.f41165h);
                TailFrameLandscapeVertical.this.k.a(com.kwad.sdk.core.response.a.a.a(i), i);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onDownloadFailed() {
                TailFrameLandscapeVertical.this.f41161d.a(TailFrameLandscapeVertical.this.f41165h);
                TailFrameLandscapeVertical.this.k.a(com.kwad.sdk.core.response.a.a.A(TailFrameLandscapeVertical.this.f41165h), 0);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onDownloadFinished() {
                TailFrameLandscapeVertical.this.f41161d.a(TailFrameLandscapeVertical.this.f41165h);
                TailFrameLandscapeVertical.this.k.a(com.kwad.sdk.core.response.a.a.a(TailFrameLandscapeVertical.this.f41164g), 0);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onIdle() {
                TailFrameLandscapeVertical.this.f41161d.a(TailFrameLandscapeVertical.this.f41165h);
                TailFrameLandscapeVertical.this.k.a(com.kwad.sdk.core.response.a.a.A(TailFrameLandscapeVertical.this.f41165h), 0);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onInstalled() {
                TailFrameLandscapeVertical.this.f41161d.a(TailFrameLandscapeVertical.this.f41165h);
                TailFrameLandscapeVertical.this.k.a(com.kwad.sdk.core.response.a.a.m(TailFrameLandscapeVertical.this.f41165h), 0);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onProgressUpdate(int i) {
                TailFrameLandscapeVertical.this.f41161d.a(TailFrameLandscapeVertical.this.f41165h);
                TailFrameLandscapeVertical.this.k.a(com.kwad.sdk.core.response.a.a.a(i), i);
            }
        });
    }

    private void f() {
        setOnClickListener(null);
        this.j = null;
    }

    public void a() {
        TailFrameBarAppLandscape tailFrameBarAppLandscape = this.f41161d;
        if (tailFrameBarAppLandscape != null) {
            tailFrameBarAppLandscape.b();
            this.f41161d.setVisibility(8);
        }
        TailFrameBarH5Landscape tailFrameBarH5Landscape = this.f41162e;
        if (tailFrameBarH5Landscape != null) {
            tailFrameBarH5Landscape.a();
            this.f41162e.setVisibility(8);
        }
        f();
    }

    public void a(@NonNull AdTemplate adTemplate, JSONObject jSONObject, a aVar) {
        this.f41164g = adTemplate;
        this.f41165h = com.kwad.sdk.core.response.a.d.j(adTemplate);
        this.i = jSONObject;
        this.f41163f = aVar;
        this.l.a(this.f41164g);
        c();
        d();
        setClickable(true);
        new f(this, this);
    }

    @Override // com.kwad.sdk.widget.d
    public void a_(View view) {
        a(view, true);
    }

    @Override // com.kwad.sdk.widget.d
    public void b(View view) {
        if (com.kwad.sdk.core.response.a.c.g(this.f41164g)) {
            a(view, false);
        }
    }

    public void setCallerContext(com.kwad.sdk.reward.a aVar) {
        this.m = aVar;
    }
}
