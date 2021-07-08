package d.n.a.a.c.b;

import android.content.Context;
import android.os.Build;
import android.os.Parcel;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public final class i {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public /* synthetic */ g f72192a;

    public i(g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {gVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f72192a = gVar;
    }

    public final String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? b("TRANSACTION_getDeviceId", "iphonesubinfo") : (String) invokeV.objValue;
    }

    public final String b(String str, String str2) {
        InterceptResult invokeLL;
        String f2;
        Parcel c2;
        Context context;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2)) == null) {
            String str3 = "";
            if (Build.VERSION.SDK_INT >= 29) {
                return "";
            }
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            f2 = this.f72192a.f(str2);
            if (TextUtils.isEmpty(f2)) {
                return "";
            }
            obtain.writeInterfaceToken(f2);
            if (Build.VERSION.SDK_INT >= 23) {
                context = g.f72188c;
                obtain.writeString(context.getPackageName());
            }
            c2 = this.f72192a.c(str2, str, obtain, obtain2);
            if (c2 != null) {
                try {
                    obtain2.readException();
                    str3 = obtain2.readString();
                } catch (SecurityException unused) {
                    return "";
                }
            }
            obtain2.recycle();
            obtain.recycle();
            return str3;
        }
        return (String) invokeLL.objValue;
    }

    public final String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? b("TRANSACTION_getIccSerialNumber", "iphonesubinfo") : (String) invokeV.objValue;
    }
}
