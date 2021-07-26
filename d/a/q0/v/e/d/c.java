package d.a.q0.v.e.d;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class c extends d.a.d.k.e.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: f  reason: collision with root package name */
    public Context f65380f;

    /* renamed from: g  reason: collision with root package name */
    public View f65381g;

    /* renamed from: h  reason: collision with root package name */
    public ImageView f65382h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f65383i;
    public View j;
    public View k;
    public View.OnClickListener l;

    public c(Context context) {
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
        this.f65380f = context;
    }

    @Override // d.a.d.k.e.b
    public View a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            View inflate = LayoutInflater.from(this.f65380f).inflate(R.layout.ala_frs_game_more_live_layout, (ViewGroup) null);
            this.f65381g = inflate;
            this.f65383i = (TextView) inflate.findViewById(R.id.ala_game_frs_more_live_tip);
            this.f65382h = (ImageView) this.f65381g.findViewById(R.id.ala_game_frs_more_live_icon);
            this.j = this.f65381g.findViewById(R.id.ala_game_frs_more_live_top_line);
            this.k = this.f65381g.findViewById(R.id.ala_game_frs_more_live_bottom_line);
            d(TbadkCoreApplication.getInst().getSkinType());
            return this.f65381g;
        }
        return (View) invokeV.objValue;
    }

    @Override // d.a.d.k.e.b
    public void c() {
        View.OnClickListener onClickListener;
        View view;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (onClickListener = this.l) == null || (view = this.f65381g) == null) {
            return;
        }
        onClickListener.onClick(view);
    }

    public void d(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
            View view = this.f65381g;
            if (view != null) {
                SkinManager.setBackgroundResource(view, R.drawable.addresslist_item_bg);
            }
            TextView textView = this.f65383i;
            if (textView != null) {
                SkinManager.setViewTextColor(textView, R.color.CAM_X0304);
            }
            ImageView imageView = this.f65382h;
            if (imageView != null) {
                SkinManager.setImageResource(imageView, R.drawable.icon_inf_arrowblue_n);
            }
            View view2 = this.j;
            if (view2 != null) {
                SkinManager.setBackgroundResource(view2, R.color.CAM_X0204);
            }
            View view3 = this.k;
            if (view3 != null) {
                SkinManager.setBackgroundResource(view3, R.color.CAM_X0204);
            }
        }
    }

    public void e(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, onClickListener) == null) {
            this.l = onClickListener;
        }
    }
}
