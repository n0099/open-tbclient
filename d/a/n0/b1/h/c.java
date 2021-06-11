package d.a.n0.b1.h;

import android.app.Activity;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
/* loaded from: classes4.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public static int f55342a;

    /* renamed from: b  reason: collision with root package name */
    public static int f55343b;

    public static boolean a(Activity activity) {
        if (activity != null) {
            try {
                return activity.isInMultiWindowMode();
            } catch (Throwable unused) {
                return false;
            }
        }
        return false;
    }

    public static void b(BdTypeRecyclerView bdTypeRecyclerView) {
        if (bdTypeRecyclerView == null) {
            return;
        }
        int firstVisiblePosition = bdTypeRecyclerView.getFirstVisiblePosition();
        View childAt = bdTypeRecyclerView.getChildAt(0);
        int top = childAt != null ? childAt.getTop() : 0;
        f55342a = firstVisiblePosition;
        f55343b = top;
    }

    public static void c(BdTypeRecyclerView bdTypeRecyclerView) {
        if (bdTypeRecyclerView == null || !(bdTypeRecyclerView.getLayoutManager() instanceof LinearLayoutManager) || f55342a > bdTypeRecyclerView.getCount() - 1) {
            return;
        }
        bdTypeRecyclerView.requestFocusFromTouch();
        ((LinearLayoutManager) bdTypeRecyclerView.getLayoutManager()).scrollToPositionWithOffset(f55342a, f55343b);
        f55342a = 0;
        f55343b = 0;
    }
}
