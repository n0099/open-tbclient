package d.a.i0.a.o.h;

import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.swan.game.ad.downloader.model.DownloadParams;
import com.baidu.swan.game.ad.downloader.model.DownloadState;
import d.a.i0.a.v1.a.b.c.c;
/* loaded from: classes2.dex */
public class b extends c {

    /* renamed from: c  reason: collision with root package name */
    public d.a.i0.f.i.k.f.a f43724c;

    /* renamed from: d  reason: collision with root package name */
    public DownloadParams.SwanAppDownloadType f43725d;

    public b(d.a.i0.f.i.k.f.a aVar, @NonNull DownloadParams.SwanAppDownloadType swanAppDownloadType) {
        this.f43724c = aVar;
        this.f43725d = swanAppDownloadType;
    }

    @Override // d.a.i0.a.v1.a.b.c.a
    public long a() {
        return 0L;
    }

    @Override // d.a.i0.a.v1.a.b.c.a
    public boolean c() {
        return false;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.i0.a.v1.a.b.c.c, d.a.i0.a.v1.a.b.c.a
    public void onEvent(@NonNull d.a.i0.a.v1.a.b.a.b bVar) {
        Bundle a2 = bVar.a();
        if (a2 == null || this.f43724c == null) {
            return;
        }
        int i2 = a2.getInt("state", DownloadState.NOT_START.value());
        int i3 = a2.getInt("progress", 0);
        this.f43724c.c(DownloadState.convert(i2), i3);
        this.f43724c.a(i3);
        String string = a2.getString("packageName", "");
        if (!TextUtils.isEmpty(string)) {
            this.f43724c.d(string);
        }
        if (this.f43725d == DownloadParams.SwanAppDownloadType.TYPE_START_DOWNLOAD) {
            this.f43724c.f(true);
        }
    }
}
