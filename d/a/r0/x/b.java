package d.a.r0.x;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.util.tbselector.TBSelector;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.e.p.l;
/* loaded from: classes9.dex */
public class b implements c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public View f56868a;

    /* renamed from: b  reason: collision with root package name */
    public ImageView f56869b;

    /* renamed from: c  reason: collision with root package name */
    public ImageView f56870c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f56871d;

    /* renamed from: e  reason: collision with root package name */
    public LinearLayout f56872e;

    public b(Context context) {
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
        View inflate = LayoutInflater.from(TbadkCoreApplication.getInst()).inflate(R.layout.floating_view_from_rule_copy, (ViewGroup) null);
        this.f56868a = inflate;
        this.f56869b = (ImageView) inflate.findViewById(R.id.floating_view_icon);
        this.f56871d = (TextView) this.f56868a.findViewById(R.id.floating_view_title);
        this.f56870c = (ImageView) this.f56868a.findViewById(R.id.floating_view_arrow);
        this.f56872e = (LinearLayout) this.f56868a.findViewById(R.id.floating_view_main);
        this.f56871d.setText(R.string.frs_forum_rule_return_info);
        b();
    }

    @Override // d.a.r0.x.c
    public void b() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f56868a == null) {
            return;
        }
        SkinManager.setViewTextColor(this.f56871d, R.color.CAM_X0101);
        this.f56870c.setImageDrawable(WebPManager.getPureDrawable(R.drawable.icon_pure_arrow12_right_n, SkinManager.getColor(R.color.CAM_X0101), WebPManager.ResourceStateType.NORMAL_PRESS));
        TBSelector.makeDrawableSelector().defaultColor(R.color.CAM_X0302).setShape(0).setAlpha(211).tlRadius(l.g(TbadkCoreApplication.getInst(), R.dimen.tbds52)).blRadius(l.g(TbadkCoreApplication.getInst(), R.dimen.tbds52)).into(this.f56872e);
        this.f56869b.setImageDrawable(WebPManager.getMaskDrawable(R.drawable.icon_mask_manage_postdelete_cancel32, WebPManager.ResourceStateType.NORMAL));
    }

    @Override // d.a.r0.x.c
    public View getView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            View view = this.f56868a;
            return view != null ? view : LayoutInflater.from(TbadkCoreApplication.getInst()).inflate(R.layout.floating_view_from_bcast_copy_link, (ViewGroup) null);
        }
        return (View) invokeV.objValue;
    }

    @Override // d.a.r0.x.c
    public void onClick() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
        }
    }
}
