package d.a.o0.r0.q1.f;

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
import d.a.o0.w3.i;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public Context f63270a;

    /* renamed from: b  reason: collision with root package name */
    public View f63271b;

    /* renamed from: c  reason: collision with root package name */
    public View f63272c;

    /* renamed from: d  reason: collision with root package name */
    public View f63273d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f63274e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f63275f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f63276g;

    /* renamed from: h  reason: collision with root package name */
    public ImageView f63277h;

    /* renamed from: i  reason: collision with root package name */
    public EditText f63278i;
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
            d.a.o0.r0.q1.f.a.R(b.this.f63274e, editable.toString().length(), 30);
            if (b.this.l != null) {
                b.this.l.a();
            }
            if (b.this.m) {
                d.a.n0.r.u.c.d(b.this.f63278i).s(R.color.CAM_X0105);
                d.a.n0.r.u.c.d(b.this.j).s(R.color.CAM_X0105);
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

    /* renamed from: d.a.o0.r0.q1.f.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1601b implements TextWatcher {

        /* renamed from: d.a.o0.r0.q1.f.b$b$a */
        /* loaded from: classes4.dex */
        public class a implements View.OnTouchListener {
            public a(C1601b c1601b) {
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

        public C1601b() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            d.a.o0.r0.q1.f.a.R(b.this.f63276g, editable.toString().length(), 1000);
            if (b.this.l != null) {
                b.this.l.a();
            }
            if (b.this.m) {
                d.a.n0.r.u.c.d(b.this.f63278i).s(R.color.CAM_X0105);
                d.a.n0.r.u.c.d(b.this.j).s(R.color.CAM_X0105);
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
            l.K(b.this.f63270a, b.this.f63278i);
        }
    }

    /* loaded from: classes4.dex */
    public class d implements View.OnClickListener {
        public d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            l.K(b.this.f63270a, b.this.j);
        }
    }

    /* loaded from: classes4.dex */
    public interface e {
        void a();
    }

    public b(Context context) {
        this.f63270a = context;
        n();
    }

    public final String i(int i2) {
        return d.a.o0.r0.q1.e.a.d(i2 + 1);
    }

    public final void j() {
        if (this.f63271b != null) {
            d.a.n0.r.u.c.d(this.f63272c).f(R.color.CAM_X0204);
            d.a.n0.r.u.c.d(this.f63273d).f(R.color.CAM_X0210);
            d.a.n0.r.u.c d2 = d.a.n0.r.u.c.d(this.f63275f);
            d2.s(R.color.CAM_X0107);
            d2.x(R.string.F_X02);
            d.a.n0.r.u.c.d(this.f63274e).s(R.color.CAM_X0111);
            this.f63277h.setImageDrawable(WebPManager.getPureDrawable(R.drawable.icon_pure_edit_delete16, SkinManager.getColor(R.color.CAM_X0107), WebPManager.ResourceStateType.NORMAL_PRESS));
            this.j.setHintTextColor(SkinManager.getColor(R.color.CAM_X0111));
            this.j.setTextColor(SkinManager.getColor(R.color.CAM_X0105));
            this.f63278i.setTextColor(SkinManager.getColor(R.color.CAM_X0105));
            this.f63278i.setHintTextColor(SkinManager.getColor(R.color.CAM_X0111));
            if (TbadkCoreApplication.getInst().getSkinType() == 0) {
                i.e(this.f63278i, R.drawable.edittext_cursor);
                i.e(this.j, R.drawable.edittext_cursor);
                return;
            }
            i.e(this.f63278i, R.drawable.edittext_cursor_1);
            i.e(this.j, R.drawable.edittext_cursor_1);
        }
    }

    public SpanGroupEditText k() {
        return this.j;
    }

    public EditText l() {
        return this.f63278i;
    }

    public View m() {
        return this.f63271b;
    }

    public final void n() {
        View inflate = LayoutInflater.from(this.f63270a).inflate(R.layout.forum_rule_edit_item, (ViewGroup) null);
        this.f63271b = inflate;
        this.f63272c = inflate.findViewById(R.id.item_divider);
        this.f63275f = (TextView) this.f63271b.findViewById(R.id.item_title_index);
        this.f63277h = (ImageView) this.f63271b.findViewById(R.id.item_del);
        this.f63278i = (EditText) this.f63271b.findViewById(R.id.item_title);
        this.f63274e = (TextView) this.f63271b.findViewById(R.id.item_title_number);
        this.f63273d = this.f63271b.findViewById(R.id.titile_divider);
        this.j = (SpanGroupEditText) this.f63271b.findViewById(R.id.item_content);
        this.f63276g = (TextView) this.f63271b.findViewById(R.id.item_content_number);
        d.a.o0.r0.q1.f.a.R(this.f63274e, 0, 30);
        d.a.o0.r0.q1.f.a.R(this.f63276g, 0, 1000);
        this.f63278i.addTextChangedListener(new a());
        this.j.addTextChangedListener(new C1601b());
        this.f63278i.setOnClickListener(new c());
        this.j.setOnClickListener(new d());
        j();
    }

    public void o(View.OnClickListener onClickListener) {
        this.k = onClickListener;
        this.f63277h.setOnClickListener(onClickListener);
    }

    public void p(e eVar) {
        this.l = eVar;
    }

    public void q(boolean z) {
        ImageView imageView = this.f63277h;
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
        EditText editText = this.f63278i;
        if (editText == null || (context = this.f63270a) == null) {
            return;
        }
        editText.setHint(String.format(context.getString(R.string.forum_rule_item_title_hint), i(i2)));
    }

    public void t(int i2) {
        TextView textView = this.f63275f;
        if (textView != null) {
            textView.setText(String.format(this.f63270a.getString(R.string.forum_rule_title_index), i(i2)));
        }
    }
}
