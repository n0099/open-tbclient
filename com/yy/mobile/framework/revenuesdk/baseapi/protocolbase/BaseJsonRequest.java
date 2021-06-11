package com.yy.mobile.framework.revenuesdk.baseapi.protocolbase;

import com.yy.mobile.framework.revenuesdk.baseapi.ProtocolType;
/* loaded from: classes7.dex */
public class BaseJsonRequest implements IBaseJsonRequest {
    public ProtocolType protocolType;
    public PSCIMessageRequest psciMessageRequest;

    public BaseJsonRequest(ProtocolType protocolType) {
        this.protocolType = ProtocolType.UNKNOW;
        this.protocolType = protocolType;
    }

    @Override // com.yy.mobile.framework.revenuesdk.baseapi.protocolbase.IBaseJsonRequest
    public void constructPSCIMessageRequest() {
        this.psciMessageRequest = new PSCIMessageRequest(this.protocolType, 0, 0, 0, "", "", "");
    }

    @Override // com.yy.mobile.framework.revenuesdk.baseapi.protocolbase.IBaseJsonRequest
    public byte[] marshall() {
        constructPSCIMessageRequest();
        return this.psciMessageRequest.marshall();
    }
}
