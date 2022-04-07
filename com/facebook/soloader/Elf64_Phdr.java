package com.facebook.soloader;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public final class Elf64_Phdr {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int p_align = 48;
    public static final int p_filesz = 32;
    public static final int p_flags = 4;
    public static final int p_memsz = 40;
    public static final int p_offset = 8;
    public static final int p_paddr = 24;
    public static final int p_type = 0;
    public static final int p_vaddr = 16;
    public transient /* synthetic */ FieldHolder $fh;

    public Elf64_Phdr() {
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
}
