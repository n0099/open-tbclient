package d.a.k0.d2.k.e;

import android.text.SpannableStringBuilder;
import android.widget.EditText;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
/* loaded from: classes5.dex */
public class u0 {

    /* renamed from: a  reason: collision with root package name */
    public d.a.k0.v3.c f53262a;

    /* renamed from: b  reason: collision with root package name */
    public d.a.k0.v3.c f53263b;

    /* renamed from: c  reason: collision with root package name */
    public EditText f53264c;

    /* renamed from: d  reason: collision with root package name */
    public EditText f53265d;

    /* renamed from: e  reason: collision with root package name */
    public PostWriteCallBackData f53266e;

    public u0() {
        d.a.k0.v3.c cVar = new d.a.k0.v3.c();
        this.f53262a = cVar;
        cVar.j(R.color.CAM_X0101);
        this.f53262a.h(R.color.cp_cont_h_alpha85);
        d.a.k0.v3.c cVar2 = new d.a.k0.v3.c();
        this.f53263b = cVar2;
        cVar2.j(R.color.CAM_X0101);
        this.f53263b.h(R.color.cp_cont_h_alpha85);
    }

    public void a(boolean z) {
        EditText editText = this.f53264c;
        if (editText == null || editText.getText() == null) {
            return;
        }
        int selectionEnd = this.f53264c.getSelectionEnd();
        SpannableStringBuilder f2 = this.f53262a.f(this.f53264c.getText());
        if (f2 != null) {
            this.f53262a.l(true);
            this.f53264c.setText(f2);
            if (z && this.f53262a.b() >= 0) {
                this.f53264c.requestFocus();
                this.f53264c.setSelection(this.f53262a.b());
            } else {
                this.f53264c.setSelection(selectionEnd);
            }
            d.a.k0.v3.c cVar = this.f53262a;
            cVar.k(cVar.b() >= 0);
        }
    }

    public void b(boolean z) {
        EditText editText = this.f53265d;
        if (editText == null || editText.getText() == null) {
            return;
        }
        int selectionEnd = this.f53265d.getSelectionEnd();
        SpannableStringBuilder f2 = this.f53263b.f(this.f53265d.getText());
        if (f2 != null) {
            this.f53263b.l(true);
            this.f53265d.setText(f2);
            if (z && this.f53263b.b() >= 0) {
                this.f53265d.requestFocus();
                this.f53265d.setSelection(this.f53263b.b());
            } else {
                this.f53265d.setSelection(selectionEnd);
            }
            d.a.k0.v3.c cVar = this.f53263b;
            cVar.k(cVar.b() >= 0);
        }
    }

    public void c() {
        this.f53262a.n(null);
        this.f53262a.i(null);
        this.f53262a.k(false);
    }

    public void d() {
        this.f53263b.n(null);
        this.f53263b.i(null);
        this.f53263b.k(false);
    }

    public d.a.k0.v3.c e() {
        return this.f53262a;
    }

    public EditText f() {
        return this.f53265d;
    }

    public d.a.k0.v3.c g() {
        return this.f53263b;
    }

    public PostWriteCallBackData h() {
        return this.f53266e;
    }

    public void i() {
        this.f53262a.g();
        this.f53263b.g();
        if (this.f53262a.d()) {
            a(false);
        }
        if (this.f53263b.d()) {
            b(false);
        }
    }

    public void j() {
        this.f53264c = null;
        this.f53265d = null;
    }

    public void k(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData == null) {
            return;
        }
        this.f53262a.i(postWriteCallBackData.getSensitiveWords());
        this.f53262a.n(postWriteCallBackData.getErrorString());
        if (ListUtils.isEmpty(this.f53262a.a())) {
            return;
        }
        a(true);
        this.f53266e = postWriteCallBackData;
    }

    public void l(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData == null) {
            return;
        }
        this.f53263b.i(postWriteCallBackData.getSensitiveWords());
        this.f53263b.n(postWriteCallBackData.getErrorString());
        if (ListUtils.isEmpty(this.f53263b.a())) {
            return;
        }
        b(true);
    }

    public void m(EditText editText) {
        this.f53264c = editText;
    }

    public void n(EditText editText) {
        this.f53265d = editText;
    }
}
