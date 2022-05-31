package com.repackage;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.text.method.MovementMethod;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.StringRes;
import androidx.appcompat.app.AlertDialog;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.dialog.TBAlertConfig;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class rq4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final AlertDialog.Builder a;
    public final Activity b;
    public boolean c;
    public AlertDialog d;
    public View e;
    public CharSequence f;
    public CharSequence g;
    public CharSequence h;
    public int i;
    public boolean j;
    public MovementMethod k;
    public View l;
    public TBAlertConfig.b m;
    public boolean n;
    public boolean o;
    public View.OnClickListener p;
    public View.OnClickListener q;

    /* loaded from: classes7.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TextView a;
        public final /* synthetic */ View b;

        public a(rq4 rq4Var, TextView textView, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rq4Var, textView, view2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = textView;
            this.b = view2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && UtilHelper.getDimenPixelSize(R.dimen.tbds868) == this.a.getHeight()) {
                this.b.setVisibility(0);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ rq4 a;

        public b(rq4 rq4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rq4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = rq4Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || this.a.d == null) {
                return;
            }
            this.a.d.dismiss();
        }
    }

    /* loaded from: classes7.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ rq4 a;

        public c(rq4 rq4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rq4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = rq4Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (this.a.d != null) {
                    this.a.d.dismiss();
                }
                if (this.a.q != null) {
                    this.a.q.onClick(view2);
                }
            }
        }
    }

    public rq4(@NonNull Activity activity) {
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
        this.i = 17;
        this.k = ScrollingMovementMethod.getInstance();
        this.b = activity;
        this.a = new AlertDialog.Builder(activity);
    }

    public static void e(@NonNull Dialog dialog) {
        Window window;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65539, null, dialog) == null) || (window = dialog.getWindow()) == null) {
            return;
        }
        window.setBackgroundDrawableResource(17170445);
    }

    public static void f(@NonNull Dialog dialog) {
        Window window;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, dialog) == null) || (window = dialog.getWindow()) == null) {
            return;
        }
        Context context = dialog.getContext();
        int i = context.getResources().getDisplayMetrics().widthPixels;
        int i2 = (i * 837) / 1076;
        int f = li.f(context, R.dimen.tbds756);
        if (i2 < f) {
            i2 = Math.min(i, f);
        }
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.width = i2;
        window.getDecorView().setPadding(0, 0, 0, 0);
        window.setAttributes(attributes);
    }

    public AlertDialog c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (!this.c) {
                this.c = true;
                w();
                this.d = this.a.create();
            }
            return this.d;
        }
        return (AlertDialog) invokeV.objValue;
    }

    public void d() {
        AlertDialog alertDialog;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (alertDialog = this.d) == null) {
            return;
        }
        alertDialog.dismiss();
    }

    public rq4 g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            this.o = true;
            return this;
        }
        return (rq4) invokeV.objValue;
    }

    public rq4 h(View.OnClickListener onClickListener) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, onClickListener)) == null) {
            this.q = onClickListener;
            return this;
        }
        return (rq4) invokeL.objValue;
    }

    public rq4 i(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048580, this, z)) == null) {
            this.a.setCancelable(z);
            return this;
        }
        return (rq4) invokeZ.objValue;
    }

    public rq4 j(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, view2)) == null) {
            this.l = view2;
            return this;
        }
        return (rq4) invokeL.objValue;
    }

    public rq4 k(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, view2)) == null) {
            this.e = view2;
            return this;
        }
        return (rq4) invokeL.objValue;
    }

    public rq4 l(@StringRes int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i)) == null) {
            this.h = TbadkCoreApplication.getInst().getResources().getString(i);
            return this;
        }
        return (rq4) invokeI.objValue;
    }

    public rq4 m(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i)) == null) {
            this.i = i;
            return this;
        }
        return (rq4) invokeI.objValue;
    }

    public rq4 n(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048585, this, z)) == null) {
            this.j = z;
            return this;
        }
        return (rq4) invokeZ.objValue;
    }

    public rq4 o(MovementMethod movementMethod) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, movementMethod)) == null) {
            this.k = movementMethod;
            return this;
        }
        return (rq4) invokeL.objValue;
    }

    public rq4 p(CharSequence charSequence) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, charSequence)) == null) {
            this.h = charSequence;
            return this;
        }
        return (rq4) invokeL.objValue;
    }

    public rq4 q(DialogInterface.OnDismissListener onDismissListener) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, onDismissListener)) == null) {
            this.a.setOnDismissListener(onDismissListener);
            return this;
        }
        return (rq4) invokeL.objValue;
    }

    public rq4 r(TBAlertConfig.a... aVarArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, aVarArr)) == null) {
            int length = aVarArr.length;
            if (length == 1) {
                this.m = TBAlertConfig.a(aVarArr[0]);
            } else if (length == 2) {
                this.m = TBAlertConfig.c(aVarArr[0], aVarArr[1]);
            } else if (length == 3) {
                this.m = TBAlertConfig.b(aVarArr[0], aVarArr[1], aVarArr[2]);
            }
            return this;
        }
        return (rq4) invokeL.objValue;
    }

    public rq4 s(TBAlertConfig.b bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, bVar)) == null) {
            this.m = bVar;
            return this;
        }
        return (rq4) invokeL.objValue;
    }

    public rq4 t(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048591, this, z)) == null) {
            this.n = z;
            return this;
        }
        return (rq4) invokeZ.objValue;
    }

    public rq4 u(@StringRes int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048592, this, i)) == null) {
            this.f = TbadkCoreApplication.getInst().getResources().getString(i);
            return this;
        }
        return (rq4) invokeI.objValue;
    }

    public rq4 v(CharSequence charSequence) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, charSequence)) == null) {
            this.f = charSequence;
            return this;
        }
        return (rq4) invokeL.objValue;
    }

    public final void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            LinearLayout linearLayout = new LinearLayout(this.b);
            linearLayout.setOrientation(1);
            linearLayout.setGravity(17);
            linearLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
            View view2 = this.e;
            if (view2 != null) {
                if (view2.getLayoutParams() == null) {
                    linearLayout.addView(this.e, new ViewGroup.LayoutParams(-1, -2));
                } else {
                    linearLayout.addView(this.e);
                }
            }
            LinearLayout linearLayout2 = new LinearLayout(this.b);
            linearLayout2.setOrientation(1);
            linearLayout2.setGravity(17);
            linearLayout2.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
            wq4 d = wq4.d(linearLayout2);
            d.m(this.e == null ? 0 : 2);
            d.n(R.string.J_X06);
            d.f(R.color.CAM_X0205);
            TextView k = sq4.k(this.b);
            k.setText(this.f);
            k.setPadding(UtilHelper.getDimenPixelSize(R.dimen.M_W_X013), UtilHelper.getDimenPixelSize(R.dimen.M_H_X009), UtilHelper.getDimenPixelSize(R.dimen.M_W_X013), UtilHelper.getDimenPixelSize(R.dimen.M_H_X007));
            linearLayout2.addView(k);
            CharSequence charSequence = this.g;
            if (charSequence != null && !StringUtils.isNull(charSequence.toString())) {
                k.setPadding(k.getPaddingLeft(), k.getPaddingTop(), k.getPaddingRight(), UtilHelper.getDimenPixelSize(R.dimen.M_H_X003));
                TextView k2 = sq4.k(this.b);
                k2.setText(this.g);
                k2.setPadding(UtilHelper.getDimenPixelSize(R.dimen.M_W_X013), 0, UtilHelper.getDimenPixelSize(R.dimen.M_W_X013), UtilHelper.getDimenPixelSize(R.dimen.M_H_X007));
                linearLayout2.addView(k2);
            }
            if (!TextUtils.isEmpty(this.h)) {
                RelativeLayout relativeLayout = new RelativeLayout(this.b);
                relativeLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
                TextView b2 = sq4.b(this.b, this.j);
                b2.setText(this.h);
                b2.setGravity(this.i);
                b2.setId(R.id.obfuscated_res_0x7f090762);
                b2.setPadding(UtilHelper.getDimenPixelSize(R.dimen.M_W_X013), 0, UtilHelper.getDimenPixelSize(R.dimen.M_W_X013), 0);
                b2.setMaxHeight(UtilHelper.getDimenPixelSize(R.dimen.tbds868));
                b2.setMovementMethod(this.k);
                relativeLayout.addView(b2, new ViewGroup.LayoutParams(-1, -2));
                View view3 = new View(this.b);
                view3.setVisibility(4);
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, UtilHelper.getDimenPixelSize(R.dimen.tbds104));
                layoutParams.addRule(8, R.id.obfuscated_res_0x7f090762);
                SkinManager.setBackgroundColorToTransparent(view3, R.color.CAM_X0205, GradientDrawable.Orientation.BOTTOM_TOP);
                relativeLayout.addView(view3, layoutParams);
                linearLayout2.addView(relativeLayout);
                b2.post(new a(this, b2, view3));
            }
            View view4 = this.l;
            if (view4 != null) {
                linearLayout2.addView(view4, new ViewGroup.LayoutParams(-1, -2));
            }
            if (this.m != null) {
                if (this.o) {
                    this.p = new b(this);
                }
                linearLayout2.addView(sq4.i(this.b, this.m, this.p));
            }
            linearLayout.addView(linearLayout2, new ViewGroup.LayoutParams(-1, -2));
            if (this.n) {
                ImageView imageView = new ImageView(this.b);
                imageView.setImageResource(R.drawable.obfuscated_res_0x7f0807f9);
                LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(li.f(TbadkCoreApplication.getInst(), R.dimen.tbds104), li.f(TbadkCoreApplication.getInst(), R.dimen.tbds105));
                layoutParams2.setMargins(0, li.f(TbadkCoreApplication.getInst(), R.dimen.M_H_X010), 0, 0);
                imageView.setOnClickListener(new c(this));
                linearLayout.addView(imageView, layoutParams2);
            }
            this.a.setView(linearLayout);
        }
    }

    public AlertDialog x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            AlertDialog c2 = c();
            y(c2);
            return c2;
        }
        return (AlertDialog) invokeV.objValue;
    }

    public AlertDialog y(AlertDialog alertDialog) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048596, this, alertDialog)) == null) {
            alertDialog.show();
            e(alertDialog);
            f(alertDialog);
            return alertDialog;
        }
        return (AlertDialog) invokeL.objValue;
    }
}
