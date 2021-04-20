package d.b.i0.d2.k.e;

import android.text.SpannableStringBuilder;
import android.widget.EditText;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
/* loaded from: classes3.dex */
public class u0 {

    /* renamed from: a  reason: collision with root package name */
    public d.b.i0.v3.c f54325a;

    /* renamed from: b  reason: collision with root package name */
    public d.b.i0.v3.c f54326b;

    /* renamed from: c  reason: collision with root package name */
    public EditText f54327c;

    /* renamed from: d  reason: collision with root package name */
    public EditText f54328d;

    /* renamed from: e  reason: collision with root package name */
    public PostWriteCallBackData f54329e;

    public u0() {
        d.b.i0.v3.c cVar = new d.b.i0.v3.c();
        this.f54325a = cVar;
        cVar.j(R.color.CAM_X0101);
        this.f54325a.h(R.color.cp_cont_h_alpha85);
        d.b.i0.v3.c cVar2 = new d.b.i0.v3.c();
        this.f54326b = cVar2;
        cVar2.j(R.color.CAM_X0101);
        this.f54326b.h(R.color.cp_cont_h_alpha85);
    }

    public void a(boolean z) {
        EditText editText = this.f54327c;
        if (editText == null || editText.getText() == null) {
            return;
        }
        int selectionEnd = this.f54327c.getSelectionEnd();
        SpannableStringBuilder f2 = this.f54325a.f(this.f54327c.getText());
        if (f2 != null) {
            this.f54325a.l(true);
            this.f54327c.setText(f2);
            if (z && this.f54325a.b() >= 0) {
                this.f54327c.requestFocus();
                this.f54327c.setSelection(this.f54325a.b());
            } else {
                this.f54327c.setSelection(selectionEnd);
            }
            d.b.i0.v3.c cVar = this.f54325a;
            cVar.k(cVar.b() >= 0);
        }
    }

    public void b(boolean z) {
        EditText editText = this.f54328d;
        if (editText == null || editText.getText() == null) {
            return;
        }
        int selectionEnd = this.f54328d.getSelectionEnd();
        SpannableStringBuilder f2 = this.f54326b.f(this.f54328d.getText());
        if (f2 != null) {
            this.f54326b.l(true);
            this.f54328d.setText(f2);
            if (z && this.f54326b.b() >= 0) {
                this.f54328d.requestFocus();
                this.f54328d.setSelection(this.f54326b.b());
            } else {
                this.f54328d.setSelection(selectionEnd);
            }
            d.b.i0.v3.c cVar = this.f54326b;
            cVar.k(cVar.b() >= 0);
        }
    }

    public void c() {
        this.f54325a.n(null);
        this.f54325a.i(null);
        this.f54325a.k(false);
    }

    public void d() {
        this.f54326b.n(null);
        this.f54326b.i(null);
        this.f54326b.k(false);
    }

    public d.b.i0.v3.c e() {
        return this.f54325a;
    }

    public EditText f() {
        return this.f54328d;
    }

    public d.b.i0.v3.c g() {
        return this.f54326b;
    }

    public PostWriteCallBackData h() {
        return this.f54329e;
    }

    public void i() {
        this.f54325a.g();
        this.f54326b.g();
        if (this.f54325a.d()) {
            a(false);
        }
        if (this.f54326b.d()) {
            b(false);
        }
    }

    public void j() {
        this.f54327c = null;
        this.f54328d = null;
    }

    public void k(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData == null) {
            return;
        }
        this.f54325a.i(postWriteCallBackData.getSensitiveWords());
        this.f54325a.n(postWriteCallBackData.getErrorString());
        if (ListUtils.isEmpty(this.f54325a.a())) {
            return;
        }
        a(true);
        this.f54329e = postWriteCallBackData;
    }

    public void l(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData == null) {
            return;
        }
        this.f54326b.i(postWriteCallBackData.getSensitiveWords());
        this.f54326b.n(postWriteCallBackData.getErrorString());
        if (ListUtils.isEmpty(this.f54326b.a())) {
            return;
        }
        b(true);
    }

    public void m(EditText editText) {
        this.f54327c = editText;
    }

    public void n(EditText editText) {
        this.f54328d = editText;
    }
}
