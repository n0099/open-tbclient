package tv.athena.revenue.payui.view.impl;

import android.app.Activity;
import android.content.Context;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.tieba.aba;
import com.baidu.tieba.cca;
import com.baidu.tieba.qba;
import com.baidu.tieba.uaa;
import com.baidu.tieba.vba;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.mobile.framework.revenuesdk.baseapi.log.RLog;
import com.yy.mobile.framework.revenuesdk.statistics.hiido.eventtype.PayUVEventType;
import java.text.DecimalFormat;
import tv.athena.revenue.api.MiddleRevenueConfig;
import tv.athena.revenue.payui.model.PayUIKitConfig;
import tv.athena.revenue.payui.view.WindowParams;
/* loaded from: classes9.dex */
public class YYPaySignView extends LinearLayout implements cca {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Activity a;
    public cca.b b;
    public cca.a c;
    public PayUIKitConfig d;
    public TextView e;
    public int f;
    public int g;
    public long h;

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
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this : (View) invokeV.objValue;
    }

    @Override // com.baidu.tieba.yba
    public void refreshView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
        }
    }

    @Override // com.baidu.tieba.yba
    public void refreshWindow(WindowParams windowParams) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, windowParams) == null) {
        }
    }

    /* loaded from: classes9.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CheckBox a;
        public final /* synthetic */ YYPaySignView b;

        public a(YYPaySignView yYPaySignView, CheckBox checkBox) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yYPaySignView, checkBox};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = yYPaySignView;
            this.a = checkBox;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                CheckBox checkBox = this.a;
                checkBox.setChecked(!checkBox.isChecked());
            }
        }
    }

    /* loaded from: classes9.dex */
    public class b implements CompoundButton.OnCheckedChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ YYPaySignView a;

        public b(YYPaySignView yYPaySignView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yYPaySignView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = yYPaySignView;
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLZ(1048576, this, compoundButton, z) == null) {
                aba.d(this.a.f, this.a.g, PayUVEventType.PAY_SIGN_DIALOG_DONT_REMIND_CLICK, "", "", "");
            }
        }
    }

    /* loaded from: classes9.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CheckBox a;
        public final /* synthetic */ YYPaySignView b;

        public c(YYPaySignView yYPaySignView, CheckBox checkBox) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yYPaySignView, checkBox};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = yYPaySignView;
            this.a = checkBox;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (this.b.c != null) {
                    this.b.c.b();
                }
                Context applicationContext = this.b.a.getApplicationContext();
                qba.b(applicationContext, this.b.h + "").c("pay_sp_key_sign_pay_skip_remind", this.a.isChecked());
                RLog.info("YYPaySignView", "click remind. uid=" + this.b.h + ", is skip remind=" + this.a.isChecked());
                aba.d(this.b.f, this.b.g, PayUVEventType.PAY_SIGN_DIALOG_CONFIRM_BTN_CLICK, "", "", "");
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public YYPaySignView(Activity activity, cca.b bVar, PayUIKitConfig payUIKitConfig, int i, int i2) {
        super(activity);
        MiddleRevenueConfig middleRevenueConfig;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {activity, bVar, payUIKitConfig, Integer.valueOf(i), Integer.valueOf(i2)};
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
        this.h = 0L;
        if (bVar == null) {
            RLog.error("YYPaySignView", "YYPaySignView construct error viewParams null", new Object[0]);
        } else {
            RLog.info("YYPaySignView", "YYPaySignView construct, viewParams=" + bVar);
        }
        this.a = activity;
        this.b = bVar;
        this.d = payUIKitConfig;
        this.f = i;
        this.g = i2;
        if (payUIKitConfig != null && (middleRevenueConfig = payUIKitConfig.revenueConfig) != null) {
            this.h = middleRevenueConfig.getUid();
        }
        h();
        aba.d(this.f, this.g, PayUVEventType.PAY_SIGN_DIALOG_SHOW, "", "", "");
    }

    @Override // com.baidu.tieba.cca
    public void setCallback(cca.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, aVar) == null) {
            this.c = aVar;
        }
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            LayoutInflater.from(new ContextThemeWrapper(this.a, vba.a.a(this.d))).inflate(R.layout.pay_ui_layout_sign_pay_view, (ViewGroup) this, true);
            this.e = (TextView) findViewById(R.id.btn_confirm_recharge);
            View findViewById = findViewById(R.id.ll_check_remind);
            CheckBox checkBox = (CheckBox) findViewById(R.id.btn_check_remind);
            i();
            findViewById.setOnClickListener(new a(this, checkBox));
            Context applicationContext = this.a.getApplicationContext();
            checkBox.setChecked(qba.b(applicationContext, this.h + "").a("pay_sp_key_sign_pay_skip_remind", true));
            checkBox.setOnCheckedChangeListener(new b(this));
            this.e.setOnClickListener(new c(this, checkBox));
        }
    }

    public final void i() {
        cca.b bVar;
        uaa uaaVar;
        boolean z;
        String format;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && (bVar = this.b) != null && (uaaVar = bVar.a) != null) {
            double c2 = uaaVar.c();
            if (c2 == ((long) c2)) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                format = new DecimalFormat("0").format(c2);
            } else {
                format = new DecimalFormat("0.00").format(c2);
            }
            TextView textView = this.e;
            textView.setText("确认支付" + format + "元");
        }
    }
}
