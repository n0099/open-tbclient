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
    public EditText f60360a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f60361b;

    /* renamed from: c  reason: collision with root package name */
    public ImageView f60362c;

    /* renamed from: d  reason: collision with root package name */
    public TextWatcher f60363d;

    /* renamed from: e  reason: collision with root package name */
    public c f60364e;

    /* renamed from: f  reason: collision with root package name */
    public Context f60365f;

    /* renamed from: g  reason: collision with root package name */
    public TbPageContext<?> f60366g;

    /* renamed from: h  reason: collision with root package name */
    public View.OnClickListener f60367h = new View$OnClickListenerC1588a();

    /* renamed from: d.a.n0.s.e.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class View$OnClickListenerC1588a implements View.OnClickListener {
        public View$OnClickListenerC1588a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == a.this.f60361b) {
                String charSequence2String = k.charSequence2String(a.this.f60360a.getText(), null);
                if (StringUtils.isNULL(charSequence2String)) {
                    return;
                }
                if (charSequence2String.trim().length() != 0) {
                    a.this.i(charSequence2String.trim());
                    a.this.f60361b.setClickable(false);
                } else if (charSequence2String.length() > 0) {
                    a.this.f60366g.showToast(R.string.input_content);
                }
            } else if (view == a.this.f60362c) {
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
                a.this.f60362c.setVisibility(8);
            } else {
                a.this.f60362c.setVisibility(0);
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
        this.f60366g = tbPageContext;
        this.f60365f = tbPageContext.getPageActivity();
        this.f60360a = (EditText) view.findViewById(R.id.new_search_friend_input);
        this.f60361b = (TextView) view.findViewById(R.id.new_search_friend_search);
        this.f60362c = (ImageView) view.findViewById(R.id.new_search_friend_del);
        this.f60361b.setOnClickListener(this.f60367h);
        this.f60362c.setOnClickListener(this.f60367h);
        b bVar = new b();
        this.f60363d = bVar;
        this.f60360a.addTextChangedListener(bVar);
        f(TbadkCoreApplication.getInst().getSkinType());
    }

    public void f(int i2) {
        SkinManager.setViewTextColor(this.f60361b, R.color.CAM_X0111, 1);
        this.f60360a.setHintTextColor(SkinManager.getColor(R.color.CAM_X0110));
        SkinManager.setImageResource(this.f60362c, R.drawable.icon_search_close);
    }

    public void g() {
        l.x(this.f60365f, this.f60360a);
    }

    public void h() {
        this.f60360a.removeTextChangedListener(this.f60363d);
    }

    public final void i(String str) {
        c cVar = this.f60364e;
        if (cVar != null) {
            cVar.a(str);
        }
    }

    public void j(boolean z) {
        this.f60361b.setClickable(z);
    }

    public void k(String str) {
        this.f60360a.setText(str);
    }

    public void l(c cVar) {
        this.f60364e = cVar;
    }
}
