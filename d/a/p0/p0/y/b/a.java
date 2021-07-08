package d.a.p0.p0.y.b;

import android.widget.BaseAdapter;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.faceshop.EmotionPackageData;
import com.baidu.tieba.faceshop.emotioncenter.adapter.EmotionCategoryAdapter;
import com.baidu.tieba.faceshop.emotioncenter.adapter.EmotionHorizontalAdapter;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.a.f;
import d.a.c.k.e.n;
import d.a.p0.p0.y.c.b;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public f f61337a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeListView f61338b;

    /* renamed from: c  reason: collision with root package name */
    public final List<d.a.c.k.e.a> f61339c;

    /* renamed from: d  reason: collision with root package name */
    public EmotionCategoryAdapter f61340d;

    /* renamed from: e  reason: collision with root package name */
    public EmotionHorizontalAdapter f61341e;

    /* renamed from: f  reason: collision with root package name */
    public List<n> f61342f;

    public a(TbPageContext<?> tbPageContext, BdTypeListView bdTypeListView) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bdTypeListView};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f61339c = new ArrayList();
        this.f61342f = new ArrayList();
        this.f61337a = tbPageContext;
        this.f61338b = bdTypeListView;
        b();
    }

    public void a(List<n> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, list) == null) || ListUtils.isEmpty(list)) {
            return;
        }
        if (this.f61338b != null) {
            this.f61342f.addAll(list);
            this.f61338b.setData(this.f61342f);
        }
        c();
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f61340d = new EmotionCategoryAdapter((TbPageContext) this.f61337a, d.a.p0.p0.y.c.a.f61343e);
            this.f61341e = new EmotionHorizontalAdapter((TbPageContext) this.f61337a, b.f61344f);
            this.f61339c.add(this.f61340d);
            this.f61339c.add(this.f61341e);
            this.f61338b.a(this.f61339c);
        }
    }

    public void c() {
        BdTypeListView bdTypeListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (bdTypeListView = this.f61338b) == null || bdTypeListView.getAdapter2() == null || !(this.f61338b.getAdapter2() instanceof BaseAdapter)) {
            return;
        }
        this.f61338b.getAdapter2().notifyDataSetChanged();
    }

    public void d(List<n> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, list) == null) || ListUtils.isEmpty(list)) {
            return;
        }
        if (!ListUtils.isEmpty(this.f61342f)) {
            this.f61342f.clear();
        }
        BdTypeListView bdTypeListView = this.f61338b;
        if (bdTypeListView != null) {
            bdTypeListView.setData(list);
            this.f61342f.addAll(list);
        }
        c();
    }

    public void e(EmotionPackageData emotionPackageData) {
        b bVar;
        EmotionPackageData emotionPackageData2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, emotionPackageData) == null) || emotionPackageData == null || ListUtils.isEmpty(this.f61342f)) {
            return;
        }
        for (n nVar : this.f61342f) {
            if ((nVar instanceof b) && (bVar = (b) nVar) != null && (emotionPackageData2 = bVar.f61345e) != null && emotionPackageData2.id == emotionPackageData.id) {
                emotionPackageData2.download = emotionPackageData.download;
                emotionPackageData2.share = emotionPackageData.share;
                c();
                return;
            }
        }
    }
}
