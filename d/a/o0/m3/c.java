package d.a.o0.m3;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.NetWork;
import io.flutter.embedding.android.FlutterActivityLaunchConfigs;
import java.net.URLEncoder;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class c extends BdAsyncTask<String, String, Integer> {

    /* renamed from: a  reason: collision with root package name */
    public String f61285a;

    /* renamed from: b  reason: collision with root package name */
    public a f61286b;

    /* loaded from: classes5.dex */
    public interface a {
        void a();

        void b();

        void c();

        void onError(String str);
    }

    public c(String str, a aVar) {
        this.f61285a = "https://lookup.api.bsb.baidu.com/urlquery?url=" + URLEncoder.encode(str) + "&ver=2.0&key=Gar7ku5AswED&cid=" + TbadkCoreApplication.getInst().getCuid();
        this.f61286b = aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: b */
    public Integer doInBackground(String... strArr) {
        try {
            NetWork netWork = new NetWork(this.f61285a);
            netWork.getNetContext().getRequest().mIsNeedAddCommenParam = false;
            netWork.getNetContext().getRequest().mIsUseCurrentBDUSS = false;
            JSONArray optJSONArray = new JSONObject(new String(netWork.getNetData())).optJSONArray("result");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i2);
                    if (optJSONObject != null) {
                        return Integer.valueOf(optJSONObject.optInt(FlutterActivityLaunchConfigs.DEFAULT_DART_ENTRYPOINT, -1));
                    }
                }
                return -1;
            }
            return -1;
        } catch (Exception e2) {
            e2.printStackTrace();
            return -1;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onPostExecute(Integer num) {
        if (this.f61286b == null || num == null) {
            return;
        }
        if (num.intValue() == -1) {
            this.f61286b.onError(null);
        } else if (num.intValue() == 1) {
            this.f61286b.c();
        } else if (num.intValue() != 2 && num.intValue() != 0) {
            this.f61286b.a();
        } else {
            this.f61286b.b();
        }
    }
}
