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
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.iz9;
import com.repackage.nz9;
import com.repackage.sz9;
import com.repackage.uz9;
import com.repackage.yy9;
import com.yy.mobile.framework.revenuesdk.baseapi.log.RLog;
import com.yy.mobile.framework.revenuesdk.payapi.bean.GiftBagItemInfo;
import com.yy.mobile.framework.revenuesdk.payapi.bean.GiftBagsInfo;
import java.util.ArrayList;
import java.util.List;
import tv.athena.revenue.payui.model.PayUIKitConfig;
/* loaded from: classes9.dex */
public class YYPayConfirmView extends LinearLayout implements sz9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public int b;
    public sz9.a c;
    public GridView d;
    public TextView e;
    public View f;
    public Button g;
    public TextView h;
    public PayUIKitConfig i;
    public uz9 j;
    public GiftBagsInfo k;
    public List<GiftBagItemInfo> l;

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
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.d();
            }
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
        yy9.d(this.a, this.b, "15", "", "", "");
    }

    public final boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            PayUIKitConfig payUIKitConfig = this.i;
            return (payUIKitConfig == null || payUIKitConfig.imageLoaderSupplier == null) ? false : true;
        }
        return invokeV.booleanValue;
    }

    public final void c(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context) == null) {
            LayoutInflater.from(new ContextThemeWrapper(context, nz9.a.a(this.i))).inflate(R.layout.obfuscated_res_0x7f0d0671, (ViewGroup) this, true);
            Button button = (Button) findViewById(R.id.obfuscated_res_0x7f09040c);
            this.g = button;
            button.setOnClickListener(new a(this));
            GridView gridView = (GridView) findViewById(R.id.obfuscated_res_0x7f090c96);
            this.d = gridView;
            gridView.setSelector(new ColorDrawable(0));
            uz9 uz9Var = new uz9(context, this.l, this.i);
            this.j = uz9Var;
            this.d.setAdapter((ListAdapter) uz9Var);
            this.d.setVisibility(b() ? 0 : 8);
            this.e = (TextView) findViewById(R.id.obfuscated_res_0x7f092222);
            this.f = findViewById(R.id.obfuscated_res_0x7f091b25);
            this.h = (TextView) findViewById(R.id.obfuscated_res_0x7f0922a3);
        }
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            RLog.info("YYPayConfirmView", "onContinueBtnClick");
            sz9.a aVar = this.c;
            if (aVar != null) {
                aVar.a();
            }
            yy9.d(this.a, this.b, "16", "", "", "");
        }
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || TextUtils.isEmpty(this.k.giveupButtonMsg)) {
            return;
        }
        this.g.setText(this.k.giveupButtonMsg);
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
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
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            if (TextUtils.isEmpty(this.k.giveupTitle)) {
                this.h.setVisibility(4);
                return;
            }
            this.h.setVisibility(0);
            this.h.setText(this.k.giveupTitle);
        }
    }

    @Override // com.repackage.qz9
    public View getContentView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this : (View) invokeV.objValue;
    }

    @Override // com.repackage.qz9
    public void refreshView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
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
                iz9.a(this.l.size(), this.f, this.d);
                g();
                f();
                e();
                return;
            }
            RLog.error("YYPayConfirmView", "refreshView error giftbag empty", new Object[0]);
        }
    }

    @Override // com.repackage.sz9
    public void setCallback(sz9.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, aVar) == null) {
            this.c = aVar;
        }
    }

    @Override // com.repackage.sz9
    public void setGiftBagsInfo(GiftBagsInfo giftBagsInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, giftBagsInfo) == null) {
            RLog.info("YYPayConfirmView", "setGiftBagsInfo giftBagsInfo:" + giftBagsInfo);
            this.k = giftBagsInfo;
        }
    }
}
