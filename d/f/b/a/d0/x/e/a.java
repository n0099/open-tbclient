package d.f.b.a.d0.x.e;

import android.net.Uri;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.Format;
import d.f.b.a.i0.u;
import d.f.b.a.i0.v;
import java.util.List;
import java.util.UUID;
/* loaded from: classes8.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final boolean f70556a;

    /* renamed from: b  reason: collision with root package name */
    public final C1981a f70557b;

    /* renamed from: c  reason: collision with root package name */
    public final b[] f70558c;

    /* renamed from: d  reason: collision with root package name */
    public final long f70559d;

    /* renamed from: e  reason: collision with root package name */
    public final long f70560e;

    /* renamed from: d.f.b.a.d0.x.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static class C1981a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final UUID f70561a;

        /* renamed from: b  reason: collision with root package name */
        public final byte[] f70562b;

        public C1981a(UUID uuid, byte[] bArr) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {uuid, bArr};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f70561a = uuid;
            this.f70562b = bArr;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public a(int i2, int i3, long j, long j2, long j3, int i4, boolean z, C1981a c1981a, b[] bVarArr) {
        this(i2, i3, j2 == 0 ? -9223372036854775807L : v.F(j2, 1000000L, j), j3 != 0 ? v.F(j3, 1000000L, j) : -9223372036854775807L, i4, z, c1981a, bVarArr);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r3;
            Object[] objArr = {Integer.valueOf(i2), Integer.valueOf(i3), Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3), Integer.valueOf(i4), Boolean.valueOf(z), c1981a, bVarArr};
            interceptable.invokeUnInit(65537, newInitContext);
            int i5 = newInitContext.flag;
            if ((i5 & 1) != 0) {
                int i6 = i5 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this(((Integer) objArr2[0]).intValue(), ((Integer) objArr2[1]).intValue(), ((Long) objArr2[2]).longValue(), ((Long) objArr2[3]).longValue(), ((Integer) objArr2[4]).intValue(), ((Boolean) objArr2[5]).booleanValue(), (C1981a) objArr2[6], (b[]) objArr2[7]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* loaded from: classes8.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final int f70563a;

        /* renamed from: b  reason: collision with root package name */
        public final long f70564b;

        /* renamed from: c  reason: collision with root package name */
        public final Format[] f70565c;

        /* renamed from: d  reason: collision with root package name */
        public final int f70566d;

        /* renamed from: e  reason: collision with root package name */
        public final String f70567e;

        /* renamed from: f  reason: collision with root package name */
        public final String f70568f;

        /* renamed from: g  reason: collision with root package name */
        public final List<Long> f70569g;

        /* renamed from: h  reason: collision with root package name */
        public final long[] f70570h;

        /* renamed from: i  reason: collision with root package name */
        public final long f70571i;

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public b(String str, String str2, int i2, String str3, long j, String str4, int i3, int i4, int i5, int i6, String str5, Format[] formatArr, List<Long> list, long j2) {
            this(str, str2, i2, str3, j, str4, i3, i4, i5, i6, str5, formatArr, list, v.G(list, 1000000L, j), v.F(j2, 1000000L, j));
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r3;
                Object[] objArr = {str, str2, Integer.valueOf(i2), str3, Long.valueOf(j), str4, Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), str5, formatArr, list, Long.valueOf(j2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i7 = newInitContext.flag;
                if ((i7 & 1) != 0) {
                    int i8 = i7 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    this((String) objArr2[0], (String) objArr2[1], ((Integer) objArr2[2]).intValue(), (String) objArr2[3], ((Long) objArr2[4]).longValue(), (String) objArr2[5], ((Integer) objArr2[6]).intValue(), ((Integer) objArr2[7]).intValue(), ((Integer) objArr2[8]).intValue(), ((Integer) objArr2[9]).intValue(), (String) objArr2[10], (Format[]) objArr2[11], (List) objArr2[12], (long[]) objArr2[13], ((Long) objArr2[14]).longValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        public Uri a(int i2, int i3) {
            InterceptResult invokeII;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeII = interceptable.invokeII(1048576, this, i2, i3)) == null) {
                d.f.b.a.i0.a.f(this.f70565c != null);
                d.f.b.a.i0.a.f(this.f70569g != null);
                d.f.b.a.i0.a.f(i3 < this.f70569g.size());
                String num = Integer.toString(this.f70565c[i2].bitrate);
                String l = this.f70569g.get(i3).toString();
                return u.d(this.f70567e, this.f70568f.replace("{bitrate}", num).replace("{Bitrate}", num).replace("{start time}", l).replace("{start_time}", l));
            }
            return (Uri) invokeII.objValue;
        }

        public long b(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) {
                if (i2 == this.f70566d - 1) {
                    return this.f70571i;
                }
                long[] jArr = this.f70570h;
                return jArr[i2 + 1] - jArr[i2];
            }
            return invokeI.longValue;
        }

        public int c(long j) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeJ = interceptable.invokeJ(Constants.METHOD_SEND_USER_MSG, this, j)) == null) ? v.e(this.f70570h, j, true, true) : invokeJ.intValue;
        }

        public long d(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i2)) == null) ? this.f70570h[i2] : invokeI.longValue;
        }

        public b(String str, String str2, int i2, String str3, long j, String str4, int i3, int i4, int i5, int i6, String str5, Format[] formatArr, List<Long> list, long[] jArr, long j2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, str2, Integer.valueOf(i2), str3, Long.valueOf(j), str4, Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), str5, formatArr, list, jArr, Long.valueOf(j2)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i7 = newInitContext.flag;
                if ((i7 & 1) != 0) {
                    int i8 = i7 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.f70567e = str;
            this.f70568f = str2;
            this.f70563a = i2;
            this.f70564b = j;
            this.f70565c = formatArr;
            this.f70569g = list;
            this.f70570h = jArr;
            this.f70571i = j2;
            this.f70566d = list.size();
        }
    }

    public a(int i2, int i3, long j, long j2, int i4, boolean z, C1981a c1981a, b[] bVarArr) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2), Integer.valueOf(i3), Long.valueOf(j), Long.valueOf(j2), Integer.valueOf(i4), Boolean.valueOf(z), c1981a, bVarArr};
            interceptable.invokeUnInit(65536, newInitContext);
            int i5 = newInitContext.flag;
            if ((i5 & 1) != 0) {
                int i6 = i5 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f70559d = j;
        this.f70560e = j2;
        this.f70556a = z;
        this.f70557b = c1981a;
        this.f70558c = bVarArr;
    }
}
