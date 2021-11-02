package tv.athena.revenue.payui.view;

import android.content.Context;
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
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.mobile.framework.revenuesdk.baseapi.log.RLog;
import com.yy.mobile.framework.revenuesdk.payapi.bean.GiftBagItemInfo;
import com.yy.mobile.framework.revenuesdk.payapi.bean.GiftBagsInfo;
import i.a.a.e.c;
import i.a.a.e.e;
import i.a.a.e.n.i;
import i.a.a.e.n.l;
import i.a.a.e.o.d;
import i.a.a.e.o.e.b;
import java.util.ArrayList;
import java.util.List;
import tv.athena.revenue.payui.model.PayUIKitConfig;
import tv.athena.revenue.payui.widget.NoScrollGridView;
/* loaded from: classes3.dex */
public class YYPayGiftView extends LinearLayout implements d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public int f73159e;

    /* renamed from: f  reason: collision with root package name */
    public int f73160f;

    /* renamed from: g  reason: collision with root package name */
    public Button f73161g;

    /* renamed from: h  reason: collision with root package name */
    public NoScrollGridView f73162h;

    /* renamed from: i  reason: collision with root package name */
    public View f73163i;
    public TextView j;
    public ImageView k;
    public d.a l;
    public GiftBagsInfo m;
    public List<GiftBagItemInfo> mGiftBagList;
    public PayUIKitConfig n;
    public b o;

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ YYPayGiftView f73164e;

        public a(YYPayGiftView yYPayGiftView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yYPayGiftView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f73164e = yYPayGiftView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f73164e.l == null) {
                return;
            }
            this.f73164e.l.a();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public YYPayGiftView(Context context, int i2, int i3, PayUIKitConfig payUIKitConfig) {
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
        this.f73159e = i2;
        this.f73160f = i3;
        this.n = payUIKitConfig;
        b(context);
        i.a.a.e.m.b.d(this.f73159e, this.f73160f, "17", "", "", "");
    }

    public final void b(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, context) == null) {
            LayoutInflater.from(new ContextThemeWrapper(context, l.f72366a.a(this.n))).inflate(e.pay_ui_layout_pay_success_gift_view, (ViewGroup) this, true);
            Button button = (Button) findViewById(i.a.a.e.d.btn_know);
            this.f73161g = button;
            button.setOnClickListener(new a(this));
            this.j = (TextView) findViewById(i.a.a.e.d.tv_title);
            this.f73163i = findViewById(i.a.a.e.d.rl_container);
            this.f73162h = (NoScrollGridView) findViewById(i.a.a.e.d.grid_pay_gift);
            b bVar = new b(context, this.mGiftBagList, this.n);
            this.o = bVar;
            this.f73162h.setAdapter((ListAdapter) bVar);
            this.k = (ImageView) findViewById(i.a.a.e.d.img_logo);
            this.k.setBackgroundResource(l.f72366a.b(this.n) ? c.pay_ui_campaign_pay_success_logo_red : c.pay_ui_campaign_pay_success_logo_yellow);
        }
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || TextUtils.isEmpty(this.m.successButtonMsg)) {
            return;
        }
        this.f73161g.setText(this.m.successButtonMsg);
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || TextUtils.isEmpty(this.m.successTitle)) {
            return;
        }
        this.j.setText(this.m.successTitle);
    }

    @Override // i.a.a.e.o.a
    public View getContentView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this : (View) invokeV.objValue;
    }

    @Override // i.a.a.e.o.a
    public void refreshView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            RLog.info("YYPayGiftView", "refreshView mGiftBagsInfo:" + this.m);
            GiftBagsInfo giftBagsInfo = this.m;
            if (giftBagsInfo == null) {
                RLog.error("YYPayGiftView", "refreshView error mGiftBagsInfo null", new Object[0]);
                return;
            }
            List<GiftBagItemInfo> list = giftBagsInfo.giftbag;
            if (list != null && !list.isEmpty()) {
                this.mGiftBagList.clear();
                this.mGiftBagList.addAll(this.m.giftbag);
                this.o.notifyDataSetChanged();
                i.a(this.mGiftBagList.size(), this.f73163i, this.f73162h);
                d();
                c();
                return;
            }
            RLog.error("YYPayGiftView", "refreshView error giftbag empty", new Object[0]);
        }
    }

    @Override // i.a.a.e.o.d
    public void setCallback(d.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, aVar) == null) {
            this.l = aVar;
        }
    }

    @Override // i.a.a.e.o.d
    public void setGiftBagsInfo(GiftBagsInfo giftBagsInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, giftBagsInfo) == null) {
            RLog.info("YYPayGiftView", "setGiftBagsInfo giftBagsInfo:" + giftBagsInfo);
            this.m = giftBagsInfo;
        }
    }
}
