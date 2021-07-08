package d.l.a.e.a.a;

import android.content.Context;
import android.util.Log;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public abstract class a implements e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final Context f71568a;

    /* renamed from: b  reason: collision with root package name */
    public final d.l.a.e.b.j.a f71569b;

    /* renamed from: c  reason: collision with root package name */
    public final String f71570c;

    public a(Context context, d.l.a.e.b.j.a aVar, String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, aVar, str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f71568a = context;
        this.f71569b = aVar;
        this.f71570c = str;
    }

    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (this.f71568a == null) {
                return false;
            }
            try {
            } catch (Throwable th) {
                if (d.l.a.e.b.c.a.e()) {
                    Log.e("AbsDevicePlan", "check is valid failed!", th);
                }
            }
            return b().resolveActivity(this.f71568a.getPackageManager()) != null;
        }
        return invokeV.booleanValue;
    }
}
