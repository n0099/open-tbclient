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
public class TailFrameLandscapeHorizontal extends LinearLayout implements d {
    public ImageView a;

    /* renamed from: b  reason: collision with root package name */
    public TailFrameBarAppLandscape f41150b;

    /* renamed from: c  reason: collision with root package name */
    public TailFrameBarH5Landscape f41151c;

    /* renamed from: d  reason: collision with root package name */
    public a f41152d;

    /* renamed from: e  reason: collision with root package name */
    public AdTemplate f41153e;

    /* renamed from: f  reason: collision with root package name */
    public AdInfo f41154f;

    /* renamed from: g  reason: collision with root package name */
    public JSONObject f41155g;

    /* renamed from: h  reason: collision with root package name */
    public b f41156h;
    public TextProgressBar i;
    public KsLogoView j;
    public com.kwad.sdk.reward.a k;

    public TailFrameLandscapeHorizontal(Context context) {
        this(context, null);
    }

    public TailFrameLandscapeHorizontal(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TailFrameLandscapeHorizontal(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        b();
    }

    private void a(View view, final boolean z) {
        int i = z ? 1 : 153;
        if (com.kwad.sdk.core.response.a.d.v(this.f41153e)) {
            this.k.a(getContext(), i, 1);
        } else {
            com.kwad.sdk.core.download.a.a.a(new a.C1956a(view.getContext()).a(this.f41153e).a(this.f41156h).a(view == this.i).a(view == this.i ? 1 : 2).a(new a.b() { // from class: com.kwad.sdk.reward.widget.tailframe.TailFrameLandscapeHorizontal.2
                @Override // com.kwad.sdk.core.download.a.a.b
                public void a() {
                    if (TailFrameLandscapeHorizontal.this.f41152d != null) {
                        TailFrameLandscapeHorizontal.this.f41152d.a(z);
                    }
                }
            }));
        }
    }

    private void b() {
        LinearLayout.inflate(getContext(), R.layout.obfuscated_res_0x7f0d0484, this);
        this.a = (ImageView) findViewById(R.id.obfuscated_res_0x7f091183);
        this.j = (KsLogoView) findViewById(R.id.obfuscated_res_0x7f091180);
    }

    private void c() {
        if (!com.kwad.sdk.core.response.a.a.B(this.f41154f) && !com.kwad.sdk.core.response.a.d.v(this.f41153e)) {
            TailFrameBarH5Landscape tailFrameBarH5Landscape = (TailFrameBarH5Landscape) findViewById(R.id.obfuscated_res_0x7f09116f);
            this.f41151c = tailFrameBarH5Landscape;
            tailFrameBarH5Landscape.setModel(this.f41153e);
            this.f41151c.setVisibility(0);
            return;
        }
        TailFrameBarAppLandscape tailFrameBarAppLandscape = (TailFrameBarAppLandscape) findViewById(R.id.obfuscated_res_0x7f091159);
        this.f41150b = tailFrameBarAppLandscape;
        tailFrameBarAppLandscape.setModel(this.f41153e);
        this.f41150b.setVisibility(0);
        this.i = this.f41150b.getTextProgressBar();
        if (!com.kwad.sdk.core.response.a.d.v(this.f41153e)) {
            d();
        }
        new f(this.i, this);
    }

    private void d() {
        this.f41156h = new b(this.f41153e, this.f41155g, new c() { // from class: com.kwad.sdk.reward.widget.tailframe.TailFrameLandscapeHorizontal.1
            @Override // com.kwad.sdk.core.download.a.c
            public void a(int i) {
                super.a(i);
                TailFrameLandscapeHorizontal.this.f41150b.a(com.kwad.sdk.core.response.a.d.j(TailFrameLandscapeHorizontal.this.f41153e));
                TailFrameLandscapeHorizontal.this.i.a(com.kwad.sdk.core.response.a.a.b(i), i);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onDownloadFailed() {
                TailFrameLandscapeHorizontal.this.f41150b.a(com.kwad.sdk.core.response.a.d.j(TailFrameLandscapeHorizontal.this.f41153e));
                TailFrameLandscapeHorizontal.this.i.a(com.kwad.sdk.core.response.a.a.A(TailFrameLandscapeHorizontal.this.f41154f), 0);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onDownloadFinished() {
                TailFrameLandscapeHorizontal.this.f41150b.a(com.kwad.sdk.core.response.a.d.j(TailFrameLandscapeHorizontal.this.f41153e));
                TailFrameLandscapeHorizontal.this.i.a(com.kwad.sdk.core.response.a.a.a(TailFrameLandscapeHorizontal.this.f41153e), 0);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onIdle() {
                TailFrameLandscapeHorizontal.this.f41150b.a(com.kwad.sdk.core.response.a.d.j(TailFrameLandscapeHorizontal.this.f41153e));
                TailFrameLandscapeHorizontal.this.i.a(com.kwad.sdk.core.response.a.a.A(TailFrameLandscapeHorizontal.this.f41154f), 0);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onInstalled() {
                TailFrameLandscapeHorizontal.this.f41150b.a(com.kwad.sdk.core.response.a.d.j(TailFrameLandscapeHorizontal.this.f41153e));
                TailFrameLandscapeHorizontal.this.i.a(com.kwad.sdk.core.response.a.a.m(TailFrameLandscapeHorizontal.this.f41154f), 0);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onProgressUpdate(int i) {
                TailFrameLandscapeHorizontal.this.f41150b.a(com.kwad.sdk.core.response.a.d.j(TailFrameLandscapeHorizontal.this.f41153e));
                TailFrameLandscapeHorizontal.this.i.a(com.kwad.sdk.core.response.a.a.a(i), i);
            }
        });
    }

    private void e() {
        setOnClickListener(null);
        this.f41156h = null;
    }

    public void a() {
        TailFrameBarAppLandscape tailFrameBarAppLandscape = this.f41150b;
        if (tailFrameBarAppLandscape != null) {
            tailFrameBarAppLandscape.b();
            this.f41150b.setVisibility(8);
        }
        TailFrameBarH5Landscape tailFrameBarH5Landscape = this.f41151c;
        if (tailFrameBarH5Landscape != null) {
            tailFrameBarH5Landscape.a();
            this.f41151c.setVisibility(8);
        }
        e();
    }

    public void a(@NonNull AdTemplate adTemplate, JSONObject jSONObject, a aVar) {
        this.f41153e = adTemplate;
        this.f41154f = com.kwad.sdk.core.response.a.d.j(adTemplate);
        this.f41155g = jSONObject;
        this.f41152d = aVar;
        this.j.a(this.f41153e);
        KSImageLoader.loadImage(this.a, com.kwad.sdk.core.response.a.a.h(this.f41154f), this.f41153e);
        c();
        setClickable(true);
        new f(this, this);
    }

    @Override // com.kwad.sdk.widget.d
    public void a_(View view) {
        a(view, true);
    }

    @Override // com.kwad.sdk.widget.d
    public void b(View view) {
        if (com.kwad.sdk.core.response.a.c.g(this.f41153e)) {
            a(view, false);
        }
    }

    public void setCallerContext(com.kwad.sdk.reward.a aVar) {
        this.k = aVar;
    }
}
