package d.a.s0.v1.c.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import tbclient.GetVipInfo.VipRank;
import tbclient.GetVipInfo.VipUser;
/* loaded from: classes9.dex */
public class p implements d.a.c.k.e.n {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: f  reason: collision with root package name */
    public static final BdUniqueId f68276f;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public d f68277e;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1030733397, "Ld/a/s0/v1/c/b/p;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1030733397, "Ld/a/s0/v1/c/b/p;");
                return;
            }
        }
        f68276f = BdUniqueId.gen();
    }

    public p(VipRank vipRank, VipUser vipUser) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {vipRank, vipUser};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        if (vipRank == null) {
            return;
        }
        String str = vipRank.card_id;
        d dVar = new d();
        this.f68277e = dVar;
        dVar.d(vipRank.class_name);
        this.f68277e.f(vipRank.class_url_name);
        this.f68277e.g(vipRank.class_url);
        vipRank.my_score_rank.intValue();
        String str2 = vipUser.portrait;
    }

    @Override // d.a.c.k.e.n
    public BdUniqueId getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? f68276f : (BdUniqueId) invokeV.objValue;
    }
}
