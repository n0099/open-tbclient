package com.tencent.mm.opensdk.modelmsg;

import android.os.Bundle;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mm.opensdk.utils.Log;
/* loaded from: classes8.dex */
public final class SendAuth {

    /* loaded from: classes8.dex */
    public static class Req extends BaseReq {
        private static final int LENGTH_LIMIT = 1024;
        private static final String TAG = "MicroMsg.SDK.SendAuth.Req";
        public String scope;
        public String state;

        public Req() {
        }

        public Req(Bundle bundle) {
            fromBundle(bundle);
        }

        @Override // com.tencent.mm.opensdk.modelbase.BaseReq
        public boolean checkArgs() {
            if (this.scope == null || this.scope.length() == 0 || this.scope.length() > 1024) {
                Log.e(TAG, "checkArgs fail, scope is invalid");
                return false;
            } else if (this.state == null || this.state.length() <= 1024) {
                return true;
            } else {
                Log.e(TAG, "checkArgs fail, state is invalid");
                return false;
            }
        }

        @Override // com.tencent.mm.opensdk.modelbase.BaseReq
        public void fromBundle(Bundle bundle) {
            super.fromBundle(bundle);
            this.scope = bundle.getString("_wxapi_sendauth_req_scope");
            this.state = bundle.getString("_wxapi_sendauth_req_state");
        }

        @Override // com.tencent.mm.opensdk.modelbase.BaseReq
        public int getType() {
            return 1;
        }

        @Override // com.tencent.mm.opensdk.modelbase.BaseReq
        public void toBundle(Bundle bundle) {
            super.toBundle(bundle);
            bundle.putString("_wxapi_sendauth_req_scope", this.scope);
            bundle.putString("_wxapi_sendauth_req_state", this.state);
        }
    }

    /* loaded from: classes8.dex */
    public static class Resp extends BaseResp {
        private static final int LENGTH_LIMIT = 1024;
        private static final String TAG = "MicroMsg.SDK.SendAuth.Resp";
        public String code;
        public String country;
        public String lang;
        public String state;
        public String url;

        public Resp() {
        }

        public Resp(Bundle bundle) {
            fromBundle(bundle);
        }

        @Override // com.tencent.mm.opensdk.modelbase.BaseResp
        public boolean checkArgs() {
            if (this.state == null || this.state.length() <= 1024) {
                return true;
            }
            Log.e(TAG, "checkArgs fail, state is invalid");
            return false;
        }

        @Override // com.tencent.mm.opensdk.modelbase.BaseResp
        public void fromBundle(Bundle bundle) {
            super.fromBundle(bundle);
            this.code = bundle.getString("_wxapi_sendauth_resp_token");
            this.state = bundle.getString("_wxapi_sendauth_resp_state");
            this.url = bundle.getString("_wxapi_sendauth_resp_url");
            this.lang = bundle.getString("_wxapi_sendauth_resp_lang");
            this.country = bundle.getString("_wxapi_sendauth_resp_country");
        }

        @Override // com.tencent.mm.opensdk.modelbase.BaseResp
        public int getType() {
            return 1;
        }

        @Override // com.tencent.mm.opensdk.modelbase.BaseResp
        public void toBundle(Bundle bundle) {
            super.toBundle(bundle);
            bundle.putString("_wxapi_sendauth_resp_token", this.code);
            bundle.putString("_wxapi_sendauth_resp_state", this.state);
            bundle.putString("_wxapi_sendauth_resp_url", this.url);
            bundle.putString("_wxapi_sendauth_resp_lang", this.lang);
            bundle.putString("_wxapi_sendauth_resp_country", this.country);
        }
    }

    private SendAuth() {
    }
}
