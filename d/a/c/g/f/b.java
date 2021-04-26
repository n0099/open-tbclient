package d.a.c.g.f;

import android.app.Application;
import android.util.Log;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.nps.interfa.IHostAppRuntime;
import com.baidu.pyramid.annotation.Service;
import com.baidu.pyramid.annotation.Singleton;
@Singleton
@Service
/* loaded from: classes.dex */
public class b implements IHostAppRuntime {
    @Override // com.baidu.nps.interfa.IHostAppRuntime
    public Application getApplication() {
        Log.e("TAG", "" + BdBaseApplication.getInst());
        return BdBaseApplication.getInst();
    }
}
