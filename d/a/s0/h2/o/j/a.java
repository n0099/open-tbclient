package d.a.s0.h2.o.j;

import androidx.annotation.Nullable;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.r0.s.c.f;
import tbclient.PbPage.FloatingIconItem;
/* loaded from: classes9.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public FloatingIconItem f61093a;

    /* renamed from: b  reason: collision with root package name */
    public f f61094b;

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Nullable
    public String a(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048576, this, z)) == null) {
            if (z) {
                FloatingIconItem floatingIconItem = this.f61093a;
                if (floatingIconItem != null) {
                    return floatingIconItem.icon_url;
                }
                return null;
            }
            f fVar = this.f61094b;
            if (fVar != null) {
                return fVar.c();
            }
            return null;
        }
        return (String) invokeZ.objValue;
    }

    @Nullable
    public String b(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z)) == null) {
            if (z) {
                FloatingIconItem floatingIconItem = this.f61093a;
                if (floatingIconItem != null) {
                    return floatingIconItem.url;
                }
                return null;
            }
            f fVar = this.f61094b;
            if (fVar != null) {
                return fVar.d();
            }
            return null;
        }
        return (String) invokeZ.objValue;
    }

    public boolean c(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z)) == null) {
            if (z) {
                FloatingIconItem floatingIconItem = this.f61093a;
                return (floatingIconItem == null || StringUtils.isNull(floatingIconItem.icon_url) || StringUtils.isNull(this.f61093a.url)) ? false : true;
            }
            f fVar = this.f61094b;
            return (fVar == null || StringUtils.isNull(fVar.c()) || StringUtils.isNull(this.f61094b.d())) ? false : true;
        }
        return invokeZ.booleanValue;
    }

    public void d(f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, fVar) == null) {
            this.f61094b = fVar;
        }
    }

    public void e(FloatingIconItem floatingIconItem) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, floatingIconItem) == null) {
            this.f61093a = floatingIconItem;
        }
    }
}
