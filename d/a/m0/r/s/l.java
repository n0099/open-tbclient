package d.a.m0.r.s;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.dialog.RoundLinearLayout;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class l {

    /* renamed from: a  reason: collision with root package name */
    public Context f50277a;

    /* renamed from: b  reason: collision with root package name */
    public RoundLinearLayout f50278b;

    /* renamed from: c  reason: collision with root package name */
    public LinearLayout f50279c;

    /* renamed from: d  reason: collision with root package name */
    public LinearLayout f50280d;

    /* renamed from: e  reason: collision with root package name */
    public EMTextView f50281e;

    /* renamed from: f  reason: collision with root package name */
    public View f50282f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f50283g;

    /* renamed from: h  reason: collision with root package name */
    public View f50284h;

    /* renamed from: i  reason: collision with root package name */
    public String f50285i;
    public SpannableStringBuilder j;
    public List<? extends k> k;
    public e l;
    public c m;
    public boolean n = false;

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            l.this.m.onClick();
        }
    }

    /* loaded from: classes3.dex */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            l.this.m.onClick();
        }
    }

    /* loaded from: classes3.dex */
    public interface c {
        void onClick();
    }

    /* loaded from: classes3.dex */
    public interface d {
        void onClick();
    }

    /* loaded from: classes3.dex */
    public interface e {
        void onItemClick(l lVar, int i2, View view);
    }

    public l(Context context) {
        if (context == null) {
            return;
        }
        this.f50277a = context;
        h();
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0041  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0043  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x005a  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0061  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void b(List<? extends k> list) {
        boolean z;
        boolean z2;
        if (list == null) {
            return;
        }
        i();
        this.k = list;
        this.f50279c.removeAllViews();
        this.f50280d.removeAllViews();
        if (list.size() < 2) {
            z = false;
        } else {
            z = ((h) list.get(0)).f() == -1;
            if (((h) list.get(1)).f() == -2) {
                z2 = true;
                this.f50282f.setVisibility(!z ? 0 : 8);
                int i2 = z ? 0 : z2 ? 4 : 3;
                boolean z3 = list.size() - i2 > 4;
                for (int i3 = 0; i3 < list.size(); i3++) {
                    h hVar = (h) list.get(i3);
                    hVar.k(z3);
                    hVar.e();
                    if (hVar != null) {
                        if (i3 < i2) {
                            this.f50279c.addView(hVar.getView());
                        } else {
                            this.f50280d.addView(hVar.getView());
                        }
                    }
                }
            }
        }
        z2 = false;
        this.f50282f.setVisibility(!z ? 0 : 8);
        if (z) {
        }
        if (list.size() - i2 > 4) {
        }
        while (i3 < list.size()) {
        }
    }

    public View c() {
        p();
        if (this.m != null) {
            this.f50283g.setOnClickListener(new b());
        }
        j();
        return this.f50278b;
    }

    public Context d() {
        return this.f50277a;
    }

    public e e() {
        return this.l;
    }

    public View f() {
        return this.f50278b;
    }

    public ViewGroup g() {
        return this.f50279c;
    }

    public final void h() {
        RoundLinearLayout roundLinearLayout = (RoundLinearLayout) LayoutInflater.from(this.f50277a).inflate(R.layout.popup_dialog_view, (ViewGroup) null);
        this.f50278b = roundLinearLayout;
        d.a.m0.r.u.c d2 = d.a.m0.r.u.c.d(roundLinearLayout);
        d2.m(R.string.J_X14);
        d2.f(R.color.CAM_X0204);
        this.f50279c = (LinearLayout) this.f50278b.findViewById(R.id.content_view);
        this.f50281e = (EMTextView) this.f50278b.findViewById(R.id.title);
        View findViewById = this.f50278b.findViewById(R.id.title_divide_line);
        this.f50282f = findViewById;
        findViewById.setVisibility(8);
        this.f50284h = this.f50278b.findViewById(R.id.dialog_header);
        this.k = new ArrayList();
        this.f50283g = (TextView) this.f50278b.findViewById(R.id.dialog_bottom_cancel_button);
    }

    public final void i() {
        this.n = true;
        RoundLinearLayout roundLinearLayout = (RoundLinearLayout) LayoutInflater.from(this.f50277a).inflate(R.layout.popup_dialog_view_horizal, (ViewGroup) null);
        this.f50278b = roundLinearLayout;
        d.a.m0.r.u.c d2 = d.a.m0.r.u.c.d(roundLinearLayout);
        d2.m(R.string.J_X14);
        d2.f(R.color.CAM_X0204);
        this.f50279c = (LinearLayout) this.f50278b.findViewById(R.id.content_view);
        this.f50280d = (LinearLayout) this.f50278b.findViewById(R.id.content_view_second);
        this.f50281e = (EMTextView) this.f50278b.findViewById(R.id.title);
        View findViewById = this.f50278b.findViewById(R.id.title_divide_line);
        this.f50282f = findViewById;
        findViewById.setVisibility(8);
        this.f50284h = this.f50278b.findViewById(R.id.dialog_header);
        this.k = new ArrayList();
        this.f50283g = (TextView) this.f50278b.findViewById(R.id.dialog_bottom_cancel_button);
        int k = (d.a.c.e.p.l.k(this.f50277a) - (h.q * 4)) / 2;
        ((LinearLayout.LayoutParams) this.f50279c.getLayoutParams()).leftMargin = k;
        ((LinearLayout.LayoutParams) this.f50279c.getLayoutParams()).rightMargin = k;
        ((FrameLayout.LayoutParams) this.f50280d.getLayoutParams()).leftMargin = k;
        ((FrameLayout.LayoutParams) this.f50280d.getLayoutParams()).rightMargin = k;
    }

    public void j() {
        if (this.n) {
            SkinManager.setBackgroundColor(this.f50282f, R.color.CAM_X0203);
        } else {
            SkinManager.setViewTextColor(this.f50281e, R.color.CAM_X0109);
            SkinManager.setBackgroundColor(this.f50282f, R.color.CAM_X0204);
        }
        SkinManager.setBackgroundResource(this.f50281e, R.color.CAM_X0209);
        SkinManager.setBackgroundResource(this.f50284h, R.color.CAM_X0209);
        SkinManager.setBackgroundResource(this.f50283g, R.color.CAM_X0204);
        SkinManager.setViewTextColorSelector(this.f50283g, R.color.CAM_X0107);
        List<? extends k> list = this.k;
        if (list != null) {
            for (k kVar : list) {
                kVar.a();
            }
        }
    }

    public void k(List<? extends k> list) {
        if (list == null) {
            return;
        }
        this.k = list;
        this.f50279c.removeAllViews();
        for (int i2 = 0; i2 < list.size(); i2++) {
            k kVar = list.get(i2);
            if (kVar != null) {
                this.f50279c.addView(kVar.getView());
            }
        }
    }

    public void l(List<? extends k> list, boolean z) {
        if (z) {
            b(list);
        } else {
            k(list);
        }
    }

    public void m(c cVar) {
        TextView textView;
        this.m = cVar;
        if (cVar == null || (textView = this.f50283g) == null) {
            return;
        }
        textView.setOnClickListener(new a());
    }

    public void n(e eVar) {
        this.l = eVar;
    }

    public void o(SpannableStringBuilder spannableStringBuilder) {
        this.j = spannableStringBuilder;
    }

    public void p() {
        if (!StringUtils.isNull(this.f50285i)) {
            this.f50281e.setVisibility(0);
            this.f50281e.setText(this.f50285i);
        } else if (this.j != null) {
            this.f50281e.setVisibility(0);
            this.f50281e.setText(this.j);
        }
    }

    public void q(String str) {
        this.f50285i = str;
    }
}
