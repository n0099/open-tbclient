package d.a.o0.r3.l;

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
import d.a.o0.r3.i.f.a;
import d.a.o0.r3.l.d;
import d.a.o0.r3.l.i;
import java.io.File;
/* loaded from: classes5.dex */
public class j implements i.b {

    /* renamed from: e  reason: collision with root package name */
    public MediaPlayer f64103e;

    /* renamed from: f  reason: collision with root package name */
    public int f64104f;

    /* renamed from: g  reason: collision with root package name */
    public String f64105g;

    /* renamed from: h  reason: collision with root package name */
    public String f64106h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f64107i;
    public Context j;
    public boolean k;
    public d.a.o0.u1.g l;

    /* loaded from: classes5.dex */
    public class a implements a.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.a f64108a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ MusicData f64109b;

        public a(d.a aVar, MusicData musicData) {
            this.f64108a = aVar;
            this.f64109b = musicData;
        }

        @Override // d.a.o0.r3.i.f.a.b
        public void a(String str) {
            if (this.f64108a.f64063d != j.this.f64104f) {
                return;
            }
            j.this.k = false;
            this.f64108a.f64061b.setVisibility(4);
            this.f64108a.f64060a.setDrawBorder(true);
            this.f64108a.f64060a.invalidate();
            d.a.c.e.p.l.M(TbadkCoreApplication.getInst(), str);
            if (j.this.l != null) {
                j.this.l.b(3, str);
            }
        }

        @Override // d.a.o0.r3.i.f.a.b
        public void b() {
            if (this.f64108a.f64063d != j.this.f64104f) {
                return;
            }
            j.this.k = false;
            this.f64108a.f64060a.setDrawBorder(true);
            this.f64108a.f64060a.invalidate();
            this.f64108a.f64061b.setVisibility(4);
        }

        @Override // d.a.o0.r3.i.f.a.b
        public void c(String str, String str2) {
            if (this.f64108a.f64063d != j.this.f64104f) {
                return;
            }
            j.this.k = false;
            if (!TextUtils.isEmpty(str2)) {
                str = str2;
            }
            j.this.p(str, this.f64109b);
            this.f64108a.f64061b.setVisibility(4);
            this.f64108a.f64060a.setDrawBorder(true);
            this.f64108a.f64060a.invalidate();
        }
    }

    /* loaded from: classes5.dex */
    public class b implements a.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ MusicData f64111a;

        public b(MusicData musicData) {
            this.f64111a = musicData;
        }

        @Override // d.a.o0.r3.i.f.a.b
        public void a(String str) {
            d.a.c.e.p.l.M(TbadkCoreApplication.getInst(), str);
            if (j.this.l != null) {
                j.this.l.b(3, str);
            }
        }

        @Override // d.a.o0.r3.i.f.a.b
        public void b() {
        }

        @Override // d.a.o0.r3.i.f.a.b
        public void c(String str, String str2) {
            if (!TextUtils.isEmpty(str2)) {
                str = str2;
            }
            j.this.p(str, this.f64111a);
        }
    }

    /* loaded from: classes5.dex */
    public class c implements MediaPlayer.OnPreparedListener {
        public c() {
        }

        @Override // android.media.MediaPlayer.OnPreparedListener
        public void onPrepared(MediaPlayer mediaPlayer) {
            j.this.f64103e.setLooping(true);
            j.this.f64103e.start();
        }
    }

    /* loaded from: classes5.dex */
    public class d implements MediaPlayer.OnErrorListener {
        public d() {
        }

        @Override // android.media.MediaPlayer.OnErrorListener
        public boolean onError(MediaPlayer mediaPlayer, int i2, int i3) {
            if (j.this.l != null) {
                d.a.o0.u1.g gVar = j.this.l;
                gVar.b(4, "what-->" + i2 + "  extra-->" + i3);
                return false;
            }
            return false;
        }
    }

    public j(Activity activity) {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921309, d.a.o0.u1.k.class);
        d.a.o0.u1.k kVar = runTask != null ? (d.a.o0.u1.k) runTask.getData() : null;
        if (kVar != null) {
            this.l = kVar.get();
        }
        this.j = activity;
    }

    @Override // d.a.o0.r3.l.i.b
    public void a(int i2) {
    }

    public void g(EditVideoActivityConfig editVideoActivityConfig) {
        if (TextUtils.isEmpty(this.f64106h) || TextUtils.isEmpty(this.f64105g)) {
            return;
        }
        editVideoActivityConfig.addMusicInfo(this.f64106h, this.f64105g, this.f64104f);
    }

    public String h() {
        return this.f64106h;
    }

    public boolean i() {
        return this.k;
    }

    public void j(String str, String str2) {
        this.f64107i = false;
        this.f64106h = str;
        this.f64105g = str2;
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
        this.f64107i = true;
        MediaPlayer mediaPlayer = this.f64103e;
        if (mediaPlayer == null || !mediaPlayer.isPlaying()) {
            return;
        }
        this.f64103e.pause();
    }

    public void m() {
        this.f64107i = false;
        MediaPlayer mediaPlayer = this.f64103e;
        if (mediaPlayer != null) {
            mediaPlayer.start();
            this.f64103e.seekTo(0);
        }
    }

    public void n(int i2) {
        MediaPlayer mediaPlayer = this.f64103e;
        if (mediaPlayer == null || mediaPlayer.getDuration() <= 0) {
            return;
        }
        if (i2 < 0) {
            i2 = 0;
        }
        if (i2 > this.f64103e.getDuration()) {
            i2 %= this.f64103e.getDuration();
        }
        this.f64103e.seekTo(i2);
        this.f64103e.start();
    }

    public void o() {
        MediaPlayer mediaPlayer = this.f64103e;
        if (mediaPlayer == null || !mediaPlayer.isPlaying()) {
            return;
        }
        this.f64103e.pause();
    }

    public final void p(String str, MusicData musicData) {
        if (this.f64107i) {
            return;
        }
        if (this.f64103e == null) {
            MediaPlayer mediaPlayer = new MediaPlayer();
            this.f64103e = mediaPlayer;
            mediaPlayer.setAudioStreamType(3);
        }
        try {
            this.f64106h = str;
            this.f64103e.reset();
            this.f64103e.setDataSource(str);
            this.f64103e.prepare();
            this.f64103e.setOnPreparedListener(new c());
            this.f64103e.setOnErrorListener(new d());
        } catch (Exception e2) {
            e2.printStackTrace();
            s(str, musicData);
        }
    }

    public final void q(Object obj, MusicData musicData) {
        if (musicData == null || TextUtils.isEmpty(musicData.resource)) {
            return;
        }
        MediaPlayer mediaPlayer = this.f64103e;
        if (mediaPlayer != null && mediaPlayer.isPlaying()) {
            this.f64103e.stop();
        }
        this.k = false;
        this.f64105g = musicData.id;
        String g2 = d.a.o0.r3.i.f.a.h().g(musicData.resource);
        if (obj != null && (obj instanceof d.a)) {
            this.f64104f = ((d.a) obj).f64063d;
        }
        if (TextUtils.isEmpty(g2)) {
            if (obj instanceof d.a) {
                d.a aVar = (d.a) obj;
                aVar.f64061b.setVisibility(0);
                aVar.f64060a.setDrawBorder(false);
                aVar.f64060a.invalidate();
                this.k = true;
                d.a.o0.r3.i.f.a.h().f(musicData.id, musicData.resource, new a(aVar, musicData));
                return;
            }
            d.a.o0.r3.i.f.a.h().f(musicData.id, musicData.resource, new b(musicData));
            return;
        }
        p(g2, musicData);
    }

    public void r() {
        MediaPlayer mediaPlayer = this.f64103e;
        if (mediaPlayer != null) {
            if (mediaPlayer.isPlaying()) {
                this.f64103e.stop();
            }
            this.f64103e.release();
            this.f64103e = null;
        }
        this.f64106h = null;
        this.f64105g = null;
    }

    public final void s(String str, MusicData musicData) {
        this.f64106h = null;
        r();
        if (str.startsWith("/")) {
            File file = new File(str);
            if (file.exists()) {
                file.delete();
            }
            d.a.o0.r3.i.f.a.h().e();
        }
        q(null, musicData);
    }

    public void t(SelectMusicModel selectMusicModel) {
    }
}
