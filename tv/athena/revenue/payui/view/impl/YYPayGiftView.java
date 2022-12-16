package tv.athena.revenue.payui.view.impl;

import android.content.Context;
import android.text.TextUtils;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.tieba.aba;
import com.baidu.tieba.bca;
import com.baidu.tieba.eca;
import com.baidu.tieba.nba;
import com.baidu.tieba.vba;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.mobile.framework.revenuesdk.baseapi.log.RLog;
import com.yy.mobile.framework.revenuesdk.payapi.bean.GiftBagItemInfo;
import com.yy.mobile.framework.revenuesdk.payapi.bean.GiftBagsInfo;
import java.util.ArrayList;
import java.util.List;
import tv.athena.revenue.payui.model.PayUIKitConfig;
import tv.athena.revenue.payui.view.WindowParams;
/* loaded from: classes9.dex */
public class YYPayGiftView extends LinearLayout implements bca {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public int b;
    public Button c;
    public GridView d;
    public View e;
    public TextView f;
    public bca.a g;
    public GiftBagsInfo h;
    public PayUIKitConfig i;
    public List<GiftBagItemInfo> j;
    public eca k;

    @Override // com.baidu.tieba.yba
    public void attachWindow(Window window) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, window) == null) {
        }
    }

    @Override // com.baidu.tieba.yba
    public View getContentView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this : (View) invokeV.objValue;
    }

    @Override // com.baidu.tieba.yba
    public void refreshWindow(WindowParams windowParams) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, windowParams) == null) {
        }
    }

    /* loaded from: classes9.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ YYPayGiftView a;

        public a(YYPayGiftView yYPayGiftView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yYPayGiftView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = yYPayGiftView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a.g != null) {
                this.a.g.a();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public YYPayGiftView(Context context, int i, int i2, PayUIKitConfig payUIKitConfig) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Integer.valueOf(i), Integer.valueOf(i2), payUIKitConfig};
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
        this.j = new ArrayList();
        this.a = i;
        this.b = i2;
        this.i = payUIKitConfig;
        c(context);
        aba.d(this.a, this.b, "17", "", "", "");
    }

    @Override // com.baidu.tieba.bca
    public void setCallback(bca.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, aVar) == null) {
            this.g = aVar;
        }
    }

    @Override // com.baidu.tieba.bca
    public void setGiftBagsInfo(GiftBagsInfo giftBagsInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, giftBagsInfo) == null) {
            RLog.info("YYPayGiftView", "setGiftBagsInfo giftBagsInfo:" + giftBagsInfo);
            this.h = giftBagsInfo;
        }
    }

    public final void c(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context) == null) {
            LayoutInflater.from(new ContextThemeWrapper(context, vba.a.a(this.i))).inflate(R.layout.pay_ui_layout_pay_success_gift_view, (ViewGroup) this, true);
            Button button = (Button) findViewById(R.id.btn_know);
            this.c = button;
            button.setOnClickListener(new a(this));
            this.f = (TextView) findViewById(R.id.tv_title);
            this.e = findViewById(R.id.rl_container);
            this.d = (GridView) findViewById(R.id.grid_pay_gift);
            eca ecaVar = new eca(context, this.j, this.i);
            this.k = ecaVar;
            this.d.setAdapter((ListAdapter) ecaVar);
        }
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && !TextUtils.isEmpty(this.h.successButtonMsg)) {
            this.c.setText(this.h.successButtonMsg);
        }
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && !TextUtils.isEmpty(this.h.successTitle)) {
            this.f.setText(this.h.successTitle);
        }
    }

    @Override // com.baidu.tieba.yba
    public void refreshView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            RLog.info("YYPayGiftView", "refreshView mGiftBagsInfo:" + this.h);
            GiftBagsInfo giftBagsInfo = this.h;
            if (giftBagsInfo == null) {
                RLog.error("YYPayGiftView", "refreshView error mGiftBagsInfo null", new Object[0]);
                return;
            }
            List<GiftBagItemInfo> list = giftBagsInfo.giftbag;
            if (list != null && !list.isEmpty()) {
                this.j.clear();
                this.j.addAll(this.h.giftbag);
                this.k.notifyDataSetChanged();
                nba.a(this.j.size(), this.e, this.d);
                f();
                e();
                return;
            }
            RLog.error("YYPayGiftView", "refreshView error giftbag empty", new Object[0]);
        }
    }
}
