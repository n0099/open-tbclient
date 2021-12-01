package io.flutter.embedding.engine.loader;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public final class FlutterApplicationInfo {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String DEFAULT_AOT_SHARED_LIBRARY_NAME = "libapp.so";
    public static final String DEFAULT_FLUTTER_ASSETS_DIR = "flutter_assets";
    public static final String DEFAULT_ISOLATE_SNAPSHOT_DATA = "isolate_snapshot_data";
    public static final String DEFAULT_VM_SNAPSHOT_DATA = "vm_snapshot_data";
    public transient /* synthetic */ FieldHolder $fh;
    public final String aotSharedLibraryName;
    public final boolean automaticallyRegisterPlugins;
    public final String domainNetworkPolicy;
    public final String flutterAssetsDir;
    public final String isolateSnapshotData;
    public final String nativeLibraryDir;
    public final String vmSnapshotData;

    public FlutterApplicationInfo(String str, String str2, String str3, String str4, String str5, String str6, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, str2, str3, str4, str5, str6, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.aotSharedLibraryName = str == null ? DEFAULT_AOT_SHARED_LIBRARY_NAME : str;
        this.vmSnapshotData = str2 == null ? DEFAULT_VM_SNAPSHOT_DATA : str2;
        this.isolateSnapshotData = str3 == null ? DEFAULT_ISOLATE_SNAPSHOT_DATA : str3;
        this.flutterAssetsDir = str4 == null ? DEFAULT_FLUTTER_ASSETS_DIR : str4;
        this.nativeLibraryDir = str6;
        this.domainNetworkPolicy = str5 == null ? "" : str5;
        this.automaticallyRegisterPlugins = z;
    }
}
