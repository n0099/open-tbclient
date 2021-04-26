package d.a.h0.a.n0;

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
import d.a.h0.a.i;
import d.a.h0.a.i2.h0;
import d.a.h0.a.i2.k0;
import d.a.h0.a.q1.b.b.g;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public final class c {

    /* loaded from: classes2.dex */
    public static class a implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ List f43383e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ TextView f43384f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Resources f43385g;

        public a(List list, TextView textView, Resources resources) {
            this.f43383e = list;
            this.f43384f = textView;
            this.f43385g = resources;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (this.f43383e.size() > 0) {
                this.f43384f.setBackground(this.f43385g.getDrawable(d.a.h0.a.e.swan_app_auth_positive_bg_selector));
            } else {
                this.f43384f.setBackground(this.f43385g.getDrawable(d.a.h0.a.e.swan_app_auth_pos_button_unable));
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class b implements DialogInterface.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ f f43386e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ List f43387f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ g f43388g;

        public b(f fVar, List list, g gVar) {
            this.f43386e = fVar;
            this.f43387f = list;
            this.f43388g = gVar;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i2) {
            if (this.f43386e.a(dialogInterface, i2, this.f43387f)) {
                this.f43388g.dismiss();
            }
        }
    }

    /* renamed from: d.a.h0.a.n0.c$c  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class View$OnClickListenerC0712c implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ g f43389e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ DialogInterface.OnClickListener f43390f;

        public View$OnClickListenerC0712c(g gVar, DialogInterface.OnClickListener onClickListener) {
            this.f43389e = gVar;
            this.f43390f = onClickListener;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f43389e.e(-1);
            this.f43390f.onClick(this.f43389e, -1);
        }
    }

    /* loaded from: classes2.dex */
    public static class d implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ g f43391e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ DialogInterface.OnClickListener f43392f;

        public d(g gVar, DialogInterface.OnClickListener onClickListener) {
            this.f43391e = gVar;
            this.f43392f = onClickListener;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f43391e.e(-2);
            this.f43392f.onClick(this.f43391e, -2);
        }
    }

    /* loaded from: classes2.dex */
    public static class e implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public boolean f43393e = true;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ TextView f43394f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Drawable f43395g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ Drawable f43396h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ int f43397i;
        public final /* synthetic */ List j;
        public final /* synthetic */ d.a.h0.a.n0.d k;
        public final /* synthetic */ View.OnClickListener l;

        public e(TextView textView, Drawable drawable, Drawable drawable2, int i2, List list, d.a.h0.a.n0.d dVar, View.OnClickListener onClickListener) {
            this.f43394f = textView;
            this.f43395g = drawable;
            this.f43396h = drawable2;
            this.f43397i = i2;
            this.j = list;
            this.k = dVar;
            this.l = onClickListener;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            boolean z = !this.f43393e;
            this.f43393e = z;
            this.f43394f.setCompoundDrawablesWithIntrinsicBounds(z ? this.f43395g : this.f43396h, (Drawable) null, (Drawable) null, (Drawable) null);
            this.f43394f.setCompoundDrawablePadding(this.f43397i);
            if (this.f43393e) {
                this.j.add(this.k);
            } else {
                this.j.remove(this.k);
            }
            this.l.onClick(view);
        }
    }

    /* loaded from: classes2.dex */
    public interface f {
        boolean a(DialogInterface dialogInterface, int i2, List<d.a.h0.a.n0.d> list);
    }

    @UiThread
    public static g a(@NonNull Activity activity, @NonNull d.a.h0.a.r1.e eVar, @Nullable String str, @NonNull List<d.a.h0.a.n0.d> list, @NonNull f fVar, @Nullable DialogInterface.OnCancelListener onCancelListener) {
        View inflate = View.inflate(activity, d.a.h0.a.g.swan_app_subscribe_msg_dialog, null);
        SwanAppRoundedImageView swanAppRoundedImageView = (SwanAppRoundedImageView) inflate.findViewById(d.a.h0.a.f.swan_app_icon);
        Resources resources = activity.getResources();
        if (swanAppRoundedImageView != null) {
            swanAppRoundedImageView.setImageDrawable(new BitmapDrawable(resources, k0.j(eVar.J(), "SwanSubscribeMsgDialog", false)));
            swanAppRoundedImageView.setBorderColor(resources.getColor(d.a.h0.a.c.swan_app_auth_icon_border));
        }
        TextView textView = (TextView) inflate.findViewById(d.a.h0.a.f.auth_negative_button);
        TextView textView2 = (TextView) inflate.findViewById(d.a.h0.a.f.auth_positive_button);
        ((TextView) inflate.findViewById(d.a.h0.a.f.swan_app_name)).setText(eVar.M());
        ((TextView) inflate.findViewById(d.a.h0.a.f.tips)).setText(str);
        LinearLayout linearLayout = (LinearLayout) inflate.findViewById(d.a.h0.a.f.template_title_layout);
        ArrayList arrayList = new ArrayList(list);
        if (list.size() > 0) {
            for (d.a.h0.a.n0.d dVar : list) {
                linearLayout.addView(b(activity, dVar, arrayList, new a(arrayList, textView2, resources)));
            }
        }
        g.a aVar = new g.a(activity);
        aVar.f(true);
        aVar.W(inflate);
        aVar.n(new d.a.h0.a.j2.g.a());
        aVar.p(d.a.h0.a.e.aiapps_action_sheet_bg);
        aVar.k(false);
        aVar.j();
        aVar.u(false);
        g c2 = aVar.c();
        b bVar = new b(fVar, arrayList, c2);
        textView2.setOnClickListener(new View$OnClickListenerC0712c(c2, bVar));
        textView.setOnClickListener(new d(c2, bVar));
        c2.a(false);
        c2.setOnCancelListener(onCancelListener);
        Window window = c2.getWindow();
        if (window != null) {
            window.setGravity(80);
            window.setLayout(h0.r(activity), -2);
            window.setWindowAnimations(i.action_sheet_animation);
        }
        return c2;
    }

    public static View b(@NonNull Activity activity, @NonNull d.a.h0.a.n0.d dVar, List<d.a.h0.a.n0.d> list, View.OnClickListener onClickListener) {
        Resources resources = activity.getResources();
        int dimension = (int) resources.getDimension(d.a.h0.a.d.swan_app_template_title_padding);
        TextView textView = new TextView(activity);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.setMargins(0, 16, 0, 16);
        textView.setLayoutParams(layoutParams);
        textView.setTextColor(d.a.h0.m.a.b.a.b(activity, d.a.h0.a.c.swan_app_msg_dialog_title));
        textView.setText(dVar.f43399b);
        Drawable drawable = resources.getDrawable(d.a.h0.a.e.aiapps_subscribe_msg_unselected);
        Drawable drawable2 = resources.getDrawable(d.a.h0.a.e.aiapps_subscribe_msg_selected);
        textView.setCompoundDrawablesWithIntrinsicBounds(drawable2, (Drawable) null, (Drawable) null, (Drawable) null);
        textView.setCompoundDrawablePadding(dimension);
        textView.setTextSize(18.0f);
        textView.setOnClickListener(new e(textView, drawable2, drawable, dimension, list, dVar, onClickListener));
        return textView;
    }
}
