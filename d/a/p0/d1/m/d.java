package d.a.p0.d1.m;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class d extends BitmapDrawable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f52401a;

    /* renamed from: b  reason: collision with root package name */
    public Context f52402b;

    /* renamed from: c  reason: collision with root package name */
    public Rect f52403c;

    /* renamed from: d  reason: collision with root package name */
    public String f52404d;

    /* renamed from: e  reason: collision with root package name */
    public Matrix f52405e;

    /* renamed from: f  reason: collision with root package name */
    public int f52406f;

    /* renamed from: g  reason: collision with root package name */
    public int f52407g;

    public d(Context context, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f52401a = 0;
        this.f52402b = null;
        this.f52403c = null;
        this.f52404d = null;
        this.f52405e = null;
        this.f52406f = 0;
        this.f52407g = 0;
        this.f52402b = context;
        this.f52401a = i2;
        this.f52404d = String.valueOf(i2);
    }

    @Override // android.graphics.drawable.BitmapDrawable, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        String str;
        String str2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, canvas) == null) || this.f52401a <= 0 || this.f52402b == null) {
            return;
        }
        d.a.p0.b0.c k = d.a.p0.b0.c.k();
        d.a.d.k.d.a m = (k == null || (str2 = this.f52404d) == null) ? null : k.m(str2);
        if (m == null) {
            Bitmap resBitmap = BitmapHelper.getResBitmap(this.f52402b, this.f52401a);
            if (resBitmap != null) {
                m = new d.a.d.k.d.a(resBitmap, false, (String) null);
            }
            if (k != null && m != null && (str = this.f52404d) != null) {
                k.d(str, m);
            }
        }
        if (m != null) {
            int r = m.r();
            int m2 = m.m();
            if (r <= 0 || m2 <= 0 || this.f52403c == null) {
                return;
            }
            canvas.save();
            canvas.clipRect(super.getBounds());
            if (m2 <= 0 && r <= 0 && this.f52406f == 0 && this.f52407g == 0) {
                m.e(canvas, 0.0f, 0.0f, null);
            } else {
                if (this.f52405e == null) {
                    Matrix matrix = new Matrix();
                    this.f52405e = matrix;
                    matrix.postTranslate(this.f52406f, this.f52407g);
                    Rect rect = this.f52403c;
                    float f2 = (rect.right - rect.left) / r;
                    float f3 = (rect.bottom - rect.top) / m2;
                    if (f2 >= f3) {
                        f2 = f3;
                    }
                    if (f2 < 1.0f) {
                        this.f52405e.postScale(f2, f2);
                    }
                }
                m.f(canvas, this.f52405e, null);
            }
            canvas.restore();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setBounds(int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, i3, i4, i5) == null) {
            this.f52403c = new Rect(i2, i3, i4, i5);
            this.f52405e = null;
            super.setBounds(i2, i3, i4, i5);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setBounds(Rect rect) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, rect) == null) {
            this.f52403c = new Rect(rect);
            this.f52405e = null;
            super.setBounds(rect);
        }
    }
}
