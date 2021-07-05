package d.a.s0.g1.c;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import tbclient.TopicList.TopicList;
import tbclient.TopicList.TopicListModule;
/* loaded from: classes9.dex */
public class b implements d.a.c.k.e.n {
    public static /* synthetic */ Interceptable $ic;
    public static final BdUniqueId j;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public String f59655e;

    /* renamed from: f  reason: collision with root package name */
    public long f59656f;

    /* renamed from: g  reason: collision with root package name */
    public String f59657g;

    /* renamed from: h  reason: collision with root package name */
    public String f59658h;

    /* renamed from: i  reason: collision with root package name */
    public String f59659i;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(760099613, "Ld/a/s0/g1/c/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(760099613, "Ld/a/s0/g1/c/b;");
                return;
            }
        }
        j = BdUniqueId.gen();
    }

    public b() {
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

    public long b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f59656f : invokeV.longValue;
    }

    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f59655e : (String) invokeV.objValue;
    }

    public String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f59657g : (String) invokeV.objValue;
    }

    public String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f59658h : (String) invokeV.objValue;
    }

    @Override // d.a.c.k.e.n
    public BdUniqueId getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? j : (BdUniqueId) invokeV.objValue;
    }

    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f59659i : (String) invokeV.objValue;
    }

    public void i(TopicList topicList) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, topicList) == null) || topicList == null) {
            return;
        }
        this.f59656f = topicList.topic_id.longValue();
        this.f59657g = topicList.topic_name;
        topicList.tag.intValue();
        topicList.discuss_num.longValue();
        this.f59658h = topicList.topic_desc;
        this.f59659i = topicList.topic_pic;
    }

    public void j(TopicListModule topicListModule) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, topicListModule) == null) {
            try {
                this.f59655e = topicListModule.module_title;
                String str = topicListModule.tips;
                String str2 = topicListModule.rule_jump_url;
            } catch (Exception e2) {
                BdLog.e(e2.toString());
            }
        }
    }
}
