package d.b.h0.s.e;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.cyberplayer.sdk.statistics.DpStatConstants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkSettings;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.tbadk.core.util.NetWork;
import com.baidu.tbadk.core.util.TbMd5;
import d.b.b.e.p.j;
import java.io.File;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class c {

    /* loaded from: classes3.dex */
    public static class a extends BdAsyncTask<String, Integer, Boolean> {

        /* renamed from: a  reason: collision with root package name */
        public NetWork f51307a = null;

        /* renamed from: b  reason: collision with root package name */
        public final String f51308b;

        /* renamed from: c  reason: collision with root package name */
        public final String f51309c;

        /* renamed from: d  reason: collision with root package name */
        public final String f51310d;

        public a(String str, String str2, String str3) {
            this.f51308b = str;
            this.f51309c = str2;
            this.f51310d = str3;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Boolean doInBackground(String... strArr) {
            Boolean bool = Boolean.FALSE;
            try {
                NetWork netWork = new NetWork(this.f51308b);
                this.f51307a = netWork;
                bool = Boolean.valueOf(netWork.downloadFile(this.f51309c + ".tmp", new Handler(Looper.getMainLooper()), TbConfig.NET_MSG_GETLENTH));
                if (bool != null && bool.booleanValue()) {
                    if (!StringUtils.isNull(FileHelper.renameTo(null, this.f51309c + ".tmp", null, this.f51309c)) && !TextUtils.isEmpty(this.f51308b) && !this.f51308b.equals(this.f51310d)) {
                        FileHelper.DelFile(TbMd5.getNameMd5FromUrl(this.f51310d));
                    }
                } else {
                    FileHelper.DelFile(this.f51309c + ".tmp");
                }
            } catch (Exception unused) {
            }
            return bool;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            super.onPostExecute((a) bool);
            if (bool == null || !bool.booleanValue()) {
                return;
            }
            new c().g();
        }
    }

    public String b() {
        return TbadkSettings.getInst().loadString("launch_config_local_url", "");
    }

    public void c(JSONObject jSONObject) {
        JSONArray jSONArray;
        JSONObject optJSONObject;
        String str;
        String str2;
        JSONObject optJSONObject2;
        if (jSONObject == null) {
            return;
        }
        try {
            jSONArray = jSONObject.getJSONArray("APP_INDEX_START");
        } catch (JSONException e2) {
            e2.printStackTrace();
            jSONArray = null;
        }
        TbadkSettings inst = TbadkSettings.getInst();
        if (jSONArray == null || jSONArray.length() == 0 || (optJSONObject = jSONArray.optJSONObject(0)) == null) {
            return;
        }
        int optInt = optJSONObject.optInt("url_type");
        String optString = optJSONObject.optString("url");
        String optString2 = optJSONObject.optString("apk_url");
        String optString3 = optJSONObject.optString("apk_name");
        String optString4 = optJSONObject.optString(DpStatConstants.KEY_APP_NAME);
        inst.saveString("url", optString);
        inst.saveInt("url_type", optInt);
        inst.saveString("apk_url", optString2);
        inst.saveString("apk_name", optString3);
        inst.saveString(DpStatConstants.KEY_APP_NAME, optString4);
        JSONArray optJSONArray = optJSONObject.optJSONArray("goods_info");
        if (optJSONArray == null || optJSONArray.length() == 0 || (optJSONObject2 = optJSONArray.optJSONObject(0)) == null) {
            str = null;
            str2 = null;
        } else {
            str = optJSONObject2.optString("thread_pic");
            str2 = optJSONObject2.optString("thread_pic_md5");
            inst.saveString("apk_size", optJSONObject2.optString("apk_size"));
        }
        if (StringUtils.isNull(str2) || StringUtils.isNull(str)) {
            return;
        }
        String loadString = inst.loadString("launch_config_md5", null);
        if (StringUtils.isNull(loadString)) {
            inst.saveString("launch_config_md5", str2);
            inst.saveString("launch_config_remote_url", str);
            d(str);
        } else if (TextUtils.equals(loadString, str2)) {
        } else {
            inst.saveString("launch_config_md5", str2);
            inst.saveString("launch_config_remote_url", str);
            d(str);
        }
    }

    public void d(String str) {
        String b2 = b();
        if (TextUtils.equals(b2, str) && e(b2)) {
            return;
        }
        f(str, b2);
    }

    public final boolean e(String str) {
        File GetFile = FileHelper.GetFile(TbMd5.getNameMd5FromUrl(str));
        return GetFile != null && GetFile.exists() && GetFile.isFile();
    }

    public final void f(String str, String str2) {
        if (j.H()) {
            new a(str, TbMd5.getNameMd5FromUrl(str), str2).execute(new String[0]);
        }
    }

    public final void g() {
        String loadString = TbadkSettings.getInst().loadString("launch_config_remote_url", null);
        if (StringUtils.isNull(loadString)) {
            return;
        }
        TbadkSettings.getInst().saveString("launch_config_local_url", loadString);
    }
}
