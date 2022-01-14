package tv.athena.revenue.payui.view;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.text.TextUtils;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.GridView;
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
import j.a.a.e.f;
import j.a.a.e.g;
import j.a.a.e.o.b;
import j.a.a.e.p.j;
import j.a.a.e.p.o;
import j.a.a.e.q.c;
import java.util.ArrayList;
import java.util.List;
import tv.athena.revenue.payui.model.PayUIKitConfig;
/* loaded from: classes5.dex */
public class YYPayConfirmView extends LinearLayout implements c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public int f62961e;

    /* renamed from: f  reason: collision with root package name */
    public int f62962f;

    /* renamed from: g  reason: collision with root package name */
    public c.a f62963g;

    /* renamed from: h  reason: collision with root package name */
    public GridView f62964h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f62965i;

    /* renamed from: j  reason: collision with root package name */
    public View f62966j;
    public Button k;
    public TextView l;
    public PayUIKitConfig m;
    public List<GiftBagItemInfo> mGiftBagList;
    public j.a.a.e.q.e.a n;
    public GiftBagsInfo o;

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ YYPayConfirmView f62967e;

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
            this.f62967e = yYPayConfirmView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f62967e.d();
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
        this.f62961e = i2;
        this.f62962f = i3;
        this.m = payUIKitConfig;
        c(context);
        b.d(this.f62961e, this.f62962f, "15", "", "", "");
    }

    public final boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            PayUIKitConfig payUIKitConfig = this.m;
            return (payUIKitConfig == null || payUIKitConfig.imageLoaderSupplier == null) ? false : true;
        }
        return invokeV.booleanValue;
    }

    public final void c(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context) == null) {
            LayoutInflater.from(new ContextThemeWrapper(context, o.a.a(this.m))).inflate(g.pay_ui_layout_pay_confirm_giveup_view, (ViewGroup) this, true);
            Button button = (Button) findViewById(f.btn_continue);
            this.k = button;
            button.setOnClickListener(new a(this));
            GridView gridView = (GridView) findViewById(f.grid_pay_gift);
            this.f62964h = gridView;
            gridView.setSelector(new ColorDrawable(0));
            j.a.a.e.q.e.a aVar = new j.a.a.e.q.e.a(context, this.mGiftBagList, this.m);
            this.n = aVar;
            this.f62964h.setAdapter((ListAdapter) aVar);
            this.f62964h.setVisibility(b() ? 0 : 8);
            this.f62965i = (TextView) findViewById(f.tv_desc);
            this.f62966j = findViewById(f.rl_container);
            this.l = (TextView) findViewById(f.tv_title);
        }
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            RLog.info("YYPayConfirmView", "onContinueBtnClick");
            c.a aVar = this.f62963g;
            if (aVar != null) {
                aVar.a();
            }
            b.d(this.f62961e, this.f62962f, "16", "", "", "");
        }
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || TextUtils.isEmpty(this.o.giveupButtonMsg)) {
            return;
        }
        this.k.setText(this.o.giveupButtonMsg);
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            if (TextUtils.isEmpty(this.o.giveupSubtitle)) {
                this.f62965i.setVisibility(4);
                return;
            }
            this.f62965i.setVisibility(0);
            this.f62965i.setText(this.o.giveupSubtitle);
        }
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            if (TextUtils.isEmpty(this.o.giveupTitle)) {
                this.l.setVisibility(4);
                return;
            }
            this.l.setVisibility(0);
            this.l.setText(this.o.giveupTitle);
        }
    }

    @Override // j.a.a.e.q.a
    public View getContentView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this : (View) invokeV.objValue;
    }

    @Override // j.a.a.e.q.a
    public void refreshView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            RLog.info("YYPayConfirmView", "refreshView mGiftBagsInfo:" + this.o);
            if (!b()) {
                RLog.error("YYPayConfirmView", "refreshView error imageLoaderSupplierValid false", new Object[0]);
                return;
            }
            GiftBagsInfo giftBagsInfo = this.o;
            if (giftBagsInfo == null) {
                RLog.error("YYPayConfirmView", "refreshView error mGiftBagsInfo null", new Object[0]);
                return;
            }
            List<GiftBagItemInfo> list = giftBagsInfo.giftbag;
            if (list != null && !list.isEmpty()) {
                this.mGiftBagList.clear();
                this.mGiftBagList.addAll(this.o.giftbag);
                this.n.notifyDataSetChanged();
                j.a(this.mGiftBagList.size(), this.f62966j, this.f62964h);
                g();
                f();
                e();
                return;
            }
            RLog.error("YYPayConfirmView", "refreshView error giftbag empty", new Object[0]);
        }
    }

    @Override // j.a.a.e.q.c
    public void setCallback(c.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, aVar) == null) {
            this.f62963g = aVar;
        }
    }

    @Override // j.a.a.e.q.c
    public void setGiftBagsInfo(GiftBagsInfo giftBagsInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, giftBagsInfo) == null) {
            RLog.info("YYPayConfirmView", "setGiftBagsInfo giftBagsInfo:" + giftBagsInfo);
            this.o = giftBagsInfo;
        }
    }
}
