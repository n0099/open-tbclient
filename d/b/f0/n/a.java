package d.b.f0.n;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.text.TextUtils;
import com.baidu.sso.m.d;
import d.b.f0.m.c;
/* loaded from: classes3.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    public Context f43036a;

    /* renamed from: b  reason: collision with root package name */
    public d f43037b;

    /* renamed from: c  reason: collision with root package name */
    public ServiceConnection f43038c;

    /* renamed from: d  reason: collision with root package name */
    public String f43039d;

    /* renamed from: d.b.f0.n.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class ServiceConnectionC0586a implements ServiceConnection {
        public ServiceConnectionC0586a() {
        }

        @Override // android.content.ServiceConnection
        public final synchronized void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            a.this.f43037b = d.a.a(iBinder);
        }

        @Override // android.content.ServiceConnection
        public final void onServiceDisconnected(ComponentName componentName) {
            a.this.f43037b = null;
        }
    }

    public a(Context context, c cVar) {
        this.f43036a = null;
        this.f43036a = context;
    }

    public final String a() {
        try {
        } catch (Throwable th) {
            th.printStackTrace();
        }
        if (TextUtils.isEmpty(this.f43039d)) {
            if (this.f43037b != null) {
                this.f43039d = this.f43037b.a();
            }
            return this.f43039d;
        }
        return this.f43039d;
    }
}
