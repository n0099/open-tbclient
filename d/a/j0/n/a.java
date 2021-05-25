package d.a.j0.n;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.text.TextUtils;
import com.baidu.sso.m.d;
import d.a.j0.m.c;
/* loaded from: classes2.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    public Context f40489a;

    /* renamed from: b  reason: collision with root package name */
    public d f40490b;

    /* renamed from: c  reason: collision with root package name */
    public ServiceConnection f40491c;

    /* renamed from: d  reason: collision with root package name */
    public String f40492d;

    /* renamed from: d.a.j0.n.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class ServiceConnectionC0557a implements ServiceConnection {
        public ServiceConnectionC0557a() {
        }

        @Override // android.content.ServiceConnection
        public final synchronized void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            a.this.f40490b = d.a.a(iBinder);
        }

        @Override // android.content.ServiceConnection
        public final void onServiceDisconnected(ComponentName componentName) {
            a.this.f40490b = null;
        }
    }

    public a(Context context, c cVar) {
        this.f40489a = null;
        this.f40489a = context;
    }

    public final String a() {
        try {
        } catch (Throwable th) {
            th.printStackTrace();
        }
        if (TextUtils.isEmpty(this.f40492d)) {
            if (this.f40490b != null) {
                this.f40492d = this.f40490b.a();
            }
            return this.f40492d;
        }
        return this.f40492d;
    }
}
