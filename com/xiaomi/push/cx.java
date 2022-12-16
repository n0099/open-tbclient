package com.xiaomi.push;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes8.dex */
public class cx extends cr {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public cr a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ cv f221a;
    public final /* synthetic */ cr b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public cx(cv cvVar, String str, cr crVar) {
        super(str);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {cvVar, str, crVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((String) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f221a = cvVar;
        this.b = crVar;
        cr crVar2 = this.b;
        this.a = crVar2;
        ((cr) this).f207b = ((cr) this).f207b;
        if (crVar2 != null) {
            this.f = crVar2.f;
        }
    }

    @Override // com.xiaomi.push.cr
    public synchronized ArrayList<String> a(boolean z) {
        InterceptResult invokeZ;
        ArrayList<String> arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048576, this, z)) == null) {
            synchronized (this) {
                arrayList = new ArrayList<>();
                if (this.a != null) {
                    arrayList.addAll(this.a.a(true));
                }
                synchronized (cv.b) {
                    cr crVar = cv.b.get(((cr) this).f207b);
                    if (crVar != null) {
                        Iterator<String> it = crVar.a(true).iterator();
                        while (it.hasNext()) {
                            String next = it.next();
                            if (arrayList.indexOf(next) == -1) {
                                arrayList.add(next);
                            }
                        }
                        arrayList.remove(((cr) this).f207b);
                        arrayList.add(((cr) this).f207b);
                    }
                }
            }
            return arrayList;
        }
        return (ArrayList) invokeZ.objValue;
    }

    @Override // com.xiaomi.push.cr
    public synchronized void a(String str, cq cqVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, cqVar) == null) {
            synchronized (this) {
                if (this.a != null) {
                    this.a.a(str, cqVar);
                }
            }
        }
    }

    @Override // com.xiaomi.push.cr
    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }
}
