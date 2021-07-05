package d.n.a.a.c.b;

import android.os.Build;
import android.os.Parcel;
import android.text.TextUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.reflect.Field;
/* loaded from: classes10.dex */
public final class i {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public /* synthetic */ f f75157a;

    public i(f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {fVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f75157a = fVar;
    }

    public final String a() {
        InterceptResult invokeV;
        String f2;
        Parcel c2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            String str = "";
            if (Build.VERSION.SDK_INT >= 29) {
                return "";
            }
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            f2 = this.f75157a.f("wifi");
            if (TextUtils.isEmpty(f2)) {
                return "";
            }
            obtain.writeInterfaceToken(f2);
            c2 = this.f75157a.c("wifi", "TRANSACTION_getConnectionInfo", obtain, obtain2);
            if (c2 != null) {
                try {
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        try {
                            Class<?> cls = Class.forName("android.net.wifi.WifiInfo");
                            Object obj = cls.getDeclaredField("CREATOR").get(cls);
                            Object invoke = obj.getClass().getMethod("createFromParcel", Parcel.class).invoke(obj, obtain2);
                            Field declaredField = cls.getDeclaredField("mMacAddress");
                            declaredField.setAccessible(true);
                            str = (String) declaredField.get(invoke);
                        } catch (Throwable th) {
                            b.c(th);
                        }
                    }
                } catch (SecurityException unused) {
                    return "";
                }
            }
            obtain2.recycle();
            obtain.recycle();
            return str;
        }
        return (String) invokeV.objValue;
    }
}
