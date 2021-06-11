package com.yy.hiidostatis.message.sender;

import android.content.Context;
import com.yy.hiidostatis.inner.util.ThreadPool;
import com.yy.hiidostatis.message.AppInfo;
import com.yy.hiidostatis.provider.MessageConfig;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.Locale;
/* loaded from: classes7.dex */
public class AppInfoManager implements AppInfo {
    public String appkey;
    public Context context;
    public boolean init;
    public long preFetchTime;
    public String ver;

    public AppInfoManager(Context context) {
        this.context = context;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearDir() {
        try {
            File file = new File(getDir(this.context));
            file.mkdirs();
            File[] listFiles = file.listFiles(getFileFilter());
            if (listFiles == null || listFiles.length <= 0) {
                return;
            }
            for (File file2 : listFiles) {
                file2.delete();
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getDir(Context context) {
        return String.format(Locale.CHINA, "%s/hiido", context.getFilesDir().getAbsolutePath());
    }

    private FilenameFilter getFileFilter() {
        return new FilenameFilter() { // from class: com.yy.hiidostatis.message.sender.AppInfoManager.2
            @Override // java.io.FilenameFilter
            public boolean accept(File file, String str) {
                return str.endsWith(".appinfo");
            }
        };
    }

    private synchronized void load() {
        int indexOf;
        try {
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        if (this.preFetchTime == 0 || System.currentTimeMillis() - this.preFetchTime >= 3000) {
            if (this.preFetchTime > 0) {
                this.init = true;
            }
            this.preFetchTime = System.currentTimeMillis();
            String[] list = new File(getDir(this.context)).list(getFileFilter());
            if (list != null && list.length > 0 && (indexOf = list[0].indexOf("_")) > 0) {
                String substring = list[0].substring(0, indexOf);
                String substring2 = list[0].substring(indexOf + 1, list[0].length() - 8);
                this.appkey = substring;
                this.ver = substring2;
                this.init = true;
            }
        }
    }

    private void updateLocalRecord(final Context context, final String str, final String str2) {
        ThreadPool.getPool().execute(new Runnable() { // from class: com.yy.hiidostatis.message.sender.AppInfoManager.1
            @Override // java.lang.Runnable
            public void run() {
                File file = new File(String.format(Locale.CHINA, "%s/%s_%s.appinfo", AppInfoManager.this.getDir(context), str, str2));
                if (file.exists()) {
                    return;
                }
                try {
                    AppInfoManager.this.clearDir();
                    file.createNewFile();
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
            }
        });
    }

    @Override // com.yy.hiidostatis.message.AppInfo
    public String getAppAppkey() {
        if (!this.init) {
            load();
        }
        return this.appkey;
    }

    @Override // com.yy.hiidostatis.message.AppInfo
    public String getAppVer() {
        if (!this.init) {
            load();
        }
        return this.ver;
    }

    @Override // com.yy.hiidostatis.message.AppInfo
    public synchronized void updateAppInfo(MessageConfig messageConfig) {
        this.init = true;
        if (!messageConfig.getAppkey().equals(this.appkey) || !messageConfig.getVer().equals(this.ver)) {
            this.appkey = messageConfig.getAppkey();
            this.ver = messageConfig.getVer();
            updateLocalRecord(messageConfig.getApplicationContext(), this.appkey, this.ver);
        }
    }
}
