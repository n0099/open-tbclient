package d.a.q0.e1.k.a.c;

import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.p0.s.q.b2;
import tbclient.ThreadInfo;
/* loaded from: classes8.dex */
public class d extends BaseCardInfo {
    public static /* synthetic */ Interceptable $ic;
    public static final BdUniqueId j;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public boolean f56320e;

    /* renamed from: f  reason: collision with root package name */
    public int f56321f;

    /* renamed from: g  reason: collision with root package name */
    public long f56322g;

    /* renamed from: h  reason: collision with root package name */
    public String f56323h;

    /* renamed from: i  reason: collision with root package name */
    public b2 f56324i;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-169241171, "Ld/a/q0/e1/k/a/c/d;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-169241171, "Ld/a/q0/e1/k/a/c/d;");
                return;
            }
        }
        j = BdUniqueId.gen();
    }

    public d() {
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

    public void c(ThreadInfo threadInfo) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, threadInfo) == null) || threadInfo == null) {
            return;
        }
        b2 b2Var = new b2();
        this.f56324i = b2Var;
        b2Var.K2(threadInfo);
        this.f56324i.O2();
    }

    @Override // com.baidu.tieba.card.data.BaseCardInfo, d.a.d.k.e.n
    public BdUniqueId getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? j : (BdUniqueId) invokeV.objValue;
    }
}
