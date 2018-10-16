package com.tencent.mm.sdk.modelmsg;

import android.os.Bundle;
import com.tencent.mm.sdk.modelbase.BaseReq;
import com.tencent.mm.sdk.modelbase.BaseResp;
import com.tencent.mm.sdk.modelmsg.WXMediaMessage;
/* loaded from: classes6.dex */
public class ShowMessageFromWX {

    /* loaded from: classes6.dex */
    public static class Req extends BaseReq {
        public WXMediaMessage message;

        public Req() {
        }

        public Req(Bundle bundle) {
            fromBundle(bundle);
        }

        @Override // com.tencent.mm.sdk.modelbase.BaseReq
        public boolean checkArgs() {
            if (this.message == null) {
                return false;
            }
            return this.message.checkArgs();
        }

        @Override // com.tencent.mm.sdk.modelbase.BaseReq
        public void fromBundle(Bundle bundle) {
            super.fromBundle(bundle);
            this.message = WXMediaMessage.Builder.fromBundle(bundle);
        }

        @Override // com.tencent.mm.sdk.modelbase.BaseReq
        public int getType() {
            return 4;
        }

        @Override // com.tencent.mm.sdk.modelbase.BaseReq
        public void toBundle(Bundle bundle) {
            Bundle bundle2 = WXMediaMessage.Builder.toBundle(this.message);
            super.toBundle(bundle2);
            bundle.putAll(bundle2);
        }
    }

    /* loaded from: classes6.dex */
    public static class Resp extends BaseResp {
        public Resp() {
        }

        public Resp(Bundle bundle) {
            fromBundle(bundle);
        }

        @Override // com.tencent.mm.sdk.modelbase.BaseResp
        public boolean checkArgs() {
            return true;
        }

        @Override // com.tencent.mm.sdk.modelbase.BaseResp
        public int getType() {
            return 4;
        }
    }

    private ShowMessageFromWX() {
    }
}
