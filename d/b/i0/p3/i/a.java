package d.b.i0.p3.i;

import android.text.TextUtils;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.video.cloudmusic.MusicPlayer;
import com.baidu.tieba.video.cloudmusic.data.CloudMusicData;
import com.baidu.tieba.video.cloudmusic.model.CloudMusicListModel;
import d.b.i0.p3.j.f.a;
import java.io.File;
/* loaded from: classes5.dex */
public class a implements e {

    /* renamed from: a  reason: collision with root package name */
    public final CloudMusicListModel f58915a;

    /* renamed from: b  reason: collision with root package name */
    public final f f58916b;

    /* renamed from: c  reason: collision with root package name */
    public MusicPlayer f58917c;

    /* renamed from: d.b.i0.p3.i.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C1455a implements d.b.i0.p3.i.i.a<CloudMusicData.MusicTagList> {
        public C1455a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.i0.p3.i.i.a
        /* renamed from: b */
        public void a(CloudMusicData.MusicTagList musicTagList) {
            a.this.f58916b.G(false);
            if (!ListUtils.isEmpty(musicTagList.music_list) || musicTagList.page.pn != 1) {
                a.this.f58916b.displayNoDataView(false);
                a.this.f58916b.T(musicTagList);
            } else {
                a.this.f58916b.displayNoDataView(true);
            }
            if (musicTagList.page.has_more == 0) {
                a.this.f58916b.J();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements a.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ CloudMusicData.MusicTagList.MusicList f58919a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ int f58920b;

        /* renamed from: d.b.i0.p3.i.a$b$a  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public class C1456a implements MusicPlayer.b {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ String f58922a;

            public C1456a(String str) {
                this.f58922a = str;
            }

            @Override // com.baidu.tieba.video.cloudmusic.MusicPlayer.b
            public void a() {
                a.this.f58917c.f();
                if (this.f58922a.startsWith("/")) {
                    File file = new File(this.f58922a);
                    if (file.exists()) {
                        file.delete();
                    }
                    d.b.i0.p3.j.f.a.h().e();
                    b bVar = b.this;
                    a.this.c(bVar.f58919a, bVar.f58920b);
                }
            }
        }

        public b(CloudMusicData.MusicTagList.MusicList musicList, int i) {
            this.f58919a = musicList;
            this.f58920b = i;
        }

        @Override // d.b.i0.p3.j.f.a.b
        public void a(String str) {
            a.this.f58916b.h0(this.f58920b);
        }

        @Override // d.b.i0.p3.j.f.a.b
        public void b() {
            a.this.f58916b.m0(this.f58920b);
        }

        @Override // d.b.i0.p3.j.f.a.b
        public void c(String str, String str2) {
            if (!TextUtils.isEmpty(str2)) {
                str = str2;
            }
            a.this.f58917c.e(str, this.f58919a, new C1456a(str));
        }
    }

    /* loaded from: classes5.dex */
    public class c implements MusicPlayer.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f58924a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ CloudMusicData.MusicTagList.MusicList f58925b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ int f58926c;

        public c(String str, CloudMusicData.MusicTagList.MusicList musicList, int i) {
            this.f58924a = str;
            this.f58925b = musicList;
            this.f58926c = i;
        }

        @Override // com.baidu.tieba.video.cloudmusic.MusicPlayer.b
        public void a() {
            a.this.f58917c.f();
            if (this.f58924a.startsWith("/")) {
                File file = new File(this.f58924a);
                if (file.exists()) {
                    file.delete();
                }
                d.b.i0.p3.j.f.a.h().e();
                a.this.c(this.f58925b, this.f58926c);
            }
        }
    }

    public a(CloudMusicListModel cloudMusicListModel, f fVar) {
        this.f58915a = cloudMusicListModel;
        this.f58916b = fVar;
        fVar.x(this);
        this.f58917c = MusicPlayer.c();
    }

    @Override // d.b.i0.p3.i.e
    public void a() {
        this.f58915a.cancelLoadData();
    }

    @Override // d.b.i0.p3.i.e
    public void b() {
        this.f58915a.w();
    }

    @Override // d.b.i0.p3.i.e
    public void c(CloudMusicData.MusicTagList.MusicList musicList, int i) {
        if (musicList == null || TextUtils.isEmpty(musicList.resource)) {
            return;
        }
        String g2 = d.b.i0.p3.j.f.a.h().g(musicList.resource);
        if (TextUtils.isEmpty(g2)) {
            this.f58916b.R(i);
            d.b.i0.p3.j.f.a.h().f(String.valueOf(musicList.music_id), musicList.resource, new b(musicList, i));
            return;
        }
        this.f58917c.e(g2, musicList, new c(g2, musicList, i));
    }

    @Override // d.b.i0.p3.i.e
    public void d(CloudMusicData.MusicTagList musicTagList) {
        if (ListUtils.isEmpty(musicTagList.music_list)) {
            this.f58916b.displayNoDataView(true);
        } else {
            this.f58916b.displayNoDataView(false);
            this.f58916b.T(musicTagList);
        }
        if (musicTagList.page.has_more == 0) {
            this.f58916b.J();
        }
    }

    @Override // d.b.i0.p3.i.e
    public void e(int i) {
        this.f58916b.G(true);
        this.f58915a.u(i, new C1455a());
    }
}
