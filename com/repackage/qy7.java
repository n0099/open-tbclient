package com.repackage;

import android.graphics.Typeface;
import android.view.View;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.tieba.view.SortSwitchButton;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import tbclient.PbPage.PbSortType;
/* loaded from: classes7.dex */
public class qy7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View a;
    public TextView b;
    public TextView c;
    public SortSwitchButton d;
    public SortSwitchButton.f e;
    public int f;
    public View.OnClickListener g;
    public int h;
    public int i;
    public SortSwitchButton.f j;
    public View.OnClickListener k;

    /* loaded from: classes7.dex */
    public class a implements SortSwitchButton.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ qy7 a;

        public a(qy7 qy7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qy7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = qy7Var;
        }

        @Override // com.baidu.tieba.view.SortSwitchButton.f
        public boolean a(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) {
                if (this.a.e != null) {
                    return this.a.e.a(i);
                }
                return true;
            }
            return invokeI.booleanValue;
        }
    }

    /* loaded from: classes7.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ qy7 a;

        public b(qy7 qy7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qy7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = qy7Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (this.a.g != null) {
                    this.a.g.onClick(view2);
                }
                if (ni.z()) {
                    if (view2 == null || !(view2.getTag() instanceof Boolean) || ((Boolean) view2.getTag()).booleanValue()) {
                        if (view2 != this.a.b) {
                            if (view2 == this.a.c) {
                                this.a.k(1);
                                return;
                            }
                            return;
                        }
                        this.a.k(0);
                    }
                }
            }
        }
    }

    public qy7(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {view2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f = 0;
        this.j = new a(this);
        this.k = new b(this);
        if (view2 == null) {
            return;
        }
        this.a = view2;
        TextView textView = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090259);
        this.b = textView;
        textView.setOnClickListener(this.k);
        TextView textView2 = (TextView) this.a.findViewById(R.id.obfuscated_res_0x7f0915ff);
        this.c = textView2;
        textView2.setOnClickListener(this.k);
        SortSwitchButton sortSwitchButton = (SortSwitchButton) this.a.findViewById(R.id.obfuscated_res_0x7f09231e);
        this.d = sortSwitchButton;
        sortSwitchButton.setOnSwitchChangeListener(this.j);
        this.d.v(2);
        h(TbadkCoreApplication.getInst().getSkinType());
    }

    public void e(er7 er7Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, er7Var) == null) || er7Var == null) {
            return;
        }
        int i = 0;
        if (er7Var.b == er7.h) {
            this.b.setClickable(true);
            this.b.setText(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f026c));
            this.c.setVisibility(0);
            f(er7Var.d);
        }
        if (er7Var.e) {
            this.c.setVisibility(8);
            this.d.setVisibility(8);
        } else if (er7Var.f) {
            this.c.setVisibility(8);
        } else {
            this.c.setVisibility(0);
        }
        if (!er7Var.e && er7Var.g != null) {
            this.d.setVisibility(0);
            int i2 = 0;
            while (true) {
                if (i2 < er7Var.g.size()) {
                    if (er7Var.g.get(i2) != null && er7Var.c == er7Var.g.get(i2).sort_type.intValue()) {
                        i = i2;
                        break;
                    }
                    i2++;
                } else {
                    break;
                }
            }
            g(er7Var.g, i);
        }
        h(TbadkCoreApplication.getInst().getSkinType());
    }

    public void f(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            if (z) {
                k(1);
            } else {
                k(0);
            }
        }
    }

    public void g(List<PbSortType> list, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, list, i) == null) {
            if (ListUtils.isEmpty(list)) {
                this.d.setVisibility(8);
                return;
            }
            ArrayList arrayList = new ArrayList();
            for (PbSortType pbSortType : list) {
                vh8 vh8Var = new vh8();
                vh8Var.c(pbSortType.sort_type.intValue());
                vh8Var.d(pbSortType.sort_name);
                arrayList.add(vh8Var);
            }
            this.d.setVisibility(0);
            this.d.setData(arrayList, i);
        }
    }

    public void h(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
            SkinManager.setBackgroundColor(this.a, R.color.CAM_X0205);
            this.i = SkinManager.getColor(R.color.CAM_X0105);
            this.h = SkinManager.getColor(R.color.CAM_X0107);
            k(this.f);
            this.d.G();
        }
    }

    public void i(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, onClickListener) == null) {
            this.g = onClickListener;
        }
    }

    public void j(SortSwitchButton.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, fVar) == null) {
            this.e = fVar;
        }
    }

    public void k(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i) == null) {
            this.f = i;
            if (i == 0) {
                this.b.setTypeface(Typeface.defaultFromStyle(1));
                this.c.setTypeface(Typeface.defaultFromStyle(0));
                this.b.setTextColor(this.i);
                this.c.setTextColor(this.h);
            } else if (i == 1) {
                this.b.setTypeface(Typeface.defaultFromStyle(0));
                this.c.setTypeface(Typeface.defaultFromStyle(1));
                this.b.setTextColor(this.h);
                this.c.setTextColor(this.i);
            }
        }
    }
}
