package d.a.q0.a.y0.k.f.c;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.retrieve.RetrieveTaskManager;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlinx.coroutines.DebugKt;
/* loaded from: classes8.dex */
public class c extends a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public String f51826b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(String str) {
        super(str);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str};
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
    }

    @Override // d.a.q0.a.y0.k.f.c.f, d.a.q0.a.y0.k.f.c.e
    public void a(String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048576, this, str, str2) == null) && e(str)) {
            boolean equals = TextUtils.equals(str2, DebugKt.DEBUG_PROPERTY_VALUE_AUTO);
            boolean equals2 = TextUtils.equals(str2, RetrieveTaskManager.KEY);
            this.f51824a.g("autoPlay", equals ? "1" : "0");
            this.f51824a.g("playMethod", equals2 ? "1" : "0");
        }
    }

    @Override // d.a.q0.a.y0.k.f.c.f, d.a.q0.a.y0.k.f.c.e
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            if (this.f51824a.d("video_will_play")) {
                this.f51824a.h("video_play_cancel");
            }
            d();
        }
    }

    public final boolean e(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) ? TextUtils.equals(this.f51826b, str) : invokeL.booleanValue;
    }
}
