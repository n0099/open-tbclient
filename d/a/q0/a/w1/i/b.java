package d.a.q0.a.w1.i;

import android.view.View;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.q0.a.k;
import d.a.q0.a.w1.j.g;
/* loaded from: classes8.dex */
public class b implements d.a.q0.a.w1.k.a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: h  reason: collision with root package name */
    public static final boolean f51533h;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final View f51534e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f51535f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f51536g;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1161759291, "Ld/a/q0/a/w1/i/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1161759291, "Ld/a/q0/a/w1/i/b;");
                return;
            }
        }
        f51533h = k.f49133a;
    }

    public b(View view) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {view};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f51535f = false;
        this.f51536g = false;
        this.f51534e = view;
    }

    public boolean a(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
            if (i2 == 0) {
                this.f51535f = false;
            }
            if (i2 == this.f51534e.getVisibility()) {
                return true;
            }
            return b() && i2 == 0;
        }
        return invokeI.booleanValue;
    }

    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f51536g : invokeV.booleanValue;
    }

    public int[] c(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(Constants.METHOD_SEND_USER_MSG, this, i2, i3)) == null) {
            if (this.f51535f) {
                this.f51534e.setVisibility(8);
                int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 1073741824);
                i3 = View.MeasureSpec.makeMeasureSpec(0, 1073741824);
                i2 = makeMeasureSpec;
            }
            return new int[]{i2, i3};
        }
        return (int[]) invokeII.objValue;
    }

    public void d(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            g.g(this.f51534e, i2);
        }
    }

    public void e(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            this.f51536g = z;
        }
    }

    @Override // d.a.q0.a.w1.k.a
    public void handleHide() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.f51535f = true;
        }
    }

    @Override // d.a.q0.a.w1.k.a
    public void handleShow() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048582, this) == null) && f51533h) {
            throw new IllegalAccessError("You can't invoke handle show in handler, please instead of handling in the panel layout, maybe just need invoke super.setVisibility(View.VISIBLE)");
        }
    }
}
