package d.b.i0.p3;

import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.tbadk.coreExtra.data.VideoInfo;
import com.baidu.tieba.video.EditVideoData;
import d.b.b.e.p.k;
import java.io.File;
/* loaded from: classes5.dex */
public abstract class b {

    /* renamed from: a  reason: collision with root package name */
    public BaseActivity f58879a;

    /* renamed from: b  reason: collision with root package name */
    public String f58880b;

    /* renamed from: c  reason: collision with root package name */
    public String f58881c;

    /* renamed from: d  reason: collision with root package name */
    public String f58882d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f58883e;

    /* renamed from: f  reason: collision with root package name */
    public String f58884f;

    /* renamed from: g  reason: collision with root package name */
    public String f58885g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f58886h;

    public b(BaseActivity baseActivity, String str, String str2) {
        this.f58880b = str;
        this.f58881c = str2;
        this.f58879a = baseActivity;
    }

    public final void a() {
        if (k.isEmpty(this.f58885g)) {
            return;
        }
        FileHelper.deleteFile(new File(this.f58885g));
    }

    public boolean b() {
        return this.f58886h;
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
        this.f58886h = z;
    }

    public void j(EditVideoData editVideoData) {
        if (editVideoData != null) {
            this.f58880b = editVideoData.originPath;
            this.f58881c = editVideoData.coverPath;
            this.f58882d = editVideoData.musicPath;
            this.f58883e = editVideoData.isMute;
            this.f58884f = editVideoData.filterName;
        }
    }

    public b(BaseActivity baseActivity, EditVideoData editVideoData) {
        if (editVideoData != null) {
            this.f58880b = editVideoData.originPath;
            this.f58881c = editVideoData.coverPath;
            this.f58882d = editVideoData.musicPath;
            this.f58883e = editVideoData.isMute;
            this.f58884f = editVideoData.filterName;
        }
        this.f58879a = baseActivity;
    }
}
