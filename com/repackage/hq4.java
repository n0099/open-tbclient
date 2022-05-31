package com.repackage;

import android.app.AlertDialog;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes6.dex */
public class hq4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public ArrayList<qq4> b;
    public AdapterView.OnItemClickListener c;
    public ViewGroup d;
    public BdListView e;
    public pq4 f;
    public TextView g;
    public TbPageContext<?> h;
    public boolean i;
    public AlertDialog j;
    public AdapterView.OnItemClickListener k;

    /* loaded from: classes6.dex */
    public class a implements AdapterView.OnItemClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ hq4 a;

        public a(hq4 hq4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hq4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = hq4Var;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view2, int i, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view2, Integer.valueOf(i), Long.valueOf(j)}) == null) {
                if (this.a.c != null) {
                    this.a.c.onItemClick(adapterView, view2, i, j);
                }
                this.a.f();
            }
        }
    }

    public hq4(TbPageContext<?> tbPageContext) {
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
        this.i = false;
        this.k = new a(this);
        this.h = tbPageContext;
        ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d022d, (ViewGroup) null);
        this.d = viewGroup;
        this.g = (TextView) viewGroup.findViewById(R.id.obfuscated_res_0x7f0907a2);
        this.e = (BdListView) this.d.findViewById(R.id.obfuscated_res_0x7f09078a);
        this.f = new pq4(this.h);
    }

    public void b(b9<?> b9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, b9Var) == null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            if (b9Var instanceof TbPageContext) {
                TbPageContext tbPageContext = (TbPageContext) b9Var;
                tbPageContext.getLayoutMode().k(skinType == 1);
                tbPageContext.getLayoutMode().j(this.d);
            }
            this.d.setBackgroundResource(R.drawable.obfuscated_res_0x7f081233);
        }
    }

    public hq4 c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (this.i) {
                return this;
            }
            this.i = true;
            if (!TextUtils.isEmpty(this.a)) {
                this.g.setText(this.a);
                this.g.setVisibility(0);
            } else {
                this.g.setVisibility(8);
            }
            this.e.setAdapter((ListAdapter) this.f);
            this.f.c(this.b);
            b(this.h);
            return this;
        }
        return (hq4) invokeV.objValue;
    }

    public void d() {
        AlertDialog alertDialog;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (alertDialog = this.j) == null) {
            return;
        }
        og.a(alertDialog, this.h.getPageActivity());
    }

    public View e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.d : (View) invokeV.objValue;
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            d();
        }
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            b(this.h);
            pq4 pq4Var = this.f;
            if (pq4Var != null) {
                pq4Var.notifyDataSetChanged();
            }
        }
    }

    public void h(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i) == null) {
            for (int i2 = 0; i2 < this.b.size(); i2++) {
                if (i2 == i) {
                    this.b.get(i2).e(true);
                } else {
                    this.b.get(i2).e(false);
                }
            }
            this.f.c(this.b);
        }
    }

    public void i(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            this.f.b(z);
        }
    }

    public void j(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) {
            for (int i2 = 0; i2 < this.b.size(); i2++) {
                if (i2 == i) {
                    qq4 qq4Var = this.b.get(i2);
                    qq4Var.e(!qq4Var.d());
                }
            }
            this.f.c(this.b);
        }
    }

    public hq4 k(ArrayList<qq4> arrayList, AdapterView.OnItemClickListener onItemClickListener) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048585, this, arrayList, onItemClickListener)) == null) {
            if (arrayList != null && arrayList.size() > 0) {
                this.b = arrayList;
                if (onItemClickListener != null) {
                    this.c = onItemClickListener;
                    this.e.setOnItemClickListener(this.k);
                }
            }
            return this;
        }
        return (hq4) invokeLL.objValue;
    }

    public hq4 l(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048586, this, i)) == null) {
            m(this.h.getResources().getString(i));
            return this;
        }
        return (hq4) invokeI.objValue;
    }

    public hq4 m(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, str)) == null) {
            this.a = str;
            return this;
        }
        return (hq4) invokeL.objValue;
    }

    public hq4 n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            if (this.i) {
                AlertDialog alertDialog = this.j;
                if (alertDialog != null) {
                    og.j(alertDialog, this.h);
                    return this;
                }
                AlertDialog create = new AlertDialog.Builder(this.h.getPageActivity()).create();
                this.j = create;
                create.setCanceledOnTouchOutside(true);
                if (og.i(this.j, this.h.getPageActivity())) {
                    Window window = this.j.getWindow();
                    window.addFlags(512);
                    WindowManager.LayoutParams attributes = window.getAttributes();
                    attributes.y = li.f(TbadkCoreApplication.getInst(), R.dimen._bottom_enter_anim_place_holder_height);
                    window.setAttributes(attributes);
                    window.setWindowAnimations(R.style.obfuscated_res_0x7f1003ee);
                    window.setGravity(80);
                    window.setLayout(-1, -2);
                    window.setContentView(this.d);
                    return this;
                }
                return this;
            }
            throw new RuntimeException("Dialog must be created by function create()!");
        }
        return (hq4) invokeV.objValue;
    }
}
