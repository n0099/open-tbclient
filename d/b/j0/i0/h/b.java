package d.b.j0.i0.h;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.R;
import d.b.j0.i0.d.h;
import d.b.j0.i0.m.a;
import d.b.j0.i0.m.f;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public TextView f57083a;

    /* renamed from: b  reason: collision with root package name */
    public int f57084b;

    /* renamed from: c  reason: collision with root package name */
    public int f57085c;

    /* renamed from: d  reason: collision with root package name */
    public Context f57086d;

    /* renamed from: e  reason: collision with root package name */
    public d.b.j0.i0.m.a f57087e;

    /* renamed from: f  reason: collision with root package name */
    public d f57088f;

    /* renamed from: g  reason: collision with root package name */
    public f f57089g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f57090h = false;
    public a.d i = new a();
    public View.OnClickListener j = new View$OnClickListenerC1346b();
    public PopupWindow.OnDismissListener k = new c();

    /* loaded from: classes4.dex */
    public class a implements a.d {
        public a() {
        }

        @Override // d.b.j0.i0.m.a.d
        public void onItemClick(int i) {
            b.this.f57085c = i;
            TiebaStatic.log(new StatisticItem("c13369").param("obj_type", i == 1 ? 2 : 1));
            b.this.r();
            if (b.this.f57088f != null) {
                b.this.f57088f.a(b.this.f57085c);
            }
        }
    }

    /* renamed from: d.b.j0.i0.h.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class View$OnClickListenerC1346b implements View.OnClickListener {
        public View$OnClickListenerC1346b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (b.this.f57089g.r()) {
                return;
            }
            if (view == b.this.f57083a) {
                if (b.this.f57087e == null) {
                    b.this.f57087e = new d.b.j0.i0.m.a(b.this.f57086d);
                    b.this.f57087e.setOnDismissListener(b.this.k);
                    b.this.f57087e.l(b.this.i);
                    b.this.f57087e.m(b.this.f57084b);
                }
                ArrayList arrayList = new ArrayList();
                arrayList.add(new h(b.this.f57086d.getString(R.string.level_sort), 1));
                arrayList.add(new h(b.this.f57086d.getString(R.string.update_sort), 2));
                b.this.f57087e.k(arrayList, b.this.f57085c);
                b.this.f57087e.o(b.this.f57083a);
            }
            b.this.f57090h = true;
            b bVar = b.this;
            bVar.s(bVar.f57090h);
        }
    }

    /* loaded from: classes4.dex */
    public class c implements PopupWindow.OnDismissListener {
        public c() {
        }

        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            b.this.f57090h = false;
            b bVar = b.this;
            bVar.s(bVar.f57090h);
        }
    }

    /* loaded from: classes4.dex */
    public interface d {
        void a(int i);
    }

    public b(Context context, int i, int i2, f fVar) {
        this.f57086d = context;
        this.f57085c = i;
        this.f57084b = i2;
        this.f57089g = fVar;
    }

    public boolean o() {
        int i = this.f57085c;
        return i == 1 || i == 2;
    }

    public void p() {
        d.b.j0.i0.m.a aVar = this.f57087e;
        if (aVar != null) {
            aVar.i();
        }
    }

    public void q(int i) {
        if (o()) {
            SkinManager.setViewTextColor(this.f57083a, R.color.CAM_X0105, i);
            if (this.f57083a != null) {
                s(this.f57090h);
            }
        }
        d.b.j0.i0.m.a aVar = this.f57087e;
        if (aVar == null || !this.f57090h) {
            return;
        }
        aVar.j();
    }

    public void r() {
        TextView textView;
        if (!o() || (textView = this.f57083a) == null) {
            return;
        }
        int i = this.f57085c;
        if (i == 1) {
            textView.setText(R.string.level_sort);
        } else if (i == 2) {
            textView.setText(R.string.update_sort);
        }
        this.f57083a.setOnClickListener(this.j);
        s(this.f57090h);
    }

    public final void s(boolean z) {
        int i = z ? R.drawable.icon_pure_fold12_svg : R.drawable.icon_pure_unfold12_svg;
        f fVar = this.f57089g;
        d.b.j0.i0.d.c n = fVar != null ? fVar.n() : null;
        if (n != null && n.f57021a) {
            f fVar2 = this.f57089g;
            if (fVar2 != null && fVar2.t()) {
                SkinManager.setViewTextColor(this.f57083a, R.color.CAM_X0107);
                this.f57083a.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SvgManager.getInstance().getPureDrawable(i, R.color.CAM_X0108, null), (Drawable) null);
                return;
            }
            SkinManager.setViewTextColor(this.f57083a, R.color.CAM_X0107);
            this.f57083a.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SvgManager.getInstance().getPureDrawable(i, R.color.CAM_X0108, null), (Drawable) null);
            return;
        }
        SkinManager.setViewTextColor(this.f57083a, R.color.CAM_X0107);
        this.f57083a.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SvgManager.getInstance().getPureDrawable(i, R.color.CAM_X0108, null), (Drawable) null);
    }

    public void t(int i) {
        if (o()) {
            this.f57085c = i;
            r();
        }
    }

    public void u(d dVar) {
        this.f57088f = dVar;
    }

    public void v(TextView textView) {
        this.f57083a = textView;
    }
}
