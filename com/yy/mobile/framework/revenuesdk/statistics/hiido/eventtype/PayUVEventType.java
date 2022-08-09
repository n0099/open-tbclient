package com.yy.mobile.framework.revenuesdk.statistics.hiido.eventtype;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class PayUVEventType {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String PAY_AMOUNT_DIALOG_COMFIRM_BTN_CLICK = "2";
    public static final String PAY_AMOUNT_DIALOG_ITEM_CLICK = "3";
    public static final String PAY_AMOUNT_DIALOG_SHOW = "1";
    public static final String PAY_AMOUNT_FAQ_ENTRANCE_CLICK = "25";
    public static final String PAY_AMOUNT_FAQ_ENTRANCE_SHOW = "24";
    public static final String PAY_AMOUNT_FULL_PAGE_COMFIRM_BTN_CLICK = "9";
    public static final String PAY_AMOUNT_FULL_PAGE_ITEM_CLICK = "10";
    public static final String PAY_AMOUNT_FULL_PAGE_SHOW = "8";
    public static final String PAY_CONFIRM_CONTINUE_BTN_CLICK = "16";
    public static final String PAY_CONFIRM_DIALOG_SHOW = "15";
    public static final String PAY_DIALOG_BANNER_CLICK = "19";
    public static final String PAY_DIALOG_BANNER_SHOW = "18";
    public static final String PAY_GIFT_DIALOG_SHOW = "17";
    public static final String PAY_SUCCESS_DIALOG_BANER_CLICK = "23";
    public static final String PAY_SUCCESS_DIALOG_BANER_SHOW = "22";
    public static final String PAY_WALLET_BANNER_CLICK = "21";
    public static final String PAY_WALLET_BANNER_SHOW = "20";
    public static final String PAY_WAY_DIALOG_CHANNEL_CLICK = "6";
    public static final String PAY_WAY_DIALOG_COMFIRM_BTN_CLICK = "5";
    public static final String PAY_WAY_DIALOG_SHOW = "4";
    public static final String PAY_WAY_DIALOG_SUCCESS = "7";
    public static final String PAY_WAY_FAQ_ENTRANCE_CLICK = "27";
    public static final String PAY_WAY_FAQ_ENTRANCE_SHOW = "26";
    public static final String PAY_WAY_FULL_PAGE_CHANNEL_CLICK = "13";
    public static final String PAY_WAY_FULL_PAGE_COMFIRM_BTN_CLICK = "12";
    public static final String PAY_WAY_FULL_PAGE_SHOW = "11";
    public static final String PAY_WAY_FULL_PAGE_SUCCESS = "14";
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes8.dex */
    public class UserType {
        public static /* synthetic */ Interceptable $ic = null;
        public static final String BAIDU = "2";
        public static final String YYUID = "1";
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PayUVEventType this$0;

        public UserType(PayUVEventType payUVEventType) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {payUVEventType};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = payUVEventType;
        }
    }

    public PayUVEventType() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }
}
