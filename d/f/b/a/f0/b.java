package d.f.b.a.f0;

import android.os.SystemClock;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.Format;
import d.f.b.a.d0.s;
import java.util.Arrays;
import java.util.Comparator;
/* loaded from: classes10.dex */
public abstract class b implements f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final s f73216a;

    /* renamed from: b  reason: collision with root package name */
    public final int f73217b;

    /* renamed from: c  reason: collision with root package name */
    public final int[] f73218c;

    /* renamed from: d  reason: collision with root package name */
    public final Format[] f73219d;

    /* renamed from: e  reason: collision with root package name */
    public final long[] f73220e;

    /* renamed from: f  reason: collision with root package name */
    public int f73221f;

    /* loaded from: classes10.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* renamed from: d.f.b.a.f0.b$b  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public static final class C2019b implements Comparator<Format> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public C2019b() {
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
        public int compare(Format format, Format format2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, format, format2)) == null) ? format2.bitrate - format.bitrate : invokeLL.intValue;
        }

        public /* synthetic */ C2019b(a aVar) {
            this();
        }
    }

    public b(s sVar, int... iArr) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {sVar, iArr};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        int i4 = 0;
        d.f.b.a.i0.a.f(iArr.length > 0);
        d.f.b.a.i0.a.e(sVar);
        this.f73216a = sVar;
        int length = iArr.length;
        this.f73217b = length;
        this.f73219d = new Format[length];
        for (int i5 = 0; i5 < iArr.length; i5++) {
            this.f73219d[i5] = sVar.a(iArr[i5]);
        }
        Arrays.sort(this.f73219d, new C2019b(null));
        this.f73218c = new int[this.f73217b];
        while (true) {
            int i6 = this.f73217b;
            if (i4 < i6) {
                this.f73218c[i4] = sVar.b(this.f73219d[i4]);
                i4++;
            } else {
                this.f73220e = new long[i6];
                return;
            }
        }
    }

    @Override // d.f.b.a.f0.f
    public final int b(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) ? this.f73218c[i2] : invokeI.intValue;
    }

    @Override // d.f.b.a.f0.f
    public final int c(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) {
            for (int i3 = 0; i3 < this.f73217b; i3++) {
                if (this.f73218c[i3] == i2) {
                    return i3;
                }
            }
            return -1;
        }
        return invokeI.intValue;
    }

    @Override // d.f.b.a.f0.f
    public final s d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f73216a : (s) invokeV.objValue;
    }

    @Override // d.f.b.a.f0.f
    public final int e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f73218c[a()] : invokeV.intValue;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, obj)) == null) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            b bVar = (b) obj;
            return this.f73216a == bVar.f73216a && Arrays.equals(this.f73218c, bVar.f73218c);
        }
        return invokeL.booleanValue;
    }

    @Override // d.f.b.a.f0.f
    public final Format f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f73219d[a()] : (Format) invokeV.objValue;
    }

    @Override // d.f.b.a.f0.f
    public final boolean g(int i2, long j) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048582, this, new Object[]{Integer.valueOf(i2), Long.valueOf(j)})) == null) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            boolean m = m(i2, elapsedRealtime);
            int i3 = 0;
            while (i3 < this.f73217b && !m) {
                m = (i3 == i2 || m(i3, elapsedRealtime)) ? false : true;
                i3++;
            }
            if (m) {
                long[] jArr = this.f73220e;
                jArr[i2] = Math.max(jArr[i2], elapsedRealtime + j);
                return true;
            }
            return false;
        }
        return invokeCommon.booleanValue;
    }

    @Override // d.f.b.a.f0.f
    public final Format h(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i2)) == null) ? this.f73219d[i2] : (Format) invokeI.objValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            if (this.f73221f == 0) {
                this.f73221f = (System.identityHashCode(this.f73216a) * 31) + Arrays.hashCode(this.f73218c);
            }
            return this.f73221f;
        }
        return invokeV.intValue;
    }

    @Override // d.f.b.a.f0.f
    public final int k(Format format) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, format)) == null) {
            for (int i2 = 0; i2 < this.f73217b; i2++) {
                if (this.f73219d[i2] == format) {
                    return i2;
                }
            }
            return -1;
        }
        return invokeL.intValue;
    }

    @Override // d.f.b.a.f0.f
    public final int length() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f73218c.length : invokeV.intValue;
    }

    public final boolean m(int i2, long j) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048587, this, new Object[]{Integer.valueOf(i2), Long.valueOf(j)})) == null) ? this.f73220e[i2] > j : invokeCommon.booleanValue;
    }
}
