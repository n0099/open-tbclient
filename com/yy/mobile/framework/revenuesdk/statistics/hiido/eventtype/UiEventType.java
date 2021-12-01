package com.yy.mobile.framework.revenuesdk.statistics.hiido.eventtype;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class UiEventType {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String failpagecallnum = "failpagecallnum";
    public static final String failpageclose = "failpageclose";
    public static final String failpageshow = "failpageshow";
    public static final String paypageclose_bt = "paypageclose_bt";
    public static final String paypageclose_transparent = "paypageclose_transparent";
    public static final String paypagepaybt = "paypagepaybt";
    public static final String paypageprotocol = "paypageprotocol";
    public static final String purchaseclose_bt = "purchaseclose_bt";
    public static final String purchaseclose_transparent = "purchaseclose_transparent";
    public static final String purchasegotopay = "purchasegotopay";
    public static final String purchaseshow = "purchaseshow";
    public static final String successpageclose = "successpageclose";
    public static final String successpageshow = "successpageshow";
    public static final String wallet_secondpage_title = "wallet_secondpage_title";
    public static final String walletclickClose = "walletclickClose";
    public static final String walletclickcharge = "walletclickcharge";
    public static final String walletclickdetail = "walletclickdetail";
    public static final String walletshow = "walletshow";
    public static final String walletshowhelp = "walletshowhelp";
    public transient /* synthetic */ FieldHolder $fh;

    public UiEventType() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }
}
