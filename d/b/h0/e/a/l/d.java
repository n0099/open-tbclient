package d.b.h0.e.a.l;

import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.swan.apps.adlanding.download.model.SwanAdDownloadState;
import com.baidu.swan.apps.scheme.actions.SwanAppDownloadAction;
/* loaded from: classes3.dex */
public class d extends d.b.h0.a.n1.a.b.c.c {

    /* renamed from: c  reason: collision with root package name */
    public d.b.h0.a.q.g.a.a f48302c;

    /* renamed from: d  reason: collision with root package name */
    public SwanAppDownloadAction.SwanAppDownloadType f48303d;

    public d(d.b.h0.a.q.g.a.a aVar, @NonNull SwanAppDownloadAction.SwanAppDownloadType swanAppDownloadType) {
        this.f48302c = aVar;
        this.f48303d = swanAppDownloadType;
    }

    @Override // d.b.h0.a.n1.a.b.c.a
    public long a() {
        return 0L;
    }

    @Override // d.b.h0.a.n1.a.b.c.a
    public boolean c() {
        return false;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.h0.a.n1.a.b.c.c, d.b.h0.a.n1.a.b.c.a
    public void onEvent(@NonNull d.b.h0.a.n1.a.b.a.b bVar) {
        Bundle a2 = bVar.a();
        if (a2 == null) {
            return;
        }
        int i = a2.getInt("state", SwanAdDownloadState.NOT_START.value());
        int i2 = a2.getInt("progress", 0);
        SwanAdDownloadState convert = SwanAdDownloadState.convert(i);
        this.f48302c.c(convert, i2);
        this.f48302c.a(convert, i2);
        String string = a2.getString("packageName", "");
        if (!TextUtils.isEmpty(string)) {
            this.f48302c.d(string);
        }
        if (this.f48303d == SwanAppDownloadAction.SwanAppDownloadType.TYPE_START_DOWNLOAD) {
            this.f48302c.f(true);
        }
    }
}
