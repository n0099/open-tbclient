package d.a.n0.j0.h;

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
import d.a.n0.j0.d.h;
import d.a.n0.j0.m.a;
import d.a.n0.j0.m.f;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public TextView f55901a;

    /* renamed from: b  reason: collision with root package name */
    public int f55902b;

    /* renamed from: c  reason: collision with root package name */
    public int f55903c;

    /* renamed from: d  reason: collision with root package name */
    public Context f55904d;

    /* renamed from: e  reason: collision with root package name */
    public d.a.n0.j0.m.a f55905e;

    /* renamed from: f  reason: collision with root package name */
    public d f55906f;

    /* renamed from: g  reason: collision with root package name */
    public f f55907g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f55908h = false;

    /* renamed from: i  reason: collision with root package name */
    public a.d f55909i = new a();
    public View.OnClickListener j = new View$OnClickListenerC1375b();
    public PopupWindow.OnDismissListener k = new c();

    /* loaded from: classes4.dex */
    public class a implements a.d {
        public a() {
        }

        @Override // d.a.n0.j0.m.a.d
        public void onItemClick(int i2) {
            b.this.f55903c = i2;
            TiebaStatic.log(new StatisticItem("c13369").param("obj_type", i2 == 1 ? 2 : 1));
            b.this.r();
            if (b.this.f55906f != null) {
                b.this.f55906f.a(b.this.f55903c);
            }
        }
    }

    /* renamed from: d.a.n0.j0.h.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class View$OnClickListenerC1375b implements View.OnClickListener {
        public View$OnClickListenerC1375b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (b.this.f55907g.r()) {
                return;
            }
            if (view == b.this.f55901a) {
                if (b.this.f55905e == null) {
                    b.this.f55905e = new d.a.n0.j0.m.a(b.this.f55904d);
                    b.this.f55905e.setOnDismissListener(b.this.k);
                    b.this.f55905e.l(b.this.f55909i);
                    b.this.f55905e.m(b.this.f55902b);
                }
                ArrayList arrayList = new ArrayList();
                arrayList.add(new h(b.this.f55904d.getString(R.string.level_sort), 1));
                arrayList.add(new h(b.this.f55904d.getString(R.string.update_sort), 2));
                b.this.f55905e.k(arrayList, b.this.f55903c);
                b.this.f55905e.o(b.this.f55901a);
            }
            b.this.f55908h = true;
            b bVar = b.this;
            bVar.s(bVar.f55908h);
        }
    }

    /* loaded from: classes4.dex */
    public class c implements PopupWindow.OnDismissListener {
        public c() {
        }

        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            b.this.f55908h = false;
            b bVar = b.this;
            bVar.s(bVar.f55908h);
        }
    }

    /* loaded from: classes4.dex */
    public interface d {
        void a(int i2);
    }

    public b(Context context, int i2, int i3, f fVar) {
        this.f55904d = context;
        this.f55903c = i2;
        this.f55902b = i3;
        this.f55907g = fVar;
    }

    public boolean o() {
        int i2 = this.f55903c;
        return i2 == 1 || i2 == 2;
    }

    public void p() {
        d.a.n0.j0.m.a aVar = this.f55905e;
        if (aVar != null) {
            aVar.i();
        }
    }

    public void q(int i2) {
        if (o()) {
            SkinManager.setViewTextColor(this.f55901a, R.color.CAM_X0105, i2);
            if (this.f55901a != null) {
                s(this.f55908h);
            }
        }
        d.a.n0.j0.m.a aVar = this.f55905e;
        if (aVar == null || !this.f55908h) {
            return;
        }
        aVar.j();
    }

    public void r() {
        TextView textView;
        if (!o() || (textView = this.f55901a) == null) {
            return;
        }
        int i2 = this.f55903c;
        if (i2 == 1) {
            textView.setText(R.string.level_sort);
        } else if (i2 == 2) {
            textView.setText(R.string.update_sort);
        }
        this.f55901a.setOnClickListener(this.j);
        s(this.f55908h);
    }

    public final void s(boolean z) {
        int i2 = z ? R.drawable.icon_pure_fold12_svg : R.drawable.icon_pure_unfold12_svg;
        f fVar = this.f55907g;
        d.a.n0.j0.d.c n = fVar != null ? fVar.n() : null;
        if (n != null && n.f55835a) {
            f fVar2 = this.f55907g;
            if (fVar2 != null && fVar2.t()) {
                SkinManager.setViewTextColor(this.f55901a, R.color.CAM_X0107);
                this.f55901a.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SvgManager.getInstance().getPureDrawable(i2, R.color.CAM_X0108, null), (Drawable) null);
                return;
            }
            SkinManager.setViewTextColor(this.f55901a, R.color.CAM_X0107);
            this.f55901a.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SvgManager.getInstance().getPureDrawable(i2, R.color.CAM_X0108, null), (Drawable) null);
            return;
        }
        SkinManager.setViewTextColor(this.f55901a, R.color.CAM_X0107);
        this.f55901a.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SvgManager.getInstance().getPureDrawable(i2, R.color.CAM_X0108, null), (Drawable) null);
    }

    public void t(int i2) {
        if (o()) {
            this.f55903c = i2;
            r();
        }
    }

    public void u(d dVar) {
        this.f55906f = dVar;
    }

    public void v(TextView textView) {
        this.f55901a = textView;
    }
}
