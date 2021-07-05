package d.a.s0.t0.c;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.k.e.n;
import java.util.ArrayList;
import java.util.List;
import tbclient.SearchPostForum.DataRes;
import tbclient.SearchPostForum.SearchForum;
/* loaded from: classes9.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public SearchForum f65552a;

    /* renamed from: b  reason: collision with root package name */
    public List<SearchForum> f65553b;

    /* renamed from: c  reason: collision with root package name */
    public ArrayList<n> f65554c;

    /* renamed from: d  reason: collision with root package name */
    public String f65555d;

    public c(String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f65555d = str;
    }

    public ArrayList<n> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f65554c : (ArrayList) invokeV.objValue;
    }

    public void b(DataRes dataRes) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, dataRes) == null) || dataRes == null) {
            return;
        }
        this.f65552a = dataRes.exact_match;
        this.f65553b = dataRes.fuzzy_match;
        this.f65554c = new ArrayList<>();
        b bVar = new b(this.f65555d);
        SearchForum searchForum = this.f65552a;
        if (searchForum != null) {
            bVar.q(searchForum);
            this.f65554c.add(bVar);
        }
        List<SearchForum> list = this.f65553b;
        if (list == null) {
            return;
        }
        for (SearchForum searchForum2 : list) {
            if (searchForum2 != null) {
                b bVar2 = new b(this.f65555d);
                bVar2.q(searchForum2);
                this.f65554c.add(bVar2);
            }
        }
    }
}
