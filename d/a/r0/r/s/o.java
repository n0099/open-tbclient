package d.a.r0.r.s;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
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
/* loaded from: classes9.dex */
public class o {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final AlertDialog.Builder f56222a;

    /* renamed from: b  reason: collision with root package name */
    public final Activity f56223b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f56224c;

    /* renamed from: d  reason: collision with root package name */
    public AlertDialog f56225d;

    /* renamed from: e  reason: collision with root package name */
    public View f56226e;

    /* renamed from: f  reason: collision with root package name */
    public String f56227f;

    /* renamed from: g  reason: collision with root package name */
    public String f56228g;

    /* renamed from: h  reason: collision with root package name */
    public int f56229h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f56230i;
    public View j;
    public TBAlertConfig.b k;
    public boolean l;
    public boolean m;
    public View.OnClickListener n;
    public View.OnClickListener o;

    /* loaded from: classes9.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ TextView f56231e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ View f56232f;

        public a(o oVar, TextView textView, View view) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {oVar, textView, view};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f56231e = textView;
            this.f56232f = view;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && UtilHelper.getDimenPixelSize(R.dimen.tbds868) == this.f56231e.getHeight()) {
                this.f56232f.setVisibility(0);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ o f56233e;

        public b(o oVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {oVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f56233e = oVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f56233e.f56225d == null) {
                return;
            }
            this.f56233e.f56225d.dismiss();
        }
    }

    /* loaded from: classes9.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ o f56234e;

        public c(o oVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {oVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f56234e = oVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (this.f56234e.f56225d != null) {
                    this.f56234e.f56225d.dismiss();
                }
                if (this.f56234e.o != null) {
                    this.f56234e.o.onClick(view);
                }
            }
        }
    }

    public o(@NonNull Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {activity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f56229h = 17;
        this.f56223b = activity;
        this.f56222a = new AlertDialog.Builder(activity);
    }

    public static void d(@NonNull Dialog dialog) {
        Window window;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65539, null, dialog) == null) || (window = dialog.getWindow()) == null) {
            return;
        }
        window.setBackgroundDrawableResource(17170445);
    }

    public static void e(@NonNull Dialog dialog) {
        Window window;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65540, null, dialog) == null) || (window = dialog.getWindow()) == null) {
            return;
        }
        Context context = dialog.getContext();
        int i2 = context.getResources().getDisplayMetrics().widthPixels;
        int i3 = (i2 * 837) / 1076;
        int g2 = d.a.c.e.p.l.g(context, R.dimen.tbds756);
        if (i3 < g2) {
            i3 = Math.min(i2, g2);
        }
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.width = i3;
        window.getDecorView().setPadding(0, 0, 0, 0);
        window.setAttributes(attributes);
    }

    public AlertDialog c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (!this.f56224c) {
                this.f56224c = true;
                q();
                this.f56225d = this.f56222a.create();
            }
            return this.f56225d;
        }
        return (AlertDialog) invokeV.objValue;
    }

    public o f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            this.m = true;
            return this;
        }
        return (o) invokeV.objValue;
    }

    public o g(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z)) == null) {
            this.f56222a.setCancelable(z);
            return this;
        }
        return (o) invokeZ.objValue;
    }

    public o h(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, view)) == null) {
            this.j = view;
            return this;
        }
        return (o) invokeL.objValue;
    }

    public o i(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, view)) == null) {
            this.f56226e = view;
            return this;
        }
        return (o) invokeL.objValue;
    }

    public o j(@StringRes int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i2)) == null) {
            this.f56228g = TbadkCoreApplication.getInst().getResources().getString(i2);
            return this;
        }
        return (o) invokeI.objValue;
    }

    public o k(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i2)) == null) {
            this.f56229h = i2;
            return this;
        }
        return (o) invokeI.objValue;
    }

    public o l(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048583, this, z)) == null) {
            this.f56230i = z;
            return this;
        }
        return (o) invokeZ.objValue;
    }

    public o m(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str)) == null) {
            this.f56228g = str;
            return this;
        }
        return (o) invokeL.objValue;
    }

    public o n(DialogInterface.OnDismissListener onDismissListener) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, onDismissListener)) == null) {
            this.f56222a.setOnDismissListener(onDismissListener);
            return this;
        }
        return (o) invokeL.objValue;
    }

    public o o(TBAlertConfig.a... aVarArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, aVarArr)) == null) {
            int length = aVarArr.length;
            if (length == 1) {
                this.k = TBAlertConfig.a(aVarArr[0]);
            } else if (length == 2) {
                this.k = TBAlertConfig.c(aVarArr[0], aVarArr[1]);
            } else if (length == 3) {
                this.k = TBAlertConfig.b(aVarArr[0], aVarArr[1], aVarArr[2]);
            }
            return this;
        }
        return (o) invokeL.objValue;
    }

    public o p(@StringRes int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048587, this, i2)) == null) {
            this.f56227f = TbadkCoreApplication.getInst().getResources().getString(i2);
            return this;
        }
        return (o) invokeI.objValue;
    }

    public final void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            LinearLayout linearLayout = new LinearLayout(this.f56223b);
            linearLayout.setOrientation(1);
            linearLayout.setGravity(17);
            linearLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
            View view = this.f56226e;
            if (view != null) {
                if (view.getLayoutParams() == null) {
                    linearLayout.addView(this.f56226e, new ViewGroup.LayoutParams(-1, -2));
                } else {
                    linearLayout.addView(this.f56226e);
                }
            }
            LinearLayout linearLayout2 = new LinearLayout(this.f56223b);
            linearLayout2.setOrientation(1);
            linearLayout2.setGravity(17);
            linearLayout2.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
            d.a.r0.r.u.c d2 = d.a.r0.r.u.c.d(linearLayout2);
            d2.m(this.f56226e == null ? 0 : 2);
            d2.n(R.string.J_X06);
            d2.f(R.color.CAM_X0205);
            TextView k = p.k(this.f56223b);
            k.setText(this.f56227f);
            k.setPadding(UtilHelper.getDimenPixelSize(R.dimen.M_W_X013), UtilHelper.getDimenPixelSize(R.dimen.M_H_X009), UtilHelper.getDimenPixelSize(R.dimen.M_W_X013), UtilHelper.getDimenPixelSize(R.dimen.M_H_X007));
            linearLayout2.addView(k);
            if (!TextUtils.isEmpty(this.f56228g)) {
                RelativeLayout relativeLayout = new RelativeLayout(this.f56223b);
                relativeLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
                TextView b2 = p.b(this.f56223b, this.f56230i);
                b2.setText(this.f56228g);
                b2.setGravity(this.f56229h);
                b2.setId(R.id.desc);
                b2.setPadding(UtilHelper.getDimenPixelSize(R.dimen.M_W_X013), 0, UtilHelper.getDimenPixelSize(R.dimen.M_W_X013), 0);
                b2.setMaxHeight(UtilHelper.getDimenPixelSize(R.dimen.tbds868));
                b2.setMovementMethod(ScrollingMovementMethod.getInstance());
                relativeLayout.addView(b2, new ViewGroup.LayoutParams(-1, -2));
                View view2 = new View(this.f56223b);
                view2.setVisibility(4);
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, UtilHelper.getDimenPixelSize(R.dimen.tbds104));
                layoutParams.addRule(8, R.id.desc);
                SkinManager.setBackgroundColorToTransparent(view2, R.color.CAM_X0205, GradientDrawable.Orientation.BOTTOM_TOP);
                relativeLayout.addView(view2, layoutParams);
                linearLayout2.addView(relativeLayout);
                b2.post(new a(this, b2, view2));
            }
            View view3 = this.j;
            if (view3 != null) {
                linearLayout2.addView(view3, new ViewGroup.LayoutParams(-1, -2));
            }
            if (this.k != null) {
                if (this.m) {
                    this.n = new b(this);
                }
                linearLayout2.addView(p.i(this.f56223b, this.k, this.n));
            }
            linearLayout.addView(linearLayout2, new ViewGroup.LayoutParams(-1, -2));
            if (this.l) {
                ImageView imageView = new ImageView(this.f56223b);
                imageView.setImageResource(R.drawable.icon_mask_pop_close);
                LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(d.a.c.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds104), d.a.c.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds105));
                layoutParams2.setMargins(0, d.a.c.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.M_H_X010), 0, 0);
                imageView.setOnClickListener(new c(this));
                linearLayout.addView(imageView, layoutParams2);
            }
            this.f56222a.setView(linearLayout);
        }
    }

    public AlertDialog r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            AlertDialog c2 = c();
            s(c2);
            return c2;
        }
        return (AlertDialog) invokeV.objValue;
    }

    public AlertDialog s(AlertDialog alertDialog) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, alertDialog)) == null) {
            alertDialog.show();
            d(alertDialog);
            e(alertDialog);
            return alertDialog;
        }
        return (AlertDialog) invokeL.objValue;
    }
}
