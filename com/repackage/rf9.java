package com.repackage;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.openadsdk.TTImage;
import com.bytedance.sdk.openadsdk.TTNativeAd;
import com.fun.ad.sdk.ChannelNativeAds;
import com.fun.ad.sdk.FunAdInteractionListener;
import com.fun.ad.sdk.FunNativeAd;
import com.fun.ad.sdk.internal.api.BaseFunNativeAd;
import com.fun.ad.sdk.internal.api.config.Ssp;
import com.repackage.of9;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public class rf9 extends BaseFunNativeAd {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final TTNativeAd b;
    public final of9 c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public rf9(TTNativeAd tTNativeAd, String str, Ssp.Pid pid, of9 of9Var) {
        super(str, pid);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tTNativeAd, str, pid, of9Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((String) objArr2[0], (Ssp.Pid) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = tTNativeAd;
        this.c = of9Var;
    }

    @Override // com.fun.ad.sdk.FunNativeAd, com.fun.ad.sdk.FunNativeInfo
    public ChannelNativeAds getChannelNativeAds() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? ChannelNativeAds.createCsj(this.b) : (ChannelNativeAds) invokeV.objValue;
    }

    @Override // com.fun.ad.sdk.FunNativeAd, com.fun.ad.sdk.FunNativeInfo
    public String getDescription() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.b.getDescription() : (String) invokeV.objValue;
    }

    @Override // com.fun.ad.sdk.FunNativeAd, com.fun.ad.sdk.FunNativeInfo
    public String getIconUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            TTImage icon = this.b.getIcon();
            if (icon == null) {
                return null;
            }
            return icon.getImageUrl();
        }
        return (String) invokeV.objValue;
    }

    @Override // com.fun.ad.sdk.FunNativeAd, com.fun.ad.sdk.FunNativeInfo
    public List<String> getImageUrls() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            List<TTImage> imageList = this.b.getImageList();
            if (imageList == null || imageList.isEmpty()) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            for (TTImage tTImage : imageList) {
                arrayList.add(tTImage.getImageUrl());
            }
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    @Override // com.fun.ad.sdk.FunNativeAd, com.fun.ad.sdk.FunNativeInfo
    public FunNativeAd.InteractionType getInteractionType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            int interactionType = this.b.getInteractionType();
            return (interactionType == 2 || interactionType == 3) ? FunNativeAd.InteractionType.TYPE_BROWSE : interactionType != 4 ? interactionType != 5 ? FunNativeAd.InteractionType.TYPE_UNKNOW : FunNativeAd.InteractionType.TYPE_DIAL : FunNativeAd.InteractionType.TYPE_DOWNLOAD;
        }
        return (FunNativeAd.InteractionType) invokeV.objValue;
    }

    @Override // com.fun.ad.sdk.FunNativeAd, com.fun.ad.sdk.FunNativeInfo
    public String getTitle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            String source = this.b.getSource();
            return TextUtils.isEmpty(source) ? this.b.getTitle() : source;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.fun.ad.sdk.FunNativeAd, com.fun.ad.sdk.FunNativeInfo
    public View getVideoView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.b.getAdView() : (View) invokeV.objValue;
    }

    @Override // com.fun.ad.sdk.internal.api.BaseFunNativeAd
    public void showInternal(Context context, ViewGroup viewGroup, List<View> list, List<View> list2, FunAdInteractionListener funAdInteractionListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048583, this, context, viewGroup, list, list2, funAdInteractionListener) == null) {
            of9 of9Var = this.c;
            TTNativeAd tTNativeAd = this.b;
            of9Var.c(context, tTNativeAd, this.mSid, viewGroup, list, list2, new of9.b(of9Var, tTNativeAd), funAdInteractionListener);
        }
    }
}
