package d.b.j0.d2.k.e;

import android.text.SpannableStringBuilder;
import android.widget.EditText;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
/* loaded from: classes3.dex */
public class u0 {

    /* renamed from: a  reason: collision with root package name */
    public d.b.j0.v3.c f54746a;

    /* renamed from: b  reason: collision with root package name */
    public d.b.j0.v3.c f54747b;

    /* renamed from: c  reason: collision with root package name */
    public EditText f54748c;

    /* renamed from: d  reason: collision with root package name */
    public EditText f54749d;

    /* renamed from: e  reason: collision with root package name */
    public PostWriteCallBackData f54750e;

    public u0() {
        d.b.j0.v3.c cVar = new d.b.j0.v3.c();
        this.f54746a = cVar;
        cVar.j(R.color.CAM_X0101);
        this.f54746a.h(R.color.cp_cont_h_alpha85);
        d.b.j0.v3.c cVar2 = new d.b.j0.v3.c();
        this.f54747b = cVar2;
        cVar2.j(R.color.CAM_X0101);
        this.f54747b.h(R.color.cp_cont_h_alpha85);
    }

    public void a(boolean z) {
        EditText editText = this.f54748c;
        if (editText == null || editText.getText() == null) {
            return;
        }
        int selectionEnd = this.f54748c.getSelectionEnd();
        SpannableStringBuilder f2 = this.f54746a.f(this.f54748c.getText());
        if (f2 != null) {
            this.f54746a.l(true);
            this.f54748c.setText(f2);
            if (z && this.f54746a.b() >= 0) {
                this.f54748c.requestFocus();
                this.f54748c.setSelection(this.f54746a.b());
            } else {
                this.f54748c.setSelection(selectionEnd);
            }
            d.b.j0.v3.c cVar = this.f54746a;
            cVar.k(cVar.b() >= 0);
        }
    }

    public void b(boolean z) {
        EditText editText = this.f54749d;
        if (editText == null || editText.getText() == null) {
            return;
        }
        int selectionEnd = this.f54749d.getSelectionEnd();
        SpannableStringBuilder f2 = this.f54747b.f(this.f54749d.getText());
        if (f2 != null) {
            this.f54747b.l(true);
            this.f54749d.setText(f2);
            if (z && this.f54747b.b() >= 0) {
                this.f54749d.requestFocus();
                this.f54749d.setSelection(this.f54747b.b());
            } else {
                this.f54749d.setSelection(selectionEnd);
            }
            d.b.j0.v3.c cVar = this.f54747b;
            cVar.k(cVar.b() >= 0);
        }
    }

    public void c() {
        this.f54746a.n(null);
        this.f54746a.i(null);
        this.f54746a.k(false);
    }

    public void d() {
        this.f54747b.n(null);
        this.f54747b.i(null);
        this.f54747b.k(false);
    }

    public d.b.j0.v3.c e() {
        return this.f54746a;
    }

    public EditText f() {
        return this.f54749d;
    }

    public d.b.j0.v3.c g() {
        return this.f54747b;
    }

    public PostWriteCallBackData h() {
        return this.f54750e;
    }

    public void i() {
        this.f54746a.g();
        this.f54747b.g();
        if (this.f54746a.d()) {
            a(false);
        }
        if (this.f54747b.d()) {
            b(false);
        }
    }

    public void j() {
        this.f54748c = null;
        this.f54749d = null;
    }

    public void k(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData == null) {
            return;
        }
        this.f54746a.i(postWriteCallBackData.getSensitiveWords());
        this.f54746a.n(postWriteCallBackData.getErrorString());
        if (ListUtils.isEmpty(this.f54746a.a())) {
            return;
        }
        a(true);
        this.f54750e = postWriteCallBackData;
    }

    public void l(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData == null) {
            return;
        }
        this.f54747b.i(postWriteCallBackData.getSensitiveWords());
        this.f54747b.n(postWriteCallBackData.getErrorString());
        if (ListUtils.isEmpty(this.f54747b.a())) {
            return;
        }
        b(true);
    }

    public void m(EditText editText) {
        this.f54748c = editText;
    }

    public void n(EditText editText) {
        this.f54749d = editText;
    }
}
