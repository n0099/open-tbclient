package d.a.l0.a.s0;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.UiThread;
import com.baidu.swan.apps.view.SwanAppRoundedImageView;
import d.a.l0.a.g;
import d.a.l0.a.i;
import d.a.l0.a.v2.n0;
import d.a.l0.a.v2.q0;
import d.a.l0.a.z1.b.b.h;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public final class c {

    /* loaded from: classes3.dex */
    public static class a implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ List f48323e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ TextView f48324f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Resources f48325g;

        public a(List list, TextView textView, Resources resources) {
            this.f48323e = list;
            this.f48324f = textView;
            this.f48325g = resources;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (this.f48323e.size() > 0) {
                this.f48324f.setBackground(this.f48325g.getDrawable(d.a.l0.a.e.swan_app_auth_positive_bg_selector));
            } else {
                this.f48324f.setBackground(this.f48325g.getDrawable(d.a.l0.a.e.swan_app_auth_pos_button_unable));
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class b implements DialogInterface.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ f f48326e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ List f48327f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ h f48328g;

        public b(f fVar, List list, h hVar) {
            this.f48326e = fVar;
            this.f48327f = list;
            this.f48328g = hVar;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i2) {
            if (this.f48326e.a(dialogInterface, i2, this.f48327f)) {
                this.f48328g.dismiss();
            }
        }
    }

    /* renamed from: d.a.l0.a.s0.c$c  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class View$OnClickListenerC0874c implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ h f48329e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ DialogInterface.OnClickListener f48330f;

        public View$OnClickListenerC0874c(h hVar, DialogInterface.OnClickListener onClickListener) {
            this.f48329e = hVar;
            this.f48330f = onClickListener;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f48329e.e(-1);
            this.f48330f.onClick(this.f48329e, -1);
        }
    }

    /* loaded from: classes3.dex */
    public static class d implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ h f48331e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ DialogInterface.OnClickListener f48332f;

        public d(h hVar, DialogInterface.OnClickListener onClickListener) {
            this.f48331e = hVar;
            this.f48332f = onClickListener;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f48331e.e(-2);
            this.f48332f.onClick(this.f48331e, -2);
        }
    }

    /* loaded from: classes3.dex */
    public static class e implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public boolean f48333e = true;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ TextView f48334f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Drawable f48335g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ Drawable f48336h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ int f48337i;
        public final /* synthetic */ List j;
        public final /* synthetic */ d.a.l0.a.s0.d k;
        public final /* synthetic */ View.OnClickListener l;

        public e(TextView textView, Drawable drawable, Drawable drawable2, int i2, List list, d.a.l0.a.s0.d dVar, View.OnClickListener onClickListener) {
            this.f48334f = textView;
            this.f48335g = drawable;
            this.f48336h = drawable2;
            this.f48337i = i2;
            this.j = list;
            this.k = dVar;
            this.l = onClickListener;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            boolean z = !this.f48333e;
            this.f48333e = z;
            this.f48334f.setCompoundDrawablesWithIntrinsicBounds(z ? this.f48335g : this.f48336h, (Drawable) null, (Drawable) null, (Drawable) null);
            this.f48334f.setCompoundDrawablePadding(this.f48337i);
            if (this.f48333e) {
                this.j.add(this.k);
            } else {
                this.j.remove(this.k);
            }
            this.l.onClick(view);
        }
    }

    /* loaded from: classes3.dex */
    public interface f {
        boolean a(DialogInterface dialogInterface, int i2, List<d.a.l0.a.s0.d> list);
    }

    @UiThread
    public static h a(@NonNull Activity activity, @NonNull d.a.l0.a.a2.e eVar, @Nullable String str, @NonNull List<d.a.l0.a.s0.d> list, @NonNull f fVar, @Nullable DialogInterface.OnCancelListener onCancelListener) {
        View inflate = View.inflate(activity, g.swan_app_subscribe_msg_dialog, null);
        SwanAppRoundedImageView swanAppRoundedImageView = (SwanAppRoundedImageView) inflate.findViewById(d.a.l0.a.f.swan_app_icon);
        Resources resources = activity.getResources();
        if (swanAppRoundedImageView != null) {
            swanAppRoundedImageView.setImageDrawable(new BitmapDrawable(resources, q0.i(eVar.L(), "SwanSubscribeMsgDialog", false)));
            swanAppRoundedImageView.setBorderColor(resources.getColor(d.a.l0.a.c.swan_app_auth_icon_border));
        }
        TextView textView = (TextView) inflate.findViewById(d.a.l0.a.f.auth_negative_button);
        TextView textView2 = (TextView) inflate.findViewById(d.a.l0.a.f.auth_positive_button);
        ((TextView) inflate.findViewById(d.a.l0.a.f.swan_app_name)).setText(eVar.O());
        ((TextView) inflate.findViewById(d.a.l0.a.f.tips)).setText(str);
        LinearLayout linearLayout = (LinearLayout) inflate.findViewById(d.a.l0.a.f.template_title_layout);
        ArrayList arrayList = new ArrayList(list);
        if (list.size() > 0) {
            for (d.a.l0.a.s0.d dVar : list) {
                linearLayout.addView(b(activity, dVar, arrayList, new a(arrayList, textView2, resources)));
            }
        }
        h.a aVar = new h.a(activity);
        aVar.f(true);
        aVar.W(inflate);
        aVar.n(new d.a.l0.a.w2.h.a());
        aVar.p(d.a.l0.a.e.aiapps_action_sheet_bg);
        aVar.k(false);
        aVar.j();
        aVar.t(false);
        h c2 = aVar.c();
        b bVar = new b(fVar, arrayList, c2);
        textView2.setOnClickListener(new View$OnClickListenerC0874c(c2, bVar));
        textView.setOnClickListener(new d(c2, bVar));
        c2.a(false);
        c2.setOnCancelListener(onCancelListener);
        Window window = c2.getWindow();
        if (window != null) {
            window.setGravity(80);
            window.setLayout(n0.t(activity), -2);
            window.setWindowAnimations(i.action_sheet_animation);
        }
        return c2;
    }

    public static View b(@NonNull Activity activity, @NonNull d.a.l0.a.s0.d dVar, List<d.a.l0.a.s0.d> list, View.OnClickListener onClickListener) {
        Resources resources = activity.getResources();
        int dimension = (int) resources.getDimension(d.a.l0.a.d.swan_app_template_title_padding);
        TextView textView = new TextView(activity);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.setMargins(0, 16, 0, 16);
        textView.setLayoutParams(layoutParams);
        textView.setTextColor(d.a.l0.o.a.b.a.b(activity, d.a.l0.a.c.swan_app_msg_dialog_title));
        textView.setText(dVar.f48339b);
        Drawable drawable = resources.getDrawable(d.a.l0.a.e.aiapps_subscribe_msg_unselected);
        Drawable drawable2 = resources.getDrawable(d.a.l0.a.e.aiapps_subscribe_msg_selected);
        textView.setCompoundDrawablesWithIntrinsicBounds(drawable2, (Drawable) null, (Drawable) null, (Drawable) null);
        textView.setCompoundDrawablePadding(dimension);
        textView.setTextSize(18.0f);
        textView.setOnClickListener(new e(textView, drawable2, drawable, dimension, list, dVar, onClickListener));
        return textView;
    }
}
