package tv.athena.revenue.payui.view.impl;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
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
import com.baidu.tieba.g7a;
import com.baidu.tieba.l7a;
import com.baidu.tieba.q7a;
import com.baidu.tieba.s7a;
import com.baidu.tieba.u6a;
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
public class YYPayConfirmView extends LinearLayout implements q7a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public int b;
    public q7a.a c;
    public GridView d;
    public TextView e;
    public View f;
    public Button g;
    public TextView h;
    public PayUIKitConfig i;
    public s7a j;
    public GiftBagsInfo k;
    public List<GiftBagItemInfo> l;

    @Override // com.baidu.tieba.o7a
    public void attachWindow(Window window) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, window) == null) {
        }
    }

    @Override // com.baidu.tieba.o7a
    public View getContentView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this : (View) invokeV.objValue;
    }

    @Override // com.baidu.tieba.o7a
    public void refreshWindow(WindowParams windowParams) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, windowParams) == null) {
        }
    }

    /* loaded from: classes9.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ YYPayConfirmView a;

        public a(YYPayConfirmView yYPayConfirmView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yYPayConfirmView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = yYPayConfirmView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, view2) != null) {
                return;
            }
            this.a.d();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public YYPayConfirmView(Context context, int i, int i2, PayUIKitConfig payUIKitConfig) {
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
        this.l = new ArrayList();
        this.a = i;
        this.b = i2;
        this.i = payUIKitConfig;
        c(context);
        u6a.d(this.a, this.b, "15", "", "", "");
    }

    @Override // com.baidu.tieba.q7a
    public void setCallback(q7a.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, aVar) == null) {
            this.c = aVar;
        }
    }

    @Override // com.baidu.tieba.q7a
    public void setGiftBagsInfo(GiftBagsInfo giftBagsInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, giftBagsInfo) == null) {
            RLog.info("YYPayConfirmView", "setGiftBagsInfo giftBagsInfo:" + giftBagsInfo);
            this.k = giftBagsInfo;
        }
    }

    public final boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            PayUIKitConfig payUIKitConfig = this.i;
            if (payUIKitConfig != null && payUIKitConfig.imageLoaderSupplier != null) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            RLog.info("YYPayConfirmView", "onContinueBtnClick");
            q7a.a aVar = this.c;
            if (aVar != null) {
                aVar.a();
            }
            u6a.d(this.a, this.b, "16", "", "", "");
        }
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && !TextUtils.isEmpty(this.k.giveupButtonMsg)) {
            this.g.setText(this.k.giveupButtonMsg);
        }
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            if (TextUtils.isEmpty(this.k.giveupSubtitle)) {
                this.e.setVisibility(4);
                return;
            }
            this.e.setVisibility(0);
            this.e.setText(this.k.giveupSubtitle);
        }
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            if (TextUtils.isEmpty(this.k.giveupTitle)) {
                this.h.setVisibility(4);
                return;
            }
            this.h.setVisibility(0);
            this.h.setText(this.k.giveupTitle);
        }
    }

    public final void c(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, context) == null) {
            LayoutInflater.from(new ContextThemeWrapper(context, l7a.a.a(this.i))).inflate(R.layout.obfuscated_res_0x7f0d06c2, (ViewGroup) this, true);
            Button button = (Button) findViewById(R.id.obfuscated_res_0x7f090448);
            this.g = button;
            button.setOnClickListener(new a(this));
            GridView gridView = (GridView) findViewById(R.id.obfuscated_res_0x7f090d20);
            this.d = gridView;
            int i = 0;
            gridView.setSelector(new ColorDrawable(0));
            s7a s7aVar = new s7a(context, this.l, this.i);
            this.j = s7aVar;
            this.d.setAdapter((ListAdapter) s7aVar);
            GridView gridView2 = this.d;
            if (!b()) {
                i = 8;
            }
            gridView2.setVisibility(i);
            this.e = (TextView) findViewById(R.id.obfuscated_res_0x7f0923c9);
            this.f = findViewById(R.id.obfuscated_res_0x7f091c99);
            this.h = (TextView) findViewById(R.id.obfuscated_res_0x7f09245a);
        }
    }

    @Override // com.baidu.tieba.o7a
    public void refreshView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            RLog.info("YYPayConfirmView", "refreshView mGiftBagsInfo:" + this.k);
            if (!b()) {
                RLog.error("YYPayConfirmView", "refreshView error imageLoaderSupplierValid false", new Object[0]);
                return;
            }
            GiftBagsInfo giftBagsInfo = this.k;
            if (giftBagsInfo == null) {
                RLog.error("YYPayConfirmView", "refreshView error mGiftBagsInfo null", new Object[0]);
                return;
            }
            List<GiftBagItemInfo> list = giftBagsInfo.giftbag;
            if (list != null && !list.isEmpty()) {
                this.l.clear();
                this.l.addAll(this.k.giftbag);
                this.j.notifyDataSetChanged();
                g7a.a(this.l.size(), this.f, this.d);
                g();
                f();
                e();
                return;
            }
            RLog.error("YYPayConfirmView", "refreshView error giftbag empty", new Object[0]);
        }
    }
}
