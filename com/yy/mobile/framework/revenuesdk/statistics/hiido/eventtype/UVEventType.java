package com.yy.mobile.framework.revenuesdk.statistics.hiido.eventtype;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class UVEventType {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String PAY_AMOUNT_DIALOG_COMFIRM_BTN_CLICK = "2";
    public static final String PAY_AMOUNT_DIALOG_ITEM_CLICK = "3";
    public static final String PAY_AMOUNT_DIALOG_SHOW = "1";
    public static final String PAY_AMOUNT_FULL_PAGE_COMFIRM_BTN_CLICK = "9";
    public static final String PAY_AMOUNT_FULL_PAGE_ITEM_CLICK = "10";
    public static final String PAY_AMOUNT_FULL_PAGE_SHOW = "8";
    public static final String PAY_CONFIRM_CONTINUE_BTN_CLICK = "16";
    public static final String PAY_CONFIRM_DIALOG_SHOW = "15";
    public static final String PAY_GIFT_DIALOG_SHOW = "17";
    public static final String PAY_WAY_DIALOG_CHANNEL_CLICK = "6";
    public static final String PAY_WAY_DIALOG_COMFIRM_BTN_CLICK = "5";
    public static final String PAY_WAY_DIALOG_SHOW = "4";
    public static final String PAY_WAY_DIALOG_SUCCESS = "7";
    public static final String PAY_WAY_FULL_PAGE_CHANNEL_CLICK = "13";
    public static final String PAY_WAY_FULL_PAGE_COMFIRM_BTN_CLICK = "12";
    public static final String PAY_WAY_FULL_PAGE_SHOW = "11";
    public static final String PAY_WAY_FULL_PAGE_SUCCESS = "14";
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes2.dex */
    public class UserType {
        public static /* synthetic */ Interceptable $ic = null;
        public static final String BAIDU = "2";
        public static final String YYUID = "1";
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ UVEventType this$0;

        public UserType(UVEventType uVEventType) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {uVEventType};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = uVEventType;
        }
    }

    public UVEventType() {
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
