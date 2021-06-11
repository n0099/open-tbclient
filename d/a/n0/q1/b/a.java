package d.a.n0.q1.b;

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
import d.a.c.e.p.j;
import d.a.c.e.p.l;
import java.util.List;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public View f62001a;

    /* renamed from: b  reason: collision with root package name */
    public SearchMajorActivity f62002b;

    /* renamed from: c  reason: collision with root package name */
    public d.a.n0.q1.a f62003c;

    /* renamed from: d  reason: collision with root package name */
    public String f62004d;

    /* renamed from: d.a.n0.q1.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class View$OnFocusChangeListenerC1539a implements View.OnFocusChangeListener {
        public View$OnFocusChangeListenerC1539a() {
        }

        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z) {
            if (!z) {
                l.x(a.this.f62002b.getPageContext().getPageActivity(), view);
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
        public boolean onEditorAction(TextView textView, int i2, KeyEvent keyEvent) {
            if (i2 == 3) {
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
            a.this.f62004d = editable.toString();
            a.this.k();
            a.this.f62003c.k(!StringUtils.isNull(editable.toString()));
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
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
            a.this.f62002b.finish(intent);
        }
    }

    /* loaded from: classes3.dex */
    public class e extends RecyclerView.OnScrollListener {
        public e() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
            if (i2 == 1 || i2 == 2) {
                l.x(a.this.f62002b.getPageContext().getPageActivity(), recyclerView);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i2, int i3) {
        }
    }

    public a(SearchMajorActivity searchMajorActivity) {
        this.f62002b = searchMajorActivity;
        h();
    }

    public void e() {
        View$OnFocusChangeListenerC1539a view$OnFocusChangeListenerC1539a = new View$OnFocusChangeListenerC1539a();
        b bVar = new b();
        c cVar = new c();
        this.f62003c.q(view$OnFocusChangeListenerC1539a);
        this.f62003c.p(bVar);
        this.f62003c.r(cVar);
    }

    public final void f() {
        d dVar = new d();
        e eVar = new e();
        this.f62003c.n(dVar);
        this.f62003c.o(eVar);
    }

    public d.a.n0.q1.a g() {
        return this.f62003c;
    }

    public final void h() {
        View inflate = LayoutInflater.from(this.f62002b).inflate(R.layout.search_major_main, (ViewGroup) null);
        this.f62001a = inflate;
        this.f62002b.setContentView(inflate);
        this.f62003c = new d.a.n0.q1.a(this.f62001a, this.f62002b);
        e();
        f();
        this.f62004d = "";
        k();
    }

    public void i(int i2) {
        this.f62003c.i(i2);
    }

    public void j() {
        d.a.n0.q1.a aVar = this.f62003c;
        if (aVar != null) {
            aVar.j();
        }
    }

    public final void k() {
        if (this.f62002b == null) {
            return;
        }
        if (j.z()) {
            if (this.f62004d != null) {
                HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_SEARCH_MAJOR);
                httpMessage.addParam("keyword", this.f62004d.trim());
                this.f62002b.sendMessage(httpMessage);
            }
        } else if (this.f62003c != null) {
            m(new ErrorData());
            this.f62002b.getRefreshView().h(R.drawable.new_pic_emotion_05);
            this.f62002b.showNetRefreshViewNoClick(this.f62003c.d(), null);
            this.f62002b.getRefreshView().n(this.f62002b.getString(R.string.im_error_default));
        }
    }

    public void l(List<String> list) {
        d.a.n0.q1.a aVar = this.f62003c;
        if (aVar != null) {
            aVar.l(list, this.f62004d);
        }
    }

    public void m(ErrorData errorData) {
        d.a.n0.q1.a aVar = this.f62003c;
        if (aVar != null) {
            aVar.m(errorData);
        }
    }
}
