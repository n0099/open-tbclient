package d.b.i0.u3;

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
    public Context f62817a;

    /* renamed from: b  reason: collision with root package name */
    public View f62818b;

    /* renamed from: c  reason: collision with root package name */
    public LinearLayout f62819c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f62820d;

    /* renamed from: e  reason: collision with root package name */
    public View f62821e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f62822f;

    /* renamed from: g  reason: collision with root package name */
    public String f62823g;

    /* renamed from: h  reason: collision with root package name */
    public List<b> f62824h;
    public e i;
    public c j;
    public boolean k;

    /* renamed from: d.b.i0.u3.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class View$OnClickListenerC1648a implements View.OnClickListener {
        public View$OnClickListenerC1648a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.j.onClick();
        }
    }

    /* loaded from: classes5.dex */
    public static class b {

        /* renamed from: b  reason: collision with root package name */
        public a f62827b;

        /* renamed from: c  reason: collision with root package name */
        public View f62828c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f62829d;

        /* renamed from: e  reason: collision with root package name */
        public View f62830e;

        /* renamed from: f  reason: collision with root package name */
        public String f62831f;

        /* renamed from: h  reason: collision with root package name */
        public d f62833h;
        public boolean j;

        /* renamed from: g  reason: collision with root package name */
        public int f62832g = 17;
        public boolean i = true;
        public final View.OnClickListener k = new View$OnClickListenerC1649a();

        /* renamed from: a  reason: collision with root package name */
        public int f62826a = hashCode();

        /* renamed from: d.b.i0.u3.a$b$a  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public class View$OnClickListenerC1649a implements View.OnClickListener {
            public View$OnClickListenerC1649a() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.f62833h != null) {
                    b.this.f62833h.onClick();
                }
                if (b.this.f62827b == null || b.this.f62827b.d() == null) {
                    return;
                }
                b.this.f62827b.d().a(b.this.f62826a, view);
            }
        }

        public b(String str, a aVar) {
            this.f62831f = str;
            this.f62827b = aVar;
            f();
            e();
        }

        public View d() {
            return this.f62828c;
        }

        public final void e() {
            TextView textView = this.f62829d;
            if (textView != null) {
                textView.setOnClickListener(this.k);
            }
        }

        public final void f() {
            a aVar = this.f62827b;
            if (aVar == null || aVar.c() == null) {
                return;
            }
            View inflate = LayoutInflater.from(this.f62827b.c()).inflate(R.layout.bottom_up_list_dialog_item, this.f62827b.e(), false);
            this.f62828c = inflate;
            TextView textView = (TextView) inflate.findViewById(R.id.item_view);
            this.f62829d = textView;
            textView.setText(this.f62831f);
            this.f62829d.setGravity(this.f62832g);
            View findViewById = this.f62828c.findViewById(R.id.divider_line);
            this.f62830e = findViewById;
            if (this.i) {
                findViewById.setVisibility(0);
            } else {
                findViewById.setVisibility(8);
            }
            g();
        }

        public void g() {
            TextView textView = this.f62829d;
            if (textView != null) {
                if (this.j) {
                    SkinManager.setBackgroundResource(textView, R.drawable.bg_bottom_up_corner_dialog);
                } else {
                    textView.setBackgroundDrawable(SkinManager.getColorDrawableWithClickState(R.color.CAM_X0211));
                }
            }
            SkinManager.setViewTextColor(this.f62829d, R.color.CAM_X0105);
            SkinManager.setBackgroundColor(this.f62830e, R.color.CAM_X0204);
        }

        public void h(d dVar) {
            this.f62833h = dVar;
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
        this.f62817a = context;
        View inflate = LayoutInflater.from(context).inflate(R.layout.bottom_up_list_dialog_view, (ViewGroup) null);
        this.f62818b = inflate;
        this.f62819c = (LinearLayout) inflate.findViewById(R.id.content_view);
        this.f62820d = (TextView) this.f62818b.findViewById(R.id.title);
        this.f62821e = this.f62818b.findViewById(R.id.title_divide_line);
        this.f62824h = new ArrayList();
        this.f62822f = (TextView) this.f62818b.findViewById(R.id.dialog_bottom_cancel_button);
    }

    public View b() {
        if (!StringUtils.isNull(this.f62823g)) {
            this.f62820d.setText(this.f62823g);
            this.f62821e.setVisibility(0);
        } else {
            this.f62820d.setVisibility(8);
            this.f62821e.setVisibility(8);
        }
        if (this.j != null) {
            this.f62822f.setOnClickListener(new View$OnClickListenerC1648a());
        }
        f();
        return this.f62818b;
    }

    public Context c() {
        return this.f62817a;
    }

    public e d() {
        return this.i;
    }

    public ViewGroup e() {
        return this.f62819c;
    }

    public void f() {
        TextView textView;
        SkinManager.setBackgroundColor(this.f62818b, R.color.CAM_X0204);
        SkinManager.setBackgroundResource(this.f62820d, R.drawable.bg_title_corner_dialog_item);
        SkinManager.setViewTextColor(this.f62820d, R.color.CAM_X0108);
        SkinManager.setBackgroundColor(this.f62821e, R.color.CAM_X0204);
        SkinManager.setBackgroundResource(this.f62822f, R.drawable.bg_bottom_up_list_dialog_item);
        SkinManager.setViewTextColor(this.f62822f, R.color.CAM_X0107);
        List<b> list = this.f62824h;
        if (list != null) {
            for (b bVar : list) {
                bVar.g();
            }
        }
        if (this.k) {
            if (!StringUtils.isNull(this.f62823g) && (textView = this.f62820d) != null && (textView.getBackground() instanceof GradientDrawable)) {
                float dimension = c().getResources().getDimension(R.dimen.tbds32);
                ((GradientDrawable) this.f62820d.getBackground()).setCornerRadii(new float[]{dimension, dimension, dimension, dimension, 0.0f, 0.0f, 0.0f, 0.0f});
            } else if (ListUtils.getCount(this.f62824h) > 0) {
                b bVar2 = this.f62824h.get(0);
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
        this.f62824h = list;
        this.f62819c.removeAllViews();
        for (int i = 0; i < list.size(); i++) {
            b bVar = list.get(i);
            if (bVar != null) {
                this.f62819c.addView(bVar.d());
            }
        }
    }

    public void h(c cVar) {
        this.j = cVar;
    }

    public void i(String str) {
        this.f62823g = str;
    }
}
