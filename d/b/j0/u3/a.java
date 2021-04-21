package d.b.j0.u3;

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
    public Context f63238a;

    /* renamed from: b  reason: collision with root package name */
    public View f63239b;

    /* renamed from: c  reason: collision with root package name */
    public LinearLayout f63240c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f63241d;

    /* renamed from: e  reason: collision with root package name */
    public View f63242e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f63243f;

    /* renamed from: g  reason: collision with root package name */
    public String f63244g;

    /* renamed from: h  reason: collision with root package name */
    public List<b> f63245h;
    public e i;
    public c j;
    public boolean k;

    /* renamed from: d.b.j0.u3.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class View$OnClickListenerC1671a implements View.OnClickListener {
        public View$OnClickListenerC1671a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.j.onClick();
        }
    }

    /* loaded from: classes5.dex */
    public static class b {

        /* renamed from: b  reason: collision with root package name */
        public a f63248b;

        /* renamed from: c  reason: collision with root package name */
        public View f63249c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f63250d;

        /* renamed from: e  reason: collision with root package name */
        public View f63251e;

        /* renamed from: f  reason: collision with root package name */
        public String f63252f;

        /* renamed from: h  reason: collision with root package name */
        public d f63254h;
        public boolean j;

        /* renamed from: g  reason: collision with root package name */
        public int f63253g = 17;
        public boolean i = true;
        public final View.OnClickListener k = new View$OnClickListenerC1672a();

        /* renamed from: a  reason: collision with root package name */
        public int f63247a = hashCode();

        /* renamed from: d.b.j0.u3.a$b$a  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public class View$OnClickListenerC1672a implements View.OnClickListener {
            public View$OnClickListenerC1672a() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.f63254h != null) {
                    b.this.f63254h.onClick();
                }
                if (b.this.f63248b == null || b.this.f63248b.d() == null) {
                    return;
                }
                b.this.f63248b.d().a(b.this.f63247a, view);
            }
        }

        public b(String str, a aVar) {
            this.f63252f = str;
            this.f63248b = aVar;
            f();
            e();
        }

        public View d() {
            return this.f63249c;
        }

        public final void e() {
            TextView textView = this.f63250d;
            if (textView != null) {
                textView.setOnClickListener(this.k);
            }
        }

        public final void f() {
            a aVar = this.f63248b;
            if (aVar == null || aVar.c() == null) {
                return;
            }
            View inflate = LayoutInflater.from(this.f63248b.c()).inflate(R.layout.bottom_up_list_dialog_item, this.f63248b.e(), false);
            this.f63249c = inflate;
            TextView textView = (TextView) inflate.findViewById(R.id.item_view);
            this.f63250d = textView;
            textView.setText(this.f63252f);
            this.f63250d.setGravity(this.f63253g);
            View findViewById = this.f63249c.findViewById(R.id.divider_line);
            this.f63251e = findViewById;
            if (this.i) {
                findViewById.setVisibility(0);
            } else {
                findViewById.setVisibility(8);
            }
            g();
        }

        public void g() {
            TextView textView = this.f63250d;
            if (textView != null) {
                if (this.j) {
                    SkinManager.setBackgroundResource(textView, R.drawable.bg_bottom_up_corner_dialog);
                } else {
                    textView.setBackgroundDrawable(SkinManager.getColorDrawableWithClickState(R.color.CAM_X0211));
                }
            }
            SkinManager.setViewTextColor(this.f63250d, R.color.CAM_X0105);
            SkinManager.setBackgroundColor(this.f63251e, R.color.CAM_X0204);
        }

        public void h(d dVar) {
            this.f63254h = dVar;
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
        void a(int i, View view);
    }

    public a(Context context) {
        if (context == null) {
            return;
        }
        this.f63238a = context;
        View inflate = LayoutInflater.from(context).inflate(R.layout.bottom_up_list_dialog_view, (ViewGroup) null);
        this.f63239b = inflate;
        this.f63240c = (LinearLayout) inflate.findViewById(R.id.content_view);
        this.f63241d = (TextView) this.f63239b.findViewById(R.id.title);
        this.f63242e = this.f63239b.findViewById(R.id.title_divide_line);
        this.f63245h = new ArrayList();
        this.f63243f = (TextView) this.f63239b.findViewById(R.id.dialog_bottom_cancel_button);
    }

    public View b() {
        if (!StringUtils.isNull(this.f63244g)) {
            this.f63241d.setText(this.f63244g);
            this.f63242e.setVisibility(0);
        } else {
            this.f63241d.setVisibility(8);
            this.f63242e.setVisibility(8);
        }
        if (this.j != null) {
            this.f63243f.setOnClickListener(new View$OnClickListenerC1671a());
        }
        f();
        return this.f63239b;
    }

    public Context c() {
        return this.f63238a;
    }

    public e d() {
        return this.i;
    }

    public ViewGroup e() {
        return this.f63240c;
    }

    public void f() {
        TextView textView;
        SkinManager.setBackgroundColor(this.f63239b, R.color.CAM_X0204);
        SkinManager.setBackgroundResource(this.f63241d, R.drawable.bg_title_corner_dialog_item);
        SkinManager.setViewTextColor(this.f63241d, R.color.CAM_X0108);
        SkinManager.setBackgroundColor(this.f63242e, R.color.CAM_X0204);
        SkinManager.setBackgroundResource(this.f63243f, R.drawable.bg_bottom_up_list_dialog_item);
        SkinManager.setViewTextColor(this.f63243f, R.color.CAM_X0107);
        List<b> list = this.f63245h;
        if (list != null) {
            for (b bVar : list) {
                bVar.g();
            }
        }
        if (this.k) {
            if (!StringUtils.isNull(this.f63244g) && (textView = this.f63241d) != null && (textView.getBackground() instanceof GradientDrawable)) {
                float dimension = c().getResources().getDimension(R.dimen.tbds32);
                ((GradientDrawable) this.f63241d.getBackground()).setCornerRadii(new float[]{dimension, dimension, dimension, dimension, 0.0f, 0.0f, 0.0f, 0.0f});
            } else if (ListUtils.getCount(this.f63245h) > 0) {
                b bVar2 = this.f63245h.get(0);
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
        this.f63245h = list;
        this.f63240c.removeAllViews();
        for (int i = 0; i < list.size(); i++) {
            b bVar = list.get(i);
            if (bVar != null) {
                this.f63240c.addView(bVar.d());
            }
        }
    }

    public void h(c cVar) {
        this.j = cVar;
    }

    public void i(String str) {
        this.f63244g = str;
    }
}
