package com.xiaomi.push;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.xiaomi.push.al;
import com.xiaomi.push.db;
/* loaded from: classes10.dex */
public class dd extends al.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public al.b f77295a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ db f234a;

    public dd(db dbVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {dbVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f234a = dbVar;
    }

    @Override // com.xiaomi.push.al.b
    public void b() {
        db.b bVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (bVar = (db.b) this.f234a.f222a.peek()) != null && bVar.a()) {
            if (this.f234a.f222a.remove(bVar)) {
                this.f77295a = bVar;
            }
            al.b bVar2 = this.f77295a;
            if (bVar2 != null) {
                bVar2.b();
            }
        }
    }

    @Override // com.xiaomi.push.al.b
    /* renamed from: c */
    public void mo245c() {
        al.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (bVar = this.f77295a) == null) {
            return;
        }
        bVar.mo245c();
    }
}
