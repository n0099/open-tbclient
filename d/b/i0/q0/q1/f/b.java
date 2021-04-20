package d.b.i0.q0.q1.f;

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
import d.b.c.e.p.l;
import d.b.i0.v3.j;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public Context f60054a;

    /* renamed from: b  reason: collision with root package name */
    public View f60055b;

    /* renamed from: c  reason: collision with root package name */
    public View f60056c;

    /* renamed from: d  reason: collision with root package name */
    public View f60057d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f60058e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f60059f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f60060g;

    /* renamed from: h  reason: collision with root package name */
    public ImageView f60061h;
    public EditText i;
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
            d.b.i0.q0.q1.f.a.T(b.this.f60058e, editable.toString().length(), 30);
            if (b.this.l != null) {
                b.this.l.a();
            }
            if (b.this.m) {
                d.b.h0.r.u.c.d(b.this.i).q(R.color.CAM_X0105);
                d.b.h0.r.u.c.d(b.this.j).q(R.color.CAM_X0105);
                b.this.m = false;
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }
    }

    /* renamed from: d.b.i0.q0.q1.f.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1492b implements TextWatcher {

        /* renamed from: d.b.i0.q0.q1.f.b$b$a */
        /* loaded from: classes4.dex */
        public class a implements View.OnTouchListener {
            public a(C1492b c1492b) {
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

        public C1492b() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            d.b.i0.q0.q1.f.a.T(b.this.f60060g, editable.toString().length(), 1000);
            if (b.this.l != null) {
                b.this.l.a();
            }
            if (b.this.m) {
                d.b.h0.r.u.c.d(b.this.i).q(R.color.CAM_X0105);
                d.b.h0.r.u.c.d(b.this.j).q(R.color.CAM_X0105);
                b.this.m = false;
            }
            if (b.this.j.getLineCount() > 6) {
                b.this.j.setOnTouchListener(new a(this));
            } else {
                b.this.j.setOnTouchListener(null);
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }
    }

    /* loaded from: classes4.dex */
    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            l.J(b.this.f60054a, b.this.i);
        }
    }

    /* loaded from: classes4.dex */
    public class d implements View.OnClickListener {
        public d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            l.J(b.this.f60054a, b.this.j);
        }
    }

    /* loaded from: classes4.dex */
    public interface e {
        void a();
    }

    public b(Context context) {
        this.f60054a = context;
        n();
    }

    public final String i(int i) {
        return d.b.i0.q0.q1.e.a.d(i + 1);
    }

    public final void j() {
        if (this.f60055b != null) {
            d.b.h0.r.u.c.d(this.f60056c).f(R.color.CAM_X0204);
            d.b.h0.r.u.c.d(this.f60057d).f(R.color.CAM_X0210);
            d.b.h0.r.u.c d2 = d.b.h0.r.u.c.d(this.f60059f);
            d2.q(R.color.CAM_X0107);
            d2.v(R.string.F_X02);
            d.b.h0.r.u.c.d(this.f60058e).q(R.color.CAM_X0111);
            this.f60061h.setImageDrawable(WebPManager.getPureDrawable(R.drawable.icon_pure_edit_delete16, SkinManager.getColor(R.color.CAM_X0107), WebPManager.ResourceStateType.NORMAL_PRESS));
            this.j.setHintTextColor(SkinManager.getColor(R.color.CAM_X0111));
            this.j.setTextColor(SkinManager.getColor(R.color.CAM_X0105));
            this.i.setTextColor(SkinManager.getColor(R.color.CAM_X0105));
            this.i.setHintTextColor(SkinManager.getColor(R.color.CAM_X0111));
            if (TbadkCoreApplication.getInst().getSkinType() == 0) {
                j.e(this.i, R.drawable.edittext_cursor);
                j.e(this.j, R.drawable.edittext_cursor);
                return;
            }
            j.e(this.i, R.drawable.edittext_cursor_1);
            j.e(this.j, R.drawable.edittext_cursor_1);
        }
    }

    public SpanGroupEditText k() {
        return this.j;
    }

    public EditText l() {
        return this.i;
    }

    public View m() {
        return this.f60055b;
    }

    public final void n() {
        View inflate = LayoutInflater.from(this.f60054a).inflate(R.layout.forum_rule_edit_item, (ViewGroup) null);
        this.f60055b = inflate;
        this.f60056c = inflate.findViewById(R.id.item_divider);
        this.f60059f = (TextView) this.f60055b.findViewById(R.id.item_title_index);
        this.f60061h = (ImageView) this.f60055b.findViewById(R.id.item_del);
        this.i = (EditText) this.f60055b.findViewById(R.id.item_title);
        this.f60058e = (TextView) this.f60055b.findViewById(R.id.item_title_number);
        this.f60057d = this.f60055b.findViewById(R.id.titile_divider);
        this.j = (SpanGroupEditText) this.f60055b.findViewById(R.id.item_content);
        this.f60060g = (TextView) this.f60055b.findViewById(R.id.item_content_number);
        d.b.i0.q0.q1.f.a.T(this.f60058e, 0, 30);
        d.b.i0.q0.q1.f.a.T(this.f60060g, 0, 1000);
        this.i.addTextChangedListener(new a());
        this.j.addTextChangedListener(new C1492b());
        this.i.setOnClickListener(new c());
        this.j.setOnClickListener(new d());
        j();
    }

    public void o(View.OnClickListener onClickListener) {
        this.k = onClickListener;
        this.f60061h.setOnClickListener(onClickListener);
    }

    public void p(e eVar) {
        this.l = eVar;
    }

    public void q(boolean z) {
        ImageView imageView = this.f60061h;
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

    public void s(int i) {
        Context context;
        EditText editText = this.i;
        if (editText == null || (context = this.f60054a) == null) {
            return;
        }
        editText.setHint(String.format(context.getString(R.string.forum_rule_item_title_hint), i(i)));
    }

    public void t(int i) {
        TextView textView = this.f60059f;
        if (textView != null) {
            textView.setText(String.format(this.f60054a.getString(R.string.forum_rule_title_index), i(i)));
        }
    }
}
