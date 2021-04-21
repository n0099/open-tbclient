package d.b.j0.q3;

import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.tbadk.coreExtra.data.VideoInfo;
import com.baidu.tieba.video.EditVideoData;
import d.b.c.e.p.k;
import java.io.File;
/* loaded from: classes5.dex */
public abstract class b {

    /* renamed from: a  reason: collision with root package name */
    public BaseActivity f60969a;

    /* renamed from: b  reason: collision with root package name */
    public String f60970b;

    /* renamed from: c  reason: collision with root package name */
    public String f60971c;

    /* renamed from: d  reason: collision with root package name */
    public String f60972d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f60973e;

    /* renamed from: f  reason: collision with root package name */
    public String f60974f;

    /* renamed from: g  reason: collision with root package name */
    public String f60975g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f60976h;

    public b(BaseActivity baseActivity, String str, String str2) {
        this.f60970b = str;
        this.f60971c = str2;
        this.f60969a = baseActivity;
    }

    public final void a() {
        if (k.isEmpty(this.f60975g)) {
            return;
        }
        FileHelper.deleteFile(new File(this.f60975g));
    }

    public boolean b() {
        return this.f60976h;
    }

    public void c() {
        a();
    }

    public void d(int i, String str) {
        a();
    }

    public abstract void e();

    public void f(VideoInfo videoInfo) {
        a();
    }

    public void g(int i, String str) {
        a();
    }

    public abstract void h();

    public void i(boolean z) {
        this.f60976h = z;
    }

    public void j(EditVideoData editVideoData) {
        if (editVideoData != null) {
            this.f60970b = editVideoData.originPath;
            this.f60971c = editVideoData.coverPath;
            this.f60972d = editVideoData.musicPath;
            this.f60973e = editVideoData.isMute;
            this.f60974f = editVideoData.filterName;
        }
    }

    public b(BaseActivity baseActivity, EditVideoData editVideoData) {
        if (editVideoData != null) {
            this.f60970b = editVideoData.originPath;
            this.f60971c = editVideoData.coverPath;
            this.f60972d = editVideoData.musicPath;
            this.f60973e = editVideoData.isMute;
            this.f60974f = editVideoData.filterName;
        }
        this.f60969a = baseActivity;
    }
}
