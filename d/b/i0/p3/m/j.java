package d.b.i0.p3.m;

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
import d.b.i0.p3.j.f.a;
import d.b.i0.p3.m.d;
import d.b.i0.p3.m.i;
import java.io.File;
/* loaded from: classes5.dex */
public class j implements i.b {

    /* renamed from: e  reason: collision with root package name */
    public MediaPlayer f59173e;

    /* renamed from: f  reason: collision with root package name */
    public int f59174f;

    /* renamed from: g  reason: collision with root package name */
    public String f59175g;

    /* renamed from: h  reason: collision with root package name */
    public String f59176h;
    public boolean i;
    public Context j;
    public boolean k;
    public d.b.i0.s1.g l;

    /* loaded from: classes5.dex */
    public class a implements a.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.a f59177a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ MusicData f59178b;

        public a(d.a aVar, MusicData musicData) {
            this.f59177a = aVar;
            this.f59178b = musicData;
        }

        @Override // d.b.i0.p3.j.f.a.b
        public void a(String str) {
            if (this.f59177a.f59134d != j.this.f59174f) {
                return;
            }
            j.this.k = false;
            this.f59177a.f59132b.setVisibility(4);
            this.f59177a.f59131a.setDrawBorder(true);
            this.f59177a.f59131a.invalidate();
            d.b.b.e.p.l.L(TbadkCoreApplication.getInst(), str);
            if (j.this.l != null) {
                j.this.l.c(3, str);
            }
        }

        @Override // d.b.i0.p3.j.f.a.b
        public void b() {
            if (this.f59177a.f59134d != j.this.f59174f) {
                return;
            }
            j.this.k = false;
            this.f59177a.f59131a.setDrawBorder(true);
            this.f59177a.f59131a.invalidate();
            this.f59177a.f59132b.setVisibility(4);
        }

        @Override // d.b.i0.p3.j.f.a.b
        public void c(String str, String str2) {
            if (this.f59177a.f59134d != j.this.f59174f) {
                return;
            }
            j.this.k = false;
            if (!TextUtils.isEmpty(str2)) {
                str = str2;
            }
            j.this.p(str, this.f59178b);
            this.f59177a.f59132b.setVisibility(4);
            this.f59177a.f59131a.setDrawBorder(true);
            this.f59177a.f59131a.invalidate();
        }
    }

    /* loaded from: classes5.dex */
    public class b implements a.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ MusicData f59180a;

        public b(MusicData musicData) {
            this.f59180a = musicData;
        }

        @Override // d.b.i0.p3.j.f.a.b
        public void a(String str) {
            d.b.b.e.p.l.L(TbadkCoreApplication.getInst(), str);
            if (j.this.l != null) {
                j.this.l.c(3, str);
            }
        }

        @Override // d.b.i0.p3.j.f.a.b
        public void b() {
        }

        @Override // d.b.i0.p3.j.f.a.b
        public void c(String str, String str2) {
            if (!TextUtils.isEmpty(str2)) {
                str = str2;
            }
            j.this.p(str, this.f59180a);
        }
    }

    /* loaded from: classes5.dex */
    public class c implements MediaPlayer.OnPreparedListener {
        public c() {
        }

        @Override // android.media.MediaPlayer.OnPreparedListener
        public void onPrepared(MediaPlayer mediaPlayer) {
            j.this.f59173e.setLooping(true);
            j.this.f59173e.start();
        }
    }

    /* loaded from: classes5.dex */
    public class d implements MediaPlayer.OnErrorListener {
        public d() {
        }

        @Override // android.media.MediaPlayer.OnErrorListener
        public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
            if (j.this.l != null) {
                d.b.i0.s1.g gVar = j.this.l;
                gVar.c(4, "what-->" + i + "  extra-->" + i2);
                return false;
            }
            return false;
        }
    }

    public j(Activity activity) {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921309, d.b.i0.s1.k.class);
        d.b.i0.s1.k kVar = runTask != null ? (d.b.i0.s1.k) runTask.getData() : null;
        if (kVar != null) {
            this.l = kVar.get();
        }
        this.j = activity;
    }

    @Override // d.b.i0.p3.m.i.b
    public void a(int i) {
    }

    public void g(EditVideoActivityConfig editVideoActivityConfig) {
        if (TextUtils.isEmpty(this.f59176h) || TextUtils.isEmpty(this.f59175g)) {
            return;
        }
        editVideoActivityConfig.addMusicInfo(this.f59176h, this.f59175g, this.f59174f);
    }

    public String h() {
        return this.f59176h;
    }

    public boolean i() {
        return this.k;
    }

    public void j(String str, String str2) {
        this.i = false;
        this.f59176h = str;
        this.f59175g = str2;
        p(str, null);
    }

    public void k(MusicData musicData, Object obj) {
        if (musicData == null) {
            return;
        }
        int i = musicData.editMusicType;
        if (i == 0) {
            q(obj, musicData);
        } else if (i == 1) {
            r();
        } else if (i != 2) {
        } else {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new CloudMusicActivityConfig(this.j, 25032)));
        }
    }

    public void l() {
        this.i = true;
        MediaPlayer mediaPlayer = this.f59173e;
        if (mediaPlayer == null || !mediaPlayer.isPlaying()) {
            return;
        }
        this.f59173e.pause();
    }

    public void m() {
        this.i = false;
        MediaPlayer mediaPlayer = this.f59173e;
        if (mediaPlayer != null) {
            mediaPlayer.start();
            this.f59173e.seekTo(0);
        }
    }

    public void n(int i) {
        MediaPlayer mediaPlayer = this.f59173e;
        if (mediaPlayer == null || mediaPlayer.getDuration() <= 0) {
            return;
        }
        if (i < 0) {
            i = 0;
        }
        if (i > this.f59173e.getDuration()) {
            i %= this.f59173e.getDuration();
        }
        this.f59173e.seekTo(i);
        this.f59173e.start();
    }

    public void o() {
        MediaPlayer mediaPlayer = this.f59173e;
        if (mediaPlayer == null || !mediaPlayer.isPlaying()) {
            return;
        }
        this.f59173e.pause();
    }

    public final void p(String str, MusicData musicData) {
        if (this.i) {
            return;
        }
        if (this.f59173e == null) {
            MediaPlayer mediaPlayer = new MediaPlayer();
            this.f59173e = mediaPlayer;
            mediaPlayer.setAudioStreamType(3);
        }
        try {
            this.f59176h = str;
            this.f59173e.reset();
            this.f59173e.setDataSource(str);
            this.f59173e.prepare();
            this.f59173e.setOnPreparedListener(new c());
            this.f59173e.setOnErrorListener(new d());
        } catch (Exception e2) {
            e2.printStackTrace();
            s(str, musicData);
        }
    }

    public final void q(Object obj, MusicData musicData) {
        if (musicData == null || TextUtils.isEmpty(musicData.resource)) {
            return;
        }
        MediaPlayer mediaPlayer = this.f59173e;
        if (mediaPlayer != null && mediaPlayer.isPlaying()) {
            this.f59173e.stop();
        }
        this.k = false;
        this.f59175g = musicData.id;
        String g2 = d.b.i0.p3.j.f.a.h().g(musicData.resource);
        if (obj != null && (obj instanceof d.a)) {
            this.f59174f = ((d.a) obj).f59134d;
        }
        if (TextUtils.isEmpty(g2)) {
            if (obj instanceof d.a) {
                d.a aVar = (d.a) obj;
                aVar.f59132b.setVisibility(0);
                aVar.f59131a.setDrawBorder(false);
                aVar.f59131a.invalidate();
                this.k = true;
                d.b.i0.p3.j.f.a.h().f(musicData.id, musicData.resource, new a(aVar, musicData));
                return;
            }
            d.b.i0.p3.j.f.a.h().f(musicData.id, musicData.resource, new b(musicData));
            return;
        }
        p(g2, musicData);
    }

    public void r() {
        MediaPlayer mediaPlayer = this.f59173e;
        if (mediaPlayer != null) {
            if (mediaPlayer.isPlaying()) {
                this.f59173e.stop();
            }
            this.f59173e.release();
            this.f59173e = null;
        }
        this.f59176h = null;
        this.f59175g = null;
    }

    public final void s(String str, MusicData musicData) {
        this.f59176h = null;
        r();
        if (str.startsWith("/")) {
            File file = new File(str);
            if (file.exists()) {
                file.delete();
            }
            d.b.i0.p3.j.f.a.h().e();
        }
        q(null, musicData);
    }

    public void t(SelectMusicModel selectMusicModel) {
    }
}
