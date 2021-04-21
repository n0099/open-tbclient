package d.b.i0.r.f0;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.R;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext<?> f51216a;

    /* renamed from: b  reason: collision with root package name */
    public Activity f51217b;

    /* renamed from: c  reason: collision with root package name */
    public AlertDialog f51218c;

    /* renamed from: d  reason: collision with root package name */
    public String f51219d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f51220e;

    /* renamed from: f  reason: collision with root package name */
    public DialogInterface.OnCancelListener f51221f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f51222g;

    public a(TbPageContext<?> tbPageContext) {
        this.f51216a = null;
        this.f51217b = null;
        this.f51219d = null;
        this.f51220e = null;
        this.f51222g = true;
        this.f51216a = tbPageContext;
        if (tbPageContext == null || tbPageContext.getPageActivity() == null) {
            return;
        }
        this.f51217b = this.f51216a.getPageActivity();
    }

    public final a a(DialogInterface.OnCancelListener onCancelListener) {
        TextView textView;
        if (this.f51217b == null) {
            return this;
        }
        AlertDialog create = new AlertDialog.Builder(this.f51217b).create();
        this.f51218c = create;
        d.b.c.e.m.g.i(create, this.f51217b);
        View inflate = LayoutInflater.from(this.f51217b).inflate(R.layout.custom_loading_toast, (ViewGroup) null);
        this.f51220e = (TextView) inflate.findViewById(R.id.custom_loading_text);
        if (!StringUtils.isNull(this.f51219d) && (textView = this.f51220e) != null) {
            textView.setText(this.f51219d);
        }
        AlertDialog alertDialog = this.f51218c;
        if (alertDialog != null && alertDialog.getWindow() != null) {
            this.f51218c.getWindow().setContentView(inflate);
            if (onCancelListener != null) {
                this.f51218c.setCancelable(true);
                this.f51218c.setCanceledOnTouchOutside(true);
                this.f51218c.setOnCancelListener(onCancelListener);
            } else {
                this.f51218c.setCanceledOnTouchOutside(false);
                this.f51218c.setCancelable(false);
            }
        }
        return this;
    }

    public final a b(DialogInterface.OnCancelListener onCancelListener) {
        TextView textView;
        if (this.f51217b == null) {
            return this;
        }
        AlertDialog create = new AlertDialog.Builder(this.f51217b).create();
        this.f51218c = create;
        d.b.c.e.m.g.i(create, this.f51217b);
        View inflate = LayoutInflater.from(this.f51217b).inflate(R.layout.custom_loading_toast, (ViewGroup) null);
        this.f51220e = (TextView) inflate.findViewById(R.id.custom_loading_text);
        if (!StringUtils.isNull(this.f51219d) && (textView = this.f51220e) != null) {
            textView.setText(this.f51219d);
        }
        AlertDialog alertDialog = this.f51218c;
        if (alertDialog != null && alertDialog.getWindow() != null) {
            this.f51218c.getWindow().setContentView(inflate);
            if (onCancelListener != null) {
                this.f51218c.setOnCancelListener(onCancelListener);
            }
        }
        return this;
    }

    public boolean c() {
        AlertDialog alertDialog = this.f51218c;
        return alertDialog != null && alertDialog.isShowing();
    }

    public void d(boolean z) {
        this.f51222g = z;
    }

    public void e(DialogInterface.OnCancelListener onCancelListener) {
        this.f51221f = onCancelListener;
    }

    public void f(boolean z) {
        AlertDialog alertDialog = this.f51218c;
        if (alertDialog != null) {
            alertDialog.setCancelable(z);
        }
    }

    public void g(boolean z) {
        AlertDialog alertDialog = this.f51218c;
        if (alertDialog != null) {
            alertDialog.setCanceledOnTouchOutside(z);
        }
    }

    public void h(boolean z) {
        if (z) {
            if (this.f51222g) {
                a(this.f51221f);
                return;
            } else {
                b(this.f51221f);
                return;
            }
        }
        d.b.c.e.m.g.a(this.f51218c, this.f51217b);
    }

    public void i(int i) {
        Activity activity = this.f51217b;
        if (activity != null) {
            this.f51219d = activity.getString(i);
        }
    }

    public void j(String str) {
        this.f51219d = str;
        TextView textView = this.f51220e;
        if (textView != null) {
            textView.setText(str);
        }
    }

    public a(Activity activity) {
        this.f51216a = null;
        this.f51217b = null;
        this.f51219d = null;
        this.f51220e = null;
        this.f51222g = true;
        this.f51217b = activity;
    }
}
