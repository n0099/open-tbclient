package d.a.l0.a.z1.b.f;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.annotation.AnimRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.swan.apps.res.widget.toast.ToastLocation;
import com.baidu.swan.apps.res.widget.toast.ToastRightAreaStyle;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.view.SimpleDraweeView;
import d.a.l0.a.g;
import d.a.l0.a.z1.b.f.e;
import java.lang.ref.WeakReference;
/* loaded from: classes3.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    public static WeakReference<View> f49886a = null;

    /* renamed from: b  reason: collision with root package name */
    public static Runnable f49887b = null;

    /* renamed from: c  reason: collision with root package name */
    public static e.b f49888c = null;
    @SuppressLint({"StaticFieldLeak"})

    /* renamed from: d  reason: collision with root package name */
    public static View f49889d = null;

    /* renamed from: e  reason: collision with root package name */
    public static boolean f49890e = false;

    /* loaded from: classes3.dex */
    public static class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ View f49891e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ View f49892f;

        /* renamed from: d.a.l0.a.z1.b.f.f$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class animation.Animation$AnimationListenerC0995a implements Animation.AnimationListener {

            /* renamed from: d.a.l0.a.z1.b.f.f$a$a$a  reason: collision with other inner class name */
            /* loaded from: classes3.dex */
            public class RunnableC0996a implements Runnable {
                public RunnableC0996a() {
                }

                @Override // java.lang.Runnable
                public void run() {
                    if (a.this.f49891e.getParent() != null) {
                        ((ViewGroup) a.this.f49891e.getParent()).removeView(a.this.f49891e);
                    }
                }
            }

            /* renamed from: d.a.l0.a.z1.b.f.f$a$a$b */
            /* loaded from: classes3.dex */
            public class b implements Runnable {
                public b() {
                }

                @Override // java.lang.Runnable
                public void run() {
                    View view = a.this.f49892f;
                    if (view == null || view.getParent() == null || !(a.this.f49892f.getParent() instanceof ViewGroup)) {
                        return;
                    }
                    ((ViewGroup) a.this.f49892f.getParent()).removeView(a.this.f49892f);
                }
            }

            public animation.Animation$AnimationListenerC0995a() {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (a.this.f49891e.getParent() instanceof ViewGroup) {
                    a.this.f49891e.post(new RunnableC0996a());
                }
                View view = a.this.f49892f;
                if (view != null) {
                    view.post(new b());
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }
        }

        public a(View view, View view2) {
            this.f49891e = view;
            this.f49892f = view2;
        }

        @Override // java.lang.Runnable
        public void run() {
            WeakReference weakReference = new WeakReference(this.f49891e.getContext());
            if (weakReference.get() == null) {
                return;
            }
            Animation loadAnimation = AnimationUtils.loadAnimation((Context) weakReference.get(), d.a.l0.a.a.aiapps_toast_exit);
            loadAnimation.setAnimationListener(new animation.Animation$AnimationListenerC0995a());
            this.f49891e.startAnimation(loadAnimation);
        }
    }

    /* loaded from: classes3.dex */
    public static class b implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ e.c f49896e;

        public b(e.c cVar) {
            this.f49896e = cVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            e.c cVar = this.f49896e;
            if (cVar != null) {
                cVar.a();
            }
            f.h();
        }
    }

    /* loaded from: classes3.dex */
    public static class c implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ e.c f49897e;

        public c(e.c cVar) {
            this.f49897e = cVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            e.c cVar = this.f49897e;
            if (cVar != null) {
                cVar.a();
            }
            f.h();
        }
    }

    /* loaded from: classes3.dex */
    public static class d implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ View f49898e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Context f49899f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ View f49900g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ FrameLayout.LayoutParams f49901h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ Animation f49902i;

        public d(View view, Context context, View view2, FrameLayout.LayoutParams layoutParams, Animation animation) {
            this.f49898e = view;
            this.f49899f = context;
            this.f49900g = view2;
            this.f49901h = layoutParams;
            this.f49902i = animation;
        }

        @Override // java.lang.Runnable
        public void run() {
            View view;
            if (f.f49890e && this.f49898e != null) {
                if (f.f49889d != null && (f.f49889d.getParent() instanceof ViewGroup)) {
                    ((ViewGroup) f.f49889d.getParent()).removeView(f.f49889d);
                }
                Context context = this.f49899f;
                if ((context instanceof Activity) && ((Activity) context).isFinishing()) {
                    return;
                }
                FrameLayout frameLayout = new FrameLayout(this.f49899f);
                frameLayout.setClickable(true);
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
                layoutParams.topMargin = d.a.l0.a.z1.b.f.e.c(this.f49899f);
                View view2 = this.f49898e;
                if (view2 instanceof ViewGroup) {
                    ((ViewGroup) view2).addView(frameLayout, layoutParams);
                    View unused = f.f49889d = frameLayout;
                }
            }
            if (f.f49886a != null && (view = (View) f.f49886a.get()) != null && (view.getParent() instanceof ViewGroup)) {
                ((ViewGroup) view.getParent()).removeView(view);
            }
            Context context2 = this.f49899f;
            if ((context2 instanceof Activity) && ((Activity) context2).isFinishing()) {
                return;
            }
            ((ViewGroup) this.f49898e).addView(this.f49900g, this.f49901h);
            this.f49900g.startAnimation(this.f49902i);
            WeakReference unused2 = f.f49886a = new WeakReference(this.f49900g);
        }
    }

    /* loaded from: classes3.dex */
    public static class e implements Runnable {
        @Override // java.lang.Runnable
        public void run() {
            f.h();
        }
    }

    public static void f(View view, View view2, int i2, FrameLayout.LayoutParams layoutParams, @AnimRes int i3) {
        if (view == null || view2 == null) {
            return;
        }
        g(view, view2, i2, layoutParams, AnimationUtils.loadAnimation(view.getContext(), i3));
    }

    public static void g(View view, View view2, int i2, FrameLayout.LayoutParams layoutParams, Animation animation) {
        if (view == null || view2 == null) {
            return;
        }
        Context context = view.getContext();
        if (view2.getParent() instanceof ViewGroup) {
            ((ViewGroup) view2.getParent()).removeView(view2);
        }
        view2.setClickable(true);
        if (view instanceof ViewGroup) {
            view.post(new d(view, context, view2, layoutParams, animation));
            if (f49887b == null) {
                f49887b = new e();
            }
            d.a.l0.a.a2.d.i().postDelayed(f49887b, i2 * 1000);
        }
    }

    public static synchronized void h() {
        synchronized (f.class) {
            if (f49886a != null) {
                View view = f49886a.get();
                if (view != null) {
                    view.post(new a(view, f49889d));
                    if (f49887b != null) {
                        view.removeCallbacks(f49887b);
                    }
                }
                if (f49887b != null) {
                    d.a.l0.a.a2.d.i().removeCallbacks(f49887b);
                }
                f49887b = null;
                f49886a = null;
                f49889d = null;
                if (f49888c != null) {
                    f49888c.onDismiss();
                    f49888c = null;
                }
            }
        }
    }

    public static View i(@NonNull Activity activity) {
        if (activity == null || activity.getWindow() == null || activity.getWindow().getDecorView() == null) {
            return null;
        }
        return activity.getWindow().getDecorView().findViewById(16908290);
    }

    public static View j(@NonNull Activity activity) {
        if (activity == null || activity.getWindow() == null || activity.getWindow().getDecorView() == null) {
            return null;
        }
        return activity.getWindow().getDecorView();
    }

    public static boolean k() {
        View view;
        WeakReference<View> weakReference = f49886a;
        return (weakReference == null || (view = weakReference.get()) == null || view.getParent() == null) ? false : true;
    }

    public static void l(e.b bVar) {
        f49888c = bVar;
    }

    public static void m(Activity activity, CharSequence charSequence, int i2, boolean z) {
        Resources resources = d.a.l0.a.c1.a.b().getResources();
        f49890e = z;
        LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(activity).inflate(g.aiapps_toast_template_square_d20, (ViewGroup) null);
        linearLayout.setBackground(resources.getDrawable(d.a.l0.a.e.aiapps_toast_bg_d20));
        linearLayout.findViewById(d.a.l0.a.f.highlight_toast_imageView_d20).setVisibility(8);
        ProgressBar progressBar = (ProgressBar) linearLayout.findViewById(d.a.l0.a.f.highlight_toast_loading_d20);
        progressBar.setVisibility(0);
        progressBar.setIndeterminateDrawable(resources.getDrawable(d.a.l0.a.e.aiapps_toast_loading_d20));
        TextView textView = (TextView) linearLayout.findViewById(d.a.l0.a.f.highlight_toast_text_d20);
        if (!TextUtils.isEmpty(charSequence) && textView != null) {
            textView.setTextColor(resources.getColor(d.a.l0.a.c.GC6));
            textView.setText(charSequence);
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        f(i(activity), linearLayout, i2, layoutParams, d.a.l0.a.a.aiapps_highlight_toast_show_d20);
    }

    public static void n(@NonNull Activity activity, @NonNull CharSequence charSequence, @Nullable Drawable drawable, @Nullable View view, int i2, boolean z) {
        Resources resources = activity.getResources();
        f49890e = z;
        LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(activity).inflate(g.aiapps_toast_template_square_d20, (ViewGroup) null);
        linearLayout.setBackground(resources.getDrawable(d.a.l0.a.e.aiapps_toast_bg_d20));
        TextView textView = (TextView) linearLayout.findViewById(d.a.l0.a.f.highlight_toast_text_d20);
        if (textView != null && !TextUtils.isEmpty(charSequence)) {
            textView.setTextColor(resources.getColor(d.a.l0.a.c.GC6));
            textView.setText(charSequence);
        }
        ImageView imageView = (ImageView) linearLayout.findViewById(d.a.l0.a.f.highlight_toast_imageView_d20);
        if (imageView != null) {
            if (view != null) {
                new d.a.l0.a.z1.b.f.g.b(activity).a(imageView, view);
            } else {
                if (drawable == null) {
                    drawable = resources.getDrawable(d.a.l0.a.e.aiapps_highlight_toast_image_d20);
                }
                d.a.l0.a.z1.b.f.d.j(drawable);
                imageView.setImageDrawable(drawable);
            }
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(resources.getDimensionPixelSize(d.a.l0.a.d.aiapps_highlight_toast_view_width_new_d20), resources.getDimensionPixelSize(d.a.l0.a.d.aiapps_highlight_toast_view_height_new_d20));
        layoutParams.gravity = 17;
        f(i(activity), linearLayout, i2, layoutParams, d.a.l0.a.a.aiapps_highlight_toast_show_d20);
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x00da  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00dd  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00ff  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0103  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0145  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0153  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void o(@NonNull Activity activity, @Nullable Uri uri, @Nullable Drawable drawable, @Nullable View view, @NonNull CharSequence charSequence, @Nullable CharSequence charSequence2, int i2, @NonNull ToastLocation toastLocation, @Nullable e.c cVar, boolean z) {
        ToastLocation toastLocation2;
        if (activity == null) {
            return;
        }
        Resources resources = d.a.l0.a.c1.a.b().getResources();
        View i3 = i(activity);
        if (i3 == null) {
            return;
        }
        f49890e = z;
        LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(activity).inflate(g.aiapps_toast_template_a_d20, (ViewGroup) null);
        linearLayout.setBackground(resources.getDrawable(d.a.l0.a.e.aiapps_toast_bg_d20));
        SimpleDraweeView simpleDraweeView = (SimpleDraweeView) linearLayout.findViewById(d.a.l0.a.f.left_icon_fresco);
        TextView textView = (TextView) linearLayout.findViewById(d.a.l0.a.f.left_toast_info_view);
        LinearLayout linearLayout2 = (LinearLayout) linearLayout.findViewById(d.a.l0.a.f.right_toast_click_area);
        TextView textView2 = (TextView) linearLayout.findViewById(d.a.l0.a.f.right_toast_jump_text);
        View findViewById = linearLayout.findViewById(d.a.l0.a.f.right_toast_vertical_line);
        if (!TextUtils.isEmpty(charSequence)) {
            textView.setTextColor(d.a.l0.a.z1.b.f.b.f49860a);
            if (uri == null && drawable == null && view == null && TextUtils.isEmpty(charSequence2)) {
                simpleDraweeView.setVisibility(8);
                linearLayout2.setVisibility(8);
                textView.setMaxLines(2);
                textView.setText(charSequence);
                textView.setMaxWidth(d.a.l0.a.z1.b.f.g.a.a(activity, 200.0f));
            } else {
                boolean z2 = true;
                if (view != null) {
                    simpleDraweeView.setVisibility(0);
                    new d.a.l0.a.z1.b.f.g.b(activity).a(simpleDraweeView, view);
                } else if (uri == null && drawable == null) {
                    simpleDraweeView.setVisibility(8);
                    textView.setSingleLine();
                    textView.setText(charSequence);
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                    layoutParams.setMargins(d.a.l0.a.z1.b.f.g.a.a(activity, !z2 ? 14.0f : 5.0f), d.a.l0.a.z1.b.f.g.a.a(activity, 9.0f), d.a.l0.a.z1.b.f.g.a.a(activity, 14.0f), d.a.l0.a.z1.b.f.g.a.a(activity, 10.0f));
                    textView.setLayoutParams(layoutParams);
                    if (!TextUtils.isEmpty(charSequence2)) {
                        linearLayout2.setVisibility(8);
                    } else {
                        ((ImageView) linearLayout.findViewById(d.a.l0.a.f.right_jump_img)).setImageDrawable(resources.getDrawable(d.a.l0.a.e.aiapps_toast_right_jump_d20));
                        toastLocation2 = ToastLocation.BOTTOM;
                        linearLayout2.setVisibility(0);
                        textView2.setText(charSequence2);
                        textView2.setTextColor(d.a.l0.a.z1.b.f.b.f49860a);
                        findViewById.setBackground(resources.getDrawable(d.a.l0.a.c.GC36));
                        if (linearLayout2 != null) {
                            linearLayout2.setOnClickListener(new b(cVar));
                            d.a.l0.a.z1.b.f.d.i(linearLayout2);
                        }
                        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, -2);
                        if (ToastLocation.BOTTOM != toastLocation2) {
                            layoutParams2.gravity = 81;
                            layoutParams2.bottomMargin = (int) resources.getDimension(d.a.l0.a.d.aiapps_clickable_toast_view_margin_bottom);
                        } else {
                            layoutParams2.gravity = 17;
                        }
                        f(i3, linearLayout, i2, layoutParams2, d.a.l0.a.a.aiapps_toast_enter);
                        return;
                    }
                } else {
                    simpleDraweeView.setVisibility(0);
                    if (drawable != null) {
                        d.a.l0.a.z1.b.f.d.j(drawable);
                        simpleDraweeView.setImageDrawable(drawable);
                    } else if (uri != null) {
                        simpleDraweeView.setController(Fresco.newDraweeControllerBuilder().setAutoPlayAnimations(true).setUri(uri).build());
                    }
                }
                z2 = false;
                textView.setSingleLine();
                textView.setText(charSequence);
                LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
                layoutParams3.setMargins(d.a.l0.a.z1.b.f.g.a.a(activity, !z2 ? 14.0f : 5.0f), d.a.l0.a.z1.b.f.g.a.a(activity, 9.0f), d.a.l0.a.z1.b.f.g.a.a(activity, 14.0f), d.a.l0.a.z1.b.f.g.a.a(activity, 10.0f));
                textView.setLayoutParams(layoutParams3);
                if (!TextUtils.isEmpty(charSequence2)) {
                }
            }
            toastLocation2 = toastLocation;
            FrameLayout.LayoutParams layoutParams22 = new FrameLayout.LayoutParams(-2, -2);
            if (ToastLocation.BOTTOM != toastLocation2) {
            }
            f(i3, linearLayout, i2, layoutParams22, d.a.l0.a.a.aiapps_toast_enter);
            return;
        }
        d.a.l0.a.z1.b.f.d.h("has no main text");
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v11, resolved type: android.widget.LinearLayout */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00b4  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x01b1  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void p(@NonNull Activity activity, @Nullable Uri uri, @Nullable Drawable drawable, @Nullable View view, @NonNull CharSequence charSequence, @Nullable CharSequence charSequence2, @Nullable CharSequence charSequence3, @Nullable ToastRightAreaStyle toastRightAreaStyle, int i2, boolean z, e.c cVar) {
        if (activity == null) {
            return;
        }
        Resources resources = d.a.l0.a.c1.a.b().getResources();
        if ((z ? j(activity) : i(activity)) == null) {
            return;
        }
        LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(activity).inflate(g.aiapps_toast_template_b_d20, (ViewGroup) null);
        linearLayout.setBackground(resources.getDrawable(d.a.l0.a.e.aiapps_toast_bg_d20));
        boolean z2 = true;
        linearLayout.setClickable(true);
        LinearLayout linearLayout2 = (LinearLayout) linearLayout.findViewById(d.a.l0.a.f.text_area);
        SimpleDraweeView simpleDraweeView = (SimpleDraweeView) linearLayout.findViewById(d.a.l0.a.f.left_icon);
        simpleDraweeView.setVisibility(0);
        if (view != null) {
            new d.a.l0.a.z1.b.f.g.b(activity).a(simpleDraweeView, view);
        } else if (drawable != null) {
            d.a.l0.a.z1.b.f.d.j(drawable);
            simpleDraweeView.setImageDrawable(drawable);
        } else if (uri != null) {
            simpleDraweeView.setController(Fresco.newDraweeControllerBuilder().setAutoPlayAnimations(true).setUri(uri).build());
        } else {
            simpleDraweeView.setVisibility(8);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.setMargins(d.a.l0.a.z1.b.f.g.a.a(activity, 15.0f), 0, 0, 0);
            linearLayout2.setLayoutParams(layoutParams);
            TextView textView = (TextView) linearLayout.findViewById(d.a.l0.a.f.title);
            TextView textView2 = (TextView) linearLayout.findViewById(d.a.l0.a.f.sub_title);
            TextView textView3 = (TextView) linearLayout.findViewById(d.a.l0.a.f.one_line_text);
            if (TextUtils.isEmpty(charSequence)) {
                if (!TextUtils.isEmpty(charSequence2)) {
                    if (z2) {
                        textView.setMaxWidth(d.a.l0.a.z1.b.f.g.a.a(activity, 175.0f));
                        textView2.setMaxWidth(d.a.l0.a.z1.b.f.g.a.a(activity, 175.0f));
                    }
                    textView.setText(charSequence);
                    textView2.setText(charSequence2);
                    textView.setVisibility(0);
                    textView2.setVisibility(0);
                    textView.setTextColor(d.a.l0.a.z1.b.f.b.f49860a);
                    textView2.setTextColor(resources.getColor(d.a.l0.a.c.GC4));
                    textView3.setVisibility(8);
                } else {
                    if (z2) {
                        textView3.setMaxWidth(d.a.l0.a.z1.b.f.g.a.a(activity, 175.0f));
                    }
                    textView3.setText(charSequence);
                    textView.setVisibility(8);
                    textView2.setVisibility(8);
                    textView3.setVisibility(0);
                    textView3.setTextColor(d.a.l0.a.z1.b.f.b.f49860a);
                }
                FrameLayout frameLayout = (FrameLayout) linearLayout.findViewById(d.a.l0.a.f.btn_area);
                LinearLayout linearLayout3 = (LinearLayout) linearLayout.findViewById(d.a.l0.a.f.jump_area);
                TextView textView4 = (TextView) linearLayout.findViewById(d.a.l0.a.f.btn_text);
                textView4.setBackground(resources.getDrawable(d.a.l0.a.e.aiapps_template_2_btn_bg_d20));
                TextView textView5 = (TextView) linearLayout.findViewById(d.a.l0.a.f.jump_text);
                ImageView imageView = (ImageView) linearLayout.findViewById(d.a.l0.a.f.jump_view);
                View findViewById = linearLayout.findViewById(d.a.l0.a.f.right_toast_vertical_line);
                if (!TextUtils.isEmpty(charSequence3)) {
                    if (toastRightAreaStyle == ToastRightAreaStyle.BUTTON) {
                        frameLayout.setVisibility(0);
                        linearLayout3.setVisibility(8);
                        textView4.setText(charSequence3);
                        textView4.setTextColor(resources.getColor(d.a.l0.a.c.GC6));
                    } else {
                        linearLayout3.setVisibility(0);
                        frameLayout.setVisibility(8);
                        textView5.setText(charSequence3);
                        textView5.setTextColor(d.a.l0.a.z1.b.f.b.f49860a);
                        imageView.setImageDrawable(resources.getDrawable(d.a.l0.a.e.aiapps_toast_right_jump_d20));
                        findViewById.setBackground(resources.getDrawable(d.a.l0.a.c.GC36));
                        frameLayout = linearLayout3;
                    }
                    if (frameLayout != null) {
                        frameLayout.setOnClickListener(new c(cVar));
                        d.a.l0.a.z1.b.f.d.i(frameLayout);
                    }
                } else {
                    frameLayout.setVisibility(8);
                    linearLayout3.setVisibility(8);
                }
                FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, -2);
                layoutParams2.gravity = 81;
                layoutParams2.bottomMargin = (int) resources.getDimension(d.a.l0.a.d.aiapps_clickable_toast_view_margin_bottom);
                f(i(activity), linearLayout, i2, layoutParams2, d.a.l0.a.a.aiapps_toast_enter);
                return;
            }
            d.a.l0.a.z1.b.f.d.h("has no main text");
            return;
        }
        z2 = false;
        TextView textView6 = (TextView) linearLayout.findViewById(d.a.l0.a.f.title);
        TextView textView22 = (TextView) linearLayout.findViewById(d.a.l0.a.f.sub_title);
        TextView textView32 = (TextView) linearLayout.findViewById(d.a.l0.a.f.one_line_text);
        if (TextUtils.isEmpty(charSequence)) {
        }
    }
}
