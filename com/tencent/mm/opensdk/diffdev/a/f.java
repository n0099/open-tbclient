package com.tencent.mm.opensdk.diffdev.a;

import android.os.AsyncTask;
import com.tencent.mm.opensdk.diffdev.OAuthErrCode;
import com.tencent.mm.opensdk.diffdev.OAuthListener;
import com.tencent.mm.opensdk.utils.Log;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final class f extends AsyncTask<Void, Void, a> {
    private OAuthListener l;
    private String o;
    private int u;
    private String url;

    /* loaded from: classes3.dex */
    static class a {
        public OAuthErrCode n;
        public String v;
        public int w;

        a() {
        }

        public static a b(byte[] bArr) {
            a aVar = new a();
            if (bArr == null || bArr.length == 0) {
                Log.e("MicroMsg.SDK.NoopingResult", "parse fail, buf is null");
                aVar.n = OAuthErrCode.WechatAuth_Err_NetworkErr;
            } else {
                try {
                    try {
                        JSONObject jSONObject = new JSONObject(new String(bArr, "utf-8"));
                        aVar.w = jSONObject.getInt("wx_errcode");
                        Log.d("MicroMsg.SDK.NoopingResult", String.format("nooping uuidStatusCode = %d", Integer.valueOf(aVar.w)));
                        switch (aVar.w) {
                            case 402:
                                aVar.n = OAuthErrCode.WechatAuth_Err_Timeout;
                                break;
                            case 403:
                                aVar.n = OAuthErrCode.WechatAuth_Err_Cancel;
                                break;
                            case 404:
                                aVar.n = OAuthErrCode.WechatAuth_Err_OK;
                                break;
                            case 405:
                                aVar.n = OAuthErrCode.WechatAuth_Err_OK;
                                aVar.v = jSONObject.getString("wx_code");
                                break;
                            case 408:
                                aVar.n = OAuthErrCode.WechatAuth_Err_OK;
                                break;
                            case 500:
                                aVar.n = OAuthErrCode.WechatAuth_Err_NormalErr;
                                break;
                            default:
                                aVar.n = OAuthErrCode.WechatAuth_Err_NormalErr;
                                break;
                        }
                    } catch (Exception e) {
                        Log.e("MicroMsg.SDK.NoopingResult", String.format("parse json fail, ex = %s", e.getMessage()));
                        aVar.n = OAuthErrCode.WechatAuth_Err_NormalErr;
                    }
                } catch (Exception e2) {
                    Log.e("MicroMsg.SDK.NoopingResult", String.format("parse fail, build String fail, ex = %s", e2.getMessage()));
                    aVar.n = OAuthErrCode.WechatAuth_Err_NormalErr;
                }
            }
            return aVar;
        }
    }

    public f(String str, OAuthListener oAuthListener) {
        this.o = str;
        this.l = oAuthListener;
        this.url = String.format("https://long.open.weixin.qq.com/connect/l/qrconnect?f=json&uuid=%s", str);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object[]] */
    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.AsyncTask
    protected final /* synthetic */ a doInBackground(Void[] voidArr) {
        if (this.o == null || this.o.length() == 0) {
            Log.e("MicroMsg.SDK.NoopingTask", "run fail, uuid is null");
            a aVar = new a();
            aVar.n = OAuthErrCode.WechatAuth_Err_NormalErr;
            return aVar;
        }
        while (!isCancelled()) {
            String str = this.url + (this.u == 0 ? "" : "&last=" + this.u);
            long currentTimeMillis = System.currentTimeMillis();
            byte[] a2 = e.a(str, 60000);
            long currentTimeMillis2 = System.currentTimeMillis();
            a b = a.b(a2);
            Log.d("MicroMsg.SDK.NoopingTask", String.format("nooping, url = %s, errCode = %s, uuidStatusCode = %d, time consumed = %d(ms)", str, b.n.toString(), Integer.valueOf(b.w), Long.valueOf(currentTimeMillis2 - currentTimeMillis)));
            if (b.n != OAuthErrCode.WechatAuth_Err_OK) {
                Log.e("MicroMsg.SDK.NoopingTask", String.format("nooping fail, errCode = %s, uuidStatusCode = %d", b.n.toString(), Integer.valueOf(b.w)));
                return b;
            }
            this.u = b.w;
            if (b.w == g.UUID_SCANED.getCode()) {
                this.l.onQrcodeScanned();
            } else if (b.w != g.UUID_KEEP_CONNECT.getCode() && b.w == g.UUID_CONFIRM.getCode()) {
                if (b.v == null || b.v.length() == 0) {
                    Log.e("MicroMsg.SDK.NoopingTask", "nooping fail, confirm with an empty code!!!");
                    b.n = OAuthErrCode.WechatAuth_Err_NormalErr;
                    return b;
                }
                return b;
            }
        }
        Log.i("MicroMsg.SDK.NoopingTask", "IDiffDevOAuth.stopAuth / detach invoked");
        a aVar2 = new a();
        aVar2.n = OAuthErrCode.WechatAuth_Err_Auth_Stopped;
        return aVar2;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // android.os.AsyncTask
    protected final /* synthetic */ void onPostExecute(a aVar) {
        a aVar2 = aVar;
        this.l.onAuthFinish(aVar2.n, aVar2.v);
    }
}
