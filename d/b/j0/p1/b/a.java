package d.b.j0.p1.b;

import android.content.Intent;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tieba.R;
import com.baidu.tieba.majorsearch.SearchMajorActivity;
import com.baidu.tieba.majorsearch.adapter.SearchMajorResultItemAdapter;
import d.b.c.e.p.j;
import d.b.c.e.p.l;
import java.util.List;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public View f59335a;

    /* renamed from: b  reason: collision with root package name */
    public SearchMajorActivity f59336b;

    /* renamed from: c  reason: collision with root package name */
    public d.b.j0.p1.a f59337c;

    /* renamed from: d  reason: collision with root package name */
    public String f59338d;

    /* renamed from: d.b.j0.p1.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class View$OnFocusChangeListenerC1453a implements View.OnFocusChangeListener {
        public View$OnFocusChangeListenerC1453a() {
        }

        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z) {
            if (!z) {
                l.w(a.this.f59336b.getPageContext().getPageActivity(), view);
            } else {
                a.this.k();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements TextView.OnEditorActionListener {
        public b() {
        }

        @Override // android.widget.TextView.OnEditorActionListener
        public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
            if (i == 3) {
                a.this.k();
                return true;
            }
            return false;
        }
    }

    /* loaded from: classes3.dex */
    public class c implements TextWatcher {
        public c() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            if (editable == null) {
                return;
            }
            a.this.f59338d = editable.toString();
            a.this.k();
            a.this.f59337c.k(!StringUtils.isNull(editable.toString()));
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }
    }

    /* loaded from: classes3.dex */
    public class d implements SearchMajorResultItemAdapter.b {
        public d() {
        }

        @Override // com.baidu.tieba.majorsearch.adapter.SearchMajorResultItemAdapter.b
        public void a(String str) {
            Intent intent = new Intent();
            intent.putExtra(IntentConfig.SEARCH_MAJOR_NAME, str);
            a.this.f59336b.finish(intent);
        }
    }

    /* loaded from: classes3.dex */
    public class e extends RecyclerView.OnScrollListener {
        public e() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            if (i == 1 || i == 2) {
                l.w(a.this.f59336b.getPageContext().getPageActivity(), recyclerView);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
        }
    }

    public a(SearchMajorActivity searchMajorActivity) {
        this.f59336b = searchMajorActivity;
        h();
    }

    public void e() {
        View$OnFocusChangeListenerC1453a view$OnFocusChangeListenerC1453a = new View$OnFocusChangeListenerC1453a();
        b bVar = new b();
        c cVar = new c();
        this.f59337c.q(view$OnFocusChangeListenerC1453a);
        this.f59337c.p(bVar);
        this.f59337c.r(cVar);
    }

    public final void f() {
        d dVar = new d();
        e eVar = new e();
        this.f59337c.n(dVar);
        this.f59337c.o(eVar);
    }

    public d.b.j0.p1.a g() {
        return this.f59337c;
    }

    public final void h() {
        View inflate = LayoutInflater.from(this.f59336b).inflate(R.layout.search_major_main, (ViewGroup) null);
        this.f59335a = inflate;
        this.f59336b.setContentView(inflate);
        this.f59337c = new d.b.j0.p1.a(this.f59335a, this.f59336b);
        e();
        f();
        this.f59338d = "";
        k();
    }

    public void i(int i) {
        this.f59337c.i(i);
    }

    public void j() {
        d.b.j0.p1.a aVar = this.f59337c;
        if (aVar != null) {
            aVar.j();
        }
    }

    public final void k() {
        if (this.f59336b == null) {
            return;
        }
        if (j.z()) {
            if (this.f59338d != null) {
                HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_SEARCH_MAJOR);
                httpMessage.addParam("keyword", this.f59338d.trim());
                this.f59336b.sendMessage(httpMessage);
            }
        } else if (this.f59337c != null) {
            m(new ErrorData());
            this.f59336b.getRefreshView().h(R.drawable.new_pic_emotion_05);
            this.f59336b.showNetRefreshViewNoClick(this.f59337c.d(), null);
            this.f59336b.getRefreshView().n(this.f59336b.getString(R.string.im_error_default));
        }
    }

    public void l(List<String> list) {
        d.b.j0.p1.a aVar = this.f59337c;
        if (aVar != null) {
            aVar.l(list, this.f59338d);
        }
    }

    public void m(ErrorData errorData) {
        d.b.j0.p1.a aVar = this.f59337c;
        if (aVar != null) {
            aVar.m(errorData);
        }
    }
}
