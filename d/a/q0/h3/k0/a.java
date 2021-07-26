package d.a.q0.h3.k0;

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
/* loaded from: classes8.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public DragLayer f58646a;

    /* renamed from: b  reason: collision with root package name */
    public Context f58647b;

    /* renamed from: c  reason: collision with root package name */
    public Vibrator f58648c;

    /* renamed from: d  reason: collision with root package name */
    public d f58649d;

    /* renamed from: e  reason: collision with root package name */
    public c f58650e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f58651f;

    /* renamed from: g  reason: collision with root package name */
    public float f58652g;

    /* renamed from: h  reason: collision with root package name */
    public float f58653h;

    /* renamed from: i  reason: collision with root package name */
    public b f58654i;
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
        this.f58647b = context;
        this.f58648c = (Vibrator) context.getSystemService("vibrator");
        this.f58653h = this.f58647b.getResources().getDisplayMetrics().density * 20.0f;
    }

    public void a() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.f58651f) {
            this.f58651f = false;
            this.f58654i = null;
            this.f58649d.c();
            this.f58649d.e();
            this.f58646a.a();
            this.f58646a.invalidate();
        }
    }

    public final void b(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar) == null) {
            bVar.f58660f = false;
            bVar.f58661g = false;
            Rect rect = bVar.f58655a;
            int width = rect.width();
            int width2 = this.f58646a.getWidth();
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
            if (rect.left < this.l + this.f58653h) {
                bVar.f58660f = true;
                bVar.f58661g = false;
            }
            if (rect.right > (this.l + i3) - this.f58653h) {
                bVar.f58660f = false;
                bVar.f58661g = true;
            }
        }
    }

    public boolean c(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, motionEvent)) == null) {
            int action = motionEvent.getAction() & 255;
            if (action == 0) {
                this.f58652g = motionEvent.getX(0);
            } else if (action == 1 || action == 3 || action == 4 || action == 6) {
                a();
            }
            return this.f58651f;
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
            if (this.f58651f) {
                if (this.k == null) {
                    Rect rect = new Rect();
                    this.k = rect;
                    this.f58646a.getDrawingRect(rect);
                    Rect rect2 = this.k;
                    float f2 = this.f58653h;
                    rect2.top = (int) (rect2.top - f2);
                    rect2.bottom = (int) (rect2.bottom + f2);
                }
                int action = motionEvent.getAction() & 255;
                if (action != 0) {
                    if (action != 1) {
                        if (action == 2) {
                            float x = motionEvent.getX(0);
                            this.f58652g = x;
                            this.f58654i.f58655a.offset((int) (x - this.f58652g), 0);
                            b(this.f58654i);
                            i();
                        } else if (action != 3) {
                            if (action != 4) {
                            }
                        }
                    }
                    a();
                } else {
                    this.f58652g = motionEvent.getX(0);
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
            this.f58646a = dragLayer;
            dragLayer.setDragController(this);
            this.l = this.f58646a.getPaddingLeft();
            this.m = this.f58646a.getPaddingRight();
        }
    }

    public void f(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, cVar) == null) {
            this.f58650e = cVar;
            cVar.setDragController(this);
        }
    }

    public void g(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, dVar) == null) {
            this.f58649d = dVar;
        }
    }

    public void h(View view, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048583, this, view, bundle) == null) || this.f58646a == null || view == null || view.getDrawingCache() == null) {
            return;
        }
        this.f58651f = true;
        this.f58654i = new b(this.f58647b);
        Rect rect = new Rect();
        view.getDrawingRect(rect);
        this.f58646a.offsetDescendantRectToMyCoords(view, rect);
        view.setDrawingCacheEnabled(true);
        view.buildDrawingCache();
        this.f58654i.f58656b = Bitmap.createBitmap(view.getDrawingCache());
        view.destroyDrawingCache();
        view.setDrawingCacheEnabled(false);
        b bVar = this.f58654i;
        bVar.f58655a = rect;
        bVar.f58659e = bundle;
        view.setVisibility(4);
        b(this.f58654i);
        this.f58646a.setDragObject(this.f58654i);
        this.f58648c.vibrate(300L);
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.j.set(this.f58654i.f58655a);
            this.f58646a.offsetRectIntoDescendantCoords((View) this.f58649d, this.j);
            this.f58649d.a(this.j);
            this.f58646a.invalidate();
            b bVar = this.f58654i;
            if (bVar.f58660f) {
                this.f58649d.b();
            } else if (bVar.f58661g) {
                this.f58649d.d();
            } else {
                this.f58649d.c();
            }
        }
    }
}
