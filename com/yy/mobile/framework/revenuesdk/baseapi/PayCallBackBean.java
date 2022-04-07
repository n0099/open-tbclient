package com.yy.mobile.framework.revenuesdk.baseapi;

import androidx.annotation.Keep;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.retrieve.log.bean.FetchLog;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.tieba.recapp.report.AdUploadHttpRequest;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
@Keep
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u001a\b\u0087\b\u0018\u0000B\u008d\u0001\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0001\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0001\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0001\u0012\b\b\u0002\u0010\u0016\u001a\u00020\t\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0001\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0001\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0001\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0001\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0010\u0012\u001a\b\u0002\u0010\u001c\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u0004¢\u0006\u0004\b<\u0010=J\u0012\u0010\u0002\u001a\u0004\u0018\u00010\u0001HÆ\u0003¢\u0006\u0004\b\u0002\u0010\u0003J\"\u0010\u0005\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u0004HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u0001HÆ\u0003¢\u0006\u0004\b\u0007\u0010\u0003J\u0012\u0010\b\u001a\u0004\u0018\u00010\u0001HÆ\u0003¢\u0006\u0004\b\b\u0010\u0003J\u0010\u0010\n\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0012\u0010\f\u001a\u0004\u0018\u00010\u0001HÆ\u0003¢\u0006\u0004\b\f\u0010\u0003J\u0012\u0010\r\u001a\u0004\u0018\u00010\u0001HÆ\u0003¢\u0006\u0004\b\r\u0010\u0003J\u0012\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÆ\u0003¢\u0006\u0004\b\u000e\u0010\u0003J\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÆ\u0003¢\u0006\u0004\b\u000f\u0010\u0003J\u0012\u0010\u0011\u001a\u0004\u0018\u00010\u0010HÆ\u0003¢\u0006\u0004\b\u0011\u0010\u0012J\u0096\u0001\u0010\u001d\u001a\u00020\u00002\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00012\b\b\u0002\u0010\u0016\u001a\u00020\t2\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u00102\u001a\b\u0002\u0010\u001c\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u0004HÆ\u0001¢\u0006\u0004\b\u001d\u0010\u001eJ\u001a\u0010\"\u001a\u00020!2\b\u0010 \u001a\u0004\u0018\u00010\u001fHÖ\u0003¢\u0006\u0004\b\"\u0010#J\u0010\u0010%\u001a\u00020$HÖ\u0001¢\u0006\u0004\b%\u0010&J\u0010\u0010'\u001a\u00020\u0001HÖ\u0001¢\u0006\u0004\b'\u0010\u0003R4\u0010\u001c\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010(\u001a\u0004\b)\u0010\u0006\"\u0004\b*\u0010+R\u001b\u0010\u0017\u001a\u0004\u0018\u00010\u00018\u0006@\u0006¢\u0006\f\n\u0004\b\u0017\u0010,\u001a\u0004\b-\u0010\u0003R$\u0010\u0015\u001a\u0004\u0018\u00010\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010,\u001a\u0004\b.\u0010\u0003\"\u0004\b/\u00100R$\u0010\u0013\u001a\u0004\u0018\u00010\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010,\u001a\u0004\b1\u0010\u0003\"\u0004\b2\u00100R\u001b\u0010\u0018\u001a\u0004\u0018\u00010\u00018\u0006@\u0006¢\u0006\f\n\u0004\b\u0018\u0010,\u001a\u0004\b3\u0010\u0003R$\u0010\u0014\u001a\u0004\u0018\u00010\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010,\u001a\u0004\b4\u0010\u0003\"\u0004\b5\u00100R\u001b\u0010\u0019\u001a\u0004\u0018\u00010\u00018\u0006@\u0006¢\u0006\f\n\u0004\b\u0019\u0010,\u001a\u0004\b6\u0010\u0003R\u001b\u0010\u001a\u001a\u0004\u0018\u00010\u00018\u0006@\u0006¢\u0006\f\n\u0004\b\u001a\u0010,\u001a\u0004\b7\u0010\u0003R\u001b\u0010\u001b\u001a\u0004\u0018\u00010\u00108\u0006@\u0006¢\u0006\f\n\u0004\b\u001b\u00108\u001a\u0004\b9\u0010\u0012R\u0019\u0010\u0016\u001a\u00020\t8\u0006@\u0006¢\u0006\f\n\u0004\b\u0016\u0010:\u001a\u0004\b;\u0010\u000b¨\u0006>"}, d2 = {"Lcom/yy/mobile/framework/revenuesdk/baseapi/PayCallBackBean;", "", "component1", "()Ljava/lang/String;", "", "component10", "()Ljava/util/Map;", "component2", "component3", "", "component4", "()J", "component5", "component6", "component7", "component8", "Lcom/yy/mobile/framework/revenuesdk/baseapi/PurchaseStatus;", "component9", "()Lcom/yy/mobile/framework/revenuesdk/baseapi/PurchaseStatus;", "orderId", AdUploadHttpRequest.KEY_PRODUCT_ID, "gpOrder", FetchLog.START_TIME, "chOrderid", "payLoad", "purchaseData", "purchaseSign", "purchaseStatus", "appClientExpand", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/yy/mobile/framework/revenuesdk/baseapi/PurchaseStatus;Ljava/util/Map;)Lcom/yy/mobile/framework/revenuesdk/baseapi/PayCallBackBean;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", TTDownloadField.TT_HASHCODE, "()I", "toString", "Ljava/util/Map;", "getAppClientExpand", "setAppClientExpand", "(Ljava/util/Map;)V", "Ljava/lang/String;", "getChOrderid", "getGpOrder", "setGpOrder", "(Ljava/lang/String;)V", "getOrderId", "setOrderId", "getPayLoad", "getProductId", "setProductId", "getPurchaseData", "getPurchaseSign", "Lcom/yy/mobile/framework/revenuesdk/baseapi/PurchaseStatus;", "getPurchaseStatus", "J", "getStartTime", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/yy/mobile/framework/revenuesdk/baseapi/PurchaseStatus;Ljava/util/Map;)V", "paybaseapi_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes8.dex */
public final class PayCallBackBean {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Map<String, String> appClientExpand;
    public final String chOrderid;
    public String gpOrder;
    public String orderId;
    public final String payLoad;
    public String productId;
    public final String purchaseData;
    public final String purchaseSign;
    public final PurchaseStatus purchaseStatus;
    public final long startTime;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PayCallBackBean() {
        this(null, null, null, 0L, null, null, null, null, null, null, 1023, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr = newInitContext.callArgs;
                this((String) objArr[0], (String) objArr[1], (String) objArr[2], ((Long) objArr[3]).longValue(), (String) objArr[4], (String) objArr[5], (String) objArr[6], (String) objArr[7], (PurchaseStatus) objArr[8], (Map) objArr[9], ((Integer) objArr[10]).intValue(), (DefaultConstructorMarker) objArr[11]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public PayCallBackBean(String str, String str2, String str3, long j, String str4, String str5, String str6, String str7, PurchaseStatus purchaseStatus, Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r3;
            Object[] objArr = {str, str2, str3, Long.valueOf(j), str4, str5, str6, str7, purchaseStatus, map};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.orderId = str;
        this.productId = str2;
        this.gpOrder = str3;
        this.startTime = j;
        this.chOrderid = str4;
        this.payLoad = str5;
        this.purchaseData = str6;
        this.purchaseSign = str7;
        this.purchaseStatus = purchaseStatus;
        this.appClientExpand = map;
    }

    public final String component1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.orderId : (String) invokeV.objValue;
    }

    public final Map<String, String> component10() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.appClientExpand : (Map) invokeV.objValue;
    }

    public final String component2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.productId : (String) invokeV.objValue;
    }

    public final String component3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.gpOrder : (String) invokeV.objValue;
    }

    public final long component4() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.startTime : invokeV.longValue;
    }

    public final String component5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.chOrderid : (String) invokeV.objValue;
    }

    public final String component6() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.payLoad : (String) invokeV.objValue;
    }

    public final String component7() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.purchaseData : (String) invokeV.objValue;
    }

    public final String component8() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.purchaseSign : (String) invokeV.objValue;
    }

    public final PurchaseStatus component9() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.purchaseStatus : (PurchaseStatus) invokeV.objValue;
    }

    public final PayCallBackBean copy(String str, String str2, String str3, long j, String str4, String str5, String str6, String str7, PurchaseStatus purchaseStatus, Map<String, String> map) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048586, this, new Object[]{str, str2, str3, Long.valueOf(j), str4, str5, str6, str7, purchaseStatus, map})) == null) ? new PayCallBackBean(str, str2, str3, j, str4, str5, str6, str7, purchaseStatus, map) : (PayCallBackBean) invokeCommon.objValue;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, obj)) == null) {
            if (this != obj) {
                if (obj instanceof PayCallBackBean) {
                    PayCallBackBean payCallBackBean = (PayCallBackBean) obj;
                    if (Intrinsics.areEqual(this.orderId, payCallBackBean.orderId) && Intrinsics.areEqual(this.productId, payCallBackBean.productId) && Intrinsics.areEqual(this.gpOrder, payCallBackBean.gpOrder)) {
                        if (!(this.startTime == payCallBackBean.startTime) || !Intrinsics.areEqual(this.chOrderid, payCallBackBean.chOrderid) || !Intrinsics.areEqual(this.payLoad, payCallBackBean.payLoad) || !Intrinsics.areEqual(this.purchaseData, payCallBackBean.purchaseData) || !Intrinsics.areEqual(this.purchaseSign, payCallBackBean.purchaseSign) || !Intrinsics.areEqual(this.purchaseStatus, payCallBackBean.purchaseStatus) || !Intrinsics.areEqual(this.appClientExpand, payCallBackBean.appClientExpand)) {
                        }
                    }
                }
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public final Map<String, String> getAppClientExpand() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.appClientExpand : (Map) invokeV.objValue;
    }

    public final String getChOrderid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.chOrderid : (String) invokeV.objValue;
    }

    public final String getGpOrder() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.gpOrder : (String) invokeV.objValue;
    }

    public final String getOrderId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.orderId : (String) invokeV.objValue;
    }

    public final String getPayLoad() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.payLoad : (String) invokeV.objValue;
    }

    public final String getProductId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.productId : (String) invokeV.objValue;
    }

    public final String getPurchaseData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.purchaseData : (String) invokeV.objValue;
    }

    public final String getPurchaseSign() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.purchaseSign : (String) invokeV.objValue;
    }

    public final PurchaseStatus getPurchaseStatus() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.purchaseStatus : (PurchaseStatus) invokeV.objValue;
    }

    public final long getStartTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? this.startTime : invokeV.longValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            String str = this.orderId;
            int hashCode = (str != null ? str.hashCode() : 0) * 31;
            String str2 = this.productId;
            int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
            String str3 = this.gpOrder;
            int hashCode3 = str3 != null ? str3.hashCode() : 0;
            long j = this.startTime;
            int i = (((hashCode2 + hashCode3) * 31) + ((int) (j ^ (j >>> 32)))) * 31;
            String str4 = this.chOrderid;
            int hashCode4 = (i + (str4 != null ? str4.hashCode() : 0)) * 31;
            String str5 = this.payLoad;
            int hashCode5 = (hashCode4 + (str5 != null ? str5.hashCode() : 0)) * 31;
            String str6 = this.purchaseData;
            int hashCode6 = (hashCode5 + (str6 != null ? str6.hashCode() : 0)) * 31;
            String str7 = this.purchaseSign;
            int hashCode7 = (hashCode6 + (str7 != null ? str7.hashCode() : 0)) * 31;
            PurchaseStatus purchaseStatus = this.purchaseStatus;
            int hashCode8 = (hashCode7 + (purchaseStatus != null ? purchaseStatus.hashCode() : 0)) * 31;
            Map<String, String> map = this.appClientExpand;
            return hashCode8 + (map != null ? map.hashCode() : 0);
        }
        return invokeV.intValue;
    }

    public final void setAppClientExpand(Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, map) == null) {
            this.appClientExpand = map;
        }
    }

    public final void setGpOrder(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, str) == null) {
            this.gpOrder = str;
        }
    }

    public final void setOrderId(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, str) == null) {
            this.orderId = str;
        }
    }

    public final void setProductId(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, str) == null) {
            this.productId = str;
        }
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            return "PayCallBackBean(orderId=" + this.orderId + ", productId=" + this.productId + ", gpOrder=" + this.gpOrder + ", startTime=" + this.startTime + ", chOrderid=" + this.chOrderid + ", payLoad=" + this.payLoad + ", purchaseData=" + this.purchaseData + ", purchaseSign=" + this.purchaseSign + ", purchaseStatus=" + this.purchaseStatus + ", appClientExpand=" + this.appClientExpand + SmallTailInfo.EMOTION_SUFFIX;
        }
        return (String) invokeV.objValue;
    }

    public /* synthetic */ PayCallBackBean(String str, String str2, String str3, long j, String str4, String str5, String str6, String str7, PurchaseStatus purchaseStatus, Map map, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? 0L : j, (i & 16) != 0 ? null : str4, (i & 32) != 0 ? null : str5, (i & 64) != 0 ? null : str6, (i & 128) != 0 ? null : str7, (i & 256) != 0 ? null : purchaseStatus, (i & 512) == 0 ? map : null);
    }
}
