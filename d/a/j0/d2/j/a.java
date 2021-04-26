package d.a.j0.d2.j;

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
import d.a.j0.d2.j.g;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes3.dex */
public abstract class a<V extends g, D extends IBaseDialogData> implements f {

    /* renamed from: a  reason: collision with root package name */
    public AlertDialog f52088a;

    /* renamed from: b  reason: collision with root package name */
    public TbPageContext f52089b;

    /* renamed from: c  reason: collision with root package name */
    public Context f52090c;

    /* renamed from: d  reason: collision with root package name */
    public DialogInterface.OnKeyListener f52091d;

    /* renamed from: e  reason: collision with root package name */
    public DialogInterface.OnCancelListener f52092e;

    /* renamed from: f  reason: collision with root package name */
    public int f52093f = -1;

    /* renamed from: g  reason: collision with root package name */
    public boolean f52094g = false;

    /* renamed from: h  reason: collision with root package name */
    public V f52095h;

    /* renamed from: d.a.j0.d2.j.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C1165a implements ViewHelper.ViewCallback {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AtomicBoolean f52096a;

        public C1165a(a aVar, AtomicBoolean atomicBoolean) {
            this.f52096a = atomicBoolean;
        }

        @Override // com.baidu.tbadk.core.util.ViewHelper.ViewCallback
        public boolean onViewFound(View view) {
            if (view instanceof EditText) {
                this.f52096a.set(true);
                return true;
            }
            return false;
        }
    }

    public a(TbPageContext tbPageContext, V v, D d2) {
        this.f52089b = tbPageContext;
        this.f52090c = tbPageContext.getPageActivity();
        this.f52095h = v;
        d(d2);
    }

    public void d(D d2) {
        V v = this.f52095h;
        if (v != null) {
            v.b(d2);
        }
    }

    @Override // d.a.j0.d2.j.f
    public void dismiss() {
        AlertDialog alertDialog = this.f52088a;
        if (alertDialog != null) {
            d.a.c.e.m.g.a(alertDialog, this.f52089b.getPageActivity());
        }
    }

    @Override // d.a.j0.d2.j.f
    public void show() {
        AlertDialog alertDialog = this.f52088a;
        if (alertDialog != null) {
            d.a.c.e.m.g.i(alertDialog, this.f52089b.getPageActivity());
            return;
        }
        if (this.f52094g) {
            this.f52088a = new AlertDialog.Builder(this.f52090c, R.style.search_dialog).create();
        } else {
            this.f52088a = new AlertDialog.Builder(this.f52090c).create();
        }
        this.f52088a.setCanceledOnTouchOutside(c());
        this.f52088a.setCancelable(b());
        this.f52088a.setOnKeyListener(this.f52091d);
        DialogInterface.OnCancelListener onCancelListener = this.f52092e;
        if (onCancelListener != null) {
            this.f52088a.setOnCancelListener(onCancelListener);
        }
        d.a.c.e.m.g.i(this.f52088a, this.f52089b.getPageActivity());
        if (this.f52088a.getWindow().getDecorView().getParent() == null) {
            return;
        }
        Window window = this.f52088a.getWindow();
        if (this.f52093f == -1) {
            this.f52093f = 17;
        }
        window.setGravity(this.f52093f);
        window.setBackgroundDrawableResource(R.drawable.transparent_bg);
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.dimAmount = 0.7f;
        attributes.width = -1;
        DisplayMetrics q = l.q(this.f52089b.getPageActivity());
        if (q != null) {
            int a2 = a();
            if (UtilHelper.getRealScreenOrientation(this.f52090c) == 2) {
                attributes.width = q.heightPixels - (a2 * 2);
            } else {
                attributes.width = q.widthPixels - (a2 * 2);
            }
        }
        attributes.height = -2;
        window.setAttributes(attributes);
        window.setContentView(this.f52095h.getViewGroup());
        AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        ViewHelper.processAllViewsIn(this.f52095h.getViewGroup(), false, new C1165a(this, atomicBoolean));
        if (atomicBoolean.get()) {
            window.clearFlags(131080);
        }
    }
}
