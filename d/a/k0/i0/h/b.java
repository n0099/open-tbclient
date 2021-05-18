package d.a.k0.i0.h;

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
import d.a.k0.i0.d.h;
import d.a.k0.i0.m.a;
import d.a.k0.i0.m.f;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public TextView f55717a;

    /* renamed from: b  reason: collision with root package name */
    public int f55718b;

    /* renamed from: c  reason: collision with root package name */
    public int f55719c;

    /* renamed from: d  reason: collision with root package name */
    public Context f55720d;

    /* renamed from: e  reason: collision with root package name */
    public d.a.k0.i0.m.a f55721e;

    /* renamed from: f  reason: collision with root package name */
    public d f55722f;

    /* renamed from: g  reason: collision with root package name */
    public f f55723g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f55724h = false;

    /* renamed from: i  reason: collision with root package name */
    public a.d f55725i = new a();
    public View.OnClickListener j = new View$OnClickListenerC1357b();
    public PopupWindow.OnDismissListener k = new c();

    /* loaded from: classes4.dex */
    public class a implements a.d {
        public a() {
        }

        @Override // d.a.k0.i0.m.a.d
        public void onItemClick(int i2) {
            b.this.f55719c = i2;
            TiebaStatic.log(new StatisticItem("c13369").param("obj_type", i2 == 1 ? 2 : 1));
            b.this.r();
            if (b.this.f55722f != null) {
                b.this.f55722f.a(b.this.f55719c);
            }
        }
    }

    /* renamed from: d.a.k0.i0.h.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class View$OnClickListenerC1357b implements View.OnClickListener {
        public View$OnClickListenerC1357b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (b.this.f55723g.r()) {
                return;
            }
            if (view == b.this.f55717a) {
                if (b.this.f55721e == null) {
                    b.this.f55721e = new d.a.k0.i0.m.a(b.this.f55720d);
                    b.this.f55721e.setOnDismissListener(b.this.k);
                    b.this.f55721e.l(b.this.f55725i);
                    b.this.f55721e.m(b.this.f55718b);
                }
                ArrayList arrayList = new ArrayList();
                arrayList.add(new h(b.this.f55720d.getString(R.string.level_sort), 1));
                arrayList.add(new h(b.this.f55720d.getString(R.string.update_sort), 2));
                b.this.f55721e.k(arrayList, b.this.f55719c);
                b.this.f55721e.o(b.this.f55717a);
            }
            b.this.f55724h = true;
            b bVar = b.this;
            bVar.s(bVar.f55724h);
        }
    }

    /* loaded from: classes4.dex */
    public class c implements PopupWindow.OnDismissListener {
        public c() {
        }

        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            b.this.f55724h = false;
            b bVar = b.this;
            bVar.s(bVar.f55724h);
        }
    }

    /* loaded from: classes4.dex */
    public interface d {
        void a(int i2);
    }

    public b(Context context, int i2, int i3, f fVar) {
        this.f55720d = context;
        this.f55719c = i2;
        this.f55718b = i3;
        this.f55723g = fVar;
    }

    public boolean o() {
        int i2 = this.f55719c;
        return i2 == 1 || i2 == 2;
    }

    public void p() {
        d.a.k0.i0.m.a aVar = this.f55721e;
        if (aVar != null) {
            aVar.i();
        }
    }

    public void q(int i2) {
        if (o()) {
            SkinManager.setViewTextColor(this.f55717a, R.color.CAM_X0105, i2);
            if (this.f55717a != null) {
                s(this.f55724h);
            }
        }
        d.a.k0.i0.m.a aVar = this.f55721e;
        if (aVar == null || !this.f55724h) {
            return;
        }
        aVar.j();
    }

    public void r() {
        TextView textView;
        if (!o() || (textView = this.f55717a) == null) {
            return;
        }
        int i2 = this.f55719c;
        if (i2 == 1) {
            textView.setText(R.string.level_sort);
        } else if (i2 == 2) {
            textView.setText(R.string.update_sort);
        }
        this.f55717a.setOnClickListener(this.j);
        s(this.f55724h);
    }

    public final void s(boolean z) {
        int i2 = z ? R.drawable.icon_pure_fold12_svg : R.drawable.icon_pure_unfold12_svg;
        f fVar = this.f55723g;
        d.a.k0.i0.d.c n = fVar != null ? fVar.n() : null;
        if (n != null && n.f55651a) {
            f fVar2 = this.f55723g;
            if (fVar2 != null && fVar2.t()) {
                SkinManager.setViewTextColor(this.f55717a, R.color.CAM_X0107);
                this.f55717a.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SvgManager.getInstance().getPureDrawable(i2, R.color.CAM_X0108, null), (Drawable) null);
                return;
            }
            SkinManager.setViewTextColor(this.f55717a, R.color.CAM_X0107);
            this.f55717a.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SvgManager.getInstance().getPureDrawable(i2, R.color.CAM_X0108, null), (Drawable) null);
            return;
        }
        SkinManager.setViewTextColor(this.f55717a, R.color.CAM_X0107);
        this.f55717a.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SvgManager.getInstance().getPureDrawable(i2, R.color.CAM_X0108, null), (Drawable) null);
    }

    public void t(int i2) {
        if (o()) {
            this.f55719c = i2;
            r();
        }
    }

    public void u(d dVar) {
        this.f55722f = dVar;
    }

    public void v(TextView textView) {
        this.f55717a = textView;
    }
}
