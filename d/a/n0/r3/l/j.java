package d.a.n0.r3.l;

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
import d.a.n0.r3.i.f.a;
import d.a.n0.r3.l.d;
import d.a.n0.r3.l.i;
import java.io.File;
/* loaded from: classes5.dex */
public class j implements i.b {

    /* renamed from: e  reason: collision with root package name */
    public MediaPlayer f63978e;

    /* renamed from: f  reason: collision with root package name */
    public int f63979f;

    /* renamed from: g  reason: collision with root package name */
    public String f63980g;

    /* renamed from: h  reason: collision with root package name */
    public String f63981h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f63982i;
    public Context j;
    public boolean k;
    public d.a.n0.u1.g l;

    /* loaded from: classes5.dex */
    public class a implements a.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.a f63983a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ MusicData f63984b;

        public a(d.a aVar, MusicData musicData) {
            this.f63983a = aVar;
            this.f63984b = musicData;
        }

        @Override // d.a.n0.r3.i.f.a.b
        public void a(String str) {
            if (this.f63983a.f63938d != j.this.f63979f) {
                return;
            }
            j.this.k = false;
            this.f63983a.f63936b.setVisibility(4);
            this.f63983a.f63935a.setDrawBorder(true);
            this.f63983a.f63935a.invalidate();
            d.a.c.e.p.l.M(TbadkCoreApplication.getInst(), str);
            if (j.this.l != null) {
                j.this.l.b(3, str);
            }
        }

        @Override // d.a.n0.r3.i.f.a.b
        public void b() {
            if (this.f63983a.f63938d != j.this.f63979f) {
                return;
            }
            j.this.k = false;
            this.f63983a.f63935a.setDrawBorder(true);
            this.f63983a.f63935a.invalidate();
            this.f63983a.f63936b.setVisibility(4);
        }

        @Override // d.a.n0.r3.i.f.a.b
        public void c(String str, String str2) {
            if (this.f63983a.f63938d != j.this.f63979f) {
                return;
            }
            j.this.k = false;
            if (!TextUtils.isEmpty(str2)) {
                str = str2;
            }
            j.this.p(str, this.f63984b);
            this.f63983a.f63936b.setVisibility(4);
            this.f63983a.f63935a.setDrawBorder(true);
            this.f63983a.f63935a.invalidate();
        }
    }

    /* loaded from: classes5.dex */
    public class b implements a.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ MusicData f63986a;

        public b(MusicData musicData) {
            this.f63986a = musicData;
        }

        @Override // d.a.n0.r3.i.f.a.b
        public void a(String str) {
            d.a.c.e.p.l.M(TbadkCoreApplication.getInst(), str);
            if (j.this.l != null) {
                j.this.l.b(3, str);
            }
        }

        @Override // d.a.n0.r3.i.f.a.b
        public void b() {
        }

        @Override // d.a.n0.r3.i.f.a.b
        public void c(String str, String str2) {
            if (!TextUtils.isEmpty(str2)) {
                str = str2;
            }
            j.this.p(str, this.f63986a);
        }
    }

    /* loaded from: classes5.dex */
    public class c implements MediaPlayer.OnPreparedListener {
        public c() {
        }

        @Override // android.media.MediaPlayer.OnPreparedListener
        public void onPrepared(MediaPlayer mediaPlayer) {
            j.this.f63978e.setLooping(true);
            j.this.f63978e.start();
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

    @Override // d.a.n0.r3.l.i.b
    public void a(int i2) {
    }

    public void g(EditVideoActivityConfig editVideoActivityConfig) {
        if (TextUtils.isEmpty(this.f63981h) || TextUtils.isEmpty(this.f63980g)) {
            return;
        }
        editVideoActivityConfig.addMusicInfo(this.f63981h, this.f63980g, this.f63979f);
    }

    public String h() {
        return this.f63981h;
    }

    public boolean i() {
        return this.k;
    }

    public void j(String str, String str2) {
        this.f63982i = false;
        this.f63981h = str;
        this.f63980g = str2;
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
        this.f63982i = true;
        MediaPlayer mediaPlayer = this.f63978e;
        if (mediaPlayer == null || !mediaPlayer.isPlaying()) {
            return;
        }
        this.f63978e.pause();
    }

    public void m() {
        this.f63982i = false;
        MediaPlayer mediaPlayer = this.f63978e;
        if (mediaPlayer != null) {
            mediaPlayer.start();
            this.f63978e.seekTo(0);
        }
    }

    public void n(int i2) {
        MediaPlayer mediaPlayer = this.f63978e;
        if (mediaPlayer == null || mediaPlayer.getDuration() <= 0) {
            return;
        }
        if (i2 < 0) {
            i2 = 0;
        }
        if (i2 > this.f63978e.getDuration()) {
            i2 %= this.f63978e.getDuration();
        }
        this.f63978e.seekTo(i2);
        this.f63978e.start();
    }

    public void o() {
        MediaPlayer mediaPlayer = this.f63978e;
        if (mediaPlayer == null || !mediaPlayer.isPlaying()) {
            return;
        }
        this.f63978e.pause();
    }

    public final void p(String str, MusicData musicData) {
        if (this.f63982i) {
            return;
        }
        if (this.f63978e == null) {
            MediaPlayer mediaPlayer = new MediaPlayer();
            this.f63978e = mediaPlayer;
            mediaPlayer.setAudioStreamType(3);
        }
        try {
            this.f63981h = str;
            this.f63978e.reset();
            this.f63978e.setDataSource(str);
            this.f63978e.prepare();
            this.f63978e.setOnPreparedListener(new c());
            this.f63978e.setOnErrorListener(new d());
        } catch (Exception e2) {
            e2.printStackTrace();
            s(str, musicData);
        }
    }

    public final void q(Object obj, MusicData musicData) {
        if (musicData == null || TextUtils.isEmpty(musicData.resource)) {
            return;
        }
        MediaPlayer mediaPlayer = this.f63978e;
        if (mediaPlayer != null && mediaPlayer.isPlaying()) {
            this.f63978e.stop();
        }
        this.k = false;
        this.f63980g = musicData.id;
        String g2 = d.a.n0.r3.i.f.a.h().g(musicData.resource);
        if (obj != null && (obj instanceof d.a)) {
            this.f63979f = ((d.a) obj).f63938d;
        }
        if (TextUtils.isEmpty(g2)) {
            if (obj instanceof d.a) {
                d.a aVar = (d.a) obj;
                aVar.f63936b.setVisibility(0);
                aVar.f63935a.setDrawBorder(false);
                aVar.f63935a.invalidate();
                this.k = true;
                d.a.n0.r3.i.f.a.h().f(musicData.id, musicData.resource, new a(aVar, musicData));
                return;
            }
            d.a.n0.r3.i.f.a.h().f(musicData.id, musicData.resource, new b(musicData));
            return;
        }
        p(g2, musicData);
    }

    public void r() {
        MediaPlayer mediaPlayer = this.f63978e;
        if (mediaPlayer != null) {
            if (mediaPlayer.isPlaying()) {
                this.f63978e.stop();
            }
            this.f63978e.release();
            this.f63978e = null;
        }
        this.f63981h = null;
        this.f63980g = null;
    }

    public final void s(String str, MusicData musicData) {
        this.f63981h = null;
        r();
        if (str.startsWith("/")) {
            File file = new File(str);
            if (file.exists()) {
                file.delete();
            }
            d.a.n0.r3.i.f.a.h().e();
        }
        q(null, musicData);
    }

    public void t(SelectMusicModel selectMusicModel) {
    }
}
