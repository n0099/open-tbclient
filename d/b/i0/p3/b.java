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
    public BaseActivity f58880a;

    /* renamed from: b  reason: collision with root package name */
    public String f58881b;

    /* renamed from: c  reason: collision with root package name */
    public String f58882c;

    /* renamed from: d  reason: collision with root package name */
    public String f58883d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f58884e;

    /* renamed from: f  reason: collision with root package name */
    public String f58885f;

    /* renamed from: g  reason: collision with root package name */
    public String f58886g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f58887h;

    public b(BaseActivity baseActivity, String str, String str2) {
        this.f58881b = str;
        this.f58882c = str2;
        this.f58880a = baseActivity;
    }

    public final void a() {
        if (k.isEmpty(this.f58886g)) {
            return;
        }
        FileHelper.deleteFile(new File(this.f58886g));
    }

    public boolean b() {
        return this.f58887h;
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
        this.f58887h = z;
    }

    public void j(EditVideoData editVideoData) {
        if (editVideoData != null) {
            this.f58881b = editVideoData.originPath;
            this.f58882c = editVideoData.coverPath;
            this.f58883d = editVideoData.musicPath;
            this.f58884e = editVideoData.isMute;
            this.f58885f = editVideoData.filterName;
        }
    }

    public b(BaseActivity baseActivity, EditVideoData editVideoData) {
        if (editVideoData != null) {
            this.f58881b = editVideoData.originPath;
            this.f58882c = editVideoData.coverPath;
            this.f58883d = editVideoData.musicPath;
            this.f58884e = editVideoData.isMute;
            this.f58885f = editVideoData.filterName;
        }
        this.f58880a = baseActivity;
    }
}
