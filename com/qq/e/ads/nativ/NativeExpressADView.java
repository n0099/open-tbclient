package com.qq.e.ads.nativ;

import android.content.Context;
import android.widget.FrameLayout;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.qq.e.comm.compliance.ApkDownloadComplianceInterface;
import com.qq.e.comm.compliance.DownloadConfirmListener;
import com.qq.e.comm.pi.AdData;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes2.dex */
public abstract class NativeExpressADView extends FrameLayout implements DownloadConfirmListener, ApkDownloadComplianceInterface {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Map<String, String> ext;

    /* loaded from: classes2.dex */
    public interface ViewBindStatusListener {
        void onAttachedToWindow();

        void onDetachedFromWindow();

        void onFinishTemporaryDetach();

        void onStartTemporaryDetach();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NativeExpressADView(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.ext = new HashMap();
    }

    public abstract void destroy();

    public abstract AdData getBoundData();

    public abstract int getECPM();

    public abstract String getECPMLevel();

    public abstract void negativeFeedback();

    public abstract void preloadVideo();

    public abstract void render();

    public abstract void sendLossNotification(int i2, int i3, String str);

    public abstract void sendWinNotification(int i2);

    @Deprecated
    public abstract void setAdSize(ADSize aDSize);

    public abstract void setBidECPM(int i2);

    public abstract void setMediaListener(NativeExpressMediaListener nativeExpressMediaListener);

    public abstract void setViewBindStatusListener(ViewBindStatusListener viewBindStatusListener);
}
