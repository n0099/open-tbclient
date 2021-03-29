package d.b.i0.t3;

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
    public Context f61128a;

    /* renamed from: b  reason: collision with root package name */
    public View f61129b;

    /* renamed from: c  reason: collision with root package name */
    public LinearLayout f61130c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f61131d;

    /* renamed from: e  reason: collision with root package name */
    public View f61132e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f61133f;

    /* renamed from: g  reason: collision with root package name */
    public String f61134g;

    /* renamed from: h  reason: collision with root package name */
    public List<b> f61135h;
    public e i;
    public c j;
    public boolean k;

    /* renamed from: d.b.i0.t3.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class View$OnClickListenerC1588a implements View.OnClickListener {
        public View$OnClickListenerC1588a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.j.onClick();
        }
    }

    /* loaded from: classes5.dex */
    public static class b {

        /* renamed from: b  reason: collision with root package name */
        public a f61138b;

        /* renamed from: c  reason: collision with root package name */
        public View f61139c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f61140d;

        /* renamed from: e  reason: collision with root package name */
        public View f61141e;

        /* renamed from: f  reason: collision with root package name */
        public String f61142f;

        /* renamed from: h  reason: collision with root package name */
        public d f61144h;
        public boolean j;

        /* renamed from: g  reason: collision with root package name */
        public int f61143g = 17;
        public boolean i = true;
        public final View.OnClickListener k = new View$OnClickListenerC1589a();

        /* renamed from: a  reason: collision with root package name */
        public int f61137a = hashCode();

        /* renamed from: d.b.i0.t3.a$b$a  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public class View$OnClickListenerC1589a implements View.OnClickListener {
            public View$OnClickListenerC1589a() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.f61144h != null) {
                    b.this.f61144h.onClick();
                }
                if (b.this.f61138b == null || b.this.f61138b.d() == null) {
                    return;
                }
                b.this.f61138b.d().a(b.this.f61137a, view);
            }
        }

        public b(String str, a aVar) {
            this.f61142f = str;
            this.f61138b = aVar;
            f();
            e();
        }

        public View d() {
            return this.f61139c;
        }

        public final void e() {
            TextView textView = this.f61140d;
            if (textView != null) {
                textView.setOnClickListener(this.k);
            }
        }

        public final void f() {
            a aVar = this.f61138b;
            if (aVar == null || aVar.c() == null) {
                return;
            }
            View inflate = LayoutInflater.from(this.f61138b.c()).inflate(R.layout.bottom_up_list_dialog_item, this.f61138b.e(), false);
            this.f61139c = inflate;
            TextView textView = (TextView) inflate.findViewById(R.id.item_view);
            this.f61140d = textView;
            textView.setText(this.f61142f);
            this.f61140d.setGravity(this.f61143g);
            View findViewById = this.f61139c.findViewById(R.id.divider_line);
            this.f61141e = findViewById;
            if (this.i) {
                findViewById.setVisibility(0);
            } else {
                findViewById.setVisibility(8);
            }
            g();
        }

        public void g() {
            TextView textView = this.f61140d;
            if (textView != null) {
                if (this.j) {
                    SkinManager.setBackgroundResource(textView, R.drawable.bg_bottom_up_corner_dialog);
                } else {
                    textView.setBackgroundDrawable(SkinManager.getColorDrawableWithClickState(R.color.CAM_X0211));
                }
            }
            SkinManager.setViewTextColor(this.f61140d, R.color.CAM_X0105);
            SkinManager.setBackgroundColor(this.f61141e, R.color.CAM_X0204);
        }

        public void h(d dVar) {
            this.f61144h = dVar;
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
        this.f61128a = context;
        View inflate = LayoutInflater.from(context).inflate(R.layout.bottom_up_list_dialog_view, (ViewGroup) null);
        this.f61129b = inflate;
        this.f61130c = (LinearLayout) inflate.findViewById(R.id.content_view);
        this.f61131d = (TextView) this.f61129b.findViewById(R.id.title);
        this.f61132e = this.f61129b.findViewById(R.id.title_divide_line);
        this.f61135h = new ArrayList();
        this.f61133f = (TextView) this.f61129b.findViewById(R.id.dialog_bottom_cancel_button);
    }

    public View b() {
        if (!StringUtils.isNull(this.f61134g)) {
            this.f61131d.setText(this.f61134g);
            this.f61132e.setVisibility(0);
        } else {
            this.f61131d.setVisibility(8);
            this.f61132e.setVisibility(8);
        }
        if (this.j != null) {
            this.f61133f.setOnClickListener(new View$OnClickListenerC1588a());
        }
        f();
        return this.f61129b;
    }

    public Context c() {
        return this.f61128a;
    }

    public e d() {
        return this.i;
    }

    public ViewGroup e() {
        return this.f61130c;
    }

    public void f() {
        TextView textView;
        SkinManager.setBackgroundColor(this.f61129b, R.color.CAM_X0204);
        SkinManager.setBackgroundResource(this.f61131d, R.drawable.bg_title_corner_dialog_item);
        SkinManager.setViewTextColor(this.f61131d, R.color.CAM_X0108);
        SkinManager.setBackgroundColor(this.f61132e, R.color.CAM_X0204);
        SkinManager.setBackgroundResource(this.f61133f, R.drawable.bg_bottom_up_list_dialog_item);
        SkinManager.setViewTextColor(this.f61133f, R.color.CAM_X0107);
        List<b> list = this.f61135h;
        if (list != null) {
            for (b bVar : list) {
                bVar.g();
            }
        }
        if (this.k) {
            if (!StringUtils.isNull(this.f61134g) && (textView = this.f61131d) != null && (textView.getBackground() instanceof GradientDrawable)) {
                float dimension = c().getResources().getDimension(R.dimen.tbds32);
                ((GradientDrawable) this.f61131d.getBackground()).setCornerRadii(new float[]{dimension, dimension, dimension, dimension, 0.0f, 0.0f, 0.0f, 0.0f});
            } else if (ListUtils.getCount(this.f61135h) > 0) {
                b bVar2 = this.f61135h.get(0);
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
        this.f61135h = list;
        this.f61130c.removeAllViews();
        for (int i = 0; i < list.size(); i++) {
            b bVar = list.get(i);
            if (bVar != null) {
                this.f61130c.addView(bVar.d());
            }
        }
    }

    public void h(c cVar) {
        this.j = cVar;
    }

    public void i(String str) {
        this.f61134g = str;
    }
}
