package d.b.i0.o1.b;

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
import d.b.b.e.p.j;
import d.b.b.e.p.l;
import java.util.List;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public View f57267a;

    /* renamed from: b  reason: collision with root package name */
    public SearchMajorActivity f57268b;

    /* renamed from: c  reason: collision with root package name */
    public d.b.i0.o1.a f57269c;

    /* renamed from: d  reason: collision with root package name */
    public String f57270d;

    /* renamed from: d.b.i0.o1.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class View$OnFocusChangeListenerC1371a implements View.OnFocusChangeListener {
        public View$OnFocusChangeListenerC1371a() {
        }

        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z) {
            if (!z) {
                l.w(a.this.f57268b.getPageContext().getPageActivity(), view);
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
            a.this.f57270d = editable.toString();
            a.this.k();
            a.this.f57269c.k(!StringUtils.isNull(editable.toString()));
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
            a.this.f57268b.finish(intent);
        }
    }

    /* loaded from: classes3.dex */
    public class e extends RecyclerView.OnScrollListener {
        public e() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            if (i == 1 || i == 2) {
                l.w(a.this.f57268b.getPageContext().getPageActivity(), recyclerView);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
        }
    }

    public a(SearchMajorActivity searchMajorActivity) {
        this.f57268b = searchMajorActivity;
        h();
    }

    public void e() {
        View$OnFocusChangeListenerC1371a view$OnFocusChangeListenerC1371a = new View$OnFocusChangeListenerC1371a();
        b bVar = new b();
        c cVar = new c();
        this.f57269c.q(view$OnFocusChangeListenerC1371a);
        this.f57269c.p(bVar);
        this.f57269c.r(cVar);
    }

    public final void f() {
        d dVar = new d();
        e eVar = new e();
        this.f57269c.n(dVar);
        this.f57269c.o(eVar);
    }

    public d.b.i0.o1.a g() {
        return this.f57269c;
    }

    public final void h() {
        View inflate = LayoutInflater.from(this.f57268b).inflate(R.layout.search_major_main, (ViewGroup) null);
        this.f57267a = inflate;
        this.f57268b.setContentView(inflate);
        this.f57269c = new d.b.i0.o1.a(this.f57267a, this.f57268b);
        e();
        f();
        this.f57270d = "";
        k();
    }

    public void i(int i) {
        this.f57269c.i(i);
    }

    public void j() {
        d.b.i0.o1.a aVar = this.f57269c;
        if (aVar != null) {
            aVar.j();
        }
    }

    public final void k() {
        if (this.f57268b == null) {
            return;
        }
        if (j.z()) {
            if (this.f57270d != null) {
                HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_SEARCH_MAJOR);
                httpMessage.addParam("keyword", this.f57270d.trim());
                this.f57268b.sendMessage(httpMessage);
            }
        } else if (this.f57269c != null) {
            m(new ErrorData());
            this.f57268b.getRefreshView().h(R.drawable.new_pic_emotion_05);
            this.f57268b.showNetRefreshViewNoClick(this.f57269c.d(), null);
            this.f57268b.getRefreshView().n(this.f57268b.getString(R.string.im_error_default));
        }
    }

    public void l(List<String> list) {
        d.b.i0.o1.a aVar = this.f57269c;
        if (aVar != null) {
            aVar.l(list, this.f57270d);
        }
    }

    public void m(ErrorData errorData) {
        d.b.i0.o1.a aVar = this.f57269c;
        if (aVar != null) {
            aVar.m(errorData);
        }
    }
}
