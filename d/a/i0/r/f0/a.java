package d.a.i0.r.f0;

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
    public TbPageContext<?> f48824a;

    /* renamed from: b  reason: collision with root package name */
    public Activity f48825b;

    /* renamed from: c  reason: collision with root package name */
    public AlertDialog f48826c;

    /* renamed from: d  reason: collision with root package name */
    public String f48827d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f48828e;

    /* renamed from: f  reason: collision with root package name */
    public DialogInterface.OnCancelListener f48829f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f48830g;

    public a(TbPageContext<?> tbPageContext) {
        this.f48824a = null;
        this.f48825b = null;
        this.f48827d = null;
        this.f48828e = null;
        this.f48830g = true;
        this.f48824a = tbPageContext;
        if (tbPageContext == null || tbPageContext.getPageActivity() == null) {
            return;
        }
        this.f48825b = this.f48824a.getPageActivity();
    }

    public final a a(DialogInterface.OnCancelListener onCancelListener) {
        TextView textView;
        if (this.f48825b == null) {
            return this;
        }
        AlertDialog create = new AlertDialog.Builder(this.f48825b).create();
        this.f48826c = create;
        d.a.c.e.m.g.i(create, this.f48825b);
        View inflate = LayoutInflater.from(this.f48825b).inflate(R.layout.custom_loading_toast, (ViewGroup) null);
        this.f48828e = (TextView) inflate.findViewById(R.id.custom_loading_text);
        if (!StringUtils.isNull(this.f48827d) && (textView = this.f48828e) != null) {
            textView.setText(this.f48827d);
        }
        AlertDialog alertDialog = this.f48826c;
        if (alertDialog != null && alertDialog.getWindow() != null) {
            this.f48826c.getWindow().setContentView(inflate);
            if (onCancelListener != null) {
                this.f48826c.setCancelable(true);
                this.f48826c.setCanceledOnTouchOutside(true);
                this.f48826c.setOnCancelListener(onCancelListener);
            } else {
                this.f48826c.setCanceledOnTouchOutside(false);
                this.f48826c.setCancelable(false);
            }
        }
        return this;
    }

    public final a b(DialogInterface.OnCancelListener onCancelListener) {
        TextView textView;
        if (this.f48825b == null) {
            return this;
        }
        AlertDialog create = new AlertDialog.Builder(this.f48825b).create();
        this.f48826c = create;
        d.a.c.e.m.g.i(create, this.f48825b);
        View inflate = LayoutInflater.from(this.f48825b).inflate(R.layout.custom_loading_toast, (ViewGroup) null);
        this.f48828e = (TextView) inflate.findViewById(R.id.custom_loading_text);
        if (!StringUtils.isNull(this.f48827d) && (textView = this.f48828e) != null) {
            textView.setText(this.f48827d);
        }
        AlertDialog alertDialog = this.f48826c;
        if (alertDialog != null && alertDialog.getWindow() != null) {
            this.f48826c.getWindow().setContentView(inflate);
            if (onCancelListener != null) {
                this.f48826c.setOnCancelListener(onCancelListener);
            }
        }
        return this;
    }

    public boolean c() {
        AlertDialog alertDialog = this.f48826c;
        return alertDialog != null && alertDialog.isShowing();
    }

    public void d(boolean z) {
        this.f48830g = z;
    }

    public void e(DialogInterface.OnCancelListener onCancelListener) {
        this.f48829f = onCancelListener;
    }

    public void f(boolean z) {
        AlertDialog alertDialog = this.f48826c;
        if (alertDialog != null) {
            alertDialog.setCancelable(z);
        }
    }

    public void g(boolean z) {
        AlertDialog alertDialog = this.f48826c;
        if (alertDialog != null) {
            alertDialog.setCanceledOnTouchOutside(z);
        }
    }

    public void h(boolean z) {
        if (z) {
            if (this.f48830g) {
                a(this.f48829f);
                return;
            } else {
                b(this.f48829f);
                return;
            }
        }
        d.a.c.e.m.g.a(this.f48826c, this.f48825b);
    }

    public void i(int i2) {
        Activity activity = this.f48825b;
        if (activity != null) {
            this.f48827d = activity.getString(i2);
        }
    }

    public void j(String str) {
        this.f48827d = str;
        TextView textView = this.f48828e;
        if (textView != null) {
            textView.setText(str);
        }
    }

    public a(Activity activity) {
        this.f48824a = null;
        this.f48825b = null;
        this.f48827d = null;
        this.f48828e = null;
        this.f48830g = true;
        this.f48825b = activity;
    }
}
