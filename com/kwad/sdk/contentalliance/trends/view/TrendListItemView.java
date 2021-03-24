package com.kwad.sdk.contentalliance.trends.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import com.kwad.sdk.R;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.page.widget.RoundAngleImageView;
import com.kwad.sdk.core.report.e;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.model.TrendInfo;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.utils.ab;
import com.kwad.sdk.utils.ag;
import com.kwad.sdk.utils.ao;
/* loaded from: classes6.dex */
public class TrendListItemView extends com.kwad.sdk.widget.a {

    /* renamed from: a  reason: collision with root package name */
    public RoundAngleImageView f33066a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f33067b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f33068c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f33069d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f33070e;

    /* renamed from: f  reason: collision with root package name */
    public ImageView f33071f;

    /* renamed from: g  reason: collision with root package name */
    public ImageView f33072g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f33073h;
    public boolean i;
    public TrendInfo j;
    public SceneImpl k;

    public TrendListItemView(Context context) {
        super(context);
        this.j = new TrendInfo();
    }

    public TrendListItemView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.j = new TrendInfo();
    }

    @Override // com.kwad.sdk.widget.a
    public void a() {
        super.a();
        if (this.i) {
            return;
        }
        SceneImpl sceneImpl = this.k;
        TrendInfo trendInfo = this.j;
        e.c(sceneImpl, trendInfo.trendId, trendInfo.name);
        this.i = true;
    }

    public void a(@NonNull TrendInfo trendInfo, boolean z) {
        this.j = trendInfo;
        this.f33073h = z;
        setBackgroundColor(z ? 234881023 : ViewCompat.MEASURED_SIZE_MASK);
        KSImageLoader.loadImage(this.f33066a, trendInfo.coverUrl, (AdTemplate) null, KSImageLoader.IMGOPTION_TREND);
        this.f33067b.setText(String.valueOf(trendInfo.rank));
        if (trendInfo.rank <= 3) {
            this.f33067b.setVisibility(8);
            this.f33071f.setVisibility(0);
            this.f33071f.setImageDrawable(ab.b(getContext(), String.format("ksad_trend_list_logo_%d", Integer.valueOf(trendInfo.rank))));
        } else {
            this.f33067b.setVisibility(0);
            this.f33071f.setVisibility(8);
            this.f33067b.setTextColor(-2130706433);
        }
        this.f33068c.setText(trendInfo.name);
        this.f33069d.setText(String.format(getContext().getString(R.string.ksad_trend_list_item_photo_count_format), Integer.valueOf(trendInfo.photoCount)));
        if (TextUtils.isEmpty(trendInfo.iconUrl)) {
            this.f33072g.setVisibility(8);
        } else {
            this.f33072g.setVisibility(0);
            KSImageLoader.loadImage(this.f33072g, trendInfo.iconUrl, null);
        }
        this.f33070e.setText(String.format(getContext().getString(R.string.ksad_photo_hot_enter_watch_count_format), ag.b(trendInfo.viewCount)));
    }

    public void b() {
        RoundAngleImageView roundAngleImageView = (RoundAngleImageView) findViewById(R.id.ksad_photo_hot_list_item_photo);
        this.f33066a = roundAngleImageView;
        roundAngleImageView.setRadius(ao.a(getContext(), 4.0f));
        this.f33067b = (TextView) findViewById(R.id.ksad_photo_hot_list_item_index);
        this.f33068c = (TextView) findViewById(R.id.ksad_photo_hot_list_item_name);
        this.f33069d = (TextView) findViewById(R.id.ksad_photo_hot_enter_photo_count);
        this.f33070e = (TextView) findViewById(R.id.ksad_photo_hot_enter_watch_count);
        this.f33071f = (ImageView) findViewById(R.id.ksad_trend_list_logo);
        this.f33072g = (ImageView) findViewById(R.id.ksad_photo_hot_list_item_icon);
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        b();
    }

    public void setAdScene(SceneImpl sceneImpl) {
        this.k = sceneImpl;
    }
}
