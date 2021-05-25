package d.a.l0.a.p.b.a;

import android.content.Intent;
import android.view.View;
import com.baidu.searchbox.v8engine.V8ExceptionInfo;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.extcore.model.ExtensionCore;
import com.baidu.swan.apps.swancore.model.SwanCoreVersion;
/* loaded from: classes2.dex */
public interface g {
    SwanCoreVersion n();

    d.a.l0.a.t0.c o(SwanAppActivity swanAppActivity, String str);

    d.a.l0.a.h0.m.l p(d.a.l0.a.v2.e1.b<Exception> bVar);

    void q(Intent intent);

    View r(d.a.l0.a.h0.g.d dVar);

    void release();

    void s(V8ExceptionInfo v8ExceptionInfo);

    ExtensionCore t();

    d.a.l0.a.p0.d.b u();

    int v(String str, long j);

    void w(String str, boolean z);
}
