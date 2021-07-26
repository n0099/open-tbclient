package d.a.q0.h1;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class b extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public String f57296e;

    /* renamed from: f  reason: collision with root package name */
    public final List<d> f57297f;

    /* renamed from: g  reason: collision with root package name */
    public LayoutInflater f57298g;

    /* loaded from: classes8.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    public b(TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f57297f = new ArrayList();
        this.f57298g = LayoutInflater.from(tbPageContext.getPageActivity());
    }

    public final void a(C1410b c1410b, View view, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLI(1048576, this, c1410b, view, i2) == null) || c1410b == null || c1410b.f57299a == i2) {
            return;
        }
        SkinManager.setBackgroundResource(view, R.drawable.addresslist_item_bg);
        SkinManager.setBackgroundColor(c1410b.f57302d, R.color.CAM_X0204);
        SkinManager.setBackgroundColor(c1410b.f57301c, R.color.CAM_X0204);
        SkinManager.setViewTextColor(c1410b.f57300b, R.color.CAM_X0105, 1);
        c1410b.f57299a = i2;
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f57297f.clear();
            notifyDataSetChanged();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: c */
    public d getItem(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) ? this.f57297f.get(i2) : (d) invokeI.objValue;
    }

    public List<d> d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f57297f : (List) invokeV.objValue;
    }

    public void e(String str, List<d> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, str, list) == null) {
            this.f57296e = str;
            this.f57297f.clear();
            if (list != null) {
                this.f57297f.addAll(list);
            }
            notifyDataSetChanged();
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f57297f.size() : invokeV.intValue;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i2)) == null) ? i2 : invokeI.longValue;
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        C1410b c1410b;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2, view, viewGroup)) == null) {
            d item = getItem(i2);
            if (item == null) {
                return view;
            }
            if (view != null && (view.getTag() instanceof C1410b)) {
                c1410b = (C1410b) view.getTag();
            } else {
                view = this.f57298g.inflate(R.layout.hot_suggest_item, (ViewGroup) null);
                c1410b = new C1410b(this, null);
                c1410b.f57300b = (TextView) view.findViewById(R.id.name);
                c1410b.f57301c = view.findViewById(R.id.divider_line_top);
                c1410b.f57302d = view.findViewById(R.id.divider_line_bottom);
                view.setTag(c1410b);
            }
            c1410b.f57301c.setVisibility(i2 == 0 ? 0 : 8);
            c1410b.f57300b.setText(StringHelper.highLightText(d.a.p0.r0.b.a(StringHelper.cutStringWithEllipsisNew(item.b(), 18)), this.f57296e, R.color.CAM_X0302));
            a(c1410b, view, TbadkCoreApplication.getInst().getSkinType());
            return view;
        }
        return (View) invokeILL.objValue;
    }

    /* renamed from: d.a.q0.h1.b$b  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C1410b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public int f57299a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f57300b;

        /* renamed from: c  reason: collision with root package name */
        public View f57301c;

        /* renamed from: d  reason: collision with root package name */
        public View f57302d;

        public C1410b(b bVar) {
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
                    return;
                }
            }
            this.f57299a = 3;
        }

        public /* synthetic */ C1410b(b bVar, a aVar) {
            this(bVar);
        }
    }
}
