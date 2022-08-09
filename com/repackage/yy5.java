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
import com.repackage.xy5;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes7.dex */
public class yy5 implements xy5, View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;
    public LinearLayout b;
    public TextView c;
    public TextView d;
    public TextView e;
    public TextView f;
    public TextView g;
    public wy5 h;
    public xy5.a i;
    public int j;
    public Map<Integer, Float> k;

    public yy5(TbPageContext tbPageContext, wy5 wy5Var, xy5.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, wy5Var, aVar};
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
        this.h = wy5Var;
        this.i = aVar;
        d();
    }

    @Override // com.repackage.xy5
    public int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.b.getVisibility() : invokeV.intValue;
    }

    @Override // com.repackage.xy5
    public void b(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
            this.b.setVisibility(i);
        }
    }

    @Override // com.repackage.xy5
    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.j != 0 : invokeV.booleanValue;
    }

    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            this.k.put(0, Float.valueOf(1.0f));
            this.k.put(1, Float.valueOf(0.5f));
            this.k.put(2, Float.valueOf(0.33333334f));
            this.k.put(3, Float.valueOf(2.0f));
            this.k.put(4, Float.valueOf(3.0f));
            e();
            return true;
        }
        return invokeV.booleanValue;
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.b = (LinearLayout) this.a.getPageActivity().findViewById(R.id.obfuscated_res_0x7f0904b5);
            this.c = (TextView) this.a.getPageActivity().findViewById(R.id.obfuscated_res_0x7f091edc);
            this.d = (TextView) this.a.getPageActivity().findViewById(R.id.obfuscated_res_0x7f091edb);
            this.e = (TextView) this.a.getPageActivity().findViewById(R.id.obfuscated_res_0x7f091eda);
            this.f = (TextView) this.a.getPageActivity().findViewById(R.id.obfuscated_res_0x7f091ed7);
            this.g = (TextView) this.a.getPageActivity().findViewById(R.id.obfuscated_res_0x7f091ed8);
            this.c.setOnClickListener(this);
            this.d.setOnClickListener(this);
            this.e.setOnClickListener(this);
            this.f.setOnClickListener(this);
            this.g.setOnClickListener(this);
            ms4 d = ms4.d(this.b);
            d.n(R.string.J_X05);
            d.f(R.color.CAM_X0214);
            g(this.e, true);
            g(this.c, false);
            g(this.d, false);
            g(this.f, false);
            g(this.g, false);
        }
    }

    public final void f(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i) == null) {
            h(this.j, false);
            this.j = i;
            h(i, true);
            wy5 wy5Var = this.h;
            if (wy5Var != null) {
                wy5Var.a(getSpeed());
            }
        }
    }

    public final void g(TextView textView, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048582, this, textView, z) == null) {
            textView.setTextColor(this.a.getResources().getColor(z ? R.color.CAM_X0302 : R.color.CAM_X0101));
            textView.setTextSize(0, UtilHelper.getDimenPixelSize(z ? R.dimen.T_X05 : R.dimen.T_X07));
        }
    }

    @Override // com.repackage.xy5
    public float getSpeed() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.k.get(Integer.valueOf(this.j)).floatValue() : invokeV.floatValue;
    }

    public final void h(int i, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
            if (i == 0) {
                g(this.e, z);
            } else if (i == 1) {
                g(this.d, z);
            } else if (i == 2) {
                g(this.c, z);
            } else if (i == 3) {
                g(this.f, z);
            } else if (i != 4) {
            } else {
                g(this.g, z);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, view2) == null) {
            if (view2.getId() == R.id.obfuscated_res_0x7f091edc) {
                xy5.a aVar = this.i;
                if (aVar == null || aVar.a(2)) {
                    f(2);
                }
            } else if (view2.getId() == R.id.obfuscated_res_0x7f091edb) {
                xy5.a aVar2 = this.i;
                if (aVar2 == null || aVar2.a(1)) {
                    f(1);
                }
            } else if (view2.getId() == R.id.obfuscated_res_0x7f091eda) {
                xy5.a aVar3 = this.i;
                if (aVar3 == null || aVar3.a(0)) {
                    f(0);
                }
            } else if (view2.getId() == R.id.obfuscated_res_0x7f091ed7) {
                xy5.a aVar4 = this.i;
                if (aVar4 == null || aVar4.a(3)) {
                    f(3);
                }
            } else if (view2.getId() == R.id.obfuscated_res_0x7f091ed8) {
                xy5.a aVar5 = this.i;
                if (aVar5 == null || aVar5.a(4)) {
                    f(4);
                }
            }
        }
    }

    @Override // com.repackage.xy5
    public void reset() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            f(0);
        }
    }
}
