package com.facebook.soloader;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public final class Elf32_Ehdr {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int e_ehsize = 40;
    public static final int e_entry = 24;
    public static final int e_flags = 36;
    public static final int e_ident = 0;
    public static final int e_machine = 18;
    public static final int e_phentsize = 42;
    public static final int e_phnum = 44;
    public static final int e_phoff = 28;
    public static final int e_shentsize = 46;
    public static final int e_shnum = 48;
    public static final int e_shoff = 32;
    public static final int e_shstrndx = 50;
    public static final int e_type = 16;
    public static final int e_version = 20;
    public transient /* synthetic */ FieldHolder $fh;

    public Elf32_Ehdr() {
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
