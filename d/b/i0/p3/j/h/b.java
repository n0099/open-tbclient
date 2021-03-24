package d.b.i0.p3.j.h;

import android.text.TextUtils;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.coreExtra.data.VideoInfo;
import com.baidu.tieba.R;
import com.baidu.tieba.video.editvideo.data.MusicData;
import com.baidu.tieba.video.editvideo.model.SelectMusicModel;
import d.b.i0.p3.j.d.b;
import java.util.List;
/* loaded from: classes5.dex */
public class b implements d.b.i0.p3.j.b, b.c, d.b.i0.b0.b {

    /* renamed from: e  reason: collision with root package name */
    public BaseActivity f59039e;

    /* renamed from: f  reason: collision with root package name */
    public d.b.i0.p3.b f59040f;

    /* renamed from: g  reason: collision with root package name */
    public d.b.i0.p3.j.d.a f59041g;

    /* renamed from: h  reason: collision with root package name */
    public SelectMusicModel f59042h;
    public String i;

    public b(d.b.i0.p3.b bVar) {
        this.f59040f = bVar;
        this.f59039e = bVar.f58879a;
    }

    @Override // d.b.i0.p3.j.d.b.c
    public void a(int i, String str) {
        d.b.i0.p3.b bVar = this.f59040f;
        if (bVar != null) {
            bVar.d(i, str);
        }
    }

    @Override // d.b.i0.p3.j.d.b.c
    public void b(String str) {
        d.b.i0.p3.b bVar = this.f59040f;
        if (bVar != null) {
            bVar.e();
        }
        d(str);
    }

    @Override // d.b.i0.p3.j.d.b.c
    public void c(int i, String str) {
        d.b.i0.p3.b bVar = this.f59040f;
        if (bVar != null) {
            bVar.d(i, str);
        }
    }

    @Override // d.b.i0.b0.b
    public void cancel() {
        d.b.i0.p3.b bVar = this.f59040f;
        if (bVar != null) {
            bVar.i(true);
        }
        d.b.i0.p3.j.d.a aVar = this.f59041g;
        if (aVar == null || !aVar.f()) {
            return;
        }
        this.f59041g.e();
    }

    public final void d(String str) {
        d.b.i0.p3.b bVar = this.f59040f;
        if (bVar == null) {
            return;
        }
        if (bVar.b()) {
            this.f59040f.c();
            this.f59040f = null;
            return;
        }
        this.i = str;
        VideoInfo videoInfo = new VideoInfo();
        videoInfo.setVideoPath(this.i);
        videoInfo.setThumbPath(this.f59040f.f58881c);
        d.b.i0.p3.b bVar2 = this.f59040f;
        if (bVar2 != null) {
            bVar2.f(videoInfo);
        }
    }

    public void e() {
        d.b.i0.p3.b bVar = this.f59040f;
        if (bVar == null) {
            return;
        }
        if (bVar.b()) {
            this.f59040f.c();
            this.f59040f = null;
            return;
        }
        if (StringUtils.isNull(this.f59040f.f58882d)) {
            d.b.i0.p3.b bVar2 = this.f59040f;
            if (!bVar2.f58883e) {
                onSaveMusicVideo(bVar2.f58880b, -4399, "");
                return;
            }
        }
        if (this.f59042h == null) {
            this.f59042h = new SelectMusicModel(this.f59039e.getPageContext(), this);
        }
        SelectMusicModel selectMusicModel = this.f59042h;
        d.b.i0.p3.b bVar3 = this.f59040f;
        selectMusicModel.v(bVar3.f58880b, bVar3.f58882d, d.b.i0.p3.c.f58889c + "video_" + System.currentTimeMillis() + ".mp4", !bVar3.f58883e);
    }

    @Override // d.b.i0.p3.j.b
    public void onSaveMusicVideo(String str, int i, String str2) {
        d.b.i0.p3.b bVar = this.f59040f;
        if (bVar != null && bVar.b()) {
            this.f59040f.c();
            this.f59040f = null;
        } else if (TextUtils.isEmpty(str)) {
            this.f59039e.showToast(R.string.mixing_fail);
            d.b.i0.p3.b bVar2 = this.f59040f;
            if (bVar2 != null) {
                bVar2.g(i, str2);
            }
        } else {
            d.b.i0.p3.b bVar3 = this.f59040f;
            if (bVar3 != null) {
                bVar3.h();
            }
            if (!StringUtils.isNull(this.f59040f.f58884f)) {
                if (!StringHelper.equals(str, this.f59040f.f58880b)) {
                    this.f59040f.f58885g = str;
                }
                if (this.f59041g == null) {
                    d.b.i0.p3.j.d.a aVar = new d.b.i0.p3.j.d.a(this.f59039e.getActivity());
                    this.f59041g = aVar;
                    aVar.i(this);
                }
                this.f59041g.g(str, this.f59040f.f58884f);
                return;
            }
            d.b.i0.p3.b bVar4 = this.f59040f;
            if (bVar4 != null) {
                bVar4.e();
            }
            d(str);
        }
    }

    @Override // d.b.i0.p3.j.b
    public void setMusicData(List<MusicData> list) {
    }

    @Override // d.b.i0.b0.b
    public void start() {
        e();
    }
}
