package d.a.i0.a.e2.c;

import com.baidu.swan.apps.setting.oauth.OAuthException;
import com.baidu.swan.apps.setting.oauth.TaskState;
/* loaded from: classes3.dex */
public class i<ResultDataT> {

    /* renamed from: a  reason: collision with root package name */
    public ResultDataT f41562a;

    /* renamed from: b  reason: collision with root package name */
    public TaskState f41563b = TaskState.INIT;

    /* renamed from: c  reason: collision with root package name */
    public OAuthException f41564c;

    public OAuthException a() {
        return this.f41564c;
    }

    public int b() {
        OAuthException oAuthException = this.f41564c;
        if (oAuthException == null) {
            return 0;
        }
        return oAuthException.mErrorCode;
    }

    public boolean c() {
        return TaskState.FINISHED == this.f41563b && this.f41564c == null;
    }

    public void d(OAuthException oAuthException) {
        this.f41564c = oAuthException;
    }

    public void e() {
        this.f41563b = TaskState.FINISHED;
        this.f41564c = null;
    }
}
