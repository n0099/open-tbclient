package tv.athena.revenue.payui.view.impl;

import android.app.Activity;
import android.content.Context;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.tieba.R;
import com.baidu.tieba.cac;
import com.baidu.tieba.iac;
import com.yy.mobile.framework.revenuesdk.baseapi.log.RLog;
import com.yy.mobile.framework.revenuesdk.payapi.bean.GiftBagItemInfo;
import com.yy.mobile.framework.revenuesdk.payapi.bean.GiftBagsInfo;
import java.util.ArrayList;
import java.util.List;
import tv.athena.revenue.payui.model.PayUIKitConfig;
import tv.athena.revenue.payui.view.WindowParams;
import tv.athena.revenue.payui.view.adapter.PayAmountCampaignListAdapter;
import tv.athena.revenue.payui.view.adapter.PayCampaignListItemDecoration;
/* loaded from: classes2.dex */
public class YYPayCampaignView extends LinearLayout implements iac {
    public Activity a;
    public RecyclerView b;
    public RelativeLayout c;
    public GiftBagsInfo d;
    public PayUIKitConfig e;
    public List<GiftBagItemInfo> f;
    public PayAmountCampaignListAdapter g;
    public LinearLayoutManager h;

    @Override // com.baidu.tieba.hac
    public void attachWindow(Window window) {
    }

    @Override // com.baidu.tieba.hac
    public View getContentView() {
        return this;
    }

    @Override // com.baidu.tieba.hac
    public void refreshWindow(WindowParams windowParams) {
    }

    public YYPayCampaignView(Activity activity, int i, int i2, PayUIKitConfig payUIKitConfig) {
        super(activity);
        this.f = new ArrayList();
        this.a = activity;
        this.e = payUIKitConfig;
        b(activity);
    }

    public final void b(Context context) {
        LayoutInflater.from(new ContextThemeWrapper(context, cac.a.a(this.e))).inflate(R.layout.pay_ui_layout_pay_amount_campaign_view, (ViewGroup) this, true);
        this.b = (RecyclerView) findViewById(R.id.rv_campaign);
        this.c = (RelativeLayout) findViewById(R.id.rl_content);
        this.h = new LinearLayoutManager(context, 0, false);
        this.g = new PayAmountCampaignListAdapter(this.a, this.f, this.e);
        this.b.setLayoutManager(this.h);
        this.b.addItemDecoration(new PayCampaignListItemDecoration());
        this.b.setAdapter(this.g);
    }

    @Override // com.baidu.tieba.hac
    public void refreshView() {
        GiftBagsInfo giftBagsInfo = this.d;
        if (giftBagsInfo == null) {
            RLog.error("YYPayCampaignView", "refreshView error mGiftBagsInfo null", new Object[0]);
            return;
        }
        List<GiftBagItemInfo> list = giftBagsInfo.giftbag;
        if (list != null && !list.isEmpty()) {
            this.f.clear();
            this.f.addAll(this.d.giftbag);
            this.g.notifyDataSetChanged();
            return;
        }
        RLog.error("YYPayCampaignView", "refreshView error giftbag null", new Object[0]);
    }

    @Override // com.baidu.tieba.iac
    public void setGiftBagsInfo(GiftBagsInfo giftBagsInfo) {
        RLog.info("YYPayCampaignView", "setGiftBagsInfo giftBagsInfo:" + giftBagsInfo);
        this.d = giftBagsInfo;
    }
}
