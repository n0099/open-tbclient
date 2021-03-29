package d.b.i0.p3.i.h;

import android.util.SparseArray;
import com.baidu.tieba.video.cloudmusic.data.CloudMusicData;
/* loaded from: classes5.dex */
public class a {

    /* renamed from: b  reason: collision with root package name */
    public static a f58945b;

    /* renamed from: a  reason: collision with root package name */
    public SparseArray<CloudMusicData.MusicTagList.MusicList> f58946a = new SparseArray<>();

    public static synchronized a b() {
        a aVar;
        synchronized (a.class) {
            if (f58945b == null) {
                f58945b = new a();
            }
            aVar = f58945b;
        }
        return aVar;
    }

    public CloudMusicData.MusicTagList.MusicList a() {
        return this.f58946a.get(4096);
    }

    public void c() {
        this.f58946a = null;
        f58945b = null;
    }

    public void d(CloudMusicData.MusicTagList.MusicList musicList) {
        this.f58946a.put(4096, musicList);
    }
}
