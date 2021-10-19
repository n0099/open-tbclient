package com.bytedance.sdk.openadsdk.preload.geckox.d.a.b;

import android.util.Pair;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.openadsdk.preload.geckox.model.UpdatePackage;
import com.bytedance.sdk.openadsdk.preload.geckox.utils.BsPatch;
import com.facebook.common.util.UriUtil;
import java.io.File;
/* loaded from: classes9.dex */
public class d extends com.bytedance.sdk.openadsdk.preload.b.d<Pair<com.bytedance.sdk.openadsdk.preload.geckox.buffer.a, UpdatePackage>, Pair<com.bytedance.sdk.openadsdk.preload.geckox.buffer.a, UpdatePackage>> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: d  reason: collision with root package name */
    public com.bytedance.sdk.openadsdk.preload.geckox.b f69068d;

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

    @Override // com.bytedance.sdk.openadsdk.preload.b.d
    public void a(Object... objArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, objArr) == null) {
            super.a(objArr);
            this.f69068d = (com.bytedance.sdk.openadsdk.preload.geckox.b) objArr[0];
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.bytedance.sdk.openadsdk.preload.b.d
    /* renamed from: a */
    public Object a_(com.bytedance.sdk.openadsdk.preload.b.b<Pair<com.bytedance.sdk.openadsdk.preload.geckox.buffer.a, UpdatePackage>> bVar, Pair<com.bytedance.sdk.openadsdk.preload.geckox.buffer.a, UpdatePackage> pair) throws Throwable {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, bVar, pair)) == null) {
            com.bytedance.sdk.openadsdk.preload.geckox.h.b.a("gecko-debug-tag", "start merge patch single file, channel:", ((UpdatePackage) pair.second).getChannel());
            com.bytedance.sdk.openadsdk.preload.geckox.buffer.a aVar = (com.bytedance.sdk.openadsdk.preload.geckox.buffer.a) pair.first;
            File f2 = aVar.f();
            aVar.a();
            aVar.e();
            File parentFile = f2.getParentFile().getParentFile();
            UpdatePackage updatePackage = (UpdatePackage) pair.second;
            File file = new File(parentFile, updatePackage.getLocalVersion() + File.separator + UriUtil.LOCAL_RESOURCE_SCHEME);
            File[] listFiles = file.listFiles();
            if (listFiles != null && listFiles.length != 0) {
                File file2 = listFiles[0];
                File parentFile2 = f2.getParentFile();
                File file3 = new File(parentFile2, UriUtil.LOCAL_RESOURCE_SCHEME + File.separator + com.bytedance.sdk.openadsdk.preload.geckox.d.a.a.b.a(updatePackage, updatePackage.getFullPackage().getUrlList().get(0)));
                com.bytedance.sdk.openadsdk.preload.geckox.utils.d.a(file3);
                try {
                    try {
                        BsPatch.a(file2, f2, file3.getParentFile(), file3.getName());
                        com.bytedance.sdk.openadsdk.preload.geckox.utils.d.a(f2);
                        com.bytedance.sdk.openadsdk.preload.geckox.buffer.a a2 = com.bytedance.sdk.openadsdk.preload.geckox.buffer.impl.a.a(this.f69068d.a(), file3, file3.length());
                        try {
                            return bVar.a((com.bytedance.sdk.openadsdk.preload.b.b<Pair<com.bytedance.sdk.openadsdk.preload.geckox.buffer.a, UpdatePackage>>) new Pair<>(a2, updatePackage));
                        } finally {
                            a2.e();
                        }
                    } catch (Throwable th) {
                        com.bytedance.sdk.openadsdk.preload.geckox.utils.d.a(f2);
                        throw th;
                    }
                } catch (Exception e2) {
                    throw new RuntimeException("merge patch single file failed, channel：" + updatePackage.getChannel() + ", pkg id:" + updatePackage.getPatch().getId() + ", caused by:" + e2.getMessage(), e2);
                }
            }
            throw new RuntimeException("can not found old full single file,:" + file.getAbsolutePath());
        }
        return invokeLL.objValue;
    }
}
