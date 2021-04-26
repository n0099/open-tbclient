package d.a.j0.u3;

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
    public Context f61458a;

    /* renamed from: b  reason: collision with root package name */
    public View f61459b;

    /* renamed from: c  reason: collision with root package name */
    public LinearLayout f61460c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f61461d;

    /* renamed from: e  reason: collision with root package name */
    public View f61462e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f61463f;

    /* renamed from: g  reason: collision with root package name */
    public String f61464g;

    /* renamed from: h  reason: collision with root package name */
    public List<b> f61465h;

    /* renamed from: i  reason: collision with root package name */
    public e f61466i;
    public c j;
    public boolean k;

    /* renamed from: d.a.j0.u3.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class View$OnClickListenerC1611a implements View.OnClickListener {
        public View$OnClickListenerC1611a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.j.onClick();
        }
    }

    /* loaded from: classes5.dex */
    public static class b {

        /* renamed from: b  reason: collision with root package name */
        public a f61469b;

        /* renamed from: c  reason: collision with root package name */
        public View f61470c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f61471d;

        /* renamed from: e  reason: collision with root package name */
        public View f61472e;

        /* renamed from: f  reason: collision with root package name */
        public String f61473f;

        /* renamed from: h  reason: collision with root package name */
        public d f61475h;
        public boolean j;

        /* renamed from: g  reason: collision with root package name */
        public int f61474g = 17;

        /* renamed from: i  reason: collision with root package name */
        public boolean f61476i = true;
        public final View.OnClickListener k = new View$OnClickListenerC1612a();

        /* renamed from: a  reason: collision with root package name */
        public int f61468a = hashCode();

        /* renamed from: d.a.j0.u3.a$b$a  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public class View$OnClickListenerC1612a implements View.OnClickListener {
            public View$OnClickListenerC1612a() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.f61475h != null) {
                    b.this.f61475h.onClick();
                }
                if (b.this.f61469b == null || b.this.f61469b.d() == null) {
                    return;
                }
                b.this.f61469b.d().a(b.this.f61468a, view);
            }
        }

        public b(String str, a aVar) {
            this.f61473f = str;
            this.f61469b = aVar;
            f();
            e();
        }

        public View d() {
            return this.f61470c;
        }

        public final void e() {
            TextView textView = this.f61471d;
            if (textView != null) {
                textView.setOnClickListener(this.k);
            }
        }

        public final void f() {
            a aVar = this.f61469b;
            if (aVar == null || aVar.c() == null) {
                return;
            }
            View inflate = LayoutInflater.from(this.f61469b.c()).inflate(R.layout.bottom_up_list_dialog_item, this.f61469b.e(), false);
            this.f61470c = inflate;
            TextView textView = (TextView) inflate.findViewById(R.id.item_view);
            this.f61471d = textView;
            textView.setText(this.f61473f);
            this.f61471d.setGravity(this.f61474g);
            View findViewById = this.f61470c.findViewById(R.id.divider_line);
            this.f61472e = findViewById;
            if (this.f61476i) {
                findViewById.setVisibility(0);
            } else {
                findViewById.setVisibility(8);
            }
            g();
        }

        public void g() {
            TextView textView = this.f61471d;
            if (textView != null) {
                if (this.j) {
                    SkinManager.setBackgroundResource(textView, R.drawable.bg_bottom_up_corner_dialog);
                } else {
                    textView.setBackgroundDrawable(SkinManager.getColorDrawableWithClickState(R.color.CAM_X0211));
                }
            }
            SkinManager.setViewTextColor(this.f61471d, R.color.CAM_X0105);
            SkinManager.setBackgroundColor(this.f61472e, R.color.CAM_X0204);
        }

        public void h(d dVar) {
            this.f61475h = dVar;
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
        this.f61458a = context;
        View inflate = LayoutInflater.from(context).inflate(R.layout.bottom_up_list_dialog_view, (ViewGroup) null);
        this.f61459b = inflate;
        this.f61460c = (LinearLayout) inflate.findViewById(R.id.content_view);
        this.f61461d = (TextView) this.f61459b.findViewById(R.id.title);
        this.f61462e = this.f61459b.findViewById(R.id.title_divide_line);
        this.f61465h = new ArrayList();
        this.f61463f = (TextView) this.f61459b.findViewById(R.id.dialog_bottom_cancel_button);
    }

    public View b() {
        if (!StringUtils.isNull(this.f61464g)) {
            this.f61461d.setText(this.f61464g);
            this.f61462e.setVisibility(0);
        } else {
            this.f61461d.setVisibility(8);
            this.f61462e.setVisibility(8);
        }
        if (this.j != null) {
            this.f61463f.setOnClickListener(new View$OnClickListenerC1611a());
        }
        f();
        return this.f61459b;
    }

    public Context c() {
        return this.f61458a;
    }

    public e d() {
        return this.f61466i;
    }

    public ViewGroup e() {
        return this.f61460c;
    }

    public void f() {
        TextView textView;
        SkinManager.setBackgroundColor(this.f61459b, R.color.CAM_X0204);
        SkinManager.setBackgroundResource(this.f61461d, R.drawable.bg_title_corner_dialog_item);
        SkinManager.setViewTextColor(this.f61461d, R.color.CAM_X0108);
        SkinManager.setBackgroundColor(this.f61462e, R.color.CAM_X0204);
        SkinManager.setBackgroundResource(this.f61463f, R.drawable.bg_bottom_up_list_dialog_item);
        SkinManager.setViewTextColor(this.f61463f, R.color.CAM_X0107);
        List<b> list = this.f61465h;
        if (list != null) {
            for (b bVar : list) {
                bVar.g();
            }
        }
        if (this.k) {
            if (!StringUtils.isNull(this.f61464g) && (textView = this.f61461d) != null && (textView.getBackground() instanceof GradientDrawable)) {
                float dimension = c().getResources().getDimension(R.dimen.tbds32);
                ((GradientDrawable) this.f61461d.getBackground()).setCornerRadii(new float[]{dimension, dimension, dimension, dimension, 0.0f, 0.0f, 0.0f, 0.0f});
            } else if (ListUtils.getCount(this.f61465h) > 0) {
                b bVar2 = this.f61465h.get(0);
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
        this.f61465h = list;
        this.f61460c.removeAllViews();
        for (int i2 = 0; i2 < list.size(); i2++) {
            b bVar = list.get(i2);
            if (bVar != null) {
                this.f61460c.addView(bVar.d());
            }
        }
    }

    public void h(c cVar) {
        this.j = cVar;
    }

    public void i(String str) {
        this.f61464g = str;
    }
}
