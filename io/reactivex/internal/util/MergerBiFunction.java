package io.reactivex.internal.util;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import io.reactivex.functions.BiFunction;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes8.dex */
public final class MergerBiFunction implements BiFunction {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Comparator comparator;

    public MergerBiFunction(Comparator comparator) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {comparator};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.comparator = comparator;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0078  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0057 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0047 A[SYNTHETIC] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:15:0x003a -> B:16:0x003b). Please submit an issue!!! */
    @Override // io.reactivex.functions.BiFunction
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public List apply(List list, List list2) throws Exception {
        InterceptResult invokeLL;
        Object obj;
        Object obj2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list, list2)) == null) {
            int size = list.size() + list2.size();
            if (size == 0) {
                return new ArrayList();
            }
            ArrayList arrayList = new ArrayList(size);
            Iterator it = list.iterator();
            Iterator it2 = list2.iterator();
            if (it.hasNext()) {
                obj = it.next();
            } else {
                obj = null;
            }
            if (it2.hasNext()) {
                obj2 = it2.next();
                while (obj != null && obj2 != null) {
                    if (this.comparator.compare(obj, obj2) >= 0) {
                        arrayList.add(obj);
                        if (it.hasNext()) {
                            obj = it.next();
                        } else {
                            obj = null;
                        }
                    } else {
                        arrayList.add(obj2);
                        if (it2.hasNext()) {
                            obj2 = it2.next();
                        }
                    }
                }
                if (obj == null) {
                    arrayList.add(obj);
                    while (it.hasNext()) {
                        arrayList.add(it.next());
                    }
                } else {
                    arrayList.add(obj2);
                    while (it2.hasNext()) {
                        arrayList.add(it2.next());
                    }
                }
                return arrayList;
            }
            obj2 = null;
            while (obj != null) {
                if (this.comparator.compare(obj, obj2) >= 0) {
                }
            }
            if (obj == null) {
            }
            return arrayList;
        }
        return (List) invokeLL.objValue;
    }
}
