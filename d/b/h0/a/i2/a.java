package d.b.h0.a.i2;

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
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f45381a = d.b.h0.a.k.f45772a;

    public static void a(@NonNull BdSailorWebView bdSailorWebView) {
        AbsoluteLayout webView;
        Drawable d2 = d.b.h0.m.a.b.a.d(bdSailorWebView.getContext(), d.b.h0.a.e.common_scrollbar_vertical);
        Drawable d3 = d.b.h0.m.a.b.a.d(bdSailorWebView.getContext(), d.b.h0.a.e.common_scrollbar_horizontal);
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
            if (f45381a) {
                th.printStackTrace();
            }
        }
    }
}
