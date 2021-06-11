package d.a.n0.t1;

import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.common.util.DeviceId;
import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.sapi2.SapiAccount;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.NetWork;
import com.baidu.tbadk.core.util.UtilHelper;
import d.a.c.e.p.j;
import d.a.c.e.p.k;
import d.a.c.e.p.q;
import d.a.m0.r.l.a;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class e {
    public static String[] a() {
        try {
            NetWork netWork = new NetWork(TbConfig.PassConfig.GET_CERT_URL);
            netWork.getNetContext().getRequest().mIsNeedAddCommenParam = false;
            netWork.getNetContext().getRequest().mIsUseCurrentBDUSS = false;
            JSONObject jSONObject = new JSONObject(new String(netWork.getNetData()));
            return new String[]{jSONObject.optString("cert_id"), jSONObject.optString("cert")};
        } catch (Exception unused) {
            return null;
        }
    }

    public static String b() {
        if (j.H()) {
            return UtilHelper.getWifiMac(TbadkCoreApplication.getInst().getApp());
        }
        return UtilHelper.getGprsIpAddress();
    }

    public static String c(ArrayList<BasicNameValuePair> arrayList, String str) {
        ArrayList arrayList2 = new ArrayList();
        HashMap hashMap = new HashMap();
        int size = arrayList.size();
        for (int i2 = 0; i2 < size; i2++) {
            arrayList2.add(arrayList.get(i2).getName());
            hashMap.put(arrayList.get(i2).getName(), arrayList.get(i2).getValue());
        }
        Collections.sort(arrayList2);
        StringBuffer stringBuffer = new StringBuffer();
        Iterator it = arrayList2.iterator();
        while (it.hasNext()) {
            String str2 = (String) it.next();
            stringBuffer.append(str2);
            stringBuffer.append("=");
            try {
                String str3 = (String) hashMap.get(str2);
                if (!TextUtils.isEmpty(str3)) {
                    stringBuffer.append(URLEncoder.encode(str3, "UTF-8"));
                }
            } catch (UnsupportedEncodingException e2) {
                BdLog.e(e2.getMessage());
            }
            stringBuffer.append("&");
        }
        stringBuffer.append("sign_key=" + str);
        return q.c(stringBuffer.toString());
    }

    public static a.b d(a.b bVar) {
        if (bVar == null) {
            return null;
        }
        try {
            String[] a2 = a();
            if (a2 == null) {
                return null;
            }
            ArrayList<BasicNameValuePair> arrayList = new ArrayList<>();
            arrayList.add(new BasicNameValuePair("crypttype", "1"));
            arrayList.add(new BasicNameValuePair("tpl", TbConfig.PassConfig.TPL));
            arrayList.add(new BasicNameValuePair("appid", "1"));
            arrayList.add(new BasicNameValuePair("clientip", b()));
            arrayList.add(new BasicNameValuePair("cert_id", a2[0]));
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("bduss", bVar.f53539a);
            jSONObject.put(SapiAccount.SAPI_ACCOUNT_PTOKEN, bVar.f53540b);
            jSONObject.put("cuid", DeviceId.getDeviceID(TbadkCoreApplication.getInst().getApp()));
            jSONObject.put("clientid", TbadkCoreApplication.getInst().getImei());
            arrayList.add(new BasicNameValuePair(TableDefine.DB_TABLE_USERINFO, new d.a.m0.r.l.d().b(a2[1], jSONObject.toString())));
            arrayList.add(new BasicNameValuePair("sig", c(arrayList, TbConfig.PassConfig.ENC_KEY)));
            NetWork netWork = new NetWork(TbConfig.PassConfig.LOGIN_BDUSS_URL);
            netWork.getNetContext().getRequest().mIsNeedAddCommenParam = false;
            netWork.getNetContext().getRequest().mIsUseCurrentBDUSS = false;
            netWork.setPostData(arrayList);
            netWork.getNetContext().getRequest().getNetWorkParam().mRequestGzip = true;
            netWork.getNetContext().getRequest().getNetWorkParam().mIsBaiduServer = false;
            String postNetData = netWork.postNetData();
            if (!netWork.getNetContext().getResponse().isRequestSuccess() || k.isEmpty(postNetData)) {
                return null;
            }
            JSONObject jSONObject2 = new JSONObject(postNetData);
            if ("0".equals(jSONObject2.optString("errno"))) {
                a.b bVar2 = new a.b();
                bVar2.f53539a = jSONObject2.optString("bduss");
                bVar2.f53540b = jSONObject2.optString(SapiAccount.SAPI_ACCOUNT_PTOKEN);
                jSONObject2.optString("uname");
                return bVar2;
            }
            return null;
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
            return null;
        }
    }
}
