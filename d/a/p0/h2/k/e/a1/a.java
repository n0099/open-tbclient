package d.a.p0.h2.k.e.a1;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.pb.main.PbFragment;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes8.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public PbFragment f57056a;

    /* renamed from: b  reason: collision with root package name */
    public d.a.p0.h2.i.c f57057b;

    /* renamed from: c  reason: collision with root package name */
    public View f57058c;

    /* renamed from: d  reason: collision with root package name */
    public View f57059d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f57060e;

    /* renamed from: f  reason: collision with root package name */
    public View f57061f;

    /* renamed from: g  reason: collision with root package name */
    public View f57062g;

    /* renamed from: h  reason: collision with root package name */
    public View f57063h;

    /* renamed from: i  reason: collision with root package name */
    public Button f57064i;

    /* renamed from: d.a.p0.h2.k.e.a1.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class View$OnLongClickListenerC1411a implements View.OnLongClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public View$OnLongClickListenerC1411a(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, view)) == null) {
                return false;
            }
            return invokeL.booleanValue;
        }
    }

    public a(PbFragment pbFragment, d.a.p0.h2.i.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {pbFragment, cVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f57058c = null;
        this.f57059d = null;
        this.f57060e = null;
        this.f57061f = null;
        this.f57062g = null;
        this.f57063h = null;
        this.f57064i = null;
        this.f57056a = pbFragment;
        this.f57057b = cVar;
        d();
    }

    public void a(BdTypeListView bdTypeListView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bdTypeListView) == null) {
            bdTypeListView.addHeaderView(this.f57058c);
        }
    }

    public boolean b(boolean z) {
        InterceptResult invokeZ;
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z)) == null) {
            Button button = this.f57064i;
            if (button != null && button.getVisibility() == 0) {
                View view = this.f57061f;
                if (view != null) {
                    view.setVisibility(0);
                }
                z2 = true;
            } else {
                View view2 = this.f57061f;
                if (view2 != null) {
                    view2.setVisibility(8);
                }
                z2 = false;
            }
            View view3 = this.f57063h;
            if ((view3 == null || view3.getVisibility() == 8) && z2 && z) {
                this.f57062g.setVisibility(0);
            } else {
                this.f57062g.setVisibility(8);
            }
            return z2;
        }
        return invokeZ.booleanValue;
    }

    public View c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f57058c : (View) invokeV.objValue;
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            View inflate = LayoutInflater.from(this.f57056a.getPageContext().getPageActivity()).inflate(R.layout.new_pb_header_item, (ViewGroup) null);
            this.f57058c = inflate;
            inflate.setOnTouchListener(this.f57057b);
            View findViewById = this.f57058c.findViewById(R.id.pb_head_activity_join_number_container);
            this.f57059d = findViewById;
            findViewById.setVisibility(8);
            this.f57060e = (TextView) this.f57058c.findViewById(R.id.pb_head_activity_join_number);
            this.f57061f = this.f57058c.findViewById(R.id.new_pb_header_item_line_above_livepost);
            this.f57062g = this.f57058c.findViewById(R.id.new_pb_header_item_line_below_livepost);
            this.f57058c.setOnLongClickListener(new View$OnLongClickListenerC1411a(this));
        }
    }

    public void e(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
            this.f57056a.getBaseFragmentActivity().getLayoutMode().j(this.f57058c);
        }
    }

    public void f(BdTypeListView bdTypeListView) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, bdTypeListView) == null) || bdTypeListView == null) {
            return;
        }
        bdTypeListView.removeHeaderView(this.f57058c);
    }

    public void g(d.a.p0.h2.h.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, eVar) == null) {
            ArrayList<d.a.o0.r.q.b> o = eVar.N().o();
            if (o != null && o.size() > 0) {
                this.f57060e.setText(String.valueOf(o.get(0).f()));
                this.f57059d.setVisibility(0);
            } else {
                this.f57059d.setVisibility(8);
            }
            SkinManager.setBackgroundResource(this.f57059d, R.drawable.activity_join_num_bg);
            SkinManager.setViewTextColor(this.f57060e, R.color.CAM_X0305, 1);
        }
    }

    public void h(d.a.p0.h2.h.e eVar, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048583, this, eVar, z) == null) {
            boolean b2 = b(z);
            if (eVar == null || eVar.x() == null || eVar.x().c() != 0 || !z) {
                this.f57062g.setVisibility(8);
            } else if (b2) {
                this.f57062g.setVisibility(0);
            } else {
                this.f57062g.setVisibility(8);
            }
        }
    }
}
