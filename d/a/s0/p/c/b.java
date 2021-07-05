package d.a.s0.p.c;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.coreExtra.view.TbSettingTextTipView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import tbclient.SimpleUser;
/* loaded from: classes9.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final View.OnClickListener f64360a;

    /* renamed from: b  reason: collision with root package name */
    public BaseActivity f64361b;

    /* renamed from: c  reason: collision with root package name */
    public LinearLayout f64362c;

    /* renamed from: d  reason: collision with root package name */
    public LinearLayout f64363d;

    /* renamed from: e  reason: collision with root package name */
    public TbSettingTextTipView f64364e;

    /* renamed from: f  reason: collision with root package name */
    public TbSettingTextTipView f64365f;

    public b(BaseActivity baseActivity, View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {baseActivity, onClickListener};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f64361b = baseActivity;
        this.f64360a = onClickListener;
        b();
    }

    public View a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f64362c : (View) invokeV.objValue;
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(this.f64361b).inflate(R.layout.account_safe_activity, (ViewGroup) null);
            this.f64362c = linearLayout;
            this.f64363d = (LinearLayout) linearLayout.findViewById(R.id.content_container);
            this.f64364e = (TbSettingTextTipView) this.f64362c.findViewById(R.id.bar_record);
            this.f64365f = (TbSettingTextTipView) this.f64362c.findViewById(R.id.account_status);
            this.f64364e.a();
            this.f64365f.a();
            this.f64364e.setOnClickListener(this.f64360a);
            this.f64365f.setOnClickListener(this.f64360a);
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f64362c.removeAllViews();
            this.f64361b = null;
        }
    }

    public void d(SimpleUser simpleUser) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, simpleUser) == null) || simpleUser == null) {
            return;
        }
        this.f64365f.setTip(simpleUser.block_msg);
    }

    public void e(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
            this.f64361b.getLayoutMode().k(i2 == 1);
            this.f64361b.getLayoutMode().j(this.f64362c);
        }
    }
}
