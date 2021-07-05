package d.f.b.a.e0.n;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.f.b.a.e0.c;
import d.f.b.a.i0.g;
import d.f.b.a.i0.l;
import d.f.b.a.i0.v;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes10.dex */
public final class a extends c {
    public static /* synthetic */ Interceptable $ic;
    public static final Pattern s;
    public transient /* synthetic */ FieldHolder $fh;
    public final boolean n;
    public int o;
    public int p;
    public int q;
    public int r;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1197597412, "Ld/f/b/a/e0/n/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1197597412, "Ld/f/b/a/e0/n/a;");
                return;
            }
        }
        s = Pattern.compile("(?:(\\d+):)?(\\d+):(\\d+)(?::|\\.)(\\d+)");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(List<byte[]> list) {
        super("SsaDecoder");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {list};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((String) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        if (list != null && !list.isEmpty()) {
            this.n = true;
            String str = new String(list.get(0));
            d.f.b.a.i0.a.a(str.startsWith("Format: "));
            C(str);
            D(new l(list.get(1)));
            return;
        }
        this.n = false;
    }

    public static long E(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            Matcher matcher = s.matcher(str);
            if (matcher.matches()) {
                return (Long.parseLong(matcher.group(1)) * 60 * 60 * 1000000) + (Long.parseLong(matcher.group(2)) * 60 * 1000000) + (Long.parseLong(matcher.group(3)) * 1000000) + (Long.parseLong(matcher.group(4)) * 10000);
            }
            return -9223372036854775807L;
        }
        return invokeL.longValue;
    }

    public final void A(String str, List<d.f.b.a.e0.b> list, g gVar) {
        long j;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, str, list, gVar) == null) {
            if (this.o == 0) {
                Log.w("SsaDecoder", "Skipping dialogue line before format: " + str);
                return;
            }
            String[] split = str.substring(10).split(",", this.o);
            long E = E(split[this.p]);
            if (E == -9223372036854775807L) {
                Log.w("SsaDecoder", "Skipping invalid timing: " + str);
                return;
            }
            String str2 = split[this.q];
            if (str2.trim().isEmpty()) {
                j = -9223372036854775807L;
            } else {
                j = E(str2);
                if (j == -9223372036854775807L) {
                    Log.w("SsaDecoder", "Skipping invalid timing: " + str);
                    return;
                }
            }
            list.add(new d.f.b.a.e0.b(split[this.r].replaceAll("\\{.*?\\}", "").replaceAll("\\\\N", "\n").replaceAll("\\\\n", "\n")));
            gVar.a(E);
            if (j != -9223372036854775807L) {
                list.add(null);
                gVar.a(j);
            }
        }
    }

    public final void B(l lVar, List<d.f.b.a.e0.b> list, g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, lVar, list, gVar) != null) {
            return;
        }
        while (true) {
            String k = lVar.k();
            if (k == null) {
                return;
            }
            if (!this.n && k.startsWith("Format: ")) {
                C(k);
            } else if (k.startsWith("Dialogue: ")) {
                A(k, list, gVar);
            }
        }
    }

    public final void C(String str) {
        char c2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            String[] split = TextUtils.split(str.substring(8), ",");
            this.o = split.length;
            this.p = -1;
            this.q = -1;
            this.r = -1;
            for (int i2 = 0; i2 < this.o; i2++) {
                String J = v.J(split[i2].trim());
                int hashCode = J.hashCode();
                if (hashCode == 100571) {
                    if (J.equals("end")) {
                        c2 = 1;
                    }
                    c2 = 65535;
                } else if (hashCode != 3556653) {
                    if (hashCode == 109757538 && J.equals("start")) {
                        c2 = 0;
                    }
                    c2 = 65535;
                } else {
                    if (J.equals("text")) {
                        c2 = 2;
                    }
                    c2 = 65535;
                }
                if (c2 == 0) {
                    this.p = i2;
                } else if (c2 == 1) {
                    this.q = i2;
                } else if (c2 == 2) {
                    this.r = i2;
                }
            }
        }
    }

    public final void D(l lVar) {
        String k;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, lVar) == null) {
            do {
                k = lVar.k();
                if (k == null) {
                    return;
                }
            } while (!k.startsWith("[Events]"));
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.f.b.a.e0.c
    /* renamed from: z */
    public b w(byte[] bArr, int i2, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048581, this, new Object[]{bArr, Integer.valueOf(i2), Boolean.valueOf(z)})) == null) {
            ArrayList arrayList = new ArrayList();
            g gVar = new g();
            l lVar = new l(bArr, i2);
            if (!this.n) {
                D(lVar);
            }
            B(lVar, arrayList, gVar);
            d.f.b.a.e0.b[] bVarArr = new d.f.b.a.e0.b[arrayList.size()];
            arrayList.toArray(bVarArr);
            return new b(bVarArr, gVar.d());
        }
        return (b) invokeCommon.objValue;
    }
}
