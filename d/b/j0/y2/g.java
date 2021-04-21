package d.b.j0.y2;

import com.baidu.pyramid.annotation.Service;
import com.baidu.pyramid.annotation.Singleton;
import com.baidu.tbadk.TbConfig;
@Singleton
@Service
/* loaded from: classes4.dex */
public class g implements d.b.l.c.d {
    @Override // d.b.l.c.d
    public String getAppVersion() {
        return TbConfig.getVersion();
    }
}
