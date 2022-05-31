package com.repackage;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.bdtask.framework.utils.DebugTrace;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.ar;
import com.repackage.br;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class cr {
    public static /* synthetic */ Interceptable $ic;
    public static final a f;
    public transient /* synthetic */ FieldHolder $fh;
    public final br a;
    public final byte[] b;
    public final int c;
    public final byte[] d;
    public final List<ar> e;

    /* loaded from: classes5.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a() {
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

        @JvmStatic
        public final cr a(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
                if (str == null || TextUtils.isEmpty(str)) {
                    return null;
                }
                DebugTrace debugTrace = DebugTrace.a;
                debugTrace.a("get raw data:" + str);
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    br.b bVar = br.c;
                    String optString = jSONObject.optString("Random");
                    Intrinsics.checkExpressionValueIsNotNull(optString, "dataObj.optString(\"Random\")");
                    br b = bVar.b(optString);
                    String optString2 = jSONObject.optString("CipherSuite");
                    int optInt = jSONObject.optInt("LifeTime");
                    String optString3 = jSONObject.optString("SKR");
                    LinkedList linkedList = new LinkedList();
                    JSONArray optJSONArray = jSONObject.optJSONArray("Extensions");
                    if (optJSONArray != null) {
                        int length = optJSONArray.length();
                        for (int i = 0; i < length; i++) {
                            String item = optJSONArray.optString(i);
                            ar.b bVar2 = ar.c;
                            Intrinsics.checkExpressionValueIsNotNull(item, "item");
                            ar b2 = bVar2.b(item);
                            if (b2 != null) {
                                linkedList.add(b2);
                            }
                        }
                    }
                    return new cr(b, bt.b(optString2), optInt, bt.b(optString3), linkedList);
                } catch (Exception e) {
                    e.printStackTrace();
                    DebugTrace debugTrace2 = DebugTrace.a;
                    debugTrace2.a("can not parse server hello:" + e.getMessage());
                    return null;
                }
            }
            return (cr) invokeL.objValue;
        }

        @JvmStatic
        public final cr b(byte[] bArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bArr)) == null) ? a(bt.a(bArr)) : (cr) invokeL.objValue;
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1964042890, "Lcom/repackage/cr;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1964042890, "Lcom/repackage/cr;");
                return;
            }
        }
        f = new a(null);
    }

    public cr(br brVar, byte[] bArr, int i, byte[] bArr2, List<ar> list) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {brVar, bArr, Integer.valueOf(i), bArr2, list};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = brVar;
        this.b = bArr;
        this.c = i;
        this.d = bArr2;
        this.e = list;
    }

    @JvmStatic
    public static final cr a(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, bArr)) == null) ? f.b(bArr) : (cr) invokeL.objValue;
    }

    public final List<ar> b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.e : (List) invokeV.objValue;
    }

    public final int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.c : invokeV.intValue;
    }

    public final byte[] d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? bt.d(this.b) : (byte[]) invokeV.objValue;
    }

    public final byte[] e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? bt.d(this.d) : (byte[]) invokeV.objValue;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, obj)) == null) {
            if (this != obj) {
                if (obj instanceof cr) {
                    cr crVar = (cr) obj;
                    if (Intrinsics.areEqual(this.a, crVar.a) && Intrinsics.areEqual(this.b, crVar.b)) {
                        if (!(this.c == crVar.c) || !Intrinsics.areEqual(this.d, crVar.d) || !Intrinsics.areEqual(this.e, crVar.e)) {
                        }
                    }
                }
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            br brVar = this.a;
            int hashCode = (brVar != null ? brVar.hashCode() : 0) * 31;
            byte[] bArr = this.b;
            int hashCode2 = (((hashCode + (bArr != null ? Arrays.hashCode(bArr) : 0)) * 31) + this.c) * 31;
            byte[] bArr2 = this.d;
            int hashCode3 = (hashCode2 + (bArr2 != null ? Arrays.hashCode(bArr2) : 0)) * 31;
            List<ar> list = this.e;
            return hashCode3 + (list != null ? list.hashCode() : 0);
        }
        return invokeV.intValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return "ServerHello(random=" + this.a + ", cipherSuiteBytes=" + Arrays.toString(this.b) + ", lifeTime=" + this.c + ", SKRBytes=" + Arrays.toString(this.d) + ", extensions=" + this.e + SmallTailInfo.EMOTION_SUFFIX;
        }
        return (String) invokeV.objValue;
    }
}
