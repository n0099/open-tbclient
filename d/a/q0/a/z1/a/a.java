package d.a.q0.a.z1.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.baidu.swan.apps.res.ui.FullScreenFloatView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import d.a.q0.a.g;
/* loaded from: classes8.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static FullScreenFloatView a(Context context, ViewGroup viewGroup, int i2) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(65536, null, context, viewGroup, i2)) == null) {
            if (context == null || viewGroup == null) {
                return null;
            }
            FullScreenFloatView b2 = b(context, i2);
            viewGroup.addView(b2);
            return b2;
        }
        return (FullScreenFloatView) invokeLLI.objValue;
    }

    public static FullScreenFloatView b(Context context, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65537, null, context, i2)) == null) {
            if (context == null) {
                return null;
            }
            int i3 = g.aiapps_fullscreen_floatview;
            if (i2 != 1 && i2 == 2) {
                i3 = g.aiapps_fullscreen_floatview_button;
            }
            return (FullScreenFloatView) LayoutInflater.from(context.getApplicationContext()).inflate(i3, (ViewGroup) null);
        }
        return (FullScreenFloatView) invokeLI.objValue;
    }
}
