package com.yy.mobile.framework.revenuesdk.payservice.revenueservice.request;

import com.baidu.tbadk.core.frameworkData.IntentConfig;
import kotlin.Metadata;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\u0011\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H&¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH&¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0005H&¢\u0006\u0004\b\u000b\u0010\u0007J\u000f\u0010\f\u001a\u00020\u0005H&¢\u0006\u0004\b\f\u0010\u0007J\u000f\u0010\r\u001a\u00020\u0005H&¢\u0006\u0004\b\r\u0010\u0007J\u000f\u0010\u000e\u001a\u00020\u0005H&¢\u0006\u0004\b\u000e\u0010\u0007J\u000f\u0010\u0010\u001a\u00020\u000fH&¢\u0006\u0004\b\u0010\u0010\u0011J\u0019\u0010\u0014\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0016\u001a\u00020\u0013H&¢\u0006\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, d2 = {"Lcom/yy/mobile/framework/revenuesdk/payservice/revenueservice/request/IRequest;", "Lkotlin/Any;", "", "getExtParam", "()Ljava/lang/Object;", "", "getReqCommand", "()I", "", "getReqSeq", "()Ljava/lang/String;", "getRetryCount", "getRetryInterval", "getTimeout", "getTotalRetryCount", "", "run", "()Z", "param", "", "setExtParam", "(Ljava/lang/Object;)V", IntentConfig.STOP, "()V", "paycore_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes4.dex */
public interface IRequest {
    Object getExtParam();

    int getReqCommand();

    String getReqSeq();

    int getRetryCount();

    int getRetryInterval();

    int getTimeout();

    int getTotalRetryCount();

    boolean run();

    void setExtParam(Object obj);

    void stop();
}
