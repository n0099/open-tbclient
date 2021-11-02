package i.a.a.e.n;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import tv.athena.revenue.payui.widget.NoScrollGridView;
/* loaded from: classes3.dex */
public class i {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(int i2, View view, NoScrollGridView noScrollGridView) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeILL(65536, null, i2, view, noScrollGridView) == null) || i2 == 0 || noScrollGridView == null || view == null) {
            return;
        }
        int i3 = i2 >= 3 ? 82 : 110;
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (i2 == 1) {
            noScrollGridView.setNumColumns(1);
            layoutParams.width = c.a(i3);
        } else if (i2 == 2) {
            noScrollGridView.setNumColumns(2);
            layoutParams.width = c.a((i3 * 2) + 7);
        } else if (i2 == 3) {
            noScrollGridView.setNumColumns(3);
            layoutParams.width = c.a((i3 * 3) + 14);
        } else if (i2 > 3) {
            noScrollGridView.setNumColumns(2);
            layoutParams.width = c.a((i3 * 2) + 7);
        }
        view.setLayoutParams(layoutParams);
    }
}
