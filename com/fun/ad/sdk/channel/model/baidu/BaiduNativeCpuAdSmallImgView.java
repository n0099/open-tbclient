package com.fun.ad.sdk.channel.model.baidu;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.sdk.api.IBasicCPUData;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.fun.ad.sdk.internal.api.utils.GlideHelper;
import java.util.List;
/* loaded from: classes9.dex */
public class BaiduNativeCpuAdSmallImgView extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TextView a;
    public ImageView b;
    public TextView c;
    public ImageView d;
    public Button e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BaiduNativeCpuAdSmallImgView(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
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
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BaiduNativeCpuAdSmallImgView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BaiduNativeCpuAdSmallImgView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0041  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x008f  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0095  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(IBasicCPUData iBasicCPUData) {
        String thumbUrl;
        String str;
        Button button;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, iBasicCPUData) == null) {
            List<String> imageUrls = iBasicCPUData.getImageUrls();
            List<String> smallImageUrls = iBasicCPUData.getSmallImageUrls();
            if (smallImageUrls != null && !smallImageUrls.isEmpty()) {
                str = smallImageUrls.get(0);
            } else if (imageUrls == null || imageUrls.isEmpty()) {
                thumbUrl = iBasicCPUData.getThumbUrl();
                if (TextUtils.isEmpty(thumbUrl)) {
                    GlideHelper.get().load(getContext(), thumbUrl, this.b);
                    this.b.setVisibility(0);
                } else {
                    this.b.setImageDrawable(null);
                    this.b.setVisibility(8);
                }
                this.a.setText(iBasicCPUData.getDesc());
                if (TextUtils.isEmpty(iBasicCPUData.getBrandName())) {
                    this.c.setText(iBasicCPUData.getBrandName());
                } else {
                    this.c.setText(R.string.obfuscated_res_0x7f0f08bd);
                }
                GlideHelper.get().load(getContext(), iBasicCPUData.getAdLogoUrl(), this.d);
                if (iBasicCPUData.isNeedDownloadApp()) {
                    button = this.e;
                    i = R.string.obfuscated_res_0x7f0f08a8;
                } else {
                    button = this.e;
                    i = R.string.obfuscated_res_0x7f0f08aa;
                }
                button.setText(i);
            } else {
                str = imageUrls.get(0);
            }
            thumbUrl = str;
            if (TextUtils.isEmpty(thumbUrl)) {
            }
            this.a.setText(iBasicCPUData.getDesc());
            if (TextUtils.isEmpty(iBasicCPUData.getBrandName())) {
            }
            GlideHelper.get().load(getContext(), iBasicCPUData.getAdLogoUrl(), this.d);
            if (iBasicCPUData.isNeedDownloadApp()) {
            }
            button.setText(i);
        }
    }

    public View getCreativeView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.e : (View) invokeV.objValue;
    }

    @Override // android.view.View
    public void onFinishInflate() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.onFinishInflate();
            this.a = (TextView) findViewById(R.id.obfuscated_res_0x7f0900ae);
            this.b = (ImageView) findViewById(R.id.obfuscated_res_0x7f0900bc);
            this.c = (TextView) findViewById(R.id.obfuscated_res_0x7f090114);
            this.d = (ImageView) findViewById(R.id.obfuscated_res_0x7f0900ef);
            this.e = (Button) findViewById(R.id.obfuscated_res_0x7f0900aa);
        }
    }
}
