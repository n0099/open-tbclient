package d.a.q0.g2;

import android.annotation.SuppressLint;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.coreExtra.view.BaseWebView;
import com.baidu.tieba.R;
import com.baidu.tieba.payment.PayVcodeActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.d.a.f;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes8.dex */
public class a extends d.a.d.a.d<PayVcodeActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public PayVcodeActivity f57090a;

    /* renamed from: b  reason: collision with root package name */
    public ViewGroup f57091b;

    /* renamed from: c  reason: collision with root package name */
    public View f57092c;

    /* renamed from: d  reason: collision with root package name */
    public ViewGroup f57093d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f57094e;

    /* renamed from: f  reason: collision with root package name */
    public BaseWebView f57095f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f57096g;

    /* renamed from: h  reason: collision with root package name */
    public ProgressBar f57097h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(PayVcodeActivity payVcodeActivity) {
        super(payVcodeActivity.getPageContext());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {payVcodeActivity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((f) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f57090a = payVcodeActivity;
        payVcodeActivity.setContentView(R.layout.pay_vcode_activity);
        j(payVcodeActivity);
    }

    public View d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f57092c : (View) invokeV.objValue;
    }

    public TextView e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f57096g : (TextView) invokeV.objValue;
    }

    public TextView f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f57094e : (TextView) invokeV.objValue;
    }

    public ViewGroup g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f57093d : (ViewGroup) invokeV.objValue;
    }

    public BaseWebView h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f57095f : (BaseWebView) invokeV.objValue;
    }

    public final void j(PayVcodeActivity payVcodeActivity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, payVcodeActivity) == null) {
            this.f57091b = (ViewGroup) this.f57090a.findViewById(R.id.payvcode_parent);
            TextView textView = (TextView) this.f57090a.findViewById(R.id.payment_performance);
            this.f57094e = textView;
            SkinManager.setBackgroundResource(textView, R.drawable.s_navbar_button_bg);
            SkinManager.setViewTextColor(this.f57094e, R.color.CAM_X0101, 1);
            this.f57095f = (BaseWebView) payVcodeActivity.findViewById(R.id.vcode_webview);
            this.f57096g = (TextView) payVcodeActivity.findViewById(R.id.webview_fail_view);
            this.f57092c = payVcodeActivity.findViewById(R.id.payvcode_empty_layout);
            this.f57093d = (ViewGroup) payVcodeActivity.findViewById(R.id.payvcode_layout);
            this.f57097h = (ProgressBar) payVcodeActivity.findViewById(R.id.payvcode_progress);
            this.f57095f.setHorizontalScrollBarEnabled(false);
            this.f57095f.setHorizontalScrollbarOverlay(false);
            this.f57095f.setScrollBarStyle(33554432);
            this.f57095f.getSettings().setJavaScriptEnabled(true);
        }
    }

    public void k(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            this.f57096g.setVisibility(z ? 0 : 8);
        }
    }

    public void l(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            this.f57097h.setVisibility(z ? 0 : 8);
        }
    }

    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) {
            d.a.p0.u0.a.a(this.f57090a.getPageContext(), this.f57091b);
            SkinManager.setBgColor(this.f57096g, i2);
            SkinManager.setBackgroundResource(this.f57094e, R.drawable.s_navbar_button_bg);
            SkinManager.setViewTextColor(this.f57094e, R.color.CAM_X0101, 1);
        }
    }
}
