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
    public TbPageContext<?> f50880a;

    /* renamed from: b  reason: collision with root package name */
    public Activity f50881b;

    /* renamed from: c  reason: collision with root package name */
    public AlertDialog f50882c;

    /* renamed from: d  reason: collision with root package name */
    public String f50883d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f50884e;

    /* renamed from: f  reason: collision with root package name */
    public DialogInterface.OnCancelListener f50885f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f50886g;

    public a(TbPageContext<?> tbPageContext) {
        this.f50880a = null;
        this.f50881b = null;
        this.f50883d = null;
        this.f50884e = null;
        this.f50886g = true;
        this.f50880a = tbPageContext;
        if (tbPageContext == null || tbPageContext.getPageActivity() == null) {
            return;
        }
        this.f50881b = this.f50880a.getPageActivity();
    }

    public final a a(DialogInterface.OnCancelListener onCancelListener) {
        TextView textView;
        if (this.f50881b == null) {
            return this;
        }
        AlertDialog create = new AlertDialog.Builder(this.f50881b).create();
        this.f50882c = create;
        d.b.c.e.m.g.i(create, this.f50881b);
        View inflate = LayoutInflater.from(this.f50881b).inflate(R.layout.custom_loading_toast, (ViewGroup) null);
        this.f50884e = (TextView) inflate.findViewById(R.id.custom_loading_text);
        if (!StringUtils.isNull(this.f50883d) && (textView = this.f50884e) != null) {
            textView.setText(this.f50883d);
        }
        AlertDialog alertDialog = this.f50882c;
        if (alertDialog != null && alertDialog.getWindow() != null) {
            this.f50882c.getWindow().setContentView(inflate);
            if (onCancelListener != null) {
                this.f50882c.setCancelable(true);
                this.f50882c.setCanceledOnTouchOutside(true);
                this.f50882c.setOnCancelListener(onCancelListener);
            } else {
                this.f50882c.setCanceledOnTouchOutside(false);
                this.f50882c.setCancelable(false);
            }
        }
        return this;
    }

    public final a b(DialogInterface.OnCancelListener onCancelListener) {
        TextView textView;
        if (this.f50881b == null) {
            return this;
        }
        AlertDialog create = new AlertDialog.Builder(this.f50881b).create();
        this.f50882c = create;
        d.b.c.e.m.g.i(create, this.f50881b);
        View inflate = LayoutInflater.from(this.f50881b).inflate(R.layout.custom_loading_toast, (ViewGroup) null);
        this.f50884e = (TextView) inflate.findViewById(R.id.custom_loading_text);
        if (!StringUtils.isNull(this.f50883d) && (textView = this.f50884e) != null) {
            textView.setText(this.f50883d);
        }
        AlertDialog alertDialog = this.f50882c;
        if (alertDialog != null && alertDialog.getWindow() != null) {
            this.f50882c.getWindow().setContentView(inflate);
            if (onCancelListener != null) {
                this.f50882c.setOnCancelListener(onCancelListener);
            }
        }
        return this;
    }

    public boolean c() {
        AlertDialog alertDialog = this.f50882c;
        return alertDialog != null && alertDialog.isShowing();
    }

    public void d(boolean z) {
        this.f50886g = z;
    }

    public void e(DialogInterface.OnCancelListener onCancelListener) {
        this.f50885f = onCancelListener;
    }

    public void f(boolean z) {
        AlertDialog alertDialog = this.f50882c;
        if (alertDialog != null) {
            alertDialog.setCancelable(z);
        }
    }

    public void g(boolean z) {
        AlertDialog alertDialog = this.f50882c;
        if (alertDialog != null) {
            alertDialog.setCanceledOnTouchOutside(z);
        }
    }

    public void h(boolean z) {
        if (z) {
            if (this.f50886g) {
                a(this.f50885f);
                return;
            } else {
                b(this.f50885f);
                return;
            }
        }
        d.b.c.e.m.g.a(this.f50882c, this.f50881b);
    }

    public void i(int i) {
        Activity activity = this.f50881b;
        if (activity != null) {
            this.f50883d = activity.getString(i);
        }
    }

    public void j(String str) {
        this.f50883d = str;
        TextView textView = this.f50884e;
        if (textView != null) {
            textView.setText(str);
        }
    }

    public a(Activity activity) {
        this.f50880a = null;
        this.f50881b = null;
        this.f50883d = null;
        this.f50884e = null;
        this.f50886g = true;
        this.f50881b = activity;
    }
}
