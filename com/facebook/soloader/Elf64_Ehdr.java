package com.facebook.soloader;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public final class Elf64_Ehdr {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int e_ehsize = 52;
    public static final int e_entry = 24;
    public static final int e_flags = 48;
    public static final int e_ident = 0;
    public static final int e_machine = 18;
    public static final int e_phentsize = 54;
    public static final int e_phnum = 56;
    public static final int e_phoff = 32;
    public static final int e_shentsize = 58;
    public static final int e_shnum = 60;
    public static final int e_shoff = 40;
    public static final int e_shstrndx = 62;
    public static final int e_type = 16;
    public static final int e_version = 20;
    public transient /* synthetic */ FieldHolder $fh;

    public Elf64_Ehdr() {
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
