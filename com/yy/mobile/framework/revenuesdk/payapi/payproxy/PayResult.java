package com.yy.mobile.framework.revenuesdk.payapi.payproxy;

import androidx.annotation.Keep;
import com.baidu.searchbox.wordscommand.util.CommandUBCHelper;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
@Keep
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000e\b\u0087\b\u0018\u0000B%\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0001\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0001¢\u0006\u0004\b\u001c\u0010\u001dJ\u0012\u0010\u0002\u001a\u0004\u0018\u00010\u0001HÆ\u0003¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u0001HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0003J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u0001HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0003J4\u0010\t\u001a\u00020\u00002\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0001HÆ\u0001¢\u0006\u0004\b\t\u0010\nJ\u001a\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u000bHÖ\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0011\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\u0001H\u0016¢\u0006\u0004\b\u0013\u0010\u0003R$\u0010\b\u001a\u0004\u0018\u00010\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\b\u0010\u0014\u001a\u0004\b\u0015\u0010\u0003\"\u0004\b\u0016\u0010\u0017R$\u0010\u0007\u001a\u0004\u0018\u00010\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010\u0014\u001a\u0004\b\u0018\u0010\u0003\"\u0004\b\u0019\u0010\u0017R$\u0010\u0006\u001a\u0004\u0018\u00010\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0006\u0010\u0014\u001a\u0004\b\u001a\u0010\u0003\"\u0004\b\u001b\u0010\u0017¨\u0006\u001e"}, d2 = {"Lcom/yy/mobile/framework/revenuesdk/payapi/payproxy/PayResult;", "", "component1", "()Ljava/lang/String;", "component2", "component3", "resultStatus", "result", "memo", CommandUBCHelper.COMMAND_UBC_TYPE_COPY, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/yy/mobile/framework/revenuesdk/payapi/payproxy/PayResult;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Ljava/lang/String;", "getMemo", "setMemo", "(Ljava/lang/String;)V", "getResult", "setResult", "getResultStatus", "setResultStatus", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "paycore_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes2.dex */
public final class PayResult {
    public String memo;
    public String result;
    public String resultStatus;

    public static /* synthetic */ PayResult copy$default(PayResult payResult, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = payResult.resultStatus;
        }
        if ((i & 2) != 0) {
            str2 = payResult.result;
        }
        if ((i & 4) != 0) {
            str3 = payResult.memo;
        }
        return payResult.copy(str, str2, str3);
    }

    public final String component1() {
        return this.resultStatus;
    }

    public final String component2() {
        return this.result;
    }

    public final String component3() {
        return this.memo;
    }

    public final PayResult copy(String str, String str2, String str3) {
        return new PayResult(str, str2, str3);
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof PayResult) {
                PayResult payResult = (PayResult) obj;
                return Intrinsics.areEqual(this.resultStatus, payResult.resultStatus) && Intrinsics.areEqual(this.result, payResult.result) && Intrinsics.areEqual(this.memo, payResult.memo);
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        String str = this.resultStatus;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.result;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.memo;
        return hashCode2 + (str3 != null ? str3.hashCode() : 0);
    }

    public PayResult(String str, String str2, String str3) {
        this.resultStatus = str;
        this.result = str2;
        this.memo = str3;
    }

    public final String getMemo() {
        return this.memo;
    }

    public final String getResult() {
        return this.result;
    }

    public final String getResultStatus() {
        return this.resultStatus;
    }

    public String toString() {
        return "PayResult(resultStatus=" + this.resultStatus + ", result=" + this.result + ", memo=" + this.memo + ')';
    }

    public final void setMemo(String str) {
        this.memo = str;
    }

    public final void setResult(String str) {
        this.result = str;
    }

    public final void setResultStatus(String str) {
        this.resultStatus = str;
    }
}
