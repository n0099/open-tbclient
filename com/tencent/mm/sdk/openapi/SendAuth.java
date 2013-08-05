package com.tencent.mm.sdk.openapi;

import android.os.Bundle;
import com.tencent.mm.sdk.platformtools.Log;
/* loaded from: classes.dex */
public final class SendAuth {

    /* loaded from: classes.dex */
    public class Req extends BaseReq {
        public String scope;
        public String state;

        public Req() {
        }

        public Req(Bundle bundle) {
            fromBundle(bundle);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.tencent.mm.sdk.openapi.BaseReq
        public final boolean checkArgs() {
            if (this.scope == null || this.scope.length() == 0 || this.scope.length() > 1024) {
                Log.e("MicroMsg.SDK.SendAuth.Req", "checkArgs fail, scope is invalid");
                return false;
            } else if (this.state == null || this.state.length() <= 1024) {
                return true;
            } else {
                Log.e("MicroMsg.SDK.SendAuth.Req", "checkArgs fail, state is invalid");
                return false;
            }
        }

        @Override // com.tencent.mm.sdk.openapi.BaseReq
        public void fromBundle(Bundle bundle) {
            super.fromBundle(bundle);
            this.scope = bundle.getString("_wxapi_sendauth_req_scope");
            this.state = bundle.getString("_wxapi_sendauth_req_state");
        }

        @Override // com.tencent.mm.sdk.openapi.BaseReq
        public int getType() {
            return 1;
        }

        @Override // com.tencent.mm.sdk.openapi.BaseReq
        public void toBundle(Bundle bundle) {
            super.toBundle(bundle);
            bundle.putString("_wxapi_sendauth_req_scope", this.scope);
            bundle.putString("_wxapi_sendauth_req_state", this.state);
        }
    }

    /* loaded from: classes.dex */
    public class Resp extends BaseResp {
        public int expireDate;
        public String resultUrl;
        public String state;
        public String token;
        public String userName;

        public Resp() {
        }

        public Resp(Bundle bundle) {
            fromBundle(bundle);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.tencent.mm.sdk.openapi.BaseResp
        public final boolean checkArgs() {
            if (this.state == null || this.state.length() <= 1024) {
                return true;
            }
            Log.e("MicroMsg.SDK.SendAuth.Resp", "checkArgs fail, state is invalid");
            return false;
        }

        @Override // com.tencent.mm.sdk.openapi.BaseResp
        public void fromBundle(Bundle bundle) {
            super.fromBundle(bundle);
            this.userName = bundle.getString("_wxapi_sendauth_resp_userName");
            this.token = bundle.getString("_wxapi_sendauth_resp_token");
            this.expireDate = bundle.getInt("_wxapi_sendauth_resp_expireDate", 0);
            this.state = bundle.getString("_wxapi_sendauth_resp_state");
        }

        @Override // com.tencent.mm.sdk.openapi.BaseResp
        public int getType() {
            return 1;
        }

        @Override // com.tencent.mm.sdk.openapi.BaseResp
        public void toBundle(Bundle bundle) {
            super.toBundle(bundle);
            bundle.putString("_wxapi_sendauth_resp_userName", this.userName);
            bundle.putString("_wxapi_sendauth_resp_token", this.token);
            bundle.putInt("_wxapi_sendauth_resp_expireDate", this.expireDate);
            bundle.putString("_wxapi_sendauth_resp_state", this.state);
        }
    }

    private SendAuth() {
    }
}
