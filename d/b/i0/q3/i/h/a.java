package d.b.i0.q3.i.h;

import android.util.SparseArray;
import com.baidu.tieba.video.cloudmusic.data.CloudMusicData;
/* loaded from: classes5.dex */
public class a {

    /* renamed from: b  reason: collision with root package name */
    public static a f60613b;

    /* renamed from: a  reason: collision with root package name */
    public SparseArray<CloudMusicData.MusicTagList.MusicList> f60614a = new SparseArray<>();

    public static synchronized a b() {
        a aVar;
        synchronized (a.class) {
            if (f60613b == null) {
                f60613b = new a();
            }
            aVar = f60613b;
        }
        return aVar;
    }

    public CloudMusicData.MusicTagList.MusicList a() {
        return this.f60614a.get(4096);
    }

    public void c() {
        this.f60614a = null;
        f60613b = null;
    }

    public void d(CloudMusicData.MusicTagList.MusicList musicList) {
        this.f60614a.put(4096, musicList);
    }
}
