package d.a.c.k.e;

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
import d.a.c.k.e.c;
/* loaded from: classes8.dex */
public class f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f44849a;

    /* renamed from: b  reason: collision with root package name */
    public int f44850b;

    /* renamed from: c  reason: collision with root package name */
    public d.a.c.k.f.a f44851c;

    /* renamed from: d  reason: collision with root package name */
    public c.a f44852d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f44853e;

    /* renamed from: f  reason: collision with root package name */
    public b f44854f;

    /* renamed from: g  reason: collision with root package name */
    public int f44855g;

    /* renamed from: h  reason: collision with root package name */
    public View f44856h;

    /* renamed from: i  reason: collision with root package name */
    public Handler f44857i;
    public Runnable j;

    /* loaded from: classes8.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ f f44858e;

        public a(f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f44858e = fVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            b bVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (bVar = this.f44858e.f44854f) == null) {
                return;
            }
            bVar.b();
        }
    }

    /* loaded from: classes8.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public int f44859e;

        /* renamed from: f  reason: collision with root package name */
        public Scroller f44860f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ f f44861g;

        public b(f fVar, Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar, context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f44861g = fVar;
            this.f44860f = new Scroller(context);
        }

        public final void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                f fVar = this.f44861g;
                fVar.f44857i.removeCallbacks(fVar.j);
                Scroller scroller = this.f44860f;
                if (scroller != null) {
                    scroller.abortAnimation();
                    this.f44860f.forceFinished(true);
                }
                View view = this.f44861g.f44856h;
                if (view != null) {
                    view.removeCallbacks(this);
                }
                if (this.f44861g.f44851c != null) {
                    this.f44861g.f44851c.onOver();
                }
            }
        }

        public final void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                f fVar = this.f44861g;
                Handler handler = fVar.f44857i;
                if (handler != null) {
                    handler.removeCallbacks(fVar.j);
                }
                View view = this.f44861g.f44856h;
                if (view != null) {
                    view.removeCallbacks(this);
                }
            }
        }

        public void d(int i2, int i3) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeII(Constants.METHOD_SEND_USER_MSG, this, i2, i3) == null) || this.f44861g.f44856h == null || this.f44860f == null) {
                return;
            }
            if (i2 == 0) {
                i2--;
            }
            c();
            this.f44859e = 0;
            this.f44860f.startScroll(0, 0, 0, i2, i3);
            this.f44861g.f44856h.post(this);
        }

        @Override // java.lang.Runnable
        public void run() {
            Scroller scroller;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || this.f44861g.f44856h == null || (scroller = this.f44860f) == null) {
                return;
            }
            boolean computeScrollOffset = scroller.computeScrollOffset();
            boolean z = false;
            if (this.f44860f.timePassed() >= this.f44861g.f44855g) {
                computeScrollOffset = false;
            }
            int currY = this.f44860f.getCurrY();
            int i2 = currY - this.f44859e;
            boolean z2 = true;
            if (computeScrollOffset) {
                if (i2 != 0) {
                    z = !this.f44861g.c(i2);
                    this.f44859e = currY;
                }
                if (!z) {
                    this.f44861g.f44856h.post(this);
                }
                z2 = z;
            }
            if (z2) {
                f fVar = this.f44861g;
                fVar.f44857i.removeCallbacks(fVar.j);
                f fVar2 = this.f44861g;
                fVar2.f44857i.post(fVar2.j);
            }
        }
    }

    public f(Context context, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i5 = newInitContext.flag;
            if ((i5 & 1) != 0) {
                int i6 = i5 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f44849a = 1;
        this.f44853e = true;
        this.f44857i = new Handler();
        this.j = new a(this);
        int abs = Math.abs(i2 - i3);
        this.f44850b = i3;
        if (abs < this.f44849a) {
            this.f44853e = false;
        }
        this.f44854f = new b(this, context);
        this.f44855g = i4;
    }

    public final boolean c(int i2) {
        InterceptResult invokeI;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
            int paddingTop = this.f44856h.getPaddingTop() - Math.abs(i2);
            int i3 = this.f44850b;
            if (paddingTop <= i3) {
                paddingTop = i3;
                z = false;
            } else {
                z = true;
            }
            View view = this.f44856h;
            view.setPadding(view.getPaddingLeft(), paddingTop, this.f44856h.getPaddingRight(), this.f44856h.getPaddingBottom());
            c.a aVar = this.f44852d;
            if (aVar != null) {
                aVar.a(null, this.f44856h.getPaddingLeft(), this.f44856h.getPaddingRight(), this.f44856h.getPaddingTop() - this.f44850b, this.f44856h.getPaddingBottom());
            }
            return z;
        }
        return invokeI.booleanValue;
    }

    public void d(d.a.c.k.f.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
            this.f44851c = aVar;
        }
    }

    public void e(c.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, aVar) == null) {
            this.f44852d = aVar;
        }
    }

    public void f(View view) {
        b bVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, view) == null) && this.f44853e && (bVar = this.f44854f) != null) {
            this.f44856h = view;
            bVar.d(Math.abs(this.f44850b), this.f44855g);
            this.f44857i.postDelayed(this.j, this.f44855g);
        }
    }
}
