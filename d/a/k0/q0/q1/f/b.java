package d.a.k0.q0.q1.f;

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
import d.a.k0.v3.i;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public Context f59313a;

    /* renamed from: b  reason: collision with root package name */
    public View f59314b;

    /* renamed from: c  reason: collision with root package name */
    public View f59315c;

    /* renamed from: d  reason: collision with root package name */
    public View f59316d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f59317e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f59318f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f59319g;

    /* renamed from: h  reason: collision with root package name */
    public ImageView f59320h;

    /* renamed from: i  reason: collision with root package name */
    public EditText f59321i;
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
            d.a.k0.q0.q1.f.a.R(b.this.f59317e, editable.toString().length(), 30);
            if (b.this.l != null) {
                b.this.l.a();
            }
            if (b.this.m) {
                d.a.j0.r.u.c.d(b.this.f59321i).q(R.color.CAM_X0105);
                d.a.j0.r.u.c.d(b.this.j).q(R.color.CAM_X0105);
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

    /* renamed from: d.a.k0.q0.q1.f.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1528b implements TextWatcher {

        /* renamed from: d.a.k0.q0.q1.f.b$b$a */
        /* loaded from: classes4.dex */
        public class a implements View.OnTouchListener {
            public a(C1528b c1528b) {
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

        public C1528b() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            d.a.k0.q0.q1.f.a.R(b.this.f59319g, editable.toString().length(), 1000);
            if (b.this.l != null) {
                b.this.l.a();
            }
            if (b.this.m) {
                d.a.j0.r.u.c.d(b.this.f59321i).q(R.color.CAM_X0105);
                d.a.j0.r.u.c.d(b.this.j).q(R.color.CAM_X0105);
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
            l.K(b.this.f59313a, b.this.f59321i);
        }
    }

    /* loaded from: classes4.dex */
    public class d implements View.OnClickListener {
        public d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            l.K(b.this.f59313a, b.this.j);
        }
    }

    /* loaded from: classes4.dex */
    public interface e {
        void a();
    }

    public b(Context context) {
        this.f59313a = context;
        n();
    }

    public final String i(int i2) {
        return d.a.k0.q0.q1.e.a.d(i2 + 1);
    }

    public final void j() {
        if (this.f59314b != null) {
            d.a.j0.r.u.c.d(this.f59315c).f(R.color.CAM_X0204);
            d.a.j0.r.u.c.d(this.f59316d).f(R.color.CAM_X0210);
            d.a.j0.r.u.c d2 = d.a.j0.r.u.c.d(this.f59318f);
            d2.q(R.color.CAM_X0107);
            d2.v(R.string.F_X02);
            d.a.j0.r.u.c.d(this.f59317e).q(R.color.CAM_X0111);
            this.f59320h.setImageDrawable(WebPManager.getPureDrawable(R.drawable.icon_pure_edit_delete16, SkinManager.getColor(R.color.CAM_X0107), WebPManager.ResourceStateType.NORMAL_PRESS));
            this.j.setHintTextColor(SkinManager.getColor(R.color.CAM_X0111));
            this.j.setTextColor(SkinManager.getColor(R.color.CAM_X0105));
            this.f59321i.setTextColor(SkinManager.getColor(R.color.CAM_X0105));
            this.f59321i.setHintTextColor(SkinManager.getColor(R.color.CAM_X0111));
            if (TbadkCoreApplication.getInst().getSkinType() == 0) {
                i.e(this.f59321i, R.drawable.edittext_cursor);
                i.e(this.j, R.drawable.edittext_cursor);
                return;
            }
            i.e(this.f59321i, R.drawable.edittext_cursor_1);
            i.e(this.j, R.drawable.edittext_cursor_1);
        }
    }

    public SpanGroupEditText k() {
        return this.j;
    }

    public EditText l() {
        return this.f59321i;
    }

    public View m() {
        return this.f59314b;
    }

    public final void n() {
        View inflate = LayoutInflater.from(this.f59313a).inflate(R.layout.forum_rule_edit_item, (ViewGroup) null);
        this.f59314b = inflate;
        this.f59315c = inflate.findViewById(R.id.item_divider);
        this.f59318f = (TextView) this.f59314b.findViewById(R.id.item_title_index);
        this.f59320h = (ImageView) this.f59314b.findViewById(R.id.item_del);
        this.f59321i = (EditText) this.f59314b.findViewById(R.id.item_title);
        this.f59317e = (TextView) this.f59314b.findViewById(R.id.item_title_number);
        this.f59316d = this.f59314b.findViewById(R.id.titile_divider);
        this.j = (SpanGroupEditText) this.f59314b.findViewById(R.id.item_content);
        this.f59319g = (TextView) this.f59314b.findViewById(R.id.item_content_number);
        d.a.k0.q0.q1.f.a.R(this.f59317e, 0, 30);
        d.a.k0.q0.q1.f.a.R(this.f59319g, 0, 1000);
        this.f59321i.addTextChangedListener(new a());
        this.j.addTextChangedListener(new C1528b());
        this.f59321i.setOnClickListener(new c());
        this.j.setOnClickListener(new d());
        j();
    }

    public void o(View.OnClickListener onClickListener) {
        this.k = onClickListener;
        this.f59320h.setOnClickListener(onClickListener);
    }

    public void p(e eVar) {
        this.l = eVar;
    }

    public void q(boolean z) {
        ImageView imageView = this.f59320h;
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
        EditText editText = this.f59321i;
        if (editText == null || (context = this.f59313a) == null) {
            return;
        }
        editText.setHint(String.format(context.getString(R.string.forum_rule_item_title_hint), i(i2)));
    }

    public void t(int i2) {
        TextView textView = this.f59318f;
        if (textView != null) {
            textView.setText(String.format(this.f59313a.getString(R.string.forum_rule_title_index), i(i2)));
        }
    }
}
