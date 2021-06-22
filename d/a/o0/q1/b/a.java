package d.a.o0.q1.b;

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
    public View f62126a;

    /* renamed from: b  reason: collision with root package name */
    public SearchMajorActivity f62127b;

    /* renamed from: c  reason: collision with root package name */
    public d.a.o0.q1.a f62128c;

    /* renamed from: d  reason: collision with root package name */
    public String f62129d;

    /* renamed from: d.a.o0.q1.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class View$OnFocusChangeListenerC1543a implements View.OnFocusChangeListener {
        public View$OnFocusChangeListenerC1543a() {
        }

        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z) {
            if (!z) {
                l.x(a.this.f62127b.getPageContext().getPageActivity(), view);
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
            a.this.f62129d = editable.toString();
            a.this.k();
            a.this.f62128c.k(!StringUtils.isNull(editable.toString()));
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
            a.this.f62127b.finish(intent);
        }
    }

    /* loaded from: classes3.dex */
    public class e extends RecyclerView.OnScrollListener {
        public e() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
            if (i2 == 1 || i2 == 2) {
                l.x(a.this.f62127b.getPageContext().getPageActivity(), recyclerView);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i2, int i3) {
        }
    }

    public a(SearchMajorActivity searchMajorActivity) {
        this.f62127b = searchMajorActivity;
        h();
    }

    public void e() {
        View$OnFocusChangeListenerC1543a view$OnFocusChangeListenerC1543a = new View$OnFocusChangeListenerC1543a();
        b bVar = new b();
        c cVar = new c();
        this.f62128c.q(view$OnFocusChangeListenerC1543a);
        this.f62128c.p(bVar);
        this.f62128c.r(cVar);
    }

    public final void f() {
        d dVar = new d();
        e eVar = new e();
        this.f62128c.n(dVar);
        this.f62128c.o(eVar);
    }

    public d.a.o0.q1.a g() {
        return this.f62128c;
    }

    public final void h() {
        View inflate = LayoutInflater.from(this.f62127b).inflate(R.layout.search_major_main, (ViewGroup) null);
        this.f62126a = inflate;
        this.f62127b.setContentView(inflate);
        this.f62128c = new d.a.o0.q1.a(this.f62126a, this.f62127b);
        e();
        f();
        this.f62129d = "";
        k();
    }

    public void i(int i2) {
        this.f62128c.i(i2);
    }

    public void j() {
        d.a.o0.q1.a aVar = this.f62128c;
        if (aVar != null) {
            aVar.j();
        }
    }

    public final void k() {
        if (this.f62127b == null) {
            return;
        }
        if (j.z()) {
            if (this.f62129d != null) {
                HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_SEARCH_MAJOR);
                httpMessage.addParam("keyword", this.f62129d.trim());
                this.f62127b.sendMessage(httpMessage);
            }
        } else if (this.f62128c != null) {
            m(new ErrorData());
            this.f62127b.getRefreshView().h(R.drawable.new_pic_emotion_05);
            this.f62127b.showNetRefreshViewNoClick(this.f62128c.d(), null);
            this.f62127b.getRefreshView().n(this.f62127b.getString(R.string.im_error_default));
        }
    }

    public void l(List<String> list) {
        d.a.o0.q1.a aVar = this.f62128c;
        if (aVar != null) {
            aVar.l(list, this.f62129d);
        }
    }

    public void m(ErrorData errorData) {
        d.a.o0.q1.a aVar = this.f62128c;
        if (aVar != null) {
            aVar.m(errorData);
        }
    }
}
