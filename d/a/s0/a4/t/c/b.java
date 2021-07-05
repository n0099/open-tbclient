package d.a.s0.a4.t.c;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.a.f;
/* loaded from: classes9.dex */
public class b extends a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: g  reason: collision with root package name */
    public static int f57616g;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c  reason: collision with root package name */
    public TextView f57617c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f57618d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f57619e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f57620f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(f fVar) {
        super(fVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {fVar};
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
        f57616g = fVar.getResources().getDimensionPixelOffset(R.dimen.ds8);
    }

    @Override // d.a.s0.a4.t.c.a
    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            View inflate = LayoutInflater.from(this.f57614a.getPageActivity()).inflate(R.layout.pic_rorate_view, (ViewGroup) null);
            this.f57615b = inflate;
            this.f57617c = (TextView) inflate.findViewById(R.id.rotate_left);
            this.f57618d = (TextView) this.f57615b.findViewById(R.id.rotate_right);
            this.f57619e = (TextView) this.f57615b.findViewById(R.id.rotate_left_right);
            this.f57620f = (TextView) this.f57615b.findViewById(R.id.rotate_up_down);
        }
    }

    public View e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f57615b : (View) invokeV.objValue;
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            SkinManager.setViewTextColor(this.f57617c, R.color.CAM_X0107);
            SkinManager.setViewTextColor(this.f57618d, R.color.CAM_X0107);
            SkinManager.setViewTextColor(this.f57619e, R.color.CAM_X0107);
            SkinManager.setViewTextColor(this.f57620f, R.color.CAM_X0107);
            this.f57617c.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, SkinManager.getDrawable(R.drawable.filter_rotate_left), (Drawable) null, (Drawable) null);
            this.f57618d.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, SkinManager.getDrawable(R.drawable.filter_rotate_right), (Drawable) null, (Drawable) null);
            this.f57620f.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, SkinManager.getDrawable(R.drawable.filter_flip_up_down), (Drawable) null, (Drawable) null);
            this.f57619e.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, SkinManager.getDrawable(R.drawable.filter_flip_left_right), (Drawable) null, (Drawable) null);
            this.f57617c.setCompoundDrawablePadding(f57616g);
            this.f57618d.setCompoundDrawablePadding(f57616g);
            this.f57620f.setCompoundDrawablePadding(f57616g);
            this.f57619e.setCompoundDrawablePadding(f57616g);
        }
    }

    public void g(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, onClickListener) == null) {
            this.f57617c.setTag(0);
            this.f57618d.setTag(1);
            this.f57619e.setTag(2);
            this.f57620f.setTag(3);
            this.f57617c.setOnClickListener(onClickListener);
            this.f57618d.setOnClickListener(onClickListener);
            this.f57619e.setOnClickListener(onClickListener);
            this.f57620f.setOnClickListener(onClickListener);
        }
    }
}
