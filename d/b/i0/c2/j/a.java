package d.b.i0.c2.j;

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
import d.b.b.e.p.l;
import d.b.i0.c2.j.g;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes4.dex */
public abstract class a<V extends g, D extends IBaseDialogData> implements f {

    /* renamed from: a  reason: collision with root package name */
    public AlertDialog f52486a;

    /* renamed from: b  reason: collision with root package name */
    public TbPageContext f52487b;

    /* renamed from: c  reason: collision with root package name */
    public Context f52488c;

    /* renamed from: d  reason: collision with root package name */
    public DialogInterface.OnKeyListener f52489d;

    /* renamed from: e  reason: collision with root package name */
    public DialogInterface.OnCancelListener f52490e;

    /* renamed from: f  reason: collision with root package name */
    public int f52491f = -1;

    /* renamed from: g  reason: collision with root package name */
    public boolean f52492g = false;

    /* renamed from: h  reason: collision with root package name */
    public V f52493h;

    /* renamed from: d.b.i0.c2.j.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1145a implements ViewHelper.ViewCallback {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AtomicBoolean f52494a;

        public C1145a(a aVar, AtomicBoolean atomicBoolean) {
            this.f52494a = atomicBoolean;
        }

        @Override // com.baidu.tbadk.core.util.ViewHelper.ViewCallback
        public boolean onViewFound(View view) {
            if (view instanceof EditText) {
                this.f52494a.set(true);
                return true;
            }
            return false;
        }
    }

    public a(TbPageContext tbPageContext, V v, D d2) {
        this.f52487b = tbPageContext;
        this.f52488c = tbPageContext.getPageActivity();
        this.f52493h = v;
        d(d2);
    }

    public void d(D d2) {
        V v = this.f52493h;
        if (v != null) {
            v.c(d2);
        }
    }

    @Override // d.b.i0.c2.j.f
    public void dismiss() {
        AlertDialog alertDialog = this.f52486a;
        if (alertDialog != null) {
            d.b.b.e.m.g.a(alertDialog, this.f52487b.getPageActivity());
        }
    }

    @Override // d.b.i0.c2.j.f
    public void show() {
        AlertDialog alertDialog = this.f52486a;
        if (alertDialog != null) {
            d.b.b.e.m.g.i(alertDialog, this.f52487b.getPageActivity());
            return;
        }
        if (this.f52492g) {
            this.f52486a = new AlertDialog.Builder(this.f52488c, R.style.search_dialog).create();
        } else {
            this.f52486a = new AlertDialog.Builder(this.f52488c).create();
        }
        this.f52486a.setCanceledOnTouchOutside(c());
        this.f52486a.setCancelable(b());
        this.f52486a.setOnKeyListener(this.f52489d);
        DialogInterface.OnCancelListener onCancelListener = this.f52490e;
        if (onCancelListener != null) {
            this.f52486a.setOnCancelListener(onCancelListener);
        }
        d.b.b.e.m.g.i(this.f52486a, this.f52487b.getPageActivity());
        if (this.f52486a.getWindow().getDecorView().getParent() == null) {
            return;
        }
        Window window = this.f52486a.getWindow();
        if (this.f52491f == -1) {
            this.f52491f = 17;
        }
        window.setGravity(this.f52491f);
        window.setBackgroundDrawableResource(R.drawable.transparent_bg);
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.dimAmount = 0.7f;
        attributes.width = -1;
        DisplayMetrics q = l.q(this.f52487b.getPageActivity());
        if (q != null) {
            int a2 = a();
            if (UtilHelper.getRealScreenOrientation(this.f52488c) == 2) {
                attributes.width = q.heightPixels - (a2 * 2);
            } else {
                attributes.width = q.widthPixels - (a2 * 2);
            }
        }
        attributes.height = -2;
        window.setAttributes(attributes);
        window.setContentView(this.f52493h.getViewGroup());
        AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        ViewHelper.processAllViewsIn(this.f52493h.getViewGroup(), false, new C1145a(this, atomicBoolean));
        if (atomicBoolean.get()) {
            window.clearFlags(131080);
        }
    }
}
