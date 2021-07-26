package d.a.q0.u0;

import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.data.FeatureCardGod;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import tbclient.FrsPageUserExtend;
import tbclient.User;
/* loaded from: classes8.dex */
public class w implements d.a.d.k.e.n {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: i  reason: collision with root package name */
    public static final BdUniqueId f64591i;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public int f64592e;

    /* renamed from: f  reason: collision with root package name */
    public List<MetaData> f64593f;

    /* renamed from: g  reason: collision with root package name */
    public String f64594g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f64595h;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(183932269, "Ld/a/q0/u0/w;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(183932269, "Ld/a/q0/u0/w;");
                return;
            }
        }
        f64591i = BdUniqueId.gen();
    }

    public w() {
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
        this.f64592e = 0;
        this.f64594g = "本吧都在关注";
        this.f64595h = false;
    }

    public int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f64592e : invokeV.intValue;
    }

    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f64594g : (String) invokeV.objValue;
    }

    public List<MetaData> d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f64593f : (List) invokeV.objValue;
    }

    public boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f64595h : invokeV.booleanValue;
    }

    @Override // d.a.d.k.e.n
    public BdUniqueId getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? f64591i : (BdUniqueId) invokeV.objValue;
    }

    public void h(FeatureCardGod featureCardGod) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, featureCardGod) == null) || featureCardGod == null || ListUtils.isEmpty(featureCardGod.sub_nodes)) {
            return;
        }
        this.f64592e = featureCardGod.floor.intValue();
        this.f64593f = featureCardGod.sub_nodes;
        this.f64594g = featureCardGod.title;
    }

    public void i(FrsPageUserExtend frsPageUserExtend) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, frsPageUserExtend) == null) || frsPageUserExtend == null || ListUtils.isEmpty(frsPageUserExtend.data)) {
            return;
        }
        List<User> list = frsPageUserExtend.data;
        this.f64592e = frsPageUserExtend.user_extend_storey.intValue();
        this.f64593f = new ArrayList(list.size());
        for (int i2 = 0; i2 < list.size(); i2++) {
            User user = list.get(i2);
            if (user != null && user.id.longValue() != 0) {
                MetaData metaData = new MetaData();
                metaData.parserProtobuf(list.get(i2));
                this.f64593f.add(metaData);
            }
        }
        this.f64594g = frsPageUserExtend.tips;
    }

    public void j(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            this.f64595h = z;
        }
    }
}
