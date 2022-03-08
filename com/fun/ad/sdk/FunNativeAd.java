package com.fun.ad.sdk;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes7.dex */
public interface FunNativeAd {

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes7.dex */
    public static final class InteractionType {
        public static /* synthetic */ Interceptable $ic;
        public static final InteractionType TYPE_BROWSE;
        public static final InteractionType TYPE_DIAL;
        public static final InteractionType TYPE_DOWNLOAD;
        public static final InteractionType TYPE_UNKNOW;
        public static final /* synthetic */ InteractionType[] a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(976376017, "Lcom/fun/ad/sdk/FunNativeAd$InteractionType;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(976376017, "Lcom/fun/ad/sdk/FunNativeAd$InteractionType;");
                    return;
                }
            }
            InteractionType interactionType = new InteractionType("TYPE_UNKNOW", 0);
            TYPE_UNKNOW = interactionType;
            InteractionType interactionType2 = new InteractionType("TYPE_DOWNLOAD", 1);
            TYPE_DOWNLOAD = interactionType2;
            InteractionType interactionType3 = new InteractionType("TYPE_DIAL", 2);
            TYPE_DIAL = interactionType3;
            InteractionType interactionType4 = new InteractionType("TYPE_BROWSE", 3);
            TYPE_BROWSE = interactionType4;
            a = new InteractionType[]{interactionType, interactionType2, interactionType3, interactionType4};
        }

        public InteractionType(String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static InteractionType valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (InteractionType) Enum.valueOf(InteractionType.class, str) : (InteractionType) invokeL.objValue;
        }

        public static InteractionType[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (InteractionType[]) a.clone() : (InteractionType[]) invokeV.objValue;
        }
    }

    ChannelNativeAds getChannelNativeAds();

    String getDescription();

    String getIconUrl();

    List<String> getImageUrls();

    InteractionType getInteractionType();

    String getTitle();

    View getVideoView();

    void show(Context context, ViewGroup viewGroup, List<View> list, List<View> list2, FunAdInteractionListener funAdInteractionListener);
}
