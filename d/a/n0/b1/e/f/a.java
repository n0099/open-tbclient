package d.a.n0.b1.e.f;

import android.graphics.Rect;
import android.os.Build;
import android.view.View;
import android.widget.PopupWindow;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ViewCommonUtil;
/* loaded from: classes4.dex */
public class a extends PopupWindow {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f55198a;

    /* renamed from: b  reason: collision with root package name */
    public InterfaceC1252a f55199b;

    /* renamed from: d.a.n0.b1.e.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC1252a {
        void a();
    }

    public a(TbPageContext tbPageContext, View view, int i2, int i3) {
        super(view, i2, i3);
        this.f55198a = tbPageContext;
    }

    public void a() {
        super.dismiss();
    }

    public void b(InterfaceC1252a interfaceC1252a) {
        this.f55199b = interfaceC1252a;
    }

    @Override // android.widget.PopupWindow
    public void dismiss() {
        InterfaceC1252a interfaceC1252a = this.f55199b;
        if (interfaceC1252a != null) {
            interfaceC1252a.a();
        } else {
            super.dismiss();
        }
    }

    @Override // android.widget.PopupWindow
    public void showAsDropDown(View view) {
        if (Build.VERSION.SDK_INT >= 24) {
            Rect rect = new Rect();
            view.getGlobalVisibleRect(rect);
            setHeight(ViewCommonUtil.getScreenFullSize(this.f55198a.getPageActivity())[1] - rect.bottom);
        }
        super.showAsDropDown(view);
    }

    @Override // android.widget.PopupWindow
    public void showAsDropDown(View view, int i2, int i3) {
        if (Build.VERSION.SDK_INT >= 24) {
            Rect rect = new Rect();
            view.getGlobalVisibleRect(rect);
            setHeight(ViewCommonUtil.getScreenFullSize(this.f55198a.getPageActivity())[1] - rect.bottom);
        }
        super.showAsDropDown(view, i2, i3);
    }
}
