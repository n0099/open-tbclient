package d.a.o0.r1.c;

import android.app.Application;
import android.os.Build;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.live.interfaces.service.AppInfoService;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.SmallTailInfo;
import d.a.n0.z0.n0;
/* loaded from: classes3.dex */
public class b implements AppInfoService {
    @Override // com.baidu.searchbox.live.interfaces.service.AppInfoService
    public Application getApplication() {
        return TbadkCoreApplication.getInst();
    }

    @Override // com.baidu.searchbox.live.interfaces.service.AppInfoService
    public String getCuid() {
        return TbadkCoreApplication.getInst().getCuidGalaxy2();
    }

    @Override // com.baidu.searchbox.live.interfaces.service.AppInfoService
    public String getFFmpegPath() {
        return "";
    }

    @Override // com.baidu.searchbox.live.interfaces.service.AppInfoService
    public String getImAppId() {
        return String.valueOf((long) Constants.APPID_TIEBA);
    }

    @Override // com.baidu.searchbox.live.interfaces.service.AppInfoService
    public String getLiveAppId() {
        return "tieba";
    }

    @Override // com.baidu.searchbox.live.interfaces.service.AppInfoService
    public String getPackageName() {
        return "com.baidu.tieba";
    }

    @Override // com.baidu.searchbox.live.interfaces.service.AppInfoService
    public String getSid() {
        return "";
    }

    @Override // com.baidu.searchbox.live.interfaces.service.AppInfoService
    public String getUA() {
        return n0.b() + " (Baidu; P1 " + Build.VERSION.RELEASE + SmallTailInfo.EMOTION_SUFFIX;
    }

    @Override // com.baidu.searchbox.live.interfaces.service.AppInfoService
    public String getVersionCode() {
        return TbadkCoreApplication.getInst().getVersionCode() + "";
    }

    @Override // com.baidu.searchbox.live.interfaces.service.AppInfoService
    public String getVersionName() {
        return TbConfig.getVersion();
    }

    @Override // com.baidu.searchbox.live.interfaces.service.AppInfoService
    public String getZid() {
        return TbadkCoreApplication.getInst().getZid();
    }

    @Override // com.baidu.searchbox.live.interfaces.service.AppInfoService
    public boolean isDebug() {
        return AppConfig.isDebug();
    }

    @Override // com.baidu.searchbox.live.interfaces.service.AppInfoService
    public boolean isNightMode() {
        return false;
    }
}
