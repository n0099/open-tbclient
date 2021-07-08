package d.a.p0.v.d.f.f;

import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.e.p.l;
/* loaded from: classes8.dex */
public abstract class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f64556a;

    /* renamed from: b  reason: collision with root package name */
    public int f64557b;

    /* renamed from: c  reason: collision with root package name */
    public TbPageContext f64558c;

    /* renamed from: d  reason: collision with root package name */
    public d.a.p0.v.d.f.c.a f64559d;

    /* renamed from: e  reason: collision with root package name */
    public View f64560e;

    public a(TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f64558c = tbPageContext;
        int k = l.k(tbPageContext.getPageActivity());
        this.f64556a = k;
        this.f64557b = (int) ((k * 9.0d) / 16.0d);
    }

    public void a(ViewGroup viewGroup) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, viewGroup) == null) || viewGroup == null) {
            return;
        }
        viewGroup.removeAllViews();
        viewGroup.addView(c());
    }

    public void b(d.a.p0.v.d.f.c.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
            this.f64559d = aVar;
        }
    }

    public abstract View c();

    public abstract void d();

    public View e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            this.f64560e = new View(this.f64558c.getPageActivity());
            this.f64560e.setLayoutParams(new FrameLayout.LayoutParams(this.f64556a, this.f64557b));
            this.f64560e.setBackgroundDrawable(new ColorDrawable(this.f64558c.getPageActivity().getResources().getColor(R.color.black_alpha30)));
            return this.f64560e;
        }
        return (View) invokeV.objValue;
    }

    public abstract boolean f(d.a.p0.v.d.f.c.a aVar);

    public abstract void g(boolean z);

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            int k = l.k(this.f64558c.getPageActivity());
            this.f64556a = k;
            this.f64557b = (int) ((k * 9.0d) / 16.0d);
            View view = this.f64560e;
            if (view != null) {
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
                layoutParams.width = this.f64556a;
                layoutParams.height = this.f64557b;
                this.f64560e.setLayoutParams(layoutParams);
            }
        }
    }

    public abstract void i(int i2);

    public abstract void j();

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
        }
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
        }
    }

    public abstract void m();

    public abstract void n();
}
