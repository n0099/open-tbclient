package com.facebook.soloader;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public final class Elf64_Shdr {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int sh_addr = 16;
    public static final int sh_addralign = 48;
    public static final int sh_entsize = 56;
    public static final int sh_flags = 8;
    public static final int sh_info = 44;
    public static final int sh_link = 40;
    public static final int sh_name = 0;
    public static final int sh_offset = 24;
    public static final int sh_size = 32;
    public static final int sh_type = 4;
    public transient /* synthetic */ FieldHolder $fh;

    public Elf64_Shdr() {
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
}
