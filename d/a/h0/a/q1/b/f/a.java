package d.a.h0.a.q1.b.f;

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
import d.a.h0.a.i;
import d.a.h0.a.k;
import d.a.h0.a.q1.b.f.d;
import java.lang.ref.WeakReference;
/* loaded from: classes3.dex */
public final class a {

    /* renamed from: b  reason: collision with root package name */
    public static WeakReference<d.a.h0.a.q1.b.f.b> f43708b;

    /* renamed from: c  reason: collision with root package name */
    public static Toast f43709c;

    /* renamed from: a  reason: collision with root package name */
    public static boolean f43707a = k.f43101a;

    /* renamed from: d  reason: collision with root package name */
    public static Handler f43710d = new Handler(Looper.getMainLooper());

    /* renamed from: d.a.h0.a.q1.b.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class View$OnTouchListenerC0738a implements View.OnTouchListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ View f43711e;

        public View$OnTouchListenerC0738a(View view) {
            this.f43711e = view;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            int action = motionEvent.getAction();
            if (action == 0) {
                this.f43711e.setAlpha(d.a.h0.a.w0.a.z().a() ? 0.5f : 0.2f);
                return false;
            } else if (action != 2) {
                this.f43711e.setAlpha(1.0f);
                return false;
            } else {
                return false;
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ View f43712e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Context f43713f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ LinearLayout f43714g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ Context f43715h;

        public b(View view, Context context, LinearLayout linearLayout, Context context2) {
            this.f43712e = view;
            this.f43713f = context;
            this.f43714g = linearLayout;
            this.f43715h = context2;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f43712e.setVisibility(8);
            Toast unused = a.f43709c = new Toast(this.f43713f);
            a.f43709c.setView(this.f43714g);
            a.f43709c.setGravity(81, 0, (int) this.f43715h.getResources().getDimension(d.a.h0.a.d.aiapps_clickable_toast_view_margin_bottom));
            d.a.h0.a.q1.b.f.c.i(a.f43709c, i.toast_animation);
            a.f43709c.show();
        }
    }

    /* loaded from: classes3.dex */
    public static class c implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Context f43716e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ RelativeLayout f43717f;

        public c(Context context, RelativeLayout relativeLayout) {
            this.f43716e = context;
            this.f43717f = relativeLayout;
        }

        @Override // java.lang.Runnable
        public void run() {
            Toast unused = a.f43709c = new Toast(this.f43716e);
            a.f43709c.setView(this.f43717f);
            a.f43709c.setGravity(17, 0, 0);
            d.a.h0.a.q1.b.f.c.i(a.f43709c, i.toast_animation);
            try {
                a.f43709c.show();
            } catch (NullPointerException e2) {
                if (a.f43707a) {
                    e2.printStackTrace();
                }
            }
            if (a.f43707a) {
                Log.d("SingleToast", "mSystemToast.show() invoked in show");
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class d implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Context f43718e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ RelativeLayout f43719f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Context f43720g;

        public d(Context context, RelativeLayout relativeLayout, Context context2) {
            this.f43718e = context;
            this.f43719f = relativeLayout;
            this.f43720g = context2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Toast unused = a.f43709c = new Toast(this.f43718e);
            a.f43709c.setView(this.f43719f);
            a.f43709c.setGravity(81, 0, (int) this.f43720g.getResources().getDimension(d.a.h0.a.d.aiapps_clickable_toast_view_margin_bottom));
            d.a.h0.a.q1.b.f.c.i(a.f43709c, i.toast_animation);
            a.f43709c.show();
            if (a.f43707a) {
                Log.d("SingleToast", "mSystemToast.show() invoked in showToastBottom");
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class e implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Context f43721e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ LinearLayout f43722f;

        public e(Context context, LinearLayout linearLayout) {
            this.f43721e = context;
            this.f43722f = linearLayout;
        }

        @Override // java.lang.Runnable
        public void run() {
            Toast unused = a.f43709c = new Toast(this.f43721e);
            a.f43709c.setView(this.f43722f);
            a.f43709c.setGravity(17, 0, 0);
            d.a.h0.a.q1.b.f.c.i(a.f43709c, i.highlight_toast_animation);
            a.f43709c.show();
        }
    }

    /* loaded from: classes3.dex */
    public static class f implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Context f43723e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ LinearLayout f43724f;

        public f(Context context, LinearLayout linearLayout) {
            this.f43723e = context;
            this.f43724f = linearLayout;
        }

        @Override // java.lang.Runnable
        public void run() {
            Toast unused = a.f43709c = new Toast(this.f43723e);
            a.f43709c.setView(this.f43724f);
            a.f43709c.setGravity(17, 0, 0);
            d.a.h0.a.q1.b.f.c.i(a.f43709c, i.highlight_toast_animation);
            a.f43709c.show();
        }
    }

    /* loaded from: classes3.dex */
    public static class g implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Context f43725e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ RelativeLayout f43726f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ d.a f43727g;

        /* renamed from: d.a.h0.a.q1.b.f.a$g$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class View$OnClickListenerC0739a implements View.OnClickListener {
            public View$OnClickListenerC0739a() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d.a aVar = g.this.f43727g;
                if (aVar != null) {
                    aVar.a();
                }
            }
        }

        public g(Context context, RelativeLayout relativeLayout, d.a aVar) {
            this.f43725e = context;
            this.f43726f = relativeLayout;
            this.f43727g = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Toast unused = a.f43709c = new Toast(this.f43725e);
            a.f43709c.setView(this.f43726f);
            a.f43709c.setGravity(81, 0, (int) this.f43725e.getResources().getDimension(d.a.h0.a.d.aiapps_clickable_toast_view_margin_bottom));
            d.a.h0.a.q1.b.f.c.i(a.f43709c, i.toast_animation);
            this.f43726f.setOnClickListener(new View$OnClickListenerC0739a());
            a.f43709c.show();
        }
    }

    public static void d() {
        d.a.h0.a.q1.b.f.b bVar;
        WeakReference<d.a.h0.a.q1.b.f.b> weakReference = f43708b;
        if (weakReference != null && (bVar = weakReference.get()) != null) {
            bVar.q();
        }
        Toast toast = f43709c;
        if (toast != null) {
            toast.cancel();
        }
    }

    public static void e(d.a.h0.a.q1.b.f.b bVar) {
        WeakReference<d.a.h0.a.q1.b.f.b> weakReference = f43708b;
        if (weakReference != null) {
            weakReference.clear();
        }
        f43708b = new WeakReference<>(bVar);
    }

    public static void f(@NonNull Context context, @NonNull CharSequence charSequence, int i2, boolean z, int i3, boolean z2) {
        TextView textView;
        Context applicationContext = context.getApplicationContext();
        Resources resources = context.getResources();
        RelativeLayout relativeLayout = (RelativeLayout) LayoutInflater.from(applicationContext).inflate(d.a.h0.a.g.aiapps_normal_toast_view, (ViewGroup) null);
        relativeLayout.setBackground(resources.getDrawable(d.a.h0.a.e.aiapps_normal_toast_view_bg));
        boolean z3 = true;
        relativeLayout.setClickable(true);
        if (!TextUtils.isEmpty(charSequence) && (textView = (TextView) relativeLayout.findViewById(d.a.h0.a.f.normal_toast_text)) != null) {
            textView.setTextColor(resources.getColor(d.a.h0.a.c.aiapps_white_text));
            textView.setText(charSequence);
            boolean z4 = i3 >= 2;
            textView.setSingleLine((z4 || !z) ? false : false);
            if (z4) {
                textView.setMaxLines(i3);
                textView.setGravity(17);
            }
        }
        if (d.a.h0.a.q1.b.f.c.l(applicationContext)) {
            f43710d.post(new c(applicationContext, relativeLayout));
            return;
        }
        d.a.h0.a.q1.b.f.b bVar = new d.a.h0.a.q1.b.f.b(applicationContext);
        e(bVar);
        bVar.w(relativeLayout);
        bVar.u(z2);
        bVar.t(17, 0, 0);
        bVar.s(i2);
        bVar.x(i.toast_animation);
        bVar.z();
    }

    public static void g(@NonNull Context context, @NonNull CharSequence charSequence, int i2, @Nullable CharSequence charSequence2, int i3, @Nullable d.a aVar) {
        TextView textView;
        TextView textView2;
        Context applicationContext = context.getApplicationContext();
        Resources resources = context.getResources();
        if (d.a.h0.a.q1.b.f.c.l(context)) {
            RelativeLayout relativeLayout = (RelativeLayout) LayoutInflater.from(applicationContext).inflate(d.a.h0.a.g.aiapps_normal_toast_view, (ViewGroup) null);
            relativeLayout.setBackground(resources.getDrawable(d.a.h0.a.e.aiapps_normal_toast_view_bg));
            relativeLayout.setClickable(true);
            if (!TextUtils.isEmpty(charSequence) && (textView2 = (TextView) relativeLayout.findViewById(d.a.h0.a.f.normal_toast_text)) != null) {
                textView2.setText(charSequence);
                textView2.setTextColor(resources.getColor(d.a.h0.a.c.aiapps_white_text));
                textView2.setTextSize(1, i2);
            }
            f43710d.post(new g(applicationContext, relativeLayout, aVar));
            return;
        }
        LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(applicationContext).inflate(d.a.h0.a.g.aiapps_clickable_toast_view, (ViewGroup) null);
        linearLayout.setBackground(resources.getDrawable(d.a.h0.a.e.aiapps_clickable_toast_view_bg));
        linearLayout.setClickable(true);
        if (!TextUtils.isEmpty(charSequence) && (textView = (TextView) linearLayout.findViewById(d.a.h0.a.f.clickable_toast_info_view)) != null) {
            textView.setText(charSequence);
            textView.setTextColor(resources.getColor(d.a.h0.a.c.aiapps_white_text));
            textView.setTextSize(1, i2);
        }
        View findViewById = linearLayout.findViewById(d.a.h0.a.f.clickable_toast_line);
        if (findViewById != null) {
            findViewById.setBackgroundColor(resources.getColor(d.a.h0.a.c.aiapps_white_text));
        }
        TextView textView3 = (TextView) linearLayout.findViewById(d.a.h0.a.f.clickable_toast_check_text);
        if (textView3 != null) {
            textView3.setTextColor(resources.getColor(d.a.h0.a.c.aiapps_white_text));
            if (!TextUtils.isEmpty(charSequence2)) {
                textView3.setText(charSequence2);
                textView3.setTextSize(1, i2);
            }
        }
        ImageView imageView = (ImageView) linearLayout.findViewById(d.a.h0.a.f.clickable_toast_icon_view);
        if (imageView != null) {
            imageView.setImageDrawable(resources.getDrawable(d.a.h0.a.e.aiapps_clickable_toast_icon));
        }
        d.a.h0.a.q1.b.f.b bVar = new d.a.h0.a.q1.b.f.b(applicationContext);
        e(bVar);
        if (d.a.h0.a.q1.b.f.c.c()) {
            bVar.y(2003);
            if (f43707a) {
                Log.d("SingleToast", "Oppo WindowManager has set to TYPE_SYSTEM_ALERT");
            }
        }
        bVar.w(linearLayout);
        bVar.t(81, 0, (int) applicationContext.getResources().getDimension(d.a.h0.a.d.aiapps_clickable_toast_view_margin_bottom));
        bVar.s(i3);
        bVar.v(aVar);
        bVar.x(i.toast_animation);
        bVar.z();
    }

    public static void h(Context context, CharSequence charSequence, int i2, boolean z) {
        Context applicationContext = context.getApplicationContext();
        Resources resources = context.getResources();
        LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(applicationContext).inflate(d.a.h0.a.g.aiapps_highloading_toast_view, (ViewGroup) null);
        linearLayout.setBackground(resources.getDrawable(d.a.h0.a.e.aiapps_highlight_toast_view_bg));
        linearLayout.setClickable(true);
        TextView textView = (TextView) linearLayout.findViewById(d.a.h0.a.f.highLoading_progress_toast_title);
        if (!TextUtils.isEmpty(charSequence) && textView != null) {
            textView.setTextColor(resources.getColor(d.a.h0.a.c.aiapps_white_text));
        }
        if (d.a.h0.a.q1.b.f.c.l(applicationContext)) {
            f43710d.post(new f(context, linearLayout));
            return;
        }
        d.a.h0.a.q1.b.f.b bVar = new d.a.h0.a.q1.b.f.b(applicationContext);
        e(bVar);
        bVar.w(linearLayout);
        bVar.u(z);
        bVar.t(17, 0, 0);
        bVar.s(i2);
        bVar.x(i.highlight_toast_animation);
        bVar.z();
    }

    public static void i(@NonNull Context context, @NonNull CharSequence charSequence, @Nullable Drawable drawable, int i2, boolean z) {
        TextView textView;
        Context applicationContext = context.getApplicationContext();
        Resources resources = context.getResources();
        LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(applicationContext).inflate(d.a.h0.a.g.aiapps_highlight_toast_view, (ViewGroup) null);
        linearLayout.setBackground(resources.getDrawable(d.a.h0.a.e.aiapps_highlight_toast_view_bg));
        linearLayout.setClickable(true);
        if (!TextUtils.isEmpty(charSequence) && (textView = (TextView) linearLayout.findViewById(d.a.h0.a.f.highlight_toast_text)) != null) {
            textView.setTextColor(resources.getColor(d.a.h0.a.c.aiapps_white_text));
            textView.setText(charSequence);
        }
        ImageView imageView = (ImageView) linearLayout.findViewById(d.a.h0.a.f.highlight_toast_imageView);
        if (imageView != null) {
            if (drawable != null) {
                imageView.setImageDrawable(drawable);
            } else {
                imageView.setImageDrawable(resources.getDrawable(d.a.h0.a.e.aiapps_highlight_toast_image));
            }
        }
        if (d.a.h0.a.q1.b.f.c.l(applicationContext)) {
            f43710d.post(new e(context, linearLayout));
            return;
        }
        d.a.h0.a.q1.b.f.b bVar = new d.a.h0.a.q1.b.f.b(applicationContext);
        e(bVar);
        bVar.w(linearLayout);
        bVar.u(z);
        bVar.t(17, 0, 0);
        bVar.s(i2);
        bVar.x(i.highlight_toast_animation);
        bVar.z();
    }

    public static void j(@NonNull Context context, Uri uri, int i2, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i3, int i4, @Nullable d.a aVar) {
        boolean z;
        TextView textView;
        Context applicationContext = context.getApplicationContext();
        Resources resources = context.getResources();
        LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(applicationContext).inflate(d.a.h0.a.g.aiapps_icon_title_message_button_toast_view, (ViewGroup) null);
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
            findViewById.setOnTouchListener(new View$OnTouchListenerC0738a(textView));
        } else {
            findViewById.setVisibility(8);
        }
        if (d.a.h0.a.q1.b.f.c.l(context)) {
            f43710d.post(new b(findViewById, applicationContext, linearLayout, context));
            return;
        }
        d.a.h0.a.q1.b.f.b bVar = new d.a.h0.a.q1.b.f.b(applicationContext);
        e(bVar);
        if (d.a.h0.a.q1.b.f.c.c()) {
            bVar.y(2003);
            if (f43707a) {
                Log.d("SingleToast", "Oppo WindowManager has set to TYPE_SYSTEM_ALERT");
            }
        }
        bVar.w(linearLayout);
        bVar.t(81, 0, (int) context.getResources().getDimension(d.a.h0.a.d.aiapps_clickable_toast_view_margin_bottom));
        bVar.s(i4);
        bVar.v(aVar);
        bVar.x(i.toast_animation);
        bVar.z();
    }

    public static void k(@NonNull Context context, @NonNull CharSequence charSequence, int i2) {
        Context applicationContext = context.getApplicationContext();
        Resources resources = context.getResources();
        RelativeLayout relativeLayout = (RelativeLayout) LayoutInflater.from(applicationContext).inflate(d.a.h0.a.g.aiapps_normal_toast_view, (ViewGroup) null);
        relativeLayout.setBackground(resources.getDrawable(d.a.h0.a.e.aiapps_normal_toast_view_bg));
        TextView textView = (TextView) relativeLayout.findViewById(d.a.h0.a.f.normal_toast_text);
        if (textView != null) {
            textView.setTextColor(resources.getColor(d.a.h0.a.c.aiapps_white_text));
            textView.setText(charSequence);
        }
        if (d.a.h0.a.q1.b.f.c.l(applicationContext)) {
            f43710d.post(new d(applicationContext, relativeLayout, context));
            return;
        }
        d.a.h0.a.q1.b.f.b bVar = new d.a.h0.a.q1.b.f.b(applicationContext);
        e(bVar);
        bVar.w(relativeLayout);
        bVar.t(81, 0, (int) context.getResources().getDimension(d.a.h0.a.d.aiapps_clickable_toast_view_margin_bottom));
        bVar.s(i2);
        bVar.x(i.toast_animation);
        bVar.z();
    }
}
