package d.a.q0.e3.f;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.d.k.e.n;
import java.util.ArrayList;
import java.util.List;
import tbclient.Page;
import tbclient.RecommendForumInfo;
/* loaded from: classes8.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public List<n> f56489a;

    /* renamed from: b  reason: collision with root package name */
    public List<RecommendForumInfo> f56490b;

    /* renamed from: c  reason: collision with root package name */
    public Page f56491c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f56492d;

    /* renamed from: e  reason: collision with root package name */
    public int f56493e;

    /* renamed from: f  reason: collision with root package name */
    public int f56494f;

    /* renamed from: g  reason: collision with root package name */
    public int f56495g;

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
        this.f56489a = new ArrayList();
        this.f56492d = true;
        this.f56493e = 0;
        this.f56494f = 0;
        this.f56495g = 0;
    }

    public List<n> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f56489a : (List) invokeV.objValue;
    }

    public void b(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, dVar) == null) {
            String str = dVar.f56499d;
            this.f56491c = dVar.f56498c;
            List<RecommendForumInfo> list = dVar.f56496a;
            this.f56490b = list;
            if (!ListUtils.isEmpty(list)) {
                for (RecommendForumInfo recommendForumInfo : this.f56490b) {
                    b bVar = new b();
                    bVar.p(recommendForumInfo);
                    this.f56489a.add(bVar);
                }
            }
            Page page = this.f56491c;
            if (page != null) {
                this.f56492d = page.has_more.intValue() == 1;
                this.f56493e = this.f56491c.current_page.intValue();
            }
        }
    }
}
