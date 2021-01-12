package com.fun.ad;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.fun.ad.au;
import com.fun.ad.sdk.R;
import com.qq.e.ads.nativ.NativeADEventListener;
import com.qq.e.ads.nativ.NativeUnifiedADData;
import com.qq.e.ads.nativ.widget.NativeAdContainer;
import com.qq.e.comm.util.AdError;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes14.dex */
public abstract class v0 extends NativeAdContainer {

    /* renamed from: a  reason: collision with root package name */
    public TextView f7838a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f7839b;
    public Button c;

    /* loaded from: classes14.dex */
    public class a implements NativeADEventListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ah f7840a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ au.a f7841b;
        public final /* synthetic */ NativeUnifiedADData c;

        public a(ah ahVar, au.a aVar, NativeUnifiedADData nativeUnifiedADData) {
            this.f7840a = ahVar;
            this.f7841b = aVar;
            this.c = nativeUnifiedADData;
        }

        @Override // com.qq.e.ads.nativ.NativeADEventListener
        public void onADClicked() {
            m.a("GDTNativeUnifiedAd onADClicked");
            ah ahVar = this.f7840a;
            if (ahVar != null) {
                ((aa) ahVar).c(this.f7841b.f7760a);
            }
        }

        @Override // com.qq.e.ads.nativ.NativeADEventListener
        public void onADError(AdError adError) {
            m.a("GDTNativeUnifiedAd onADError");
            ah ahVar = this.f7840a;
            if (ahVar != null) {
                ((aa) ahVar).a(this.f7841b.f7760a, adError.getErrorCode(), adError.getErrorMsg());
            }
        }

        @Override // com.qq.e.ads.nativ.NativeADEventListener
        public void onADExposed() {
            m.a("GDTNativeUnifiedAd onADExposed");
            ah ahVar = this.f7840a;
            if (ahVar != null) {
                ((aa) ahVar).d(this.f7841b.f7760a);
            }
        }

        @Override // com.qq.e.ads.nativ.NativeADEventListener
        public void onADStatusChanged() {
            m.a("GDTNativeUnifiedAd onADStatusChanged");
            v0.this.a(this.c);
            ah ahVar = this.f7840a;
            if (ahVar != null) {
                String str = this.f7841b.f7760a;
                if (((aa) ahVar) == null) {
                    throw null;
                }
                m.a("FunAdLoader 优量汇广告 onADStatusChanged，广告ID：" + str);
            }
        }
    }

    public v0(Context context) {
        this(context, null);
    }

    public v0(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public v0(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public List<View> a() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.c);
        return arrayList;
    }

    public void a(Activity activity, au.a aVar, NativeUnifiedADData nativeUnifiedADData, ah ahVar) {
        this.f7839b.setText(nativeUnifiedADData.getTitle());
        this.f7838a.setText(nativeUnifiedADData.getDesc());
        nativeUnifiedADData.bindAdToView(getContext(), this, null, a());
        nativeUnifiedADData.setNativeAdEventListener(new a(ahVar, aVar, nativeUnifiedADData));
        a(nativeUnifiedADData);
    }

    public void a(NativeUnifiedADData nativeUnifiedADData) {
        if (nativeUnifiedADData.isAppAd()) {
            int appStatus = nativeUnifiedADData.getAppStatus();
            if (appStatus == 0) {
                this.c.setText(R.string.ad_interaction_type_download);
                return;
            } else if (appStatus == 1) {
                this.c.setText(R.string.ad_interaction_type_start);
                return;
            } else if (appStatus == 2) {
                this.c.setText(R.string.ad_interaction_type_update);
                return;
            } else if (appStatus == 4) {
                this.c.setText(String.format("%s/100", Integer.valueOf(nativeUnifiedADData.getProgress())));
                return;
            } else if (appStatus == 8) {
                this.c.setText(R.string.ad_interaction_type_install);
                return;
            } else if (appStatus == 16) {
                this.c.setText(R.string.ad_interaction_type_redownload);
                return;
            }
        }
        this.c.setText(R.string.ad_interaction_type_view);
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        this.f7838a = (TextView) findViewById(R.id.ad_description);
        this.f7839b = (TextView) findViewById(R.id.ad_title);
        this.c = (Button) findViewById(R.id.ad_creative);
    }
}
