package d.a.n0.r0.q1.f;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.view.spanGroup.SpanGroupEditText;
import com.baidu.tieba.R;
import d.a.c.e.p.l;
import d.a.n0.w3.i;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public Context f59454a;

    /* renamed from: b  reason: collision with root package name */
    public View f59455b;

    /* renamed from: c  reason: collision with root package name */
    public View f59456c;

    /* renamed from: d  reason: collision with root package name */
    public View f59457d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f59458e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f59459f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f59460g;

    /* renamed from: h  reason: collision with root package name */
    public ImageView f59461h;

    /* renamed from: i  reason: collision with root package name */
    public EditText f59462i;
    public SpanGroupEditText j;
    public View.OnClickListener k;
    public e l;
    public boolean m;

    /* loaded from: classes4.dex */
    public class a implements TextWatcher {
        public a() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            d.a.n0.r0.q1.f.a.R(b.this.f59458e, editable.toString().length(), 30);
            if (b.this.l != null) {
                b.this.l.a();
            }
            if (b.this.m) {
                d.a.m0.r.u.c.d(b.this.f59462i).s(R.color.CAM_X0105);
                d.a.m0.r.u.c.d(b.this.j).s(R.color.CAM_X0105);
                b.this.m = false;
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }
    }

    /* renamed from: d.a.n0.r0.q1.f.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1541b implements TextWatcher {

        /* renamed from: d.a.n0.r0.q1.f.b$b$a */
        /* loaded from: classes4.dex */
        public class a implements View.OnTouchListener {
            public a(C1541b c1541b) {
            }

            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    view.getParent().requestDisallowInterceptTouchEvent(true);
                } else if (motionEvent.getAction() == 1) {
                    view.getParent().requestDisallowInterceptTouchEvent(false);
                } else if (motionEvent.getAction() == 3) {
                    view.getParent().requestDisallowInterceptTouchEvent(false);
                }
                return false;
            }
        }

        public C1541b() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            d.a.n0.r0.q1.f.a.R(b.this.f59460g, editable.toString().length(), 1000);
            if (b.this.l != null) {
                b.this.l.a();
            }
            if (b.this.m) {
                d.a.m0.r.u.c.d(b.this.f59462i).s(R.color.CAM_X0105);
                d.a.m0.r.u.c.d(b.this.j).s(R.color.CAM_X0105);
                b.this.m = false;
            }
            if (b.this.j.getLineCount() > 6) {
                b.this.j.setOnTouchListener(new a(this));
            } else {
                b.this.j.setOnTouchListener(null);
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }
    }

    /* loaded from: classes4.dex */
    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            l.K(b.this.f59454a, b.this.f59462i);
        }
    }

    /* loaded from: classes4.dex */
    public class d implements View.OnClickListener {
        public d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            l.K(b.this.f59454a, b.this.j);
        }
    }

    /* loaded from: classes4.dex */
    public interface e {
        void a();
    }

    public b(Context context) {
        this.f59454a = context;
        n();
    }

    public final String i(int i2) {
        return d.a.n0.r0.q1.e.a.d(i2 + 1);
    }

    public final void j() {
        if (this.f59455b != null) {
            d.a.m0.r.u.c.d(this.f59456c).f(R.color.CAM_X0204);
            d.a.m0.r.u.c.d(this.f59457d).f(R.color.CAM_X0210);
            d.a.m0.r.u.c d2 = d.a.m0.r.u.c.d(this.f59459f);
            d2.s(R.color.CAM_X0107);
            d2.x(R.string.F_X02);
            d.a.m0.r.u.c.d(this.f59458e).s(R.color.CAM_X0111);
            this.f59461h.setImageDrawable(WebPManager.getPureDrawable(R.drawable.icon_pure_edit_delete16, SkinManager.getColor(R.color.CAM_X0107), WebPManager.ResourceStateType.NORMAL_PRESS));
            this.j.setHintTextColor(SkinManager.getColor(R.color.CAM_X0111));
            this.j.setTextColor(SkinManager.getColor(R.color.CAM_X0105));
            this.f59462i.setTextColor(SkinManager.getColor(R.color.CAM_X0105));
            this.f59462i.setHintTextColor(SkinManager.getColor(R.color.CAM_X0111));
            if (TbadkCoreApplication.getInst().getSkinType() == 0) {
                i.e(this.f59462i, R.drawable.edittext_cursor);
                i.e(this.j, R.drawable.edittext_cursor);
                return;
            }
            i.e(this.f59462i, R.drawable.edittext_cursor_1);
            i.e(this.j, R.drawable.edittext_cursor_1);
        }
    }

    public SpanGroupEditText k() {
        return this.j;
    }

    public EditText l() {
        return this.f59462i;
    }

    public View m() {
        return this.f59455b;
    }

    public final void n() {
        View inflate = LayoutInflater.from(this.f59454a).inflate(R.layout.forum_rule_edit_item, (ViewGroup) null);
        this.f59455b = inflate;
        this.f59456c = inflate.findViewById(R.id.item_divider);
        this.f59459f = (TextView) this.f59455b.findViewById(R.id.item_title_index);
        this.f59461h = (ImageView) this.f59455b.findViewById(R.id.item_del);
        this.f59462i = (EditText) this.f59455b.findViewById(R.id.item_title);
        this.f59458e = (TextView) this.f59455b.findViewById(R.id.item_title_number);
        this.f59457d = this.f59455b.findViewById(R.id.titile_divider);
        this.j = (SpanGroupEditText) this.f59455b.findViewById(R.id.item_content);
        this.f59460g = (TextView) this.f59455b.findViewById(R.id.item_content_number);
        d.a.n0.r0.q1.f.a.R(this.f59458e, 0, 30);
        d.a.n0.r0.q1.f.a.R(this.f59460g, 0, 1000);
        this.f59462i.addTextChangedListener(new a());
        this.j.addTextChangedListener(new C1541b());
        this.f59462i.setOnClickListener(new c());
        this.j.setOnClickListener(new d());
        j();
    }

    public void o(View.OnClickListener onClickListener) {
        this.k = onClickListener;
        this.f59461h.setOnClickListener(onClickListener);
    }

    public void p(e eVar) {
        this.l = eVar;
    }

    public void q(boolean z) {
        ImageView imageView = this.f59461h;
        if (imageView != null) {
            if (z) {
                imageView.setVisibility(0);
            } else {
                imageView.setVisibility(8);
            }
        }
    }

    public void r(boolean z) {
        this.m = z;
    }

    public void s(int i2) {
        Context context;
        EditText editText = this.f59462i;
        if (editText == null || (context = this.f59454a) == null) {
            return;
        }
        editText.setHint(String.format(context.getString(R.string.forum_rule_item_title_hint), i(i2)));
    }

    public void t(int i2) {
        TextView textView = this.f59459f;
        if (textView != null) {
            textView.setText(String.format(this.f59454a.getString(R.string.forum_rule_title_index), i(i2)));
        }
    }
}
