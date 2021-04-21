package d.b.h0.a.v1.c;

import com.baidu.swan.apps.setting.oauth.OAuthException;
import com.baidu.swan.apps.setting.oauth.TaskState;
/* loaded from: classes3.dex */
public class h<ResultDataT> {

    /* renamed from: a  reason: collision with root package name */
    public ResultDataT f47529a;

    /* renamed from: b  reason: collision with root package name */
    public TaskState f47530b = TaskState.INIT;

    /* renamed from: c  reason: collision with root package name */
    public OAuthException f47531c;

    public OAuthException a() {
        return this.f47531c;
    }

    public int b() {
        OAuthException oAuthException = this.f47531c;
        if (oAuthException == null) {
            return 0;
        }
        return oAuthException.mErrorCode;
    }

    public boolean c() {
        return TaskState.FINISHED == this.f47530b && this.f47531c == null;
    }

    public void d(OAuthException oAuthException) {
        this.f47531c = oAuthException;
    }

    public void e() {
        this.f47530b = TaskState.FINISHED;
        this.f47531c = null;
    }
}
