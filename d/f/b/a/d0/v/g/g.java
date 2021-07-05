package d.f.b.a.d0.v.g;

import android.net.Uri;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.Format;
import d.f.b.a.d0.v.g.h;
import java.util.Collections;
import java.util.List;
/* loaded from: classes10.dex */
public abstract class g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final Format f72871a;

    /* renamed from: b  reason: collision with root package name */
    public final String f72872b;

    /* renamed from: c  reason: collision with root package name */
    public final long f72873c;

    /* renamed from: d  reason: collision with root package name */
    public final List<d> f72874d;

    /* renamed from: e  reason: collision with root package name */
    public final f f72875e;

    /* loaded from: classes10.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes10.dex */
    public static class b extends g implements d.f.b.a.d0.v.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: f  reason: collision with root package name */
        public final h.a f72876f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(String str, long j, Format format, String str2, h.a aVar, List<d> list) {
            super(str, j, format, str2, aVar, list, null);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Long.valueOf(j), format, str2, aVar, list};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((String) objArr2[0], ((Long) objArr2[1]).longValue(), (Format) objArr2[2], (String) objArr2[3], (h) objArr2[4], (List) objArr2[5], (a) objArr2[6]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f72876f = aVar;
        }

        @Override // d.f.b.a.d0.v.d
        public long a(int i2, long j) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), Long.valueOf(j)})) == null) ? this.f72876f.e(i2, j) : invokeCommon.longValue;
        }

        @Override // d.f.b.a.d0.v.d
        public int b(long j, long j2) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Long.valueOf(j), Long.valueOf(j2)})) == null) ? this.f72876f.f(j, j2) : invokeCommon.intValue;
        }

        @Override // d.f.b.a.d0.v.d
        public int c(long j) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeJ = interceptable.invokeJ(Constants.METHOD_SEND_USER_MSG, this, j)) == null) ? this.f72876f.d(j) : invokeJ.intValue;
        }

        @Override // d.f.b.a.d0.v.d
        public int d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f72876f.c() : invokeV.intValue;
        }

        @Override // d.f.b.a.d0.v.d
        public f e(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i2)) == null) ? this.f72876f.h(this, i2) : (f) invokeI.objValue;
        }

        @Override // d.f.b.a.d0.v.d
        public long f(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i2)) == null) ? this.f72876f.g(i2) : invokeI.longValue;
        }

        @Override // d.f.b.a.d0.v.d
        public boolean g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f72876f.i() : invokeV.booleanValue;
        }

        @Override // d.f.b.a.d0.v.g.g
        public String h() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
                return null;
            }
            return (String) invokeV.objValue;
        }

        @Override // d.f.b.a.d0.v.g.g
        public d.f.b.a.d0.v.d i() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this : (d.f.b.a.d0.v.d) invokeV.objValue;
        }

        @Override // d.f.b.a.d0.v.g.g
        public f j() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
                return null;
            }
            return (f) invokeV.objValue;
        }
    }

    /* loaded from: classes10.dex */
    public static class c extends g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: f  reason: collision with root package name */
        public final String f72877f;

        /* renamed from: g  reason: collision with root package name */
        public final f f72878g;

        /* renamed from: h  reason: collision with root package name */
        public final i f72879h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(String str, long j, Format format, String str2, h.e eVar, List<d> list, String str3, long j2) {
            super(str, j, format, str2, eVar, list, null);
            String str4;
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r4;
                Object[] objArr = {str, Long.valueOf(j), format, str2, eVar, list, str3, Long.valueOf(j2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((String) objArr2[0], ((Long) objArr2[1]).longValue(), (Format) objArr2[2], (String) objArr2[3], (h) objArr2[4], (List) objArr2[5], (a) objArr2[6]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            Uri.parse(str2);
            this.f72878g = eVar.c();
            if (str3 != null) {
                str4 = str3;
            } else if (str != null) {
                str4 = str + "." + format.id + "." + j;
            } else {
                str4 = null;
            }
            this.f72877f = str4;
            this.f72879h = this.f72878g == null ? new i(new f(null, 0L, j2)) : null;
        }

        @Override // d.f.b.a.d0.v.g.g
        public String h() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f72877f : (String) invokeV.objValue;
        }

        @Override // d.f.b.a.d0.v.g.g
        public d.f.b.a.d0.v.d i() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f72879h : (d.f.b.a.d0.v.d) invokeV.objValue;
        }

        @Override // d.f.b.a.d0.v.g.g
        public f j() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f72878g : (f) invokeV.objValue;
        }
    }

    public /* synthetic */ g(String str, long j, Format format, String str2, h hVar, List list, a aVar) {
        this(str, j, format, str2, hVar, list);
    }

    public static g l(String str, long j, Format format, String str2, h hVar, List<d> list) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, null, new Object[]{str, Long.valueOf(j), format, str2, hVar, list})) == null) ? m(str, j, format, str2, hVar, list, null) : (g) invokeCommon.objValue;
    }

    public static g m(String str, long j, Format format, String str2, h hVar, List<d> list, String str3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65539, null, new Object[]{str, Long.valueOf(j), format, str2, hVar, list, str3})) == null) {
            if (hVar instanceof h.e) {
                return new c(str, j, format, str2, (h.e) hVar, list, str3, -1L);
            }
            if (hVar instanceof h.a) {
                return new b(str, j, format, str2, (h.a) hVar, list);
            }
            throw new IllegalArgumentException("segmentBase must be of type SingleSegmentBase or MultiSegmentBase");
        }
        return (g) invokeCommon.objValue;
    }

    public abstract String h();

    public abstract d.f.b.a.d0.v.d i();

    public abstract f j();

    public f k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f72875e : (f) invokeV.objValue;
    }

    public g(String str, long j, Format format, String str2, h hVar, List<d> list) {
        List<d> unmodifiableList;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Long.valueOf(j), format, str2, hVar, list};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f72871a = format;
        this.f72872b = str2;
        if (list == null) {
            unmodifiableList = Collections.emptyList();
        } else {
            unmodifiableList = Collections.unmodifiableList(list);
        }
        this.f72874d = unmodifiableList;
        this.f72875e = hVar.a(this);
        this.f72873c = hVar.b();
    }
}
