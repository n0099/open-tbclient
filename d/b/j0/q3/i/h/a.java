package d.b.j0.q3.i.h;

import android.util.SparseArray;
import com.baidu.tieba.video.cloudmusic.data.CloudMusicData;
/* loaded from: classes5.dex */
public class a {

    /* renamed from: b  reason: collision with root package name */
    public static a f61034b;

    /* renamed from: a  reason: collision with root package name */
    public SparseArray<CloudMusicData.MusicTagList.MusicList> f61035a = new SparseArray<>();

    public static synchronized a b() {
        a aVar;
        synchronized (a.class) {
            if (f61034b == null) {
                f61034b = new a();
            }
            aVar = f61034b;
        }
        return aVar;
    }

    public CloudMusicData.MusicTagList.MusicList a() {
        return this.f61035a.get(4096);
    }

    public void c() {
        this.f61035a = null;
        f61034b = null;
    }

    public void d(CloudMusicData.MusicTagList.MusicList musicList) {
        this.f61035a.put(4096, musicList);
    }
}
