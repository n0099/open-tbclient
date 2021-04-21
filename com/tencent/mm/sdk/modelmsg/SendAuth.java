package com.tencent.mm.sdk.modelmsg;

import android.os.Bundle;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.modelbase.BaseReq;
import com.tencent.mm.sdk.modelbase.BaseResp;
/* loaded from: classes7.dex */
public final class SendAuth {

    /* loaded from: classes7.dex */
    public static class Req extends BaseReq {
        public static final int LENGTH_LIMIT = 1024;
        public static final String TAG = "MicroMsg.SDK.SendAuth.Req";
        public String scope;
        public String state;

        public Req() {
        }

        public Req(Bundle bundle) {
            fromBundle(bundle);
        }

        @Override // com.tencent.mm.sdk.modelbase.BaseReq
        public boolean checkArgs() {
            String str;
            String str2 = this.scope;
            if (str2 == null || str2.length() == 0 || this.scope.length() > 1024) {
                str = "checkArgs fail, scope is invalid";
            } else {
                String str3 = this.state;
                if (str3 == null || str3.length() <= 1024) {
                    return true;
                }
                str = "checkArgs fail, state is invalid";
            }
            a.a("MicroMsg.SDK.SendAuth.Req", str);
            return false;
        }

        @Override // com.tencent.mm.sdk.modelbase.BaseReq
        public void fromBundle(Bundle bundle) {
            super.fromBundle(bundle);
            this.scope = bundle.getString("_wxapi_sendauth_req_scope");
            this.state = bundle.getString("_wxapi_sendauth_req_state");
        }

        @Override // com.tencent.mm.sdk.modelbase.BaseReq
        public int getType() {
            return 1;
        }

        @Override // com.tencent.mm.sdk.modelbase.BaseReq
        public void toBundle(Bundle bundle) {
            super.toBundle(bundle);
            bundle.putString("_wxapi_sendauth_req_scope", this.scope);
            bundle.putString("_wxapi_sendauth_req_state", this.state);
        }
    }

    /* loaded from: classes7.dex */
    public static class Resp extends BaseResp {
        public static final int LENGTH_LIMIT = 1024;
        public static final String TAG = "MicroMsg.SDK.SendAuth.Resp";
        public String code;
        public String state;
        public String url;

        public Resp() {
        }

        public Resp(Bundle bundle) {
            fromBundle(bundle);
        }

        @Override // com.tencent.mm.sdk.modelbase.BaseResp
        public boolean checkArgs() {
            String str = this.state;
            if (str == null || str.length() <= 1024) {
                return true;
            }
            a.a("MicroMsg.SDK.SendAuth.Resp", "checkArgs fail, state is invalid");
            return false;
        }

        @Override // com.tencent.mm.sdk.modelbase.BaseResp
        public void fromBundle(Bundle bundle) {
            super.fromBundle(bundle);
            this.code = bundle.getString("_wxapi_sendauth_resp_token");
            this.state = bundle.getString("_wxapi_sendauth_resp_state");
            this.url = bundle.getString("_wxapi_sendauth_resp_url");
        }

        @Override // com.tencent.mm.sdk.modelbase.BaseResp
        public int getType() {
            return 1;
        }

        @Override // com.tencent.mm.sdk.modelbase.BaseResp
        public void toBundle(Bundle bundle) {
            super.toBundle(bundle);
            bundle.putString("_wxapi_sendauth_resp_token", this.code);
            bundle.putString("_wxapi_sendauth_resp_state", this.state);
            bundle.putString("_wxapi_sendauth_resp_url", this.url);
        }
    }
}
