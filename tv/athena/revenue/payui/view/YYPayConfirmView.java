package tv.athena.revenue.payui.view;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.text.TextUtils;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.mobile.framework.revenuesdk.baseapi.log.RLog;
import com.yy.mobile.framework.revenuesdk.payapi.bean.GiftBagItemInfo;
import com.yy.mobile.framework.revenuesdk.payapi.bean.GiftBagsInfo;
import i.a.a.e.d;
import i.a.a.e.e;
import i.a.a.e.n.i;
import i.a.a.e.n.l;
import i.a.a.e.o.c;
import i.a.a.e.o.e.b;
import java.util.ArrayList;
import java.util.List;
import tv.athena.revenue.payui.model.PayUIKitConfig;
import tv.athena.revenue.payui.widget.NoScrollGridView;
/* loaded from: classes3.dex */
public class YYPayConfirmView extends LinearLayout implements c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public int f73153e;

    /* renamed from: f  reason: collision with root package name */
    public int f73154f;

    /* renamed from: g  reason: collision with root package name */
    public c.a f73155g;

    /* renamed from: h  reason: collision with root package name */
    public NoScrollGridView f73156h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f73157i;
    public View j;
    public Button k;
    public ImageView l;
    public TextView m;
    public List<GiftBagItemInfo> mGiftBagList;
    public PayUIKitConfig n;
    public b o;
    public GiftBagsInfo p;

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ YYPayConfirmView f73158e;

        public a(YYPayConfirmView yYPayConfirmView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yYPayConfirmView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f73158e = yYPayConfirmView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f73158e.d();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public YYPayConfirmView(Context context, int i2, int i3, PayUIKitConfig payUIKitConfig) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Integer.valueOf(i2), Integer.valueOf(i3), payUIKitConfig};
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
        this.mGiftBagList = new ArrayList();
        this.f73153e = i2;
        this.f73154f = i3;
        this.n = payUIKitConfig;
        c(context);
        i.a.a.e.m.b.d(this.f73153e, this.f73154f, "15", "", "", "");
    }

    public final boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            PayUIKitConfig payUIKitConfig = this.n;
            return (payUIKitConfig == null || payUIKitConfig.imageLoaderSupplier == null) ? false : true;
        }
        return invokeV.booleanValue;
    }

    public final void c(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context) == null) {
            LayoutInflater.from(new ContextThemeWrapper(context, l.f72366a.a(this.n))).inflate(e.pay_ui_layout_pay_confirm_giveup_view, (ViewGroup) this, true);
            Button button = (Button) findViewById(d.btn_continue);
            this.k = button;
            button.setOnClickListener(new a(this));
            NoScrollGridView noScrollGridView = (NoScrollGridView) findViewById(d.grid_pay_gift);
            this.f73156h = noScrollGridView;
            noScrollGridView.setSelector(new ColorDrawable(0));
            b bVar = new b(context, this.mGiftBagList, this.n);
            this.o = bVar;
            this.f73156h.setAdapter((ListAdapter) bVar);
            this.f73156h.setVisibility(b() ? 0 : 8);
            this.f73157i = (TextView) findViewById(d.tv_desc);
            this.j = findViewById(d.rl_container);
            this.m = (TextView) findViewById(d.tv_title);
            this.l = (ImageView) findViewById(d.img_logo);
            this.l.setBackgroundResource(l.f72366a.b(this.n) ? i.a.a.e.c.pay_ui_campaign_confirm_giveup_pay_log_red : i.a.a.e.c.pay_ui_campaign_confirm_giveup_pay_log_yellow);
        }
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            RLog.info("YYPayConfirmView", "onContinueBtnClick");
            c.a aVar = this.f73155g;
            if (aVar != null) {
                aVar.a();
            }
            i.a.a.e.m.b.d(this.f73153e, this.f73154f, "16", "", "", "");
        }
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || TextUtils.isEmpty(this.p.giveupButtonMsg)) {
            return;
        }
        this.k.setText(this.p.giveupButtonMsg);
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            if (TextUtils.isEmpty(this.p.giveupSubtitle)) {
                this.f73157i.setVisibility(4);
                return;
            }
            this.f73157i.setVisibility(0);
            this.f73157i.setText(this.p.giveupSubtitle);
        }
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            if (TextUtils.isEmpty(this.p.giveupTitle)) {
                this.m.setVisibility(4);
                return;
            }
            this.m.setVisibility(0);
            this.m.setText(this.p.giveupTitle);
        }
    }

    @Override // i.a.a.e.o.a
    public View getContentView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this : (View) invokeV.objValue;
    }

    @Override // i.a.a.e.o.a
    public void refreshView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            RLog.info("YYPayConfirmView", "refreshView mGiftBagsInfo:" + this.p);
            if (!b()) {
                RLog.error("YYPayConfirmView", "refreshView error imageLoaderSupplierValid false", new Object[0]);
                return;
            }
            GiftBagsInfo giftBagsInfo = this.p;
            if (giftBagsInfo == null) {
                RLog.error("YYPayConfirmView", "refreshView error mGiftBagsInfo null", new Object[0]);
                return;
            }
            List<GiftBagItemInfo> list = giftBagsInfo.giftbag;
            if (list != null && !list.isEmpty()) {
                this.mGiftBagList.clear();
                this.mGiftBagList.addAll(this.p.giftbag);
                this.o.notifyDataSetChanged();
                i.a(this.mGiftBagList.size(), this.j, this.f73156h);
                g();
                f();
                e();
                return;
            }
            RLog.error("YYPayConfirmView", "refreshView error giftbag empty", new Object[0]);
        }
    }

    @Override // i.a.a.e.o.c
    public void setCallback(c.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, aVar) == null) {
            this.f73155g = aVar;
        }
    }

    @Override // i.a.a.e.o.c
    public void setGiftBagsInfo(GiftBagsInfo giftBagsInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, giftBagsInfo) == null) {
            RLog.info("YYPayConfirmView", "setGiftBagsInfo giftBagsInfo:" + giftBagsInfo);
            this.p = giftBagsInfo;
        }
    }
}
