package d.a.j0.i1;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.clientupdate.ClientUpdater;
import com.baidu.clientupdate.appinfo.ClientUpdateInfo;
import com.baidu.clientupdate.download.Download;
import com.baidu.tbadk.core.TbadkCoreApplication;
import java.io.IOException;
/* loaded from: classes4.dex */
public class b extends BdAsyncTask<String, Integer, Download> {

    /* renamed from: a  reason: collision with root package name */
    public ClientUpdateInfo f55363a;

    public b(ClientUpdateInfo clientUpdateInfo) {
        this.f55363a = clientUpdateInfo;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: b */
    public Download doInBackground(String... strArr) throws IOException {
        if (this.f55363a == null) {
            return null;
        }
        ClientUpdater.getInstance(TbadkCoreApplication.getInst()).startDownload(this.f55363a, null);
        return null;
    }
}
