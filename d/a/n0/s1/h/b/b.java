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
    public EditText f60638a;

    /* renamed from: b  reason: collision with root package name */
    public ImageView f60639b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f60640c;

    /* renamed from: d  reason: collision with root package name */
    public ViewGroup f60641d;

    /* renamed from: e  reason: collision with root package name */
    public BaseActivity<?> f60642e;

    /* renamed from: f  reason: collision with root package name */
    public Window f60643f;

    /* renamed from: g  reason: collision with root package name */
    public ImageView f60644g;

    /* renamed from: h  reason: collision with root package name */
    public EditorTools f60645h;

    /* renamed from: i  reason: collision with root package name */
    public FrameLayout f60646i;
    public ProgressBar j;

    public b(BaseActivity<?> baseActivity, View.OnClickListener onClickListener, View.OnClickListener onClickListener2) {
        this.f60642e = baseActivity;
        Window window = baseActivity.getWindow();
        this.f60643f = window;
        this.f60641d = (ViewGroup) window.findViewById(R.id.tail_edit_root);
        this.f60638a = (EditText) this.f60643f.findViewById(R.id.tail_edit_edittext);
        ImageView imageView = (ImageView) this.f60643f.findViewById(R.id.tail_edit_submit);
        this.f60639b = imageView;
        imageView.setOnClickListener(onClickListener);
        ImageView imageView2 = (ImageView) this.f60643f.findViewById(R.id.tail_edit_cancel);
        this.f60644g = imageView2;
        imageView2.setOnClickListener(onClickListener2);
        this.f60640c = (TextView) this.f60643f.findViewById(R.id.tail_edit_text_number);
        this.f60646i = (FrameLayout) this.f60643f.findViewById(R.id.tail_edit_editor);
        this.j = (ProgressBar) this.f60643f.findViewById(R.id.tail_edit_progress);
    }

    public void a(d.a.m0.w.b bVar, String str) {
        this.f60645h = new EditorTools(this.f60642e.getPageContext().getPageActivity());
        d();
        c(bVar);
        b(bVar, str);
        this.f60645h.f();
        this.f60645h.A(new d.a.m0.w.a(35, 5, Boolean.FALSE));
        this.f60645h.j();
        o(this.f60645h);
    }

    public final void b(d.a.m0.w.b bVar, String str) {
        this.f60645h.d(new d(this.f60642e.getPageContext(), 2, str));
        this.f60645h.setActionListener(26, bVar);
        this.f60645h.setActionListener(3, bVar);
    }

    public final void c(d.a.m0.w.b bVar) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(5);
        this.f60645h.h(arrayList);
        m n = this.f60645h.n(5);
        if (n != null) {
            n.j = 1;
            n.f(false);
        }
        this.f60645h.setActionListener(24, bVar);
    }

    public final void d() {
        this.f60645h.setBarMaxLauCount(4);
        this.f60645h.setBarLauncherType(1);
        this.f60645h.C(true);
        this.f60645h.setBackgroundColorId(R.color.CAM_X0201);
    }

    public void e() {
        if (this.f60638a.getSelectionStart() <= 0) {
            return;
        }
        String substring = this.f60638a.getText().toString().substring(0, this.f60638a.getSelectionStart());
        Matcher matcher = Pattern.compile("#\\([^#\\)\\(]+\\)$").matcher(substring);
        int i2 = 1;
        if (matcher.find()) {
            i2 = substring.length() - matcher.replaceFirst("").length();
        }
        this.f60638a.getText().delete(this.f60638a.getSelectionStart() - i2, this.f60638a.getSelectionStart());
    }

    public void f() {
        this.f60642e.ShowSoftKeyPadDelay(this.f60638a);
        EditText editText = this.f60638a;
        editText.setSelection(editText.length());
    }

    public String g() {
        return this.f60638a.getText().toString();
    }

    public EditText h() {
        return this.f60638a;
    }

    public void i() {
        this.j.setVisibility(8);
    }

    public void j() {
        this.f60645h.q();
        this.f60645h.A(new d.a.m0.w.a(5, -1, null));
    }

    public void k() {
        EditText editText = this.f60638a;
        editText.setSelection(editText.length());
    }

    public void l(int i2) {
        this.f60642e.getLayoutMode().k(i2 == 1);
        this.f60642e.getLayoutMode().j(this.f60641d);
        this.f60645h.w(i2);
    }

    public void m(String str) {
        this.f60638a.setTextColor(c.a(str));
    }

    public void n(String str) {
        this.f60638a.setText(TbFaceManager.e().l(this.f60642e.getPageContext().getPageActivity(), str, null));
    }

    public void o(EditorTools editorTools) {
        this.f60646i.addView(editorTools, new LinearLayout.LayoutParams(-1, -2));
    }

    public void p(boolean z) {
        this.f60639b.setEnabled(z);
    }

    public void q(int i2, int i3) {
        TextView textView = this.f60640c;
        textView.setText(i2 + "/" + i3);
        int i4 = R.color.CAM_X0109;
        if (i2 == i3) {
            i4 = R.color.CAM_X0301;
        }
        SkinManager.setViewTextColor(this.f60640c, i4, 1);
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
