package d.b.i0.z0.d.f;

import android.graphics.Rect;
import android.os.Build;
import android.view.View;
import android.widget.PopupWindow;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ViewCommonUtil;
/* loaded from: classes4.dex */
public class a extends PopupWindow {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f62911a;

    /* renamed from: b  reason: collision with root package name */
    public InterfaceC1692a f62912b;

    /* renamed from: d.b.i0.z0.d.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC1692a {
        void a();
    }

    public a(TbPageContext tbPageContext, View view, int i, int i2) {
        super(view, i, i2);
        this.f62911a = tbPageContext;
    }

    public void a() {
        super.dismiss();
    }

    public void b(InterfaceC1692a interfaceC1692a) {
        this.f62912b = interfaceC1692a;
    }

    @Override // android.widget.PopupWindow
    public void dismiss() {
        InterfaceC1692a interfaceC1692a = this.f62912b;
        if (interfaceC1692a != null) {
            interfaceC1692a.a();
        } else {
            super.dismiss();
        }
    }

    @Override // android.widget.PopupWindow
    public void showAsDropDown(View view) {
        if (Build.VERSION.SDK_INT >= 24) {
            Rect rect = new Rect();
            view.getGlobalVisibleRect(rect);
            setHeight(ViewCommonUtil.getScreenFullSize(this.f62911a.getPageActivity())[1] - rect.bottom);
        }
        super.showAsDropDown(view);
    }

    @Override // android.widget.PopupWindow
    public void showAsDropDown(View view, int i, int i2) {
        if (Build.VERSION.SDK_INT >= 24) {
            Rect rect = new Rect();
            view.getGlobalVisibleRect(rect);
            setHeight(ViewCommonUtil.getScreenFullSize(this.f62911a.getPageActivity())[1] - rect.bottom);
        }
        super.showAsDropDown(view, i, i2);
    }
}
