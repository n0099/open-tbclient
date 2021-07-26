package d.a.o0.a.z1.b.f;

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
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.swan.apps.res.widget.toast.ToastLocation;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.view.SimpleDraweeView;
import d.a.o0.a.g;
import d.a.o0.a.i;
import d.a.o0.a.k;
import d.a.o0.a.z1.b.f.e;
import java.lang.ref.WeakReference;
/* loaded from: classes7.dex */
public final class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static boolean f49300a;

    /* renamed from: b  reason: collision with root package name */
    public static WeakReference<d.a.o0.a.z1.b.f.c> f49301b;

    /* renamed from: c  reason: collision with root package name */
    public static Toast f49302c;

    /* renamed from: d  reason: collision with root package name */
    public static Handler f49303d;

    /* renamed from: e  reason: collision with root package name */
    public static e.b f49304e;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: d.a.o0.a.z1.b.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static class RunnableC1014a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Context f49305e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ RelativeLayout f49306f;

        public RunnableC1014a(Context context, RelativeLayout relativeLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context, relativeLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f49305e = context;
            this.f49306f = relativeLayout;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                Toast unused = a.f49302c = new Toast(this.f49305e);
                a.f49302c.setView(this.f49306f);
                a.f49302c.setGravity(17, 0, 0);
                d.a.o0.a.z1.b.f.d.k(a.f49302c, i.toast_animation);
                try {
                    a.f49302c.show();
                } catch (NullPointerException e2) {
                    if (a.f49300a) {
                        e2.printStackTrace();
                    }
                }
                if (a.f49300a) {
                    Log.d("SingleToast", "mSystemToast.show() invoked in show");
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Context f49307e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ LinearLayout f49308f;

        public b(Context context, LinearLayout linearLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context, linearLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f49307e = context;
            this.f49308f = linearLayout;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                Toast unused = a.f49302c = new Toast(this.f49307e);
                a.f49302c.setView(this.f49308f);
                a.f49302c.setGravity(17, 0, 0);
                d.a.o0.a.z1.b.f.d.k(a.f49302c, i.highlight_toast_animation);
                a.f49302c.show();
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Context f49309e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ LinearLayout f49310f;

        public c(Context context, LinearLayout linearLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context, linearLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f49309e = context;
            this.f49310f = linearLayout;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                Toast unused = a.f49302c = new Toast(this.f49309e);
                a.f49302c.setView(this.f49310f);
                a.f49302c.setGravity(17, 0, 0);
                d.a.o0.a.z1.b.f.d.k(a.f49302c, i.highlight_toast_animation);
                a.f49302c.show();
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ e.c f49311e;

        public d(e.c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f49311e = cVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                e.c cVar = this.f49311e;
                if (cVar != null) {
                    cVar.a();
                }
                a.d();
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ToastLocation f49312e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Resources f49313f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Context f49314g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ LinearLayout f49315h;

        public e(ToastLocation toastLocation, Resources resources, Context context, LinearLayout linearLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {toastLocation, resources, context, linearLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f49312e = toastLocation;
            this.f49313f = resources;
            this.f49314g = context;
            this.f49315h = linearLayout;
        }

        @Override // java.lang.Runnable
        public void run() {
            int i2;
            int i3;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (ToastLocation.BOTTOM == this.f49312e) {
                    i2 = 81;
                    i3 = (int) this.f49313f.getDimension(d.a.o0.a.d.aiapps_clickable_toast_view_margin_bottom);
                } else {
                    i2 = 17;
                    i3 = 0;
                }
                Toast unused = a.f49302c = new Toast(this.f49314g);
                a.f49302c.setView(this.f49315h);
                a.f49302c.setGravity(i2, 0, i3);
                d.a.o0.a.z1.b.f.d.k(a.f49302c, i.highlight_toast_animation);
                a.f49302c.show();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-557390511, "Ld/a/o0/a/z1/b/f/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-557390511, "Ld/a/o0/a/z1/b/f/a;");
                return;
            }
        }
        f49300a = k.f46335a;
        f49303d = new Handler(Looper.getMainLooper());
    }

    public static void d() {
        d.a.o0.a.z1.b.f.c cVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null) == null) {
            WeakReference<d.a.o0.a.z1.b.f.c> weakReference = f49301b;
            if (weakReference != null && (cVar = weakReference.get()) != null) {
                cVar.s();
            }
            Toast toast = f49302c;
            if (toast != null) {
                toast.cancel();
            }
            e.b bVar = f49304e;
            if (bVar != null) {
                bVar.onDismiss();
                f49304e = null;
            }
        }
    }

    public static boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.AD_TEXT_ID, null)) == null) {
            WeakReference<d.a.o0.a.z1.b.f.c> weakReference = f49301b;
            d.a.o0.a.z1.b.f.c cVar = weakReference != null ? weakReference.get() : null;
            Toast toast = f49302c;
            return (cVar != null && cVar.u()) || (toast != null && toast.getView() != null && toast.getView().getParent() != null);
        }
        return invokeV.booleanValue;
    }

    public static void f(e.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, bVar) == null) {
            f49304e = bVar;
        }
    }

    public static void g(d.a.o0.a.z1.b.f.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65543, null, cVar) == null) {
            WeakReference<d.a.o0.a.z1.b.f.c> weakReference = f49301b;
            if (weakReference != null) {
                weakReference.clear();
            }
            f49301b = new WeakReference<>(cVar);
        }
    }

    public static void h(@NonNull Context context, @NonNull CharSequence charSequence, int i2, boolean z, int i3, boolean z2) {
        TextView textView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65544, null, new Object[]{context, charSequence, Integer.valueOf(i2), Boolean.valueOf(z), Integer.valueOf(i3), Boolean.valueOf(z2)}) == null) {
            Context applicationContext = context.getApplicationContext();
            Resources resources = context.getResources();
            RelativeLayout relativeLayout = (RelativeLayout) LayoutInflater.from(applicationContext).inflate(g.aiapps_normal_toast_view, (ViewGroup) null);
            relativeLayout.setBackground(resources.getDrawable(d.a.o0.a.e.aiapps_normal_toast_view_bg));
            boolean z3 = true;
            relativeLayout.setClickable(true);
            if (!TextUtils.isEmpty(charSequence) && (textView = (TextView) relativeLayout.findViewById(d.a.o0.a.f.normal_toast_text)) != null) {
                textView.setTextColor(-1);
                textView.setText(charSequence);
                boolean z4 = i3 >= 2;
                textView.setSingleLine((z4 || !z) ? false : false);
                if (z4) {
                    textView.setMaxLines(i3);
                    textView.setGravity(17);
                }
            }
            if (d.a.o0.a.z1.b.f.d.n(applicationContext)) {
                f49303d.post(new RunnableC1014a(applicationContext, relativeLayout));
                return;
            }
            d.a.o0.a.z1.b.f.c cVar = new d.a.o0.a.z1.b.f.c(applicationContext);
            g(cVar);
            cVar.z(relativeLayout);
            cVar.x(z2);
            cVar.w(17, 0, 0);
            cVar.v(i2);
            cVar.A(i.toast_animation);
            cVar.y(f49304e);
            f49304e = null;
            cVar.B();
        }
    }

    public static void i(Context context, CharSequence charSequence, int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65545, null, new Object[]{context, charSequence, Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
            Context applicationContext = context.getApplicationContext();
            Resources resources = context.getResources();
            LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(applicationContext).inflate(g.aiapps_toast_template_square_d20, (ViewGroup) null);
            linearLayout.setBackground(resources.getDrawable(d.a.o0.a.e.aiapps_toast_bg_d20));
            linearLayout.findViewById(d.a.o0.a.f.highlight_toast_imageView_d20).setVisibility(8);
            ProgressBar progressBar = (ProgressBar) linearLayout.findViewById(d.a.o0.a.f.highlight_toast_loading_d20);
            progressBar.setVisibility(0);
            progressBar.setIndeterminateDrawable(resources.getDrawable(d.a.o0.a.e.aiapps_toast_loading_d20));
            linearLayout.setClickable(true);
            TextView textView = (TextView) linearLayout.findViewById(d.a.o0.a.f.highlight_toast_text_d20);
            if (!TextUtils.isEmpty(charSequence) && textView != null) {
                textView.setText(charSequence);
                textView.setTextColor(resources.getColor(d.a.o0.a.c.GC6));
            }
            if (d.a.o0.a.z1.b.f.d.n(applicationContext)) {
                f49303d.post(new c(context, linearLayout));
                return;
            }
            d.a.o0.a.z1.b.f.c cVar = new d.a.o0.a.z1.b.f.c(applicationContext);
            g(cVar);
            cVar.z(linearLayout);
            cVar.x(z);
            cVar.w(17, 0, 0);
            cVar.v(i2);
            cVar.A(i.highlight_toast_animation);
            cVar.B();
        }
    }

    public static void j(@NonNull Context context, @NonNull CharSequence charSequence, @Nullable Drawable drawable, @Nullable View view, int i2, boolean z) {
        TextView textView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65546, null, new Object[]{context, charSequence, drawable, view, Integer.valueOf(i2), Boolean.valueOf(z)}) == null) || context == null) {
            return;
        }
        Context applicationContext = context.getApplicationContext();
        Resources resources = context.getResources();
        LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(applicationContext).inflate(g.aiapps_toast_template_square_d20, (ViewGroup) null);
        linearLayout.setBackground(resources.getDrawable(d.a.o0.a.e.aiapps_toast_bg_d20));
        linearLayout.setClickable(true);
        if (!TextUtils.isEmpty(charSequence) && (textView = (TextView) linearLayout.findViewById(d.a.o0.a.f.highlight_toast_text_d20)) != null) {
            textView.setTextColor(resources.getColor(d.a.o0.a.c.GC6));
            textView.setText(charSequence);
        }
        ImageView imageView = (ImageView) linearLayout.findViewById(d.a.o0.a.f.highlight_toast_imageView_d20);
        if (imageView != null) {
            if (view != null) {
                new d.a.o0.a.z1.b.f.g.b(applicationContext).a(imageView, view);
            } else {
                if (drawable == null) {
                    drawable = resources.getDrawable(d.a.o0.a.e.aiapps_highlight_toast_image_d20);
                }
                d.a.o0.a.z1.b.f.d.j(drawable);
                imageView.setImageDrawable(drawable);
            }
        }
        if (d.a.o0.a.z1.b.f.d.n(applicationContext)) {
            f49303d.post(new b(context, linearLayout));
            return;
        }
        d.a.o0.a.z1.b.f.c cVar = new d.a.o0.a.z1.b.f.c(applicationContext);
        g(cVar);
        cVar.z(linearLayout);
        cVar.x(z);
        cVar.w(17, 0, 0);
        cVar.v(i2);
        cVar.A(i.highlight_toast_animation);
        cVar.B();
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x00d5  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00d8  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00fa  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00fe  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x013c  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0147  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void k(@NonNull Context context, @Nullable Uri uri, @Nullable Drawable drawable, @Nullable View view, @NonNull CharSequence charSequence, @Nullable CharSequence charSequence2, int i2, @NonNull ToastLocation toastLocation, @Nullable e.c cVar, boolean z) {
        ToastLocation toastLocation2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65547, null, new Object[]{context, uri, drawable, view, charSequence, charSequence2, Integer.valueOf(i2), toastLocation, cVar, Boolean.valueOf(z)}) == null) || context == null) {
            return;
        }
        Context applicationContext = context.getApplicationContext();
        Resources resources = context.getResources();
        LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(context).inflate(g.aiapps_toast_template_a_d20, (ViewGroup) null);
        linearLayout.setBackground(resources.getDrawable(d.a.o0.a.e.aiapps_toast_bg_d20));
        SimpleDraweeView simpleDraweeView = (SimpleDraweeView) linearLayout.findViewById(d.a.o0.a.f.left_icon_fresco);
        TextView textView = (TextView) linearLayout.findViewById(d.a.o0.a.f.left_toast_info_view);
        LinearLayout linearLayout2 = (LinearLayout) linearLayout.findViewById(d.a.o0.a.f.right_toast_click_area);
        TextView textView2 = (TextView) linearLayout.findViewById(d.a.o0.a.f.right_toast_jump_text);
        View findViewById = linearLayout.findViewById(d.a.o0.a.f.right_toast_vertical_line);
        if (!TextUtils.isEmpty(charSequence)) {
            textView.setTextColor(d.a.o0.a.z1.b.f.b.f49316a);
            if (uri == null && drawable == null && view == null && TextUtils.isEmpty(charSequence2)) {
                simpleDraweeView.setVisibility(8);
                linearLayout2.setVisibility(8);
                textView.setMaxLines(2);
                textView.setText(charSequence);
                textView.setMaxWidth(d.a.o0.a.z1.b.f.g.a.a(context, 200.0f));
            } else {
                boolean z2 = true;
                if (view != null) {
                    simpleDraweeView.setVisibility(0);
                    new d.a.o0.a.z1.b.f.g.b(applicationContext).a(simpleDraweeView, view);
                } else if (uri == null && drawable == null) {
                    simpleDraweeView.setVisibility(8);
                    textView.setSingleLine();
                    textView.setText(charSequence);
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                    layoutParams.setMargins(d.a.o0.a.z1.b.f.g.a.a(context, !z2 ? 14.0f : 5.0f), d.a.o0.a.z1.b.f.g.a.a(context, 9.0f), d.a.o0.a.z1.b.f.g.a.a(context, 14.0f), d.a.o0.a.z1.b.f.g.a.a(context, 10.0f));
                    textView.setLayoutParams(layoutParams);
                    if (!TextUtils.isEmpty(charSequence2)) {
                        linearLayout2.setVisibility(8);
                    } else {
                        toastLocation2 = ToastLocation.BOTTOM;
                        linearLayout2.setVisibility(0);
                        ((ImageView) linearLayout.findViewById(d.a.o0.a.f.right_jump_img)).setImageDrawable(resources.getDrawable(d.a.o0.a.e.aiapps_toast_right_jump_d20));
                        textView2.setText(charSequence2);
                        textView2.setTextColor(d.a.o0.a.z1.b.f.b.f49316a);
                        findViewById.setBackground(resources.getDrawable(d.a.o0.a.c.GC36));
                        if (linearLayout2 != null) {
                            linearLayout2.setOnClickListener(new d(cVar));
                            d.a.o0.a.z1.b.f.d.i(linearLayout2);
                        }
                        if (!d.a.o0.a.z1.b.f.d.n(applicationContext)) {
                            f49303d.post(new e(toastLocation2, resources, context, linearLayout));
                            return;
                        }
                        d.a.o0.a.z1.b.f.c cVar2 = new d.a.o0.a.z1.b.f.c(applicationContext);
                        g(cVar2);
                        cVar2.z(linearLayout);
                        cVar2.x(z);
                        cVar2.w(17, 0, 0);
                        cVar2.v(i2);
                        cVar2.A(i.highlight_toast_animation);
                        cVar2.B();
                        return;
                    }
                } else {
                    simpleDraweeView.setVisibility(0);
                    if (drawable != null) {
                        d.a.o0.a.z1.b.f.d.j(drawable);
                        simpleDraweeView.setImageDrawable(drawable);
                    } else if (uri != null) {
                        simpleDraweeView.setController(Fresco.newDraweeControllerBuilder().setAutoPlayAnimations(true).setUri(uri).build());
                    }
                }
                z2 = false;
                textView.setSingleLine();
                textView.setText(charSequence);
                LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
                layoutParams2.setMargins(d.a.o0.a.z1.b.f.g.a.a(context, !z2 ? 14.0f : 5.0f), d.a.o0.a.z1.b.f.g.a.a(context, 9.0f), d.a.o0.a.z1.b.f.g.a.a(context, 14.0f), d.a.o0.a.z1.b.f.g.a.a(context, 10.0f));
                textView.setLayoutParams(layoutParams2);
                if (!TextUtils.isEmpty(charSequence2)) {
                }
            }
            toastLocation2 = toastLocation;
            if (!d.a.o0.a.z1.b.f.d.n(applicationContext)) {
            }
        } else {
            d.a.o0.a.z1.b.f.d.h("has no main text");
        }
    }
}
