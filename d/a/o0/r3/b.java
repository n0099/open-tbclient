package d.a.o0.r3;

import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.tbadk.coreExtra.data.VideoInfo;
import com.baidu.tieba.video.EditVideoData;
import d.a.c.e.p.k;
import java.io.File;
/* loaded from: classes5.dex */
public abstract class b {

    /* renamed from: a  reason: collision with root package name */
    public BaseActivity f63801a;

    /* renamed from: b  reason: collision with root package name */
    public String f63802b;

    /* renamed from: c  reason: collision with root package name */
    public String f63803c;

    /* renamed from: d  reason: collision with root package name */
    public String f63804d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f63805e;

    /* renamed from: f  reason: collision with root package name */
    public String f63806f;

    /* renamed from: g  reason: collision with root package name */
    public String f63807g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f63808h;

    public b(BaseActivity baseActivity, String str, String str2) {
        this.f63802b = str;
        this.f63803c = str2;
        this.f63801a = baseActivity;
    }

    public final void a() {
        if (k.isEmpty(this.f63807g)) {
            return;
        }
        FileHelper.deleteFile(new File(this.f63807g));
    }

    public boolean b() {
        return this.f63808h;
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
        this.f63808h = z;
    }

    public void j(EditVideoData editVideoData) {
        if (editVideoData != null) {
            this.f63802b = editVideoData.originPath;
            this.f63803c = editVideoData.coverPath;
            this.f63804d = editVideoData.musicPath;
            this.f63805e = editVideoData.isMute;
            this.f63806f = editVideoData.filterName;
        }
    }

    public b(BaseActivity baseActivity, EditVideoData editVideoData) {
        if (editVideoData != null) {
            this.f63802b = editVideoData.originPath;
            this.f63803c = editVideoData.coverPath;
            this.f63804d = editVideoData.musicPath;
            this.f63805e = editVideoData.isMute;
            this.f63806f = editVideoData.filterName;
        }
        this.f63801a = baseActivity;
    }
}
