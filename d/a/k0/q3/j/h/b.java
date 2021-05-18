package d.a.k0.q3.j.h;

import android.text.TextUtils;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.coreExtra.data.VideoInfo;
import com.baidu.tieba.R;
import com.baidu.tieba.video.editvideo.data.MusicData;
import com.baidu.tieba.video.editvideo.model.SelectMusicModel;
import d.a.k0.q3.j.d.b;
import java.util.List;
/* loaded from: classes5.dex */
public class b implements d.a.k0.q3.j.b, b.c, d.a.k0.b0.b {

    /* renamed from: e  reason: collision with root package name */
    public BaseActivity f60010e;

    /* renamed from: f  reason: collision with root package name */
    public d.a.k0.q3.b f60011f;

    /* renamed from: g  reason: collision with root package name */
    public d.a.k0.q3.j.d.a f60012g;

    /* renamed from: h  reason: collision with root package name */
    public SelectMusicModel f60013h;

    /* renamed from: i  reason: collision with root package name */
    public String f60014i;

    public b(d.a.k0.q3.b bVar) {
        this.f60011f = bVar;
        this.f60010e = bVar.f59844a;
    }

    @Override // d.a.k0.q3.j.d.b.c
    public void a(int i2, String str) {
        d.a.k0.q3.b bVar = this.f60011f;
        if (bVar != null) {
            bVar.d(i2, str);
        }
    }

    @Override // d.a.k0.q3.j.d.b.c
    public void b(String str) {
        d.a.k0.q3.b bVar = this.f60011f;
        if (bVar != null) {
            bVar.e();
        }
        d(str);
    }

    @Override // d.a.k0.q3.j.d.b.c
    public void c(int i2, String str) {
        d.a.k0.q3.b bVar = this.f60011f;
        if (bVar != null) {
            bVar.d(i2, str);
        }
    }

    @Override // d.a.k0.b0.b
    public void cancel() {
        d.a.k0.q3.b bVar = this.f60011f;
        if (bVar != null) {
            bVar.i(true);
        }
        d.a.k0.q3.j.d.a aVar = this.f60012g;
        if (aVar == null || !aVar.f()) {
            return;
        }
        this.f60012g.e();
    }

    public final void d(String str) {
        d.a.k0.q3.b bVar = this.f60011f;
        if (bVar == null) {
            return;
        }
        if (bVar.b()) {
            this.f60011f.c();
            this.f60011f = null;
            return;
        }
        this.f60014i = str;
        VideoInfo videoInfo = new VideoInfo();
        videoInfo.setVideoPath(this.f60014i);
        videoInfo.setThumbPath(this.f60011f.f59846c);
        d.a.k0.q3.b bVar2 = this.f60011f;
        if (bVar2 != null) {
            bVar2.f(videoInfo);
        }
    }

    public void e() {
        d.a.k0.q3.b bVar = this.f60011f;
        if (bVar == null) {
            return;
        }
        if (bVar.b()) {
            this.f60011f.c();
            this.f60011f = null;
            return;
        }
        if (StringUtils.isNull(this.f60011f.f59847d)) {
            d.a.k0.q3.b bVar2 = this.f60011f;
            if (!bVar2.f59848e) {
                onSaveMusicVideo(bVar2.f59845b, -4399, "");
                return;
            }
        }
        if (this.f60013h == null) {
            this.f60013h = new SelectMusicModel(this.f60010e.getPageContext(), this);
        }
        SelectMusicModel selectMusicModel = this.f60013h;
        d.a.k0.q3.b bVar3 = this.f60011f;
        selectMusicModel.v(bVar3.f59845b, bVar3.f59847d, d.a.k0.q3.c.f59854c + "video_" + System.currentTimeMillis() + ".mp4", !bVar3.f59848e);
    }

    @Override // d.a.k0.q3.j.b
    public void onSaveMusicVideo(String str, int i2, String str2) {
        d.a.k0.q3.b bVar = this.f60011f;
        if (bVar != null && bVar.b()) {
            this.f60011f.c();
            this.f60011f = null;
        } else if (TextUtils.isEmpty(str)) {
            this.f60010e.showToast(R.string.mixing_fail);
            d.a.k0.q3.b bVar2 = this.f60011f;
            if (bVar2 != null) {
                bVar2.g(i2, str2);
            }
        } else {
            d.a.k0.q3.b bVar3 = this.f60011f;
            if (bVar3 != null) {
                bVar3.h();
            }
            if (!StringUtils.isNull(this.f60011f.f59849f)) {
                if (!StringHelper.equals(str, this.f60011f.f59845b)) {
                    this.f60011f.f59850g = str;
                }
                if (this.f60012g == null) {
                    d.a.k0.q3.j.d.a aVar = new d.a.k0.q3.j.d.a(this.f60010e.getActivity());
                    this.f60012g = aVar;
                    aVar.i(this);
                }
                this.f60012g.g(str, this.f60011f.f59849f);
                return;
            }
            d.a.k0.q3.b bVar4 = this.f60011f;
            if (bVar4 != null) {
                bVar4.e();
            }
            d(str);
        }
    }

    @Override // d.a.k0.q3.j.b
    public void setMusicData(List<MusicData> list) {
    }

    @Override // d.a.k0.b0.b
    public void start() {
        e();
    }
}
