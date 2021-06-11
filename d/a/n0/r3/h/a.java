package d.a.n0.r3.h;

import android.text.TextUtils;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.video.cloudmusic.MusicPlayer;
import com.baidu.tieba.video.cloudmusic.data.CloudMusicData;
import com.baidu.tieba.video.cloudmusic.model.CloudMusicListModel;
import d.a.n0.r3.i.f.a;
import java.io.File;
/* loaded from: classes5.dex */
public class a implements e {

    /* renamed from: a  reason: collision with root package name */
    public final CloudMusicListModel f63710a;

    /* renamed from: b  reason: collision with root package name */
    public final f f63711b;

    /* renamed from: c  reason: collision with root package name */
    public MusicPlayer f63712c;

    /* renamed from: d.a.n0.r3.h.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C1623a implements d.a.n0.r3.h.i.a<CloudMusicData.MusicTagList> {
        public C1623a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.n0.r3.h.i.a
        /* renamed from: b */
        public void a(CloudMusicData.MusicTagList musicTagList) {
            a.this.f63711b.w(false);
            if (!ListUtils.isEmpty(musicTagList.music_list) || musicTagList.page.pn != 1) {
                a.this.f63711b.displayNoDataView(false);
                a.this.f63711b.F(musicTagList);
            } else {
                a.this.f63711b.displayNoDataView(true);
            }
            if (musicTagList.page.has_more == 0) {
                a.this.f63711b.y();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements a.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ CloudMusicData.MusicTagList.MusicList f63714a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ int f63715b;

        /* renamed from: d.a.n0.r3.h.a$b$a  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public class C1624a implements MusicPlayer.b {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ String f63717a;

            public C1624a(String str) {
                this.f63717a = str;
            }

            @Override // com.baidu.tieba.video.cloudmusic.MusicPlayer.b
            public void a() {
                a.this.f63712c.f();
                if (this.f63717a.startsWith("/")) {
                    File file = new File(this.f63717a);
                    if (file.exists()) {
                        file.delete();
                    }
                    d.a.n0.r3.i.f.a.h().e();
                    b bVar = b.this;
                    a.this.c(bVar.f63714a, bVar.f63715b);
                }
            }
        }

        public b(CloudMusicData.MusicTagList.MusicList musicList, int i2) {
            this.f63714a = musicList;
            this.f63715b = i2;
        }

        @Override // d.a.n0.r3.i.f.a.b
        public void a(String str) {
            a.this.f63711b.J(this.f63715b);
        }

        @Override // d.a.n0.r3.i.f.a.b
        public void b() {
            a.this.f63711b.L(this.f63715b);
        }

        @Override // d.a.n0.r3.i.f.a.b
        public void c(String str, String str2) {
            if (!TextUtils.isEmpty(str2)) {
                str = str2;
            }
            a.this.f63712c.e(str, this.f63714a, new C1624a(str));
        }
    }

    /* loaded from: classes5.dex */
    public class c implements MusicPlayer.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f63719a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ CloudMusicData.MusicTagList.MusicList f63720b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ int f63721c;

        public c(String str, CloudMusicData.MusicTagList.MusicList musicList, int i2) {
            this.f63719a = str;
            this.f63720b = musicList;
            this.f63721c = i2;
        }

        @Override // com.baidu.tieba.video.cloudmusic.MusicPlayer.b
        public void a() {
            a.this.f63712c.f();
            if (this.f63719a.startsWith("/")) {
                File file = new File(this.f63719a);
                if (file.exists()) {
                    file.delete();
                }
                d.a.n0.r3.i.f.a.h().e();
                a.this.c(this.f63720b, this.f63721c);
            }
        }
    }

    public a(CloudMusicListModel cloudMusicListModel, f fVar) {
        this.f63710a = cloudMusicListModel;
        this.f63711b = fVar;
        fVar.c0(this);
        this.f63712c = MusicPlayer.c();
    }

    @Override // d.a.n0.r3.h.e
    public void a(CloudMusicData.MusicTagList musicTagList) {
        if (ListUtils.isEmpty(musicTagList.music_list)) {
            this.f63711b.displayNoDataView(true);
        } else {
            this.f63711b.displayNoDataView(false);
            this.f63711b.F(musicTagList);
        }
        if (musicTagList.page.has_more == 0) {
            this.f63711b.y();
        }
    }

    @Override // d.a.n0.r3.h.e
    public void b() {
        this.f63710a.A();
    }

    @Override // d.a.n0.r3.h.e
    public void c(CloudMusicData.MusicTagList.MusicList musicList, int i2) {
        if (musicList == null || TextUtils.isEmpty(musicList.resource)) {
            return;
        }
        String g2 = d.a.n0.r3.i.f.a.h().g(musicList.resource);
        if (TextUtils.isEmpty(g2)) {
            this.f63711b.i0(i2);
            d.a.n0.r3.i.f.a.h().f(String.valueOf(musicList.music_id), musicList.resource, new b(musicList, i2));
            return;
        }
        this.f63712c.e(g2, musicList, new c(g2, musicList, i2));
    }

    @Override // d.a.n0.r3.h.e
    public void cancelLoadData() {
        this.f63710a.cancelLoadData();
    }

    @Override // d.a.n0.r3.h.e
    public void d(int i2) {
        this.f63711b.w(true);
        this.f63710a.y(i2, new C1623a());
    }
}
