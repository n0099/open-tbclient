package d.b.i0.q.e.b;

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
    public EditText f58995a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f58996b;

    /* renamed from: c  reason: collision with root package name */
    public ImageView f58997c;

    /* renamed from: d  reason: collision with root package name */
    public TextWatcher f58998d;

    /* renamed from: e  reason: collision with root package name */
    public c f58999e;

    /* renamed from: f  reason: collision with root package name */
    public Context f59000f;

    /* renamed from: g  reason: collision with root package name */
    public TbPageContext<?> f59001g;

    /* renamed from: h  reason: collision with root package name */
    public View.OnClickListener f59002h = new View$OnClickListenerC1436a();

    /* renamed from: d.b.i0.q.e.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class View$OnClickListenerC1436a implements View.OnClickListener {
        public View$OnClickListenerC1436a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == a.this.f58996b) {
                String charSequence2String = k.charSequence2String(a.this.f58995a.getText(), null);
                if (StringUtils.isNULL(charSequence2String)) {
                    return;
                }
                if (charSequence2String.trim().length() != 0) {
                    a.this.i(charSequence2String.trim());
                    a.this.f58996b.setClickable(false);
                } else if (charSequence2String.length() > 0) {
                    a.this.f59001g.showToast(R.string.input_content);
                }
            } else if (view == a.this.f58997c) {
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
                a.this.f58997c.setVisibility(8);
            } else {
                a.this.f58997c.setVisibility(0);
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
        this.f59001g = tbPageContext;
        this.f59000f = tbPageContext.getPageActivity();
        this.f58995a = (EditText) view.findViewById(R.id.new_search_friend_input);
        this.f58996b = (TextView) view.findViewById(R.id.new_search_friend_search);
        this.f58997c = (ImageView) view.findViewById(R.id.new_search_friend_del);
        this.f58996b.setOnClickListener(this.f59002h);
        this.f58997c.setOnClickListener(this.f59002h);
        b bVar = new b();
        this.f58998d = bVar;
        this.f58995a.addTextChangedListener(bVar);
        f(TbadkCoreApplication.getInst().getSkinType());
    }

    public void f(int i) {
        SkinManager.setViewTextColor(this.f58996b, R.color.CAM_X0111, 1);
        this.f58995a.setHintTextColor(SkinManager.getColor(R.color.CAM_X0110));
        SkinManager.setImageResource(this.f58997c, R.drawable.icon_search_close);
    }

    public void g() {
        l.w(this.f59000f, this.f58995a);
    }

    public void h() {
        this.f58995a.removeTextChangedListener(this.f58998d);
    }

    public final void i(String str) {
        c cVar = this.f58999e;
        if (cVar != null) {
            cVar.a(str);
        }
    }

    public void j(boolean z) {
        this.f58996b.setClickable(z);
    }

    public void k(String str) {
        this.f58995a.setText(str);
    }

    public void l(c cVar) {
        this.f58999e = cVar;
    }
}
