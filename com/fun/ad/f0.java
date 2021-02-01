package com.fun.ad;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.bytedance.sdk.openadsdk.TTFeedAd;
import com.bytedance.sdk.openadsdk.TTImage;
import com.bytedance.sdk.openadsdk.TTNativeAd;
import com.fun.ad.ap;
import com.fun.ad.sdk.R;
import java.util.ArrayList;
/* loaded from: classes6.dex */
public class f0 extends LinearLayout {

    /* renamed from: a  reason: collision with root package name */
    public TextView f7779a;

    /* renamed from: b  reason: collision with root package name */
    public ImageView f7780b;
    public TextView c;
    public ImageView d;
    public Button e;
    public int f;

    public f0(Context context) {
        super(context);
    }

    public f0(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public f0(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void a(Activity activity, TTFeedAd tTFeedAd, TTNativeAd.AdInteractionListener adInteractionListener) {
        a(activity, (TTNativeAd) tTFeedAd, adInteractionListener);
    }

    public void a(Activity activity, TTNativeAd tTNativeAd, TTNativeAd.AdInteractionListener adInteractionListener) {
        this.f7779a.setText(tTNativeAd.getDescription());
        TTImage icon = tTNativeAd.getIcon();
        if (icon != null && icon.isValid()) {
            ap.a.pPq.a(getContext(), icon.getImageUrl(), this.f7780b);
        }
        this.c.setText(TextUtils.isEmpty(tTNativeAd.getSource()) ? tTNativeAd.getTitle() : tTNativeAd.getSource());
        this.d.setImageResource(R.drawable.csj_ad_logo);
        switch (tTNativeAd.getInteractionType()) {
            case 2:
            case 3:
                this.e.setVisibility(0);
                this.e.setText(R.string.ad_interaction_type_browser);
                break;
            case 4:
                tTNativeAd.setActivityForDownloadApp(activity);
                this.e.setVisibility(0);
                this.e.setText(R.string.ad_interaction_type_download);
                break;
            case 5:
                this.e.setVisibility(0);
                this.e.setText(R.string.ad_interaction_type_dial);
                break;
            default:
                this.e.setVisibility(8);
                break;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(this);
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(this.e);
        tTNativeAd.registerViewForInteraction(this, arrayList, arrayList2, adInteractionListener);
        tTNativeAd.setDownloadListener(new bj(this.e));
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        this.f7779a = (TextView) findViewById(R.id.ad_description);
        this.d = (ImageView) findViewById(R.id.ad_logo);
        this.f7780b = (ImageView) findViewById(R.id.ad_icon);
        this.c = (TextView) findViewById(R.id.ad_source);
        this.e = (Button) findViewById(R.id.ad_creative);
    }

    public void setAdViewWidth(int i) {
        this.f = i;
    }
}
