package d.a.s0.m2.e;

import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import tbclient.GiftInfo;
import tbclient.User;
/* loaded from: classes9.dex */
public class g extends BaseCardInfo {
    public static /* synthetic */ Interceptable $ic;
    public static final BdUniqueId l;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public boolean f63490e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f63491f;

    /* renamed from: g  reason: collision with root package name */
    public String f63492g;

    /* renamed from: h  reason: collision with root package name */
    public String f63493h;

    /* renamed from: i  reason: collision with root package name */
    public String f63494i;
    public int j;
    public List<d.a.c.k.e.n> k;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1818843291, "Ld/a/s0/m2/e/g;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1818843291, "Ld/a/s0/m2/e/g;");
                return;
            }
        }
        l = BdUniqueId.gen();
    }

    public g() {
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

    public void c(User user) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, user) == null) || user == null || ListUtils.isEmpty(user.gift_list)) {
            return;
        }
        this.f63492g = String.valueOf(user.id);
        this.f63493h = user.name;
        this.f63494i = user.name_show;
        this.j = user.sex.intValue();
        String str = this.f63492g;
        if (str != null && str.equals(TbadkCoreApplication.getCurrentAccount())) {
            this.f63490e = true;
        } else {
            this.f63490e = false;
        }
        if (user.sex.intValue() == 2) {
            this.f63491f = false;
        } else {
            this.f63491f = true;
        }
        Integer num = user.gift_num;
        if (num != null) {
            num.intValue();
        }
        this.k = new ArrayList();
        for (GiftInfo giftInfo : user.gift_list) {
            if (giftInfo != null) {
                o oVar = new o();
                oVar.c(giftInfo);
                this.k.add(oVar);
            }
        }
    }

    @Override // com.baidu.tieba.card.data.BaseCardInfo, d.a.c.k.e.n
    public BdUniqueId getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? l : (BdUniqueId) invokeV.objValue;
    }

    public boolean isValid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? !ListUtils.isEmpty(this.k) : invokeV.booleanValue;
    }
}
