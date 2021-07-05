package d.a.s0.e3.f;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.k.e.n;
import java.util.ArrayList;
import java.util.List;
import tbclient.Page;
import tbclient.RecommendForumInfo;
/* loaded from: classes9.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public List<n> f59200a;

    /* renamed from: b  reason: collision with root package name */
    public List<RecommendForumInfo> f59201b;

    /* renamed from: c  reason: collision with root package name */
    public Page f59202c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f59203d;

    /* renamed from: e  reason: collision with root package name */
    public int f59204e;

    /* renamed from: f  reason: collision with root package name */
    public int f59205f;

    /* renamed from: g  reason: collision with root package name */
    public int f59206g;

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
        this.f59200a = new ArrayList();
        this.f59203d = true;
        this.f59204e = 0;
        this.f59205f = 0;
        this.f59206g = 0;
    }

    public List<n> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f59200a : (List) invokeV.objValue;
    }

    public void b(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, dVar) == null) {
            String str = dVar.f59210d;
            this.f59202c = dVar.f59209c;
            List<RecommendForumInfo> list = dVar.f59207a;
            this.f59201b = list;
            if (!ListUtils.isEmpty(list)) {
                for (RecommendForumInfo recommendForumInfo : this.f59201b) {
                    b bVar = new b();
                    bVar.p(recommendForumInfo);
                    this.f59200a.add(bVar);
                }
            }
            Page page = this.f59202c;
            if (page != null) {
                this.f59203d = page.has_more.intValue() == 1;
                this.f59204e = this.f59202c.current_page.intValue();
            }
        }
    }
}
