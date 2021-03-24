package com.kwad.sdk.contentalliance.trends.a.a;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.kwad.sdk.R;
import com.kwad.sdk.contentalliance.trends.TrendsParams;
import com.kwad.sdk.core.i.c;
import com.kwad.sdk.core.i.d;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.report.e;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.model.TrendInfo;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.utils.ag;
import com.kwad.sdk.utils.ao;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes6.dex */
public class a extends com.kwad.sdk.contentalliance.detail.b {

    /* renamed from: b  reason: collision with root package name */
    public ViewGroup f32994b;

    /* renamed from: c  reason: collision with root package name */
    public ViewGroup f32995c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f32996d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f32997e;

    /* renamed from: f  reason: collision with root package name */
    public ImageView f32998f;

    /* renamed from: g  reason: collision with root package name */
    public View f32999g;

    /* renamed from: h  reason: collision with root package name */
    public View f33000h;
    @Nullable
    public ViewStub i;
    @Nullable
    public View j;
    @Nullable
    public View k;
    @Nullable
    public TextView l;
    @Nullable
    public ImageView m;
    public ImageView n;
    public Animation o;
    public AdTemplate p;
    public int q;
    public AtomicBoolean r = new AtomicBoolean(false);
    public c s = new d() { // from class: com.kwad.sdk.contentalliance.trends.a.a.a.1
        @Override // com.kwad.sdk.core.i.d, com.kwad.sdk.core.i.c
        public void c_() {
            if (a.this.r.getAndSet(true)) {
                return;
            }
            if (a.this.a(com.kwad.sdk.core.response.b.d.K(com.kwad.sdk.core.response.b.c.k(((com.kwad.sdk.contentalliance.detail.b) a.this).f32132a.j)))) {
                e.j(a.this.p);
            }
        }
    };
    public com.kwad.sdk.contentalliance.a.a t = new com.kwad.sdk.contentalliance.a.b() { // from class: com.kwad.sdk.contentalliance.trends.a.a.a.2
        @Override // com.kwad.sdk.contentalliance.a.b, com.kwad.sdk.contentalliance.a.a
        public void k() {
            a.this.r.set(false);
        }
    };

    private void a(long j) {
        this.f32997e.setText(String.format(o().getString(this.q == 2 ? R.string.ksad_photo_hot_enter_watch_extra_button_format_v2 : R.string.ksad_photo_hot_enter_watch_count_format), ag.b(j)));
    }

    private void a(String str) {
        this.f32996d.setText(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, TrendInfo trendInfo) {
        SceneImpl sceneImpl;
        if (o() != null) {
            e.c(((com.kwad.sdk.contentalliance.detail.b) this).f32132a.j, z ? 2 : 1);
            TrendsParams trendsParams = new TrendsParams();
            AdTemplate adTemplate = ((com.kwad.sdk.contentalliance.detail.b) this).f32132a.j;
            if (adTemplate != null && (sceneImpl = adTemplate.mAdScene) != null) {
                trendsParams.mEntryScene = sceneImpl.entryScene;
            }
            trendsParams.trendInfo = trendInfo;
            com.kwad.sdk.contentalliance.trends.b.a(o(), trendsParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(TrendInfo trendInfo) {
        boolean z;
        boolean z2 = true;
        boolean z3 = com.kwad.sdk.core.response.b.d.x(com.kwad.sdk.core.response.b.c.k(((com.kwad.sdk.contentalliance.detail.b) this).f32132a.j)) && !((com.kwad.sdk.contentalliance.detail.b) this).f32132a.j.mIsTubeEpisodeList;
        if (trendInfo != null) {
            long j = trendInfo.offlineTime;
            if (j > 0 && j < System.currentTimeMillis()) {
                z = true;
                z2 = (trendInfo != null || TextUtils.isEmpty(trendInfo.name) || com.kwad.sdk.core.response.b.c.B(((com.kwad.sdk.contentalliance.detail.b) this).f32132a.j) || z3 || z) ? false : false;
                com.kwad.sdk.core.d.a.a("PhotoTrendEnterPresenter", ">> isShowTrendEnterView() showTrendEnter=" + z2);
                return z2;
            }
        }
        z = false;
        if (trendInfo != null) {
        }
        com.kwad.sdk.core.d.a.a("PhotoTrendEnterPresenter", ">> isShowTrendEnterView() showTrendEnter=" + z2);
        return z2;
    }

    private void b(long j) {
        if (this.l == null) {
            return;
        }
        this.l.setText(String.format(o().getString(R.string.ksad_photo_hot_enter_watch_extra_button_format), ag.b(j)));
    }

    private void b(View view) {
        if (view == null) {
            return;
        }
        this.o = this.q == 0 ? new TranslateAnimation(-5.0f, 5.0f, 0.0f, 0.0f) : new TranslateAnimation(-2.0f, 4.0f, 0.0f, 0.0f);
        this.o.setDuration(250L);
        view.setAnimation(this.o);
        this.o.setRepeatCount(Integer.MAX_VALUE);
        this.o.setRepeatMode(2);
        this.o.startNow();
    }

    private void b(TrendInfo trendInfo) {
        int i = this.q;
        if (i == 1) {
            c(trendInfo);
        } else if (i != 2) {
            e(trendInfo);
        } else {
            d(trendInfo);
        }
    }

    private void c(final TrendInfo trendInfo) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f32995c.getLayoutParams();
        marginLayoutParams.rightMargin = ao.a(o(), 0.0f);
        marginLayoutParams.width = -1;
        marginLayoutParams.height = ao.a(o(), R.dimen.ksad_content_trend_bottom_layout_height);
        this.f32995c.setLayoutParams(marginLayoutParams);
        this.f32999g.setVisibility(8);
        this.f33000h.setVisibility(8);
        this.f32997e.setVisibility(8);
        this.f32998f.setVisibility(8);
        e();
        if (this.j == null) {
            return;
        }
        View view = this.k;
        if (view != null) {
            view.setVisibility(0);
        }
        this.j.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.sdk.contentalliance.trends.a.a.a.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                a.this.a(true, trendInfo);
            }
        });
        this.j.setVisibility(0);
        b(trendInfo.viewCount);
        b(this.m);
    }

    private void d(final TrendInfo trendInfo) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f32995c.getLayoutParams();
        marginLayoutParams.rightMargin = ao.a(o(), 57.0f);
        marginLayoutParams.width = -2;
        marginLayoutParams.height = ao.a(o(), R.dimen.ksad_content_trend_bottom_layout_height);
        this.f32995c.setLayoutParams(marginLayoutParams);
        a(trendInfo.viewCount);
        this.f32999g.setVisibility(8);
        this.f33000h.setVisibility(0);
        this.f32997e.setVisibility(0);
        this.f32998f.setVisibility(8);
        e();
        if (this.j == null) {
            return;
        }
        View view = this.k;
        if (view != null) {
            view.setVisibility(0);
        }
        this.j.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.sdk.contentalliance.trends.a.a.a.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                a.this.a(true, trendInfo);
            }
        });
        this.j.setVisibility(0);
        b(this.m);
    }

    private void e() {
        ViewStub viewStub = this.i;
        if (viewStub == null || viewStub.getParent() == null || this.j != null) {
            return;
        }
        this.j = this.i.inflate();
        this.k = b(R.id.ksad_photo_hot_extra_button);
        this.l = (TextView) b(R.id.ksad_photo_hot_extra_button_text);
        this.m = (ImageView) b(R.id.ksad_photo_hot_extra_button_arrow);
    }

    private void e(TrendInfo trendInfo) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f32995c.getLayoutParams();
        marginLayoutParams.rightMargin = ao.a(o(), 43.0f);
        marginLayoutParams.width = -2;
        marginLayoutParams.height = ao.a(o(), R.dimen.ksad_content_trend_bottom_layout_height);
        this.f32995c.setLayoutParams(marginLayoutParams);
        this.f32999g.setVisibility(0);
        this.f33000h.setVisibility(8);
        this.f32997e.setVisibility(0);
        this.f32998f.setVisibility(0);
        a(trendInfo.viewCount);
        b(this.f32998f);
    }

    @Override // com.kwad.sdk.contentalliance.detail.b, com.kwad.sdk.mvp.Presenter
    public void a() {
        ViewGroup viewGroup;
        int i;
        super.a();
        AdTemplate adTemplate = ((com.kwad.sdk.contentalliance.detail.b) this).f32132a.j;
        this.p = adTemplate;
        final TrendInfo K = com.kwad.sdk.core.response.b.d.K(com.kwad.sdk.core.response.b.c.k(adTemplate));
        if (a(K)) {
            a(K.name);
            if (TextUtils.isEmpty(K.iconUrl)) {
                this.n.setImageDrawable(o().getResources().getDrawable(R.drawable.ksad_trend_hot_icon));
            } else {
                KSImageLoader.loadImage(this.n, K.iconUrl, null);
            }
            b(K);
            this.f32994b.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.sdk.contentalliance.trends.a.a.a.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.a(false, K);
                }
            });
            viewGroup = this.f32994b;
            i = 0;
        } else {
            viewGroup = this.f32994b;
            i = 8;
        }
        viewGroup.setVisibility(i);
        ((com.kwad.sdk.contentalliance.detail.b) this).f32132a.f32152b.add(this.t);
        com.kwad.sdk.contentalliance.detail.video.b bVar = ((com.kwad.sdk.contentalliance.detail.b) this).f32132a.m;
        if (bVar != null) {
            bVar.a(this.s);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        Animation animation = this.o;
        if (animation != null) {
            animation.cancel();
        }
        com.kwad.sdk.contentalliance.detail.video.b bVar = ((com.kwad.sdk.contentalliance.detail.b) this).f32132a.m;
        if (bVar != null) {
            bVar.b(this.s);
        }
        ((com.kwad.sdk.contentalliance.detail.b) this).f32132a.f32152b.remove(this.t);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        int i;
        super.c();
        this.q = com.kwad.sdk.core.config.c.x();
        this.f32994b = (ViewGroup) b(R.id.ksad_photo_hot_enter_container);
        this.f32998f = (ImageView) b(R.id.ksad_trend_enter_arrow);
        this.f32996d = (TextView) b(R.id.ksad_photo_hot_enter_trend_name);
        this.f32997e = (TextView) b(R.id.ksad_photo_hot_enter_watch_count);
        this.f32995c = (ViewGroup) b(R.id.ksad_photo_hot_bottom_enter);
        this.f32999g = b(R.id.ksad_photo_hot_divider);
        this.f33000h = b(R.id.ksad_photo_hot_divider_v2);
        int i2 = this.q;
        if (i2 != 1) {
            if (i2 == 2) {
                i = R.id.ksad_trend_enter_extra_button_vs_v2;
            }
            this.n = (ImageView) b(R.id.ksad_photo_hot_enter_label);
        }
        i = R.id.ksad_trend_enter_extra_button_vs;
        this.i = (ViewStub) b(i);
        this.n = (ImageView) b(R.id.ksad_photo_hot_enter_label);
    }
}
