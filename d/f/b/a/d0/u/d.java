package d.f.b.a.d0.u;

import android.util.SparseArray;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.Format;
import d.f.b.a.a0.m;
import java.io.IOException;
/* loaded from: classes8.dex */
public final class d implements d.f.b.a.a0.g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final d.f.b.a.a0.e f69868e;

    /* renamed from: f  reason: collision with root package name */
    public final int f69869f;

    /* renamed from: g  reason: collision with root package name */
    public final Format f69870g;

    /* renamed from: h  reason: collision with root package name */
    public final SparseArray<a> f69871h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f69872i;
    public b j;
    public d.f.b.a.a0.l k;
    public Format[] l;

    /* loaded from: classes8.dex */
    public static final class a implements d.f.b.a.a0.m {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final int f69873a;

        /* renamed from: b  reason: collision with root package name */
        public final int f69874b;

        /* renamed from: c  reason: collision with root package name */
        public final Format f69875c;

        /* renamed from: d  reason: collision with root package name */
        public Format f69876d;

        /* renamed from: e  reason: collision with root package name */
        public d.f.b.a.a0.m f69877e;

        public a(int i2, int i3, Format format) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2), Integer.valueOf(i3), format};
                interceptable.invokeUnInit(65536, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f69873a = i2;
            this.f69874b = i3;
            this.f69875c = format;
        }

        @Override // d.f.b.a.a0.m
        public void a(d.f.b.a.i0.l lVar, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, lVar, i2) == null) {
                this.f69877e.a(lVar, i2);
            }
        }

        @Override // d.f.b.a.a0.m
        public void b(Format format) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, format) == null) {
                Format format2 = this.f69875c;
                if (format2 != null) {
                    format = format.copyWithManifestFormatInfo(format2);
                }
                this.f69876d = format;
                this.f69877e.b(format);
            }
        }

        @Override // d.f.b.a.a0.m
        public void c(long j, int i2, int i3, int i4, m.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Long.valueOf(j), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), aVar}) == null) {
                this.f69877e.c(j, i2, i3, i4, aVar);
            }
        }

        @Override // d.f.b.a.a0.m
        public int d(d.f.b.a.a0.f fVar, int i2, boolean z) throws IOException, InterruptedException {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{fVar, Integer.valueOf(i2), Boolean.valueOf(z)})) == null) ? this.f69877e.d(fVar, i2, z) : invokeCommon.intValue;
        }

        public void e(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, bVar) == null) {
                if (bVar == null) {
                    this.f69877e = new d.f.b.a.a0.d();
                    return;
                }
                d.f.b.a.a0.m a2 = bVar.a(this.f69873a, this.f69874b);
                this.f69877e = a2;
                Format format = this.f69876d;
                if (format != null) {
                    a2.b(format);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public interface b {
        d.f.b.a.a0.m a(int i2, int i3);
    }

    public d(d.f.b.a.a0.e eVar, int i2, Format format) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {eVar, Integer.valueOf(i2), format};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f69868e = eVar;
        this.f69869f = i2;
        this.f69870g = format;
        this.f69871h = new SparseArray<>();
    }

    @Override // d.f.b.a.a0.g
    public d.f.b.a.a0.m a(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048576, this, i2, i3)) == null) {
            a aVar = this.f69871h.get(i2);
            if (aVar == null) {
                d.f.b.a.i0.a.f(this.l == null);
                aVar = new a(i2, i3, i3 == this.f69869f ? this.f69870g : null);
                aVar.e(this.j);
                this.f69871h.put(i2, aVar);
            }
            return aVar;
        }
        return (d.f.b.a.a0.m) invokeII.objValue;
    }

    public Format[] b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.l : (Format[]) invokeV.objValue;
    }

    public d.f.b.a.a0.l c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.k : (d.f.b.a.a0.l) invokeV.objValue;
    }

    public void d(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bVar) == null) {
            this.j = bVar;
            if (!this.f69872i) {
                this.f69868e.f(this);
                this.f69872i = true;
                return;
            }
            this.f69868e.a(0L, 0L);
            for (int i2 = 0; i2 < this.f69871h.size(); i2++) {
                this.f69871h.valueAt(i2).e(bVar);
            }
        }
    }

    @Override // d.f.b.a.a0.g
    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            Format[] formatArr = new Format[this.f69871h.size()];
            for (int i2 = 0; i2 < this.f69871h.size(); i2++) {
                formatArr[i2] = this.f69871h.valueAt(i2).f69876d;
            }
            this.l = formatArr;
        }
    }

    @Override // d.f.b.a.a0.g
    public void p(d.f.b.a.a0.l lVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, lVar) == null) {
            this.k = lVar;
        }
    }
}
