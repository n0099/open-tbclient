package d.b.i0.o0;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Message;
import android.os.Process;
import android.text.TextUtils;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.plugin.packageManager.pluginFileDownload.BdFileDownloadData;
import com.baidu.adp.plugin.util.Util;
import com.baidu.searchbox.live.interfaces.net.NetWorkError;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.CommonHelper;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.tbadk.core.util.NetWork;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.R;
import com.kwai.sodler.lib.ext.PluginError;
import d.b.c.e.p.f;
import d.b.c.e.p.j;
import d.b.c.e.p.k;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes3.dex */
public class c extends d.b.c.h.j.e.b {

    /* renamed from: c  reason: collision with root package name */
    public static c f51126c = new c();

    /* renamed from: d  reason: collision with root package name */
    public static BdFileDownloadData f51127d = null;

    /* renamed from: e  reason: collision with root package name */
    public static List<BdFileDownloadData> f51128e = new LinkedList();

    /* renamed from: a  reason: collision with root package name */
    public b f51129a = null;
    @SuppressLint({"HandlerLeak"})

    /* renamed from: b  reason: collision with root package name */
    public Handler f51130b = new a(this);

    /* loaded from: classes3.dex */
    public class a extends Handler {
        public a(c cVar) {
        }

        @Override // android.os.Handler
        public void dispatchMessage(Message message) {
            if (message != null && message.what == -1 && (message.obj instanceof d.b.i0.o0.b)) {
                if (c.f51127d != null) {
                    d.b.i0.o0.b bVar = (d.b.i0.o0.b) message.obj;
                    c.f51127d.setErrorCode(message.arg1);
                    c.f51127d.setAfterHttpDnsUrl(bVar.a());
                    c.f51127d.setStatusMsg(bVar.g());
                    return;
                }
                return;
            }
            super.dispatchMessage(message);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            if (message.what != 900002 || message.arg2 <= 0 || c.f51127d == null) {
                return;
            }
            c.f51127d.setLength(message.arg1);
            c.f51127d.setSize(message.arg2);
            if (c.f51127d.getCallback() != null) {
                c.f51127d.getCallback().d(c.f51127d);
            }
        }
    }

    @SuppressLint({"DefaultLocale"})
    /* loaded from: classes3.dex */
    public class b extends BdAsyncTask<BdFileDownloadData, BdFileDownloadData, Integer> {

        /* renamed from: d  reason: collision with root package name */
        public BdFileDownloadData f51134d;
        public long i;
        public long j;
        public long k;

        /* renamed from: a  reason: collision with root package name */
        public NetWork f51131a = new NetWork();

        /* renamed from: b  reason: collision with root package name */
        public long f51132b = -1;

        /* renamed from: c  reason: collision with root package name */
        public String f51133c = null;

        /* renamed from: e  reason: collision with root package name */
        public String f51135e = null;

        /* renamed from: f  reason: collision with root package name */
        public String f51136f = "";

        /* renamed from: g  reason: collision with root package name */
        public String f51137g = "";

        /* renamed from: h  reason: collision with root package name */
        public String f51138h = "";

        public b() {
        }

        public final boolean b(File file, String str, byte[] bArr) {
            FileInputStream fileInputStream;
            String y;
            if (!file.exists() || file.length() <= 0) {
                return false;
            }
            FileInputStream fileInputStream2 = null;
            try {
                try {
                    try {
                        fileInputStream = new FileInputStream(file);
                    } catch (Exception e2) {
                        e = e2;
                    }
                } catch (Throwable th) {
                    th = th;
                }
            } catch (IOException e3) {
                BdLog.d(e3.getMessage());
            }
            try {
                y = Util.y(fileInputStream, bArr);
            } catch (Exception e4) {
                e = e4;
                fileInputStream2 = fileInputStream;
                BdLog.d(e.getMessage());
                if (fileInputStream2 != null) {
                    fileInputStream2.close();
                }
                return false;
            } catch (Throwable th2) {
                th = th2;
                fileInputStream2 = fileInputStream;
                if (fileInputStream2 != null) {
                    try {
                        fileInputStream2.close();
                    } catch (IOException e5) {
                        BdLog.d(e5.getMessage());
                    }
                }
                throw th;
            }
            if (!y.equalsIgnoreCase(str)) {
                this.f51132b = file.length();
                this.f51133c = y;
                f.n(file);
                this.f51135e = d.b.i0.o0.a.a(file);
                fileInputStream.close();
                return false;
            }
            try {
                fileInputStream.close();
            } catch (IOException e6) {
                BdLog.d(e6.getMessage());
            }
            return true;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public Integer doInBackground(BdFileDownloadData... bdFileDownloadDataArr) {
            if (bdFileDownloadDataArr[0] == null) {
                return 3;
            }
            this.f51134d = bdFileDownloadDataArr[0];
            if (bdFileDownloadDataArr[0].getCallback() != null && !bdFileDownloadDataArr[0].getCallback().b(bdFileDownloadDataArr[0])) {
                return 0;
            }
            BdLog.i("pluginFileDownloader beging download " + bdFileDownloadDataArr[0].getId());
            if (bdFileDownloadDataArr[0].getPath() != null && bdFileDownloadDataArr[0].getCheck() != null) {
                this.f51136f = bdFileDownloadDataArr[0].getId();
                this.f51131a.setUrl(bdFileDownloadDataArr[0].getUrl());
                this.f51131a.setCanHttpsDownToHttp(true);
                File file = new File(bdFileDownloadDataArr[0].getPath());
                if (b(file, bdFileDownloadDataArr[0].getCheck(), null)) {
                    return 0;
                }
                if (!file.exists()) {
                    long currentTimeMillis = System.currentTimeMillis();
                    this.f51137g = UtilHelper.getIpFromDomain("tb1.bdstatic.com");
                    int d2 = d(bdFileDownloadDataArr[0], null);
                    if (d2 == 6 || d2 == 7) {
                        d2 = d(bdFileDownloadDataArr[0], null);
                    }
                    this.i = System.currentTimeMillis() - currentTimeMillis;
                    if (d2 != 0) {
                        return Integer.valueOf(d2);
                    }
                }
                if (bdFileDownloadDataArr[0].getCallback() == null || bdFileDownloadDataArr[0].getCallback().c(bdFileDownloadDataArr[0])) {
                    if (c.this.o(bdFileDownloadDataArr[0])) {
                        return 0;
                    }
                    return 9;
                }
                return 5;
            }
            return 4;
        }

        public final int d(BdFileDownloadData bdFileDownloadData, byte[] bArr) {
            BdLog.i("pluginFileDownloader downloadPlugin " + bdFileDownloadData.getPath());
            File file = new File(bdFileDownloadData.getPath());
            File file2 = new File(c.this.m(bdFileDownloadData));
            long length = file2.length();
            if (this.f51131a.downloadFile(c.this.m(bdFileDownloadData), c.this.f51130b, TbConfig.NET_MSG_GETLENTH, 3, 3000, true)) {
                if (g(file2, file, bArr)) {
                    return b(file, bdFileDownloadData.getCheck(), bArr) ? 0 : 6;
                }
                return 8;
            } else if (this.f51131a.getNetContext().getResponse().mNetErrorCode == 416) {
                if (b(file2, bdFileDownloadData.getCheck(), null)) {
                    if (g(file2, file, bArr)) {
                        return b(file, bdFileDownloadData.getCheck(), bArr) ? 0 : 6;
                    }
                    return 8;
                }
                return 7;
            } else {
                this.j = file2.length();
                this.k = file2.length() - length;
                return e();
            }
        }

        public final int e() {
            if (j.z()) {
                if (c.f51127d != null) {
                    int errorCode = c.f51127d.getErrorCode();
                    if (errorCode != -100) {
                        switch (errorCode) {
                            case NetWorkError.NETWORK_CONNECT_EXCEPTION /* -22 */:
                                return 3009;
                            case NetWorkError.NETWORK_UNKNOWN_HOST_EXCEPTION /* -21 */:
                                return 3008;
                            case -20:
                                return 3007;
                            case -19:
                                return 3004;
                            default:
                                switch (errorCode) {
                                    case -15:
                                        return 3005;
                                    case -14:
                                        return 3000;
                                    case -13:
                                        return 3002;
                                    case -12:
                                        return 3001;
                                }
                        }
                    }
                    return 3003;
                }
                return 2;
            }
            return PluginError.ERROR_INS_INSTALL_PATH;
        }

        /* JADX WARN: Removed duplicated region for block: B:19:0x0060  */
        /* JADX WARN: Removed duplicated region for block: B:22:0x0067  */
        /* JADX WARN: Removed duplicated region for block: B:29:0x0099  */
        /* JADX WARN: Removed duplicated region for block: B:30:0x009c  */
        /* JADX WARN: Removed duplicated region for block: B:33:0x00c5  */
        /* JADX WARN: Removed duplicated region for block: B:34:0x00c8  */
        /* JADX WARN: Removed duplicated region for block: B:37:0x0117  */
        /* JADX WARN: Removed duplicated region for block: B:44:0x01c3  */
        /* JADX WARN: Removed duplicated region for block: B:47:0x01e7  */
        /* JADX WARN: Removed duplicated region for block: B:49:? A[RETURN, SYNTHETIC] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final void f(Integer num) {
            String string;
            String statusMsg = c.f51127d.getStatusMsg();
            int intValue = num.intValue();
            if (intValue != 2) {
                if (intValue != 3 && intValue != 4 && intValue != 5 && intValue != 8 && intValue != 9) {
                    switch (intValue) {
                        case 3000:
                        case 3001:
                        case 3002:
                        case 3003:
                        case 3004:
                        case 3005:
                        case 3007:
                        case 3008:
                        case 3009:
                            string = TbadkCoreApplication.getInst().getApp().getString(R.string.download_fail_net);
                            break;
                        case PluginError.ERROR_INS_INSTALL_PATH /* 3006 */:
                            break;
                        default:
                            string = TbadkCoreApplication.getInst().getApp().getString(R.string.tb_err_unknown);
                            break;
                    }
                } else {
                    string = TbadkCoreApplication.getInst().getApp().getString(R.string.download_fail);
                }
                if (statusMsg == null) {
                    statusMsg = string;
                }
                if (num.intValue() == 8) {
                    statusMsg = statusMsg + "_err-" + this.f51138h;
                }
                if (num.intValue() != 6 || num.intValue() == 7) {
                    String c2 = d.b.i0.o0.a.c(TbadkCoreApplication.getInst());
                    String str = !d.b.i0.o0.a.b() ? "true" : "false";
                    StringBuilder sb = new StringBuilder();
                    sb.append("_downloadfilesize-");
                    sb.append(this.f51132b);
                    sb.append(" ");
                    sb.append("downloadfileMd5-");
                    sb.append(this.f51133c);
                    sb.append(" wishMd5-");
                    BdFileDownloadData bdFileDownloadData = this.f51134d;
                    sb.append(bdFileDownloadData != null ? "" : bdFileDownloadData.getCheck());
                    sb.append("-url_");
                    sb.append(c.f51127d.getUrl());
                    sb.append("-realurl_");
                    sb.append(c.f51127d.getAfterHttpDnsUrl());
                    sb.append("-uploadResult_");
                    sb.append(this.f51135e);
                    sb.append("-Proxy_");
                    sb.append(c2);
                    sb.append("-UsbDebug_");
                    sb.append(str);
                    sb.append("-errorMsg_");
                    sb.append(statusMsg);
                    statusMsg = sb.toString();
                }
                if (statusMsg != null) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("-netType_");
                    sb2.append(j.J());
                    sb2.append("-cost_");
                    sb2.append(this.i);
                    sb2.append("-downloadSize_");
                    sb2.append(this.k);
                    sb2.append("-tempSize_");
                    sb2.append(this.j);
                    sb2.append("-clientIp_");
                    sb2.append(CommonHelper.getIp());
                    sb2.append("-cdnIp_");
                    sb2.append(this.f51137g);
                    sb2.append("-NetChangeTime_");
                    sb2.append(j.l());
                    sb2.append("-syncTime_");
                    sb2.append(TbadkCoreApplication.getInst().getLastSyncFinishTime());
                    if (TbadkCoreApplication.getInst().isInBackground()) {
                        sb2.append("|Background:true");
                    } else {
                        sb2.append("|Background:false|TopActivity:");
                        sb2.append(UtilHelper.getTopActivityClassName());
                    }
                    statusMsg = statusMsg + sb2.toString();
                }
                c.f51127d.setStatusMsg(string);
                c.f51127d.setErrorCode(num.intValue());
                if (c.f51127d.getCallback() != null) {
                    c.f51127d.getCallback().e(c.f51127d, num.intValue(), string, statusMsg);
                }
                c.f51127d.setStatus(2);
                if (c.f51127d.getCallback() == null) {
                    c.f51127d.getCallback().d(c.f51127d);
                    return;
                }
                return;
            }
            string = TbadkCoreApplication.getInst().getApp().getString(R.string.download_fail_net);
            if (statusMsg == null) {
            }
            if (num.intValue() == 8) {
            }
            if (num.intValue() != 6) {
            }
            String c22 = d.b.i0.o0.a.c(TbadkCoreApplication.getInst());
            if (!d.b.i0.o0.a.b()) {
            }
            StringBuilder sb3 = new StringBuilder();
            sb3.append("_downloadfilesize-");
            sb3.append(this.f51132b);
            sb3.append(" ");
            sb3.append("downloadfileMd5-");
            sb3.append(this.f51133c);
            sb3.append(" wishMd5-");
            BdFileDownloadData bdFileDownloadData2 = this.f51134d;
            sb3.append(bdFileDownloadData2 != null ? "" : bdFileDownloadData2.getCheck());
            sb3.append("-url_");
            sb3.append(c.f51127d.getUrl());
            sb3.append("-realurl_");
            sb3.append(c.f51127d.getAfterHttpDnsUrl());
            sb3.append("-uploadResult_");
            sb3.append(this.f51135e);
            sb3.append("-Proxy_");
            sb3.append(c22);
            sb3.append("-UsbDebug_");
            sb3.append(str);
            sb3.append("-errorMsg_");
            sb3.append(statusMsg);
            statusMsg = sb3.toString();
            if (statusMsg != null) {
            }
            c.f51127d.setStatusMsg(string);
            c.f51127d.setErrorCode(num.intValue());
            if (c.f51127d.getCallback() != null) {
            }
            c.f51127d.setStatus(2);
            if (c.f51127d.getCallback() == null) {
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:33:0x005c  */
        /* JADX WARN: Removed duplicated region for block: B:34:0x005f  */
        /* JADX WARN: Removed duplicated region for block: B:37:0x006c A[Catch: Exception -> 0x009d, TRY_ENTER, TryCatch #1 {Exception -> 0x009d, blocks: (B:37:0x006c, B:38:0x0070, B:40:0x0076, B:41:0x0079, B:43:0x007f, B:45:0x0085, B:47:0x008d, B:49:0x0091, B:50:0x0096, B:51:0x0097, B:52:0x009c), top: B:62:0x006a }] */
        /* JADX WARN: Removed duplicated region for block: B:38:0x0070 A[Catch: Exception -> 0x009d, TryCatch #1 {Exception -> 0x009d, blocks: (B:37:0x006c, B:38:0x0070, B:40:0x0076, B:41:0x0079, B:43:0x007f, B:45:0x0085, B:47:0x008d, B:49:0x0091, B:50:0x0096, B:51:0x0097, B:52:0x009c), top: B:62:0x006a }] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final boolean g(File file, File file2, byte[] bArr) {
            Exception exc;
            long j;
            boolean z;
            if (file.exists() && file.length() > 0) {
                try {
                    if (file2.exists()) {
                        file2.delete();
                    }
                    j = file.length();
                } catch (Exception e2) {
                    exc = e2;
                    j = 0;
                }
                try {
                } catch (Exception e3) {
                    exc = e3;
                    z = false;
                    d.b.c.h.h.a.b().p("retry_rename_tmp", this.f51136f, !z ? "true" : "false", exc.toString());
                    try {
                        if (!z) {
                        }
                        return true;
                    } catch (Exception e4) {
                        f.n(file2);
                        this.f51138h = "avirom_" + Util.g() + "-filesize_" + j + "-exception_" + exc.toString() + "-exception1_" + e4.toString();
                        return false;
                    }
                }
                if (d.b.i0.o0.a.d(file, file2, bArr)) {
                    if (file2.exists() && file2.length() != 0) {
                        try {
                            file.delete();
                        } catch (Exception e5) {
                            exc = e5;
                            z = true;
                            d.b.c.h.h.a.b().p("retry_rename_tmp", this.f51136f, !z ? "true" : "false", exc.toString());
                            if (!z) {
                                file.delete();
                            } else {
                                if (file2.exists()) {
                                    file2.delete();
                                }
                                if (d.b.i0.o0.a.d(file, file2, bArr)) {
                                    if (file2.exists() && file2.length() != 0) {
                                        file.delete();
                                    } else {
                                        throw new Exception("rename fail");
                                    }
                                } else {
                                    throw new Exception("rename return fail");
                                }
                            }
                            return true;
                        }
                        return true;
                    }
                    throw new Exception("rename fail");
                }
                throw new Exception("rename return fail");
            }
            if (file.exists()) {
                this.f51138h = "temp_exists";
                f.n(file);
            }
            return false;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            super.onCancelled();
            this.f51131a.cancelNetConnect();
            c.f51127d.setStatus(4);
            c.f51127d.setStatusMsg(null);
            if (c.f51127d.getCallback() != null) {
                c.f51127d.getCallback().d(c.f51127d);
            }
            if (!c.f51128e.isEmpty()) {
                c.f51128e.remove(0);
            }
            BdFileDownloadData unused = c.f51127d = null;
            c.this.p();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Integer num) {
            super.onPostExecute((b) num);
            if (num == null) {
                num = -1;
            }
            if (num.intValue() == 0) {
                if (c.f51127d.getCallback() != null) {
                    c.f51127d.getCallback().a(c.f51127d);
                }
                c.f51127d.setStatus(0);
                if (c.f51127d.getCallback() != null) {
                    c.f51127d.getCallback().d(c.f51127d);
                }
            } else {
                f(num);
            }
            BdFileDownloadData unused = c.f51127d = null;
            if (c.f51128e.isEmpty()) {
                return;
            }
            c.f51128e.remove(0);
            c.this.p();
        }
    }

    public static c n() {
        return f51126c;
    }

    @Override // d.b.c.h.j.e.b
    public void a(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        BdFileDownloadData bdFileDownloadData = f51127d;
        if (bdFileDownloadData != null && bdFileDownloadData.getId().equals(str)) {
            this.f51129a.cancel(true);
            return;
        }
        LinkedList<BdFileDownloadData> linkedList = new LinkedList();
        Iterator<BdFileDownloadData> it = f51128e.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            BdFileDownloadData next = it.next();
            if (next.getId().equals(str)) {
                next.setStatus(4);
                next.setStatusMsg(null);
                if (next.getCallback() != null) {
                    next.getCallback().d(next);
                }
                linkedList.add(next);
            }
        }
        for (BdFileDownloadData bdFileDownloadData2 : linkedList) {
            f51128e.remove(bdFileDownloadData2);
        }
    }

    @Override // d.b.c.h.j.e.b
    public List<BdFileDownloadData> b() {
        return f51128e;
    }

    @Override // d.b.c.h.j.e.b
    public void d(BdFileDownloadData bdFileDownloadData, int i) {
        if (bdFileDownloadData == null) {
            return;
        }
        if (!FileHelper.checkSD() && i == 2) {
            bdFileDownloadData.setStatusMsg(TbadkCoreApplication.getInst().getApp().getString(R.string.download_fail_no_sd));
            bdFileDownloadData.setStatus(2);
        }
        if (bdFileDownloadData.getStatus() == 2) {
            if (bdFileDownloadData.getCallback() != null) {
                bdFileDownloadData.getCallback().d(bdFileDownloadData);
                return;
            }
            return;
        }
        BdStatisticsManager bdStatisticsManager = BdStatisticsManager.getInstance();
        BdBaseApplication inst = BdBaseApplication.getInst();
        bdStatisticsManager.eventStat(inst, "plugin_start_download", null, 1, "pname", bdFileDownloadData.getId(), "appver", BdStatisticsManager.getInstance().getAppVersion(), "comment", "downloadByAuto-isBackgrount_" + TbadkCoreApplication.getInst().isInBackground(), "pid", Integer.valueOf(Process.myPid()));
        for (int i2 = 0; i2 < f51128e.size(); i2++) {
            BdFileDownloadData bdFileDownloadData2 = f51128e.get(i2);
            if (bdFileDownloadData2 != null && !k.isEmpty(bdFileDownloadData2.getUrl()) && bdFileDownloadData2.getUrl().equals(bdFileDownloadData.getUrl()) && bdFileDownloadData2.getId().equals(bdFileDownloadData.getId())) {
                return;
            }
        }
        bdFileDownloadData.setStatus(1);
        f51128e.add(bdFileDownloadData);
        p();
    }

    @Override // d.b.c.h.j.e.b
    public void e(BdFileDownloadData bdFileDownloadData, int i) {
        if (bdFileDownloadData == null) {
            return;
        }
        if (!FileHelper.checkSD() && i == 2) {
            bdFileDownloadData.setStatusMsg(TbadkCoreApplication.getInst().getApp().getString(R.string.download_fail_no_sd));
            bdFileDownloadData.setStatus(2);
        }
        if (bdFileDownloadData.getStatus() == 2) {
            if (bdFileDownloadData.getCallback() != null) {
                bdFileDownloadData.getCallback().d(bdFileDownloadData);
                return;
            }
            return;
        }
        BdStatisticsManager bdStatisticsManager = BdStatisticsManager.getInstance();
        BdBaseApplication inst = BdBaseApplication.getInst();
        bdStatisticsManager.eventStat(inst, "plugin_start_download", null, 1, "pname", bdFileDownloadData.getId(), "appver", BdStatisticsManager.getInstance().getAppVersion(), "comment", "downloadByUser-isBackgrount_" + TbadkCoreApplication.getInst().isInBackground(), "pid", Integer.valueOf(Process.myPid()));
        BdFileDownloadData bdFileDownloadData2 = f51127d;
        if (bdFileDownloadData2 != null && bdFileDownloadData2.getUrl().equals(bdFileDownloadData.getUrl()) && f51127d.getId().equals(bdFileDownloadData.getId())) {
            return;
        }
        for (int i2 = 0; i2 < f51128e.size(); i2++) {
            BdFileDownloadData bdFileDownloadData3 = f51128e.get(i2);
            if (bdFileDownloadData3 != null && bdFileDownloadData3.getUrl().equals(bdFileDownloadData.getUrl()) && bdFileDownloadData3.getId().equals(bdFileDownloadData.getId())) {
                f51128e.remove(i2);
                f51128e.add(0, bdFileDownloadData3);
                return;
            }
        }
        bdFileDownloadData.setStatus(1);
        f51128e.add(0, bdFileDownloadData);
        p();
    }

    public final String m(BdFileDownloadData bdFileDownloadData) {
        if (bdFileDownloadData == null) {
            return null;
        }
        return bdFileDownloadData.getPath() + ".tmp";
    }

    public final boolean o(BdFileDownloadData bdFileDownloadData) {
        if (bdFileDownloadData == null) {
            return false;
        }
        String path = bdFileDownloadData.getPath();
        return !TextUtils.isEmpty(path) && new File(path).exists();
    }

    public final void p() {
        if (f51127d != null || f51128e.isEmpty()) {
            return;
        }
        BdFileDownloadData bdFileDownloadData = f51128e.get(0);
        f51127d = bdFileDownloadData;
        if (bdFileDownloadData != null) {
            b bVar = new b();
            this.f51129a = bVar;
            bVar.execute(f51127d);
        }
    }
}
