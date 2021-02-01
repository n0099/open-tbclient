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
import com.kwad.sdk.utils.ag;
import com.kwad.sdk.utils.ao;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes3.dex */
public class a extends com.kwad.sdk.contentalliance.detail.b {

    /* renamed from: b  reason: collision with root package name */
    private ViewGroup f8842b;
    private ViewGroup c;
    private TextView d;
    private TextView e;
    private ImageView f;
    private View g;
    private View h;
    @Nullable
    private ViewStub i;
    @Nullable
    private View j;
    @Nullable
    private View k;
    @Nullable
    private TextView l;
    @Nullable
    private ImageView m;
    private ImageView n;
    private Animation o;
    private AdTemplate p;
    private int q;
    private AtomicBoolean r = new AtomicBoolean(false);
    private c s = new d() { // from class: com.kwad.sdk.contentalliance.trends.a.a.a.1
        @Override // com.kwad.sdk.core.i.d, com.kwad.sdk.core.i.c
        public void c_() {
            if (a.this.r.getAndSet(true)) {
                return;
            }
            if (a.this.a(com.kwad.sdk.core.response.b.d.K(com.kwad.sdk.core.response.b.c.k(a.this.f8395a.j)))) {
                e.j(a.this.p);
            }
        }
    };
    private com.kwad.sdk.contentalliance.a.a t = new com.kwad.sdk.contentalliance.a.b() { // from class: com.kwad.sdk.contentalliance.trends.a.a.a.2
        @Override // com.kwad.sdk.contentalliance.a.b, com.kwad.sdk.contentalliance.a.a
        public void k() {
            a.this.r.set(false);
        }
    };

    private void a(long j) {
        this.e.setText(String.format(o().getString(this.q == 2 ? R.string.ksad_photo_hot_enter_watch_extra_button_format_v2 : R.string.ksad_photo_hot_enter_watch_count_format), ag.b(j)));
    }

    private void a(String str) {
        this.d.setText(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, TrendInfo trendInfo) {
        if (o() != null) {
            e.c(this.f8395a.j, z ? 2 : 1);
            TrendsParams trendsParams = new TrendsParams();
            if (this.f8395a.j != null && this.f8395a.j.mAdScene != null) {
                trendsParams.mEntryScene = this.f8395a.j.mAdScene.entryScene;
            }
            trendsParams.trendInfo = trendInfo;
            com.kwad.sdk.contentalliance.trends.b.a(o(), trendsParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(TrendInfo trendInfo) {
        boolean z = true;
        boolean z2 = com.kwad.sdk.core.response.b.d.x(com.kwad.sdk.core.response.b.c.k(this.f8395a.j)) && !this.f8395a.j.mIsTubeEpisodeList;
        boolean z3 = trendInfo != null && trendInfo.offlineTime > 0 && trendInfo.offlineTime < System.currentTimeMillis();
        if (trendInfo == null || TextUtils.isEmpty(trendInfo.name) || com.kwad.sdk.core.response.b.c.B(this.f8395a.j) || z2 || z3) {
            z = false;
        }
        com.kwad.sdk.core.d.a.a("PhotoTrendEnterPresenter", ">> isShowTrendEnterView() showTrendEnter=" + z);
        return z;
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
        if (this.q == 0) {
            this.o = new TranslateAnimation(-5.0f, 5.0f, 0.0f, 0.0f);
        } else {
            this.o = new TranslateAnimation(-2.0f, 4.0f, 0.0f, 0.0f);
        }
        this.o.setDuration(250L);
        view.setAnimation(this.o);
        this.o.setRepeatCount(Integer.MAX_VALUE);
        this.o.setRepeatMode(2);
        this.o.startNow();
    }

    private void b(TrendInfo trendInfo) {
        switch (this.q) {
            case 1:
                c(trendInfo);
                return;
            case 2:
                d(trendInfo);
                return;
            default:
                e(trendInfo);
                return;
        }
    }

    private void c(final TrendInfo trendInfo) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.c.getLayoutParams();
        marginLayoutParams.rightMargin = ao.a(o(), 0.0f);
        marginLayoutParams.width = -1;
        marginLayoutParams.height = ao.a(o(), R.dimen.ksad_content_trend_bottom_layout_height);
        this.c.setLayoutParams(marginLayoutParams);
        this.g.setVisibility(8);
        this.h.setVisibility(8);
        this.e.setVisibility(8);
        this.f.setVisibility(8);
        e();
        if (this.j == null) {
            return;
        }
        if (this.k != null) {
            this.k.setVisibility(0);
        }
        this.j.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.sdk.contentalliance.trends.a.a.a.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.a(true, trendInfo);
            }
        });
        this.j.setVisibility(0);
        b(trendInfo.viewCount);
        b(this.m);
    }

    private void d(final TrendInfo trendInfo) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.c.getLayoutParams();
        marginLayoutParams.rightMargin = ao.a(o(), 57.0f);
        marginLayoutParams.width = -2;
        marginLayoutParams.height = ao.a(o(), R.dimen.ksad_content_trend_bottom_layout_height);
        this.c.setLayoutParams(marginLayoutParams);
        a(trendInfo.viewCount);
        this.g.setVisibility(8);
        this.h.setVisibility(0);
        this.e.setVisibility(0);
        this.f.setVisibility(8);
        e();
        if (this.j == null) {
            return;
        }
        if (this.k != null) {
            this.k.setVisibility(0);
        }
        this.j.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.sdk.contentalliance.trends.a.a.a.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.a(true, trendInfo);
            }
        });
        this.j.setVisibility(0);
        b(this.m);
    }

    private void e() {
        if (this.i == null || this.i.getParent() == null || this.j != null) {
            return;
        }
        this.j = this.i.inflate();
        this.k = b(R.id.ksad_photo_hot_extra_button);
        this.l = (TextView) b(R.id.ksad_photo_hot_extra_button_text);
        this.m = (ImageView) b(R.id.ksad_photo_hot_extra_button_arrow);
    }

    private void e(TrendInfo trendInfo) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.c.getLayoutParams();
        marginLayoutParams.rightMargin = ao.a(o(), 43.0f);
        marginLayoutParams.width = -2;
        marginLayoutParams.height = ao.a(o(), R.dimen.ksad_content_trend_bottom_layout_height);
        this.c.setLayoutParams(marginLayoutParams);
        this.g.setVisibility(0);
        this.h.setVisibility(8);
        this.e.setVisibility(0);
        this.f.setVisibility(0);
        a(trendInfo.viewCount);
        b(this.f);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.contentalliance.detail.b, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        this.p = this.f8395a.j;
        final TrendInfo K = com.kwad.sdk.core.response.b.d.K(com.kwad.sdk.core.response.b.c.k(this.f8395a.j));
        if (a(K)) {
            a(K.name);
            if (TextUtils.isEmpty(K.iconUrl)) {
                this.n.setImageDrawable(o().getResources().getDrawable(R.drawable.ksad_trend_hot_icon));
            } else {
                KSImageLoader.loadImage(this.n, K.iconUrl, null);
            }
            b(K);
            this.f8842b.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.sdk.contentalliance.trends.a.a.a.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.a(false, K);
                }
            });
            this.f8842b.setVisibility(0);
        } else {
            this.f8842b.setVisibility(8);
        }
        this.f8395a.f8405b.add(this.t);
        if (this.f8395a.m != null) {
            this.f8395a.m.a(this.s);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        if (this.o != null) {
            this.o.cancel();
        }
        if (this.f8395a.m != null) {
            this.f8395a.m.b(this.s);
        }
        this.f8395a.f8405b.remove(this.t);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        this.q = com.kwad.sdk.core.config.c.x();
        this.f8842b = (ViewGroup) b(R.id.ksad_photo_hot_enter_container);
        this.f = (ImageView) b(R.id.ksad_trend_enter_arrow);
        this.d = (TextView) b(R.id.ksad_photo_hot_enter_trend_name);
        this.e = (TextView) b(R.id.ksad_photo_hot_enter_watch_count);
        this.c = (ViewGroup) b(R.id.ksad_photo_hot_bottom_enter);
        this.g = b(R.id.ksad_photo_hot_divider);
        this.h = b(R.id.ksad_photo_hot_divider_v2);
        switch (this.q) {
            case 1:
                this.i = (ViewStub) b(R.id.ksad_trend_enter_extra_button_vs);
                break;
            case 2:
                this.i = (ViewStub) b(R.id.ksad_trend_enter_extra_button_vs_v2);
                break;
        }
        this.n = (ImageView) b(R.id.ksad_photo_hot_enter_label);
    }
}
