package d.a.s0.h1;

import GetSugTopic.TopicList;
import GetSugTopic.TopicListModule;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.e.p.k;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes9.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f60003a;

    /* renamed from: b  reason: collision with root package name */
    public int f60004b;

    /* renamed from: c  reason: collision with root package name */
    public List<d> f60005c;

    public c() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f60004b = -1;
        this.f60005c = new ArrayList();
    }

    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f60003a : (String) invokeV.objValue;
    }

    public List<d> b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f60005c : (List) invokeV.objValue;
    }

    public int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f60004b : invokeV.intValue;
    }

    public void d(TopicListModule topicListModule) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, topicListModule) == null) || topicListModule == null) {
            return;
        }
        this.f60003a = topicListModule.module_title;
        List<TopicList> list = topicListModule.topic_list;
        if (list == null) {
            return;
        }
        int count = ListUtils.getCount(list);
        for (int i2 = 0; i2 < count; i2++) {
            d dVar = new d();
            TopicList topicList = (TopicList) ListUtils.getItem(topicListModule.topic_list, i2);
            if (topicList != null) {
                dVar.c(topicList);
                if (!k.isEmptyStringAfterTrim(dVar.b())) {
                    this.f60005c.add(dVar);
                }
            }
        }
    }

    public void e(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            this.f60003a = str;
        }
    }

    public void f(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i2) == null) {
            this.f60004b = i2;
        }
    }
}
