package com.repackage;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes7.dex */
public class rf8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public String b;
    public View c;
    public int d;
    public int e;
    public int f;
    public String g;
    public String h;
    public String i;
    public String j;
    public c k;
    public c l;
    public c m;
    public DialogInterface.OnCancelListener n;
    public DialogInterface.OnKeyListener o;
    public AlertDialog p;
    public final Activity q;
    public final ViewGroup r;
    public boolean s;
    public boolean t;

    /* loaded from: classes7.dex */
    public class a implements ViewHelper.ViewCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AtomicBoolean a;

        public a(rf8 rf8Var, AtomicBoolean atomicBoolean) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rf8Var, atomicBoolean};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = atomicBoolean;
        }

        @Override // com.baidu.tbadk.core.util.ViewHelper.ViewCallback
        public boolean onViewFound(View view2) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, view2)) == null) {
                if (view2 instanceof EditText) {
                    this.a.set(true);
                    return true;
                }
                return false;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes7.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final rf8 a;
        public final c b;

        public b(rf8 rf8Var, rf8 rf8Var2, c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rf8Var, rf8Var2, cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = rf8Var2;
            this.b = cVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            c cVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || (cVar = this.b) == null) {
                return;
            }
            cVar.a(this.a);
        }
    }

    /* loaded from: classes7.dex */
    public interface c {
        void a(rf8 rf8Var);
    }

    public rf8(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {activity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = -1;
        this.d = -1;
        this.e = R.drawable.btn_blue_bg;
        this.f = R.color.CAM_X0111;
        this.s = false;
        this.t = true;
        this.q = activity;
        this.r = (ViewGroup) LayoutInflater.from(activity).inflate(R.layout.obfuscated_res_0x7f0d0236, (ViewGroup) null);
    }

    public final void a(b9<?> b9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, b9Var) == null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            if (b9Var instanceof TbPageContext) {
                TbPageContext tbPageContext = (TbPageContext) b9Var;
                tbPageContext.getLayoutMode().k(skinType == 1);
                tbPageContext.getLayoutMode().j(this.r);
            }
        }
    }

    public rf8 b(b9<?> b9Var) {
        InterceptResult invokeL;
        boolean z;
        boolean z2;
        boolean z3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, b9Var)) == null) {
            if (this.s) {
                return this;
            }
            this.s = true;
            a(b9Var);
            TextView textView = (TextView) this.r.findViewById(R.id.obfuscated_res_0x7f092013);
            LinearLayout linearLayout = (LinearLayout) this.r.findViewById(R.id.obfuscated_res_0x7f0906e0);
            ImageView imageView = (ImageView) this.r.findViewById(R.id.obfuscated_res_0x7f09034d);
            TextView textView2 = (TextView) this.r.findViewById(R.id.obfuscated_res_0x7f0913f5);
            Button button = (Button) this.r.findViewById(R.id.obfuscated_res_0x7f092493);
            SkinManager.setBackgroundResource(button, this.e);
            SkinManager.setViewTextColor(button, this.f, 3);
            Button button2 = (Button) this.r.findViewById(R.id.obfuscated_res_0x7f091579);
            Button button3 = (Button) this.r.findViewById(R.id.obfuscated_res_0x7f090495);
            if (!TextUtils.isEmpty(this.b)) {
                textView.setText(this.b);
            } else {
                textView.setVisibility(8);
            }
            if (this.c != null) {
                linearLayout.removeAllViews();
                linearLayout.addView(this.c);
            }
            int i = this.d;
            if (i != -1) {
                SkinManager.setImageResource(imageView, i);
                imageView.setVisibility(0);
            } else {
                imageView.setVisibility(8);
            }
            if (!TextUtils.isEmpty(this.g)) {
                textView2.setText(this.g);
            }
            if (TextUtils.isEmpty(this.h)) {
                z = false;
            } else {
                button.setText(this.h);
                c cVar = this.k;
                if (cVar != null) {
                    button.setOnClickListener(new b(this, this, cVar));
                }
                z = true;
            }
            if (TextUtils.isEmpty(this.i)) {
                z2 = false;
            } else {
                button2.setText(this.i);
                c cVar2 = this.l;
                if (cVar2 != null) {
                    button2.setOnClickListener(new b(this, this, cVar2));
                }
                z2 = true;
            }
            if (TextUtils.isEmpty(this.j)) {
                z3 = false;
            } else {
                button3.setText(this.j);
                c cVar3 = this.m;
                if (cVar3 != null) {
                    button3.setOnClickListener(new b(this, this, cVar3));
                }
                z3 = true;
            }
            e(z, z2, z3, button, button2, button3);
            return this;
        }
        return (rf8) invokeL.objValue;
    }

    public final int c(Context context, float f) {
        InterceptResult invokeLF;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLF = interceptable.invokeLF(Constants.METHOD_SEND_USER_MSG, this, context, f)) == null) ? (int) ((f * context.getResources().getDisplayMetrics().density) + 0.5f) : invokeLF.intValue;
    }

    public void d() {
        AlertDialog alertDialog;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (alertDialog = this.p) == null) {
            return;
        }
        rg.a(alertDialog, this.q);
    }

    public final void e(boolean z, boolean z2, boolean z3, Button button, Button button2, Button button3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3), button, button2, button3}) == null) {
            boolean[] zArr = {z2, z, z3};
            Button[] buttonArr = {button2, button, button3};
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < 3; i++) {
                if (zArr[i]) {
                    arrayList.add(buttonArr[i]);
                    buttonArr[i].setVisibility(0);
                } else {
                    buttonArr[i].setVisibility(8);
                }
            }
            if (arrayList.size() == 3) {
                int i2 = 0;
                while (i2 < 3) {
                    f((Button) arrayList.get(i2), 0, i2 == 2 ? 0 : 20);
                    i2++;
                }
            }
            if (arrayList.size() == 2) {
                int i3 = 0;
                while (i3 < 2) {
                    f((Button) arrayList.get(i3), 0, i3 == 1 ? 0 : 20);
                    i3++;
                }
            }
            if (arrayList.size() == 1) {
                f((Button) arrayList.get(0), 0, 0);
            }
        }
    }

    public final void f(Button button, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048581, this, button, i, i2) == null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) button.getLayoutParams();
            layoutParams.width = c(this.q, i);
            layoutParams.rightMargin = i2;
            layoutParams.weight = 1.0f;
            button.setLayoutParams(layoutParams);
        }
    }

    public rf8 g(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048582, this, z)) == null) {
            this.t = z;
            return this;
        }
        return (rf8) invokeZ.objValue;
    }

    public rf8 h(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i)) == null) {
            this.d = i;
            return this;
        }
        return (rf8) invokeI.objValue;
    }

    public rf8 i(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i)) == null) {
            Activity activity = this.q;
            if (activity != null) {
                this.g = activity.getResources().getString(i);
            }
            return this;
        }
        return (rf8) invokeI.objValue;
    }

    public rf8 j(int i, c cVar) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048585, this, i, cVar)) == null) {
            Activity activity = this.q;
            if (activity != null) {
                this.i = activity.getResources().getString(i);
                this.l = cVar;
            }
            return this;
        }
        return (rf8) invokeIL.objValue;
    }

    public rf8 k(DialogInterface.OnKeyListener onKeyListener) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, onKeyListener)) == null) {
            this.o = onKeyListener;
            return this;
        }
        return (rf8) invokeL.objValue;
    }

    public rf8 l(int i, c cVar) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048587, this, i, cVar)) == null) {
            Activity activity = this.q;
            if (activity != null) {
                this.h = activity.getResources().getString(i);
                this.k = cVar;
            }
            return this;
        }
        return (rf8) invokeIL.objValue;
    }

    public rf8 m(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048588, this, i)) == null) {
            this.e = i;
            return this;
        }
        return (rf8) invokeI.objValue;
    }

    public rf8 n(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048589, this, i)) == null) {
            this.f = i;
            return this;
        }
        return (rf8) invokeI.objValue;
    }

    public rf8 o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            p(true);
            return this;
        }
        return (rf8) invokeV.objValue;
    }

    public final rf8 p(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048591, this, z)) == null) {
            if (this.s) {
                AlertDialog alertDialog = this.p;
                if (alertDialog != null) {
                    if (z) {
                        rg.i(alertDialog, this.q);
                    } else {
                        alertDialog.show();
                    }
                    return this;
                }
                AlertDialog create = new AlertDialog.Builder(this.q).create();
                this.p = create;
                create.setCanceledOnTouchOutside(this.t);
                DialogInterface.OnCancelListener onCancelListener = this.n;
                if (onCancelListener != null) {
                    this.p.setOnCancelListener(onCancelListener);
                }
                DialogInterface.OnKeyListener onKeyListener = this.o;
                if (onKeyListener != null) {
                    this.p.setOnKeyListener(onKeyListener);
                }
                if (z) {
                    rg.i(this.p, this.q);
                } else {
                    this.p.show();
                }
                Window window = this.p.getWindow();
                if (this.a == -1) {
                    this.a = 17;
                }
                window.setGravity(this.a);
                WindowManager.LayoutParams attributes = window.getAttributes();
                attributes.dimAmount = 0.5f;
                window.setAttributes(attributes);
                window.addFlags(2);
                window.setLayout(-2, -2);
                window.setContentView(this.r);
                AtomicBoolean atomicBoolean = new AtomicBoolean(false);
                ViewHelper.processAllViewsIn(this.r, false, new a(this, atomicBoolean));
                if (atomicBoolean.get()) {
                    window.clearFlags(131080);
                }
                return this;
            }
            throw new RuntimeException("Dialog must be created by function create()!");
        }
        return (rf8) invokeZ.objValue;
    }
}
