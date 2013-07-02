package com.mofamulu.tieba.ch;

import android.os.AsyncTask;
import android.util.Log;
import com.baidu.android.pushservice.PushConstants;
import java.io.IOException;
import java.util.List;
import org.apache.http.HttpResponse;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.json.JSONTokener;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class z extends AsyncTask {
    final /* synthetic */ u a;
    private final String b;
    private final y c;
    private final List d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(u uVar, String str, List list, y yVar) {
        this.a = uVar;
        this.b = str;
        this.d = list;
        this.c = yVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a */
    public String doInBackground(String... strArr) {
        try {
            BasicHttpParams basicHttpParams = new BasicHttpParams();
            HttpConnectionParams.setConnectionTimeout(basicHttpParams, 15000);
            HttpConnectionParams.setSoTimeout(basicHttpParams, 15000);
            DefaultHttpClient defaultHttpClient = new DefaultHttpClient(basicHttpParams);
            HttpPost httpPost = new HttpPost(this.b);
            httpPost.setHeader("tbhp_x_from", "android");
            this.d.add(new BasicNameValuePair("uname", bg.a()));
            httpPost.setEntity(new UrlEncodedFormEntity(this.d, "UTF-8"));
            HttpResponse execute = defaultHttpClient.execute(httpPost);
            if (execute.getStatusLine().getStatusCode() == 200) {
                JSONObject jSONObject = (JSONObject) new JSONTokener(EntityUtils.toString(execute.getEntity()).trim()).nextValue();
                return this.c.a(jSONObject.optInt("error_code", 1), jSONObject.optString(PushConstants.EXTRA_ERROR_CODE, "云端返回的数据格式错误！"), jSONObject.optString("data"));
            }
            return "云端暂不可用，请稍候再试。";
        } catch (IOException e) {
            Log.e("tbhp", "failed to sync from cloud. " + this.b, e);
            return "网络暂不可用，请稍候再试。" + e.getMessage();
        } catch (Throwable th) {
            Log.e("tbhp", "failed to sync from cloud. " + this.b, th);
            return th.getMessage();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a */
    public void onPostExecute(String str) {
        this.c.a(str);
    }
}
