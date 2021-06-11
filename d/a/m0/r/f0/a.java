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
    public TbPageContext<?> f53372a;

    /* renamed from: b  reason: collision with root package name */
    public Activity f53373b;

    /* renamed from: c  reason: collision with root package name */
    public AlertDialog f53374c;

    /* renamed from: d  reason: collision with root package name */
    public String f53375d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f53376e;

    /* renamed from: f  reason: collision with root package name */
    public DialogInterface.OnCancelListener f53377f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f53378g;

    public a(TbPageContext<?> tbPageContext) {
        this.f53372a = null;
        this.f53373b = null;
        this.f53375d = null;
        this.f53376e = null;
        this.f53378g = true;
        this.f53372a = tbPageContext;
        if (tbPageContext == null || tbPageContext.getPageActivity() == null) {
            return;
        }
        this.f53373b = this.f53372a.getPageActivity();
    }

    public final a a(DialogInterface.OnCancelListener onCancelListener) {
        TextView textView;
        if (this.f53373b == null) {
            return this;
        }
        AlertDialog create = new AlertDialog.Builder(this.f53373b).create();
        this.f53374c = create;
        d.a.c.e.m.g.i(create, this.f53373b);
        View inflate = LayoutInflater.from(this.f53373b).inflate(R.layout.custom_loading_toast, (ViewGroup) null);
        this.f53376e = (TextView) inflate.findViewById(R.id.custom_loading_text);
        if (!StringUtils.isNull(this.f53375d) && (textView = this.f53376e) != null) {
            textView.setText(this.f53375d);
        }
        AlertDialog alertDialog = this.f53374c;
        if (alertDialog != null && alertDialog.getWindow() != null) {
            this.f53374c.getWindow().setContentView(inflate);
            if (onCancelListener != null) {
                this.f53374c.setCancelable(true);
                this.f53374c.setCanceledOnTouchOutside(true);
                this.f53374c.setOnCancelListener(onCancelListener);
            } else {
                this.f53374c.setCanceledOnTouchOutside(false);
                this.f53374c.setCancelable(false);
            }
        }
        return this;
    }

    public final a b(DialogInterface.OnCancelListener onCancelListener) {
        TextView textView;
        if (this.f53373b == null) {
            return this;
        }
        AlertDialog create = new AlertDialog.Builder(this.f53373b).create();
        this.f53374c = create;
        d.a.c.e.m.g.i(create, this.f53373b);
        View inflate = LayoutInflater.from(this.f53373b).inflate(R.layout.custom_loading_toast, (ViewGroup) null);
        this.f53376e = (TextView) inflate.findViewById(R.id.custom_loading_text);
        if (!StringUtils.isNull(this.f53375d) && (textView = this.f53376e) != null) {
            textView.setText(this.f53375d);
        }
        AlertDialog alertDialog = this.f53374c;
        if (alertDialog != null && alertDialog.getWindow() != null) {
            this.f53374c.getWindow().setContentView(inflate);
            if (onCancelListener != null) {
                this.f53374c.setOnCancelListener(onCancelListener);
            }
        }
        return this;
    }

    public boolean c() {
        AlertDialog alertDialog = this.f53374c;
        return alertDialog != null && alertDialog.isShowing();
    }

    public void d(boolean z) {
        this.f53378g = z;
    }

    public void e(DialogInterface.OnCancelListener onCancelListener) {
        this.f53377f = onCancelListener;
    }

    public void f(boolean z) {
        AlertDialog alertDialog = this.f53374c;
        if (alertDialog != null) {
            alertDialog.setCancelable(z);
        }
    }

    public void g(boolean z) {
        AlertDialog alertDialog = this.f53374c;
        if (alertDialog != null) {
            alertDialog.setCanceledOnTouchOutside(z);
        }
    }

    public void h(boolean z) {
        if (z) {
            if (this.f53378g) {
                a(this.f53377f);
                return;
            } else {
                b(this.f53377f);
                return;
            }
        }
        d.a.c.e.m.g.a(this.f53374c, this.f53373b);
    }

    public void i(int i2) {
        Activity activity = this.f53373b;
        if (activity != null) {
            this.f53375d = activity.getString(i2);
        }
    }

    public void j(String str) {
        this.f53375d = str;
        TextView textView = this.f53376e;
        if (textView != null) {
            textView.setText(str);
        }
    }

    public a(Activity activity) {
        this.f53372a = null;
        this.f53373b = null;
        this.f53375d = null;
        this.f53376e = null;
        this.f53378g = true;
        this.f53373b = activity;
    }
}
