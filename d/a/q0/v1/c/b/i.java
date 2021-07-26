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
import tbclient.GetVipInfo.VipThemeItem;
import tbclient.GetVipInfo.VipThemeList;
/* loaded from: classes8.dex */
public class i implements d.a.d.k.e.n {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: h  reason: collision with root package name */
    public static final BdUniqueId f65694h;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public d f65695e;

    /* renamed from: f  reason: collision with root package name */
    public List<j> f65696f;

    /* renamed from: g  reason: collision with root package name */
    public List<j> f65697g;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1288899052, "Ld/a/q0/v1/c/b/i;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1288899052, "Ld/a/q0/v1/c/b/i;");
                return;
            }
        }
        f65694h = BdUniqueId.gen();
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
        this.f65695e = dVar;
        dVar.e(2);
        this.f65695e.d(vipThemeList.class_name);
        this.f65695e.f(vipThemeList.class_url_name);
        this.f65695e.g(vipThemeList.class_url);
        if (vipThemeList.item != null) {
            this.f65696f = new ArrayList();
            for (VipThemeItem vipThemeItem : vipThemeList.item) {
                this.f65696f.add(new j(vipThemeItem));
            }
        }
        if (vipThemeList.item_card != null) {
            this.f65697g = new ArrayList();
            for (VipThemeItem vipThemeItem2 : vipThemeList.item_card) {
                this.f65697g.add(new j(vipThemeItem2));
            }
        }
    }

    @Override // d.a.d.k.e.n
    public BdUniqueId getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? f65694h : (BdUniqueId) invokeV.objValue;
    }
}
