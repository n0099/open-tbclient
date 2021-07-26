package d.f.b.a.j0;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.ParserException;
import d.f.b.a.i0.j;
import d.f.b.a.i0.l;
import java.util.Collections;
import java.util.List;
/* loaded from: classes8.dex */
public final class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final List<byte[]> f71003a;

    /* renamed from: b  reason: collision with root package name */
    public final int f71004b;

    public b(List<byte[]> list, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {list, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f71003a = list;
        this.f71004b = i2;
    }

    public static b a(l lVar) throws ParserException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, lVar)) == null) {
            try {
                lVar.K(21);
                int x = lVar.x() & 3;
                int x2 = lVar.x();
                int c2 = lVar.c();
                int i2 = 0;
                for (int i3 = 0; i3 < x2; i3++) {
                    lVar.K(1);
                    int D = lVar.D();
                    for (int i4 = 0; i4 < D; i4++) {
                        int D2 = lVar.D();
                        i2 += D2 + 4;
                        lVar.K(D2);
                    }
                }
                lVar.J(c2);
                byte[] bArr = new byte[i2];
                int i5 = 0;
                for (int i6 = 0; i6 < x2; i6++) {
                    lVar.K(1);
                    int D3 = lVar.D();
                    for (int i7 = 0; i7 < D3; i7++) {
                        int D4 = lVar.D();
                        System.arraycopy(j.f70923a, 0, bArr, i5, j.f70923a.length);
                        int length = i5 + j.f70923a.length;
                        System.arraycopy(lVar.f70943a, lVar.c(), bArr, length, D4);
                        i5 = length + D4;
                        lVar.K(D4);
                    }
                }
                return new b(i2 == 0 ? null : Collections.singletonList(bArr), x + 1);
            } catch (ArrayIndexOutOfBoundsException e2) {
                throw new ParserException("Error parsing HEVC config", e2);
            }
        }
        return (b) invokeL.objValue;
    }
}
