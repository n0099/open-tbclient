package com.repackage;

import android.content.Context;
import android.widget.Button;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.openadsdk.TTAppDownloadListener;
import com.fun.ad.sdk.internal.api.utils.LogPrinter;
/* loaded from: classes6.dex */
public class oc9 implements TTAppDownloadListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Button a;

    public oc9(Button button) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {button};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = button;
    }

    public final String a(Context context, long j, long j2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{context, Long.valueOf(j), Long.valueOf(j2)})) == null) ? j != 0 ? context.getString(R.string.obfuscated_res_0x7f0f0764, String.format("%s/100", Long.valueOf((j2 * 100) / j))) : context.getString(R.string.obfuscated_res_0x7f0f0765) : (String) invokeCommon.objValue;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
    public void onDownloadActive(long j, long j2, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Long.valueOf(j), Long.valueOf(j2), str, str2}) == null) {
            LogPrinter.d("CSJAppDownloadListener 下载中，点击图片暂停", new Object[0]);
            Button button = this.a;
            if (button != null) {
                button.setText(a(button.getContext(), j, j2));
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
    public void onDownloadFailed(long j, long j2, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Long.valueOf(j), Long.valueOf(j2), str, str2}) == null) {
            LogPrinter.e("CSJAppDownloadListener 下载失败，点击图片重新下载", new Object[0]);
            Button button = this.a;
            if (button != null) {
                button.setText(R.string.obfuscated_res_0x7f0f0763);
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
    public void onDownloadFinished(long j, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Long.valueOf(j), str, str2}) == null) {
            LogPrinter.d("CSJAppDownloadListener 点击图片安装", new Object[0]);
            Button button = this.a;
            if (button != null) {
                button.setText(R.string.obfuscated_res_0x7f0f0766);
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
    public void onDownloadPaused(long j, long j2, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{Long.valueOf(j), Long.valueOf(j2), str, str2}) == null) {
            LogPrinter.d("CSJAppDownloadListener 下载暂停，点击图片继续", new Object[0]);
            Button button = this.a;
            if (button != null) {
                button.setText(a(button.getContext(), j, j2));
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener, com.kwad.sdk.api.KsAppDownloadListener
    public void onIdle() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            LogPrinter.e("CSJAppDownloadListener 点击图片开始下载", new Object[0]);
            Button button = this.a;
            if (button != null) {
                button.setText(R.string.obfuscated_res_0x7f0f0763);
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
    public void onInstalled(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, str, str2) == null) {
            LogPrinter.d("CSJAppDownloadListener 安装完成，点击图片打开", new Object[0]);
            Button button = this.a;
            if (button != null) {
                button.setText(R.string.obfuscated_res_0x7f0f0767);
            }
        }
    }
}
