package com.dxmpay.wallet.base.widget.dialog.model;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class ContentDialogModel extends BaseDialogModel {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int backgroundColor;
    public boolean hideMessage;
    public CharSequence message;
    public int messageColor;
    public int messageId;
    public int messageSize;

    public ContentDialogModel() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.messageColor = 0;
        this.messageSize = 0;
        this.backgroundColor = 0;
        this.hideMessage = false;
    }
}
