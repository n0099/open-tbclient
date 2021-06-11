package d.a.n0.v3;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public Context f66054a;

    /* renamed from: b  reason: collision with root package name */
    public View f66055b;

    /* renamed from: c  reason: collision with root package name */
    public LinearLayout f66056c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f66057d;

    /* renamed from: e  reason: collision with root package name */
    public View f66058e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f66059f;

    /* renamed from: g  reason: collision with root package name */
    public String f66060g;

    /* renamed from: h  reason: collision with root package name */
    public List<b> f66061h;

    /* renamed from: i  reason: collision with root package name */
    public e f66062i;
    public c j;
    public boolean k;

    /* renamed from: d.a.n0.v3.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class View$OnClickListenerC1746a implements View.OnClickListener {
        public View$OnClickListenerC1746a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.j.onClick();
        }
    }

    /* loaded from: classes5.dex */
    public static class b {

        /* renamed from: b  reason: collision with root package name */
        public a f66065b;

        /* renamed from: c  reason: collision with root package name */
        public View f66066c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f66067d;

        /* renamed from: e  reason: collision with root package name */
        public View f66068e;

        /* renamed from: f  reason: collision with root package name */
        public String f66069f;

        /* renamed from: h  reason: collision with root package name */
        public d f66071h;
        public boolean j;

        /* renamed from: g  reason: collision with root package name */
        public int f66070g = 17;

        /* renamed from: i  reason: collision with root package name */
        public boolean f66072i = true;
        public final View.OnClickListener k = new View$OnClickListenerC1747a();

        /* renamed from: a  reason: collision with root package name */
        public int f66064a = hashCode();

        /* renamed from: d.a.n0.v3.a$b$a  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public class View$OnClickListenerC1747a implements View.OnClickListener {
            public View$OnClickListenerC1747a() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.f66071h != null) {
                    b.this.f66071h.onClick();
                }
                if (b.this.f66065b == null || b.this.f66065b.d() == null) {
                    return;
                }
                b.this.f66065b.d().a(b.this.f66064a, view);
            }
        }

        public b(String str, a aVar) {
            this.f66069f = str;
            this.f66065b = aVar;
            f();
            e();
        }

        public View d() {
            return this.f66066c;
        }

        public final void e() {
            TextView textView = this.f66067d;
            if (textView != null) {
                textView.setOnClickListener(this.k);
            }
        }

        public final void f() {
            a aVar = this.f66065b;
            if (aVar == null || aVar.c() == null) {
                return;
            }
            View inflate = LayoutInflater.from(this.f66065b.c()).inflate(R.layout.bottom_up_list_dialog_item, this.f66065b.e(), false);
            this.f66066c = inflate;
            TextView textView = (TextView) inflate.findViewById(R.id.item_view);
            this.f66067d = textView;
            textView.setText(this.f66069f);
            this.f66067d.setGravity(this.f66070g);
            View findViewById = this.f66066c.findViewById(R.id.divider_line);
            this.f66068e = findViewById;
            if (this.f66072i) {
                findViewById.setVisibility(0);
            } else {
                findViewById.setVisibility(8);
            }
            g();
        }

        public void g() {
            TextView textView = this.f66067d;
            if (textView != null) {
                if (this.j) {
                    SkinManager.setBackgroundResource(textView, R.drawable.bg_bottom_up_corner_dialog);
                } else {
                    textView.setBackgroundDrawable(SkinManager.getColorDrawableWithClickState(R.color.CAM_X0211));
                }
            }
            SkinManager.setViewTextColor(this.f66067d, R.color.CAM_X0105);
            SkinManager.setBackgroundColor(this.f66068e, R.color.CAM_X0204);
        }

        public void h(d dVar) {
            this.f66071h = dVar;
            e();
        }
    }

    /* loaded from: classes5.dex */
    public interface c {
        void onClick();
    }

    /* loaded from: classes5.dex */
    public interface d {
        void onClick();
    }

    /* loaded from: classes5.dex */
    public interface e {
        void a(int i2, View view);
    }

    public a(Context context) {
        if (context == null) {
            return;
        }
        this.f66054a = context;
        View inflate = LayoutInflater.from(context).inflate(R.layout.bottom_up_list_dialog_view, (ViewGroup) null);
        this.f66055b = inflate;
        this.f66056c = (LinearLayout) inflate.findViewById(R.id.content_view);
        this.f66057d = (TextView) this.f66055b.findViewById(R.id.title);
        this.f66058e = this.f66055b.findViewById(R.id.title_divide_line);
        this.f66061h = new ArrayList();
        this.f66059f = (TextView) this.f66055b.findViewById(R.id.dialog_bottom_cancel_button);
    }

    public View b() {
        if (!StringUtils.isNull(this.f66060g)) {
            this.f66057d.setText(this.f66060g);
            this.f66058e.setVisibility(0);
        } else {
            this.f66057d.setVisibility(8);
            this.f66058e.setVisibility(8);
        }
        if (this.j != null) {
            this.f66059f.setOnClickListener(new View$OnClickListenerC1746a());
        }
        f();
        return this.f66055b;
    }

    public Context c() {
        return this.f66054a;
    }

    public e d() {
        return this.f66062i;
    }

    public ViewGroup e() {
        return this.f66056c;
    }

    public void f() {
        TextView textView;
        SkinManager.setBackgroundColor(this.f66055b, R.color.CAM_X0204);
        SkinManager.setBackgroundResource(this.f66057d, R.drawable.bg_title_corner_dialog_item);
        SkinManager.setViewTextColor(this.f66057d, R.color.CAM_X0108);
        SkinManager.setBackgroundColor(this.f66058e, R.color.CAM_X0204);
        SkinManager.setBackgroundResource(this.f66059f, R.drawable.bg_bottom_up_list_dialog_item);
        SkinManager.setViewTextColor(this.f66059f, R.color.CAM_X0107);
        List<b> list = this.f66061h;
        if (list != null) {
            for (b bVar : list) {
                bVar.g();
            }
        }
        if (this.k) {
            if (!StringUtils.isNull(this.f66060g) && (textView = this.f66057d) != null && (textView.getBackground() instanceof GradientDrawable)) {
                float dimension = c().getResources().getDimension(R.dimen.tbds32);
                ((GradientDrawable) this.f66057d.getBackground()).setCornerRadii(new float[]{dimension, dimension, dimension, dimension, 0.0f, 0.0f, 0.0f, 0.0f});
            } else if (ListUtils.getCount(this.f66061h) > 0) {
                b bVar2 = this.f66061h.get(0);
                if (bVar2.j) {
                    return;
                }
                bVar2.j = true;
                bVar2.g();
            }
        }
    }

    public void g(List<b> list) {
        if (list == null) {
            return;
        }
        this.f66061h = list;
        this.f66056c.removeAllViews();
        for (int i2 = 0; i2 < list.size(); i2++) {
            b bVar = list.get(i2);
            if (bVar != null) {
                this.f66056c.addView(bVar.d());
            }
        }
    }

    public void h(c cVar) {
        this.j = cVar;
    }

    public void i(String str) {
        this.f66060g = str;
    }
}
