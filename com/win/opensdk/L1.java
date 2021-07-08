package com.win.opensdk;

import android.os.Handler;
import android.os.Message;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.win.opensdk.views.CloseParentView;
/* loaded from: classes6.dex */
public class L1 extends Handler {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ CloseParentView f39414a;

    public L1(CloseParentView closeParentView) {
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
        this.f39414a = closeParentView;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, message) == null) && message.what == 10) {
            CloseParentView closeParentView = this.f39414a;
            closeParentView.f39684a.setText(String.valueOf(closeParentView.f39691h));
            CloseParentView closeParentView2 = this.f39414a;
            if (closeParentView2.f39691h <= 0) {
                closeParentView2.f39684a.setVisibility(8);
                this.f39414a.f39684a.setClickable(false);
                this.f39414a.f39692i.removeMessages(10);
            } else {
                closeParentView2.f39684a.setVisibility(0);
                this.f39414a.f39684a.setClickable(true);
            }
            this.f39414a.f39692i.sendEmptyMessageDelayed(10, 1000L);
            this.f39414a.f39691h--;
        }
    }
}
