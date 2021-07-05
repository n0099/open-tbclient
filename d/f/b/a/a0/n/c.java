package d.f.b.a.a0.n;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.extractor.flv.TagPayloadReader;
import d.f.b.a.a0.m;
import d.f.b.a.i0.l;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
/* loaded from: classes10.dex */
public final class c extends TagPayloadReader {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public long f72143b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(m mVar) {
        super(mVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {mVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((m) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f72143b = -9223372036854775807L;
    }

    public static Boolean e(l lVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, lVar)) == null) {
            return Boolean.valueOf(lVar.x() == 1);
        }
        return (Boolean) invokeL.objValue;
    }

    public static Object f(l lVar, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65538, null, lVar, i2)) == null) {
            if (i2 != 0) {
                if (i2 != 1) {
                    if (i2 != 2) {
                        if (i2 != 3) {
                            if (i2 != 8) {
                                if (i2 != 10) {
                                    if (i2 != 11) {
                                        return null;
                                    }
                                    return g(lVar);
                                }
                                return k(lVar);
                            }
                            return i(lVar);
                        }
                        return j(lVar);
                    }
                    return l(lVar);
                }
                return e(lVar);
            }
            return h(lVar);
        }
        return invokeLI.objValue;
    }

    public static Date g(l lVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, lVar)) == null) {
            Date date = new Date((long) h(lVar).doubleValue());
            lVar.K(2);
            return date;
        }
        return (Date) invokeL.objValue;
    }

    public static Double h(l lVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65540, null, lVar)) == null) ? Double.valueOf(Double.longBitsToDouble(lVar.q())) : (Double) invokeL.objValue;
    }

    public static HashMap<String, Object> i(l lVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, lVar)) == null) {
            int B = lVar.B();
            HashMap<String, Object> hashMap = new HashMap<>(B);
            for (int i2 = 0; i2 < B; i2++) {
                hashMap.put(l(lVar), f(lVar, m(lVar)));
            }
            return hashMap;
        }
        return (HashMap) invokeL.objValue;
    }

    public static HashMap<String, Object> j(l lVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, lVar)) != null) {
            return (HashMap) invokeL.objValue;
        }
        HashMap<String, Object> hashMap = new HashMap<>();
        while (true) {
            String l = l(lVar);
            int m = m(lVar);
            if (m == 9) {
                return hashMap;
            }
            hashMap.put(l, f(lVar, m));
        }
    }

    public static ArrayList<Object> k(l lVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, lVar)) == null) {
            int B = lVar.B();
            ArrayList<Object> arrayList = new ArrayList<>(B);
            for (int i2 = 0; i2 < B; i2++) {
                arrayList.add(f(lVar, m(lVar)));
            }
            return arrayList;
        }
        return (ArrayList) invokeL.objValue;
    }

    public static String l(l lVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, lVar)) == null) {
            int D = lVar.D();
            int c2 = lVar.c();
            lVar.K(D);
            return new String(lVar.f73386a, c2, D);
        }
        return (String) invokeL.objValue;
    }

    public static int m(l lVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65545, null, lVar)) == null) ? lVar.x() : invokeL.intValue;
    }

    @Override // com.google.android.exoplayer2.extractor.flv.TagPayloadReader
    public boolean b(l lVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, lVar)) == null) {
            return true;
        }
        return invokeL.booleanValue;
    }

    @Override // com.google.android.exoplayer2.extractor.flv.TagPayloadReader
    public void c(l lVar, long j) throws ParserException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, lVar, j) == null) {
            if (m(lVar) == 2) {
                if ("onMetaData".equals(l(lVar)) && m(lVar) == 8) {
                    HashMap<String, Object> i2 = i(lVar);
                    if (i2.containsKey("duration")) {
                        double doubleValue = ((Double) i2.get("duration")).doubleValue();
                        if (doubleValue > 0.0d) {
                            this.f72143b = (long) (doubleValue * 1000000.0d);
                            return;
                        }
                        return;
                    }
                    return;
                }
                return;
            }
            throw new ParserException();
        }
    }

    public long d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f72143b : invokeV.longValue;
    }
}
