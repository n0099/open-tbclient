package d.a.k0.q.e.b;

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
    public EditText f58197a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f58198b;

    /* renamed from: c  reason: collision with root package name */
    public ImageView f58199c;

    /* renamed from: d  reason: collision with root package name */
    public TextWatcher f58200d;

    /* renamed from: e  reason: collision with root package name */
    public c f58201e;

    /* renamed from: f  reason: collision with root package name */
    public Context f58202f;

    /* renamed from: g  reason: collision with root package name */
    public TbPageContext<?> f58203g;

    /* renamed from: h  reason: collision with root package name */
    public View.OnClickListener f58204h = new View$OnClickListenerC1472a();

    /* renamed from: d.a.k0.q.e.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class View$OnClickListenerC1472a implements View.OnClickListener {
        public View$OnClickListenerC1472a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == a.this.f58198b) {
                String charSequence2String = k.charSequence2String(a.this.f58197a.getText(), null);
                if (StringUtils.isNULL(charSequence2String)) {
                    return;
                }
                if (charSequence2String.trim().length() != 0) {
                    a.this.i(charSequence2String.trim());
                    a.this.f58198b.setClickable(false);
                } else if (charSequence2String.length() > 0) {
                    a.this.f58203g.showToast(R.string.input_content);
                }
            } else if (view == a.this.f58199c) {
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
                a.this.f58199c.setVisibility(8);
            } else {
                a.this.f58199c.setVisibility(0);
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
        this.f58203g = tbPageContext;
        this.f58202f = tbPageContext.getPageActivity();
        this.f58197a = (EditText) view.findViewById(R.id.new_search_friend_input);
        this.f58198b = (TextView) view.findViewById(R.id.new_search_friend_search);
        this.f58199c = (ImageView) view.findViewById(R.id.new_search_friend_del);
        this.f58198b.setOnClickListener(this.f58204h);
        this.f58199c.setOnClickListener(this.f58204h);
        b bVar = new b();
        this.f58200d = bVar;
        this.f58197a.addTextChangedListener(bVar);
        f(TbadkCoreApplication.getInst().getSkinType());
    }

    public void f(int i2) {
        SkinManager.setViewTextColor(this.f58198b, R.color.CAM_X0111, 1);
        this.f58197a.setHintTextColor(SkinManager.getColor(R.color.CAM_X0110));
        SkinManager.setImageResource(this.f58199c, R.drawable.icon_search_close);
    }

    public void g() {
        l.x(this.f58202f, this.f58197a);
    }

    public void h() {
        this.f58197a.removeTextChangedListener(this.f58200d);
    }

    public final void i(String str) {
        c cVar = this.f58201e;
        if (cVar != null) {
            cVar.a(str);
        }
    }

    public void j(boolean z) {
        this.f58198b.setClickable(z);
    }

    public void k(String str) {
        this.f58197a.setText(str);
    }

    public void l(c cVar) {
        this.f58201e = cVar;
    }
}
