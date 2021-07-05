package com.kwad.sdk.glide.e;

import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.glide.load.ImageHeaderParser;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public final class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final List<ImageHeaderParser> f37685a;

    public b() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f37685a = new ArrayList();
    }

    @NonNull
    public synchronized List<ImageHeaderParser> a() {
        InterceptResult invokeV;
        List<ImageHeaderParser> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            synchronized (this) {
                list = this.f37685a;
            }
            return list;
        }
        return (List) invokeV.objValue;
    }

    public synchronized void a(@NonNull ImageHeaderParser imageHeaderParser) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, imageHeaderParser) == null) {
            synchronized (this) {
                this.f37685a.add(imageHeaderParser);
            }
        }
    }
}
