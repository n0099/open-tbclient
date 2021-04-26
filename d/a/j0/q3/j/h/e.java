package d.a.j0.q3.j.h;

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
import d.a.c.e.p.k;
import d.a.c.e.p.l;
import d.a.j0.q3.j.c.c;
import d.a.j0.q3.j.f.a;
import java.io.File;
import java.util.List;
/* loaded from: classes5.dex */
public class e extends d.a.c.a.d {

    /* renamed from: a  reason: collision with root package name */
    public View f59287a;

    /* renamed from: b  reason: collision with root package name */
    public HorizontalListView f59288b;

    /* renamed from: c  reason: collision with root package name */
    public Resources f59289c;

    /* renamed from: d  reason: collision with root package name */
    public d.a.j0.q3.j.h.a f59290d;

    /* renamed from: e  reason: collision with root package name */
    public d.a.j0.q3.j.c.c f59291e;

    /* renamed from: f  reason: collision with root package name */
    public LinearLayout f59292f;

    /* renamed from: g  reason: collision with root package name */
    public ImageView f59293g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f59294h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f59295i;
    public MediaPlayer j;
    public String k;
    public int l;
    public int m;
    public int n;
    public boolean o;
    public String p;
    public boolean q;
    public d.a.j0.t1.g r;
    public String s;
    public String t;

    /* loaded from: classes5.dex */
    public class a implements AdapterView.OnItemClickListener {
        public a() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j) {
            if (e.this.f59291e.b() != i2 || i2 == e.this.l) {
                e.this.m = i2;
                e.this.s(i2, view);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements a.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c.a f59297a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ int f59298b;

        public b(c.a aVar, int i2) {
            this.f59297a = aVar;
            this.f59298b = i2;
        }

        @Override // d.a.j0.q3.j.f.a.b
        public void a(String str) {
            this.f59297a.f59183b.setVisibility(4);
            l.M(e.this.mContext.getPageActivity(), str);
            if (e.this.r != null) {
                e.this.r.a(206, str);
            }
        }

        @Override // d.a.j0.q3.j.f.a.b
        public void b() {
            this.f59297a.f59183b.setVisibility(4);
        }

        @Override // d.a.j0.q3.j.f.a.b
        public void c(String str, String str2) {
            if (!TextUtils.isEmpty(str2)) {
                str = str2;
            }
            this.f59297a.f59183b.setVisibility(4);
            e.this.G(str, this.f59298b);
        }
    }

    /* loaded from: classes5.dex */
    public class c implements a.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ int f59300a;

        public c(int i2) {
            this.f59300a = i2;
        }

        @Override // d.a.j0.q3.j.f.a.b
        public void a(String str) {
            l.M(e.this.mContext.getPageActivity(), str);
            if (e.this.r != null) {
                e.this.r.a(206, str);
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
            e.this.G(str, this.f59300a);
        }
    }

    /* loaded from: classes5.dex */
    public class d implements MediaPlayer.OnPreparedListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f59302e;

        public d(int i2) {
            this.f59302e = i2;
        }

        @Override // android.media.MediaPlayer.OnPreparedListener
        public void onPrepared(MediaPlayer mediaPlayer) {
            e.this.f59291e.d(this.f59302e);
            e.this.j.setLooping(true);
        }
    }

    /* renamed from: d.a.j0.q3.j.h.e$e  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C1492e implements MediaPlayer.OnErrorListener {
        public C1492e() {
        }

        @Override // android.media.MediaPlayer.OnErrorListener
        public boolean onError(MediaPlayer mediaPlayer, int i2, int i3) {
            if (e.this.r != null) {
                d.a.j0.t1.g gVar = e.this.r;
                gVar.a(207, "what-->" + i2 + "  extra-->" + i3);
                return false;
            }
            return false;
        }
    }

    /* loaded from: classes5.dex */
    public class f implements MediaPlayer.OnPreparedListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f59305e;

        public f(int i2) {
            this.f59305e = i2;
        }

        @Override // android.media.MediaPlayer.OnPreparedListener
        public void onPrepared(MediaPlayer mediaPlayer) {
            e.this.f59291e.d(this.f59305e);
            e.this.j.setLooping(true);
            e.this.j.start();
            e.this.f59290d.Q();
        }
    }

    /* loaded from: classes5.dex */
    public class g implements MediaPlayer.OnErrorListener {
        public g() {
        }

        @Override // android.media.MediaPlayer.OnErrorListener
        public boolean onError(MediaPlayer mediaPlayer, int i2, int i3) {
            if (e.this.r != null) {
                d.a.j0.t1.g gVar = e.this.r;
                gVar.a(207, "what-->" + i2 + "  extra-->" + i3);
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
            eVar.O(!eVar.f59295i);
            e.this.f59290d.Y(!e.this.f59295i);
            e.this.K();
            StatisticItem statisticItem = new StatisticItem("c12423");
            statisticItem.param("obj_type", !e.this.f59295i ? 1 : 0);
            TiebaStatic.log(statisticItem);
        }
    }

    /* loaded from: classes5.dex */
    public class i implements Runnable {
        public i() {
        }

        @Override // java.lang.Runnable
        public void run() {
            e.this.f59288b.setSelection(e.this.n);
            e.this.f59288b.v(e.this.m * l.g(e.this.getPageContext().getContext(), R.dimen.ds122));
        }
    }

    public e(d.a.c.a.f fVar, d.a.j0.q3.j.h.a aVar, d.a.j0.t1.g gVar) {
        super(fVar);
        this.f59295i = true;
        this.l = 1;
        this.f59290d = aVar;
        this.r = gVar;
        View inflate = LayoutInflater.from(fVar.getPageActivity()).inflate(R.layout.edit_music_layout, (ViewGroup) null);
        this.f59287a = inflate;
        this.f59289c = inflate.getResources();
        x();
    }

    public void A() {
        this.o = true;
        MediaPlayer mediaPlayer = this.j;
        if (mediaPlayer == null || !mediaPlayer.isPlaying()) {
            return;
        }
        this.j.pause();
    }

    public void B() {
        this.o = false;
        MediaPlayer mediaPlayer = this.j;
        if (mediaPlayer == null || this.f59290d.l != 2) {
            return;
        }
        mediaPlayer.start();
        this.j.seekTo(0);
    }

    public void F(boolean z) {
        if (z) {
            this.f59292f.setVisibility(0);
            if (this.q && this.j == null && !TextUtils.isEmpty(this.k)) {
                G(this.k, this.n);
                this.q = false;
                if (this.n > 4) {
                    new Handler().postDelayed(new i(), 300L);
                    return;
                }
                return;
            }
            K();
            return;
        }
        this.f59292f.setVisibility(8);
        A();
    }

    public final void G(String str, int i2) {
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
                L(str, i2);
                d.a.j0.t1.g gVar = this.r;
                if (gVar != null) {
                    gVar.a(208, d.a.j0.t1.a.a(e2));
                }
            }
        }
    }

    public final void H(int i2, View view, MusicData musicData) {
        if (musicData == null || TextUtils.isEmpty(musicData.resource)) {
            return;
        }
        this.p = musicData.id;
        this.f59290d.r();
        String g2 = d.a.j0.q3.j.f.a.h().g(musicData.resource);
        if (!TextUtils.isEmpty(g2)) {
            G(g2, i2);
        } else if (view != null) {
            c.a aVar = (c.a) view.getTag();
            aVar.f59183b.setVisibility(0);
            d.a.j0.q3.j.f.a.h().f(musicData.id, musicData.resource, new b(aVar, i2));
        } else {
            d.a.j0.q3.j.f.a.h().f(musicData.id, musicData.resource, new c(i2));
        }
    }

    public final void I(int i2) {
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
                this.j.setOnErrorListener(new C1492e());
            } catch (Exception e2) {
                e2.printStackTrace();
                L(this.k, i2);
                if (this.r != null) {
                    this.r.a(208, d.a.j0.t1.a.a(e2));
                }
            }
        } finally {
            this.t = null;
            this.s = null;
        }
    }

    public final void J() {
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

    public void K() {
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

    public final void L(String str, int i2) {
        this.k = null;
        J();
        if (str.startsWith("/")) {
            File file = new File(str);
            if (file.exists()) {
                file.delete();
            }
            d.a.j0.q3.j.f.a.h().e();
        }
        H(i2, this.f59288b.getChildCount() > i2 ? this.f59288b.getChildAt(i2) : null, (MusicData) this.f59291e.getItem(i2));
    }

    public void N(List<MusicData> list) {
        this.f59291e.f(list);
        d.a.j0.q3.j.c.c cVar = this.f59291e;
        if (cVar != null) {
            int b2 = cVar.b();
            this.n = b2;
            this.m = b2;
        }
        R();
    }

    public void O(boolean z) {
        this.f59295i = z;
        if (z) {
            this.f59293g.setSelected(false);
            this.f59294h.setText(this.f59289c.getString(R.string.video_voice_open));
            return;
        }
        this.f59293g.setSelected(true);
        this.f59294h.setText(this.f59289c.getString(R.string.video_voice_close));
    }

    public void P(Intent intent) {
        if (intent == null || intent.getStringExtra(EditVideoActivityConfig.LOCAL_PATH_KEY) == null || intent.getStringExtra(EditVideoActivityConfig.MUSIC_ID_KEY) == null) {
            return;
        }
        this.q = true;
        this.p = intent.getStringExtra(EditVideoActivityConfig.MUSIC_ID_KEY);
        this.k = intent.getStringExtra(EditVideoActivityConfig.LOCAL_PATH_KEY);
        d.a.j0.q3.j.c.c cVar = this.f59291e;
        if (cVar != null) {
            cVar.e(this.p);
            int b2 = this.f59291e.b();
            this.n = b2;
            this.l = b2;
            this.m = b2;
        }
    }

    public void Q(String str, String str2) {
        this.s = str;
        this.t = str2;
        R();
    }

    public final void R() {
        if (k.isEmpty(this.t) || k.isEmpty(this.s)) {
            return;
        }
        List<MusicData> c2 = this.f59291e.c();
        if (ListUtils.isEmpty(c2)) {
            return;
        }
        for (int i2 = 0; i2 < c2.size(); i2++) {
            if (c2.get(i2) != null && StringHelper.equals(c2.get(i2).id, this.t)) {
                I(i2);
                return;
            }
        }
        I(1);
    }

    public final void s(int i2, View view) {
        MusicData musicData = (MusicData) this.f59291e.getItem(i2);
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
            H(i2, view, musicData);
        } else if (i3 == 1) {
            this.f59291e.d(i2);
            J();
            this.f59290d.Q();
        } else if (i3 != 2) {
        } else {
            this.l = i2;
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new CloudMusicActivityConfig(this.mContext.getPageActivity(), 25032)));
        }
    }

    public String t() {
        return this.p;
    }

    public String u() {
        return this.k;
    }

    public View v() {
        return this.f59287a;
    }

    public void w(View view) {
        this.f59292f = (LinearLayout) view.findViewById(R.id.video_voice_layout);
        this.f59293g = (ImageView) view.findViewById(R.id.video_voice_img);
        this.f59294h = (TextView) view.findViewById(R.id.video_voice_text);
        this.f59292f.setVisibility(8);
        this.f59292f.setOnClickListener(new h());
        O(this.f59295i);
        this.f59290d.Y(!this.f59295i);
    }

    public final void x() {
        this.f59288b = (HorizontalListView) this.f59287a.findViewById(R.id.horizontal_list);
        d.a.j0.q3.j.c.c cVar = new d.a.j0.q3.j.c.c(this.mContext);
        this.f59291e = cVar;
        this.f59288b.setAdapter((ListAdapter) cVar);
        this.f59288b.setOnItemClickListener(new a());
    }

    public void y(d.a.c.a.f fVar, int i2) {
        SkinManager.setBackgroundColor(this.f59287a, R.color.CAM_X0201);
    }

    public void z(String str, String str2) {
        this.o = false;
        int i2 = this.l;
        this.m = i2;
        this.p = str2;
        G(str, i2);
    }
}
