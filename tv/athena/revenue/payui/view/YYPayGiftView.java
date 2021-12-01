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
import j.a.a.e.c;
import j.a.a.e.e;
import j.a.a.e.n.i;
import j.a.a.e.n.l;
import j.a.a.e.o.d;
import j.a.a.e.o.e.b;
import java.util.ArrayList;
import java.util.List;
import tv.athena.revenue.payui.model.PayUIKitConfig;
import tv.athena.revenue.payui.widget.NoScrollGridView;
/* loaded from: classes4.dex */
public class YYPayGiftView extends LinearLayout implements d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public int f64843e;

    /* renamed from: f  reason: collision with root package name */
    public int f64844f;

    /* renamed from: g  reason: collision with root package name */
    public Button f64845g;

    /* renamed from: h  reason: collision with root package name */
    public NoScrollGridView f64846h;

    /* renamed from: i  reason: collision with root package name */
    public View f64847i;

    /* renamed from: j  reason: collision with root package name */
    public TextView f64848j;

    /* renamed from: k  reason: collision with root package name */
    public ImageView f64849k;
    public d.a l;
    public GiftBagsInfo m;
    public List<GiftBagItemInfo> mGiftBagList;
    public PayUIKitConfig n;
    public b o;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ YYPayGiftView f64850e;

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
            this.f64850e = yYPayGiftView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f64850e.l == null) {
                return;
            }
            this.f64850e.l.a();
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
        this.f64843e = i2;
        this.f64844f = i3;
        this.n = payUIKitConfig;
        b(context);
        j.a.a.e.m.b.d(this.f64843e, this.f64844f, "17", "", "", "");
    }

    public final void b(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, context) == null) {
            LayoutInflater.from(new ContextThemeWrapper(context, l.a.a(this.n))).inflate(e.pay_ui_layout_pay_success_gift_view, (ViewGroup) this, true);
            Button button = (Button) findViewById(j.a.a.e.d.btn_know);
            this.f64845g = button;
            button.setOnClickListener(new a(this));
            this.f64848j = (TextView) findViewById(j.a.a.e.d.tv_title);
            this.f64847i = findViewById(j.a.a.e.d.rl_container);
            this.f64846h = (NoScrollGridView) findViewById(j.a.a.e.d.grid_pay_gift);
            b bVar = new b(context, this.mGiftBagList, this.n);
            this.o = bVar;
            this.f64846h.setAdapter((ListAdapter) bVar);
            this.f64849k = (ImageView) findViewById(j.a.a.e.d.img_logo);
            this.f64849k.setBackgroundResource(l.a.b(this.n) ? c.pay_ui_campaign_pay_success_logo_red : c.pay_ui_campaign_pay_success_logo_yellow);
        }
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || TextUtils.isEmpty(this.m.successButtonMsg)) {
            return;
        }
        this.f64845g.setText(this.m.successButtonMsg);
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || TextUtils.isEmpty(this.m.successTitle)) {
            return;
        }
        this.f64848j.setText(this.m.successTitle);
    }

    @Override // j.a.a.e.o.a
    public View getContentView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this : (View) invokeV.objValue;
    }

    @Override // j.a.a.e.o.a
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
                i.a(this.mGiftBagList.size(), this.f64847i, this.f64846h);
                d();
                c();
                return;
            }
            RLog.error("YYPayGiftView", "refreshView error giftbag empty", new Object[0]);
        }
    }

    @Override // j.a.a.e.o.d
    public void setCallback(d.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, aVar) == null) {
            this.l = aVar;
        }
    }

    @Override // j.a.a.e.o.d
    public void setGiftBagsInfo(GiftBagsInfo giftBagsInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, giftBagsInfo) == null) {
            RLog.info("YYPayGiftView", "setGiftBagsInfo giftBagsInfo:" + giftBagsInfo);
            this.m = giftBagsInfo;
        }
    }
}
