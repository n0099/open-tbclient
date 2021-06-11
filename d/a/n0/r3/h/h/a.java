package d.a.n0.r3.h.h;

import android.util.SparseArray;
import com.baidu.tieba.video.cloudmusic.data.CloudMusicData;
/* loaded from: classes5.dex */
public class a {

    /* renamed from: b  reason: collision with root package name */
    public static a f63740b;

    /* renamed from: a  reason: collision with root package name */
    public SparseArray<CloudMusicData.MusicTagList.MusicList> f63741a = new SparseArray<>();

    public static synchronized a b() {
        a aVar;
        synchronized (a.class) {
            if (f63740b == null) {
                f63740b = new a();
            }
            aVar = f63740b;
        }
        return aVar;
    }

    public CloudMusicData.MusicTagList.MusicList a() {
        return this.f63741a.get(4096);
    }

    public void c() {
        this.f63741a = null;
        f63740b = null;
    }

    public void d(CloudMusicData.MusicTagList.MusicList musicList) {
        this.f63741a.put(4096, musicList);
    }
}
