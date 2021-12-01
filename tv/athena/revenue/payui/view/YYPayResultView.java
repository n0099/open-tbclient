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
import j.a.a.e.e;
import j.a.a.e.k.i;
import j.a.a.e.n.l;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import tv.athena.revenue.payui.model.PayUIKitConfig;
import tv.athena.revenue.payui.view.IYYPayResultView;
import tv.athena.revenue.payui.view.banner.PluginCenterTopBanner;
/* loaded from: classes4.dex */
public class YYPayResultView extends LinearLayout implements IYYPayResultView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public Activity f64851e;

    /* renamed from: f  reason: collision with root package name */
    public int f64852f;

    /* renamed from: g  reason: collision with root package name */
    public int f64853g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f64854h;

    /* renamed from: i  reason: collision with root package name */
    public ImageView f64855i;

    /* renamed from: j  reason: collision with root package name */
    public TextView f64856j;

    /* renamed from: k  reason: collision with root package name */
    public PluginCenterTopBanner f64857k;
    public IYYPayResultView.a l;
    public IYYPayResultView.b m;
    public PayUIKitConfig n;
    public j.a.a.e.l.b o;
    public int p;
    public List<BannerConfigItem.BannerInfo> q;
    public IYYPayResultView.c r;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ YYPayResultView f64858e;

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
            this.f64858e = yYPayResultView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (this.f64858e.l != null) {
                    this.f64858e.l.a();
                }
                this.f64858e.k();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ YYPayResultView f64859e;

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
            this.f64859e = yYPayResultView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                j.a.a.e.m.b.b(this.f64859e.f64852f, this.f64859e.f64853g, UiEventType.failpagecallnum);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements AdapterView.OnItemClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ YYPayResultView f64860e;

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
            this.f64860e = yYPayResultView;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view, Integer.valueOf(i2), Long.valueOf(j2)}) == null) || i2 < 0 || i2 >= this.f64860e.q.size()) {
                return;
            }
            BannerConfigItem.BannerInfo bannerInfo = (BannerConfigItem.BannerInfo) this.f64860e.q.get(i2);
            RLog.info("YYPayResultView", "updateBanner: click=" + bannerInfo);
            if (this.f64860e.r == null || this.f64860e.r.f64812b == null) {
                return;
            }
            this.f64860e.r.f64812b.onBannerClick(bannerInfo);
        }
    }

    /* loaded from: classes4.dex */
    public class d implements IResult<BannerConfigResult> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ YYPayResultView a;

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
            this.a = yYPayResultView;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.yy.mobile.framework.revenuesdk.baseapi.IResult
        /* renamed from: a */
        public void onSuccess(BannerConfigResult bannerConfigResult, PayCallBackBean payCallBackBean) {
            List<BannerConfigItem.BannerInfo> list;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, bannerConfigResult, payCallBackBean) == null) {
                RLog.info("YYPayResultView", "queryBannerConfig onSuccess:" + bannerConfigResult);
                this.a.q.clear();
                if (bannerConfigResult.getBannerConfigItemList() == null || bannerConfigResult.getBannerConfigItemList().size() <= 0) {
                    list = null;
                } else {
                    BannerConfigItem bannerConfigItem = bannerConfigResult.getBannerConfigItemList().get(0);
                    list = bannerConfigItem.bannerInfoList;
                    this.a.p = bannerConfigItem.autoPlayTime;
                }
                if (list == null || list.size() <= 0) {
                    return;
                }
                this.a.q.addAll(list);
                this.a.l();
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
    public YYPayResultView(Activity activity, PayUIKitConfig payUIKitConfig, j.a.a.e.l.b bVar, int i2, int i3, IYYPayResultView.c cVar, i iVar) {
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
        LayoutInflater.from(new ContextThemeWrapper(activity, l.a.a(payUIKitConfig))).inflate(e.pay_ui_layout_pay_result_view, (ViewGroup) this, true);
        this.f64851e = activity;
        this.r = cVar;
        this.f64854h = (TextView) findViewById(j.a.a.e.d.tv_result);
        Button button = (Button) findViewById(j.a.a.e.d.btn_confirm);
        this.f64852f = i2;
        this.f64853g = i3;
        this.o = bVar;
        this.f64855i = (ImageView) findViewById(j.a.a.e.d.img_result);
        this.f64856j = (TextView) findViewById(j.a.a.e.d.tv_hint);
        m(cVar != null ? cVar.a : null);
        button.setOnClickListener(new a(this));
        this.f64856j.setOnClickListener(new b(this));
        PluginCenterTopBanner pluginCenterTopBanner = (PluginCenterTopBanner) findViewById(j.a.a.e.d.banner);
        this.f64857k = pluginCenterTopBanner;
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

    @Override // j.a.a.e.o.a
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
            j.a.a.e.l.d.a(a2, new d(this));
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
        IYYPayResultView.Result result = bVar.a;
        if (result == IYYPayResultView.Result.PAY_SUUCESS) {
            j.a.a.e.m.b.b(this.f64852f, this.f64853g, UiEventType.successpageclose);
            RLog.info("YYPayResultView", UiEventType.successpageclose);
        } else if (result == IYYPayResultView.Result.PAY_FAIL) {
            j.a.a.e.m.b.b(this.f64852f, this.f64853g, UiEventType.failpageclose);
            RLog.info("YYPayResultView", UiEventType.failpageclose);
        }
    }

    public final void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            RLog.info("YYPayResultView", "updateBanner: count=" + this.q.size());
            if (this.q.size() == 0) {
                this.f64857k.setVisibility(8);
                return;
            }
            int i2 = this.p;
            if (i2 > 0) {
                this.f64857k.setFlipInterval(i2);
            }
            this.f64857k.setData(this.q);
            this.f64857k.setOnItemClickListener(new c(this));
            this.f64857k.setVisibility(0);
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
        IYYPayResultView.Result result = bVar.a;
        if (result == IYYPayResultView.Result.PAY_LOADING) {
            this.f64854h.setText("支付中");
        } else if (result == IYYPayResultView.Result.PAY_SUUCESS) {
            CurrencyChargeMessage currencyChargeMessage = bVar.f64809b;
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
            this.f64854h.setText(str3);
            PaysSettingInfo paysSettingInfo = j.a.a.e.l.e.a;
            if (paysSettingInfo != null && (str4 = paysSettingInfo.successMsg) != null) {
                str6 = str4;
            }
            this.f64856j.setText(str6);
            this.f64855i.setImageResource(j.a.a.e.c.pay_ui_pay_success_icon);
            j.a.a.e.m.b.b(this.f64852f, this.f64853g, UiEventType.successpageshow);
            RLog.info("YYPayResultView", UiEventType.successpageshow);
        } else if (result == IYYPayResultView.Result.PAY_FAIL) {
            CurrencyChargeMessage currencyChargeMessage2 = bVar.f64809b;
            if (currencyChargeMessage2 == null) {
                String str7 = bVar.f64811d;
                str = (str7 != null ? str7 : "充值失败") + "(" + bVar.f64810c + SmallTailInfo.EMOTION_SUFFIX;
            } else {
                String str8 = currencyChargeMessage2.message;
                str = (str8 != null ? str8 : "充值失败") + "(" + bVar.f64809b.status + SmallTailInfo.EMOTION_SUFFIX;
            }
            this.f64854h.setText(str);
            PaysSettingInfo paysSettingInfo2 = j.a.a.e.l.e.a;
            this.f64856j.setText((paysSettingInfo2 == null || (str2 = paysSettingInfo2.customerServiceMsg) == null || str2.isEmpty()) ? "如有问题可以联系客服 " : j.a.a.e.l.e.a.customerServiceMsg);
            this.f64855i.setImageResource(j.a.a.e.c.pay_ui_pay_fail_icon);
            RLog.info("YYPayResultView", UiEventType.failpageshow);
            j.a.a.e.m.b.b(this.f64852f, this.f64853g, UiEventType.failpageshow);
        }
    }

    @Override // j.a.a.e.o.a
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
