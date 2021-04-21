package d.b.j0.q.e.b;

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
import d.b.c.e.p.k;
import d.b.c.e.p.l;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public EditText f59416a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f59417b;

    /* renamed from: c  reason: collision with root package name */
    public ImageView f59418c;

    /* renamed from: d  reason: collision with root package name */
    public TextWatcher f59419d;

    /* renamed from: e  reason: collision with root package name */
    public c f59420e;

    /* renamed from: f  reason: collision with root package name */
    public Context f59421f;

    /* renamed from: g  reason: collision with root package name */
    public TbPageContext<?> f59422g;

    /* renamed from: h  reason: collision with root package name */
    public View.OnClickListener f59423h = new View$OnClickListenerC1459a();

    /* renamed from: d.b.j0.q.e.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class View$OnClickListenerC1459a implements View.OnClickListener {
        public View$OnClickListenerC1459a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == a.this.f59417b) {
                String charSequence2String = k.charSequence2String(a.this.f59416a.getText(), null);
                if (StringUtils.isNULL(charSequence2String)) {
                    return;
                }
                if (charSequence2String.trim().length() != 0) {
                    a.this.i(charSequence2String.trim());
                    a.this.f59417b.setClickable(false);
                } else if (charSequence2String.length() > 0) {
                    a.this.f59422g.showToast(R.string.input_content);
                }
            } else if (view == a.this.f59418c) {
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
                a.this.f59418c.setVisibility(8);
            } else {
                a.this.f59418c.setVisibility(0);
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
    public interface c {
        void a(String str);
    }

    public a(TbPageContext<?> tbPageContext, View view) {
        this.f59422g = tbPageContext;
        this.f59421f = tbPageContext.getPageActivity();
        this.f59416a = (EditText) view.findViewById(R.id.new_search_friend_input);
        this.f59417b = (TextView) view.findViewById(R.id.new_search_friend_search);
        this.f59418c = (ImageView) view.findViewById(R.id.new_search_friend_del);
        this.f59417b.setOnClickListener(this.f59423h);
        this.f59418c.setOnClickListener(this.f59423h);
        b bVar = new b();
        this.f59419d = bVar;
        this.f59416a.addTextChangedListener(bVar);
        f(TbadkCoreApplication.getInst().getSkinType());
    }

    public void f(int i) {
        SkinManager.setViewTextColor(this.f59417b, R.color.CAM_X0111, 1);
        this.f59416a.setHintTextColor(SkinManager.getColor(R.color.CAM_X0110));
        SkinManager.setImageResource(this.f59418c, R.drawable.icon_search_close);
    }

    public void g() {
        l.w(this.f59421f, this.f59416a);
    }

    public void h() {
        this.f59416a.removeTextChangedListener(this.f59419d);
    }

    public final void i(String str) {
        c cVar = this.f59420e;
        if (cVar != null) {
            cVar.a(str);
        }
    }

    public void j(boolean z) {
        this.f59417b.setClickable(z);
    }

    public void k(String str) {
        this.f59416a.setText(str);
    }

    public void l(c cVar) {
        this.f59420e = cVar;
    }
}
