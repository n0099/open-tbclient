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
import com.repackage.m03;
import java.lang.ref.WeakReference;
/* loaded from: classes6.dex */
public final class i03 {
    public static /* synthetic */ Interceptable $ic;
    public static boolean a;
    public static WeakReference<k03> b;
    public static Toast c;
    public static Handler d;
    public static m03.b e;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
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
                Toast unused = i03.c = new Toast(this.a);
                i03.c.setView(this.b);
                i03.c.setGravity(17, 0, 0);
                l03.k(i03.c, R.style.obfuscated_res_0x7f100410);
                try {
                    i03.c.show();
                } catch (NullPointerException e) {
                    if (i03.a) {
                        e.printStackTrace();
                    }
                }
                if (i03.a) {
                    Log.d("SingleToast", "mSystemToast.show() invoked in show");
                }
            }
        }
    }

    /* loaded from: classes6.dex */
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
                Toast unused = i03.c = new Toast(this.a);
                i03.c.setView(this.b);
                i03.c.setGravity(17, 0, 0);
                l03.k(i03.c, R.style.obfuscated_res_0x7f1003ae);
                i03.c.show();
            }
        }
    }

    /* loaded from: classes6.dex */
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
                Toast unused = i03.c = new Toast(this.a);
                i03.c.setView(this.b);
                i03.c.setGravity(17, 0, 0);
                l03.k(i03.c, R.style.obfuscated_res_0x7f1003ae);
                i03.c.show();
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ m03.c a;

        public d(m03.c cVar) {
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
                m03.c cVar = this.a;
                if (cVar != null) {
                    cVar.a();
                }
                i03.d();
            }
        }
    }

    /* loaded from: classes6.dex */
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
                Toast unused = i03.c = new Toast(this.c);
                i03.c.setView(this.d);
                i03.c.setGravity(i, 0, i2);
                l03.k(i03.c, R.style.obfuscated_res_0x7f1003ae);
                i03.c.show();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755672315, "Lcom/repackage/i03;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755672315, "Lcom/repackage/i03;");
                return;
            }
        }
        a = eh1.a;
        d = new Handler(Looper.getMainLooper());
    }

    public static void d() {
        k03 k03Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null) == null) {
            WeakReference<k03> weakReference = b;
            if (weakReference != null && (k03Var = weakReference.get()) != null) {
                k03Var.s();
            }
            Toast toast = c;
            if (toast != null) {
                toast.cancel();
            }
            m03.b bVar = e;
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
            WeakReference<k03> weakReference = b;
            k03 k03Var = weakReference != null ? weakReference.get() : null;
            Toast toast = c;
            return (k03Var != null && k03Var.u()) || (toast != null && toast.getView() != null && toast.getView().getParent() != null);
        }
        return invokeV.booleanValue;
    }

    public static void f(m03.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65542, null, bVar) == null) {
            e = bVar;
        }
    }

    public static void g(k03 k03Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65543, null, k03Var) == null) {
            WeakReference<k03> weakReference = b;
            if (weakReference != null) {
                weakReference.clear();
            }
            b = new WeakReference<>(k03Var);
        }
    }

    public static void h(@NonNull Context context, @NonNull CharSequence charSequence, int i, boolean z, int i2, boolean z2) {
        TextView textView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65544, null, new Object[]{context, charSequence, Integer.valueOf(i), Boolean.valueOf(z), Integer.valueOf(i2), Boolean.valueOf(z2)}) == null) {
            Context applicationContext = context.getApplicationContext();
            Resources resources = context.getResources();
            RelativeLayout relativeLayout = (RelativeLayout) LayoutInflater.from(applicationContext).inflate(R.layout.obfuscated_res_0x7f0d00c1, (ViewGroup) null);
            relativeLayout.setBackground(resources.getDrawable(R.drawable.obfuscated_res_0x7f0801a4));
            boolean z3 = true;
            relativeLayout.setClickable(true);
            if (!TextUtils.isEmpty(charSequence) && (textView = (TextView) relativeLayout.findViewById(R.id.obfuscated_res_0x7f0915c6)) != null) {
                textView.setTextColor(-1);
                textView.setText(charSequence);
                boolean z4 = i2 >= 2;
                textView.setSingleLine((z4 || !z) ? false : false);
                if (z4) {
                    textView.setMaxLines(i2);
                    textView.setGravity(17);
                }
            }
            if (l03.n(applicationContext)) {
                d.post(new a(applicationContext, relativeLayout));
                return;
            }
            k03 k03Var = new k03(applicationContext);
            g(k03Var);
            k03Var.z(relativeLayout);
            k03Var.x(z2);
            k03Var.w(17, 0, 0);
            k03Var.v(i);
            k03Var.A(R.style.obfuscated_res_0x7f100410);
            k03Var.y(e);
            e = null;
            k03Var.B();
        }
    }

    public static void i(Context context, CharSequence charSequence, int i, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65545, null, new Object[]{context, charSequence, Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
            Context applicationContext = context.getApplicationContext();
            Resources resources = context.getResources();
            LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(applicationContext).inflate(R.layout.obfuscated_res_0x7f0d00db, (ViewGroup) null);
            linearLayout.setBackground(resources.getDrawable(R.drawable.obfuscated_res_0x7f0801c5));
            linearLayout.findViewById(R.id.obfuscated_res_0x7f090d47).setVisibility(8);
            ProgressBar progressBar = (ProgressBar) linearLayout.findViewById(R.id.obfuscated_res_0x7f090d48);
            progressBar.setVisibility(0);
            progressBar.setIndeterminateDrawable(resources.getDrawable(R.drawable.obfuscated_res_0x7f0801c7));
            linearLayout.setClickable(true);
            TextView textView = (TextView) linearLayout.findViewById(R.id.obfuscated_res_0x7f090d49);
            if (!TextUtils.isEmpty(charSequence) && textView != null) {
                textView.setText(charSequence);
                textView.setTextColor(resources.getColor(R.color.obfuscated_res_0x7f06023c));
            }
            if (l03.n(applicationContext)) {
                d.post(new c(context, linearLayout));
                return;
            }
            k03 k03Var = new k03(applicationContext);
            g(k03Var);
            k03Var.z(linearLayout);
            k03Var.x(z);
            k03Var.w(17, 0, 0);
            k03Var.v(i);
            k03Var.A(R.style.obfuscated_res_0x7f1003ae);
            k03Var.B();
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
        LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(applicationContext).inflate(R.layout.obfuscated_res_0x7f0d00db, (ViewGroup) null);
        linearLayout.setBackground(resources.getDrawable(R.drawable.obfuscated_res_0x7f0801c5));
        linearLayout.setClickable(true);
        if (!TextUtils.isEmpty(charSequence) && (textView = (TextView) linearLayout.findViewById(R.id.obfuscated_res_0x7f090d49)) != null) {
            textView.setTextColor(resources.getColor(R.color.obfuscated_res_0x7f06023c));
            textView.setText(charSequence);
        }
        ImageView imageView = (ImageView) linearLayout.findViewById(R.id.obfuscated_res_0x7f090d47);
        if (imageView != null) {
            if (view2 != null) {
                new p03(applicationContext).a(imageView, view2);
            } else {
                if (drawable == null) {
                    drawable = resources.getDrawable(R.drawable.obfuscated_res_0x7f080173);
                }
                l03.j(drawable);
                imageView.setImageDrawable(drawable);
            }
        }
        if (l03.n(applicationContext)) {
            d.post(new b(context, linearLayout));
            return;
        }
        k03 k03Var = new k03(applicationContext);
        g(k03Var);
        k03Var.z(linearLayout);
        k03Var.x(z);
        k03Var.w(17, 0, 0);
        k03Var.v(i);
        k03Var.A(R.style.obfuscated_res_0x7f1003ae);
        k03Var.B();
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
    public static void k(@NonNull Context context, @Nullable Uri uri, @Nullable Drawable drawable, @Nullable View view2, @NonNull CharSequence charSequence, @Nullable CharSequence charSequence2, int i, @NonNull ToastLocation toastLocation, @Nullable m03.c cVar, boolean z) {
        ToastLocation toastLocation2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65547, null, new Object[]{context, uri, drawable, view2, charSequence, charSequence2, Integer.valueOf(i), toastLocation, cVar, Boolean.valueOf(z)}) == null) || context == null) {
            return;
        }
        Context applicationContext = context.getApplicationContext();
        Resources resources = context.getResources();
        LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d00d9, (ViewGroup) null);
        linearLayout.setBackground(resources.getDrawable(R.drawable.obfuscated_res_0x7f0801c5));
        SimpleDraweeView simpleDraweeView = (SimpleDraweeView) linearLayout.findViewById(R.id.obfuscated_res_0x7f091224);
        TextView textView = (TextView) linearLayout.findViewById(R.id.obfuscated_res_0x7f09122d);
        LinearLayout linearLayout2 = (LinearLayout) linearLayout.findViewById(R.id.obfuscated_res_0x7f091af8);
        TextView textView2 = (TextView) linearLayout.findViewById(R.id.obfuscated_res_0x7f091af9);
        View findViewById = linearLayout.findViewById(R.id.obfuscated_res_0x7f091afa);
        if (!TextUtils.isEmpty(charSequence)) {
            textView.setTextColor(j03.a);
            if (uri == null && drawable == null && view2 == null && TextUtils.isEmpty(charSequence2)) {
                simpleDraweeView.setVisibility(8);
                linearLayout2.setVisibility(8);
                textView.setMaxLines(2);
                textView.setText(charSequence);
                textView.setMaxWidth(o03.a(context, 200.0f));
            } else {
                boolean z2 = true;
                if (view2 != null) {
                    simpleDraweeView.setVisibility(0);
                    new p03(applicationContext).a(simpleDraweeView, view2);
                } else if (uri == null && drawable == null) {
                    simpleDraweeView.setVisibility(8);
                    textView.setSingleLine();
                    textView.setText(charSequence);
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                    layoutParams.setMargins(o03.a(context, !z2 ? 14.0f : 5.0f), o03.a(context, 9.0f), o03.a(context, 14.0f), o03.a(context, 10.0f));
                    textView.setLayoutParams(layoutParams);
                    if (!TextUtils.isEmpty(charSequence2)) {
                        linearLayout2.setVisibility(8);
                    } else {
                        toastLocation2 = ToastLocation.BOTTOM;
                        linearLayout2.setVisibility(0);
                        ((ImageView) linearLayout.findViewById(R.id.obfuscated_res_0x7f091af0)).setImageDrawable(resources.getDrawable(R.drawable.obfuscated_res_0x7f0801c8));
                        textView2.setText(charSequence2);
                        textView2.setTextColor(j03.a);
                        findViewById.setBackground(resources.getDrawable(R.color.obfuscated_res_0x7f060229));
                        if (linearLayout2 != null) {
                            linearLayout2.setOnClickListener(new d(cVar));
                            l03.i(linearLayout2);
                        }
                        if (!l03.n(applicationContext)) {
                            d.post(new e(toastLocation2, resources, context, linearLayout));
                            return;
                        }
                        k03 k03Var = new k03(applicationContext);
                        g(k03Var);
                        k03Var.z(linearLayout);
                        k03Var.x(z);
                        k03Var.w(17, 0, 0);
                        k03Var.v(i);
                        k03Var.A(R.style.obfuscated_res_0x7f1003ae);
                        k03Var.B();
                        return;
                    }
                } else {
                    simpleDraweeView.setVisibility(0);
                    if (drawable != null) {
                        l03.j(drawable);
                        simpleDraweeView.setImageDrawable(drawable);
                    } else if (uri != null) {
                        simpleDraweeView.setController(Fresco.newDraweeControllerBuilder().setAutoPlayAnimations(true).setUri(uri).build());
                    }
                }
                z2 = false;
                textView.setSingleLine();
                textView.setText(charSequence);
                LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
                layoutParams2.setMargins(o03.a(context, !z2 ? 14.0f : 5.0f), o03.a(context, 9.0f), o03.a(context, 14.0f), o03.a(context, 10.0f));
                textView.setLayoutParams(layoutParams2);
                if (!TextUtils.isEmpty(charSequence2)) {
                }
            }
            toastLocation2 = toastLocation;
            if (!l03.n(applicationContext)) {
            }
        } else {
            l03.h("has no main text");
        }
    }
}
