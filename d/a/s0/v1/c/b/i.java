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
import tbclient.GetVipInfo.VipThemeItem;
import tbclient.GetVipInfo.VipThemeList;
/* loaded from: classes9.dex */
public class i implements d.a.c.k.e.n {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: h  reason: collision with root package name */
    public static final BdUniqueId f68264h;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public d f68265e;

    /* renamed from: f  reason: collision with root package name */
    public List<j> f68266f;

    /* renamed from: g  reason: collision with root package name */
    public List<j> f68267g;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1030733614, "Ld/a/s0/v1/c/b/i;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1030733614, "Ld/a/s0/v1/c/b/i;");
                return;
            }
        }
        f68264h = BdUniqueId.gen();
    }

    public i(VipThemeList vipThemeList) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {vipThemeList};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        if (vipThemeList == null) {
            return;
        }
        String str = vipThemeList.card_id;
        d dVar = new d();
        this.f68265e = dVar;
        dVar.e(2);
        this.f68265e.d(vipThemeList.class_name);
        this.f68265e.f(vipThemeList.class_url_name);
        this.f68265e.g(vipThemeList.class_url);
        if (vipThemeList.item != null) {
            this.f68266f = new ArrayList();
            for (VipThemeItem vipThemeItem : vipThemeList.item) {
                this.f68266f.add(new j(vipThemeItem));
            }
        }
        if (vipThemeList.item_card != null) {
            this.f68267g = new ArrayList();
            for (VipThemeItem vipThemeItem2 : vipThemeList.item_card) {
                this.f68267g.add(new j(vipThemeItem2));
            }
        }
    }

    @Override // d.a.c.k.e.n
    public BdUniqueId getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? f68264h : (BdUniqueId) invokeV.objValue;
    }
}
