package d.a.q0.h2.k.e.b1;

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
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public PbFragment f57636a;

    /* renamed from: b  reason: collision with root package name */
    public d.a.q0.h2.i.c f57637b;

    /* renamed from: c  reason: collision with root package name */
    public View f57638c;

    /* renamed from: d  reason: collision with root package name */
    public View f57639d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f57640e;

    /* renamed from: f  reason: collision with root package name */
    public View f57641f;

    /* renamed from: g  reason: collision with root package name */
    public View f57642g;

    /* renamed from: h  reason: collision with root package name */
    public View f57643h;

    /* renamed from: i  reason: collision with root package name */
    public Button f57644i;

    /* loaded from: classes8.dex */
    public class a implements View.OnLongClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
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

    public b(PbFragment pbFragment, d.a.q0.h2.i.c cVar) {
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
        this.f57638c = null;
        this.f57639d = null;
        this.f57640e = null;
        this.f57641f = null;
        this.f57642g = null;
        this.f57643h = null;
        this.f57644i = null;
        this.f57636a = pbFragment;
        this.f57637b = cVar;
        d();
    }

    public void a(BdTypeListView bdTypeListView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bdTypeListView) == null) {
            bdTypeListView.addHeaderView(this.f57638c);
        }
    }

    public boolean b(boolean z) {
        InterceptResult invokeZ;
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z)) == null) {
            Button button = this.f57644i;
            if (button != null && button.getVisibility() == 0) {
                View view = this.f57641f;
                if (view != null) {
                    view.setVisibility(0);
                }
                z2 = true;
            } else {
                View view2 = this.f57641f;
                if (view2 != null) {
                    view2.setVisibility(8);
                }
                z2 = false;
            }
            View view3 = this.f57643h;
            if ((view3 == null || view3.getVisibility() == 8) && z2 && z) {
                this.f57642g.setVisibility(0);
            } else {
                this.f57642g.setVisibility(8);
            }
            return z2;
        }
        return invokeZ.booleanValue;
    }

    public View c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f57638c : (View) invokeV.objValue;
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            View inflate = LayoutInflater.from(this.f57636a.getPageContext().getPageActivity()).inflate(R.layout.new_pb_header_item, (ViewGroup) null);
            this.f57638c = inflate;
            inflate.setOnTouchListener(this.f57637b);
            View findViewById = this.f57638c.findViewById(R.id.pb_head_activity_join_number_container);
            this.f57639d = findViewById;
            findViewById.setVisibility(8);
            this.f57640e = (TextView) this.f57638c.findViewById(R.id.pb_head_activity_join_number);
            this.f57641f = this.f57638c.findViewById(R.id.new_pb_header_item_line_above_livepost);
            this.f57642g = this.f57638c.findViewById(R.id.new_pb_header_item_line_below_livepost);
            this.f57638c.setOnLongClickListener(new a(this));
        }
    }

    public void e(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
            this.f57636a.getBaseFragmentActivity().getLayoutMode().j(this.f57638c);
        }
    }

    public void f(BdTypeListView bdTypeListView) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, bdTypeListView) == null) || bdTypeListView == null) {
            return;
        }
        bdTypeListView.removeHeaderView(this.f57638c);
    }

    public void g(d.a.q0.h2.h.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, eVar) == null) {
            ArrayList<d.a.p0.s.q.b> o = eVar.N().o();
            if (o != null && o.size() > 0) {
                this.f57640e.setText(String.valueOf(o.get(0).f()));
                this.f57639d.setVisibility(0);
            } else {
                this.f57639d.setVisibility(8);
            }
            SkinManager.setBackgroundResource(this.f57639d, R.drawable.activity_join_num_bg);
            SkinManager.setViewTextColor(this.f57640e, R.color.CAM_X0305, 1);
        }
    }

    public void h(d.a.q0.h2.h.e eVar, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048583, this, eVar, z) == null) {
            boolean b2 = b(z);
            if (eVar == null || eVar.x() == null || eVar.x().c() != 0 || !z) {
                this.f57642g.setVisibility(8);
            } else if (b2) {
                this.f57642g.setVisibility(0);
            } else {
                this.f57642g.setVisibility(8);
            }
        }
    }
}
