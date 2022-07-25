package com.repackage;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import tbclient.Page;
/* loaded from: classes6.dex */
public class lb5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public boolean b;
    public Object c;

    public lb5() {
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
        this.b = true;
    }

    public void a(Page page) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, page) == null) || page == null) {
            return;
        }
        this.b = page.has_more.intValue() == 1;
        page.has_prev.intValue();
        this.a = page.current_page.intValue();
        page.page_size.intValue();
        page.total_page.intValue();
        page.offset.intValue();
        page.total_count.intValue();
        gc5.b("parserProto--->currentPage=" + this.a + ",hasMore=" + this.b);
    }
}
