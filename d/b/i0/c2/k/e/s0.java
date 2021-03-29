package d.b.i0.c2.k.e;

import android.text.SpannableStringBuilder;
import android.widget.EditText;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
/* loaded from: classes4.dex */
public class s0 {

    /* renamed from: a  reason: collision with root package name */
    public d.b.i0.u3.c f52830a;

    /* renamed from: b  reason: collision with root package name */
    public d.b.i0.u3.c f52831b;

    /* renamed from: c  reason: collision with root package name */
    public EditText f52832c;

    /* renamed from: d  reason: collision with root package name */
    public EditText f52833d;

    /* renamed from: e  reason: collision with root package name */
    public PostWriteCallBackData f52834e;

    public s0() {
        d.b.i0.u3.c cVar = new d.b.i0.u3.c();
        this.f52830a = cVar;
        cVar.j(R.color.CAM_X0101);
        this.f52830a.h(R.color.cp_cont_h_alpha85);
        d.b.i0.u3.c cVar2 = new d.b.i0.u3.c();
        this.f52831b = cVar2;
        cVar2.j(R.color.CAM_X0101);
        this.f52831b.h(R.color.cp_cont_h_alpha85);
    }

    public void a(boolean z) {
        EditText editText = this.f52832c;
        if (editText == null || editText.getText() == null) {
            return;
        }
        int selectionEnd = this.f52832c.getSelectionEnd();
        SpannableStringBuilder f2 = this.f52830a.f(this.f52832c.getText());
        if (f2 != null) {
            this.f52830a.l(true);
            this.f52832c.setText(f2);
            if (z && this.f52830a.b() >= 0) {
                this.f52832c.requestFocus();
                this.f52832c.setSelection(this.f52830a.b());
            } else {
                this.f52832c.setSelection(selectionEnd);
            }
            d.b.i0.u3.c cVar = this.f52830a;
            cVar.k(cVar.b() >= 0);
        }
    }

    public void b(boolean z) {
        EditText editText = this.f52833d;
        if (editText == null || editText.getText() == null) {
            return;
        }
        int selectionEnd = this.f52833d.getSelectionEnd();
        SpannableStringBuilder f2 = this.f52831b.f(this.f52833d.getText());
        if (f2 != null) {
            this.f52831b.l(true);
            this.f52833d.setText(f2);
            if (z && this.f52831b.b() >= 0) {
                this.f52833d.requestFocus();
                this.f52833d.setSelection(this.f52831b.b());
            } else {
                this.f52833d.setSelection(selectionEnd);
            }
            d.b.i0.u3.c cVar = this.f52831b;
            cVar.k(cVar.b() >= 0);
        }
    }

    public void c() {
        this.f52830a.n(null);
        this.f52830a.i(null);
        this.f52830a.k(false);
    }

    public void d() {
        this.f52831b.n(null);
        this.f52831b.i(null);
        this.f52831b.k(false);
    }

    public d.b.i0.u3.c e() {
        return this.f52830a;
    }

    public EditText f() {
        return this.f52833d;
    }

    public d.b.i0.u3.c g() {
        return this.f52831b;
    }

    public PostWriteCallBackData h() {
        return this.f52834e;
    }

    public void i() {
        this.f52830a.g();
        this.f52831b.g();
        if (this.f52830a.d()) {
            a(false);
        }
        if (this.f52831b.d()) {
            b(false);
        }
    }

    public void j() {
        this.f52832c = null;
        this.f52833d = null;
    }

    public void k(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData == null) {
            return;
        }
        this.f52830a.i(postWriteCallBackData.getSensitiveWords());
        this.f52830a.n(postWriteCallBackData.getErrorString());
        if (ListUtils.isEmpty(this.f52830a.a())) {
            return;
        }
        a(true);
        this.f52834e = postWriteCallBackData;
    }

    public void l(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData == null) {
            return;
        }
        this.f52831b.i(postWriteCallBackData.getSensitiveWords());
        this.f52831b.n(postWriteCallBackData.getErrorString());
        if (ListUtils.isEmpty(this.f52831b.a())) {
            return;
        }
        b(true);
    }

    public void m(EditText editText) {
        this.f52832c = editText;
    }

    public void n(EditText editText) {
        this.f52833d = editText;
    }
}
