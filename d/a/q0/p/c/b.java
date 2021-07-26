package d.a.q0.p.c;

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
/* loaded from: classes8.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final View.OnClickListener f61740a;

    /* renamed from: b  reason: collision with root package name */
    public BaseActivity f61741b;

    /* renamed from: c  reason: collision with root package name */
    public LinearLayout f61742c;

    /* renamed from: d  reason: collision with root package name */
    public LinearLayout f61743d;

    /* renamed from: e  reason: collision with root package name */
    public TbSettingTextTipView f61744e;

    /* renamed from: f  reason: collision with root package name */
    public TbSettingTextTipView f61745f;

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
        this.f61741b = baseActivity;
        this.f61740a = onClickListener;
        b();
    }

    public View a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f61742c : (View) invokeV.objValue;
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(this.f61741b).inflate(R.layout.account_safe_activity, (ViewGroup) null);
            this.f61742c = linearLayout;
            this.f61743d = (LinearLayout) linearLayout.findViewById(R.id.content_container);
            this.f61744e = (TbSettingTextTipView) this.f61742c.findViewById(R.id.bar_record);
            this.f61745f = (TbSettingTextTipView) this.f61742c.findViewById(R.id.account_status);
            this.f61744e.a();
            this.f61745f.a();
            this.f61744e.setOnClickListener(this.f61740a);
            this.f61745f.setOnClickListener(this.f61740a);
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f61742c.removeAllViews();
            this.f61741b = null;
        }
    }

    public void d(SimpleUser simpleUser) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, simpleUser) == null) || simpleUser == null) {
            return;
        }
        this.f61745f.setTip(simpleUser.block_msg);
    }

    public void e(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
            this.f61741b.getLayoutMode().k(i2 == 1);
            this.f61741b.getLayoutMode().j(this.f61742c);
        }
    }
}
