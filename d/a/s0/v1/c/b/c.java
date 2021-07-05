package d.a.s0.v1.c.b;

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
import java.util.List;
import tbclient.GetVipInfo.VipBasicList;
import tbclient.GetVipInfo.VipSpecialItem;
/* loaded from: classes9.dex */
public class c implements d.a.c.k.e.n {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: i  reason: collision with root package name */
    public static final BdUniqueId f68248i;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public d f68249e;

    /* renamed from: f  reason: collision with root package name */
    public List<VipSpecialItem> f68250f;

    /* renamed from: g  reason: collision with root package name */
    public int f68251g;

    /* renamed from: h  reason: collision with root package name */
    public String f68252h;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1030733800, "Ld/a/s0/v1/c/b/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1030733800, "Ld/a/s0/v1/c/b/c;");
                return;
            }
        }
        f68248i = BdUniqueId.gen();
    }

    public c(VipBasicList vipBasicList) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {vipBasicList};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f68251g = 0;
        this.f68252h = "";
        if (vipBasicList == null || vipBasicList.item.size() <= 0) {
            return;
        }
        this.f68252h = vipBasicList.card_id;
        this.f68251g = vipBasicList.card_type.intValue();
        d dVar = new d();
        this.f68249e = dVar;
        dVar.e(5);
        this.f68249e.d(vipBasicList.class_name);
        this.f68249e.f(vipBasicList.class_url_name);
        this.f68249e.g(vipBasicList.class_url);
        this.f68250f = new ArrayList();
        for (VipSpecialItem vipSpecialItem : vipBasicList.item) {
            this.f68250f.add(vipSpecialItem);
        }
    }

    public List<VipSpecialItem> b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f68250f : (List) invokeV.objValue;
    }

    @Override // d.a.c.k.e.n
    public BdUniqueId getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? f68248i : (BdUniqueId) invokeV.objValue;
    }
}
