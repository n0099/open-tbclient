package com.repackage;

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
/* loaded from: classes6.dex */
public class jk8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public DragLayer a;
    public Context b;
    public Vibrator c;
    public mk8 d;
    public lk8 e;
    public boolean f;
    public float g;
    public float h;
    public kk8 i;
    public Rect j;
    public Rect k;
    public int l;
    public int m;

    public jk8(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.j = new Rect();
        this.b = context;
        this.c = (Vibrator) context.getSystemService("vibrator");
        this.h = this.b.getResources().getDisplayMetrics().density * 20.0f;
    }

    public void a() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.f) {
            this.f = false;
            this.i = null;
            this.d.c();
            this.d.e();
            this.a.a();
            this.a.invalidate();
        }
    }

    public final void b(kk8 kk8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, kk8Var) == null) {
            kk8Var.f = false;
            kk8Var.g = false;
            Rect rect = kk8Var.a;
            int width = rect.width();
            int width2 = this.a.getWidth();
            int i = this.l;
            int i2 = (width2 - i) - this.m;
            if (rect.left < i) {
                rect.left = i;
                rect.right = i + width;
            }
            int i3 = rect.right;
            int i4 = this.l;
            if (i3 > i4 + i2) {
                int i5 = i4 + i2;
                rect.right = i5;
                rect.left = i5 - width;
            }
            if (rect.left < this.l + this.h) {
                kk8Var.f = true;
                kk8Var.g = false;
            }
            if (rect.right > (this.l + i2) - this.h) {
                kk8Var.f = false;
                kk8Var.g = true;
            }
        }
    }

    public boolean c(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, motionEvent)) == null) {
            int action = motionEvent.getAction() & 255;
            if (action == 0) {
                this.g = motionEvent.getX(0);
            } else if (action == 1 || action == 3 || action == 4 || action == 6) {
                a();
            }
            return this.f;
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
            if (this.f) {
                if (this.k == null) {
                    Rect rect = new Rect();
                    this.k = rect;
                    this.a.getDrawingRect(rect);
                    Rect rect2 = this.k;
                    float f = this.h;
                    rect2.top = (int) (rect2.top - f);
                    rect2.bottom = (int) (rect2.bottom + f);
                }
                int action = motionEvent.getAction() & 255;
                if (action != 0) {
                    if (action != 1) {
                        if (action == 2) {
                            float x = motionEvent.getX(0);
                            this.g = x;
                            this.i.a.offset((int) (x - this.g), 0);
                            b(this.i);
                            i();
                        } else if (action != 3) {
                            if (action != 4) {
                            }
                        }
                    }
                    a();
                } else {
                    this.g = motionEvent.getX(0);
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
            this.a = dragLayer;
            dragLayer.setDragController(this);
            this.l = this.a.getPaddingLeft();
            this.m = this.a.getPaddingRight();
        }
    }

    public void f(lk8 lk8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, lk8Var) == null) {
            this.e = lk8Var;
            lk8Var.setDragController(this);
        }
    }

    public void g(mk8 mk8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, mk8Var) == null) {
            this.d = mk8Var;
        }
    }

    public void h(View view2, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048583, this, view2, bundle) == null) || this.a == null || view2 == null || view2.getDrawingCache() == null) {
            return;
        }
        this.f = true;
        this.i = new kk8(this.b);
        Rect rect = new Rect();
        view2.getDrawingRect(rect);
        this.a.offsetDescendantRectToMyCoords(view2, rect);
        view2.setDrawingCacheEnabled(true);
        view2.buildDrawingCache();
        this.i.b = Bitmap.createBitmap(view2.getDrawingCache());
        view2.destroyDrawingCache();
        view2.setDrawingCacheEnabled(false);
        kk8 kk8Var = this.i;
        kk8Var.a = rect;
        kk8Var.e = bundle;
        view2.setVisibility(4);
        b(this.i);
        this.a.setDragObject(this.i);
        this.c.vibrate(300L);
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.j.set(this.i.a);
            this.a.offsetRectIntoDescendantCoords((View) this.d, this.j);
            this.d.a(this.j);
            this.a.invalidate();
            kk8 kk8Var = this.i;
            if (kk8Var.f) {
                this.d.b();
            } else if (kk8Var.g) {
                this.d.d();
            } else {
                this.d.c();
            }
        }
    }
}
