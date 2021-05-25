package d.a.n0.u.b.n;

import android.content.Context;
import com.baidu.pyramid.annotation.Service;
import com.baidu.pyramid.annotation.Singleton;
import com.baidu.searchbox.process.ipc.delegate.DelegateResult;
import com.baidu.searchbox.process.ipc.delegate.DelegateUtils;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import d.a.l0.a.c1.d.k;
@Singleton
@Service
/* loaded from: classes4.dex */
public class b implements k {
    public static String b(Context context) {
        return TbadkCoreApplication.getInst().getZid(context, null, 0, null);
    }

    @Override // d.a.l0.a.c1.d.k
    public String a(Context context) {
        if (!ProcessUtils.isMainProcess()) {
            return c(context);
        }
        return b(context);
    }

    public final String c(Context context) {
        DelegateResult callOnMainWithContentProvider = DelegateUtils.callOnMainWithContentProvider(context, a.class, null);
        return callOnMainWithContentProvider.isOk() ? callOnMainWithContentProvider.mResult.getString("result", "") : "";
    }
}
