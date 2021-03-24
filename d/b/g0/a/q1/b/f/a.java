package d.b.g0.a.q1.b.f;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.facebook.drawee.generic.RoundingParams;
import com.facebook.drawee.view.SimpleDraweeView;
import d.b.g0.a.i;
import d.b.g0.a.k;
import d.b.g0.a.q1.b.f.d;
import java.lang.ref.WeakReference;
/* loaded from: classes3.dex */
public final class a {

    /* renamed from: b  reason: collision with root package name */
    public static WeakReference<d.b.g0.a.q1.b.f.b> f45629b;

    /* renamed from: c  reason: collision with root package name */
    public static Toast f45630c;

    /* renamed from: a  reason: collision with root package name */
    public static boolean f45628a = k.f45050a;

    /* renamed from: d  reason: collision with root package name */
    public static Handler f45631d = new Handler(Looper.getMainLooper());

    /* renamed from: d.b.g0.a.q1.b.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class View$OnTouchListenerC0766a implements View.OnTouchListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ View f45632e;

        public View$OnTouchListenerC0766a(View view) {
            this.f45632e = view;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            int action = motionEvent.getAction();
            if (action == 0) {
                this.f45632e.setAlpha(d.b.g0.a.w0.a.z().a() ? 0.5f : 0.2f);
                return false;
            } else if (action != 2) {
                this.f45632e.setAlpha(1.0f);
                return false;
            } else {
                return false;
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ View f45633e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Context f45634f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ LinearLayout f45635g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ Context f45636h;

        public b(View view, Context context, LinearLayout linearLayout, Context context2) {
            this.f45633e = view;
            this.f45634f = context;
            this.f45635g = linearLayout;
            this.f45636h = context2;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f45633e.setVisibility(8);
            Toast unused = a.f45630c = new Toast(this.f45634f);
            a.f45630c.setView(this.f45635g);
            a.f45630c.setGravity(81, 0, (int) this.f45636h.getResources().getDimension(d.b.g0.a.d.aiapps_clickable_toast_view_margin_bottom));
            d.b.g0.a.q1.b.f.c.i(a.f45630c, i.toast_animation);
            a.f45630c.show();
        }
    }

    /* loaded from: classes3.dex */
    public static class c implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Context f45637e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ RelativeLayout f45638f;

        public c(Context context, RelativeLayout relativeLayout) {
            this.f45637e = context;
            this.f45638f = relativeLayout;
        }

        @Override // java.lang.Runnable
        public void run() {
            Toast unused = a.f45630c = new Toast(this.f45637e);
            a.f45630c.setView(this.f45638f);
            a.f45630c.setGravity(17, 0, 0);
            d.b.g0.a.q1.b.f.c.i(a.f45630c, i.toast_animation);
            try {
                a.f45630c.show();
            } catch (NullPointerException e2) {
                if (a.f45628a) {
                    e2.printStackTrace();
                }
            }
            if (a.f45628a) {
                Log.d("SingleToast", "mSystemToast.show() invoked in show");
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class d implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Context f45639e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ RelativeLayout f45640f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Context f45641g;

        public d(Context context, RelativeLayout relativeLayout, Context context2) {
            this.f45639e = context;
            this.f45640f = relativeLayout;
            this.f45641g = context2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Toast unused = a.f45630c = new Toast(this.f45639e);
            a.f45630c.setView(this.f45640f);
            a.f45630c.setGravity(81, 0, (int) this.f45641g.getResources().getDimension(d.b.g0.a.d.aiapps_clickable_toast_view_margin_bottom));
            d.b.g0.a.q1.b.f.c.i(a.f45630c, i.toast_animation);
            a.f45630c.show();
            if (a.f45628a) {
                Log.d("SingleToast", "mSystemToast.show() invoked in showToastBottom");
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class e implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Context f45642e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ LinearLayout f45643f;

        public e(Context context, LinearLayout linearLayout) {
            this.f45642e = context;
            this.f45643f = linearLayout;
        }

        @Override // java.lang.Runnable
        public void run() {
            Toast unused = a.f45630c = new Toast(this.f45642e);
            a.f45630c.setView(this.f45643f);
            a.f45630c.setGravity(17, 0, 0);
            d.b.g0.a.q1.b.f.c.i(a.f45630c, i.highlight_toast_animation);
            a.f45630c.show();
        }
    }

    /* loaded from: classes3.dex */
    public static class f implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Context f45644e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ LinearLayout f45645f;

        public f(Context context, LinearLayout linearLayout) {
            this.f45644e = context;
            this.f45645f = linearLayout;
        }

        @Override // java.lang.Runnable
        public void run() {
            Toast unused = a.f45630c = new Toast(this.f45644e);
            a.f45630c.setView(this.f45645f);
            a.f45630c.setGravity(17, 0, 0);
            d.b.g0.a.q1.b.f.c.i(a.f45630c, i.highlight_toast_animation);
            a.f45630c.show();
        }
    }

    /* loaded from: classes3.dex */
    public static class g implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Context f45646e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ RelativeLayout f45647f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ d.a f45648g;

        /* renamed from: d.b.g0.a.q1.b.f.a$g$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class View$OnClickListenerC0767a implements View.OnClickListener {
            public View$OnClickListenerC0767a() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d.a aVar = g.this.f45648g;
                if (aVar != null) {
                    aVar.a();
                }
            }
        }

        public g(Context context, RelativeLayout relativeLayout, d.a aVar) {
            this.f45646e = context;
            this.f45647f = relativeLayout;
            this.f45648g = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Toast unused = a.f45630c = new Toast(this.f45646e);
            a.f45630c.setView(this.f45647f);
            a.f45630c.setGravity(81, 0, (int) this.f45646e.getResources().getDimension(d.b.g0.a.d.aiapps_clickable_toast_view_margin_bottom));
            d.b.g0.a.q1.b.f.c.i(a.f45630c, i.toast_animation);
            this.f45647f.setOnClickListener(new View$OnClickListenerC0767a());
            a.f45630c.show();
        }
    }

    public static void d() {
        d.b.g0.a.q1.b.f.b bVar;
        WeakReference<d.b.g0.a.q1.b.f.b> weakReference = f45629b;
        if (weakReference != null && (bVar = weakReference.get()) != null) {
            bVar.q();
        }
        Toast toast = f45630c;
        if (toast != null) {
            toast.cancel();
        }
    }

    public static void e(d.b.g0.a.q1.b.f.b bVar) {
        WeakReference<d.b.g0.a.q1.b.f.b> weakReference = f45629b;
        if (weakReference != null) {
            weakReference.clear();
        }
        f45629b = new WeakReference<>(bVar);
    }

    public static void f(@NonNull Context context, @NonNull CharSequence charSequence, int i, boolean z, int i2, boolean z2) {
        TextView textView;
        Context applicationContext = context.getApplicationContext();
        Resources resources = context.getResources();
        RelativeLayout relativeLayout = (RelativeLayout) LayoutInflater.from(applicationContext).inflate(d.b.g0.a.g.aiapps_normal_toast_view, (ViewGroup) null);
        relativeLayout.setBackground(resources.getDrawable(d.b.g0.a.e.aiapps_normal_toast_view_bg));
        boolean z3 = true;
        relativeLayout.setClickable(true);
        if (!TextUtils.isEmpty(charSequence) && (textView = (TextView) relativeLayout.findViewById(d.b.g0.a.f.normal_toast_text)) != null) {
            textView.setTextColor(resources.getColor(d.b.g0.a.c.aiapps_white_text));
            textView.setText(charSequence);
            boolean z4 = i2 >= 2;
            textView.setSingleLine((z4 || !z) ? false : false);
            if (z4) {
                textView.setMaxLines(i2);
                textView.setGravity(17);
            }
        }
        if (d.b.g0.a.q1.b.f.c.l(applicationContext)) {
            f45631d.post(new c(applicationContext, relativeLayout));
            return;
        }
        d.b.g0.a.q1.b.f.b bVar = new d.b.g0.a.q1.b.f.b(applicationContext);
        e(bVar);
        bVar.w(relativeLayout);
        bVar.u(z2);
        bVar.t(17, 0, 0);
        bVar.s(i);
        bVar.x(i.toast_animation);
        bVar.z();
    }

    public static void g(@NonNull Context context, @NonNull CharSequence charSequence, int i, @Nullable CharSequence charSequence2, int i2, @Nullable d.a aVar) {
        TextView textView;
        TextView textView2;
        Context applicationContext = context.getApplicationContext();
        Resources resources = context.getResources();
        if (d.b.g0.a.q1.b.f.c.l(context)) {
            RelativeLayout relativeLayout = (RelativeLayout) LayoutInflater.from(applicationContext).inflate(d.b.g0.a.g.aiapps_normal_toast_view, (ViewGroup) null);
            relativeLayout.setBackground(resources.getDrawable(d.b.g0.a.e.aiapps_normal_toast_view_bg));
            relativeLayout.setClickable(true);
            if (!TextUtils.isEmpty(charSequence) && (textView2 = (TextView) relativeLayout.findViewById(d.b.g0.a.f.normal_toast_text)) != null) {
                textView2.setText(charSequence);
                textView2.setTextColor(resources.getColor(d.b.g0.a.c.aiapps_white_text));
                textView2.setTextSize(1, i);
            }
            f45631d.post(new g(applicationContext, relativeLayout, aVar));
            return;
        }
        LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(applicationContext).inflate(d.b.g0.a.g.aiapps_clickable_toast_view, (ViewGroup) null);
        linearLayout.setBackground(resources.getDrawable(d.b.g0.a.e.aiapps_clickable_toast_view_bg));
        linearLayout.setClickable(true);
        if (!TextUtils.isEmpty(charSequence) && (textView = (TextView) linearLayout.findViewById(d.b.g0.a.f.clickable_toast_info_view)) != null) {
            textView.setText(charSequence);
            textView.setTextColor(resources.getColor(d.b.g0.a.c.aiapps_white_text));
            textView.setTextSize(1, i);
        }
        View findViewById = linearLayout.findViewById(d.b.g0.a.f.clickable_toast_line);
        if (findViewById != null) {
            findViewById.setBackgroundColor(resources.getColor(d.b.g0.a.c.aiapps_white_text));
        }
        TextView textView3 = (TextView) linearLayout.findViewById(d.b.g0.a.f.clickable_toast_check_text);
        if (textView3 != null) {
            textView3.setTextColor(resources.getColor(d.b.g0.a.c.aiapps_white_text));
            if (!TextUtils.isEmpty(charSequence2)) {
                textView3.setText(charSequence2);
                textView3.setTextSize(1, i);
            }
        }
        ImageView imageView = (ImageView) linearLayout.findViewById(d.b.g0.a.f.clickable_toast_icon_view);
        if (imageView != null) {
            imageView.setImageDrawable(resources.getDrawable(d.b.g0.a.e.aiapps_clickable_toast_icon));
        }
        d.b.g0.a.q1.b.f.b bVar = new d.b.g0.a.q1.b.f.b(applicationContext);
        e(bVar);
        if (d.b.g0.a.q1.b.f.c.c()) {
            bVar.y(2003);
            if (f45628a) {
                Log.d("SingleToast", "Oppo WindowManager has set to TYPE_SYSTEM_ALERT");
            }
        }
        bVar.w(linearLayout);
        bVar.t(81, 0, (int) applicationContext.getResources().getDimension(d.b.g0.a.d.aiapps_clickable_toast_view_margin_bottom));
        bVar.s(i2);
        bVar.v(aVar);
        bVar.x(i.toast_animation);
        bVar.z();
    }

    public static void h(Context context, CharSequence charSequence, int i, boolean z) {
        Context applicationContext = context.getApplicationContext();
        Resources resources = context.getResources();
        LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(applicationContext).inflate(d.b.g0.a.g.aiapps_highloading_toast_view, (ViewGroup) null);
        linearLayout.setBackground(resources.getDrawable(d.b.g0.a.e.aiapps_highlight_toast_view_bg));
        linearLayout.setClickable(true);
        TextView textView = (TextView) linearLayout.findViewById(d.b.g0.a.f.highLoading_progress_toast_title);
        if (!TextUtils.isEmpty(charSequence) && textView != null) {
            textView.setTextColor(resources.getColor(d.b.g0.a.c.aiapps_white_text));
        }
        if (d.b.g0.a.q1.b.f.c.l(applicationContext)) {
            f45631d.post(new f(context, linearLayout));
            return;
        }
        d.b.g0.a.q1.b.f.b bVar = new d.b.g0.a.q1.b.f.b(applicationContext);
        e(bVar);
        bVar.w(linearLayout);
        bVar.u(z);
        bVar.t(17, 0, 0);
        bVar.s(i);
        bVar.x(i.highlight_toast_animation);
        bVar.z();
    }

    public static void i(@NonNull Context context, @NonNull CharSequence charSequence, @Nullable Drawable drawable, int i, boolean z) {
        TextView textView;
        Context applicationContext = context.getApplicationContext();
        Resources resources = context.getResources();
        LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(applicationContext).inflate(d.b.g0.a.g.aiapps_highlight_toast_view, (ViewGroup) null);
        linearLayout.setBackground(resources.getDrawable(d.b.g0.a.e.aiapps_highlight_toast_view_bg));
        linearLayout.setClickable(true);
        if (!TextUtils.isEmpty(charSequence) && (textView = (TextView) linearLayout.findViewById(d.b.g0.a.f.highlight_toast_text)) != null) {
            textView.setTextColor(resources.getColor(d.b.g0.a.c.aiapps_white_text));
            textView.setText(charSequence);
        }
        ImageView imageView = (ImageView) linearLayout.findViewById(d.b.g0.a.f.highlight_toast_imageView);
        if (imageView != null) {
            if (drawable != null) {
                imageView.setImageDrawable(drawable);
            } else {
                imageView.setImageDrawable(resources.getDrawable(d.b.g0.a.e.aiapps_highlight_toast_image));
            }
        }
        if (d.b.g0.a.q1.b.f.c.l(applicationContext)) {
            f45631d.post(new e(context, linearLayout));
            return;
        }
        d.b.g0.a.q1.b.f.b bVar = new d.b.g0.a.q1.b.f.b(applicationContext);
        e(bVar);
        bVar.w(linearLayout);
        bVar.u(z);
        bVar.t(17, 0, 0);
        bVar.s(i);
        bVar.x(i.highlight_toast_animation);
        bVar.z();
    }

    public static void j(@NonNull Context context, Uri uri, int i, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i2, int i3, @Nullable d.a aVar) {
        boolean z;
        TextView textView;
        Context applicationContext = context.getApplicationContext();
        Resources resources = context.getResources();
        LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(applicationContext).inflate(d.b.g0.a.g.aiapps_icon_title_message_button_toast_view, (ViewGroup) null);
        linearLayout.setBackground(resources.getDrawable(d.b.g0.a.e.aiapps_clickable_toast_view_bg));
        linearLayout.setClickable(true);
        SimpleDraweeView simpleDraweeView = (SimpleDraweeView) linearLayout.findViewById(d.b.g0.a.f.left_icon);
        if (uri != null) {
            simpleDraweeView.setImageURI(uri);
            if (i != 1) {
                simpleDraweeView.getHierarchy().setRoundingParams(new RoundingParams().setRoundAsCircle(false));
            }
        } else {
            simpleDraweeView.setVisibility(8);
        }
        TextView textView2 = (TextView) linearLayout.findViewById(d.b.g0.a.f.title_text);
        TextView textView3 = (TextView) linearLayout.findViewById(d.b.g0.a.f.message_text);
        textView2.setTextColor(resources.getColor(d.b.g0.a.c.aiapps_white_text));
        textView3.setTextColor(resources.getColor(d.b.g0.a.c.aiapps_white_text));
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
            int dimensionPixelSize = resources.getDimensionPixelSize(d.b.g0.a.d.aiapps_clickable_toast_single_line_padding);
            ((ViewGroup.MarginLayoutParams) linearLayout.findViewById(d.b.g0.a.f.text_area).getLayoutParams()).setMargins(0, dimensionPixelSize, 0, dimensionPixelSize);
        }
        View findViewById = linearLayout.findViewById(d.b.g0.a.f.clickable_toast_click_area);
        if (!TextUtils.isEmpty(charSequence3)) {
            if (i2 != 1) {
                linearLayout.findViewById(d.b.g0.a.f.line_text_icon_btn).setVisibility(8);
                textView = (TextView) linearLayout.findViewById(d.b.g0.a.f.bg_text_btn);
                textView.setBackground(resources.getDrawable(d.b.g0.a.e.aiapps_toast_button_view_bg));
                textView.setTextColor(resources.getColor(d.b.g0.a.c.aiapps_white_text));
                textView.setText(charSequence3);
            } else {
                linearLayout.findViewById(d.b.g0.a.f.bg_text_btn).setVisibility(8);
                linearLayout.findViewById(d.b.g0.a.f.clickable_toast_line).setBackgroundColor(resources.getColor(d.b.g0.a.c.aiapps_white_text));
                textView = (TextView) linearLayout.findViewById(d.b.g0.a.f.clickable_toast_check_text);
                textView.setTextColor(resources.getColor(d.b.g0.a.c.aiapps_white_text));
                textView.setText(charSequence3);
                ((ImageView) linearLayout.findViewById(d.b.g0.a.f.clickable_toast_icon_view)).setImageDrawable(resources.getDrawable(d.b.g0.a.e.aiapps_clickable_toast_icon));
            }
            findViewById.setOnTouchListener(new View$OnTouchListenerC0766a(textView));
        } else {
            findViewById.setVisibility(8);
        }
        if (d.b.g0.a.q1.b.f.c.l(context)) {
            f45631d.post(new b(findViewById, applicationContext, linearLayout, context));
            return;
        }
        d.b.g0.a.q1.b.f.b bVar = new d.b.g0.a.q1.b.f.b(applicationContext);
        e(bVar);
        if (d.b.g0.a.q1.b.f.c.c()) {
            bVar.y(2003);
            if (f45628a) {
                Log.d("SingleToast", "Oppo WindowManager has set to TYPE_SYSTEM_ALERT");
            }
        }
        bVar.w(linearLayout);
        bVar.t(81, 0, (int) context.getResources().getDimension(d.b.g0.a.d.aiapps_clickable_toast_view_margin_bottom));
        bVar.s(i3);
        bVar.v(aVar);
        bVar.x(i.toast_animation);
        bVar.z();
    }

    public static void k(@NonNull Context context, @NonNull CharSequence charSequence, int i) {
        Context applicationContext = context.getApplicationContext();
        Resources resources = context.getResources();
        RelativeLayout relativeLayout = (RelativeLayout) LayoutInflater.from(applicationContext).inflate(d.b.g0.a.g.aiapps_normal_toast_view, (ViewGroup) null);
        relativeLayout.setBackground(resources.getDrawable(d.b.g0.a.e.aiapps_normal_toast_view_bg));
        TextView textView = (TextView) relativeLayout.findViewById(d.b.g0.a.f.normal_toast_text);
        if (textView != null) {
            textView.setTextColor(resources.getColor(d.b.g0.a.c.aiapps_white_text));
            textView.setText(charSequence);
        }
        if (d.b.g0.a.q1.b.f.c.l(applicationContext)) {
            f45631d.post(new d(applicationContext, relativeLayout, context));
            return;
        }
        d.b.g0.a.q1.b.f.b bVar = new d.b.g0.a.q1.b.f.b(applicationContext);
        e(bVar);
        bVar.w(relativeLayout);
        bVar.t(81, 0, (int) context.getResources().getDimension(d.b.g0.a.d.aiapps_clickable_toast_view_margin_bottom));
        bVar.s(i);
        bVar.x(i.toast_animation);
        bVar.z();
    }
}
