package d.b.h0.g.i.m;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.smallgame.sdk.permission.PermissionListener;
import com.baidu.smallgame.sdk.permission.PermissionProxy;
import com.baidu.webkit.sdk.PermissionRequest;
import d.b.h0.a.k;
import d.b.h0.a.v1.c.h;
import d.b.h0.a.v1.c.i.b;
/* loaded from: classes3.dex */
public class e implements PermissionProxy {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f48925a = k.f45772a;

    /* loaded from: classes3.dex */
    public class a implements d.b.h0.a.i2.u0.b<h<b.e>> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f48926e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f48927f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ PermissionListener f48928g;

        public a(String str, String str2, PermissionListener permissionListener) {
            this.f48926e = str;
            this.f48927f = str2;
            this.f48928g = permissionListener;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.h0.a.i2.u0.b
        /* renamed from: a */
        public void onCallback(h<b.e> hVar) {
            if (d.b.h0.a.v1.c.c.h(hVar)) {
                e.this.b(this.f48926e, this.f48927f, this.f48928g);
            } else {
                this.f48928g.onPermissionResult(this.f48926e, 2);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements d.b.h0.a.k1.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PermissionListener f48930a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f48931b;

        public b(e eVar, PermissionListener permissionListener, String str) {
            this.f48930a = permissionListener;
            this.f48931b = str;
        }

        @Override // d.b.h0.a.k1.b
        public void a(String str) {
            this.f48930a.onPermissionResult(this.f48931b, 0);
        }

        @Override // d.b.h0.a.k1.b
        public void b(int i, String str) {
            this.f48930a.onPermissionResult(this.f48931b, 1);
        }
    }

    public final void b(@NonNull String str, @NonNull String str2, @NonNull PermissionListener permissionListener) {
        b bVar = new b(this, permissionListener, str);
        d.b.h0.a.k1.a.a(str2, new String[]{str2}, 2, d.b.h0.a.r1.d.e().n(), bVar);
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
        if (f48925a) {
            Log.d("V8PermissionDelegate", "requestPermission : " + str);
        }
        if (permissionListener == null) {
            if (f48925a) {
                Log.e("V8PermissionDelegate", "PermissionListener can not be null.");
                return;
            }
            return;
        }
        String c2 = c(str);
        d.b.h0.a.r1.e y = d.b.h0.a.r1.e.y();
        if (!TextUtils.isEmpty(c2) && y != null && y.n() != null) {
            y.R().g(y.n(), str, new a(str, c2, permissionListener));
        } else {
            permissionListener.onPermissionResult(str, 2);
        }
    }
}
