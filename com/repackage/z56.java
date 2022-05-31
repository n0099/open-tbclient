package com.repackage;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.minivideo.arface.utils.ThreadPool;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ugc.editvideo.data.MultiMediaData;
import com.baidu.ugc.editvideo.record.RecordConstants;
import com.repackage.w59;
/* loaded from: classes7.dex */
public abstract class z56 implements c66 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public f66 a;
    public d66 b;
    public Thread c;
    public boolean d;

    /* loaded from: classes7.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ z56 a;

        public a(z56 z56Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {z56Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = z56Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.f();
            }
        }
    }

    public z56() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.d = false;
    }

    @Override // com.repackage.c66
    public void a(f66 f66Var, d66 d66Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, f66Var, d66Var) == null) || d66Var == null) {
            return;
        }
        this.b = d66Var;
        if (f66Var == null) {
            d66Var.onError(StringUtil.NULL_STRING, "cover config is null !!");
            return;
        }
        this.a = f66Var;
        this.c = new Thread(new a(this));
        ThreadPool.b().e(this.c);
    }

    public int[] b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            f66 f66Var = this.a;
            int[] iArr = {f66Var.a, f66Var.b};
            if (!f66Var.g && !f66Var.e) {
                float f = f66Var.d;
                if (f != 0.0f) {
                    w59.a e = w59.e(f, RecordConstants.VIDEO_CONSTANT_WIDTH);
                    iArr[0] = e.b();
                    iArr[1] = e.a();
                }
            } else {
                w59.a e2 = e();
                float f2 = this.a.d;
                if (f2 != 0.0f) {
                    w59.a f3 = w59.f(f2, e2.b(), e2.a());
                    iArr[0] = f3.b();
                    iArr[1] = f3.a();
                }
                w59.a d = w59.d(iArr[0], iArr[1]);
                iArr[0] = d.b();
                iArr[1] = d.a();
            }
            return iArr;
        }
        return (int[]) invokeV.objValue;
    }

    public Bitmap c(Bitmap bitmap, float f, MultiMediaData multiMediaData) {
        InterceptResult invokeCommon;
        Bitmap bitmap2;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{bitmap, Float.valueOf(f), multiMediaData})) == null) {
            if (multiMediaData == null || !((i = 360 - (((int) multiMediaData.angle) % 360)) == 90 || i == 270)) {
                bitmap2 = null;
            } else {
                Matrix matrix = new Matrix();
                matrix.setRotate(i);
                bitmap2 = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
            }
            if (bitmap2 != null) {
                bitmap = bitmap2;
            }
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            if (bitmap.getHeight() / bitmap.getWidth() > f) {
                width = (int) (bitmap.getHeight() * f);
            } else {
                height = (int) (bitmap.getWidth() * f);
            }
            Bitmap createBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.RGB_565);
            Canvas canvas = new Canvas(createBitmap);
            canvas.save();
            canvas.drawBitmap(bitmap, width != bitmap.getWidth() ? Math.abs(width - bitmap.getWidth()) / 2 : 0, height != bitmap.getHeight() ? Math.abs(height - bitmap.getHeight()) / 2 : 0, (Paint) null);
            canvas.restore();
            bitmap.recycle();
            return createBitmap;
        }
        return (Bitmap) invokeCommon.objValue;
    }

    public String d(int i, int i2, Bitmap bitmap, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), bitmap, Boolean.valueOf(z)})) == null) {
            if (i == 0 || i2 == 0) {
                return "";
            }
            Bitmap h = q79.h(bitmap, i, i2, z);
            String b = this.d ? tu8.b() : tu8.a();
            String c = tu8.c(b, h, System.currentTimeMillis() + ".jpg");
            if (h != null) {
                h.recycle();
                return c;
            }
            return c;
        }
        return (String) invokeCommon.objValue;
    }

    public w59.a e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            MultiMediaData multiMediaData = this.a.c;
            int i = RecordConstants.VIDEO_CONSTANT_WIDTH;
            int i2 = RecordConstants.VIDEO_CONSTANT_HEIGHT;
            if (multiMediaData == null) {
                return new w59.a(i, i2);
            }
            if (multiMediaData.type == 1) {
                float f = multiMediaData.angle;
                float f2 = multiMediaData.rotation;
                if ((f + f2) % 360.0f != 90.0f && (f + f2) % 360.0f != 270.0f) {
                    i = multiMediaData.width;
                    i2 = multiMediaData.height;
                } else {
                    i = multiMediaData.height;
                    i2 = multiMediaData.width;
                }
            }
            return new w59.a(i, i2);
        }
        return (w59.a) invokeV.objValue;
    }

    public abstract void f();

    public void g(e66 e66Var, Bitmap bitmap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, e66Var, bitmap) == null) {
            if (e66Var == null) {
                e66Var = new e66();
            }
            int[] b = b();
            e66Var.a = d(b[0], b[1], bitmap, true);
            this.b.a(this.a.f, e66Var);
        }
    }
}
