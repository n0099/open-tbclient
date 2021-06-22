package d.a.m0.a.e2.c;

import com.baidu.swan.apps.setting.oauth.OAuthException;
import com.baidu.swan.apps.setting.oauth.TaskState;
/* loaded from: classes3.dex */
public class i<ResultDataT> {

    /* renamed from: a  reason: collision with root package name */
    public ResultDataT f45520a;

    /* renamed from: b  reason: collision with root package name */
    public TaskState f45521b = TaskState.INIT;

    /* renamed from: c  reason: collision with root package name */
    public OAuthException f45522c;

    public OAuthException a() {
        return this.f45522c;
    }

    public int b() {
        OAuthException oAuthException = this.f45522c;
        if (oAuthException == null) {
            return 0;
        }
        return oAuthException.mErrorCode;
    }

    public boolean c() {
        return TaskState.FINISHED == this.f45521b && this.f45522c == null;
    }

    public void d(OAuthException oAuthException) {
        this.f45522c = oAuthException;
    }

    public void e() {
        this.f45521b = TaskState.FINISHED;
        this.f45522c = null;
    }
}
