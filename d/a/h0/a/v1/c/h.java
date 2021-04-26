package d.a.h0.a.v1.c;

import com.baidu.swan.apps.setting.oauth.OAuthException;
import com.baidu.swan.apps.setting.oauth.TaskState;
/* loaded from: classes3.dex */
public class h<ResultDataT> {

    /* renamed from: a  reason: collision with root package name */
    public ResultDataT f44952a;

    /* renamed from: b  reason: collision with root package name */
    public TaskState f44953b = TaskState.INIT;

    /* renamed from: c  reason: collision with root package name */
    public OAuthException f44954c;

    public OAuthException a() {
        return this.f44954c;
    }

    public int b() {
        OAuthException oAuthException = this.f44954c;
        if (oAuthException == null) {
            return 0;
        }
        return oAuthException.mErrorCode;
    }

    public boolean c() {
        return TaskState.FINISHED == this.f44953b && this.f44954c == null;
    }

    public void d(OAuthException oAuthException) {
        this.f44954c = oAuthException;
    }

    public void e() {
        this.f44953b = TaskState.FINISHED;
        this.f44954c = null;
    }
}
