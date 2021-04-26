package d.a.j0.p1.b;

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
    public View f57372a;

    /* renamed from: b  reason: collision with root package name */
    public SearchMajorActivity f57373b;

    /* renamed from: c  reason: collision with root package name */
    public d.a.j0.p1.a f57374c;

    /* renamed from: d  reason: collision with root package name */
    public String f57375d;

    /* renamed from: d.a.j0.p1.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class View$OnFocusChangeListenerC1392a implements View.OnFocusChangeListener {
        public View$OnFocusChangeListenerC1392a() {
        }

        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z) {
            if (!z) {
                l.x(a.this.f57373b.getPageContext().getPageActivity(), view);
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
            a.this.f57375d = editable.toString();
            a.this.k();
            a.this.f57374c.k(!StringUtils.isNull(editable.toString()));
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
            a.this.f57373b.finish(intent);
        }
    }

    /* loaded from: classes3.dex */
    public class e extends RecyclerView.OnScrollListener {
        public e() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
            if (i2 == 1 || i2 == 2) {
                l.x(a.this.f57373b.getPageContext().getPageActivity(), recyclerView);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i2, int i3) {
        }
    }

    public a(SearchMajorActivity searchMajorActivity) {
        this.f57373b = searchMajorActivity;
        h();
    }

    public void e() {
        View$OnFocusChangeListenerC1392a view$OnFocusChangeListenerC1392a = new View$OnFocusChangeListenerC1392a();
        b bVar = new b();
        c cVar = new c();
        this.f57374c.q(view$OnFocusChangeListenerC1392a);
        this.f57374c.p(bVar);
        this.f57374c.r(cVar);
    }

    public final void f() {
        d dVar = new d();
        e eVar = new e();
        this.f57374c.n(dVar);
        this.f57374c.o(eVar);
    }

    public d.a.j0.p1.a g() {
        return this.f57374c;
    }

    public final void h() {
        View inflate = LayoutInflater.from(this.f57373b).inflate(R.layout.search_major_main, (ViewGroup) null);
        this.f57372a = inflate;
        this.f57373b.setContentView(inflate);
        this.f57374c = new d.a.j0.p1.a(this.f57372a, this.f57373b);
        e();
        f();
        this.f57375d = "";
        k();
    }

    public void i(int i2) {
        this.f57374c.i(i2);
    }

    public void j() {
        d.a.j0.p1.a aVar = this.f57374c;
        if (aVar != null) {
            aVar.j();
        }
    }

    public final void k() {
        if (this.f57373b == null) {
            return;
        }
        if (j.z()) {
            if (this.f57375d != null) {
                HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_SEARCH_MAJOR);
                httpMessage.addParam("keyword", this.f57375d.trim());
                this.f57373b.sendMessage(httpMessage);
            }
        } else if (this.f57374c != null) {
            m(new ErrorData());
            this.f57373b.getRefreshView().h(R.drawable.new_pic_emotion_05);
            this.f57373b.showNetRefreshViewNoClick(this.f57374c.d(), null);
            this.f57373b.getRefreshView().n(this.f57373b.getString(R.string.im_error_default));
        }
    }

    public void l(List<String> list) {
        d.a.j0.p1.a aVar = this.f57374c;
        if (aVar != null) {
            aVar.l(list, this.f57375d);
        }
    }

    public void m(ErrorData errorData) {
        d.a.j0.p1.a aVar = this.f57374c;
        if (aVar != null) {
            aVar.m(errorData);
        }
    }
}
