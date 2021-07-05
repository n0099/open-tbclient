package d.a.s0.w;

import android.os.Looper;
import android.util.AndroidRuntimeException;
import android.view.View;
import androidx.annotation.RestrictTo;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.s0.w.a;
import d.a.s0.w.b;
import java.util.ArrayList;
/* loaded from: classes9.dex */
public abstract class b<T extends b<T>> implements a.b {
    public static /* synthetic */ Interceptable $ic;
    public static final l m;
    public static final l n;
    public static final l o;
    public static final l p;
    public static final l q;
    public static final l r;
    public static final l s;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public float f68900a;

    /* renamed from: b  reason: collision with root package name */
    public float f68901b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f68902c;

    /* renamed from: d  reason: collision with root package name */
    public final Object f68903d;

    /* renamed from: e  reason: collision with root package name */
    public final d.a.s0.w.c f68904e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f68905f;

    /* renamed from: g  reason: collision with root package name */
    public float f68906g;

    /* renamed from: h  reason: collision with root package name */
    public float f68907h;

    /* renamed from: i  reason: collision with root package name */
    public long f68908i;
    public float j;
    public final ArrayList<j> k;
    public final ArrayList<k> l;

    /* loaded from: classes9.dex */
    public static class a extends l {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(String str) {
            super(str, null);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((String) objArr2[0], (C1864b) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.s0.w.c
        /* renamed from: c */
        public float a(View view) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, view)) == null) ? view.getAlpha() : invokeL.floatValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.s0.w.c
        /* renamed from: d */
        public void b(View view, float f2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLF(1048579, this, view, f2) == null) {
                view.setAlpha(f2);
            }
        }
    }

    /* renamed from: d.a.s0.w.b$b  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public static class C1864b extends l {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes9.dex */
    public static class c extends l {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(String str) {
            super(str, null);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((String) objArr2[0], (C1864b) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.s0.w.c
        /* renamed from: c */
        public float a(View view) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, view)) == null) ? view.getTranslationY() : invokeL.floatValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.s0.w.c
        /* renamed from: d */
        public void b(View view, float f2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLF(1048579, this, view, f2) == null) {
                view.setTranslationY(f2);
            }
        }
    }

    /* loaded from: classes9.dex */
    public static class d extends l {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(String str) {
            super(str, null);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((String) objArr2[0], (C1864b) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.s0.w.c
        /* renamed from: c */
        public float a(View view) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, view)) == null) ? view.getScaleX() : invokeL.floatValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.s0.w.c
        /* renamed from: d */
        public void b(View view, float f2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLF(1048579, this, view, f2) == null) {
                view.setScaleX(f2);
            }
        }
    }

    /* loaded from: classes9.dex */
    public static class e extends l {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(String str) {
            super(str, null);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((String) objArr2[0], (C1864b) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.s0.w.c
        /* renamed from: c */
        public float a(View view) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, view)) == null) ? view.getScaleY() : invokeL.floatValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.s0.w.c
        /* renamed from: d */
        public void b(View view, float f2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLF(1048579, this, view, f2) == null) {
                view.setScaleY(f2);
            }
        }
    }

    /* loaded from: classes9.dex */
    public static class f extends l {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(String str) {
            super(str, null);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((String) objArr2[0], (C1864b) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.s0.w.c
        /* renamed from: c */
        public float a(View view) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, view)) == null) ? view.getRotation() : invokeL.floatValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.s0.w.c
        /* renamed from: d */
        public void b(View view, float f2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLF(1048579, this, view, f2) == null) {
                view.setRotation(f2);
            }
        }
    }

    /* loaded from: classes9.dex */
    public static class g extends l {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(String str) {
            super(str, null);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((String) objArr2[0], (C1864b) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.s0.w.c
        /* renamed from: c */
        public float a(View view) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, view)) == null) ? view.getRotationX() : invokeL.floatValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.s0.w.c
        /* renamed from: d */
        public void b(View view, float f2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLF(1048579, this, view, f2) == null) {
                view.setRotationX(f2);
            }
        }
    }

    /* loaded from: classes9.dex */
    public static class h extends l {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public h(String str) {
            super(str, null);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((String) objArr2[0], (C1864b) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.s0.w.c
        /* renamed from: c */
        public float a(View view) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, view)) == null) ? view.getRotationY() : invokeL.floatValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.s0.w.c
        /* renamed from: d */
        public void b(View view, float f2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLF(1048579, this, view, f2) == null) {
                view.setRotationY(f2);
            }
        }
    }

    /* loaded from: classes9.dex */
    public static class i {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public float f68909a;

        /* renamed from: b  reason: collision with root package name */
        public float f68910b;

        public i() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public interface j {
        void a(b bVar, boolean z, float f2, float f3);
    }

    /* loaded from: classes9.dex */
    public interface k {
        void a(b bVar, float f2, float f3);
    }

    /* loaded from: classes9.dex */
    public static abstract class l extends d.a.s0.w.c<View> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public /* synthetic */ l(String str, C1864b c1864b) {
            this(str);
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public l(String str) {
            super(str);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((String) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1544135170, "Ld/a/s0/w/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1544135170, "Ld/a/s0/w/b;");
                return;
            }
        }
        m = new c("translationY");
        n = new d("scaleX");
        o = new e("scaleY");
        p = new f("rotation");
        q = new g("rotationX");
        r = new h("rotationY");
        s = new a("alpha");
    }

    public <K> b(K k2, d.a.s0.w.c<K> cVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {k2, cVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f68900a = 0.0f;
        this.f68901b = Float.MAX_VALUE;
        this.f68902c = false;
        this.f68905f = false;
        this.f68906g = Float.MAX_VALUE;
        this.f68907h = -Float.MAX_VALUE;
        this.f68908i = 0L;
        this.k = new ArrayList<>();
        this.l = new ArrayList<>();
        this.f68903d = k2;
        this.f68904e = cVar;
        if (cVar != p && cVar != q && cVar != r) {
            if (cVar == s) {
                this.j = 0.00390625f;
                return;
            } else if (cVar != n && cVar != o) {
                this.j = 1.0f;
                return;
            } else {
                this.j = 0.00390625f;
                return;
            }
        }
        this.j = 0.1f;
    }

    public static <T> void e(ArrayList<T> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, arrayList) == null) {
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                if (arrayList.get(size) == null) {
                    arrayList.remove(size);
                }
            }
        }
    }

    @Override // d.a.s0.w.a.b
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public boolean a(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048576, this, j2)) == null) {
            long j3 = this.f68908i;
            if (j3 == 0) {
                this.f68908i = j2;
                f(this.f68901b);
                return false;
            }
            this.f68908i = j2;
            boolean i2 = i(j2 - j3);
            float min = Math.min(this.f68901b, this.f68906g);
            this.f68901b = min;
            float max = Math.max(min, this.f68907h);
            this.f68901b = max;
            f(max);
            if (i2) {
                b(false);
            }
            return i2;
        }
        return invokeJ.booleanValue;
    }

    public final void b(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            this.f68905f = false;
            d.a.s0.w.a.i().l(this);
            this.f68908i = 0L;
            this.f68902c = false;
            for (int i2 = 0; i2 < this.k.size(); i2++) {
                if (this.k.get(i2) != null) {
                    this.k.get(i2).a(this, z, this.f68901b, this.f68900a);
                }
            }
            e(this.k);
        }
    }

    public final float c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f68904e.a(this.f68903d) : invokeV.floatValue;
    }

    public float d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.j * 0.75f : invokeV.floatValue;
    }

    public void f(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048580, this, f2) == null) {
            this.f68904e.b(this.f68903d, f2);
            for (int i2 = 0; i2 < this.l.size(); i2++) {
                if (this.l.get(i2) != null) {
                    this.l.get(i2).a(this, this.f68901b, this.f68900a);
                }
            }
            e(this.l);
        }
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            if (Looper.myLooper() == Looper.getMainLooper()) {
                if (this.f68905f) {
                    return;
                }
                h();
                return;
            }
            throw new AndroidRuntimeException("Animations may only be started on the main thread");
        }
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || this.f68905f) {
            return;
        }
        this.f68905f = true;
        if (!this.f68902c) {
            this.f68901b = c();
        }
        float f2 = this.f68901b;
        if (f2 <= this.f68906g && f2 >= this.f68907h) {
            d.a.s0.w.a.i().f(this, 0L);
            return;
        }
        throw new IllegalArgumentException("Starting value need to be in between min value and max value");
    }

    public abstract boolean i(long j2);
}
