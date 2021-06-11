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
    public RoundAngleImageView f33673a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f33674b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f33675c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f33676d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f33677e;

    /* renamed from: f  reason: collision with root package name */
    public ImageView f33678f;

    /* renamed from: g  reason: collision with root package name */
    public ImageView f33679g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f33680h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f33681i;
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
        if (this.f33681i) {
            return;
        }
        SceneImpl sceneImpl = this.k;
        TrendInfo trendInfo = this.j;
        e.c(sceneImpl, trendInfo.trendId, trendInfo.name);
        this.f33681i = true;
    }

    public void a(@NonNull TrendInfo trendInfo, boolean z) {
        this.j = trendInfo;
        this.f33680h = z;
        setBackgroundColor(z ? 234881023 : ViewCompat.MEASURED_SIZE_MASK);
        KSImageLoader.loadImage(this.f33673a, trendInfo.coverUrl, (AdTemplate) null, KSImageLoader.IMGOPTION_TREND);
        this.f33674b.setText(String.valueOf(trendInfo.rank));
        if (trendInfo.rank <= 3) {
            this.f33674b.setVisibility(8);
            this.f33678f.setVisibility(0);
            this.f33678f.setImageDrawable(ab.b(getContext(), String.format("ksad_trend_list_logo_%d", Integer.valueOf(trendInfo.rank))));
        } else {
            this.f33674b.setVisibility(0);
            this.f33678f.setVisibility(8);
            this.f33674b.setTextColor(-2130706433);
        }
        this.f33675c.setText(trendInfo.name);
        this.f33676d.setText(String.format(getContext().getString(R.string.ksad_trend_list_item_photo_count_format), Integer.valueOf(trendInfo.photoCount)));
        if (TextUtils.isEmpty(trendInfo.iconUrl)) {
            this.f33679g.setVisibility(8);
        } else {
            this.f33679g.setVisibility(0);
            KSImageLoader.loadImage(this.f33679g, trendInfo.iconUrl, null);
        }
        this.f33677e.setText(String.format(getContext().getString(R.string.ksad_photo_hot_enter_watch_count_format), ag.b(trendInfo.viewCount)));
    }

    public void b() {
        RoundAngleImageView roundAngleImageView = (RoundAngleImageView) findViewById(R.id.ksad_photo_hot_list_item_photo);
        this.f33673a = roundAngleImageView;
        roundAngleImageView.setRadius(ao.a(getContext(), 4.0f));
        this.f33674b = (TextView) findViewById(R.id.ksad_photo_hot_list_item_index);
        this.f33675c = (TextView) findViewById(R.id.ksad_photo_hot_list_item_name);
        this.f33676d = (TextView) findViewById(R.id.ksad_photo_hot_enter_photo_count);
        this.f33677e = (TextView) findViewById(R.id.ksad_photo_hot_enter_watch_count);
        this.f33678f = (ImageView) findViewById(R.id.ksad_trend_list_logo);
        this.f33679g = (ImageView) findViewById(R.id.ksad_photo_hot_list_item_icon);
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
