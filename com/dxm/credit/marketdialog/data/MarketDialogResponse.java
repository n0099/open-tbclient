package com.dxm.credit.marketdialog.data;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.apollon.beans.IBeanResponse;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.core.NoProguard;
import com.baidu.wallet.core.utils.LogUtil;
import java.io.Serializable;
/* loaded from: classes12.dex */
public class MarketDialogResponse implements IBeanResponse, NoProguard, Serializable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Dialog[] immediate;
    public transient boolean immediate_changed;
    public String immediate_md5;
    public Dialog[] polling;
    public transient boolean polling_changed;
    public String polling_md5;

    /* loaded from: classes12.dex */
    public static class Button implements NoProguard, Serializable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String link_addr;
        public String name;
        public String type;

        public Button() {
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

        public boolean isValid() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? (TextUtils.isEmpty(this.name) || TextUtils.isEmpty(this.type) || TextUtils.isEmpty(this.link_addr)) ? false : true : invokeV.booleanValue;
        }
    }

    /* loaded from: classes12.dex */
    public static class Coupon implements NoProguard, Serializable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String business;
        public CouponButton[] buttons;
        public String coupon_id;
        public String desc;
        public String detail;
        public String logo;
        public String name;

        public Coupon() {
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

    /* loaded from: classes12.dex */
    public static class CouponButton extends Button implements NoProguard, Serializable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String style;

        public CouponButton() {
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

    /* loaded from: classes12.dex */
    public static class CreditScore implements NoProguard, Serializable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String background;
        public String desc;
        public String icon;
        public String pre_value;
        public String title;
        public String value;

        public CreditScore() {
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

    /* loaded from: classes12.dex */
    public static class Dialog implements NoProguard, Serializable {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = -4139480570358932040L;
        public transient /* synthetic */ FieldHolder $fh;
        public CreditScore credit_score;
        public String[] group_bottom_background;
        public Button[] group_buttons;
        public T7ItemDesc[] group_content;
        public String group_day_limit;
        public String group_desc;
        public String group_detail;
        public String group_hide;
        public String group_img;
        public String group_layout;
        public String group_limit;
        public String group_link_addr;
        public String group_link_type;
        public String group_md5;
        public String group_name;
        public String group_resource;
        public String group_size;
        public String group_style;
        public String[] group_top_background;
        public String group_top_img;
        public String group_type;
        public Coupon[] list;

        public Dialog() {
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

        public boolean isClickable() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? (TextUtils.isEmpty(this.group_link_type) || TextUtils.isEmpty(this.group_link_addr)) ? false : true : invokeV.booleanValue;
        }
    }

    /* loaded from: classes12.dex */
    public static class T7ItemDesc implements NoProguard, Serializable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String desc;
        public String desc_value;
        public String detail;
        public String name;

        public T7ItemDesc() {
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

    public MarketDialogResponse() {
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
        this.immediate_changed = false;
        this.polling_changed = false;
    }

    @Override // com.baidu.apollon.beans.IBeanResponse
    public boolean checkResponseValidity() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    public boolean isImmediateChanged() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.immediate_changed : invokeV.booleanValue;
    }

    public boolean isPollingChanged() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.polling_changed : invokeV.booleanValue;
    }

    public void setImmediateChanged(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            this.immediate_changed = z;
        }
    }

    public void setNetResponse(Context context, MarketDialogResponse marketDialogResponse) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048580, this, context, marketDialogResponse) == null) || marketDialogResponse == null) {
            return;
        }
        LogUtil.d("market", "setNetResponse o = " + marketDialogResponse);
        LogUtil.d("market", "setNetResponse old md5 = " + this.polling_md5 + " ; new md5 = " + marketDialogResponse.polling_md5);
        if (!TextUtils.isEmpty(marketDialogResponse.polling_md5) && !TextUtils.equals(marketDialogResponse.polling_md5, this.polling_md5)) {
            this.polling_md5 = marketDialogResponse.polling_md5;
            this.polling = marketDialogResponse.polling;
        }
        Dialog[] dialogArr = this.polling;
        if (dialogArr == null || dialogArr.length <= 0) {
            return;
        }
        setPollingChanged(true);
    }

    public void setPollingChanged(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            this.polling_changed = z;
        }
    }

    @Override // com.baidu.apollon.beans.IBeanResponse
    public void storeResponse(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, context) == null) {
        }
    }
}
