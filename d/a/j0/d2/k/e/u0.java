package d.a.j0.d2.k.e;

import android.text.SpannableStringBuilder;
import android.widget.EditText;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
/* loaded from: classes3.dex */
public class u0 {

    /* renamed from: a  reason: collision with root package name */
    public d.a.j0.v3.c f52559a;

    /* renamed from: b  reason: collision with root package name */
    public d.a.j0.v3.c f52560b;

    /* renamed from: c  reason: collision with root package name */
    public EditText f52561c;

    /* renamed from: d  reason: collision with root package name */
    public EditText f52562d;

    /* renamed from: e  reason: collision with root package name */
    public PostWriteCallBackData f52563e;

    public u0() {
        d.a.j0.v3.c cVar = new d.a.j0.v3.c();
        this.f52559a = cVar;
        cVar.j(R.color.CAM_X0101);
        this.f52559a.h(R.color.cp_cont_h_alpha85);
        d.a.j0.v3.c cVar2 = new d.a.j0.v3.c();
        this.f52560b = cVar2;
        cVar2.j(R.color.CAM_X0101);
        this.f52560b.h(R.color.cp_cont_h_alpha85);
    }

    public void a(boolean z) {
        EditText editText = this.f52561c;
        if (editText == null || editText.getText() == null) {
            return;
        }
        int selectionEnd = this.f52561c.getSelectionEnd();
        SpannableStringBuilder f2 = this.f52559a.f(this.f52561c.getText());
        if (f2 != null) {
            this.f52559a.l(true);
            this.f52561c.setText(f2);
            if (z && this.f52559a.b() >= 0) {
                this.f52561c.requestFocus();
                this.f52561c.setSelection(this.f52559a.b());
            } else {
                this.f52561c.setSelection(selectionEnd);
            }
            d.a.j0.v3.c cVar = this.f52559a;
            cVar.k(cVar.b() >= 0);
        }
    }

    public void b(boolean z) {
        EditText editText = this.f52562d;
        if (editText == null || editText.getText() == null) {
            return;
        }
        int selectionEnd = this.f52562d.getSelectionEnd();
        SpannableStringBuilder f2 = this.f52560b.f(this.f52562d.getText());
        if (f2 != null) {
            this.f52560b.l(true);
            this.f52562d.setText(f2);
            if (z && this.f52560b.b() >= 0) {
                this.f52562d.requestFocus();
                this.f52562d.setSelection(this.f52560b.b());
            } else {
                this.f52562d.setSelection(selectionEnd);
            }
            d.a.j0.v3.c cVar = this.f52560b;
            cVar.k(cVar.b() >= 0);
        }
    }

    public void c() {
        this.f52559a.n(null);
        this.f52559a.i(null);
        this.f52559a.k(false);
    }

    public void d() {
        this.f52560b.n(null);
        this.f52560b.i(null);
        this.f52560b.k(false);
    }

    public d.a.j0.v3.c e() {
        return this.f52559a;
    }

    public EditText f() {
        return this.f52562d;
    }

    public d.a.j0.v3.c g() {
        return this.f52560b;
    }

    public PostWriteCallBackData h() {
        return this.f52563e;
    }

    public void i() {
        this.f52559a.g();
        this.f52560b.g();
        if (this.f52559a.d()) {
            a(false);
        }
        if (this.f52560b.d()) {
            b(false);
        }
    }

    public void j() {
        this.f52561c = null;
        this.f52562d = null;
    }

    public void k(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData == null) {
            return;
        }
        this.f52559a.i(postWriteCallBackData.getSensitiveWords());
        this.f52559a.n(postWriteCallBackData.getErrorString());
        if (ListUtils.isEmpty(this.f52559a.a())) {
            return;
        }
        a(true);
        this.f52563e = postWriteCallBackData;
    }

    public void l(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData == null) {
            return;
        }
        this.f52560b.i(postWriteCallBackData.getSensitiveWords());
        this.f52560b.n(postWriteCallBackData.getErrorString());
        if (ListUtils.isEmpty(this.f52560b.a())) {
            return;
        }
        b(true);
    }

    public void m(EditText editText) {
        this.f52561c = editText;
    }

    public void n(EditText editText) {
        this.f52562d = editText;
    }
}
