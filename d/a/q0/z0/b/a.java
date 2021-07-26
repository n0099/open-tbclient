package d.a.q0.z0.b;

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
import d.a.d.k.e.e;
import d.a.q0.a0.f0.d;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public d f67180a;

    /* renamed from: b  reason: collision with root package name */
    public GodSquareRecGodAdapter f67181b;

    /* renamed from: c  reason: collision with root package name */
    public GodSquareHotGodAdapter f67182c;

    /* renamed from: d  reason: collision with root package name */
    public List<d.a.d.k.e.a> f67183d;

    /* renamed from: e  reason: collision with root package name */
    public BdTypeListView f67184e;

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
        this.f67183d = new ArrayList();
        this.f67184e = bdTypeListView;
        this.f67180a = new d(tbPageContext);
        this.f67181b = new GodSquareRecGodAdapter(tbPageContext);
        this.f67182c = new GodSquareHotGodAdapter(tbPageContext);
        this.f67183d.add(this.f67180a);
        this.f67183d.add(this.f67181b);
        this.f67183d.add(this.f67182c);
    }

    public List<d.a.d.k.e.a> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f67183d : (List) invokeV.objValue;
    }

    public void b() {
        BdTypeListView bdTypeListView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (bdTypeListView = this.f67184e) != null && (bdTypeListView.getAdapter2() instanceof e)) {
            this.f67184e.getAdapter2().notifyDataSetChanged();
        }
    }
}
