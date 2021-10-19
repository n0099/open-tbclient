package com.bytedance.sdk.openadsdk.preload.geckox.d.a.b;

import android.net.Uri;
import android.util.Pair;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.openadsdk.preload.geckox.model.UpdatePackage;
import java.io.File;
/* loaded from: classes9.dex */
public class c extends com.bytedance.sdk.openadsdk.preload.b.d<Pair<Uri, UpdatePackage>, Pair<com.bytedance.sdk.openadsdk.preload.geckox.buffer.a, UpdatePackage>> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: d  reason: collision with root package name */
    public com.bytedance.sdk.openadsdk.preload.geckox.b f69066d;

    /* renamed from: e  reason: collision with root package name */
    public File f69067e;

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

    @Override // com.bytedance.sdk.openadsdk.preload.b.d
    public void a(Object... objArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, objArr) == null) {
            super.a(objArr);
            this.f69066d = (com.bytedance.sdk.openadsdk.preload.geckox.b) objArr[0];
            this.f69067e = (File) objArr[1];
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.bytedance.sdk.openadsdk.preload.b.d
    /* renamed from: a */
    public Object a_(com.bytedance.sdk.openadsdk.preload.b.b<Pair<com.bytedance.sdk.openadsdk.preload.geckox.buffer.a, UpdatePackage>> bVar, Pair<Uri, UpdatePackage> pair) throws Throwable {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, bVar, pair)) == null) {
            com.bytedance.sdk.openadsdk.preload.geckox.h.b.a("gecko-debug-tag", "start download patch single file, channel:", ((UpdatePackage) pair.second).getChannel());
            UpdatePackage updatePackage = (UpdatePackage) pair.second;
            String uri = ((Uri) pair.first).toString();
            long length = updatePackage.getPatch().getLength();
            File file = this.f69067e;
            File file2 = new File(file, updatePackage.getAccessKey() + File.separator + updatePackage.getChannel() + File.separator + updatePackage.getVersion() + "--updating");
            file2.mkdirs();
            com.bytedance.sdk.openadsdk.preload.geckox.buffer.a a2 = com.bytedance.sdk.openadsdk.preload.geckox.buffer.impl.a.a(this.f69066d.a(), new File(file2, "patch.tmp"), length);
            try {
                this.f69066d.h().a(uri, length, new com.bytedance.sdk.openadsdk.preload.geckox.buffer.a.b(a2));
                try {
                    return bVar.a((com.bytedance.sdk.openadsdk.preload.b.b<Pair<com.bytedance.sdk.openadsdk.preload.geckox.buffer.a, UpdatePackage>>) new Pair<>(a2, updatePackage));
                } finally {
                    a2.e();
                }
            } catch (Throwable th) {
                a2.e();
                throw new com.bytedance.sdk.openadsdk.preload.geckox.b.a("download patch single file failed, url:" + uri + ", channel:" + updatePackage.getChannel() + ", pkg id:" + updatePackage.getPatch().getId() + ", caused by:" + th.getMessage(), th);
            }
        }
        return invokeLL.objValue;
    }
}
