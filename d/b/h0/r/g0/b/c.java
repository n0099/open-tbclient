package d.b.h0.r.g0.b;

import android.text.TextUtils;
import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.tbadk.core.util.httpNet.WebClient;
import com.baidu.tbadk.core.util.resourceLoaderProc.DiskCancelWorker;
import com.baidu.tieba.R;
import d.b.b.e.l.e;
import d.b.b.e.q.h;
/* loaded from: classes3.dex */
public class c implements e<a> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.b.e.l.e
    /* renamed from: a */
    public a getFromLocal(String str, String str2, int i, int i2, d.b.b.e.l.b bVar, Object... objArr) {
        DiskFileOperate diskFileOperate = new DiskFileOperate("voice", str, DiskFileOperate.Action.INFO);
        diskFileOperate.setOperateType(DiskFileOperate.OperateType.MUST_SUCCESS);
        diskFileOperate.setSubFolder(false);
        diskFileOperate.setIsFormatData(false);
        if (bVar != null) {
            DiskCancelWorker diskCancelWorker = new DiskCancelWorker();
            diskCancelWorker.setOperate(diskFileOperate);
            bVar.f41847a = diskCancelWorker;
        }
        diskFileOperate.call();
        if (diskFileOperate.isSuccess()) {
            String desPath = diskFileOperate.getDesPath();
            a aVar = new a();
            aVar.f50586a = str;
            aVar.f50587b = desPath;
            return aVar;
        }
        return null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.b.e.l.e
    /* renamed from: b */
    public a getFromMemory(String str, String str2, int i, int i2, boolean z, Object... objArr) {
        return null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.b.e.l.e
    /* renamed from: c */
    public a getFromRemote(String str, String str2, int i, int i2, d.b.b.e.l.b bVar, Object... objArr) {
        int i3 = 1;
        String str3 = null;
        String valueOf = objArr.length == 1 ? String.valueOf(objArr[0]) : null;
        a aVar = new a();
        WebClient webClient = new WebClient();
        if (bVar != null) {
            bVar.f41847a = webClient;
        }
        String str4 = TbConfig.SERVER_ADDRESS + TbConfig.VOICE_DATA + "?voice_md5=" + str;
        if (!TextUtils.isEmpty(valueOf)) {
            str4 = str4 + "&play_from=" + valueOf;
        }
        byte[] downloadCommonBytes = webClient.downloadCommonBytes(str4);
        if (!webClient.IsRequestSuccess()) {
            aVar.f50588c = 3;
            aVar.f50589d = h.a(R.string.neterror);
            return aVar;
        } else if (downloadCommonBytes == null || downloadCommonBytes.length == 0) {
            aVar.f50588c = 4;
            aVar.f50589d = h.a(R.string.voice_cache_error_no_file);
            return aVar;
        } else {
            if (str == null) {
                i3 = 5;
            } else if (downloadCommonBytes == null || downloadCommonBytes.length == 0) {
                i3 = 6;
            } else {
                DiskFileOperate diskFileOperate = new DiskFileOperate("voice", str, DiskFileOperate.Action.WRITE);
                diskFileOperate.setOperateType(DiskFileOperate.OperateType.MUST_SUCCESS);
                diskFileOperate.setSubFolder(false);
                diskFileOperate.setData(downloadCommonBytes);
                if (bVar != null) {
                    DiskCancelWorker diskCancelWorker = new DiskCancelWorker();
                    diskCancelWorker.setOperate(diskFileOperate);
                    bVar.f41847a = diskCancelWorker;
                }
                diskFileOperate.call();
                if (diskFileOperate.isSuccess() && diskFileOperate.getFileInfo() != null) {
                    str3 = diskFileOperate.getFileInfo().getAbsolutePath();
                    i3 = 0;
                } else if (FileHelper.getAvailableSize() < downloadCommonBytes.length) {
                    i3 = 2;
                }
            }
            if (i3 == 0) {
                aVar.f50587b = str3;
                aVar.f50586a = str;
            } else {
                aVar.f50588c = i3;
                aVar.f50589d = a.a(i3);
            }
            return aVar;
        }
    }

    @Override // d.b.b.e.l.e
    public BdAsyncTaskParallel getAsyncTaskParallel() {
        return null;
    }

    @Override // d.b.b.e.l.e
    public int getAsyncTaskPriority() {
        return 2;
    }

    @Override // d.b.b.e.l.e
    public boolean isNeedLoad() {
        return true;
    }

    @Override // d.b.b.e.l.e
    public void updateMemory(String str, Object obj, int i, int i2, Object... objArr) {
    }
}
