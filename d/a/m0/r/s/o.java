package d.a.m0.r.s;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.StringRes;
import androidx.appcompat.app.AlertDialog;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.dialog.TBAlertConfig;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.R;
/* loaded from: classes3.dex */
public class o {

    /* renamed from: a  reason: collision with root package name */
    public final AlertDialog.Builder f50298a;

    /* renamed from: b  reason: collision with root package name */
    public final Activity f50299b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f50300c;

    /* renamed from: d  reason: collision with root package name */
    public AlertDialog f50301d;

    /* renamed from: e  reason: collision with root package name */
    public View f50302e;

    /* renamed from: f  reason: collision with root package name */
    public String f50303f;

    /* renamed from: g  reason: collision with root package name */
    public String f50304g;

    /* renamed from: h  reason: collision with root package name */
    public int f50305h = 17;

    /* renamed from: i  reason: collision with root package name */
    public boolean f50306i;
    public View j;
    public TBAlertConfig.b k;
    public boolean l;
    public boolean m;
    public View.OnClickListener n;
    public View.OnClickListener o;

    /* loaded from: classes3.dex */
    public class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ TextView f50307e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ View f50308f;

        public a(o oVar, TextView textView, View view) {
            this.f50307e = textView;
            this.f50308f = view;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (UtilHelper.getDimenPixelSize(R.dimen.tbds868) == this.f50307e.getHeight()) {
                this.f50308f.setVisibility(0);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (o.this.f50301d != null) {
                o.this.f50301d.dismiss();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (o.this.f50301d != null) {
                o.this.f50301d.dismiss();
            }
            if (o.this.o != null) {
                o.this.o.onClick(view);
            }
        }
    }

    public o(@NonNull Activity activity) {
        this.f50299b = activity;
        this.f50298a = new AlertDialog.Builder(activity);
    }

    public static void d(@NonNull Dialog dialog) {
        Window window = dialog.getWindow();
        if (window == null) {
            return;
        }
        window.setBackgroundDrawableResource(17170445);
    }

    public static void e(@NonNull Dialog dialog) {
        Window window = dialog.getWindow();
        if (window == null) {
            return;
        }
        Context context = dialog.getContext();
        int i2 = context.getResources().getDisplayMetrics().widthPixels;
        int i3 = (i2 * 837) / 1076;
        int g2 = d.a.c.e.p.l.g(context, R.dimen.tbds756);
        if (i3 < g2) {
            i3 = Math.min(i2, g2);
        }
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.width = i3;
        window.getDecorView().setPadding(0, 0, 0, 0);
        window.setAttributes(attributes);
    }

    public AlertDialog c() {
        if (!this.f50300c) {
            this.f50300c = true;
            m();
            this.f50301d = this.f50298a.create();
        }
        return this.f50301d;
    }

    public o f(boolean z) {
        this.f50298a.setCancelable(z);
        return this;
    }

    public o g(View view) {
        this.j = view;
        return this;
    }

    public o h(View view) {
        this.f50302e = view;
        return this;
    }

    public o i(@StringRes int i2) {
        this.f50304g = TbadkCoreApplication.getInst().getResources().getString(i2);
        return this;
    }

    public o j(DialogInterface.OnDismissListener onDismissListener) {
        this.f50298a.setOnDismissListener(onDismissListener);
        return this;
    }

    public o k(TBAlertConfig.a... aVarArr) {
        int length = aVarArr.length;
        if (length == 1) {
            this.k = TBAlertConfig.a(aVarArr[0]);
        } else if (length == 2) {
            this.k = TBAlertConfig.c(aVarArr[0], aVarArr[1]);
        } else if (length == 3) {
            this.k = TBAlertConfig.b(aVarArr[0], aVarArr[1], aVarArr[2]);
        }
        return this;
    }

    public o l(@StringRes int i2) {
        this.f50303f = TbadkCoreApplication.getInst().getResources().getString(i2);
        return this;
    }

    public final void m() {
        LinearLayout linearLayout = new LinearLayout(this.f50299b);
        linearLayout.setOrientation(1);
        linearLayout.setGravity(17);
        linearLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        View view = this.f50302e;
        if (view != null) {
            if (view.getLayoutParams() == null) {
                linearLayout.addView(this.f50302e, new ViewGroup.LayoutParams(-1, -2));
            } else {
                linearLayout.addView(this.f50302e);
            }
        }
        LinearLayout linearLayout2 = new LinearLayout(this.f50299b);
        linearLayout2.setOrientation(1);
        linearLayout2.setGravity(17);
        linearLayout2.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        d.a.m0.r.u.c d2 = d.a.m0.r.u.c.d(linearLayout2);
        d2.l(this.f50302e == null ? 0 : 2);
        d2.m(R.string.J_X06);
        d2.f(R.color.CAM_X0205);
        TextView k = p.k(this.f50299b);
        k.setText(this.f50303f);
        k.setPadding(UtilHelper.getDimenPixelSize(R.dimen.M_W_X013), UtilHelper.getDimenPixelSize(R.dimen.M_H_X009), UtilHelper.getDimenPixelSize(R.dimen.M_W_X013), UtilHelper.getDimenPixelSize(R.dimen.M_H_X007));
        linearLayout2.addView(k);
        if (!TextUtils.isEmpty(this.f50304g)) {
            RelativeLayout relativeLayout = new RelativeLayout(this.f50299b);
            relativeLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
            TextView b2 = p.b(this.f50299b, this.f50306i);
            b2.setText(this.f50304g);
            b2.setGravity(this.f50305h);
            b2.setId(R.id.desc);
            b2.setPadding(UtilHelper.getDimenPixelSize(R.dimen.M_W_X013), 0, UtilHelper.getDimenPixelSize(R.dimen.M_W_X013), 0);
            b2.setMaxHeight(UtilHelper.getDimenPixelSize(R.dimen.tbds868));
            b2.setMovementMethod(ScrollingMovementMethod.getInstance());
            relativeLayout.addView(b2, new ViewGroup.LayoutParams(-1, -2));
            View view2 = new View(this.f50299b);
            view2.setVisibility(4);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, UtilHelper.getDimenPixelSize(R.dimen.tbds104));
            layoutParams.addRule(8, R.id.desc);
            SkinManager.setBackgroundColorToTransparent(view2, R.color.CAM_X0205, GradientDrawable.Orientation.BOTTOM_TOP);
            relativeLayout.addView(view2, layoutParams);
            linearLayout2.addView(relativeLayout);
            b2.post(new a(this, b2, view2));
        }
        View view3 = this.j;
        if (view3 != null) {
            linearLayout2.addView(view3, new ViewGroup.LayoutParams(-1, -2));
        }
        if (this.k != null) {
            if (this.m) {
                this.n = new b();
            }
            linearLayout2.addView(p.i(this.f50299b, this.k, this.n));
        }
        linearLayout.addView(linearLayout2, new ViewGroup.LayoutParams(-1, -2));
        if (this.l) {
            ImageView imageView = new ImageView(this.f50299b);
            imageView.setImageResource(R.drawable.icon_mask_pop_close);
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(d.a.c.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds104), d.a.c.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds105));
            layoutParams2.setMargins(0, d.a.c.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.M_H_X010), 0, 0);
            imageView.setOnClickListener(new c());
            linearLayout.addView(imageView, layoutParams2);
        }
        this.f50298a.setView(linearLayout);
    }

    public AlertDialog n() {
        AlertDialog c2 = c();
        o(c2);
        return c2;
    }

    public AlertDialog o(AlertDialog alertDialog) {
        alertDialog.show();
        d(alertDialog);
        e(alertDialog);
        return alertDialog;
    }
}
