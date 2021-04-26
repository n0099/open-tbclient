package d.a.j0.q3.m;

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
import d.a.j0.q3.j.f.a;
import d.a.j0.q3.m.d;
import d.a.j0.q3.m.i;
import java.io.File;
/* loaded from: classes5.dex */
public class j implements i.b {

    /* renamed from: e  reason: collision with root package name */
    public MediaPlayer f59403e;

    /* renamed from: f  reason: collision with root package name */
    public int f59404f;

    /* renamed from: g  reason: collision with root package name */
    public String f59405g;

    /* renamed from: h  reason: collision with root package name */
    public String f59406h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f59407i;
    public Context j;
    public boolean k;
    public d.a.j0.t1.g l;

    /* loaded from: classes5.dex */
    public class a implements a.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.a f59408a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ MusicData f59409b;

        public a(d.a aVar, MusicData musicData) {
            this.f59408a = aVar;
            this.f59409b = musicData;
        }

        @Override // d.a.j0.q3.j.f.a.b
        public void a(String str) {
            if (this.f59408a.f59363d != j.this.f59404f) {
                return;
            }
            j.this.k = false;
            this.f59408a.f59361b.setVisibility(4);
            this.f59408a.f59360a.setDrawBorder(true);
            this.f59408a.f59360a.invalidate();
            d.a.c.e.p.l.M(TbadkCoreApplication.getInst(), str);
            if (j.this.l != null) {
                j.this.l.b(3, str);
            }
        }

        @Override // d.a.j0.q3.j.f.a.b
        public void b() {
            if (this.f59408a.f59363d != j.this.f59404f) {
                return;
            }
            j.this.k = false;
            this.f59408a.f59360a.setDrawBorder(true);
            this.f59408a.f59360a.invalidate();
            this.f59408a.f59361b.setVisibility(4);
        }

        @Override // d.a.j0.q3.j.f.a.b
        public void c(String str, String str2) {
            if (this.f59408a.f59363d != j.this.f59404f) {
                return;
            }
            j.this.k = false;
            if (!TextUtils.isEmpty(str2)) {
                str = str2;
            }
            j.this.p(str, this.f59409b);
            this.f59408a.f59361b.setVisibility(4);
            this.f59408a.f59360a.setDrawBorder(true);
            this.f59408a.f59360a.invalidate();
        }
    }

    /* loaded from: classes5.dex */
    public class b implements a.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ MusicData f59411a;

        public b(MusicData musicData) {
            this.f59411a = musicData;
        }

        @Override // d.a.j0.q3.j.f.a.b
        public void a(String str) {
            d.a.c.e.p.l.M(TbadkCoreApplication.getInst(), str);
            if (j.this.l != null) {
                j.this.l.b(3, str);
            }
        }

        @Override // d.a.j0.q3.j.f.a.b
        public void b() {
        }

        @Override // d.a.j0.q3.j.f.a.b
        public void c(String str, String str2) {
            if (!TextUtils.isEmpty(str2)) {
                str = str2;
            }
            j.this.p(str, this.f59411a);
        }
    }

    /* loaded from: classes5.dex */
    public class c implements MediaPlayer.OnPreparedListener {
        public c() {
        }

        @Override // android.media.MediaPlayer.OnPreparedListener
        public void onPrepared(MediaPlayer mediaPlayer) {
            j.this.f59403e.setLooping(true);
            j.this.f59403e.start();
        }
    }

    /* loaded from: classes5.dex */
    public class d implements MediaPlayer.OnErrorListener {
        public d() {
        }

        @Override // android.media.MediaPlayer.OnErrorListener
        public boolean onError(MediaPlayer mediaPlayer, int i2, int i3) {
            if (j.this.l != null) {
                d.a.j0.t1.g gVar = j.this.l;
                gVar.b(4, "what-->" + i2 + "  extra-->" + i3);
                return false;
            }
            return false;
        }
    }

    public j(Activity activity) {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921309, d.a.j0.t1.k.class);
        d.a.j0.t1.k kVar = runTask != null ? (d.a.j0.t1.k) runTask.getData() : null;
        if (kVar != null) {
            this.l = kVar.get();
        }
        this.j = activity;
    }

    @Override // d.a.j0.q3.m.i.b
    public void a(int i2) {
    }

    public void g(EditVideoActivityConfig editVideoActivityConfig) {
        if (TextUtils.isEmpty(this.f59406h) || TextUtils.isEmpty(this.f59405g)) {
            return;
        }
        editVideoActivityConfig.addMusicInfo(this.f59406h, this.f59405g, this.f59404f);
    }

    public String h() {
        return this.f59406h;
    }

    public boolean i() {
        return this.k;
    }

    public void j(String str, String str2) {
        this.f59407i = false;
        this.f59406h = str;
        this.f59405g = str2;
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
        this.f59407i = true;
        MediaPlayer mediaPlayer = this.f59403e;
        if (mediaPlayer == null || !mediaPlayer.isPlaying()) {
            return;
        }
        this.f59403e.pause();
    }

    public void m() {
        this.f59407i = false;
        MediaPlayer mediaPlayer = this.f59403e;
        if (mediaPlayer != null) {
            mediaPlayer.start();
            this.f59403e.seekTo(0);
        }
    }

    public void n(int i2) {
        MediaPlayer mediaPlayer = this.f59403e;
        if (mediaPlayer == null || mediaPlayer.getDuration() <= 0) {
            return;
        }
        if (i2 < 0) {
            i2 = 0;
        }
        if (i2 > this.f59403e.getDuration()) {
            i2 %= this.f59403e.getDuration();
        }
        this.f59403e.seekTo(i2);
        this.f59403e.start();
    }

    public void o() {
        MediaPlayer mediaPlayer = this.f59403e;
        if (mediaPlayer == null || !mediaPlayer.isPlaying()) {
            return;
        }
        this.f59403e.pause();
    }

    public final void p(String str, MusicData musicData) {
        if (this.f59407i) {
            return;
        }
        if (this.f59403e == null) {
            MediaPlayer mediaPlayer = new MediaPlayer();
            this.f59403e = mediaPlayer;
            mediaPlayer.setAudioStreamType(3);
        }
        try {
            this.f59406h = str;
            this.f59403e.reset();
            this.f59403e.setDataSource(str);
            this.f59403e.prepare();
            this.f59403e.setOnPreparedListener(new c());
            this.f59403e.setOnErrorListener(new d());
        } catch (Exception e2) {
            e2.printStackTrace();
            s(str, musicData);
        }
    }

    public final void q(Object obj, MusicData musicData) {
        if (musicData == null || TextUtils.isEmpty(musicData.resource)) {
            return;
        }
        MediaPlayer mediaPlayer = this.f59403e;
        if (mediaPlayer != null && mediaPlayer.isPlaying()) {
            this.f59403e.stop();
        }
        this.k = false;
        this.f59405g = musicData.id;
        String g2 = d.a.j0.q3.j.f.a.h().g(musicData.resource);
        if (obj != null && (obj instanceof d.a)) {
            this.f59404f = ((d.a) obj).f59363d;
        }
        if (TextUtils.isEmpty(g2)) {
            if (obj instanceof d.a) {
                d.a aVar = (d.a) obj;
                aVar.f59361b.setVisibility(0);
                aVar.f59360a.setDrawBorder(false);
                aVar.f59360a.invalidate();
                this.k = true;
                d.a.j0.q3.j.f.a.h().f(musicData.id, musicData.resource, new a(aVar, musicData));
                return;
            }
            d.a.j0.q3.j.f.a.h().f(musicData.id, musicData.resource, new b(musicData));
            return;
        }
        p(g2, musicData);
    }

    public void r() {
        MediaPlayer mediaPlayer = this.f59403e;
        if (mediaPlayer != null) {
            if (mediaPlayer.isPlaying()) {
                this.f59403e.stop();
            }
            this.f59403e.release();
            this.f59403e = null;
        }
        this.f59406h = null;
        this.f59405g = null;
    }

    public final void s(String str, MusicData musicData) {
        this.f59406h = null;
        r();
        if (str.startsWith("/")) {
            File file = new File(str);
            if (file.exists()) {
                file.delete();
            }
            d.a.j0.q3.j.f.a.h().e();
        }
        q(null, musicData);
    }

    public void t(SelectMusicModel selectMusicModel) {
    }
}
