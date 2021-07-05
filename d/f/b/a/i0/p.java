package d.f.b.a.i0;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
/* loaded from: classes10.dex */
public class p {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: h  reason: collision with root package name */
    public static final Comparator<c> f73393h;

    /* renamed from: i  reason: collision with root package name */
    public static final Comparator<c> f73394i;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final int f73395a;

    /* renamed from: b  reason: collision with root package name */
    public final ArrayList<c> f73396b;

    /* renamed from: c  reason: collision with root package name */
    public final c[] f73397c;

    /* renamed from: d  reason: collision with root package name */
    public int f73398d;

    /* renamed from: e  reason: collision with root package name */
    public int f73399e;

    /* renamed from: f  reason: collision with root package name */
    public int f73400f;

    /* renamed from: g  reason: collision with root package name */
    public int f73401g;

    /* loaded from: classes10.dex */
    public static class a implements Comparator<c> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a() {
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

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(c cVar, c cVar2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, cVar, cVar2)) == null) ? cVar.f73402a - cVar2.f73402a : invokeLL.intValue;
        }
    }

    /* loaded from: classes10.dex */
    public static class b implements Comparator<c> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b() {
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

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(c cVar, c cVar2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, cVar, cVar2)) == null) {
                float f2 = cVar.f73404c;
                float f3 = cVar2.f73404c;
                if (f2 < f3) {
                    return -1;
                }
                return f3 < f2 ? 1 : 0;
            }
            return invokeLL.intValue;
        }
    }

    /* loaded from: classes10.dex */
    public static class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public int f73402a;

        /* renamed from: b  reason: collision with root package name */
        public int f73403b;

        /* renamed from: c  reason: collision with root package name */
        public float f73404c;

        public c() {
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

        public /* synthetic */ c(a aVar) {
            this();
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(85387192, "Ld/f/b/a/i0/p;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(85387192, "Ld/f/b/a/i0/p;");
                return;
            }
        }
        f73393h = new a();
        f73394i = new b();
    }

    public p(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f73395a = i2;
        this.f73397c = new c[5];
        this.f73396b = new ArrayList<>();
        this.f73398d = -1;
    }

    public void a(int i2, float f2) {
        c cVar;
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), Float.valueOf(f2)}) != null) {
            return;
        }
        b();
        int i3 = this.f73401g;
        if (i3 > 0) {
            c[] cVarArr = this.f73397c;
            int i4 = i3 - 1;
            this.f73401g = i4;
            cVar = cVarArr[i4];
        } else {
            cVar = new c(null);
        }
        int i5 = this.f73399e;
        this.f73399e = i5 + 1;
        cVar.f73402a = i5;
        cVar.f73403b = i2;
        cVar.f73404c = f2;
        this.f73396b.add(cVar);
        this.f73400f += i2;
        while (true) {
            int i6 = this.f73400f;
            int i7 = this.f73395a;
            if (i6 <= i7) {
                return;
            }
            int i8 = i6 - i7;
            c cVar2 = this.f73396b.get(0);
            int i9 = cVar2.f73403b;
            if (i9 <= i8) {
                this.f73400f -= i9;
                this.f73396b.remove(0);
                int i10 = this.f73401g;
                if (i10 < 5) {
                    c[] cVarArr2 = this.f73397c;
                    this.f73401g = i10 + 1;
                    cVarArr2[i10] = cVar2;
                }
            } else {
                cVar2.f73403b = i9 - i8;
                this.f73400f -= i8;
            }
        }
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.f73398d == 1) {
            return;
        }
        Collections.sort(this.f73396b, f73393h);
        this.f73398d = 1;
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || this.f73398d == 0) {
            return;
        }
        Collections.sort(this.f73396b, f73394i);
        this.f73398d = 0;
    }

    public float d(float f2) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(1048579, this, f2)) == null) {
            c();
            float f3 = f2 * this.f73400f;
            int i2 = 0;
            for (int i3 = 0; i3 < this.f73396b.size(); i3++) {
                c cVar = this.f73396b.get(i3);
                i2 += cVar.f73403b;
                if (i2 >= f3) {
                    return cVar.f73404c;
                }
            }
            if (this.f73396b.isEmpty()) {
                return Float.NaN;
            }
            ArrayList<c> arrayList = this.f73396b;
            return arrayList.get(arrayList.size() - 1).f73404c;
        }
        return invokeF.floatValue;
    }
}
