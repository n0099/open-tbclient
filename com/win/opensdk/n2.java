package com.win.opensdk;

import android.os.Handler;
import android.os.Message;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.win.opensdk.views.CloseParentView;
/* loaded from: classes6.dex */
public class n2 extends Handler {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ CloseParentView f39887a;

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
        this.f39887a = closeParentView;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, message) == null) && message.what == 10) {
            CloseParentView closeParentView = this.f39887a;
            closeParentView.f39966a.setText(String.valueOf(closeParentView.f39973h));
            CloseParentView closeParentView2 = this.f39887a;
            if (closeParentView2.f39973h <= 0) {
                closeParentView2.f39966a.setVisibility(8);
                this.f39887a.f39966a.setClickable(false);
                this.f39887a.f39974i.removeMessages(10);
            } else {
                closeParentView2.f39966a.setVisibility(0);
                this.f39887a.f39966a.setClickable(true);
            }
            this.f39887a.f39974i.sendEmptyMessageDelayed(10, 1000L);
            this.f39887a.f39973h--;
        }
    }
}
