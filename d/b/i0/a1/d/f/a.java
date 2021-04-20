package d.b.i0.a1.d.f;

import android.graphics.Rect;
import android.os.Build;
import android.view.View;
import android.widget.PopupWindow;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ViewCommonUtil;
/* loaded from: classes4.dex */
public class a extends PopupWindow {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f52531a;

    /* renamed from: b  reason: collision with root package name */
    public InterfaceC1145a f52532b;

    /* renamed from: d.b.i0.a1.d.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC1145a {
        void a();
    }

    public a(TbPageContext tbPageContext, View view, int i, int i2) {
        super(view, i, i2);
        this.f52531a = tbPageContext;
    }

    public void a() {
        super.dismiss();
    }

    public void b(InterfaceC1145a interfaceC1145a) {
        this.f52532b = interfaceC1145a;
    }

    @Override // android.widget.PopupWindow
    public void dismiss() {
        InterfaceC1145a interfaceC1145a = this.f52532b;
        if (interfaceC1145a != null) {
            interfaceC1145a.a();
        } else {
            super.dismiss();
        }
    }

    @Override // android.widget.PopupWindow
    public void showAsDropDown(View view) {
        if (Build.VERSION.SDK_INT >= 24) {
            Rect rect = new Rect();
            view.getGlobalVisibleRect(rect);
            setHeight(ViewCommonUtil.getScreenFullSize(this.f52531a.getPageActivity())[1] - rect.bottom);
        }
        super.showAsDropDown(view);
    }

    @Override // android.widget.PopupWindow
    public void showAsDropDown(View view, int i, int i2) {
        if (Build.VERSION.SDK_INT >= 24) {
            Rect rect = new Rect();
            view.getGlobalVisibleRect(rect);
            setHeight(ViewCommonUtil.getScreenFullSize(this.f52531a.getPageActivity())[1] - rect.bottom);
        }
        super.showAsDropDown(view, i, i2);
    }
}
