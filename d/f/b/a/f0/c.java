package d.f.b.a.f0;

import android.graphics.Point;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.Format;
import d.f.b.a.d0.s;
import d.f.b.a.d0.t;
import d.f.b.a.f0.f;
import d.f.b.a.i0.v;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes8.dex */
public class c extends e {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: f  reason: collision with root package name */
    public static final int[] f70325f;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: d  reason: collision with root package name */
    public final f.a f70326d;

    /* renamed from: e  reason: collision with root package name */
    public final AtomicReference<C1989c> f70327e;

    /* loaded from: classes8.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final int f70328a;

        /* renamed from: b  reason: collision with root package name */
        public final int f70329b;

        /* renamed from: c  reason: collision with root package name */
        public final String f70330c;

        public a(int i2, int i3, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2), Integer.valueOf(i3), str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f70328a = i2;
            this.f70329b = i3;
            this.f70330c = str;
        }

        public boolean equals(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, obj)) == null) {
                if (this == obj) {
                    return true;
                }
                if (obj == null || a.class != obj.getClass()) {
                    return false;
                }
                a aVar = (a) obj;
                return this.f70328a == aVar.f70328a && this.f70329b == aVar.f70329b && TextUtils.equals(this.f70330c, aVar.f70330c);
            }
            return invokeL.booleanValue;
        }

        public int hashCode() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                int i2 = ((this.f70328a * 31) + this.f70329b) * 31;
                String str = this.f70330c;
                return i2 + (str != null ? str.hashCode() : 0);
            }
            return invokeV.intValue;
        }
    }

    /* loaded from: classes8.dex */
    public static final class b implements Comparable<b> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final C1989c f70331e;

        /* renamed from: f  reason: collision with root package name */
        public final int f70332f;

        /* renamed from: g  reason: collision with root package name */
        public final int f70333g;

        /* renamed from: h  reason: collision with root package name */
        public final int f70334h;

        /* renamed from: i  reason: collision with root package name */
        public final int f70335i;
        public final int j;
        public final int k;

        public b(Format format, C1989c c1989c, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {format, c1989c, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f70331e = c1989c;
            this.f70332f = c.w(i2, false) ? 1 : 0;
            this.f70333g = c.p(format, c1989c.f70336a) ? 1 : 0;
            this.f70334h = (format.selectionFlags & 1) != 0 ? 1 : 0;
            this.f70335i = format.channelCount;
            this.j = format.sampleRate;
            this.k = format.bitrate;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.lang.Comparable
        /* renamed from: a */
        public int compareTo(b bVar) {
            InterceptResult invokeL;
            int n;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, bVar)) == null) {
                int i2 = this.f70332f;
                int i3 = bVar.f70332f;
                if (i2 != i3) {
                    return c.n(i2, i3);
                }
                int i4 = this.f70333g;
                int i5 = bVar.f70333g;
                if (i4 != i5) {
                    return c.n(i4, i5);
                }
                int i6 = this.f70334h;
                int i7 = bVar.f70334h;
                if (i6 != i7) {
                    return c.n(i6, i7);
                }
                if (this.f70331e.j) {
                    return c.n(bVar.k, this.k);
                }
                int i8 = i2 != 1 ? -1 : 1;
                int i9 = this.f70335i;
                int i10 = bVar.f70335i;
                if (i9 != i10) {
                    n = c.n(i9, i10);
                } else {
                    int i11 = this.j;
                    int i12 = bVar.j;
                    n = i11 != i12 ? c.n(i11, i12) : c.n(this.k, bVar.k);
                }
                return i8 * n;
            }
            return invokeL.intValue;
        }

        public boolean equals(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, obj)) == null) {
                if (this == obj) {
                    return true;
                }
                if (obj == null || b.class != obj.getClass()) {
                    return false;
                }
                b bVar = (b) obj;
                return this.f70332f == bVar.f70332f && this.f70333g == bVar.f70333g && this.f70334h == bVar.f70334h && this.f70335i == bVar.f70335i && this.j == bVar.j && this.k == bVar.k;
            }
            return invokeL.booleanValue;
        }

        public int hashCode() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? (((((((((this.f70332f * 31) + this.f70333g) * 31) + this.f70334h) * 31) + this.f70335i) * 31) + this.j) * 31) + this.k : invokeV.intValue;
        }
    }

    /* renamed from: d.f.b.a.f0.c$c  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static final class C1989c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final String f70336a;

        /* renamed from: b  reason: collision with root package name */
        public final String f70337b;

        /* renamed from: c  reason: collision with root package name */
        public final int f70338c;

        /* renamed from: d  reason: collision with root package name */
        public final int f70339d;

        /* renamed from: e  reason: collision with root package name */
        public final int f70340e;

        /* renamed from: f  reason: collision with root package name */
        public final boolean f70341f;

        /* renamed from: g  reason: collision with root package name */
        public final int f70342g;

        /* renamed from: h  reason: collision with root package name */
        public final int f70343h;

        /* renamed from: i  reason: collision with root package name */
        public final boolean f70344i;
        public final boolean j;
        public final boolean k;
        public final boolean l;
        public final boolean m;

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public C1989c() {
            this(null, null, false, false, true, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, true, true, Integer.MAX_VALUE, Integer.MAX_VALUE, true);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr = newInitContext.callArgs;
                    this((String) objArr[0], (String) objArr[1], ((Boolean) objArr[2]).booleanValue(), ((Boolean) objArr[3]).booleanValue(), ((Boolean) objArr[4]).booleanValue(), ((Integer) objArr[5]).intValue(), ((Integer) objArr[6]).intValue(), ((Integer) objArr[7]).intValue(), ((Boolean) objArr[8]).booleanValue(), ((Boolean) objArr[9]).booleanValue(), ((Integer) objArr[10]).intValue(), ((Integer) objArr[11]).intValue(), ((Boolean) objArr[12]).booleanValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        public boolean equals(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, obj)) == null) {
                if (this == obj) {
                    return true;
                }
                if (obj == null || C1989c.class != obj.getClass()) {
                    return false;
                }
                C1989c c1989c = (C1989c) obj;
                return this.j == c1989c.j && this.k == c1989c.k && this.l == c1989c.l && this.f70338c == c1989c.f70338c && this.f70339d == c1989c.f70339d && this.f70341f == c1989c.f70341f && this.m == c1989c.m && this.f70344i == c1989c.f70344i && this.f70342g == c1989c.f70342g && this.f70343h == c1989c.f70343h && this.f70340e == c1989c.f70340e && TextUtils.equals(this.f70336a, c1989c.f70336a) && TextUtils.equals(this.f70337b, c1989c.f70337b);
            }
            return invokeL.booleanValue;
        }

        public int hashCode() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return (((((((((((((((((((((((this.f70336a.hashCode() * 31) + this.f70337b.hashCode()) * 31) + (this.j ? 1 : 0)) * 31) + (this.k ? 1 : 0)) * 31) + (this.l ? 1 : 0)) * 31) + this.f70338c) * 31) + this.f70339d) * 31) + this.f70340e) * 31) + (this.f70341f ? 1 : 0)) * 31) + (this.m ? 1 : 0)) * 31) + (this.f70344i ? 1 : 0)) * 31) + this.f70342g) * 31) + this.f70343h;
            }
            return invokeV.intValue;
        }

        public C1989c(String str, String str2, boolean z, boolean z2, boolean z3, int i2, int i3, int i4, boolean z4, boolean z5, int i5, int i6, boolean z6) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r3;
                Object[] objArr = {str, str2, Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Boolean.valueOf(z4), Boolean.valueOf(z5), Integer.valueOf(i5), Integer.valueOf(i6), Boolean.valueOf(z6)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i7 = newInitContext.flag;
                if ((i7 & 1) != 0) {
                    int i8 = i7 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.f70336a = str;
            this.f70337b = str2;
            this.j = z;
            this.k = z2;
            this.l = z3;
            this.f70338c = i2;
            this.f70339d = i3;
            this.f70340e = i4;
            this.f70341f = z4;
            this.m = z5;
            this.f70342g = i5;
            this.f70343h = i6;
            this.f70344i = z6;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(82616226, "Ld/f/b/a/f0/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(82616226, "Ld/f/b/a/f0/c;");
                return;
            }
        }
        f70325f = new int[0];
    }

    public c(f.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {aVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f70326d = aVar;
        this.f70327e = new AtomicReference<>(new C1989c());
    }

    /* JADX WARN: Code restructure failed: missing block: B:45:0x0087, code lost:
        if (m(r2.bitrate, r10) < 0) goto L44;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static f B(t tVar, int[][] iArr, C1989c c1989c) {
        InterceptResult invokeLLL;
        int m;
        int i2;
        int i3;
        int i4;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65538, null, tVar, iArr, c1989c)) == null) {
            t tVar2 = tVar;
            int i5 = -1;
            int i6 = 0;
            s sVar = null;
            int i7 = 0;
            int i8 = 0;
            int i9 = -1;
            int i10 = -1;
            while (i6 < tVar2.f69855a) {
                s a2 = tVar2.a(i6);
                List<Integer> v = v(a2, c1989c.f70342g, c1989c.f70343h, c1989c.f70344i);
                int[] iArr2 = iArr[i6];
                int i11 = 0;
                while (i11 < a2.f69851a) {
                    if (w(iArr2[i11], c1989c.m)) {
                        Format a3 = a2.a(i11);
                        boolean z = true;
                        boolean z2 = v.contains(Integer.valueOf(i11)) && ((i2 = a3.width) == i5 || i2 <= c1989c.f70338c) && (((i3 = a3.height) == i5 || i3 <= c1989c.f70339d) && ((i4 = a3.bitrate) == i5 || i4 <= c1989c.f70340e));
                        if (z2 || c1989c.f70341f) {
                            int i12 = z2 ? 2 : 1;
                            boolean w = w(iArr2[i11], false);
                            if (w) {
                                i12 += 1000;
                            }
                            boolean z3 = i12 > i8;
                            if (i12 == i8) {
                                if (!c1989c.j) {
                                    int pixelCount = a3.getPixelCount();
                                    if (pixelCount != i9) {
                                        m = m(pixelCount, i9);
                                    } else {
                                        m = m(a3.bitrate, i10);
                                    }
                                    if (w) {
                                    }
                                    z = false;
                                    z3 = z;
                                }
                            }
                            if (z3) {
                                i10 = a3.bitrate;
                                i9 = a3.getPixelCount();
                                sVar = a2;
                                i7 = i11;
                                i8 = i12;
                            }
                        }
                    }
                    i11++;
                    i5 = -1;
                }
                i6++;
                tVar2 = tVar;
                i5 = -1;
            }
            if (sVar == null) {
                return null;
            }
            return new d(sVar, i7);
        }
        return (f) invokeLLL.objValue;
    }

    public static int m(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(InputDeviceCompat.SOURCE_TRACKBALL, null, i2, i3)) == null) {
            if (i2 == -1) {
                return i3 == -1 ? 0 : -1;
            } else if (i3 == -1) {
                return 1;
            } else {
                return i2 - i3;
            }
        }
        return invokeII.intValue;
    }

    public static int n(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(AdIconUtil.AD_TEXT_ID, null, i2, i3)) == null) {
            if (i2 > i3) {
                return 1;
            }
            return i3 > i2 ? -1 : 0;
        }
        return invokeII.intValue;
    }

    public static void o(s sVar, int[] iArr, int i2, String str, int i3, int i4, int i5, List<Integer> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(AdIconUtil.BAIDU_LOGO_ID, null, new Object[]{sVar, iArr, Integer.valueOf(i2), str, Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), list}) == null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                int intValue = list.get(size).intValue();
                if (!y(sVar.a(intValue), str, iArr[intValue], i2, i3, i4, i5)) {
                    list.remove(size);
                }
            }
        }
    }

    public static boolean p(Format format, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, format, str)) == null) ? str != null && TextUtils.equals(str, v.C(format.language)) : invokeLL.booleanValue;
    }

    public static int q(s sVar, int[] iArr, a aVar) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65544, null, sVar, iArr, aVar)) == null) {
            int i2 = 0;
            for (int i3 = 0; i3 < sVar.f69851a; i3++) {
                if (x(sVar.a(i3), iArr[i3], aVar)) {
                    i2++;
                }
            }
            return i2;
        }
        return invokeLLL.intValue;
    }

    public static int[] r(s sVar, int[] iArr, boolean z) {
        InterceptResult invokeLLZ;
        int q;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(65545, null, sVar, iArr, z)) == null) {
            HashSet hashSet = new HashSet();
            a aVar = null;
            int i2 = 0;
            for (int i3 = 0; i3 < sVar.f69851a; i3++) {
                Format a2 = sVar.a(i3);
                a aVar2 = new a(a2.channelCount, a2.sampleRate, z ? null : a2.sampleMimeType);
                if (hashSet.add(aVar2) && (q = q(sVar, iArr, aVar2)) > i2) {
                    i2 = q;
                    aVar = aVar2;
                }
            }
            if (i2 > 1) {
                int[] iArr2 = new int[i2];
                int i4 = 0;
                for (int i5 = 0; i5 < sVar.f69851a; i5++) {
                    if (x(sVar.a(i5), iArr[i5], aVar)) {
                        iArr2[i4] = i5;
                        i4++;
                    }
                }
                return iArr2;
            }
            return f70325f;
        }
        return (int[]) invokeLLZ.objValue;
    }

    public static int s(s sVar, int[] iArr, int i2, String str, int i3, int i4, int i5, List<Integer> list) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65546, null, new Object[]{sVar, iArr, Integer.valueOf(i2), str, Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), list})) == null) {
            int i6 = 0;
            for (int i7 = 0; i7 < list.size(); i7++) {
                int intValue = list.get(i7).intValue();
                if (y(sVar.a(intValue), str, iArr[intValue], i2, i3, i4, i5)) {
                    i6++;
                }
            }
            return i6;
        }
        return invokeCommon.intValue;
    }

    public static int[] t(s sVar, int[] iArr, boolean z, int i2, int i3, int i4, int i5, int i6, int i7, boolean z2) {
        InterceptResult invokeCommon;
        String str;
        int s;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65547, null, new Object[]{sVar, iArr, Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7), Boolean.valueOf(z2)})) == null) {
            if (sVar.f69851a < 2) {
                return f70325f;
            }
            List<Integer> v = v(sVar, i6, i7, z2);
            if (v.size() < 2) {
                return f70325f;
            }
            if (z) {
                str = null;
            } else {
                HashSet hashSet = new HashSet();
                String str2 = null;
                int i8 = 0;
                for (int i9 = 0; i9 < v.size(); i9++) {
                    String str3 = sVar.a(v.get(i9).intValue()).sampleMimeType;
                    if (hashSet.add(str3) && (s = s(sVar, iArr, i2, str3, i3, i4, i5, v)) > i8) {
                        i8 = s;
                        str2 = str3;
                    }
                }
                str = str2;
            }
            o(sVar, iArr, i2, str, i3, i4, i5, v);
            return v.size() < 2 ? f70325f : v.I(v);
        }
        return (int[]) invokeCommon.objValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0011, code lost:
        if ((r7 > r8) != (r5 > r6)) goto L10;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Point u(boolean z, int i2, int i3, int i4, int i5) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65548, null, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)})) == null) {
            if (z) {
            }
            i3 = i2;
            i2 = i3;
            int i6 = i4 * i2;
            int i7 = i5 * i3;
            if (i6 >= i7) {
                return new Point(i3, v.f(i7, i4));
            }
            return new Point(v.f(i6, i5), i2);
        }
        return (Point) invokeCommon.objValue;
    }

    public static List<Integer> v(s sVar, int i2, int i3, boolean z) {
        InterceptResult invokeCommon;
        int i4;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65549, null, new Object[]{sVar, Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z)})) == null) {
            ArrayList arrayList = new ArrayList(sVar.f69851a);
            for (int i5 = 0; i5 < sVar.f69851a; i5++) {
                arrayList.add(Integer.valueOf(i5));
            }
            if (i2 != Integer.MAX_VALUE && i3 != Integer.MAX_VALUE) {
                int i6 = Integer.MAX_VALUE;
                for (int i7 = 0; i7 < sVar.f69851a; i7++) {
                    Format a2 = sVar.a(i7);
                    int i8 = a2.width;
                    if (i8 > 0 && (i4 = a2.height) > 0) {
                        Point u = u(z, i2, i3, i8, i4);
                        int i9 = a2.width;
                        int i10 = a2.height;
                        int i11 = i9 * i10;
                        if (i9 >= ((int) (u.x * 0.98f)) && i10 >= ((int) (u.y * 0.98f)) && i11 < i6) {
                            i6 = i11;
                        }
                    }
                }
                if (i6 != Integer.MAX_VALUE) {
                    for (int size = arrayList.size() - 1; size >= 0; size--) {
                        int pixelCount = sVar.a(((Integer) arrayList.get(size)).intValue()).getPixelCount();
                        if (pixelCount == -1 || pixelCount > i6) {
                            arrayList.remove(size);
                        }
                    }
                }
            }
            return arrayList;
        }
        return (List) invokeCommon.objValue;
    }

    public static boolean w(int i2, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65550, null, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)})) == null) {
            int i3 = i2 & 7;
            return i3 == 4 || (z && i3 == 3);
        }
        return invokeCommon.booleanValue;
    }

    public static boolean x(Format format, int i2, a aVar) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(65551, null, format, i2, aVar)) == null) {
            if (w(i2, false) && format.channelCount == aVar.f70328a && format.sampleRate == aVar.f70329b) {
                String str = aVar.f70330c;
                return str == null || TextUtils.equals(str, format.sampleMimeType);
            }
            return false;
        }
        return invokeLIL.booleanValue;
    }

    public static boolean y(Format format, String str, int i2, int i3, int i4, int i5, int i6) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65552, null, new Object[]{format, str, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6)})) == null) {
            if (!w(i2, false) || (i2 & i3) == 0) {
                return false;
            }
            if (str == null || v.a(format.sampleMimeType, str)) {
                int i7 = format.width;
                if (i7 == -1 || i7 <= i4) {
                    int i8 = format.height;
                    if (i8 == -1 || i8 <= i5) {
                        int i9 = format.bitrate;
                        return i9 == -1 || i9 <= i6;
                    }
                    return false;
                }
                return false;
            }
            return false;
        }
        return invokeCommon.booleanValue;
    }

    public static f z(d.f.b.a.s sVar, t tVar, int[][] iArr, C1989c c1989c, f.a aVar) throws ExoPlaybackException {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(65553, null, sVar, tVar, iArr, c1989c, aVar)) == null) {
            int i2 = c1989c.l ? 24 : 16;
            boolean z = c1989c.k && (sVar.r() & i2) != 0;
            for (int i3 = 0; i3 < tVar.f69855a; i3++) {
                s a2 = tVar.a(i3);
                int[] t = t(a2, iArr[i3], z, i2, c1989c.f70338c, c1989c.f70339d, c1989c.f70340e, c1989c.f70342g, c1989c.f70343h, c1989c.f70344i);
                if (t.length > 0) {
                    return aVar.a(a2, t);
                }
            }
            return null;
        }
        return (f) invokeLLLLL.objValue;
    }

    public f A(t tVar, int[][] iArr, C1989c c1989c, f.a aVar) throws ExoPlaybackException {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, tVar, iArr, c1989c, aVar)) == null) {
            b bVar = null;
            int i2 = -1;
            int i3 = -1;
            for (int i4 = 0; i4 < tVar.f69855a; i4++) {
                s a2 = tVar.a(i4);
                int[] iArr2 = iArr[i4];
                for (int i5 = 0; i5 < a2.f69851a; i5++) {
                    if (w(iArr2[i5], c1989c.m)) {
                        b bVar2 = new b(a2.a(i5), c1989c, iArr2[i5]);
                        if (bVar == null || bVar2.compareTo(bVar) > 0) {
                            i2 = i4;
                            i3 = i5;
                            bVar = bVar2;
                        }
                    }
                }
            }
            if (i2 == -1) {
                return null;
            }
            s a3 = tVar.a(i2);
            if (!c1989c.j && aVar != null) {
                int[] r = r(a3, iArr[i2], c1989c.k);
                if (r.length > 0) {
                    return aVar.a(a3, r);
                }
            }
            return new d(a3, i3);
        }
        return (f) invokeLLLL.objValue;
    }

    public f C(int i2, t tVar, int[][] iArr, C1989c c1989c) throws ExoPlaybackException {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i2), tVar, iArr, c1989c})) == null) {
            s sVar = null;
            int i3 = 0;
            int i4 = 0;
            for (int i5 = 0; i5 < tVar.f69855a; i5++) {
                s a2 = tVar.a(i5);
                int[] iArr2 = iArr[i5];
                for (int i6 = 0; i6 < a2.f69851a; i6++) {
                    if (w(iArr2[i6], c1989c.m)) {
                        int i7 = (a2.a(i6).selectionFlags & 1) != 0 ? 2 : 1;
                        if (w(iArr2[i6], false)) {
                            i7 += 1000;
                        }
                        if (i7 > i4) {
                            sVar = a2;
                            i3 = i6;
                            i4 = i7;
                        }
                    }
                }
            }
            if (sVar == null) {
                return null;
            }
            return new d(sVar, i3);
        }
        return (f) invokeCommon.objValue;
    }

    public f D(t tVar, int[][] iArr, C1989c c1989c) throws ExoPlaybackException {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, tVar, iArr, c1989c)) == null) {
            s sVar = null;
            int i2 = 0;
            int i3 = 0;
            for (int i4 = 0; i4 < tVar.f69855a; i4++) {
                s a2 = tVar.a(i4);
                int[] iArr2 = iArr[i4];
                for (int i5 = 0; i5 < a2.f69851a; i5++) {
                    if (w(iArr2[i5], c1989c.m)) {
                        Format a3 = a2.a(i5);
                        int i6 = 1;
                        boolean z = (a3.selectionFlags & 1) != 0;
                        boolean z2 = (a3.selectionFlags & 2) != 0;
                        if (p(a3, c1989c.f70337b)) {
                            i6 = z ? 6 : !z2 ? 5 : 4;
                        } else if (z) {
                            i6 = 3;
                        } else if (z2) {
                            if (p(a3, c1989c.f70336a)) {
                                i6 = 2;
                            }
                        }
                        if (w(iArr2[i5], false)) {
                            i6 += 1000;
                        }
                        if (i6 > i3) {
                            sVar = a2;
                            i2 = i5;
                            i3 = i6;
                        }
                    }
                }
            }
            if (sVar == null) {
                return null;
            }
            return new d(sVar, i2);
        }
        return (f) invokeLLL.objValue;
    }

    public f E(d.f.b.a.s sVar, t tVar, int[][] iArr, C1989c c1989c, f.a aVar) throws ExoPlaybackException {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(1048579, this, sVar, tVar, iArr, c1989c, aVar)) == null) {
            f z = (c1989c.j || aVar == null) ? null : z(sVar, tVar, iArr, c1989c, aVar);
            return z == null ? B(tVar, iArr, c1989c) : z;
        }
        return (f) invokeLLLLL.objValue;
    }

    @Override // d.f.b.a.f0.e
    public f[] k(d.f.b.a.s[] sVarArr, t[] tVarArr, int[][][] iArr) throws ExoPlaybackException {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048580, this, sVarArr, tVarArr, iArr)) == null) {
            int length = sVarArr.length;
            f[] fVarArr = new f[length];
            C1989c c1989c = this.f70327e.get();
            boolean z = false;
            int i2 = 0;
            boolean z2 = false;
            while (true) {
                if (i2 >= length) {
                    break;
                }
                if (2 == sVarArr[i2].e()) {
                    if (!z) {
                        fVarArr[i2] = E(sVarArr[i2], tVarArr[i2], iArr[i2], c1989c, this.f70326d);
                        z = fVarArr[i2] != null;
                    }
                    z2 |= tVarArr[i2].f69855a > 0;
                }
                i2++;
            }
            boolean z3 = false;
            boolean z4 = false;
            for (int i3 = 0; i3 < length; i3++) {
                int e2 = sVarArr[i3].e();
                if (e2 != 1) {
                    if (e2 != 2) {
                        if (e2 != 3) {
                            fVarArr[i3] = C(sVarArr[i3].e(), tVarArr[i3], iArr[i3], c1989c);
                        } else if (!z4) {
                            fVarArr[i3] = D(tVarArr[i3], iArr[i3], c1989c);
                            z4 = fVarArr[i3] != null;
                        }
                    }
                } else if (!z3) {
                    fVarArr[i3] = A(tVarArr[i3], iArr[i3], c1989c, z2 ? null : this.f70326d);
                    z3 = fVarArr[i3] != null;
                }
            }
            return fVarArr;
        }
        return (f[]) invokeLLL.objValue;
    }
}
