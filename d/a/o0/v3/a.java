package d.a.o0.v3;

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
    public Context f66179a;

    /* renamed from: b  reason: collision with root package name */
    public View f66180b;

    /* renamed from: c  reason: collision with root package name */
    public LinearLayout f66181c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f66182d;

    /* renamed from: e  reason: collision with root package name */
    public View f66183e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f66184f;

    /* renamed from: g  reason: collision with root package name */
    public String f66185g;

    /* renamed from: h  reason: collision with root package name */
    public List<b> f66186h;

    /* renamed from: i  reason: collision with root package name */
    public e f66187i;
    public c j;
    public boolean k;

    /* renamed from: d.a.o0.v3.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class View$OnClickListenerC1750a implements View.OnClickListener {
        public View$OnClickListenerC1750a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.j.onClick();
        }
    }

    /* loaded from: classes5.dex */
    public static class b {

        /* renamed from: b  reason: collision with root package name */
        public a f66190b;

        /* renamed from: c  reason: collision with root package name */
        public View f66191c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f66192d;

        /* renamed from: e  reason: collision with root package name */
        public View f66193e;

        /* renamed from: f  reason: collision with root package name */
        public String f66194f;

        /* renamed from: h  reason: collision with root package name */
        public d f66196h;
        public boolean j;

        /* renamed from: g  reason: collision with root package name */
        public int f66195g = 17;

        /* renamed from: i  reason: collision with root package name */
        public boolean f66197i = true;
        public final View.OnClickListener k = new View$OnClickListenerC1751a();

        /* renamed from: a  reason: collision with root package name */
        public int f66189a = hashCode();

        /* renamed from: d.a.o0.v3.a$b$a  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public class View$OnClickListenerC1751a implements View.OnClickListener {
            public View$OnClickListenerC1751a() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.f66196h != null) {
                    b.this.f66196h.onClick();
                }
                if (b.this.f66190b == null || b.this.f66190b.d() == null) {
                    return;
                }
                b.this.f66190b.d().a(b.this.f66189a, view);
            }
        }

        public b(String str, a aVar) {
            this.f66194f = str;
            this.f66190b = aVar;
            f();
            e();
        }

        public View d() {
            return this.f66191c;
        }

        public final void e() {
            TextView textView = this.f66192d;
            if (textView != null) {
                textView.setOnClickListener(this.k);
            }
        }

        public final void f() {
            a aVar = this.f66190b;
            if (aVar == null || aVar.c() == null) {
                return;
            }
            View inflate = LayoutInflater.from(this.f66190b.c()).inflate(R.layout.bottom_up_list_dialog_item, this.f66190b.e(), false);
            this.f66191c = inflate;
            TextView textView = (TextView) inflate.findViewById(R.id.item_view);
            this.f66192d = textView;
            textView.setText(this.f66194f);
            this.f66192d.setGravity(this.f66195g);
            View findViewById = this.f66191c.findViewById(R.id.divider_line);
            this.f66193e = findViewById;
            if (this.f66197i) {
                findViewById.setVisibility(0);
            } else {
                findViewById.setVisibility(8);
            }
            g();
        }

        public void g() {
            TextView textView = this.f66192d;
            if (textView != null) {
                if (this.j) {
                    SkinManager.setBackgroundResource(textView, R.drawable.bg_bottom_up_corner_dialog);
                } else {
                    textView.setBackgroundDrawable(SkinManager.getColorDrawableWithClickState(R.color.CAM_X0211));
                }
            }
            SkinManager.setViewTextColor(this.f66192d, R.color.CAM_X0105);
            SkinManager.setBackgroundColor(this.f66193e, R.color.CAM_X0204);
        }

        public void h(d dVar) {
            this.f66196h = dVar;
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
        this.f66179a = context;
        View inflate = LayoutInflater.from(context).inflate(R.layout.bottom_up_list_dialog_view, (ViewGroup) null);
        this.f66180b = inflate;
        this.f66181c = (LinearLayout) inflate.findViewById(R.id.content_view);
        this.f66182d = (TextView) this.f66180b.findViewById(R.id.title);
        this.f66183e = this.f66180b.findViewById(R.id.title_divide_line);
        this.f66186h = new ArrayList();
        this.f66184f = (TextView) this.f66180b.findViewById(R.id.dialog_bottom_cancel_button);
    }

    public View b() {
        if (!StringUtils.isNull(this.f66185g)) {
            this.f66182d.setText(this.f66185g);
            this.f66183e.setVisibility(0);
        } else {
            this.f66182d.setVisibility(8);
            this.f66183e.setVisibility(8);
        }
        if (this.j != null) {
            this.f66184f.setOnClickListener(new View$OnClickListenerC1750a());
        }
        f();
        return this.f66180b;
    }

    public Context c() {
        return this.f66179a;
    }

    public e d() {
        return this.f66187i;
    }

    public ViewGroup e() {
        return this.f66181c;
    }

    public void f() {
        TextView textView;
        SkinManager.setBackgroundColor(this.f66180b, R.color.CAM_X0204);
        SkinManager.setBackgroundResource(this.f66182d, R.drawable.bg_title_corner_dialog_item);
        SkinManager.setViewTextColor(this.f66182d, R.color.CAM_X0108);
        SkinManager.setBackgroundColor(this.f66183e, R.color.CAM_X0204);
        SkinManager.setBackgroundResource(this.f66184f, R.drawable.bg_bottom_up_list_dialog_item);
        SkinManager.setViewTextColor(this.f66184f, R.color.CAM_X0107);
        List<b> list = this.f66186h;
        if (list != null) {
            for (b bVar : list) {
                bVar.g();
            }
        }
        if (this.k) {
            if (!StringUtils.isNull(this.f66185g) && (textView = this.f66182d) != null && (textView.getBackground() instanceof GradientDrawable)) {
                float dimension = c().getResources().getDimension(R.dimen.tbds32);
                ((GradientDrawable) this.f66182d.getBackground()).setCornerRadii(new float[]{dimension, dimension, dimension, dimension, 0.0f, 0.0f, 0.0f, 0.0f});
            } else if (ListUtils.getCount(this.f66186h) > 0) {
                b bVar2 = this.f66186h.get(0);
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
        this.f66186h = list;
        this.f66181c.removeAllViews();
        for (int i2 = 0; i2 < list.size(); i2++) {
            b bVar = list.get(i2);
            if (bVar != null) {
                this.f66181c.addView(bVar.d());
            }
        }
    }

    public void h(c cVar) {
        this.j = cVar;
    }

    public void i(String str) {
        this.f66185g = str;
    }
}
