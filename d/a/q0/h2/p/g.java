package d.a.q0.h2.p;

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
/* loaded from: classes8.dex */
public class g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public LinearLayout f58472a;

    /* renamed from: b  reason: collision with root package name */
    public EMTextView f58473b;

    /* renamed from: c  reason: collision with root package name */
    public BdTypeRecyclerView f58474c;

    /* renamed from: d  reason: collision with root package name */
    public View f58475d;

    /* renamed from: e  reason: collision with root package name */
    public d.a.q0.h2.k.c.b f58476e;

    /* renamed from: f  reason: collision with root package name */
    public d.a.q0.h2.k.e.b1.h f58477f;

    public g(d.a.q0.h2.o.b bVar, BdUniqueId bdUniqueId) {
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
        d.a.q0.h2.k.c.b bVar2 = new d.a.q0.h2.k.c.b(bVar, bdUniqueId, this.f58474c);
        this.f58476e = bVar2;
        this.f58477f = new d.a.q0.h2.k.e.b1.h(this.f58474c, bVar2);
        c();
    }

    public View a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f58472a : (View) invokeV.objValue;
    }

    public final void b(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context) == null) {
            LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(context).inflate(R.layout.recom_thread_info_layout, (ViewGroup) null);
            this.f58472a = linearLayout;
            this.f58473b = (EMTextView) linearLayout.findViewById(R.id.tv_title);
            BdTypeRecyclerView bdTypeRecyclerView = (BdTypeRecyclerView) this.f58472a.findViewById(R.id.pb_recom_info_list);
            this.f58474c = bdTypeRecyclerView;
            bdTypeRecyclerView.setLayoutManager(new LinearLayoutManager(context));
            this.f58474c.setFadingEdgeLength(0);
            this.f58474c.setOverScrollMode(2);
            int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.M_W_X004);
            this.f58474c.setPadding(dimenPixelSize, 0, dimenPixelSize, 0);
            this.f58474c.setNestedScrollingEnabled(false);
            this.f58475d = new View(context);
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            SkinManager.setBackgroundColor(this.f58472a, R.color.CAM_X0204);
            SkinManager.setViewTextColor(this.f58473b, R.color.CAM_X0105);
            this.f58476e.e();
        }
    }

    public void d(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            this.f58474c.y(this.f58475d);
            this.f58475d.setLayoutParams(new ViewGroup.LayoutParams(1, i2));
            this.f58474c.r(this.f58475d);
        }
    }

    public void e(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            this.f58474c.setNestedScrollingEnabled(z);
        }
    }

    public void f(d.a.q0.h2.h.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, eVar) == null) {
            this.f58477f.k(eVar);
        }
    }
}
