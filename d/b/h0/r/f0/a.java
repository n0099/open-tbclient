package d.b.h0.r.f0;

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
    public TbPageContext<?> f50473a;

    /* renamed from: b  reason: collision with root package name */
    public Activity f50474b;

    /* renamed from: c  reason: collision with root package name */
    public AlertDialog f50475c;

    /* renamed from: d  reason: collision with root package name */
    public String f50476d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f50477e;

    /* renamed from: f  reason: collision with root package name */
    public DialogInterface.OnCancelListener f50478f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f50479g;

    public a(TbPageContext<?> tbPageContext) {
        this.f50473a = null;
        this.f50474b = null;
        this.f50476d = null;
        this.f50477e = null;
        this.f50479g = true;
        this.f50473a = tbPageContext;
        if (tbPageContext == null || tbPageContext.getPageActivity() == null) {
            return;
        }
        this.f50474b = this.f50473a.getPageActivity();
    }

    public final a a(DialogInterface.OnCancelListener onCancelListener) {
        TextView textView;
        if (this.f50474b == null) {
            return this;
        }
        AlertDialog create = new AlertDialog.Builder(this.f50474b).create();
        this.f50475c = create;
        d.b.b.e.m.g.i(create, this.f50474b);
        View inflate = LayoutInflater.from(this.f50474b).inflate(R.layout.custom_loading_toast, (ViewGroup) null);
        this.f50477e = (TextView) inflate.findViewById(R.id.custom_loading_text);
        if (!StringUtils.isNull(this.f50476d) && (textView = this.f50477e) != null) {
            textView.setText(this.f50476d);
        }
        AlertDialog alertDialog = this.f50475c;
        if (alertDialog != null && alertDialog.getWindow() != null) {
            this.f50475c.getWindow().setContentView(inflate);
            if (onCancelListener != null) {
                this.f50475c.setCancelable(true);
                this.f50475c.setCanceledOnTouchOutside(true);
                this.f50475c.setOnCancelListener(onCancelListener);
            } else {
                this.f50475c.setCanceledOnTouchOutside(false);
                this.f50475c.setCancelable(false);
            }
        }
        return this;
    }

    public final a b(DialogInterface.OnCancelListener onCancelListener) {
        TextView textView;
        if (this.f50474b == null) {
            return this;
        }
        AlertDialog create = new AlertDialog.Builder(this.f50474b).create();
        this.f50475c = create;
        d.b.b.e.m.g.i(create, this.f50474b);
        View inflate = LayoutInflater.from(this.f50474b).inflate(R.layout.custom_loading_toast, (ViewGroup) null);
        this.f50477e = (TextView) inflate.findViewById(R.id.custom_loading_text);
        if (!StringUtils.isNull(this.f50476d) && (textView = this.f50477e) != null) {
            textView.setText(this.f50476d);
        }
        AlertDialog alertDialog = this.f50475c;
        if (alertDialog != null && alertDialog.getWindow() != null) {
            this.f50475c.getWindow().setContentView(inflate);
            if (onCancelListener != null) {
                this.f50475c.setOnCancelListener(onCancelListener);
            }
        }
        return this;
    }

    public boolean c() {
        AlertDialog alertDialog = this.f50475c;
        return alertDialog != null && alertDialog.isShowing();
    }

    public void d(boolean z) {
        this.f50479g = z;
    }

    public void e(DialogInterface.OnCancelListener onCancelListener) {
        this.f50478f = onCancelListener;
    }

    public void f(boolean z) {
        AlertDialog alertDialog = this.f50475c;
        if (alertDialog != null) {
            alertDialog.setCancelable(z);
        }
    }

    public void g(boolean z) {
        AlertDialog alertDialog = this.f50475c;
        if (alertDialog != null) {
            alertDialog.setCanceledOnTouchOutside(z);
        }
    }

    public void h(boolean z) {
        if (z) {
            if (this.f50479g) {
                a(this.f50478f);
                return;
            } else {
                b(this.f50478f);
                return;
            }
        }
        d.b.b.e.m.g.a(this.f50475c, this.f50474b);
    }

    public void i(int i) {
        Activity activity = this.f50474b;
        if (activity != null) {
            this.f50476d = activity.getString(i);
        }
    }

    public void j(String str) {
        this.f50476d = str;
        TextView textView = this.f50477e;
        if (textView != null) {
            textView.setText(str);
        }
    }

    public a(Activity activity) {
        this.f50473a = null;
        this.f50474b = null;
        this.f50476d = null;
        this.f50477e = null;
        this.f50479g = true;
        this.f50474b = activity;
    }
}
