package d.a.n0.r3;

import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.tbadk.coreExtra.data.VideoInfo;
import com.baidu.tieba.video.EditVideoData;
import d.a.c.e.p.k;
import java.io.File;
/* loaded from: classes5.dex */
public abstract class b {

    /* renamed from: a  reason: collision with root package name */
    public BaseActivity f63676a;

    /* renamed from: b  reason: collision with root package name */
    public String f63677b;

    /* renamed from: c  reason: collision with root package name */
    public String f63678c;

    /* renamed from: d  reason: collision with root package name */
    public String f63679d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f63680e;

    /* renamed from: f  reason: collision with root package name */
    public String f63681f;

    /* renamed from: g  reason: collision with root package name */
    public String f63682g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f63683h;

    public b(BaseActivity baseActivity, String str, String str2) {
        this.f63677b = str;
        this.f63678c = str2;
        this.f63676a = baseActivity;
    }

    public final void a() {
        if (k.isEmpty(this.f63682g)) {
            return;
        }
        FileHelper.deleteFile(new File(this.f63682g));
    }

    public boolean b() {
        return this.f63683h;
    }

    public void c() {
        a();
    }

    public void d(int i2, String str) {
        a();
    }

    public abstract void e();

    public void f(VideoInfo videoInfo) {
        a();
    }

    public void g(int i2, String str) {
        a();
    }

    public abstract void h();

    public void i(boolean z) {
        this.f63683h = z;
    }

    public void j(EditVideoData editVideoData) {
        if (editVideoData != null) {
            this.f63677b = editVideoData.originPath;
            this.f63678c = editVideoData.coverPath;
            this.f63679d = editVideoData.musicPath;
            this.f63680e = editVideoData.isMute;
            this.f63681f = editVideoData.filterName;
        }
    }

    public b(BaseActivity baseActivity, EditVideoData editVideoData) {
        if (editVideoData != null) {
            this.f63677b = editVideoData.originPath;
            this.f63678c = editVideoData.coverPath;
            this.f63679d = editVideoData.musicPath;
            this.f63680e = editVideoData.isMute;
            this.f63681f = editVideoData.filterName;
        }
        this.f63676a = baseActivity;
    }
}
