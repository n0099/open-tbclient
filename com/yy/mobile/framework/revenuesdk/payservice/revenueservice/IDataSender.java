package com.yy.mobile.framework.revenuesdk.payservice.revenueservice;

import com.baidu.wallet.paysdk.banksign.datamodel.QueryResponse;
import kotlin.Metadata;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J3\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0006\u001a\u00020\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u0004H&¢\u0006\u0004\b\t\u0010\nJ!\u0010\r\u001a\u00020\b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\f\u001a\u00020\u000bH&¢\u0006\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/yy/mobile/framework/revenuesdk/payservice/revenueservice/IDataSender;", "Lkotlin/Any;", "", "command", "", "seq", "code", "message", "", QueryResponse.Options.CANCEL, "(ILjava/lang/String;ILjava/lang/String;)V", "", "data", "sendData", "(Ljava/lang/String;[B)V", "paycore_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes3.dex */
public interface IDataSender {
    void cancel(int i2, String str, int i3, String str2);

    void sendData(String str, byte[] bArr);
}
