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
/* loaded from: classes4.dex */
public abstract class a<V extends g, D extends IBaseDialogData> implements f {

    /* renamed from: a  reason: collision with root package name */
    public AlertDialog f52993a;

    /* renamed from: b  reason: collision with root package name */
    public TbPageContext f52994b;

    /* renamed from: c  reason: collision with root package name */
    public Context f52995c;

    /* renamed from: d  reason: collision with root package name */
    public DialogInterface.OnKeyListener f52996d;

    /* renamed from: e  reason: collision with root package name */
    public DialogInterface.OnCancelListener f52997e;

    /* renamed from: f  reason: collision with root package name */
    public int f52998f = -1;

    /* renamed from: g  reason: collision with root package name */
    public boolean f52999g = false;

    /* renamed from: h  reason: collision with root package name */
    public V f53000h;

    /* renamed from: d.a.n0.e2.j.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1255a implements ViewHelper.ViewCallback {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AtomicBoolean f53001a;

        public C1255a(a aVar, AtomicBoolean atomicBoolean) {
            this.f53001a = atomicBoolean;
        }

        @Override // com.baidu.tbadk.core.util.ViewHelper.ViewCallback
        public boolean onViewFound(View view) {
            if (view instanceof EditText) {
                this.f53001a.set(true);
                return true;
            }
            return false;
        }
    }

    public a(TbPageContext tbPageContext, V v, D d2) {
        this.f52994b = tbPageContext;
        this.f52995c = tbPageContext.getPageActivity();
        this.f53000h = v;
        d(d2);
    }

    public void d(D d2) {
        V v = this.f53000h;
        if (v != null) {
            v.b(d2);
        }
    }

    @Override // d.a.n0.e2.j.f
    public void dismiss() {
        AlertDialog alertDialog = this.f52993a;
        if (alertDialog != null) {
            d.a.c.e.m.g.a(alertDialog, this.f52994b.getPageActivity());
        }
    }

    @Override // d.a.n0.e2.j.f
    public void show() {
        AlertDialog alertDialog = this.f52993a;
        if (alertDialog != null) {
            d.a.c.e.m.g.i(alertDialog, this.f52994b.getPageActivity());
            return;
        }
        if (this.f52999g) {
            this.f52993a = new AlertDialog.Builder(this.f52995c, R.style.search_dialog).create();
        } else {
            this.f52993a = new AlertDialog.Builder(this.f52995c).create();
        }
        this.f52993a.setCanceledOnTouchOutside(c());
        this.f52993a.setCancelable(b());
        this.f52993a.setOnKeyListener(this.f52996d);
        DialogInterface.OnCancelListener onCancelListener = this.f52997e;
        if (onCancelListener != null) {
            this.f52993a.setOnCancelListener(onCancelListener);
        }
        d.a.c.e.m.g.i(this.f52993a, this.f52994b.getPageActivity());
        if (this.f52993a.getWindow().getDecorView().getParent() == null) {
            return;
        }
        Window window = this.f52993a.getWindow();
        if (this.f52998f == -1) {
            this.f52998f = 17;
        }
        window.setGravity(this.f52998f);
        window.setBackgroundDrawableResource(R.drawable.transparent_bg);
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.dimAmount = 0.7f;
        attributes.width = -1;
        DisplayMetrics q = l.q(this.f52994b.getPageActivity());
        if (q != null) {
            int a2 = a();
            if (UtilHelper.getRealScreenOrientation(this.f52995c) == 2) {
                attributes.width = q.heightPixels - (a2 * 2);
            } else {
                attributes.width = q.widthPixels - (a2 * 2);
            }
        }
        attributes.height = -2;
        window.setAttributes(attributes);
        window.setContentView(this.f53000h.getViewGroup());
        AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        ViewHelper.processAllViewsIn(this.f53000h.getViewGroup(), false, new C1255a(this, atomicBoolean));
        if (atomicBoolean.get()) {
            window.clearFlags(131080);
        }
    }
}
