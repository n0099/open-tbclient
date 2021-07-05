package d.a.s0.u0.p1.d;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.r0.r.u.c;
/* loaded from: classes9.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Context f66740a;

    /* renamed from: b  reason: collision with root package name */
    public View f66741b;

    /* renamed from: c  reason: collision with root package name */
    public EMTextView f66742c;

    public b(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f66740a = context;
        b(context);
    }

    public void a(BdTypeRecyclerView bdTypeRecyclerView) {
        View view;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, bdTypeRecyclerView) == null) || bdTypeRecyclerView == null || (view = this.f66741b) == null) {
            return;
        }
        view.setVisibility(0);
        bdTypeRecyclerView.s(this.f66741b);
    }

    public final void b(Context context) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context) == null) && this.f66741b == null) {
            View inflate = LayoutInflater.from(context).inflate(R.layout.forum_rules_title_area, (ViewGroup) null);
            this.f66741b = inflate;
            this.f66742c = (EMTextView) inflate.findViewById(R.id.forum_rules_title);
            c(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void c(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
            c d2 = c.d(this.f66742c);
            d2.y(R.string.F_X02);
            d2.t(R.color.CAM_X0105);
        }
    }

    public void d(BdTypeRecyclerView bdTypeRecyclerView) {
        View view;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, bdTypeRecyclerView) == null) || bdTypeRecyclerView == null || (view = this.f66741b) == null) {
            return;
        }
        view.setVisibility(8);
        bdTypeRecyclerView.removeHeaderView(this.f66741b);
    }

    public void e(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            this.f66742c.setText(str);
        }
    }
}
