package com.repackage;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public final class ms implements ts {
    public static /* synthetic */ Interceptable $ic;
    public static final b e;
    public transient /* synthetic */ FieldHolder $fh;
    public final os a;
    public final List<byte[]> b;
    public final List<ns> c;
    public final byte[] d;

    /* loaded from: classes6.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public os a;
        public List<byte[]> b;
        public List<ns> c;
        public byte[] d;

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
                    return;
                }
            }
            this.b = new LinkedList();
            this.c = new LinkedList();
        }

        public final a a(ns nsVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, nsVar)) == null) {
                this.c.add(nsVar);
                return this;
            }
            return (a) invokeL.objValue;
        }

        public final a b(os osVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, osVar)) == null) {
                this.a = osVar;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public final a c(byte[] bArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bArr)) == null) {
                List<byte[]> list = this.b;
                byte[] c = ou.c(bArr);
                Intrinsics.checkExpressionValueIsNotNull(c, "StringUtils.base64Encode(cipherSuite)");
                list.add(c);
                return this;
            }
            return (a) invokeL.objValue;
        }

        public final ms d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? new ms(this.a, this.b, this.c, ou.c(this.d)) : (ms) invokeV.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public static final class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b() {
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
        public final a a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? new a() : (a) invokeV.objValue;
        }

        public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1964033249, "Lcom/repackage/ms;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1964033249, "Lcom/repackage/ms;");
                return;
            }
        }
        e = new b(null);
    }

    public ms(os osVar, List<byte[]> list, List<ns> list2, byte[] bArr) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {osVar, list, list2, bArr};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = osVar;
        this.b = list;
        this.c = list2;
        this.d = bArr;
    }

    @JvmStatic
    public static final a d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? e.a() : (a) invokeV.objValue;
    }

    public byte[] a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            byte[] b2 = ou.b(b());
            Intrinsics.checkExpressionValueIsNotNull(b2, "StringUtils.str2Byte(toJsonStr())");
            return b2;
        }
        return (byte[]) invokeV.objValue;
    }

    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            String jSONObject = c().toString();
            Intrinsics.checkExpressionValueIsNotNull(jSONObject, "toJsonObj().toString()");
            return jSONObject;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.repackage.ts
    public JSONObject c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            os osVar = this.a;
            jSONObject.putOpt("Random", osVar != null ? osVar.c() : null);
            jSONObject.putOpt("CipherSuites", qs.a.b(this.b));
            jSONObject.putOpt("Extensions", qs.a.a(this.c));
            jSONObject.putOpt("SKR", ou.a(this.d));
            return jSONObject;
        }
        return (JSONObject) invokeV.objValue;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, obj)) == null) {
            if (this != obj) {
                if (obj instanceof ms) {
                    ms msVar = (ms) obj;
                    return Intrinsics.areEqual(this.a, msVar.a) && Intrinsics.areEqual(this.b, msVar.b) && Intrinsics.areEqual(this.c, msVar.c) && Intrinsics.areEqual(this.d, msVar.d);
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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            os osVar = this.a;
            int hashCode = (osVar != null ? osVar.hashCode() : 0) * 31;
            List<byte[]> list = this.b;
            int hashCode2 = (hashCode + (list != null ? list.hashCode() : 0)) * 31;
            List<ns> list2 = this.c;
            int hashCode3 = (hashCode2 + (list2 != null ? list2.hashCode() : 0)) * 31;
            byte[] bArr = this.d;
            return hashCode3 + (bArr != null ? Arrays.hashCode(bArr) : 0);
        }
        return invokeV.intValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return "ClientHello(random=" + this.a + ", cipherSuites=" + this.b + ", extensions=" + this.c + ", SKRBytes=" + Arrays.toString(this.d) + SmallTailInfo.EMOTION_SUFFIX;
        }
        return (String) invokeV.objValue;
    }
}
