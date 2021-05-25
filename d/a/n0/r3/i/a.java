package d.a.n0.r3.i;

import android.text.TextUtils;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.video.cloudmusic.MusicPlayer;
import com.baidu.tieba.video.cloudmusic.data.CloudMusicData;
import com.baidu.tieba.video.cloudmusic.model.CloudMusicListModel;
import d.a.n0.r3.j.f.a;
import java.io.File;
/* loaded from: classes5.dex */
public class a implements e {

    /* renamed from: a  reason: collision with root package name */
    public final CloudMusicListModel f60021a;

    /* renamed from: b  reason: collision with root package name */
    public final f f60022b;

    /* renamed from: c  reason: collision with root package name */
    public MusicPlayer f60023c;

    /* renamed from: d.a.n0.r3.i.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C1567a implements d.a.n0.r3.i.i.a<CloudMusicData.MusicTagList> {
        public C1567a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.n0.r3.i.i.a
        /* renamed from: b */
        public void a(CloudMusicData.MusicTagList musicTagList) {
            a.this.f60022b.v(false);
            if (!ListUtils.isEmpty(musicTagList.music_list) || musicTagList.page.pn != 1) {
                a.this.f60022b.displayNoDataView(false);
                a.this.f60022b.B(musicTagList);
            } else {
                a.this.f60022b.displayNoDataView(true);
            }
            if (musicTagList.page.has_more == 0) {
                a.this.f60022b.x();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements a.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ CloudMusicData.MusicTagList.MusicList f60025a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ int f60026b;

        /* renamed from: d.a.n0.r3.i.a$b$a  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public class C1568a implements MusicPlayer.b {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ String f60028a;

            public C1568a(String str) {
                this.f60028a = str;
            }

            @Override // com.baidu.tieba.video.cloudmusic.MusicPlayer.b
            public void a() {
                a.this.f60023c.f();
                if (this.f60028a.startsWith("/")) {
                    File file = new File(this.f60028a);
                    if (file.exists()) {
                        file.delete();
                    }
                    d.a.n0.r3.j.f.a.h().e();
                    b bVar = b.this;
                    a.this.c(bVar.f60025a, bVar.f60026b);
                }
            }
        }

        public b(CloudMusicData.MusicTagList.MusicList musicList, int i2) {
            this.f60025a = musicList;
            this.f60026b = i2;
        }

        @Override // d.a.n0.r3.j.f.a.b
        public void a(String str) {
            a.this.f60022b.I(this.f60026b);
        }

        @Override // d.a.n0.r3.j.f.a.b
        public void b() {
            a.this.f60022b.K(this.f60026b);
        }

        @Override // d.a.n0.r3.j.f.a.b
        public void c(String str, String str2) {
            if (!TextUtils.isEmpty(str2)) {
                str = str2;
            }
            a.this.f60023c.e(str, this.f60025a, new C1568a(str));
        }
    }

    /* loaded from: classes5.dex */
    public class c implements MusicPlayer.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f60030a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ CloudMusicData.MusicTagList.MusicList f60031b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ int f60032c;

        public c(String str, CloudMusicData.MusicTagList.MusicList musicList, int i2) {
            this.f60030a = str;
            this.f60031b = musicList;
            this.f60032c = i2;
        }

        @Override // com.baidu.tieba.video.cloudmusic.MusicPlayer.b
        public void a() {
            a.this.f60023c.f();
            if (this.f60030a.startsWith("/")) {
                File file = new File(this.f60030a);
                if (file.exists()) {
                    file.delete();
                }
                d.a.n0.r3.j.f.a.h().e();
                a.this.c(this.f60031b, this.f60032c);
            }
        }
    }

    public a(CloudMusicListModel cloudMusicListModel, f fVar) {
        this.f60021a = cloudMusicListModel;
        this.f60022b = fVar;
        fVar.Z(this);
        this.f60023c = MusicPlayer.c();
    }

    @Override // d.a.n0.r3.i.e
    public void a(CloudMusicData.MusicTagList musicTagList) {
        if (ListUtils.isEmpty(musicTagList.music_list)) {
            this.f60022b.displayNoDataView(true);
        } else {
            this.f60022b.displayNoDataView(false);
            this.f60022b.B(musicTagList);
        }
        if (musicTagList.page.has_more == 0) {
            this.f60022b.x();
        }
    }

    @Override // d.a.n0.r3.i.e
    public void b() {
        this.f60021a.w();
    }

    @Override // d.a.n0.r3.i.e
    public void c(CloudMusicData.MusicTagList.MusicList musicList, int i2) {
        if (musicList == null || TextUtils.isEmpty(musicList.resource)) {
            return;
        }
        String g2 = d.a.n0.r3.j.f.a.h().g(musicList.resource);
        if (TextUtils.isEmpty(g2)) {
            this.f60022b.f0(i2);
            d.a.n0.r3.j.f.a.h().f(String.valueOf(musicList.music_id), musicList.resource, new b(musicList, i2));
            return;
        }
        this.f60023c.e(g2, musicList, new c(g2, musicList, i2));
    }

    @Override // d.a.n0.r3.i.e
    public void cancelLoadData() {
        this.f60021a.cancelLoadData();
    }

    @Override // d.a.n0.r3.i.e
    public void d(int i2) {
        this.f60022b.v(true);
        this.f60021a.u(i2, new C1567a());
    }
}
