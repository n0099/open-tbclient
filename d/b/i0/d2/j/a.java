package d.b.i0.d2.j;

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
import d.b.i0.d2.j.g;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes3.dex */
public abstract class a<V extends g, D extends IBaseDialogData> implements f {

    /* renamed from: a  reason: collision with root package name */
    public AlertDialog f53882a;

    /* renamed from: b  reason: collision with root package name */
    public TbPageContext f53883b;

    /* renamed from: c  reason: collision with root package name */
    public Context f53884c;

    /* renamed from: d  reason: collision with root package name */
    public DialogInterface.OnKeyListener f53885d;

    /* renamed from: e  reason: collision with root package name */
    public DialogInterface.OnCancelListener f53886e;

    /* renamed from: f  reason: collision with root package name */
    public int f53887f = -1;

    /* renamed from: g  reason: collision with root package name */
    public boolean f53888g = false;

    /* renamed from: h  reason: collision with root package name */
    public V f53889h;

    /* renamed from: d.b.i0.d2.j.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C1203a implements ViewHelper.ViewCallback {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AtomicBoolean f53890a;

        public C1203a(a aVar, AtomicBoolean atomicBoolean) {
            this.f53890a = atomicBoolean;
        }

        @Override // com.baidu.tbadk.core.util.ViewHelper.ViewCallback
        public boolean onViewFound(View view) {
            if (view instanceof EditText) {
                this.f53890a.set(true);
                return true;
            }
            return false;
        }
    }

    public a(TbPageContext tbPageContext, V v, D d2) {
        this.f53883b = tbPageContext;
        this.f53884c = tbPageContext.getPageActivity();
        this.f53889h = v;
        d(d2);
    }

    public void d(D d2) {
        V v = this.f53889h;
        if (v != null) {
            v.c(d2);
        }
    }

    @Override // d.b.i0.d2.j.f
    public void dismiss() {
        AlertDialog alertDialog = this.f53882a;
        if (alertDialog != null) {
            d.b.c.e.m.g.a(alertDialog, this.f53883b.getPageActivity());
        }
    }

    @Override // d.b.i0.d2.j.f
    public void show() {
        AlertDialog alertDialog = this.f53882a;
        if (alertDialog != null) {
            d.b.c.e.m.g.i(alertDialog, this.f53883b.getPageActivity());
            return;
        }
        if (this.f53888g) {
            this.f53882a = new AlertDialog.Builder(this.f53884c, R.style.search_dialog).create();
        } else {
            this.f53882a = new AlertDialog.Builder(this.f53884c).create();
        }
        this.f53882a.setCanceledOnTouchOutside(c());
        this.f53882a.setCancelable(b());
        this.f53882a.setOnKeyListener(this.f53885d);
        DialogInterface.OnCancelListener onCancelListener = this.f53886e;
        if (onCancelListener != null) {
            this.f53882a.setOnCancelListener(onCancelListener);
        }
        d.b.c.e.m.g.i(this.f53882a, this.f53883b.getPageActivity());
        if (this.f53882a.getWindow().getDecorView().getParent() == null) {
            return;
        }
        Window window = this.f53882a.getWindow();
        if (this.f53887f == -1) {
            this.f53887f = 17;
        }
        window.setGravity(this.f53887f);
        window.setBackgroundDrawableResource(R.drawable.transparent_bg);
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.dimAmount = 0.7f;
        attributes.width = -1;
        DisplayMetrics q = l.q(this.f53883b.getPageActivity());
        if (q != null) {
            int a2 = a();
            if (UtilHelper.getRealScreenOrientation(this.f53884c) == 2) {
                attributes.width = q.heightPixels - (a2 * 2);
            } else {
                attributes.width = q.widthPixels - (a2 * 2);
            }
        }
        attributes.height = -2;
        window.setAttributes(attributes);
        window.setContentView(this.f53889h.getViewGroup());
        AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        ViewHelper.processAllViewsIn(this.f53889h.getViewGroup(), false, new C1203a(this, atomicBoolean));
        if (atomicBoolean.get()) {
            window.clearFlags(131080);
        }
    }
}
