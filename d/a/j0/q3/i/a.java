package d.a.j0.q3.i;

import android.text.TextUtils;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.video.cloudmusic.MusicPlayer;
import com.baidu.tieba.video.cloudmusic.data.CloudMusicData;
import com.baidu.tieba.video.cloudmusic.model.CloudMusicListModel;
import d.a.j0.q3.j.f.a;
import java.io.File;
/* loaded from: classes5.dex */
public class a implements e {

    /* renamed from: a  reason: collision with root package name */
    public final CloudMusicListModel f59135a;

    /* renamed from: b  reason: collision with root package name */
    public final f f59136b;

    /* renamed from: c  reason: collision with root package name */
    public MusicPlayer f59137c;

    /* renamed from: d.a.j0.q3.i.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C1480a implements d.a.j0.q3.i.i.a<CloudMusicData.MusicTagList> {
        public C1480a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.j0.q3.i.i.a
        /* renamed from: b */
        public void a(CloudMusicData.MusicTagList musicTagList) {
            a.this.f59136b.v(false);
            if (!ListUtils.isEmpty(musicTagList.music_list) || musicTagList.page.pn != 1) {
                a.this.f59136b.displayNoDataView(false);
                a.this.f59136b.B(musicTagList);
            } else {
                a.this.f59136b.displayNoDataView(true);
            }
            if (musicTagList.page.has_more == 0) {
                a.this.f59136b.x();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements a.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ CloudMusicData.MusicTagList.MusicList f59139a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ int f59140b;

        /* renamed from: d.a.j0.q3.i.a$b$a  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public class C1481a implements MusicPlayer.b {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ String f59142a;

            public C1481a(String str) {
                this.f59142a = str;
            }

            @Override // com.baidu.tieba.video.cloudmusic.MusicPlayer.b
            public void a() {
                a.this.f59137c.f();
                if (this.f59142a.startsWith("/")) {
                    File file = new File(this.f59142a);
                    if (file.exists()) {
                        file.delete();
                    }
                    d.a.j0.q3.j.f.a.h().e();
                    b bVar = b.this;
                    a.this.c(bVar.f59139a, bVar.f59140b);
                }
            }
        }

        public b(CloudMusicData.MusicTagList.MusicList musicList, int i2) {
            this.f59139a = musicList;
            this.f59140b = i2;
        }

        @Override // d.a.j0.q3.j.f.a.b
        public void a(String str) {
            a.this.f59136b.I(this.f59140b);
        }

        @Override // d.a.j0.q3.j.f.a.b
        public void b() {
            a.this.f59136b.K(this.f59140b);
        }

        @Override // d.a.j0.q3.j.f.a.b
        public void c(String str, String str2) {
            if (!TextUtils.isEmpty(str2)) {
                str = str2;
            }
            a.this.f59137c.e(str, this.f59139a, new C1481a(str));
        }
    }

    /* loaded from: classes5.dex */
    public class c implements MusicPlayer.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f59144a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ CloudMusicData.MusicTagList.MusicList f59145b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ int f59146c;

        public c(String str, CloudMusicData.MusicTagList.MusicList musicList, int i2) {
            this.f59144a = str;
            this.f59145b = musicList;
            this.f59146c = i2;
        }

        @Override // com.baidu.tieba.video.cloudmusic.MusicPlayer.b
        public void a() {
            a.this.f59137c.f();
            if (this.f59144a.startsWith("/")) {
                File file = new File(this.f59144a);
                if (file.exists()) {
                    file.delete();
                }
                d.a.j0.q3.j.f.a.h().e();
                a.this.c(this.f59145b, this.f59146c);
            }
        }
    }

    public a(CloudMusicListModel cloudMusicListModel, f fVar) {
        this.f59135a = cloudMusicListModel;
        this.f59136b = fVar;
        fVar.Z(this);
        this.f59137c = MusicPlayer.c();
    }

    @Override // d.a.j0.q3.i.e
    public void a(CloudMusicData.MusicTagList musicTagList) {
        if (ListUtils.isEmpty(musicTagList.music_list)) {
            this.f59136b.displayNoDataView(true);
        } else {
            this.f59136b.displayNoDataView(false);
            this.f59136b.B(musicTagList);
        }
        if (musicTagList.page.has_more == 0) {
            this.f59136b.x();
        }
    }

    @Override // d.a.j0.q3.i.e
    public void b() {
        this.f59135a.w();
    }

    @Override // d.a.j0.q3.i.e
    public void c(CloudMusicData.MusicTagList.MusicList musicList, int i2) {
        if (musicList == null || TextUtils.isEmpty(musicList.resource)) {
            return;
        }
        String g2 = d.a.j0.q3.j.f.a.h().g(musicList.resource);
        if (TextUtils.isEmpty(g2)) {
            this.f59136b.f0(i2);
            d.a.j0.q3.j.f.a.h().f(String.valueOf(musicList.music_id), musicList.resource, new b(musicList, i2));
            return;
        }
        this.f59137c.e(g2, musicList, new c(g2, musicList, i2));
    }

    @Override // d.a.j0.q3.i.e
    public void cancelLoadData() {
        this.f59135a.cancelLoadData();
    }

    @Override // d.a.j0.q3.i.e
    public void d(int i2) {
        this.f59136b.v(true);
        this.f59135a.u(i2, new C1480a());
    }
}
