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
    public Context f61127a;

    /* renamed from: b  reason: collision with root package name */
    public View f61128b;

    /* renamed from: c  reason: collision with root package name */
    public LinearLayout f61129c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f61130d;

    /* renamed from: e  reason: collision with root package name */
    public View f61131e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f61132f;

    /* renamed from: g  reason: collision with root package name */
    public String f61133g;

    /* renamed from: h  reason: collision with root package name */
    public List<b> f61134h;
    public e i;
    public c j;
    public boolean k;

    /* renamed from: d.b.i0.t3.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class View$OnClickListenerC1587a implements View.OnClickListener {
        public View$OnClickListenerC1587a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.j.onClick();
        }
    }

    /* loaded from: classes5.dex */
    public static class b {

        /* renamed from: b  reason: collision with root package name */
        public a f61137b;

        /* renamed from: c  reason: collision with root package name */
        public View f61138c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f61139d;

        /* renamed from: e  reason: collision with root package name */
        public View f61140e;

        /* renamed from: f  reason: collision with root package name */
        public String f61141f;

        /* renamed from: h  reason: collision with root package name */
        public d f61143h;
        public boolean j;

        /* renamed from: g  reason: collision with root package name */
        public int f61142g = 17;
        public boolean i = true;
        public final View.OnClickListener k = new View$OnClickListenerC1588a();

        /* renamed from: a  reason: collision with root package name */
        public int f61136a = hashCode();

        /* renamed from: d.b.i0.t3.a$b$a  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public class View$OnClickListenerC1588a implements View.OnClickListener {
            public View$OnClickListenerC1588a() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.f61143h != null) {
                    b.this.f61143h.onClick();
                }
                if (b.this.f61137b == null || b.this.f61137b.d() == null) {
                    return;
                }
                b.this.f61137b.d().a(b.this.f61136a, view);
            }
        }

        public b(String str, a aVar) {
            this.f61141f = str;
            this.f61137b = aVar;
            f();
            e();
        }

        public View d() {
            return this.f61138c;
        }

        public final void e() {
            TextView textView = this.f61139d;
            if (textView != null) {
                textView.setOnClickListener(this.k);
            }
        }

        public final void f() {
            a aVar = this.f61137b;
            if (aVar == null || aVar.c() == null) {
                return;
            }
            View inflate = LayoutInflater.from(this.f61137b.c()).inflate(R.layout.bottom_up_list_dialog_item, this.f61137b.e(), false);
            this.f61138c = inflate;
            TextView textView = (TextView) inflate.findViewById(R.id.item_view);
            this.f61139d = textView;
            textView.setText(this.f61141f);
            this.f61139d.setGravity(this.f61142g);
            View findViewById = this.f61138c.findViewById(R.id.divider_line);
            this.f61140e = findViewById;
            if (this.i) {
                findViewById.setVisibility(0);
            } else {
                findViewById.setVisibility(8);
            }
            g();
        }

        public void g() {
            TextView textView = this.f61139d;
            if (textView != null) {
                if (this.j) {
                    SkinManager.setBackgroundResource(textView, R.drawable.bg_bottom_up_corner_dialog);
                } else {
                    textView.setBackgroundDrawable(SkinManager.getColorDrawableWithClickState(R.color.CAM_X0211));
                }
            }
            SkinManager.setViewTextColor(this.f61139d, R.color.CAM_X0105);
            SkinManager.setBackgroundColor(this.f61140e, R.color.CAM_X0204);
        }

        public void h(d dVar) {
            this.f61143h = dVar;
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
        this.f61127a = context;
        View inflate = LayoutInflater.from(context).inflate(R.layout.bottom_up_list_dialog_view, (ViewGroup) null);
        this.f61128b = inflate;
        this.f61129c = (LinearLayout) inflate.findViewById(R.id.content_view);
        this.f61130d = (TextView) this.f61128b.findViewById(R.id.title);
        this.f61131e = this.f61128b.findViewById(R.id.title_divide_line);
        this.f61134h = new ArrayList();
        this.f61132f = (TextView) this.f61128b.findViewById(R.id.dialog_bottom_cancel_button);
    }

    public View b() {
        if (!StringUtils.isNull(this.f61133g)) {
            this.f61130d.setText(this.f61133g);
            this.f61131e.setVisibility(0);
        } else {
            this.f61130d.setVisibility(8);
            this.f61131e.setVisibility(8);
        }
        if (this.j != null) {
            this.f61132f.setOnClickListener(new View$OnClickListenerC1587a());
        }
        f();
        return this.f61128b;
    }

    public Context c() {
        return this.f61127a;
    }

    public e d() {
        return this.i;
    }

    public ViewGroup e() {
        return this.f61129c;
    }

    public void f() {
        TextView textView;
        SkinManager.setBackgroundColor(this.f61128b, R.color.CAM_X0204);
        SkinManager.setBackgroundResource(this.f61130d, R.drawable.bg_title_corner_dialog_item);
        SkinManager.setViewTextColor(this.f61130d, R.color.CAM_X0108);
        SkinManager.setBackgroundColor(this.f61131e, R.color.CAM_X0204);
        SkinManager.setBackgroundResource(this.f61132f, R.drawable.bg_bottom_up_list_dialog_item);
        SkinManager.setViewTextColor(this.f61132f, R.color.CAM_X0107);
        List<b> list = this.f61134h;
        if (list != null) {
            for (b bVar : list) {
                bVar.g();
            }
        }
        if (this.k) {
            if (!StringUtils.isNull(this.f61133g) && (textView = this.f61130d) != null && (textView.getBackground() instanceof GradientDrawable)) {
                float dimension = c().getResources().getDimension(R.dimen.tbds32);
                ((GradientDrawable) this.f61130d.getBackground()).setCornerRadii(new float[]{dimension, dimension, dimension, dimension, 0.0f, 0.0f, 0.0f, 0.0f});
            } else if (ListUtils.getCount(this.f61134h) > 0) {
                b bVar2 = this.f61134h.get(0);
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
        this.f61134h = list;
        this.f61129c.removeAllViews();
        for (int i = 0; i < list.size(); i++) {
            b bVar = list.get(i);
            if (bVar != null) {
                this.f61129c.addView(bVar.d());
            }
        }
    }

    public void h(c cVar) {
        this.j = cVar;
    }

    public void i(String str) {
        this.f61133g = str;
    }
}
