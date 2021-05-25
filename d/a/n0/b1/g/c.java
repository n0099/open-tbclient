package d.a.n0.b1.g;

import android.app.Activity;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
/* loaded from: classes4.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public static int f51659a;

    /* renamed from: b  reason: collision with root package name */
    public static int f51660b;

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
        f51659a = firstVisiblePosition;
        f51660b = top;
    }

    public static void c(BdTypeRecyclerView bdTypeRecyclerView) {
        if (bdTypeRecyclerView == null || !(bdTypeRecyclerView.getLayoutManager() instanceof LinearLayoutManager) || f51659a > bdTypeRecyclerView.getCount() - 1) {
            return;
        }
        bdTypeRecyclerView.requestFocusFromTouch();
        ((LinearLayoutManager) bdTypeRecyclerView.getLayoutManager()).scrollToPositionWithOffset(f51659a, f51660b);
        f51659a = 0;
        f51660b = 0;
    }
}
