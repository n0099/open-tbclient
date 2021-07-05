package d.a.s0.z0.b;

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
import d.a.s0.a0.f0.d;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes9.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public d f69699a;

    /* renamed from: b  reason: collision with root package name */
    public GodSquareRecGodAdapter f69700b;

    /* renamed from: c  reason: collision with root package name */
    public GodSquareHotGodAdapter f69701c;

    /* renamed from: d  reason: collision with root package name */
    public List<d.a.c.k.e.a> f69702d;

    /* renamed from: e  reason: collision with root package name */
    public BdTypeListView f69703e;

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
        this.f69702d = new ArrayList();
        this.f69703e = bdTypeListView;
        this.f69699a = new d(tbPageContext);
        this.f69700b = new GodSquareRecGodAdapter(tbPageContext);
        this.f69701c = new GodSquareHotGodAdapter(tbPageContext);
        this.f69702d.add(this.f69699a);
        this.f69702d.add(this.f69700b);
        this.f69702d.add(this.f69701c);
    }

    public List<d.a.c.k.e.a> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f69702d : (List) invokeV.objValue;
    }

    public void b() {
        BdTypeListView bdTypeListView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (bdTypeListView = this.f69703e) != null && (bdTypeListView.getAdapter2() instanceof e)) {
            this.f69703e.getAdapter2().notifyDataSetChanged();
        }
    }
}
