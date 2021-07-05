package d.a.s0.h2.p;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public class g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public LinearLayout f61141a;

    /* renamed from: b  reason: collision with root package name */
    public EMTextView f61142b;

    /* renamed from: c  reason: collision with root package name */
    public BdTypeRecyclerView f61143c;

    /* renamed from: d  reason: collision with root package name */
    public View f61144d;

    /* renamed from: e  reason: collision with root package name */
    public d.a.s0.h2.k.c.b f61145e;

    /* renamed from: f  reason: collision with root package name */
    public d.a.s0.h2.k.e.a1.g f61146f;

    public g(d.a.s0.h2.o.b bVar, BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bVar, bdUniqueId};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        b(bVar.z());
        d.a.s0.h2.k.c.b bVar2 = new d.a.s0.h2.k.c.b(bVar, bdUniqueId, this.f61143c);
        this.f61145e = bVar2;
        this.f61146f = new d.a.s0.h2.k.e.a1.g(this.f61143c, bVar2);
        c();
    }

    public View a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f61141a : (View) invokeV.objValue;
    }

    public final void b(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context) == null) {
            LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(context).inflate(R.layout.recom_thread_info_layout, (ViewGroup) null);
            this.f61141a = linearLayout;
            this.f61142b = (EMTextView) linearLayout.findViewById(R.id.tv_title);
            BdTypeRecyclerView bdTypeRecyclerView = (BdTypeRecyclerView) this.f61141a.findViewById(R.id.pb_recom_info_list);
            this.f61143c = bdTypeRecyclerView;
            bdTypeRecyclerView.setLayoutManager(new LinearLayoutManager(context));
            this.f61143c.setFadingEdgeLength(0);
            this.f61143c.setOverScrollMode(2);
            int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.M_W_X004);
            this.f61143c.setPadding(dimenPixelSize, 0, dimenPixelSize, 0);
            this.f61143c.setNestedScrollingEnabled(false);
            this.f61144d = new View(context);
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            SkinManager.setBackgroundColor(this.f61141a, R.color.CAM_X0204);
            SkinManager.setViewTextColor(this.f61142b, R.color.CAM_X0105);
            this.f61145e.e();
        }
    }

    public void d(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            this.f61143c.y(this.f61144d);
            this.f61144d.setLayoutParams(new ViewGroup.LayoutParams(1, i2));
            this.f61143c.r(this.f61144d);
        }
    }

    public void e(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            this.f61143c.setNestedScrollingEnabled(z);
        }
    }

    public void f(d.a.s0.h2.h.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, eVar) == null) {
            this.f61146f.k(eVar);
        }
    }
}
