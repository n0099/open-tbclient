package d.a.h0.e.a.l;

import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.swan.apps.adlanding.download.model.SwanAdDownloadState;
import com.baidu.swan.apps.scheme.actions.SwanAppDownloadAction;
/* loaded from: classes3.dex */
public class d extends d.a.h0.a.n1.a.b.c.c {

    /* renamed from: c  reason: collision with root package name */
    public d.a.h0.a.q.g.a.a f45755c;

    /* renamed from: d  reason: collision with root package name */
    public SwanAppDownloadAction.SwanAppDownloadType f45756d;

    public d(d.a.h0.a.q.g.a.a aVar, @NonNull SwanAppDownloadAction.SwanAppDownloadType swanAppDownloadType) {
        this.f45755c = aVar;
        this.f45756d = swanAppDownloadType;
    }

    @Override // d.a.h0.a.n1.a.b.c.a
    public long a() {
        return 0L;
    }

    @Override // d.a.h0.a.n1.a.b.c.a
    public boolean c() {
        return false;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.h0.a.n1.a.b.c.c, d.a.h0.a.n1.a.b.c.a
    public void onEvent(@NonNull d.a.h0.a.n1.a.b.a.b bVar) {
        Bundle a2 = bVar.a();
        if (a2 == null) {
            return;
        }
        int i2 = a2.getInt("state", SwanAdDownloadState.NOT_START.value());
        int i3 = a2.getInt("progress", 0);
        SwanAdDownloadState convert = SwanAdDownloadState.convert(i2);
        this.f45755c.c(convert, i3);
        this.f45755c.b(convert, i3);
        String string = a2.getString("packageName", "");
        if (!TextUtils.isEmpty(string)) {
            this.f45755c.d(string);
        }
        if (this.f45756d == SwanAppDownloadAction.SwanAppDownloadType.TYPE_START_DOWNLOAD) {
            this.f45755c.f(true);
        }
    }
}
