package d.a.s0.e0;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.view.MessageRedDotView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.e.p.l;
/* loaded from: classes9.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Context f58282a;

    /* renamed from: b  reason: collision with root package name */
    public View f58283b;

    /* renamed from: c  reason: collision with root package name */
    public RelativeLayout f58284c;

    /* renamed from: d  reason: collision with root package name */
    public ImageView f58285d;

    /* renamed from: e  reason: collision with root package name */
    public MessageRedDotView f58286e;

    public d(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f58282a = context;
        View inflate = LayoutInflater.from(context).inflate(R.layout.widget_message_entrance, (ViewGroup) null);
        this.f58283b = inflate;
        this.f58284c = (RelativeLayout) inflate.findViewById(R.id.message_view_layout);
        this.f58285d = (ImageView) this.f58283b.findViewById(R.id.img_message);
        MessageRedDotView messageRedDotView = (MessageRedDotView) this.f58283b.findViewById(R.id.img_red_tip);
        this.f58286e = messageRedDotView;
        messageRedDotView.setShadowEnabled(false);
    }

    public MessageRedDotView a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f58286e : (MessageRedDotView) invokeV.objValue;
    }

    public ImageView b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f58285d : (ImageView) invokeV.objValue;
    }

    public View c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f58283b : (View) invokeV.objValue;
    }

    public void d(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            this.f58286e.e();
            this.f58285d.setImageDrawable(WebPManager.getPureDrawable(R.drawable.icon_pure_topbar_information40, SkinManager.getColor(R.color.CAM_X0106), WebPManager.ResourceStateType.NORMAL_PRESS));
        }
    }

    public void e(boolean z, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2)}) == null) {
            if (z) {
                this.f58286e.f(i2);
                this.f58286e.setVisibility(0);
                return;
            }
            this.f58286e.setVisibility(8);
        }
    }

    public void f(NavigationBar.ControlAlign controlAlign, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLZ(1048581, this, controlAlign, z) == null) && !z && controlAlign == NavigationBar.ControlAlign.HORIZONTAL_RIGHT) {
            ((RelativeLayout.LayoutParams) this.f58285d.getLayoutParams()).rightMargin = -l.g(this.f58282a, R.dimen.tbds10);
            ((RelativeLayout.LayoutParams) this.f58286e.getLayoutParams()).rightMargin = -l.g(this.f58282a, R.dimen.tbds10);
            this.f58284c.getLayoutParams().width = l.g(this.f58282a, R.dimen.ds88);
        }
    }

    public void g(int i2) {
        View view;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048582, this, i2) == null) || (view = this.f58283b) == null) {
            return;
        }
        view.setVisibility(i2);
    }
}
