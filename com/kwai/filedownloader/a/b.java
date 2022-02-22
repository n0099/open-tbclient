package com.kwai.filedownloader.a;

import android.util.SparseArray;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwai.filedownloader.a.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes4.dex */
public class b implements com.kwai.filedownloader.a.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final SparseArray<com.kwai.filedownloader.c.c> a;

    /* renamed from: b  reason: collision with root package name */
    public final SparseArray<List<com.kwai.filedownloader.c.a>> f58355b;

    /* loaded from: classes4.dex */
    public class a implements a.InterfaceC2171a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b a;

        public a(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bVar;
        }

        @Override // com.kwai.filedownloader.a.a.InterfaceC2171a
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            }
        }

        @Override // com.kwai.filedownloader.a.a.InterfaceC2171a
        public void a(int i2, com.kwai.filedownloader.c.c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, cVar) == null) {
            }
        }

        @Override // com.kwai.filedownloader.a.a.InterfaceC2171a
        public void a(com.kwai.filedownloader.c.c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, cVar) == null) {
            }
        }

        @Override // com.kwai.filedownloader.a.a.InterfaceC2171a
        public void b(com.kwai.filedownloader.c.c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, cVar) == null) {
            }
        }

        @Override // java.lang.Iterable
        public Iterator<com.kwai.filedownloader.c.c> iterator() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? new C2172b(this.a) : (Iterator) invokeV.objValue;
        }
    }

    /* renamed from: com.kwai.filedownloader.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C2172b implements Iterator<com.kwai.filedownloader.c.c> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b a;

        public C2172b(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Iterator
        /* renamed from: a */
        public com.kwai.filedownloader.c.c next() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return null;
            }
            return (com.kwai.filedownloader.c.c) invokeV.objValue;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return false;
            }
            return invokeV.booleanValue;
        }

        @Override // java.util.Iterator
        public void remove() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            }
        }
    }

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
                return;
            }
        }
        this.a = new SparseArray<>();
        this.f58355b = new SparseArray<>();
    }

    @Override // com.kwai.filedownloader.a.a
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            synchronized (this.a) {
                this.a.clear();
            }
        }
    }

    @Override // com.kwai.filedownloader.a.a
    public void a(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
        }
    }

    @Override // com.kwai.filedownloader.a.a
    public void a(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(Constants.METHOD_SEND_USER_MSG, this, i2, i3) == null) {
        }
    }

    @Override // com.kwai.filedownloader.a.a
    public void a(int i2, int i3, long j2) {
        List<com.kwai.filedownloader.c.a> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Long.valueOf(j2)}) == null) {
            synchronized (this.f58355b) {
                list = this.f58355b.get(i2);
            }
            if (list == null) {
                return;
            }
            for (com.kwai.filedownloader.c.a aVar : list) {
                if (aVar.b() == i3) {
                    aVar.b(j2);
                    return;
                }
            }
        }
    }

    @Override // com.kwai.filedownloader.a.a
    public void a(int i2, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i2), Long.valueOf(j2)}) == null) {
        }
    }

    @Override // com.kwai.filedownloader.a.a
    public void a(int i2, long j2, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{Integer.valueOf(i2), Long.valueOf(j2), str, str2}) == null) {
        }
    }

    @Override // com.kwai.filedownloader.a.a
    public void a(int i2, String str, long j2, long j3, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{Integer.valueOf(i2), str, Long.valueOf(j2), Long.valueOf(j3), Integer.valueOf(i3)}) == null) {
        }
    }

    @Override // com.kwai.filedownloader.a.a
    public void a(int i2, Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048583, this, i2, th) == null) {
        }
    }

    @Override // com.kwai.filedownloader.a.a
    public void a(int i2, Throwable th, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{Integer.valueOf(i2), th, Long.valueOf(j2)}) == null) {
        }
    }

    @Override // com.kwai.filedownloader.a.a
    public void a(com.kwai.filedownloader.c.a aVar) {
        List<com.kwai.filedownloader.c.a> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, aVar) == null) {
            try {
                int a2 = aVar.a();
                synchronized (this.f58355b) {
                    list = this.f58355b.get(a2);
                    if (list == null) {
                        list = new ArrayList<>();
                        this.f58355b.put(a2, list);
                    }
                }
                list.add(aVar);
            } catch (Exception unused) {
            }
        }
    }

    @Override // com.kwai.filedownloader.a.a
    public void a(com.kwai.filedownloader.c.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, cVar) == null) {
            if (cVar == null) {
                com.kwai.filedownloader.e.d.d(this, "update but model == null!", new Object[0]);
            } else if (b(cVar.a()) == null) {
                b(cVar);
            } else {
                synchronized (this.a) {
                    this.a.remove(cVar.a());
                    this.a.put(cVar.a(), cVar);
                }
            }
        }
    }

    @Override // com.kwai.filedownloader.a.a
    public a.InterfaceC2171a b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? new a(this) : (a.InterfaceC2171a) invokeV.objValue;
    }

    @Override // com.kwai.filedownloader.a.a
    public com.kwai.filedownloader.c.c b(int i2) {
        InterceptResult invokeI;
        com.kwai.filedownloader.c.c cVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048588, this, i2)) == null) {
            synchronized (this.a) {
                cVar = this.a.get(i2);
            }
            return cVar;
        }
        return (com.kwai.filedownloader.c.c) invokeI.objValue;
    }

    @Override // com.kwai.filedownloader.a.a
    public void b(int i2, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048589, this, new Object[]{Integer.valueOf(i2), Long.valueOf(j2)}) == null) {
            e(i2);
        }
    }

    public void b(com.kwai.filedownloader.c.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, cVar) == null) {
            synchronized (this.a) {
                this.a.put(cVar.a(), cVar);
            }
        }
    }

    @Override // com.kwai.filedownloader.a.a
    public List<com.kwai.filedownloader.c.a> c(int i2) {
        List<com.kwai.filedownloader.c.a> list;
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048591, this, i2)) == null) {
            try {
                ArrayList arrayList = new ArrayList();
                synchronized (this.f58355b) {
                    list = this.f58355b.get(i2);
                }
                if (list != null) {
                    arrayList.addAll(list);
                }
                return arrayList;
            } catch (Exception unused) {
                return new ArrayList();
            }
        }
        return (List) invokeI.objValue;
    }

    @Override // com.kwai.filedownloader.a.a
    public void c(int i2, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048592, this, new Object[]{Integer.valueOf(i2), Long.valueOf(j2)}) == null) {
        }
    }

    @Override // com.kwai.filedownloader.a.a
    public void d(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048593, this, i2) == null) {
            try {
                synchronized (this.f58355b) {
                    this.f58355b.remove(i2);
                }
            } catch (Exception unused) {
            }
        }
    }

    @Override // com.kwai.filedownloader.a.a
    public boolean e(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048594, this, i2)) == null) {
            synchronized (this.a) {
                this.a.remove(i2);
            }
            return true;
        }
        return invokeI.booleanValue;
    }

    @Override // com.kwai.filedownloader.a.a
    public void f(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048595, this, i2) == null) {
        }
    }
}
