package j.a.a.e.p;

import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class j {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(int i2, View view, GridView gridView) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeILL(65536, null, i2, view, gridView) == null) || i2 == 0 || gridView == null || view == null) {
            return;
        }
        int i3 = i2 >= 3 ? 82 : 110;
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (i2 == 1) {
            gridView.setNumColumns(1);
            layoutParams.width = c.a(i3);
        } else if (i2 == 2) {
            gridView.setNumColumns(2);
            layoutParams.width = c.a((i3 * 2) + 7);
        } else if (i2 == 3) {
            gridView.setNumColumns(3);
            layoutParams.width = c.a((i3 * 3) + 14);
        } else if (i2 != 4) {
            gridView.setNumColumns(3);
            layoutParams.width = c.a((i3 * 3) + 14);
        } else {
            gridView.setNumColumns(2);
            layoutParams.width = c.a((i3 * 2) + 7);
        }
        view.setLayoutParams(layoutParams);
    }
}
