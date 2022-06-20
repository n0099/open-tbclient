package com.repackage;

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
import com.repackage.zi7;
import java.util.List;
/* loaded from: classes7.dex */
public class wi7 extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<zi7.d> a;
    public LayoutInflater b;
    public int c;
    public int d;
    public int e;
    public int f;

    /* loaded from: classes7.dex */
    public class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public RelativeLayout a;
        public LinearLayout b;
        public TextView c;
        public TextView d;
        public TextView e;
        public TextView f;
        public TextView g;

        public a(wi7 wi7Var, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wi7Var, view2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = (RelativeLayout) view2.findViewById(R.id.obfuscated_res_0x7f091abd);
            this.b = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f09069b);
            this.c = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0921d6);
            this.d = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0921d8);
            this.e = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0921d5);
            this.f = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0921d7);
            this.g = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0921b1);
        }
    }

    public wi7(TbPageContext<?> tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = LayoutInflater.from(tbPageContext.getPageActivity());
        int k = pi.k(tbPageContext.getPageActivity());
        this.c = k;
        this.d = (k - tbPageContext.getPageActivity().getResources().getDimensionPixelSize(R.dimen.tbds120)) / 3;
        this.e = tbPageContext.getPageActivity().getResources().getDimensionPixelSize(R.dimen.tbds360);
        this.f = tbPageContext.getPageActivity().getResources().getDimensionPixelSize(R.dimen.tbds44);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: a */
    public zi7.d getItem(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) ? (zi7.d) ListUtils.getItem(this.a, i) : (zi7.d) invokeI.objValue;
    }

    public zi7.d b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            for (int i = 0; i < this.a.size(); i++) {
                if (this.a.get(i).i) {
                    return this.a.get(i);
                }
            }
            return null;
        }
        return (zi7.d) invokeV.objValue;
    }

    public final void c(int i, zi7.d dVar, a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeILL(Constants.METHOD_SEND_USER_MSG, this, i, dVar, aVar) == null) || dVar == null || dVar.f < 0) {
            return;
        }
        aVar.g.setText(f(dVar.b, 7));
        if (TextUtils.isEmpty(dVar.c)) {
            aVar.f.setVisibility(4);
        } else {
            aVar.f.setVisibility(0);
            aVar.f.setText(f(dVar.c, 10));
        }
        TextView textView = aVar.e;
        textView.setText("" + (dVar.f / 100));
        if (TextUtils.isEmpty(dVar.d)) {
            aVar.d.setVisibility(4);
        } else {
            aVar.d.setVisibility(0);
            aVar.d.setText(dVar.d);
        }
        if (i == 0) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) aVar.a.getLayoutParams();
            layoutParams.width = this.d;
            layoutParams.height = this.e;
            layoutParams.leftMargin = this.f;
            aVar.a.setLayoutParams(layoutParams);
        } else {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) aVar.a.getLayoutParams();
            layoutParams2.width = this.d;
            layoutParams2.height = this.e;
            layoutParams2.leftMargin = 0;
            aVar.a.setLayoutParams(layoutParams2);
        }
        SkinManager.setViewTextColor(aVar.c, (int) R.color.CAM_X0301);
        SkinManager.setViewTextColor(aVar.d, (int) R.color.CAM_X0101);
        SkinManager.setBackgroundResource(aVar.d, R.drawable.member_price_tag_bg_shape);
        SkinManager.setViewTextColor(aVar.e, (int) R.color.CAM_X0301);
        SkinManager.setViewTextColor(aVar.f, (int) R.color.CAM_X0109);
        SkinManager.setViewTextColor(aVar.g, (int) R.color.CAM_X0105);
        e(dVar, aVar);
    }

    public void d(List<zi7.d> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, list) == null) {
            this.a = list;
        }
    }

    public final void e(zi7.d dVar, a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048580, this, dVar, aVar) == null) || dVar == null || aVar == null) {
            return;
        }
        if (dVar.i) {
            SkinManager.setBackgroundResource(aVar.b, R.drawable.member_price_bg_shape_s);
        } else {
            SkinManager.setBackgroundResource(aVar.b, R.drawable.member_price_bg_shape_n);
        }
    }

    public final String f(String str, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048581, this, str, i)) == null) {
            if (str.length() > i) {
                return str.substring(0, i - 1) + StringHelper.STRING_MORE;
            }
            return str;
        }
        return (String) invokeLI.objValue;
    }

    public void g(zi7.d dVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, dVar) == null) || dVar == null || this.a == null) {
            return;
        }
        for (int i = 0; i < this.a.size(); i++) {
            this.a.get(i).i = false;
            if (this.a.get(i).a.equals(dVar.a)) {
                this.a.get(i).i = true;
            }
        }
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? ListUtils.getCount(this.a) : invokeV.intValue;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048585, this, i)) == null) ? i : invokeI.longValue;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view2, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048586, this, i, view2, viewGroup)) == null) {
            if (view2 == null) {
                view2 = this.b.inflate(R.layout.obfuscated_res_0x7f0d0527, (ViewGroup) null);
                view2.setTag(new a(this, view2));
            }
            c(i, getItem(i), (a) view2.getTag());
            return view2;
        }
        return (View) invokeILL.objValue;
    }
}
