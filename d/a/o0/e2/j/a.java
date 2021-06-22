package d.a.o0.e2.j;

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
import d.a.o0.e2.j.g;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes5.dex */
public abstract class a<V extends g, D extends IBaseDialogData> implements f {

    /* renamed from: a  reason: collision with root package name */
    public AlertDialog f56807a;

    /* renamed from: b  reason: collision with root package name */
    public TbPageContext f56808b;

    /* renamed from: c  reason: collision with root package name */
    public Context f56809c;

    /* renamed from: d  reason: collision with root package name */
    public DialogInterface.OnKeyListener f56810d;

    /* renamed from: e  reason: collision with root package name */
    public DialogInterface.OnCancelListener f56811e;

    /* renamed from: f  reason: collision with root package name */
    public int f56812f = -1;

    /* renamed from: g  reason: collision with root package name */
    public boolean f56813g = false;

    /* renamed from: h  reason: collision with root package name */
    public V f56814h;

    /* renamed from: d.a.o0.e2.j.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C1315a implements ViewHelper.ViewCallback {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AtomicBoolean f56815a;

        public C1315a(a aVar, AtomicBoolean atomicBoolean) {
            this.f56815a = atomicBoolean;
        }

        @Override // com.baidu.tbadk.core.util.ViewHelper.ViewCallback
        public boolean onViewFound(View view) {
            if (view instanceof EditText) {
                this.f56815a.set(true);
                return true;
            }
            return false;
        }
    }

    public a(TbPageContext tbPageContext, V v, D d2) {
        this.f56808b = tbPageContext;
        this.f56809c = tbPageContext.getPageActivity();
        this.f56814h = v;
        d(d2);
    }

    public void d(D d2) {
        V v = this.f56814h;
        if (v != null) {
            v.b(d2);
        }
    }

    @Override // d.a.o0.e2.j.f
    public void dismiss() {
        AlertDialog alertDialog = this.f56807a;
        if (alertDialog != null) {
            d.a.c.e.m.g.a(alertDialog, this.f56808b.getPageActivity());
        }
    }

    @Override // d.a.o0.e2.j.f
    public void show() {
        AlertDialog alertDialog = this.f56807a;
        if (alertDialog != null) {
            d.a.c.e.m.g.i(alertDialog, this.f56808b.getPageActivity());
            return;
        }
        if (this.f56813g) {
            this.f56807a = new AlertDialog.Builder(this.f56809c, R.style.search_dialog).create();
        } else {
            this.f56807a = new AlertDialog.Builder(this.f56809c).create();
        }
        this.f56807a.setCanceledOnTouchOutside(c());
        this.f56807a.setCancelable(b());
        this.f56807a.setOnKeyListener(this.f56810d);
        DialogInterface.OnCancelListener onCancelListener = this.f56811e;
        if (onCancelListener != null) {
            this.f56807a.setOnCancelListener(onCancelListener);
        }
        d.a.c.e.m.g.i(this.f56807a, this.f56808b.getPageActivity());
        if (this.f56807a.getWindow().getDecorView().getParent() == null) {
            return;
        }
        Window window = this.f56807a.getWindow();
        if (this.f56812f == -1) {
            this.f56812f = 17;
        }
        window.setGravity(this.f56812f);
        window.setBackgroundDrawableResource(R.drawable.transparent_bg);
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.dimAmount = 0.7f;
        attributes.width = -1;
        DisplayMetrics q = l.q(this.f56808b.getPageActivity());
        if (q != null) {
            int a2 = a();
            if (UtilHelper.getRealScreenOrientation(this.f56809c) == 2) {
                attributes.width = q.heightPixels - (a2 * 2);
            } else {
                attributes.width = q.widthPixels - (a2 * 2);
            }
        }
        attributes.height = -2;
        window.setAttributes(attributes);
        window.setContentView(this.f56814h.getViewGroup());
        AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        ViewHelper.processAllViewsIn(this.f56814h.getViewGroup(), false, new C1315a(this, atomicBoolean));
        if (atomicBoolean.get()) {
            window.clearFlags(131080);
        }
    }
}
