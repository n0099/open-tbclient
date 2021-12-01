package com.kwad.jni;

import androidx.annotation.Keep;
import androidx.annotation.Nullable;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Iterator;
import java.util.Map;
@Keep
/* loaded from: classes2.dex */
public class MapIteratorHelper {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @Keep
    public final Iterator<Map.Entry> mIterator;
    @Nullable
    @Keep
    public Object mKey;
    @Nullable
    @Keep
    public Object mValue;

    @Keep
    public MapIteratorHelper(Map map) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {map};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mIterator = map.entrySet().iterator();
    }

    @Keep
    public boolean hasNext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (!this.mIterator.hasNext()) {
                this.mKey = null;
                this.mValue = null;
                return false;
            }
            Map.Entry next = this.mIterator.next();
            this.mKey = next.getKey();
            this.mValue = next.getValue();
            return true;
        }
        return invokeV.booleanValue;
    }
}
