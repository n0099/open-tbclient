package com.facebook.soloader;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public final class Elf32_Phdr {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int p_align = 28;
    public static final int p_filesz = 16;
    public static final int p_flags = 24;
    public static final int p_memsz = 20;
    public static final int p_offset = 4;
    public static final int p_paddr = 12;
    public static final int p_type = 0;
    public static final int p_vaddr = 8;
    public transient /* synthetic */ FieldHolder $fh;

    public Elf32_Phdr() {
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
