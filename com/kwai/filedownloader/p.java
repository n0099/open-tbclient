package com.kwai.filedownloader;

import android.os.IBinder;
import android.os.RemoteException;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwai.filedownloader.b.a;
import com.kwai.filedownloader.b.b;
import com.kwai.filedownloader.message.MessageSnapshot;
/* loaded from: classes5.dex */
public final class p extends com.kwai.filedownloader.services.a<a, com.kwai.filedownloader.b.b> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public static class a extends a.AbstractBinderC0558a {
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
        public final void a(MessageSnapshot messageSnapshot) {
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

    /* renamed from: a  reason: avoid collision after fix types in other method */
    public static void a2(com.kwai.filedownloader.b.b bVar, a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, bVar, aVar) == null) {
            bVar.a(aVar);
        }
    }

    public static com.kwai.filedownloader.b.b b(IBinder iBinder) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, iBinder)) == null) ? b.a.a(iBinder) : (com.kwai.filedownloader.b.b) invokeL.objValue;
    }

    public static a d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? new a() : (a) invokeV.objValue;
    }

    /* JADX DEBUG: Return type fixed from 'android.os.Binder' to match base method */
    @Override // com.kwai.filedownloader.services.a
    public final /* synthetic */ a a() {
        return d();
    }

    /* JADX DEBUG: Return type fixed from 'android.os.IInterface' to match base method */
    @Override // com.kwai.filedownloader.services.a
    public final /* synthetic */ com.kwai.filedownloader.b.b a(IBinder iBinder) {
        return b(iBinder);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.os.IInterface, android.os.Binder] */
    @Override // com.kwai.filedownloader.services.a
    public final /* bridge */ /* synthetic */ void a(com.kwai.filedownloader.b.b bVar, a aVar) {
        a2(bVar, aVar);
    }

    @Override // com.kwai.filedownloader.u
    public final boolean a(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i)) == null) {
            if (c()) {
                try {
                    return b().a(i);
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
    public final boolean a(String str, String str2, boolean z, int i, int i2, int i3, boolean z2, com.kwai.filedownloader.c.b bVar, boolean z3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{str, str2, Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z2), bVar, Boolean.valueOf(z3)})) == null) {
            if (c()) {
                try {
                    b().a(str, str2, z, i, i2, i3, z2, bVar, z3);
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
    public final byte b(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i)) == null) {
            if (c()) {
                try {
                    return b().e(i);
                } catch (RemoteException e) {
                    e.printStackTrace();
                    return (byte) 0;
                }
            }
            return com.kwai.filedownloader.e.a.b(i);
        }
        return invokeI.byteValue;
    }

    @Override // com.kwai.filedownloader.u
    public final boolean c(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i)) == null) {
            if (c()) {
                try {
                    return b().f(i);
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
