package d.a.n0.b1.d.f;

import android.graphics.Rect;
import android.os.Build;
import android.view.View;
import android.widget.PopupWindow;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ViewCommonUtil;
/* loaded from: classes4.dex */
public class a extends PopupWindow {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f51515a;

    /* renamed from: b  reason: collision with root package name */
    public InterfaceC1196a f51516b;

    /* renamed from: d.a.n0.b1.d.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC1196a {
        void a();
    }

    public a(TbPageContext tbPageContext, View view, int i2, int i3) {
        super(view, i2, i3);
        this.f51515a = tbPageContext;
    }

    public void a() {
        super.dismiss();
    }

    public void b(InterfaceC1196a interfaceC1196a) {
        this.f51516b = interfaceC1196a;
    }

    @Override // android.widget.PopupWindow
    public void dismiss() {
        InterfaceC1196a interfaceC1196a = this.f51516b;
        if (interfaceC1196a != null) {
            interfaceC1196a.a();
        } else {
            super.dismiss();
        }
    }

    @Override // android.widget.PopupWindow
    public void showAsDropDown(View view) {
        if (Build.VERSION.SDK_INT >= 24) {
            Rect rect = new Rect();
            view.getGlobalVisibleRect(rect);
            setHeight(ViewCommonUtil.getScreenFullSize(this.f51515a.getPageActivity())[1] - rect.bottom);
        }
        super.showAsDropDown(view);
    }

    @Override // android.widget.PopupWindow
    public void showAsDropDown(View view, int i2, int i3) {
        if (Build.VERSION.SDK_INT >= 24) {
            Rect rect = new Rect();
            view.getGlobalVisibleRect(rect);
            setHeight(ViewCommonUtil.getScreenFullSize(this.f51515a.getPageActivity())[1] - rect.bottom);
        }
        super.showAsDropDown(view, i2, i3);
    }
}
