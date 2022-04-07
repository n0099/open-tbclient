package com.repackage;

import android.content.Context;
import android.widget.EditText;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.videoplay.editor.VideoPlayInputContainer;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class lv8 extends u05 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public EditText r;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public lv8(Context context) {
        super(context, (String) null, 28);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (String) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.m = false;
        this.l = 3;
        VideoPlayInputContainer videoPlayInputContainer = new VideoPlayInputContainer(context);
        this.k = videoPlayInputContainer;
        this.r = videoPlayInputContainer.getInputView();
        this.n = new int[]{4, 24, 3, 9, 6};
    }

    public EditText f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.r : (EditText) invokeV.objValue;
    }

    public VideoPlayInputContainer g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? (VideoPlayInputContainer) this.k : (VideoPlayInputContainer) invokeV.objValue;
    }
}
