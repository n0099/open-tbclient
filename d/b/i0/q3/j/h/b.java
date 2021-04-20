package d.b.i0.q3.j.h;

import android.text.TextUtils;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.coreExtra.data.VideoInfo;
import com.baidu.tieba.R;
import com.baidu.tieba.video.editvideo.data.MusicData;
import com.baidu.tieba.video.editvideo.model.SelectMusicModel;
import d.b.i0.q3.j.d.b;
import java.util.List;
/* loaded from: classes5.dex */
public class b implements d.b.i0.q3.j.b, b.c, d.b.i0.b0.b {

    /* renamed from: e  reason: collision with root package name */
    public BaseActivity f60708e;

    /* renamed from: f  reason: collision with root package name */
    public d.b.i0.q3.b f60709f;

    /* renamed from: g  reason: collision with root package name */
    public d.b.i0.q3.j.d.a f60710g;

    /* renamed from: h  reason: collision with root package name */
    public SelectMusicModel f60711h;
    public String i;

    public b(d.b.i0.q3.b bVar) {
        this.f60709f = bVar;
        this.f60708e = bVar.f60548a;
    }

    @Override // d.b.i0.q3.j.d.b.c
    public void a(int i, String str) {
        d.b.i0.q3.b bVar = this.f60709f;
        if (bVar != null) {
            bVar.d(i, str);
        }
    }

    @Override // d.b.i0.q3.j.d.b.c
    public void b(String str) {
        d.b.i0.q3.b bVar = this.f60709f;
        if (bVar != null) {
            bVar.e();
        }
        d(str);
    }

    @Override // d.b.i0.q3.j.d.b.c
    public void c(int i, String str) {
        d.b.i0.q3.b bVar = this.f60709f;
        if (bVar != null) {
            bVar.d(i, str);
        }
    }

    @Override // d.b.i0.b0.b
    public void cancel() {
        d.b.i0.q3.b bVar = this.f60709f;
        if (bVar != null) {
            bVar.i(true);
        }
        d.b.i0.q3.j.d.a aVar = this.f60710g;
        if (aVar == null || !aVar.f()) {
            return;
        }
        this.f60710g.e();
    }

    public final void d(String str) {
        d.b.i0.q3.b bVar = this.f60709f;
        if (bVar == null) {
            return;
        }
        if (bVar.b()) {
            this.f60709f.c();
            this.f60709f = null;
            return;
        }
        this.i = str;
        VideoInfo videoInfo = new VideoInfo();
        videoInfo.setVideoPath(this.i);
        videoInfo.setThumbPath(this.f60709f.f60550c);
        d.b.i0.q3.b bVar2 = this.f60709f;
        if (bVar2 != null) {
            bVar2.f(videoInfo);
        }
    }

    public void e() {
        d.b.i0.q3.b bVar = this.f60709f;
        if (bVar == null) {
            return;
        }
        if (bVar.b()) {
            this.f60709f.c();
            this.f60709f = null;
            return;
        }
        if (StringUtils.isNull(this.f60709f.f60551d)) {
            d.b.i0.q3.b bVar2 = this.f60709f;
            if (!bVar2.f60552e) {
                onSaveMusicVideo(bVar2.f60549b, -4399, "");
                return;
            }
        }
        if (this.f60711h == null) {
            this.f60711h = new SelectMusicModel(this.f60708e.getPageContext(), this);
        }
        SelectMusicModel selectMusicModel = this.f60711h;
        d.b.i0.q3.b bVar3 = this.f60709f;
        selectMusicModel.v(bVar3.f60549b, bVar3.f60551d, d.b.i0.q3.c.f60558c + "video_" + System.currentTimeMillis() + ".mp4", !bVar3.f60552e);
    }

    @Override // d.b.i0.q3.j.b
    public void onSaveMusicVideo(String str, int i, String str2) {
        d.b.i0.q3.b bVar = this.f60709f;
        if (bVar != null && bVar.b()) {
            this.f60709f.c();
            this.f60709f = null;
        } else if (TextUtils.isEmpty(str)) {
            this.f60708e.showToast(R.string.mixing_fail);
            d.b.i0.q3.b bVar2 = this.f60709f;
            if (bVar2 != null) {
                bVar2.g(i, str2);
            }
        } else {
            d.b.i0.q3.b bVar3 = this.f60709f;
            if (bVar3 != null) {
                bVar3.h();
            }
            if (!StringUtils.isNull(this.f60709f.f60553f)) {
                if (!StringHelper.equals(str, this.f60709f.f60549b)) {
                    this.f60709f.f60554g = str;
                }
                if (this.f60710g == null) {
                    d.b.i0.q3.j.d.a aVar = new d.b.i0.q3.j.d.a(this.f60708e.getActivity());
                    this.f60710g = aVar;
                    aVar.i(this);
                }
                this.f60710g.g(str, this.f60709f.f60553f);
                return;
            }
            d.b.i0.q3.b bVar4 = this.f60709f;
            if (bVar4 != null) {
                bVar4.e();
            }
            d(str);
        }
    }

    @Override // d.b.i0.q3.j.b
    public void setMusicData(List<MusicData> list) {
    }

    @Override // d.b.i0.b0.b
    public void start() {
        e();
    }
}
