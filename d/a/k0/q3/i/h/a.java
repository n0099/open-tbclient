package d.a.k0.q3.i.h;

import android.util.SparseArray;
import com.baidu.tieba.video.cloudmusic.data.CloudMusicData;
/* loaded from: classes5.dex */
public class a {

    /* renamed from: b  reason: collision with root package name */
    public static a f59910b;

    /* renamed from: a  reason: collision with root package name */
    public SparseArray<CloudMusicData.MusicTagList.MusicList> f59911a = new SparseArray<>();

    public static synchronized a b() {
        a aVar;
        synchronized (a.class) {
            if (f59910b == null) {
                f59910b = new a();
            }
            aVar = f59910b;
        }
        return aVar;
    }

    public CloudMusicData.MusicTagList.MusicList a() {
        return this.f59911a.get(4096);
    }

    public void c() {
        this.f59911a = null;
        f59910b = null;
    }

    public void d(CloudMusicData.MusicTagList.MusicList musicList) {
        this.f59911a.put(4096, musicList);
    }
}
