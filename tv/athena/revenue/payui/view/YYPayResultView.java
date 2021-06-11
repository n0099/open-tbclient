package tv.athena.revenue.payui.view;

import android.app.Activity;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.yy.mobile.framework.revenuesdk.baseapi.IResult;
import com.yy.mobile.framework.revenuesdk.baseapi.PayCallBackBean;
import com.yy.mobile.framework.revenuesdk.baseapi.log.RLog;
import com.yy.mobile.framework.revenuesdk.payapi.bean.BannerConfigItem;
import com.yy.mobile.framework.revenuesdk.payapi.bean.CurrencyChargeMessage;
import com.yy.mobile.framework.revenuesdk.payapi.bean.PaysSettingInfo;
import com.yy.mobile.framework.revenuesdk.payapi.callbackresult.BannerConfigResult;
import com.yy.mobile.framework.revenuesdk.payapi.request.GetBannerConfigReqParams;
import com.yy.mobile.framework.revenuesdk.statistics.hiido.eventtype.UiEventType;
import i.a.a.e.e;
import i.a.a.e.n.g;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import tv.athena.revenue.payui.view.IYYPayResultView;
import tv.athena.revenue.payui.view.banner.PluginCenterTopBanner;
/* loaded from: classes8.dex */
public class YYPayResultView extends LinearLayout implements IYYPayResultView {

    /* renamed from: e  reason: collision with root package name */
    public Activity f72937e;

    /* renamed from: f  reason: collision with root package name */
    public int f72938f;

    /* renamed from: g  reason: collision with root package name */
    public int f72939g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f72940h;

    /* renamed from: i  reason: collision with root package name */
    public ImageView f72941i;
    public TextView j;
    public PluginCenterTopBanner k;
    public IYYPayResultView.a l;
    public IYYPayResultView.b m;
    public i.a.a.e.k.b n;
    public i.a.a.e.k.a o;
    public int p;
    public List<BannerConfigItem.BannerInfo> q;
    public IYYPayResultView.c r;

    /* loaded from: classes8.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (YYPayResultView.this.l != null) {
                YYPayResultView.this.l.a();
            }
            YYPayResultView.this.j();
        }
    }

    /* loaded from: classes8.dex */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            i.a.a.e.m.a.b(YYPayResultView.this.f72938f, YYPayResultView.this.f72939g, UiEventType.failpagecallnum);
        }
    }

    /* loaded from: classes8.dex */
    public class c implements AdapterView.OnItemClickListener {
        public c() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j) {
            if (i2 < 0 || i2 >= YYPayResultView.this.q.size()) {
                return;
            }
            BannerConfigItem.BannerInfo bannerInfo = (BannerConfigItem.BannerInfo) YYPayResultView.this.q.get(i2);
            RLog.info("YYPayResultView", "updateBanner: click=" + bannerInfo);
            if (YYPayResultView.this.r == null || YYPayResultView.this.r.f72919b == null) {
                return;
            }
            YYPayResultView.this.r.f72919b.onBannerClick(bannerInfo);
        }
    }

    /* loaded from: classes8.dex */
    public class d implements IResult<BannerConfigResult> {
        public d() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.yy.mobile.framework.revenuesdk.baseapi.IResult
        /* renamed from: a */
        public void onSuccess(BannerConfigResult bannerConfigResult, PayCallBackBean payCallBackBean) {
            List<BannerConfigItem.BannerInfo> list;
            RLog.info("YYPayResultView", "queryBannerConfig()->onSuccess:" + bannerConfigResult);
            YYPayResultView.this.q.clear();
            if (bannerConfigResult.getBannerConfigItemList() == null || bannerConfigResult.getBannerConfigItemList().size() <= 0) {
                list = null;
            } else {
                BannerConfigItem bannerConfigItem = bannerConfigResult.getBannerConfigItemList().get(0);
                list = bannerConfigItem.bannerInfoList;
                YYPayResultView.this.p = bannerConfigItem.autoPlayTime;
            }
            if (list == null || list.size() <= 0) {
                return;
            }
            YYPayResultView.this.q.addAll(list);
            YYPayResultView.this.k();
        }

        @Override // com.yy.mobile.framework.revenuesdk.baseapi.IResult
        public void onFail(int i2, String str, PayCallBackBean payCallBackBean) {
            RLog.error("YYPayResultView", "queryBannerConfig()->onFail->code:" + i2 + " failReason:" + str, new Object[0]);
        }
    }

    public YYPayResultView(Activity activity, i.a.a.e.k.b bVar, i.a.a.e.k.a aVar, int i2, int i3, IYYPayResultView.c cVar) {
        super(activity);
        this.q = new ArrayList();
        if (cVar == null) {
            RLog.error("YYPayResultView", "YYPayResultView construct error viewParams null", new Object[0]);
        }
        this.n = bVar;
        LayoutInflater.from(new ContextThemeWrapper(activity, g.f72167a.a(bVar != null ? bVar.getPayUIKitConfig() : null))).inflate(e.pay_ui_layout_pay_result_view, (ViewGroup) this, true);
        this.f72937e = activity;
        this.r = cVar;
        this.f72940h = (TextView) findViewById(i.a.a.e.d.tv_result);
        Button button = (Button) findViewById(i.a.a.e.d.btn_confirm);
        this.f72938f = i2;
        this.f72939g = i3;
        this.n = bVar;
        this.o = aVar;
        this.f72941i = (ImageView) findViewById(i.a.a.e.d.img_result);
        this.j = (TextView) findViewById(i.a.a.e.d.tv_hint);
        l(cVar != null ? cVar.f72918a : null);
        button.setOnClickListener(new a());
        this.j.setOnClickListener(new b());
        this.k = (PluginCenterTopBanner) findViewById(i.a.a.e.d.banner);
        if (bVar != null && bVar.getPayUIKitConfig() != null) {
            this.k.setImageLoaderSupplier(bVar.getPayUIKitConfig().imageLoaderSupplier);
        }
        i();
    }

    @Override // i.a.a.e.o.a
    public View getContentView() {
        return this;
    }

    public final void i() {
        i.a.a.e.k.a aVar;
        if (this.n != null && (aVar = this.o) != null) {
            GetBannerConfigReqParams a2 = aVar.a();
            if (a2 == null) {
                RLog.error("YYPayResultView", "queryBannerConfig error reqParams null", new Object[0]);
                return;
            }
            a2.setTypes(new int[]{2});
            this.n.h(a2, new d());
            return;
        }
        RLog.warn("YYPayResultView", "queryBannerConfig: invalid param");
    }

    public final void j() {
        IYYPayResultView.b bVar = this.m;
        if (bVar == null) {
            return;
        }
        IYYPayResultView.Result result = bVar.f72916a;
        if (result == IYYPayResultView.Result.PAY_SUUCESS) {
            i.a.a.e.m.a.b(this.f72938f, this.f72939g, UiEventType.successpageclose);
            RLog.warn("YYPayResultView", UiEventType.successpageclose);
        } else if (result == IYYPayResultView.Result.PAY_FAIL) {
            i.a.a.e.m.a.b(this.f72938f, this.f72939g, UiEventType.failpageclose);
            RLog.warn("YYPayResultView", UiEventType.failpageclose);
        }
    }

    public final void k() {
        RLog.info("YYPayResultView", "updateBanner: count=" + this.q.size());
        if (this.q.size() == 0) {
            this.k.setVisibility(8);
            return;
        }
        int i2 = this.p;
        if (i2 > 0) {
            this.k.setFlipInterval(i2);
        }
        this.k.setData(this.q);
        this.k.setOnItemClickListener(new c());
        this.k.setVisibility(0);
    }

    public final void l(IYYPayResultView.b bVar) {
        String str;
        String str2;
        String str3;
        if (bVar == null) {
            return;
        }
        this.m = bVar;
        IYYPayResultView.Result result = bVar.f72916a;
        if (result == IYYPayResultView.Result.PAY_LOADING) {
            this.f72940h.setText("支付中");
        } else if (result == IYYPayResultView.Result.PAY_SUUCESS) {
            CurrencyChargeMessage currencyChargeMessage = bVar.f72917b;
            String str4 = null;
            if (currencyChargeMessage != null && currencyChargeMessage.currencyAmount > 0) {
                str4 = new DecimalFormat("#.##").format(currencyChargeMessage.currencyAmount / 100.0d);
            }
            String str5 = "";
            if (str4 != null) {
                str2 = "成功充值" + str4 + (currencyChargeMessage.currencyType == 4 ? "Y币" : "");
            } else {
                str2 = "充值成功";
            }
            this.f72940h.setText(str2);
            PaysSettingInfo paysSettingInfo = i.a.a.e.l.b.f72155a;
            if (paysSettingInfo != null && (str3 = paysSettingInfo.successMsg) != null) {
                str5 = str3;
            }
            this.j.setText(str5);
            this.f72941i.setImageResource(i.a.a.e.c.pay_ui_pay_success_icon);
            i.a.a.e.m.a.b(this.f72938f, this.f72939g, UiEventType.successpageshow);
            RLog.warn("YYPayResultView", UiEventType.successpageshow);
        } else if (result == IYYPayResultView.Result.PAY_FAIL) {
            this.f72940h.setText("充值失败");
            PaysSettingInfo paysSettingInfo2 = i.a.a.e.l.b.f72155a;
            if (paysSettingInfo2 != null) {
                String str6 = paysSettingInfo2.customerServiceHotline;
                if (str6 != null && !str6.isEmpty()) {
                    String str7 = i.a.a.e.l.b.f72155a.customerServiceHotline;
                }
                String str8 = i.a.a.e.l.b.f72155a.customerServiceMsg;
                if (str8 != null && !str8.isEmpty()) {
                    str = i.a.a.e.l.b.f72155a.customerServiceMsg;
                    this.j.setText(str);
                    this.f72941i.setImageResource(i.a.a.e.c.pay_ui_pay_fail_icon);
                    RLog.warn("YYPayResultView", UiEventType.failpageshow);
                    i.a.a.e.m.a.b(this.f72938f, this.f72939g, UiEventType.failpageshow);
                }
            }
            str = "如有问题可以联系客服 ";
            this.j.setText(str);
            this.f72941i.setImageResource(i.a.a.e.c.pay_ui_pay_fail_icon);
            RLog.warn("YYPayResultView", UiEventType.failpageshow);
            i.a.a.e.m.a.b(this.f72938f, this.f72939g, UiEventType.failpageshow);
        }
    }

    @Override // i.a.a.e.o.a
    public void refreshView() {
    }

    @Override // tv.athena.revenue.payui.view.IYYPayResultView
    public void setCallback(IYYPayResultView.a aVar) {
        this.l = aVar;
    }
}
