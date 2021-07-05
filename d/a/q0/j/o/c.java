package d.a.q0.j.o;

import com.baidu.mapapi.search.core.PoiInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public PoiInfo f53821a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f53822b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f53823c;

    public c(PoiInfo poiInfo, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {poiInfo, Boolean.valueOf(z), Boolean.valueOf(z2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        if (poiInfo == null) {
            this.f53821a = new PoiInfo();
        }
        this.f53821a = poiInfo;
        this.f53822b = z;
        this.f53823c = z2;
    }

    public static List<c> a(List<PoiInfo> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, list)) == null) {
            if (list != null && list.size() > 0) {
                ArrayList arrayList = new ArrayList(list.size());
                for (PoiInfo poiInfo : list) {
                    if (poiInfo.location != null) {
                        arrayList.add(new c(poiInfo));
                    }
                }
                return arrayList;
            }
            return new ArrayList();
        }
        return (List) invokeL.objValue;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public c(PoiInfo poiInfo) {
        this(poiInfo, false, false);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {poiInfo};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((PoiInfo) objArr2[0], ((Boolean) objArr2[1]).booleanValue(), ((Boolean) objArr2[2]).booleanValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }
}
