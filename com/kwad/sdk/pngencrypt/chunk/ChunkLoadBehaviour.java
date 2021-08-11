package com.kwad.sdk.pngencrypt.chunk;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes10.dex */
public final class ChunkLoadBehaviour {
    public static final /* synthetic */ ChunkLoadBehaviour[] $VALUES;
    public static /* synthetic */ Interceptable $ic;
    public static final ChunkLoadBehaviour LOAD_CHUNK_ALWAYS;
    public static final ChunkLoadBehaviour LOAD_CHUNK_IF_SAFE;
    public static final ChunkLoadBehaviour LOAD_CHUNK_MOST_IMPORTANT;
    public static final ChunkLoadBehaviour LOAD_CHUNK_NEVER;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-237958441, "Lcom/kwad/sdk/pngencrypt/chunk/ChunkLoadBehaviour;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-237958441, "Lcom/kwad/sdk/pngencrypt/chunk/ChunkLoadBehaviour;");
                return;
            }
        }
        LOAD_CHUNK_NEVER = new ChunkLoadBehaviour("LOAD_CHUNK_NEVER", 0);
        LOAD_CHUNK_IF_SAFE = new ChunkLoadBehaviour("LOAD_CHUNK_IF_SAFE", 1);
        LOAD_CHUNK_MOST_IMPORTANT = new ChunkLoadBehaviour("LOAD_CHUNK_MOST_IMPORTANT", 2);
        ChunkLoadBehaviour chunkLoadBehaviour = new ChunkLoadBehaviour("LOAD_CHUNK_ALWAYS", 3);
        LOAD_CHUNK_ALWAYS = chunkLoadBehaviour;
        $VALUES = new ChunkLoadBehaviour[]{LOAD_CHUNK_NEVER, LOAD_CHUNK_IF_SAFE, LOAD_CHUNK_MOST_IMPORTANT, chunkLoadBehaviour};
    }

    public ChunkLoadBehaviour(String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                String str2 = (String) objArr2[0];
                ((Integer) objArr2[1]).intValue();
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static ChunkLoadBehaviour valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (ChunkLoadBehaviour) Enum.valueOf(ChunkLoadBehaviour.class, str) : (ChunkLoadBehaviour) invokeL.objValue;
    }

    public static ChunkLoadBehaviour[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (ChunkLoadBehaviour[]) $VALUES.clone() : (ChunkLoadBehaviour[]) invokeV.objValue;
    }
}
