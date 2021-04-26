package d.a.j0.q3.i.h;

import android.util.SparseArray;
import com.baidu.tieba.video.cloudmusic.data.CloudMusicData;
/* loaded from: classes5.dex */
public class a {

    /* renamed from: b  reason: collision with root package name */
    public static a f59165b;

    /* renamed from: a  reason: collision with root package name */
    public SparseArray<CloudMusicData.MusicTagList.MusicList> f59166a = new SparseArray<>();

    public static synchronized a b() {
        a aVar;
        synchronized (a.class) {
            if (f59165b == null) {
                f59165b = new a();
            }
            aVar = f59165b;
        }
        return aVar;
    }

    public CloudMusicData.MusicTagList.MusicList a() {
        return this.f59166a.get(4096);
    }

    public void c() {
        this.f59166a = null;
        f59165b = null;
    }

    public void d(CloudMusicData.MusicTagList.MusicList musicList) {
        this.f59166a.put(4096, musicList);
    }
}
