package d.a.p0.v1.f;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.e.p.l;
import d.a.p0.v1.f.f;
import java.util.List;
/* loaded from: classes8.dex */
public class c extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public List<f.d> f65128e;

    /* renamed from: f  reason: collision with root package name */
    public LayoutInflater f65129f;

    /* renamed from: g  reason: collision with root package name */
    public int f65130g;

    /* renamed from: h  reason: collision with root package name */
    public int f65131h;

    /* renamed from: i  reason: collision with root package name */
    public int f65132i;
    public int j;

    /* loaded from: classes8.dex */
    public class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public RelativeLayout f65133a;

        /* renamed from: b  reason: collision with root package name */
        public LinearLayout f65134b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f65135c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f65136d;

        /* renamed from: e  reason: collision with root package name */
        public TextView f65137e;

        /* renamed from: f  reason: collision with root package name */
        public TextView f65138f;

        /* renamed from: g  reason: collision with root package name */
        public TextView f65139g;

        public a(c cVar, View view) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, view};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f65133a = (RelativeLayout) view.findViewById(R.id.root);
            this.f65134b = (LinearLayout) view.findViewById(R.id.container);
            this.f65135c = (TextView) view.findViewById(R.id.tv_price_money_label);
            this.f65136d = (TextView) view.findViewById(R.id.tv_price_tag);
            this.f65137e = (TextView) view.findViewById(R.id.tv_price_money);
            this.f65138f = (TextView) view.findViewById(R.id.tv_price_sale);
            this.f65139g = (TextView) view.findViewById(R.id.tv_month);
        }
    }

    public c(TbPageContext<?> tbPageContext) {
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
        this.f65129f = LayoutInflater.from(tbPageContext.getPageActivity());
        int k = l.k(tbPageContext.getPageActivity());
        this.f65130g = k;
        this.f65131h = (k - tbPageContext.getPageActivity().getResources().getDimensionPixelSize(R.dimen.tbds120)) / 3;
        this.f65132i = tbPageContext.getPageActivity().getResources().getDimensionPixelSize(R.dimen.tbds360);
        this.j = tbPageContext.getPageActivity().getResources().getDimensionPixelSize(R.dimen.tbds44);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: a */
    public f.d getItem(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) ? (f.d) ListUtils.getItem(this.f65128e, i2) : (f.d) invokeI.objValue;
    }

    public f.d b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            for (int i2 = 0; i2 < this.f65128e.size(); i2++) {
                if (this.f65128e.get(i2).m) {
                    return this.f65128e.get(i2);
                }
            }
            return null;
        }
        return (f.d) invokeV.objValue;
    }

    public final void c(int i2, f.d dVar, a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeILL(Constants.METHOD_SEND_USER_MSG, this, i2, dVar, aVar) == null) || dVar == null || dVar.j < 0) {
            return;
        }
        aVar.f65139g.setText(f(dVar.f65161b, 7));
        if (TextUtils.isEmpty(dVar.f65162c)) {
            aVar.f65138f.setVisibility(4);
        } else {
            aVar.f65138f.setVisibility(0);
            aVar.f65138f.setText(f(dVar.f65162c, 10));
        }
        TextView textView = aVar.f65137e;
        textView.setText("" + (dVar.j / 100));
        if (TextUtils.isEmpty(dVar.f65167h)) {
            aVar.f65136d.setVisibility(4);
        } else {
            aVar.f65136d.setVisibility(0);
            aVar.f65136d.setText(dVar.f65167h);
        }
        if (i2 == 0) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) aVar.f65133a.getLayoutParams();
            layoutParams.width = this.f65131h;
            layoutParams.height = this.f65132i;
            layoutParams.leftMargin = this.j;
            aVar.f65133a.setLayoutParams(layoutParams);
        } else {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) aVar.f65133a.getLayoutParams();
            layoutParams2.width = this.f65131h;
            layoutParams2.height = this.f65132i;
            layoutParams2.leftMargin = 0;
            aVar.f65133a.setLayoutParams(layoutParams2);
        }
        SkinManager.setViewTextColor(aVar.f65135c, R.color.CAM_X0301);
        SkinManager.setViewTextColor(aVar.f65136d, R.color.CAM_X0101);
        SkinManager.setBackgroundResource(aVar.f65136d, R.drawable.member_price_tag_bg_shape);
        SkinManager.setViewTextColor(aVar.f65137e, R.color.CAM_X0301);
        SkinManager.setViewTextColor(aVar.f65138f, R.color.CAM_X0109);
        SkinManager.setViewTextColor(aVar.f65139g, R.color.CAM_X0105);
        e(dVar, aVar);
    }

    public void d(List<f.d> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, list) == null) {
            this.f65128e = list;
        }
    }

    public final void e(f.d dVar, a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048580, this, dVar, aVar) == null) || dVar == null || aVar == null) {
            return;
        }
        if (dVar.m) {
            SkinManager.setBackgroundResource(aVar.f65134b, R.drawable.member_price_bg_shape_s);
        } else {
            SkinManager.setBackgroundResource(aVar.f65134b, R.drawable.member_price_bg_shape_n);
        }
    }

    public final String f(String str, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048581, this, str, i2)) == null) {
            if (str.length() > i2) {
                return str.substring(0, i2 - 1) + StringHelper.STRING_MORE;
            }
            return str;
        }
        return (String) invokeLI.objValue;
    }

    public void g(f.d dVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, dVar) == null) || dVar == null || this.f65128e == null) {
            return;
        }
        for (int i2 = 0; i2 < this.f65128e.size(); i2++) {
            this.f65128e.get(i2).m = false;
            if (this.f65128e.get(i2).f65160a.equals(dVar.f65160a)) {
                this.f65128e.get(i2).m = true;
            }
        }
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? ListUtils.getCount(this.f65128e) : invokeV.intValue;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048585, this, i2)) == null) ? i2 : invokeI.longValue;
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048586, this, i2, view, viewGroup)) == null) {
            if (view == null) {
                view = this.f65129f.inflate(R.layout.member_pay_price_list_item, (ViewGroup) null);
                view.setTag(new a(this, view));
            }
            c(i2, getItem(i2), (a) view.getTag());
            return view;
        }
        return (View) invokeILL.objValue;
    }
}
