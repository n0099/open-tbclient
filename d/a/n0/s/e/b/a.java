package d.a.n0.s.e.b;

import android.content.Context;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import d.a.c.e.p.k;
import d.a.c.e.p.l;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public EditText f64049a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f64050b;

    /* renamed from: c  reason: collision with root package name */
    public ImageView f64051c;

    /* renamed from: d  reason: collision with root package name */
    public TextWatcher f64052d;

    /* renamed from: e  reason: collision with root package name */
    public c f64053e;

    /* renamed from: f  reason: collision with root package name */
    public Context f64054f;

    /* renamed from: g  reason: collision with root package name */
    public TbPageContext<?> f64055g;

    /* renamed from: h  reason: collision with root package name */
    public View.OnClickListener f64056h = new View$OnClickListenerC1644a();

    /* renamed from: d.a.n0.s.e.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class View$OnClickListenerC1644a implements View.OnClickListener {
        public View$OnClickListenerC1644a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == a.this.f64050b) {
                String charSequence2String = k.charSequence2String(a.this.f64049a.getText(), null);
                if (StringUtils.isNULL(charSequence2String)) {
                    return;
                }
                if (charSequence2String.trim().length() != 0) {
                    a.this.i(charSequence2String.trim());
                    a.this.f64050b.setClickable(false);
                } else if (charSequence2String.length() > 0) {
                    a.this.f64055g.showToast(R.string.input_content);
                }
            } else if (view == a.this.f64051c) {
                a.this.k("");
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements TextWatcher {
        public b() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            if (TextUtils.isEmpty(editable)) {
                a.this.f64051c.setVisibility(8);
            } else {
                a.this.f64051c.setVisibility(0);
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
    public interface c {
        void a(String str);
    }

    public a(TbPageContext<?> tbPageContext, View view) {
        this.f64055g = tbPageContext;
        this.f64054f = tbPageContext.getPageActivity();
        this.f64049a = (EditText) view.findViewById(R.id.new_search_friend_input);
        this.f64050b = (TextView) view.findViewById(R.id.new_search_friend_search);
        this.f64051c = (ImageView) view.findViewById(R.id.new_search_friend_del);
        this.f64050b.setOnClickListener(this.f64056h);
        this.f64051c.setOnClickListener(this.f64056h);
        b bVar = new b();
        this.f64052d = bVar;
        this.f64049a.addTextChangedListener(bVar);
        f(TbadkCoreApplication.getInst().getSkinType());
    }

    public void f(int i2) {
        SkinManager.setViewTextColor(this.f64050b, R.color.CAM_X0111, 1);
        this.f64049a.setHintTextColor(SkinManager.getColor(R.color.CAM_X0110));
        SkinManager.setImageResource(this.f64051c, R.drawable.icon_search_close);
    }

    public void g() {
        l.x(this.f64054f, this.f64049a);
    }

    public void h() {
        this.f64049a.removeTextChangedListener(this.f64052d);
    }

    public final void i(String str) {
        c cVar = this.f64053e;
        if (cVar != null) {
            cVar.a(str);
        }
    }

    public void j(boolean z) {
        this.f64050b.setClickable(z);
    }

    public void k(String str) {
        this.f64049a.setText(str);
    }

    public void l(c cVar) {
        this.f64053e = cVar;
    }
}
