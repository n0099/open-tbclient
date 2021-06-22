package d.a.n0.r.f0;

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
    public TbPageContext<?> f53479a;

    /* renamed from: b  reason: collision with root package name */
    public Activity f53480b;

    /* renamed from: c  reason: collision with root package name */
    public AlertDialog f53481c;

    /* renamed from: d  reason: collision with root package name */
    public String f53482d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f53483e;

    /* renamed from: f  reason: collision with root package name */
    public DialogInterface.OnCancelListener f53484f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f53485g;

    public a(TbPageContext<?> tbPageContext) {
        this.f53479a = null;
        this.f53480b = null;
        this.f53482d = null;
        this.f53483e = null;
        this.f53485g = true;
        this.f53479a = tbPageContext;
        if (tbPageContext == null || tbPageContext.getPageActivity() == null) {
            return;
        }
        this.f53480b = this.f53479a.getPageActivity();
    }

    public final a a(DialogInterface.OnCancelListener onCancelListener) {
        TextView textView;
        if (this.f53480b == null) {
            return this;
        }
        AlertDialog create = new AlertDialog.Builder(this.f53480b).create();
        this.f53481c = create;
        d.a.c.e.m.g.i(create, this.f53480b);
        View inflate = LayoutInflater.from(this.f53480b).inflate(R.layout.custom_loading_toast, (ViewGroup) null);
        this.f53483e = (TextView) inflate.findViewById(R.id.custom_loading_text);
        if (!StringUtils.isNull(this.f53482d) && (textView = this.f53483e) != null) {
            textView.setText(this.f53482d);
        }
        AlertDialog alertDialog = this.f53481c;
        if (alertDialog != null && alertDialog.getWindow() != null) {
            this.f53481c.getWindow().setContentView(inflate);
            if (onCancelListener != null) {
                this.f53481c.setCancelable(true);
                this.f53481c.setCanceledOnTouchOutside(true);
                this.f53481c.setOnCancelListener(onCancelListener);
            } else {
                this.f53481c.setCanceledOnTouchOutside(false);
                this.f53481c.setCancelable(false);
            }
        }
        return this;
    }

    public final a b(DialogInterface.OnCancelListener onCancelListener) {
        TextView textView;
        if (this.f53480b == null) {
            return this;
        }
        AlertDialog create = new AlertDialog.Builder(this.f53480b).create();
        this.f53481c = create;
        d.a.c.e.m.g.i(create, this.f53480b);
        View inflate = LayoutInflater.from(this.f53480b).inflate(R.layout.custom_loading_toast, (ViewGroup) null);
        this.f53483e = (TextView) inflate.findViewById(R.id.custom_loading_text);
        if (!StringUtils.isNull(this.f53482d) && (textView = this.f53483e) != null) {
            textView.setText(this.f53482d);
        }
        AlertDialog alertDialog = this.f53481c;
        if (alertDialog != null && alertDialog.getWindow() != null) {
            this.f53481c.getWindow().setContentView(inflate);
            if (onCancelListener != null) {
                this.f53481c.setOnCancelListener(onCancelListener);
            }
        }
        return this;
    }

    public boolean c() {
        AlertDialog alertDialog = this.f53481c;
        return alertDialog != null && alertDialog.isShowing();
    }

    public void d(boolean z) {
        this.f53485g = z;
    }

    public void e(DialogInterface.OnCancelListener onCancelListener) {
        this.f53484f = onCancelListener;
    }

    public void f(boolean z) {
        AlertDialog alertDialog = this.f53481c;
        if (alertDialog != null) {
            alertDialog.setCancelable(z);
        }
    }

    public void g(boolean z) {
        AlertDialog alertDialog = this.f53481c;
        if (alertDialog != null) {
            alertDialog.setCanceledOnTouchOutside(z);
        }
    }

    public void h(boolean z) {
        if (z) {
            if (this.f53485g) {
                a(this.f53484f);
                return;
            } else {
                b(this.f53484f);
                return;
            }
        }
        d.a.c.e.m.g.a(this.f53481c, this.f53480b);
    }

    public void i(int i2) {
        Activity activity = this.f53480b;
        if (activity != null) {
            this.f53482d = activity.getString(i2);
        }
    }

    public void j(String str) {
        this.f53482d = str;
        TextView textView = this.f53483e;
        if (textView != null) {
            textView.setText(str);
        }
    }

    public a(Activity activity) {
        this.f53479a = null;
        this.f53480b = null;
        this.f53482d = null;
        this.f53483e = null;
        this.f53485g = true;
        this.f53480b = activity;
    }
}
