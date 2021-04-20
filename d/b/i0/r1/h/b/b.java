package d.b.i0.r1.h.b;

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
import d.b.h0.w.m;
import d.b.i0.r1.h.b.c.d;
import d.b.i0.r1.h.f.c;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public EditText f61195a;

    /* renamed from: b  reason: collision with root package name */
    public ImageView f61196b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f61197c;

    /* renamed from: d  reason: collision with root package name */
    public ViewGroup f61198d;

    /* renamed from: e  reason: collision with root package name */
    public BaseActivity<?> f61199e;

    /* renamed from: f  reason: collision with root package name */
    public Window f61200f;

    /* renamed from: g  reason: collision with root package name */
    public ImageView f61201g;

    /* renamed from: h  reason: collision with root package name */
    public EditorTools f61202h;
    public FrameLayout i;
    public ProgressBar j;

    public b(BaseActivity<?> baseActivity, View.OnClickListener onClickListener, View.OnClickListener onClickListener2) {
        this.f61199e = baseActivity;
        Window window = baseActivity.getWindow();
        this.f61200f = window;
        this.f61198d = (ViewGroup) window.findViewById(R.id.tail_edit_root);
        this.f61195a = (EditText) this.f61200f.findViewById(R.id.tail_edit_edittext);
        ImageView imageView = (ImageView) this.f61200f.findViewById(R.id.tail_edit_submit);
        this.f61196b = imageView;
        imageView.setOnClickListener(onClickListener);
        ImageView imageView2 = (ImageView) this.f61200f.findViewById(R.id.tail_edit_cancel);
        this.f61201g = imageView2;
        imageView2.setOnClickListener(onClickListener2);
        this.f61197c = (TextView) this.f61200f.findViewById(R.id.tail_edit_text_number);
        this.i = (FrameLayout) this.f61200f.findViewById(R.id.tail_edit_editor);
        this.j = (ProgressBar) this.f61200f.findViewById(R.id.tail_edit_progress);
    }

    public void a(d.b.h0.w.b bVar, String str) {
        this.f61202h = new EditorTools(this.f61199e.getPageContext().getPageActivity());
        d();
        c(bVar);
        b(bVar, str);
        this.f61202h.f();
        this.f61202h.A(new d.b.h0.w.a(35, 5, Boolean.FALSE));
        this.f61202h.j();
        o(this.f61202h);
    }

    public final void b(d.b.h0.w.b bVar, String str) {
        this.f61202h.d(new d(this.f61199e.getPageContext(), 2, str));
        this.f61202h.setActionListener(26, bVar);
        this.f61202h.setActionListener(3, bVar);
    }

    public final void c(d.b.h0.w.b bVar) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(5);
        this.f61202h.h(arrayList);
        m n = this.f61202h.n(5);
        if (n != null) {
            n.j = 1;
            n.f(false);
        }
        this.f61202h.setActionListener(24, bVar);
    }

    public final void d() {
        this.f61202h.setBarMaxLauCount(4);
        this.f61202h.setBarLauncherType(1);
        this.f61202h.C(true);
        this.f61202h.setBackgroundColorId(R.color.CAM_X0201);
    }

    public void e() {
        if (this.f61195a.getSelectionStart() <= 0) {
            return;
        }
        String substring = this.f61195a.getText().toString().substring(0, this.f61195a.getSelectionStart());
        Matcher matcher = Pattern.compile("#\\([^#\\)\\(]+\\)$").matcher(substring);
        int i = 1;
        if (matcher.find()) {
            i = substring.length() - matcher.replaceFirst("").length();
        }
        this.f61195a.getText().delete(this.f61195a.getSelectionStart() - i, this.f61195a.getSelectionStart());
    }

    public void f() {
        this.f61199e.ShowSoftKeyPadDelay(this.f61195a);
        EditText editText = this.f61195a;
        editText.setSelection(editText.length());
    }

    public String g() {
        return this.f61195a.getText().toString();
    }

    public EditText h() {
        return this.f61195a;
    }

    public void i() {
        this.j.setVisibility(8);
    }

    public void j() {
        this.f61202h.q();
        this.f61202h.A(new d.b.h0.w.a(5, -1, null));
    }

    public void k() {
        EditText editText = this.f61195a;
        editText.setSelection(editText.length());
    }

    public void l(int i) {
        this.f61199e.getLayoutMode().k(i == 1);
        this.f61199e.getLayoutMode().j(this.f61198d);
        this.f61202h.w(i);
    }

    public void m(String str) {
        this.f61195a.setTextColor(c.a(str));
    }

    public void n(String str) {
        this.f61195a.setText(TbFaceManager.e().l(this.f61199e.getPageContext().getPageActivity(), str, null));
    }

    public void o(EditorTools editorTools) {
        this.i.addView(editorTools, new LinearLayout.LayoutParams(-1, -2));
    }

    public void p(boolean z) {
        this.f61196b.setEnabled(z);
    }

    public void q(int i, int i2) {
        TextView textView = this.f61197c;
        textView.setText(i + "/" + i2);
        int i3 = R.color.CAM_X0109;
        if (i == i2) {
            i3 = R.color.CAM_X0301;
        }
        SkinManager.setViewTextColor(this.f61197c, i3, 1);
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
