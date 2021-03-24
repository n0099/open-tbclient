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
    public final CloudMusicListModel f58914a;

    /* renamed from: b  reason: collision with root package name */
    public final f f58915b;

    /* renamed from: c  reason: collision with root package name */
    public MusicPlayer f58916c;

    /* renamed from: d.b.i0.p3.i.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C1454a implements d.b.i0.p3.i.i.a<CloudMusicData.MusicTagList> {
        public C1454a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.i0.p3.i.i.a
        /* renamed from: b */
        public void a(CloudMusicData.MusicTagList musicTagList) {
            a.this.f58915b.G(false);
            if (!ListUtils.isEmpty(musicTagList.music_list) || musicTagList.page.pn != 1) {
                a.this.f58915b.displayNoDataView(false);
                a.this.f58915b.T(musicTagList);
            } else {
                a.this.f58915b.displayNoDataView(true);
            }
            if (musicTagList.page.has_more == 0) {
                a.this.f58915b.J();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements a.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ CloudMusicData.MusicTagList.MusicList f58918a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ int f58919b;

        /* renamed from: d.b.i0.p3.i.a$b$a  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public class C1455a implements MusicPlayer.b {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ String f58921a;

            public C1455a(String str) {
                this.f58921a = str;
            }

            @Override // com.baidu.tieba.video.cloudmusic.MusicPlayer.b
            public void a() {
                a.this.f58916c.f();
                if (this.f58921a.startsWith("/")) {
                    File file = new File(this.f58921a);
                    if (file.exists()) {
                        file.delete();
                    }
                    d.b.i0.p3.j.f.a.h().e();
                    b bVar = b.this;
                    a.this.c(bVar.f58918a, bVar.f58919b);
                }
            }
        }

        public b(CloudMusicData.MusicTagList.MusicList musicList, int i) {
            this.f58918a = musicList;
            this.f58919b = i;
        }

        @Override // d.b.i0.p3.j.f.a.b
        public void a(String str) {
            a.this.f58915b.h0(this.f58919b);
        }

        @Override // d.b.i0.p3.j.f.a.b
        public void b() {
            a.this.f58915b.m0(this.f58919b);
        }

        @Override // d.b.i0.p3.j.f.a.b
        public void c(String str, String str2) {
            if (!TextUtils.isEmpty(str2)) {
                str = str2;
            }
            a.this.f58916c.e(str, this.f58918a, new C1455a(str));
        }
    }

    /* loaded from: classes5.dex */
    public class c implements MusicPlayer.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f58923a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ CloudMusicData.MusicTagList.MusicList f58924b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ int f58925c;

        public c(String str, CloudMusicData.MusicTagList.MusicList musicList, int i) {
            this.f58923a = str;
            this.f58924b = musicList;
            this.f58925c = i;
        }

        @Override // com.baidu.tieba.video.cloudmusic.MusicPlayer.b
        public void a() {
            a.this.f58916c.f();
            if (this.f58923a.startsWith("/")) {
                File file = new File(this.f58923a);
                if (file.exists()) {
                    file.delete();
                }
                d.b.i0.p3.j.f.a.h().e();
                a.this.c(this.f58924b, this.f58925c);
            }
        }
    }

    public a(CloudMusicListModel cloudMusicListModel, f fVar) {
        this.f58914a = cloudMusicListModel;
        this.f58915b = fVar;
        fVar.x(this);
        this.f58916c = MusicPlayer.c();
    }

    @Override // d.b.i0.p3.i.e
    public void a() {
        this.f58914a.cancelLoadData();
    }

    @Override // d.b.i0.p3.i.e
    public void b() {
        this.f58914a.w();
    }

    @Override // d.b.i0.p3.i.e
    public void c(CloudMusicData.MusicTagList.MusicList musicList, int i) {
        if (musicList == null || TextUtils.isEmpty(musicList.resource)) {
            return;
        }
        String g2 = d.b.i0.p3.j.f.a.h().g(musicList.resource);
        if (TextUtils.isEmpty(g2)) {
            this.f58915b.R(i);
            d.b.i0.p3.j.f.a.h().f(String.valueOf(musicList.music_id), musicList.resource, new b(musicList, i));
            return;
        }
        this.f58916c.e(g2, musicList, new c(g2, musicList, i));
    }

    @Override // d.b.i0.p3.i.e
    public void d(CloudMusicData.MusicTagList musicTagList) {
        if (ListUtils.isEmpty(musicTagList.music_list)) {
            this.f58915b.displayNoDataView(true);
        } else {
            this.f58915b.displayNoDataView(false);
            this.f58915b.T(musicTagList);
        }
        if (musicTagList.page.has_more == 0) {
            this.f58915b.J();
        }
    }

    @Override // d.b.i0.p3.i.e
    public void e(int i) {
        this.f58915b.G(true);
        this.f58914a.u(i, new C1454a());
    }
}
