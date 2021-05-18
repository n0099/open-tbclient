package d.a.k0.p1.b;

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
    public View f58114a;

    /* renamed from: b  reason: collision with root package name */
    public SearchMajorActivity f58115b;

    /* renamed from: c  reason: collision with root package name */
    public d.a.k0.p1.a f58116c;

    /* renamed from: d  reason: collision with root package name */
    public String f58117d;

    /* renamed from: d.a.k0.p1.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class View$OnFocusChangeListenerC1466a implements View.OnFocusChangeListener {
        public View$OnFocusChangeListenerC1466a() {
        }

        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z) {
            if (!z) {
                l.x(a.this.f58115b.getPageContext().getPageActivity(), view);
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
            a.this.f58117d = editable.toString();
            a.this.k();
            a.this.f58116c.k(!StringUtils.isNull(editable.toString()));
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
            a.this.f58115b.finish(intent);
        }
    }

    /* loaded from: classes3.dex */
    public class e extends RecyclerView.OnScrollListener {
        public e() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
            if (i2 == 1 || i2 == 2) {
                l.x(a.this.f58115b.getPageContext().getPageActivity(), recyclerView);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i2, int i3) {
        }
    }

    public a(SearchMajorActivity searchMajorActivity) {
        this.f58115b = searchMajorActivity;
        h();
    }

    public void e() {
        View$OnFocusChangeListenerC1466a view$OnFocusChangeListenerC1466a = new View$OnFocusChangeListenerC1466a();
        b bVar = new b();
        c cVar = new c();
        this.f58116c.q(view$OnFocusChangeListenerC1466a);
        this.f58116c.p(bVar);
        this.f58116c.r(cVar);
    }

    public final void f() {
        d dVar = new d();
        e eVar = new e();
        this.f58116c.n(dVar);
        this.f58116c.o(eVar);
    }

    public d.a.k0.p1.a g() {
        return this.f58116c;
    }

    public final void h() {
        View inflate = LayoutInflater.from(this.f58115b).inflate(R.layout.search_major_main, (ViewGroup) null);
        this.f58114a = inflate;
        this.f58115b.setContentView(inflate);
        this.f58116c = new d.a.k0.p1.a(this.f58114a, this.f58115b);
        e();
        f();
        this.f58117d = "";
        k();
    }

    public void i(int i2) {
        this.f58116c.i(i2);
    }

    public void j() {
        d.a.k0.p1.a aVar = this.f58116c;
        if (aVar != null) {
            aVar.j();
        }
    }

    public final void k() {
        if (this.f58115b == null) {
            return;
        }
        if (j.z()) {
            if (this.f58117d != null) {
                HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_SEARCH_MAJOR);
                httpMessage.addParam("keyword", this.f58117d.trim());
                this.f58115b.sendMessage(httpMessage);
            }
        } else if (this.f58116c != null) {
            m(new ErrorData());
            this.f58115b.getRefreshView().h(R.drawable.new_pic_emotion_05);
            this.f58115b.showNetRefreshViewNoClick(this.f58116c.d(), null);
            this.f58115b.getRefreshView().n(this.f58115b.getString(R.string.im_error_default));
        }
    }

    public void l(List<String> list) {
        d.a.k0.p1.a aVar = this.f58116c;
        if (aVar != null) {
            aVar.l(list, this.f58117d);
        }
    }

    public void m(ErrorData errorData) {
        d.a.k0.p1.a aVar = this.f58116c;
        if (aVar != null) {
            aVar.m(errorData);
        }
    }
}
