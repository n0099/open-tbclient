package d.a.r0.b1.m;

import android.graphics.drawable.Drawable;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes9.dex */
public class g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static Drawable a(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65536, null, i2)) == null) {
            if (i2 != 0) {
                return SkinManager.getDrawable(R.drawable.icon_xiangqing_n);
            }
            return SkinManager.getDrawable(R.drawable.icon_xiangqing_n);
        }
        return (Drawable) invokeI.objValue;
    }
}
