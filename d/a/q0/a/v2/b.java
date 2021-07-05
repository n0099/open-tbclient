package d.a.q0.a.v2;

import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.View;
import android.widget.AbsoluteLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.browser.sailor.BdSailorWebView;
import com.baidu.browser.sailor.util.BdZeusUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
/* loaded from: classes8.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f51286a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(129923763, "Ld/a/q0/a/v2/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(129923763, "Ld/a/q0/a/v2/b;");
                return;
            }
        }
        f51286a = d.a.q0.a.k.f49133a;
    }

    public static void a(@NonNull BdSailorWebView bdSailorWebView) {
        AbsoluteLayout webView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, bdSailorWebView) == null) {
            Drawable d2 = d.a.q0.o.a.b.a.d(bdSailorWebView.getContext(), d.a.q0.a.e.swan_app_common_scrollbar_vertical);
            Drawable d3 = d.a.q0.o.a.b.a.d(bdSailorWebView.getContext(), d.a.q0.a.e.swan_app_common_scrollbar_horizontal);
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
    }

    public static void b(@Nullable View view, Drawable drawable, Drawable drawable2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65538, null, view, drawable, drawable2) == null) || view == null) {
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
            if (f51286a) {
                th.printStackTrace();
            }
        }
    }
}
