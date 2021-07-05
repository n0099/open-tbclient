package d.a.r0.b.f;

import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes9.dex */
public class g extends a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: c  reason: collision with root package name */
    public static final BdUniqueId f54761c;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final ArrayList<String> f54762a;

    /* renamed from: b  reason: collision with root package name */
    public d.a.r0.b.e f54763b;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-943828074, "Ld/a/r0/b/f/g;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-943828074, "Ld/a/r0/b/f/g;");
                return;
            }
        }
        f54761c = BdUniqueId.gen();
    }

    public g() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        ArrayList<String> arrayList = new ArrayList<>(2);
        this.f54762a = arrayList;
        arrayList.add("12_2_frs_default_sort_a");
        this.f54762a.add("12_2_frs_default_sort_b");
    }

    @Override // d.a.r0.b.f.a
    public ArrayList<String> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f54762a : (ArrayList) invokeV.objValue;
    }

    @Override // d.a.r0.b.f.a
    public d.a.r0.b.e b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f54763b : (d.a.r0.b.e) invokeV.objValue;
    }

    @Override // d.a.r0.b.f.a
    public BdUniqueId c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? f54761c : (BdUniqueId) invokeV.objValue;
    }

    @Override // d.a.r0.b.f.a
    public void f(d.a.r0.b.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, eVar) == null) {
            this.f54763b = eVar;
        }
    }
}
