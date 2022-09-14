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
import com.baidu.tieba.b5a;
import com.baidu.tieba.c5a;
import com.baidu.tieba.e4a;
import com.baidu.tieba.q4a;
import com.baidu.tieba.v4a;
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
public class YYPayGiftView extends LinearLayout implements b5a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public int b;
    public Button c;
    public GridView d;
    public View e;
    public TextView f;
    public b5a.a g;
    public GiftBagsInfo h;
    public PayUIKitConfig i;
    public List<GiftBagItemInfo> j;
    public c5a k;

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
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || this.a.g == null) {
                return;
            }
            this.a.g.a();
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
        b(context);
        e4a.d(this.a, this.b, "17", "", "", "");
    }

    @Override // com.baidu.tieba.y4a
    public void attachWindow(Window window) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, window) == null) {
        }
    }

    public final void b(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context) == null) {
            LayoutInflater.from(new ContextThemeWrapper(context, v4a.a.a(this.i))).inflate(R.layout.obfuscated_res_0x7f0d06af, (ViewGroup) this, true);
            Button button = (Button) findViewById(R.id.obfuscated_res_0x7f09043c);
            this.c = button;
            button.setOnClickListener(new a(this));
            this.f = (TextView) findViewById(R.id.obfuscated_res_0x7f092417);
            this.e = findViewById(R.id.obfuscated_res_0x7f091c52);
            this.d = (GridView) findViewById(R.id.obfuscated_res_0x7f090cf5);
            c5a c5aVar = new c5a(context, this.j, this.i);
            this.k = c5aVar;
            this.d.setAdapter((ListAdapter) c5aVar);
        }
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || TextUtils.isEmpty(this.h.successButtonMsg)) {
            return;
        }
        this.c.setText(this.h.successButtonMsg);
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || TextUtils.isEmpty(this.h.successTitle)) {
            return;
        }
        this.f.setText(this.h.successTitle);
    }

    @Override // com.baidu.tieba.y4a
    public View getContentView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this : (View) invokeV.objValue;
    }

    @Override // com.baidu.tieba.y4a
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
                q4a.a(this.j.size(), this.e, this.d);
                d();
                c();
                return;
            }
            RLog.error("YYPayGiftView", "refreshView error giftbag empty", new Object[0]);
        }
    }

    @Override // com.baidu.tieba.y4a
    public void refreshWindow(WindowParams windowParams) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, windowParams) == null) {
        }
    }

    @Override // com.baidu.tieba.b5a
    public void setCallback(b5a.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, aVar) == null) {
            this.g = aVar;
        }
    }

    @Override // com.baidu.tieba.b5a
    public void setGiftBagsInfo(GiftBagsInfo giftBagsInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, giftBagsInfo) == null) {
            RLog.info("YYPayGiftView", "setGiftBagsInfo giftBagsInfo:" + giftBagsInfo);
            this.h = giftBagsInfo;
        }
    }
}
