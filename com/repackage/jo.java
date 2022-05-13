package com.repackage;

import android.content.Context;
import android.os.Handler;
import android.view.View;
import android.widget.Scroller;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.go;
/* loaded from: classes6.dex */
public class jo {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public int b;
    public dp c;
    public go.a d;
    public boolean e;
    public b f;
    public int g;
    public View h;
    public Handler i;
    public Runnable j;

    /* loaded from: classes6.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ jo a;

        public a(jo joVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {joVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = joVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            b bVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (bVar = this.a.f) == null) {
                return;
            }
            bVar.b();
        }
    }

    /* loaded from: classes6.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;
        public Scroller b;
        public final /* synthetic */ jo c;

        public b(jo joVar, Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {joVar, context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = joVar;
            this.b = new Scroller(context);
        }

        public final void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                jo joVar = this.c;
                joVar.i.removeCallbacks(joVar.j);
                Scroller scroller = this.b;
                if (scroller != null) {
                    scroller.abortAnimation();
                    this.b.forceFinished(true);
                }
                View view2 = this.c.h;
                if (view2 != null) {
                    view2.removeCallbacks(this);
                }
                if (this.c.c != null) {
                    this.c.c.onOver();
                }
            }
        }

        public final void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                jo joVar = this.c;
                Handler handler = joVar.i;
                if (handler != null) {
                    handler.removeCallbacks(joVar.j);
                }
                View view2 = this.c.h;
                if (view2 != null) {
                    view2.removeCallbacks(this);
                }
            }
        }

        public void d(int i, int i2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeII(Constants.METHOD_SEND_USER_MSG, this, i, i2) == null) || this.c.h == null || this.b == null) {
                return;
            }
            if (i == 0) {
                i--;
            }
            c();
            this.a = 0;
            this.b.startScroll(0, 0, 0, i, i2);
            this.c.h.post(this);
        }

        @Override // java.lang.Runnable
        public void run() {
            Scroller scroller;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || this.c.h == null || (scroller = this.b) == null) {
                return;
            }
            boolean computeScrollOffset = scroller.computeScrollOffset();
            boolean z = false;
            if (this.b.timePassed() >= this.c.g) {
                computeScrollOffset = false;
            }
            int currY = this.b.getCurrY();
            int i = currY - this.a;
            boolean z2 = true;
            if (computeScrollOffset) {
                if (i != 0) {
                    z = !this.c.c(i);
                    this.a = currY;
                }
                if (!z) {
                    this.c.h.post(this);
                }
                z2 = z;
            }
            if (z2) {
                jo joVar = this.c;
                joVar.i.removeCallbacks(joVar.j);
                jo joVar2 = this.c;
                joVar2.i.post(joVar2.j);
            }
        }
    }

    public jo(Context context, int i, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = 1;
        this.e = true;
        this.i = new Handler();
        this.j = new a(this);
        int abs = Math.abs(i - i2);
        this.b = i2;
        if (abs < this.a) {
            this.e = false;
        }
        this.f = new b(this, context);
        this.g = i3;
    }

    public final boolean c(int i) {
        InterceptResult invokeI;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) {
            int paddingTop = this.h.getPaddingTop() - Math.abs(i);
            int i2 = this.b;
            if (paddingTop <= i2) {
                paddingTop = i2;
                z = false;
            } else {
                z = true;
            }
            View view2 = this.h;
            view2.setPadding(view2.getPaddingLeft(), paddingTop, this.h.getPaddingRight(), this.h.getPaddingBottom());
            go.a aVar = this.d;
            if (aVar != null) {
                aVar.a(null, this.h.getPaddingLeft(), this.h.getPaddingRight(), this.h.getPaddingTop() - this.b, this.h.getPaddingBottom());
            }
            return z;
        }
        return invokeI.booleanValue;
    }

    public void d(dp dpVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, dpVar) == null) {
            this.c = dpVar;
        }
    }

    public void e(go.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, aVar) == null) {
            this.d = aVar;
        }
    }

    public void f(View view2) {
        b bVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, view2) == null) && this.e && (bVar = this.f) != null) {
            this.h = view2;
            bVar.d(Math.abs(this.b), this.g);
            this.i.postDelayed(this.j, this.g);
        }
    }
}
