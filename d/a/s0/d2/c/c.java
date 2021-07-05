package d.a.s0.d2.c;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import tbclient.ClassForumInfo;
import tbclient.GetVerticalForumList.DataRes;
import tbclient.Page;
import tbclient.RecommendForumInfo;
/* loaded from: classes9.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public List<a> f58170a;

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
            }
        }
    }

    public void a(DataRes dataRes) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, dataRes) == null) || dataRes == null) {
            return;
        }
        if (dataRes.class_foruminfo != null) {
            this.f58170a = new ArrayList();
            for (ClassForumInfo classForumInfo : dataRes.class_foruminfo) {
                a aVar = new a();
                aVar.f58163b = classForumInfo.class_id;
                aVar.f58164c = classForumInfo.class_name;
                ArrayList arrayList = new ArrayList();
                for (RecommendForumInfo recommendForumInfo : classForumInfo.forum_info) {
                    arrayList.add(new d(recommendForumInfo, false));
                }
                aVar.f58162a = arrayList;
                this.f58170a.add(aVar);
            }
        }
        Page page = dataRes.page;
    }
}
