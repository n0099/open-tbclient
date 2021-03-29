package d.b.i0.p0.q1.f;

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
import d.b.b.e.p.l;
import d.b.i0.u3.j;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public Context f58392a;

    /* renamed from: b  reason: collision with root package name */
    public View f58393b;

    /* renamed from: c  reason: collision with root package name */
    public View f58394c;

    /* renamed from: d  reason: collision with root package name */
    public View f58395d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f58396e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f58397f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f58398g;

    /* renamed from: h  reason: collision with root package name */
    public ImageView f58399h;
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
            d.b.i0.p0.q1.f.a.T(b.this.f58396e, editable.toString().length(), 30);
            if (b.this.l != null) {
                b.this.l.a();
            }
            if (b.this.m) {
                d.b.h0.r.u.c.a(b.this.i).n(R.color.CAM_X0105);
                d.b.h0.r.u.c.a(b.this.j).n(R.color.CAM_X0105);
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

    /* renamed from: d.b.i0.p0.q1.f.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1430b implements TextWatcher {

        /* renamed from: d.b.i0.p0.q1.f.b$b$a */
        /* loaded from: classes4.dex */
        public class a implements View.OnTouchListener {
            public a(C1430b c1430b) {
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

        public C1430b() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            d.b.i0.p0.q1.f.a.T(b.this.f58398g, editable.toString().length(), 1000);
            if (b.this.l != null) {
                b.this.l.a();
            }
            if (b.this.m) {
                d.b.h0.r.u.c.a(b.this.i).n(R.color.CAM_X0105);
                d.b.h0.r.u.c.a(b.this.j).n(R.color.CAM_X0105);
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
            l.J(b.this.f58392a, b.this.i);
        }
    }

    /* loaded from: classes4.dex */
    public class d implements View.OnClickListener {
        public d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            l.J(b.this.f58392a, b.this.j);
        }
    }

    /* loaded from: classes4.dex */
    public interface e {
        void a();
    }

    public b(Context context) {
        this.f58392a = context;
        n();
    }

    public final String i(int i) {
        return d.b.i0.p0.q1.e.a.d(i + 1);
    }

    public final void j() {
        if (this.f58393b != null) {
            d.b.h0.r.u.c.a(this.f58394c).c(R.color.CAM_X0204);
            d.b.h0.r.u.c.a(this.f58395d).c(R.color.CAM_X0210);
            d.b.h0.r.u.c a2 = d.b.h0.r.u.c.a(this.f58397f);
            a2.n(R.color.CAM_X0107);
            a2.s(R.string.F_X02);
            d.b.h0.r.u.c.a(this.f58396e).n(R.color.CAM_X0111);
            this.f58399h.setImageDrawable(WebPManager.getPureDrawable(R.drawable.icon_pure_edit_delete16, SkinManager.getColor(R.color.CAM_X0107), WebPManager.ResourceStateType.NORMAL_PRESS));
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
        return this.f58393b;
    }

    public final void n() {
        View inflate = LayoutInflater.from(this.f58392a).inflate(R.layout.forum_rule_edit_item, (ViewGroup) null);
        this.f58393b = inflate;
        this.f58394c = inflate.findViewById(R.id.item_divider);
        this.f58397f = (TextView) this.f58393b.findViewById(R.id.item_title_index);
        this.f58399h = (ImageView) this.f58393b.findViewById(R.id.item_del);
        this.i = (EditText) this.f58393b.findViewById(R.id.item_title);
        this.f58396e = (TextView) this.f58393b.findViewById(R.id.item_title_number);
        this.f58395d = this.f58393b.findViewById(R.id.titile_divider);
        this.j = (SpanGroupEditText) this.f58393b.findViewById(R.id.item_content);
        this.f58398g = (TextView) this.f58393b.findViewById(R.id.item_content_number);
        d.b.i0.p0.q1.f.a.T(this.f58396e, 0, 30);
        d.b.i0.p0.q1.f.a.T(this.f58398g, 0, 1000);
        this.i.addTextChangedListener(new a());
        this.j.addTextChangedListener(new C1430b());
        this.i.setOnClickListener(new c());
        this.j.setOnClickListener(new d());
        j();
    }

    public void o(View.OnClickListener onClickListener) {
        this.k = onClickListener;
        this.f58399h.setOnClickListener(onClickListener);
    }

    public void p(e eVar) {
        this.l = eVar;
    }

    public void q(boolean z) {
        ImageView imageView = this.f58399h;
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
        if (editText == null || (context = this.f58392a) == null) {
            return;
        }
        editText.setHint(String.format(context.getString(R.string.forum_rule_item_title_hint), i(i)));
    }

    public void t(int i) {
        TextView textView = this.f58397f;
        if (textView != null) {
            textView.setText(String.format(this.f58392a.getString(R.string.forum_rule_title_index), i(i)));
        }
    }
}
