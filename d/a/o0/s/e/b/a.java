package d.a.o0.s.e.b;

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
    public EditText f64174a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f64175b;

    /* renamed from: c  reason: collision with root package name */
    public ImageView f64176c;

    /* renamed from: d  reason: collision with root package name */
    public TextWatcher f64177d;

    /* renamed from: e  reason: collision with root package name */
    public c f64178e;

    /* renamed from: f  reason: collision with root package name */
    public Context f64179f;

    /* renamed from: g  reason: collision with root package name */
    public TbPageContext<?> f64180g;

    /* renamed from: h  reason: collision with root package name */
    public View.OnClickListener f64181h = new View$OnClickListenerC1648a();

    /* renamed from: d.a.o0.s.e.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class View$OnClickListenerC1648a implements View.OnClickListener {
        public View$OnClickListenerC1648a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == a.this.f64175b) {
                String charSequence2String = k.charSequence2String(a.this.f64174a.getText(), null);
                if (StringUtils.isNULL(charSequence2String)) {
                    return;
                }
                if (charSequence2String.trim().length() != 0) {
                    a.this.i(charSequence2String.trim());
                    a.this.f64175b.setClickable(false);
                } else if (charSequence2String.length() > 0) {
                    a.this.f64180g.showToast(R.string.input_content);
                }
            } else if (view == a.this.f64176c) {
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
                a.this.f64176c.setVisibility(8);
            } else {
                a.this.f64176c.setVisibility(0);
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
        this.f64180g = tbPageContext;
        this.f64179f = tbPageContext.getPageActivity();
        this.f64174a = (EditText) view.findViewById(R.id.new_search_friend_input);
        this.f64175b = (TextView) view.findViewById(R.id.new_search_friend_search);
        this.f64176c = (ImageView) view.findViewById(R.id.new_search_friend_del);
        this.f64175b.setOnClickListener(this.f64181h);
        this.f64176c.setOnClickListener(this.f64181h);
        b bVar = new b();
        this.f64177d = bVar;
        this.f64174a.addTextChangedListener(bVar);
        f(TbadkCoreApplication.getInst().getSkinType());
    }

    public void f(int i2) {
        SkinManager.setViewTextColor(this.f64175b, R.color.CAM_X0111, 1);
        this.f64174a.setHintTextColor(SkinManager.getColor(R.color.CAM_X0110));
        SkinManager.setImageResource(this.f64176c, R.drawable.icon_search_close);
    }

    public void g() {
        l.x(this.f64179f, this.f64174a);
    }

    public void h() {
        this.f64174a.removeTextChangedListener(this.f64177d);
    }

    public final void i(String str) {
        c cVar = this.f64178e;
        if (cVar != null) {
            cVar.a(str);
        }
    }

    public void j(boolean z) {
        this.f64175b.setClickable(z);
    }

    public void k(String str) {
        this.f64174a.setText(str);
    }

    public void l(c cVar) {
        this.f64178e = cVar;
    }
}
