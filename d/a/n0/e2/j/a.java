package d.a.n0.e2.j;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.interactionpopupwindow.IBaseDialogData;
import d.a.c.e.p.l;
import d.a.n0.e2.j.g;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes5.dex */
public abstract class a<V extends g, D extends IBaseDialogData> implements f {

    /* renamed from: a  reason: collision with root package name */
    public AlertDialog f56682a;

    /* renamed from: b  reason: collision with root package name */
    public TbPageContext f56683b;

    /* renamed from: c  reason: collision with root package name */
    public Context f56684c;

    /* renamed from: d  reason: collision with root package name */
    public DialogInterface.OnKeyListener f56685d;

    /* renamed from: e  reason: collision with root package name */
    public DialogInterface.OnCancelListener f56686e;

    /* renamed from: f  reason: collision with root package name */
    public int f56687f = -1;

    /* renamed from: g  reason: collision with root package name */
    public boolean f56688g = false;

    /* renamed from: h  reason: collision with root package name */
    public V f56689h;

    /* renamed from: d.a.n0.e2.j.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C1311a implements ViewHelper.ViewCallback {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AtomicBoolean f56690a;

        public C1311a(a aVar, AtomicBoolean atomicBoolean) {
            this.f56690a = atomicBoolean;
        }

        @Override // com.baidu.tbadk.core.util.ViewHelper.ViewCallback
        public boolean onViewFound(View view) {
            if (view instanceof EditText) {
                this.f56690a.set(true);
                return true;
            }
            return false;
        }
    }

    public a(TbPageContext tbPageContext, V v, D d2) {
        this.f56683b = tbPageContext;
        this.f56684c = tbPageContext.getPageActivity();
        this.f56689h = v;
        d(d2);
    }

    public void d(D d2) {
        V v = this.f56689h;
        if (v != null) {
            v.b(d2);
        }
    }

    @Override // d.a.n0.e2.j.f
    public void dismiss() {
        AlertDialog alertDialog = this.f56682a;
        if (alertDialog != null) {
            d.a.c.e.m.g.a(alertDialog, this.f56683b.getPageActivity());
        }
    }

    @Override // d.a.n0.e2.j.f
    public void show() {
        AlertDialog alertDialog = this.f56682a;
        if (alertDialog != null) {
            d.a.c.e.m.g.i(alertDialog, this.f56683b.getPageActivity());
            return;
        }
        if (this.f56688g) {
            this.f56682a = new AlertDialog.Builder(this.f56684c, R.style.search_dialog).create();
        } else {
            this.f56682a = new AlertDialog.Builder(this.f56684c).create();
        }
        this.f56682a.setCanceledOnTouchOutside(c());
        this.f56682a.setCancelable(b());
        this.f56682a.setOnKeyListener(this.f56685d);
        DialogInterface.OnCancelListener onCancelListener = this.f56686e;
        if (onCancelListener != null) {
            this.f56682a.setOnCancelListener(onCancelListener);
        }
        d.a.c.e.m.g.i(this.f56682a, this.f56683b.getPageActivity());
        if (this.f56682a.getWindow().getDecorView().getParent() == null) {
            return;
        }
        Window window = this.f56682a.getWindow();
        if (this.f56687f == -1) {
            this.f56687f = 17;
        }
        window.setGravity(this.f56687f);
        window.setBackgroundDrawableResource(R.drawable.transparent_bg);
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.dimAmount = 0.7f;
        attributes.width = -1;
        DisplayMetrics q = l.q(this.f56683b.getPageActivity());
        if (q != null) {
            int a2 = a();
            if (UtilHelper.getRealScreenOrientation(this.f56684c) == 2) {
                attributes.width = q.heightPixels - (a2 * 2);
            } else {
                attributes.width = q.widthPixels - (a2 * 2);
            }
        }
        attributes.height = -2;
        window.setAttributes(attributes);
        window.setContentView(this.f56689h.getViewGroup());
        AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        ViewHelper.processAllViewsIn(this.f56689h.getViewGroup(), false, new C1311a(this, atomicBoolean));
        if (atomicBoolean.get()) {
            window.clearFlags(131080);
        }
    }
}
