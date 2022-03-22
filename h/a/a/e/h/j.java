package h.a.a.e.h;

import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class j {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(int i, View view, GridView gridView) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeILL(65536, null, i, view, gridView) == null) || i == 0 || gridView == null || view == null) {
            return;
        }
        int i2 = i >= 3 ? 82 : 110;
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (i == 1) {
            gridView.setNumColumns(1);
            layoutParams.width = c.a(i2);
        } else if (i == 2) {
            gridView.setNumColumns(2);
            layoutParams.width = c.a((i2 * 2) + 7);
        } else if (i == 3) {
            gridView.setNumColumns(3);
            layoutParams.width = c.a((i2 * 3) + 14);
        } else if (i != 4) {
            gridView.setNumColumns(3);
            layoutParams.width = c.a((i2 * 3) + 14);
        } else {
            gridView.setNumColumns(2);
            layoutParams.width = c.a((i2 * 2) + 7);
        }
        view.setLayoutParams(layoutParams);
    }
}
