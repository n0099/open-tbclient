package com.kwai.sodler.lib.c;

import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes5.dex */
public final class b implements Comparable<b> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean Dv;
    public String ayA;
    public long ayB;
    public String ayC;
    public boolean ayD;
    public boolean ayE;
    public HashMap<String, String> ayF;
    public List<String> ayG;
    public List<String> ayH;
    public ClassLoader ayI;
    public String ayz;
    public String version;

    public b() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.ayD = false;
        this.ayE = true;
        this.ayF = new HashMap<>(10);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: private */
    @Override // java.lang.Comparable
    /* renamed from: c */
    public int compareTo(@NonNull b bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65537, this, bVar)) == null) ? -this.version.compareTo(bVar.version) : invokeL.intValue;
    }

    public final String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return "RemotePluginInfo{pluginId='" + this.ayz + "', version='" + this.version + "', downloadUrl='" + this.ayA + "', fileSize=" + this.ayB + ", enable=" + this.Dv + ", md5sum='" + this.ayC + "', onlyWifiDownload=" + this.ayD + ", onlyWifiRetryDownload=" + this.ayE + ", soMd5s=" + this.ayF + ", hostPackages=" + this.ayG + ", hostInterfaces=" + this.ayH + '}';
        }
        return (String) invokeV.objValue;
    }
}
