package d.a.o0.b1;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public class a extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public Context f51567e;

    /* renamed from: f  reason: collision with root package name */
    public int f51568f;

    /* renamed from: g  reason: collision with root package name */
    public List<String> f51569g;

    /* renamed from: h  reason: collision with root package name */
    public List<String> f51570h;

    /* renamed from: i  reason: collision with root package name */
    public List<String> f51571i;

    /* renamed from: d.a.o0.b1.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class C1171a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public TbImageView f51572a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f51573b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f51574c;

        public C1171a(a aVar, View view) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, view};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            TbImageView tbImageView = (TbImageView) view.findViewById(R.id.bar_select_rule_head_view);
            this.f51572a = tbImageView;
            tbImageView.setDefaultBgResource(R.color.CAM_X0206);
            this.f51573b = (TextView) view.findViewById(R.id.bar_select_rule_title);
            this.f51574c = (TextView) view.findViewById(R.id.bar_select_rule_content);
        }
    }

    /* loaded from: classes7.dex */
    public class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public TextView f51575a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f51576b;

        public b(a aVar, View view) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, view};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f51575a = (TextView) view.findViewById(R.id.pb_vote_select_rule_title);
            this.f51576b = (TextView) view.findViewById(R.id.pb_vote_select_rule_content);
        }
    }

    public a(Context context) {
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
        this.f51568f = 0;
        this.f51567e = context;
        this.f51569g = new ArrayList();
        this.f51570h = new ArrayList();
        this.f51571i = new ArrayList();
    }

    public void a(C1171a c1171a) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, c1171a) == null) || c1171a == null) {
            return;
        }
        SkinManager.setViewTextColor(c1171a.f51573b, R.color.CAM_X0105, 1);
        SkinManager.setViewTextColor(c1171a.f51574c, R.color.CAM_X0109, 1);
    }

    public void b(b bVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar) == null) || bVar == null) {
            return;
        }
        SkinManager.setViewTextColor(bVar.f51575a, R.color.CAM_X0105);
        SkinManager.setViewTextColor(bVar.f51576b, R.color.CAM_X0109);
    }

    public void c(List<String> list, List<String> list2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, list, list2) == null) {
            this.f51570h.clear();
            this.f51571i.clear();
            if (!ListUtils.isEmpty(list) && !ListUtils.isEmpty(list2)) {
                this.f51570h.addAll(list);
                this.f51571i.addAll(list2);
            }
            notifyDataSetChanged();
        }
    }

    public void d(List<String> list, List<String> list2, List<String> list3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048579, this, list, list2, list3) == null) {
            this.f51569g.clear();
            if (!ListUtils.isEmpty(list)) {
                this.f51569g.addAll(list);
            }
            c(list2, list3);
        }
    }

    public void e(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
            this.f51568f = i2;
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (ListUtils.isEmpty(this.f51570h)) {
                return 0;
            }
            return this.f51570h.size();
        }
        return invokeV.intValue;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i2)) == null) {
            return null;
        }
        return invokeI.objValue;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i2)) == null) {
            return 0L;
        }
        return invokeI.longValue;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2)) == null) ? super.getItemViewType(i2) : invokeI.intValue;
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048585, this, i2, view, viewGroup)) == null) {
            int i3 = this.f51568f;
            if (i3 == 0) {
                view = LayoutInflater.from(this.f51567e).inflate(R.layout.pb_vote_select_rule_item, (ViewGroup) null, false);
                b bVar = new b(this, view);
                if (!ListUtils.isEmpty(this.f51570h) && this.f51570h.size() > i2 && !TextUtils.isEmpty(this.f51570h.get(i2))) {
                    bVar.f51575a.setText(this.f51570h.get(i2));
                    bVar.f51575a.setVisibility(0);
                } else {
                    bVar.f51575a.setVisibility(8);
                }
                if (!ListUtils.isEmpty(this.f51571i) && this.f51571i.size() > i2 && !TextUtils.isEmpty(this.f51571i.get(i2))) {
                    bVar.f51576b.setText(this.f51571i.get(i2));
                    bVar.f51576b.setVisibility(0);
                } else {
                    bVar.f51576b.setVisibility(8);
                }
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2);
                layoutParams.weight = 1.0f;
                view.setLayoutParams(layoutParams);
                b(bVar);
            } else if (i3 == 1) {
                view = LayoutInflater.from(this.f51567e).inflate(R.layout.bar_select_rule_item, (ViewGroup) null, false);
                C1171a c1171a = new C1171a(this, view);
                if (!ListUtils.isEmpty(this.f51569g) && this.f51569g.size() > i2 && !TextUtils.isEmpty(this.f51569g.get(i2))) {
                    c1171a.f51572a.setDefaultResource(R.drawable.transparent_bg);
                    c1171a.f51572a.M(this.f51569g.get(i2), 10, false);
                }
                if (!ListUtils.isEmpty(this.f51570h) && this.f51570h.size() > i2 && !TextUtils.isEmpty(this.f51570h.get(i2))) {
                    c1171a.f51573b.setText(this.f51570h.get(i2));
                    c1171a.f51573b.setVisibility(0);
                } else {
                    c1171a.f51573b.setVisibility(8);
                }
                if (!ListUtils.isEmpty(this.f51571i) && this.f51571i.size() > i2 && !TextUtils.isEmpty(this.f51571i.get(i2))) {
                    c1171a.f51574c.setText(this.f51571i.get(i2));
                    c1171a.f51574c.setVisibility(0);
                } else {
                    c1171a.f51574c.setVisibility(8);
                }
                LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(0, -2);
                layoutParams2.weight = 1.0f;
                view.setLayoutParams(layoutParams2);
                a(c1171a);
            }
            return view;
        }
        return (View) invokeILL.objValue;
    }
}
