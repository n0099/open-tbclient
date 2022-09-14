package tv.athena.revenue.payui.view.impl;

import android.app.Activity;
import android.content.Context;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.tieba.R;
import com.baidu.tieba.e4a;
import com.baidu.tieba.m2a;
import com.baidu.tieba.v4a;
import com.baidu.tieba.w3a;
import com.baidu.tieba.y3a;
import com.baidu.tieba.z3a;
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
import com.yy.mobile.framework.revenuesdk.payapi.callbackresult.BannerConfigResult;
import com.yy.mobile.framework.revenuesdk.payapi.request.GetBannerConfigReqParams;
import com.yy.mobile.framework.revenuesdk.statistics.hiido.eventtype.PayUIEventType;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import tv.athena.revenue.payui.model.BannerItemSelectListener;
import tv.athena.revenue.payui.model.PayUIKitConfig;
import tv.athena.revenue.payui.view.IYYPayResultView;
import tv.athena.revenue.payui.view.WindowParams;
import tv.athena.revenue.payui.view.banner.PluginCenterTopBanner;
/* loaded from: classes9.dex */
public class YYPayResultView extends LinearLayout implements IYYPayResultView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Activity a;
    public int b;
    public int c;
    public TextView d;
    public ImageView e;
    public TextView f;
    public PluginCenterTopBanner g;
    public IYYPayResultView.a h;
    public IYYPayResultView.b i;
    public PayUIKitConfig j;
    public w3a k;
    public int l;
    public List<BannerConfigItem.BannerInfo> m;
    public IYYPayResultView.c n;
    public Window o;

    /* loaded from: classes9.dex */
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
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (this.a.h != null) {
                    this.a.h.a();
                }
                this.a.k();
            }
        }
    }

    /* loaded from: classes9.dex */
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
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                e4a.b(this.a.b, this.a.c, PayUIEventType.failpagecallnum);
            }
        }
    }

    /* loaded from: classes9.dex */
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
        public void onItemClick(AdapterView<?> adapterView, View view2, int i, long j) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view2, Integer.valueOf(i), Long.valueOf(j)}) == null) || i < 0 || i >= this.a.m.size()) {
                return;
            }
            BannerConfigItem.BannerInfo bannerInfo = (BannerConfigItem.BannerInfo) this.a.m.get(i);
            RLog.info("YYPayResultView", "onItemClick: click=" + bannerInfo);
            if (this.a.n != null && this.a.n.b != null) {
                this.a.n.b.onBannerClick(bannerInfo);
            }
            e4a.d(this.a.b, this.a.c, "23", "", "", bannerInfo.id);
        }
    }

    /* loaded from: classes9.dex */
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
            e4a.d(this.a.b, this.a.c, "22", "", "", bannerInfo.id);
        }
    }

    /* loaded from: classes9.dex */
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
    public YYPayResultView(Activity activity, PayUIKitConfig payUIKitConfig, w3a w3aVar, int i, int i2, IYYPayResultView.c cVar, m2a m2aVar) {
        super(activity);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {activity, payUIKitConfig, w3aVar, Integer.valueOf(i), Integer.valueOf(i2), cVar, m2aVar};
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
        LayoutInflater.from(new ContextThemeWrapper(activity, v4a.a.a(payUIKitConfig))).inflate(R.layout.obfuscated_res_0x7f0d06ae, (ViewGroup) this, true);
        this.a = activity;
        this.n = cVar;
        this.d = (TextView) findViewById(R.id.obfuscated_res_0x7f0923fb);
        Button button = (Button) findViewById(R.id.obfuscated_res_0x7f090430);
        this.b = i;
        this.c = i2;
        this.k = w3aVar;
        this.e = (ImageView) findViewById(R.id.obfuscated_res_0x7f090f01);
        this.f = (TextView) findViewById(R.id.obfuscated_res_0x7f0923ac);
        m(cVar != null ? cVar.a : null);
        button.setOnClickListener(new a(this));
        this.f.setOnClickListener(new b(this));
        PluginCenterTopBanner pluginCenterTopBanner = (PluginCenterTopBanner) findViewById(R.id.obfuscated_res_0x7f09031c);
        this.g = pluginCenterTopBanner;
        PayUIKitConfig payUIKitConfig2 = this.j;
        if (payUIKitConfig2 != null) {
            pluginCenterTopBanner.setImageLoaderSupplier(payUIKitConfig2.imageLoaderSupplier);
        }
        i();
    }

    @Override // com.baidu.tieba.y4a
    public void attachWindow(Window window) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, window) == null) {
            RLog.debug("YYPayResultView", "attachWindow window:" + window);
            this.o = window;
            IYYPayResultView.c cVar = this.n;
            if (cVar != null) {
                refreshWindow(cVar.c);
            }
        }
    }

    @Override // com.baidu.tieba.y4a
    public View getContentView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this : (View) invokeV.objValue;
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            GetBannerConfigReqParams a2 = this.k.a();
            if (a2 == null) {
                RLog.error("YYPayResultView", "queryBannerConfig error reqParams null", new Object[0]);
                return;
            }
            a2.setTypes(new int[]{2});
            y3a.a(a2, new e(this));
        }
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            IYYPayResultView.a aVar = this.h;
            boolean b2 = aVar != null ? aVar.b() : false;
            RLog.info("YYPayResultView", "showPayGiftDialog:" + b2);
        }
    }

    public final void k() {
        IYYPayResultView.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (bVar = this.i) == null) {
            return;
        }
        IYYPayResultView.Result result = bVar.a;
        if (result == IYYPayResultView.Result.PAY_SUUCESS) {
            e4a.b(this.b, this.c, PayUIEventType.successpageclose);
            RLog.info("YYPayResultView", PayUIEventType.successpageclose);
        } else if (result == IYYPayResultView.Result.PAY_FAIL) {
            e4a.b(this.b, this.c, PayUIEventType.failpageclose);
            RLog.info("YYPayResultView", PayUIEventType.failpageclose);
        }
    }

    public final void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            RLog.info("YYPayResultView", "updateBanner: count=" + this.m.size());
            if (this.m.size() == 0) {
                this.g.setVisibility(8);
                return;
            }
            int i = this.l;
            if (i > 0) {
                this.g.setFlipInterval(i);
            }
            this.g.setData(this.m);
            this.g.setOnItemClickListener(new c(this));
            this.g.setBannerItemSelectListener(new d(this));
            this.g.setVisibility(0);
        }
    }

    public final void m(IYYPayResultView.b bVar) {
        String str;
        String str2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, bVar) == null) || bVar == null) {
            return;
        }
        this.i = bVar;
        IYYPayResultView.Result result = bVar.a;
        if (result == IYYPayResultView.Result.PAY_LOADING) {
            this.d.setText("支付中");
        } else if (result == IYYPayResultView.Result.PAY_SUUCESS) {
            CurrencyChargeMessage currencyChargeMessage = bVar.b;
            String str3 = null;
            if (currencyChargeMessage != null && currencyChargeMessage.currencyAmount > 0) {
                str3 = new DecimalFormat("#.##").format(currencyChargeMessage.currencyAmount / 100.0d);
            }
            String str4 = "";
            if (str3 != null) {
                str2 = "成功充值" + str3 + (currencyChargeMessage.currencyType == 4 ? "Y币" : "");
            } else {
                str2 = "充值成功";
            }
            this.d.setText(str2);
            if (z3a.d() != null && z3a.d().successMsg != null) {
                str4 = z3a.d().successMsg;
            }
            this.f.setText(str4);
            this.e.setImageResource(R.drawable.obfuscated_res_0x7f080ed4);
            e4a.b(this.b, this.c, PayUIEventType.successpageshow);
            RLog.info("YYPayResultView", PayUIEventType.successpageshow);
        } else if (result == IYYPayResultView.Result.PAY_FAIL) {
            CurrencyChargeMessage currencyChargeMessage2 = bVar.b;
            if (currencyChargeMessage2 == null) {
                String str5 = bVar.d;
                str = (str5 != null ? str5 : "充值失败") + "(" + bVar.c + SmallTailInfo.EMOTION_SUFFIX;
            } else {
                String str6 = currencyChargeMessage2.message;
                str = (str6 != null ? str6 : "充值失败") + "(" + bVar.b.status + SmallTailInfo.EMOTION_SUFFIX;
            }
            this.d.setText(str);
            this.f.setText((z3a.d() == null || z3a.d().customerServiceMsg == null || z3a.d().customerServiceMsg.isEmpty()) ? "如有问题可以联系客服 " : z3a.d().customerServiceMsg);
            this.e.setImageResource(R.drawable.obfuscated_res_0x7f080ed1);
            RLog.info("YYPayResultView", PayUIEventType.failpageshow);
            e4a.b(this.b, this.c, PayUIEventType.failpageshow);
        }
    }

    @Override // com.baidu.tieba.y4a
    public void refreshView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
        }
    }

    @Override // com.baidu.tieba.y4a
    public void refreshWindow(WindowParams windowParams) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, windowParams) == null) {
            RLog.debug("YYPayResultView", "refreshWindow params:" + windowParams + " mWindow:" + this.o);
            if (this.o == null || windowParams == null) {
                return;
            }
            IYYPayResultView.c cVar = this.n;
            if (cVar != null) {
                cVar.c = windowParams;
            }
            WindowManager.LayoutParams attributes = this.o.getAttributes();
            attributes.dimAmount = windowParams.dimAmount;
            try {
                this.o.setAttributes(attributes);
            } catch (Exception e2) {
                RLog.error("YYPayResultView", "refreshWindow e:" + e2, new Object[0]);
            }
        }
    }

    @Override // tv.athena.revenue.payui.view.IYYPayResultView
    public void setCallback(IYYPayResultView.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, aVar) == null) {
            RLog.info("YYPayResultView", "setCallback");
            this.h = aVar;
            j();
        }
    }
}
