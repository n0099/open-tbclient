package d.a.o0.r3.i.h;

import android.text.TextUtils;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.coreExtra.data.VideoInfo;
import com.baidu.tieba.R;
import com.baidu.tieba.video.editvideo.data.MusicData;
import com.baidu.tieba.video.editvideo.model.SelectMusicModel;
import d.a.o0.r3.i.d.b;
import java.util.List;
/* loaded from: classes5.dex */
public class b implements d.a.o0.r3.i.b, b.c, d.a.o0.d0.b {

    /* renamed from: e  reason: collision with root package name */
    public BaseActivity f63965e;

    /* renamed from: f  reason: collision with root package name */
    public d.a.o0.r3.b f63966f;

    /* renamed from: g  reason: collision with root package name */
    public d.a.o0.r3.i.d.a f63967g;

    /* renamed from: h  reason: collision with root package name */
    public SelectMusicModel f63968h;

    /* renamed from: i  reason: collision with root package name */
    public String f63969i;

    public b(d.a.o0.r3.b bVar) {
        this.f63966f = bVar;
        this.f63965e = bVar.f63801a;
    }

    @Override // d.a.o0.r3.i.d.b.c
    public void a(int i2, String str) {
        d.a.o0.r3.b bVar = this.f63966f;
        if (bVar != null) {
            bVar.d(i2, str);
        }
    }

    @Override // d.a.o0.r3.i.d.b.c
    public void b(String str) {
        d.a.o0.r3.b bVar = this.f63966f;
        if (bVar != null) {
            bVar.e();
        }
        d(str);
    }

    @Override // d.a.o0.r3.i.d.b.c
    public void c(int i2, String str) {
        d.a.o0.r3.b bVar = this.f63966f;
        if (bVar != null) {
            bVar.d(i2, str);
        }
    }

    @Override // d.a.o0.d0.b
    public void cancel() {
        d.a.o0.r3.b bVar = this.f63966f;
        if (bVar != null) {
            bVar.i(true);
        }
        d.a.o0.r3.i.d.a aVar = this.f63967g;
        if (aVar == null || !aVar.f()) {
            return;
        }
        this.f63967g.e();
    }

    public final void d(String str) {
        d.a.o0.r3.b bVar = this.f63966f;
        if (bVar == null) {
            return;
        }
        if (bVar.b()) {
            this.f63966f.c();
            this.f63966f = null;
            return;
        }
        this.f63969i = str;
        VideoInfo videoInfo = new VideoInfo();
        videoInfo.setVideoPath(this.f63969i);
        videoInfo.setThumbPath(this.f63966f.f63803c);
        d.a.o0.r3.b bVar2 = this.f63966f;
        if (bVar2 != null) {
            bVar2.f(videoInfo);
        }
    }

    public void e() {
        d.a.o0.r3.b bVar = this.f63966f;
        if (bVar == null) {
            return;
        }
        if (bVar.b()) {
            this.f63966f.c();
            this.f63966f = null;
            return;
        }
        if (StringUtils.isNull(this.f63966f.f63804d)) {
            d.a.o0.r3.b bVar2 = this.f63966f;
            if (!bVar2.f63805e) {
                onSaveMusicVideo(bVar2.f63802b, -4399, "");
                return;
            }
        }
        if (this.f63968h == null) {
            this.f63968h = new SelectMusicModel(this.f63965e.getPageContext(), this);
        }
        SelectMusicModel selectMusicModel = this.f63968h;
        d.a.o0.r3.b bVar3 = this.f63966f;
        selectMusicModel.z(bVar3.f63802b, bVar3.f63804d, d.a.o0.r3.c.f63811c + "video_" + System.currentTimeMillis() + ".mp4", !bVar3.f63805e);
    }

    @Override // d.a.o0.r3.i.b
    public void onSaveMusicVideo(String str, int i2, String str2) {
        d.a.o0.r3.b bVar = this.f63966f;
        if (bVar != null && bVar.b()) {
            this.f63966f.c();
            this.f63966f = null;
        } else if (TextUtils.isEmpty(str)) {
            this.f63965e.showToast(R.string.mixing_fail);
            d.a.o0.r3.b bVar2 = this.f63966f;
            if (bVar2 != null) {
                bVar2.g(i2, str2);
            }
        } else {
            d.a.o0.r3.b bVar3 = this.f63966f;
            if (bVar3 != null) {
                bVar3.h();
            }
            if (!StringUtils.isNull(this.f63966f.f63806f)) {
                if (!StringHelper.equals(str, this.f63966f.f63802b)) {
                    this.f63966f.f63807g = str;
                }
                if (this.f63967g == null) {
                    d.a.o0.r3.i.d.a aVar = new d.a.o0.r3.i.d.a(this.f63965e.getActivity());
                    this.f63967g = aVar;
                    aVar.i(this);
                }
                this.f63967g.g(str, this.f63966f.f63806f);
                return;
            }
            d.a.o0.r3.b bVar4 = this.f63966f;
            if (bVar4 != null) {
                bVar4.e();
            }
            d(str);
        }
    }

    @Override // d.a.o0.r3.i.b
    public void setMusicData(List<MusicData> list) {
    }

    @Override // d.a.o0.d0.b
    public void start() {
        e();
    }
}
