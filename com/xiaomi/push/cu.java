package com.xiaomi.push;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes10.dex */
public class cu extends co {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public co f77813a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ cs f212a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ co f77814b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public cu(cs csVar, String str, co coVar) {
        super(str);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {csVar, str, coVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((String) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f212a = csVar;
        this.f77814b = coVar;
        co coVar2 = this.f77814b;
        this.f77813a = coVar2;
        ((co) this).f198b = ((co) this).f198b;
        if (coVar2 != null) {
            this.f77801f = coVar2.f77801f;
        }
    }

    @Override // com.xiaomi.push.co
    public synchronized ArrayList<String> a(boolean z) {
        InterceptResult invokeZ;
        ArrayList<String> arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048576, this, z)) == null) {
            synchronized (this) {
                arrayList = new ArrayList<>();
                if (this.f77813a != null) {
                    arrayList.addAll(this.f77813a.a(true));
                }
                synchronized (cs.f77809b) {
                    co coVar = cs.f77809b.get(((co) this).f198b);
                    if (coVar != null) {
                        Iterator<String> it = coVar.a(true).iterator();
                        while (it.hasNext()) {
                            String next = it.next();
                            if (arrayList.indexOf(next) == -1) {
                                arrayList.add(next);
                            }
                        }
                        arrayList.remove(((co) this).f198b);
                        arrayList.add(((co) this).f198b);
                    }
                }
            }
            return arrayList;
        }
        return (ArrayList) invokeZ.objValue;
    }

    @Override // com.xiaomi.push.co
    public synchronized void a(String str, cn cnVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, cnVar) == null) {
            synchronized (this) {
                if (this.f77813a != null) {
                    this.f77813a.a(str, cnVar);
                }
            }
        }
    }

    @Override // com.xiaomi.push.co
    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }
}
