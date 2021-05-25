package d.a.n0.m0;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tieba.faceshop.EmotionGroupData;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
/* loaded from: classes4.dex */
public class e implements d.a.m0.v.c {
    @Override // d.a.m0.v.c
    public void onFileDownloadFailed(DownloadData downloadData, int i2, String str) {
        if (i2 != 3) {
            try {
                File file = new File(downloadData.getPath());
                if (file.exists()) {
                    file.delete();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    @Override // d.a.m0.v.c
    public void onFileDownloadSucceed(DownloadData downloadData) {
        MessageManager.getInstance().runTask(2004603, (Class) null);
        try {
            File file = new File(downloadData.getPath());
            if (file.exists()) {
                file.delete();
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @Override // d.a.m0.v.c
    public boolean onFileDownloaded(DownloadData downloadData) {
        FileInputStream fileInputStream;
        if (downloadData == null) {
            return false;
        }
        FileInputStream fileInputStream2 = null;
        try {
            try {
                fileInputStream = new FileInputStream(downloadData.getPath());
            } catch (Throwable th) {
                th = th;
            }
        } catch (Exception e2) {
            e = e2;
        }
        try {
            int g2 = a.c().g(downloadData.getId(), fileInputStream);
            EmotionGroupData j = g.k().j(downloadData.getId());
            if (j == null) {
                if (g2 == 0) {
                    try {
                        fileInputStream.close();
                    } catch (IOException e3) {
                        BdLog.detailException(e3);
                    }
                    return false;
                }
                j = new EmotionGroupData();
                j.setBytesLength((int) downloadData.getSize());
                j.setBytesReceived((int) downloadData.getLength());
                j.setDownloadUrl(downloadData.getUrl());
                j.setGroupId(downloadData.getId());
                j.setEmotionsCount(g2);
                j.setHeight(downloadData.getHeight());
                j.setWidth(downloadData.getWidth());
                j.setDownloadTime(System.currentTimeMillis());
                j.setGroupDesc(downloadData.getDescription());
                j.setGroupName(downloadData.getName());
                j.setStatus(1);
                g.k().e(j);
            }
            g.k().f(downloadData.getStatusMsg(), j);
            downloadData.setStatusMsg(null);
            try {
                fileInputStream.close();
            } catch (IOException e4) {
                BdLog.detailException(e4);
            }
            return true;
        } catch (Exception e5) {
            e = e5;
            fileInputStream2 = fileInputStream;
            BdLog.detailException(e);
            if (fileInputStream2 != null) {
                try {
                    fileInputStream2.close();
                } catch (IOException e6) {
                    BdLog.detailException(e6);
                }
            }
            return false;
        } catch (Throwable th2) {
            th = th2;
            fileInputStream2 = fileInputStream;
            if (fileInputStream2 != null) {
                try {
                    fileInputStream2.close();
                } catch (IOException e7) {
                    BdLog.detailException(e7);
                }
            }
            throw th;
        }
    }

    @Override // d.a.m0.v.c
    public void onFileUpdateProgress(DownloadData downloadData) {
        if (downloadData == null) {
            return;
        }
        f.f().i(downloadData);
    }

    @Override // d.a.m0.v.c
    public boolean onPreDownload(DownloadData downloadData) {
        if (downloadData == null) {
            return false;
        }
        EmotionGroupData j = g.k().j(downloadData.getId());
        if (j == null || !b.d(downloadData.getId())) {
            return true;
        }
        g.k().f(downloadData.getStatusMsg(), j);
        downloadData.setStatusMsg(null);
        return false;
    }
}
