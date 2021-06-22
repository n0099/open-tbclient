package d.a.o0.r3.h.h;

import android.util.SparseArray;
import com.baidu.tieba.video.cloudmusic.data.CloudMusicData;
/* loaded from: classes5.dex */
public class a {

    /* renamed from: b  reason: collision with root package name */
    public static a f63865b;

    /* renamed from: a  reason: collision with root package name */
    public SparseArray<CloudMusicData.MusicTagList.MusicList> f63866a = new SparseArray<>();

    public static synchronized a b() {
        a aVar;
        synchronized (a.class) {
            if (f63865b == null) {
                f63865b = new a();
            }
            aVar = f63865b;
        }
        return aVar;
    }

    public CloudMusicData.MusicTagList.MusicList a() {
        return this.f63866a.get(4096);
    }

    public void c() {
        this.f63866a = null;
        f63865b = null;
    }

    public void d(CloudMusicData.MusicTagList.MusicList musicList) {
        this.f63866a.put(4096, musicList);
    }
}
