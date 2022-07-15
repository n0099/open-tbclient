package com.repackage;

import android.content.ContentResolver;
import android.content.Context;
import android.content.UriMatcher;
import android.content.UriPermission;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.net.Uri;
import android.net.http.Headers;
import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.helios.channels.upc.d;
import com.baidu.searchbox.crius.constants.NativeConstants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.d40;
import com.repackage.x10;
import java.io.ByteArrayOutputStream;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class e20 extends x10 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context f;
    public k g;
    public d40.a h;
    public j i;

    /* loaded from: classes5.dex */
    public static final class a extends b<a> {
        public static /* synthetic */ Interceptable $ic;
        public static final String[] b;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-464399663, "Lcom/repackage/e20$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-464399663, "Lcom/repackage/e20$a;");
                    return;
                }
            }
            b = new String[]{"read0", "read1", "read2", "read3", "access0", "access1", "access2", "access3", "sync0", "sync1", "sync2", "sync3", "open0", "open1", "open2", "open3"};
            b.b(4);
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(int i) {
            super(i, 4);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Integer) objArr2[0]).intValue(), ((Integer) objArr2[1]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
        }

        public static a d(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(65538, null, i)) == null) ? new a(i) : (a) invokeI.objValue;
        }

        public String e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? b[a()] : (String) invokeV.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public static abstract class b<T extends b> implements Comparable<T> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;

        public b(int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i), Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            int b = b(i2);
            if (i >= 0 && i <= b) {
                this.a = i;
                return;
            }
            throw new IllegalArgumentException("invalid index " + i);
        }

        public static int b(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(65537, null, i)) == null) ? (1 << i) - 1 : invokeI.intValue;
        }

        public int a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.a : invokeV.intValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.lang.Comparable
        /* renamed from: c */
        public int compareTo(T t) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, t)) == null) ? this.a - t.a() : invokeL.intValue;
        }

        public boolean equals(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, obj)) == null) {
                if (this == obj) {
                    return true;
                }
                return obj != null && getClass() == obj.getClass() && this.a == ((b) obj).a;
            }
            return invokeL.booleanValue;
        }

        public int hashCode() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.a : invokeV.intValue;
        }
    }

    /* loaded from: classes5.dex */
    public static class c<T extends b> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public List<C0617c<T>> a;

        /* loaded from: classes5.dex */
        public class a implements Comparator<C0617c<T>> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public a(c cVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // java.util.Comparator
            /* renamed from: a */
            public int compare(C0617c<T> c0617c, C0617c<T> c0617c2) {
                InterceptResult invokeLL;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, c0617c, c0617c2)) == null) ? c0617c.a - c0617c2.a : invokeLL.intValue;
            }
        }

        /* loaded from: classes5.dex */
        public class b implements Comparator<C0617c<T>> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public b(c cVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // java.util.Comparator
            /* renamed from: a */
            public int compare(C0617c<T> c0617c, C0617c<T> c0617c2) {
                InterceptResult invokeLL;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, c0617c, c0617c2)) == null) ? c0617c2.a - c0617c.a : invokeLL.intValue;
            }
        }

        /* renamed from: com.repackage.e20$c$c  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public static class C0617c<T> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public int a;
            public T b;

            public C0617c(T t) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {t};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.b = t;
            }

            public T a() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.b : (T) invokeV.objValue;
            }

            public void c() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                    this.a++;
                }
            }
        }

        public c() {
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
            this.a = new ArrayList();
        }

        public C0617c a(T t) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, t)) == null) {
                C0617c<T> c0617c = new C0617c<>(t);
                this.a.add(c0617c);
                return c0617c;
            }
            return (C0617c) invokeL.objValue;
        }

        public List<C0617c<T>> b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                ArrayList arrayList = new ArrayList(this.a);
                Collections.sort(arrayList, new a(this));
                return arrayList;
            }
            return (List) invokeV.objValue;
        }

        public List<C0617c<T>> c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                ArrayList arrayList = new ArrayList(this.a);
                Collections.sort(arrayList, new b(this));
                return arrayList;
            }
            return (List) invokeV.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public static final class d extends b<d> {
        public static /* synthetic */ Interceptable $ic;
        public static final int b;
        public static final String[] c;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-464399570, "Lcom/repackage/e20$d;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-464399570, "Lcom/repackage/e20$d;");
                    return;
                }
            }
            int b2 = b.b(6);
            b = b2;
            c = new String[b2 + 1];
            String[] strArr = {"read", "access", NativeConstants.COMPONENT_SYNC_TEXT_VIEW, "open", Headers.REFRESH, "check", "close", "release"};
            for (int i = 0; i <= b; i++) {
                String str = strArr[i / 8];
                String valueOf = String.valueOf(i % 8);
                String[] strArr2 = c;
                strArr2[i] = str + valueOf;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(int i) {
            super(i, 6);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Integer) objArr2[0]).intValue(), ((Integer) objArr2[1]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
        }

        public static d d(byte b2) {
            InterceptResult invokeB;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeB = interceptable.invokeB(65538, null, b2)) == null) ? f(b2 & 255) : (d) invokeB.objValue;
        }

        public static d e(g gVar, a aVar) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, gVar, aVar)) == null) ? f((gVar.a() << 4) | aVar.a()) : (d) invokeLL.objValue;
        }

        public static d f(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TRACKBALL, null, i)) == null) ? new d(i) : (d) invokeI.objValue;
        }

        public String g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? c[a()] : (String) invokeV.objValue;
        }

        public a h() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? a.d(a() & 15) : (a) invokeV.objValue;
        }

        public byte i() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? (byte) a() : invokeV.byteValue;
        }
    }

    /* loaded from: classes5.dex */
    public static class e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public d[] a;
        public int b;

        public e() {
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
            this.a = new d[27];
        }

        public static e b(byte[] bArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, bArr)) == null) {
                e eVar = new e();
                for (byte b : f20.d(bArr)) {
                    eVar.d(d.d(b));
                }
                return eVar;
            }
            return (e) invokeL.objValue;
        }

        public int a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.b : invokeV.intValue;
        }

        public final void c(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
                d[] dVarArr = this.a;
                if (i - dVarArr.length > 0) {
                    int length = dVarArr.length;
                    int i2 = length + (length >> 1);
                    if (i2 - i >= 0) {
                        i = i2;
                    }
                    this.a = (d[]) Arrays.copyOf(this.a, i);
                }
            }
        }

        public void d(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, dVar) == null) {
                c(this.b + 1);
                d[] dVarArr = this.a;
                int i = this.b;
                this.b = i + 1;
                dVarArr[i] = dVar;
            }
        }

        public d e(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i)) == null) {
                if (i < this.b) {
                    return this.a[i];
                }
                throw new IndexOutOfBoundsException("idx " + i + " size " + this.b);
            }
            return (d) invokeI.objValue;
        }

        public byte[] f() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                for (int i = 0; i < this.b; i++) {
                    byteArrayOutputStream.write(this.a[i].i());
                }
                return f20.b(byteArrayOutputStream.toByteArray());
            }
            return (byte[]) invokeV.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public static class f<T extends b> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;
        public Map<T, Integer> b;

        /* loaded from: classes5.dex */
        public class a implements Comparator<Map.Entry<T, Integer>> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public a(f fVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {fVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // java.util.Comparator
            /* renamed from: a */
            public int compare(Map.Entry<T, Integer> entry, Map.Entry<T, Integer> entry2) {
                InterceptResult invokeLL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, entry, entry2)) == null) {
                    int intValue = entry2.getValue().intValue() - entry.getValue().intValue();
                    return intValue != 0 ? intValue : entry.getKey().compareTo(entry2.getKey());
                }
                return invokeLL.intValue;
            }
        }

        public f(int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = new HashMap();
            this.a = i;
        }

        public List<T> a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                ArrayList arrayList = new ArrayList(this.b.entrySet());
                Collections.sort(arrayList, new a(this));
                ArrayList arrayList2 = new ArrayList(this.a);
                int min = Math.min(this.a, arrayList.size());
                for (int i = 0; i < min; i++) {
                    Map.Entry entry = (Map.Entry) arrayList.get(i);
                    if (((Integer) entry.getValue()).intValue() > 1) {
                        arrayList2.add(entry.getKey());
                    }
                }
                return arrayList2;
            }
            return (List) invokeV.objValue;
        }

        public void b(T t) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, t) == null) {
                Integer num = this.b.get(t);
                this.b.put(t, num == null ? 1 : Integer.valueOf(num.intValue() + 1));
            }
        }
    }

    /* loaded from: classes5.dex */
    public static final class g extends b<g> {
        public static /* synthetic */ Interceptable $ic;
        public static final int b;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-464399477, "Lcom/repackage/e20$g;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-464399477, "Lcom/repackage/e20$g;");
                    return;
                }
            }
            b = b.b(2);
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(int i) {
            super(i, 2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Integer) objArr2[0]).intValue(), ((Integer) objArr2[1]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
        }

        public static g d(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(65538, null, i)) == null) ? new g(i) : (g) invokeI.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public static class h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public h() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class i {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;
        public int b;

        public i() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "" : (String) invokeV.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public class j {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;
        public long b;
        public a40 c;
        public long d;
        public String e;
        public boolean f;
        public final /* synthetic */ e20 g;

        public j(e20 e20Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {e20Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.g = e20Var;
            this.c = new a40();
            this.f = true;
        }

        public long a(long j) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeJ = interceptable.invokeJ(1048576, this, j)) == null) ? this.c.a(j) : invokeJ.longValue;
        }

        public String b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.e : (String) invokeV.objValue;
        }

        public boolean c(long j, long j2) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Long.valueOf(j), Long.valueOf(j2)})) == null) {
                if (this.c.c(j, j2)) {
                    this.f = true;
                    return true;
                }
                return false;
            }
            return invokeCommon.booleanValue;
        }

        public boolean d(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
                String str2 = this.e;
                if (str2 == str) {
                    return false;
                }
                if (str == null || !str.equals(str2)) {
                    this.f = true;
                    this.e = str;
                    return true;
                }
                return false;
            }
            return invokeL.booleanValue;
        }

        public void e(long j) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeJ(1048580, this, j) == null) || this.b == j) {
                return;
            }
            this.b = j;
            this.f = true;
        }

        public long f() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.d : invokeV.longValue;
        }

        public boolean g(long j) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(1048582, this, j)) == null) {
                if (this.d != j) {
                    this.d = j;
                    this.f = true;
                    return true;
                }
                return false;
            }
            return invokeJ.booleanValue;
        }

        public boolean h() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
                if (this.f) {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("pub_ver", this.a);
                        jSONObject.put("pub_lst_ts", this.b);
                        jSONObject.put("pkg_lst_up_ts", this.d);
                        jSONObject.put("flags", this.c.d());
                        jSONObject.put("d_form_ver", 1);
                        jSONObject.put("aid", this.e);
                        this.g.h.i("pub.dat", jSONObject.toString(), true);
                        this.f = false;
                        return true;
                    } catch (Exception unused) {
                    }
                }
                return false;
            }
            return invokeV.booleanValue;
        }

        public void i() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
                String g = this.g.h.g("pub.dat", true);
                if (TextUtils.isEmpty(g)) {
                    return;
                }
                try {
                    JSONObject jSONObject = new JSONObject(g);
                    this.a = jSONObject.getInt("pub_ver");
                    this.b = jSONObject.getLong("pub_lst_ts");
                    this.d = jSONObject.getLong("pkg_lst_up_ts");
                    this.c.b(jSONObject.getLong("flags"));
                    jSONObject.getInt("d_form_ver");
                    this.e = jSONObject.optString("aid");
                    this.f = false;
                } catch (Exception unused) {
                    this.f = true;
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class k {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public Method a;
        public Method b;
        public Method c;
        public Method d;
        public Method e;

        public k() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public int a(Context context, Uri uri, int i, int i2, int i3) throws d.a {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{context, uri, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)})) == null) {
                try {
                    return ((Integer) this.a.invoke(context, uri, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3))).intValue();
                } catch (Exception e) {
                    throw new d.a(e);
                }
            }
            return invokeCommon.intValue;
        }

        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                try {
                    this.a = com.baidu.helios.channels.upc.d.b(Context.class, com.baidu.helios.channels.upc.d.a(g20.a()), new Class[]{Uri.class, Integer.TYPE, Integer.TYPE, Integer.TYPE});
                    this.b = com.baidu.helios.channels.upc.d.b(Context.class, com.baidu.helios.channels.upc.d.a(g20.b()), new Class[]{String.class, Uri.class, Integer.TYPE});
                    this.c = com.baidu.helios.channels.upc.d.b(ContentResolver.class, com.baidu.helios.channels.upc.d.a(g20.e()), new Class[]{Uri.class, Integer.TYPE});
                    this.d = com.baidu.helios.channels.upc.d.b(Context.class, com.baidu.helios.channels.upc.d.a(g20.d()), new Class[]{Uri.class, Integer.TYPE});
                    this.e = com.baidu.helios.channels.upc.d.b(ContentResolver.class, com.baidu.helios.channels.upc.d.a(g20.c()), new Class[]{Uri.class, Integer.TYPE});
                } catch (Exception unused) {
                }
            }
        }

        public void c(ContentResolver contentResolver, Uri uri, int i) throws d.a {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLI(Constants.METHOD_SEND_USER_MSG, this, contentResolver, uri, i) == null) {
                try {
                    this.e.invoke(contentResolver, uri, Integer.valueOf(i));
                } catch (Exception e) {
                    throw new d.a(e);
                }
            }
        }

        public void d(Context context, Uri uri, int i) throws d.a {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLI(1048579, this, context, uri, i) == null) {
                try {
                    this.d.invoke(context, uri, Integer.valueOf(i));
                } catch (Exception e) {
                    throw new d.a(e);
                }
            }
        }

        public void e(Context context, String str, Uri uri, int i) throws d.a {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLLI(1048580, this, context, str, uri, i) == null) {
                try {
                    this.b.invoke(context, str, uri, Integer.valueOf(i));
                } catch (Exception e) {
                    throw new d.a(e);
                }
            }
        }

        public void f(ContentResolver contentResolver, Uri uri, int i) throws d.a {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLI(1048581, this, contentResolver, uri, i) == null) {
                try {
                    this.c.invoke(contentResolver, uri, Integer.valueOf(i));
                } catch (Exception e) {
                    throw new d.a(e);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class l extends x10.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String d;
        public long e;
        public String f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public l(e20 e20Var, String str) {
            super(e20Var.h, str);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {e20Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((d40.a) objArr2[0], (String) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        @Override // com.repackage.x10.b
        public void c(JSONObject jSONObject) throws JSONException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jSONObject) == null) {
                this.d = jSONObject.getString("pkg");
                this.e = jSONObject.getLong("last_fe_ts");
                this.f = jSONObject.getString("id");
                jSONObject.getInt("d_form_ver");
            }
        }

        @Override // com.repackage.x10.b
        public void e(JSONObject jSONObject) throws JSONException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONObject) == null) {
                jSONObject.put("pkg", this.d);
                jSONObject.put("last_fe_ts", this.e);
                jSONObject.put("id", this.f);
                jSONObject.put("d_form_ver", 1);
            }
        }

        public String f() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f : (String) invokeV.objValue;
        }

        public void g(long j) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeJ(1048579, this, j) == null) || this.e == j) {
                return;
            }
            this.e = j;
            a(true);
        }

        public void h(String str) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048580, this, str) == null) || str.equals(this.f)) {
                return;
            }
            this.f = str;
            a(true);
        }

        public String i() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.d : (String) invokeV.objValue;
        }

        public void j(String str) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048582, this, str) == null) || str.equals(this.d)) {
                return;
            }
            this.d = str;
            a(true);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e20() {
        super("upc", 8500000L);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr = newInitContext.callArgs;
                super((String) objArr[0], ((Long) objArr[1]).longValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.g = new k();
        this.i = new j(this);
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IGET]}, finally: {[IGET, INVOKE, IF, IF] complete} */
    @Override // com.repackage.x10
    public x10.g b(String str, x10.f fVar) {
        InterceptResult invokeLL;
        PackageInfo packageInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, str, fVar)) == null) {
            if (Build.VERSION.SDK_INT < 26) {
                return x10.g.a();
            }
            h hVar = new h();
            l lVar = null;
            try {
                packageInfo = this.f.getPackageManager().getPackageInfo(str, 0);
            } catch (PackageManager.NameNotFoundException unused) {
                packageInfo = null;
            }
            if (packageInfo == null) {
                return x10.g.a();
            }
            if (fVar.a) {
                lVar = new l(this, str);
                lVar.d();
                if (str.equals(lVar.i())) {
                    String f2 = lVar.f();
                    if (!TextUtils.isEmpty(f2)) {
                        return x10.g.f(f2);
                    }
                }
                lVar.j(str);
            }
            l lVar2 = lVar;
            int i2 = packageInfo.applicationInfo.uid;
            i iVar = new i();
            c cVar = new c();
            c cVar2 = new c();
            for (int i3 = 0; i3 < 16; i3++) {
                try {
                    a d2 = a.d(i3);
                    if (u(str, d2, i2)) {
                        cVar.a(d2);
                    } else {
                        cVar2.a(d2);
                    }
                } finally {
                    if (fVar.a && lVar2 != null) {
                        lVar2.b();
                    }
                }
            }
            e eVar = new e();
            int a2 = f20.a(20);
            c cVar3 = new c();
            for (int i4 = 0; i4 <= g.b; i4++) {
                cVar3.a(g.d(i4));
            }
            int i5 = 0;
            while (i5 < a2) {
                int i6 = i5;
                c cVar4 = cVar3;
                int i7 = a2;
                e eVar2 = eVar;
                d j2 = j(str, i5, cVar.b(), cVar3.c(), i2, iVar);
                if (j2 == null) {
                    j2 = j(str, i6, cVar2.b(), cVar4.c(), i2, iVar);
                }
                if (j2 == null) {
                    return x10.g.a();
                }
                eVar2.d(j2);
                i5 = i6 + 1;
                eVar = eVar2;
                cVar3 = cVar4;
                a2 = i7;
            }
            String i8 = i40.i(eVar.f());
            if (fVar.a && lVar2 != null) {
                lVar2.h(i8);
                lVar2.g(System.currentTimeMillis());
            }
            x10.g f3 = x10.g.f(i8);
            if (fVar.b) {
                f3.c = hVar;
            }
            if (fVar.a && lVar2 != null) {
                lVar2.b();
            }
            return f3;
        }
        return (x10.g) invokeLL.objValue;
    }

    @Override // com.repackage.x10
    public void e(x10.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar) == null) {
            this.f = this.a.a;
            this.h = this.b.f("upc");
            this.g.b();
        }
    }

    @Override // com.repackage.x10
    public x10.e f(x10.d dVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, dVar)) == null) {
            this.i.i();
            try {
                return h(dVar);
            } finally {
                this.i.h();
            }
        }
        return (x10.e) invokeL.objValue;
    }

    public final x10.e h(x10.d dVar) {
        InterceptResult invokeL;
        String b2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, dVar)) == null) {
            if (Build.VERSION.SDK_INT < 26) {
                return x10.e.a();
            }
            Context context = this.a.a;
            PackageManager packageManager = context.getPackageManager();
            String packageName = context.getPackageName();
            try {
                PackageInfo packageInfo = packageManager.getPackageInfo(context.getPackageName(), 0);
                boolean z = packageInfo.lastUpdateTime != this.i.f();
                this.i.g(packageInfo.lastUpdateTime);
                if (z || this.i.a(6L) != 4) {
                    g40 a2 = this.a.c.a("aid");
                    e b3 = e.b(a2.d());
                    if (b3 == null) {
                        return x10.e.a();
                    }
                    if (this.i.a(1L) == 1 && (b2 = this.i.b()) != null && b2.equals(a2.c())) {
                        return x10.e.d();
                    }
                    this.i.d(a2.c());
                    ProviderInfo providerInfo = null;
                    try {
                        providerInfo = packageManager.resolveContentProvider(k(packageName), 0);
                    } catch (Exception unused) {
                    }
                    if (providerInfo == null) {
                        this.i.c(4L, 6L);
                    } else {
                        this.i.c(2L, 6L);
                    }
                    return i(b3);
                }
                return x10.e.a();
            } catch (PackageManager.NameNotFoundException unused2) {
                return x10.e.a();
            }
        }
        return (x10.e) invokeL.objValue;
    }

    public final x10.e i(e eVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, eVar)) == null) {
            f fVar = new f(6);
            for (int i2 = 0; i2 < eVar.a(); i2++) {
                fVar.b(eVar.e(i2).h());
            }
            List<a> a2 = fVar.a();
            if (s(eVar, a2)) {
                for (int a3 = eVar.a() - 1; a3 >= 0; a3--) {
                    o(a3, eVar.e(a3));
                }
                for (a aVar : a2) {
                    r(aVar);
                }
                this.i.e(System.currentTimeMillis());
            }
            this.i.c(1L, 1L);
            return x10.e.d();
        }
        return (x10.e) invokeL.objValue;
    }

    public final d j(String str, int i2, List<c.C0617c<a>> list, List<c.C0617c<g>> list2, int i3, i iVar) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048581, this, new Object[]{str, Integer.valueOf(i2), list, list2, Integer.valueOf(i3), iVar})) == null) {
            for (c.C0617c<a> c0617c : list) {
                for (c.C0617c<g> c0617c2 : list2) {
                    d e2 = d.e(c0617c2.a(), c0617c.a());
                    if (t(str, i2, e2, i3, iVar)) {
                        c0617c.c();
                        c0617c2.c();
                        return e2;
                    }
                }
            }
            return null;
        }
        return (d) invokeCommon.objValue;
    }

    public final String k(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
            return str + ".helios.quark";
        }
        return (String) invokeL.objValue;
    }

    public final String l(String str, int i2, d dVar) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048583, this, str, i2, dVar)) == null) ? String.format("content://%s/dat/v1/i%d/%s", k(str), Integer.valueOf(i2), dVar.g()) : (String) invokeLIL.objValue;
    }

    public final String m(String str, a aVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, aVar)) == null) ? String.format("content://%s/dic/v1/%s", k(str), aVar.e()) : (String) invokeLL.objValue;
    }

    public final void n(UriMatcher uriMatcher) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, uriMatcher) == null) {
            uriMatcher.addURI(k(this.f.getPackageName()), "dat/v1/*/*", 1);
            uriMatcher.addURI(k(this.f.getPackageName()), "dic/v1/*", 2);
        }
    }

    public final boolean o(int i2, d dVar) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048586, this, i2, dVar)) == null) {
            if (Build.VERSION.SDK_INT < 26) {
                return false;
            }
            return p(Uri.parse(l(this.f.getPackageName(), i2, dVar)));
        }
        return invokeIL.booleanValue;
    }

    public final boolean p(Uri uri) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, uri)) == null) {
            if (Build.VERSION.SDK_INT < 26) {
                return false;
            }
            Context context = this.f;
            ContentResolver contentResolver = context.getContentResolver();
            try {
                this.g.e(context, context.getPackageName(), uri, 65);
                this.g.f(contentResolver, uri, 1);
                return true;
            } catch (Exception unused) {
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public final boolean q(Uri uri, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048588, this, uri, i2)) == null) {
            if (Build.VERSION.SDK_INT < 26) {
                return false;
            }
            Context context = this.f;
            ContentResolver contentResolver = context.getContentResolver();
            try {
                this.g.d(context, uri, i2);
                this.g.c(contentResolver, uri, i2);
                return true;
            } catch (Exception unused) {
                return false;
            }
        }
        return invokeLI.booleanValue;
    }

    public final boolean r(a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, aVar)) == null) {
            if (Build.VERSION.SDK_INT < 26) {
                return false;
            }
            return p(Uri.parse(m(this.f.getPackageName(), aVar)));
        }
        return invokeL.booleanValue;
    }

    public final boolean s(e eVar, List<a> list) {
        InterceptResult invokeLL;
        int i2;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048590, this, eVar, list)) == null) {
            if (Build.VERSION.SDK_INT < 26) {
                return false;
            }
            ContentResolver contentResolver = this.f.getContentResolver();
            UriMatcher uriMatcher = new UriMatcher(-1);
            n(uriMatcher);
            List<UriPermission> persistedUriPermissions = contentResolver.getPersistedUriPermissions();
            if (persistedUriPermissions == null || persistedUriPermissions.size() == 0) {
                persistedUriPermissions = contentResolver.getOutgoingPersistedUriPermissions();
            }
            if (persistedUriPermissions == null || persistedUriPermissions.size() == 0) {
                return true;
            }
            for (UriPermission uriPermission : persistedUriPermissions) {
                Uri uri = uriPermission.getUri();
                int match = uriMatcher.match(uri);
                List<String> pathSegments = uri.getPathSegments();
                if ((match == 1 || match == 2) && uriPermission.isWritePermission()) {
                    q(uri, uriPermission.isReadPermission() ? 3 : 2);
                } else if (match == 1) {
                    try {
                        i2 = Integer.valueOf(pathSegments.get(2).substring(1)).intValue();
                    } catch (Exception unused) {
                        i2 = -1;
                    }
                    if (i2 >= 0 && i2 < eVar.a()) {
                        if (!eVar.e(i2).g().equals(pathSegments.get(3))) {
                        }
                    }
                    q(uri, 1);
                } else if (match == 2) {
                    String str = pathSegments.get(2);
                    Iterator<a> it = list.iterator();
                    while (true) {
                        if (it.hasNext()) {
                            if (it.next().e().equals(str)) {
                                z = true;
                                break;
                            }
                        } else {
                            z = false;
                            break;
                        }
                    }
                    if (!z) {
                        q(uri, 1);
                    }
                }
            }
            int a2 = eVar.a();
            for (int i3 = 0; i3 < a2; i3++) {
                if (!t(this.f.getPackageName(), i3, eVar.e(i3), Process.myUid(), null)) {
                    return true;
                }
            }
            int size = list.size();
            for (int i4 = 0; i4 < size; i4++) {
                if (!u(this.f.getPackageName(), list.get(i4), Process.myUid())) {
                    return true;
                }
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public final boolean t(String str, int i2, d dVar, int i3, i iVar) {
        InterceptResult invokeCommon;
        int i4;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048591, this, new Object[]{str, Integer.valueOf(i2), dVar, Integer.valueOf(i3), iVar})) == null) {
            Uri parse = Uri.parse(l(str, i2, dVar));
            int i5 = 0;
            while (true) {
                if (i5 >= 2) {
                    i4 = -1;
                    break;
                }
                if (iVar != null) {
                    try {
                        if (iVar.a > 0 && iVar.a % 100 == 0) {
                            try {
                                Thread.sleep(10L);
                            } catch (Exception unused) {
                            }
                        }
                        iVar.a++;
                    } catch (Throwable unused2) {
                        try {
                            Thread.sleep(5L);
                        } catch (Exception unused3) {
                        }
                        i5++;
                    }
                }
                i4 = this.g.a(this.f, parse, 0, i3, 1);
                break;
            }
            if (i4 == 0) {
                return true;
            }
            if (iVar != null) {
                iVar.b++;
            }
            return false;
        }
        return invokeCommon.booleanValue;
    }

    public final boolean u(String str, a aVar, int i2) {
        InterceptResult invokeLLI;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048592, this, str, aVar, i2)) == null) {
            Uri parse = Uri.parse(m(str, aVar));
            int i4 = 0;
            while (true) {
                if (i4 >= 2) {
                    i3 = -1;
                    break;
                }
                try {
                    i3 = this.g.a(this.f, parse, 0, i2, 1);
                    break;
                } catch (Throwable unused) {
                    try {
                        Thread.sleep(5L);
                    } catch (Exception unused2) {
                    }
                    i4++;
                }
            }
            return i3 == 0;
        }
        return invokeLLI.booleanValue;
    }
}
