package d.a.j0.y2;

import com.baidu.pyramid.annotation.Service;
import com.baidu.pyramid.annotation.Singleton;
import com.baidu.tbadk.TbConfig;
@Singleton
@Service
/* loaded from: classes5.dex */
public class g implements d.a.l.c.e {
    @Override // d.a.l.c.e
    public String getAppVersion() {
        return TbConfig.getVersion();
    }
}
