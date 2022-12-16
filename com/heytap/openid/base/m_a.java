package com.heytap.openid.base;

import android.content.Context;
import androidx.annotation.Keep;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
@Keep
/* loaded from: classes8.dex */
public class m_a implements Runnable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @Keep
    public final /* synthetic */ Context m_a;
    @Keep
    public final /* synthetic */ List m_b;
    @Keep
    public final /* synthetic */ m_b m_c;

    public m_a(m_b m_bVar, Context context, List list) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {m_bVar, context, list};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.m_c = m_bVar;
        this.m_a = context;
        this.m_b = list;
    }

    @Override // java.lang.Runnable
    @Keep
    public native void run();
}
