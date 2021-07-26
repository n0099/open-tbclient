package d.a.o0.a.z1.b.d;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.core.view.InputDeviceCompat;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.swan.apps.res.ui.BdShimmerView;
import com.baidu.swan.apps.res.widget.loadingview.LoadingView;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import d.a.o0.a.k;
import java.util.WeakHashMap;
/* loaded from: classes7.dex */
public final class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f49275a;

    /* renamed from: b  reason: collision with root package name */
    public static final WeakHashMap<ViewGroup, b> f49276b;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-557450093, "Ld/a/o0/a/z1/b/d/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-557450093, "Ld/a/o0/a/z1/b/d/a;");
                return;
            }
        }
        f49275a = k.f46335a & true;
        f49276b = new WeakHashMap<>();
    }

    public static void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, null) == null) {
            for (ViewGroup viewGroup : f49276b.keySet()) {
                b bVar = f49276b.get(viewGroup);
                if (bVar != null && bVar.getLoadingView() != null) {
                    viewGroup.removeView(bVar.getLoadingView());
                }
            }
            f49276b.clear();
        }
    }

    public static boolean b(ViewGroup viewGroup) {
        InterceptResult invokeL;
        b bVar;
        View loadingView;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, viewGroup)) == null) {
            if (viewGroup == null) {
                return false;
            }
            b bVar2 = f49276b.get(viewGroup);
            if (bVar2 != null && bVar2.getLoadingView() != null) {
                bVar2.getLoadingView().setVisibility(8);
                return true;
            }
            for (int i2 = 0; i2 < viewGroup.getChildCount(); i2++) {
                if ((viewGroup.getChildAt(i2) instanceof b) && (loadingView = (bVar = (b) viewGroup.getChildAt(i2)).getLoadingView()) != null) {
                    loadingView.setVisibility(8);
                    f49276b.put(viewGroup, bVar);
                    if (f49275a) {
                        Log.d("LoadingViewHelper", "The count of cached loading views is : " + f49276b.size());
                        Log.d("LoadingViewHelper", "The content of cached views is : " + f49276b.toString());
                    }
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static boolean c(ViewGroup viewGroup) {
        InterceptResult invokeL;
        b bVar;
        View loadingView;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, viewGroup)) == null) {
            if (viewGroup == null) {
                return false;
            }
            b bVar2 = f49276b.get(viewGroup);
            if (bVar2 != null) {
                View loadingView2 = bVar2.getLoadingView();
                if (loadingView2 != null) {
                    if (loadingView2 instanceof BdShimmerView) {
                        ((BdShimmerView) loadingView2).p();
                    }
                    loadingView2.setVisibility(8);
                    viewGroup.removeView(loadingView2);
                    f49276b.remove(viewGroup);
                    if (f49275a) {
                        Log.d("LoadingViewHelper", "The count of cached loading views is : " + f49276b.size());
                        Log.d("LoadingViewHelper", "The content of cached views is : " + f49276b.toString());
                    }
                }
                return true;
            }
            for (int i2 = 0; i2 < viewGroup.getChildCount(); i2++) {
                if ((viewGroup.getChildAt(i2) instanceof b) && (loadingView = (bVar = (b) viewGroup.getChildAt(i2)).getLoadingView()) != null) {
                    loadingView.setVisibility(8);
                    viewGroup.removeView((View) bVar);
                    f49276b.remove(viewGroup);
                    if (f49275a) {
                        Log.d("LoadingViewHelper", "The count of cached loading views is : " + f49276b.size());
                        Log.d("LoadingViewHelper", "The content of cached views is : " + f49276b.toString());
                    }
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static boolean d(ViewGroup viewGroup) {
        InterceptResult invokeL;
        b bVar;
        View loadingView;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, viewGroup)) == null) {
            if (viewGroup == null) {
                return false;
            }
            b bVar2 = f49276b.get(viewGroup);
            if (bVar2 != null && bVar2.getLoadingView() != null) {
                bVar2.getLoadingView().setVisibility(0);
                return true;
            }
            for (int i2 = 0; i2 < viewGroup.getChildCount(); i2++) {
                if ((viewGroup.getChildAt(i2) instanceof b) && (loadingView = (bVar = (b) viewGroup.getChildAt(i2)).getLoadingView()) != null) {
                    loadingView.setVisibility(0);
                    f49276b.put(viewGroup, bVar);
                    if (f49275a) {
                        Log.d("LoadingViewHelper", "The count of cached loading views is : " + f49276b.size());
                        Log.d("LoadingViewHelper", "The content of cached views is : " + f49276b.toString());
                    }
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static boolean e(Context context, ViewGroup viewGroup) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(AdIconUtil.AD_TEXT_ID, null, context, viewGroup)) == null) ? f(context, viewGroup, "") : invokeLL.booleanValue;
    }

    public static boolean f(Context context, ViewGroup viewGroup, String str) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(AdIconUtil.BAIDU_LOGO_ID, null, context, viewGroup, str)) == null) {
            if (context != null && viewGroup != null) {
                if (d(viewGroup)) {
                    return true;
                }
                LoadingView loadingView = new LoadingView(context);
                LoadingView loadingView2 = loadingView.getLoadingView();
                if (loadingView2 == null) {
                    return false;
                }
                if (!TextUtils.isEmpty(str)) {
                    loadingView2.setMsg(str);
                }
                ViewGroup viewGroup2 = (ViewGroup) loadingView2.getParent();
                if (viewGroup2 != null) {
                    viewGroup2.removeView(loadingView2);
                }
                if (viewGroup instanceof RelativeLayout) {
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                    layoutParams.addRule(13);
                    viewGroup.addView(loadingView2, layoutParams);
                } else if (viewGroup instanceof LinearLayout) {
                    LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
                    layoutParams2.gravity = 17;
                    viewGroup.addView(loadingView2, layoutParams2);
                } else if (viewGroup instanceof FrameLayout) {
                    FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-2, -2);
                    layoutParams3.gravity = 17;
                    viewGroup.addView(loadingView2, layoutParams3);
                }
                f49276b.put(viewGroup, loadingView);
                loadingView2.setVisibility(0);
                if (f49275a) {
                    Log.d("LoadingViewHelper", "The count of cached loading views is : " + f49276b.size());
                    Log.d("LoadingViewHelper", "The content of cached views is : " + f49276b.toString());
                }
                return true;
            }
            return false;
        }
        return invokeLLL.booleanValue;
    }
}
