package d.a.o0.w3.u;

import android.text.Editable;
import android.text.Spannable;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.widget.EditText;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.spanGroup.TbLinkForegroundColorSpan;
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes5.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public ArrayList<String> f66838a;

    /* renamed from: b  reason: collision with root package name */
    public String f66839b;

    public final void a(Spannable spannable) {
        Matcher matcher = Pattern.compile("@[\\u4e00-\\u9fa5\\w\\ud83c\\udc00-\\ud83c\\udfff\\ud83d\\udc00-\\ud83d\\udfff\\u2600-\\u27ff]+").matcher(spannable);
        while (matcher.find()) {
            spannable.setSpan(new ForegroundColorSpan(SkinManager.getColor(R.color.CAM_X0304)), matcher.start(), matcher.end(), 33);
        }
    }

    public boolean b(EditText editText) {
        Editable text;
        if (editText == null || (text = editText.getText()) == null) {
            return false;
        }
        int e2 = e(text);
        if (e2 > 0) {
            editText.requestFocus();
            editText.setSelection(e2);
            return true;
        }
        editText.setSelection(editText.getSelectionEnd());
        return false;
    }

    public boolean c(EditText editText, EditText editText2) {
        if (ListUtils.isEmpty(d())) {
            return false;
        }
        return b(editText) || b(editText2);
    }

    public ArrayList<String> d() {
        return this.f66838a;
    }

    public int e(Spanned spanned) {
        if (spanned == null) {
            return 0;
        }
        BackgroundColorSpan[] backgroundColorSpanArr = (BackgroundColorSpan[]) spanned.getSpans(0, spanned.length(), BackgroundColorSpan.class);
        int length = spanned.length();
        return (backgroundColorSpanArr == null || backgroundColorSpanArr.length <= 0) ? length : spanned.getSpanEnd(backgroundColorSpanArr[0]);
    }

    public String f() {
        return this.f66839b;
    }

    public boolean g(Spannable spannable) {
        return Pattern.compile("@[\\u4e00-\\u9fa5\\w\\ud83c\\udc00-\\ud83c\\udfff\\ud83d\\udc00-\\ud83d\\udfff\\u2600-\\u27ff]+").matcher(spannable).find();
    }

    public void h(EditText editText, boolean z) {
        Editable text;
        Object[] spans;
        if (editText == null || (text = editText.getText()) == null) {
            return;
        }
        for (Object obj : text.getSpans(0, text.length(), Object.class)) {
            if (((obj instanceof ForegroundColorSpan) && !(obj instanceof TbLinkForegroundColorSpan)) || (obj instanceof BackgroundColorSpan)) {
                text.removeSpan(obj);
            }
        }
        d.a.n0.p0.b.k(text);
        if (!z) {
            a(text);
        }
        k(text);
    }

    public void i(EditText editText, EditText editText2) {
        j(editText, true);
        j(editText2, false);
        c(editText, editText2);
    }

    public void j(EditText editText, boolean z) {
        if (editText == null) {
            return;
        }
        h(editText, z);
    }

    public final void k(Spannable spannable) {
        if (spannable == null || ListUtils.isEmpty(this.f66838a)) {
            return;
        }
        String obj = spannable.toString();
        if (TextUtils.isEmpty(obj)) {
            return;
        }
        Iterator<String> it = this.f66838a.iterator();
        while (it.hasNext()) {
            l(spannable, obj, it.next());
        }
    }

    public final void l(Spannable spannable, String str, String str2) {
        if (spannable == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        int indexOf = str.indexOf(str2);
        int length = str2.length();
        while (indexOf >= 0) {
            int i2 = indexOf + length;
            int color = SkinManager.getColor(R.color.CAM_X0101);
            int color2 = SkinManager.getColor(R.color.cp_cont_h_alpha85);
            ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(color);
            BackgroundColorSpan backgroundColorSpan = new BackgroundColorSpan(color2);
            spannable.setSpan(foregroundColorSpan, indexOf, i2, 33);
            spannable.setSpan(backgroundColorSpan, indexOf, i2, 33);
            indexOf = str.indexOf(str2, i2);
        }
    }

    public void m(EditText editText, EditText editText2) {
        i(editText, editText2);
    }

    public void n(ArrayList<String> arrayList) {
        this.f66838a = arrayList;
    }

    public void o(String str) {
        this.f66839b = str;
    }
}
