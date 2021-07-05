package d.a.q0.j.r;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes8.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static Bitmap a(Bitmap bitmap, int i2, int i3) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(65536, null, bitmap, i2, i3)) == null) {
            if (bitmap == null || i2 <= 0 || i3 <= 0) {
                return null;
            }
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            if (width == 0 || height == 0) {
                return null;
            }
            Matrix matrix = new Matrix();
            matrix.postScale(i2 / width, i3 / height);
            try {
                return Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, true);
            } catch (Exception | OutOfMemoryError e2) {
                e2.printStackTrace();
                return null;
            }
        }
        return (Bitmap) invokeLII.objValue;
    }
}
