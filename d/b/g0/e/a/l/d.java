package d.b.g0.e.a.l;

import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.swan.apps.adlanding.download.model.SwanAdDownloadState;
import com.baidu.swan.apps.scheme.actions.SwanAppDownloadAction;
import com.baidu.swan.gamecenter.appmanager.install.InstallAntiBlockingActivity;
/* loaded from: classes3.dex */
public class d extends d.b.g0.a.n1.a.b.c.c {

    /* renamed from: c  reason: collision with root package name */
    public d.b.g0.a.q.g.a.a f47581c;

    /* renamed from: d  reason: collision with root package name */
    public SwanAppDownloadAction.SwanAppDownloadType f47582d;

    public d(d.b.g0.a.q.g.a.a aVar, @NonNull SwanAppDownloadAction.SwanAppDownloadType swanAppDownloadType) {
        this.f47581c = aVar;
        this.f47582d = swanAppDownloadType;
    }

    @Override // d.b.g0.a.n1.a.b.c.a
    public long a() {
        return 0L;
    }

    @Override // d.b.g0.a.n1.a.b.c.a
    public boolean c() {
        return false;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.g0.a.n1.a.b.c.c, d.b.g0.a.n1.a.b.c.a
    public void onEvent(@NonNull d.b.g0.a.n1.a.b.a.b bVar) {
        Bundle a2 = bVar.a();
        if (a2 == null) {
            return;
        }
        int i = a2.getInt("state", SwanAdDownloadState.NOT_START.value());
        int i2 = a2.getInt("progress", 0);
        SwanAdDownloadState convert = SwanAdDownloadState.convert(i);
        this.f47581c.c(convert, i2);
        this.f47581c.a(convert, i2);
        String string = a2.getString(InstallAntiBlockingActivity.PARAM_PACKAGE_NAME, "");
        if (!TextUtils.isEmpty(string)) {
            this.f47581c.d(string);
        }
        if (this.f47582d == SwanAppDownloadAction.SwanAppDownloadType.TYPE_START_DOWNLOAD) {
            this.f47581c.f(true);
        }
    }
}
