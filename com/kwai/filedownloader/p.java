package com.kwai.filedownloader;

import android.os.IBinder;
import android.os.RemoteException;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwai.filedownloader.b.a;
import com.kwai.filedownloader.b.b;
import com.kwai.filedownloader.message.MessageSnapshot;
/* loaded from: classes5.dex */
public class p extends com.kwai.filedownloader.services.a<a, com.kwai.filedownloader.b.b> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public static class a extends a.AbstractBinderC0361a {
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

        @Override // com.kwai.filedownloader.b.a
        public void a(MessageSnapshot messageSnapshot) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, messageSnapshot) == null) {
                com.kwai.filedownloader.message.e.a().a(messageSnapshot);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public p(Class<?> cls) {
        super(cls);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {cls};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Class) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwai.filedownloader.services.a
    /* renamed from: a */
    public com.kwai.filedownloader.b.b b(IBinder iBinder) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, iBinder)) == null) ? b.a.a(iBinder) : (com.kwai.filedownloader.b.b) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwai.filedownloader.services.a
    /* renamed from: a */
    public a b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? new a() : (a) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwai.filedownloader.services.a
    /* renamed from: a  reason: avoid collision after fix types in other method */
    public void b(com.kwai.filedownloader.b.b bVar, a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, bVar, aVar) == null) {
            bVar.a(aVar);
        }
    }

    @Override // com.kwai.filedownloader.u
    public boolean a(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i)) == null) {
            if (c()) {
                try {
                    return d().a(i);
                } catch (RemoteException e) {
                    e.printStackTrace();
                    return false;
                }
            }
            return com.kwai.filedownloader.e.a.a(i);
        }
        return invokeI.booleanValue;
    }

    @Override // com.kwai.filedownloader.u
    public boolean a(String str, String str2, boolean z, int i, int i2, int i3, boolean z2, com.kwai.filedownloader.c.b bVar, boolean z3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048581, this, new Object[]{str, str2, Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z2), bVar, Boolean.valueOf(z3)})) == null) {
            if (c()) {
                try {
                    d().a(str, str2, z, i, i2, i3, z2, bVar, z3);
                    return true;
                } catch (RemoteException e) {
                    e.printStackTrace();
                    return false;
                }
            }
            return com.kwai.filedownloader.e.a.a(str, str2, z);
        }
        return invokeCommon.booleanValue;
    }

    @Override // com.kwai.filedownloader.u
    public byte b(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i)) == null) {
            if (c()) {
                try {
                    return d().e(i);
                } catch (RemoteException e) {
                    e.printStackTrace();
                    return (byte) 0;
                }
            }
            return com.kwai.filedownloader.e.a.b(i);
        }
        return invokeI.byteValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwai.filedownloader.services.a
    /* renamed from: b  reason: avoid collision after fix types in other method */
    public void a(com.kwai.filedownloader.b.b bVar, a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048586, this, bVar, aVar) == null) {
            bVar.b(aVar);
        }
    }

    @Override // com.kwai.filedownloader.u
    public boolean c(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048587, this, i)) == null) {
            if (c()) {
                try {
                    return d().f(i);
                } catch (RemoteException e) {
                    e.printStackTrace();
                    return false;
                }
            }
            return com.kwai.filedownloader.e.a.c(i);
        }
        return invokeI.booleanValue;
    }
}
