package tv.athena.revenue.api.pay.params;
/* loaded from: classes9.dex */
public enum PayFlowType {
    DIOALOG_PAY_FLOW(1, "半屏充值流程"),
    WALLET_PAY_FLOW(2, "全屏钱包充值流程");
    
    public final int typeId;
    public final String typeName;

    public int getTypeId() {
        return this.typeId;
    }

    public String getTypeName() {
        return this.typeName;
    }

    PayFlowType(int i, String str) {
        this.typeId = i;
        this.typeName = str;
    }
}
