package d.a.n0.s1.h.b;

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
import d.a.m0.w.m;
import d.a.n0.s1.h.b.c.d;
import d.a.n0.s1.h.f.c;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public EditText f64329a;

    /* renamed from: b  reason: collision with root package name */
    public ImageView f64330b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f64331c;

    /* renamed from: d  reason: collision with root package name */
    public ViewGroup f64332d;

    /* renamed from: e  reason: collision with root package name */
    public BaseActivity<?> f64333e;

    /* renamed from: f  reason: collision with root package name */
    public Window f64334f;

    /* renamed from: g  reason: collision with root package name */
    public ImageView f64335g;

    /* renamed from: h  reason: collision with root package name */
    public EditorTools f64336h;

    /* renamed from: i  reason: collision with root package name */
    public FrameLayout f64337i;
    public ProgressBar j;

    public b(BaseActivity<?> baseActivity, View.OnClickListener onClickListener, View.OnClickListener onClickListener2) {
        this.f64333e = baseActivity;
        Window window = baseActivity.getWindow();
        this.f64334f = window;
        this.f64332d = (ViewGroup) window.findViewById(R.id.tail_edit_root);
        this.f64329a = (EditText) this.f64334f.findViewById(R.id.tail_edit_edittext);
        ImageView imageView = (ImageView) this.f64334f.findViewById(R.id.tail_edit_submit);
        this.f64330b = imageView;
        imageView.setOnClickListener(onClickListener);
        ImageView imageView2 = (ImageView) this.f64334f.findViewById(R.id.tail_edit_cancel);
        this.f64335g = imageView2;
        imageView2.setOnClickListener(onClickListener2);
        this.f64331c = (TextView) this.f64334f.findViewById(R.id.tail_edit_text_number);
        this.f64337i = (FrameLayout) this.f64334f.findViewById(R.id.tail_edit_editor);
        this.j = (ProgressBar) this.f64334f.findViewById(R.id.tail_edit_progress);
    }

    public void a(d.a.m0.w.b bVar, String str) {
        this.f64336h = new EditorTools(this.f64333e.getPageContext().getPageActivity());
        d();
        c(bVar);
        b(bVar, str);
        this.f64336h.f();
        this.f64336h.A(new d.a.m0.w.a(35, 5, Boolean.FALSE));
        this.f64336h.j();
        o(this.f64336h);
    }

    public final void b(d.a.m0.w.b bVar, String str) {
        this.f64336h.d(new d(this.f64333e.getPageContext(), 2, str));
        this.f64336h.setActionListener(26, bVar);
        this.f64336h.setActionListener(3, bVar);
    }

    public final void c(d.a.m0.w.b bVar) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(5);
        this.f64336h.h(arrayList);
        m n = this.f64336h.n(5);
        if (n != null) {
            n.j = 1;
            n.f(false);
        }
        this.f64336h.setActionListener(24, bVar);
    }

    public final void d() {
        this.f64336h.setBarMaxLauCount(4);
        this.f64336h.setBarLauncherType(1);
        this.f64336h.C(true);
        this.f64336h.setBackgroundColorId(R.color.CAM_X0201);
    }

    public void e() {
        if (this.f64329a.getSelectionStart() <= 0) {
            return;
        }
        String substring = this.f64329a.getText().toString().substring(0, this.f64329a.getSelectionStart());
        Matcher matcher = Pattern.compile("#\\([^#\\)\\(]+\\)$").matcher(substring);
        int i2 = 1;
        if (matcher.find()) {
            i2 = substring.length() - matcher.replaceFirst("").length();
        }
        this.f64329a.getText().delete(this.f64329a.getSelectionStart() - i2, this.f64329a.getSelectionStart());
    }

    public void f() {
        this.f64333e.ShowSoftKeyPadDelay(this.f64329a);
        EditText editText = this.f64329a;
        editText.setSelection(editText.length());
    }

    public String g() {
        return this.f64329a.getText().toString();
    }

    public EditText h() {
        return this.f64329a;
    }

    public void i() {
        this.j.setVisibility(8);
    }

    public void j() {
        this.f64336h.q();
        this.f64336h.A(new d.a.m0.w.a(5, -1, null));
    }

    public void k() {
        EditText editText = this.f64329a;
        editText.setSelection(editText.length());
    }

    public void l(int i2) {
        this.f64333e.getLayoutMode().k(i2 == 1);
        this.f64333e.getLayoutMode().j(this.f64332d);
        this.f64336h.w(i2);
    }

    public void m(String str) {
        this.f64329a.setTextColor(c.a(str));
    }

    public void n(String str) {
        this.f64329a.setText(TbFaceManager.e().l(this.f64333e.getPageContext().getPageActivity(), str, null));
    }

    public void o(EditorTools editorTools) {
        this.f64337i.addView(editorTools, new LinearLayout.LayoutParams(-1, -2));
    }

    public void p(boolean z) {
        this.f64330b.setEnabled(z);
    }

    public void q(int i2, int i3) {
        TextView textView = this.f64331c;
        textView.setText(i2 + "/" + i3);
        int i4 = R.color.CAM_X0109;
        if (i2 == i3) {
            i4 = R.color.CAM_X0301;
        }
        SkinManager.setViewTextColor(this.f64331c, i4, 1);
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
