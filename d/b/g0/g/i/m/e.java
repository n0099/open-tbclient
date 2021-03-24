package d.b.g0.g.i.m;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.smallgame.sdk.permission.PermissionListener;
import com.baidu.smallgame.sdk.permission.PermissionProxy;
import com.baidu.webkit.sdk.PermissionRequest;
import d.b.g0.a.k;
import d.b.g0.a.v1.c.h;
import d.b.g0.a.v1.c.i.b;
/* loaded from: classes3.dex */
public class e implements PermissionProxy {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f48203a = k.f45050a;

    /* loaded from: classes3.dex */
    public class a implements d.b.g0.a.i2.u0.b<h<b.e>> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f48204e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f48205f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ PermissionListener f48206g;

        public a(String str, String str2, PermissionListener permissionListener) {
            this.f48204e = str;
            this.f48205f = str2;
            this.f48206g = permissionListener;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.g0.a.i2.u0.b
        /* renamed from: a */
        public void onCallback(h<b.e> hVar) {
            if (d.b.g0.a.v1.c.c.h(hVar)) {
                e.this.b(this.f48204e, this.f48205f, this.f48206g);
            } else {
                this.f48206g.onPermissionResult(this.f48204e, 2);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements d.b.g0.a.k1.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PermissionListener f48208a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f48209b;

        public b(e eVar, PermissionListener permissionListener, String str) {
            this.f48208a = permissionListener;
            this.f48209b = str;
        }

        @Override // d.b.g0.a.k1.b
        public void a(String str) {
            this.f48208a.onPermissionResult(this.f48209b, 0);
        }

        @Override // d.b.g0.a.k1.b
        public void b(int i, String str) {
            this.f48208a.onPermissionResult(this.f48209b, 1);
        }
    }

    public final void b(@NonNull String str, @NonNull String str2, @NonNull PermissionListener permissionListener) {
        b bVar = new b(this, permissionListener, str);
        d.b.g0.a.k1.a.a(str2, new String[]{str2}, 2, d.b.g0.a.r1.d.e().n(), bVar);
    }

    public final String c(String str) {
        if (str == null) {
            return null;
        }
        char c2 = 65535;
        int hashCode = str.hashCode();
        if (hashCode != -1785599184) {
            if (hashCode == -1352756132 && str.equals(PermissionProxy.SCOPE_ID_RECORD)) {
                c2 = 1;
            }
        } else if (str.equals(PermissionProxy.SCOPE_ID_CAMERA)) {
            c2 = 0;
        }
        if (c2 != 0) {
            if (c2 != 1) {
                return null;
            }
            return PermissionRequest.RESOURCE_AUDIO_CAPTURE;
        }
        return PermissionRequest.RESOURCE_VIDEO_CAPTURE;
    }

    @Override // com.baidu.smallgame.sdk.permission.PermissionProxy
    public void requestPermission(String str, PermissionListener permissionListener) {
        if (f48203a) {
            Log.d("V8PermissionDelegate", "requestPermission : " + str);
        }
        if (permissionListener == null) {
            if (f48203a) {
                Log.e("V8PermissionDelegate", "PermissionListener can not be null.");
                return;
            }
            return;
        }
        String c2 = c(str);
        d.b.g0.a.r1.e y = d.b.g0.a.r1.e.y();
        if (!TextUtils.isEmpty(c2) && y != null && y.n() != null) {
            y.R().g(y.n(), str, new a(str, c2, permissionListener));
        } else {
            permissionListener.onPermissionResult(str, 2);
        }
    }
}
