package d.a.j0.q3.j.h;

import android.text.TextUtils;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.coreExtra.data.VideoInfo;
import com.baidu.tieba.R;
import com.baidu.tieba.video.editvideo.data.MusicData;
import com.baidu.tieba.video.editvideo.model.SelectMusicModel;
import d.a.j0.q3.j.d.b;
import java.util.List;
/* loaded from: classes5.dex */
public class b implements d.a.j0.q3.j.b, b.c, d.a.j0.b0.b {

    /* renamed from: e  reason: collision with root package name */
    public BaseActivity f59265e;

    /* renamed from: f  reason: collision with root package name */
    public d.a.j0.q3.b f59266f;

    /* renamed from: g  reason: collision with root package name */
    public d.a.j0.q3.j.d.a f59267g;

    /* renamed from: h  reason: collision with root package name */
    public SelectMusicModel f59268h;

    /* renamed from: i  reason: collision with root package name */
    public String f59269i;

    public b(d.a.j0.q3.b bVar) {
        this.f59266f = bVar;
        this.f59265e = bVar.f59099a;
    }

    @Override // d.a.j0.q3.j.d.b.c
    public void a(int i2, String str) {
        d.a.j0.q3.b bVar = this.f59266f;
        if (bVar != null) {
            bVar.d(i2, str);
        }
    }

    @Override // d.a.j0.q3.j.d.b.c
    public void b(String str) {
        d.a.j0.q3.b bVar = this.f59266f;
        if (bVar != null) {
            bVar.e();
        }
        d(str);
    }

    @Override // d.a.j0.q3.j.d.b.c
    public void c(int i2, String str) {
        d.a.j0.q3.b bVar = this.f59266f;
        if (bVar != null) {
            bVar.d(i2, str);
        }
    }

    @Override // d.a.j0.b0.b
    public void cancel() {
        d.a.j0.q3.b bVar = this.f59266f;
        if (bVar != null) {
            bVar.i(true);
        }
        d.a.j0.q3.j.d.a aVar = this.f59267g;
        if (aVar == null || !aVar.f()) {
            return;
        }
        this.f59267g.e();
    }

    public final void d(String str) {
        d.a.j0.q3.b bVar = this.f59266f;
        if (bVar == null) {
            return;
        }
        if (bVar.b()) {
            this.f59266f.c();
            this.f59266f = null;
            return;
        }
        this.f59269i = str;
        VideoInfo videoInfo = new VideoInfo();
        videoInfo.setVideoPath(this.f59269i);
        videoInfo.setThumbPath(this.f59266f.f59101c);
        d.a.j0.q3.b bVar2 = this.f59266f;
        if (bVar2 != null) {
            bVar2.f(videoInfo);
        }
    }

    public void e() {
        d.a.j0.q3.b bVar = this.f59266f;
        if (bVar == null) {
            return;
        }
        if (bVar.b()) {
            this.f59266f.c();
            this.f59266f = null;
            return;
        }
        if (StringUtils.isNull(this.f59266f.f59102d)) {
            d.a.j0.q3.b bVar2 = this.f59266f;
            if (!bVar2.f59103e) {
                onSaveMusicVideo(bVar2.f59100b, -4399, "");
                return;
            }
        }
        if (this.f59268h == null) {
            this.f59268h = new SelectMusicModel(this.f59265e.getPageContext(), this);
        }
        SelectMusicModel selectMusicModel = this.f59268h;
        d.a.j0.q3.b bVar3 = this.f59266f;
        selectMusicModel.v(bVar3.f59100b, bVar3.f59102d, d.a.j0.q3.c.f59109c + "video_" + System.currentTimeMillis() + ".mp4", !bVar3.f59103e);
    }

    @Override // d.a.j0.q3.j.b
    public void onSaveMusicVideo(String str, int i2, String str2) {
        d.a.j0.q3.b bVar = this.f59266f;
        if (bVar != null && bVar.b()) {
            this.f59266f.c();
            this.f59266f = null;
        } else if (TextUtils.isEmpty(str)) {
            this.f59265e.showToast(R.string.mixing_fail);
            d.a.j0.q3.b bVar2 = this.f59266f;
            if (bVar2 != null) {
                bVar2.g(i2, str2);
            }
        } else {
            d.a.j0.q3.b bVar3 = this.f59266f;
            if (bVar3 != null) {
                bVar3.h();
            }
            if (!StringUtils.isNull(this.f59266f.f59104f)) {
                if (!StringHelper.equals(str, this.f59266f.f59100b)) {
                    this.f59266f.f59105g = str;
                }
                if (this.f59267g == null) {
                    d.a.j0.q3.j.d.a aVar = new d.a.j0.q3.j.d.a(this.f59265e.getActivity());
                    this.f59267g = aVar;
                    aVar.i(this);
                }
                this.f59267g.g(str, this.f59266f.f59104f);
                return;
            }
            d.a.j0.q3.b bVar4 = this.f59266f;
            if (bVar4 != null) {
                bVar4.e();
            }
            d(str);
        }
    }

    @Override // d.a.j0.q3.j.b
    public void setMusicData(List<MusicData> list) {
    }

    @Override // d.a.j0.b0.b
    public void start() {
        e();
    }
}
