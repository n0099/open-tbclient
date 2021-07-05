package d.a.s0.v1.c.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import tbclient.GetVipInfo.VipTaskItem;
import tbclient.GetVipInfo.VipTaskList;
/* loaded from: classes9.dex */
public class q implements d.a.c.k.e.n {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: g  reason: collision with root package name */
    public static final BdUniqueId f68278g;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public d f68279e;

    /* renamed from: f  reason: collision with root package name */
    public List<r> f68280f;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1030733366, "Ld/a/s0/v1/c/b/q;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1030733366, "Ld/a/s0/v1/c/b/q;");
                return;
            }
        }
        f68278g = BdUniqueId.gen();
    }

    public q(VipTaskList vipTaskList) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {vipTaskList};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        if (vipTaskList == null || vipTaskList.item == null) {
            return;
        }
        String str = vipTaskList.card_id;
        d dVar = new d();
        this.f68279e = dVar;
        dVar.e(3);
        this.f68279e.d(vipTaskList.class_name);
        this.f68279e.f(vipTaskList.class_url_name);
        this.f68279e.g(vipTaskList.class_url);
        this.f68280f = new ArrayList();
        for (VipTaskItem vipTaskItem : vipTaskList.item) {
            this.f68280f.add(new r(vipTaskItem));
        }
    }

    @Override // d.a.c.k.e.n
    public BdUniqueId getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? f68278g : (BdUniqueId) invokeV.objValue;
    }
}
