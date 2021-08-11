package com.bytedance.sdk.openadsdk.preload.geckox.d;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.unitedscheme.SchemeDescPatchListener;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.openadsdk.preload.b.j;
import com.bytedance.sdk.openadsdk.preload.geckox.model.UpdatePackage;
import java.util.List;
/* loaded from: classes9.dex */
public class b extends j<UpdatePackage, UpdatePackage> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

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

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.bytedance.sdk.openadsdk.preload.b.j
    public String a(com.bytedance.sdk.openadsdk.preload.b.b<UpdatePackage> bVar, UpdatePackage updatePackage) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, bVar, updatePackage)) == null) {
            UpdatePackage.Package patch = updatePackage.getPatch();
            if (patch == null) {
                com.bytedance.sdk.openadsdk.preload.geckox.h.b.a("gecko-debug-tag", "start full update, channel:", updatePackage.getChannel());
                return "full";
            }
            List<String> urlList = patch.getUrlList();
            if (urlList == null || urlList.isEmpty()) {
                com.bytedance.sdk.openadsdk.preload.geckox.h.b.a("gecko-debug-tag", "start full update, channel:", updatePackage.getChannel());
                return "full";
            }
            com.bytedance.sdk.openadsdk.preload.geckox.h.b.a("gecko-debug-tag", "start full update, channel:", updatePackage.getChannel());
            return SchemeDescPatchListener.PATCH;
        }
        return (String) invokeLL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.bytedance.sdk.openadsdk.preload.b.j
    public String a(com.bytedance.sdk.openadsdk.preload.b.b<UpdatePackage> bVar, UpdatePackage updatePackage, Throwable th, String str) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar, updatePackage, th, str)) == null) {
            if (SchemeDescPatchListener.PATCH.equals(str)) {
                com.bytedance.sdk.openadsdk.preload.geckox.h.b.a("gecko-debug-tag", "start full update, channel:", updatePackage.getChannel());
                return "full";
            }
            throw new RuntimeException("full update failed, caused by:" + th.getMessage(), th);
        }
        return (String) invokeLLLL.objValue;
    }
}
