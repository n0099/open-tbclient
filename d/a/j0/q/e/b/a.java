package d.a.j0.q.e.b;

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
    public EditText f57455a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f57456b;

    /* renamed from: c  reason: collision with root package name */
    public ImageView f57457c;

    /* renamed from: d  reason: collision with root package name */
    public TextWatcher f57458d;

    /* renamed from: e  reason: collision with root package name */
    public c f57459e;

    /* renamed from: f  reason: collision with root package name */
    public Context f57460f;

    /* renamed from: g  reason: collision with root package name */
    public TbPageContext<?> f57461g;

    /* renamed from: h  reason: collision with root package name */
    public View.OnClickListener f57462h = new View$OnClickListenerC1398a();

    /* renamed from: d.a.j0.q.e.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class View$OnClickListenerC1398a implements View.OnClickListener {
        public View$OnClickListenerC1398a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == a.this.f57456b) {
                String charSequence2String = k.charSequence2String(a.this.f57455a.getText(), null);
                if (StringUtils.isNULL(charSequence2String)) {
                    return;
                }
                if (charSequence2String.trim().length() != 0) {
                    a.this.i(charSequence2String.trim());
                    a.this.f57456b.setClickable(false);
                } else if (charSequence2String.length() > 0) {
                    a.this.f57461g.showToast(R.string.input_content);
                }
            } else if (view == a.this.f57457c) {
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
                a.this.f57457c.setVisibility(8);
            } else {
                a.this.f57457c.setVisibility(0);
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
        this.f57461g = tbPageContext;
        this.f57460f = tbPageContext.getPageActivity();
        this.f57455a = (EditText) view.findViewById(R.id.new_search_friend_input);
        this.f57456b = (TextView) view.findViewById(R.id.new_search_friend_search);
        this.f57457c = (ImageView) view.findViewById(R.id.new_search_friend_del);
        this.f57456b.setOnClickListener(this.f57462h);
        this.f57457c.setOnClickListener(this.f57462h);
        b bVar = new b();
        this.f57458d = bVar;
        this.f57455a.addTextChangedListener(bVar);
        f(TbadkCoreApplication.getInst().getSkinType());
    }

    public void f(int i2) {
        SkinManager.setViewTextColor(this.f57456b, R.color.CAM_X0111, 1);
        this.f57455a.setHintTextColor(SkinManager.getColor(R.color.CAM_X0110));
        SkinManager.setImageResource(this.f57457c, R.drawable.icon_search_close);
    }

    public void g() {
        l.x(this.f57460f, this.f57455a);
    }

    public void h() {
        this.f57455a.removeTextChangedListener(this.f57458d);
    }

    public final void i(String str) {
        c cVar = this.f57459e;
        if (cVar != null) {
            cVar.a(str);
        }
    }

    public void j(boolean z) {
        this.f57456b.setClickable(z);
    }

    public void k(String str) {
        this.f57455a.setText(str);
    }

    public void l(c cVar) {
        this.f57459e = cVar;
    }
}
