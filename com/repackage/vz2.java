package com.repackage;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.swan.apps.res.widget.toast.ToastLocation;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.view.SimpleDraweeView;
import com.repackage.zz2;
import java.lang.ref.WeakReference;
/* loaded from: classes7.dex */
public final class vz2 {
    public static /* synthetic */ Interceptable $ic;
    public static boolean a;
    public static WeakReference<xz2> b;
    public static Toast c;
    public static Handler d;
    public static zz2.b e;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public static class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Context a;
        public final /* synthetic */ RelativeLayout b;

        public a(Context context, RelativeLayout relativeLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context, relativeLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = context;
            this.b = relativeLayout;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                Toast unused = vz2.c = new Toast(this.a);
                vz2.c.setView(this.b);
                vz2.c.setGravity(17, 0, 0);
                yz2.k(vz2.c, R.style.obfuscated_res_0x7f100413);
                try {
                    vz2.c.show();
                } catch (NullPointerException e) {
                    if (vz2.a) {
                        e.printStackTrace();
                    }
                }
                if (vz2.a) {
                    Log.d("SingleToast", "mSystemToast.show() invoked in show");
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Context a;
        public final /* synthetic */ LinearLayout b;

        public b(Context context, LinearLayout linearLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context, linearLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = context;
            this.b = linearLayout;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                Toast unused = vz2.c = new Toast(this.a);
                vz2.c.setView(this.b);
                vz2.c.setGravity(17, 0, 0);
                yz2.k(vz2.c, R.style.obfuscated_res_0x7f1003af);
                vz2.c.show();
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Context a;
        public final /* synthetic */ LinearLayout b;

        public c(Context context, LinearLayout linearLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context, linearLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = context;
            this.b = linearLayout;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                Toast unused = vz2.c = new Toast(this.a);
                vz2.c.setView(this.b);
                vz2.c.setGravity(17, 0, 0);
                yz2.k(vz2.c, R.style.obfuscated_res_0x7f1003af);
                vz2.c.show();
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ zz2.c a;

        public d(zz2.c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                zz2.c cVar = this.a;
                if (cVar != null) {
                    cVar.a();
                }
                vz2.d();
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ToastLocation a;
        public final /* synthetic */ Resources b;
        public final /* synthetic */ Context c;
        public final /* synthetic */ LinearLayout d;

        public e(ToastLocation toastLocation, Resources resources, Context context, LinearLayout linearLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {toastLocation, resources, context, linearLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = toastLocation;
            this.b = resources;
            this.c = context;
            this.d = linearLayout;
        }

        @Override // java.lang.Runnable
        public void run() {
            int i;
            int i2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (ToastLocation.BOTTOM == this.a) {
                    i = 81;
                    i2 = (int) this.b.getDimension(R.dimen.obfuscated_res_0x7f07011a);
                } else {
                    i = 17;
                    i2 = 0;
                }
                Toast unused = vz2.c = new Toast(this.c);
                vz2.c.setView(this.d);
                vz2.c.setGravity(i, 0, i2);
                yz2.k(vz2.c, R.style.obfuscated_res_0x7f1003af);
                vz2.c.show();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755213949, "Lcom/repackage/vz2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755213949, "Lcom/repackage/vz2;");
                return;
            }
        }
        a = rg1.a;
        d = new Handler(Looper.getMainLooper());
    }

    public static void d() {
        xz2 xz2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null) == null) {
            WeakReference<xz2> weakReference = b;
            if (weakReference != null && (xz2Var = weakReference.get()) != null) {
                xz2Var.s();
            }
            Toast toast = c;
            if (toast != null) {
                toast.cancel();
            }
            zz2.b bVar = e;
            if (bVar != null) {
                bVar.onDismiss();
                e = null;
            }
        }
    }

    public static boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            WeakReference<xz2> weakReference = b;
            xz2 xz2Var = weakReference != null ? weakReference.get() : null;
            Toast toast = c;
            return (xz2Var != null && xz2Var.u()) || (toast != null && toast.getView() != null && toast.getView().getParent() != null);
        }
        return invokeV.booleanValue;
    }

    public static void f(zz2.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65542, null, bVar) == null) {
            e = bVar;
        }
    }

    public static void g(xz2 xz2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65543, null, xz2Var) == null) {
            WeakReference<xz2> weakReference = b;
            if (weakReference != null) {
                weakReference.clear();
            }
            b = new WeakReference<>(xz2Var);
        }
    }

    public static void h(@NonNull Context context, @NonNull CharSequence charSequence, int i, boolean z, int i2, boolean z2) {
        TextView textView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65544, null, new Object[]{context, charSequence, Integer.valueOf(i), Boolean.valueOf(z), Integer.valueOf(i2), Boolean.valueOf(z2)}) == null) {
            Context applicationContext = context.getApplicationContext();
            Resources resources = context.getResources();
            RelativeLayout relativeLayout = (RelativeLayout) LayoutInflater.from(applicationContext).inflate(R.layout.obfuscated_res_0x7f0d00bc, (ViewGroup) null);
            relativeLayout.setBackground(resources.getDrawable(R.drawable.obfuscated_res_0x7f0801a3));
            boolean z3 = true;
            relativeLayout.setClickable(true);
            if (!TextUtils.isEmpty(charSequence) && (textView = (TextView) relativeLayout.findViewById(R.id.obfuscated_res_0x7f091621)) != null) {
                textView.setTextColor(-1);
                textView.setText(charSequence);
                boolean z4 = i2 >= 2;
                textView.setSingleLine((z4 || !z) ? false : false);
                if (z4) {
                    textView.setMaxLines(i2);
                    textView.setGravity(17);
                }
            }
            if (yz2.n(applicationContext)) {
                d.post(new a(applicationContext, relativeLayout));
                return;
            }
            xz2 xz2Var = new xz2(applicationContext);
            g(xz2Var);
            xz2Var.z(relativeLayout);
            xz2Var.x(z2);
            xz2Var.w(17, 0, 0);
            xz2Var.v(i);
            xz2Var.A(R.style.obfuscated_res_0x7f100413);
            xz2Var.y(e);
            e = null;
            xz2Var.B();
        }
    }

    public static void i(Context context, CharSequence charSequence, int i, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65545, null, new Object[]{context, charSequence, Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
            Context applicationContext = context.getApplicationContext();
            Resources resources = context.getResources();
            LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(applicationContext).inflate(R.layout.obfuscated_res_0x7f0d00d6, (ViewGroup) null);
            linearLayout.setBackground(resources.getDrawable(R.drawable.obfuscated_res_0x7f0801c4));
            linearLayout.findViewById(R.id.obfuscated_res_0x7f090d09).setVisibility(8);
            ProgressBar progressBar = (ProgressBar) linearLayout.findViewById(R.id.obfuscated_res_0x7f090d0a);
            progressBar.setVisibility(0);
            progressBar.setIndeterminateDrawable(resources.getDrawable(R.drawable.obfuscated_res_0x7f0801c6));
            linearLayout.setClickable(true);
            TextView textView = (TextView) linearLayout.findViewById(R.id.obfuscated_res_0x7f090d0b);
            if (!TextUtils.isEmpty(charSequence) && textView != null) {
                textView.setText(charSequence);
                textView.setTextColor(resources.getColor(R.color.obfuscated_res_0x7f06023f));
            }
            if (yz2.n(applicationContext)) {
                d.post(new c(context, linearLayout));
                return;
            }
            xz2 xz2Var = new xz2(applicationContext);
            g(xz2Var);
            xz2Var.z(linearLayout);
            xz2Var.x(z);
            xz2Var.w(17, 0, 0);
            xz2Var.v(i);
            xz2Var.A(R.style.obfuscated_res_0x7f1003af);
            xz2Var.B();
        }
    }

    public static void j(@NonNull Context context, @NonNull CharSequence charSequence, @Nullable Drawable drawable, @Nullable View view2, int i, boolean z) {
        TextView textView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65546, null, new Object[]{context, charSequence, drawable, view2, Integer.valueOf(i), Boolean.valueOf(z)}) == null) || context == null) {
            return;
        }
        Context applicationContext = context.getApplicationContext();
        Resources resources = context.getResources();
        LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(applicationContext).inflate(R.layout.obfuscated_res_0x7f0d00d6, (ViewGroup) null);
        linearLayout.setBackground(resources.getDrawable(R.drawable.obfuscated_res_0x7f0801c4));
        linearLayout.setClickable(true);
        if (!TextUtils.isEmpty(charSequence) && (textView = (TextView) linearLayout.findViewById(R.id.obfuscated_res_0x7f090d0b)) != null) {
            textView.setTextColor(resources.getColor(R.color.obfuscated_res_0x7f06023f));
            textView.setText(charSequence);
        }
        ImageView imageView = (ImageView) linearLayout.findViewById(R.id.obfuscated_res_0x7f090d09);
        if (imageView != null) {
            if (view2 != null) {
                new c03(applicationContext).a(imageView, view2);
            } else {
                if (drawable == null) {
                    drawable = resources.getDrawable(R.drawable.obfuscated_res_0x7f080172);
                }
                yz2.j(drawable);
                imageView.setImageDrawable(drawable);
            }
        }
        if (yz2.n(applicationContext)) {
            d.post(new b(context, linearLayout));
            return;
        }
        xz2 xz2Var = new xz2(applicationContext);
        g(xz2Var);
        xz2Var.z(linearLayout);
        xz2Var.x(z);
        xz2Var.w(17, 0, 0);
        xz2Var.v(i);
        xz2Var.A(R.style.obfuscated_res_0x7f1003af);
        xz2Var.B();
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x00dc  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00df  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0101  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0105  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0146  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0151  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void k(@NonNull Context context, @Nullable Uri uri, @Nullable Drawable drawable, @Nullable View view2, @NonNull CharSequence charSequence, @Nullable CharSequence charSequence2, int i, @NonNull ToastLocation toastLocation, @Nullable zz2.c cVar, boolean z) {
        ToastLocation toastLocation2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65547, null, new Object[]{context, uri, drawable, view2, charSequence, charSequence2, Integer.valueOf(i), toastLocation, cVar, Boolean.valueOf(z)}) == null) || context == null) {
            return;
        }
        Context applicationContext = context.getApplicationContext();
        Resources resources = context.getResources();
        LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d00d4, (ViewGroup) null);
        linearLayout.setBackground(resources.getDrawable(R.drawable.obfuscated_res_0x7f0801c4));
        SimpleDraweeView simpleDraweeView = (SimpleDraweeView) linearLayout.findViewById(R.id.obfuscated_res_0x7f09127c);
        TextView textView = (TextView) linearLayout.findViewById(R.id.obfuscated_res_0x7f091285);
        LinearLayout linearLayout2 = (LinearLayout) linearLayout.findViewById(R.id.obfuscated_res_0x7f091b3e);
        TextView textView2 = (TextView) linearLayout.findViewById(R.id.obfuscated_res_0x7f091b3f);
        View findViewById = linearLayout.findViewById(R.id.obfuscated_res_0x7f091b40);
        if (!TextUtils.isEmpty(charSequence)) {
            textView.setTextColor(wz2.a);
            if (uri == null && drawable == null && view2 == null && TextUtils.isEmpty(charSequence2)) {
                simpleDraweeView.setVisibility(8);
                linearLayout2.setVisibility(8);
                textView.setMaxLines(2);
                textView.setText(charSequence);
                textView.setMaxWidth(b03.a(context, 200.0f));
            } else {
                boolean z2 = true;
                if (view2 != null) {
                    simpleDraweeView.setVisibility(0);
                    new c03(applicationContext).a(simpleDraweeView, view2);
                } else if (uri == null && drawable == null) {
                    simpleDraweeView.setVisibility(8);
                    textView.setSingleLine();
                    textView.setText(charSequence);
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                    layoutParams.setMargins(b03.a(context, !z2 ? 14.0f : 5.0f), b03.a(context, 9.0f), b03.a(context, 14.0f), b03.a(context, 10.0f));
                    textView.setLayoutParams(layoutParams);
                    if (!TextUtils.isEmpty(charSequence2)) {
                        linearLayout2.setVisibility(8);
                    } else {
                        toastLocation2 = ToastLocation.BOTTOM;
                        linearLayout2.setVisibility(0);
                        ((ImageView) linearLayout.findViewById(R.id.obfuscated_res_0x7f091b36)).setImageDrawable(resources.getDrawable(R.drawable.obfuscated_res_0x7f0801c7));
                        textView2.setText(charSequence2);
                        textView2.setTextColor(wz2.a);
                        findViewById.setBackground(resources.getDrawable(R.color.obfuscated_res_0x7f06022c));
                        if (linearLayout2 != null) {
                            linearLayout2.setOnClickListener(new d(cVar));
                            yz2.i(linearLayout2);
                        }
                        if (!yz2.n(applicationContext)) {
                            d.post(new e(toastLocation2, resources, context, linearLayout));
                            return;
                        }
                        xz2 xz2Var = new xz2(applicationContext);
                        g(xz2Var);
                        xz2Var.z(linearLayout);
                        xz2Var.x(z);
                        xz2Var.w(17, 0, 0);
                        xz2Var.v(i);
                        xz2Var.A(R.style.obfuscated_res_0x7f1003af);
                        xz2Var.B();
                        return;
                    }
                } else {
                    simpleDraweeView.setVisibility(0);
                    if (drawable != null) {
                        yz2.j(drawable);
                        simpleDraweeView.setImageDrawable(drawable);
                    } else if (uri != null) {
                        simpleDraweeView.setController(Fresco.newDraweeControllerBuilder().setAutoPlayAnimations(true).setUri(uri).build());
                    }
                }
                z2 = false;
                textView.setSingleLine();
                textView.setText(charSequence);
                LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
                layoutParams2.setMargins(b03.a(context, !z2 ? 14.0f : 5.0f), b03.a(context, 9.0f), b03.a(context, 14.0f), b03.a(context, 10.0f));
                textView.setLayoutParams(layoutParams2);
                if (!TextUtils.isEmpty(charSequence2)) {
                }
            }
            toastLocation2 = toastLocation;
            if (!yz2.n(applicationContext)) {
            }
        } else {
            yz2.h("has no main text");
        }
    }
}
