package com.win.opensdk;

import android.os.Handler;
import android.os.Message;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.win.opensdk.views.CloseParentView;
/* loaded from: classes10.dex */
public class n2 extends Handler {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ CloseParentView f77467a;

    public n2(CloseParentView closeParentView) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {closeParentView};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f77467a = closeParentView;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, message) == null) && message.what == 10) {
            CloseParentView closeParentView = this.f77467a;
            closeParentView.f77551a.setText(String.valueOf(closeParentView.f77558h));
            CloseParentView closeParentView2 = this.f77467a;
            if (closeParentView2.f77558h <= 0) {
                closeParentView2.f77551a.setVisibility(8);
                this.f77467a.f77551a.setClickable(false);
                this.f77467a.f77559i.removeMessages(10);
            } else {
                closeParentView2.f77551a.setVisibility(0);
                this.f77467a.f77551a.setClickable(true);
            }
            this.f77467a.f77559i.sendEmptyMessageDelayed(10, 1000L);
            this.f77467a.f77558h--;
        }
    }
}
