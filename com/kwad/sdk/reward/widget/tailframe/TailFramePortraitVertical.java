package com.kwad.sdk.reward.widget.tailframe;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import com.baidu.tieba.R;
import com.kwad.sdk.core.download.a.a;
import com.kwad.sdk.core.download.a.b;
import com.kwad.sdk.core.download.a.c;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.page.widget.TextProgressBar;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.reward.widget.tailframe.appbar.TailFrameBarAppPortraitVertical;
import com.kwad.sdk.reward.widget.tailframe.h5bar.TailFrameBarH5PortraitVertical;
import com.kwad.sdk.widget.KsLogoView;
import com.kwad.sdk.widget.d;
import com.kwad.sdk.widget.f;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class TailFramePortraitVertical extends LinearLayout implements d {
    public ImageView a;

    /* renamed from: b  reason: collision with root package name */
    public TailFrameBarAppPortraitVertical f41177b;

    /* renamed from: c  reason: collision with root package name */
    public TailFrameBarH5PortraitVertical f41178c;

    /* renamed from: d  reason: collision with root package name */
    public a f41179d;

    /* renamed from: e  reason: collision with root package name */
    public AdTemplate f41180e;

    /* renamed from: f  reason: collision with root package name */
    public AdInfo f41181f;

    /* renamed from: g  reason: collision with root package name */
    public JSONObject f41182g;

    /* renamed from: h  reason: collision with root package name */
    public b f41183h;
    public TextProgressBar i;
    public KsLogoView j;
    public com.kwad.sdk.reward.a k;
    public View l;

    public TailFramePortraitVertical(Context context) {
        this(context, null);
    }

    public TailFramePortraitVertical(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TailFramePortraitVertical(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        b();
    }

    private void a(View view, final boolean z) {
        if (com.kwad.sdk.core.response.a.d.v(this.f41180e)) {
            this.k.a(getContext(), z ? 1 : 153, 1);
        } else {
            com.kwad.sdk.core.download.a.a.a(new a.C1956a(view.getContext()).a(this.f41180e).a(this.f41183h).a(view == this.i).a(view == this.i ? 1 : 2).a(new a.b() { // from class: com.kwad.sdk.reward.widget.tailframe.TailFramePortraitVertical.2
                @Override // com.kwad.sdk.core.download.a.a.b
                public void a() {
                    if (TailFramePortraitVertical.this.f41179d != null) {
                        TailFramePortraitVertical.this.f41179d.a(z);
                    }
                }
            }));
        }
    }

    private void b() {
        this.l = LinearLayout.inflate(getContext(), R.layout.obfuscated_res_0x7f0d0487, this);
        this.a = (ImageView) findViewById(R.id.obfuscated_res_0x7f091183);
        this.j = (KsLogoView) findViewById(R.id.obfuscated_res_0x7f091180);
    }

    private void c() {
        if (!com.kwad.sdk.core.response.a.a.B(this.f41181f) && !com.kwad.sdk.core.response.a.d.v(this.f41180e)) {
            TailFrameBarH5PortraitVertical tailFrameBarH5PortraitVertical = (TailFrameBarH5PortraitVertical) findViewById(R.id.obfuscated_res_0x7f09116f);
            this.f41178c = tailFrameBarH5PortraitVertical;
            tailFrameBarH5PortraitVertical.a(this.f41180e);
            this.f41178c.setVisibility(0);
            return;
        }
        TailFrameBarAppPortraitVertical tailFrameBarAppPortraitVertical = (TailFrameBarAppPortraitVertical) findViewById(R.id.obfuscated_res_0x7f091159);
        this.f41177b = tailFrameBarAppPortraitVertical;
        tailFrameBarAppPortraitVertical.a(this.f41180e);
        this.f41177b.setVisibility(0);
        this.i = this.f41177b.getTextProgressBar();
        if (!com.kwad.sdk.core.response.a.d.v(this.f41180e)) {
            d();
        }
        new f(this.i, this);
    }

    private void d() {
        this.f41183h = new b(this.f41180e, this.f41182g, new c() { // from class: com.kwad.sdk.reward.widget.tailframe.TailFramePortraitVertical.1
            @Override // com.kwad.sdk.core.download.a.c
            public void a(int i) {
                TailFramePortraitVertical.this.f41177b.a(TailFramePortraitVertical.this.f41181f);
                TailFramePortraitVertical.this.i.a(com.kwad.sdk.core.response.a.a.b(i), i);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onDownloadFailed() {
                TailFramePortraitVertical.this.f41177b.a(TailFramePortraitVertical.this.f41181f);
                TailFramePortraitVertical.this.i.a(com.kwad.sdk.core.response.a.a.A(TailFramePortraitVertical.this.f41181f), 0);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onDownloadFinished() {
                TailFramePortraitVertical.this.f41177b.a(TailFramePortraitVertical.this.f41181f);
                TailFramePortraitVertical.this.i.a(com.kwad.sdk.core.response.a.a.a(TailFramePortraitVertical.this.f41180e), 0);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onIdle() {
                TailFramePortraitVertical.this.f41177b.a(TailFramePortraitVertical.this.f41181f);
                TailFramePortraitVertical.this.i.a(com.kwad.sdk.core.response.a.a.A(TailFramePortraitVertical.this.f41181f), 0);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onInstalled() {
                TailFramePortraitVertical.this.f41177b.a(TailFramePortraitVertical.this.f41181f);
                TailFramePortraitVertical.this.i.a(com.kwad.sdk.core.response.a.a.m(TailFramePortraitVertical.this.f41181f), 0);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onProgressUpdate(int i) {
                TailFramePortraitVertical.this.f41177b.a(TailFramePortraitVertical.this.f41181f);
                TailFramePortraitVertical.this.i.a(com.kwad.sdk.core.response.a.a.a(i), i);
            }
        });
    }

    private void e() {
        setOnClickListener(null);
        this.f41183h = null;
    }

    public void a() {
        TailFrameBarAppPortraitVertical tailFrameBarAppPortraitVertical = this.f41177b;
        if (tailFrameBarAppPortraitVertical != null) {
            tailFrameBarAppPortraitVertical.b();
            this.f41177b.setVisibility(8);
        }
        TailFrameBarH5PortraitVertical tailFrameBarH5PortraitVertical = this.f41178c;
        if (tailFrameBarH5PortraitVertical != null) {
            tailFrameBarH5PortraitVertical.a();
            this.f41178c.setVisibility(8);
        }
        e();
    }

    public void a(@NonNull AdTemplate adTemplate, JSONObject jSONObject, a aVar) {
        this.f41180e = adTemplate;
        if (com.kwad.sdk.core.response.a.d.v(adTemplate)) {
            this.l.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.obfuscated_res_0x7f06075b));
            this.a.setVisibility(8);
            this.j.setVisibility(8);
        }
        AdInfo j = com.kwad.sdk.core.response.a.d.j(adTemplate);
        this.f41181f = j;
        this.f41182g = jSONObject;
        this.f41179d = aVar;
        KSImageLoader.loadImage(this.a, com.kwad.sdk.core.response.a.a.h(j), this.f41180e);
        this.j.a(adTemplate);
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
        if (com.kwad.sdk.core.response.a.c.g(this.f41180e)) {
            a(view, false);
        }
    }

    public void setCallerContext(com.kwad.sdk.reward.a aVar) {
        this.k = aVar;
    }
}
