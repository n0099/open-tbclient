package d.a.s0.h3.k0;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.MotionEvent;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.tbadkCore.imgView.DragLayer;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public DragLayer f61315a;

    /* renamed from: b  reason: collision with root package name */
    public Context f61316b;

    /* renamed from: c  reason: collision with root package name */
    public Vibrator f61317c;

    /* renamed from: d  reason: collision with root package name */
    public d f61318d;

    /* renamed from: e  reason: collision with root package name */
    public c f61319e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f61320f;

    /* renamed from: g  reason: collision with root package name */
    public float f61321g;

    /* renamed from: h  reason: collision with root package name */
    public float f61322h;

    /* renamed from: i  reason: collision with root package name */
    public b f61323i;
    public Rect j;
    public Rect k;
    public int l;
    public int m;

    public a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.j = new Rect();
        this.f61316b = context;
        this.f61317c = (Vibrator) context.getSystemService("vibrator");
        this.f61322h = this.f61316b.getResources().getDisplayMetrics().density * 20.0f;
    }

    public void a() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.f61320f) {
            this.f61320f = false;
            this.f61323i = null;
            this.f61318d.c();
            this.f61318d.e();
            this.f61315a.a();
            this.f61315a.invalidate();
        }
    }

    public final void b(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar) == null) {
            bVar.f61329f = false;
            bVar.f61330g = false;
            Rect rect = bVar.f61324a;
            int width = rect.width();
            int width2 = this.f61315a.getWidth();
            int i2 = this.l;
            int i3 = (width2 - i2) - this.m;
            if (rect.left < i2) {
                rect.left = i2;
                rect.right = i2 + width;
            }
            int i4 = rect.right;
            int i5 = this.l;
            if (i4 > i5 + i3) {
                int i6 = i5 + i3;
                rect.right = i6;
                rect.left = i6 - width;
            }
            if (rect.left < this.l + this.f61322h) {
                bVar.f61329f = true;
                bVar.f61330g = false;
            }
            if (rect.right > (this.l + i3) - this.f61322h) {
                bVar.f61329f = false;
                bVar.f61330g = true;
            }
        }
    }

    public boolean c(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, motionEvent)) == null) {
            int action = motionEvent.getAction() & 255;
            if (action == 0) {
                this.f61321g = motionEvent.getX(0);
            } else if (action == 1 || action == 3 || action == 4 || action == 6) {
                a();
            }
            return this.f61320f;
        }
        return invokeL.booleanValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0041, code lost:
        if (r0 != 6) goto L21;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean d(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, motionEvent)) == null) {
            if (this.f61320f) {
                if (this.k == null) {
                    Rect rect = new Rect();
                    this.k = rect;
                    this.f61315a.getDrawingRect(rect);
                    Rect rect2 = this.k;
                    float f2 = this.f61322h;
                    rect2.top = (int) (rect2.top - f2);
                    rect2.bottom = (int) (rect2.bottom + f2);
                }
                int action = motionEvent.getAction() & 255;
                if (action != 0) {
                    if (action != 1) {
                        if (action == 2) {
                            float x = motionEvent.getX(0);
                            this.f61321g = x;
                            this.f61323i.f61324a.offset((int) (x - this.f61321g), 0);
                            b(this.f61323i);
                            i();
                        } else if (action != 3) {
                            if (action != 4) {
                            }
                        }
                    }
                    a();
                } else {
                    this.f61321g = motionEvent.getX(0);
                }
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public void e(DragLayer dragLayer) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, dragLayer) == null) {
            this.f61315a = dragLayer;
            dragLayer.setDragController(this);
            this.l = this.f61315a.getPaddingLeft();
            this.m = this.f61315a.getPaddingRight();
        }
    }

    public void f(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, cVar) == null) {
            this.f61319e = cVar;
            cVar.setDragController(this);
        }
    }

    public void g(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, dVar) == null) {
            this.f61318d = dVar;
        }
    }

    public void h(View view, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048583, this, view, bundle) == null) || this.f61315a == null || view == null || view.getDrawingCache() == null) {
            return;
        }
        this.f61320f = true;
        this.f61323i = new b(this.f61316b);
        Rect rect = new Rect();
        view.getDrawingRect(rect);
        this.f61315a.offsetDescendantRectToMyCoords(view, rect);
        view.setDrawingCacheEnabled(true);
        view.buildDrawingCache();
        this.f61323i.f61325b = Bitmap.createBitmap(view.getDrawingCache());
        view.destroyDrawingCache();
        view.setDrawingCacheEnabled(false);
        b bVar = this.f61323i;
        bVar.f61324a = rect;
        bVar.f61328e = bundle;
        view.setVisibility(4);
        b(this.f61323i);
        this.f61315a.setDragObject(this.f61323i);
        this.f61317c.vibrate(300L);
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.j.set(this.f61323i.f61324a);
            this.f61315a.offsetRectIntoDescendantCoords((View) this.f61318d, this.j);
            this.f61318d.a(this.j);
            this.f61315a.invalidate();
            b bVar = this.f61323i;
            if (bVar.f61329f) {
                this.f61318d.b();
            } else if (bVar.f61330g) {
                this.f61318d.d();
            } else {
                this.f61318d.c();
            }
        }
    }
}
