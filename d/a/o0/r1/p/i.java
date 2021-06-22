package d.a.o0.r1.p;

import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.searchbox.live.interfaces.player.LivePlayer;
import com.baidu.searchbox.live.interfaces.service.ILivePlayerService;
import com.baidu.searchbox.player.BDPlayerConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes3.dex */
public class i implements ILivePlayerService {
    @Override // com.baidu.searchbox.live.interfaces.service.ILivePlayerService
    public LivePlayer createBackPlayer(String str) {
        return new e(str);
    }

    @Override // com.baidu.searchbox.live.interfaces.service.ILivePlayerService
    public LivePlayer createPlayer(String str) {
        return new f(str);
    }

    @Override // com.baidu.searchbox.live.interfaces.service.ILivePlayerService
    public void initPlayerEvn(CyberPlayerManager.InstallListener installListener, int i2) {
        BDPlayerConfig.setAppContext(TbadkCoreApplication.getInst());
        BDPlayerConfig.initEnv(false);
        g.e().h(installListener, i2);
    }
}
