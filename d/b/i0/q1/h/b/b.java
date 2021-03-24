package d.b.i0.q1.h.b;

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
import d.b.i0.q1.h.b.c.d;
import d.b.i0.q1.h.f.c;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public EditText f59500a;

    /* renamed from: b  reason: collision with root package name */
    public ImageView f59501b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f59502c;

    /* renamed from: d  reason: collision with root package name */
    public ViewGroup f59503d;

    /* renamed from: e  reason: collision with root package name */
    public BaseActivity<?> f59504e;

    /* renamed from: f  reason: collision with root package name */
    public Window f59505f;

    /* renamed from: g  reason: collision with root package name */
    public ImageView f59506g;

    /* renamed from: h  reason: collision with root package name */
    public EditorTools f59507h;
    public FrameLayout i;
    public ProgressBar j;

    public b(BaseActivity<?> baseActivity, View.OnClickListener onClickListener, View.OnClickListener onClickListener2) {
        this.f59504e = baseActivity;
        Window window = baseActivity.getWindow();
        this.f59505f = window;
        this.f59503d = (ViewGroup) window.findViewById(R.id.tail_edit_root);
        this.f59500a = (EditText) this.f59505f.findViewById(R.id.tail_edit_edittext);
        ImageView imageView = (ImageView) this.f59505f.findViewById(R.id.tail_edit_submit);
        this.f59501b = imageView;
        imageView.setOnClickListener(onClickListener);
        ImageView imageView2 = (ImageView) this.f59505f.findViewById(R.id.tail_edit_cancel);
        this.f59506g = imageView2;
        imageView2.setOnClickListener(onClickListener2);
        this.f59502c = (TextView) this.f59505f.findViewById(R.id.tail_edit_text_number);
        this.i = (FrameLayout) this.f59505f.findViewById(R.id.tail_edit_editor);
        this.j = (ProgressBar) this.f59505f.findViewById(R.id.tail_edit_progress);
    }

    public void a(d.b.h0.w.b bVar, String str) {
        this.f59507h = new EditorTools(this.f59504e.getPageContext().getPageActivity());
        d();
        c(bVar);
        b(bVar, str);
        this.f59507h.f();
        this.f59507h.A(new d.b.h0.w.a(35, 5, Boolean.FALSE));
        this.f59507h.j();
        o(this.f59507h);
    }

    public final void b(d.b.h0.w.b bVar, String str) {
        this.f59507h.d(new d(this.f59504e.getPageContext(), 2, str));
        this.f59507h.setActionListener(26, bVar);
        this.f59507h.setActionListener(3, bVar);
    }

    public final void c(d.b.h0.w.b bVar) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(5);
        this.f59507h.h(arrayList);
        m n = this.f59507h.n(5);
        if (n != null) {
            n.j = 1;
            n.f(false);
        }
        this.f59507h.setActionListener(24, bVar);
    }

    public final void d() {
        this.f59507h.setBarMaxLauCount(4);
        this.f59507h.setBarLauncherType(1);
        this.f59507h.C(true);
        this.f59507h.setBackgroundColorId(R.color.CAM_X0201);
    }

    public void e() {
        if (this.f59500a.getSelectionStart() <= 0) {
            return;
        }
        String substring = this.f59500a.getText().toString().substring(0, this.f59500a.getSelectionStart());
        Matcher matcher = Pattern.compile("#\\([^#\\)\\(]+\\)$").matcher(substring);
        int i = 1;
        if (matcher.find()) {
            i = substring.length() - matcher.replaceFirst("").length();
        }
        this.f59500a.getText().delete(this.f59500a.getSelectionStart() - i, this.f59500a.getSelectionStart());
    }

    public void f() {
        this.f59504e.ShowSoftKeyPadDelay(this.f59500a);
        EditText editText = this.f59500a;
        editText.setSelection(editText.length());
    }

    public String g() {
        return this.f59500a.getText().toString();
    }

    public EditText h() {
        return this.f59500a;
    }

    public void i() {
        this.j.setVisibility(8);
    }

    public void j() {
        this.f59507h.q();
        this.f59507h.A(new d.b.h0.w.a(5, -1, null));
    }

    public void k() {
        EditText editText = this.f59500a;
        editText.setSelection(editText.length());
    }

    public void l(int i) {
        this.f59504e.getLayoutMode().k(i == 1);
        this.f59504e.getLayoutMode().j(this.f59503d);
        this.f59507h.w(i);
    }

    public void m(String str) {
        this.f59500a.setTextColor(c.a(str));
    }

    public void n(String str) {
        this.f59500a.setText(TbFaceManager.e().l(this.f59504e.getPageContext().getPageActivity(), str, null));
    }

    public void o(EditorTools editorTools) {
        this.i.addView(editorTools, new LinearLayout.LayoutParams(-1, -2));
    }

    public void p(boolean z) {
        this.f59501b.setEnabled(z);
    }

    public void q(int i, int i2) {
        TextView textView = this.f59502c;
        textView.setText(i + "/" + i2);
        int i3 = R.color.CAM_X0109;
        if (i == i2) {
            i3 = R.color.CAM_X0301;
        }
        SkinManager.setViewTextColor(this.f59502c, i3, 1);
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
