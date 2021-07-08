package d.a.p0.e3.f;

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
/* loaded from: classes8.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public List<n> f55945a;

    /* renamed from: b  reason: collision with root package name */
    public List<RecommendForumInfo> f55946b;

    /* renamed from: c  reason: collision with root package name */
    public Page f55947c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f55948d;

    /* renamed from: e  reason: collision with root package name */
    public int f55949e;

    /* renamed from: f  reason: collision with root package name */
    public int f55950f;

    /* renamed from: g  reason: collision with root package name */
    public int f55951g;

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
        this.f55945a = new ArrayList();
        this.f55948d = true;
        this.f55949e = 0;
        this.f55950f = 0;
        this.f55951g = 0;
    }

    public List<n> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f55945a : (List) invokeV.objValue;
    }

    public void b(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, dVar) == null) {
            String str = dVar.f55955d;
            this.f55947c = dVar.f55954c;
            List<RecommendForumInfo> list = dVar.f55952a;
            this.f55946b = list;
            if (!ListUtils.isEmpty(list)) {
                for (RecommendForumInfo recommendForumInfo : this.f55946b) {
                    b bVar = new b();
                    bVar.p(recommendForumInfo);
                    this.f55945a.add(bVar);
                }
            }
            Page page = this.f55947c;
            if (page != null) {
                this.f55948d = page.has_more.intValue() == 1;
                this.f55949e = this.f55947c.current_page.intValue();
            }
        }
    }
}
