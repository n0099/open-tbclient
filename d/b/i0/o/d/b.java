package d.b.i0.o.d;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.tieba.ad.download.AdDownloadData;
import com.baidu.tieba.ad.download.DownloadCacheKey;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public Map<DownloadCacheKey, AdDownloadData> f58630a;

    /* renamed from: d.b.i0.o.d.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static final class C1411b {

        /* renamed from: a  reason: collision with root package name */
        public static final b f58631a = new b();
    }

    public static b c() {
        return C1411b.f58631a;
    }

    public AdDownloadData a(@NonNull DownloadCacheKey downloadCacheKey) {
        return this.f58630a.get(downloadCacheKey);
    }

    public Map<DownloadCacheKey, AdDownloadData> b(String str) {
        HashMap hashMap = new HashMap(this.f58630a.size());
        if (TextUtils.isEmpty(str)) {
            return hashMap;
        }
        for (Map.Entry<DownloadCacheKey, AdDownloadData> entry : this.f58630a.entrySet()) {
            if (entry.getKey() != null && entry.getKey().samePackage(str)) {
                hashMap.put(entry.getKey(), entry.getValue());
            }
        }
        return hashMap;
    }

    public void d(@NonNull DownloadCacheKey downloadCacheKey, @NonNull AdDownloadData adDownloadData) {
        if (this.f58630a.get(downloadCacheKey) == null) {
            this.f58630a.put(downloadCacheKey, adDownloadData);
        }
    }

    public b() {
        this.f58630a = new HashMap();
    }
}
