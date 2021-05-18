package d.a.k0.q3.i;

import android.text.TextUtils;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.video.cloudmusic.MusicPlayer;
import com.baidu.tieba.video.cloudmusic.data.CloudMusicData;
import com.baidu.tieba.video.cloudmusic.model.CloudMusicListModel;
import d.a.k0.q3.j.f.a;
import java.io.File;
/* loaded from: classes5.dex */
public class a implements e {

    /* renamed from: a  reason: collision with root package name */
    public final CloudMusicListModel f59880a;

    /* renamed from: b  reason: collision with root package name */
    public final f f59881b;

    /* renamed from: c  reason: collision with root package name */
    public MusicPlayer f59882c;

    /* renamed from: d.a.k0.q3.i.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C1554a implements d.a.k0.q3.i.i.a<CloudMusicData.MusicTagList> {
        public C1554a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.k0.q3.i.i.a
        /* renamed from: b */
        public void a(CloudMusicData.MusicTagList musicTagList) {
            a.this.f59881b.v(false);
            if (!ListUtils.isEmpty(musicTagList.music_list) || musicTagList.page.pn != 1) {
                a.this.f59881b.displayNoDataView(false);
                a.this.f59881b.B(musicTagList);
            } else {
                a.this.f59881b.displayNoDataView(true);
            }
            if (musicTagList.page.has_more == 0) {
                a.this.f59881b.x();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements a.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ CloudMusicData.MusicTagList.MusicList f59884a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ int f59885b;

        /* renamed from: d.a.k0.q3.i.a$b$a  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public class C1555a implements MusicPlayer.b {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ String f59887a;

            public C1555a(String str) {
                this.f59887a = str;
            }

            @Override // com.baidu.tieba.video.cloudmusic.MusicPlayer.b
            public void a() {
                a.this.f59882c.f();
                if (this.f59887a.startsWith("/")) {
                    File file = new File(this.f59887a);
                    if (file.exists()) {
                        file.delete();
                    }
                    d.a.k0.q3.j.f.a.h().e();
                    b bVar = b.this;
                    a.this.c(bVar.f59884a, bVar.f59885b);
                }
            }
        }

        public b(CloudMusicData.MusicTagList.MusicList musicList, int i2) {
            this.f59884a = musicList;
            this.f59885b = i2;
        }

        @Override // d.a.k0.q3.j.f.a.b
        public void a(String str) {
            a.this.f59881b.I(this.f59885b);
        }

        @Override // d.a.k0.q3.j.f.a.b
        public void b() {
            a.this.f59881b.K(this.f59885b);
        }

        @Override // d.a.k0.q3.j.f.a.b
        public void c(String str, String str2) {
            if (!TextUtils.isEmpty(str2)) {
                str = str2;
            }
            a.this.f59882c.e(str, this.f59884a, new C1555a(str));
        }
    }

    /* loaded from: classes5.dex */
    public class c implements MusicPlayer.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f59889a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ CloudMusicData.MusicTagList.MusicList f59890b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ int f59891c;

        public c(String str, CloudMusicData.MusicTagList.MusicList musicList, int i2) {
            this.f59889a = str;
            this.f59890b = musicList;
            this.f59891c = i2;
        }

        @Override // com.baidu.tieba.video.cloudmusic.MusicPlayer.b
        public void a() {
            a.this.f59882c.f();
            if (this.f59889a.startsWith("/")) {
                File file = new File(this.f59889a);
                if (file.exists()) {
                    file.delete();
                }
                d.a.k0.q3.j.f.a.h().e();
                a.this.c(this.f59890b, this.f59891c);
            }
        }
    }

    public a(CloudMusicListModel cloudMusicListModel, f fVar) {
        this.f59880a = cloudMusicListModel;
        this.f59881b = fVar;
        fVar.Z(this);
        this.f59882c = MusicPlayer.c();
    }

    @Override // d.a.k0.q3.i.e
    public void a(CloudMusicData.MusicTagList musicTagList) {
        if (ListUtils.isEmpty(musicTagList.music_list)) {
            this.f59881b.displayNoDataView(true);
        } else {
            this.f59881b.displayNoDataView(false);
            this.f59881b.B(musicTagList);
        }
        if (musicTagList.page.has_more == 0) {
            this.f59881b.x();
        }
    }

    @Override // d.a.k0.q3.i.e
    public void b() {
        this.f59880a.w();
    }

    @Override // d.a.k0.q3.i.e
    public void c(CloudMusicData.MusicTagList.MusicList musicList, int i2) {
        if (musicList == null || TextUtils.isEmpty(musicList.resource)) {
            return;
        }
        String g2 = d.a.k0.q3.j.f.a.h().g(musicList.resource);
        if (TextUtils.isEmpty(g2)) {
            this.f59881b.f0(i2);
            d.a.k0.q3.j.f.a.h().f(String.valueOf(musicList.music_id), musicList.resource, new b(musicList, i2));
            return;
        }
        this.f59882c.e(g2, musicList, new c(g2, musicList, i2));
    }

    @Override // d.a.k0.q3.i.e
    public void cancelLoadData() {
        this.f59880a.cancelLoadData();
    }

    @Override // d.a.k0.q3.i.e
    public void d(int i2) {
        this.f59881b.v(true);
        this.f59880a.u(i2, new C1554a());
    }
}
