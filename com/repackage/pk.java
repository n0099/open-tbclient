package com.repackage;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.baidu.adp.newwidget.ImageView.DrawerArgs;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.player.widget.BdThumbSeekBarView;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public abstract class pk {
    public static /* synthetic */ Interceptable $ic;
    public static final Matrix.ScaleToFit[] o;
    public static final PorterDuffColorFilter p;
    public transient /* synthetic */ FieldHolder $fh;
    public b a;
    public Paint b;
    public Paint c;
    public Paint d;
    public Matrix e;
    public RectF f;
    public RectF g;
    public RectF h;
    public RectF i;
    public RectF j;
    public DrawerArgs k;
    public float[] l;
    public PointF m;
    public RectF n;

    /* loaded from: classes6.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public static final /* synthetic */ int[] a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1942796147, "Lcom/repackage/pk$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1942796147, "Lcom/repackage/pk$a;");
                    return;
                }
            }
            int[] iArr = new int[DrawerArgs.SkinType.values().length];
            a = iArr;
            try {
                iArr[DrawerArgs.SkinType.NIGHT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[DrawerArgs.SkinType.DAY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[DrawerArgs.SkinType.DARK.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* loaded from: classes6.dex */
    public interface b {
        boolean a(Canvas canvas, Drawable drawable);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1964030614, "Lcom/repackage/pk;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1964030614, "Lcom/repackage/pk;");
                return;
            }
        }
        o = new Matrix.ScaleToFit[]{Matrix.ScaleToFit.FILL, Matrix.ScaleToFit.START, Matrix.ScaleToFit.CENTER, Matrix.ScaleToFit.END};
        p = new PorterDuffColorFilter(BdThumbSeekBarView.UI_TRACE_COLOR, PorterDuff.Mode.SRC_ATOP);
    }

    public pk() {
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
        this.b = new Paint(6);
        this.c = new Paint();
        this.d = new Paint();
        this.e = new Matrix();
        this.f = new RectF();
        this.g = new RectF();
        this.h = new RectF();
        this.i = new RectF();
        this.j = new RectF();
        this.k = new DrawerArgs();
        this.l = new float[9];
        this.m = new PointF();
        this.n = new RectF();
        this.c.setStyle(Paint.Style.STROKE);
        this.c.setAntiAlias(true);
        this.b.setAntiAlias(true);
        this.d.setAntiAlias(true);
        this.d.setStyle(Paint.Style.FILL);
    }

    public static Matrix.ScaleToFit m(ImageView.ScaleType scaleType) {
        InterceptResult invokeL;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, scaleType)) == null) {
            if (scaleType != ImageView.ScaleType.FIT_XY) {
                if (scaleType == ImageView.ScaleType.FIT_START) {
                    i = 2;
                } else if (scaleType == ImageView.ScaleType.FIT_CENTER) {
                    i = 3;
                } else if (scaleType == ImageView.ScaleType.FIT_END) {
                    i = 4;
                }
                return o[i - 1];
            }
            i = 1;
            return o[i - 1];
        }
        return (Matrix.ScaleToFit) invokeL.objValue;
    }

    public abstract void a(sk skVar, ImageView imageView);

    public PointF b(float f, float f2, Matrix matrix) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Float.valueOf(f), Float.valueOf(f2), matrix})) == null) {
            matrix.getValues(this.l);
            float[] fArr = this.l;
            this.m.set((int) ((fArr[0] * f) + (fArr[1] * f2) + fArr[2]), (int) ((f * fArr[3]) + (f2 * fArr[4]) + fArr[5]));
            return this.m;
        }
        return (PointF) invokeCommon.objValue;
    }

    public void c(sk skVar, ImageView imageView, ImageView.ScaleType scaleType) {
        float f;
        float f2;
        float f3;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, skVar, imageView, scaleType) == null) || imageView.getWidth() == 0 || imageView.getHeight() == 0) {
            return;
        }
        int b2 = skVar.b();
        int a2 = skVar.a();
        int width = (imageView.getWidth() - imageView.getPaddingLeft()) - imageView.getPaddingRight();
        int height = (imageView.getHeight() - imageView.getPaddingTop()) - imageView.getPaddingBottom();
        if (scaleType == ImageView.ScaleType.MATRIX) {
            this.f.set(0.0f, 0.0f, b2, a2);
            a(skVar, imageView);
            return;
        }
        boolean z = (b2 <= 0 || width == b2) && (a2 <= 0 || height == a2);
        this.e.reset();
        if (ImageView.ScaleType.FIT_XY != scaleType && !z) {
            float f4 = b2;
            float f5 = a2;
            this.f.set(0.0f, 0.0f, f4, f5);
            if (ImageView.ScaleType.CENTER == scaleType) {
                this.e.setTranslate((width - b2) * 0.5f, (height - a2) * 0.5f);
            } else if (ImageView.ScaleType.CENTER_CROP == scaleType) {
                if (b2 * height > a2 * width) {
                    f = height / f5;
                    f3 = (width - (f4 * f)) * 0.5f;
                    f2 = 0.0f;
                } else {
                    f = width / f4;
                    f2 = (height - (f5 * f)) * 0.5f;
                    f3 = 0.0f;
                }
                this.e.setScale(f, f);
                this.e.postTranslate(f3, f2);
            } else if (ImageView.ScaleType.CENTER_INSIDE == scaleType) {
                float min = (b2 > width || a2 > height) ? Math.min(width / f4, height / f5) : 1.0f;
                this.e.setScale(min, min);
                this.e.postTranslate((width - (f4 * min)) * 0.5f, (height - (f5 * min)) * 0.5f);
            } else {
                this.h.set(0.0f, 0.0f, f4, f5);
                this.i.set(0.0f, 0.0f, width, height);
                this.e.setRectToRect(this.h, this.i, m(scaleType));
            }
        } else {
            this.f.set(0.0f, 0.0f, width, height);
        }
        int length = this.k.a.length;
        for (int i = 0; i < length; i++) {
            float[] fArr = this.k.a;
            if (fArr[i] > 0.0f && fArr[i] < 1.0f) {
                fArr[i] = fArr[i] * this.f.height();
            }
        }
        a(skVar, imageView);
    }

    public void d(Canvas canvas, ImageView imageView, Drawable drawable) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048579, this, canvas, imageView, drawable) == null) || drawable == null) {
            return;
        }
        int scrollX = imageView.getScrollX();
        int scrollY = imageView.getScrollY();
        drawable.setBounds(0, 0, imageView.getWidth(), imageView.getHeight());
        if ((scrollX | scrollY) == 0) {
            e(canvas, drawable);
            return;
        }
        canvas.translate(scrollX, scrollY);
        e(canvas, drawable);
        canvas.translate(-scrollX, -scrollY);
    }

    public void e(Canvas canvas, Drawable drawable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, canvas, drawable) == null) {
            b bVar = this.a;
            if (bVar == null || !bVar.a(canvas, drawable)) {
                drawable.draw(canvas);
            }
        }
    }

    public abstract void f(Canvas canvas, ImageView imageView);

    public void g(Canvas canvas, sk skVar, ImageView imageView) {
        Matrix matrix;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048582, this, canvas, skVar, imageView) == null) {
            q();
            int save = canvas.save();
            int scrollX = imageView.getScrollX();
            int scrollY = imageView.getScrollY();
            int paddingLeft = imageView.getPaddingLeft();
            int paddingRight = imageView.getPaddingRight();
            int paddingTop = imageView.getPaddingTop();
            int paddingBottom = imageView.getPaddingBottom();
            canvas.clipRect(scrollX + paddingLeft, scrollY + paddingTop, ((scrollX + imageView.getRight()) - imageView.getLeft()) - paddingRight, ((scrollY + imageView.getBottom()) - imageView.getTop()) - paddingBottom);
            canvas.translate(paddingLeft, paddingTop);
            int save2 = canvas.save();
            Matrix matrix2 = this.k.l;
            if (matrix2 != null) {
                canvas.concat(matrix2);
            }
            fo foVar = skVar.b;
            if (foVar != null && foVar.v()) {
                if ((skVar.b.p().getWidth() + paddingLeft + paddingRight > imageView.getWidth() || skVar.b.p().getHeight() + paddingTop + paddingBottom > imageView.getHeight()) && (matrix = this.e) != null) {
                    canvas.concat(matrix);
                }
                this.j.set(0.0f, 0.0f, imageView.getWidth(), imageView.getHeight());
                skVar.b.i(canvas, this.j);
            } else {
                h(canvas, skVar, imageView);
            }
            if (save2 >= 1 && save2 <= canvas.getSaveCount()) {
                canvas.restoreToCount(save2);
            }
            f(canvas, imageView);
            if (save < 1 || save > canvas.getSaveCount()) {
                return;
            }
            canvas.restoreToCount(save);
        }
    }

    public abstract void h(Canvas canvas, sk skVar, ImageView imageView);

    public abstract void i(Canvas canvas, ImageView imageView);

    public RectF j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f : (RectF) invokeV.objValue;
    }

    public Matrix k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.e : (Matrix) invokeV.objValue;
    }

    public Path l(RectF rectF, float[] fArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048587, this, rectF, fArr)) == null) {
            Path path = new Path();
            path.addRoundRect(rectF, fArr, Path.Direction.CCW);
            return path;
        }
        return (Path) invokeLL.objValue;
    }

    public void n(Matrix matrix) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, matrix) == null) {
            this.e = matrix;
        }
    }

    public void o(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, bVar) == null) {
            this.a = bVar;
        }
    }

    public void p(DrawerArgs drawerArgs) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, drawerArgs) == null) {
            this.k = drawerArgs;
        }
    }

    public void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            this.b.setAlpha((int) (this.k.k * 255.0f));
            if (a.a[this.k.f.ordinal()] != 1) {
                this.b.setColorFilter(null);
            } else {
                this.b.setColorFilter(p);
            }
            this.c.setColor(this.k.e);
            this.c.setStrokeWidth(this.k.d);
        }
    }
}
