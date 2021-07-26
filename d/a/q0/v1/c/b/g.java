package d.a.q0.v1.c.b;

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
import tbclient.GetVipInfo.VipDailyList;
import tbclient.GetVipInfo.VipThemeItem;
/* loaded from: classes8.dex */
public class g implements d.a.d.k.e.n {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: g  reason: collision with root package name */
    public static final BdUniqueId f65691g;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public d f65692e;

    /* renamed from: f  reason: collision with root package name */
    public List<h> f65693f;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1288899114, "Ld/a/q0/v1/c/b/g;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1288899114, "Ld/a/q0/v1/c/b/g;");
                return;
            }
        }
        f65691g = BdUniqueId.gen();
    }

    public g(VipDailyList vipDailyList) {
        List<VipThemeItem> list;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {vipDailyList};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        if (vipDailyList == null || (list = vipDailyList.item) == null || list.size() <= 0) {
            return;
        }
        String str = vipDailyList.card_id;
        d dVar = new d();
        this.f65692e = dVar;
        dVar.e(1);
        this.f65692e.d(vipDailyList.class_name);
        this.f65692e.f(vipDailyList.class_url_name);
        this.f65692e.g(vipDailyList.class_url);
        this.f65693f = new ArrayList();
        for (VipThemeItem vipThemeItem : vipDailyList.item) {
            this.f65693f.add(new h(vipThemeItem));
        }
    }

    @Override // d.a.d.k.e.n
    public BdUniqueId getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? f65691g : (BdUniqueId) invokeV.objValue;
    }
}
