package com.tencent.mm.sdk.modelmsg;

import android.os.Bundle;
import com.tencent.mm.sdk.modelbase.BaseReq;
import com.tencent.mm.sdk.modelbase.BaseResp;
/* loaded from: classes15.dex */
public class LaunchFromWX {

    /* loaded from: classes15.dex */
    public static class Req extends BaseReq {
        public Req() {
        }

        public Req(Bundle bundle) {
            fromBundle(bundle);
        }

        @Override // com.tencent.mm.sdk.modelbase.BaseReq
        public boolean checkArgs() {
            return true;
        }

        @Override // com.tencent.mm.sdk.modelbase.BaseReq
        public int getType() {
            return 6;
        }
    }

    /* loaded from: classes15.dex */
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
            return 6;
        }
    }

    private LaunchFromWX() {
    }
}
