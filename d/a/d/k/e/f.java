package d.a.d.k.e;

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
import d.a.d.k.e.c;
/* loaded from: classes7.dex */
public class f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f42369a;

    /* renamed from: b  reason: collision with root package name */
    public int f42370b;

    /* renamed from: c  reason: collision with root package name */
    public d.a.d.k.f.a f42371c;

    /* renamed from: d  reason: collision with root package name */
    public c.a f42372d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f42373e;

    /* renamed from: f  reason: collision with root package name */
    public b f42374f;

    /* renamed from: g  reason: collision with root package name */
    public int f42375g;

    /* renamed from: h  reason: collision with root package name */
    public View f42376h;

    /* renamed from: i  reason: collision with root package name */
    public Handler f42377i;
    public Runnable j;

    /* loaded from: classes7.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ f f42378e;

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
            this.f42378e = fVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            b bVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (bVar = this.f42378e.f42374f) == null) {
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
        public int f42379e;

        /* renamed from: f  reason: collision with root package name */
        public Scroller f42380f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ f f42381g;

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
            this.f42381g = fVar;
            this.f42380f = new Scroller(context);
        }

        public final void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                f fVar = this.f42381g;
                fVar.f42377i.removeCallbacks(fVar.j);
                Scroller scroller = this.f42380f;
                if (scroller != null) {
                    scroller.abortAnimation();
                    this.f42380f.forceFinished(true);
                }
                View view = this.f42381g.f42376h;
                if (view != null) {
                    view.removeCallbacks(this);
                }
                if (this.f42381g.f42371c != null) {
                    this.f42381g.f42371c.onOver();
                }
            }
        }

        public final void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                f fVar = this.f42381g;
                Handler handler = fVar.f42377i;
                if (handler != null) {
                    handler.removeCallbacks(fVar.j);
                }
                View view = this.f42381g.f42376h;
                if (view != null) {
                    view.removeCallbacks(this);
                }
            }
        }

        public void d(int i2, int i3) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeII(Constants.METHOD_SEND_USER_MSG, this, i2, i3) == null) || this.f42381g.f42376h == null || this.f42380f == null) {
                return;
            }
            if (i2 == 0) {
                i2--;
            }
            c();
            this.f42379e = 0;
            this.f42380f.startScroll(0, 0, 0, i2, i3);
            this.f42381g.f42376h.post(this);
        }

        @Override // java.lang.Runnable
        public void run() {
            Scroller scroller;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || this.f42381g.f42376h == null || (scroller = this.f42380f) == null) {
                return;
            }
            boolean computeScrollOffset = scroller.computeScrollOffset();
            boolean z = false;
            if (this.f42380f.timePassed() >= this.f42381g.f42375g) {
                computeScrollOffset = false;
            }
            int currY = this.f42380f.getCurrY();
            int i2 = currY - this.f42379e;
            boolean z2 = true;
            if (computeScrollOffset) {
                if (i2 != 0) {
                    z = !this.f42381g.c(i2);
                    this.f42379e = currY;
                }
                if (!z) {
                    this.f42381g.f42376h.post(this);
                }
                z2 = z;
            }
            if (z2) {
                f fVar = this.f42381g;
                fVar.f42377i.removeCallbacks(fVar.j);
                f fVar2 = this.f42381g;
                fVar2.f42377i.post(fVar2.j);
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
        this.f42369a = 1;
        this.f42373e = true;
        this.f42377i = new Handler();
        this.j = new a(this);
        int abs = Math.abs(i2 - i3);
        this.f42370b = i3;
        if (abs < this.f42369a) {
            this.f42373e = false;
        }
        this.f42374f = new b(this, context);
        this.f42375g = i4;
    }

    public final boolean c(int i2) {
        InterceptResult invokeI;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
            int paddingTop = this.f42376h.getPaddingTop() - Math.abs(i2);
            int i3 = this.f42370b;
            if (paddingTop <= i3) {
                paddingTop = i3;
                z = false;
            } else {
                z = true;
            }
            View view = this.f42376h;
            view.setPadding(view.getPaddingLeft(), paddingTop, this.f42376h.getPaddingRight(), this.f42376h.getPaddingBottom());
            c.a aVar = this.f42372d;
            if (aVar != null) {
                aVar.a(null, this.f42376h.getPaddingLeft(), this.f42376h.getPaddingRight(), this.f42376h.getPaddingTop() - this.f42370b, this.f42376h.getPaddingBottom());
            }
            return z;
        }
        return invokeI.booleanValue;
    }

    public void d(d.a.d.k.f.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
            this.f42371c = aVar;
        }
    }

    public void e(c.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, aVar) == null) {
            this.f42372d = aVar;
        }
    }

    public void f(View view) {
        b bVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, view) == null) && this.f42373e && (bVar = this.f42374f) != null) {
            this.f42376h = view;
            bVar.d(Math.abs(this.f42370b), this.f42375g);
            this.f42377i.postDelayed(this.j, this.f42375g);
        }
    }
}
