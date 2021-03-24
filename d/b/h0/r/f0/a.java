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
    public TbPageContext<?> f50472a;

    /* renamed from: b  reason: collision with root package name */
    public Activity f50473b;

    /* renamed from: c  reason: collision with root package name */
    public AlertDialog f50474c;

    /* renamed from: d  reason: collision with root package name */
    public String f50475d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f50476e;

    /* renamed from: f  reason: collision with root package name */
    public DialogInterface.OnCancelListener f50477f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f50478g;

    public a(TbPageContext<?> tbPageContext) {
        this.f50472a = null;
        this.f50473b = null;
        this.f50475d = null;
        this.f50476e = null;
        this.f50478g = true;
        this.f50472a = tbPageContext;
        if (tbPageContext == null || tbPageContext.getPageActivity() == null) {
            return;
        }
        this.f50473b = this.f50472a.getPageActivity();
    }

    public final a a(DialogInterface.OnCancelListener onCancelListener) {
        TextView textView;
        if (this.f50473b == null) {
            return this;
        }
        AlertDialog create = new AlertDialog.Builder(this.f50473b).create();
        this.f50474c = create;
        d.b.b.e.m.g.i(create, this.f50473b);
        View inflate = LayoutInflater.from(this.f50473b).inflate(R.layout.custom_loading_toast, (ViewGroup) null);
        this.f50476e = (TextView) inflate.findViewById(R.id.custom_loading_text);
        if (!StringUtils.isNull(this.f50475d) && (textView = this.f50476e) != null) {
            textView.setText(this.f50475d);
        }
        AlertDialog alertDialog = this.f50474c;
        if (alertDialog != null && alertDialog.getWindow() != null) {
            this.f50474c.getWindow().setContentView(inflate);
            if (onCancelListener != null) {
                this.f50474c.setCancelable(true);
                this.f50474c.setCanceledOnTouchOutside(true);
                this.f50474c.setOnCancelListener(onCancelListener);
            } else {
                this.f50474c.setCanceledOnTouchOutside(false);
                this.f50474c.setCancelable(false);
            }
        }
        return this;
    }

    public final a b(DialogInterface.OnCancelListener onCancelListener) {
        TextView textView;
        if (this.f50473b == null) {
            return this;
        }
        AlertDialog create = new AlertDialog.Builder(this.f50473b).create();
        this.f50474c = create;
        d.b.b.e.m.g.i(create, this.f50473b);
        View inflate = LayoutInflater.from(this.f50473b).inflate(R.layout.custom_loading_toast, (ViewGroup) null);
        this.f50476e = (TextView) inflate.findViewById(R.id.custom_loading_text);
        if (!StringUtils.isNull(this.f50475d) && (textView = this.f50476e) != null) {
            textView.setText(this.f50475d);
        }
        AlertDialog alertDialog = this.f50474c;
        if (alertDialog != null && alertDialog.getWindow() != null) {
            this.f50474c.getWindow().setContentView(inflate);
            if (onCancelListener != null) {
                this.f50474c.setOnCancelListener(onCancelListener);
            }
        }
        return this;
    }

    public boolean c() {
        AlertDialog alertDialog = this.f50474c;
        return alertDialog != null && alertDialog.isShowing();
    }

    public void d(boolean z) {
        this.f50478g = z;
    }

    public void e(DialogInterface.OnCancelListener onCancelListener) {
        this.f50477f = onCancelListener;
    }

    public void f(boolean z) {
        AlertDialog alertDialog = this.f50474c;
        if (alertDialog != null) {
            alertDialog.setCancelable(z);
        }
    }

    public void g(boolean z) {
        AlertDialog alertDialog = this.f50474c;
        if (alertDialog != null) {
            alertDialog.setCanceledOnTouchOutside(z);
        }
    }

    public void h(boolean z) {
        if (z) {
            if (this.f50478g) {
                a(this.f50477f);
                return;
            } else {
                b(this.f50477f);
                return;
            }
        }
        d.b.b.e.m.g.a(this.f50474c, this.f50473b);
    }

    public void i(int i) {
        Activity activity = this.f50473b;
        if (activity != null) {
            this.f50475d = activity.getString(i);
        }
    }

    public void j(String str) {
        this.f50475d = str;
        TextView textView = this.f50476e;
        if (textView != null) {
            textView.setText(str);
        }
    }

    public a(Activity activity) {
        this.f50472a = null;
        this.f50473b = null;
        this.f50475d = null;
        this.f50476e = null;
        this.f50478g = true;
        this.f50473b = activity;
    }
}
