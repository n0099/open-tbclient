package d.a.p0.d1;

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
    public Context f52230e;

    /* renamed from: f  reason: collision with root package name */
    public int f52231f;

    /* renamed from: g  reason: collision with root package name */
    public List<String> f52232g;

    /* renamed from: h  reason: collision with root package name */
    public List<String> f52233h;

    /* renamed from: i  reason: collision with root package name */
    public List<String> f52234i;

    /* renamed from: d.a.p0.d1.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class C1182a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public TbImageView f52235a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f52236b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f52237c;

        public C1182a(a aVar, View view) {
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
            this.f52235a = tbImageView;
            tbImageView.setDefaultBgResource(R.color.CAM_X0206);
            this.f52236b = (TextView) view.findViewById(R.id.bar_select_rule_title);
            this.f52237c = (TextView) view.findViewById(R.id.bar_select_rule_content);
        }
    }

    /* loaded from: classes7.dex */
    public class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public TextView f52238a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f52239b;

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
            this.f52238a = (TextView) view.findViewById(R.id.pb_vote_select_rule_title);
            this.f52239b = (TextView) view.findViewById(R.id.pb_vote_select_rule_content);
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
        this.f52231f = 0;
        this.f52230e = context;
        this.f52232g = new ArrayList();
        this.f52233h = new ArrayList();
        this.f52234i = new ArrayList();
    }

    public void a(C1182a c1182a) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, c1182a) == null) || c1182a == null) {
            return;
        }
        SkinManager.setViewTextColor(c1182a.f52236b, R.color.CAM_X0105, 1);
        SkinManager.setViewTextColor(c1182a.f52237c, R.color.CAM_X0109, 1);
    }

    public void b(b bVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar) == null) || bVar == null) {
            return;
        }
        SkinManager.setViewTextColor(bVar.f52238a, R.color.CAM_X0105);
        SkinManager.setViewTextColor(bVar.f52239b, R.color.CAM_X0109);
    }

    public void c(List<String> list, List<String> list2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, list, list2) == null) {
            this.f52233h.clear();
            this.f52234i.clear();
            if (!ListUtils.isEmpty(list) && !ListUtils.isEmpty(list2)) {
                this.f52233h.addAll(list);
                this.f52234i.addAll(list2);
            }
            notifyDataSetChanged();
        }
    }

    public void d(List<String> list, List<String> list2, List<String> list3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048579, this, list, list2, list3) == null) {
            this.f52232g.clear();
            if (!ListUtils.isEmpty(list)) {
                this.f52232g.addAll(list);
            }
            c(list2, list3);
        }
    }

    public void e(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
            this.f52231f = i2;
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (ListUtils.isEmpty(this.f52233h)) {
                return 0;
            }
            return this.f52233h.size();
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
            int i3 = this.f52231f;
            if (i3 == 0) {
                view = LayoutInflater.from(this.f52230e).inflate(R.layout.pb_vote_select_rule_item, (ViewGroup) null, false);
                b bVar = new b(this, view);
                if (!ListUtils.isEmpty(this.f52233h) && this.f52233h.size() > i2 && !TextUtils.isEmpty(this.f52233h.get(i2))) {
                    bVar.f52238a.setText(this.f52233h.get(i2));
                    bVar.f52238a.setVisibility(0);
                } else {
                    bVar.f52238a.setVisibility(8);
                }
                if (!ListUtils.isEmpty(this.f52234i) && this.f52234i.size() > i2 && !TextUtils.isEmpty(this.f52234i.get(i2))) {
                    bVar.f52239b.setText(this.f52234i.get(i2));
                    bVar.f52239b.setVisibility(0);
                } else {
                    bVar.f52239b.setVisibility(8);
                }
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2);
                layoutParams.weight = 1.0f;
                view.setLayoutParams(layoutParams);
                b(bVar);
            } else if (i3 == 1) {
                view = LayoutInflater.from(this.f52230e).inflate(R.layout.bar_select_rule_item, (ViewGroup) null, false);
                C1182a c1182a = new C1182a(this, view);
                if (!ListUtils.isEmpty(this.f52232g) && this.f52232g.size() > i2 && !TextUtils.isEmpty(this.f52232g.get(i2))) {
                    c1182a.f52235a.setDefaultResource(R.drawable.transparent_bg);
                    c1182a.f52235a.M(this.f52232g.get(i2), 10, false);
                }
                if (!ListUtils.isEmpty(this.f52233h) && this.f52233h.size() > i2 && !TextUtils.isEmpty(this.f52233h.get(i2))) {
                    c1182a.f52236b.setText(this.f52233h.get(i2));
                    c1182a.f52236b.setVisibility(0);
                } else {
                    c1182a.f52236b.setVisibility(8);
                }
                if (!ListUtils.isEmpty(this.f52234i) && this.f52234i.size() > i2 && !TextUtils.isEmpty(this.f52234i.get(i2))) {
                    c1182a.f52237c.setText(this.f52234i.get(i2));
                    c1182a.f52237c.setVisibility(0);
                } else {
                    c1182a.f52237c.setVisibility(8);
                }
                LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(0, -2);
                layoutParams2.weight = 1.0f;
                view.setLayoutParams(layoutParams2);
                a(c1182a);
            }
            return view;
        }
        return (View) invokeILL.objValue;
    }
}
