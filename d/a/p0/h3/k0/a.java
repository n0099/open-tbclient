package d.a.p0.h3.k0;

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
    public DragLayer f58071a;

    /* renamed from: b  reason: collision with root package name */
    public Context f58072b;

    /* renamed from: c  reason: collision with root package name */
    public Vibrator f58073c;

    /* renamed from: d  reason: collision with root package name */
    public d f58074d;

    /* renamed from: e  reason: collision with root package name */
    public c f58075e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f58076f;

    /* renamed from: g  reason: collision with root package name */
    public float f58077g;

    /* renamed from: h  reason: collision with root package name */
    public float f58078h;

    /* renamed from: i  reason: collision with root package name */
    public b f58079i;
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
        this.f58072b = context;
        this.f58073c = (Vibrator) context.getSystemService("vibrator");
        this.f58078h = this.f58072b.getResources().getDisplayMetrics().density * 20.0f;
    }

    public void a() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.f58076f) {
            this.f58076f = false;
            this.f58079i = null;
            this.f58074d.c();
            this.f58074d.e();
            this.f58071a.a();
            this.f58071a.invalidate();
        }
    }

    public final void b(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar) == null) {
            bVar.f58085f = false;
            bVar.f58086g = false;
            Rect rect = bVar.f58080a;
            int width = rect.width();
            int width2 = this.f58071a.getWidth();
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
            if (rect.left < this.l + this.f58078h) {
                bVar.f58085f = true;
                bVar.f58086g = false;
            }
            if (rect.right > (this.l + i3) - this.f58078h) {
                bVar.f58085f = false;
                bVar.f58086g = true;
            }
        }
    }

    public boolean c(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, motionEvent)) == null) {
            int action = motionEvent.getAction() & 255;
            if (action == 0) {
                this.f58077g = motionEvent.getX(0);
            } else if (action == 1 || action == 3 || action == 4 || action == 6) {
                a();
            }
            return this.f58076f;
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
            if (this.f58076f) {
                if (this.k == null) {
                    Rect rect = new Rect();
                    this.k = rect;
                    this.f58071a.getDrawingRect(rect);
                    Rect rect2 = this.k;
                    float f2 = this.f58078h;
                    rect2.top = (int) (rect2.top - f2);
                    rect2.bottom = (int) (rect2.bottom + f2);
                }
                int action = motionEvent.getAction() & 255;
                if (action != 0) {
                    if (action != 1) {
                        if (action == 2) {
                            float x = motionEvent.getX(0);
                            this.f58077g = x;
                            this.f58079i.f58080a.offset((int) (x - this.f58077g), 0);
                            b(this.f58079i);
                            i();
                        } else if (action != 3) {
                            if (action != 4) {
                            }
                        }
                    }
                    a();
                } else {
                    this.f58077g = motionEvent.getX(0);
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
            this.f58071a = dragLayer;
            dragLayer.setDragController(this);
            this.l = this.f58071a.getPaddingLeft();
            this.m = this.f58071a.getPaddingRight();
        }
    }

    public void f(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, cVar) == null) {
            this.f58075e = cVar;
            cVar.setDragController(this);
        }
    }

    public void g(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, dVar) == null) {
            this.f58074d = dVar;
        }
    }

    public void h(View view, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048583, this, view, bundle) == null) || this.f58071a == null || view == null || view.getDrawingCache() == null) {
            return;
        }
        this.f58076f = true;
        this.f58079i = new b(this.f58072b);
        Rect rect = new Rect();
        view.getDrawingRect(rect);
        this.f58071a.offsetDescendantRectToMyCoords(view, rect);
        view.setDrawingCacheEnabled(true);
        view.buildDrawingCache();
        this.f58079i.f58081b = Bitmap.createBitmap(view.getDrawingCache());
        view.destroyDrawingCache();
        view.setDrawingCacheEnabled(false);
        b bVar = this.f58079i;
        bVar.f58080a = rect;
        bVar.f58084e = bundle;
        view.setVisibility(4);
        b(this.f58079i);
        this.f58071a.setDragObject(this.f58079i);
        this.f58073c.vibrate(300L);
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.j.set(this.f58079i.f58080a);
            this.f58071a.offsetRectIntoDescendantCoords((View) this.f58074d, this.j);
            this.f58074d.a(this.j);
            this.f58071a.invalidate();
            b bVar = this.f58079i;
            if (bVar.f58085f) {
                this.f58074d.b();
            } else if (bVar.f58086g) {
                this.f58074d.d();
            } else {
                this.f58074d.c();
            }
        }
    }
}
