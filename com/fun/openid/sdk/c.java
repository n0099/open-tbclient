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
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
/* loaded from: classes9.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public com.fun.openid.sdk.a f70020a = null;

    /* renamed from: b  reason: collision with root package name */
    public String f70021b = null;

    /* renamed from: c  reason: collision with root package name */
    public String f70022c = null;

    /* renamed from: d  reason: collision with root package name */
    public final Object f70023d = new Object();

    /* renamed from: e  reason: collision with root package name */
    public ServiceConnection f70024e = new a(this);

    /* loaded from: classes9.dex */
    public class a implements ServiceConnection {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f70025a;

        public a(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f70025a = cVar;
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            com.fun.openid.sdk.a c1948a;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, componentName, iBinder) == null) {
                c cVar = this.f70025a;
                int i2 = a.AbstractBinderC1947a.f70016a;
                if (iBinder == null) {
                    c1948a = null;
                } else {
                    IInterface queryLocalInterface = iBinder.queryLocalInterface("com.heytap.openid.IOpenID");
                    c1948a = (queryLocalInterface == null || !(queryLocalInterface instanceof com.fun.openid.sdk.a)) ? new a.AbstractBinderC1947a.C1948a(iBinder) : (com.fun.openid.sdk.a) queryLocalInterface;
                }
                cVar.f70020a = c1948a;
                synchronized (this.f70025a.f70023d) {
                    this.f70025a.f70023d.notify();
                }
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, componentName) == null) {
                this.f70025a.f70020a = null;
            }
        }
    }

    /* loaded from: classes9.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final c f70026a;
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
            f70026a = new c();
        }
    }

    public final String a(Context context, String str) {
        InterceptResult invokeLL;
        Signature[] signatureArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, context, str)) == null) {
            if (TextUtils.isEmpty(this.f70021b)) {
                this.f70021b = context.getPackageName();
            }
            if (TextUtils.isEmpty(this.f70022c)) {
                String str2 = null;
                try {
                    signatureArr = context.getPackageManager().getPackageInfo(this.f70021b, 64).signatures;
                } catch (PackageManager.NameNotFoundException e2) {
                    e2.printStackTrace();
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
                    } catch (NoSuchAlgorithmException e3) {
                        e3.printStackTrace();
                    }
                }
                this.f70022c = str2;
            }
            com.fun.openid.sdk.a aVar = this.f70020a;
            String str3 = this.f70021b;
            String str4 = this.f70022c;
            a.AbstractBinderC1947a.C1948a c1948a = (a.AbstractBinderC1947a.C1948a) aVar;
            c1948a.getClass();
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken("com.heytap.openid.IOpenID");
                obtain.writeString(str3);
                obtain.writeString(str4);
                obtain.writeString(str);
                c1948a.f70017a.transact(1, obtain, obtain2, 0);
                obtain2.readException();
                String readString = obtain2.readString();
                obtain2.recycle();
                obtain.recycle();
                return TextUtils.isEmpty(readString) ? "" : readString;
            } catch (Throwable th) {
                obtain2.recycle();
                obtain.recycle();
                throw th;
            }
        }
        return (String) invokeLL.objValue;
    }
}
