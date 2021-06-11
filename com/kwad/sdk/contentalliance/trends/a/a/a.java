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
    public ViewGroup f33597b;

    /* renamed from: c  reason: collision with root package name */
    public ViewGroup f33598c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f33599d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f33600e;

    /* renamed from: f  reason: collision with root package name */
    public ImageView f33601f;

    /* renamed from: g  reason: collision with root package name */
    public View f33602g;

    /* renamed from: h  reason: collision with root package name */
    public View f33603h;
    @Nullable

    /* renamed from: i  reason: collision with root package name */
    public ViewStub f33604i;
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
            if (a.this.a(com.kwad.sdk.core.response.b.d.K(com.kwad.sdk.core.response.b.c.k(((com.kwad.sdk.contentalliance.detail.b) a.this).f32692a.j)))) {
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
        this.f33600e.setText(String.format(o().getString(this.q == 2 ? R.string.ksad_photo_hot_enter_watch_extra_button_format_v2 : R.string.ksad_photo_hot_enter_watch_count_format), ag.b(j)));
    }

    private void a(String str) {
        this.f33599d.setText(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, TrendInfo trendInfo) {
        SceneImpl sceneImpl;
        if (o() != null) {
            e.c(((com.kwad.sdk.contentalliance.detail.b) this).f32692a.j, z ? 2 : 1);
            TrendsParams trendsParams = new TrendsParams();
            AdTemplate adTemplate = ((com.kwad.sdk.contentalliance.detail.b) this).f32692a.j;
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
        boolean z3 = com.kwad.sdk.core.response.b.d.x(com.kwad.sdk.core.response.b.c.k(((com.kwad.sdk.contentalliance.detail.b) this).f32692a.j)) && !((com.kwad.sdk.contentalliance.detail.b) this).f32692a.j.mIsTubeEpisodeList;
        if (trendInfo != null) {
            long j = trendInfo.offlineTime;
            if (j > 0 && j < System.currentTimeMillis()) {
                z = true;
                z2 = (trendInfo != null || TextUtils.isEmpty(trendInfo.name) || com.kwad.sdk.core.response.b.c.B(((com.kwad.sdk.contentalliance.detail.b) this).f32692a.j) || z3 || z) ? false : false;
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
        int i2 = this.q;
        if (i2 == 1) {
            c(trendInfo);
        } else if (i2 != 2) {
            e(trendInfo);
        } else {
            d(trendInfo);
        }
    }

    private void c(final TrendInfo trendInfo) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f33598c.getLayoutParams();
        marginLayoutParams.rightMargin = ao.a(o(), 0.0f);
        marginLayoutParams.width = -1;
        marginLayoutParams.height = ao.a(o(), R.dimen.ksad_content_trend_bottom_layout_height);
        this.f33598c.setLayoutParams(marginLayoutParams);
        this.f33602g.setVisibility(8);
        this.f33603h.setVisibility(8);
        this.f33600e.setVisibility(8);
        this.f33601f.setVisibility(8);
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
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f33598c.getLayoutParams();
        marginLayoutParams.rightMargin = ao.a(o(), 57.0f);
        marginLayoutParams.width = -2;
        marginLayoutParams.height = ao.a(o(), R.dimen.ksad_content_trend_bottom_layout_height);
        this.f33598c.setLayoutParams(marginLayoutParams);
        a(trendInfo.viewCount);
        this.f33602g.setVisibility(8);
        this.f33603h.setVisibility(0);
        this.f33600e.setVisibility(0);
        this.f33601f.setVisibility(8);
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
        ViewStub viewStub = this.f33604i;
        if (viewStub == null || viewStub.getParent() == null || this.j != null) {
            return;
        }
        this.j = this.f33604i.inflate();
        this.k = b(R.id.ksad_photo_hot_extra_button);
        this.l = (TextView) b(R.id.ksad_photo_hot_extra_button_text);
        this.m = (ImageView) b(R.id.ksad_photo_hot_extra_button_arrow);
    }

    private void e(TrendInfo trendInfo) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f33598c.getLayoutParams();
        marginLayoutParams.rightMargin = ao.a(o(), 43.0f);
        marginLayoutParams.width = -2;
        marginLayoutParams.height = ao.a(o(), R.dimen.ksad_content_trend_bottom_layout_height);
        this.f33598c.setLayoutParams(marginLayoutParams);
        this.f33602g.setVisibility(0);
        this.f33603h.setVisibility(8);
        this.f33600e.setVisibility(0);
        this.f33601f.setVisibility(0);
        a(trendInfo.viewCount);
        b(this.f33601f);
    }

    @Override // com.kwad.sdk.contentalliance.detail.b, com.kwad.sdk.mvp.Presenter
    public void a() {
        ViewGroup viewGroup;
        int i2;
        super.a();
        AdTemplate adTemplate = ((com.kwad.sdk.contentalliance.detail.b) this).f32692a.j;
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
            this.f33597b.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.sdk.contentalliance.trends.a.a.a.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.a(false, K);
                }
            });
            viewGroup = this.f33597b;
            i2 = 0;
        } else {
            viewGroup = this.f33597b;
            i2 = 8;
        }
        viewGroup.setVisibility(i2);
        ((com.kwad.sdk.contentalliance.detail.b) this).f32692a.f32714b.add(this.t);
        com.kwad.sdk.contentalliance.detail.video.b bVar = ((com.kwad.sdk.contentalliance.detail.b) this).f32692a.m;
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
        com.kwad.sdk.contentalliance.detail.video.b bVar = ((com.kwad.sdk.contentalliance.detail.b) this).f32692a.m;
        if (bVar != null) {
            bVar.b(this.s);
        }
        ((com.kwad.sdk.contentalliance.detail.b) this).f32692a.f32714b.remove(this.t);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        int i2;
        super.c();
        this.q = com.kwad.sdk.core.config.c.x();
        this.f33597b = (ViewGroup) b(R.id.ksad_photo_hot_enter_container);
        this.f33601f = (ImageView) b(R.id.ksad_trend_enter_arrow);
        this.f33599d = (TextView) b(R.id.ksad_photo_hot_enter_trend_name);
        this.f33600e = (TextView) b(R.id.ksad_photo_hot_enter_watch_count);
        this.f33598c = (ViewGroup) b(R.id.ksad_photo_hot_bottom_enter);
        this.f33602g = b(R.id.ksad_photo_hot_divider);
        this.f33603h = b(R.id.ksad_photo_hot_divider_v2);
        int i3 = this.q;
        if (i3 != 1) {
            if (i3 == 2) {
                i2 = R.id.ksad_trend_enter_extra_button_vs_v2;
            }
            this.n = (ImageView) b(R.id.ksad_photo_hot_enter_label);
        }
        i2 = R.id.ksad_trend_enter_extra_button_vs;
        this.f33604i = (ViewStub) b(i2);
        this.n = (ImageView) b(R.id.ksad_photo_hot_enter_label);
    }
}
