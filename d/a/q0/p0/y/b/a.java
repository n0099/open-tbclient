package d.a.q0.p0.y.b;

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
import d.a.d.a.f;
import d.a.d.k.e.n;
import d.a.q0.p0.y.c.b;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public f f61951a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeListView f61952b;

    /* renamed from: c  reason: collision with root package name */
    public final List<d.a.d.k.e.a> f61953c;

    /* renamed from: d  reason: collision with root package name */
    public EmotionCategoryAdapter f61954d;

    /* renamed from: e  reason: collision with root package name */
    public EmotionHorizontalAdapter f61955e;

    /* renamed from: f  reason: collision with root package name */
    public List<n> f61956f;

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
        this.f61953c = new ArrayList();
        this.f61956f = new ArrayList();
        this.f61951a = tbPageContext;
        this.f61952b = bdTypeListView;
        b();
    }

    public void a(List<n> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, list) == null) || ListUtils.isEmpty(list)) {
            return;
        }
        if (this.f61952b != null) {
            this.f61956f.addAll(list);
            this.f61952b.setData(this.f61956f);
        }
        c();
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f61954d = new EmotionCategoryAdapter((TbPageContext) this.f61951a, d.a.q0.p0.y.c.a.f61957e);
            this.f61955e = new EmotionHorizontalAdapter((TbPageContext) this.f61951a, b.f61958f);
            this.f61953c.add(this.f61954d);
            this.f61953c.add(this.f61955e);
            this.f61952b.a(this.f61953c);
        }
    }

    public void c() {
        BdTypeListView bdTypeListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (bdTypeListView = this.f61952b) == null || bdTypeListView.getAdapter2() == null || !(this.f61952b.getAdapter2() instanceof BaseAdapter)) {
            return;
        }
        this.f61952b.getAdapter2().notifyDataSetChanged();
    }

    public void d(List<n> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, list) == null) || ListUtils.isEmpty(list)) {
            return;
        }
        if (!ListUtils.isEmpty(this.f61956f)) {
            this.f61956f.clear();
        }
        BdTypeListView bdTypeListView = this.f61952b;
        if (bdTypeListView != null) {
            bdTypeListView.setData(list);
            this.f61956f.addAll(list);
        }
        c();
    }

    public void e(EmotionPackageData emotionPackageData) {
        b bVar;
        EmotionPackageData emotionPackageData2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, emotionPackageData) == null) || emotionPackageData == null || ListUtils.isEmpty(this.f61956f)) {
            return;
        }
        for (n nVar : this.f61956f) {
            if ((nVar instanceof b) && (bVar = (b) nVar) != null && (emotionPackageData2 = bVar.f61959e) != null && emotionPackageData2.id == emotionPackageData.id) {
                emotionPackageData2.download = emotionPackageData.download;
                emotionPackageData2.share = emotionPackageData.share;
                c();
                return;
            }
        }
    }
}
