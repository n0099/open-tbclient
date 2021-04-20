package d.b.i0.q3;

import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.tbadk.coreExtra.data.VideoInfo;
import com.baidu.tieba.video.EditVideoData;
import d.b.c.e.p.k;
import java.io.File;
/* loaded from: classes5.dex */
public abstract class b {

    /* renamed from: a  reason: collision with root package name */
    public BaseActivity f60548a;

    /* renamed from: b  reason: collision with root package name */
    public String f60549b;

    /* renamed from: c  reason: collision with root package name */
    public String f60550c;

    /* renamed from: d  reason: collision with root package name */
    public String f60551d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f60552e;

    /* renamed from: f  reason: collision with root package name */
    public String f60553f;

    /* renamed from: g  reason: collision with root package name */
    public String f60554g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f60555h;

    public b(BaseActivity baseActivity, String str, String str2) {
        this.f60549b = str;
        this.f60550c = str2;
        this.f60548a = baseActivity;
    }

    public final void a() {
        if (k.isEmpty(this.f60554g)) {
            return;
        }
        FileHelper.deleteFile(new File(this.f60554g));
    }

    public boolean b() {
        return this.f60555h;
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
        this.f60555h = z;
    }

    public void j(EditVideoData editVideoData) {
        if (editVideoData != null) {
            this.f60549b = editVideoData.originPath;
            this.f60550c = editVideoData.coverPath;
            this.f60551d = editVideoData.musicPath;
            this.f60552e = editVideoData.isMute;
            this.f60553f = editVideoData.filterName;
        }
    }

    public b(BaseActivity baseActivity, EditVideoData editVideoData) {
        if (editVideoData != null) {
            this.f60549b = editVideoData.originPath;
            this.f60550c = editVideoData.coverPath;
            this.f60551d = editVideoData.musicPath;
            this.f60552e = editVideoData.isMute;
            this.f60553f = editVideoData.filterName;
        }
        this.f60548a = baseActivity;
    }
}
