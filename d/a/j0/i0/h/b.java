package d.a.j0.i0.h;

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
import d.a.j0.i0.d.h;
import d.a.j0.i0.m.a;
import d.a.j0.i0.m.f;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public TextView f55010a;

    /* renamed from: b  reason: collision with root package name */
    public int f55011b;

    /* renamed from: c  reason: collision with root package name */
    public int f55012c;

    /* renamed from: d  reason: collision with root package name */
    public Context f55013d;

    /* renamed from: e  reason: collision with root package name */
    public d.a.j0.i0.m.a f55014e;

    /* renamed from: f  reason: collision with root package name */
    public d f55015f;

    /* renamed from: g  reason: collision with root package name */
    public f f55016g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f55017h = false;

    /* renamed from: i  reason: collision with root package name */
    public a.d f55018i = new a();
    public View.OnClickListener j = new View$OnClickListenerC1285b();
    public PopupWindow.OnDismissListener k = new c();

    /* loaded from: classes4.dex */
    public class a implements a.d {
        public a() {
        }

        @Override // d.a.j0.i0.m.a.d
        public void onItemClick(int i2) {
            b.this.f55012c = i2;
            TiebaStatic.log(new StatisticItem("c13369").param("obj_type", i2 == 1 ? 2 : 1));
            b.this.r();
            if (b.this.f55015f != null) {
                b.this.f55015f.a(b.this.f55012c);
            }
        }
    }

    /* renamed from: d.a.j0.i0.h.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class View$OnClickListenerC1285b implements View.OnClickListener {
        public View$OnClickListenerC1285b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (b.this.f55016g.r()) {
                return;
            }
            if (view == b.this.f55010a) {
                if (b.this.f55014e == null) {
                    b.this.f55014e = new d.a.j0.i0.m.a(b.this.f55013d);
                    b.this.f55014e.setOnDismissListener(b.this.k);
                    b.this.f55014e.l(b.this.f55018i);
                    b.this.f55014e.m(b.this.f55011b);
                }
                ArrayList arrayList = new ArrayList();
                arrayList.add(new h(b.this.f55013d.getString(R.string.level_sort), 1));
                arrayList.add(new h(b.this.f55013d.getString(R.string.update_sort), 2));
                b.this.f55014e.k(arrayList, b.this.f55012c);
                b.this.f55014e.o(b.this.f55010a);
            }
            b.this.f55017h = true;
            b bVar = b.this;
            bVar.s(bVar.f55017h);
        }
    }

    /* loaded from: classes4.dex */
    public class c implements PopupWindow.OnDismissListener {
        public c() {
        }

        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            b.this.f55017h = false;
            b bVar = b.this;
            bVar.s(bVar.f55017h);
        }
    }

    /* loaded from: classes4.dex */
    public interface d {
        void a(int i2);
    }

    public b(Context context, int i2, int i3, f fVar) {
        this.f55013d = context;
        this.f55012c = i2;
        this.f55011b = i3;
        this.f55016g = fVar;
    }

    public boolean o() {
        int i2 = this.f55012c;
        return i2 == 1 || i2 == 2;
    }

    public void p() {
        d.a.j0.i0.m.a aVar = this.f55014e;
        if (aVar != null) {
            aVar.i();
        }
    }

    public void q(int i2) {
        if (o()) {
            SkinManager.setViewTextColor(this.f55010a, R.color.CAM_X0105, i2);
            if (this.f55010a != null) {
                s(this.f55017h);
            }
        }
        d.a.j0.i0.m.a aVar = this.f55014e;
        if (aVar == null || !this.f55017h) {
            return;
        }
        aVar.j();
    }

    public void r() {
        TextView textView;
        if (!o() || (textView = this.f55010a) == null) {
            return;
        }
        int i2 = this.f55012c;
        if (i2 == 1) {
            textView.setText(R.string.level_sort);
        } else if (i2 == 2) {
            textView.setText(R.string.update_sort);
        }
        this.f55010a.setOnClickListener(this.j);
        s(this.f55017h);
    }

    public final void s(boolean z) {
        int i2 = z ? R.drawable.icon_pure_fold12_svg : R.drawable.icon_pure_unfold12_svg;
        f fVar = this.f55016g;
        d.a.j0.i0.d.c n = fVar != null ? fVar.n() : null;
        if (n != null && n.f54944a) {
            f fVar2 = this.f55016g;
            if (fVar2 != null && fVar2.t()) {
                SkinManager.setViewTextColor(this.f55010a, R.color.CAM_X0107);
                this.f55010a.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SvgManager.getInstance().getPureDrawable(i2, R.color.CAM_X0108, null), (Drawable) null);
                return;
            }
            SkinManager.setViewTextColor(this.f55010a, R.color.CAM_X0107);
            this.f55010a.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SvgManager.getInstance().getPureDrawable(i2, R.color.CAM_X0108, null), (Drawable) null);
            return;
        }
        SkinManager.setViewTextColor(this.f55010a, R.color.CAM_X0107);
        this.f55010a.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SvgManager.getInstance().getPureDrawable(i2, R.color.CAM_X0108, null), (Drawable) null);
    }

    public void t(int i2) {
        if (o()) {
            this.f55012c = i2;
            r();
        }
    }

    public void u(d dVar) {
        this.f55015f = dVar;
    }

    public void v(TextView textView) {
        this.f55010a = textView;
    }
}
