package d.a.j0.r.f0;

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
    public TbPageContext<?> f49653a;

    /* renamed from: b  reason: collision with root package name */
    public Activity f49654b;

    /* renamed from: c  reason: collision with root package name */
    public AlertDialog f49655c;

    /* renamed from: d  reason: collision with root package name */
    public String f49656d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f49657e;

    /* renamed from: f  reason: collision with root package name */
    public DialogInterface.OnCancelListener f49658f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f49659g;

    public a(TbPageContext<?> tbPageContext) {
        this.f49653a = null;
        this.f49654b = null;
        this.f49656d = null;
        this.f49657e = null;
        this.f49659g = true;
        this.f49653a = tbPageContext;
        if (tbPageContext == null || tbPageContext.getPageActivity() == null) {
            return;
        }
        this.f49654b = this.f49653a.getPageActivity();
    }

    public final a a(DialogInterface.OnCancelListener onCancelListener) {
        TextView textView;
        if (this.f49654b == null) {
            return this;
        }
        AlertDialog create = new AlertDialog.Builder(this.f49654b).create();
        this.f49655c = create;
        d.a.c.e.m.g.i(create, this.f49654b);
        View inflate = LayoutInflater.from(this.f49654b).inflate(R.layout.custom_loading_toast, (ViewGroup) null);
        this.f49657e = (TextView) inflate.findViewById(R.id.custom_loading_text);
        if (!StringUtils.isNull(this.f49656d) && (textView = this.f49657e) != null) {
            textView.setText(this.f49656d);
        }
        AlertDialog alertDialog = this.f49655c;
        if (alertDialog != null && alertDialog.getWindow() != null) {
            this.f49655c.getWindow().setContentView(inflate);
            if (onCancelListener != null) {
                this.f49655c.setCancelable(true);
                this.f49655c.setCanceledOnTouchOutside(true);
                this.f49655c.setOnCancelListener(onCancelListener);
            } else {
                this.f49655c.setCanceledOnTouchOutside(false);
                this.f49655c.setCancelable(false);
            }
        }
        return this;
    }

    public final a b(DialogInterface.OnCancelListener onCancelListener) {
        TextView textView;
        if (this.f49654b == null) {
            return this;
        }
        AlertDialog create = new AlertDialog.Builder(this.f49654b).create();
        this.f49655c = create;
        d.a.c.e.m.g.i(create, this.f49654b);
        View inflate = LayoutInflater.from(this.f49654b).inflate(R.layout.custom_loading_toast, (ViewGroup) null);
        this.f49657e = (TextView) inflate.findViewById(R.id.custom_loading_text);
        if (!StringUtils.isNull(this.f49656d) && (textView = this.f49657e) != null) {
            textView.setText(this.f49656d);
        }
        AlertDialog alertDialog = this.f49655c;
        if (alertDialog != null && alertDialog.getWindow() != null) {
            this.f49655c.getWindow().setContentView(inflate);
            if (onCancelListener != null) {
                this.f49655c.setOnCancelListener(onCancelListener);
            }
        }
        return this;
    }

    public boolean c() {
        AlertDialog alertDialog = this.f49655c;
        return alertDialog != null && alertDialog.isShowing();
    }

    public void d(boolean z) {
        this.f49659g = z;
    }

    public void e(DialogInterface.OnCancelListener onCancelListener) {
        this.f49658f = onCancelListener;
    }

    public void f(boolean z) {
        AlertDialog alertDialog = this.f49655c;
        if (alertDialog != null) {
            alertDialog.setCancelable(z);
        }
    }

    public void g(boolean z) {
        AlertDialog alertDialog = this.f49655c;
        if (alertDialog != null) {
            alertDialog.setCanceledOnTouchOutside(z);
        }
    }

    public void h(boolean z) {
        if (z) {
            if (this.f49659g) {
                a(this.f49658f);
                return;
            } else {
                b(this.f49658f);
                return;
            }
        }
        d.a.c.e.m.g.a(this.f49655c, this.f49654b);
    }

    public void i(int i2) {
        Activity activity = this.f49654b;
        if (activity != null) {
            this.f49656d = activity.getString(i2);
        }
    }

    public void j(String str) {
        this.f49656d = str;
        TextView textView = this.f49657e;
        if (textView != null) {
            textView.setText(str);
        }
    }

    public a(Activity activity) {
        this.f49653a = null;
        this.f49654b = null;
        this.f49656d = null;
        this.f49657e = null;
        this.f49659g = true;
        this.f49654b = activity;
    }
}
