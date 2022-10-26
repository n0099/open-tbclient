package com.heytap.openid.sdk;

import android.content.Context;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.heytap.openid.sdk.m_c;
import com.heytap.openid.sdk.m_i;
import java.util.List;
/* loaded from: classes7.dex */
public class m_b extends com.heytap.openid.base.m_b {
    public static /* synthetic */ Interceptable $ic;
    public static m_b m_c;
    public transient /* synthetic */ FieldHolder $fh;

    public m_b() {
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

    public static native m_b m_a();

    @Override // com.heytap.openid.base.m_b
    public void m_a(Context context, List list, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048576, this, context, list, z) == null) {
            (this.m_b.equals("OP_APP") ? m_c.m_b.m_a : m_i.m_b.m_a).m_a(context, list, z);
        }
    }
}
