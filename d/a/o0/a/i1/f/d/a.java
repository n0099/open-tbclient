package d.a.o0.a.i1.f.d;

import android.telephony.PhoneStateListener;
import android.util.Log;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.o0.a.k;
/* loaded from: classes7.dex */
public class a extends PhoneStateListener {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f46076a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(219021310, "Ld/a/o0/a/i1/f/d/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(219021310, "Ld/a/o0/a/i1/f/d/a;");
                return;
            }
        }
        f46076a = k.f46335a;
    }

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    @Override // android.telephony.PhoneStateListener
    public void onCallStateChanged(int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048576, this, i2, str) == null) {
            super.onCallStateChanged(i2, str);
            if (i2 == 0) {
                d.a.o0.a.i1.f.e.a.k().o();
                if (f46076a) {
                    Log.i("PhoneStateListener", "挂断");
                }
            } else if (i2 == 1) {
                d.a.o0.a.i1.f.e.a.k().n();
                if (f46076a) {
                    Log.i("PhoneStateListener", "响铃:" + str);
                }
            } else if (i2 != 2) {
                if (f46076a) {
                    Log.e("PhoneStateListener", "invalid state");
                }
            } else {
                d.a.o0.a.i1.f.e.a.k().n();
                if (f46076a) {
                    Log.i("PhoneStateListener", "接听");
                }
            }
        }
    }
}
