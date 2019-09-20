package com.tencent.mm.opensdk.diffdev.a;

import android.os.AsyncTask;
import com.tencent.mm.opensdk.diffdev.OAuthErrCode;
import com.tencent.mm.opensdk.diffdev.OAuthListener;
import com.tencent.mm.opensdk.utils.Log;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class f extends AsyncTask<Void, Void, a> {
    private OAuthListener k;
    private String n;
    private int t;
    private String url;

    /* loaded from: classes2.dex */
    static class a {
        public OAuthErrCode m;
        public String u;
        public int v;

        a() {
        }

        public static a b(byte[] bArr) {
            a aVar = new a();
            if (bArr == null || bArr.length == 0) {
                Log.e("MicroMsg.SDK.NoopingResult", "parse fail, buf is null");
                aVar.m = OAuthErrCode.WechatAuth_Err_NetworkErr;
            } else {
                try {
                    try {
                        JSONObject jSONObject = new JSONObject(new String(bArr, "utf-8"));
                        aVar.v = jSONObject.getInt("wx_errcode");
                        Log.d("MicroMsg.SDK.NoopingResult", String.format("nooping uuidStatusCode = %d", Integer.valueOf(aVar.v)));
                        switch (aVar.v) {
                            case 402:
                                aVar.m = OAuthErrCode.WechatAuth_Err_Timeout;
                                break;
                            case 403:
                                aVar.m = OAuthErrCode.WechatAuth_Err_Cancel;
                                break;
                            case 404:
                                aVar.m = OAuthErrCode.WechatAuth_Err_OK;
                                break;
                            case 405:
                                aVar.m = OAuthErrCode.WechatAuth_Err_OK;
                                aVar.u = jSONObject.getString("wx_code");
                                break;
                            case 408:
                                aVar.m = OAuthErrCode.WechatAuth_Err_OK;
                                break;
                            case 500:
                                aVar.m = OAuthErrCode.WechatAuth_Err_NormalErr;
                                break;
                            default:
                                aVar.m = OAuthErrCode.WechatAuth_Err_NormalErr;
                                break;
                        }
                    } catch (Exception e) {
                        Log.e("MicroMsg.SDK.NoopingResult", String.format("parse json fail, ex = %s", e.getMessage()));
                        aVar.m = OAuthErrCode.WechatAuth_Err_NormalErr;
                    }
                } catch (Exception e2) {
                    Log.e("MicroMsg.SDK.NoopingResult", String.format("parse fail, build String fail, ex = %s", e2.getMessage()));
                    aVar.m = OAuthErrCode.WechatAuth_Err_NormalErr;
                }
            }
            return aVar;
        }
    }

    public f(String str, OAuthListener oAuthListener) {
        this.n = str;
        this.k = oAuthListener;
        this.url = String.format("https://long.open.weixin.qq.com/connect/l/qrconnect?f=json&uuid=%s", str);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object[]] */
    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.AsyncTask
    protected final /* synthetic */ a doInBackground(Void[] voidArr) {
        Thread.currentThread().setName("OpenSdkNoopingTask");
        if (this.n == null || this.n.length() == 0) {
            Log.e("MicroMsg.SDK.NoopingTask", "run fail, uuid is null");
            a aVar = new a();
            aVar.m = OAuthErrCode.WechatAuth_Err_NormalErr;
            return aVar;
        }
        while (!isCancelled()) {
            String str = this.url + (this.t == 0 ? "" : "&last=" + this.t);
            long currentTimeMillis = System.currentTimeMillis();
            byte[] a2 = e.a(str);
            long currentTimeMillis2 = System.currentTimeMillis();
            a b = a.b(a2);
            Log.d("MicroMsg.SDK.NoopingTask", String.format("nooping, url = %s, errCode = %s, uuidStatusCode = %d, time consumed = %d(ms)", str, b.m.toString(), Integer.valueOf(b.v), Long.valueOf(currentTimeMillis2 - currentTimeMillis)));
            if (b.m != OAuthErrCode.WechatAuth_Err_OK) {
                Log.e("MicroMsg.SDK.NoopingTask", String.format("nooping fail, errCode = %s, uuidStatusCode = %d", b.m.toString(), Integer.valueOf(b.v)));
                return b;
            }
            this.t = b.v;
            if (b.v == g.UUID_SCANED.getCode()) {
                this.k.onQrcodeScanned();
            } else if (b.v != g.UUID_KEEP_CONNECT.getCode() && b.v == g.UUID_CONFIRM.getCode()) {
                if (b.u == null || b.u.length() == 0) {
                    Log.e("MicroMsg.SDK.NoopingTask", "nooping fail, confirm with an empty code!!!");
                    b.m = OAuthErrCode.WechatAuth_Err_NormalErr;
                    return b;
                }
                return b;
            }
        }
        Log.i("MicroMsg.SDK.NoopingTask", "IDiffDevOAuth.stopAuth / detach invoked");
        a aVar2 = new a();
        aVar2.m = OAuthErrCode.WechatAuth_Err_Auth_Stopped;
        return aVar2;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // android.os.AsyncTask
    protected final /* synthetic */ void onPostExecute(a aVar) {
        a aVar2 = aVar;
        this.k.onAuthFinish(aVar2.m, aVar2.u);
    }
}
