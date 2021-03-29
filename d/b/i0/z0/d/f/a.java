package d.b.i0.z0.d.f;

import android.graphics.Rect;
import android.os.Build;
import android.view.View;
import android.widget.PopupWindow;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ViewCommonUtil;
/* loaded from: classes3.dex */
public class a extends PopupWindow {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f62912a;

    /* renamed from: b  reason: collision with root package name */
    public InterfaceC1693a f62913b;

    /* renamed from: d.b.i0.z0.d.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC1693a {
        void a();
    }

    public a(TbPageContext tbPageContext, View view, int i, int i2) {
        super(view, i, i2);
        this.f62912a = tbPageContext;
    }

    public void a() {
        super.dismiss();
    }

    public void b(InterfaceC1693a interfaceC1693a) {
        this.f62913b = interfaceC1693a;
    }

    @Override // android.widget.PopupWindow
    public void dismiss() {
        InterfaceC1693a interfaceC1693a = this.f62913b;
        if (interfaceC1693a != null) {
            interfaceC1693a.a();
        } else {
            super.dismiss();
        }
    }

    @Override // android.widget.PopupWindow
    public void showAsDropDown(View view) {
        if (Build.VERSION.SDK_INT >= 24) {
            Rect rect = new Rect();
            view.getGlobalVisibleRect(rect);
            setHeight(ViewCommonUtil.getScreenFullSize(this.f62912a.getPageActivity())[1] - rect.bottom);
        }
        super.showAsDropDown(view);
    }

    @Override // android.widget.PopupWindow
    public void showAsDropDown(View view, int i, int i2) {
        if (Build.VERSION.SDK_INT >= 24) {
            Rect rect = new Rect();
            view.getGlobalVisibleRect(rect);
            setHeight(ViewCommonUtil.getScreenFullSize(this.f62912a.getPageActivity())[1] - rect.bottom);
        }
        super.showAsDropDown(view, i, i2);
    }
}
