package d.a.q0.l0.l.d;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.d.k.e.n;
import d.a.p0.s.q.b2;
import d.a.p0.s.q.p1;
import d.a.p0.s.q.v1;
import java.util.ArrayList;
import tbclient.GeneralResource;
import tbclient.HotUserRankEntry;
import tbclient.Tabfeedlist.DataRes;
import tbclient.ThreadInfo;
/* loaded from: classes8.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public ArrayList<n> f60391a;

    /* renamed from: b  reason: collision with root package name */
    public ArrayList<v1> f60392b;

    /* renamed from: c  reason: collision with root package name */
    public p1 f60393c;

    /* renamed from: d  reason: collision with root package name */
    public c f60394d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f60395e;

    public a() {
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

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: a */
    public a clone() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            a aVar = new a();
            aVar.f60391a = this.f60391a;
            aVar.f60392b = this.f60392b;
            aVar.f60393c = this.f60393c;
            aVar.f60394d = this.f60394d;
            aVar.f60395e = this.f60395e;
            return aVar;
        }
        return (a) invokeV.objValue;
    }

    public c b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f60394d : (c) invokeV.objValue;
    }

    public p1 c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f60393c : (p1) invokeV.objValue;
    }

    public ArrayList<v1> d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f60392b : (ArrayList) invokeV.objValue;
    }

    public ArrayList<n> e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f60391a : (ArrayList) invokeV.objValue;
    }

    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f60395e : invokeV.booleanValue;
    }

    public void g(DataRes dataRes) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, dataRes) == null) || dataRes == null) {
            return;
        }
        this.f60391a = new ArrayList<>(ListUtils.getCount(dataRes.thread_list));
        for (ThreadInfo threadInfo : dataRes.thread_list) {
            b2 b2Var = new b2();
            b2Var.K2(threadInfo);
            b2Var.A1();
            this.f60391a.add(b2Var);
        }
        this.f60392b = new ArrayList<>();
        if (!ListUtils.isEmpty(dataRes.resource_list)) {
            for (GeneralResource generalResource : dataRes.resource_list) {
                v1 v1Var = new v1();
                v1Var.c(generalResource);
                this.f60392b.add(v1Var);
            }
        }
        p1 p1Var = new p1();
        this.f60393c = p1Var;
        p1Var.h(dataRes.recommend_forum_info);
        if (dataRes.hot_userrank_entry != null) {
            c cVar = new c();
            this.f60394d = cVar;
            HotUserRankEntry hotUserRankEntry = dataRes.hot_userrank_entry;
            cVar.f60404a = hotUserRankEntry.hot_user;
            cVar.f60405b = hotUserRankEntry.module_name;
            cVar.f60406c = hotUserRankEntry.module_icon;
        }
        this.f60395e = dataRes.is_new_url.intValue() == 1;
    }
}
