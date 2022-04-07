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
import com.repackage.et;
import com.repackage.ft;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public final class gt {
    public static /* synthetic */ Interceptable $ic;
    public static final a f;
    public transient /* synthetic */ FieldHolder $fh;
    public final ft a;
    public final byte[] b;
    public final int c;
    public final byte[] d;
    public final List<et> e;

    /* loaded from: classes6.dex */
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
        public final gt a(String str) {
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
                    ft.b bVar = ft.c;
                    String optString = jSONObject.optString("Random");
                    Intrinsics.checkExpressionValueIsNotNull(optString, "dataObj.optString(\"Random\")");
                    ft b = bVar.b(optString);
                    String optString2 = jSONObject.optString("CipherSuite");
                    int optInt = jSONObject.optInt("LifeTime");
                    String optString3 = jSONObject.optString("SKR");
                    LinkedList linkedList = new LinkedList();
                    JSONArray optJSONArray = jSONObject.optJSONArray("Extensions");
                    if (optJSONArray != null) {
                        int length = optJSONArray.length();
                        for (int i = 0; i < length; i++) {
                            String item = optJSONArray.optString(i);
                            et.b bVar2 = et.c;
                            Intrinsics.checkExpressionValueIsNotNull(item, "item");
                            et b2 = bVar2.b(item);
                            if (b2 != null) {
                                linkedList.add(b2);
                            }
                        }
                    }
                    return new gt(b, fv.b(optString2), optInt, fv.b(optString3), linkedList);
                } catch (Exception e) {
                    e.printStackTrace();
                    DebugTrace debugTrace2 = DebugTrace.a;
                    debugTrace2.a("can not parse server hello:" + e.getMessage());
                    return null;
                }
            }
            return (gt) invokeL.objValue;
        }

        @JvmStatic
        public final gt b(byte[] bArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bArr)) == null) ? a(fv.a(bArr)) : (gt) invokeL.objValue;
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1964038984, "Lcom/repackage/gt;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1964038984, "Lcom/repackage/gt;");
                return;
            }
        }
        f = new a(null);
    }

    public gt(ft ftVar, byte[] bArr, int i, byte[] bArr2, List<et> list) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {ftVar, bArr, Integer.valueOf(i), bArr2, list};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = ftVar;
        this.b = bArr;
        this.c = i;
        this.d = bArr2;
        this.e = list;
    }

    @JvmStatic
    public static final gt a(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, bArr)) == null) ? f.b(bArr) : (gt) invokeL.objValue;
    }

    public final List<et> b() {
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
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? fv.d(this.b) : (byte[]) invokeV.objValue;
    }

    public final byte[] e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? fv.d(this.d) : (byte[]) invokeV.objValue;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, obj)) == null) {
            if (this != obj) {
                if (obj instanceof gt) {
                    gt gtVar = (gt) obj;
                    if (Intrinsics.areEqual(this.a, gtVar.a) && Intrinsics.areEqual(this.b, gtVar.b)) {
                        if (!(this.c == gtVar.c) || !Intrinsics.areEqual(this.d, gtVar.d) || !Intrinsics.areEqual(this.e, gtVar.e)) {
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
            ft ftVar = this.a;
            int hashCode = (ftVar != null ? ftVar.hashCode() : 0) * 31;
            byte[] bArr = this.b;
            int hashCode2 = (((hashCode + (bArr != null ? Arrays.hashCode(bArr) : 0)) * 31) + this.c) * 31;
            byte[] bArr2 = this.d;
            int hashCode3 = (hashCode2 + (bArr2 != null ? Arrays.hashCode(bArr2) : 0)) * 31;
            List<et> list = this.e;
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
