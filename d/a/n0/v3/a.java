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
    public Context f62339a;

    /* renamed from: b  reason: collision with root package name */
    public View f62340b;

    /* renamed from: c  reason: collision with root package name */
    public LinearLayout f62341c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f62342d;

    /* renamed from: e  reason: collision with root package name */
    public View f62343e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f62344f;

    /* renamed from: g  reason: collision with root package name */
    public String f62345g;

    /* renamed from: h  reason: collision with root package name */
    public List<b> f62346h;

    /* renamed from: i  reason: collision with root package name */
    public e f62347i;
    public c j;
    public boolean k;

    /* renamed from: d.a.n0.v3.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class View$OnClickListenerC1689a implements View.OnClickListener {
        public View$OnClickListenerC1689a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.j.onClick();
        }
    }

    /* loaded from: classes5.dex */
    public static class b {

        /* renamed from: b  reason: collision with root package name */
        public a f62350b;

        /* renamed from: c  reason: collision with root package name */
        public View f62351c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f62352d;

        /* renamed from: e  reason: collision with root package name */
        public View f62353e;

        /* renamed from: f  reason: collision with root package name */
        public String f62354f;

        /* renamed from: h  reason: collision with root package name */
        public d f62356h;
        public boolean j;

        /* renamed from: g  reason: collision with root package name */
        public int f62355g = 17;

        /* renamed from: i  reason: collision with root package name */
        public boolean f62357i = true;
        public final View.OnClickListener k = new View$OnClickListenerC1690a();

        /* renamed from: a  reason: collision with root package name */
        public int f62349a = hashCode();

        /* renamed from: d.a.n0.v3.a$b$a  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public class View$OnClickListenerC1690a implements View.OnClickListener {
            public View$OnClickListenerC1690a() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.f62356h != null) {
                    b.this.f62356h.onClick();
                }
                if (b.this.f62350b == null || b.this.f62350b.d() == null) {
                    return;
                }
                b.this.f62350b.d().a(b.this.f62349a, view);
            }
        }

        public b(String str, a aVar) {
            this.f62354f = str;
            this.f62350b = aVar;
            f();
            e();
        }

        public View d() {
            return this.f62351c;
        }

        public final void e() {
            TextView textView = this.f62352d;
            if (textView != null) {
                textView.setOnClickListener(this.k);
            }
        }

        public final void f() {
            a aVar = this.f62350b;
            if (aVar == null || aVar.c() == null) {
                return;
            }
            View inflate = LayoutInflater.from(this.f62350b.c()).inflate(R.layout.bottom_up_list_dialog_item, this.f62350b.e(), false);
            this.f62351c = inflate;
            TextView textView = (TextView) inflate.findViewById(R.id.item_view);
            this.f62352d = textView;
            textView.setText(this.f62354f);
            this.f62352d.setGravity(this.f62355g);
            View findViewById = this.f62351c.findViewById(R.id.divider_line);
            this.f62353e = findViewById;
            if (this.f62357i) {
                findViewById.setVisibility(0);
            } else {
                findViewById.setVisibility(8);
            }
            g();
        }

        public void g() {
            TextView textView = this.f62352d;
            if (textView != null) {
                if (this.j) {
                    SkinManager.setBackgroundResource(textView, R.drawable.bg_bottom_up_corner_dialog);
                } else {
                    textView.setBackgroundDrawable(SkinManager.getColorDrawableWithClickState(R.color.CAM_X0211));
                }
            }
            SkinManager.setViewTextColor(this.f62352d, R.color.CAM_X0105);
            SkinManager.setBackgroundColor(this.f62353e, R.color.CAM_X0204);
        }

        public void h(d dVar) {
            this.f62356h = dVar;
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
        this.f62339a = context;
        View inflate = LayoutInflater.from(context).inflate(R.layout.bottom_up_list_dialog_view, (ViewGroup) null);
        this.f62340b = inflate;
        this.f62341c = (LinearLayout) inflate.findViewById(R.id.content_view);
        this.f62342d = (TextView) this.f62340b.findViewById(R.id.title);
        this.f62343e = this.f62340b.findViewById(R.id.title_divide_line);
        this.f62346h = new ArrayList();
        this.f62344f = (TextView) this.f62340b.findViewById(R.id.dialog_bottom_cancel_button);
    }

    public View b() {
        if (!StringUtils.isNull(this.f62345g)) {
            this.f62342d.setText(this.f62345g);
            this.f62343e.setVisibility(0);
        } else {
            this.f62342d.setVisibility(8);
            this.f62343e.setVisibility(8);
        }
        if (this.j != null) {
            this.f62344f.setOnClickListener(new View$OnClickListenerC1689a());
        }
        f();
        return this.f62340b;
    }

    public Context c() {
        return this.f62339a;
    }

    public e d() {
        return this.f62347i;
    }

    public ViewGroup e() {
        return this.f62341c;
    }

    public void f() {
        TextView textView;
        SkinManager.setBackgroundColor(this.f62340b, R.color.CAM_X0204);
        SkinManager.setBackgroundResource(this.f62342d, R.drawable.bg_title_corner_dialog_item);
        SkinManager.setViewTextColor(this.f62342d, R.color.CAM_X0108);
        SkinManager.setBackgroundColor(this.f62343e, R.color.CAM_X0204);
        SkinManager.setBackgroundResource(this.f62344f, R.drawable.bg_bottom_up_list_dialog_item);
        SkinManager.setViewTextColor(this.f62344f, R.color.CAM_X0107);
        List<b> list = this.f62346h;
        if (list != null) {
            for (b bVar : list) {
                bVar.g();
            }
        }
        if (this.k) {
            if (!StringUtils.isNull(this.f62345g) && (textView = this.f62342d) != null && (textView.getBackground() instanceof GradientDrawable)) {
                float dimension = c().getResources().getDimension(R.dimen.tbds32);
                ((GradientDrawable) this.f62342d.getBackground()).setCornerRadii(new float[]{dimension, dimension, dimension, dimension, 0.0f, 0.0f, 0.0f, 0.0f});
            } else if (ListUtils.getCount(this.f62346h) > 0) {
                b bVar2 = this.f62346h.get(0);
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
        this.f62346h = list;
        this.f62341c.removeAllViews();
        for (int i2 = 0; i2 < list.size(); i2++) {
            b bVar = list.get(i2);
            if (bVar != null) {
                this.f62341c.addView(bVar.d());
            }
        }
    }

    public void h(c cVar) {
        this.j = cVar;
    }

    public void i(String str) {
        this.f62345g = str;
    }
}
