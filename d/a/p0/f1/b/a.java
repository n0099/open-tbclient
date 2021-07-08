package d.a.p0.f1.b;

import android.widget.ExpandableListView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes8.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: e  reason: collision with root package name */
    public static ArrayList<a> f56187e;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f56188a;

    /* renamed from: b  reason: collision with root package name */
    public int f56189b;

    /* renamed from: c  reason: collision with root package name */
    public int f56190c;

    /* renamed from: d  reason: collision with root package name */
    public int f56191d;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(462106625, "Ld/a/p0/f1/b/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(462106625, "Ld/a/p0/f1/b/a;");
                return;
            }
        }
        f56187e = new ArrayList<>(5);
    }

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static a b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            synchronized (f56187e) {
                if (f56187e.size() > 0) {
                    a remove = f56187e.remove(0);
                    remove.f();
                    return remove;
                }
                return new a();
            }
        }
        return (a) invokeV.objValue;
    }

    public static a c(int i2, int i3, int i4, int i5) {
        InterceptResult invokeIIII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIII = interceptable.invokeIIII(65539, null, i2, i3, i4, i5)) == null) {
            a b2 = b();
            b2.f56191d = i2;
            b2.f56188a = i3;
            b2.f56189b = i4;
            b2.f56190c = i5;
            return b2;
        }
        return (a) invokeIIII.objValue;
    }

    public static a d(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TRACKBALL, null, i2)) == null) ? c(2, i2, 0, 0) : (a) invokeI.objValue;
    }

    public long a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f56191d == 1 ? ExpandableListView.getPackedPositionForChild(this.f56188a, this.f56189b) : ExpandableListView.getPackedPositionForGroup(this.f56188a) : invokeV.longValue;
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            synchronized (f56187e) {
                if (f56187e.size() < 5) {
                    f56187e.add(this);
                }
            }
        }
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f56188a = 0;
            this.f56189b = 0;
            this.f56190c = 0;
            this.f56191d = 0;
        }
    }
}
