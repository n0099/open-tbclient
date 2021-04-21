package d.b.j0.q3.i;

import android.text.TextUtils;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.video.cloudmusic.MusicPlayer;
import com.baidu.tieba.video.cloudmusic.data.CloudMusicData;
import com.baidu.tieba.video.cloudmusic.model.CloudMusicListModel;
import d.b.j0.q3.j.f.a;
import java.io.File;
/* loaded from: classes5.dex */
public class a implements e {

    /* renamed from: a  reason: collision with root package name */
    public final CloudMusicListModel f61004a;

    /* renamed from: b  reason: collision with root package name */
    public final f f61005b;

    /* renamed from: c  reason: collision with root package name */
    public MusicPlayer f61006c;

    /* renamed from: d.b.j0.q3.i.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C1541a implements d.b.j0.q3.i.i.a<CloudMusicData.MusicTagList> {
        public C1541a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.j0.q3.i.i.a
        /* renamed from: b */
        public void a(CloudMusicData.MusicTagList musicTagList) {
            a.this.f61005b.G(false);
            if (!ListUtils.isEmpty(musicTagList.music_list) || musicTagList.page.pn != 1) {
                a.this.f61005b.displayNoDataView(false);
                a.this.f61005b.T(musicTagList);
            } else {
                a.this.f61005b.displayNoDataView(true);
            }
            if (musicTagList.page.has_more == 0) {
                a.this.f61005b.J();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements a.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ CloudMusicData.MusicTagList.MusicList f61008a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ int f61009b;

        /* renamed from: d.b.j0.q3.i.a$b$a  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public class C1542a implements MusicPlayer.b {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ String f61011a;

            public C1542a(String str) {
                this.f61011a = str;
            }

            @Override // com.baidu.tieba.video.cloudmusic.MusicPlayer.b
            public void a() {
                a.this.f61006c.f();
                if (this.f61011a.startsWith("/")) {
                    File file = new File(this.f61011a);
                    if (file.exists()) {
                        file.delete();
                    }
                    d.b.j0.q3.j.f.a.h().e();
                    b bVar = b.this;
                    a.this.b(bVar.f61008a, bVar.f61009b);
                }
            }
        }

        public b(CloudMusicData.MusicTagList.MusicList musicList, int i) {
            this.f61008a = musicList;
            this.f61009b = i;
        }

        @Override // d.b.j0.q3.j.f.a.b
        public void a(String str) {
            a.this.f61005b.h0(this.f61009b);
        }

        @Override // d.b.j0.q3.j.f.a.b
        public void b() {
            a.this.f61005b.m0(this.f61009b);
        }

        @Override // d.b.j0.q3.j.f.a.b
        public void c(String str, String str2) {
            if (!TextUtils.isEmpty(str2)) {
                str = str2;
            }
            a.this.f61006c.e(str, this.f61008a, new C1542a(str));
        }
    }

    /* loaded from: classes5.dex */
    public class c implements MusicPlayer.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f61013a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ CloudMusicData.MusicTagList.MusicList f61014b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ int f61015c;

        public c(String str, CloudMusicData.MusicTagList.MusicList musicList, int i) {
            this.f61013a = str;
            this.f61014b = musicList;
            this.f61015c = i;
        }

        @Override // com.baidu.tieba.video.cloudmusic.MusicPlayer.b
        public void a() {
            a.this.f61006c.f();
            if (this.f61013a.startsWith("/")) {
                File file = new File(this.f61013a);
                if (file.exists()) {
                    file.delete();
                }
                d.b.j0.q3.j.f.a.h().e();
                a.this.b(this.f61014b, this.f61015c);
            }
        }
    }

    public a(CloudMusicListModel cloudMusicListModel, f fVar) {
        this.f61004a = cloudMusicListModel;
        this.f61005b = fVar;
        fVar.x(this);
        this.f61006c = MusicPlayer.c();
    }

    @Override // d.b.j0.q3.i.e
    public void a() {
        this.f61004a.w();
    }

    @Override // d.b.j0.q3.i.e
    public void b(CloudMusicData.MusicTagList.MusicList musicList, int i) {
        if (musicList == null || TextUtils.isEmpty(musicList.resource)) {
            return;
        }
        String g2 = d.b.j0.q3.j.f.a.h().g(musicList.resource);
        if (TextUtils.isEmpty(g2)) {
            this.f61005b.R(i);
            d.b.j0.q3.j.f.a.h().f(String.valueOf(musicList.music_id), musicList.resource, new b(musicList, i));
            return;
        }
        this.f61006c.e(g2, musicList, new c(g2, musicList, i));
    }

    @Override // d.b.j0.q3.i.e
    public void c(CloudMusicData.MusicTagList musicTagList) {
        if (ListUtils.isEmpty(musicTagList.music_list)) {
            this.f61005b.displayNoDataView(true);
        } else {
            this.f61005b.displayNoDataView(false);
            this.f61005b.T(musicTagList);
        }
        if (musicTagList.page.has_more == 0) {
            this.f61005b.J();
        }
    }

    @Override // d.b.j0.q3.i.e
    public void cancelLoadData() {
        this.f61004a.cancelLoadData();
    }

    @Override // d.b.j0.q3.i.e
    public void d(int i) {
        this.f61005b.G(true);
        this.f61004a.u(i, new C1541a());
    }
}
