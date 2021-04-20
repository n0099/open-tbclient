package d.b.h0.r.s;

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
    public Context f51432a;

    /* renamed from: b  reason: collision with root package name */
    public RoundLinearLayout f51433b;

    /* renamed from: c  reason: collision with root package name */
    public LinearLayout f51434c;

    /* renamed from: d  reason: collision with root package name */
    public LinearLayout f51435d;

    /* renamed from: e  reason: collision with root package name */
    public EMTextView f51436e;

    /* renamed from: f  reason: collision with root package name */
    public View f51437f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f51438g;

    /* renamed from: h  reason: collision with root package name */
    public View f51439h;
    public String i;
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
        void onItemClick(l lVar, int i, View view);
    }

    public l(Context context) {
        if (context == null) {
            return;
        }
        this.f51432a = context;
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
        this.f51434c.removeAllViews();
        this.f51435d.removeAllViews();
        if (list.size() < 2) {
            z = false;
        } else {
            z = ((h) list.get(0)).f() == -1;
            if (((h) list.get(1)).f() == -2) {
                z2 = true;
                this.f51437f.setVisibility(!z ? 0 : 8);
                int i = z ? 0 : z2 ? 4 : 3;
                boolean z3 = list.size() - i > 4;
                for (int i2 = 0; i2 < list.size(); i2++) {
                    h hVar = (h) list.get(i2);
                    hVar.k(z3);
                    hVar.e();
                    if (hVar != null) {
                        if (i2 < i) {
                            this.f51434c.addView(hVar.getView());
                        } else {
                            this.f51435d.addView(hVar.getView());
                        }
                    }
                }
            }
        }
        z2 = false;
        this.f51437f.setVisibility(!z ? 0 : 8);
        if (z) {
        }
        if (list.size() - i > 4) {
        }
        while (i2 < list.size()) {
        }
    }

    public View c() {
        p();
        if (this.m != null) {
            this.f51438g.setOnClickListener(new b());
        }
        j();
        return this.f51433b;
    }

    public Context d() {
        return this.f51432a;
    }

    public e e() {
        return this.l;
    }

    public View f() {
        return this.f51433b;
    }

    public ViewGroup g() {
        return this.f51434c;
    }

    public final void h() {
        RoundLinearLayout roundLinearLayout = (RoundLinearLayout) LayoutInflater.from(this.f51432a).inflate(R.layout.popup_dialog_view, (ViewGroup) null);
        this.f51433b = roundLinearLayout;
        d.b.h0.r.u.c d2 = d.b.h0.r.u.c.d(roundLinearLayout);
        d2.k(R.string.J_X14);
        d2.f(R.color.CAM_X0204);
        this.f51434c = (LinearLayout) this.f51433b.findViewById(R.id.content_view);
        this.f51436e = (EMTextView) this.f51433b.findViewById(R.id.title);
        View findViewById = this.f51433b.findViewById(R.id.title_divide_line);
        this.f51437f = findViewById;
        findViewById.setVisibility(8);
        this.f51439h = this.f51433b.findViewById(R.id.dialog_header);
        this.k = new ArrayList();
        this.f51438g = (TextView) this.f51433b.findViewById(R.id.dialog_bottom_cancel_button);
    }

    public final void i() {
        this.n = true;
        RoundLinearLayout roundLinearLayout = (RoundLinearLayout) LayoutInflater.from(this.f51432a).inflate(R.layout.popup_dialog_view_horizal, (ViewGroup) null);
        this.f51433b = roundLinearLayout;
        d.b.h0.r.u.c d2 = d.b.h0.r.u.c.d(roundLinearLayout);
        d2.k(R.string.J_X14);
        d2.f(R.color.CAM_X0204);
        this.f51434c = (LinearLayout) this.f51433b.findViewById(R.id.content_view);
        this.f51435d = (LinearLayout) this.f51433b.findViewById(R.id.content_view_second);
        this.f51436e = (EMTextView) this.f51433b.findViewById(R.id.title);
        View findViewById = this.f51433b.findViewById(R.id.title_divide_line);
        this.f51437f = findViewById;
        findViewById.setVisibility(8);
        this.f51439h = this.f51433b.findViewById(R.id.dialog_header);
        this.k = new ArrayList();
        this.f51438g = (TextView) this.f51433b.findViewById(R.id.dialog_bottom_cancel_button);
        int k = (d.b.c.e.p.l.k(this.f51432a) - (h.q * 4)) / 2;
        ((LinearLayout.LayoutParams) this.f51434c.getLayoutParams()).leftMargin = k;
        ((LinearLayout.LayoutParams) this.f51434c.getLayoutParams()).rightMargin = k;
        ((FrameLayout.LayoutParams) this.f51435d.getLayoutParams()).leftMargin = k;
        ((FrameLayout.LayoutParams) this.f51435d.getLayoutParams()).rightMargin = k;
    }

    public void j() {
        if (this.n) {
            SkinManager.setBackgroundColor(this.f51437f, R.color.CAM_X0203);
        } else {
            SkinManager.setViewTextColor(this.f51436e, R.color.CAM_X0109);
            SkinManager.setBackgroundColor(this.f51437f, R.color.CAM_X0204);
        }
        SkinManager.setBackgroundResource(this.f51436e, R.color.CAM_X0209);
        SkinManager.setBackgroundResource(this.f51439h, R.color.CAM_X0209);
        SkinManager.setBackgroundResource(this.f51438g, R.color.CAM_X0204);
        SkinManager.setViewTextColorSelector(this.f51438g, R.color.CAM_X0107);
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
        this.f51434c.removeAllViews();
        for (int i = 0; i < list.size(); i++) {
            k kVar = list.get(i);
            if (kVar != null) {
                this.f51434c.addView(kVar.getView());
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
        if (cVar == null || (textView = this.f51438g) == null) {
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
        if (!StringUtils.isNull(this.i)) {
            this.f51436e.setVisibility(0);
            this.f51436e.setText(this.i);
        } else if (this.j != null) {
            this.f51436e.setVisibility(0);
            this.f51436e.setText(this.j);
        }
    }

    public void q(String str) {
        this.i = str;
    }
}
