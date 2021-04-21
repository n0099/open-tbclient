package d.b.j0.h0.a;

import android.graphics.Bitmap;
import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.DiskEmotionOperate;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.httpNet.WebClient;
import com.baidu.tbadk.core.util.resourceLoaderProc.DiskCancelWorker;
import d.b.c.e.a.d;
import d.b.c.e.l.b;
import d.b.c.e.l.e;
import d.b.c.e.p.j;
import d.b.i0.r.k;
import d.b.i0.w.p.c;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes4.dex */
public class a implements e<d.b.c.j.d.a> {
    public final String a(String str, boolean z) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(z ? "_gif" : "");
        return sb.toString();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.c.e.l.e
    /* renamed from: b */
    public d.b.c.j.d.a getFromLocal(String str, String str2, int i, int i2, b bVar, Object... objArr) {
        d.b.c.j.d.a aVar;
        Bitmap f2;
        d.b.c.j.d.a aVar2 = null;
        if (objArr == null || objArr.length != 4) {
            return null;
        }
        String valueOf = objArr[0] == null ? "" : String.valueOf(objArr[0]);
        String valueOf2 = objArr[1] != null ? String.valueOf(objArr[1]) : "";
        Boolean valueOf3 = Boolean.valueOf(String.valueOf(objArr[2]));
        if (valueOf == null || valueOf2 == null || valueOf3 == null) {
            return null;
        }
        ArrayList<c> h2 = d.b.j0.h0.b.e.i().h();
        if (d.b.j0.h0.b.e.i().m(valueOf2) && valueOf3.booleanValue() && !new File(d.b.j0.h0.b.e.i().f(valueOf2, true)).exists()) {
            valueOf3 = Boolean.FALSE;
        }
        boolean booleanValue = valueOf3.booleanValue();
        if (d.b.j0.h0.b.e.i().l(valueOf2) && valueOf3.booleanValue()) {
            String f3 = d.b.j0.h0.b.e.i().f(valueOf2, true);
            String g2 = d.b.j0.h0.b.e.i().g(valueOf2);
            if (!new File(FileHelper.EXTERNAL_STORAGE_DIRECTORY + "/" + TbConfig.getTempDirName() + "/.emotions/" + g2 + "/" + f3).exists()) {
                valueOf3 = Boolean.FALSE;
            }
            valueOf = g2;
        }
        if (valueOf3.booleanValue()) {
            String f4 = d.b.j0.h0.b.e.i().f(valueOf2, true);
            Iterator<c> it = h2.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                c next = it.next();
                if (next.m(valueOf2)) {
                    if (next.j()) {
                        aVar2 = next.n(valueOf2);
                    } else {
                        aVar2 = e(next.f(), f4, bVar);
                    }
                }
            }
            return (aVar2 != null || valueOf == null) ? aVar2 : e(valueOf, f4, bVar);
        }
        String f5 = d.b.j0.h0.b.e.i().f(valueOf2, false);
        if (booleanValue && d.b.j0.h0.b.e.i().l(valueOf2)) {
            f5 = f5.replaceFirst("s_", "d_");
        }
        Iterator<c> it2 = h2.iterator();
        d.b.c.j.d.a aVar3 = null;
        while (true) {
            if (!it2.hasNext()) {
                aVar = aVar3;
                break;
            }
            c next2 = it2.next();
            if (next2.m(valueOf2)) {
                if (next2.j()) {
                    aVar3 = next2.o(valueOf2);
                } else {
                    Bitmap f6 = f(next2.f(), f5, bVar);
                    if (f6 == null) {
                        return null;
                    }
                    aVar = new d.b.c.j.d.a(f6, false, valueOf2);
                }
            }
        }
        return (aVar != null || valueOf == null || (f2 = f(valueOf, f5, bVar)) == null) ? aVar : new d.b.c.j.d.a(f2, false, valueOf2);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.c.e.l.e
    /* renamed from: c */
    public d.b.c.j.d.a getFromMemory(String str, String str2, int i, int i2, boolean z, Object... objArr) {
        return d.b.i0.a0.c.k().m(a(str, Boolean.valueOf(String.valueOf(objArr[2])).booleanValue()));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.c.e.l.e
    /* renamed from: d */
    public d.b.c.j.d.a getFromRemote(String str, String str2, int i, int i2, b bVar, Object... objArr) {
        d.b.c.j.d.a aVar;
        if (objArr != null && objArr.length == 4) {
            String valueOf = objArr[0] == null ? "" : String.valueOf(objArr[0]);
            String valueOf2 = objArr[1] == null ? "" : String.valueOf(objArr[1]);
            Boolean valueOf3 = Boolean.valueOf(String.valueOf(objArr[2]));
            String valueOf4 = objArr[3] == null ? "" : String.valueOf(objArr[3]);
            if (valueOf != null && valueOf2 != null && valueOf3 != null && valueOf4 != null) {
                WebClient webClient = new WebClient();
                byte[] downloadImageBytes = webClient.downloadImageBytes(valueOf4, false);
                boolean needCache = webClient.needCache();
                if (downloadImageBytes != null && webClient.IsRequestSuccess()) {
                    synchronized (BitmapHelper.lockForSyncImageDecoder) {
                        String f2 = d.b.j0.h0.b.e.i().f(valueOf2, valueOf3.booleanValue());
                        String str3 = ".emotions/" + valueOf;
                        if (valueOf3.booleanValue()) {
                            d.b.c.e.a.f.a aVar2 = new d.b.c.e.a.f.a(str3, f2, DiskFileOperate.Action.WRITE);
                            aVar2.setOperateType(DiskFileOperate.OperateType.TRY_SUCCESS);
                            aVar2.setSubFolder(false);
                            aVar2.setSavedCache(false);
                            aVar2.setSdCard(false);
                            aVar2.setData(downloadImageBytes);
                            d.g().d(aVar2);
                            if (bVar != null) {
                                DiskCancelWorker diskCancelWorker = new DiskCancelWorker();
                                diskCancelWorker.setOperate(aVar2);
                                bVar.f42585a = diskCancelWorker;
                            }
                            Iterator<c> it = d.b.j0.h0.b.e.i().h().iterator();
                            while (true) {
                                if (!it.hasNext()) {
                                    aVar = null;
                                    break;
                                }
                                c next = it.next();
                                if (next.m(valueOf2)) {
                                    aVar = e(next.f(), f2, bVar);
                                    break;
                                }
                            }
                            if (aVar == null && valueOf != null) {
                                aVar = e(valueOf, f2, bVar);
                            }
                            if (aVar == null) {
                                return null;
                            }
                        } else {
                            d.b.i0.a0.c.k().i(80000);
                            Bitmap checkBitmapSize = BitmapHelper.checkBitmapSize(BitmapHelper.Bytes2Bitmap(downloadImageBytes), i, i2);
                            if (checkBitmapSize == null) {
                                return null;
                            }
                            d.b.c.j.d.a aVar3 = new d.b.c.j.d.a(checkBitmapSize, valueOf3.booleanValue(), valueOf4);
                            aVar3.y(needCache);
                            if (needCache) {
                                d.b.c.e.a.f.c cVar = new d.b.c.e.a.f.c(str3, f2, DiskFileOperate.Action.WRITE);
                                cVar.setOperateType(DiskFileOperate.OperateType.TRY_SUCCESS);
                                cVar.setSubFolder(false);
                                cVar.setData(downloadImageBytes);
                                cVar.setSavedCache(false);
                                cVar.setSdCard(false);
                                cVar.setGif(valueOf3.booleanValue());
                                d.g().a(cVar);
                                if (bVar != null) {
                                    DiskCancelWorker diskCancelWorker2 = new DiskCancelWorker();
                                    diskCancelWorker2.setOperate(cVar);
                                    bVar.f42585a = diskCancelWorker2;
                                }
                            }
                            aVar = aVar3;
                        }
                        return aVar;
                    }
                }
            }
        }
        return null;
    }

    public d.b.c.j.d.a e(String str, String str2, b bVar) {
        String str3 = ".emotions/";
        if (str != null) {
            str3 = ".emotions/" + str + "/";
        }
        if (!UtilHelper.hasAvaiableSDCardSpace(1024)) {
            Bitmap f2 = f(str, str2, bVar);
            if (f2 == null) {
                return null;
            }
            return new d.b.c.j.d.a(f2, false, str2);
        }
        byte[] bArr = new byte[0];
        d.b.c.e.a.f.a aVar = new d.b.c.e.a.f.a(str3, str2, DiskFileOperate.Action.READ);
        aVar.setOperateType(DiskFileOperate.OperateType.TRY_SUCCESS);
        aVar.setSubFolder(false);
        aVar.setIsFormatData(false);
        aVar.setSavedCache(false);
        aVar.setSdCard(false);
        aVar.setLock(bArr);
        if (bVar != null) {
            DiskCancelWorker diskCancelWorker = new DiskCancelWorker();
            diskCancelWorker.setOperate(aVar);
            bVar.f42585a = diskCancelWorker;
        }
        if (d.g().a(aVar)) {
            int i = j.H() ? 500 : 2000;
            synchronized (bArr) {
                try {
                    bArr.wait(i);
                } catch (InterruptedException e2) {
                    BdLog.detailException(e2);
                }
            }
            if (aVar.isSuccess()) {
                aVar.formatData(aVar.getData());
                return new d.b.c.j.d.a(aVar.a());
            }
            return null;
        }
        return null;
    }

    public Bitmap f(String str, String str2, b bVar) {
        StringBuilder sb = new StringBuilder();
        sb.append(".emotions/");
        if (str == null) {
            str = "";
        }
        sb.append(str);
        byte[] bArr = new byte[0];
        DiskEmotionOperate diskEmotionOperate = new DiskEmotionOperate(sb.toString(), str2, DiskFileOperate.Action.READ);
        diskEmotionOperate.setOperateType(DiskFileOperate.OperateType.TRY_SUCCESS);
        diskEmotionOperate.setSubFolder(false);
        diskEmotionOperate.setIsFormatData(false);
        diskEmotionOperate.setSavedCache(false);
        diskEmotionOperate.setSdCard(false);
        diskEmotionOperate.setLock(bArr);
        if (bVar != null) {
            DiskCancelWorker diskCancelWorker = new DiskCancelWorker();
            diskCancelWorker.setOperate(diskEmotionOperate);
            bVar.f42585a = diskCancelWorker;
        }
        if (d.g().a(diskEmotionOperate)) {
            int i = j.H() ? 300 : 2000;
            synchronized (bArr) {
                try {
                    bArr.wait(i);
                } catch (InterruptedException e2) {
                    BdLog.detailException(e2);
                }
            }
            if (diskEmotionOperate.isSuccess()) {
                diskEmotionOperate.formatData(diskEmotionOperate.getData());
                return diskEmotionOperate.getBitmap();
            }
            return null;
        }
        return null;
    }

    @Override // d.b.c.e.l.e
    public BdAsyncTaskParallel getAsyncTaskParallel() {
        return null;
    }

    @Override // d.b.c.e.l.e
    public int getAsyncTaskPriority() {
        return 1;
    }

    @Override // d.b.c.e.l.e
    public boolean isNeedLoad() {
        return k.c().g();
    }

    @Override // d.b.c.e.l.e
    public void updateMemory(String str, Object obj, int i, int i2, Object... objArr) {
        if (obj == null || !(obj instanceof d.b.c.j.d.a)) {
            return;
        }
        d.b.c.j.d.a aVar = (d.b.c.j.d.a) obj;
        if (aVar.u()) {
            aVar.A(i);
            aVar.z(i2);
            d.b.i0.a0.c.k().d(a(str, Boolean.valueOf(String.valueOf(objArr[2])).booleanValue()), aVar);
        }
    }
}
