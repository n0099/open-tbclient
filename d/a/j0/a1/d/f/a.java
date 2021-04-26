package d.a.j0.a1.d.f;

import android.graphics.Rect;
import android.os.Build;
import android.view.View;
import android.widget.PopupWindow;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ViewCommonUtil;
/* loaded from: classes4.dex */
public class a extends PopupWindow {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f50653a;

    /* renamed from: b  reason: collision with root package name */
    public InterfaceC1107a f50654b;

    /* renamed from: d.a.j0.a1.d.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC1107a {
        void a();
    }

    public a(TbPageContext tbPageContext, View view, int i2, int i3) {
        super(view, i2, i3);
        this.f50653a = tbPageContext;
    }

    public void a() {
        super.dismiss();
    }

    public void b(InterfaceC1107a interfaceC1107a) {
        this.f50654b = interfaceC1107a;
    }

    @Override // android.widget.PopupWindow
    public void dismiss() {
        InterfaceC1107a interfaceC1107a = this.f50654b;
        if (interfaceC1107a != null) {
            interfaceC1107a.a();
        } else {
            super.dismiss();
        }
    }

    @Override // android.widget.PopupWindow
    public void showAsDropDown(View view) {
        if (Build.VERSION.SDK_INT >= 24) {
            Rect rect = new Rect();
            view.getGlobalVisibleRect(rect);
            setHeight(ViewCommonUtil.getScreenFullSize(this.f50653a.getPageActivity())[1] - rect.bottom);
        }
        super.showAsDropDown(view);
    }

    @Override // android.widget.PopupWindow
    public void showAsDropDown(View view, int i2, int i3) {
        if (Build.VERSION.SDK_INT >= 24) {
            Rect rect = new Rect();
            view.getGlobalVisibleRect(rect);
            setHeight(ViewCommonUtil.getScreenFullSize(this.f50653a.getPageActivity())[1] - rect.bottom);
        }
        super.showAsDropDown(view, i2, i3);
    }
}
