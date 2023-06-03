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
/* loaded from: classes10.dex */
public final class b implements com.kwai.filedownloader.a.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final SparseArray<com.kwai.filedownloader.c.c> atQ;
    public final SparseArray<List<com.kwai.filedownloader.c.a>> atR;

    /* loaded from: classes10.dex */
    public class a implements a.InterfaceC0682a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b atS;

        public a(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.atS = bVar;
        }

        @Override // com.kwai.filedownloader.a.a.InterfaceC0682a
        public final void Di() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            }
        }

        @Override // com.kwai.filedownloader.a.a.InterfaceC0682a
        public final void a(int i, com.kwai.filedownloader.c.c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, cVar) == null) {
            }
        }

        @Override // com.kwai.filedownloader.a.a.InterfaceC0682a
        public final void c(com.kwai.filedownloader.c.c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, cVar) == null) {
            }
        }

        @Override // java.lang.Iterable
        public final Iterator<com.kwai.filedownloader.c.c> iterator() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? new C0683b(this.atS) : (Iterator) invokeV.objValue;
        }
    }

    /* renamed from: com.kwai.filedownloader.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public class C0683b implements Iterator<com.kwai.filedownloader.c.c> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b atS;

        public C0683b(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.atS = bVar;
        }

        @Override // java.util.Iterator
        public final boolean hasNext() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return false;
            }
            return invokeV.booleanValue;
        }

        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // java.util.Iterator
        public final /* bridge */ /* synthetic */ com.kwai.filedownloader.c.c next() {
            return null;
        }

        @Override // java.util.Iterator
        public final void remove() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            }
        }
    }

    public b() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.atQ = new SparseArray<>();
        this.atR = new SparseArray<>();
    }

    private void d(com.kwai.filedownloader.c.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, this, cVar) == null) {
            synchronized (this.atQ) {
                this.atQ.put(cVar.getId(), cVar);
            }
        }
    }

    @Override // com.kwai.filedownloader.a.a
    public final a.InterfaceC0682a Dh() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? new a(this) : (a.InterfaceC0682a) invokeV.objValue;
    }

    @Override // com.kwai.filedownloader.a.a
    public final void a(int i, int i2, long j) {
        List<com.kwai.filedownloader.c.a> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Long.valueOf(j)}) == null) {
            synchronized (this.atR) {
                list = this.atR.get(i);
            }
            if (list == null) {
                return;
            }
            for (com.kwai.filedownloader.c.a aVar : list) {
                if (aVar.getIndex() == i2) {
                    aVar.X(j);
                    return;
                }
            }
        }
    }

    @Override // com.kwai.filedownloader.a.a
    public final void a(int i, long j, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i), Long.valueOf(j), str, str2}) == null) {
        }
    }

    @Override // com.kwai.filedownloader.a.a
    public final void a(int i, String str, long j, long j2, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i), str, Long.valueOf(j), Long.valueOf(j2), Integer.valueOf(i2)}) == null) {
        }
    }

    @Override // com.kwai.filedownloader.a.a
    public final void a(int i, Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048580, this, i, th) == null) {
        }
    }

    @Override // com.kwai.filedownloader.a.a
    public final void a(int i, Throwable th, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{Integer.valueOf(i), th, Long.valueOf(j)}) == null) {
        }
    }

    @Override // com.kwai.filedownloader.a.a
    public final void a(com.kwai.filedownloader.c.a aVar) {
        List<com.kwai.filedownloader.c.a> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, aVar) == null) {
            try {
                int id = aVar.getId();
                synchronized (this.atR) {
                    list = this.atR.get(id);
                    if (list == null) {
                        list = new ArrayList<>();
                        this.atR.put(id, list);
                    }
                }
                list.add(aVar);
            } catch (Exception unused) {
            }
        }
    }

    @Override // com.kwai.filedownloader.a.a
    public final void b(com.kwai.filedownloader.c.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, cVar) == null) {
            if (cVar == null) {
                com.kwai.filedownloader.e.d.f(this, "update but model == null!", new Object[0]);
            } else if (cd(cVar.getId()) == null) {
                d(cVar);
            } else {
                synchronized (this.atQ) {
                    this.atQ.remove(cVar.getId());
                    this.atQ.put(cVar.getId(), cVar);
                }
            }
        }
    }

    @Override // com.kwai.filedownloader.a.a
    public final void c(int i, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{Integer.valueOf(i), Long.valueOf(j)}) == null) {
        }
    }

    @Override // com.kwai.filedownloader.a.a
    public final void cc(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i) == null) {
        }
    }

    @Override // com.kwai.filedownloader.a.a
    public final com.kwai.filedownloader.c.c cd(int i) {
        InterceptResult invokeI;
        com.kwai.filedownloader.c.c cVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048586, this, i)) == null) {
            synchronized (this.atQ) {
                cVar = this.atQ.get(i);
            }
            return cVar;
        }
        return (com.kwai.filedownloader.c.c) invokeI.objValue;
    }

    @Override // com.kwai.filedownloader.a.a
    public final List<com.kwai.filedownloader.c.a> ce(int i) {
        List<com.kwai.filedownloader.c.a> list;
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048587, this, i)) == null) {
            try {
                ArrayList arrayList = new ArrayList();
                synchronized (this.atR) {
                    list = this.atR.get(i);
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
    public final void cf(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i) == null) {
            try {
                synchronized (this.atR) {
                    this.atR.remove(i);
                }
            } catch (Exception unused) {
            }
        }
    }

    @Override // com.kwai.filedownloader.a.a
    public final boolean cg(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048589, this, i)) == null) {
            synchronized (this.atQ) {
                this.atQ.remove(i);
            }
            return true;
        }
        return invokeI.booleanValue;
    }

    @Override // com.kwai.filedownloader.a.a
    public final void ch(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i) == null) {
        }
    }

    @Override // com.kwai.filedownloader.a.a
    public final void clear() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            synchronized (this.atQ) {
                this.atQ.clear();
            }
        }
    }

    @Override // com.kwai.filedownloader.a.a
    public final void d(int i, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048592, this, new Object[]{Integer.valueOf(i), Long.valueOf(j)}) == null) {
            cg(i);
        }
    }

    @Override // com.kwai.filedownloader.a.a
    public final void e(int i, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048593, this, new Object[]{Integer.valueOf(i), Long.valueOf(j)}) == null) {
        }
    }

    @Override // com.kwai.filedownloader.a.a
    public final void x(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048594, this, i, i2) == null) {
        }
    }
}
