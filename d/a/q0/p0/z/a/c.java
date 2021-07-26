package d.a.q0.p0.z.a;

import android.widget.BaseAdapter;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.faceshop.forumpackage.data.ForumEmotionPackageData;
import com.baidu.tieba.faceshop.forumpackage.model.ForumEmotionModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.d.k.e.n;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f61974a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeListView f61975b;

    /* renamed from: c  reason: collision with root package name */
    public final List<d.a.d.k.e.a> f61976c;

    /* renamed from: d  reason: collision with root package name */
    public b f61977d;

    /* renamed from: e  reason: collision with root package name */
    public d f61978e;

    /* renamed from: f  reason: collision with root package name */
    public final List<n> f61979f;

    public c(TbPageContext<?> tbPageContext, BdTypeListView bdTypeListView, ForumEmotionModel forumEmotionModel) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bdTypeListView, forumEmotionModel};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f61976c = new ArrayList();
        this.f61979f = new ArrayList();
        this.f61974a = tbPageContext;
        this.f61975b = bdTypeListView;
        c(forumEmotionModel);
    }

    public void a(List<n> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, list) == null) || ListUtils.isEmpty(list)) {
            return;
        }
        if (this.f61975b != null) {
            this.f61979f.addAll(list);
            this.f61975b.setData(this.f61979f);
        }
        d();
    }

    public int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f61979f.size() : invokeV.intValue;
    }

    public final void c(ForumEmotionModel forumEmotionModel) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, forumEmotionModel) == null) {
            b bVar = new b(this.f61974a, forumEmotionModel.y(), d.a.q0.p0.z.b.c.f61983f);
            this.f61977d = bVar;
            this.f61976c.add(bVar);
            d dVar = new d(this.f61974a, forumEmotionModel.y(), d.a.q0.p0.z.b.a.f61980e);
            this.f61978e = dVar;
            this.f61976c.add(dVar);
            this.f61975b.a(this.f61976c);
        }
    }

    public void d() {
        BdTypeListView bdTypeListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (bdTypeListView = this.f61975b) == null || bdTypeListView.getAdapter2() == null || !(this.f61975b.getAdapter2() instanceof BaseAdapter)) {
            return;
        }
        this.f61975b.getAdapter2().notifyDataSetChanged();
    }

    public void e(List<n> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, list) == null) || ListUtils.isEmpty(list)) {
            return;
        }
        if (!ListUtils.isEmpty(this.f61979f)) {
            this.f61979f.clear();
        }
        BdTypeListView bdTypeListView = this.f61975b;
        if (bdTypeListView != null) {
            bdTypeListView.setData(list);
            this.f61979f.addAll(list);
        }
        d();
    }

    public void f(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, aVar) == null) {
            this.f61977d.g0(aVar);
            this.f61978e.g0(aVar);
        }
    }

    public void g(ForumEmotionPackageData forumEmotionPackageData) {
        ForumEmotionPackageData forumEmotionPackageData2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, forumEmotionPackageData) == null) || forumEmotionPackageData == null || ListUtils.isEmpty(this.f61979f)) {
            return;
        }
        for (n nVar : this.f61979f) {
            if (nVar != null && (nVar instanceof d.a.q0.p0.z.b.c) && (forumEmotionPackageData2 = ((d.a.q0.p0.z.b.c) nVar).f61984e) != null && forumEmotionPackageData2.id == forumEmotionPackageData.id) {
                forumEmotionPackageData2.download = forumEmotionPackageData.download;
                forumEmotionPackageData2.share = forumEmotionPackageData.share;
                d();
                return;
            }
        }
    }
}
