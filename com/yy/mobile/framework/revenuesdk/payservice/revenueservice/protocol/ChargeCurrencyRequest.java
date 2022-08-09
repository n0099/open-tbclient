package com.yy.mobile.framework.revenuesdk.payservice.revenueservice.protocol;

import android.text.TextUtils;
import com.baidu.sapi2.activity.BaseActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.mobile.framework.revenuesdk.baseapi.log.RLog;
import com.yy.mobile.framework.revenuesdk.payservice.revenueservice.request.IRequestProtocol;
import com.yy.mobile.framework.revenuesdk.statistics.hiido.uievent.PayUiEventContent;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class ChargeCurrencyRequest implements IRequestProtocol {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public double amount;
    public int appId;
    public int chargeCurrencyConfigId;
    public String clientVersion;
    public int currencyType;
    public String expand;
    public boolean needUnicast;
    public String payChannel;
    public String payMethod;
    public String returnUrl;
    public String seq;
    public int sid;
    public long uid;
    public int usedChannel;

    /* loaded from: classes8.dex */
    public static class ExpandBuilder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final String hdid;
        public final String product_id;
        public final int quantity;
        public final String srcCurrencySymbol;
        public final Double unitPrice;

        public ExpandBuilder(int i, Double d, String str, String str2, String str3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i), d, str, str2, str3};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.quantity = i;
            this.unitPrice = d;
            this.product_id = str;
            this.hdid = str2;
            this.srcCurrencySymbol = str3;
        }

        public String toJson() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("quantity", this.quantity);
                    jSONObject.put("unitPrice", this.unitPrice);
                    jSONObject.put("product_id", this.product_id);
                    jSONObject.put("hdid", this.hdid);
                    jSONObject.put("srcCurrencySymbol", this.srcCurrencySymbol);
                } catch (JSONException e) {
                    RLog.error("ChargeCurrencyRequest", "ExpandBuilder.toJson", e);
                }
                return jSONObject.toString();
            }
            return (String) invokeV.objValue;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ChargeCurrencyRequest(int i, int i2, String str, String str2, String str3, double d) {
        this(0L, i, i2, str, str2, str3, d);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i), Integer.valueOf(i2), str, str2, str3, Double.valueOf(d)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this(((Long) objArr2[0]).longValue(), ((Integer) objArr2[1]).intValue(), ((Integer) objArr2[2]).intValue(), (String) objArr2[3], (String) objArr2[4], (String) objArr2[5], ((Double) objArr2[6]).doubleValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // com.yy.mobile.framework.revenuesdk.payservice.revenueservice.request.IRequestProtocol
    public String getProtocol() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("cmd", 1022);
                jSONObject.put("uid", this.uid);
                jSONObject.put("sid", this.sid);
                jSONObject.put(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, this.appId);
                jSONObject.put("usedChannel", this.usedChannel);
                jSONObject.put("currencyType", this.currencyType);
                jSONObject.put("seq", this.seq);
                jSONObject.put("payChannel", this.payChannel);
                jSONObject.put("payMethod", this.payMethod);
                jSONObject.put(PayUiEventContent.AMOUNT, this.amount);
                jSONObject.put("chargeCurrencyConfigId", this.chargeCurrencyConfigId);
                jSONObject.put("needUnicast", this.needUnicast);
                jSONObject.put("returnUrl", this.returnUrl);
                jSONObject.put("clientVersion", this.clientVersion);
                if (!TextUtils.isEmpty(this.expand)) {
                    jSONObject.put("expand", this.expand);
                }
                return jSONObject.toString();
            } catch (JSONException e) {
                RLog.error("ChargeCurrencyRequest", "constructPSCIMessageRequest", e);
                return "";
            }
        }
        return (String) invokeV.objValue;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ChargeCurrencyRequest(long j, int i, int i2, String str, String str2, String str3, double d) {
        this(j, 0, i, 10002, i2, str, str2, str3, d, 0, true, "", "", "1.0.0", "");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r3;
            Object[] objArr = {Long.valueOf(j), Integer.valueOf(i), Integer.valueOf(i2), str, str2, str3, Double.valueOf(d)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this(((Long) objArr2[0]).longValue(), ((Integer) objArr2[1]).intValue(), ((Integer) objArr2[2]).intValue(), ((Integer) objArr2[3]).intValue(), ((Integer) objArr2[4]).intValue(), (String) objArr2[5], (String) objArr2[6], (String) objArr2[7], ((Double) objArr2[8]).doubleValue(), ((Integer) objArr2[9]).intValue(), ((Boolean) objArr2[10]).booleanValue(), (String) objArr2[11], (String) objArr2[12], (String) objArr2[13], (String) objArr2[14]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
    }

    public ChargeCurrencyRequest(long j, int i, int i2, int i3, int i4, String str, String str2, String str3, double d, int i5, boolean z, String str4, String str5, String str6, String str7) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Long.valueOf(j), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), str, str2, str3, Double.valueOf(d), Integer.valueOf(i5), Boolean.valueOf(z), str4, str5, str6, str7};
            interceptable.invokeUnInit(65537, newInitContext);
            int i6 = newInitContext.flag;
            if ((i6 & 1) != 0) {
                int i7 = i6 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.sid = 0;
        this.usedChannel = 10002;
        this.chargeCurrencyConfigId = 0;
        this.needUnicast = true;
        this.returnUrl = "";
        this.expand = "";
        this.clientVersion = "";
        this.uid = j;
        this.sid = i;
        this.appId = i2;
        this.usedChannel = i3;
        this.currencyType = i4;
        this.seq = str;
        this.payChannel = str2;
        this.payMethod = str3;
        this.amount = d;
        this.chargeCurrencyConfigId = i5;
        this.needUnicast = z;
        this.returnUrl = str4;
        this.expand = str5;
        this.clientVersion = str6;
    }
}
