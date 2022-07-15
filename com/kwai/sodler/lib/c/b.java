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
    public String a;
    public String b;
    public String c;
    public long d;
    public boolean e;
    public String f;
    public boolean g;
    public boolean h;
    public HashMap<String, String> i;
    public List<String> j;
    public List<String> k;
    public ClassLoader l;

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
        this.g = false;
        this.h = true;
        this.i = new HashMap<>(10);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: private */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(@NonNull b bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65537, this, bVar)) == null) ? -this.b.compareTo(bVar.b) : invokeL.intValue;
    }

    public final String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return "RemotePluginInfo{pluginId='" + this.a + "', version='" + this.b + "', downloadUrl='" + this.c + "', fileSize=" + this.d + ", enable=" + this.e + ", md5sum='" + this.f + "', onlyWifiDownload=" + this.g + ", onlyWifiRetryDownload=" + this.h + ", soMd5s=" + this.i + ", hostPackages=" + this.j + ", hostInterfaces=" + this.k + '}';
        }
        return (String) invokeV.objValue;
    }
}
