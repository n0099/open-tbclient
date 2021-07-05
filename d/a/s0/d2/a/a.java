package d.a.s0.d2.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.e.p.l;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes9.dex */
public class a extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public int f58145e;

    /* renamed from: f  reason: collision with root package name */
    public final Context f58146f;

    /* renamed from: g  reason: collision with root package name */
    public final List<d.a.s0.d2.c.b> f58147g;

    /* renamed from: h  reason: collision with root package name */
    public c f58148h;

    /* renamed from: d.a.s0.d2.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public class View$OnClickListenerC1363a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.s0.d2.c.b f58149e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ b f58150f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f58151g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ a f58152h;

        public View$OnClickListenerC1363a(a aVar, d.a.s0.d2.c.b bVar, b bVar2, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, bVar, bVar2, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f58152h = aVar;
            this.f58149e = bVar;
            this.f58150f = bVar2;
            this.f58151g = i2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (!this.f58149e.d() && this.f58152h.f58145e >= 10) {
                    l.M(this.f58152h.f58146f.getApplicationContext(), this.f58152h.f58146f.getApplicationContext().getString(R.string.max_interest_select_num));
                    return;
                }
                d.a.s0.d2.c.b bVar = this.f58149e;
                bVar.e(!bVar.d());
                this.f58152h.i(this.f58150f.f58155c, this.f58149e);
                this.f58152h.h(this.f58149e);
                if (this.f58152h.f58148h != null) {
                    this.f58152h.f58148h.F0(this.f58152h.f58145e);
                }
                if (this.f58149e.d()) {
                    StatisticItem statisticItem = new StatisticItem("c13682");
                    statisticItem.param("obj_type", 2);
                    statisticItem.param("obj_locate", 1);
                    statisticItem.param("obj_source", this.f58151g);
                    TiebaStatic.log(statisticItem);
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public ImageView f58153a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f58154b;

        /* renamed from: c  reason: collision with root package name */
        public ImageView f58155c;

        public b(View view) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {view};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f58153a = (ImageView) view.findViewById(R.id.interest_icon);
            this.f58154b = (TextView) view.findViewById(R.id.interest_text);
            this.f58155c = (ImageView) view.findViewById(R.id.select_status_view);
            SkinManager.setViewTextColor(this.f58154b, R.color.CAM_X0105);
            SkinManager.setBackgroundResource(view, R.drawable.bg_interest_item_selection);
        }
    }

    /* loaded from: classes9.dex */
    public interface c {
        void F0(int i2);
    }

    public a(List<d.a.s0.d2.c.b> list, Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {list, context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f58147g = list;
        this.f58146f = context;
    }

    public List<d.a.s0.d2.c.b> f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            ArrayList arrayList = new ArrayList();
            for (d.a.s0.d2.c.b bVar : this.f58147g) {
                if (bVar.d()) {
                    arrayList.add(bVar);
                }
            }
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    public void g(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar) == null) {
            this.f58148h = cVar;
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            List<d.a.s0.d2.c.b> list = this.f58147g;
            if (list == null) {
                return 0;
            }
            return list.size();
        }
        return invokeV.intValue;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i2)) == null) {
            return null;
        }
        return invokeI.objValue;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i2)) == null) {
            return 0L;
        }
        return invokeI.longValue;
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048581, this, i2, view, viewGroup)) == null) {
            if (view == null) {
                view = LayoutInflater.from(this.f58146f).inflate(R.layout.list_item_interest_selection, viewGroup, false);
                bVar = new b(view);
                view.setTag(bVar);
            } else {
                bVar = (b) view.getTag();
            }
            d.a.s0.d2.c.b bVar2 = this.f58147g.get(i2);
            if (bVar2.a() > 0) {
                SvgManager.getInstance().setMaskDrawableWithDayNightModeAutoChange(bVar.f58153a, bVar2.a(), null);
            }
            bVar.f58154b.setText(bVar2.c());
            i(bVar.f58155c, bVar2);
            if (bVar2.d()) {
                this.f58145e++;
            }
            view.setOnClickListener(new View$OnClickListenerC1363a(this, bVar2, bVar, i2));
            return view;
        }
        return (View) invokeILL.objValue;
    }

    public final void h(d.a.s0.d2.c.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, bVar) == null) {
            if (bVar.d()) {
                this.f58145e++;
            } else {
                this.f58145e--;
            }
        }
    }

    public final void i(ImageView imageView, d.a.s0.d2.c.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, imageView, bVar) == null) {
            if (bVar.d()) {
                SvgManager.getInstance().setMaskDrawableWithDayNightModeAutoChange(imageView, R.drawable.ic_icon_pure_guide_select_svg, SvgManager.SvgResourceStateType.NORMAL);
            } else {
                SvgManager.getInstance().setMaskDrawableWithDayNightModeAutoChange(imageView, R.drawable.ic_icon_mask_module_unselect_svg, SvgManager.SvgResourceStateType.NORMAL);
            }
        }
    }
}
