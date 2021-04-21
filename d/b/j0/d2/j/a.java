package d.b.j0.d2.j;

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
import d.b.c.e.p.l;
import d.b.j0.d2.j.g;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes3.dex */
public abstract class a<V extends g, D extends IBaseDialogData> implements f {

    /* renamed from: a  reason: collision with root package name */
    public AlertDialog f54303a;

    /* renamed from: b  reason: collision with root package name */
    public TbPageContext f54304b;

    /* renamed from: c  reason: collision with root package name */
    public Context f54305c;

    /* renamed from: d  reason: collision with root package name */
    public DialogInterface.OnKeyListener f54306d;

    /* renamed from: e  reason: collision with root package name */
    public DialogInterface.OnCancelListener f54307e;

    /* renamed from: f  reason: collision with root package name */
    public int f54308f = -1;

    /* renamed from: g  reason: collision with root package name */
    public boolean f54309g = false;

    /* renamed from: h  reason: collision with root package name */
    public V f54310h;

    /* renamed from: d.b.j0.d2.j.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C1226a implements ViewHelper.ViewCallback {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AtomicBoolean f54311a;

        public C1226a(a aVar, AtomicBoolean atomicBoolean) {
            this.f54311a = atomicBoolean;
        }

        @Override // com.baidu.tbadk.core.util.ViewHelper.ViewCallback
        public boolean onViewFound(View view) {
            if (view instanceof EditText) {
                this.f54311a.set(true);
                return true;
            }
            return false;
        }
    }

    public a(TbPageContext tbPageContext, V v, D d2) {
        this.f54304b = tbPageContext;
        this.f54305c = tbPageContext.getPageActivity();
        this.f54310h = v;
        d(d2);
    }

    public void d(D d2) {
        V v = this.f54310h;
        if (v != null) {
            v.c(d2);
        }
    }

    @Override // d.b.j0.d2.j.f
    public void dismiss() {
        AlertDialog alertDialog = this.f54303a;
        if (alertDialog != null) {
            d.b.c.e.m.g.a(alertDialog, this.f54304b.getPageActivity());
        }
    }

    @Override // d.b.j0.d2.j.f
    public void show() {
        AlertDialog alertDialog = this.f54303a;
        if (alertDialog != null) {
            d.b.c.e.m.g.i(alertDialog, this.f54304b.getPageActivity());
            return;
        }
        if (this.f54309g) {
            this.f54303a = new AlertDialog.Builder(this.f54305c, R.style.search_dialog).create();
        } else {
            this.f54303a = new AlertDialog.Builder(this.f54305c).create();
        }
        this.f54303a.setCanceledOnTouchOutside(c());
        this.f54303a.setCancelable(b());
        this.f54303a.setOnKeyListener(this.f54306d);
        DialogInterface.OnCancelListener onCancelListener = this.f54307e;
        if (onCancelListener != null) {
            this.f54303a.setOnCancelListener(onCancelListener);
        }
        d.b.c.e.m.g.i(this.f54303a, this.f54304b.getPageActivity());
        if (this.f54303a.getWindow().getDecorView().getParent() == null) {
            return;
        }
        Window window = this.f54303a.getWindow();
        if (this.f54308f == -1) {
            this.f54308f = 17;
        }
        window.setGravity(this.f54308f);
        window.setBackgroundDrawableResource(R.drawable.transparent_bg);
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.dimAmount = 0.7f;
        attributes.width = -1;
        DisplayMetrics q = l.q(this.f54304b.getPageActivity());
        if (q != null) {
            int a2 = a();
            if (UtilHelper.getRealScreenOrientation(this.f54305c) == 2) {
                attributes.width = q.heightPixels - (a2 * 2);
            } else {
                attributes.width = q.widthPixels - (a2 * 2);
            }
        }
        attributes.height = -2;
        window.setAttributes(attributes);
        window.setContentView(this.f54310h.getViewGroup());
        AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        ViewHelper.processAllViewsIn(this.f54310h.getViewGroup(), false, new C1226a(this, atomicBoolean));
        if (atomicBoolean.get()) {
            window.clearFlags(131080);
        }
    }
}
