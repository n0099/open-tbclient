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
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.tieba.R;
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
import h.a.a.e.h.o;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import tv.athena.revenue.payui.model.BannerItemSelectListener;
import tv.athena.revenue.payui.model.PayUIKitConfig;
import tv.athena.revenue.payui.view.IYYPayResultView;
import tv.athena.revenue.payui.view.banner.PluginCenterTopBanner;
/* loaded from: classes8.dex */
public class YYPayResultView extends LinearLayout implements IYYPayResultView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Activity a;

    /* renamed from: b  reason: collision with root package name */
    public int f45871b;

    /* renamed from: c  reason: collision with root package name */
    public int f45872c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f45873d;

    /* renamed from: e  reason: collision with root package name */
    public ImageView f45874e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f45875f;

    /* renamed from: g  reason: collision with root package name */
    public PluginCenterTopBanner f45876g;

    /* renamed from: h  reason: collision with root package name */
    public IYYPayResultView.a f45877h;
    public IYYPayResultView.b i;
    public PayUIKitConfig j;
    public h.a.a.e.f.b k;
    public int l;
    public List<BannerConfigItem.BannerInfo> m;
    public IYYPayResultView.c n;

    /* loaded from: classes8.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ YYPayResultView a;

        public a(YYPayResultView yYPayResultView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yYPayResultView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = yYPayResultView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (this.a.f45877h != null) {
                    this.a.f45877h.a();
                }
                this.a.k();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ YYPayResultView a;

        public b(YYPayResultView yYPayResultView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yYPayResultView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = yYPayResultView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                h.a.a.e.g.b.b(this.a.f45871b, this.a.f45872c, UiEventType.failpagecallnum);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c implements AdapterView.OnItemClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ YYPayResultView a;

        public c(YYPayResultView yYPayResultView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yYPayResultView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = yYPayResultView;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view, Integer.valueOf(i), Long.valueOf(j)}) == null) || i < 0 || i >= this.a.m.size()) {
                return;
            }
            BannerConfigItem.BannerInfo bannerInfo = (BannerConfigItem.BannerInfo) this.a.m.get(i);
            RLog.info("YYPayResultView", "onItemClick: click=" + bannerInfo);
            if (this.a.n != null && this.a.n.f45836b != null) {
                this.a.n.f45836b.onBannerClick(bannerInfo);
            }
            h.a.a.e.g.b.d(this.a.f45871b, this.a.f45872c, "23", "", "", bannerInfo.id);
        }
    }

    /* loaded from: classes8.dex */
    public class d implements BannerItemSelectListener {
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = yYPayResultView;
        }

        @Override // tv.athena.revenue.payui.model.BannerItemSelectListener
        public void onItemSelected(int i) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeI(1048576, this, i) == null) || i < 0 || i >= this.a.m.size()) {
                return;
            }
            BannerConfigItem.BannerInfo bannerInfo = (BannerConfigItem.BannerInfo) this.a.m.get(i);
            RLog.debug("YYPayResultView", "onItemSelected: item=" + bannerInfo);
            h.a.a.e.g.b.d(this.a.f45871b, this.a.f45872c, "22", "", "", bannerInfo.id);
        }
    }

    /* loaded from: classes8.dex */
    public class e implements IResult<BannerConfigResult> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ YYPayResultView a;

        public e(YYPayResultView yYPayResultView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yYPayResultView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
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
                this.a.m.clear();
                if (bannerConfigResult.getBannerConfigItemList() == null || bannerConfigResult.getBannerConfigItemList().size() <= 0) {
                    list = null;
                } else {
                    BannerConfigItem bannerConfigItem = bannerConfigResult.getBannerConfigItemList().get(0);
                    list = bannerConfigItem.bannerInfoList;
                    this.a.l = bannerConfigItem.autoPlayTime;
                }
                if (list == null || list.size() <= 0) {
                    return;
                }
                this.a.m.addAll(list);
                this.a.l();
            }
        }

        @Override // com.yy.mobile.framework.revenuesdk.baseapi.IResult
        public void onFail(int i, String str, PayCallBackBean payCallBackBean) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeILL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str, payCallBackBean) == null) {
                RLog.error("YYPayResultView", "queryBannerConfig onFail code:" + i + " failReason:" + str, new Object[0]);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public YYPayResultView(Activity activity, PayUIKitConfig payUIKitConfig, h.a.a.e.f.b bVar, int i, int i2, IYYPayResultView.c cVar, h.a.a.e.e.d dVar) {
        super(activity);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {activity, payUIKitConfig, bVar, Integer.valueOf(i), Integer.valueOf(i2), cVar, dVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.m = new ArrayList();
        if (cVar == null) {
            RLog.error("YYPayResultView", "YYPayResultView construct error viewParams null", new Object[0]);
        }
        this.j = payUIKitConfig;
        LayoutInflater.from(new ContextThemeWrapper(activity, o.a.a(payUIKitConfig))).inflate(R.layout.obfuscated_res_0x7f0d066b, (ViewGroup) this, true);
        this.a = activity;
        this.n = cVar;
        this.f45873d = (TextView) findViewById(R.id.obfuscated_res_0x7f092204);
        Button button = (Button) findViewById(R.id.obfuscated_res_0x7f09040e);
        this.f45871b = i;
        this.f45872c = i2;
        this.k = bVar;
        this.f45874e = (ImageView) findViewById(R.id.obfuscated_res_0x7f090ecf);
        this.f45875f = (TextView) findViewById(R.id.obfuscated_res_0x7f0921c2);
        m(cVar != null ? cVar.a : null);
        button.setOnClickListener(new a(this));
        this.f45875f.setOnClickListener(new b(this));
        PluginCenterTopBanner pluginCenterTopBanner = (PluginCenterTopBanner) findViewById(R.id.obfuscated_res_0x7f0902f6);
        this.f45876g = pluginCenterTopBanner;
        PayUIKitConfig payUIKitConfig2 = this.j;
        if (payUIKitConfig2 != null) {
            pluginCenterTopBanner.setImageLoaderSupplier(payUIKitConfig2.imageLoaderSupplier);
        }
        i();
    }

    @Override // h.a.a.e.i.a
    public View getContentView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this : (View) invokeV.objValue;
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            GetBannerConfigReqParams a2 = this.k.a();
            if (a2 == null) {
                RLog.error("YYPayResultView", "queryBannerConfig error reqParams null", new Object[0]);
                return;
            }
            a2.setTypes(new int[]{2});
            h.a.a.e.f.d.a(a2, new e(this));
        }
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            IYYPayResultView.a aVar = this.f45877h;
            boolean b2 = aVar != null ? aVar.b() : false;
            RLog.info("YYPayResultView", "showPayGiftDialog:" + b2);
        }
    }

    public final void k() {
        IYYPayResultView.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (bVar = this.i) == null) {
            return;
        }
        IYYPayResultView.Result result = bVar.a;
        if (result == IYYPayResultView.Result.PAY_SUUCESS) {
            h.a.a.e.g.b.b(this.f45871b, this.f45872c, UiEventType.successpageclose);
            RLog.info("YYPayResultView", UiEventType.successpageclose);
        } else if (result == IYYPayResultView.Result.PAY_FAIL) {
            h.a.a.e.g.b.b(this.f45871b, this.f45872c, UiEventType.failpageclose);
            RLog.info("YYPayResultView", UiEventType.failpageclose);
        }
    }

    public final void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            RLog.info("YYPayResultView", "updateBanner: count=" + this.m.size());
            if (this.m.size() == 0) {
                this.f45876g.setVisibility(8);
                return;
            }
            int i = this.l;
            if (i > 0) {
                this.f45876g.setFlipInterval(i);
            }
            this.f45876g.setData(this.m);
            this.f45876g.setOnItemClickListener(new c(this));
            this.f45876g.setBannerItemSelectListener(new d(this));
            this.f45876g.setVisibility(0);
        }
    }

    public final void m(IYYPayResultView.b bVar) {
        String str;
        String str2;
        String str3;
        String str4;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, bVar) == null) || bVar == null) {
            return;
        }
        this.i = bVar;
        IYYPayResultView.Result result = bVar.a;
        if (result == IYYPayResultView.Result.PAY_LOADING) {
            this.f45873d.setText("支付中");
        } else if (result == IYYPayResultView.Result.PAY_SUUCESS) {
            CurrencyChargeMessage currencyChargeMessage = bVar.f45833b;
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
            this.f45873d.setText(str3);
            PaysSettingInfo paysSettingInfo = h.a.a.e.f.e.a;
            if (paysSettingInfo != null && (str4 = paysSettingInfo.successMsg) != null) {
                str6 = str4;
            }
            this.f45875f.setText(str6);
            this.f45874e.setImageResource(R.drawable.obfuscated_res_0x7f080e9a);
            h.a.a.e.g.b.b(this.f45871b, this.f45872c, UiEventType.successpageshow);
            RLog.info("YYPayResultView", UiEventType.successpageshow);
        } else if (result == IYYPayResultView.Result.PAY_FAIL) {
            CurrencyChargeMessage currencyChargeMessage2 = bVar.f45833b;
            if (currencyChargeMessage2 == null) {
                String str7 = bVar.f45835d;
                str = (str7 != null ? str7 : "充值失败") + "(" + bVar.f45834c + SmallTailInfo.EMOTION_SUFFIX;
            } else {
                String str8 = currencyChargeMessage2.message;
                str = (str8 != null ? str8 : "充值失败") + "(" + bVar.f45833b.status + SmallTailInfo.EMOTION_SUFFIX;
            }
            this.f45873d.setText(str);
            PaysSettingInfo paysSettingInfo2 = h.a.a.e.f.e.a;
            this.f45875f.setText((paysSettingInfo2 == null || (str2 = paysSettingInfo2.customerServiceMsg) == null || str2.isEmpty()) ? "如有问题可以联系客服 " : h.a.a.e.f.e.a.customerServiceMsg);
            this.f45874e.setImageResource(R.drawable.obfuscated_res_0x7f080e97);
            RLog.info("YYPayResultView", UiEventType.failpageshow);
            h.a.a.e.g.b.b(this.f45871b, this.f45872c, UiEventType.failpageshow);
        }
    }

    @Override // h.a.a.e.i.a
    public void refreshView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
        }
    }

    @Override // tv.athena.revenue.payui.view.IYYPayResultView
    public void setCallback(IYYPayResultView.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, aVar) == null) {
            RLog.info("YYPayResultView", "setCallback");
            this.f45877h = aVar;
            j();
        }
    }
}
