package d.a.i0.s.g;

import android.net.Uri;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.atomData.BigdayActivityConfig;
import com.baidu.tbadk.core.util.NetWork;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import d.a.c.e.p.k;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public InterfaceC1072b f49777a;

    /* loaded from: classes3.dex */
    public class a extends BdAsyncTask<ShareItem, Integer, ShareItem> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ShareItem f49778a;

        public a(ShareItem shareItem) {
            this.f49778a = shareItem;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public ShareItem doInBackground(ShareItem... shareItemArr) {
            ShareItem shareItem;
            String str = null;
            if (shareItemArr == null || shareItemArr.length < 1 || (shareItem = shareItemArr[0]) == null) {
                return null;
            }
            String str2 = shareItem.K;
            NetWork netWork = new NetWork();
            netWork.setUrl(TbConfig.SERVER_ADDRESS + TbConfig.URL_SMART_APP_SHARE_IMAGE);
            if (shareItem.y == 4) {
                netWork.addPostData("forum_id", this.f49778a.J);
                netWork.addPostData("type", "2");
            } else {
                netWork.addPostData("thread_id", str2);
                netWork.addPostData("type", "3");
            }
            String postNetData = netWork.postNetData();
            if (k.isEmpty(postNetData)) {
                return shareItem;
            }
            try {
                str = new JSONObject(postNetData).optString(BigdayActivityConfig.IMG_URL);
            } catch (JSONException e2) {
                BdLog.e(e2);
            }
            if (shareItem.y != 4) {
                shareItem.e0 = str;
                shareItem.v = Uri.parse(str);
            }
            return shareItem;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(ShareItem shareItem) {
            super.onPostExecute(shareItem);
            if (b.this.f49777a != null) {
                b.this.f49777a.a(shareItem);
            }
        }
    }

    /* renamed from: d.a.i0.s.g.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC1072b {
        void a(ShareItem shareItem);
    }

    public void b(ShareItem shareItem) {
        new a(shareItem).execute(shareItem);
    }

    public void c(InterfaceC1072b interfaceC1072b) {
        this.f49777a = interfaceC1072b;
    }
}
