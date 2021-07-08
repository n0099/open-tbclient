package d.a.p0.d2.a;

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
/* loaded from: classes7.dex */
public class a extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public int f54890e;

    /* renamed from: f  reason: collision with root package name */
    public final Context f54891f;

    /* renamed from: g  reason: collision with root package name */
    public final List<d.a.p0.d2.c.b> f54892g;

    /* renamed from: h  reason: collision with root package name */
    public c f54893h;

    /* renamed from: d.a.p0.d2.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class View$OnClickListenerC1317a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.p0.d2.c.b f54894e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ b f54895f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f54896g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ a f54897h;

        public View$OnClickListenerC1317a(a aVar, d.a.p0.d2.c.b bVar, b bVar2, int i2) {
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
            this.f54897h = aVar;
            this.f54894e = bVar;
            this.f54895f = bVar2;
            this.f54896g = i2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (!this.f54894e.d() && this.f54897h.f54890e >= 10) {
                    l.M(this.f54897h.f54891f.getApplicationContext(), this.f54897h.f54891f.getApplicationContext().getString(R.string.max_interest_select_num));
                    return;
                }
                d.a.p0.d2.c.b bVar = this.f54894e;
                bVar.e(!bVar.d());
                this.f54897h.i(this.f54895f.f54900c, this.f54894e);
                this.f54897h.h(this.f54894e);
                if (this.f54897h.f54893h != null) {
                    this.f54897h.f54893h.F0(this.f54897h.f54890e);
                }
                if (this.f54894e.d()) {
                    StatisticItem statisticItem = new StatisticItem("c13682");
                    statisticItem.param("obj_type", 2);
                    statisticItem.param("obj_locate", 1);
                    statisticItem.param("obj_source", this.f54896g);
                    TiebaStatic.log(statisticItem);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public ImageView f54898a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f54899b;

        /* renamed from: c  reason: collision with root package name */
        public ImageView f54900c;

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
            this.f54898a = (ImageView) view.findViewById(R.id.interest_icon);
            this.f54899b = (TextView) view.findViewById(R.id.interest_text);
            this.f54900c = (ImageView) view.findViewById(R.id.select_status_view);
            SkinManager.setViewTextColor(this.f54899b, R.color.CAM_X0105);
            SkinManager.setBackgroundResource(view, R.drawable.bg_interest_item_selection);
        }
    }

    /* loaded from: classes7.dex */
    public interface c {
        void F0(int i2);
    }

    public a(List<d.a.p0.d2.c.b> list, Context context) {
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
        this.f54892g = list;
        this.f54891f = context;
    }

    public List<d.a.p0.d2.c.b> f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            ArrayList arrayList = new ArrayList();
            for (d.a.p0.d2.c.b bVar : this.f54892g) {
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
            this.f54893h = cVar;
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            List<d.a.p0.d2.c.b> list = this.f54892g;
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
                view = LayoutInflater.from(this.f54891f).inflate(R.layout.list_item_interest_selection, viewGroup, false);
                bVar = new b(view);
                view.setTag(bVar);
            } else {
                bVar = (b) view.getTag();
            }
            d.a.p0.d2.c.b bVar2 = this.f54892g.get(i2);
            if (bVar2.a() > 0) {
                SvgManager.getInstance().setMaskDrawableWithDayNightModeAutoChange(bVar.f54898a, bVar2.a(), null);
            }
            bVar.f54899b.setText(bVar2.c());
            i(bVar.f54900c, bVar2);
            if (bVar2.d()) {
                this.f54890e++;
            }
            view.setOnClickListener(new View$OnClickListenerC1317a(this, bVar2, bVar, i2));
            return view;
        }
        return (View) invokeILL.objValue;
    }

    public final void h(d.a.p0.d2.c.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, bVar) == null) {
            if (bVar.d()) {
                this.f54890e++;
            } else {
                this.f54890e--;
            }
        }
    }

    public final void i(ImageView imageView, d.a.p0.d2.c.b bVar) {
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
