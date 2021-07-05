package com.bytedance.sdk.openadsdk.preload.geckox.d;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.openadsdk.preload.geckox.model.UpdatePackage;
/* loaded from: classes6.dex */
public class a extends com.bytedance.sdk.openadsdk.preload.b.a<UpdatePackage, UpdatePackage> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public a() {
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
    @Override // com.bytedance.sdk.openadsdk.preload.b.a
    public String a(com.bytedance.sdk.openadsdk.preload.b.b<UpdatePackage> bVar, UpdatePackage updatePackage) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, bVar, updatePackage)) == null) {
            int packageType = updatePackage.getPackageType();
            if (packageType != 0) {
                if (packageType == 1) {
                    return "branch_single_file";
                }
                throw new RuntimeException("unknow file type: " + packageType);
            }
            return "branch_zip";
        }
        return (String) invokeLL.objValue;
    }
}
