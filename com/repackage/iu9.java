package com.repackage;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.win.opensdk.views.CloseParentView;
/* loaded from: classes6.dex */
public class iu9 extends Handler {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ CloseParentView a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public iu9(CloseParentView closeParentView, Looper looper) {
        super(looper);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {closeParentView, looper};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Looper) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = closeParentView;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, message) == null) && message.what == 10) {
            CloseParentView closeParentView = this.a;
            closeParentView.a.setText(String.valueOf(closeParentView.h));
            CloseParentView closeParentView2 = this.a;
            if (closeParentView2.h <= 0) {
                closeParentView2.a.setVisibility(8);
                this.a.a.setClickable(false);
                this.a.i.removeMessages(10);
            } else {
                closeParentView2.a.setVisibility(0);
                this.a.a.setClickable(true);
            }
            this.a.i.sendEmptyMessageDelayed(10, 1000L);
            this.a.h--;
        }
    }
}
