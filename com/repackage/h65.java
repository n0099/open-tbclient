package com.repackage;

import android.content.Intent;
import com.baidu.tbadk.mutiprocess.DataType;
import com.baidu.tbadk.mutiprocess.ParcelableEvent;
import com.baidu.tbadk.mutiprocess.SerializableEvent;
import com.baidu.tbadk.mutiprocess.StickyEvent;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class h65 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public h65() {
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

    public void a(Intent intent, x55 x55Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, intent, x55Var) == null) {
            if (x55Var instanceof StickyEvent) {
                intent.putExtra("value_type", DataType.ORM.ordinal());
                intent.putExtra("value", (StickyEvent) x55Var);
            } else if (x55Var instanceof ParcelableEvent) {
                intent.putExtra("value_type", DataType.PARCELABLE.ordinal());
                intent.putExtra("value", (ParcelableEvent) x55Var);
            } else if (x55Var instanceof SerializableEvent) {
                intent.putExtra("value_type", DataType.SERIALIZABLE.ordinal());
                intent.putExtra("value", (SerializableEvent) x55Var);
            }
        }
    }
}
