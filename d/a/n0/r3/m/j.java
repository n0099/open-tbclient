package d.a.n0.r3.m;

import android.app.Activity;
import android.content.Context;
import android.media.MediaPlayer;
import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.CloudMusicActivityConfig;
import com.baidu.tbadk.core.atomData.EditVideoActivityConfig;
import com.baidu.tieba.video.editvideo.data.MusicData;
import com.baidu.tieba.video.editvideo.model.SelectMusicModel;
import d.a.n0.r3.j.f.a;
import d.a.n0.r3.m.d;
import d.a.n0.r3.m.i;
import java.io.File;
/* loaded from: classes5.dex */
public class j implements i.b {

    /* renamed from: e  reason: collision with root package name */
    public MediaPlayer f60289e;

    /* renamed from: f  reason: collision with root package name */
    public int f60290f;

    /* renamed from: g  reason: collision with root package name */
    public String f60291g;

    /* renamed from: h  reason: collision with root package name */
    public String f60292h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f60293i;
    public Context j;
    public boolean k;
    public d.a.n0.u1.g l;

    /* loaded from: classes5.dex */
    public class a implements a.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.a f60294a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ MusicData f60295b;

        public a(d.a aVar, MusicData musicData) {
            this.f60294a = aVar;
            this.f60295b = musicData;
        }

        @Override // d.a.n0.r3.j.f.a.b
        public void a(String str) {
            if (this.f60294a.f60249d != j.this.f60290f) {
                return;
            }
            j.this.k = false;
            this.f60294a.f60247b.setVisibility(4);
            this.f60294a.f60246a.setDrawBorder(true);
            this.f60294a.f60246a.invalidate();
            d.a.c.e.p.l.M(TbadkCoreApplication.getInst(), str);
            if (j.this.l != null) {
                j.this.l.b(3, str);
            }
        }

        @Override // d.a.n0.r3.j.f.a.b
        public void b() {
            if (this.f60294a.f60249d != j.this.f60290f) {
                return;
            }
            j.this.k = false;
            this.f60294a.f60246a.setDrawBorder(true);
            this.f60294a.f60246a.invalidate();
            this.f60294a.f60247b.setVisibility(4);
        }

        @Override // d.a.n0.r3.j.f.a.b
        public void c(String str, String str2) {
            if (this.f60294a.f60249d != j.this.f60290f) {
                return;
            }
            j.this.k = false;
            if (!TextUtils.isEmpty(str2)) {
                str = str2;
            }
            j.this.p(str, this.f60295b);
            this.f60294a.f60247b.setVisibility(4);
            this.f60294a.f60246a.setDrawBorder(true);
            this.f60294a.f60246a.invalidate();
        }
    }

    /* loaded from: classes5.dex */
    public class b implements a.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ MusicData f60297a;

        public b(MusicData musicData) {
            this.f60297a = musicData;
        }

        @Override // d.a.n0.r3.j.f.a.b
        public void a(String str) {
            d.a.c.e.p.l.M(TbadkCoreApplication.getInst(), str);
            if (j.this.l != null) {
                j.this.l.b(3, str);
            }
        }

        @Override // d.a.n0.r3.j.f.a.b
        public void b() {
        }

        @Override // d.a.n0.r3.j.f.a.b
        public void c(String str, String str2) {
            if (!TextUtils.isEmpty(str2)) {
                str = str2;
            }
            j.this.p(str, this.f60297a);
        }
    }

    /* loaded from: classes5.dex */
    public class c implements MediaPlayer.OnPreparedListener {
        public c() {
        }

        @Override // android.media.MediaPlayer.OnPreparedListener
        public void onPrepared(MediaPlayer mediaPlayer) {
            j.this.f60289e.setLooping(true);
            j.this.f60289e.start();
        }
    }

    /* loaded from: classes5.dex */
    public class d implements MediaPlayer.OnErrorListener {
        public d() {
        }

        @Override // android.media.MediaPlayer.OnErrorListener
        public boolean onError(MediaPlayer mediaPlayer, int i2, int i3) {
            if (j.this.l != null) {
                d.a.n0.u1.g gVar = j.this.l;
                gVar.b(4, "what-->" + i2 + "  extra-->" + i3);
                return false;
            }
            return false;
        }
    }

    public j(Activity activity) {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921309, d.a.n0.u1.k.class);
        d.a.n0.u1.k kVar = runTask != null ? (d.a.n0.u1.k) runTask.getData() : null;
        if (kVar != null) {
            this.l = kVar.get();
        }
        this.j = activity;
    }

    @Override // d.a.n0.r3.m.i.b
    public void a(int i2) {
    }

    public void g(EditVideoActivityConfig editVideoActivityConfig) {
        if (TextUtils.isEmpty(this.f60292h) || TextUtils.isEmpty(this.f60291g)) {
            return;
        }
        editVideoActivityConfig.addMusicInfo(this.f60292h, this.f60291g, this.f60290f);
    }

    public String h() {
        return this.f60292h;
    }

    public boolean i() {
        return this.k;
    }

    public void j(String str, String str2) {
        this.f60293i = false;
        this.f60292h = str;
        this.f60291g = str2;
        p(str, null);
    }

    public void k(MusicData musicData, Object obj) {
        if (musicData == null) {
            return;
        }
        int i2 = musicData.editMusicType;
        if (i2 == 0) {
            q(obj, musicData);
        } else if (i2 == 1) {
            r();
        } else if (i2 != 2) {
        } else {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new CloudMusicActivityConfig(this.j, 25032)));
        }
    }

    public void l() {
        this.f60293i = true;
        MediaPlayer mediaPlayer = this.f60289e;
        if (mediaPlayer == null || !mediaPlayer.isPlaying()) {
            return;
        }
        this.f60289e.pause();
    }

    public void m() {
        this.f60293i = false;
        MediaPlayer mediaPlayer = this.f60289e;
        if (mediaPlayer != null) {
            mediaPlayer.start();
            this.f60289e.seekTo(0);
        }
    }

    public void n(int i2) {
        MediaPlayer mediaPlayer = this.f60289e;
        if (mediaPlayer == null || mediaPlayer.getDuration() <= 0) {
            return;
        }
        if (i2 < 0) {
            i2 = 0;
        }
        if (i2 > this.f60289e.getDuration()) {
            i2 %= this.f60289e.getDuration();
        }
        this.f60289e.seekTo(i2);
        this.f60289e.start();
    }

    public void o() {
        MediaPlayer mediaPlayer = this.f60289e;
        if (mediaPlayer == null || !mediaPlayer.isPlaying()) {
            return;
        }
        this.f60289e.pause();
    }

    public final void p(String str, MusicData musicData) {
        if (this.f60293i) {
            return;
        }
        if (this.f60289e == null) {
            MediaPlayer mediaPlayer = new MediaPlayer();
            this.f60289e = mediaPlayer;
            mediaPlayer.setAudioStreamType(3);
        }
        try {
            this.f60292h = str;
            this.f60289e.reset();
            this.f60289e.setDataSource(str);
            this.f60289e.prepare();
            this.f60289e.setOnPreparedListener(new c());
            this.f60289e.setOnErrorListener(new d());
        } catch (Exception e2) {
            e2.printStackTrace();
            s(str, musicData);
        }
    }

    public final void q(Object obj, MusicData musicData) {
        if (musicData == null || TextUtils.isEmpty(musicData.resource)) {
            return;
        }
        MediaPlayer mediaPlayer = this.f60289e;
        if (mediaPlayer != null && mediaPlayer.isPlaying()) {
            this.f60289e.stop();
        }
        this.k = false;
        this.f60291g = musicData.id;
        String g2 = d.a.n0.r3.j.f.a.h().g(musicData.resource);
        if (obj != null && (obj instanceof d.a)) {
            this.f60290f = ((d.a) obj).f60249d;
        }
        if (TextUtils.isEmpty(g2)) {
            if (obj instanceof d.a) {
                d.a aVar = (d.a) obj;
                aVar.f60247b.setVisibility(0);
                aVar.f60246a.setDrawBorder(false);
                aVar.f60246a.invalidate();
                this.k = true;
                d.a.n0.r3.j.f.a.h().f(musicData.id, musicData.resource, new a(aVar, musicData));
                return;
            }
            d.a.n0.r3.j.f.a.h().f(musicData.id, musicData.resource, new b(musicData));
            return;
        }
        p(g2, musicData);
    }

    public void r() {
        MediaPlayer mediaPlayer = this.f60289e;
        if (mediaPlayer != null) {
            if (mediaPlayer.isPlaying()) {
                this.f60289e.stop();
            }
            this.f60289e.release();
            this.f60289e = null;
        }
        this.f60292h = null;
        this.f60291g = null;
    }

    public final void s(String str, MusicData musicData) {
        this.f60292h = null;
        r();
        if (str.startsWith("/")) {
            File file = new File(str);
            if (file.exists()) {
                file.delete();
            }
            d.a.n0.r3.j.f.a.h().e();
        }
        q(null, musicData);
    }

    public void t(SelectMusicModel selectMusicModel) {
    }
}
