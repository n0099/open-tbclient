package d.b.i0.x2;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tieba.R;
import d.b.c.a.f;
import d.b.c.e.m.g;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: b  reason: collision with root package name */
    public String f63947b;

    /* renamed from: c  reason: collision with root package name */
    public View f63948c;

    /* renamed from: g  reason: collision with root package name */
    public String f63952g;

    /* renamed from: h  reason: collision with root package name */
    public String f63953h;
    public String i;
    public String j;
    public c k;
    public c l;
    public c m;
    public DialogInterface.OnCancelListener n;
    public DialogInterface.OnKeyListener o;
    public AlertDialog p;
    public final Activity q;
    public final ViewGroup r;

    /* renamed from: a  reason: collision with root package name */
    public int f63946a = -1;

    /* renamed from: d  reason: collision with root package name */
    public int f63949d = -1;

    /* renamed from: e  reason: collision with root package name */
    public int f63950e = R.drawable.btn_blue_bg;

    /* renamed from: f  reason: collision with root package name */
    public int f63951f = R.color.CAM_X0111;
    public boolean s = false;
    public boolean t = true;

    /* renamed from: d.b.i0.x2.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1708a implements ViewHelper.ViewCallback {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AtomicBoolean f63954a;

        public C1708a(a aVar, AtomicBoolean atomicBoolean) {
            this.f63954a = atomicBoolean;
        }

        @Override // com.baidu.tbadk.core.util.ViewHelper.ViewCallback
        public boolean onViewFound(View view) {
            if (view instanceof EditText) {
                this.f63954a.set(true);
                return true;
            }
            return false;
        }
    }

    /* loaded from: classes4.dex */
    public class b implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final a f63955e;

        /* renamed from: f  reason: collision with root package name */
        public final c f63956f;

        public b(a aVar, a aVar2, c cVar) {
            this.f63955e = aVar2;
            this.f63956f = cVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            c cVar = this.f63956f;
            if (cVar != null) {
                cVar.a(this.f63955e);
            }
        }
    }

    /* loaded from: classes4.dex */
    public interface c {
        void a(a aVar);
    }

    public a(Activity activity) {
        this.q = activity;
        this.r = (ViewGroup) LayoutInflater.from(activity).inflate(R.layout.dialog_icon_bdalert, (ViewGroup) null);
    }

    public final void a(f<?> fVar) {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (fVar instanceof TbPageContext) {
            TbPageContext tbPageContext = (TbPageContext) fVar;
            tbPageContext.getLayoutMode().k(skinType == 1);
            tbPageContext.getLayoutMode().j(this.r);
        }
    }

    public a b(f<?> fVar) {
        boolean z;
        boolean z2;
        boolean z3;
        if (this.s) {
            return this;
        }
        this.s = true;
        a(fVar);
        TextView textView = (TextView) this.r.findViewById(R.id.title);
        LinearLayout linearLayout = (LinearLayout) this.r.findViewById(R.id.content);
        ImageView imageView = (ImageView) this.r.findViewById(R.id.bdalert_icon);
        TextView textView2 = (TextView) this.r.findViewById(R.id.message);
        Button button = (Button) this.r.findViewById(R.id.yes);
        SkinManager.setBackgroundResource(button, this.f63950e);
        SkinManager.setViewTextColor(button, this.f63951f, 3);
        Button button2 = (Button) this.r.findViewById(R.id.no);
        Button button3 = (Button) this.r.findViewById(R.id.cancel);
        if (!TextUtils.isEmpty(this.f63947b)) {
            textView.setText(this.f63947b);
        } else {
            textView.setVisibility(8);
        }
        if (this.f63948c != null) {
            linearLayout.removeAllViews();
            linearLayout.addView(this.f63948c);
        }
        int i = this.f63949d;
        if (i != -1) {
            SkinManager.setImageResource(imageView, i);
            imageView.setVisibility(0);
        } else {
            imageView.setVisibility(8);
        }
        if (!TextUtils.isEmpty(this.f63952g)) {
            textView2.setText(this.f63952g);
        }
        if (TextUtils.isEmpty(this.f63953h)) {
            z = false;
        } else {
            button.setText(this.f63953h);
            c cVar = this.k;
            if (cVar != null) {
                button.setOnClickListener(new b(this, this, cVar));
            }
            z = true;
        }
        if (TextUtils.isEmpty(this.i)) {
            z2 = false;
        } else {
            button2.setText(this.i);
            c cVar2 = this.l;
            if (cVar2 != null) {
                button2.setOnClickListener(new b(this, this, cVar2));
            }
            z2 = true;
        }
        if (TextUtils.isEmpty(this.j)) {
            z3 = false;
        } else {
            button3.setText(this.j);
            c cVar3 = this.m;
            if (cVar3 != null) {
                button3.setOnClickListener(new b(this, this, cVar3));
            }
            z3 = true;
        }
        e(z, z2, z3, button, button2, button3);
        return this;
    }

    public final int c(Context context, float f2) {
        return (int) ((f2 * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public void d() {
        AlertDialog alertDialog = this.p;
        if (alertDialog != null) {
            g.a(alertDialog, this.q);
        }
    }

    public final void e(boolean z, boolean z2, boolean z3, Button button, Button button2, Button button3) {
        boolean[] zArr = {z2, z, z3};
        Button[] buttonArr = {button2, button, button3};
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < 3; i++) {
            if (zArr[i]) {
                arrayList.add(buttonArr[i]);
                buttonArr[i].setVisibility(0);
            } else {
                buttonArr[i].setVisibility(8);
            }
        }
        if (arrayList.size() == 3) {
            int i2 = 0;
            while (i2 < 3) {
                f((Button) arrayList.get(i2), 0, i2 == 2 ? 0 : 20);
                i2++;
            }
        }
        if (arrayList.size() == 2) {
            int i3 = 0;
            while (i3 < 2) {
                f((Button) arrayList.get(i3), 0, i3 == 1 ? 0 : 20);
                i3++;
            }
        }
        if (arrayList.size() == 1) {
            f((Button) arrayList.get(0), 0, 0);
        }
    }

    public final void f(Button button, int i, int i2) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) button.getLayoutParams();
        layoutParams.width = c(this.q, i);
        layoutParams.rightMargin = i2;
        layoutParams.weight = 1.0f;
        button.setLayoutParams(layoutParams);
    }

    public a g(boolean z) {
        this.t = z;
        return this;
    }

    public a h(int i) {
        this.f63949d = i;
        return this;
    }

    public a i(int i) {
        Activity activity = this.q;
        if (activity != null) {
            this.f63952g = activity.getResources().getString(i);
        }
        return this;
    }

    public a j(int i, c cVar) {
        Activity activity = this.q;
        if (activity != null) {
            this.i = activity.getResources().getString(i);
            this.l = cVar;
        }
        return this;
    }

    public a k(DialogInterface.OnKeyListener onKeyListener) {
        this.o = onKeyListener;
        return this;
    }

    public a l(int i, c cVar) {
        Activity activity = this.q;
        if (activity != null) {
            this.f63953h = activity.getResources().getString(i);
            this.k = cVar;
        }
        return this;
    }

    public a m(int i) {
        this.f63950e = i;
        return this;
    }

    public a n(int i) {
        this.f63951f = i;
        return this;
    }

    public a o() {
        p(true);
        return this;
    }

    public final a p(boolean z) {
        if (this.s) {
            AlertDialog alertDialog = this.p;
            if (alertDialog != null) {
                if (z) {
                    g.i(alertDialog, this.q);
                } else {
                    alertDialog.show();
                }
                return this;
            }
            AlertDialog create = new AlertDialog.Builder(this.q).create();
            this.p = create;
            create.setCanceledOnTouchOutside(this.t);
            DialogInterface.OnCancelListener onCancelListener = this.n;
            if (onCancelListener != null) {
                this.p.setOnCancelListener(onCancelListener);
            }
            DialogInterface.OnKeyListener onKeyListener = this.o;
            if (onKeyListener != null) {
                this.p.setOnKeyListener(onKeyListener);
            }
            if (z) {
                g.i(this.p, this.q);
            } else {
                this.p.show();
            }
            Window window = this.p.getWindow();
            if (this.f63946a == -1) {
                this.f63946a = 17;
            }
            window.setGravity(this.f63946a);
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.dimAmount = 0.5f;
            window.setAttributes(attributes);
            window.addFlags(2);
            window.setLayout(-2, -2);
            window.setContentView(this.r);
            AtomicBoolean atomicBoolean = new AtomicBoolean(false);
            ViewHelper.processAllViewsIn(this.r, false, new C1708a(this, atomicBoolean));
            if (atomicBoolean.get()) {
                window.clearFlags(131080);
            }
            return this;
        }
        throw new RuntimeException("Dialog must be created by function create()!");
    }
}
