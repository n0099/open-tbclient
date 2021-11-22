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
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.SmallTailInfo;
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
import i.a.a.e.k.i;
import i.a.a.e.n.l;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import tv.athena.revenue.payui.model.PayUIKitConfig;
import tv.athena.revenue.payui.view.IYYPayResultView;
import tv.athena.revenue.payui.view.banner.PluginCenterTopBanner;
/* loaded from: classes3.dex */
public class YYPayResultView extends LinearLayout implements IYYPayResultView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public Activity f74085e;

    /* renamed from: f  reason: collision with root package name */
    public int f74086f;

    /* renamed from: g  reason: collision with root package name */
    public int f74087g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f74088h;

    /* renamed from: i  reason: collision with root package name */
    public ImageView f74089i;
    public TextView j;
    public PluginCenterTopBanner k;
    public IYYPayResultView.a l;
    public IYYPayResultView.b m;
    public PayUIKitConfig n;
    public i.a.a.e.l.b o;
    public int p;
    public List<BannerConfigItem.BannerInfo> q;
    public IYYPayResultView.c r;

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ YYPayResultView f74090e;

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
            this.f74090e = yYPayResultView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (this.f74090e.l != null) {
                    this.f74090e.l.a();
                }
                this.f74090e.k();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ YYPayResultView f74091e;

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
            this.f74091e = yYPayResultView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                i.a.a.e.m.b.b(this.f74091e.f74086f, this.f74091e.f74087g, UiEventType.failpagecallnum);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements AdapterView.OnItemClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ YYPayResultView f74092e;

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
            this.f74092e = yYPayResultView;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view, Integer.valueOf(i2), Long.valueOf(j)}) == null) || i2 < 0 || i2 >= this.f74092e.q.size()) {
                return;
            }
            BannerConfigItem.BannerInfo bannerInfo = (BannerConfigItem.BannerInfo) this.f74092e.q.get(i2);
            RLog.info("YYPayResultView", "updateBanner: click=" + bannerInfo);
            if (this.f74092e.r == null || this.f74092e.r.f74049b == null) {
                return;
            }
            this.f74092e.r.f74049b.onBannerClick(bannerInfo);
        }
    }

    /* loaded from: classes3.dex */
    public class d implements IResult<BannerConfigResult> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ YYPayResultView f74093a;

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
            this.f74093a = yYPayResultView;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.yy.mobile.framework.revenuesdk.baseapi.IResult
        /* renamed from: a */
        public void onSuccess(BannerConfigResult bannerConfigResult, PayCallBackBean payCallBackBean) {
            List<BannerConfigItem.BannerInfo> list;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, bannerConfigResult, payCallBackBean) == null) {
                RLog.info("YYPayResultView", "queryBannerConfig onSuccess:" + bannerConfigResult);
                this.f74093a.q.clear();
                if (bannerConfigResult.getBannerConfigItemList() == null || bannerConfigResult.getBannerConfigItemList().size() <= 0) {
                    list = null;
                } else {
                    BannerConfigItem bannerConfigItem = bannerConfigResult.getBannerConfigItemList().get(0);
                    list = bannerConfigItem.bannerInfoList;
                    this.f74093a.p = bannerConfigItem.autoPlayTime;
                }
                if (list == null || list.size() <= 0) {
                    return;
                }
                this.f74093a.q.addAll(list);
                this.f74093a.l();
            }
        }

        @Override // com.yy.mobile.framework.revenuesdk.baseapi.IResult
        public void onFail(int i2, String str, PayCallBackBean payCallBackBean) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeILL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str, payCallBackBean) == null) {
                RLog.error("YYPayResultView", "queryBannerConfig onFail code:" + i2 + " failReason:" + str, new Object[0]);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public YYPayResultView(Activity activity, PayUIKitConfig payUIKitConfig, i.a.a.e.l.b bVar, int i2, int i3, IYYPayResultView.c cVar, i iVar) {
        super(activity);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {activity, payUIKitConfig, bVar, Integer.valueOf(i2), Integer.valueOf(i3), cVar, iVar};
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
        this.n = payUIKitConfig;
        LayoutInflater.from(new ContextThemeWrapper(activity, l.f73284a.a(payUIKitConfig))).inflate(e.pay_ui_layout_pay_result_view, (ViewGroup) this, true);
        this.f74085e = activity;
        this.r = cVar;
        this.f74088h = (TextView) findViewById(i.a.a.e.d.tv_result);
        Button button = (Button) findViewById(i.a.a.e.d.btn_confirm);
        this.f74086f = i2;
        this.f74087g = i3;
        this.o = bVar;
        this.f74089i = (ImageView) findViewById(i.a.a.e.d.img_result);
        this.j = (TextView) findViewById(i.a.a.e.d.tv_hint);
        m(cVar != null ? cVar.f74048a : null);
        button.setOnClickListener(new a(this));
        this.j.setOnClickListener(new b(this));
        PluginCenterTopBanner pluginCenterTopBanner = (PluginCenterTopBanner) findViewById(i.a.a.e.d.banner);
        this.k = pluginCenterTopBanner;
        PayUIKitConfig payUIKitConfig2 = this.n;
        if (payUIKitConfig2 != null) {
            pluginCenterTopBanner.setImageLoaderSupplier(payUIKitConfig2.imageLoaderSupplier);
        }
        i();
    }

    public void finishPayFlow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            RLog.info("YYPayResultView", "finishPayFlow");
            IYYPayResultView.a aVar = this.l;
            if (aVar != null) {
                aVar.b();
            }
        }
    }

    @Override // i.a.a.e.o.a
    public View getContentView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this : (View) invokeV.objValue;
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            GetBannerConfigReqParams a2 = this.o.a();
            if (a2 == null) {
                RLog.error("YYPayResultView", "queryBannerConfig error reqParams null", new Object[0]);
                return;
            }
            a2.setTypes(new int[]{2});
            i.a.a.e.l.d.a(a2, new d(this));
        }
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            IYYPayResultView.a aVar = this.l;
            boolean c2 = aVar != null ? aVar.c() : false;
            RLog.info("YYPayResultView", "showPayGiftDialog:" + c2);
        }
    }

    public final void k() {
        IYYPayResultView.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (bVar = this.m) == null) {
            return;
        }
        IYYPayResultView.Result result = bVar.f74044a;
        if (result == IYYPayResultView.Result.PAY_SUUCESS) {
            i.a.a.e.m.b.b(this.f74086f, this.f74087g, UiEventType.successpageclose);
            RLog.info("YYPayResultView", UiEventType.successpageclose);
        } else if (result == IYYPayResultView.Result.PAY_FAIL) {
            i.a.a.e.m.b.b(this.f74086f, this.f74087g, UiEventType.failpageclose);
            RLog.info("YYPayResultView", UiEventType.failpageclose);
        }
    }

    public final void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
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

    public final void m(IYYPayResultView.b bVar) {
        String str;
        String str2;
        String str3;
        String str4;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, bVar) == null) || bVar == null) {
            return;
        }
        this.m = bVar;
        IYYPayResultView.Result result = bVar.f74044a;
        if (result == IYYPayResultView.Result.PAY_LOADING) {
            this.f74088h.setText("支付中");
        } else if (result == IYYPayResultView.Result.PAY_SUUCESS) {
            CurrencyChargeMessage currencyChargeMessage = bVar.f74045b;
            String str5 = null;
            if (currencyChargeMessage != null && currencyChargeMessage.currencyAmount > 0) {
                str5 = new DecimalFormat("#.##").format(currencyChargeMessage.currencyAmount / 100.0d);
            }
            String str6 = "";
            if (str5 != null) {
                str3 = "成功充值" + str5 + (currencyChargeMessage.currencyType == 4 ? "Y币" : "");
            } else {
                str3 = "充值成功";
            }
            this.f74088h.setText(str3);
            PaysSettingInfo paysSettingInfo = i.a.a.e.l.e.f73271a;
            if (paysSettingInfo != null && (str4 = paysSettingInfo.successMsg) != null) {
                str6 = str4;
            }
            this.j.setText(str6);
            this.f74089i.setImageResource(i.a.a.e.c.pay_ui_pay_success_icon);
            i.a.a.e.m.b.b(this.f74086f, this.f74087g, UiEventType.successpageshow);
            RLog.info("YYPayResultView", UiEventType.successpageshow);
        } else if (result == IYYPayResultView.Result.PAY_FAIL) {
            CurrencyChargeMessage currencyChargeMessage2 = bVar.f74045b;
            if (currencyChargeMessage2 == null) {
                String str7 = bVar.f74047d;
                str = (str7 != null ? str7 : "充值失败") + "(" + bVar.f74046c + SmallTailInfo.EMOTION_SUFFIX;
            } else {
                String str8 = currencyChargeMessage2.message;
                str = (str8 != null ? str8 : "充值失败") + "(" + bVar.f74045b.status + SmallTailInfo.EMOTION_SUFFIX;
            }
            this.f74088h.setText(str);
            PaysSettingInfo paysSettingInfo2 = i.a.a.e.l.e.f73271a;
            this.j.setText((paysSettingInfo2 == null || (str2 = paysSettingInfo2.customerServiceMsg) == null || str2.isEmpty()) ? "如有问题可以联系客服 " : i.a.a.e.l.e.f73271a.customerServiceMsg);
            this.f74089i.setImageResource(i.a.a.e.c.pay_ui_pay_fail_icon);
            RLog.info("YYPayResultView", UiEventType.failpageshow);
            i.a.a.e.m.b.b(this.f74086f, this.f74087g, UiEventType.failpageshow);
        }
    }

    @Override // i.a.a.e.o.a
    public void refreshView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
        }
    }

    @Override // tv.athena.revenue.payui.view.IYYPayResultView
    public void setCallback(IYYPayResultView.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, aVar) == null) {
            RLog.info("YYPayResultView", "setCallback");
            this.l = aVar;
            j();
        }
    }
}
