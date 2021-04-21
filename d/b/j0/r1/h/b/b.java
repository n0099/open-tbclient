package d.b.j0.r1.h.b;

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
import d.b.i0.w.m;
import d.b.j0.r1.h.b.c.d;
import d.b.j0.r1.h.f.c;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public EditText f61616a;

    /* renamed from: b  reason: collision with root package name */
    public ImageView f61617b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f61618c;

    /* renamed from: d  reason: collision with root package name */
    public ViewGroup f61619d;

    /* renamed from: e  reason: collision with root package name */
    public BaseActivity<?> f61620e;

    /* renamed from: f  reason: collision with root package name */
    public Window f61621f;

    /* renamed from: g  reason: collision with root package name */
    public ImageView f61622g;

    /* renamed from: h  reason: collision with root package name */
    public EditorTools f61623h;
    public FrameLayout i;
    public ProgressBar j;

    public b(BaseActivity<?> baseActivity, View.OnClickListener onClickListener, View.OnClickListener onClickListener2) {
        this.f61620e = baseActivity;
        Window window = baseActivity.getWindow();
        this.f61621f = window;
        this.f61619d = (ViewGroup) window.findViewById(R.id.tail_edit_root);
        this.f61616a = (EditText) this.f61621f.findViewById(R.id.tail_edit_edittext);
        ImageView imageView = (ImageView) this.f61621f.findViewById(R.id.tail_edit_submit);
        this.f61617b = imageView;
        imageView.setOnClickListener(onClickListener);
        ImageView imageView2 = (ImageView) this.f61621f.findViewById(R.id.tail_edit_cancel);
        this.f61622g = imageView2;
        imageView2.setOnClickListener(onClickListener2);
        this.f61618c = (TextView) this.f61621f.findViewById(R.id.tail_edit_text_number);
        this.i = (FrameLayout) this.f61621f.findViewById(R.id.tail_edit_editor);
        this.j = (ProgressBar) this.f61621f.findViewById(R.id.tail_edit_progress);
    }

    public void a(d.b.i0.w.b bVar, String str) {
        this.f61623h = new EditorTools(this.f61620e.getPageContext().getPageActivity());
        d();
        c(bVar);
        b(bVar, str);
        this.f61623h.f();
        this.f61623h.A(new d.b.i0.w.a(35, 5, Boolean.FALSE));
        this.f61623h.j();
        o(this.f61623h);
    }

    public final void b(d.b.i0.w.b bVar, String str) {
        this.f61623h.d(new d(this.f61620e.getPageContext(), 2, str));
        this.f61623h.setActionListener(26, bVar);
        this.f61623h.setActionListener(3, bVar);
    }

    public final void c(d.b.i0.w.b bVar) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(5);
        this.f61623h.h(arrayList);
        m n = this.f61623h.n(5);
        if (n != null) {
            n.j = 1;
            n.f(false);
        }
        this.f61623h.setActionListener(24, bVar);
    }

    public final void d() {
        this.f61623h.setBarMaxLauCount(4);
        this.f61623h.setBarLauncherType(1);
        this.f61623h.C(true);
        this.f61623h.setBackgroundColorId(R.color.CAM_X0201);
    }

    public void e() {
        if (this.f61616a.getSelectionStart() <= 0) {
            return;
        }
        String substring = this.f61616a.getText().toString().substring(0, this.f61616a.getSelectionStart());
        Matcher matcher = Pattern.compile("#\\([^#\\)\\(]+\\)$").matcher(substring);
        int i = 1;
        if (matcher.find()) {
            i = substring.length() - matcher.replaceFirst("").length();
        }
        this.f61616a.getText().delete(this.f61616a.getSelectionStart() - i, this.f61616a.getSelectionStart());
    }

    public void f() {
        this.f61620e.ShowSoftKeyPadDelay(this.f61616a);
        EditText editText = this.f61616a;
        editText.setSelection(editText.length());
    }

    public String g() {
        return this.f61616a.getText().toString();
    }

    public EditText h() {
        return this.f61616a;
    }

    public void i() {
        this.j.setVisibility(8);
    }

    public void j() {
        this.f61623h.q();
        this.f61623h.A(new d.b.i0.w.a(5, -1, null));
    }

    public void k() {
        EditText editText = this.f61616a;
        editText.setSelection(editText.length());
    }

    public void l(int i) {
        this.f61620e.getLayoutMode().k(i == 1);
        this.f61620e.getLayoutMode().j(this.f61619d);
        this.f61623h.w(i);
    }

    public void m(String str) {
        this.f61616a.setTextColor(c.a(str));
    }

    public void n(String str) {
        this.f61616a.setText(TbFaceManager.e().l(this.f61620e.getPageContext().getPageActivity(), str, null));
    }

    public void o(EditorTools editorTools) {
        this.i.addView(editorTools, new LinearLayout.LayoutParams(-1, -2));
    }

    public void p(boolean z) {
        this.f61617b.setEnabled(z);
    }

    public void q(int i, int i2) {
        TextView textView = this.f61618c;
        textView.setText(i + "/" + i2);
        int i3 = R.color.CAM_X0109;
        if (i == i2) {
            i3 = R.color.CAM_X0301;
        }
        SkinManager.setViewTextColor(this.f61618c, i3, 1);
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
