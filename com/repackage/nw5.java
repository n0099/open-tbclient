package com.repackage;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class nw5 implements mw5, View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public float a;
    public TbPageContext b;
    public LinearLayout c;
    public ImageView d;
    public ImageView e;
    public ImageView f;
    public ImageView g;
    public ImageView h;
    public RelativeLayout i;
    public RelativeLayout j;
    public RelativeLayout k;
    public RelativeLayout l;
    public RelativeLayout m;
    public lw5 n;
    public float o;
    public float p;

    public nw5(TbPageContext tbPageContext, int i, int i2, lw5 lw5Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, Integer.valueOf(i), Integer.valueOf(i2), lw5Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = tbPageContext;
        this.n = lw5Var;
        float f = (i * 1.0f) / i2;
        this.a = f;
        this.o = f;
        this.p = 0.0f;
        a();
    }

    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            LinearLayout linearLayout = (LinearLayout) this.b.getPageActivity().findViewById(R.id.obfuscated_res_0x7f0904b2);
            this.c = linearLayout;
            vr4 d = vr4.d(linearLayout);
            d.n(R.string.J_X05);
            d.f(R.color.CAM_X0214);
            this.d = (ImageView) this.b.getPageActivity().findViewById(R.id.obfuscated_res_0x7f0919b4);
            this.i = (RelativeLayout) this.b.getPageActivity().findViewById(R.id.obfuscated_res_0x7f0919b5);
            this.g = (ImageView) this.b.getPageActivity().findViewById(R.id.obfuscated_res_0x7f0919b2);
            this.l = (RelativeLayout) this.b.getPageActivity().findViewById(R.id.obfuscated_res_0x7f0919b3);
            this.f = (ImageView) this.b.getPageActivity().findViewById(R.id.obfuscated_res_0x7f0919b0);
            this.k = (RelativeLayout) this.b.getPageActivity().findViewById(R.id.obfuscated_res_0x7f0919b1);
            this.e = (ImageView) this.b.getPageActivity().findViewById(R.id.obfuscated_res_0x7f0919ac);
            this.j = (RelativeLayout) this.b.getPageActivity().findViewById(R.id.obfuscated_res_0x7f0919ad);
            this.h = (ImageView) this.b.getPageActivity().findViewById(R.id.obfuscated_res_0x7f0919ae);
            this.m = (RelativeLayout) this.b.getPageActivity().findViewById(R.id.obfuscated_res_0x7f0919af);
            g();
            this.i.setOnClickListener(this);
            this.l.setOnClickListener(this);
            this.k.setOnClickListener(this);
            this.j.setOnClickListener(this);
            this.m.setOnClickListener(this);
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.repackage.mw5
    public int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.c.getVisibility() : invokeV.intValue;
    }

    @Override // com.repackage.mw5
    public void c(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
            this.c.setVisibility(i);
        }
    }

    @Override // com.repackage.mw5
    public void d(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
            this.i.setVisibility(i);
            if (i == 8) {
                this.p = 1.7777778f;
                f(1.7777778f);
            }
        }
    }

    @Override // com.repackage.mw5
    public float e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.p : invokeV.floatValue;
    }

    public void f(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048581, this, f) == null) {
            this.o = f;
            lw5 lw5Var = this.n;
            if (lw5Var != null) {
                lw5Var.a(f);
            }
            g();
        }
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.d.setImageDrawable(this.b.getResources().getDrawable(R.drawable.obfuscated_res_0x7f080985));
            this.g.setImageDrawable(this.b.getResources().getDrawable(R.drawable.obfuscated_res_0x7f080984));
            this.f.setImageDrawable(this.b.getResources().getDrawable(R.drawable.obfuscated_res_0x7f080983));
            this.e.setImageDrawable(this.b.getResources().getDrawable(R.drawable.obfuscated_res_0x7f080981));
            this.h.setImageDrawable(this.b.getResources().getDrawable(R.drawable.obfuscated_res_0x7f080982));
            float f = this.p;
            if (f == 0.0f) {
                this.d.setImageDrawable(WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f080985, this.b.getResources().getColor(R.color.CAM_X0302), null));
            } else if (f == 1.7777778f) {
                this.g.setImageDrawable(WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f080984, this.b.getResources().getColor(R.color.CAM_X0302), null));
            } else if (f == 1.3333334f) {
                this.f.setImageDrawable(WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f080983, this.b.getResources().getColor(R.color.CAM_X0302), null));
            } else if (f == 0.5625f) {
                this.e.setImageDrawable(WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f080981, this.b.getResources().getColor(R.color.CAM_X0302), null));
            } else if (f == 1.0f) {
                this.h.setImageDrawable(WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f080982, this.b.getResources().getColor(R.color.CAM_X0302), null));
            }
        }
    }

    @Override // com.repackage.mw5
    public float getRatio() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.o : invokeV.floatValue;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, view2) == null) {
            if (view2.getId() == R.id.obfuscated_res_0x7f0919b5) {
                this.p = 0.0f;
                f(this.a);
            } else if (view2.getId() == R.id.obfuscated_res_0x7f0919b3) {
                this.p = 1.7777778f;
                f(1.7777778f);
            } else if (view2.getId() == R.id.obfuscated_res_0x7f0919b1) {
                this.p = 1.3333334f;
                f(1.3333334f);
            } else if (view2.getId() == R.id.obfuscated_res_0x7f0919ad) {
                this.p = 0.5625f;
                f(0.5625f);
            } else if (view2.getId() == R.id.obfuscated_res_0x7f0919af) {
                this.p = 1.0f;
                f(1.0f);
            }
        }
    }

    @Override // com.repackage.mw5
    public void reset() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.p = 0.0f;
            f(this.a);
        }
    }

    public nw5(TbPageContext tbPageContext, lw5 lw5Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, lw5Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.b = tbPageContext;
        this.n = lw5Var;
        this.a = 1.7777778f;
        this.o = 1.7777778f;
        this.p = 0.0f;
        a();
    }
}
