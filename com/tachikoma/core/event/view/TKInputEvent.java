package com.tachikoma.core.event.view;

import android.content.Context;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.tachikoma.annotation.TK_EXPORT_CLASS;
import com.tachikoma.core.event.base.TKBaseEvent;
import java.util.List;
@TK_EXPORT_CLASS
/* loaded from: classes7.dex */
public class TKInputEvent extends TKBaseEvent {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int TK_INPUT_STATE_BEGAN = 1;
    public static final int TK_INPUT_STATE_CHANGED = 2;
    public static final int TK_INPUT_STATE_ENDED = 3;
    public static final int TK_INPUT_STATE_NORMAL = 0;
    public transient /* synthetic */ FieldHolder $fh;
    public int state;
    public String text;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TKInputEvent(Context context, List<Object> list) {
        super(context, list);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, list};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (List) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public void setText(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            this.text = str;
        }
    }
}
