package d.a.o0.j0.h;

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
import d.a.o0.j0.d.h;
import d.a.o0.j0.m.a;
import d.a.o0.j0.m.f;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public TextView f59715a;

    /* renamed from: b  reason: collision with root package name */
    public int f59716b;

    /* renamed from: c  reason: collision with root package name */
    public int f59717c;

    /* renamed from: d  reason: collision with root package name */
    public Context f59718d;

    /* renamed from: e  reason: collision with root package name */
    public d.a.o0.j0.m.a f59719e;

    /* renamed from: f  reason: collision with root package name */
    public d f59720f;

    /* renamed from: g  reason: collision with root package name */
    public f f59721g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f59722h = false;

    /* renamed from: i  reason: collision with root package name */
    public a.d f59723i = new a();
    public View.OnClickListener j = new View$OnClickListenerC1435b();
    public PopupWindow.OnDismissListener k = new c();

    /* loaded from: classes4.dex */
    public class a implements a.d {
        public a() {
        }

        @Override // d.a.o0.j0.m.a.d
        public void onItemClick(int i2) {
            b.this.f59717c = i2;
            TiebaStatic.log(new StatisticItem("c13369").param("obj_type", i2 == 1 ? 2 : 1));
            b.this.r();
            if (b.this.f59720f != null) {
                b.this.f59720f.a(b.this.f59717c);
            }
        }
    }

    /* renamed from: d.a.o0.j0.h.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class View$OnClickListenerC1435b implements View.OnClickListener {
        public View$OnClickListenerC1435b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (b.this.f59721g.r()) {
                return;
            }
            if (view == b.this.f59715a) {
                if (b.this.f59719e == null) {
                    b.this.f59719e = new d.a.o0.j0.m.a(b.this.f59718d);
                    b.this.f59719e.setOnDismissListener(b.this.k);
                    b.this.f59719e.l(b.this.f59723i);
                    b.this.f59719e.m(b.this.f59716b);
                }
                ArrayList arrayList = new ArrayList();
                arrayList.add(new h(b.this.f59718d.getString(R.string.level_sort), 1));
                arrayList.add(new h(b.this.f59718d.getString(R.string.update_sort), 2));
                b.this.f59719e.k(arrayList, b.this.f59717c);
                b.this.f59719e.o(b.this.f59715a);
            }
            b.this.f59722h = true;
            b bVar = b.this;
            bVar.s(bVar.f59722h);
        }
    }

    /* loaded from: classes4.dex */
    public class c implements PopupWindow.OnDismissListener {
        public c() {
        }

        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            b.this.f59722h = false;
            b bVar = b.this;
            bVar.s(bVar.f59722h);
        }
    }

    /* loaded from: classes4.dex */
    public interface d {
        void a(int i2);
    }

    public b(Context context, int i2, int i3, f fVar) {
        this.f59718d = context;
        this.f59717c = i2;
        this.f59716b = i3;
        this.f59721g = fVar;
    }

    public boolean o() {
        int i2 = this.f59717c;
        return i2 == 1 || i2 == 2;
    }

    public void p() {
        d.a.o0.j0.m.a aVar = this.f59719e;
        if (aVar != null) {
            aVar.i();
        }
    }

    public void q(int i2) {
        if (o()) {
            SkinManager.setViewTextColor(this.f59715a, R.color.CAM_X0105, i2);
            if (this.f59715a != null) {
                s(this.f59722h);
            }
        }
        d.a.o0.j0.m.a aVar = this.f59719e;
        if (aVar == null || !this.f59722h) {
            return;
        }
        aVar.j();
    }

    public void r() {
        TextView textView;
        if (!o() || (textView = this.f59715a) == null) {
            return;
        }
        int i2 = this.f59717c;
        if (i2 == 1) {
            textView.setText(R.string.level_sort);
        } else if (i2 == 2) {
            textView.setText(R.string.update_sort);
        }
        this.f59715a.setOnClickListener(this.j);
        s(this.f59722h);
    }

    public final void s(boolean z) {
        int i2 = z ? R.drawable.icon_pure_fold12_svg : R.drawable.icon_pure_unfold12_svg;
        f fVar = this.f59721g;
        d.a.o0.j0.d.c n = fVar != null ? fVar.n() : null;
        if (n != null && n.f59649a) {
            f fVar2 = this.f59721g;
            if (fVar2 != null && fVar2.t()) {
                SkinManager.setViewTextColor(this.f59715a, R.color.CAM_X0107);
                this.f59715a.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SvgManager.getInstance().getPureDrawable(i2, R.color.CAM_X0108, null), (Drawable) null);
                return;
            }
            SkinManager.setViewTextColor(this.f59715a, R.color.CAM_X0107);
            this.f59715a.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SvgManager.getInstance().getPureDrawable(i2, R.color.CAM_X0108, null), (Drawable) null);
            return;
        }
        SkinManager.setViewTextColor(this.f59715a, R.color.CAM_X0107);
        this.f59715a.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SvgManager.getInstance().getPureDrawable(i2, R.color.CAM_X0108, null), (Drawable) null);
    }

    public void t(int i2) {
        if (o()) {
            this.f59717c = i2;
            r();
        }
    }

    public void u(d dVar) {
        this.f59720f = dVar;
    }

    public void v(TextView textView) {
        this.f59715a = textView;
    }
}
