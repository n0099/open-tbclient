package d.b.i0.i0.h;

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
import d.b.i0.i0.d.h;
import d.b.i0.i0.m.a;
import d.b.i0.i0.m.f;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public TextView f55539a;

    /* renamed from: b  reason: collision with root package name */
    public int f55540b;

    /* renamed from: c  reason: collision with root package name */
    public int f55541c;

    /* renamed from: d  reason: collision with root package name */
    public Context f55542d;

    /* renamed from: e  reason: collision with root package name */
    public d.b.i0.i0.m.a f55543e;

    /* renamed from: f  reason: collision with root package name */
    public d f55544f;

    /* renamed from: g  reason: collision with root package name */
    public f f55545g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f55546h = false;
    public a.d i = new a();
    public View.OnClickListener j = new View$OnClickListenerC1285b();
    public PopupWindow.OnDismissListener k = new c();

    /* loaded from: classes4.dex */
    public class a implements a.d {
        public a() {
        }

        @Override // d.b.i0.i0.m.a.d
        public void onItemClick(int i) {
            b.this.f55541c = i;
            TiebaStatic.log(new StatisticItem("c13369").param("obj_type", i == 1 ? 2 : 1));
            b.this.r();
            if (b.this.f55544f != null) {
                b.this.f55544f.a(b.this.f55541c);
            }
        }
    }

    /* renamed from: d.b.i0.i0.h.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class View$OnClickListenerC1285b implements View.OnClickListener {
        public View$OnClickListenerC1285b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (b.this.f55545g.r()) {
                return;
            }
            if (view == b.this.f55539a) {
                if (b.this.f55543e == null) {
                    b.this.f55543e = new d.b.i0.i0.m.a(b.this.f55542d);
                    b.this.f55543e.setOnDismissListener(b.this.k);
                    b.this.f55543e.l(b.this.i);
                    b.this.f55543e.m(b.this.f55540b);
                }
                ArrayList arrayList = new ArrayList();
                arrayList.add(new h(b.this.f55542d.getString(R.string.level_sort), 1));
                arrayList.add(new h(b.this.f55542d.getString(R.string.update_sort), 2));
                b.this.f55543e.k(arrayList, b.this.f55541c);
                b.this.f55543e.o(b.this.f55539a);
            }
            b.this.f55546h = true;
            b bVar = b.this;
            bVar.s(bVar.f55546h);
        }
    }

    /* loaded from: classes4.dex */
    public class c implements PopupWindow.OnDismissListener {
        public c() {
        }

        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            b.this.f55546h = false;
            b bVar = b.this;
            bVar.s(bVar.f55546h);
        }
    }

    /* loaded from: classes4.dex */
    public interface d {
        void a(int i);
    }

    public b(Context context, int i, int i2, f fVar) {
        this.f55542d = context;
        this.f55541c = i;
        this.f55540b = i2;
        this.f55545g = fVar;
    }

    public boolean o() {
        int i = this.f55541c;
        return i == 1 || i == 2;
    }

    public void p() {
        d.b.i0.i0.m.a aVar = this.f55543e;
        if (aVar != null) {
            aVar.i();
        }
    }

    public void q(int i) {
        if (o()) {
            SkinManager.setViewTextColor(this.f55539a, R.color.CAM_X0105, i);
            if (this.f55539a != null) {
                s(this.f55546h);
            }
        }
        d.b.i0.i0.m.a aVar = this.f55543e;
        if (aVar == null || !this.f55546h) {
            return;
        }
        aVar.j();
    }

    public void r() {
        TextView textView;
        if (!o() || (textView = this.f55539a) == null) {
            return;
        }
        int i = this.f55541c;
        if (i == 1) {
            textView.setText(R.string.level_sort);
        } else if (i == 2) {
            textView.setText(R.string.update_sort);
        }
        this.f55539a.setOnClickListener(this.j);
        s(this.f55546h);
    }

    public final void s(boolean z) {
        int i = z ? R.drawable.icon_pure_fold12_svg : R.drawable.icon_pure_unfold12_svg;
        f fVar = this.f55545g;
        d.b.i0.i0.d.c n = fVar != null ? fVar.n() : null;
        if (n != null && n.f55477a) {
            f fVar2 = this.f55545g;
            if (fVar2 != null && fVar2.t()) {
                SkinManager.setViewTextColor(this.f55539a, R.color.CAM_X0107);
                this.f55539a.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SvgManager.getInstance().getPureDrawable(i, R.color.CAM_X0108, null), (Drawable) null);
                return;
            }
            SkinManager.setViewTextColor(this.f55539a, R.color.CAM_X0107);
            this.f55539a.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SvgManager.getInstance().getPureDrawable(i, R.color.CAM_X0108, null), (Drawable) null);
            return;
        }
        SkinManager.setViewTextColor(this.f55539a, R.color.CAM_X0107);
        this.f55539a.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SvgManager.getInstance().getPureDrawable(i, R.color.CAM_X0108, null), (Drawable) null);
    }

    public void t(int i) {
        if (o()) {
            this.f55541c = i;
            r();
        }
    }

    public void u(d dVar) {
        this.f55544f = dVar;
    }

    public void v(TextView textView) {
        this.f55539a = textView;
    }
}
