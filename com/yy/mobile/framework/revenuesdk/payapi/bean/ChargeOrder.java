package com.yy.mobile.framework.revenuesdk.payapi.bean;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u001a\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b+\b\u0086\b\u0018\u0000B\u007f\u0012\u0006\u0010\u0016\u001a\u00020\u0001\u0012\u0006\u0010\u0017\u001a\u00020\f\u0012\u0006\u0010\u0018\u001a\u00020\u0004\u0012\u0006\u0010\u0019\u001a\u00020\u0001\u0012\u0006\u0010\u001a\u001a\u00020\u0001\u0012\u0006\u0010\u001b\u001a\u00020\f\u0012\u0006\u0010\u001c\u001a\u00020\u0004\u0012\u0006\u0010\u001d\u001a\u00020\u0004\u0012\u0006\u0010\u001e\u001a\u00020\u0004\u0012\u0006\u0010\u001f\u001a\u00020\u0004\u0012\u0006\u0010 \u001a\u00020\u0004\u0012\u0006\u0010!\u001a\u00020\u0004\u0012\u0006\u0010\"\u001a\u00020\u0004\u0012\u0006\u0010#\u001a\u00020\u0001\u0012\u0006\u0010$\u001a\u00020\u0004¢\u0006\u0004\bR\u0010SJ\u0010\u0010\u0002\u001a\u00020\u0001HÆ\u0003¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0005\u001a\u00020\u0004HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\u0007\u001a\u00020\u0004HÆ\u0003¢\u0006\u0004\b\u0007\u0010\u0006J\u0010\u0010\b\u001a\u00020\u0004HÆ\u0003¢\u0006\u0004\b\b\u0010\u0006J\u0010\u0010\t\u001a\u00020\u0004HÆ\u0003¢\u0006\u0004\b\t\u0010\u0006J\u0010\u0010\n\u001a\u00020\u0001HÆ\u0003¢\u0006\u0004\b\n\u0010\u0003J\u0010\u0010\u000b\u001a\u00020\u0004HÆ\u0003¢\u0006\u0004\b\u000b\u0010\u0006J\u0010\u0010\r\u001a\u00020\fHÆ\u0003¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u000f\u001a\u00020\u0004HÆ\u0003¢\u0006\u0004\b\u000f\u0010\u0006J\u0010\u0010\u0010\u001a\u00020\u0001HÆ\u0003¢\u0006\u0004\b\u0010\u0010\u0003J\u0010\u0010\u0011\u001a\u00020\u0001HÆ\u0003¢\u0006\u0004\b\u0011\u0010\u0003J\u0010\u0010\u0012\u001a\u00020\fHÆ\u0003¢\u0006\u0004\b\u0012\u0010\u000eJ\u0010\u0010\u0013\u001a\u00020\u0004HÆ\u0003¢\u0006\u0004\b\u0013\u0010\u0006J\u0010\u0010\u0014\u001a\u00020\u0004HÆ\u0003¢\u0006\u0004\b\u0014\u0010\u0006J\u0010\u0010\u0015\u001a\u00020\u0004HÆ\u0003¢\u0006\u0004\b\u0015\u0010\u0006J¦\u0001\u0010%\u001a\u00020\u00002\b\b\u0002\u0010\u0016\u001a\u00020\u00012\b\b\u0002\u0010\u0017\u001a\u00020\f2\b\b\u0002\u0010\u0018\u001a\u00020\u00042\b\b\u0002\u0010\u0019\u001a\u00020\u00012\b\b\u0002\u0010\u001a\u001a\u00020\u00012\b\b\u0002\u0010\u001b\u001a\u00020\f2\b\b\u0002\u0010\u001c\u001a\u00020\u00042\b\b\u0002\u0010\u001d\u001a\u00020\u00042\b\b\u0002\u0010\u001e\u001a\u00020\u00042\b\b\u0002\u0010\u001f\u001a\u00020\u00042\b\b\u0002\u0010 \u001a\u00020\u00042\b\b\u0002\u0010!\u001a\u00020\u00042\b\b\u0002\u0010\"\u001a\u00020\u00042\b\b\u0002\u0010#\u001a\u00020\u00012\b\b\u0002\u0010$\u001a\u00020\u0004HÆ\u0001¢\u0006\u0004\b%\u0010&J\u001a\u0010*\u001a\u00020)2\b\u0010(\u001a\u0004\u0018\u00010'HÖ\u0003¢\u0006\u0004\b*\u0010+J\u0010\u0010,\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b,\u0010\u0006J\u0010\u0010-\u001a\u00020\u0001HÖ\u0001¢\u0006\u0004\b-\u0010\u0003R\"\u0010$\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b$\u0010.\u001a\u0004\b/\u0010\u0006\"\u0004\b0\u00101R\"\u0010\u0017\u001a\u00020\f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0017\u00102\u001a\u0004\b3\u0010\u000e\"\u0004\b4\u00105R\"\u0010\u0019\u001a\u00020\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0019\u00106\u001a\u0004\b7\u0010\u0003\"\u0004\b8\u00109R\"\u0010 \u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b \u0010.\u001a\u0004\b:\u0010\u0006\"\u0004\b;\u00101R\"\u0010!\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b!\u0010.\u001a\u0004\b<\u0010\u0006\"\u0004\b=\u00101R\"\u0010\u0018\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010.\u001a\u0004\b>\u0010\u0006\"\u0004\b?\u00101R\"\u0010\u001b\u001a\u00020\f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001b\u00102\u001a\u0004\b@\u0010\u000e\"\u0004\bA\u00105R\"\u0010\u001e\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001e\u0010.\u001a\u0004\bB\u0010\u0006\"\u0004\bC\u00101R\"\u0010\u001d\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010.\u001a\u0004\bD\u0010\u0006\"\u0004\bE\u00101R\"\u0010#\u001a\u00020\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b#\u00106\u001a\u0004\bF\u0010\u0003\"\u0004\bG\u00109R\"\u0010\"\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\"\u0010.\u001a\u0004\bH\u0010\u0006\"\u0004\bI\u00101R\"\u0010\u001a\u001a\u00020\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001a\u00106\u001a\u0004\bJ\u0010\u0003\"\u0004\bK\u00109R\"\u0010\u0016\u001a\u00020\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0016\u00106\u001a\u0004\bL\u0010\u0003\"\u0004\bM\u00109R\"\u0010\u001f\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010.\u001a\u0004\bN\u0010\u0006\"\u0004\bO\u00101R\"\u0010\u001c\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010.\u001a\u0004\bP\u0010\u0006\"\u0004\bQ\u00101¨\u0006T"}, d2 = {"Lcom/yy/mobile/framework/revenuesdk/payapi/bean/ChargeOrder;", "", "component1", "()Ljava/lang/String;", "", "component10", "()I", "component11", "component12", "component13", "component14", "component15", "", "component2", "()J", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "rechargeAmount", "createTime", "diamondAmount", "currencySymbol", "payChannel", "id", "status", "offersType", "offersRate", "srcAmount", "destAmount", "destCurrencyType", "payAmount", "otherChargeOrderId", "chargeConfigType", "copy", "(Ljava/lang/String;JILjava/lang/String;Ljava/lang/String;JIIIIIIILjava/lang/String;I)Lcom/yy/mobile/framework/revenuesdk/payapi/bean/ChargeOrder;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "toString", "I", "getChargeConfigType", "setChargeConfigType", "(I)V", "J", "getCreateTime", "setCreateTime", "(J)V", "Ljava/lang/String;", "getCurrencySymbol", "setCurrencySymbol", "(Ljava/lang/String;)V", "getDestAmount", "setDestAmount", "getDestCurrencyType", "setDestCurrencyType", "getDiamondAmount", "setDiamondAmount", "getId", "setId", "getOffersRate", "setOffersRate", "getOffersType", "setOffersType", "getOtherChargeOrderId", "setOtherChargeOrderId", "getPayAmount", "setPayAmount", "getPayChannel", "setPayChannel", "getRechargeAmount", "setRechargeAmount", "getSrcAmount", "setSrcAmount", "getStatus", "setStatus", "<init>", "(Ljava/lang/String;JILjava/lang/String;Ljava/lang/String;JIIIIIIILjava/lang/String;I)V", "paycore_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes6.dex */
public final class ChargeOrder {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int chargeConfigType;
    public long createTime;
    public String currencySymbol;
    public int destAmount;
    public int destCurrencyType;
    public int diamondAmount;
    public long id;
    public int offersRate;
    public int offersType;
    public String otherChargeOrderId;
    public int payAmount;
    public String payChannel;
    public String rechargeAmount;
    public int srcAmount;
    public int status;

    public ChargeOrder(String str, long j, int i2, String str2, String str3, long j2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, String str4, int i10) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Long.valueOf(j), Integer.valueOf(i2), str2, str3, Long.valueOf(j2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7), Integer.valueOf(i8), Integer.valueOf(i9), str4, Integer.valueOf(i10)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i11 = newInitContext.flag;
            if ((i11 & 1) != 0) {
                int i12 = i11 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.rechargeAmount = str;
        this.createTime = j;
        this.diamondAmount = i2;
        this.currencySymbol = str2;
        this.payChannel = str3;
        this.id = j2;
        this.status = i3;
        this.offersType = i4;
        this.offersRate = i5;
        this.srcAmount = i6;
        this.destAmount = i7;
        this.destCurrencyType = i8;
        this.payAmount = i9;
        this.otherChargeOrderId = str4;
        this.chargeConfigType = i10;
    }

    public final String component1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.rechargeAmount : (String) invokeV.objValue;
    }

    public final int component10() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.srcAmount : invokeV.intValue;
    }

    public final int component11() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.destAmount : invokeV.intValue;
    }

    public final int component12() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.destCurrencyType : invokeV.intValue;
    }

    public final int component13() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.payAmount : invokeV.intValue;
    }

    public final String component14() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.otherChargeOrderId : (String) invokeV.objValue;
    }

    public final int component15() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.chargeConfigType : invokeV.intValue;
    }

    public final long component2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.createTime : invokeV.longValue;
    }

    public final int component3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.diamondAmount : invokeV.intValue;
    }

    public final String component4() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.currencySymbol : (String) invokeV.objValue;
    }

    public final String component5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.payChannel : (String) invokeV.objValue;
    }

    public final long component6() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.id : invokeV.longValue;
    }

    public final int component7() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.status : invokeV.intValue;
    }

    public final int component8() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.offersType : invokeV.intValue;
    }

    public final int component9() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.offersRate : invokeV.intValue;
    }

    public final ChargeOrder copy(String str, long j, int i2, String str2, String str3, long j2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, String str4, int i10) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048591, this, new Object[]{str, Long.valueOf(j), Integer.valueOf(i2), str2, str3, Long.valueOf(j2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7), Integer.valueOf(i8), Integer.valueOf(i9), str4, Integer.valueOf(i10)})) == null) ? new ChargeOrder(str, j, i2, str2, str3, j2, i3, i4, i5, i6, i7, i8, i9, str4, i10) : (ChargeOrder) invokeCommon.objValue;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, obj)) == null) {
            if (this != obj) {
                if (obj instanceof ChargeOrder) {
                    ChargeOrder chargeOrder = (ChargeOrder) obj;
                    if (Intrinsics.areEqual(this.rechargeAmount, chargeOrder.rechargeAmount)) {
                        if (this.createTime == chargeOrder.createTime) {
                            if ((this.diamondAmount == chargeOrder.diamondAmount) && Intrinsics.areEqual(this.currencySymbol, chargeOrder.currencySymbol) && Intrinsics.areEqual(this.payChannel, chargeOrder.payChannel)) {
                                if (this.id == chargeOrder.id) {
                                    if (this.status == chargeOrder.status) {
                                        if (this.offersType == chargeOrder.offersType) {
                                            if (this.offersRate == chargeOrder.offersRate) {
                                                if (this.srcAmount == chargeOrder.srcAmount) {
                                                    if (this.destAmount == chargeOrder.destAmount) {
                                                        if (this.destCurrencyType == chargeOrder.destCurrencyType) {
                                                            if ((this.payAmount == chargeOrder.payAmount) && Intrinsics.areEqual(this.otherChargeOrderId, chargeOrder.otherChargeOrderId)) {
                                                                if (this.chargeConfigType == chargeOrder.chargeConfigType) {
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public final int getChargeConfigType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.chargeConfigType : invokeV.intValue;
    }

    public final long getCreateTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.createTime : invokeV.longValue;
    }

    public final String getCurrencySymbol() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.currencySymbol : (String) invokeV.objValue;
    }

    public final int getDestAmount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.destAmount : invokeV.intValue;
    }

    public final int getDestCurrencyType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? this.destCurrencyType : invokeV.intValue;
    }

    public final int getDiamondAmount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? this.diamondAmount : invokeV.intValue;
    }

    public final long getId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? this.id : invokeV.longValue;
    }

    public final int getOffersRate() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? this.offersRate : invokeV.intValue;
    }

    public final int getOffersType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? this.offersType : invokeV.intValue;
    }

    public final String getOtherChargeOrderId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) ? this.otherChargeOrderId : (String) invokeV.objValue;
    }

    public final int getPayAmount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) ? this.payAmount : invokeV.intValue;
    }

    public final String getPayChannel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) ? this.payChannel : (String) invokeV.objValue;
    }

    public final String getRechargeAmount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) ? this.rechargeAmount : (String) invokeV.objValue;
    }

    public final int getSrcAmount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) ? this.srcAmount : invokeV.intValue;
    }

    public final int getStatus() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) ? this.status : invokeV.intValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) {
            String str = this.rechargeAmount;
            int hashCode = str != null ? str.hashCode() : 0;
            long j = this.createTime;
            int i2 = ((((hashCode * 31) + ((int) (j ^ (j >>> 32)))) * 31) + this.diamondAmount) * 31;
            String str2 = this.currencySymbol;
            int hashCode2 = (i2 + (str2 != null ? str2.hashCode() : 0)) * 31;
            String str3 = this.payChannel;
            int hashCode3 = str3 != null ? str3.hashCode() : 0;
            long j2 = this.id;
            int i3 = (((((((((((((((((hashCode2 + hashCode3) * 31) + ((int) (j2 ^ (j2 >>> 32)))) * 31) + this.status) * 31) + this.offersType) * 31) + this.offersRate) * 31) + this.srcAmount) * 31) + this.destAmount) * 31) + this.destCurrencyType) * 31) + this.payAmount) * 31;
            String str4 = this.otherChargeOrderId;
            return ((i3 + (str4 != null ? str4.hashCode() : 0)) * 31) + this.chargeConfigType;
        }
        return invokeV.intValue;
    }

    public final void setChargeConfigType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048609, this, i2) == null) {
            this.chargeConfigType = i2;
        }
    }

    public final void setCreateTime(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048610, this, j) == null) {
            this.createTime = j;
        }
    }

    public final void setCurrencySymbol(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048611, this, str) == null) {
            this.currencySymbol = str;
        }
    }

    public final void setDestAmount(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048612, this, i2) == null) {
            this.destAmount = i2;
        }
    }

    public final void setDestCurrencyType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048613, this, i2) == null) {
            this.destCurrencyType = i2;
        }
    }

    public final void setDiamondAmount(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048614, this, i2) == null) {
            this.diamondAmount = i2;
        }
    }

    public final void setId(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048615, this, j) == null) {
            this.id = j;
        }
    }

    public final void setOffersRate(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048616, this, i2) == null) {
            this.offersRate = i2;
        }
    }

    public final void setOffersType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048617, this, i2) == null) {
            this.offersType = i2;
        }
    }

    public final void setOtherChargeOrderId(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048618, this, str) == null) {
            this.otherChargeOrderId = str;
        }
    }

    public final void setPayAmount(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048619, this, i2) == null) {
            this.payAmount = i2;
        }
    }

    public final void setPayChannel(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048620, this, str) == null) {
            this.payChannel = str;
        }
    }

    public final void setRechargeAmount(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048621, this, str) == null) {
            this.rechargeAmount = str;
        }
    }

    public final void setSrcAmount(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048622, this, i2) == null) {
            this.srcAmount = i2;
        }
    }

    public final void setStatus(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048623, this, i2) == null) {
            this.status = i2;
        }
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048624, this)) == null) {
            return "ChargeOrder(rechargeAmount=" + this.rechargeAmount + ", createTime=" + this.createTime + ", diamondAmount=" + this.diamondAmount + ", currencySymbol=" + this.currencySymbol + ", payChannel=" + this.payChannel + ", id=" + this.id + ", status=" + this.status + ", offersType=" + this.offersType + ", offersRate=" + this.offersRate + ", srcAmount=" + this.srcAmount + ", destAmount=" + this.destAmount + ", destCurrencyType=" + this.destCurrencyType + ", payAmount=" + this.payAmount + ", otherChargeOrderId=" + this.otherChargeOrderId + ", chargeConfigType=" + this.chargeConfigType + SmallTailInfo.EMOTION_SUFFIX;
        }
        return (String) invokeV.objValue;
    }
}
