package d.a.o0.e2.k.e;

import android.text.SpannableStringBuilder;
import android.widget.EditText;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
/* loaded from: classes5.dex */
public class v0 {

    /* renamed from: a  reason: collision with root package name */
    public d.a.o0.w3.c f57340a;

    /* renamed from: b  reason: collision with root package name */
    public d.a.o0.w3.c f57341b;

    /* renamed from: c  reason: collision with root package name */
    public EditText f57342c;

    /* renamed from: d  reason: collision with root package name */
    public EditText f57343d;

    /* renamed from: e  reason: collision with root package name */
    public PostWriteCallBackData f57344e;

    public v0() {
        d.a.o0.w3.c cVar = new d.a.o0.w3.c();
        this.f57340a = cVar;
        cVar.j(R.color.CAM_X0101);
        this.f57340a.h(R.color.cp_cont_h_alpha85);
        d.a.o0.w3.c cVar2 = new d.a.o0.w3.c();
        this.f57341b = cVar2;
        cVar2.j(R.color.CAM_X0101);
        this.f57341b.h(R.color.cp_cont_h_alpha85);
    }

    public void a(boolean z) {
        EditText editText = this.f57342c;
        if (editText == null || editText.getText() == null) {
            return;
        }
        int selectionEnd = this.f57342c.getSelectionEnd();
        SpannableStringBuilder f2 = this.f57340a.f(this.f57342c.getText());
        if (f2 != null) {
            this.f57340a.l(true);
            this.f57342c.setText(f2);
            if (z && this.f57340a.b() >= 0) {
                this.f57342c.requestFocus();
                this.f57342c.setSelection(this.f57340a.b());
            } else {
                this.f57342c.setSelection(selectionEnd);
            }
            d.a.o0.w3.c cVar = this.f57340a;
            cVar.k(cVar.b() >= 0);
        }
    }

    public void b(boolean z) {
        EditText editText = this.f57343d;
        if (editText == null || editText.getText() == null) {
            return;
        }
        int selectionEnd = this.f57343d.getSelectionEnd();
        SpannableStringBuilder f2 = this.f57341b.f(this.f57343d.getText());
        if (f2 != null) {
            this.f57341b.l(true);
            this.f57343d.setText(f2);
            if (z && this.f57341b.b() >= 0) {
                this.f57343d.requestFocus();
                this.f57343d.setSelection(this.f57341b.b());
            } else {
                this.f57343d.setSelection(selectionEnd);
            }
            d.a.o0.w3.c cVar = this.f57341b;
            cVar.k(cVar.b() >= 0);
        }
    }

    public void c() {
        this.f57340a.n(null);
        this.f57340a.i(null);
        this.f57340a.k(false);
    }

    public void d() {
        this.f57341b.n(null);
        this.f57341b.i(null);
        this.f57341b.k(false);
    }

    public d.a.o0.w3.c e() {
        return this.f57340a;
    }

    public EditText f() {
        return this.f57343d;
    }

    public d.a.o0.w3.c g() {
        return this.f57341b;
    }

    public PostWriteCallBackData h() {
        return this.f57344e;
    }

    public void i() {
        this.f57340a.g();
        this.f57341b.g();
        if (this.f57340a.d()) {
            a(false);
        }
        if (this.f57341b.d()) {
            b(false);
        }
    }

    public void j() {
        this.f57342c = null;
        this.f57343d = null;
    }

    public void k(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData == null) {
            return;
        }
        this.f57340a.i(postWriteCallBackData.getSensitiveWords());
        this.f57340a.n(postWriteCallBackData.getErrorString());
        if (ListUtils.isEmpty(this.f57340a.a())) {
            return;
        }
        a(true);
        this.f57344e = postWriteCallBackData;
    }

    public void l(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData == null) {
            return;
        }
        this.f57341b.i(postWriteCallBackData.getSensitiveWords());
        this.f57341b.n(postWriteCallBackData.getErrorString());
        if (ListUtils.isEmpty(this.f57341b.a())) {
            return;
        }
        b(true);
    }

    public void m(EditText editText) {
        this.f57342c = editText;
    }

    public void n(EditText editText) {
        this.f57343d = editText;
    }
}
