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
import tbclient.GetVipInfo.VipSpecialItem;
import tbclient.GetVipInfo.VipSpecialList;
/* loaded from: classes9.dex */
public class n implements d.a.c.k.e.n {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: g  reason: collision with root package name */
    public static final BdUniqueId f68273g;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public d f68274e;

    /* renamed from: f  reason: collision with root package name */
    public List<o> f68275f;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1030733459, "Ld/a/s0/v1/c/b/n;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1030733459, "Ld/a/s0/v1/c/b/n;");
                return;
            }
        }
        f68273g = BdUniqueId.gen();
    }

    public n(VipSpecialList vipSpecialList) {
        List<VipSpecialItem> list;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {vipSpecialList};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        if (vipSpecialList == null || (list = vipSpecialList.item) == null || list.size() <= 0) {
            return;
        }
        String str = vipSpecialList.card_id;
        d dVar = new d();
        this.f68274e = dVar;
        dVar.e(1);
        this.f68274e.d(vipSpecialList.class_name);
        this.f68274e.f(vipSpecialList.class_url_name);
        this.f68274e.g(vipSpecialList.class_url);
        this.f68275f = new ArrayList();
        for (VipSpecialItem vipSpecialItem : vipSpecialList.item) {
            this.f68275f.add(new o(vipSpecialItem));
        }
    }

    @Override // d.a.c.k.e.n
    public BdUniqueId getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? f68273g : (BdUniqueId) invokeV.objValue;
    }
}
