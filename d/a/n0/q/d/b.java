package d.a.n0.q.d;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.tieba.ad.download.AdDownloadData;
import com.baidu.tieba.ad.download.DownloadCacheKey;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public Map<DownloadCacheKey, AdDownloadData> f61890a;

    /* renamed from: d.a.n0.q.d.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static final class C1530b {

        /* renamed from: a  reason: collision with root package name */
        public static final b f61891a = new b();
    }

    public static b c() {
        return C1530b.f61891a;
    }

    public AdDownloadData a(@NonNull DownloadCacheKey downloadCacheKey) {
        return this.f61890a.get(downloadCacheKey);
    }

    public Map<DownloadCacheKey, AdDownloadData> b(String str) {
        HashMap hashMap = new HashMap(this.f61890a.size());
        if (TextUtils.isEmpty(str)) {
            return hashMap;
        }
        for (Map.Entry<DownloadCacheKey, AdDownloadData> entry : this.f61890a.entrySet()) {
            if (entry.getKey() != null && entry.getKey().samePackage(str)) {
                hashMap.put(entry.getKey(), entry.getValue());
            }
        }
        return hashMap;
    }

    public void d(@NonNull DownloadCacheKey downloadCacheKey, @NonNull AdDownloadData adDownloadData) {
        if (this.f61890a.get(downloadCacheKey) == null) {
            this.f61890a.put(downloadCacheKey, adDownloadData);
        }
    }

    public b() {
        this.f61890a = new HashMap();
    }
}
