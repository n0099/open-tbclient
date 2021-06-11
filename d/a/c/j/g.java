package d.a.c.j;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.adp.titan.TitanDownloadService;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.pms.bean.CheckData;
import com.baidu.searchbox.pms.bean.ErrorInfo;
import com.baidu.searchbox.pms.bean.PackageInfo;
import com.baidu.searchbox.pms.callback.DefaultDownloadCallback;
import com.baidu.searchbox.pms.callback.IDataInterceptor;
import com.baidu.searchbox.pms.callback.PackageCallback;
import com.baidu.searchbox.pms.download.DownloadOptions;
import com.baidu.searchbox.pms.init.PmsManager;
import com.baidu.searchbox.pms.init.RequestParams;
import com.baidu.searchbox.pms.init.response.ParseUtils;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class g extends RequestParams.Channel {

    /* loaded from: classes.dex */
    public static class b implements IDataInterceptor {
        public b() {
        }

        @Override // com.baidu.searchbox.pms.callback.IDataInterceptor
        public JSONObject getUploadData() {
            h d2 = h.d();
            d2.g();
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("com.baidu.titan.patch", String.valueOf(d2.b()));
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            Log.d(TitanDownloadService.TAG, "get upload data");
            return jSONObject;
        }

        @Override // com.baidu.searchbox.pms.callback.IDataInterceptor
        public CheckData onReceiveData(JSONObject jSONObject, int i2, int i3, String str) {
            if (jSONObject == null) {
                return null;
            }
            try {
                JSONObject jSONObject2 = jSONObject.getJSONObject("com.baidu.titan.patch");
                PackageInfo parsePkgItem = ParseUtils.parsePkgItem("126", "com.baidu.titan.patch", jSONObject2);
                CheckData checkData = new CheckData();
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("product", "126/com.baidu.titan.patch");
                if (parsePkgItem != null && parsePkgItem.updateVersion > 0) {
                    DownloadOptions downloadOptions = new DownloadOptions();
                    downloadOptions.saveToDb = false;
                    PmsManager.getInstance().download(parsePkgItem, downloadOptions, new c());
                    if (!TextUtils.isEmpty(parsePkgItem.downloadUrl)) {
                        jSONObject3.put("valid", 1);
                    } else {
                        jSONObject3.put("valid", 0);
                    }
                    jSONObject3.put("version", parsePkgItem.updateVersion);
                }
                ArrayList arrayList = new ArrayList();
                checkData.items = arrayList;
                arrayList.add(jSONObject2);
                checkData.totalCount = 1;
                checkData.successCount = 1;
                return checkData;
            } catch (JSONException e2) {
                e2.printStackTrace();
                return null;
            }
        }
    }

    /* loaded from: classes.dex */
    public static class c extends DefaultDownloadCallback {

        /* loaded from: classes.dex */
        public class a implements f {
            public a(c cVar) {
            }

            @Override // d.a.c.j.f
            public void a(String str, int i2, String str2) {
                if (d.a.c.j.a.f42853a) {
                    Log.d(TitanDownloadService.TAG, "install " + str + " result: " + i2);
                }
            }
        }

        public c() {
        }

        @Override // com.baidu.searchbox.pms.callback.DefaultDownloadCallback, com.baidu.searchbox.pms.callback.DownloadCallback
        public void onDownloadError(PackageInfo packageInfo, ErrorInfo errorInfo) {
            super.onDownloadError(packageInfo, errorInfo);
        }

        @Override // com.baidu.searchbox.pms.callback.DefaultDownloadCallback, com.baidu.searchbox.pms.callback.DownloadCallback
        public void onDownloadSuccess(PackageInfo packageInfo, ErrorInfo errorInfo) {
            super.onDownloadSuccess(packageInfo, errorInfo);
            j.b(AppRuntime.getAppContext(), new a(this), packageInfo, false);
        }
    }

    public g() {
        super("126", "com.baidu.titan.patch", (PackageCallback) null);
        setDataInterceptor(new b());
    }
}
