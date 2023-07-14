package com.fun.openid.sdk;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.fun.openid.sdk.a;
import com.heytap.openid.IOpenID;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
/* loaded from: classes9.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public com.fun.openid.sdk.a a = null;
    public String b = null;
    public String c = null;
    public final Object d = new Object();
    public ServiceConnection e = new a(this);

    /* loaded from: classes9.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public static final c a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-2005111121, "Lcom/fun/openid/sdk/c$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-2005111121, "Lcom/fun/openid/sdk/c$b;");
                    return;
                }
            }
            a = new c();
        }
    }

    /* loaded from: classes9.dex */
    public class a implements ServiceConnection {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c a;

        public a(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cVar;
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, componentName) == null) {
                this.a.a = null;
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            com.fun.openid.sdk.a c0583a;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, componentName, iBinder) == null) {
                c cVar = this.a;
                int i = a.AbstractBinderC0582a.a;
                if (iBinder == null) {
                    c0583a = null;
                } else {
                    IInterface queryLocalInterface = iBinder.queryLocalInterface(IOpenID.Stub.DESCRIPTOR);
                    if (queryLocalInterface != null && (queryLocalInterface instanceof com.fun.openid.sdk.a)) {
                        c0583a = (com.fun.openid.sdk.a) queryLocalInterface;
                    } else {
                        c0583a = new a.AbstractBinderC0582a.C0583a(iBinder);
                    }
                }
                cVar.a = c0583a;
                synchronized (this.a.d) {
                    this.a.d.notify();
                }
            }
        }
    }

    public final String a(Context context, String str) {
        InterceptResult invokeLL;
        Signature[] signatureArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, context, str)) == null) {
            if (TextUtils.isEmpty(this.b)) {
                this.b = context.getPackageName();
            }
            if (TextUtils.isEmpty(this.c)) {
                String str2 = null;
                try {
                    signatureArr = context.getPackageManager().getPackageInfo(this.b, 64).signatures;
                } catch (PackageManager.NameNotFoundException e) {
                    e.printStackTrace();
                    signatureArr = null;
                }
                if (signatureArr != null && signatureArr.length > 0) {
                    byte[] byteArray = signatureArr[0].toByteArray();
                    try {
                        MessageDigest messageDigest = MessageDigest.getInstance("SHA1");
                        if (messageDigest != null) {
                            byte[] digest = messageDigest.digest(byteArray);
                            StringBuilder sb = new StringBuilder();
                            for (byte b2 : digest) {
                                sb.append(Integer.toHexString((b2 & 255) | 256).substring(1, 3));
                            }
                            str2 = sb.toString();
                        }
                    } catch (NoSuchAlgorithmException e2) {
                        e2.printStackTrace();
                    }
                }
                this.c = str2;
            }
            com.fun.openid.sdk.a aVar = this.a;
            String str3 = this.b;
            String str4 = this.c;
            a.AbstractBinderC0582a.C0583a c0583a = (a.AbstractBinderC0582a.C0583a) aVar;
            c0583a.getClass();
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken(IOpenID.Stub.DESCRIPTOR);
                obtain.writeString(str3);
                obtain.writeString(str4);
                obtain.writeString(str);
                c0583a.a.transact(1, obtain, obtain2, 0);
                obtain2.readException();
                String readString = obtain2.readString();
                obtain2.recycle();
                obtain.recycle();
                if (TextUtils.isEmpty(readString)) {
                    return "";
                }
                return readString;
            } catch (Throwable th) {
                obtain2.recycle();
                obtain.recycle();
                throw th;
            }
        }
        return (String) invokeLL.objValue;
    }
}
