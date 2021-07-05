package d.a.s0.u0.r1.a.e;

import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public abstract class a extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public e f66938e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f66939f;

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f66939f = true;
    }

    public final View a(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, view)) == null) {
            e eVar = this.f66938e;
            if (eVar == null) {
                return view;
            }
            if (view == null || view != eVar.getArrowView()) {
                view = this.f66938e.getArrowView();
                if (view.getLayoutParams() == null) {
                    view.setLayoutParams(new AbsListView.LayoutParams(-1, d()));
                }
            }
            this.f66938e.a(view);
            return view;
        }
        return (View) invokeL.objValue;
    }

    public abstract int b();

    public abstract Object c(int i2);

    public abstract int d();

    public abstract long e(int i2);

    public int f(int i2) {
        InterceptResult invokeI;
        int arrowIndex;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i2)) == null) {
            e eVar = this.f66938e;
            if (eVar == null || !eVar.b() || i2 < (arrowIndex = this.f66938e.getArrowIndex())) {
                return i2;
            }
            if (i2 == arrowIndex) {
                return -1;
            }
            return i2 - 1;
        }
        return invokeI.intValue;
    }

    public abstract View g(int i2, View view, ViewGroup viewGroup);

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        int b2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            if (h()) {
                if (this.f66939f) {
                    b2 = this.f66938e.getArrowIndex();
                } else {
                    e eVar = this.f66938e;
                    if (eVar != null && eVar.b()) {
                        b2 = b();
                    } else {
                        return b();
                    }
                }
                return b2 + 1;
            }
            return b();
        }
        return invokeV.intValue;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2)) == null) {
            if (h()) {
                int f2 = f(i2);
                if (f2 >= 0) {
                    return c(f2);
                }
                return c(i2);
            }
            return c(i2);
        }
        return invokeI.objValue;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048585, this, i2)) == null) {
            if (h()) {
                int f2 = f(i2);
                if (f2 >= 0) {
                    return e(f2);
                }
                return e(i2);
            }
            return e(i2);
        }
        return invokeI.longValue;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i2) {
        InterceptResult invokeI;
        int arrowIndex;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048586, this, i2)) == null) ? (h() && (arrowIndex = this.f66938e.getArrowIndex()) > 0 && i2 == arrowIndex) ? 1 : 0 : invokeI.intValue;
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048587, this, i2, view, viewGroup)) == null) {
            if (getItemViewType(i2) == 0) {
                return g(f(i2), view, viewGroup);
            }
            return a(view);
        }
        return (View) invokeILL.objValue;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? h() ? 2 : 1 : invokeV.intValue;
    }

    public boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            e eVar = this.f66938e;
            return eVar != null && eVar.b() && b() - 1 > this.f66938e.getArrowIndex();
        }
        return invokeV.booleanValue;
    }

    public void i(e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, eVar) == null) {
            this.f66938e = eVar;
        }
    }

    public abstract void j(int i2);

    public void k(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048592, this, z) == null) {
            this.f66939f = z;
        }
    }
}
