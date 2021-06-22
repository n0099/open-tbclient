package d.a.m0.a.l0.m;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.smallgame.sdk.permission.PermissionListener;
import com.baidu.smallgame.sdk.permission.PermissionProxy;
import com.baidu.webkit.sdk.PermissionRequest;
import d.a.m0.a.e2.c.i;
import d.a.m0.a.e2.c.j.b;
import d.a.m0.a.k;
import d.a.m0.a.s1.f;
/* loaded from: classes3.dex */
public class e implements PermissionProxy {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f47120a = k.f46983a;

    /* loaded from: classes3.dex */
    public class a implements d.a.m0.a.v2.e1.b<i<b.e>> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f47121e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f47122f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ PermissionListener f47123g;

        public a(String str, String str2, PermissionListener permissionListener) {
            this.f47121e = str;
            this.f47122f = str2;
            this.f47123g = permissionListener;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.m0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(i<b.e> iVar) {
            if (d.a.m0.a.e2.c.d.h(iVar)) {
                e.this.b(this.f47121e, this.f47122f, this.f47123g);
            } else {
                this.f47123g.onPermissionResult(this.f47121e, 2);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements f {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PermissionListener f47125a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f47126b;

        public b(e eVar, PermissionListener permissionListener, String str) {
            this.f47125a = permissionListener;
            this.f47126b = str;
        }

        @Override // d.a.m0.a.s1.f
        public void a(String str) {
            this.f47125a.onPermissionResult(this.f47126b, 0);
        }

        @Override // d.a.m0.a.s1.f
        public void b(int i2, String str) {
            this.f47125a.onPermissionResult(this.f47126b, 1);
        }
    }

    public final void b(@NonNull String str, @NonNull String str2, @NonNull PermissionListener permissionListener) {
        b bVar = new b(this, permissionListener, str);
        d.a.m0.a.s1.e.e(str2, new String[]{str2}, 2, d.a.m0.a.a2.d.g().x(), bVar);
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
        if (f47120a) {
            Log.d("V8PermissionDelegate", "requestPermission : " + str);
        }
        if (permissionListener == null) {
            if (f47120a) {
                Log.e("V8PermissionDelegate", "PermissionListener can not be null.");
                return;
            }
            return;
        }
        String c2 = c(str);
        d.a.m0.a.a2.e i2 = d.a.m0.a.a2.e.i();
        if (!TextUtils.isEmpty(c2) && i2 != null && i2.x() != null) {
            i2.T().g(i2.x(), str, new a(str, c2, permissionListener));
        } else {
            permissionListener.onPermissionResult(str, 2);
        }
    }
}
