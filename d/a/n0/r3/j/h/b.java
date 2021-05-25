package d.a.n0.r3.j.h;

import android.text.TextUtils;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.coreExtra.data.VideoInfo;
import com.baidu.tieba.R;
import com.baidu.tieba.video.editvideo.data.MusicData;
import com.baidu.tieba.video.editvideo.model.SelectMusicModel;
import d.a.n0.r3.j.d.b;
import java.util.List;
/* loaded from: classes5.dex */
public class b implements d.a.n0.r3.j.b, b.c, d.a.n0.d0.b {

    /* renamed from: e  reason: collision with root package name */
    public BaseActivity f60151e;

    /* renamed from: f  reason: collision with root package name */
    public d.a.n0.r3.b f60152f;

    /* renamed from: g  reason: collision with root package name */
    public d.a.n0.r3.j.d.a f60153g;

    /* renamed from: h  reason: collision with root package name */
    public SelectMusicModel f60154h;

    /* renamed from: i  reason: collision with root package name */
    public String f60155i;

    public b(d.a.n0.r3.b bVar) {
        this.f60152f = bVar;
        this.f60151e = bVar.f59985a;
    }

    @Override // d.a.n0.r3.j.d.b.c
    public void a(int i2, String str) {
        d.a.n0.r3.b bVar = this.f60152f;
        if (bVar != null) {
            bVar.d(i2, str);
        }
    }

    @Override // d.a.n0.r3.j.d.b.c
    public void b(String str) {
        d.a.n0.r3.b bVar = this.f60152f;
        if (bVar != null) {
            bVar.e();
        }
        d(str);
    }

    @Override // d.a.n0.r3.j.d.b.c
    public void c(int i2, String str) {
        d.a.n0.r3.b bVar = this.f60152f;
        if (bVar != null) {
            bVar.d(i2, str);
        }
    }

    @Override // d.a.n0.d0.b
    public void cancel() {
        d.a.n0.r3.b bVar = this.f60152f;
        if (bVar != null) {
            bVar.i(true);
        }
        d.a.n0.r3.j.d.a aVar = this.f60153g;
        if (aVar == null || !aVar.f()) {
            return;
        }
        this.f60153g.e();
    }

    public final void d(String str) {
        d.a.n0.r3.b bVar = this.f60152f;
        if (bVar == null) {
            return;
        }
        if (bVar.b()) {
            this.f60152f.c();
            this.f60152f = null;
            return;
        }
        this.f60155i = str;
        VideoInfo videoInfo = new VideoInfo();
        videoInfo.setVideoPath(this.f60155i);
        videoInfo.setThumbPath(this.f60152f.f59987c);
        d.a.n0.r3.b bVar2 = this.f60152f;
        if (bVar2 != null) {
            bVar2.f(videoInfo);
        }
    }

    public void e() {
        d.a.n0.r3.b bVar = this.f60152f;
        if (bVar == null) {
            return;
        }
        if (bVar.b()) {
            this.f60152f.c();
            this.f60152f = null;
            return;
        }
        if (StringUtils.isNull(this.f60152f.f59988d)) {
            d.a.n0.r3.b bVar2 = this.f60152f;
            if (!bVar2.f59989e) {
                onSaveMusicVideo(bVar2.f59986b, -4399, "");
                return;
            }
        }
        if (this.f60154h == null) {
            this.f60154h = new SelectMusicModel(this.f60151e.getPageContext(), this);
        }
        SelectMusicModel selectMusicModel = this.f60154h;
        d.a.n0.r3.b bVar3 = this.f60152f;
        selectMusicModel.v(bVar3.f59986b, bVar3.f59988d, d.a.n0.r3.c.f59995c + "video_" + System.currentTimeMillis() + ".mp4", !bVar3.f59989e);
    }

    @Override // d.a.n0.r3.j.b
    public void onSaveMusicVideo(String str, int i2, String str2) {
        d.a.n0.r3.b bVar = this.f60152f;
        if (bVar != null && bVar.b()) {
            this.f60152f.c();
            this.f60152f = null;
        } else if (TextUtils.isEmpty(str)) {
            this.f60151e.showToast(R.string.mixing_fail);
            d.a.n0.r3.b bVar2 = this.f60152f;
            if (bVar2 != null) {
                bVar2.g(i2, str2);
            }
        } else {
            d.a.n0.r3.b bVar3 = this.f60152f;
            if (bVar3 != null) {
                bVar3.h();
            }
            if (!StringUtils.isNull(this.f60152f.f59990f)) {
                if (!StringHelper.equals(str, this.f60152f.f59986b)) {
                    this.f60152f.f59991g = str;
                }
                if (this.f60153g == null) {
                    d.a.n0.r3.j.d.a aVar = new d.a.n0.r3.j.d.a(this.f60151e.getActivity());
                    this.f60153g = aVar;
                    aVar.i(this);
                }
                this.f60153g.g(str, this.f60152f.f59990f);
                return;
            }
            d.a.n0.r3.b bVar4 = this.f60152f;
            if (bVar4 != null) {
                bVar4.e();
            }
            d(str);
        }
    }

    @Override // d.a.n0.r3.j.b
    public void setMusicData(List<MusicData> list) {
    }

    @Override // d.a.n0.d0.b
    public void start() {
        e();
    }
}
