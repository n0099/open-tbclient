package d.a.o0.r3.h;

import android.text.TextUtils;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.video.cloudmusic.MusicPlayer;
import com.baidu.tieba.video.cloudmusic.data.CloudMusicData;
import com.baidu.tieba.video.cloudmusic.model.CloudMusicListModel;
import d.a.o0.r3.i.f.a;
import java.io.File;
/* loaded from: classes5.dex */
public class a implements e {

    /* renamed from: a  reason: collision with root package name */
    public final CloudMusicListModel f63835a;

    /* renamed from: b  reason: collision with root package name */
    public final f f63836b;

    /* renamed from: c  reason: collision with root package name */
    public MusicPlayer f63837c;

    /* renamed from: d.a.o0.r3.h.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C1627a implements d.a.o0.r3.h.i.a<CloudMusicData.MusicTagList> {
        public C1627a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.o0.r3.h.i.a
        /* renamed from: b */
        public void a(CloudMusicData.MusicTagList musicTagList) {
            a.this.f63836b.w(false);
            if (!ListUtils.isEmpty(musicTagList.music_list) || musicTagList.page.pn != 1) {
                a.this.f63836b.displayNoDataView(false);
                a.this.f63836b.F(musicTagList);
            } else {
                a.this.f63836b.displayNoDataView(true);
            }
            if (musicTagList.page.has_more == 0) {
                a.this.f63836b.y();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements a.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ CloudMusicData.MusicTagList.MusicList f63839a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ int f63840b;

        /* renamed from: d.a.o0.r3.h.a$b$a  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public class C1628a implements MusicPlayer.b {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ String f63842a;

            public C1628a(String str) {
                this.f63842a = str;
            }

            @Override // com.baidu.tieba.video.cloudmusic.MusicPlayer.b
            public void a() {
                a.this.f63837c.f();
                if (this.f63842a.startsWith("/")) {
                    File file = new File(this.f63842a);
                    if (file.exists()) {
                        file.delete();
                    }
                    d.a.o0.r3.i.f.a.h().e();
                    b bVar = b.this;
                    a.this.c(bVar.f63839a, bVar.f63840b);
                }
            }
        }

        public b(CloudMusicData.MusicTagList.MusicList musicList, int i2) {
            this.f63839a = musicList;
            this.f63840b = i2;
        }

        @Override // d.a.o0.r3.i.f.a.b
        public void a(String str) {
            a.this.f63836b.J(this.f63840b);
        }

        @Override // d.a.o0.r3.i.f.a.b
        public void b() {
            a.this.f63836b.L(this.f63840b);
        }

        @Override // d.a.o0.r3.i.f.a.b
        public void c(String str, String str2) {
            if (!TextUtils.isEmpty(str2)) {
                str = str2;
            }
            a.this.f63837c.e(str, this.f63839a, new C1628a(str));
        }
    }

    /* loaded from: classes5.dex */
    public class c implements MusicPlayer.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f63844a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ CloudMusicData.MusicTagList.MusicList f63845b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ int f63846c;

        public c(String str, CloudMusicData.MusicTagList.MusicList musicList, int i2) {
            this.f63844a = str;
            this.f63845b = musicList;
            this.f63846c = i2;
        }

        @Override // com.baidu.tieba.video.cloudmusic.MusicPlayer.b
        public void a() {
            a.this.f63837c.f();
            if (this.f63844a.startsWith("/")) {
                File file = new File(this.f63844a);
                if (file.exists()) {
                    file.delete();
                }
                d.a.o0.r3.i.f.a.h().e();
                a.this.c(this.f63845b, this.f63846c);
            }
        }
    }

    public a(CloudMusicListModel cloudMusicListModel, f fVar) {
        this.f63835a = cloudMusicListModel;
        this.f63836b = fVar;
        fVar.c0(this);
        this.f63837c = MusicPlayer.c();
    }

    @Override // d.a.o0.r3.h.e
    public void a(CloudMusicData.MusicTagList musicTagList) {
        if (ListUtils.isEmpty(musicTagList.music_list)) {
            this.f63836b.displayNoDataView(true);
        } else {
            this.f63836b.displayNoDataView(false);
            this.f63836b.F(musicTagList);
        }
        if (musicTagList.page.has_more == 0) {
            this.f63836b.y();
        }
    }

    @Override // d.a.o0.r3.h.e
    public void b() {
        this.f63835a.A();
    }

    @Override // d.a.o0.r3.h.e
    public void c(CloudMusicData.MusicTagList.MusicList musicList, int i2) {
        if (musicList == null || TextUtils.isEmpty(musicList.resource)) {
            return;
        }
        String g2 = d.a.o0.r3.i.f.a.h().g(musicList.resource);
        if (TextUtils.isEmpty(g2)) {
            this.f63836b.i0(i2);
            d.a.o0.r3.i.f.a.h().f(String.valueOf(musicList.music_id), musicList.resource, new b(musicList, i2));
            return;
        }
        this.f63837c.e(g2, musicList, new c(g2, musicList, i2));
    }

    @Override // d.a.o0.r3.h.e
    public void cancelLoadData() {
        this.f63835a.cancelLoadData();
    }

    @Override // d.a.o0.r3.h.e
    public void d(int i2) {
        this.f63836b.w(true);
        this.f63835a.y(i2, new C1627a());
    }
}
