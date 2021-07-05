package d.a.r0.r.q;

import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import tbclient.User;
/* loaded from: classes9.dex */
public class t1 extends a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: i  reason: collision with root package name */
    public static final BdUniqueId f56058i;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public String f56059e;

    /* renamed from: f  reason: collision with root package name */
    public int f56060f;

    /* renamed from: g  reason: collision with root package name */
    public List<MetaData> f56061g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f56062h;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(2131428759, "Ld/a/r0/r/q/t1;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(2131428759, "Ld/a/r0/r/q/t1;");
                return;
            }
        }
        f56058i = BdUniqueId.gen();
    }

    public t1() {
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
        this.f56062h = true;
        this.f56061g = new ArrayList();
    }

    public List<MetaData> c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f56061g : (List) invokeV.objValue;
    }

    public void d(List<User> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) || list == null) {
            return;
        }
        int min = Math.min(list.size(), this.f56062h ? 10 : list.size());
        for (int i2 = 0; i2 < min; i2++) {
            MetaData metaData = new MetaData();
            metaData.parserProtobuf(list.get(i2));
            this.f56061g.add(metaData);
        }
    }

    @Override // d.a.r0.r.q.a
    public w0 getNegFeedBackData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? new w0() : (w0) invokeV.objValue;
    }

    @Override // d.a.r0.r.q.a
    public b2 getThreadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return null;
        }
        return (b2) invokeV.objValue;
    }

    @Override // com.baidu.tieba.card.data.BaseCardInfo, d.a.c.k.e.n
    public BdUniqueId getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? f56058i : (BdUniqueId) invokeV.objValue;
    }
}
