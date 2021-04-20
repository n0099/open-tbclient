package d.b.i0.q3.i;

import android.text.TextUtils;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.video.cloudmusic.MusicPlayer;
import com.baidu.tieba.video.cloudmusic.data.CloudMusicData;
import com.baidu.tieba.video.cloudmusic.model.CloudMusicListModel;
import d.b.i0.q3.j.f.a;
import java.io.File;
/* loaded from: classes5.dex */
public class a implements e {

    /* renamed from: a  reason: collision with root package name */
    public final CloudMusicListModel f60583a;

    /* renamed from: b  reason: collision with root package name */
    public final f f60584b;

    /* renamed from: c  reason: collision with root package name */
    public MusicPlayer f60585c;

    /* renamed from: d.b.i0.q3.i.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C1518a implements d.b.i0.q3.i.i.a<CloudMusicData.MusicTagList> {
        public C1518a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.i0.q3.i.i.a
        /* renamed from: b */
        public void a(CloudMusicData.MusicTagList musicTagList) {
            a.this.f60584b.G(false);
            if (!ListUtils.isEmpty(musicTagList.music_list) || musicTagList.page.pn != 1) {
                a.this.f60584b.displayNoDataView(false);
                a.this.f60584b.T(musicTagList);
            } else {
                a.this.f60584b.displayNoDataView(true);
            }
            if (musicTagList.page.has_more == 0) {
                a.this.f60584b.J();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements a.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ CloudMusicData.MusicTagList.MusicList f60587a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ int f60588b;

        /* renamed from: d.b.i0.q3.i.a$b$a  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public class C1519a implements MusicPlayer.b {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ String f60590a;

            public C1519a(String str) {
                this.f60590a = str;
            }

            @Override // com.baidu.tieba.video.cloudmusic.MusicPlayer.b
            public void a() {
                a.this.f60585c.f();
                if (this.f60590a.startsWith("/")) {
                    File file = new File(this.f60590a);
                    if (file.exists()) {
                        file.delete();
                    }
                    d.b.i0.q3.j.f.a.h().e();
                    b bVar = b.this;
                    a.this.b(bVar.f60587a, bVar.f60588b);
                }
            }
        }

        public b(CloudMusicData.MusicTagList.MusicList musicList, int i) {
            this.f60587a = musicList;
            this.f60588b = i;
        }

        @Override // d.b.i0.q3.j.f.a.b
        public void a(String str) {
            a.this.f60584b.h0(this.f60588b);
        }

        @Override // d.b.i0.q3.j.f.a.b
        public void b() {
            a.this.f60584b.m0(this.f60588b);
        }

        @Override // d.b.i0.q3.j.f.a.b
        public void c(String str, String str2) {
            if (!TextUtils.isEmpty(str2)) {
                str = str2;
            }
            a.this.f60585c.e(str, this.f60587a, new C1519a(str));
        }
    }

    /* loaded from: classes5.dex */
    public class c implements MusicPlayer.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f60592a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ CloudMusicData.MusicTagList.MusicList f60593b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ int f60594c;

        public c(String str, CloudMusicData.MusicTagList.MusicList musicList, int i) {
            this.f60592a = str;
            this.f60593b = musicList;
            this.f60594c = i;
        }

        @Override // com.baidu.tieba.video.cloudmusic.MusicPlayer.b
        public void a() {
            a.this.f60585c.f();
            if (this.f60592a.startsWith("/")) {
                File file = new File(this.f60592a);
                if (file.exists()) {
                    file.delete();
                }
                d.b.i0.q3.j.f.a.h().e();
                a.this.b(this.f60593b, this.f60594c);
            }
        }
    }

    public a(CloudMusicListModel cloudMusicListModel, f fVar) {
        this.f60583a = cloudMusicListModel;
        this.f60584b = fVar;
        fVar.x(this);
        this.f60585c = MusicPlayer.c();
    }

    @Override // d.b.i0.q3.i.e
    public void a() {
        this.f60583a.w();
    }

    @Override // d.b.i0.q3.i.e
    public void b(CloudMusicData.MusicTagList.MusicList musicList, int i) {
        if (musicList == null || TextUtils.isEmpty(musicList.resource)) {
            return;
        }
        String g2 = d.b.i0.q3.j.f.a.h().g(musicList.resource);
        if (TextUtils.isEmpty(g2)) {
            this.f60584b.R(i);
            d.b.i0.q3.j.f.a.h().f(String.valueOf(musicList.music_id), musicList.resource, new b(musicList, i));
            return;
        }
        this.f60585c.e(g2, musicList, new c(g2, musicList, i));
    }

    @Override // d.b.i0.q3.i.e
    public void c(CloudMusicData.MusicTagList musicTagList) {
        if (ListUtils.isEmpty(musicTagList.music_list)) {
            this.f60584b.displayNoDataView(true);
        } else {
            this.f60584b.displayNoDataView(false);
            this.f60584b.T(musicTagList);
        }
        if (musicTagList.page.has_more == 0) {
            this.f60584b.J();
        }
    }

    @Override // d.b.i0.q3.i.e
    public void cancelLoadData() {
        this.f60583a.cancelLoadData();
    }

    @Override // d.b.i0.q3.i.e
    public void d(int i) {
        this.f60584b.G(true);
        this.f60583a.u(i, new C1518a());
    }
}
