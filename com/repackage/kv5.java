package com.repackage;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.jv5;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes6.dex */
public class kv5 implements jv5, View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;
    public LinearLayout b;
    public TextView c;
    public TextView d;
    public TextView e;
    public TextView f;
    public TextView g;
    public iv5 h;
    public jv5.a i;
    public int j;
    public Map<Integer, Float> k;

    public kv5(TbPageContext tbPageContext, iv5 iv5Var, jv5.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, iv5Var, aVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.j = 0;
        this.k = new HashMap();
        this.a = tbPageContext;
        this.h = iv5Var;
        this.i = aVar;
        e();
    }

    @Override // com.repackage.jv5
    public float a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.k.get(Integer.valueOf(this.j)).floatValue() : invokeV.floatValue;
    }

    @Override // com.repackage.jv5
    public int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.b.getVisibility() : invokeV.intValue;
    }

    @Override // com.repackage.jv5
    public void c(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
            this.b.setVisibility(i);
        }
    }

    @Override // com.repackage.jv5
    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.j != 0 : invokeV.booleanValue;
    }

    public boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            this.k.put(0, Float.valueOf(1.0f));
            this.k.put(1, Float.valueOf(0.5f));
            this.k.put(2, Float.valueOf(0.33333334f));
            this.k.put(3, Float.valueOf(2.0f));
            this.k.put(4, Float.valueOf(3.0f));
            f();
            return true;
        }
        return invokeV.booleanValue;
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.b = (LinearLayout) this.a.getPageActivity().findViewById(R.id.obfuscated_res_0x7f0904b8);
            this.c = (TextView) this.a.getPageActivity().findViewById(R.id.obfuscated_res_0x7f091d4b);
            this.d = (TextView) this.a.getPageActivity().findViewById(R.id.obfuscated_res_0x7f091d4a);
            this.e = (TextView) this.a.getPageActivity().findViewById(R.id.obfuscated_res_0x7f091d49);
            this.f = (TextView) this.a.getPageActivity().findViewById(R.id.obfuscated_res_0x7f091d46);
            this.g = (TextView) this.a.getPageActivity().findViewById(R.id.obfuscated_res_0x7f091d47);
            this.c.setOnClickListener(this);
            this.d.setOnClickListener(this);
            this.e.setOnClickListener(this);
            this.f.setOnClickListener(this);
            this.g.setOnClickListener(this);
            wq4 d = wq4.d(this.b);
            d.n(R.string.J_X05);
            d.f(R.color.CAM_X0214);
            h(this.e, true);
            h(this.c, false);
            h(this.d, false);
            h(this.f, false);
            h(this.g, false);
        }
    }

    public final void g(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i) == null) {
            i(this.j, false);
            this.j = i;
            i(i, true);
            iv5 iv5Var = this.h;
            if (iv5Var != null) {
                iv5Var.a(a());
            }
        }
    }

    public final void h(TextView textView, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048583, this, textView, z) == null) {
            textView.setTextColor(this.a.getResources().getColor(z ? R.color.CAM_X0302 : R.color.CAM_X0101));
            textView.setTextSize(0, UtilHelper.getDimenPixelSize(z ? R.dimen.T_X05 : R.dimen.T_X07));
        }
    }

    public final void i(int i, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
            if (i == 0) {
                h(this.e, z);
            } else if (i == 1) {
                h(this.d, z);
            } else if (i == 2) {
                h(this.c, z);
            } else if (i == 3) {
                h(this.f, z);
            } else if (i != 4) {
            } else {
                h(this.g, z);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, view2) == null) {
            if (view2.getId() == R.id.obfuscated_res_0x7f091d4b) {
                jv5.a aVar = this.i;
                if (aVar == null || aVar.a(2)) {
                    g(2);
                }
            } else if (view2.getId() == R.id.obfuscated_res_0x7f091d4a) {
                jv5.a aVar2 = this.i;
                if (aVar2 == null || aVar2.a(1)) {
                    g(1);
                }
            } else if (view2.getId() == R.id.obfuscated_res_0x7f091d49) {
                jv5.a aVar3 = this.i;
                if (aVar3 == null || aVar3.a(0)) {
                    g(0);
                }
            } else if (view2.getId() == R.id.obfuscated_res_0x7f091d46) {
                jv5.a aVar4 = this.i;
                if (aVar4 == null || aVar4.a(3)) {
                    g(3);
                }
            } else if (view2.getId() == R.id.obfuscated_res_0x7f091d47) {
                jv5.a aVar5 = this.i;
                if (aVar5 == null || aVar5.a(4)) {
                    g(4);
                }
            }
        }
    }

    @Override // com.repackage.jv5
    public void reset() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            g(0);
        }
    }
}
