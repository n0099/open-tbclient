package d.b.g0.a.v1.c;

import com.baidu.swan.apps.setting.oauth.OAuthException;
import com.baidu.swan.apps.setting.oauth.TaskState;
/* loaded from: classes2.dex */
public class h<ResultDataT> {

    /* renamed from: a  reason: collision with root package name */
    public ResultDataT f46808a;

    /* renamed from: b  reason: collision with root package name */
    public TaskState f46809b = TaskState.INIT;

    /* renamed from: c  reason: collision with root package name */
    public OAuthException f46810c;

    public OAuthException a() {
        return this.f46810c;
    }

    public int b() {
        OAuthException oAuthException = this.f46810c;
        if (oAuthException == null) {
            return 0;
        }
        return oAuthException.mErrorCode;
    }

    public boolean c() {
        return TaskState.FINISHED == this.f46809b && this.f46810c == null;
    }

    public void d(OAuthException oAuthException) {
        this.f46810c = oAuthException;
    }

    public void e() {
        this.f46809b = TaskState.FINISHED;
        this.f46810c = null;
    }
}
