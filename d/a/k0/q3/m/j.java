package d.a.k0.q3.m;

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
import d.a.k0.q3.j.f.a;
import d.a.k0.q3.m.d;
import d.a.k0.q3.m.i;
import java.io.File;
/* loaded from: classes5.dex */
public class j implements i.b {

    /* renamed from: e  reason: collision with root package name */
    public MediaPlayer f60148e;

    /* renamed from: f  reason: collision with root package name */
    public int f60149f;

    /* renamed from: g  reason: collision with root package name */
    public String f60150g;

    /* renamed from: h  reason: collision with root package name */
    public String f60151h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f60152i;
    public Context j;
    public boolean k;
    public d.a.k0.t1.g l;

    /* loaded from: classes5.dex */
    public class a implements a.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.a f60153a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ MusicData f60154b;

        public a(d.a aVar, MusicData musicData) {
            this.f60153a = aVar;
            this.f60154b = musicData;
        }

        @Override // d.a.k0.q3.j.f.a.b
        public void a(String str) {
            if (this.f60153a.f60108d != j.this.f60149f) {
                return;
            }
            j.this.k = false;
            this.f60153a.f60106b.setVisibility(4);
            this.f60153a.f60105a.setDrawBorder(true);
            this.f60153a.f60105a.invalidate();
            d.a.c.e.p.l.M(TbadkCoreApplication.getInst(), str);
            if (j.this.l != null) {
                j.this.l.b(3, str);
            }
        }

        @Override // d.a.k0.q3.j.f.a.b
        public void b() {
            if (this.f60153a.f60108d != j.this.f60149f) {
                return;
            }
            j.this.k = false;
            this.f60153a.f60105a.setDrawBorder(true);
            this.f60153a.f60105a.invalidate();
            this.f60153a.f60106b.setVisibility(4);
        }

        @Override // d.a.k0.q3.j.f.a.b
        public void c(String str, String str2) {
            if (this.f60153a.f60108d != j.this.f60149f) {
                return;
            }
            j.this.k = false;
            if (!TextUtils.isEmpty(str2)) {
                str = str2;
            }
            j.this.p(str, this.f60154b);
            this.f60153a.f60106b.setVisibility(4);
            this.f60153a.f60105a.setDrawBorder(true);
            this.f60153a.f60105a.invalidate();
        }
    }

    /* loaded from: classes5.dex */
    public class b implements a.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ MusicData f60156a;

        public b(MusicData musicData) {
            this.f60156a = musicData;
        }

        @Override // d.a.k0.q3.j.f.a.b
        public void a(String str) {
            d.a.c.e.p.l.M(TbadkCoreApplication.getInst(), str);
            if (j.this.l != null) {
                j.this.l.b(3, str);
            }
        }

        @Override // d.a.k0.q3.j.f.a.b
        public void b() {
        }

        @Override // d.a.k0.q3.j.f.a.b
        public void c(String str, String str2) {
            if (!TextUtils.isEmpty(str2)) {
                str = str2;
            }
            j.this.p(str, this.f60156a);
        }
    }

    /* loaded from: classes5.dex */
    public class c implements MediaPlayer.OnPreparedListener {
        public c() {
        }

        @Override // android.media.MediaPlayer.OnPreparedListener
        public void onPrepared(MediaPlayer mediaPlayer) {
            j.this.f60148e.setLooping(true);
            j.this.f60148e.start();
        }
    }

    /* loaded from: classes5.dex */
    public class d implements MediaPlayer.OnErrorListener {
        public d() {
        }

        @Override // android.media.MediaPlayer.OnErrorListener
        public boolean onError(MediaPlayer mediaPlayer, int i2, int i3) {
            if (j.this.l != null) {
                d.a.k0.t1.g gVar = j.this.l;
                gVar.b(4, "what-->" + i2 + "  extra-->" + i3);
                return false;
            }
            return false;
        }
    }

    public j(Activity activity) {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921309, d.a.k0.t1.k.class);
        d.a.k0.t1.k kVar = runTask != null ? (d.a.k0.t1.k) runTask.getData() : null;
        if (kVar != null) {
            this.l = kVar.get();
        }
        this.j = activity;
    }

    @Override // d.a.k0.q3.m.i.b
    public void a(int i2) {
    }

    public void g(EditVideoActivityConfig editVideoActivityConfig) {
        if (TextUtils.isEmpty(this.f60151h) || TextUtils.isEmpty(this.f60150g)) {
            return;
        }
        editVideoActivityConfig.addMusicInfo(this.f60151h, this.f60150g, this.f60149f);
    }

    public String h() {
        return this.f60151h;
    }

    public boolean i() {
        return this.k;
    }

    public void j(String str, String str2) {
        this.f60152i = false;
        this.f60151h = str;
        this.f60150g = str2;
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
        this.f60152i = true;
        MediaPlayer mediaPlayer = this.f60148e;
        if (mediaPlayer == null || !mediaPlayer.isPlaying()) {
            return;
        }
        this.f60148e.pause();
    }

    public void m() {
        this.f60152i = false;
        MediaPlayer mediaPlayer = this.f60148e;
        if (mediaPlayer != null) {
            mediaPlayer.start();
            this.f60148e.seekTo(0);
        }
    }

    public void n(int i2) {
        MediaPlayer mediaPlayer = this.f60148e;
        if (mediaPlayer == null || mediaPlayer.getDuration() <= 0) {
            return;
        }
        if (i2 < 0) {
            i2 = 0;
        }
        if (i2 > this.f60148e.getDuration()) {
            i2 %= this.f60148e.getDuration();
        }
        this.f60148e.seekTo(i2);
        this.f60148e.start();
    }

    public void o() {
        MediaPlayer mediaPlayer = this.f60148e;
        if (mediaPlayer == null || !mediaPlayer.isPlaying()) {
            return;
        }
        this.f60148e.pause();
    }

    public final void p(String str, MusicData musicData) {
        if (this.f60152i) {
            return;
        }
        if (this.f60148e == null) {
            MediaPlayer mediaPlayer = new MediaPlayer();
            this.f60148e = mediaPlayer;
            mediaPlayer.setAudioStreamType(3);
        }
        try {
            this.f60151h = str;
            this.f60148e.reset();
            this.f60148e.setDataSource(str);
            this.f60148e.prepare();
            this.f60148e.setOnPreparedListener(new c());
            this.f60148e.setOnErrorListener(new d());
        } catch (Exception e2) {
            e2.printStackTrace();
            s(str, musicData);
        }
    }

    public final void q(Object obj, MusicData musicData) {
        if (musicData == null || TextUtils.isEmpty(musicData.resource)) {
            return;
        }
        MediaPlayer mediaPlayer = this.f60148e;
        if (mediaPlayer != null && mediaPlayer.isPlaying()) {
            this.f60148e.stop();
        }
        this.k = false;
        this.f60150g = musicData.id;
        String g2 = d.a.k0.q3.j.f.a.h().g(musicData.resource);
        if (obj != null && (obj instanceof d.a)) {
            this.f60149f = ((d.a) obj).f60108d;
        }
        if (TextUtils.isEmpty(g2)) {
            if (obj instanceof d.a) {
                d.a aVar = (d.a) obj;
                aVar.f60106b.setVisibility(0);
                aVar.f60105a.setDrawBorder(false);
                aVar.f60105a.invalidate();
                this.k = true;
                d.a.k0.q3.j.f.a.h().f(musicData.id, musicData.resource, new a(aVar, musicData));
                return;
            }
            d.a.k0.q3.j.f.a.h().f(musicData.id, musicData.resource, new b(musicData));
            return;
        }
        p(g2, musicData);
    }

    public void r() {
        MediaPlayer mediaPlayer = this.f60148e;
        if (mediaPlayer != null) {
            if (mediaPlayer.isPlaying()) {
                this.f60148e.stop();
            }
            this.f60148e.release();
            this.f60148e = null;
        }
        this.f60151h = null;
        this.f60150g = null;
    }

    public final void s(String str, MusicData musicData) {
        this.f60151h = null;
        r();
        if (str.startsWith("/")) {
            File file = new File(str);
            if (file.exists()) {
                file.delete();
            }
            d.a.k0.q3.j.f.a.h().e();
        }
        q(null, musicData);
    }

    public void t(SelectMusicModel selectMusicModel) {
    }
}
