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
/* loaded from: classes3.dex */
public class TrendListItemView extends com.kwad.sdk.widget.a {

    /* renamed from: a  reason: collision with root package name */
    private RoundAngleImageView f8882a;

    /* renamed from: b  reason: collision with root package name */
    private TextView f8883b;
    private TextView c;
    private TextView d;
    private TextView e;
    private ImageView f;
    private ImageView g;
    private boolean h;
    private boolean i;
    private TrendInfo j;
    private SceneImpl k;

    public TrendListItemView(Context context) {
        super(context);
        this.j = new TrendInfo();
    }

    public TrendListItemView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.j = new TrendInfo();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.widget.a
    public void a() {
        super.a();
        if (this.i) {
            return;
        }
        e.c(this.k, this.j.trendId, this.j.name);
        this.i = true;
    }

    public void a(@NonNull TrendInfo trendInfo, boolean z) {
        this.j = trendInfo;
        this.h = z;
        if (this.h) {
            setBackgroundColor(234881023);
        } else {
            setBackgroundColor(ViewCompat.MEASURED_SIZE_MASK);
        }
        KSImageLoader.loadImage(this.f8882a, trendInfo.coverUrl, (AdTemplate) null, KSImageLoader.IMGOPTION_TREND);
        this.f8883b.setText(String.valueOf(trendInfo.rank));
        if (trendInfo.rank <= 3) {
            this.f8883b.setVisibility(8);
            this.f.setVisibility(0);
            this.f.setImageDrawable(ab.b(getContext(), String.format("ksad_trend_list_logo_%d", Integer.valueOf(trendInfo.rank))));
        } else {
            this.f8883b.setVisibility(0);
            this.f.setVisibility(8);
            this.f8883b.setTextColor(-2130706433);
        }
        this.c.setText(trendInfo.name);
        this.d.setText(String.format(getContext().getString(R.string.ksad_trend_list_item_photo_count_format), Integer.valueOf(trendInfo.photoCount)));
        if (TextUtils.isEmpty(trendInfo.iconUrl)) {
            this.g.setVisibility(8);
        } else {
            this.g.setVisibility(0);
            KSImageLoader.loadImage(this.g, trendInfo.iconUrl, null);
        }
        this.e.setText(String.format(getContext().getString(R.string.ksad_photo_hot_enter_watch_count_format), ag.b(trendInfo.viewCount)));
    }

    protected void b() {
        this.f8882a = (RoundAngleImageView) findViewById(R.id.ksad_photo_hot_list_item_photo);
        this.f8882a.setRadius(ao.a(getContext(), 4.0f));
        this.f8883b = (TextView) findViewById(R.id.ksad_photo_hot_list_item_index);
        this.c = (TextView) findViewById(R.id.ksad_photo_hot_list_item_name);
        this.d = (TextView) findViewById(R.id.ksad_photo_hot_enter_photo_count);
        this.e = (TextView) findViewById(R.id.ksad_photo_hot_enter_watch_count);
        this.f = (ImageView) findViewById(R.id.ksad_trend_list_logo);
        this.g = (ImageView) findViewById(R.id.ksad_photo_hot_list_item_icon);
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        b();
    }

    public void setAdScene(SceneImpl sceneImpl) {
        this.k = sceneImpl;
    }
}
