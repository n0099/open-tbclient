package d.a.o0.a.a0.b;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.util.Base64;
import android.view.View;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.o0.a.v2.n0;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class c extends a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int o;
    public int p;
    public int q;
    public int r;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(String str) {
        super(str);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((String) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.o = n0.g((float) jSONObject.optDouble("x"));
            this.p = n0.g((float) jSONObject.optDouble("y"));
            this.q = n0.g((float) jSONObject.optDouble("width"));
            this.r = n0.g((float) jSONObject.optDouble("height"));
        } catch (Exception e2) {
            d.a.o0.a.e0.d.c("canvasGetImageData", "CanvasGetImageData meets json exception", e2);
        }
    }

    public final byte[] j(@NonNull Bitmap bitmap) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, bitmap)) == null) {
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            int i2 = width * height;
            int[] iArr = new int[i2];
            bitmap.getPixels(iArr, 0, width, 0, 0, width, height);
            byte[] bArr = new byte[i2 * 4];
            for (int i3 = 0; i3 < i2; i3++) {
                int i4 = iArr[i3];
                int i5 = i3 * 4;
                bArr[i5] = (byte) Color.red(i4);
                bArr[i5 + 1] = (byte) Color.green(i4);
                bArr[i5 + 2] = (byte) Color.blue(i4);
                bArr[i5 + 3] = (byte) Color.alpha(i4);
            }
            return bArr;
        }
        return (byte[]) invokeL.objValue;
    }

    public JSONObject k(@NonNull View view) {
        InterceptResult invokeL;
        String str;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view)) == null) {
            int measuredWidth = view.getMeasuredWidth();
            int measuredHeight = view.getMeasuredHeight();
            int i3 = 0;
            if (measuredWidth > 0 && measuredHeight > 0) {
                int i4 = this.o;
                this.o = (i4 < 0 || i4 >= measuredWidth) ? 0 : 0;
                int i5 = this.p;
                this.p = (i5 < 0 || i5 >= measuredHeight) ? 0 : 0;
                int i6 = this.q;
                if (i6 <= 0 || this.o + i6 > measuredWidth) {
                    i6 = measuredWidth - this.o;
                }
                this.q = i6;
                int i7 = this.r;
                if (i7 <= 0 || this.p + i7 > measuredHeight) {
                    i7 = measuredHeight - this.p;
                }
                this.r = i7;
                Bitmap createBitmap = Bitmap.createBitmap(this.q, i7, Bitmap.Config.ARGB_4444);
                Canvas canvas = new Canvas(createBitmap);
                canvas.drawARGB(0, 0, 0, 0);
                canvas.translate(-this.o, -this.p);
                view.draw(canvas);
                Bitmap l = l(createBitmap);
                str = Base64.encodeToString(j(l), 2);
                i3 = l.getWidth();
                i2 = l.getHeight();
            } else {
                d.a.o0.a.e0.d.a("canvasGetImageData", "canvas size is invalid.");
                str = "";
                i2 = 0;
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("width", i3);
                jSONObject.put("height", i2);
                jSONObject.put("data", str);
            } catch (Exception e2) {
                d.a.o0.a.e0.d.c("canvasGetImageData", "CanvasGetImageData meets json exception", e2);
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }

    @NonNull
    public final Bitmap l(@NonNull Bitmap bitmap) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bitmap)) == null) {
            float l = 1.0f / n0.l(d.a.o0.a.c1.a.b());
            Matrix matrix = new Matrix();
            matrix.postScale(l, l);
            return Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
        }
        return (Bitmap) invokeL.objValue;
    }
}
