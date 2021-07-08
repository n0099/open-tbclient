package com.bytedance.sdk.openadsdk.preload.geckox.a.a;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.util.List;
/* loaded from: classes5.dex */
public class e extends b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public e() {
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

    @Override // com.bytedance.sdk.openadsdk.preload.geckox.a.a.b
    public void a(a aVar, File file, List<String> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar, file, list) == null) {
            super.a(aVar, file, list);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.preload.geckox.a.a.b
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            for (String str : this.f32133f) {
                List<File> b2 = com.bytedance.sdk.openadsdk.preload.geckox.utils.d.b(new File(this.f32132e, str));
                if (b2 != null && b2.size() > this.f32131d.b()) {
                    for (File file : b2.subList(0, b2.size() - this.f32131d.b())) {
                        boolean b3 = com.bytedance.sdk.openadsdk.preload.geckox.a.c.b(file.getAbsolutePath());
                        if (this.f32131d.c() != null) {
                            this.f32131d.c().a(file.getName(), b3);
                        }
                    }
                }
            }
        }
    }
}
