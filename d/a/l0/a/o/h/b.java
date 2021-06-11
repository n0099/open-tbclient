package d.a.l0.a.o.h;

import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.swan.game.ad.downloader.model.DownloadParams;
import com.baidu.swan.game.ad.downloader.model.DownloadState;
import d.a.l0.a.v1.a.b.c.c;
/* loaded from: classes2.dex */
public class b extends c {

    /* renamed from: c  reason: collision with root package name */
    public d.a.l0.f.i.k.f.a f47574c;

    /* renamed from: d  reason: collision with root package name */
    public DownloadParams.SwanAppDownloadType f47575d;

    public b(d.a.l0.f.i.k.f.a aVar, @NonNull DownloadParams.SwanAppDownloadType swanAppDownloadType) {
        this.f47574c = aVar;
        this.f47575d = swanAppDownloadType;
    }

    @Override // d.a.l0.a.v1.a.b.c.a
    public long a() {
        return 0L;
    }

    @Override // d.a.l0.a.v1.a.b.c.a
    public boolean c() {
        return false;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.l0.a.v1.a.b.c.c, d.a.l0.a.v1.a.b.c.a
    public void onEvent(@NonNull d.a.l0.a.v1.a.b.a.b bVar) {
        Bundle a2 = bVar.a();
        if (a2 == null || this.f47574c == null) {
            return;
        }
        int i2 = a2.getInt("state", DownloadState.NOT_START.value());
        int i3 = a2.getInt("progress", 0);
        this.f47574c.c(DownloadState.convert(i2), i3);
        this.f47574c.a(i3);
        String string = a2.getString("packageName", "");
        if (!TextUtils.isEmpty(string)) {
            this.f47574c.d(string);
        }
        if (this.f47575d == DownloadParams.SwanAppDownloadType.TYPE_START_DOWNLOAD) {
            this.f47574c.f(true);
        }
    }
}
