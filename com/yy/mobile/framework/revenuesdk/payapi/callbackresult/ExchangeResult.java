package com.yy.mobile.framework.revenuesdk.payapi.callbackresult;

import androidx.annotation.Keep;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import kotlin.Metadata;
@Keep
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0015\b\u0087\b\u0018\u0000B7\u0012\u0006\u0010\u000b\u001a\u00020\u0001\u0012\u0006\u0010\f\u001a\u00020\u0004\u0012\u0006\u0010\r\u001a\u00020\u0001\u0012\u0006\u0010\u000e\u001a\u00020\u0004\u0012\u0006\u0010\u000f\u001a\u00020\u0004\u0012\u0006\u0010\u0010\u001a\u00020\u0001¢\u0006\u0004\b,\u0010-J\u0010\u0010\u0002\u001a\u00020\u0001HÆ\u0003¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0005\u001a\u00020\u0004HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\u0007\u001a\u00020\u0001HÆ\u0003¢\u0006\u0004\b\u0007\u0010\u0003J\u0010\u0010\b\u001a\u00020\u0004HÆ\u0003¢\u0006\u0004\b\b\u0010\u0006J\u0010\u0010\t\u001a\u00020\u0004HÆ\u0003¢\u0006\u0004\b\t\u0010\u0006J\u0010\u0010\n\u001a\u00020\u0001HÆ\u0003¢\u0006\u0004\b\n\u0010\u0003JL\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u000b\u001a\u00020\u00012\b\b\u0002\u0010\f\u001a\u00020\u00042\b\b\u0002\u0010\r\u001a\u00020\u00012\b\b\u0002\u0010\u000e\u001a\u00020\u00042\b\b\u0002\u0010\u000f\u001a\u00020\u00042\b\b\u0002\u0010\u0010\u001a\u00020\u0001HÆ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u001a\u0010\u0016\u001a\u00020\u00152\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013HÖ\u0003¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0018\u001a\u00020\u0001HÖ\u0001¢\u0006\u0004\b\u0018\u0010\u0003J\u0010\u0010\u001a\u001a\u00020\u0019HÖ\u0001¢\u0006\u0004\b\u001a\u0010\u001bR\"\u0010\u000e\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010\u001c\u001a\u0004\b\u001d\u0010\u0006\"\u0004\b\u001e\u0010\u001fR\"\u0010\r\u001a\u00020\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\r\u0010 \u001a\u0004\b!\u0010\u0003\"\u0004\b\"\u0010#R\"\u0010\u0010\u001a\u00020\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010 \u001a\u0004\b$\u0010\u0003\"\u0004\b%\u0010#R\"\u0010\u000f\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u001c\u001a\u0004\b&\u0010\u0006\"\u0004\b'\u0010\u001fR\"\u0010\u000b\u001a\u00020\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010 \u001a\u0004\b(\u0010\u0003\"\u0004\b)\u0010#R\"\u0010\f\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u001c\u001a\u0004\b*\u0010\u0006\"\u0004\b+\u0010\u001f¨\u0006."}, d2 = {"Lcom/yy/mobile/framework/revenuesdk/payapi/callbackresult/ExchangeResult;", "", "component1", "()I", "", "component2", "()J", "component3", "component4", "component5", "component6", "srcCurrencyType", "srcRemainAmount", "destCurrencyType", "descRemainAmount", "exchangeDestAmount", "exchangeAmount", "copy", "(IJIJJI)Lcom/yy/mobile/framework/revenuesdk/payapi/callbackresult/ExchangeResult;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", TTDownloadField.TT_HASHCODE, "", "toString", "()Ljava/lang/String;", "J", "getDescRemainAmount", "setDescRemainAmount", "(J)V", "I", "getDestCurrencyType", "setDestCurrencyType", "(I)V", "getExchangeAmount", "setExchangeAmount", "getExchangeDestAmount", "setExchangeDestAmount", "getSrcCurrencyType", "setSrcCurrencyType", "getSrcRemainAmount", "setSrcRemainAmount", "<init>", "(IJIJJI)V", "paycore_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes4.dex */
public final class ExchangeResult {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public long descRemainAmount;
    public int destCurrencyType;
    public int exchangeAmount;
    public long exchangeDestAmount;
    public int srcCurrencyType;
    public long srcRemainAmount;

    public ExchangeResult(int i2, long j2, int i3, long j3, long j4, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2), Long.valueOf(j2), Integer.valueOf(i3), Long.valueOf(j3), Long.valueOf(j4), Integer.valueOf(i4)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i5 = newInitContext.flag;
            if ((i5 & 1) != 0) {
                int i6 = i5 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.srcCurrencyType = i2;
        this.srcRemainAmount = j2;
        this.destCurrencyType = i3;
        this.descRemainAmount = j3;
        this.exchangeDestAmount = j4;
        this.exchangeAmount = i4;
    }

    public final int component1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.srcCurrencyType : invokeV.intValue;
    }

    public final long component2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.srcRemainAmount : invokeV.longValue;
    }

    public final int component3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.destCurrencyType : invokeV.intValue;
    }

    public final long component4() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.descRemainAmount : invokeV.longValue;
    }

    public final long component5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.exchangeDestAmount : invokeV.longValue;
    }

    public final int component6() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.exchangeAmount : invokeV.intValue;
    }

    public final ExchangeResult copy(int i2, long j2, int i3, long j3, long j4, int i4) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048582, this, new Object[]{Integer.valueOf(i2), Long.valueOf(j2), Integer.valueOf(i3), Long.valueOf(j3), Long.valueOf(j4), Integer.valueOf(i4)})) == null) ? new ExchangeResult(i2, j2, i3, j3, j4, i4) : (ExchangeResult) invokeCommon.objValue;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, obj)) == null) {
            if (this != obj) {
                if (obj instanceof ExchangeResult) {
                    ExchangeResult exchangeResult = (ExchangeResult) obj;
                    if (this.srcCurrencyType == exchangeResult.srcCurrencyType) {
                        if (this.srcRemainAmount == exchangeResult.srcRemainAmount) {
                            if (this.destCurrencyType == exchangeResult.destCurrencyType) {
                                if (this.descRemainAmount == exchangeResult.descRemainAmount) {
                                    if (this.exchangeDestAmount == exchangeResult.exchangeDestAmount) {
                                        if (this.exchangeAmount == exchangeResult.exchangeAmount) {
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

    public final long getDescRemainAmount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.descRemainAmount : invokeV.longValue;
    }

    public final int getDestCurrencyType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.destCurrencyType : invokeV.intValue;
    }

    public final int getExchangeAmount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.exchangeAmount : invokeV.intValue;
    }

    public final long getExchangeDestAmount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.exchangeDestAmount : invokeV.longValue;
    }

    public final int getSrcCurrencyType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.srcCurrencyType : invokeV.intValue;
    }

    public final long getSrcRemainAmount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.srcRemainAmount : invokeV.longValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            long j2 = this.srcRemainAmount;
            long j3 = this.descRemainAmount;
            long j4 = this.exchangeDestAmount;
            return (((((((((this.srcCurrencyType * 31) + ((int) (j2 ^ (j2 >>> 32)))) * 31) + this.destCurrencyType) * 31) + ((int) (j3 ^ (j3 >>> 32)))) * 31) + ((int) (j4 ^ (j4 >>> 32)))) * 31) + this.exchangeAmount;
        }
        return invokeV.intValue;
    }

    public final void setDescRemainAmount(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048591, this, j2) == null) {
            this.descRemainAmount = j2;
        }
    }

    public final void setDestCurrencyType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048592, this, i2) == null) {
            this.destCurrencyType = i2;
        }
    }

    public final void setExchangeAmount(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048593, this, i2) == null) {
            this.exchangeAmount = i2;
        }
    }

    public final void setExchangeDestAmount(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048594, this, j2) == null) {
            this.exchangeDestAmount = j2;
        }
    }

    public final void setSrcCurrencyType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048595, this, i2) == null) {
            this.srcCurrencyType = i2;
        }
    }

    public final void setSrcRemainAmount(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048596, this, j2) == null) {
            this.srcRemainAmount = j2;
        }
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            return "ExchangeResult(srcCurrencyType=" + this.srcCurrencyType + ", srcRemainAmount=" + this.srcRemainAmount + ", destCurrencyType=" + this.destCurrencyType + ", descRemainAmount=" + this.descRemainAmount + ", exchangeDestAmount=" + this.exchangeDestAmount + ", exchangeAmount=" + this.exchangeAmount + SmallTailInfo.EMOTION_SUFFIX;
        }
        return (String) invokeV.objValue;
    }
}
