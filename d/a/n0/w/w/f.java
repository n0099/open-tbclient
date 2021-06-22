package d.a.n0.w.w;

import android.content.Context;
import android.text.TextWatcher;
import android.widget.EditText;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.editortools.pb.PbNewInputContainer;
import com.baidu.tieba.R;
import d.a.n0.w.m;
import d.a.n0.w.n;
/* loaded from: classes3.dex */
public class f extends m {
    public EditText q;

    public f(Context context, boolean z, boolean z2) {
        super(context, (String) null, 27);
        this.m = false;
        this.l = 3;
        PbNewInputContainer pbNewInputContainer = new PbNewInputContainer(context);
        this.k = pbNewInputContainer;
        pbNewInputContainer.setTransLink(!z);
        this.q = ((PbNewInputContainer) this.k).getInputView();
        ((PbNewInputContainer) this.k).setHint(context.getString(R.string.say_your_point));
        ((PbNewInputContainer) this.k).y(z2);
        this.n = new int[]{4, 17, 24, 3, 9, 6, 44, 12, 10, 13, 11, 28, 29, 39, 45};
    }

    public void g(TextWatcher textWatcher) {
        this.q.addTextChangedListener(textWatcher);
    }

    public void h(int i2) {
        n nVar = this.k;
        if (nVar != null) {
            ((PbNewInputContainer) nVar).p(i2);
        }
    }

    public EditText i() {
        return this.q;
    }

    public void j(TextWatcher textWatcher) {
        this.q.removeTextChangedListener(textWatcher);
    }

    public void k(String str) {
        if (this.k == null || StringUtils.isNull(str)) {
            return;
        }
        ((PbNewInputContainer) this.k).setDefaultHint(str);
    }

    public void l(String str) {
        if (this.k == null || StringUtils.isNull(str)) {
            return;
        }
        ((PbNewInputContainer) this.k).setHint(str);
    }

    public void m(int i2) {
        n nVar = this.k;
        if (nVar != null) {
            ((PbNewInputContainer) nVar).setType(i2);
        }
    }
}
