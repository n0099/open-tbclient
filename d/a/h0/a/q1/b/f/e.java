package d.a.h0.a.q1.b.f;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.AnimRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.facebook.drawee.generic.RoundingParams;
import com.facebook.drawee.view.SimpleDraweeView;
import d.a.h0.a.g;
import d.a.h0.a.q1.b.f.d;
/* loaded from: classes3.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public static View f43756a = null;

    /* renamed from: b  reason: collision with root package name */
    public static Runnable f43757b = null;

    /* renamed from: c  reason: collision with root package name */
    public static View f43758c = null;

    /* renamed from: d  reason: collision with root package name */
    public static boolean f43759d = false;

    /* loaded from: classes3.dex */
    public static class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ View f43760e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ View f43761f;

        /* renamed from: d.a.h0.a.q1.b.f.e$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class animation.Animation$AnimationListenerC0741a implements Animation.AnimationListener {

            /* renamed from: d.a.h0.a.q1.b.f.e$a$a$a  reason: collision with other inner class name */
            /* loaded from: classes3.dex */
            public class RunnableC0742a implements Runnable {
                public RunnableC0742a() {
                }

                @Override // java.lang.Runnable
                public void run() {
                    if (a.this.f43760e.getParent() != null) {
                        ((ViewGroup) a.this.f43760e.getParent()).removeView(a.this.f43760e);
                    }
                }
            }

            /* renamed from: d.a.h0.a.q1.b.f.e$a$a$b */
            /* loaded from: classes3.dex */
            public class b implements Runnable {
                public b() {
                }

                @Override // java.lang.Runnable
                public void run() {
                    View view = a.this.f43761f;
                    if (view == null || view.getParent() == null || !(a.this.f43761f.getParent() instanceof ViewGroup)) {
                        return;
                    }
                    ((ViewGroup) a.this.f43761f.getParent()).removeView(a.this.f43761f);
                }
            }

            public animation.Animation$AnimationListenerC0741a() {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (a.this.f43760e.getParent() instanceof ViewGroup) {
                    a.this.f43760e.post(new RunnableC0742a());
                }
                View view = a.this.f43761f;
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
            this.f43760e = view;
            this.f43761f = view2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Animation loadAnimation = AnimationUtils.loadAnimation(this.f43760e.getContext(), d.a.h0.a.a.aiapps_toast_exit);
            loadAnimation.setAnimationListener(new animation.Animation$AnimationListenerC0741a());
            this.f43760e.startAnimation(loadAnimation);
        }
    }

    /* loaded from: classes3.dex */
    public static class b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ View f43765e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Context f43766f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ View f43767g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ FrameLayout.LayoutParams f43768h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ Animation f43769i;

        public b(View view, Context context, View view2, FrameLayout.LayoutParams layoutParams, Animation animation) {
            this.f43765e = view;
            this.f43766f = context;
            this.f43767g = view2;
            this.f43768h = layoutParams;
            this.f43769i = animation;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (e.f43759d && this.f43765e != null) {
                if (e.f43758c != null && (e.f43758c.getParent() instanceof ViewGroup)) {
                    ((ViewGroup) e.f43758c.getParent()).removeView(e.f43758c);
                }
                Context context = this.f43766f;
                if ((context instanceof Activity) && ((Activity) context).isFinishing()) {
                    return;
                }
                FrameLayout frameLayout = new FrameLayout(this.f43766f);
                frameLayout.setClickable(true);
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
                layoutParams.topMargin = d.a.h0.a.q1.b.f.d.c(this.f43766f);
                View view = this.f43765e;
                if (view instanceof ViewGroup) {
                    ((ViewGroup) view).addView(frameLayout, layoutParams);
                    View unused = e.f43758c = frameLayout;
                }
            }
            if (e.f43756a != null && (e.f43756a.getParent() instanceof ViewGroup)) {
                ((ViewGroup) e.f43756a.getParent()).removeView(e.f43756a);
            }
            Context context2 = this.f43766f;
            if ((context2 instanceof Activity) && ((Activity) context2).isFinishing()) {
                return;
            }
            ((ViewGroup) this.f43765e).addView(this.f43767g, this.f43768h);
            this.f43767g.startAnimation(this.f43769i);
            View unused2 = e.f43756a = this.f43767g;
        }
    }

    /* loaded from: classes3.dex */
    public static class c implements Runnable {
        @Override // java.lang.Runnable
        public void run() {
            e.h();
        }
    }

    /* loaded from: classes3.dex */
    public static class d implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a f43770e;

        public d(d.a aVar) {
            this.f43770e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d.a aVar = this.f43770e;
            if (aVar != null) {
                aVar.a();
            }
            e.h();
        }
    }

    /* renamed from: d.a.h0.a.q1.b.f.e$e  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class View$OnClickListenerC0743e implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a f43771e;

        public View$OnClickListenerC0743e(d.a aVar) {
            this.f43771e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d.a aVar = this.f43771e;
            if (aVar != null) {
                aVar.a();
            }
            e.h();
        }
    }

    /* loaded from: classes3.dex */
    public static class f implements View.OnTouchListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ View f43772e;

        public f(View view) {
            this.f43772e = view;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            int action = motionEvent.getAction();
            if (action == 0) {
                this.f43772e.setAlpha(d.a.h0.a.w0.a.z().a() ? 0.5f : 0.2f);
                return false;
            } else if (action != 2) {
                this.f43772e.setAlpha(1.0f);
                return false;
            } else {
                return false;
            }
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
            view.post(new b(view, context, view2, layoutParams, animation));
            if (f43757b == null) {
                f43757b = new c();
            }
            view.postDelayed(f43757b, i2 * 1000);
        }
    }

    public static synchronized void h() {
        synchronized (e.class) {
            if (f43756a != null) {
                f43756a.post(new a(f43756a, f43758c));
                f43756a.removeCallbacks(f43757b);
                f43756a = null;
                f43757b = null;
                f43758c = null;
            }
        }
    }

    public static View i(@NonNull Activity activity) {
        if (activity == null || activity.getWindow() == null || activity.getWindow().getDecorView() == null) {
            return null;
        }
        return activity.getWindow().getDecorView().findViewById(16908290);
    }

    public static void j(@NonNull Activity activity, @NonNull CharSequence charSequence, int i2, @Nullable CharSequence charSequence2, int i3, @Nullable d.a aVar) {
        TextView textView;
        Resources resources = activity.getResources();
        View i4 = i(activity);
        if (i4 == null) {
            return;
        }
        LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(i4.getContext()).inflate(g.aiapps_clickable_toast_view, (ViewGroup) null);
        linearLayout.setBackground(resources.getDrawable(d.a.h0.a.e.aiapps_clickable_toast_view_bg));
        View findViewById = linearLayout.findViewById(d.a.h0.a.f.clickable_toast_click_area);
        if (!TextUtils.isEmpty(charSequence) && (textView = (TextView) linearLayout.findViewById(d.a.h0.a.f.clickable_toast_info_view)) != null) {
            textView.setText(charSequence);
            textView.setTextColor(resources.getColor(d.a.h0.a.c.aiapps_white_text));
            textView.setTextSize(1, i2);
        }
        View findViewById2 = linearLayout.findViewById(d.a.h0.a.f.clickable_toast_line);
        if (findViewById2 != null) {
            findViewById2.setBackgroundColor(resources.getColor(d.a.h0.a.c.aiapps_white_text));
        }
        TextView textView2 = (TextView) linearLayout.findViewById(d.a.h0.a.f.clickable_toast_check_text);
        if (textView2 != null) {
            textView2.setTextColor(resources.getColor(d.a.h0.a.c.aiapps_white_text));
            if (!TextUtils.isEmpty(charSequence2)) {
                textView2.setText(charSequence2);
                textView2.setTextSize(1, i2);
            }
        }
        ImageView imageView = (ImageView) linearLayout.findViewById(d.a.h0.a.f.clickable_toast_icon_view);
        if (imageView != null) {
            imageView.setImageDrawable(resources.getDrawable(d.a.h0.a.e.aiapps_clickable_toast_icon));
        }
        if (findViewById != null) {
            findViewById.setOnClickListener(new d(aVar));
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 81;
        layoutParams.bottomMargin = (int) resources.getDimension(d.a.h0.a.d.aiapps_clickable_toast_view_margin_bottom);
        f(i4, linearLayout, i3, layoutParams, d.a.h0.a.a.aiapps_toast_enter);
    }

    public static void k(Activity activity, CharSequence charSequence, int i2, boolean z) {
        Resources resources = activity.getResources();
        f43759d = z;
        LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(activity).inflate(g.aiapps_highloading_toast_view, (ViewGroup) null);
        linearLayout.setBackground(resources.getDrawable(d.a.h0.a.e.aiapps_highlight_toast_view_bg));
        TextView textView = (TextView) linearLayout.findViewById(d.a.h0.a.f.highLoading_progress_toast_title);
        if (!TextUtils.isEmpty(charSequence) && textView != null) {
            textView.setTextColor(resources.getColor(d.a.h0.a.c.aiapps_white_text));
            textView.setText(charSequence);
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        f(i(activity), linearLayout, i2, layoutParams, d.a.h0.a.a.aiapps_highlight_toast_show);
    }

    public static void l(@NonNull Activity activity, @NonNull CharSequence charSequence, @Nullable Drawable drawable, int i2, boolean z) {
        Resources resources = activity.getResources();
        f43759d = z;
        LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(activity).inflate(g.aiapps_highlight_toast_view, (ViewGroup) null);
        linearLayout.setBackground(resources.getDrawable(d.a.h0.a.e.aiapps_highlight_toast_view_bg));
        TextView textView = (TextView) linearLayout.findViewById(d.a.h0.a.f.highlight_toast_text);
        if (textView != null && !TextUtils.isEmpty(charSequence)) {
            textView.setTextColor(resources.getColor(d.a.h0.a.c.aiapps_white_text));
            textView.setText(charSequence);
        }
        ImageView imageView = (ImageView) linearLayout.findViewById(d.a.h0.a.f.highlight_toast_imageView);
        if (imageView != null) {
            if (drawable == null) {
                drawable = resources.getDrawable(d.a.h0.a.e.aiapps_highlight_toast_image);
            }
            imageView.setImageDrawable(drawable);
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        f(i(activity), linearLayout, i2, layoutParams, d.a.h0.a.a.aiapps_highlight_toast_show);
    }

    public static void m(@NonNull Activity activity, Uri uri, int i2, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i3, int i4, int i5, @Nullable d.a aVar) {
        boolean z;
        Animation animation;
        TextView textView;
        Resources resources = activity.getResources();
        LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(activity).inflate(g.aiapps_icon_title_message_button_toast_view, (ViewGroup) null);
        linearLayout.setBackground(resources.getDrawable(d.a.h0.a.e.aiapps_clickable_toast_view_bg));
        linearLayout.setClickable(true);
        SimpleDraweeView simpleDraweeView = (SimpleDraweeView) linearLayout.findViewById(d.a.h0.a.f.left_icon);
        if (uri != null) {
            simpleDraweeView.setImageURI(uri);
            if (i2 != 1) {
                simpleDraweeView.getHierarchy().setRoundingParams(new RoundingParams().setRoundAsCircle(false));
            }
        } else {
            simpleDraweeView.setVisibility(8);
        }
        TextView textView2 = (TextView) linearLayout.findViewById(d.a.h0.a.f.title_text);
        TextView textView3 = (TextView) linearLayout.findViewById(d.a.h0.a.f.message_text);
        textView2.setTextColor(resources.getColor(d.a.h0.a.c.aiapps_white_text));
        textView3.setTextColor(resources.getColor(d.a.h0.a.c.aiapps_white_text));
        if (!TextUtils.isEmpty(charSequence) && !TextUtils.isEmpty(charSequence2)) {
            textView2.setText(charSequence);
            textView3.setText(charSequence2);
            z = true;
        } else {
            if (!TextUtils.isEmpty(charSequence)) {
                textView3.setVisibility(8);
                textView2.setText(charSequence);
            } else if (!TextUtils.isEmpty(charSequence2)) {
                textView3.setVisibility(8);
                textView2.setText(charSequence2);
            } else {
                textView2.setVisibility(8);
                textView3.setVisibility(8);
            }
            z = false;
        }
        if (uri == null && !z) {
            int dimensionPixelSize = resources.getDimensionPixelSize(d.a.h0.a.d.aiapps_clickable_toast_single_line_padding);
            ((ViewGroup.MarginLayoutParams) linearLayout.findViewById(d.a.h0.a.f.text_area).getLayoutParams()).setMargins(0, dimensionPixelSize, 0, dimensionPixelSize);
        }
        View findViewById = linearLayout.findViewById(d.a.h0.a.f.clickable_toast_click_area);
        if (!TextUtils.isEmpty(charSequence3)) {
            if (i3 != 1) {
                linearLayout.findViewById(d.a.h0.a.f.line_text_icon_btn).setVisibility(8);
                textView = (TextView) linearLayout.findViewById(d.a.h0.a.f.bg_text_btn);
                textView.setBackground(resources.getDrawable(d.a.h0.a.e.aiapps_toast_button_view_bg));
                textView.setTextColor(resources.getColor(d.a.h0.a.c.aiapps_white_text));
                textView.setText(charSequence3);
            } else {
                linearLayout.findViewById(d.a.h0.a.f.bg_text_btn).setVisibility(8);
                linearLayout.findViewById(d.a.h0.a.f.clickable_toast_line).setBackgroundColor(resources.getColor(d.a.h0.a.c.aiapps_white_text));
                textView = (TextView) linearLayout.findViewById(d.a.h0.a.f.clickable_toast_check_text);
                textView.setTextColor(resources.getColor(d.a.h0.a.c.aiapps_white_text));
                textView.setText(charSequence3);
                ((ImageView) linearLayout.findViewById(d.a.h0.a.f.clickable_toast_icon_view)).setImageDrawable(resources.getDrawable(d.a.h0.a.e.aiapps_clickable_toast_icon));
            }
            findViewById.setOnClickListener(new View$OnClickListenerC0743e(aVar));
            findViewById.setOnTouchListener(new f(textView));
        } else {
            findViewById.setVisibility(8);
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 81;
        layoutParams.bottomMargin = (int) resources.getDimension(d.a.h0.a.d.aiapps_clickable_toast_view_margin_bottom);
        if (i4 != 2) {
            animation = AnimationUtils.loadAnimation(activity, d.a.h0.a.a.aiapps_toast_enter);
        } else {
            int dimensionPixelSize2 = resources.getDimensionPixelSize(d.a.h0.a.d.aiapps_clickable_toast_view_shift_start_y);
            AnimationSet animationSet = new AnimationSet(true);
            animationSet.setDuration(200L);
            animationSet.setInterpolator(new DecelerateInterpolator());
            animationSet.addAnimation(new TranslateAnimation(0, 0.0f, 0, 0.0f, 0, dimensionPixelSize2, 0, 0.0f));
            animationSet.addAnimation(new AlphaAnimation(0.0f, 1.0f));
            animation = animationSet;
        }
        g(i(activity), linearLayout, i5, layoutParams, animation);
    }

    public static void n(@NonNull Activity activity, @NonNull CharSequence charSequence, int i2, int i3, boolean z) {
        TextView textView;
        Resources resources = activity.getResources();
        RelativeLayout relativeLayout = (RelativeLayout) LayoutInflater.from(activity).inflate(g.aiapps_normal_toast_view, (ViewGroup) null);
        relativeLayout.setBackground(resources.getDrawable(d.a.h0.a.e.aiapps_normal_toast_view_bg));
        if (!TextUtils.isEmpty(charSequence) && (textView = (TextView) relativeLayout.findViewById(d.a.h0.a.f.normal_toast_text)) != null) {
            textView.setTextColor(resources.getColor(d.a.h0.a.c.aiapps_white_text));
            textView.setText(charSequence);
            if (i3 >= 2) {
                textView.setSingleLine(false);
                textView.setMaxLines(i3);
                textView.setGravity(17);
            }
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        f(i(activity), relativeLayout, i2, layoutParams, d.a.h0.a.a.aiapps_toast_enter);
    }

    public static void o(@NonNull Activity activity, @NonNull CharSequence charSequence, int i2) {
        TextView textView;
        Resources resources = activity.getResources();
        RelativeLayout relativeLayout = (RelativeLayout) LayoutInflater.from(activity).inflate(g.aiapps_normal_toast_view, (ViewGroup) null);
        relativeLayout.setBackground(resources.getDrawable(d.a.h0.a.e.aiapps_normal_toast_view_bg));
        if (!TextUtils.isEmpty(charSequence) && (textView = (TextView) relativeLayout.findViewById(d.a.h0.a.f.normal_toast_text)) != null) {
            textView.setTextColor(resources.getColor(d.a.h0.a.c.aiapps_white_text));
            textView.setText(charSequence);
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 81;
        layoutParams.bottomMargin = (int) resources.getDimension(d.a.h0.a.d.aiapps_clickable_toast_view_margin_bottom);
        f(i(activity), relativeLayout, i2, layoutParams, d.a.h0.a.a.aiapps_toast_enter);
    }
}
