package com.xiaomi.push;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import java.util.Iterator;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class cx implements Comparable<cx> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f40229a;

    /* renamed from: a  reason: collision with other field name */
    public long f209a;

    /* renamed from: a  reason: collision with other field name */
    public String f210a;

    /* renamed from: a  reason: collision with other field name */
    public final LinkedList<cn> f211a;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public cx() {
        this(null, 0);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr = newInitContext.callArgs;
                this((String) objArr[0], ((Integer) objArr[1]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public cx(String str) {
        this(str, 0);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((String) objArr2[0], ((Integer) objArr2[1]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public cx(String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.f211a = new LinkedList<>();
        this.f209a = 0L;
        this.f210a = str;
        this.f40229a = i2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(cx cxVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, cxVar)) == null) {
            if (cxVar == null) {
                return 1;
            }
            return cxVar.f40229a - this.f40229a;
        }
        return invokeL.intValue;
    }

    public synchronized cx a(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONObject)) == null) {
            synchronized (this) {
                this.f209a = jSONObject.getLong(PushConstants.PUSH_NOTIFICATION_CREATE_TIMES_TAMP);
                this.f40229a = jSONObject.getInt("wt");
                this.f210a = jSONObject.getString("host");
                JSONArray jSONArray = jSONObject.getJSONArray("ah");
                for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                    this.f211a.add(new cn().a(jSONArray.getJSONObject(i2)));
                }
            }
            return this;
        }
        return (cx) invokeL.objValue;
    }

    public synchronized JSONObject a() {
        InterceptResult invokeV;
        JSONObject jSONObject;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            synchronized (this) {
                jSONObject = new JSONObject();
                jSONObject.put(PushConstants.PUSH_NOTIFICATION_CREATE_TIMES_TAMP, this.f209a);
                jSONObject.put("wt", this.f40229a);
                jSONObject.put("host", this.f210a);
                JSONArray jSONArray = new JSONArray();
                Iterator<cn> it = this.f211a.iterator();
                while (it.hasNext()) {
                    jSONArray.put(it.next().m218a());
                }
                jSONObject.put("ah", jSONArray);
            }
            return jSONObject;
        }
        return (JSONObject) invokeV.objValue;
    }

    public synchronized void a(cn cnVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, cnVar) == null) {
            synchronized (this) {
                if (cnVar != null) {
                    this.f211a.add(cnVar);
                    int a2 = cnVar.a();
                    if (a2 > 0) {
                        this.f40229a += cnVar.a();
                    } else {
                        int i2 = 0;
                        for (int size = this.f211a.size() - 1; size >= 0 && this.f211a.get(size).a() < 0; size--) {
                            i2++;
                        }
                        this.f40229a += a2 * i2;
                    }
                    if (this.f211a.size() > 30) {
                        this.f40229a -= this.f211a.remove().a();
                    }
                }
            }
        }
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.f210a + ":" + this.f40229a;
        }
        return (String) invokeV.objValue;
    }
}
