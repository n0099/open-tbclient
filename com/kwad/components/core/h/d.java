package com.kwad.components.core.h;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import androidx.annotation.LayoutRes;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.api.loader.Wrapper;
/* loaded from: classes5.dex */
public abstract class d extends AlertDialog {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Context a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(Activity activity) {
        super(activity);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {activity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        setOwnerActivity(activity);
        this.a = Wrapper.wrapContextIfNeed(activity);
    }

    @LayoutRes
    public abstract int a();

    public abstract void a(View view2);

    @Override // android.app.AlertDialog, android.app.Dialog
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bundle) == null) {
            super.onCreate(bundle);
            View inflate = View.inflate(this.a, a(), null);
            setContentView(inflate);
            setCanceledOnTouchOutside(false);
            getWindow().setBackgroundDrawable(new ColorDrawable(0));
            getWindow().setLayout(-1, -1);
            a(inflate);
        }
    }
}
