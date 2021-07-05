package d.f.b.a.e0.r;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.text.SubtitleDecoderException;
import d.f.b.a.e0.r.e;
import d.f.b.a.i0.l;
import d.f.b.a.i0.v;
import java.util.ArrayList;
import java.util.Collections;
/* loaded from: classes10.dex */
public final class b extends d.f.b.a.e0.c {
    public static /* synthetic */ Interceptable $ic;
    public static final int p;
    public static final int q;
    public static final int r;
    public transient /* synthetic */ FieldHolder $fh;
    public final l n;
    public final e.b o;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1197716607, "Ld/f/b/a/e0/r/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1197716607, "Ld/f/b/a/e0/r/b;");
                return;
            }
        }
        p = v.q("payl");
        q = v.q("sttg");
        r = v.q("vttc");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b() {
        super("Mp4WebvttDecoder");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
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
        this.n = new l();
        this.o = new e.b();
    }

    public static d.f.b.a.e0.b A(l lVar, e.b bVar, int i2) throws SubtitleDecoderException {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(65538, null, lVar, bVar, i2)) == null) {
            bVar.c();
            while (i2 > 0) {
                if (i2 >= 8) {
                    int i3 = lVar.i();
                    int i4 = lVar.i();
                    int i5 = i3 - 8;
                    String str = new String(lVar.f73386a, lVar.c(), i5);
                    lVar.K(i5);
                    i2 = (i2 - 8) - i5;
                    if (i4 == q) {
                        f.j(str, bVar);
                    } else if (i4 == p) {
                        f.k(null, str.trim(), bVar, Collections.emptyList());
                    }
                } else {
                    throw new SubtitleDecoderException("Incomplete vtt cue box header found.");
                }
            }
            return bVar.a();
        }
        return (d.f.b.a.e0.b) invokeLLI.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.f.b.a.e0.c
    /* renamed from: z */
    public c w(byte[] bArr, int i2, boolean z) throws SubtitleDecoderException {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{bArr, Integer.valueOf(i2), Boolean.valueOf(z)})) == null) {
            this.n.H(bArr, i2);
            ArrayList arrayList = new ArrayList();
            while (this.n.a() > 0) {
                if (this.n.a() >= 8) {
                    int i3 = this.n.i();
                    if (this.n.i() == r) {
                        arrayList.add(A(this.n, this.o, i3 - 8));
                    } else {
                        this.n.K(i3 - 8);
                    }
                } else {
                    throw new SubtitleDecoderException("Incomplete Mp4Webvtt Top Level box header found.");
                }
            }
            return new c(arrayList);
        }
        return (c) invokeCommon.objValue;
    }
}
