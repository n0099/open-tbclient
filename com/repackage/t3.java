package com.repackage;

import androidx.core.view.InputDeviceCompat;
import com.badlogic.gdx.utils.GdxRuntimeException;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Iterator;
import java.util.NoSuchElementException;
/* loaded from: classes7.dex */
public final class t3 implements Iterable<s3>, Comparable<t3> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final s3[] a;
    public final int b;
    public long c;
    public a<s3> d;

    /* loaded from: classes7.dex */
    public static class a<T> implements Iterable<T> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final T[] a;
        public b b;
        public b c;

        public a(T[] tArr) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tArr};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tArr;
        }

        @Override // java.lang.Iterable
        public Iterator<T> iterator() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                if (f7.a) {
                    return new b(this.a);
                }
                if (this.b == null) {
                    this.b = new b(this.a);
                    this.c = new b(this.a);
                }
                b bVar = this.b;
                if (!bVar.c) {
                    bVar.b = 0;
                    bVar.c = true;
                    this.c.c = false;
                    return bVar;
                }
                b bVar2 = this.c;
                bVar2.b = 0;
                bVar2.c = true;
                bVar.c = false;
                return bVar2;
            }
            return (Iterator) invokeV.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public static class b<T> implements Iterator<T>, Iterable<T> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final T[] a;
        public int b;
        public boolean c;

        public b(T[] tArr) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tArr};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = true;
            this.a = tArr;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                if (this.c) {
                    return this.b < this.a.length;
                }
                throw new GdxRuntimeException("#iterator() cannot be used nested.");
            }
            return invokeV.booleanValue;
        }

        @Override // java.lang.Iterable
        public Iterator<T> iterator() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this : (Iterator) invokeV.objValue;
        }

        @Override // java.util.Iterator
        public T next() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                int i = this.b;
                T[] tArr = this.a;
                if (i < tArr.length) {
                    if (this.c) {
                        this.b = i + 1;
                        return tArr[i];
                    }
                    throw new GdxRuntimeException("#iterator() cannot be used nested.");
                }
                throw new NoSuchElementException(String.valueOf(this.b));
            }
            return (T) invokeV.objValue;
        }

        @Override // java.util.Iterator
        public void remove() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                throw new GdxRuntimeException("Remove not allowed.");
            }
        }
    }

    public t3(s3... s3VarArr) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {s3VarArr};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.c = -1L;
        if (s3VarArr.length != 0) {
            s3[] s3VarArr2 = new s3[s3VarArr.length];
            for (int i3 = 0; i3 < s3VarArr.length; i3++) {
                s3VarArr2[i3] = s3VarArr[i3];
            }
            this.a = s3VarArr2;
            this.b = b();
            return;
        }
        throw new IllegalArgumentException("attributes must be >= 1");
    }

    public final int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeV = interceptable.invokeV(1048576, this)) != null) {
            return invokeV.intValue;
        }
        int i = 0;
        int i2 = 0;
        while (true) {
            s3[] s3VarArr = this.a;
            if (i >= s3VarArr.length) {
                return i2;
            }
            s3 s3Var = s3VarArr[i];
            s3Var.e = i2;
            i2 += s3Var.k();
            i++;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: c */
    public int compareTo(t3 t3Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, t3Var)) == null) {
            s3[] s3VarArr = this.a;
            int length = s3VarArr.length;
            s3[] s3VarArr2 = t3Var.a;
            if (length != s3VarArr2.length) {
                return s3VarArr.length - s3VarArr2.length;
            }
            int i = (e() > t3Var.e() ? 1 : (e() == t3Var.e() ? 0 : -1));
            if (i != 0) {
                return i < 0 ? -1 : 1;
            }
            for (int length2 = this.a.length - 1; length2 >= 0; length2--) {
                s3 s3Var = this.a[length2];
                s3 s3Var2 = t3Var.a[length2];
                int i2 = s3Var.a;
                int i3 = s3Var2.a;
                if (i2 != i3) {
                    return i2 - i3;
                }
                int i4 = s3Var.g;
                int i5 = s3Var2.g;
                if (i4 != i5) {
                    return i4 - i5;
                }
                int i6 = s3Var.b;
                int i7 = s3Var2.b;
                if (i6 != i7) {
                    return i6 - i7;
                }
                boolean z = s3Var.c;
                if (z != s3Var2.c) {
                    return z ? 1 : -1;
                }
                int i8 = s3Var.d;
                int i9 = s3Var2.d;
                if (i8 != i9) {
                    return i8 - i9;
                }
            }
            return 0;
        }
        return invokeL.intValue;
    }

    public s3 d(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i)) == null) ? this.a[i] : (s3) invokeI.objValue;
    }

    public long e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (this.c == -1) {
                long j = 0;
                int i = 0;
                while (true) {
                    s3[] s3VarArr = this.a;
                    if (i >= s3VarArr.length) {
                        break;
                    }
                    j |= s3VarArr[i].a;
                    i++;
                }
                this.c = j;
            }
            return this.c;
        }
        return invokeV.longValue;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(1048581, this, obj)) != null) {
            return invokeL.booleanValue;
        }
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof t3)) {
            return false;
        }
        t3 t3Var = (t3) obj;
        if (this.a.length != t3Var.a.length) {
            return false;
        }
        int i = 0;
        while (true) {
            s3[] s3VarArr = this.a;
            if (i >= s3VarArr.length) {
                return true;
            }
            if (!s3VarArr[i].i(t3Var.a[i])) {
                return false;
            }
            i++;
        }
    }

    public int hashCode() {
        InterceptResult invokeV;
        s3[] s3VarArr;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeV = interceptable.invokeV(1048582, this)) != null) {
            return invokeV.intValue;
        }
        long length = this.a.length * 61;
        int i = 0;
        while (true) {
            if (i >= this.a.length) {
                return (int) (length ^ (length >> 32));
            }
            length = (length * 61) + s3VarArr[i].hashCode();
            i++;
        }
    }

    @Override // java.lang.Iterable
    public Iterator<s3> iterator() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            if (this.d == null) {
                this.d = new a<>(this.a);
            }
            return this.d.iterator();
        }
        return (Iterator) invokeV.objValue;
    }

    public int size() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.a.length : invokeV.intValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            StringBuilder sb = new StringBuilder();
            sb.append(PreferencesUtil.LEFT_MOUNT);
            for (int i = 0; i < this.a.length; i++) {
                sb.append("(");
                sb.append(this.a[i].f);
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append(this.a[i].a);
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append(this.a[i].b);
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append(this.a[i].e);
                sb.append(SmallTailInfo.EMOTION_SUFFIX);
                sb.append("\n");
            }
            sb.append(PreferencesUtil.RIGHT_MOUNT);
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }
}
