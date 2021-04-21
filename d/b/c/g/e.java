package d.b.c.g;

import com.baidu.nps.interfa.IThreadManager;
import com.baidu.pyramid.annotation.Service;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import java.util.concurrent.Executor;
@Service
/* loaded from: classes.dex */
public class e implements IThreadManager {

    /* renamed from: a  reason: collision with root package name */
    public Executor f42917a = ExecutorUtilsExt.getElasticExecutor("NPS", 3);

    @Override // com.baidu.nps.interfa.IThreadManager
    public void run(Runnable runnable) {
        this.f42917a.execute(runnable);
    }
}
