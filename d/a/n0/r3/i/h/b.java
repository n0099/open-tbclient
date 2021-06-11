package d.a.n0.r3.i.h;

import android.text.TextUtils;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.coreExtra.data.VideoInfo;
import com.baidu.tieba.R;
import com.baidu.tieba.video.editvideo.data.MusicData;
import com.baidu.tieba.video.editvideo.model.SelectMusicModel;
import d.a.n0.r3.i.d.b;
import java.util.List;
/* loaded from: classes5.dex */
public class b implements d.a.n0.r3.i.b, b.c, d.a.n0.d0.b {

    /* renamed from: e  reason: collision with root package name */
    public BaseActivity f63840e;

    /* renamed from: f  reason: collision with root package name */
    public d.a.n0.r3.b f63841f;

    /* renamed from: g  reason: collision with root package name */
    public d.a.n0.r3.i.d.a f63842g;

    /* renamed from: h  reason: collision with root package name */
    public SelectMusicModel f63843h;

    /* renamed from: i  reason: collision with root package name */
    public String f63844i;

    public b(d.a.n0.r3.b bVar) {
        this.f63841f = bVar;
        this.f63840e = bVar.f63676a;
    }

    @Override // d.a.n0.r3.i.d.b.c
    public void a(int i2, String str) {
        d.a.n0.r3.b bVar = this.f63841f;
        if (bVar != null) {
            bVar.d(i2, str);
        }
    }

    @Override // d.a.n0.r3.i.d.b.c
    public void b(String str) {
        d.a.n0.r3.b bVar = this.f63841f;
        if (bVar != null) {
            bVar.e();
        }
        d(str);
    }

    @Override // d.a.n0.r3.i.d.b.c
    public void c(int i2, String str) {
        d.a.n0.r3.b bVar = this.f63841f;
        if (bVar != null) {
            bVar.d(i2, str);
        }
    }

    @Override // d.a.n0.d0.b
    public void cancel() {
        d.a.n0.r3.b bVar = this.f63841f;
        if (bVar != null) {
            bVar.i(true);
        }
        d.a.n0.r3.i.d.a aVar = this.f63842g;
        if (aVar == null || !aVar.f()) {
            return;
        }
        this.f63842g.e();
    }

    public final void d(String str) {
        d.a.n0.r3.b bVar = this.f63841f;
        if (bVar == null) {
            return;
        }
        if (bVar.b()) {
            this.f63841f.c();
            this.f63841f = null;
            return;
        }
        this.f63844i = str;
        VideoInfo videoInfo = new VideoInfo();
        videoInfo.setVideoPath(this.f63844i);
        videoInfo.setThumbPath(this.f63841f.f63678c);
        d.a.n0.r3.b bVar2 = this.f63841f;
        if (bVar2 != null) {
            bVar2.f(videoInfo);
        }
    }

    public void e() {
        d.a.n0.r3.b bVar = this.f63841f;
        if (bVar == null) {
            return;
        }
        if (bVar.b()) {
            this.f63841f.c();
            this.f63841f = null;
            return;
        }
        if (StringUtils.isNull(this.f63841f.f63679d)) {
            d.a.n0.r3.b bVar2 = this.f63841f;
            if (!bVar2.f63680e) {
                onSaveMusicVideo(bVar2.f63677b, -4399, "");
                return;
            }
        }
        if (this.f63843h == null) {
            this.f63843h = new SelectMusicModel(this.f63840e.getPageContext(), this);
        }
        SelectMusicModel selectMusicModel = this.f63843h;
        d.a.n0.r3.b bVar3 = this.f63841f;
        selectMusicModel.z(bVar3.f63677b, bVar3.f63679d, d.a.n0.r3.c.f63686c + "video_" + System.currentTimeMillis() + ".mp4", !bVar3.f63680e);
    }

    @Override // d.a.n0.r3.i.b
    public void onSaveMusicVideo(String str, int i2, String str2) {
        d.a.n0.r3.b bVar = this.f63841f;
        if (bVar != null && bVar.b()) {
            this.f63841f.c();
            this.f63841f = null;
        } else if (TextUtils.isEmpty(str)) {
            this.f63840e.showToast(R.string.mixing_fail);
            d.a.n0.r3.b bVar2 = this.f63841f;
            if (bVar2 != null) {
                bVar2.g(i2, str2);
            }
        } else {
            d.a.n0.r3.b bVar3 = this.f63841f;
            if (bVar3 != null) {
                bVar3.h();
            }
            if (!StringUtils.isNull(this.f63841f.f63681f)) {
                if (!StringHelper.equals(str, this.f63841f.f63677b)) {
                    this.f63841f.f63682g = str;
                }
                if (this.f63842g == null) {
                    d.a.n0.r3.i.d.a aVar = new d.a.n0.r3.i.d.a(this.f63840e.getActivity());
                    this.f63842g = aVar;
                    aVar.i(this);
                }
                this.f63842g.g(str, this.f63841f.f63681f);
                return;
            }
            d.a.n0.r3.b bVar4 = this.f63841f;
            if (bVar4 != null) {
                bVar4.e();
            }
            d(str);
        }
    }

    @Override // d.a.n0.r3.i.b
    public void setMusicData(List<MusicData> list) {
    }

    @Override // d.a.n0.d0.b
    public void start() {
        e();
    }
}
