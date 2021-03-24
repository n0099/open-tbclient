package d.b.g0.a.v1.c;

import com.baidu.swan.apps.setting.oauth.OAuthException;
import com.baidu.swan.apps.setting.oauth.TaskState;
/* loaded from: classes3.dex */
public class h<ResultDataT> {

    /* renamed from: a  reason: collision with root package name */
    public ResultDataT f46807a;

    /* renamed from: b  reason: collision with root package name */
    public TaskState f46808b = TaskState.INIT;

    /* renamed from: c  reason: collision with root package name */
    public OAuthException f46809c;

    public OAuthException a() {
        return this.f46809c;
    }

    public int b() {
        OAuthException oAuthException = this.f46809c;
        if (oAuthException == null) {
            return 0;
        }
        return oAuthException.mErrorCode;
    }

    public boolean c() {
        return TaskState.FINISHED == this.f46808b && this.f46809c == null;
    }

    public void d(OAuthException oAuthException) {
        this.f46809c = oAuthException;
    }

    public void e() {
        this.f46808b = TaskState.FINISHED;
        this.f46809c = null;
    }
}
