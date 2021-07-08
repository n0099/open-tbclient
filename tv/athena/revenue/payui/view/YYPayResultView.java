package tv.athena.revenue.payui.view;

import android.app.Activity;
import android.content.Context;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
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
/* loaded from: classes9.dex */
public class YYPayResultView extends LinearLayout implements IYYPayResultView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public Activity f73751e;

    /* renamed from: f  reason: collision with root package name */
    public int f73752f;

    /* renamed from: g  reason: collision with root package name */
    public int f73753g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f73754h;

    /* renamed from: i  reason: collision with root package name */
    public ImageView f73755i;
    public TextView j;
    public PluginCenterTopBanner k;
    public IYYPayResultView.a l;
    public IYYPayResultView.b m;
    public i.a.a.e.k.b n;
    public i.a.a.e.k.a o;
    public int p;
    public List<BannerConfigItem.BannerInfo> q;
    public IYYPayResultView.c r;

    /* loaded from: classes9.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ YYPayResultView f73756e;

        public a(YYPayResultView yYPayResultView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yYPayResultView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f73756e = yYPayResultView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (this.f73756e.l != null) {
                    this.f73756e.l.a();
                }
                this.f73756e.j();
            }
        }
    }

    /* loaded from: classes9.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ YYPayResultView f73757e;

        public b(YYPayResultView yYPayResultView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yYPayResultView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f73757e = yYPayResultView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                i.a.a.e.m.a.b(this.f73757e.f73752f, this.f73757e.f73753g, UiEventType.failpagecallnum);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class c implements AdapterView.OnItemClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ YYPayResultView f73758e;

        public c(YYPayResultView yYPayResultView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yYPayResultView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f73758e = yYPayResultView;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view, Integer.valueOf(i2), Long.valueOf(j)}) == null) || i2 < 0 || i2 >= this.f73758e.q.size()) {
                return;
            }
            BannerConfigItem.BannerInfo bannerInfo = (BannerConfigItem.BannerInfo) this.f73758e.q.get(i2);
            RLog.info("YYPayResultView", "updateBanner: click=" + bannerInfo);
            if (this.f73758e.r == null || this.f73758e.r.f73733b == null) {
                return;
            }
            this.f73758e.r.f73733b.onBannerClick(bannerInfo);
        }
    }

    /* loaded from: classes9.dex */
    public class d implements IResult<BannerConfigResult> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ YYPayResultView f73759a;

        public d(YYPayResultView yYPayResultView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yYPayResultView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f73759a = yYPayResultView;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.yy.mobile.framework.revenuesdk.baseapi.IResult
        /* renamed from: a */
        public void onSuccess(BannerConfigResult bannerConfigResult, PayCallBackBean payCallBackBean) {
            List<BannerConfigItem.BannerInfo> list;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, bannerConfigResult, payCallBackBean) == null) {
                RLog.info("YYPayResultView", "queryBannerConfig()->onSuccess:" + bannerConfigResult);
                this.f73759a.q.clear();
                if (bannerConfigResult.getBannerConfigItemList() == null || bannerConfigResult.getBannerConfigItemList().size() <= 0) {
                    list = null;
                } else {
                    BannerConfigItem bannerConfigItem = bannerConfigResult.getBannerConfigItemList().get(0);
                    list = bannerConfigItem.bannerInfoList;
                    this.f73759a.p = bannerConfigItem.autoPlayTime;
                }
                if (list == null || list.size() <= 0) {
                    return;
                }
                this.f73759a.q.addAll(list);
                this.f73759a.k();
            }
        }

        @Override // com.yy.mobile.framework.revenuesdk.baseapi.IResult
        public void onFail(int i2, String str, PayCallBackBean payCallBackBean) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeILL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str, payCallBackBean) == null) {
                RLog.error("YYPayResultView", "queryBannerConfig()->onFail->code:" + i2 + " failReason:" + str, new Object[0]);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public YYPayResultView(Activity activity, i.a.a.e.k.b bVar, i.a.a.e.k.a aVar, int i2, int i3, IYYPayResultView.c cVar) {
        super(activity);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {activity, bVar, aVar, Integer.valueOf(i2), Integer.valueOf(i3), cVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.q = new ArrayList();
        if (cVar == null) {
            RLog.error("YYPayResultView", "YYPayResultView construct error viewParams null", new Object[0]);
        }
        this.n = bVar;
        LayoutInflater.from(new ContextThemeWrapper(activity, g.f72897a.a(bVar != null ? bVar.getPayUIKitConfig() : null))).inflate(e.pay_ui_layout_pay_result_view, (ViewGroup) this, true);
        this.f73751e = activity;
        this.r = cVar;
        this.f73754h = (TextView) findViewById(i.a.a.e.d.tv_result);
        Button button = (Button) findViewById(i.a.a.e.d.btn_confirm);
        this.f73752f = i2;
        this.f73753g = i3;
        this.n = bVar;
        this.o = aVar;
        this.f73755i = (ImageView) findViewById(i.a.a.e.d.img_result);
        this.j = (TextView) findViewById(i.a.a.e.d.tv_hint);
        l(cVar != null ? cVar.f73732a : null);
        button.setOnClickListener(new a(this));
        this.j.setOnClickListener(new b(this));
        this.k = (PluginCenterTopBanner) findViewById(i.a.a.e.d.banner);
        if (bVar != null && bVar.getPayUIKitConfig() != null) {
            this.k.setImageLoaderSupplier(bVar.getPayUIKitConfig().imageLoaderSupplier);
        }
        i();
    }

    @Override // i.a.a.e.o.a
    public View getContentView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this : (View) invokeV.objValue;
    }

    public final void i() {
        i.a.a.e.k.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            if (this.n != null && (aVar = this.o) != null) {
                GetBannerConfigReqParams a2 = aVar.a();
                if (a2 == null) {
                    RLog.error("YYPayResultView", "queryBannerConfig error reqParams null", new Object[0]);
                    return;
                }
                a2.setTypes(new int[]{2});
                this.n.h(a2, new d(this));
                return;
            }
            RLog.warn("YYPayResultView", "queryBannerConfig: invalid param");
        }
    }

    public final void j() {
        IYYPayResultView.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (bVar = this.m) == null) {
            return;
        }
        IYYPayResultView.Result result = bVar.f73730a;
        if (result == IYYPayResultView.Result.PAY_SUUCESS) {
            i.a.a.e.m.a.b(this.f73752f, this.f73753g, UiEventType.successpageclose);
            RLog.warn("YYPayResultView", UiEventType.successpageclose);
        } else if (result == IYYPayResultView.Result.PAY_FAIL) {
            i.a.a.e.m.a.b(this.f73752f, this.f73753g, UiEventType.failpageclose);
            RLog.warn("YYPayResultView", UiEventType.failpageclose);
        }
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
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
            this.k.setOnItemClickListener(new c(this));
            this.k.setVisibility(0);
        }
    }

    public final void l(IYYPayResultView.b bVar) {
        String str;
        String str2;
        String str3;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, bVar) == null) || bVar == null) {
            return;
        }
        this.m = bVar;
        IYYPayResultView.Result result = bVar.f73730a;
        if (result == IYYPayResultView.Result.PAY_LOADING) {
            this.f73754h.setText("支付中");
        } else if (result == IYYPayResultView.Result.PAY_SUUCESS) {
            CurrencyChargeMessage currencyChargeMessage = bVar.f73731b;
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
            this.f73754h.setText(str2);
            PaysSettingInfo paysSettingInfo = i.a.a.e.l.b.f72885a;
            if (paysSettingInfo != null && (str3 = paysSettingInfo.successMsg) != null) {
                str5 = str3;
            }
            this.j.setText(str5);
            this.f73755i.setImageResource(i.a.a.e.c.pay_ui_pay_success_icon);
            i.a.a.e.m.a.b(this.f73752f, this.f73753g, UiEventType.successpageshow);
            RLog.warn("YYPayResultView", UiEventType.successpageshow);
        } else if (result == IYYPayResultView.Result.PAY_FAIL) {
            this.f73754h.setText("充值失败");
            PaysSettingInfo paysSettingInfo2 = i.a.a.e.l.b.f72885a;
            if (paysSettingInfo2 != null) {
                String str6 = paysSettingInfo2.customerServiceHotline;
                if (str6 != null && !str6.isEmpty()) {
                    String str7 = i.a.a.e.l.b.f72885a.customerServiceHotline;
                }
                String str8 = i.a.a.e.l.b.f72885a.customerServiceMsg;
                if (str8 != null && !str8.isEmpty()) {
                    str = i.a.a.e.l.b.f72885a.customerServiceMsg;
                    this.j.setText(str);
                    this.f73755i.setImageResource(i.a.a.e.c.pay_ui_pay_fail_icon);
                    RLog.warn("YYPayResultView", UiEventType.failpageshow);
                    i.a.a.e.m.a.b(this.f73752f, this.f73753g, UiEventType.failpageshow);
                }
            }
            str = "如有问题可以联系客服 ";
            this.j.setText(str);
            this.f73755i.setImageResource(i.a.a.e.c.pay_ui_pay_fail_icon);
            RLog.warn("YYPayResultView", UiEventType.failpageshow);
            i.a.a.e.m.a.b(this.f73752f, this.f73753g, UiEventType.failpageshow);
        }
    }

    @Override // i.a.a.e.o.a
    public void refreshView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
        }
    }

    @Override // tv.athena.revenue.payui.view.IYYPayResultView
    public void setCallback(IYYPayResultView.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, aVar) == null) {
            this.l = aVar;
        }
    }
}
