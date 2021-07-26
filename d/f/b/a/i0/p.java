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
/* loaded from: classes8.dex */
public class p {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: h  reason: collision with root package name */
    public static final Comparator<c> f70950h;

    /* renamed from: i  reason: collision with root package name */
    public static final Comparator<c> f70951i;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final int f70952a;

    /* renamed from: b  reason: collision with root package name */
    public final ArrayList<c> f70953b;

    /* renamed from: c  reason: collision with root package name */
    public final c[] f70954c;

    /* renamed from: d  reason: collision with root package name */
    public int f70955d;

    /* renamed from: e  reason: collision with root package name */
    public int f70956e;

    /* renamed from: f  reason: collision with root package name */
    public int f70957f;

    /* renamed from: g  reason: collision with root package name */
    public int f70958g;

    /* loaded from: classes8.dex */
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
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, cVar, cVar2)) == null) ? cVar.f70959a - cVar2.f70959a : invokeLL.intValue;
        }
    }

    /* loaded from: classes8.dex */
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
                float f2 = cVar.f70961c;
                float f3 = cVar2.f70961c;
                if (f2 < f3) {
                    return -1;
                }
                return f3 < f2 ? 1 : 0;
            }
            return invokeLL.intValue;
        }
    }

    /* loaded from: classes8.dex */
    public static class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public int f70959a;

        /* renamed from: b  reason: collision with root package name */
        public int f70960b;

        /* renamed from: c  reason: collision with root package name */
        public float f70961c;

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
        f70950h = new a();
        f70951i = new b();
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
        this.f70952a = i2;
        this.f70954c = new c[5];
        this.f70953b = new ArrayList<>();
        this.f70955d = -1;
    }

    public void a(int i2, float f2) {
        c cVar;
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), Float.valueOf(f2)}) != null) {
            return;
        }
        b();
        int i3 = this.f70958g;
        if (i3 > 0) {
            c[] cVarArr = this.f70954c;
            int i4 = i3 - 1;
            this.f70958g = i4;
            cVar = cVarArr[i4];
        } else {
            cVar = new c(null);
        }
        int i5 = this.f70956e;
        this.f70956e = i5 + 1;
        cVar.f70959a = i5;
        cVar.f70960b = i2;
        cVar.f70961c = f2;
        this.f70953b.add(cVar);
        this.f70957f += i2;
        while (true) {
            int i6 = this.f70957f;
            int i7 = this.f70952a;
            if (i6 <= i7) {
                return;
            }
            int i8 = i6 - i7;
            c cVar2 = this.f70953b.get(0);
            int i9 = cVar2.f70960b;
            if (i9 <= i8) {
                this.f70957f -= i9;
                this.f70953b.remove(0);
                int i10 = this.f70958g;
                if (i10 < 5) {
                    c[] cVarArr2 = this.f70954c;
                    this.f70958g = i10 + 1;
                    cVarArr2[i10] = cVar2;
                }
            } else {
                cVar2.f70960b = i9 - i8;
                this.f70957f -= i8;
            }
        }
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.f70955d == 1) {
            return;
        }
        Collections.sort(this.f70953b, f70950h);
        this.f70955d = 1;
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || this.f70955d == 0) {
            return;
        }
        Collections.sort(this.f70953b, f70951i);
        this.f70955d = 0;
    }

    public float d(float f2) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(1048579, this, f2)) == null) {
            c();
            float f3 = f2 * this.f70957f;
            int i2 = 0;
            for (int i3 = 0; i3 < this.f70953b.size(); i3++) {
                c cVar = this.f70953b.get(i3);
                i2 += cVar.f70960b;
                if (i2 >= f3) {
                    return cVar.f70961c;
                }
            }
            if (this.f70953b.isEmpty()) {
                return Float.NaN;
            }
            ArrayList<c> arrayList = this.f70953b;
            return arrayList.get(arrayList.size() - 1).f70961c;
        }
        return invokeF.floatValue;
    }
}
