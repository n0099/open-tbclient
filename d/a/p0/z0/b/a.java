package d.a.p0.z0.b;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.godSquare.adapter.GodSquareHotGodAdapter;
import com.baidu.tieba.godSquare.adapter.GodSquareRecGodAdapter;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.k.e.e;
import d.a.p0.a0.f0.d;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public d f66502a;

    /* renamed from: b  reason: collision with root package name */
    public GodSquareRecGodAdapter f66503b;

    /* renamed from: c  reason: collision with root package name */
    public GodSquareHotGodAdapter f66504c;

    /* renamed from: d  reason: collision with root package name */
    public List<d.a.c.k.e.a> f66505d;

    /* renamed from: e  reason: collision with root package name */
    public BdTypeListView f66506e;

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
        this.f66505d = new ArrayList();
        this.f66506e = bdTypeListView;
        this.f66502a = new d(tbPageContext);
        this.f66503b = new GodSquareRecGodAdapter(tbPageContext);
        this.f66504c = new GodSquareHotGodAdapter(tbPageContext);
        this.f66505d.add(this.f66502a);
        this.f66505d.add(this.f66503b);
        this.f66505d.add(this.f66504c);
    }

    public List<d.a.c.k.e.a> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f66505d : (List) invokeV.objValue;
    }

    public void b() {
        BdTypeListView bdTypeListView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (bdTypeListView = this.f66506e) != null && (bdTypeListView.getAdapter2() instanceof e)) {
            this.f66506e.getAdapter2().notifyDataSetChanged();
        }
    }
}
