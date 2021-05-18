package d.a.i0.a.z1.b.f;

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
import com.baidu.swan.apps.res.widget.toast.ToastLocation;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.view.SimpleDraweeView;
import d.a.i0.a.g;
import d.a.i0.a.i;
import d.a.i0.a.k;
import d.a.i0.a.z1.b.f.e;
import java.lang.ref.WeakReference;
/* loaded from: classes3.dex */
public final class a {

    /* renamed from: b  reason: collision with root package name */
    public static WeakReference<d.a.i0.a.z1.b.f.c> f45995b;

    /* renamed from: c  reason: collision with root package name */
    public static Toast f45996c;

    /* renamed from: e  reason: collision with root package name */
    public static e.b f45998e;

    /* renamed from: a  reason: collision with root package name */
    public static boolean f45994a = k.f43025a;

    /* renamed from: d  reason: collision with root package name */
    public static Handler f45997d = new Handler(Looper.getMainLooper());

    /* renamed from: d.a.i0.a.z1.b.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class RunnableC0926a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Context f45999e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ RelativeLayout f46000f;

        public RunnableC0926a(Context context, RelativeLayout relativeLayout) {
            this.f45999e = context;
            this.f46000f = relativeLayout;
        }

        @Override // java.lang.Runnable
        public void run() {
            Toast unused = a.f45996c = new Toast(this.f45999e);
            a.f45996c.setView(this.f46000f);
            a.f45996c.setGravity(17, 0, 0);
            d.a.i0.a.z1.b.f.d.k(a.f45996c, i.toast_animation);
            try {
                a.f45996c.show();
            } catch (NullPointerException e2) {
                if (a.f45994a) {
                    e2.printStackTrace();
                }
            }
            if (a.f45994a) {
                Log.d("SingleToast", "mSystemToast.show() invoked in show");
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Context f46001e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ LinearLayout f46002f;

        public b(Context context, LinearLayout linearLayout) {
            this.f46001e = context;
            this.f46002f = linearLayout;
        }

        @Override // java.lang.Runnable
        public void run() {
            Toast unused = a.f45996c = new Toast(this.f46001e);
            a.f45996c.setView(this.f46002f);
            a.f45996c.setGravity(17, 0, 0);
            d.a.i0.a.z1.b.f.d.k(a.f45996c, i.highlight_toast_animation);
            a.f45996c.show();
        }
    }

    /* loaded from: classes3.dex */
    public static class c implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Context f46003e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ LinearLayout f46004f;

        public c(Context context, LinearLayout linearLayout) {
            this.f46003e = context;
            this.f46004f = linearLayout;
        }

        @Override // java.lang.Runnable
        public void run() {
            Toast unused = a.f45996c = new Toast(this.f46003e);
            a.f45996c.setView(this.f46004f);
            a.f45996c.setGravity(17, 0, 0);
            d.a.i0.a.z1.b.f.d.k(a.f45996c, i.highlight_toast_animation);
            a.f45996c.show();
        }
    }

    /* loaded from: classes3.dex */
    public static class d implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ e.c f46005e;

        public d(e.c cVar) {
            this.f46005e = cVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            e.c cVar = this.f46005e;
            if (cVar != null) {
                cVar.a();
            }
            a.d();
        }
    }

    /* loaded from: classes3.dex */
    public static class e implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ToastLocation f46006e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Resources f46007f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Context f46008g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ LinearLayout f46009h;

        public e(ToastLocation toastLocation, Resources resources, Context context, LinearLayout linearLayout) {
            this.f46006e = toastLocation;
            this.f46007f = resources;
            this.f46008g = context;
            this.f46009h = linearLayout;
        }

        @Override // java.lang.Runnable
        public void run() {
            int i2;
            int i3;
            if (ToastLocation.BOTTOM == this.f46006e) {
                i2 = 81;
                i3 = (int) this.f46007f.getDimension(d.a.i0.a.d.aiapps_clickable_toast_view_margin_bottom);
            } else {
                i2 = 17;
                i3 = 0;
            }
            Toast unused = a.f45996c = new Toast(this.f46008g);
            a.f45996c.setView(this.f46009h);
            a.f45996c.setGravity(i2, 0, i3);
            d.a.i0.a.z1.b.f.d.k(a.f45996c, i.highlight_toast_animation);
            a.f45996c.show();
        }
    }

    public static void d() {
        d.a.i0.a.z1.b.f.c cVar;
        WeakReference<d.a.i0.a.z1.b.f.c> weakReference = f45995b;
        if (weakReference != null && (cVar = weakReference.get()) != null) {
            cVar.s();
        }
        Toast toast = f45996c;
        if (toast != null) {
            toast.cancel();
        }
        e.b bVar = f45998e;
        if (bVar != null) {
            bVar.onDismiss();
            f45998e = null;
        }
    }

    public static boolean e() {
        WeakReference<d.a.i0.a.z1.b.f.c> weakReference = f45995b;
        d.a.i0.a.z1.b.f.c cVar = weakReference != null ? weakReference.get() : null;
        Toast toast = f45996c;
        return (cVar != null && cVar.u()) || (toast != null && toast.getView() != null && toast.getView().getParent() != null);
    }

    public static void f(e.b bVar) {
        f45998e = bVar;
    }

    public static void g(d.a.i0.a.z1.b.f.c cVar) {
        WeakReference<d.a.i0.a.z1.b.f.c> weakReference = f45995b;
        if (weakReference != null) {
            weakReference.clear();
        }
        f45995b = new WeakReference<>(cVar);
    }

    public static void h(@NonNull Context context, @NonNull CharSequence charSequence, int i2, boolean z, int i3, boolean z2) {
        TextView textView;
        Context applicationContext = context.getApplicationContext();
        Resources resources = context.getResources();
        RelativeLayout relativeLayout = (RelativeLayout) LayoutInflater.from(applicationContext).inflate(g.aiapps_normal_toast_view, (ViewGroup) null);
        relativeLayout.setBackground(resources.getDrawable(d.a.i0.a.e.aiapps_normal_toast_view_bg));
        boolean z3 = true;
        relativeLayout.setClickable(true);
        if (!TextUtils.isEmpty(charSequence) && (textView = (TextView) relativeLayout.findViewById(d.a.i0.a.f.normal_toast_text)) != null) {
            textView.setTextColor(-1);
            textView.setText(charSequence);
            boolean z4 = i3 >= 2;
            textView.setSingleLine((z4 || !z) ? false : false);
            if (z4) {
                textView.setMaxLines(i3);
                textView.setGravity(17);
            }
        }
        if (d.a.i0.a.z1.b.f.d.n(applicationContext)) {
            f45997d.post(new RunnableC0926a(applicationContext, relativeLayout));
            return;
        }
        d.a.i0.a.z1.b.f.c cVar = new d.a.i0.a.z1.b.f.c(applicationContext);
        g(cVar);
        cVar.z(relativeLayout);
        cVar.x(z2);
        cVar.w(17, 0, 0);
        cVar.v(i2);
        cVar.A(i.toast_animation);
        cVar.y(f45998e);
        f45998e = null;
        cVar.B();
    }

    public static void i(Context context, CharSequence charSequence, int i2, boolean z) {
        Context applicationContext = context.getApplicationContext();
        Resources resources = context.getResources();
        LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(applicationContext).inflate(g.aiapps_toast_template_square_d20, (ViewGroup) null);
        linearLayout.setBackground(resources.getDrawable(d.a.i0.a.e.aiapps_toast_bg_d20));
        linearLayout.findViewById(d.a.i0.a.f.highlight_toast_imageView_d20).setVisibility(8);
        ProgressBar progressBar = (ProgressBar) linearLayout.findViewById(d.a.i0.a.f.highlight_toast_loading_d20);
        progressBar.setVisibility(0);
        progressBar.setIndeterminateDrawable(resources.getDrawable(d.a.i0.a.e.aiapps_toast_loading_d20));
        linearLayout.setClickable(true);
        TextView textView = (TextView) linearLayout.findViewById(d.a.i0.a.f.highlight_toast_text_d20);
        if (!TextUtils.isEmpty(charSequence) && textView != null) {
            textView.setText(charSequence);
            textView.setTextColor(resources.getColor(d.a.i0.a.c.GC6));
        }
        if (d.a.i0.a.z1.b.f.d.n(applicationContext)) {
            f45997d.post(new c(context, linearLayout));
            return;
        }
        d.a.i0.a.z1.b.f.c cVar = new d.a.i0.a.z1.b.f.c(applicationContext);
        g(cVar);
        cVar.z(linearLayout);
        cVar.x(z);
        cVar.w(17, 0, 0);
        cVar.v(i2);
        cVar.A(i.highlight_toast_animation);
        cVar.B();
    }

    public static void j(@NonNull Context context, @NonNull CharSequence charSequence, @Nullable Drawable drawable, @Nullable View view, int i2, boolean z) {
        TextView textView;
        if (context == null) {
            return;
        }
        Context applicationContext = context.getApplicationContext();
        Resources resources = context.getResources();
        LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(applicationContext).inflate(g.aiapps_toast_template_square_d20, (ViewGroup) null);
        linearLayout.setBackground(resources.getDrawable(d.a.i0.a.e.aiapps_toast_bg_d20));
        linearLayout.setClickable(true);
        if (!TextUtils.isEmpty(charSequence) && (textView = (TextView) linearLayout.findViewById(d.a.i0.a.f.highlight_toast_text_d20)) != null) {
            textView.setTextColor(resources.getColor(d.a.i0.a.c.GC6));
            textView.setText(charSequence);
        }
        ImageView imageView = (ImageView) linearLayout.findViewById(d.a.i0.a.f.highlight_toast_imageView_d20);
        if (imageView != null) {
            if (view != null) {
                new d.a.i0.a.z1.b.f.g.b(applicationContext).a(imageView, view);
            } else {
                if (drawable == null) {
                    drawable = resources.getDrawable(d.a.i0.a.e.aiapps_highlight_toast_image_d20);
                }
                d.a.i0.a.z1.b.f.d.j(drawable);
                imageView.setImageDrawable(drawable);
            }
        }
        if (d.a.i0.a.z1.b.f.d.n(applicationContext)) {
            f45997d.post(new b(context, linearLayout));
            return;
        }
        d.a.i0.a.z1.b.f.c cVar = new d.a.i0.a.z1.b.f.c(applicationContext);
        g(cVar);
        cVar.z(linearLayout);
        cVar.x(z);
        cVar.w(17, 0, 0);
        cVar.v(i2);
        cVar.A(i.highlight_toast_animation);
        cVar.B();
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x00d1  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00d4  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00f6  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00fa  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0138  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0143  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void k(@NonNull Context context, @Nullable Uri uri, @Nullable Drawable drawable, @Nullable View view, @NonNull CharSequence charSequence, @Nullable CharSequence charSequence2, int i2, @NonNull ToastLocation toastLocation, @Nullable e.c cVar, boolean z) {
        ToastLocation toastLocation2;
        if (context == null) {
            return;
        }
        Context applicationContext = context.getApplicationContext();
        Resources resources = context.getResources();
        LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(context).inflate(g.aiapps_toast_template_a_d20, (ViewGroup) null);
        linearLayout.setBackground(resources.getDrawable(d.a.i0.a.e.aiapps_toast_bg_d20));
        SimpleDraweeView simpleDraweeView = (SimpleDraweeView) linearLayout.findViewById(d.a.i0.a.f.left_icon_fresco);
        TextView textView = (TextView) linearLayout.findViewById(d.a.i0.a.f.left_toast_info_view);
        LinearLayout linearLayout2 = (LinearLayout) linearLayout.findViewById(d.a.i0.a.f.right_toast_click_area);
        TextView textView2 = (TextView) linearLayout.findViewById(d.a.i0.a.f.right_toast_jump_text);
        View findViewById = linearLayout.findViewById(d.a.i0.a.f.right_toast_vertical_line);
        if (!TextUtils.isEmpty(charSequence)) {
            textView.setTextColor(d.a.i0.a.z1.b.f.b.f46010a);
            if (uri == null && drawable == null && view == null && TextUtils.isEmpty(charSequence2)) {
                simpleDraweeView.setVisibility(8);
                linearLayout2.setVisibility(8);
                textView.setMaxLines(2);
                textView.setText(charSequence);
                textView.setMaxWidth(d.a.i0.a.z1.b.f.g.a.a(context, 200.0f));
            } else {
                boolean z2 = true;
                if (view != null) {
                    simpleDraweeView.setVisibility(0);
                    new d.a.i0.a.z1.b.f.g.b(applicationContext).a(simpleDraweeView, view);
                } else if (uri == null && drawable == null) {
                    simpleDraweeView.setVisibility(8);
                    textView.setSingleLine();
                    textView.setText(charSequence);
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                    layoutParams.setMargins(d.a.i0.a.z1.b.f.g.a.a(context, !z2 ? 14.0f : 5.0f), d.a.i0.a.z1.b.f.g.a.a(context, 9.0f), d.a.i0.a.z1.b.f.g.a.a(context, 14.0f), d.a.i0.a.z1.b.f.g.a.a(context, 10.0f));
                    textView.setLayoutParams(layoutParams);
                    if (!TextUtils.isEmpty(charSequence2)) {
                        linearLayout2.setVisibility(8);
                    } else {
                        toastLocation2 = ToastLocation.BOTTOM;
                        linearLayout2.setVisibility(0);
                        ((ImageView) linearLayout.findViewById(d.a.i0.a.f.right_jump_img)).setImageDrawable(resources.getDrawable(d.a.i0.a.e.aiapps_toast_right_jump_d20));
                        textView2.setText(charSequence2);
                        textView2.setTextColor(d.a.i0.a.z1.b.f.b.f46010a);
                        findViewById.setBackground(resources.getDrawable(d.a.i0.a.c.GC36));
                        if (linearLayout2 != null) {
                            linearLayout2.setOnClickListener(new d(cVar));
                            d.a.i0.a.z1.b.f.d.i(linearLayout2);
                        }
                        if (!d.a.i0.a.z1.b.f.d.n(applicationContext)) {
                            f45997d.post(new e(toastLocation2, resources, context, linearLayout));
                            return;
                        }
                        d.a.i0.a.z1.b.f.c cVar2 = new d.a.i0.a.z1.b.f.c(applicationContext);
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
                        d.a.i0.a.z1.b.f.d.j(drawable);
                        simpleDraweeView.setImageDrawable(drawable);
                    } else if (uri != null) {
                        simpleDraweeView.setController(Fresco.newDraweeControllerBuilder().setAutoPlayAnimations(true).setUri(uri).build());
                    }
                }
                z2 = false;
                textView.setSingleLine();
                textView.setText(charSequence);
                LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
                layoutParams2.setMargins(d.a.i0.a.z1.b.f.g.a.a(context, !z2 ? 14.0f : 5.0f), d.a.i0.a.z1.b.f.g.a.a(context, 9.0f), d.a.i0.a.z1.b.f.g.a.a(context, 14.0f), d.a.i0.a.z1.b.f.g.a.a(context, 10.0f));
                textView.setLayoutParams(layoutParams2);
                if (!TextUtils.isEmpty(charSequence2)) {
                }
            }
            toastLocation2 = toastLocation;
            if (!d.a.i0.a.z1.b.f.d.n(applicationContext)) {
            }
        } else {
            d.a.i0.a.z1.b.f.d.h("has no main text");
        }
    }
}
