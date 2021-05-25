package d.a.m0.r.f0;

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
    public TbPageContext<?> f49697a;

    /* renamed from: b  reason: collision with root package name */
    public Activity f49698b;

    /* renamed from: c  reason: collision with root package name */
    public AlertDialog f49699c;

    /* renamed from: d  reason: collision with root package name */
    public String f49700d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f49701e;

    /* renamed from: f  reason: collision with root package name */
    public DialogInterface.OnCancelListener f49702f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f49703g;

    public a(TbPageContext<?> tbPageContext) {
        this.f49697a = null;
        this.f49698b = null;
        this.f49700d = null;
        this.f49701e = null;
        this.f49703g = true;
        this.f49697a = tbPageContext;
        if (tbPageContext == null || tbPageContext.getPageActivity() == null) {
            return;
        }
        this.f49698b = this.f49697a.getPageActivity();
    }

    public final a a(DialogInterface.OnCancelListener onCancelListener) {
        TextView textView;
        if (this.f49698b == null) {
            return this;
        }
        AlertDialog create = new AlertDialog.Builder(this.f49698b).create();
        this.f49699c = create;
        d.a.c.e.m.g.i(create, this.f49698b);
        View inflate = LayoutInflater.from(this.f49698b).inflate(R.layout.custom_loading_toast, (ViewGroup) null);
        this.f49701e = (TextView) inflate.findViewById(R.id.custom_loading_text);
        if (!StringUtils.isNull(this.f49700d) && (textView = this.f49701e) != null) {
            textView.setText(this.f49700d);
        }
        AlertDialog alertDialog = this.f49699c;
        if (alertDialog != null && alertDialog.getWindow() != null) {
            this.f49699c.getWindow().setContentView(inflate);
            if (onCancelListener != null) {
                this.f49699c.setCancelable(true);
                this.f49699c.setCanceledOnTouchOutside(true);
                this.f49699c.setOnCancelListener(onCancelListener);
            } else {
                this.f49699c.setCanceledOnTouchOutside(false);
                this.f49699c.setCancelable(false);
            }
        }
        return this;
    }

    public final a b(DialogInterface.OnCancelListener onCancelListener) {
        TextView textView;
        if (this.f49698b == null) {
            return this;
        }
        AlertDialog create = new AlertDialog.Builder(this.f49698b).create();
        this.f49699c = create;
        d.a.c.e.m.g.i(create, this.f49698b);
        View inflate = LayoutInflater.from(this.f49698b).inflate(R.layout.custom_loading_toast, (ViewGroup) null);
        this.f49701e = (TextView) inflate.findViewById(R.id.custom_loading_text);
        if (!StringUtils.isNull(this.f49700d) && (textView = this.f49701e) != null) {
            textView.setText(this.f49700d);
        }
        AlertDialog alertDialog = this.f49699c;
        if (alertDialog != null && alertDialog.getWindow() != null) {
            this.f49699c.getWindow().setContentView(inflate);
            if (onCancelListener != null) {
                this.f49699c.setOnCancelListener(onCancelListener);
            }
        }
        return this;
    }

    public boolean c() {
        AlertDialog alertDialog = this.f49699c;
        return alertDialog != null && alertDialog.isShowing();
    }

    public void d(boolean z) {
        this.f49703g = z;
    }

    public void e(DialogInterface.OnCancelListener onCancelListener) {
        this.f49702f = onCancelListener;
    }

    public void f(boolean z) {
        AlertDialog alertDialog = this.f49699c;
        if (alertDialog != null) {
            alertDialog.setCancelable(z);
        }
    }

    public void g(boolean z) {
        AlertDialog alertDialog = this.f49699c;
        if (alertDialog != null) {
            alertDialog.setCanceledOnTouchOutside(z);
        }
    }

    public void h(boolean z) {
        if (z) {
            if (this.f49703g) {
                a(this.f49702f);
                return;
            } else {
                b(this.f49702f);
                return;
            }
        }
        d.a.c.e.m.g.a(this.f49699c, this.f49698b);
    }

    public void i(int i2) {
        Activity activity = this.f49698b;
        if (activity != null) {
            this.f49700d = activity.getString(i2);
        }
    }

    public void j(String str) {
        this.f49700d = str;
        TextView textView = this.f49701e;
        if (textView != null) {
            textView.setText(str);
        }
    }

    public a(Activity activity) {
        this.f49697a = null;
        this.f49698b = null;
        this.f49700d = null;
        this.f49701e = null;
        this.f49703g = true;
        this.f49698b = activity;
    }
}
