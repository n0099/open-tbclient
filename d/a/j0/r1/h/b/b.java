package d.a.j0.r1.h.b;

import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.imageManager.TbFaceManager;
import com.baidu.tieba.R;
import com.baidu.tieba.memberCenter.tail.data.TailData;
import d.a.i0.w.m;
import d.a.j0.r1.h.b.c.d;
import d.a.j0.r1.h.f.c;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public EditText f59770a;

    /* renamed from: b  reason: collision with root package name */
    public ImageView f59771b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f59772c;

    /* renamed from: d  reason: collision with root package name */
    public ViewGroup f59773d;

    /* renamed from: e  reason: collision with root package name */
    public BaseActivity<?> f59774e;

    /* renamed from: f  reason: collision with root package name */
    public Window f59775f;

    /* renamed from: g  reason: collision with root package name */
    public ImageView f59776g;

    /* renamed from: h  reason: collision with root package name */
    public EditorTools f59777h;

    /* renamed from: i  reason: collision with root package name */
    public FrameLayout f59778i;
    public ProgressBar j;

    public b(BaseActivity<?> baseActivity, View.OnClickListener onClickListener, View.OnClickListener onClickListener2) {
        this.f59774e = baseActivity;
        Window window = baseActivity.getWindow();
        this.f59775f = window;
        this.f59773d = (ViewGroup) window.findViewById(R.id.tail_edit_root);
        this.f59770a = (EditText) this.f59775f.findViewById(R.id.tail_edit_edittext);
        ImageView imageView = (ImageView) this.f59775f.findViewById(R.id.tail_edit_submit);
        this.f59771b = imageView;
        imageView.setOnClickListener(onClickListener);
        ImageView imageView2 = (ImageView) this.f59775f.findViewById(R.id.tail_edit_cancel);
        this.f59776g = imageView2;
        imageView2.setOnClickListener(onClickListener2);
        this.f59772c = (TextView) this.f59775f.findViewById(R.id.tail_edit_text_number);
        this.f59778i = (FrameLayout) this.f59775f.findViewById(R.id.tail_edit_editor);
        this.j = (ProgressBar) this.f59775f.findViewById(R.id.tail_edit_progress);
    }

    public void a(d.a.i0.w.b bVar, String str) {
        this.f59777h = new EditorTools(this.f59774e.getPageContext().getPageActivity());
        d();
        c(bVar);
        b(bVar, str);
        this.f59777h.f();
        this.f59777h.A(new d.a.i0.w.a(35, 5, Boolean.FALSE));
        this.f59777h.j();
        o(this.f59777h);
    }

    public final void b(d.a.i0.w.b bVar, String str) {
        this.f59777h.d(new d(this.f59774e.getPageContext(), 2, str));
        this.f59777h.setActionListener(26, bVar);
        this.f59777h.setActionListener(3, bVar);
    }

    public final void c(d.a.i0.w.b bVar) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(5);
        this.f59777h.h(arrayList);
        m n = this.f59777h.n(5);
        if (n != null) {
            n.j = 1;
            n.f(false);
        }
        this.f59777h.setActionListener(24, bVar);
    }

    public final void d() {
        this.f59777h.setBarMaxLauCount(4);
        this.f59777h.setBarLauncherType(1);
        this.f59777h.C(true);
        this.f59777h.setBackgroundColorId(R.color.CAM_X0201);
    }

    public void e() {
        if (this.f59770a.getSelectionStart() <= 0) {
            return;
        }
        String substring = this.f59770a.getText().toString().substring(0, this.f59770a.getSelectionStart());
        Matcher matcher = Pattern.compile("#\\([^#\\)\\(]+\\)$").matcher(substring);
        int i2 = 1;
        if (matcher.find()) {
            i2 = substring.length() - matcher.replaceFirst("").length();
        }
        this.f59770a.getText().delete(this.f59770a.getSelectionStart() - i2, this.f59770a.getSelectionStart());
    }

    public void f() {
        this.f59774e.ShowSoftKeyPadDelay(this.f59770a);
        EditText editText = this.f59770a;
        editText.setSelection(editText.length());
    }

    public String g() {
        return this.f59770a.getText().toString();
    }

    public EditText h() {
        return this.f59770a;
    }

    public void i() {
        this.j.setVisibility(8);
    }

    public void j() {
        this.f59777h.q();
        this.f59777h.A(new d.a.i0.w.a(5, -1, null));
    }

    public void k() {
        EditText editText = this.f59770a;
        editText.setSelection(editText.length());
    }

    public void l(int i2) {
        this.f59774e.getLayoutMode().k(i2 == 1);
        this.f59774e.getLayoutMode().j(this.f59773d);
        this.f59777h.w(i2);
    }

    public void m(String str) {
        this.f59770a.setTextColor(c.a(str));
    }

    public void n(String str) {
        this.f59770a.setText(TbFaceManager.e().l(this.f59774e.getPageContext().getPageActivity(), str, null));
    }

    public void o(EditorTools editorTools) {
        this.f59778i.addView(editorTools, new LinearLayout.LayoutParams(-1, -2));
    }

    public void p(boolean z) {
        this.f59771b.setEnabled(z);
    }

    public void q(int i2, int i3) {
        TextView textView = this.f59772c;
        textView.setText(i2 + "/" + i3);
        int i4 = R.color.CAM_X0109;
        if (i2 == i3) {
            i4 = R.color.CAM_X0301;
        }
        SkinManager.setViewTextColor(this.f59772c, i4, 1);
    }

    public void r() {
        this.j.setVisibility(0);
    }

    public void s(TailData tailData) {
        if (tailData != null) {
            n(tailData.getContent());
            m(tailData.getFontColor());
        }
    }
}
