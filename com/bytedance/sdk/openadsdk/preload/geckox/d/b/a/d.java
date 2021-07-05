package com.bytedance.sdk.openadsdk.preload.geckox.d.b.a;

import android.util.Pair;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.openadsdk.preload.geckox.model.UpdatePackage;
import com.bytedance.sdk.openadsdk.preload.geckox.utils.l;
import com.facebook.common.util.UriUtil;
import java.io.File;
/* loaded from: classes6.dex */
public class d extends com.bytedance.sdk.openadsdk.preload.b.d<Pair<com.bytedance.sdk.openadsdk.preload.geckox.buffer.a, UpdatePackage>, Pair<File, UpdatePackage>> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public d() {
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
    public Object a_(com.bytedance.sdk.openadsdk.preload.b.b<Pair<File, UpdatePackage>> bVar, Pair<com.bytedance.sdk.openadsdk.preload.geckox.buffer.a, UpdatePackage> pair) throws Throwable {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, bVar, pair)) == null) {
            com.bytedance.sdk.openadsdk.preload.geckox.h.b.a("gecko-debug-tag", "start unzip full zip file, channel:", ((UpdatePackage) pair.second).getChannel());
            com.bytedance.sdk.openadsdk.preload.geckox.buffer.a aVar = (com.bytedance.sdk.openadsdk.preload.geckox.buffer.a) pair.first;
            aVar.b(0L);
            UpdatePackage updatePackage = (UpdatePackage) pair.second;
            File parentFile = aVar.f().getParentFile();
            try {
                l.a(new com.bytedance.sdk.openadsdk.preload.geckox.buffer.a.a(aVar), parentFile.getAbsolutePath(), updatePackage.getChannel());
                aVar.a();
                File file = new File(parentFile, UriUtil.LOCAL_RESOURCE_SCHEME);
                com.bytedance.sdk.openadsdk.preload.geckox.utils.d.a(file);
                if (new File(parentFile, updatePackage.getChannel()).renameTo(file)) {
                    return bVar.a((com.bytedance.sdk.openadsdk.preload.b.b<Pair<File, UpdatePackage>>) new Pair<>(aVar.f(), updatePackage));
                }
                throw new RuntimeException("rename unziped full zip file failed:" + parentFile.getAbsolutePath() + ", dest:" + file.getAbsolutePath() + ", exist?" + file.exists());
            } catch (Exception e2) {
                throw new RuntimeException("unzip full zip file failed, channel:" + updatePackage.getChannel() + ", pkg id:" + updatePackage.getFullPackage().getId() + ", dir:" + parentFile.getAbsolutePath() + ", caused by:" + e2.getMessage(), e2);
            }
        }
        return invokeLL.objValue;
    }
}
