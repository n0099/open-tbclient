package d.b.i0.a1.g;

import android.app.Activity;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
/* loaded from: classes4.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public static int f52669a;

    /* renamed from: b  reason: collision with root package name */
    public static int f52670b;

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
        f52669a = firstVisiblePosition;
        f52670b = top;
    }

    public static void c(BdTypeRecyclerView bdTypeRecyclerView) {
        if (bdTypeRecyclerView == null || !(bdTypeRecyclerView.getLayoutManager() instanceof LinearLayoutManager) || f52669a > bdTypeRecyclerView.getCount() - 1) {
            return;
        }
        bdTypeRecyclerView.requestFocusFromTouch();
        ((LinearLayoutManager) bdTypeRecyclerView.getLayoutManager()).scrollToPositionWithOffset(f52669a, f52670b);
        f52669a = 0;
        f52670b = 0;
    }
}
