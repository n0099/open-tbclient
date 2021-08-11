package com.bytedance.sdk.openadsdk.preload.geckox.d.a.a;

import android.util.Pair;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.openadsdk.preload.b.d;
import com.bytedance.sdk.openadsdk.preload.geckox.model.UpdatePackage;
import java.io.File;
/* loaded from: classes9.dex */
public class c extends d<Pair<File, UpdatePackage>, Pair<String, Long>> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public c() {
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

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.bytedance.sdk.openadsdk.preload.b.d
    /* renamed from: a */
    public Object a_(com.bytedance.sdk.openadsdk.preload.b.b<Pair<String, Long>> bVar, Pair<File, UpdatePackage> pair) throws Throwable {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, bVar, pair)) == null) {
            com.bytedance.sdk.openadsdk.preload.geckox.h.b.a("gecko-debug-tag", "start active full single file, channel:", ((UpdatePackage) pair.second).getChannel());
            File parentFile = ((File) pair.first).getParentFile().getParentFile();
            long version = ((UpdatePackage) pair.second).getVersion();
            File parentFile2 = parentFile.getParentFile();
            File file = new File(parentFile2, version + "");
            com.bytedance.sdk.openadsdk.preload.geckox.utils.d.a(file);
            if (parentFile.renameTo(file)) {
                return bVar.a((com.bytedance.sdk.openadsdk.preload.b.b<Pair<String, Long>>) new Pair<>(((UpdatePackage) pair.second).getChannel(), Long.valueOf(version)));
            }
            throw new RuntimeException("active full single file failed: " + parentFile.getAbsolutePath());
        }
        return invokeLL.objValue;
    }
}
