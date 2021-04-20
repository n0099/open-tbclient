package d.b.i0.q3.j.h;

import android.content.Intent;
import android.content.res.Resources;
import android.media.MediaPlayer;
import android.os.Handler;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.CloudMusicActivityConfig;
import com.baidu.tbadk.core.atomData.EditVideoActivityConfig;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.HorizontalListView;
import com.baidu.tieba.R;
import com.baidu.tieba.video.editvideo.data.MusicData;
import d.b.c.e.p.k;
import d.b.c.e.p.l;
import d.b.i0.q3.j.c.c;
import d.b.i0.q3.j.f.a;
import java.io.File;
import java.util.List;
/* loaded from: classes5.dex */
public class e extends d.b.c.a.d {

    /* renamed from: a  reason: collision with root package name */
    public View f60729a;

    /* renamed from: b  reason: collision with root package name */
    public HorizontalListView f60730b;

    /* renamed from: c  reason: collision with root package name */
    public Resources f60731c;

    /* renamed from: d  reason: collision with root package name */
    public d.b.i0.q3.j.h.a f60732d;

    /* renamed from: e  reason: collision with root package name */
    public d.b.i0.q3.j.c.c f60733e;

    /* renamed from: f  reason: collision with root package name */
    public LinearLayout f60734f;

    /* renamed from: g  reason: collision with root package name */
    public ImageView f60735g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f60736h;
    public boolean i;
    public MediaPlayer j;
    public String k;
    public int l;
    public int m;
    public int n;
    public boolean o;
    public String p;
    public boolean q;
    public d.b.i0.t1.g r;
    public String s;
    public String t;

    /* loaded from: classes5.dex */
    public class a implements AdapterView.OnItemClickListener {
        public a() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            if (e.this.f60733e.b() != i || i == e.this.l) {
                e.this.m = i;
                e.this.u(i, view);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements a.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c.a f60738a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ int f60739b;

        public b(c.a aVar, int i) {
            this.f60738a = aVar;
            this.f60739b = i;
        }

        @Override // d.b.i0.q3.j.f.a.b
        public void a(String str) {
            this.f60738a.f60631b.setVisibility(4);
            l.L(e.this.mContext.getPageActivity(), str);
            if (e.this.r != null) {
                e.this.r.a(206, str);
            }
        }

        @Override // d.b.i0.q3.j.f.a.b
        public void b() {
            this.f60738a.f60631b.setVisibility(4);
        }

        @Override // d.b.i0.q3.j.f.a.b
        public void c(String str, String str2) {
            if (!TextUtils.isEmpty(str2)) {
                str = str2;
            }
            this.f60738a.f60631b.setVisibility(4);
            e.this.I(str, this.f60739b);
        }
    }

    /* loaded from: classes5.dex */
    public class c implements a.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ int f60741a;

        public c(int i) {
            this.f60741a = i;
        }

        @Override // d.b.i0.q3.j.f.a.b
        public void a(String str) {
            l.L(e.this.mContext.getPageActivity(), str);
            if (e.this.r != null) {
                e.this.r.a(206, str);
            }
        }

        @Override // d.b.i0.q3.j.f.a.b
        public void b() {
        }

        @Override // d.b.i0.q3.j.f.a.b
        public void c(String str, String str2) {
            if (!TextUtils.isEmpty(str2)) {
                str = str2;
            }
            e.this.I(str, this.f60741a);
        }
    }

    /* loaded from: classes5.dex */
    public class d implements MediaPlayer.OnPreparedListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f60743e;

        public d(int i) {
            this.f60743e = i;
        }

        @Override // android.media.MediaPlayer.OnPreparedListener
        public void onPrepared(MediaPlayer mediaPlayer) {
            e.this.f60733e.d(this.f60743e);
            e.this.j.setLooping(true);
        }
    }

    /* renamed from: d.b.i0.q3.j.h.e$e  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C1530e implements MediaPlayer.OnErrorListener {
        public C1530e() {
        }

        @Override // android.media.MediaPlayer.OnErrorListener
        public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
            if (e.this.r != null) {
                d.b.i0.t1.g gVar = e.this.r;
                gVar.a(207, "what-->" + i + "  extra-->" + i2);
                return false;
            }
            return false;
        }
    }

    /* loaded from: classes5.dex */
    public class f implements MediaPlayer.OnPreparedListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f60746e;

        public f(int i) {
            this.f60746e = i;
        }

        @Override // android.media.MediaPlayer.OnPreparedListener
        public void onPrepared(MediaPlayer mediaPlayer) {
            e.this.f60733e.d(this.f60746e);
            e.this.j.setLooping(true);
            e.this.j.start();
            e.this.f60732d.S();
        }
    }

    /* loaded from: classes5.dex */
    public class g implements MediaPlayer.OnErrorListener {
        public g() {
        }

        @Override // android.media.MediaPlayer.OnErrorListener
        public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
            if (e.this.r != null) {
                d.b.i0.t1.g gVar = e.this.r;
                gVar.a(207, "what-->" + i + "  extra-->" + i2);
                return false;
            }
            return false;
        }
    }

    /* loaded from: classes5.dex */
    public class h implements View.OnClickListener {
        public h() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            e eVar = e.this;
            eVar.Q(!eVar.i);
            e.this.f60732d.Y(!e.this.i);
            e.this.M();
            StatisticItem statisticItem = new StatisticItem("c12423");
            statisticItem.param("obj_type", !e.this.i ? 1 : 0);
            TiebaStatic.log(statisticItem);
        }
    }

    /* loaded from: classes5.dex */
    public class i implements Runnable {
        public i() {
        }

        @Override // java.lang.Runnable
        public void run() {
            e.this.f60730b.setSelection(e.this.n);
            e.this.f60730b.v(e.this.m * l.g(e.this.getPageContext().getContext(), R.dimen.ds122));
        }
    }

    public e(d.b.c.a.f fVar, d.b.i0.q3.j.h.a aVar, d.b.i0.t1.g gVar) {
        super(fVar);
        this.i = true;
        this.l = 1;
        this.f60732d = aVar;
        this.r = gVar;
        View inflate = LayoutInflater.from(fVar.getPageActivity()).inflate(R.layout.edit_music_layout, (ViewGroup) null);
        this.f60729a = inflate;
        this.f60731c = inflate.getResources();
        z();
    }

    public void A(d.b.c.a.f fVar, int i2) {
        SkinManager.setBackgroundColor(this.f60729a, R.color.CAM_X0201);
    }

    public void B(String str, String str2) {
        this.o = false;
        int i2 = this.l;
        this.m = i2;
        this.p = str2;
        I(str, i2);
    }

    public void E() {
        this.o = true;
        MediaPlayer mediaPlayer = this.j;
        if (mediaPlayer == null || !mediaPlayer.isPlaying()) {
            return;
        }
        this.j.pause();
    }

    public void F() {
        this.o = false;
        MediaPlayer mediaPlayer = this.j;
        if (mediaPlayer == null || this.f60732d.l != 2) {
            return;
        }
        mediaPlayer.start();
        this.j.seekTo(0);
    }

    public void G(boolean z) {
        if (z) {
            this.f60734f.setVisibility(0);
            if (this.q && this.j == null && !TextUtils.isEmpty(this.k)) {
                I(this.k, this.n);
                this.q = false;
                if (this.n > 4) {
                    new Handler().postDelayed(new i(), 300L);
                    return;
                }
                return;
            }
            M();
            return;
        }
        this.f60734f.setVisibility(8);
        E();
    }

    public final void I(String str, int i2) {
        this.n = i2;
        if (this.m == i2 && !this.o) {
            if (this.j == null) {
                MediaPlayer mediaPlayer = new MediaPlayer();
                this.j = mediaPlayer;
                mediaPlayer.setAudioStreamType(3);
            }
            try {
                this.k = str;
                this.j.reset();
                this.j.setDataSource(str);
                this.j.prepare();
                this.j.setOnPreparedListener(new f(i2));
                this.j.setOnErrorListener(new g());
            } catch (Exception e2) {
                e2.printStackTrace();
                O(str, i2);
                d.b.i0.t1.g gVar = this.r;
                if (gVar != null) {
                    gVar.a(208, d.b.i0.t1.a.a(e2));
                }
            }
        }
    }

    public final void J(int i2, View view, MusicData musicData) {
        if (musicData == null || TextUtils.isEmpty(musicData.resource)) {
            return;
        }
        this.p = musicData.id;
        this.f60732d.s();
        String g2 = d.b.i0.q3.j.f.a.h().g(musicData.resource);
        if (!TextUtils.isEmpty(g2)) {
            I(g2, i2);
        } else if (view != null) {
            c.a aVar = (c.a) view.getTag();
            aVar.f60631b.setVisibility(0);
            d.b.i0.q3.j.f.a.h().f(musicData.id, musicData.resource, new b(aVar, i2));
        } else {
            d.b.i0.q3.j.f.a.h().f(musicData.id, musicData.resource, new c(i2));
        }
    }

    public final void K(int i2) {
        if (k.isEmpty(this.s)) {
            return;
        }
        this.n = i2;
        if (this.j == null) {
            MediaPlayer mediaPlayer = new MediaPlayer();
            this.j = mediaPlayer;
            mediaPlayer.setAudioStreamType(3);
        }
        try {
            try {
                this.p = this.t;
                this.k = this.s;
                this.j.reset();
                this.j.setDataSource(this.s);
                this.j.prepare();
                this.j.setOnPreparedListener(new d(i2));
                this.j.setOnErrorListener(new C1530e());
            } catch (Exception e2) {
                e2.printStackTrace();
                O(this.k, i2);
                if (this.r != null) {
                    this.r.a(208, d.b.i0.t1.a.a(e2));
                }
            }
        } finally {
            this.t = null;
            this.s = null;
        }
    }

    public final void L() {
        MediaPlayer mediaPlayer = this.j;
        if (mediaPlayer != null) {
            if (mediaPlayer.isPlaying()) {
                this.j.stop();
            }
            this.j.release();
            this.j = null;
        }
        this.k = null;
        this.p = null;
    }

    public void M() {
        this.o = false;
        MediaPlayer mediaPlayer = this.j;
        if (mediaPlayer != null && mediaPlayer.isPlaying()) {
            this.j.pause();
        }
        MediaPlayer mediaPlayer2 = this.j;
        if (mediaPlayer2 != null) {
            mediaPlayer2.start();
            this.j.seekTo(0);
        }
    }

    public final void O(String str, int i2) {
        this.k = null;
        L();
        if (str.startsWith("/")) {
            File file = new File(str);
            if (file.exists()) {
                file.delete();
            }
            d.b.i0.q3.j.f.a.h().e();
        }
        J(i2, this.f60730b.getChildCount() > i2 ? this.f60730b.getChildAt(i2) : null, (MusicData) this.f60733e.getItem(i2));
    }

    public void P(List<MusicData> list) {
        this.f60733e.f(list);
        d.b.i0.q3.j.c.c cVar = this.f60733e;
        if (cVar != null) {
            int b2 = cVar.b();
            this.n = b2;
            this.m = b2;
        }
        T();
    }

    public void Q(boolean z) {
        this.i = z;
        if (z) {
            this.f60735g.setSelected(false);
            this.f60736h.setText(this.f60731c.getString(R.string.video_voice_open));
            return;
        }
        this.f60735g.setSelected(true);
        this.f60736h.setText(this.f60731c.getString(R.string.video_voice_close));
    }

    public void R(Intent intent) {
        if (intent == null || intent.getStringExtra(EditVideoActivityConfig.LOCAL_PATH_KEY) == null || intent.getStringExtra(EditVideoActivityConfig.MUSIC_ID_KEY) == null) {
            return;
        }
        this.q = true;
        this.p = intent.getStringExtra(EditVideoActivityConfig.MUSIC_ID_KEY);
        this.k = intent.getStringExtra(EditVideoActivityConfig.LOCAL_PATH_KEY);
        d.b.i0.q3.j.c.c cVar = this.f60733e;
        if (cVar != null) {
            cVar.e(this.p);
            int b2 = this.f60733e.b();
            this.n = b2;
            this.l = b2;
            this.m = b2;
        }
    }

    public void S(String str, String str2) {
        this.s = str;
        this.t = str2;
        T();
    }

    public final void T() {
        if (k.isEmpty(this.t) || k.isEmpty(this.s)) {
            return;
        }
        List<MusicData> c2 = this.f60733e.c();
        if (ListUtils.isEmpty(c2)) {
            return;
        }
        for (int i2 = 0; i2 < c2.size(); i2++) {
            if (c2.get(i2) != null && StringHelper.equals(c2.get(i2).id, this.t)) {
                K(i2);
                return;
            }
        }
        K(1);
    }

    public final void u(int i2, View view) {
        MusicData musicData = (MusicData) this.f60733e.getItem(i2);
        if (musicData == null) {
            return;
        }
        StatisticItem statisticItem = new StatisticItem("c12423");
        statisticItem.param("obj_id", musicData.id);
        statisticItem.param("obj_locate", i2 + 1);
        statisticItem.param("obj_source", 2);
        TiebaStatic.log(statisticItem);
        int i3 = musicData.editMusicType;
        if (i3 == 0) {
            J(i2, view, musicData);
        } else if (i3 == 1) {
            this.f60733e.d(i2);
            L();
            this.f60732d.S();
        } else if (i3 != 2) {
        } else {
            this.l = i2;
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new CloudMusicActivityConfig(this.mContext.getPageActivity(), 25032)));
        }
    }

    public String v() {
        return this.p;
    }

    public String w() {
        return this.k;
    }

    public View x() {
        return this.f60729a;
    }

    public void y(View view) {
        this.f60734f = (LinearLayout) view.findViewById(R.id.video_voice_layout);
        this.f60735g = (ImageView) view.findViewById(R.id.video_voice_img);
        this.f60736h = (TextView) view.findViewById(R.id.video_voice_text);
        this.f60734f.setVisibility(8);
        this.f60734f.setOnClickListener(new h());
        Q(this.i);
        this.f60732d.Y(!this.i);
    }

    public final void z() {
        this.f60730b = (HorizontalListView) this.f60729a.findViewById(R.id.horizontal_list);
        d.b.i0.q3.j.c.c cVar = new d.b.i0.q3.j.c.c(this.mContext);
        this.f60733e = cVar;
        this.f60730b.setAdapter((ListAdapter) cVar);
        this.f60730b.setOnItemClickListener(new a());
    }
}
