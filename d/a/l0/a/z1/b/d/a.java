package d.a.l0.a.z1.b.d;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.baidu.swan.apps.res.ui.BdShimmerView;
import com.baidu.swan.apps.res.widget.loadingview.LoadingView;
import d.a.l0.a.k;
import java.util.WeakHashMap;
/* loaded from: classes3.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f49819a = k.f46875a & true;

    /* renamed from: b  reason: collision with root package name */
    public static final WeakHashMap<ViewGroup, b> f49820b = new WeakHashMap<>();

    public static void a() {
        for (ViewGroup viewGroup : f49820b.keySet()) {
            b bVar = f49820b.get(viewGroup);
            if (bVar != null && bVar.getLoadingView() != null) {
                viewGroup.removeView(bVar.getLoadingView());
            }
        }
        f49820b.clear();
    }

    public static boolean b(ViewGroup viewGroup) {
        b bVar;
        View loadingView;
        if (viewGroup == null) {
            return false;
        }
        b bVar2 = f49820b.get(viewGroup);
        if (bVar2 != null && bVar2.getLoadingView() != null) {
            bVar2.getLoadingView().setVisibility(8);
            return true;
        }
        for (int i2 = 0; i2 < viewGroup.getChildCount(); i2++) {
            if ((viewGroup.getChildAt(i2) instanceof b) && (loadingView = (bVar = (b) viewGroup.getChildAt(i2)).getLoadingView()) != null) {
                loadingView.setVisibility(8);
                f49820b.put(viewGroup, bVar);
                if (f49819a) {
                    Log.d("LoadingViewHelper", "The count of cached loading views is : " + f49820b.size());
                    Log.d("LoadingViewHelper", "The content of cached views is : " + f49820b.toString());
                }
                return true;
            }
        }
        return false;
    }

    public static boolean c(ViewGroup viewGroup) {
        b bVar;
        View loadingView;
        if (viewGroup == null) {
            return false;
        }
        b bVar2 = f49820b.get(viewGroup);
        if (bVar2 != null) {
            View loadingView2 = bVar2.getLoadingView();
            if (loadingView2 != null) {
                if (loadingView2 instanceof BdShimmerView) {
                    ((BdShimmerView) loadingView2).p();
                }
                loadingView2.setVisibility(8);
                viewGroup.removeView(loadingView2);
                f49820b.remove(viewGroup);
                if (f49819a) {
                    Log.d("LoadingViewHelper", "The count of cached loading views is : " + f49820b.size());
                    Log.d("LoadingViewHelper", "The content of cached views is : " + f49820b.toString());
                }
            }
            return true;
        }
        for (int i2 = 0; i2 < viewGroup.getChildCount(); i2++) {
            if ((viewGroup.getChildAt(i2) instanceof b) && (loadingView = (bVar = (b) viewGroup.getChildAt(i2)).getLoadingView()) != null) {
                loadingView.setVisibility(8);
                viewGroup.removeView((View) bVar);
                f49820b.remove(viewGroup);
                if (f49819a) {
                    Log.d("LoadingViewHelper", "The count of cached loading views is : " + f49820b.size());
                    Log.d("LoadingViewHelper", "The content of cached views is : " + f49820b.toString());
                }
                return true;
            }
        }
        return false;
    }

    public static boolean d(ViewGroup viewGroup) {
        b bVar;
        View loadingView;
        if (viewGroup == null) {
            return false;
        }
        b bVar2 = f49820b.get(viewGroup);
        if (bVar2 != null && bVar2.getLoadingView() != null) {
            bVar2.getLoadingView().setVisibility(0);
            return true;
        }
        for (int i2 = 0; i2 < viewGroup.getChildCount(); i2++) {
            if ((viewGroup.getChildAt(i2) instanceof b) && (loadingView = (bVar = (b) viewGroup.getChildAt(i2)).getLoadingView()) != null) {
                loadingView.setVisibility(0);
                f49820b.put(viewGroup, bVar);
                if (f49819a) {
                    Log.d("LoadingViewHelper", "The count of cached loading views is : " + f49820b.size());
                    Log.d("LoadingViewHelper", "The content of cached views is : " + f49820b.toString());
                }
                return true;
            }
        }
        return false;
    }

    public static boolean e(Context context, ViewGroup viewGroup) {
        return f(context, viewGroup, "");
    }

    public static boolean f(Context context, ViewGroup viewGroup, String str) {
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
            f49820b.put(viewGroup, loadingView);
            loadingView2.setVisibility(0);
            if (f49819a) {
                Log.d("LoadingViewHelper", "The count of cached loading views is : " + f49820b.size());
                Log.d("LoadingViewHelper", "The content of cached views is : " + f49820b.toString());
            }
            return true;
        }
        return false;
    }
}
