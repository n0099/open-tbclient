package d.a.p0.u0.k2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.p0.u0.d1;
import d.a.p0.u0.k2.f;
import java.util.List;
/* loaded from: classes8.dex */
public class g implements d.a.p0.u0.k2.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public BdListView f63034a;

    /* renamed from: b  reason: collision with root package name */
    public f.e f63035b;

    /* renamed from: c  reason: collision with root package name */
    public Context f63036c;

    /* renamed from: d  reason: collision with root package name */
    public List<d1> f63037d;

    /* renamed from: e  reason: collision with root package name */
    public f f63038e;

    /* renamed from: f  reason: collision with root package name */
    public final BaseAdapter f63039f;

    /* renamed from: g  reason: collision with root package name */
    public AdapterView.OnItemClickListener f63040g;

    /* loaded from: classes8.dex */
    public class a extends BaseAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ g f63041e;

        public a(g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f63041e = gVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.widget.Adapter
        /* renamed from: a */
        public d1 getItem(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
                if (this.f63041e.f63037d == null) {
                    return null;
                }
                return (d1) this.f63041e.f63037d.get(i2);
            }
            return (d1) invokeI.objValue;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                if (this.f63041e.f63037d == null) {
                    return 0;
                }
                return this.f63041e.f63037d.size();
            }
            return invokeV.intValue;
        }

        @Override // android.widget.Adapter
        public long getItemId(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i2)) == null) ? i2 : invokeI.longValue;
        }

        @Override // android.widget.Adapter
        public View getView(int i2, View view, ViewGroup viewGroup) {
            InterceptResult invokeILL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeILL = interceptable.invokeILL(1048580, this, i2, view, viewGroup)) == null) {
                if (view == null) {
                    view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.tab_item_menu_item_view, (ViewGroup) null);
                    view.setLayoutParams(new AbsListView.LayoutParams(-1, viewGroup.getContext().getResources().getDimensionPixelSize(R.dimen.ds80)));
                    f.C1683f c1683f = new f.C1683f();
                    c1683f.f63030a = (TextView) view.findViewById(R.id.tab_menu_name);
                    c1683f.f63031b = (ImageView) view.findViewById(R.id.tab_menu_check);
                    c1683f.f63032c = view.findViewById(R.id.tab_menu_line_s);
                    c1683f.f63033d = view.findViewById(R.id.tab_menu_line_f);
                    view.setTag(c1683f);
                }
                SkinManager.setBackgroundResource(view, R.color.CAM_X0201);
                f.C1683f c1683f2 = (f.C1683f) view.getTag();
                d1 item = getItem(i2);
                if (item == null) {
                    return view;
                }
                c1683f2.f63030a.setText(item.f62611a);
                if (item.f62613c) {
                    SkinManager.setViewTextColor(c1683f2.f63030a, R.color.CAM_X0302, 1);
                    SkinManager.setImageResource(c1683f2.f63031b, R.drawable.chx_tips_list_ok);
                    c1683f2.f63031b.setVisibility(0);
                } else {
                    SkinManager.setViewTextColor(c1683f2.f63030a, R.color.CAM_X0108, 1);
                    c1683f2.f63031b.setVisibility(8);
                }
                if (i2 >= 0 && i2 == getCount() - 1) {
                    c1683f2.f63033d.setVisibility(0);
                    c1683f2.f63032c.setVisibility(8);
                    SkinManager.setBackgroundColor(c1683f2.f63033d, R.color.CAM_X0204);
                } else {
                    c1683f2.f63032c.setVisibility(0);
                    c1683f2.f63033d.setVisibility(8);
                    SkinManager.setBackgroundColor(c1683f2.f63032c, R.color.CAM_X0204);
                }
                return view;
            }
            return (View) invokeILL.objValue;
        }
    }

    /* loaded from: classes8.dex */
    public class b implements AdapterView.OnItemClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ g f63042e;

        public b(g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f63042e = gVar;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view, Integer.valueOf(i2), Long.valueOf(j)}) == null) {
                if (this.f63042e.f63038e != null) {
                    this.f63042e.f63038e.c();
                }
                if (this.f63042e.f63039f == null || this.f63042e.f63035b == null) {
                    return;
                }
                for (d1 d1Var : this.f63042e.f63037d) {
                    if (d1Var != null) {
                        d1Var.f62613c = false;
                    }
                }
                d1 d1Var2 = (d1) this.f63042e.f63039f.getItem(i2);
                if (d1Var2 != null) {
                    d1Var2.f62613c = true;
                    this.f63042e.f63035b.a(d1Var2.f62612b);
                }
            }
        }
    }

    public g() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f63039f = new a(this);
        this.f63040g = new b(this);
    }

    @Override // d.a.p0.u0.k2.b
    public void a(Context context, f fVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, context, fVar) == null) || context == null || fVar == null) {
            return;
        }
        this.f63036c = context;
        this.f63038e = fVar;
        this.f63035b = fVar.d();
        g();
    }

    @Override // d.a.p0.u0.k2.b
    public int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            BdListView bdListView = new BdListView(this.f63036c);
            this.f63034a = bdListView;
            bdListView.setAlwaysDrawnWithCacheEnabled(false);
            this.f63034a.setDivider(null);
            this.f63034a.setDividerHeight(0);
            this.f63034a.setSelector(17170445);
            this.f63034a.setCacheColorHint(this.f63036c.getResources().getColor(17170445));
            this.f63034a.setOnItemClickListener(this.f63040g);
            this.f63034a.setAdapter((ListAdapter) this.f63039f);
        }
    }

    @Override // d.a.p0.u0.k2.b
    public View getView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f63034a : (View) invokeV.objValue;
    }

    @Override // d.a.p0.u0.k2.b
    public void setData(List<d1> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, list) == null) {
            this.f63037d = list;
            this.f63039f.notifyDataSetChanged();
        }
    }
}
