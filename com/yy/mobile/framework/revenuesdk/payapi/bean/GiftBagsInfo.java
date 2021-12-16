package com.yy.mobile.framework.revenuesdk.payapi.bean;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang3.text.ExtendedMessageFormat;
/* loaded from: classes4.dex */
public class GiftBagsInfo {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<GiftBagItemInfo> giftbag;
    public String giftbagTitle;
    public String giveupButtonMsg;
    public String giveupSubtitle;
    public String giveupTitle;
    public String offersTips;
    public String successButtonMsg;
    public String successTitle;

    public GiftBagsInfo() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.giftbag = new ArrayList();
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return "GiftBagsInfo {offersTips=" + this.offersTips + ", giveupTitle=" + this.giveupTitle + ", giveupSubtitle=" + this.giveupSubtitle + ", giveupButtonMsg=" + this.giveupButtonMsg + ", successTitle=" + this.successTitle + ", successButtonMsg=" + this.successButtonMsg + ", giftbag='" + this.giftbag + ExtendedMessageFormat.QUOTE + ", giftbagTitle='" + this.giftbagTitle + ExtendedMessageFormat.QUOTE + ExtendedMessageFormat.END_FE;
        }
        return (String) invokeV.objValue;
    }
}
