package d.a.d.k.d;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.NinePatch;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.widget.ImageView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.ByteArrayOutputStream;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes7.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public static final Object m;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f42321a;

    /* renamed from: b  reason: collision with root package name */
    public Bitmap f42322b;

    /* renamed from: c  reason: collision with root package name */
    public volatile boolean f42323c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f42324d;

    /* renamed from: e  reason: collision with root package name */
    public byte[] f42325e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f42326f;

    /* renamed from: g  reason: collision with root package name */
    public AtomicBoolean f42327g;

    /* renamed from: h  reason: collision with root package name */
    public d.a.d.d.b f42328h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f42329i;
    public Rect j;
    public boolean k;
    public NinePatch l;

    /* renamed from: d.a.d.k.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class C0572a extends BitmapDrawable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f42330a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0572a(a aVar, Bitmap bitmap) {
            super(bitmap);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, bitmap};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((Bitmap) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f42330a = aVar;
        }

        @Override // android.graphics.drawable.BitmapDrawable, android.graphics.drawable.Drawable
        public void draw(Canvas canvas) {
            Bitmap bitmap;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, canvas) == null) || this.f42330a.f42322b == null || (bitmap = getBitmap()) == null || bitmap.isRecycled()) {
                return;
            }
            canvas.drawBitmap(this.f42330a.f42322b, (Rect) null, getBounds(), getPaint());
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-230618247, "Ld/a/d/k/d/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-230618247, "Ld/a/d/k/d/a;");
                return;
            }
        }
        m = new Object();
    }

    public a(Bitmap bitmap) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bitmap};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f42322b = null;
        this.f42323c = false;
        this.f42324d = true;
        this.f42325e = null;
        this.f42326f = true;
        this.f42327g = new AtomicBoolean(false);
        this.f42329i = false;
        this.k = false;
        this.f42322b = bitmap;
    }

    public void A(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
        }
    }

    public int B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            Bitmap bitmap = this.f42322b;
            if (bitmap == null) {
                return 0;
            }
            return bitmap.getHeight() * this.f42322b.getRowBytes();
        }
        return invokeV.intValue;
    }

    public void b(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            this.f42327g.set(z);
        }
    }

    public final void c() {
        Bitmap bitmap;
        byte[] ninePatchChunk;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (bitmap = this.f42322b) == null || (ninePatchChunk = bitmap.getNinePatchChunk()) == null || ninePatchChunk.length <= 0 || !NinePatch.isNinePatchChunk(ninePatchChunk)) {
            return;
        }
        this.k = true;
        this.l = new NinePatch(this.f42322b, ninePatchChunk, "image");
    }

    public BitmapShader d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            Bitmap bitmap = this.f42322b;
            if (bitmap == null || bitmap.isRecycled()) {
                return null;
            }
            this.f42324d = false;
            Bitmap bitmap2 = this.f42322b;
            Shader.TileMode tileMode = Shader.TileMode.CLAMP;
            return new BitmapShader(bitmap2, tileMode, tileMode);
        }
        return (BitmapShader) invokeV.objValue;
    }

    public void e(Canvas canvas, float f2, float f3, Paint paint) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{canvas, Float.valueOf(f2), Float.valueOf(f3), paint}) == null) || this.f42322b == null) {
            return;
        }
        this.f42327g.set(true);
        canvas.drawBitmap(this.f42322b, f2, f3, paint);
        this.f42327g.set(false);
    }

    public void f(Canvas canvas, Matrix matrix, Paint paint) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048582, this, canvas, matrix, paint) == null) || this.f42322b == null) {
            return;
        }
        this.f42327g.set(true);
        canvas.drawBitmap(this.f42322b, matrix, paint);
        this.f42327g.set(false);
    }

    public void g(Canvas canvas, Rect rect, RectF rectF, Paint paint) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLL(1048583, this, canvas, rect, rectF, paint) == null) || this.f42322b == null) {
            return;
        }
        this.f42327g.set(true);
        canvas.drawBitmap(this.f42322b, rect, rectF, paint);
        this.f42327g.set(false);
    }

    public void h(ImageView imageView) {
        Bitmap bitmap;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, imageView) == null) || imageView == null || (bitmap = this.f42322b) == null) {
            return;
        }
        this.f42324d = false;
        imageView.setImageBitmap(bitmap);
    }

    public void i(Canvas canvas, RectF rectF) {
        NinePatch ninePatch;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048585, this, canvas, rectF) == null) && this.k && (ninePatch = this.l) != null) {
            ninePatch.draw(canvas, rectF);
        }
    }

    public BitmapDrawable j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            if (this.f42322b == null) {
                return null;
            }
            this.f42324d = false;
            return new C0572a(this, this.f42322b);
        }
        return (BitmapDrawable) invokeV.objValue;
    }

    public byte[] k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.f42325e : (byte[]) invokeV.objValue;
    }

    public d.a.d.d.b l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.f42328h : (d.a.d.d.b) invokeV.objValue;
    }

    public int m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            Bitmap bitmap = this.f42322b;
            if (bitmap == null) {
                return 0;
            }
            return bitmap.getHeight();
        }
        return invokeV.intValue;
    }

    public byte[] n() {
        InterceptResult invokeV;
        byte[] byteArray;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            if (this.f42322b == null) {
                return null;
            }
            synchronized (m) {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                this.f42322b.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
                byteArray = byteArrayOutputStream.toByteArray();
            }
            return byteArray;
        }
        return (byte[]) invokeV.objValue;
    }

    public Rect o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.j : (Rect) invokeV.objValue;
    }

    public Bitmap p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            this.f42324d = false;
            return this.f42322b;
        }
        return (Bitmap) invokeV.objValue;
    }

    public String q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.f42321a : (String) invokeV.objValue;
    }

    public int r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            Bitmap bitmap = this.f42322b;
            if (bitmap == null) {
                return 0;
            }
            return bitmap.getWidth();
        }
        return invokeV.intValue;
    }

    public boolean s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.f42329i : invokeV.booleanValue;
    }

    public boolean t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.f42323c : invokeV.booleanValue;
    }

    public boolean u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? this.f42326f : invokeV.booleanValue;
    }

    public boolean v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? this.k : invokeV.booleanValue;
    }

    public boolean w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? this.f42322b != null : invokeV.booleanValue;
    }

    public boolean x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            if (this.f42324d && !this.f42327g.get()) {
                Bitmap bitmap = this.f42322b;
                if (bitmap != null) {
                    this.f42322b = null;
                    bitmap.recycle();
                }
                d.a.d.d.b bVar = this.f42328h;
                if (bVar != null) {
                    this.f42328h = null;
                    bVar.close();
                    return true;
                }
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void y(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048601, this, z) == null) {
            this.f42326f = z;
        }
    }

    public void z(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048602, this, i2) == null) {
        }
    }

    public a(Bitmap bitmap, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bitmap, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.f42322b = null;
        this.f42323c = false;
        this.f42324d = true;
        this.f42325e = null;
        this.f42326f = true;
        this.f42327g = new AtomicBoolean(false);
        this.f42329i = false;
        this.k = false;
        this.f42322b = bitmap;
        this.f42323c = z;
        c();
    }

    public a(Bitmap bitmap, boolean z, String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bitmap, Boolean.valueOf(z), str};
            interceptable.invokeUnInit(65539, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        this.f42322b = null;
        this.f42323c = false;
        this.f42324d = true;
        this.f42325e = null;
        this.f42326f = true;
        this.f42327g = new AtomicBoolean(false);
        this.f42329i = false;
        this.k = false;
        this.f42322b = bitmap;
        this.f42323c = z;
        this.f42321a = str;
        c();
    }

    public a(Bitmap bitmap, boolean z, String str, Rect rect) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bitmap, Boolean.valueOf(z), str, rect};
            interceptable.invokeUnInit(InputDeviceCompat.SOURCE_TRACKBALL, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(InputDeviceCompat.SOURCE_TRACKBALL, newInitContext);
                return;
            }
        }
        this.f42322b = null;
        this.f42323c = false;
        this.f42324d = true;
        this.f42325e = null;
        this.f42326f = true;
        this.f42327g = new AtomicBoolean(false);
        this.f42329i = false;
        this.k = false;
        this.f42322b = bitmap;
        this.f42323c = z;
        this.f42321a = str;
        this.j = rect;
        c();
    }

    public a(Bitmap bitmap, boolean z, String str, byte[] bArr) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bitmap, Boolean.valueOf(z), str, bArr};
            interceptable.invokeUnInit(AdIconUtil.AD_TEXT_ID, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(AdIconUtil.AD_TEXT_ID, newInitContext);
                return;
            }
        }
        this.f42322b = null;
        this.f42323c = false;
        this.f42324d = true;
        this.f42325e = null;
        this.f42326f = true;
        this.f42327g = new AtomicBoolean(false);
        this.f42329i = false;
        this.k = false;
        this.f42322b = bitmap;
        this.f42323c = z;
        this.f42321a = str;
        this.f42325e = bArr;
        c();
    }

    public a(d.a.d.d.b bVar, Bitmap bitmap, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bVar, bitmap, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65543, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65543, newInitContext);
                return;
            }
        }
        this.f42322b = null;
        this.f42323c = false;
        this.f42324d = true;
        this.f42325e = null;
        this.f42326f = true;
        this.f42327g = new AtomicBoolean(false);
        this.f42329i = false;
        this.k = false;
        this.f42328h = bVar;
        this.f42322b = bitmap;
        this.f42323c = z;
    }

    public a(d.a.d.d.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bVar};
            interceptable.invokeUnInit(AdIconUtil.BAIDU_LOGO_ID, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(AdIconUtil.BAIDU_LOGO_ID, newInitContext);
                return;
            }
        }
        this.f42322b = null;
        this.f42323c = false;
        this.f42324d = true;
        this.f42325e = null;
        this.f42326f = true;
        this.f42327g = new AtomicBoolean(false);
        this.f42329i = false;
        this.k = false;
        this.f42328h = bVar;
        this.f42329i = true;
    }
}
