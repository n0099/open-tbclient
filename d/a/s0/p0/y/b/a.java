package d.a.s0.p0.y.b;

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
import d.a.s0.p0.y.c.b;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes9.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public f f64571a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeListView f64572b;

    /* renamed from: c  reason: collision with root package name */
    public final List<d.a.c.k.e.a> f64573c;

    /* renamed from: d  reason: collision with root package name */
    public EmotionCategoryAdapter f64574d;

    /* renamed from: e  reason: collision with root package name */
    public EmotionHorizontalAdapter f64575e;

    /* renamed from: f  reason: collision with root package name */
    public List<n> f64576f;

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
        this.f64573c = new ArrayList();
        this.f64576f = new ArrayList();
        this.f64571a = tbPageContext;
        this.f64572b = bdTypeListView;
        b();
    }

    public void a(List<n> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, list) == null) || ListUtils.isEmpty(list)) {
            return;
        }
        if (this.f64572b != null) {
            this.f64576f.addAll(list);
            this.f64572b.setData(this.f64576f);
        }
        c();
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f64574d = new EmotionCategoryAdapter((TbPageContext) this.f64571a, d.a.s0.p0.y.c.a.f64577e);
            this.f64575e = new EmotionHorizontalAdapter((TbPageContext) this.f64571a, b.f64578f);
            this.f64573c.add(this.f64574d);
            this.f64573c.add(this.f64575e);
            this.f64572b.a(this.f64573c);
        }
    }

    public void c() {
        BdTypeListView bdTypeListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (bdTypeListView = this.f64572b) == null || bdTypeListView.getAdapter2() == null || !(this.f64572b.getAdapter2() instanceof BaseAdapter)) {
            return;
        }
        this.f64572b.getAdapter2().notifyDataSetChanged();
    }

    public void d(List<n> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, list) == null) || ListUtils.isEmpty(list)) {
            return;
        }
        if (!ListUtils.isEmpty(this.f64576f)) {
            this.f64576f.clear();
        }
        BdTypeListView bdTypeListView = this.f64572b;
        if (bdTypeListView != null) {
            bdTypeListView.setData(list);
            this.f64576f.addAll(list);
        }
        c();
    }

    public void e(EmotionPackageData emotionPackageData) {
        b bVar;
        EmotionPackageData emotionPackageData2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, emotionPackageData) == null) || emotionPackageData == null || ListUtils.isEmpty(this.f64576f)) {
            return;
        }
        for (n nVar : this.f64576f) {
            if ((nVar instanceof b) && (bVar = (b) nVar) != null && (emotionPackageData2 = bVar.f64579e) != null && emotionPackageData2.id == emotionPackageData.id) {
                emotionPackageData2.download = emotionPackageData.download;
                emotionPackageData2.share = emotionPackageData.share;
                c();
                return;
            }
        }
    }
}
