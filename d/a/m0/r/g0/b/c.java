package d.a.m0.r.g0.b;

import android.text.TextUtils;
import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.tbadk.core.util.httpNet.WebClient;
import com.baidu.tbadk.core.util.resourceLoaderProc.DiskCancelWorker;
import com.baidu.tieba.R;
import d.a.c.e.l.e;
import d.a.c.e.q.h;
/* loaded from: classes3.dex */
public class c implements e<a> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.e.l.e
    /* renamed from: a */
    public a getFromLocal(String str, String str2, int i2, int i3, d.a.c.e.l.b bVar, Object... objArr) {
        DiskFileOperate diskFileOperate = new DiskFileOperate("voice", str, DiskFileOperate.Action.INFO);
        diskFileOperate.setOperateType(DiskFileOperate.OperateType.MUST_SUCCESS);
        diskFileOperate.setSubFolder(false);
        diskFileOperate.setIsFormatData(false);
        if (bVar != null) {
            DiskCancelWorker diskCancelWorker = new DiskCancelWorker();
            diskCancelWorker.setOperate(diskFileOperate);
            bVar.f38695a = diskCancelWorker;
        }
        diskFileOperate.call();
        if (diskFileOperate.isSuccess()) {
            String desPath = diskFileOperate.getDesPath();
            a aVar = new a();
            aVar.f49820a = str;
            aVar.f49821b = desPath;
            return aVar;
        }
        return null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.e.l.e
    /* renamed from: b */
    public a getFromMemory(String str, String str2, int i2, int i3, boolean z, Object... objArr) {
        return null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.e.l.e
    /* renamed from: c */
    public a getFromRemote(String str, String str2, int i2, int i3, d.a.c.e.l.b bVar, Object... objArr) {
        int i4 = 1;
        String str3 = null;
        String valueOf = objArr.length == 1 ? String.valueOf(objArr[0]) : null;
        a aVar = new a();
        WebClient webClient = new WebClient();
        if (bVar != null) {
            bVar.f38695a = webClient;
        }
        String str4 = TbConfig.SERVER_ADDRESS + TbConfig.VOICE_DATA + "?voice_md5=" + str;
        if (!TextUtils.isEmpty(valueOf)) {
            str4 = str4 + "&play_from=" + valueOf;
        }
        byte[] downloadCommonBytes = webClient.downloadCommonBytes(str4);
        if (!webClient.IsRequestSuccess()) {
            aVar.f49822c = 3;
            aVar.f49823d = h.a(R.string.neterror);
            return aVar;
        } else if (downloadCommonBytes == null || downloadCommonBytes.length == 0) {
            aVar.f49822c = 4;
            aVar.f49823d = h.a(R.string.voice_cache_error_no_file);
            return aVar;
        } else {
            if (str == null) {
                i4 = 5;
            } else if (downloadCommonBytes == null || downloadCommonBytes.length == 0) {
                i4 = 6;
            } else {
                DiskFileOperate diskFileOperate = new DiskFileOperate("voice", str, DiskFileOperate.Action.WRITE);
                diskFileOperate.setOperateType(DiskFileOperate.OperateType.MUST_SUCCESS);
                diskFileOperate.setSubFolder(false);
                diskFileOperate.setData(downloadCommonBytes);
                if (bVar != null) {
                    DiskCancelWorker diskCancelWorker = new DiskCancelWorker();
                    diskCancelWorker.setOperate(diskFileOperate);
                    bVar.f38695a = diskCancelWorker;
                }
                diskFileOperate.call();
                if (diskFileOperate.isSuccess() && diskFileOperate.getFileInfo() != null) {
                    str3 = diskFileOperate.getFileInfo().getAbsolutePath();
                    i4 = 0;
                } else if (FileHelper.getAvailableSize() < downloadCommonBytes.length) {
                    i4 = 2;
                }
            }
            if (i4 == 0) {
                aVar.f49821b = str3;
                aVar.f49820a = str;
            } else {
                aVar.f49822c = i4;
                aVar.f49823d = a.a(i4);
            }
            return aVar;
        }
    }

    @Override // d.a.c.e.l.e
    public BdAsyncTaskParallel getAsyncTaskParallel() {
        return null;
    }

    @Override // d.a.c.e.l.e
    public int getAsyncTaskPriority() {
        return 2;
    }

    @Override // d.a.c.e.l.e
    public boolean isNeedLoad() {
        return true;
    }

    @Override // d.a.c.e.l.e
    public void updateMemory(String str, Object obj, int i2, int i3, Object... objArr) {
    }
}
