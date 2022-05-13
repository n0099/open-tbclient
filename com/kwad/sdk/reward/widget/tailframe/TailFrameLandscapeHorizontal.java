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
public class TailFrameLandscapeHorizontal extends LinearLayout implements d {
    public ImageView a;
    public TailFrameBarAppLandscape b;
    public TailFrameBarH5Landscape c;
    public a d;
    public AdTemplate e;
    public AdInfo f;
    public JSONObject g;
    public b h;
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

    private void a(View view2, final boolean z) {
        int i = z ? 1 : 153;
        if (com.kwad.sdk.core.response.a.d.v(this.e)) {
            this.k.a(getContext(), i, 1);
        } else {
            com.kwad.sdk.core.download.a.a.a(new a.C0295a(view2.getContext()).a(this.e).a(this.h).a(view2 == this.i).a(view2 == this.i ? 1 : 2).a(new a.b() { // from class: com.kwad.sdk.reward.widget.tailframe.TailFrameLandscapeHorizontal.2
                @Override // com.kwad.sdk.core.download.a.a.b
                public void a() {
                    if (TailFrameLandscapeHorizontal.this.d != null) {
                        TailFrameLandscapeHorizontal.this.d.a(z);
                    }
                }
            }));
        }
    }

    private void b() {
        LinearLayout.inflate(getContext(), R.layout.obfuscated_res_0x7f0d0473, this);
        this.a = (ImageView) findViewById(R.id.obfuscated_res_0x7f09118c);
        this.j = (KsLogoView) findViewById(R.id.obfuscated_res_0x7f091189);
    }

    private void c() {
        if (!com.kwad.sdk.core.response.a.a.B(this.f) && !com.kwad.sdk.core.response.a.d.v(this.e)) {
            TailFrameBarH5Landscape tailFrameBarH5Landscape = (TailFrameBarH5Landscape) findViewById(R.id.obfuscated_res_0x7f091178);
            this.c = tailFrameBarH5Landscape;
            tailFrameBarH5Landscape.setModel(this.e);
            this.c.setVisibility(0);
            return;
        }
        TailFrameBarAppLandscape tailFrameBarAppLandscape = (TailFrameBarAppLandscape) findViewById(R.id.obfuscated_res_0x7f091162);
        this.b = tailFrameBarAppLandscape;
        tailFrameBarAppLandscape.setModel(this.e);
        this.b.setVisibility(0);
        this.i = this.b.getTextProgressBar();
        if (!com.kwad.sdk.core.response.a.d.v(this.e)) {
            d();
        }
        new f(this.i, this);
    }

    private void d() {
        this.h = new b(this.e, this.g, new c() { // from class: com.kwad.sdk.reward.widget.tailframe.TailFrameLandscapeHorizontal.1
            @Override // com.kwad.sdk.core.download.a.c
            public void a(int i) {
                super.a(i);
                TailFrameLandscapeHorizontal.this.b.a(com.kwad.sdk.core.response.a.d.j(TailFrameLandscapeHorizontal.this.e));
                TailFrameLandscapeHorizontal.this.i.a(com.kwad.sdk.core.response.a.a.b(i), i);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onDownloadFailed() {
                TailFrameLandscapeHorizontal.this.b.a(com.kwad.sdk.core.response.a.d.j(TailFrameLandscapeHorizontal.this.e));
                TailFrameLandscapeHorizontal.this.i.a(com.kwad.sdk.core.response.a.a.A(TailFrameLandscapeHorizontal.this.f), 0);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onDownloadFinished() {
                TailFrameLandscapeHorizontal.this.b.a(com.kwad.sdk.core.response.a.d.j(TailFrameLandscapeHorizontal.this.e));
                TailFrameLandscapeHorizontal.this.i.a(com.kwad.sdk.core.response.a.a.a(TailFrameLandscapeHorizontal.this.e), 0);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onIdle() {
                TailFrameLandscapeHorizontal.this.b.a(com.kwad.sdk.core.response.a.d.j(TailFrameLandscapeHorizontal.this.e));
                TailFrameLandscapeHorizontal.this.i.a(com.kwad.sdk.core.response.a.a.A(TailFrameLandscapeHorizontal.this.f), 0);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onInstalled() {
                TailFrameLandscapeHorizontal.this.b.a(com.kwad.sdk.core.response.a.d.j(TailFrameLandscapeHorizontal.this.e));
                TailFrameLandscapeHorizontal.this.i.a(com.kwad.sdk.core.response.a.a.m(TailFrameLandscapeHorizontal.this.f), 0);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onProgressUpdate(int i) {
                TailFrameLandscapeHorizontal.this.b.a(com.kwad.sdk.core.response.a.d.j(TailFrameLandscapeHorizontal.this.e));
                TailFrameLandscapeHorizontal.this.i.a(com.kwad.sdk.core.response.a.a.a(i), i);
            }
        });
    }

    private void e() {
        setOnClickListener(null);
        this.h = null;
    }

    public void a() {
        TailFrameBarAppLandscape tailFrameBarAppLandscape = this.b;
        if (tailFrameBarAppLandscape != null) {
            tailFrameBarAppLandscape.b();
            this.b.setVisibility(8);
        }
        TailFrameBarH5Landscape tailFrameBarH5Landscape = this.c;
        if (tailFrameBarH5Landscape != null) {
            tailFrameBarH5Landscape.a();
            this.c.setVisibility(8);
        }
        e();
    }

    public void a(@NonNull AdTemplate adTemplate, JSONObject jSONObject, a aVar) {
        this.e = adTemplate;
        this.f = com.kwad.sdk.core.response.a.d.j(adTemplate);
        this.g = jSONObject;
        this.d = aVar;
        this.j.a(this.e);
        KSImageLoader.loadImage(this.a, com.kwad.sdk.core.response.a.a.h(this.f), this.e);
        c();
        setClickable(true);
        new f(this, this);
    }

    @Override // com.kwad.sdk.widget.d
    public void a_(View view2) {
        a(view2, true);
    }

    @Override // com.kwad.sdk.widget.d
    public void b(View view2) {
        if (com.kwad.sdk.core.response.a.c.g(this.e)) {
            a(view2, false);
        }
    }

    public void setCallerContext(com.kwad.sdk.reward.a aVar) {
        this.k = aVar;
    }
}
