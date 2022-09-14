package com.google.android.gms.dynamite;

import android.content.Context;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.gms.dynamite.DynamiteModule;
/* loaded from: classes7.dex */
public final class zzf implements DynamiteModule.VersionPolicy {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public zzf() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Override // com.google.android.gms.dynamite.DynamiteModule.VersionPolicy
    public final DynamiteModule.VersionPolicy.SelectionResult selectModule(Context context, String str, DynamiteModule.VersionPolicy.IVersions iVersions) throws DynamiteModule.LoadingException {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, context, str, iVersions)) == null) {
            DynamiteModule.VersionPolicy.SelectionResult selectionResult = new DynamiteModule.VersionPolicy.SelectionResult();
            int zzb = iVersions.zzb(context, str, true);
            selectionResult.remoteVersion = zzb;
            if (zzb != 0) {
                selectionResult.selection = 1;
            } else {
                int zza = iVersions.zza(context, str);
                selectionResult.localVersion = zza;
                if (zza != 0) {
                    selectionResult.selection = -1;
                }
            }
            return selectionResult;
        }
        return (DynamiteModule.VersionPolicy.SelectionResult) invokeLLL.objValue;
    }
}
