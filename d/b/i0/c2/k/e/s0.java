package d.b.i0.c2.k.e;

import android.text.SpannableStringBuilder;
import android.widget.EditText;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
/* loaded from: classes4.dex */
public class s0 {

    /* renamed from: a  reason: collision with root package name */
    public d.b.i0.u3.c f52829a;

    /* renamed from: b  reason: collision with root package name */
    public d.b.i0.u3.c f52830b;

    /* renamed from: c  reason: collision with root package name */
    public EditText f52831c;

    /* renamed from: d  reason: collision with root package name */
    public EditText f52832d;

    /* renamed from: e  reason: collision with root package name */
    public PostWriteCallBackData f52833e;

    public s0() {
        d.b.i0.u3.c cVar = new d.b.i0.u3.c();
        this.f52829a = cVar;
        cVar.j(R.color.CAM_X0101);
        this.f52829a.h(R.color.cp_cont_h_alpha85);
        d.b.i0.u3.c cVar2 = new d.b.i0.u3.c();
        this.f52830b = cVar2;
        cVar2.j(R.color.CAM_X0101);
        this.f52830b.h(R.color.cp_cont_h_alpha85);
    }

    public void a(boolean z) {
        EditText editText = this.f52831c;
        if (editText == null || editText.getText() == null) {
            return;
        }
        int selectionEnd = this.f52831c.getSelectionEnd();
        SpannableStringBuilder f2 = this.f52829a.f(this.f52831c.getText());
        if (f2 != null) {
            this.f52829a.l(true);
            this.f52831c.setText(f2);
            if (z && this.f52829a.b() >= 0) {
                this.f52831c.requestFocus();
                this.f52831c.setSelection(this.f52829a.b());
            } else {
                this.f52831c.setSelection(selectionEnd);
            }
            d.b.i0.u3.c cVar = this.f52829a;
            cVar.k(cVar.b() >= 0);
        }
    }

    public void b(boolean z) {
        EditText editText = this.f52832d;
        if (editText == null || editText.getText() == null) {
            return;
        }
        int selectionEnd = this.f52832d.getSelectionEnd();
        SpannableStringBuilder f2 = this.f52830b.f(this.f52832d.getText());
        if (f2 != null) {
            this.f52830b.l(true);
            this.f52832d.setText(f2);
            if (z && this.f52830b.b() >= 0) {
                this.f52832d.requestFocus();
                this.f52832d.setSelection(this.f52830b.b());
            } else {
                this.f52832d.setSelection(selectionEnd);
            }
            d.b.i0.u3.c cVar = this.f52830b;
            cVar.k(cVar.b() >= 0);
        }
    }

    public void c() {
        this.f52829a.n(null);
        this.f52829a.i(null);
        this.f52829a.k(false);
    }

    public void d() {
        this.f52830b.n(null);
        this.f52830b.i(null);
        this.f52830b.k(false);
    }

    public d.b.i0.u3.c e() {
        return this.f52829a;
    }

    public EditText f() {
        return this.f52832d;
    }

    public d.b.i0.u3.c g() {
        return this.f52830b;
    }

    public PostWriteCallBackData h() {
        return this.f52833e;
    }

    public void i() {
        this.f52829a.g();
        this.f52830b.g();
        if (this.f52829a.d()) {
            a(false);
        }
        if (this.f52830b.d()) {
            b(false);
        }
    }

    public void j() {
        this.f52831c = null;
        this.f52832d = null;
    }

    public void k(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData == null) {
            return;
        }
        this.f52829a.i(postWriteCallBackData.getSensitiveWords());
        this.f52829a.n(postWriteCallBackData.getErrorString());
        if (ListUtils.isEmpty(this.f52829a.a())) {
            return;
        }
        a(true);
        this.f52833e = postWriteCallBackData;
    }

    public void l(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData == null) {
            return;
        }
        this.f52830b.i(postWriteCallBackData.getSensitiveWords());
        this.f52830b.n(postWriteCallBackData.getErrorString());
        if (ListUtils.isEmpty(this.f52830b.a())) {
            return;
        }
        b(true);
    }

    public void m(EditText editText) {
        this.f52831c = editText;
    }

    public void n(EditText editText) {
        this.f52832d = editText;
    }
}
