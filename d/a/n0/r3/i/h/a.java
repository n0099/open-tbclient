package d.a.n0.r3.i.h;

import android.util.SparseArray;
import com.baidu.tieba.video.cloudmusic.data.CloudMusicData;
/* loaded from: classes5.dex */
public class a {

    /* renamed from: b  reason: collision with root package name */
    public static a f60051b;

    /* renamed from: a  reason: collision with root package name */
    public SparseArray<CloudMusicData.MusicTagList.MusicList> f60052a = new SparseArray<>();

    public static synchronized a b() {
        a aVar;
        synchronized (a.class) {
            if (f60051b == null) {
                f60051b = new a();
            }
            aVar = f60051b;
        }
        return aVar;
    }

    public CloudMusicData.MusicTagList.MusicList a() {
        return this.f60052a.get(4096);
    }

    public void c() {
        this.f60052a = null;
        f60051b = null;
    }

    public void d(CloudMusicData.MusicTagList.MusicList musicList) {
        this.f60052a.put(4096, musicList);
    }
}
