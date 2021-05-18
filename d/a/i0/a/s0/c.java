package d.a.i0.a.s0;

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
import d.a.i0.a.g;
import d.a.i0.a.i;
import d.a.i0.a.v2.n0;
import d.a.i0.a.v2.q0;
import d.a.i0.a.z1.b.b.h;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public final class c {

    /* loaded from: classes2.dex */
    public static class a implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ List f44473e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ TextView f44474f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Resources f44475g;

        public a(List list, TextView textView, Resources resources) {
            this.f44473e = list;
            this.f44474f = textView;
            this.f44475g = resources;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (this.f44473e.size() > 0) {
                this.f44474f.setBackground(this.f44475g.getDrawable(d.a.i0.a.e.swan_app_auth_positive_bg_selector));
            } else {
                this.f44474f.setBackground(this.f44475g.getDrawable(d.a.i0.a.e.swan_app_auth_pos_button_unable));
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class b implements DialogInterface.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ f f44476e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ List f44477f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ h f44478g;

        public b(f fVar, List list, h hVar) {
            this.f44476e = fVar;
            this.f44477f = list;
            this.f44478g = hVar;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i2) {
            if (this.f44476e.a(dialogInterface, i2, this.f44477f)) {
                this.f44478g.dismiss();
            }
        }
    }

    /* renamed from: d.a.i0.a.s0.c$c  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class View$OnClickListenerC0807c implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ h f44479e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ DialogInterface.OnClickListener f44480f;

        public View$OnClickListenerC0807c(h hVar, DialogInterface.OnClickListener onClickListener) {
            this.f44479e = hVar;
            this.f44480f = onClickListener;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f44479e.e(-1);
            this.f44480f.onClick(this.f44479e, -1);
        }
    }

    /* loaded from: classes2.dex */
    public static class d implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ h f44481e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ DialogInterface.OnClickListener f44482f;

        public d(h hVar, DialogInterface.OnClickListener onClickListener) {
            this.f44481e = hVar;
            this.f44482f = onClickListener;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f44481e.e(-2);
            this.f44482f.onClick(this.f44481e, -2);
        }
    }

    /* loaded from: classes2.dex */
    public static class e implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public boolean f44483e = true;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ TextView f44484f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Drawable f44485g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ Drawable f44486h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ int f44487i;
        public final /* synthetic */ List j;
        public final /* synthetic */ d.a.i0.a.s0.d k;
        public final /* synthetic */ View.OnClickListener l;

        public e(TextView textView, Drawable drawable, Drawable drawable2, int i2, List list, d.a.i0.a.s0.d dVar, View.OnClickListener onClickListener) {
            this.f44484f = textView;
            this.f44485g = drawable;
            this.f44486h = drawable2;
            this.f44487i = i2;
            this.j = list;
            this.k = dVar;
            this.l = onClickListener;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            boolean z = !this.f44483e;
            this.f44483e = z;
            this.f44484f.setCompoundDrawablesWithIntrinsicBounds(z ? this.f44485g : this.f44486h, (Drawable) null, (Drawable) null, (Drawable) null);
            this.f44484f.setCompoundDrawablePadding(this.f44487i);
            if (this.f44483e) {
                this.j.add(this.k);
            } else {
                this.j.remove(this.k);
            }
            this.l.onClick(view);
        }
    }

    /* loaded from: classes2.dex */
    public interface f {
        boolean a(DialogInterface dialogInterface, int i2, List<d.a.i0.a.s0.d> list);
    }

    @UiThread
    public static h a(@NonNull Activity activity, @NonNull d.a.i0.a.a2.e eVar, @Nullable String str, @NonNull List<d.a.i0.a.s0.d> list, @NonNull f fVar, @Nullable DialogInterface.OnCancelListener onCancelListener) {
        View inflate = View.inflate(activity, g.swan_app_subscribe_msg_dialog, null);
        SwanAppRoundedImageView swanAppRoundedImageView = (SwanAppRoundedImageView) inflate.findViewById(d.a.i0.a.f.swan_app_icon);
        Resources resources = activity.getResources();
        if (swanAppRoundedImageView != null) {
            swanAppRoundedImageView.setImageDrawable(new BitmapDrawable(resources, q0.i(eVar.L(), "SwanSubscribeMsgDialog", false)));
            swanAppRoundedImageView.setBorderColor(resources.getColor(d.a.i0.a.c.swan_app_auth_icon_border));
        }
        TextView textView = (TextView) inflate.findViewById(d.a.i0.a.f.auth_negative_button);
        TextView textView2 = (TextView) inflate.findViewById(d.a.i0.a.f.auth_positive_button);
        ((TextView) inflate.findViewById(d.a.i0.a.f.swan_app_name)).setText(eVar.O());
        ((TextView) inflate.findViewById(d.a.i0.a.f.tips)).setText(str);
        LinearLayout linearLayout = (LinearLayout) inflate.findViewById(d.a.i0.a.f.template_title_layout);
        ArrayList arrayList = new ArrayList(list);
        if (list.size() > 0) {
            for (d.a.i0.a.s0.d dVar : list) {
                linearLayout.addView(b(activity, dVar, arrayList, new a(arrayList, textView2, resources)));
            }
        }
        h.a aVar = new h.a(activity);
        aVar.f(true);
        aVar.W(inflate);
        aVar.n(new d.a.i0.a.w2.h.a());
        aVar.p(d.a.i0.a.e.aiapps_action_sheet_bg);
        aVar.k(false);
        aVar.j();
        aVar.t(false);
        h c2 = aVar.c();
        b bVar = new b(fVar, arrayList, c2);
        textView2.setOnClickListener(new View$OnClickListenerC0807c(c2, bVar));
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

    public static View b(@NonNull Activity activity, @NonNull d.a.i0.a.s0.d dVar, List<d.a.i0.a.s0.d> list, View.OnClickListener onClickListener) {
        Resources resources = activity.getResources();
        int dimension = (int) resources.getDimension(d.a.i0.a.d.swan_app_template_title_padding);
        TextView textView = new TextView(activity);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.setMargins(0, 16, 0, 16);
        textView.setLayoutParams(layoutParams);
        textView.setTextColor(d.a.i0.o.a.b.a.b(activity, d.a.i0.a.c.swan_app_msg_dialog_title));
        textView.setText(dVar.f44489b);
        Drawable drawable = resources.getDrawable(d.a.i0.a.e.aiapps_subscribe_msg_unselected);
        Drawable drawable2 = resources.getDrawable(d.a.i0.a.e.aiapps_subscribe_msg_selected);
        textView.setCompoundDrawablesWithIntrinsicBounds(drawable2, (Drawable) null, (Drawable) null, (Drawable) null);
        textView.setCompoundDrawablePadding(dimension);
        textView.setTextSize(18.0f);
        textView.setOnClickListener(new e(textView, drawable2, drawable, dimension, list, dVar, onClickListener));
        return textView;
    }
}
