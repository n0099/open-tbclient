package com.repackage;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.util.SparseArray;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.ByteArrayOutputStream;
/* loaded from: classes5.dex */
public class ei {
    public static /* synthetic */ Interceptable $ic;
    public static ei c;
    public transient /* synthetic */ FieldHolder $fh;
    public volatile SparseArray<Bitmap> a;
    public Context b;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1964041247, "Lcom/repackage/ei;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1964041247, "Lcom/repackage/ei;");
        }
    }

    public ei() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = new SparseArray<>();
        Bitmap.Config config = Bitmap.Config.RGB_565;
    }

    public static synchronized ei d() {
        InterceptResult invokeV;
        ei eiVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            synchronized (ei.class) {
                if (c == null) {
                    c = new ei();
                }
                eiVar = c;
            }
            return eiVar;
        }
        return (ei) invokeV.objValue;
    }

    public byte[] a(Bitmap bitmap, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048576, this, bitmap, i)) == null) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.JPEG, i, byteArrayOutputStream);
            return byteArrayOutputStream.toByteArray();
        }
        return (byte[]) invokeLI.objValue;
    }

    public synchronized void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            synchronized (this) {
                this.a.clear();
            }
        }
    }

    public Bitmap c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) ? BitmapFactory.decodeFile(str) : (Bitmap) invokeL.objValue;
    }

    public Bitmap e(Context context, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048579, this, context, i)) == null) {
            try {
                return BitmapFactory.decodeResource(context.getResources(), i, new BitmapFactory.Options());
            } catch (Exception e) {
                BdLog.e(e.getMessage());
                return null;
            }
        }
        return (Bitmap) invokeLI.objValue;
    }

    public void f(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, context) == null) {
            this.b = context;
        }
    }

    public Bitmap g(Bitmap bitmap, int i, int i2) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(1048581, this, bitmap, i, i2)) == null) {
            if (i <= 0 || i2 < 0 || bitmap == null || bitmap.isRecycled()) {
                return null;
            }
            if (bitmap.getWidth() > i || bitmap.getHeight() > i2) {
                int width = bitmap.getWidth();
                int height = bitmap.getHeight();
                float f = i2 / height;
                float f2 = i / width;
                if (f > f2) {
                    f = f2;
                }
                Matrix matrix = new Matrix();
                matrix.postScale(f, f);
                Bitmap createBitmap = Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, true);
                if (createBitmap != bitmap) {
                    bitmap.recycle();
                }
                return createBitmap;
            }
            return bitmap;
        }
        return (Bitmap) invokeLII.objValue;
    }
}
