package d.a.s0.u0.l1;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.squareup.wire.Message;
import com.squareup.wire.Wire;
import d.a.c.k.e.n;
import d.a.r0.g0.b.b;
import d.a.r0.g0.b.h;
import d.a.r0.r.q.b2;
import java.util.ArrayList;
import java.util.HashMap;
import org.json.JSONObject;
import tbclient.StarTrends.DataRes;
import tbclient.StarTrends.StarTrendsResIdl;
import tbclient.ThreadInfo;
import tbclient.User;
/* loaded from: classes9.dex */
public class a implements b, h {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: i  reason: collision with root package name */
    public static final Wire f66273i;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public ArrayList<n> f66274e;

    /* renamed from: f  reason: collision with root package name */
    public HashMap<String, MetaData> f66275f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f66276g;

    /* renamed from: h  reason: collision with root package name */
    public int f66277h;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-161387747, "Ld/a/s0/u0/l1/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-161387747, "Ld/a/s0/u0/l1/a;");
                return;
            }
        }
        f66273i = new Wire(new Class[0]);
    }

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f66274e = new ArrayList<>();
        this.f66275f = new HashMap<>();
    }

    public StarTrendsResIdl a(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, bArr)) == null) {
            if (bArr == null) {
                return null;
            }
            try {
                StarTrendsResIdl starTrendsResIdl = (StarTrendsResIdl) f66273i.parseFrom(bArr, StarTrendsResIdl.class);
                if (starTrendsResIdl != null && starTrendsResIdl.data != null) {
                    c(starTrendsResIdl.data);
                }
                return starTrendsResIdl;
            } catch (Exception e2) {
                BdLog.detailException(e2);
                return null;
            }
        }
        return (StarTrendsResIdl) invokeL.objValue;
    }

    public final void c(DataRes dataRes) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, dataRes) == null) || dataRes == null) {
            return;
        }
        if (!ListUtils.isEmpty(dataRes.user_list)) {
            for (User user : dataRes.user_list) {
                if (user != null) {
                    MetaData metaData = new MetaData();
                    metaData.parserProtobuf(user);
                    String userId = metaData.getUserId();
                    if (userId != null && !"0".equals(userId)) {
                        this.f66275f.put(userId, metaData);
                    }
                }
            }
        }
        if (!ListUtils.isEmpty(dataRes.thread_list)) {
            for (ThreadInfo threadInfo : dataRes.thread_list) {
                if (threadInfo != null) {
                    b2 b2Var = new b2();
                    b2Var.i4(this.f66275f);
                    b2Var.I2(threadInfo);
                    b2Var.M2();
                    b2Var.z1();
                    if (b2Var.getType() == b2.O2 || b2Var.getType() == b2.k3 || b2Var.getType() == b2.q3 || b2Var.getType() == b2.l3 || b2Var.getType() == b2.u3 || b2Var.getType() == b2.v3) {
                        this.f66274e.add(b2Var);
                    }
                }
            }
        }
        d.a.r0.b.f.a.d(this.f66274e);
        this.f66276g = dataRes.has_more.intValue() == 1;
    }

    @Override // d.a.r0.g0.b.c
    public String getCacheKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return null;
        }
        return (String) invokeV.objValue;
    }

    @Override // d.a.r0.g0.b.b
    public boolean initByByteArray(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, bArr)) == null) {
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // d.a.r0.g0.b.h
    public void initByJson(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, jSONObject) == null) {
        }
    }

    @Override // d.a.r0.g0.b.h
    public void initByProtobuf(Message message) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, message) == null) {
        }
    }

    @Override // d.a.r0.g0.b.b
    public byte[] toCacheByteArray() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return null;
        }
        return (byte[]) invokeV.objValue;
    }
}
