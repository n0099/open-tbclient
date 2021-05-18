package d.a.k0.u3;

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
    public Context f62182a;

    /* renamed from: b  reason: collision with root package name */
    public View f62183b;

    /* renamed from: c  reason: collision with root package name */
    public LinearLayout f62184c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f62185d;

    /* renamed from: e  reason: collision with root package name */
    public View f62186e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f62187f;

    /* renamed from: g  reason: collision with root package name */
    public String f62188g;

    /* renamed from: h  reason: collision with root package name */
    public List<b> f62189h;

    /* renamed from: i  reason: collision with root package name */
    public e f62190i;
    public c j;
    public boolean k;

    /* renamed from: d.a.k0.u3.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class View$OnClickListenerC1676a implements View.OnClickListener {
        public View$OnClickListenerC1676a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.j.onClick();
        }
    }

    /* loaded from: classes5.dex */
    public static class b {

        /* renamed from: b  reason: collision with root package name */
        public a f62193b;

        /* renamed from: c  reason: collision with root package name */
        public View f62194c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f62195d;

        /* renamed from: e  reason: collision with root package name */
        public View f62196e;

        /* renamed from: f  reason: collision with root package name */
        public String f62197f;

        /* renamed from: h  reason: collision with root package name */
        public d f62199h;
        public boolean j;

        /* renamed from: g  reason: collision with root package name */
        public int f62198g = 17;

        /* renamed from: i  reason: collision with root package name */
        public boolean f62200i = true;
        public final View.OnClickListener k = new View$OnClickListenerC1677a();

        /* renamed from: a  reason: collision with root package name */
        public int f62192a = hashCode();

        /* renamed from: d.a.k0.u3.a$b$a  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public class View$OnClickListenerC1677a implements View.OnClickListener {
            public View$OnClickListenerC1677a() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.f62199h != null) {
                    b.this.f62199h.onClick();
                }
                if (b.this.f62193b == null || b.this.f62193b.d() == null) {
                    return;
                }
                b.this.f62193b.d().a(b.this.f62192a, view);
            }
        }

        public b(String str, a aVar) {
            this.f62197f = str;
            this.f62193b = aVar;
            f();
            e();
        }

        public View d() {
            return this.f62194c;
        }

        public final void e() {
            TextView textView = this.f62195d;
            if (textView != null) {
                textView.setOnClickListener(this.k);
            }
        }

        public final void f() {
            a aVar = this.f62193b;
            if (aVar == null || aVar.c() == null) {
                return;
            }
            View inflate = LayoutInflater.from(this.f62193b.c()).inflate(R.layout.bottom_up_list_dialog_item, this.f62193b.e(), false);
            this.f62194c = inflate;
            TextView textView = (TextView) inflate.findViewById(R.id.item_view);
            this.f62195d = textView;
            textView.setText(this.f62197f);
            this.f62195d.setGravity(this.f62198g);
            View findViewById = this.f62194c.findViewById(R.id.divider_line);
            this.f62196e = findViewById;
            if (this.f62200i) {
                findViewById.setVisibility(0);
            } else {
                findViewById.setVisibility(8);
            }
            g();
        }

        public void g() {
            TextView textView = this.f62195d;
            if (textView != null) {
                if (this.j) {
                    SkinManager.setBackgroundResource(textView, R.drawable.bg_bottom_up_corner_dialog);
                } else {
                    textView.setBackgroundDrawable(SkinManager.getColorDrawableWithClickState(R.color.CAM_X0211));
                }
            }
            SkinManager.setViewTextColor(this.f62195d, R.color.CAM_X0105);
            SkinManager.setBackgroundColor(this.f62196e, R.color.CAM_X0204);
        }

        public void h(d dVar) {
            this.f62199h = dVar;
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
        this.f62182a = context;
        View inflate = LayoutInflater.from(context).inflate(R.layout.bottom_up_list_dialog_view, (ViewGroup) null);
        this.f62183b = inflate;
        this.f62184c = (LinearLayout) inflate.findViewById(R.id.content_view);
        this.f62185d = (TextView) this.f62183b.findViewById(R.id.title);
        this.f62186e = this.f62183b.findViewById(R.id.title_divide_line);
        this.f62189h = new ArrayList();
        this.f62187f = (TextView) this.f62183b.findViewById(R.id.dialog_bottom_cancel_button);
    }

    public View b() {
        if (!StringUtils.isNull(this.f62188g)) {
            this.f62185d.setText(this.f62188g);
            this.f62186e.setVisibility(0);
        } else {
            this.f62185d.setVisibility(8);
            this.f62186e.setVisibility(8);
        }
        if (this.j != null) {
            this.f62187f.setOnClickListener(new View$OnClickListenerC1676a());
        }
        f();
        return this.f62183b;
    }

    public Context c() {
        return this.f62182a;
    }

    public e d() {
        return this.f62190i;
    }

    public ViewGroup e() {
        return this.f62184c;
    }

    public void f() {
        TextView textView;
        SkinManager.setBackgroundColor(this.f62183b, R.color.CAM_X0204);
        SkinManager.setBackgroundResource(this.f62185d, R.drawable.bg_title_corner_dialog_item);
        SkinManager.setViewTextColor(this.f62185d, R.color.CAM_X0108);
        SkinManager.setBackgroundColor(this.f62186e, R.color.CAM_X0204);
        SkinManager.setBackgroundResource(this.f62187f, R.drawable.bg_bottom_up_list_dialog_item);
        SkinManager.setViewTextColor(this.f62187f, R.color.CAM_X0107);
        List<b> list = this.f62189h;
        if (list != null) {
            for (b bVar : list) {
                bVar.g();
            }
        }
        if (this.k) {
            if (!StringUtils.isNull(this.f62188g) && (textView = this.f62185d) != null && (textView.getBackground() instanceof GradientDrawable)) {
                float dimension = c().getResources().getDimension(R.dimen.tbds32);
                ((GradientDrawable) this.f62185d.getBackground()).setCornerRadii(new float[]{dimension, dimension, dimension, dimension, 0.0f, 0.0f, 0.0f, 0.0f});
            } else if (ListUtils.getCount(this.f62189h) > 0) {
                b bVar2 = this.f62189h.get(0);
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
        this.f62189h = list;
        this.f62184c.removeAllViews();
        for (int i2 = 0; i2 < list.size(); i2++) {
            b bVar = list.get(i2);
            if (bVar != null) {
                this.f62184c.addView(bVar.d());
            }
        }
    }

    public void h(c cVar) {
        this.j = cVar;
    }

    public void i(String str) {
        this.f62188g = str;
    }
}
