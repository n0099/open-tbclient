package d.a.s0.g2;

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
import d.a.c.a.f;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes9.dex */
public class a extends d.a.c.a.d<PayVcodeActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public PayVcodeActivity f59804a;

    /* renamed from: b  reason: collision with root package name */
    public ViewGroup f59805b;

    /* renamed from: c  reason: collision with root package name */
    public View f59806c;

    /* renamed from: d  reason: collision with root package name */
    public ViewGroup f59807d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f59808e;

    /* renamed from: f  reason: collision with root package name */
    public BaseWebView f59809f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f59810g;

    /* renamed from: h  reason: collision with root package name */
    public ProgressBar f59811h;

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
        this.f59804a = payVcodeActivity;
        payVcodeActivity.setContentView(R.layout.pay_vcode_activity);
        k(payVcodeActivity);
    }

    public View d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f59806c : (View) invokeV.objValue;
    }

    public TextView e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f59810g : (TextView) invokeV.objValue;
    }

    public TextView f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f59808e : (TextView) invokeV.objValue;
    }

    public ViewGroup h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f59807d : (ViewGroup) invokeV.objValue;
    }

    public BaseWebView i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f59809f : (BaseWebView) invokeV.objValue;
    }

    public final void k(PayVcodeActivity payVcodeActivity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, payVcodeActivity) == null) {
            this.f59805b = (ViewGroup) this.f59804a.findViewById(R.id.payvcode_parent);
            TextView textView = (TextView) this.f59804a.findViewById(R.id.payment_performance);
            this.f59808e = textView;
            SkinManager.setBackgroundResource(textView, R.drawable.s_navbar_button_bg);
            SkinManager.setViewTextColor(this.f59808e, R.color.CAM_X0101, 1);
            this.f59809f = (BaseWebView) payVcodeActivity.findViewById(R.id.vcode_webview);
            this.f59810g = (TextView) payVcodeActivity.findViewById(R.id.webview_fail_view);
            this.f59806c = payVcodeActivity.findViewById(R.id.payvcode_empty_layout);
            this.f59807d = (ViewGroup) payVcodeActivity.findViewById(R.id.payvcode_layout);
            this.f59811h = (ProgressBar) payVcodeActivity.findViewById(R.id.payvcode_progress);
            this.f59809f.setHorizontalScrollBarEnabled(false);
            this.f59809f.setHorizontalScrollbarOverlay(false);
            this.f59809f.setScrollBarStyle(33554432);
            this.f59809f.getSettings().setJavaScriptEnabled(true);
        }
    }

    public void l(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            this.f59810g.setVisibility(z ? 0 : 8);
        }
    }

    public void m(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            this.f59811h.setVisibility(z ? 0 : 8);
        }
    }

    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) {
            d.a.r0.s0.a.a(this.f59804a.getPageContext(), this.f59805b);
            SkinManager.setBgColor(this.f59810g, i2);
            SkinManager.setBackgroundResource(this.f59808e, R.drawable.s_navbar_button_bg);
            SkinManager.setViewTextColor(this.f59808e, R.color.CAM_X0101, 1);
        }
    }
}
