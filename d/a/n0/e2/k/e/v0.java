package d.a.n0.e2.k.e;

import android.text.SpannableStringBuilder;
import android.widget.EditText;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
/* loaded from: classes5.dex */
public class v0 {

    /* renamed from: a  reason: collision with root package name */
    public d.a.n0.w3.c f57215a;

    /* renamed from: b  reason: collision with root package name */
    public d.a.n0.w3.c f57216b;

    /* renamed from: c  reason: collision with root package name */
    public EditText f57217c;

    /* renamed from: d  reason: collision with root package name */
    public EditText f57218d;

    /* renamed from: e  reason: collision with root package name */
    public PostWriteCallBackData f57219e;

    public v0() {
        d.a.n0.w3.c cVar = new d.a.n0.w3.c();
        this.f57215a = cVar;
        cVar.j(R.color.CAM_X0101);
        this.f57215a.h(R.color.cp_cont_h_alpha85);
        d.a.n0.w3.c cVar2 = new d.a.n0.w3.c();
        this.f57216b = cVar2;
        cVar2.j(R.color.CAM_X0101);
        this.f57216b.h(R.color.cp_cont_h_alpha85);
    }

    public void a(boolean z) {
        EditText editText = this.f57217c;
        if (editText == null || editText.getText() == null) {
            return;
        }
        int selectionEnd = this.f57217c.getSelectionEnd();
        SpannableStringBuilder f2 = this.f57215a.f(this.f57217c.getText());
        if (f2 != null) {
            this.f57215a.l(true);
            this.f57217c.setText(f2);
            if (z && this.f57215a.b() >= 0) {
                this.f57217c.requestFocus();
                this.f57217c.setSelection(this.f57215a.b());
            } else {
                this.f57217c.setSelection(selectionEnd);
            }
            d.a.n0.w3.c cVar = this.f57215a;
            cVar.k(cVar.b() >= 0);
        }
    }

    public void b(boolean z) {
        EditText editText = this.f57218d;
        if (editText == null || editText.getText() == null) {
            return;
        }
        int selectionEnd = this.f57218d.getSelectionEnd();
        SpannableStringBuilder f2 = this.f57216b.f(this.f57218d.getText());
        if (f2 != null) {
            this.f57216b.l(true);
            this.f57218d.setText(f2);
            if (z && this.f57216b.b() >= 0) {
                this.f57218d.requestFocus();
                this.f57218d.setSelection(this.f57216b.b());
            } else {
                this.f57218d.setSelection(selectionEnd);
            }
            d.a.n0.w3.c cVar = this.f57216b;
            cVar.k(cVar.b() >= 0);
        }
    }

    public void c() {
        this.f57215a.n(null);
        this.f57215a.i(null);
        this.f57215a.k(false);
    }

    public void d() {
        this.f57216b.n(null);
        this.f57216b.i(null);
        this.f57216b.k(false);
    }

    public d.a.n0.w3.c e() {
        return this.f57215a;
    }

    public EditText f() {
        return this.f57218d;
    }

    public d.a.n0.w3.c g() {
        return this.f57216b;
    }

    public PostWriteCallBackData h() {
        return this.f57219e;
    }

    public void i() {
        this.f57215a.g();
        this.f57216b.g();
        if (this.f57215a.d()) {
            a(false);
        }
        if (this.f57216b.d()) {
            b(false);
        }
    }

    public void j() {
        this.f57217c = null;
        this.f57218d = null;
    }

    public void k(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData == null) {
            return;
        }
        this.f57215a.i(postWriteCallBackData.getSensitiveWords());
        this.f57215a.n(postWriteCallBackData.getErrorString());
        if (ListUtils.isEmpty(this.f57215a.a())) {
            return;
        }
        a(true);
        this.f57219e = postWriteCallBackData;
    }

    public void l(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData == null) {
            return;
        }
        this.f57216b.i(postWriteCallBackData.getSensitiveWords());
        this.f57216b.n(postWriteCallBackData.getErrorString());
        if (ListUtils.isEmpty(this.f57216b.a())) {
            return;
        }
        b(true);
    }

    public void m(EditText editText) {
        this.f57217c = editText;
    }

    public void n(EditText editText) {
        this.f57218d = editText;
    }
}
