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
/* loaded from: classes7.dex */
public class f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f41865a;

    /* renamed from: b  reason: collision with root package name */
    public int f41866b;

    /* renamed from: c  reason: collision with root package name */
    public d.a.c.k.f.a f41867c;

    /* renamed from: d  reason: collision with root package name */
    public c.a f41868d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f41869e;

    /* renamed from: f  reason: collision with root package name */
    public b f41870f;

    /* renamed from: g  reason: collision with root package name */
    public int f41871g;

    /* renamed from: h  reason: collision with root package name */
    public View f41872h;

    /* renamed from: i  reason: collision with root package name */
    public Handler f41873i;
    public Runnable j;

    /* loaded from: classes7.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ f f41874e;

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
            this.f41874e = fVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            b bVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (bVar = this.f41874e.f41870f) == null) {
                return;
            }
            bVar.b();
        }
    }

    /* loaded from: classes7.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public int f41875e;

        /* renamed from: f  reason: collision with root package name */
        public Scroller f41876f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ f f41877g;

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
            this.f41877g = fVar;
            this.f41876f = new Scroller(context);
        }

        public final void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                f fVar = this.f41877g;
                fVar.f41873i.removeCallbacks(fVar.j);
                Scroller scroller = this.f41876f;
                if (scroller != null) {
                    scroller.abortAnimation();
                    this.f41876f.forceFinished(true);
                }
                View view = this.f41877g.f41872h;
                if (view != null) {
                    view.removeCallbacks(this);
                }
                if (this.f41877g.f41867c != null) {
                    this.f41877g.f41867c.onOver();
                }
            }
        }

        public final void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                f fVar = this.f41877g;
                Handler handler = fVar.f41873i;
                if (handler != null) {
                    handler.removeCallbacks(fVar.j);
                }
                View view = this.f41877g.f41872h;
                if (view != null) {
                    view.removeCallbacks(this);
                }
            }
        }

        public void d(int i2, int i3) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeII(Constants.METHOD_SEND_USER_MSG, this, i2, i3) == null) || this.f41877g.f41872h == null || this.f41876f == null) {
                return;
            }
            if (i2 == 0) {
                i2--;
            }
            c();
            this.f41875e = 0;
            this.f41876f.startScroll(0, 0, 0, i2, i3);
            this.f41877g.f41872h.post(this);
        }

        @Override // java.lang.Runnable
        public void run() {
            Scroller scroller;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || this.f41877g.f41872h == null || (scroller = this.f41876f) == null) {
                return;
            }
            boolean computeScrollOffset = scroller.computeScrollOffset();
            boolean z = false;
            if (this.f41876f.timePassed() >= this.f41877g.f41871g) {
                computeScrollOffset = false;
            }
            int currY = this.f41876f.getCurrY();
            int i2 = currY - this.f41875e;
            boolean z2 = true;
            if (computeScrollOffset) {
                if (i2 != 0) {
                    z = !this.f41877g.c(i2);
                    this.f41875e = currY;
                }
                if (!z) {
                    this.f41877g.f41872h.post(this);
                }
                z2 = z;
            }
            if (z2) {
                f fVar = this.f41877g;
                fVar.f41873i.removeCallbacks(fVar.j);
                f fVar2 = this.f41877g;
                fVar2.f41873i.post(fVar2.j);
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
        this.f41865a = 1;
        this.f41869e = true;
        this.f41873i = new Handler();
        this.j = new a(this);
        int abs = Math.abs(i2 - i3);
        this.f41866b = i3;
        if (abs < this.f41865a) {
            this.f41869e = false;
        }
        this.f41870f = new b(this, context);
        this.f41871g = i4;
    }

    public final boolean c(int i2) {
        InterceptResult invokeI;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
            int paddingTop = this.f41872h.getPaddingTop() - Math.abs(i2);
            int i3 = this.f41866b;
            if (paddingTop <= i3) {
                paddingTop = i3;
                z = false;
            } else {
                z = true;
            }
            View view = this.f41872h;
            view.setPadding(view.getPaddingLeft(), paddingTop, this.f41872h.getPaddingRight(), this.f41872h.getPaddingBottom());
            c.a aVar = this.f41868d;
            if (aVar != null) {
                aVar.a(null, this.f41872h.getPaddingLeft(), this.f41872h.getPaddingRight(), this.f41872h.getPaddingTop() - this.f41866b, this.f41872h.getPaddingBottom());
            }
            return z;
        }
        return invokeI.booleanValue;
    }

    public void d(d.a.c.k.f.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
            this.f41867c = aVar;
        }
    }

    public void e(c.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, aVar) == null) {
            this.f41868d = aVar;
        }
    }

    public void f(View view) {
        b bVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, view) == null) && this.f41869e && (bVar = this.f41870f) != null) {
            this.f41872h = view;
            bVar.d(Math.abs(this.f41866b), this.f41871g);
            this.f41873i.postDelayed(this.j, this.f41871g);
        }
    }
}
