package d.a.c.k.e;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.widget.refresh.BdSwipeRefreshLayout;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.security.InvalidParameterException;
/* loaded from: classes7.dex */
public abstract class c implements BdSwipeRefreshLayout.i {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public Context f41843e;

    /* renamed from: f  reason: collision with root package name */
    public View f41844f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f41845g;

    /* renamed from: h  reason: collision with root package name */
    public int f41846h;

    /* renamed from: i  reason: collision with root package name */
    public a f41847i;
    public boolean j;

    /* loaded from: classes7.dex */
    public interface a {
        void a(c cVar, int i2, int i3, int i4, int i5);
    }

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
        this.f41843e = null;
        this.f41844f = null;
        this.f41845g = true;
        this.f41846h = 0;
        this.j = false;
        if (context != null) {
            this.f41843e = context;
            return;
        }
        throw new InvalidParameterException("BdIListPullView context is null");
    }

    public void A() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.j = false;
        }
    }

    public void B(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            this.f41845g = z;
        }
    }

    public void C(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, aVar) == null) {
            this.f41847i = aVar;
        }
    }

    public void D(int i2, int i3, int i4, int i5) {
        View view;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIIII(1048579, this, i2, i3, i4, i5) == null) || (view = this.f41844f) == null || this.j) {
            return;
        }
        view.setPadding(i2, i3, i4, i5);
        a aVar = this.f41847i;
        if (aVar != null) {
            aVar.a(this, i2, i4, i3 + q(), i5);
        }
    }

    @Override // com.baidu.adp.widget.refresh.BdSwipeRefreshLayout.i
    public void c() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || this.j) {
            return;
        }
        x(false);
    }

    @Override // com.baidu.adp.widget.refresh.BdSwipeRefreshLayout.i
    public void d() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || this.j) {
            return;
        }
        z();
    }

    @Override // com.baidu.adp.widget.refresh.BdSwipeRefreshLayout.i
    public void e(float f2, float f3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3)}) == null) {
        }
    }

    @Override // com.baidu.adp.widget.refresh.BdSwipeRefreshLayout.i
    public long getCompleteAnimTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return 0L;
        }
        return invokeV.longValue;
    }

    @Override // com.baidu.adp.widget.refresh.BdSwipeRefreshLayout.i
    public final View getView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            if (this.f41844f == null) {
                View n = n();
                this.f41844f = n;
                if (n != null) {
                    t(n);
                    this.f41846h = this.f41844f.getMeasuredHeight();
                    this.f41844f.getMeasuredWidth();
                } else {
                    throw new IllegalStateException("BdIListPullView getView is null");
                }
            }
            return this.f41844f;
        }
        return (View) invokeV.objValue;
    }

    @Override // com.baidu.adp.widget.refresh.BdSwipeRefreshLayout.i
    public void k() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || this.j) {
            return;
        }
        u();
    }

    @Override // com.baidu.adp.widget.refresh.BdSwipeRefreshLayout.i
    public void m() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || this.j) {
            return;
        }
        y();
        v(true);
    }

    public abstract View n();

    public abstract void o(boolean z);

    @Override // com.baidu.adp.widget.refresh.BdSwipeRefreshLayout.i
    public void onFinish() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048589, this) == null) || this.j) {
            return;
        }
        o(true);
    }

    public Context p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.f41843e : (Context) invokeV.objValue;
    }

    public int q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.f41846h : invokeV.intValue;
    }

    public boolean r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.f41845g : invokeV.booleanValue;
    }

    public boolean s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.j : invokeV.booleanValue;
    }

    public final void t(View view) {
        int makeMeasureSpec;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, view) == null) {
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new ViewGroup.LayoutParams(-1, -2);
            }
            int childMeasureSpec = ViewGroup.getChildMeasureSpec(0, 0, layoutParams.width);
            int i2 = layoutParams.height;
            if (i2 > 0) {
                makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i2, 1073741824);
            } else {
                makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
            }
            view.measure(childMeasureSpec, makeMeasureSpec);
        }
    }

    public abstract void u();

    public abstract void v(boolean z);

    public void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            this.j = true;
        }
    }

    public abstract void x(boolean z);

    public abstract void y();

    public abstract void z();
}
