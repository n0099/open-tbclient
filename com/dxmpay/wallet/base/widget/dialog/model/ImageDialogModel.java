package com.dxmpay.wallet.base.widget.dialog.model;

import android.graphics.drawable.Drawable;
import android.view.View;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public class ImageDialogModel extends BaseModel {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String buttonText;
    public int buttonTextId;
    public View.OnClickListener defaultClickListener;
    public Drawable imageDrawable;
    public int imageId;
    public String message;
    public int messageId;
    public String messageTemp;
    public int messageTempId;
    public String titleText;
    public int titleTextId;

    public ImageDialogModel() {
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
