package d.b.j0.q3.j.h;

import android.text.TextUtils;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.coreExtra.data.VideoInfo;
import com.baidu.tieba.R;
import com.baidu.tieba.video.editvideo.data.MusicData;
import com.baidu.tieba.video.editvideo.model.SelectMusicModel;
import d.b.j0.q3.j.d.b;
import java.util.List;
/* loaded from: classes5.dex */
public class b implements d.b.j0.q3.j.b, b.c, d.b.j0.b0.b {

    /* renamed from: e  reason: collision with root package name */
    public BaseActivity f61129e;

    /* renamed from: f  reason: collision with root package name */
    public d.b.j0.q3.b f61130f;

    /* renamed from: g  reason: collision with root package name */
    public d.b.j0.q3.j.d.a f61131g;

    /* renamed from: h  reason: collision with root package name */
    public SelectMusicModel f61132h;
    public String i;

    public b(d.b.j0.q3.b bVar) {
        this.f61130f = bVar;
        this.f61129e = bVar.f60969a;
    }

    @Override // d.b.j0.q3.j.d.b.c
    public void a(int i, String str) {
        d.b.j0.q3.b bVar = this.f61130f;
        if (bVar != null) {
            bVar.d(i, str);
        }
    }

    @Override // d.b.j0.q3.j.d.b.c
    public void b(String str) {
        d.b.j0.q3.b bVar = this.f61130f;
        if (bVar != null) {
            bVar.e();
        }
        d(str);
    }

    @Override // d.b.j0.q3.j.d.b.c
    public void c(int i, String str) {
        d.b.j0.q3.b bVar = this.f61130f;
        if (bVar != null) {
            bVar.d(i, str);
        }
    }

    @Override // d.b.j0.b0.b
    public void cancel() {
        d.b.j0.q3.b bVar = this.f61130f;
        if (bVar != null) {
            bVar.i(true);
        }
        d.b.j0.q3.j.d.a aVar = this.f61131g;
        if (aVar == null || !aVar.f()) {
            return;
        }
        this.f61131g.e();
    }

    public final void d(String str) {
        d.b.j0.q3.b bVar = this.f61130f;
        if (bVar == null) {
            return;
        }
        if (bVar.b()) {
            this.f61130f.c();
            this.f61130f = null;
            return;
        }
        this.i = str;
        VideoInfo videoInfo = new VideoInfo();
        videoInfo.setVideoPath(this.i);
        videoInfo.setThumbPath(this.f61130f.f60971c);
        d.b.j0.q3.b bVar2 = this.f61130f;
        if (bVar2 != null) {
            bVar2.f(videoInfo);
        }
    }

    public void e() {
        d.b.j0.q3.b bVar = this.f61130f;
        if (bVar == null) {
            return;
        }
        if (bVar.b()) {
            this.f61130f.c();
            this.f61130f = null;
            return;
        }
        if (StringUtils.isNull(this.f61130f.f60972d)) {
            d.b.j0.q3.b bVar2 = this.f61130f;
            if (!bVar2.f60973e) {
                onSaveMusicVideo(bVar2.f60970b, -4399, "");
                return;
            }
        }
        if (this.f61132h == null) {
            this.f61132h = new SelectMusicModel(this.f61129e.getPageContext(), this);
        }
        SelectMusicModel selectMusicModel = this.f61132h;
        d.b.j0.q3.b bVar3 = this.f61130f;
        selectMusicModel.v(bVar3.f60970b, bVar3.f60972d, d.b.j0.q3.c.f60979c + "video_" + System.currentTimeMillis() + ".mp4", !bVar3.f60973e);
    }

    @Override // d.b.j0.q3.j.b
    public void onSaveMusicVideo(String str, int i, String str2) {
        d.b.j0.q3.b bVar = this.f61130f;
        if (bVar != null && bVar.b()) {
            this.f61130f.c();
            this.f61130f = null;
        } else if (TextUtils.isEmpty(str)) {
            this.f61129e.showToast(R.string.mixing_fail);
            d.b.j0.q3.b bVar2 = this.f61130f;
            if (bVar2 != null) {
                bVar2.g(i, str2);
            }
        } else {
            d.b.j0.q3.b bVar3 = this.f61130f;
            if (bVar3 != null) {
                bVar3.h();
            }
            if (!StringUtils.isNull(this.f61130f.f60974f)) {
                if (!StringHelper.equals(str, this.f61130f.f60970b)) {
                    this.f61130f.f60975g = str;
                }
                if (this.f61131g == null) {
                    d.b.j0.q3.j.d.a aVar = new d.b.j0.q3.j.d.a(this.f61129e.getActivity());
                    this.f61131g = aVar;
                    aVar.i(this);
                }
                this.f61131g.g(str, this.f61130f.f60974f);
                return;
            }
            d.b.j0.q3.b bVar4 = this.f61130f;
            if (bVar4 != null) {
                bVar4.e();
            }
            d(str);
        }
    }

    @Override // d.b.j0.q3.j.b
    public void setMusicData(List<MusicData> list) {
    }

    @Override // d.b.j0.b0.b
    public void start() {
        e();
    }
}
