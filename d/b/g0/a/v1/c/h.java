package d.b.g0.a.v1.c;

import com.baidu.swan.apps.setting.oauth.OAuthException;
import com.baidu.swan.apps.setting.oauth.TaskState;
/* loaded from: classes3.dex */
public class h<ResultDataT> {

    /* renamed from: a  reason: collision with root package name */
    public ResultDataT f47200a;

    /* renamed from: b  reason: collision with root package name */
    public TaskState f47201b = TaskState.INIT;

    /* renamed from: c  reason: collision with root package name */
    public OAuthException f47202c;

    public OAuthException a() {
        return this.f47202c;
    }

    public int b() {
        OAuthException oAuthException = this.f47202c;
        if (oAuthException == null) {
            return 0;
        }
        return oAuthException.mErrorCode;
    }

    public boolean c() {
        return TaskState.FINISHED == this.f47201b && this.f47202c == null;
    }

    public void d(OAuthException oAuthException) {
        this.f47202c = oAuthException;
    }

    public void e() {
        this.f47201b = TaskState.FINISHED;
        this.f47202c = null;
    }
}
