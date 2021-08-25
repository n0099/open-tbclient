package com.bytedance.sdk.openadsdk.preload.geckox.d.a.a;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Pair;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.openadsdk.preload.b.d;
import com.bytedance.sdk.openadsdk.preload.geckox.model.UpdatePackage;
import com.facebook.common.util.UriUtil;
import java.io.File;
/* loaded from: classes9.dex */
public class b extends d<Pair<Uri, UpdatePackage>, Pair<com.bytedance.sdk.openadsdk.preload.geckox.buffer.a, UpdatePackage>> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: d  reason: collision with root package name */
    public com.bytedance.sdk.openadsdk.preload.geckox.b f68538d;

    /* renamed from: e  reason: collision with root package name */
    public File f68539e;

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
            }
        }
    }

    public static String a(UpdatePackage updatePackage, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, updatePackage, str)) == null) {
            if (!TextUtils.isEmpty(str)) {
                int lastIndexOf = str.lastIndexOf("/");
                if (lastIndexOf != -1) {
                    String substring = str.substring(lastIndexOf + 1);
                    if (TextUtils.isEmpty(substring)) {
                        throw new RuntimeException("url path illegal, url:" + str);
                    }
                    return substring;
                }
                throw new RuntimeException("url path illegal, url:" + str);
            }
            throw new RuntimeException("url empty, channel:" + updatePackage.getChannel());
        }
        return (String) invokeLL.objValue;
    }

    @Override // com.bytedance.sdk.openadsdk.preload.b.d
    public void a(Object... objArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, objArr) == null) {
            super.a(objArr);
            this.f68538d = (com.bytedance.sdk.openadsdk.preload.geckox.b) objArr[0];
            this.f68539e = (File) objArr[1];
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.bytedance.sdk.openadsdk.preload.b.d
    /* renamed from: a */
    public Object a_(com.bytedance.sdk.openadsdk.preload.b.b<Pair<com.bytedance.sdk.openadsdk.preload.geckox.buffer.a, UpdatePackage>> bVar, Pair<Uri, UpdatePackage> pair) throws Throwable {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, bVar, pair)) == null) {
            com.bytedance.sdk.openadsdk.preload.geckox.h.b.a("gecko-debug-tag", "start download full single file channel:", ((UpdatePackage) pair.second).getChannel());
            UpdatePackage updatePackage = (UpdatePackage) pair.second;
            String uri = ((Uri) pair.first).toString();
            long length = updatePackage.getFullPackage().getLength();
            File file = this.f68539e;
            File file2 = new File(file, updatePackage.getAccessKey() + File.separator + updatePackage.getChannel() + File.separator + updatePackage.getVersion() + "--updating");
            file2.mkdirs();
            StringBuilder sb = new StringBuilder();
            sb.append(UriUtil.LOCAL_RESOURCE_SCHEME);
            sb.append(File.separator);
            sb.append(a(updatePackage, uri));
            com.bytedance.sdk.openadsdk.preload.geckox.buffer.a a2 = com.bytedance.sdk.openadsdk.preload.geckox.buffer.impl.a.a(this.f68538d.a(), new File(file2, sb.toString()), length);
            try {
                this.f68538d.h().a(uri, length, new com.bytedance.sdk.openadsdk.preload.geckox.buffer.a.b(a2));
                try {
                    try {
                        Object a3 = bVar.a((com.bytedance.sdk.openadsdk.preload.b.b<Pair<com.bytedance.sdk.openadsdk.preload.geckox.buffer.a, UpdatePackage>>) new Pair<>(a2, updatePackage));
                        try {
                            a2.e();
                        } catch (Exception e2) {
                            com.bytedance.sdk.openadsdk.preload.geckox.h.b.a("gecko-debug-tag", "DownloadFullSingleFile-release:", e2);
                        }
                        return a3;
                    } catch (Throwable th) {
                        try {
                            a2.e();
                        } catch (Exception e3) {
                            com.bytedance.sdk.openadsdk.preload.geckox.h.b.a("gecko-debug-tag", "DownloadFullSingleFile-release:", e3);
                        }
                        throw th;
                    }
                } catch (Exception e4) {
                    throw e4;
                }
            } catch (Throwable th2) {
                a2.e();
                throw new com.bytedance.sdk.openadsdk.preload.geckox.b.a("download full single file failed! url:" + uri + ", channel:" + updatePackage.getChannel() + ", pkg id:" + updatePackage.getFullPackage().getId() + ", caused by:" + th2.getMessage(), th2);
            }
        }
        return invokeLL.objValue;
    }
}
