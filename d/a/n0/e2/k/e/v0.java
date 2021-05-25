package d.a.n0.e2.k.e;

import android.text.SpannableStringBuilder;
import android.widget.EditText;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
/* loaded from: classes5.dex */
public class v0 {

    /* renamed from: a  reason: collision with root package name */
    public d.a.n0.w3.c f53526a;

    /* renamed from: b  reason: collision with root package name */
    public d.a.n0.w3.c f53527b;

    /* renamed from: c  reason: collision with root package name */
    public EditText f53528c;

    /* renamed from: d  reason: collision with root package name */
    public EditText f53529d;

    /* renamed from: e  reason: collision with root package name */
    public PostWriteCallBackData f53530e;

    public v0() {
        d.a.n0.w3.c cVar = new d.a.n0.w3.c();
        this.f53526a = cVar;
        cVar.j(R.color.CAM_X0101);
        this.f53526a.h(R.color.cp_cont_h_alpha85);
        d.a.n0.w3.c cVar2 = new d.a.n0.w3.c();
        this.f53527b = cVar2;
        cVar2.j(R.color.CAM_X0101);
        this.f53527b.h(R.color.cp_cont_h_alpha85);
    }

    public void a(boolean z) {
        EditText editText = this.f53528c;
        if (editText == null || editText.getText() == null) {
            return;
        }
        int selectionEnd = this.f53528c.getSelectionEnd();
        SpannableStringBuilder f2 = this.f53526a.f(this.f53528c.getText());
        if (f2 != null) {
            this.f53526a.l(true);
            this.f53528c.setText(f2);
            if (z && this.f53526a.b() >= 0) {
                this.f53528c.requestFocus();
                this.f53528c.setSelection(this.f53526a.b());
            } else {
                this.f53528c.setSelection(selectionEnd);
            }
            d.a.n0.w3.c cVar = this.f53526a;
            cVar.k(cVar.b() >= 0);
        }
    }

    public void b(boolean z) {
        EditText editText = this.f53529d;
        if (editText == null || editText.getText() == null) {
            return;
        }
        int selectionEnd = this.f53529d.getSelectionEnd();
        SpannableStringBuilder f2 = this.f53527b.f(this.f53529d.getText());
        if (f2 != null) {
            this.f53527b.l(true);
            this.f53529d.setText(f2);
            if (z && this.f53527b.b() >= 0) {
                this.f53529d.requestFocus();
                this.f53529d.setSelection(this.f53527b.b());
            } else {
                this.f53529d.setSelection(selectionEnd);
            }
            d.a.n0.w3.c cVar = this.f53527b;
            cVar.k(cVar.b() >= 0);
        }
    }

    public void c() {
        this.f53526a.n(null);
        this.f53526a.i(null);
        this.f53526a.k(false);
    }

    public void d() {
        this.f53527b.n(null);
        this.f53527b.i(null);
        this.f53527b.k(false);
    }

    public d.a.n0.w3.c e() {
        return this.f53526a;
    }

    public EditText f() {
        return this.f53529d;
    }

    public d.a.n0.w3.c g() {
        return this.f53527b;
    }

    public PostWriteCallBackData h() {
        return this.f53530e;
    }

    public void i() {
        this.f53526a.g();
        this.f53527b.g();
        if (this.f53526a.d()) {
            a(false);
        }
        if (this.f53527b.d()) {
            b(false);
        }
    }

    public void j() {
        this.f53528c = null;
        this.f53529d = null;
    }

    public void k(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData == null) {
            return;
        }
        this.f53526a.i(postWriteCallBackData.getSensitiveWords());
        this.f53526a.n(postWriteCallBackData.getErrorString());
        if (ListUtils.isEmpty(this.f53526a.a())) {
            return;
        }
        a(true);
        this.f53530e = postWriteCallBackData;
    }

    public void l(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData == null) {
            return;
        }
        this.f53527b.i(postWriteCallBackData.getSensitiveWords());
        this.f53527b.n(postWriteCallBackData.getErrorString());
        if (ListUtils.isEmpty(this.f53527b.a())) {
            return;
        }
        b(true);
    }

    public void m(EditText editText) {
        this.f53528c = editText;
    }

    public void n(EditText editText) {
        this.f53529d = editText;
    }
}
