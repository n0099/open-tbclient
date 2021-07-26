package d.a.q0.h2.h;

import com.baidu.adp.BdUniqueId;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import tbclient.PbPage.PbSortType;
/* loaded from: classes8.dex */
public class o implements d.a.d.k.e.n {
    public static /* synthetic */ Interceptable $ic;
    public static final BdUniqueId l;
    public static final BdUniqueId m;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public String f57474e;

    /* renamed from: f  reason: collision with root package name */
    public BdUniqueId f57475f;

    /* renamed from: g  reason: collision with root package name */
    public int f57476g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f57477h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f57478i;
    public boolean j;
    public List<PbSortType> k;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(2069408813, "Ld/a/q0/h2/h/o;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(2069408813, "Ld/a/q0/h2/h/o;");
                return;
            }
        }
        l = BdUniqueId.gen();
        m = BdUniqueId.gen();
    }

    public o(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bdUniqueId};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f57475f = m;
        this.f57476g = 0;
        this.f57477h = false;
        this.f57475f = bdUniqueId;
    }

    @Override // d.a.d.k.e.n
    public BdUniqueId getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f57475f : (BdUniqueId) invokeV.objValue;
    }
}
