package d.a.l0.a.v2;

import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.View;
import android.widget.AbsoluteLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.browser.sailor.BdSailorWebView;
import com.baidu.browser.sailor.util.BdZeusUtil;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f49032a = d.a.l0.a.k.f46875a;

    public static void a(@NonNull BdSailorWebView bdSailorWebView) {
        AbsoluteLayout webView;
        Drawable d2 = d.a.l0.o.a.b.a.d(bdSailorWebView.getContext(), d.a.l0.a.e.swan_app_common_scrollbar_vertical);
        Drawable d3 = d.a.l0.o.a.b.a.d(bdSailorWebView.getContext(), d.a.l0.a.e.swan_app_common_scrollbar_horizontal);
        if (BdZeusUtil.isWebkitLoaded()) {
            webView = bdSailorWebView.getCurrentWebView();
        } else {
            webView = bdSailorWebView.getCurrentWebView().getWebView();
        }
        if (Build.VERSION.SDK_INT >= 29) {
            webView.setVerticalScrollbarThumbDrawable(d2);
            webView.setHorizontalScrollbarThumbDrawable(d3);
            return;
        }
        b(webView, d2, d3);
    }

    public static void b(@Nullable View view, Drawable drawable, Drawable drawable2) {
        if (view == null) {
            return;
        }
        try {
            Field declaredField = View.class.getDeclaredField("mScrollCache");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(view);
            Field declaredField2 = obj.getClass().getDeclaredField("scrollBar");
            declaredField2.setAccessible(true);
            Object obj2 = declaredField2.get(obj);
            Method declaredMethod = obj2.getClass().getDeclaredMethod("setVerticalThumbDrawable", Drawable.class);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(obj2, drawable);
            Method declaredMethod2 = obj2.getClass().getDeclaredMethod("setHorizontalThumbDrawable", Drawable.class);
            declaredMethod2.setAccessible(true);
            declaredMethod2.invoke(obj2, drawable2);
        } catch (Throwable th) {
            if (f49032a) {
                th.printStackTrace();
            }
        }
    }
}
